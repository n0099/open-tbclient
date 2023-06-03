package com.baidu.sapi2;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import com.baidu.android.imsdk.chatmessage.messages.NetDiskFileMsg;
import com.baidu.pass.common.SecurityUtil;
import com.baidu.pass.http.ReqPriority;
import com.baidu.sapi2.SapiOptions;
import com.baidu.sapi2.httpwrap.HttpClientWrap;
import com.baidu.sapi2.httpwrap.HttpHandlerWrap;
import com.baidu.sapi2.httpwrap.HttpHashMapWrap;
import com.baidu.sapi2.outsdk.OneKeyLoginSdkCall;
import com.baidu.sapi2.share.face.FaceLoginService;
import com.baidu.sapi2.utils.FileUtil;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiDeviceInfo;
import com.baidu.sapi2.utils.SapiEnv;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.StatService;
import com.baidubce.http.Headers;
import com.meizu.cloud.pushsdk.notification.model.AppIconSetting;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class SapiCache {
    public static final Map<String, SoftReference<String>> cache = new ConcurrentHashMap();
    public Context context;
    public final List<String> oldModuleIds = new ArrayList();
    public final List<String> newModuleIds = new ArrayList();

    /* loaded from: classes3.dex */
    public interface LoadModuleEventListener {
        void onFailure(SapiOptions.Cache.Module module);

        void onSuccess(SapiOptions.Cache.Module module, String str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportDi() {
        String deviceInfo = SapiDeviceInfo.getDeviceInfo(SapiEnv.SAPI_CONFIG_URI);
        if (!TextUtils.isEmpty(deviceInfo)) {
            StatService.onEvent("dvif_interface", Collections.singletonMap(AppIconSetting.DEFAULT_LARGE_ICON, deviceInfo));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initSomeSwitch(SapiOptions sapiOptions) {
        SapiConfiguration sapiConfiguration = SapiAccountManager.getInstance().getSapiConfiguration();
        new FaceLoginService().syncFaceLoginUID(this.context, null);
        resetFileExecPer(sapiOptions.resetFileExecPer);
        if (sapiConfiguration.syncOneKeyLoginInfo) {
            new OneKeyLoginSdkCall().preGetPhoneInfo(sapiConfiguration, "init");
        }
    }

    public SapiOptions.Cache.Module getModuleById(String str) {
        for (SapiOptions.Cache.Module module : SapiContext.getInstance().getSapiOptions().getCache().getModules()) {
            if (module.id.equals(str)) {
                return module;
            }
        }
        return null;
    }

    public void init(Context context) {
        this.context = context.getApplicationContext();
        SapiOptions sapiOptions = SapiContext.getInstance().getSapiOptions();
        loadCache(sapiOptions);
        syncCache(sapiOptions);
    }

    public String loadDataFromExternal(File file) throws IOException {
        return FileUtil.read(file.getAbsolutePath());
    }

    public String loadModuleFromMemory(String str) {
        if (cache.containsKey(str) && cache.get(str) != null) {
            String str2 = cache.get(str).get();
            if (!TextUtils.isEmpty(str2)) {
                return str2;
            }
            return null;
        }
        return null;
    }

    public void remove(String str) {
        cache.remove(str);
    }

    public String getCacheData(Context context, String str) {
        return get(context, getCacheModuleId(str));
    }

    @TargetApi(4)
    public String loadDataFromInternal(Context context, String str) throws IOException {
        return FileUtil.read(context.getApplicationInfo().dataDir + File.separator + NetDiskFileMsg.JSON_KEY_FILES + File.separator + str);
    }

    public void loadModuleFromInternal(Context context, SapiOptions.Cache.Module module) {
        String internalFile = SapiOptions.Cache.Module.getInternalFile(module.id);
        if (new File(context.getFilesDir(), internalFile).exists()) {
            try {
                put(module.id, loadDataFromInternal(context, internalFile));
            } catch (Throwable th) {
                Log.e(th);
            }
        }
    }

    public boolean needUpdate(SapiOptions.Cache.Module module, SapiOptions.Cache.Module module2) {
        if (!TextUtils.isEmpty(module.hash) && (module2 == null || !module.hash.equals(module2.hash))) {
            return true;
        }
        return false;
    }

    public void put(String str, String str2) {
        cache.put(str, new SoftReference<>(str2));
    }

    public void writeExternal(String str, byte[] bArr) {
        File file;
        try {
            if ("mounted".equals(Environment.getExternalStorageState())) {
                if (Build.VERSION.SDK_INT >= 30) {
                    file = new File(this.context.getExternalCacheDir(), str);
                } else {
                    file = new File(Environment.getExternalStorageDirectory(), str);
                }
                FileUtil.write(file, bArr, false);
            }
        } catch (Throwable th) {
            Log.e(th);
        }
    }

    public String get(final Context context, String str) {
        invalidate();
        if (SapiContext.getInstance().getSapiOptions().getCache().isEnabled()) {
            String loadModuleFromMemory = loadModuleFromMemory(str);
            if (!TextUtils.isEmpty(loadModuleFromMemory)) {
                return loadModuleFromMemory;
            }
            SapiOptions.Cache.Module moduleById = getModuleById(str);
            if (moduleById != null) {
                loadModuleFromExternal(moduleById, new LoadModuleEventListener() { // from class: com.baidu.sapi2.SapiCache.1
                    @Override // com.baidu.sapi2.SapiCache.LoadModuleEventListener
                    public void onSuccess(SapiOptions.Cache.Module module, String str2) {
                        SapiCache.this.put(module.id, str2);
                    }

                    @Override // com.baidu.sapi2.SapiCache.LoadModuleEventListener
                    public void onFailure(SapiOptions.Cache.Module module) {
                        SapiCache.this.loadModuleFromInternal(context, module);
                    }
                });
            }
            return loadModuleFromMemory(str);
        }
        return null;
    }

    public String getCacheModuleId(String str) {
        String str2;
        Uri parse = Uri.parse(str);
        StringBuilder sb = new StringBuilder();
        sb.append(parse.getHost());
        if (parse.getPort() == -1) {
            str2 = "";
        } else {
            str2 = ":" + parse.getPort();
        }
        sb.append(str2);
        sb.append(parse.getPath());
        String sb2 = sb.toString();
        if (!sb2.endsWith(".html")) {
            return sb2 + ".html";
        }
        return sb2;
    }

    public void loadCache(SapiOptions sapiOptions) {
        SapiOptions.Cache cache2 = sapiOptions.getCache();
        if (cache2.isEnabled()) {
            for (SapiOptions.Cache.Module module : cache2.getModules()) {
                this.oldModuleIds.add(module.id);
            }
            this.newModuleIds.addAll(this.oldModuleIds);
            for (SapiOptions.Cache.Module module2 : cache2.getModules()) {
                loadModuleFromExternal(module2, new LoadModuleEventListener() { // from class: com.baidu.sapi2.SapiCache.2
                    @Override // com.baidu.sapi2.SapiCache.LoadModuleEventListener
                    public void onFailure(SapiOptions.Cache.Module module3) {
                        SapiCache sapiCache = SapiCache.this;
                        sapiCache.loadModuleFromInternal(sapiCache.context, module3);
                    }

                    @Override // com.baidu.sapi2.SapiCache.LoadModuleEventListener
                    public void onSuccess(SapiOptions.Cache.Module module3, String str) {
                        SapiCache.this.put(module3.id, str);
                    }
                });
            }
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    @TargetApi(4)
    public void resetFileExecPer(boolean z) {
        if (!z) {
            return;
        }
        String packageDirExecutePer = SapiContext.getInstance().getPackageDirExecutePer();
        if (TextUtils.isEmpty(packageDirExecutePer)) {
            return;
        }
        Process process = null;
        try {
            try {
                Runtime runtime = Runtime.getRuntime();
                process = runtime.exec("chmod " + packageDirExecutePer + " " + this.context.getApplicationInfo().dataDir);
                if (process.waitFor() == 0) {
                    SapiContext.getInstance().setPackageDirExecutePer("");
                }
                if (process == null) {
                    return;
                }
            } catch (Exception e) {
                Log.e(e);
                if (process == null) {
                    return;
                }
            }
            process.destroy();
        } catch (Throwable th) {
            if (process != null) {
                process.destroy();
            }
            throw th;
        }
    }

    public void syncCache(final SapiOptions sapiOptions) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("If-None-Match", SapiContext.getInstance().getString(SapiContext.KEY_CONFIG_FILE_ETAG));
        HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
        try {
            new HttpClientWrap().post(SapiAccountManager.getInstance().getSapiConfiguration().environment.getWap() + SapiEnv.SAPI_CONFIG_HTTPS_URI, ReqPriority.IMMEDIATE, httpHashMapWrap, hashMap, null, null, new HttpHandlerWrap(true) { // from class: com.baidu.sapi2.SapiCache.3
                @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
                public void onFailure(Throwable th, int i, String str) {
                    SapiCache.this.initSomeSwitch(sapiOptions);
                    SapiCache.this.reportDi();
                }

                @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
                public void onSuccess(int i, String str, HashMap<String, String> hashMap2) {
                    if (str == null) {
                        return;
                    }
                    int i2 = -1;
                    String str2 = null;
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        i2 = jSONObject.optInt("errno");
                        str2 = jSONObject.optString("data");
                    } catch (JSONException e) {
                        Log.e(e);
                    }
                    if (i2 == 0 && !TextUtils.isEmpty(str2)) {
                        SapiCache.this.handleOptions(str2, sapiOptions);
                        if (hashMap2 != null) {
                            SapiContext.getInstance().put(SapiContext.KEY_CONFIG_FILE_ETAG, hashMap2.get(Headers.ETAG));
                        }
                        SapiCache.this.reportDi();
                    }
                }
            });
        } catch (Throwable th) {
            Log.e(th);
        }
    }

    public void handleCachePage(String str, SapiOptions.Cache.Module module) {
        if (!TextUtils.isEmpty(module.id) && !TextUtils.isEmpty(str) && module.hash.equals(SecurityUtil.md5(str.getBytes(), false))) {
            put(module.id, str);
            writeInternal(this.context, SapiOptions.Cache.Module.getInternalFile(module.id), str.getBytes());
            if (SapiUtils.checkRequestPermission("android.permission.WRITE_EXTERNAL_STORAGE", this.context)) {
                writeExternal(SapiOptions.Cache.Module.getExternalFile(module.id), str.getBytes());
            }
        }
    }

    public void handleOptions(String str, SapiOptions sapiOptions) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            final SapiOptions fromJSON = SapiOptions.fromJSON(jSONObject);
            SapiContext.getInstance().setSapiOptions(fromJSON);
            SapiContext.getInstance().setPkgSigns(SapiOptions.PkgSigns.fromJSON(jSONObject));
            SapiOptions.Cache cache2 = fromJSON.getCache();
            final SapiOptions.Cache cache3 = sapiOptions.getCache();
            initSomeSwitch(fromJSON);
            this.newModuleIds.clear();
            if (cache2.isEnabled()) {
                for (SapiOptions.Cache.Module module : cache2.getModules()) {
                    this.newModuleIds.add(module.id);
                }
                for (final SapiOptions.Cache.Module module2 : cache2.getModules()) {
                    SapiOptions.Cache.Module module3 = null;
                    for (SapiOptions.Cache.Module module4 : cache3.getModules()) {
                        if (module4.id.equals(module2.id)) {
                            module3 = module4;
                        }
                    }
                    if (needUpdate(module2, module3)) {
                        loadModuleFromExternal(module2, new LoadModuleEventListener() { // from class: com.baidu.sapi2.SapiCache.4
                            @Override // com.baidu.sapi2.SapiCache.LoadModuleEventListener
                            public void onFailure(SapiOptions.Cache.Module module5) {
                                new HttpClientWrap().get(module2.downloadUrl, ReqPriority.IMMEDIATE, new HttpHashMapWrap(), null, null, new HttpHandlerWrap(true) { // from class: com.baidu.sapi2.SapiCache.4.1
                                    @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
                                    public void onSuccess(int i, String str2) {
                                        AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                                        SapiCache.this.handleCachePage(str2, module2);
                                    }

                                    @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
                                    public void onFailure(Throwable th, int i, String str2) {
                                        AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                                        fromJSON.setCache(cache3);
                                        SapiContext.getInstance().setSapiOptions(fromJSON);
                                    }
                                });
                            }

                            @Override // com.baidu.sapi2.SapiCache.LoadModuleEventListener
                            public void onSuccess(SapiOptions.Cache.Module module5, String str2) {
                                if (!TextUtils.isEmpty(module2.id) && !TextUtils.isEmpty(str2)) {
                                    SapiCache.this.put(module2.id, str2);
                                    SapiCache sapiCache = SapiCache.this;
                                    sapiCache.writeInternal(sapiCache.context, SapiOptions.Cache.Module.getInternalFile(module2.id), str2.getBytes());
                                }
                            }
                        });
                    } else {
                        loadModuleFromExternal(module2, new LoadModuleEventListener() { // from class: com.baidu.sapi2.SapiCache.5
                            @Override // com.baidu.sapi2.SapiCache.LoadModuleEventListener
                            public void onSuccess(SapiOptions.Cache.Module module5, String str2) {
                            }

                            @Override // com.baidu.sapi2.SapiCache.LoadModuleEventListener
                            public void onFailure(SapiOptions.Cache.Module module5) {
                                String internalFile = SapiOptions.Cache.Module.getInternalFile(module5.id);
                                String externalFile = SapiOptions.Cache.Module.getExternalFile(module5.id);
                                if (new File(SapiCache.this.context.getFilesDir(), internalFile).exists()) {
                                    try {
                                        String loadDataFromInternal = SapiCache.this.loadDataFromInternal(SapiCache.this.context, internalFile);
                                        if (Build.VERSION.SDK_INT >= 30 || SapiUtils.checkRequestPermission("android.permission.WRITE_EXTERNAL_STORAGE", SapiCache.this.context)) {
                                            SapiCache.this.writeExternal(externalFile, loadDataFromInternal.getBytes());
                                        }
                                    } catch (Throwable th) {
                                        Log.e(th);
                                    }
                                }
                            }
                        });
                    }
                }
            }
        } catch (JSONException unused) {
        }
    }

    public void invalidate() {
        ArrayList<String> arrayList = new ArrayList();
        for (String str : this.oldModuleIds) {
            if (!this.newModuleIds.contains(str)) {
                arrayList.add(str);
                remove(str);
            }
        }
        for (String str2 : arrayList) {
            if (this.oldModuleIds.contains(str2)) {
                this.oldModuleIds.remove(str2);
            }
        }
    }

    public void loadModuleFromExternal(SapiOptions.Cache.Module module, LoadModuleEventListener loadModuleEventListener) {
        File file;
        if (loadModuleEventListener != null) {
            String externalFile = SapiOptions.Cache.Module.getExternalFile(module.id);
            try {
                if ("mounted".equals(Environment.getExternalStorageState())) {
                    if (Build.VERSION.SDK_INT >= 30) {
                        file = new File(this.context.getExternalCacheDir(), externalFile);
                    } else {
                        file = new File(Environment.getExternalStorageDirectory(), externalFile);
                    }
                    if (file.exists()) {
                        String loadDataFromExternal = loadDataFromExternal(file);
                        if (SecurityUtil.md5(loadDataFromExternal.getBytes(), false).equals(module.hash)) {
                            loadModuleEventListener.onSuccess(module, loadDataFromExternal);
                            return;
                        } else {
                            loadModuleEventListener.onFailure(module);
                            return;
                        }
                    }
                    loadModuleEventListener.onFailure(module);
                    return;
                }
                return;
            } catch (Throwable unused) {
                loadModuleEventListener.onFailure(module);
                return;
            }
        }
        throw new IllegalArgumentException(LoadModuleEventListener.class.getName() + "can't be null");
    }

    public void writeInternal(Context context, String str, byte[] bArr) {
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = context.openFileOutput(str, 0);
        } catch (Throwable unused) {
            fileOutputStream = null;
        }
        try {
            try {
                fileOutputStream.write(bArr);
                if (fileOutputStream == null) {
                    return;
                }
            } catch (Throwable unused2) {
                if (fileOutputStream == null) {
                    return;
                }
                fileOutputStream.close();
            }
            fileOutputStream.close();
        } catch (Throwable unused3) {
        }
    }
}
