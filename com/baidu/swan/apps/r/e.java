package com.baidu.swan.apps.r;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.aq.ad;
import com.baidu.swan.apps.aq.ah;
import com.baidu.swan.apps.aq.aj;
import com.baidu.swan.apps.env.SwanAppDeleteInfo;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.r.a.a;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.statistic.h;
import com.baidu.swan.apps.statistic.j;
import com.baidu.swan.apps.v.b.b;
import java.io.File;
import java.io.FileFilter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class e {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static ExecutorService cgo = Executors.newSingleThreadExecutor();

    /* loaded from: classes11.dex */
    public interface b {
        void dt(int i);

        void onFailed();

        void onSuccess();
    }

    /* loaded from: classes11.dex */
    public static class c {
        public String mAppId;
        public String mDownloadUrl;
    }

    /* loaded from: classes11.dex */
    public static class f extends com.baidu.swan.apps.r.a {
        public String cgs;
        public SwanAppConfigData cgt;
    }

    public static void a(final com.baidu.swan.apps.v.b.b bVar, final com.baidu.swan.apps.r.b bVar2) {
        String abS;
        final JSONObject jSONObject = null;
        if (bVar == null || j.oz(bVar.getVersion())) {
            jSONObject = new JSONObject();
            String atN = aj.atN();
            if (bVar == null) {
                abS = "null";
            } else {
                try {
                    abS = bVar.abS();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            jSONObject.put("originLaunchInfo", abS);
            jSONObject.put("stackTraceBefore", atN);
        }
        cgo.execute(new Runnable() { // from class: com.baidu.swan.apps.r.e.1
            @Override // java.lang.Runnable
            public void run() {
                f a2;
                com.baidu.swan.apps.aq.a.b bVar3 = new com.baidu.swan.apps.aq.a.b();
                if (com.baidu.swan.apps.af.a.a.m(com.baidu.swan.apps.v.b.b.this)) {
                    a2 = com.baidu.swan.apps.af.a.a.a(com.baidu.swan.apps.v.b.b.this, bVar3);
                } else {
                    a2 = d.a(com.baidu.swan.apps.v.b.b.this, bVar3, jSONObject);
                }
                if (a2 == null || a2.cgt == null || a2.cgt.cAs == null) {
                    com.baidu.swan.apps.an.a aVar = bVar3.cKt;
                    if (aVar == null) {
                        aVar = new com.baidu.swan.apps.an.a().bw(5L).bx(20L).pt("小程序loadbundle出错，loadinfo为空或者页面配置空 ");
                    }
                    h.b(new com.baidu.swan.apps.statistic.a.d().oC(h.gU(com.baidu.swan.apps.v.b.b.this != null ? com.baidu.swan.apps.v.b.b.this.getAppFrameType() : 0)).f(aVar).oF("appjson_config_invalid").a(com.baidu.swan.apps.v.b.b.this));
                }
                bVar2.a(0, a2);
            }
        });
    }

    public static File aeI() {
        return new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "aiapps_folder");
    }

    public static File aeJ() {
        return new File(AppRuntime.getAppContext().getFilesDir(), "swan_plugin_workspace");
    }

    public static File kC(String str) {
        if (TextUtils.isEmpty(str)) {
            if (DEBUG) {
                throw new IllegalArgumentException("plugin name can't be empty");
            }
            return null;
        }
        return new File(aeJ(), str);
    }

    public static File bh(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            if (DEBUG) {
                throw new IllegalArgumentException("plugin name or version can't be empty");
            }
            return null;
        }
        return new File(kC(str), str2);
    }

    public static boolean a(File file, File file2, com.baidu.swan.apps.v.b.b bVar) {
        return a(file, file2, bVar, null);
    }

    public static synchronized String t(@NonNull File file) {
        String str;
        synchronized (e.class) {
            if (file == null) {
                str = "";
            } else {
                String path = file.getPath();
                if (DEBUG) {
                    Log.d("SwanAppBundleHelper", "getConfigContent path: " + path);
                }
                str = (String) com.baidu.swan.apps.core.turbo.c.abi().o(path, "");
                if (TextUtils.isEmpty(str)) {
                    if (DEBUG) {
                        Log.d("SwanAppBundleHelper", "getConfigContent read start: " + path);
                    }
                    str = com.baidu.swan.e.d.readFileData(file);
                    com.baidu.swan.apps.core.turbo.c.abi().p(path, str);
                    if (DEBUG) {
                        Log.d("SwanAppBundleHelper", "getConfigContent read end: " + path);
                    }
                }
            }
        }
        return str;
    }

    private static File c(@NonNull com.baidu.swan.apps.runtime.e eVar) {
        File file = null;
        if (eVar != null) {
            b.a aoJ = eVar.aoJ();
            file = a(eVar.getAppId(), aoJ.getVersion(), aoJ.ahe(), aoJ.ahf(), null);
            if (DEBUG) {
                Log.d("SwanAppBundleHelper", "sendLaunchEvent folderFile: " + file.getPath());
                Log.d("SwanAppBundleHelper", "sendLaunchEvent file exists: " + file.exists());
            }
        }
        return file;
    }

    public static synchronized boolean d(@NonNull com.baidu.swan.apps.runtime.e eVar) {
        boolean z = true;
        synchronized (e.class) {
            File c2 = c(eVar);
            if (c2 == null || !c2.exists()) {
                z = false;
            } else {
                String t = t(new File(c2, "app.json"));
                if (DEBUG && !TextUtils.isEmpty(t)) {
                    Log.i("SwanAppBundleHelper", "pre handle configData : " + t);
                }
                SwanAppConfigData k = SwanAppConfigData.k(t, c2);
                if (k != null) {
                    eVar.f(k);
                }
                com.baidu.swan.apps.ae.b.a.a(k, true);
                com.baidu.swan.apps.ae.g.b.e(k);
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean a(File file, File file2, com.baidu.swan.apps.v.b.b bVar, com.baidu.swan.apps.aq.a.b bVar2) {
        boolean unzipFile;
        int i = 0;
        if (file == null || file2 == null) {
            return false;
        }
        if (!file.exists() || file.length() == 0) {
            com.baidu.swan.apps.an.a pt = new com.baidu.swan.apps.an.a().bw(5L).bx(4L).pt("小程序bundle文件不存在或者空文件! ");
            if (bVar2 != null) {
                bVar2.cKt = pt;
                return false;
            }
            return false;
        }
        com.baidu.swan.apps.performance.g.alx().f(new UbcFlowEvent("package_start_unzip"));
        long currentTimeMillis = System.currentTimeMillis();
        a.b w = com.baidu.swan.apps.r.a.a.w(file);
        if (w.type != -1) {
            unzipFile = com.baidu.swan.apps.r.a.a.a(w.cgD, file2, w.type).isSuccess;
            i = w.type;
        } else {
            unzipFile = com.baidu.swan.e.d.unzipFile(file.getPath(), file2.getPath());
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        if (DEBUG) {
            com.baidu.swan.apps.r.a.a.fy((int) (currentTimeMillis2 - currentTimeMillis));
        }
        if (!unzipFile) {
            com.baidu.swan.apps.an.a pt2 = new com.baidu.swan.apps.an.a().bw(5L).bx(7L).pt("小程序bundle解压失败! PkgType=" + i);
            if (bVar2 != null) {
                bVar2.cKt = pt2;
            }
        }
        com.baidu.swan.apps.performance.g.alx().f(new UbcFlowEvent("package_end_unzip")).bD("app_package_version", String.valueOf(i));
        return unzipFile;
    }

    private static File kD(String str) {
        return new File(aeI(), str);
    }

    private static File bi(String str, String str2) {
        return new File(kD(str), str2);
    }

    public static File a(String str, String str2, boolean z, String str3, @Nullable JSONObject jSONObject) {
        File d2 = d.d(str, str2, jSONObject);
        return (!z || TextUtils.isEmpty(str3)) ? d2 : new File(d2, str3);
    }

    public static File C(String str, String str2, String str3) {
        return new File(bi(str, str2), ah.pN(str3));
    }

    public static boolean D(String str, String str2, String str3) {
        return u(C(str, str2, str3));
    }

    public static boolean bj(String str, String str2) {
        return new File(bi(str, str2), "app.json").exists();
    }

    public static boolean u(File file) {
        if (file == null || !file.exists()) {
            return false;
        }
        return new File(file, "app.json").exists();
    }

    /* loaded from: classes11.dex */
    public static class d {
        public static f a(com.baidu.swan.apps.v.b.b bVar, com.baidu.swan.apps.aq.a.b bVar2, @Nullable JSONObject jSONObject) {
            if (bVar == null) {
                return null;
            }
            File a = e.a(bVar.getAppId(), bVar.getVersion(), bVar.ahe(), bVar.ahf(), jSONObject);
            if (!a.exists()) {
                File a2 = a(bVar.getAppId(), true, bVar2);
                if (a2 != null) {
                    if (!e.a(a2, v(a), bVar, bVar2)) {
                        com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "小程序bundle解压失败!").showToast();
                        com.baidu.swan.apps.an.a pt = new com.baidu.swan.apps.an.a().bw(5L).bx(7L).pt("小程序bundle解压失败! for release");
                        com.baidu.swan.apps.an.e.asQ().g(pt);
                        if (bVar2 == null || bVar2.cKt != null) {
                            return null;
                        }
                        bVar2.cKt = pt;
                        return null;
                    }
                } else {
                    com.baidu.swan.apps.process.messaging.client.a.amQ().a(8, new SwanAppDeleteInfo(bVar.getAppId(), 1));
                    h.b(new com.baidu.swan.apps.statistic.a.d().oC(h.gU(bVar.getAppFrameType())).f(new com.baidu.swan.apps.an.a().bw(5L).bx(31L).pt("小程序zip和bundle不存在，兜底重置")).a(bVar));
                    if (e.DEBUG) {
                        Log.w("SwanAppBundleHelper", "20050004：reset aiapps");
                        return null;
                    }
                    return null;
                }
            }
            bl(bVar.getAppId(), bVar.getVersion());
            f fVar = new f();
            File file = new File(a, "app.json");
            SwanAppConfigData k = SwanAppConfigData.k(e.t(file), a);
            if (k != null) {
                fVar.cgs = bk(bVar.getAppId(), bVar.getVersion()).getPath() + File.separator;
                fVar.cgt = k;
                com.baidu.swan.apps.ae.b.a.a(k, true);
                com.baidu.swan.apps.ae.g.b.e(k);
                if (e.DEBUG) {
                    Log.d("SwanAppBundleHelper", "configFile path: " + file.getPath());
                    Log.d("SwanAppBundleHelper", "configFile exist: " + file.exists());
                    Log.d("SwanAppBundleHelper", "info.mAppBundlePath path: " + fVar.cgs);
                    Log.d("SwanAppBundleHelper", "launchInfo.swanCoreVersion.swanCorePath: " + bVar.abG().swanCorePath);
                }
                return fVar;
            }
            return null;
        }

        public static File v(File file) {
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }

        public static File bk(String str, String str2) {
            return d(str, str2, null);
        }

        public static File d(String str, String str2, @Nullable JSONObject jSONObject) {
            if (j.oz(str2)) {
                j.e(str, str2, jSONObject);
            }
            return new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "aiapps_folder" + File.separator + str, str2);
        }

        public static void kE(String str) {
            if (!TextUtils.isEmpty(str)) {
                File M = M(str, false);
                if (M != null) {
                    com.baidu.swan.e.d.deleteFile(M);
                }
                com.baidu.swan.e.d.deleteFile(new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "aiapps_folder" + File.separator + str));
            }
        }

        public static void bl(String str, String str2) {
            File[] listFiles;
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && (listFiles = new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "aiapps_folder", str).listFiles(new FileFilter() { // from class: com.baidu.swan.apps.r.e.d.1
                @Override // java.io.FileFilter
                public boolean accept(File file) {
                    return file.isDirectory() && TextUtils.isDigitsOnly(file.getName());
                }
            })) != null && listFiles.length > 0) {
                for (File file : listFiles) {
                    if (bm(str2, file.getName())) {
                        if (e.DEBUG) {
                            Log.i("SwanAppBundleHelper", "删除低版本文件夹：" + file.getAbsolutePath());
                        }
                        com.baidu.swan.pms.database.a.aFV().cJ(str, file.getName());
                        com.baidu.swan.e.d.deleteFile(file);
                    }
                }
            }
        }

        @Nullable
        public static File M(String str, boolean z) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return a(str, z, (com.baidu.swan.apps.aq.a.b) null);
        }

        public static File a(String str, boolean z, com.baidu.swan.apps.aq.a.b bVar) {
            File aeL;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            File[] listFiles = aeL().listFiles();
            if (listFiles == null || listFiles.length == 0) {
                if (e.DEBUG && z) {
                    com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), aeL.getPath() + " 没有小程序包!").showToast();
                }
                com.baidu.swan.apps.an.a pt = new com.baidu.swan.apps.an.a().bw(5L).bx(4L).pt("没有小程序包! for release, bundle files are empty");
                com.baidu.swan.apps.an.e.asQ().g(pt);
                if (bVar != null) {
                    bVar.cKt = pt;
                }
                return null;
            }
            for (File file : listFiles) {
                if (TextUtils.equals(file.getName(), str + ".aiapps")) {
                    return file;
                }
            }
            if (e.DEBUG && z) {
                com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), aeL.getPath() + " 没有小程序包!").showToast();
            }
            com.baidu.swan.apps.an.a pt2 = new com.baidu.swan.apps.an.a().bw(5L).bx(4L).pt("没有小程序包! for release, no such bundle file");
            com.baidu.swan.apps.an.e.asQ().g(pt2);
            if (bVar != null) {
                bVar.cKt = pt2;
            }
            return null;
        }

        public static File aeL() {
            File file = new File(AppRuntime.getAppContext().getFilesDir(), "aiapps_zip");
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }

        private static boolean bm(String str, String str2) {
            if (e.DEBUG) {
                Log.i("SwanAppBundleHelper", "curVersion:" + str + ",targetVersion:" + str2);
            }
            try {
                return bn(str, str2) > 0;
            } catch (IllegalArgumentException e) {
                if (e.DEBUG) {
                    Log.e("SwanAppBundleHelper", "比较版本号Exception：" + e.getMessage());
                    return false;
                }
                return false;
            }
        }

        private static long bn(String str, String str2) throws IllegalArgumentException {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                throw new IllegalArgumentException("version null");
            }
            if (!TextUtils.isDigitsOnly(str) || !TextUtils.isDigitsOnly(str2)) {
                throw new IllegalArgumentException("version is not digits only");
            }
            return Long.parseLong(str) - Long.parseLong(str2);
        }
    }

    public static void a(c cVar, b bVar) {
        new com.baidu.swan.apps.k.a().a(cVar, a.Wu().getPath() + File.separator + String.valueOf(System.currentTimeMillis()) + ".aibundle", bVar);
    }

    public static void a(String str, b bVar) {
        c cVar = new c();
        cVar.mDownloadUrl = str;
        com.baidu.swan.apps.swancore.b.a.acL();
        new com.baidu.swan.apps.k.a().a(cVar, com.baidu.swan.apps.swancore.b.a.acM().getPath(), bVar);
    }

    public static void b(String str, b bVar) {
        c cVar = new c();
        cVar.mDownloadUrl = str;
        com.baidu.swan.apps.extcore.c.b.acL();
        new com.baidu.swan.apps.k.a().a(cVar, com.baidu.swan.apps.extcore.c.b.acM().getPath(), bVar);
    }

    /* loaded from: classes11.dex */
    public static class a {
        /* JADX WARN: Removed duplicated region for block: B:19:0x00b2  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static f a(com.baidu.swan.apps.v.b.b bVar, com.baidu.swan.apps.aq.a.b bVar2) {
            f fVar = null;
            File a = a(bVar2);
            if (a != null) {
                com.baidu.swan.apps.runtime.e aoF = com.baidu.swan.apps.runtime.e.aoF();
                if (aoF == null) {
                    if (!e.a(a, VZ(), bVar, bVar2)) {
                        com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "小程序bundle解压失败!").showToast();
                        com.baidu.swan.apps.an.a pt = new com.baidu.swan.apps.an.a().bw(5L).bx(7L).pt("小程序bundle解压失败! for debug");
                        com.baidu.swan.apps.an.e.asQ().g(pt);
                        if (bVar2 != null && bVar2.cKt == null) {
                            bVar2.cKt = pt;
                        }
                    }
                    fVar = new f();
                    File aeK = aeK();
                    File file = new File(aeK, "app.json");
                    SwanAppConfigData k = SwanAppConfigData.k(com.baidu.swan.e.d.readFileData(file), aeK);
                    fVar.cgs = aeK.getPath() + File.separator;
                    fVar.cgt = k;
                    com.baidu.swan.apps.ae.b.a.a(k, true);
                    com.baidu.swan.apps.ae.g.b.e(k);
                    if (e.DEBUG) {
                    }
                } else {
                    String string = aoF.aoR().getString("installed_debug_bundle_md5", "");
                    String md5 = com.baidu.swan.e.e.toMd5(a, false);
                    if (!TextUtils.equals(string, md5)) {
                        if (!e.a(a, VZ(), bVar, bVar2)) {
                            com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "小程序bundle解压失败!").showToast();
                            com.baidu.swan.apps.an.a pt2 = new com.baidu.swan.apps.an.a().bw(5L).bx(7L).pt("小程序bundle解压失败! for debug");
                            com.baidu.swan.apps.an.e.asQ().g(pt2);
                            if (bVar2 != null && bVar2.cKt == null) {
                                bVar2.cKt = pt2;
                            }
                        } else {
                            aoF.aoR().putString("installed_debug_bundle_md5", md5);
                        }
                    }
                    fVar = new f();
                    File aeK2 = aeK();
                    File file2 = new File(aeK2, "app.json");
                    SwanAppConfigData k2 = SwanAppConfigData.k(com.baidu.swan.e.d.readFileData(file2), aeK2);
                    fVar.cgs = aeK2.getPath() + File.separator;
                    fVar.cgt = k2;
                    com.baidu.swan.apps.ae.b.a.a(k2, true);
                    com.baidu.swan.apps.ae.g.b.e(k2);
                    if (e.DEBUG) {
                        Log.d("SwanAppBundleHelper", "configFile path: " + file2.getPath());
                        Log.d("SwanAppBundleHelper", "configFile exist: " + file2.exists());
                        Log.d("SwanAppBundleHelper", "info.mAppBundlePath path: " + fVar.cgs);
                        Log.d("SwanAppBundleHelper", "launchInfo.swanCoreVersion.swanCorePath: " + bVar.abG().swanCorePath);
                    }
                }
            }
            return fVar;
        }

        public static File aeK() {
            return VZ();
        }

        public static File VZ() {
            File file = new File(AppRuntime.getAppContext().getFilesDir(), "debug_aiapps_bundle");
            file.mkdirs();
            return file;
        }

        public static File a(com.baidu.swan.apps.aq.a.b bVar) {
            File Wu = Wu();
            File[] listFiles = Wu.listFiles();
            if (listFiles == null || listFiles.length == 0) {
                com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), Wu.getPath() + " 没有测试程序包!").showToast();
                com.baidu.swan.apps.an.a pt = new com.baidu.swan.apps.an.a().bw(5L).bx(4L).pt("没有小程序包! for debug, bundle files are empty");
                com.baidu.swan.apps.an.e.asQ().g(pt);
                if (bVar != null) {
                    bVar.cKt = pt;
                }
                return null;
            }
            return c(listFiles);
        }

        private static File c(File[] fileArr) {
            File file = null;
            for (File file2 : fileArr) {
                if (file == null || file2.lastModified() > file.lastModified()) {
                    file = file2;
                }
            }
            return file;
        }

        public static File Wu() {
            File file = new File(ad.getStorageList().get(0).mPath, "/aiapps_debug/");
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }
    }

    /* renamed from: com.baidu.swan.apps.r.e$e  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0371e {
        public static f d(com.baidu.swan.apps.v.b.b bVar) {
            File VZ = VZ();
            com.baidu.swan.apps.console.debugger.a.d.Wf().iQ("unzipstart");
            e.a(Wt(), VZ, bVar);
            com.baidu.swan.apps.console.debugger.a.d.Wf().iQ("unzipend");
            f fVar = new f();
            File file = new File(VZ, "app.json");
            SwanAppConfigData k = SwanAppConfigData.k(com.baidu.swan.e.d.readFileData(file), VZ);
            fVar.cgs = VZ.getPath() + File.separator;
            fVar.cgt = k;
            com.baidu.swan.apps.ae.b.a.a(k, true);
            com.baidu.swan.apps.ae.g.b.e(k);
            if (e.DEBUG) {
                Log.d("SwanAppBundleHelper", "configFile path: " + file.getPath());
                Log.d("SwanAppBundleHelper", "configFile exist: " + file.exists());
                Log.d("SwanAppBundleHelper", "info.mAppBundlePath path: " + fVar.cgs);
            }
            return fVar;
        }

        public static File VZ() {
            File file = new File(AppRuntime.getAppContext().getFilesDir(), "aiapps_remote_debug_folder");
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }

        public static File Wt() {
            return new File(Wu(), "remote_debug.aiapps");
        }

        public static File Wu() {
            File file = new File(AppRuntime.getAppContext().getFilesDir(), "aiapps_remote_debug_zip");
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }
    }
}
