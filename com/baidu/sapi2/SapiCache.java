package com.baidu.sapi2;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import com.baidu.android.common.security.MD5Util;
import com.baidu.sapi2.SapiOptions;
import com.baidu.sapi2.a.c;
import com.baidu.sapi2.httpwrap.HttpClientWrap;
import com.baidu.sapi2.httpwrap.HttpHandlerWrap;
import com.baidu.sapi2.httpwrap.HttpHashMapWrap;
import com.baidu.sapi2.share.a.b;
import com.baidu.sapi2.utils.FileUtil;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiDeviceInfo;
import com.baidu.sapi2.utils.SapiEnv;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.StatService;
import com.meizu.cloud.pushsdk.notification.model.AppIconSetting;
import java.io.File;
import java.io.IOException;
import java.lang.ref.SoftReference;
import java.net.HttpCookie;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class SapiCache {
    private static final Map<String, SoftReference<String>> a = new ConcurrentHashMap();
    private final List<String> b = new ArrayList();
    private final List<String> c = new ArrayList();
    private Context d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface a {
        void a(SapiOptions.Cache.Module module);

        void a(SapiOptions.Cache.Module module, String str);
    }

    void a(String str, String str2) {
        a.put(str, new SoftReference<>(str2));
    }

    void a(String str) {
        a.remove(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a(Context context, String str) {
        if (!SapiContext.getInstance(context).getBoolean(SapiContext.KEY_LOGIN_PAGE_IS_CACHED, false)) {
            return null;
        }
        return b(context, c(str));
    }

    String b(final Context context, String str) {
        a();
        if (SapiContext.getInstance(context).getSapiOptions().getCache().isEnabled()) {
            String b = b(str);
            if (TextUtils.isEmpty(b)) {
                SapiOptions.Cache.Module c = c(context, str);
                if (c != null) {
                    a(c, new a() { // from class: com.baidu.sapi2.SapiCache.1
                        @Override // com.baidu.sapi2.SapiCache.a
                        public void a(SapiOptions.Cache.Module module, String str2) {
                            SapiCache.this.a(module.id, str2);
                        }

                        @Override // com.baidu.sapi2.SapiCache.a
                        public void a(SapiOptions.Cache.Module module) {
                            SapiCache.this.a(context, module);
                        }
                    });
                }
                return b(str);
            }
            return b;
        }
        return null;
    }

    String b(String str) {
        if (a.containsKey(str) && a.get(str) != null) {
            String str2 = a.get(str).get();
            if (!TextUtils.isEmpty(str2)) {
                return str2;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SapiOptions.Cache.Module c(Context context, String str) {
        for (SapiOptions.Cache.Module module : SapiContext.getInstance(context).getSapiOptions().getCache().getModules()) {
            if (module.id.equals(str)) {
                return module;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Context context) {
        this.d = context.getApplicationContext();
        SapiOptions sapiOptions = SapiContext.getInstance(this.d).getSapiOptions();
        a(sapiOptions);
        b(sapiOptions);
    }

    void a(SapiOptions sapiOptions) {
        SapiOptions.Cache cache = sapiOptions.getCache();
        if (cache.isEnabled()) {
            for (SapiOptions.Cache.Module module : cache.getModules()) {
                this.b.add(module.id);
            }
            this.c.addAll(this.b);
            for (SapiOptions.Cache.Module module2 : cache.getModules()) {
                a(module2, new a() { // from class: com.baidu.sapi2.SapiCache.2
                    @Override // com.baidu.sapi2.SapiCache.a
                    public void a(SapiOptions.Cache.Module module3, String str) {
                        SapiCache.this.a(module3.id, str);
                    }

                    @Override // com.baidu.sapi2.SapiCache.a
                    public void a(SapiOptions.Cache.Module module3) {
                        SapiCache.this.a(SapiCache.this.d, module3);
                    }
                });
            }
        }
    }

    void a(SapiOptions.Cache.Module module, a aVar) {
        if (aVar == null) {
            throw new IllegalArgumentException(a.class.getName() + "can't be null");
        }
        String externalFile = SapiOptions.Cache.Module.getExternalFile(module.id);
        try {
            if ("mounted".equals(Environment.getExternalStorageState()) && new File(Environment.getExternalStorageDirectory(), externalFile).exists()) {
                String d = d(externalFile);
                if (MD5Util.toMd5(d.getBytes(), false).equals(module.hash)) {
                    aVar.a(module, d);
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

    void a(Context context, SapiOptions.Cache.Module module) {
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
    public String c(String str) {
        Uri parse;
        String str2 = parse.getHost() + (Uri.parse(str).getPort() == -1 ? "" : ":" + parse.getPort()) + parse.getPath();
        if (!str2.endsWith(".html")) {
            return str2 + ".html";
        }
        return str2;
    }

    void b(final SapiOptions sapiOptions) {
        HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
        String str = SapiAccountManager.getInstance().getSapiConfiguration().environment.getConfigHttpsUrl() + SapiEnv.SAPI_CONFIG_HTTPS_URI;
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("If-None-Match", SapiContext.getInstance(this.d).getString(SapiContext.KEY_CONFIG_FILE_ETAG));
        try {
            new HttpClientWrap().get(str, httpHashMapWrap, hashMap, (List<HttpCookie>) null, (String) null, 0, new HttpHandlerWrap(true) { // from class: com.baidu.sapi2.SapiCache.3
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
                public void onSuccess(int i, String str2, HashMap<String, String> hashMap2) {
                    if (str2 != null) {
                        SapiCache.this.a(str2, sapiOptions);
                        if (hashMap2 != null) {
                            SapiContext.getInstance(SapiCache.this.d).put(SapiContext.KEY_CONFIG_FILE_ETAG, hashMap2.get("ETag"));
                        }
                        SapiCache.this.b();
                    }
                }

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
                public void onFailure(Throwable th, int i, String str2) {
                    SapiCache.this.c(sapiOptions);
                    SapiCache.this.b();
                }
            });
        } catch (Throwable th) {
            Log.e(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        String deviceInfo = SapiDeviceInfo.getDeviceInfo(SapiEnv.SAPI_CONFIG_URI);
        if (!TextUtils.isEmpty(deviceInfo)) {
            StatService.onEvent("dvif_interface", Collections.singletonMap(AppIconSetting.DEFAULT_LARGE_ICON, deviceInfo));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(SapiOptions sapiOptions) {
        new c().a(SapiAccountManager.getInstance().getSapiConfiguration(), sapiOptions.chinaMobileOauthGray, sapiOptions.ctGray);
        SapiAccountManager.getInstance().preFetchStoken(SapiAccountManager.getInstance().getSession(), false);
        new b().a(this.d, (String) null);
        a(sapiOptions.resetFileExecPer);
    }

    void a(String str, SapiOptions sapiOptions) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            final SapiOptions fromJSON = SapiOptions.fromJSON(jSONObject);
            SapiContext.getInstance(this.d).setSapiOptions(fromJSON);
            SapiContext.getInstance(this.d).setPkgSigns(SapiOptions.PkgSigns.fromJSON(jSONObject));
            SapiOptions.Cache cache = fromJSON.getCache();
            final SapiOptions.Cache cache2 = sapiOptions.getCache();
            c(fromJSON);
            this.c.clear();
            if (cache.isEnabled()) {
                for (SapiOptions.Cache.Module module : cache.getModules()) {
                    this.c.add(module.id);
                }
                for (final SapiOptions.Cache.Module module2 : cache.getModules()) {
                    SapiOptions.Cache.Module module3 = null;
                    for (SapiOptions.Cache.Module module4 : cache2.getModules()) {
                        if (!module4.id.equals(module2.id)) {
                            module4 = module3;
                        }
                        module3 = module4;
                    }
                    if (a(module2, module3)) {
                        a(module2, new a() { // from class: com.baidu.sapi2.SapiCache.4
                            @Override // com.baidu.sapi2.SapiCache.a
                            public void a(SapiOptions.Cache.Module module5, String str2) {
                                if (!TextUtils.isEmpty(module2.id) && !TextUtils.isEmpty(str2)) {
                                    SapiCache.this.a(module2.id, str2);
                                    SapiCache.this.a(SapiCache.this.d, SapiOptions.Cache.Module.getInternalFile(module2.id), str2.getBytes());
                                }
                            }

                            @Override // com.baidu.sapi2.SapiCache.a
                            public void a(SapiOptions.Cache.Module module5) {
                                new HttpClientWrap().get(module2.downloadUrl, new HttpHashMapWrap(), null, null, new HttpHandlerWrap(true) { // from class: com.baidu.sapi2.SapiCache.4.1
                                    /* JADX INFO: Access modifiers changed from: protected */
                                    @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
                                    public void onSuccess(int i, String str2) {
                                        SapiCache.this.a(str2, module2);
                                    }

                                    @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
                                    public void onFailure(Throwable th, int i, String str2) {
                                        fromJSON.setCache(cache2);
                                        SapiContext.getInstance(SapiCache.this.d).setSapiOptions(fromJSON);
                                    }
                                });
                            }
                        });
                    } else {
                        SapiContext.getInstance(this.d).put(SapiContext.KEY_LOGIN_PAGE_IS_CACHED, true);
                        a(module2, new a() { // from class: com.baidu.sapi2.SapiCache.5
                            @Override // com.baidu.sapi2.SapiCache.a
                            public void a(SapiOptions.Cache.Module module5, String str2) {
                            }

                            @Override // com.baidu.sapi2.SapiCache.a
                            public void a(SapiOptions.Cache.Module module5) {
                                String internalFile = SapiOptions.Cache.Module.getInternalFile(module5.id);
                                String externalFile = SapiOptions.Cache.Module.getExternalFile(module5.id);
                                if (new File(SapiCache.this.d.getFilesDir(), internalFile).exists()) {
                                    try {
                                        String d = SapiCache.this.d(SapiCache.this.d, internalFile);
                                        if (SapiUtils.checkRequestPermission("android.permission.WRITE_EXTERNAL_STORAGE", SapiCache.this.d)) {
                                            SapiCache.this.a(externalFile, d.getBytes());
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
        } catch (JSONException e) {
        }
    }

    void a(String str, SapiOptions.Cache.Module module) {
        if (!TextUtils.isEmpty(module.id) && !TextUtils.isEmpty(str) && module.hash.equals(MD5Util.toMd5(str.getBytes(), false))) {
            a(module.id, str);
            a(this.d, SapiOptions.Cache.Module.getInternalFile(module.id), str.getBytes());
            if (SapiUtils.checkRequestPermission("android.permission.WRITE_EXTERNAL_STORAGE", this.d)) {
                a(SapiOptions.Cache.Module.getExternalFile(module.id), str.getBytes());
            }
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    @TargetApi(4)
    void a(boolean z) {
        if (z) {
            String packageDirExecutePer = SapiContext.getInstance(this.d).getPackageDirExecutePer();
            if (!TextUtils.isEmpty(packageDirExecutePer)) {
                Process process = null;
                try {
                    try {
                        process = Runtime.getRuntime().exec("chmod " + packageDirExecutePer + " " + this.d.getApplicationInfo().dataDir);
                        if (process.waitFor() == 0) {
                            SapiContext.getInstance(this.d).setPackageDirExecutePer("");
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

    boolean a(SapiOptions.Cache.Module module, SapiOptions.Cache.Module module2) {
        return !TextUtils.isEmpty(module.hash) && (module2 == null || !module.hash.equals(module2.hash));
    }

    void a() {
        ArrayList<String> arrayList = new ArrayList();
        for (String str : this.b) {
            if (!this.c.contains(str)) {
                arrayList.add(str);
                a(str);
            }
        }
        for (String str2 : arrayList) {
            if (this.b.contains(str2)) {
                this.b.remove(str2);
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
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [559=4] */
    void a(android.content.Context r6, java.lang.String r7, byte[] r8) {
        /*
            r5 = this;
            r0 = 0
            r1 = 0
            java.io.FileOutputStream r0 = r6.openFileOutput(r7, r1)     // Catch: java.lang.Throwable -> L1a
            r0.write(r8)     // Catch: java.lang.Throwable -> L1a
            com.baidu.sapi2.SapiContext r1 = com.baidu.sapi2.SapiContext.getInstance(r6)     // Catch: java.lang.Throwable -> L1a
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

    void a(String str, byte[] bArr) {
        try {
            if ("mounted".equals(Environment.getExternalStorageState())) {
                FileUtil.write(new File(Environment.getExternalStorageDirectory(), str), bArr, false);
            }
        } catch (Throwable th) {
            Log.e(th);
        }
    }

    String d(String str) throws IOException {
        return FileUtil.read(new File(Environment.getExternalStorageDirectory(), str).getAbsolutePath());
    }

    @TargetApi(4)
    String d(Context context, String str) throws IOException {
        return FileUtil.read(context.getApplicationInfo().dataDir + File.separator + "files" + File.separator + str);
    }
}
