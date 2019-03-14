package com.baidu.sapi2;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.android.common.security.MD5Util;
import com.baidu.mobstat.Config;
import com.baidu.sapi2.SapiOptions;
import com.baidu.sapi2.base.debug.Log;
import com.baidu.sapi2.httpwrap.HttpClientWrap;
import com.baidu.sapi2.httpwrap.HttpHandlerWrap;
import com.baidu.sapi2.httpwrap.HttpHashMapWrap;
import com.baidu.sapi2.outsdk.ChinaMobileSDK;
import com.baidu.sapi2.passhost.framework.PluginFacade;
import com.baidu.sapi2.passhost.hostsdk.service.SafeService;
import com.baidu.sapi2.passhost.hostsdk.service.ThreadPoolService;
import com.baidu.sapi2.passhost.pluginsdk.service.TPRunnable;
import com.baidu.sapi2.share.face.FaceLoginService;
import com.baidu.sapi2.utils.SapiDeviceInfo;
import com.baidu.sapi2.utils.SapiEnv;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.StatService;
import com.baidu.sapi2.utils.enums.Domain;
import com.meizu.cloud.pushsdk.notification.model.AppIconSetting;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class SapiCache {
    private static final Map<String, SoftReference<String>> a = new ConcurrentHashMap();
    private static final List<String> b = new ArrayList();
    private static final List<String> c = new ArrayList();
    private static Context d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface a {
        void a(SapiOptions.Cache.Module module);

        void a(SapiOptions.Cache.Module module, String str);
    }

    private SapiCache() {
    }

    static void a(String str, String str2) {
        a.put(str, new SoftReference<>(str2));
    }

    static void a(String str) {
        a.remove(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(Context context, String str) {
        if (!SapiContext.getInstance(context).getBoolean(SapiContext.KEY_LOGIN_PAGE_IS_CACHED, false)) {
            return null;
        }
        return b(context, c(str));
    }

    static String b(final Context context, String str) {
        e();
        if (SapiContext.getInstance(context).getSapiOptions().getCache().isEnabled()) {
            String b2 = b(str);
            if (TextUtils.isEmpty(b2)) {
                SapiOptions.Cache.Module c2 = c(context, str);
                if (c2 != null) {
                    a(c2, new a() { // from class: com.baidu.sapi2.SapiCache.1
                        @Override // com.baidu.sapi2.SapiCache.a
                        public void a(SapiOptions.Cache.Module module, String str2) {
                            SapiCache.a(module.id, str2);
                        }

                        @Override // com.baidu.sapi2.SapiCache.a
                        public void a(SapiOptions.Cache.Module module) {
                            SapiCache.a(context, module);
                        }
                    });
                }
                return b(str);
            }
            return b2;
        }
        return null;
    }

    static String b(String str) {
        if (a.containsKey(str) && a.get(str) != null) {
            String str2 = a.get(str).get();
            if (!TextUtils.isEmpty(str2)) {
                return str2;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static SapiOptions.Cache.Module c(Context context, String str) {
        for (SapiOptions.Cache.Module module : SapiContext.getInstance(context).getSapiOptions().getCache().getModules()) {
            if (module.id.equals(str)) {
                return module;
            }
        }
        return null;
    }

    public static void init(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("Context can't be null");
        }
        d = context.getApplicationContext();
        a();
        b();
    }

    static void a() {
        SapiOptions.Cache cache = SapiContext.getInstance(d).getSapiOptions().getCache();
        if (cache.isEnabled()) {
            for (SapiOptions.Cache.Module module : cache.getModules()) {
                b.add(module.id);
            }
            c.addAll(b);
            for (SapiOptions.Cache.Module module2 : cache.getModules()) {
                a(module2, new a() { // from class: com.baidu.sapi2.SapiCache.2
                    @Override // com.baidu.sapi2.SapiCache.a
                    public void a(SapiOptions.Cache.Module module3, String str) {
                        SapiCache.a(module3.id, str);
                    }

                    @Override // com.baidu.sapi2.SapiCache.a
                    public void a(SapiOptions.Cache.Module module3) {
                        SapiCache.a(SapiCache.d, module3);
                    }
                });
            }
        }
    }

    static void a(SapiOptions.Cache.Module module, a aVar) {
        if (aVar == null) {
            throw new IllegalArgumentException(a.class.getName() + "can't be null");
        }
        String externalFile = SapiOptions.Cache.Module.getExternalFile(module.id);
        try {
            if ("mounted".equals(Environment.getExternalStorageState()) && new File(Environment.getExternalStorageDirectory(), externalFile).exists()) {
                String e = e(externalFile);
                if (MD5Util.toMd5(e.getBytes(), false).equals(module.hash)) {
                    aVar.a(module, e);
                } else {
                    aVar.a(module);
                }
            } else {
                aVar.a(module);
            }
        } catch (Throwable th) {
            aVar.a(module);
        }
    }

    static void a(Context context, SapiOptions.Cache.Module module) {
        String internalFile = SapiOptions.Cache.Module.getInternalFile(module.id);
        if (new File(context.getFilesDir(), internalFile).exists()) {
            try {
                a(module.id, d(context, internalFile));
            } catch (Throwable th) {
                Log.e(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String c(String str) {
        Uri parse;
        String str2 = parse.getHost() + (Uri.parse(str).getPort() == -1 ? "" : Config.TRACE_TODAY_VISIT_SPLIT + parse.getPort()) + parse.getPath();
        if (!str2.endsWith(".html")) {
            return str2 + ".html";
        }
        return str2;
    }

    static void b() {
        if (SapiUtils.hasActiveNetwork(d)) {
            try {
                HttpHashMapWrap c2 = c();
                String d2 = d();
                SapiOptions sapiOptions = SapiContext.getInstance(d).getSapiOptions();
                int i = sapiOptions.configStep;
                if (sapiOptions.configType == 0) {
                    c2.put("cdnversion", String.valueOf((int) (System.currentTimeMillis() / (i * 1000))));
                } else {
                    d2 = d2.replace("config.txt", "config_" + String.valueOf((int) (System.currentTimeMillis() / (i * 1000))) + ".txt");
                }
                new HttpClientWrap().get(d2, c2, null, null, new HttpHandlerWrap(Looper.getMainLooper()) { // from class: com.baidu.sapi2.SapiCache.3
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
                    public void onSuccess(int i2, String str) {
                        super.onSuccess(i2, str);
                        if (str != null) {
                            SapiCache.d(str);
                            SapiCache.i();
                        }
                    }

                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
                    public void onFailure(Throwable th, String str) {
                        super.onFailure(th, str);
                        StatService.onEvent("sslerr_config", Collections.singletonMap("na_err_code", "0"), false);
                        SapiCache.i();
                    }
                });
            } catch (Throwable th) {
                Log.e(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void i() {
        ThreadPoolService.getInstance().run(new TPRunnable(new Runnable() { // from class: com.baidu.sapi2.SapiCache.4
            @Override // java.lang.Runnable
            public void run() {
                String deviceInfo = SapiDeviceInfo.getDeviceInfo(SapiEnv.SAPI_CONFIG_URI);
                if (!TextUtils.isEmpty(deviceInfo)) {
                    StatService.onEvent("dvif_interface", Collections.singletonMap(AppIconSetting.DEFAULT_LARGE_ICON, deviceInfo), false);
                }
            }
        }));
    }

    static void d(final String str) {
        final SapiConfiguration sapiConfiguration = SapiAccountManager.getInstance().getSapiConfiguration();
        if (TextUtils.isEmpty(sapiConfiguration.sofireAppKey) || TextUtils.isEmpty(sapiConfiguration.sofireSecKey) || sapiConfiguration.sofireHostID == -1) {
            throw new IllegalArgumentException("sofireAppKey or sofireSecKey can't be empty and sofireHostID can't equal -1");
        }
        ThreadPoolService.getInstance().runImport(new TPRunnable(new Runnable() { // from class: com.baidu.sapi2.SapiCache.5
            @Override // java.lang.Runnable
            public void run() {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    SapiOptions sapiOptions = SapiContext.getInstance(SapiCache.d).getSapiOptions();
                    final SapiOptions fromJSON = SapiOptions.fromJSON(jSONObject);
                    if (fromJSON.getSofireSdkEnabled()) {
                        SapiCache.a(sapiConfiguration);
                    }
                    new ChinaMobileSDK().preGetPhoneInfo(SapiCache.d, sapiConfiguration.chinaMobileAppID, sapiConfiguration.chinaMobileAppKey, fromJSON.chinaMobileOauthGray);
                    PluginFacade.setSwitch(SapiCache.d, fromJSON.getPluginsEnabled());
                    SapiOptions.Cache cache = fromJSON.getCache();
                    final SapiOptions.Cache cache2 = sapiOptions.getCache();
                    SapiContext.getInstance(SapiCache.d).setSapiOptions(fromJSON);
                    SapiAccountManager.getInstance().preFetchStoken(SapiAccountManager.getInstance().getSession(), false);
                    new FaceLoginService().requestFaceLoginModel();
                    SapiCache.a(fromJSON.resetFileExecPer);
                    SapiCache.c.clear();
                    if (cache.isEnabled()) {
                        for (SapiOptions.Cache.Module module : cache.getModules()) {
                            SapiCache.c.add(module.id);
                        }
                        for (final SapiOptions.Cache.Module module2 : cache.getModules()) {
                            SapiOptions.Cache.Module module3 = null;
                            for (SapiOptions.Cache.Module module4 : sapiOptions.getCache().getModules()) {
                                if (!module4.id.equals(module2.id)) {
                                    module4 = module3;
                                }
                                module3 = module4;
                            }
                            if (!SapiCache.a(module2, module3)) {
                                SapiContext.getInstance(SapiCache.d).setSapiOptions(fromJSON);
                                SapiContext.getInstance(SapiCache.d).put(SapiContext.KEY_LOGIN_PAGE_IS_CACHED, true);
                                SapiCache.a(module2, new a() { // from class: com.baidu.sapi2.SapiCache.5.2
                                    @Override // com.baidu.sapi2.SapiCache.a
                                    public void a(SapiOptions.Cache.Module module5, String str2) {
                                    }

                                    @Override // com.baidu.sapi2.SapiCache.a
                                    public void a(SapiOptions.Cache.Module module5) {
                                        String internalFile = SapiOptions.Cache.Module.getInternalFile(module5.id);
                                        String externalFile = SapiOptions.Cache.Module.getExternalFile(module5.id);
                                        if (new File(SapiCache.d.getFilesDir(), internalFile).exists()) {
                                            try {
                                                String d2 = SapiCache.d(SapiCache.d, internalFile);
                                                if (SapiUtils.checkRequestPermission("android.permission.WRITE_EXTERNAL_STORAGE", SapiCache.d)) {
                                                    SapiCache.a(externalFile, d2.getBytes());
                                                }
                                            } catch (Throwable th) {
                                                Log.e(th);
                                            }
                                        }
                                    }
                                });
                            } else {
                                SapiCache.a(module2, new a() { // from class: com.baidu.sapi2.SapiCache.5.1
                                    @Override // com.baidu.sapi2.SapiCache.a
                                    public void a(SapiOptions.Cache.Module module5, String str2) {
                                        SapiContext.getInstance(SapiCache.d).setSapiOptions(fromJSON);
                                        if (!TextUtils.isEmpty(module2.id) && !TextUtils.isEmpty(str2)) {
                                            SapiCache.a(module2.id, str2);
                                            SapiCache.a(SapiCache.d, SapiOptions.Cache.Module.getInternalFile(module2.id), str2.getBytes());
                                        }
                                    }

                                    @Override // com.baidu.sapi2.SapiCache.a
                                    public void a(SapiOptions.Cache.Module module5) {
                                        new HttpClientWrap().get(module2.downloadUrl, SapiCache.c(), null, null, new HttpHandlerWrap(Looper.getMainLooper()) { // from class: com.baidu.sapi2.SapiCache.5.1.1
                                            /* JADX INFO: Access modifiers changed from: protected */
                                            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
                                            public void onSuccess(int i, String str2) {
                                                SapiCache.a(str2, module2, fromJSON);
                                            }

                                            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
                                            public void onFailure(Throwable th, String str2) {
                                                fromJSON.setCache(cache2);
                                                SapiContext.getInstance(SapiCache.d).setSapiOptions(fromJSON);
                                            }
                                        });
                                    }
                                });
                            }
                        }
                    }
                } catch (JSONException e) {
                }
            }
        }));
    }

    static void a(final String str, final SapiOptions.Cache.Module module, final SapiOptions sapiOptions) {
        ThreadPoolService.getInstance().runImport(new TPRunnable(new Runnable() { // from class: com.baidu.sapi2.SapiCache.6
            @Override // java.lang.Runnable
            public void run() {
                if (!TextUtils.isEmpty(SapiOptions.Cache.Module.this.id) && !TextUtils.isEmpty(str) && SapiOptions.Cache.Module.this.hash.equals(MD5Util.toMd5(str.getBytes(), false))) {
                    SapiContext.getInstance(SapiCache.d).setSapiOptions(sapiOptions);
                    SapiCache.a(SapiOptions.Cache.Module.this.id, str);
                    SapiCache.a(SapiCache.d, SapiOptions.Cache.Module.getInternalFile(SapiOptions.Cache.Module.this.id), str.getBytes());
                    if (SapiUtils.checkRequestPermission("android.permission.WRITE_EXTERNAL_STORAGE", SapiCache.d)) {
                        SapiCache.a(SapiOptions.Cache.Module.getExternalFile(SapiOptions.Cache.Module.this.id), str.getBytes());
                    }
                }
            }
        }));
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    @TargetApi(4)
    static void a(boolean z) {
        if (z) {
            String packageDirExecutePer = SapiContext.getInstance(d).getPackageDirExecutePer();
            if (!TextUtils.isEmpty(packageDirExecutePer)) {
                Process process = null;
                try {
                    try {
                        process = Runtime.getRuntime().exec("chmod " + packageDirExecutePer + " " + d.getApplicationInfo().dataDir);
                        if (process.waitFor() == 0) {
                            SapiContext.getInstance(d).setPackageDirExecutePer("");
                        }
                        if (process != null) {
                            process.destroy();
                        }
                    } catch (Exception e) {
                        Log.e(e);
                        if (process != null) {
                            process.destroy();
                        }
                    }
                } catch (Throwable th) {
                    if (process != null) {
                        process.destroy();
                    }
                    throw th;
                }
            }
        }
    }

    static void a(SapiConfiguration sapiConfiguration) {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            boolean init = SafeService.getInstance().init(d, sapiConfiguration.sofireAppKey, sapiConfiguration.sofireSecKey, 1);
            long currentTimeMillis2 = System.currentTimeMillis();
            String currentZid = SapiAccountManager.getInstance().getSafeFacade().getCurrentZid(d);
            long currentTimeMillis3 = System.currentTimeMillis();
            HashMap hashMap = new HashMap();
            hashMap.put("ssdk_init_time", (currentTimeMillis2 - currentTimeMillis) + "");
            hashMap.put("ssdk_zid_time", (currentTimeMillis3 - currentTimeMillis2) + "");
            hashMap.put("ssdk_zid_whole_time", (currentTimeMillis3 - currentTimeMillis) + "");
            hashMap.put("initSucc", init + "");
            hashMap.put("zid", currentZid);
            StatService.onEvent("ssdk_zid", hashMap, false);
        } catch (Exception e) {
            Log.e(e);
        }
    }

    static synchronized HttpHashMapWrap c() {
        HttpHashMapWrap httpHashMapWrap;
        synchronized (SapiCache.class) {
            httpHashMapWrap = new HttpHashMapWrap();
            httpHashMapWrap.put("tpl", SapiAccountManager.getInstance().getSapiConfiguration().tpl);
            httpHashMapWrap.put(SapiContext.KEY_SDK_VERSION, SapiAccountManager.VERSION_NAME);
            httpHashMapWrap.put(Constants.EXTRA_KEY_APP_VERSION, SapiUtils.getVersionName(d));
        }
        return httpHashMapWrap;
    }

    static boolean a(SapiOptions.Cache.Module module, SapiOptions.Cache.Module module2) {
        return !TextUtils.isEmpty(module.hash) && (module2 == null || !module.hash.equals(module2.hash));
    }

    static String d() {
        return !SapiAccountManager.getInstance().getSapiConfiguration().environment.equals(Domain.DOMAIN_ONLINE) ? SapiAccountManager.getInstance().getSapiConfiguration().environment.getConfigUrl() + SapiEnv.SAPI_CONFIG_URI : SapiAccountManager.getInstance().getSapiConfiguration().environment.getConfigHttpsUrl() + SapiEnv.SAPI_CONFIG_HTTPS_URI;
    }

    static void e() {
        ArrayList<String> arrayList = new ArrayList();
        for (String str : b) {
            if (!c.contains(str)) {
                arrayList.add(str);
                a(str);
            }
        }
        for (String str2 : arrayList) {
            if (b.contains(str2)) {
                b.remove(str2);
            }
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [661=4] */
    static void a(android.content.Context r5, java.lang.String r6, byte[] r7) {
        /*
            r0 = 0
            r1 = 0
            java.io.FileOutputStream r0 = r5.openFileOutput(r6, r1)     // Catch: java.lang.Throwable -> L1a
            r0.write(r7)     // Catch: java.lang.Throwable -> L1a
            com.baidu.sapi2.SapiContext r1 = com.baidu.sapi2.SapiContext.getInstance(r5)     // Catch: java.lang.Throwable -> L1a
            java.lang.String r2 = "login_page_is_cached"
            r3 = 1
            r1.put(r2, r3)     // Catch: java.lang.Throwable -> L1a
            if (r0 == 0) goto L19
            r0.close()     // Catch: java.lang.Throwable -> L2d
        L19:
            return
        L1a:
            r1 = move-exception
            if (r0 == 0) goto L19
            r0.close()     // Catch: java.lang.Throwable -> L21
            goto L19
        L21:
            r0 = move-exception
            goto L19
        L23:
            r1 = move-exception
            r4 = r1
            r1 = r0
            r0 = r4
        L27:
            if (r1 == 0) goto L2c
            r1.close()     // Catch: java.lang.Throwable -> L2f
        L2c:
            throw r0
        L2d:
            r0 = move-exception
            goto L19
        L2f:
            r1 = move-exception
            goto L2c
        L31:
            r1 = move-exception
            r4 = r1
            r1 = r0
            r0 = r4
            goto L27
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sapi2.SapiCache.a(android.content.Context, java.lang.String, byte[]):void");
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [694=4] */
    static void a(String str, byte[] bArr) {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            if ("mounted".equals(Environment.getExternalStorageState())) {
                File file = new File(Environment.getExternalStorageDirectory(), str);
                if (!file.getParentFile().exists()) {
                    file.getParentFile().mkdirs();
                }
                if (!file.exists()) {
                    file.createNewFile();
                }
                fileOutputStream = new FileOutputStream(file);
                try {
                    fileOutputStream.write(bArr);
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream2 = fileOutputStream;
                    try {
                        Log.e(th);
                        if (fileOutputStream2 != null) {
                            try {
                                fileOutputStream2.close();
                                return;
                            } catch (Throwable th2) {
                                Log.e(th2);
                                return;
                            }
                        }
                        return;
                    } catch (Throwable th3) {
                        if (fileOutputStream2 != null) {
                            try {
                                fileOutputStream2.close();
                            } catch (Throwable th4) {
                                Log.e(th4);
                            }
                        }
                        throw th3;
                    }
                }
            } else {
                fileOutputStream = null;
            }
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (Throwable th5) {
                    Log.e(th5);
                }
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    static String e(String str) throws IOException {
        return a(new FileInputStream(new File(Environment.getExternalStorageDirectory(), str)));
    }

    static String d(Context context, String str) throws IOException {
        return a(context.openFileInput(str));
    }

    static String a(InputStream inputStream) throws IOException {
        try {
            byte[] bArr = new byte[inputStream.available()];
            inputStream.read(bArr);
            return new String(bArr);
        } finally {
            inputStream.close();
        }
    }
}
