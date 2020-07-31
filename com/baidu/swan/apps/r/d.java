package com.baidu.swan.apps.r;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.aq.aj;
import com.baidu.swan.apps.aq.al;
import com.baidu.swan.apps.env.SwanAppDeleteInfo;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.performance.i;
import com.baidu.swan.apps.r.a.a;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.statistic.h;
import com.baidu.swan.apps.statistic.j;
import com.baidu.swan.apps.u.c.b;
import java.io.File;
import java.io.FileFilter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static ExecutorService cng = Executors.newSingleThreadExecutor();

    /* loaded from: classes7.dex */
    public interface b {
        void dE(int i);

        void onFailed();

        void onSuccess();
    }

    /* loaded from: classes7.dex */
    public static class c {
        public String mAppId;
        public String mDownloadUrl;
    }

    /* loaded from: classes7.dex */
    public static class f extends com.baidu.swan.apps.r.a {
        public String cnk;
        public SwanAppConfigData cnl;
    }

    public static void a(final com.baidu.swan.apps.u.c.b bVar, final com.baidu.swan.apps.r.b bVar2) {
        String aed;
        final JSONObject jSONObject = null;
        if (bVar == null || j.pr(bVar.getVersion())) {
            jSONObject = new JSONObject();
            String awZ = al.awZ();
            if (bVar == null) {
                aed = "null";
            } else {
                try {
                    aed = bVar.aed();
                } catch (JSONException e2) {
                    if (DEBUG) {
                        e2.printStackTrace();
                    }
                }
            }
            jSONObject.put("originLaunchInfo", aed);
            jSONObject.put("stackTraceBefore", awZ);
        }
        cng.execute(new Runnable() { // from class: com.baidu.swan.apps.r.d.1
            @Override // java.lang.Runnable
            public void run() {
                f a2;
                com.baidu.swan.apps.aq.a.b bVar3 = new com.baidu.swan.apps.aq.a.b();
                if (com.baidu.swan.apps.ae.a.a.j(com.baidu.swan.apps.u.c.b.this)) {
                    a2 = com.baidu.swan.apps.ae.a.a.a(com.baidu.swan.apps.u.c.b.this, bVar3);
                } else {
                    a2 = C0380d.a(com.baidu.swan.apps.u.c.b.this, bVar3, jSONObject);
                }
                if (a2 == null || a2.cnl == null || a2.cnl.cHS == null) {
                    com.baidu.swan.apps.an.a aVar = bVar3.cSE;
                    if (aVar == null) {
                        aVar = new com.baidu.swan.apps.an.a().bJ(5L).bK(20L).qm("小程序loadbundle出错，loadinfo为空或者页面配置空 ");
                    }
                    h.b(new com.baidu.swan.apps.statistic.a.d().pu(h.ho(com.baidu.swan.apps.u.c.b.this != null ? com.baidu.swan.apps.u.c.b.this.getAppFrameType() : 0)).f(aVar).px("appjson_config_invalid").a(com.baidu.swan.apps.u.c.b.this));
                }
                bVar2.a(0, a2);
            }
        });
    }

    public static File agZ() {
        return new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "aiapps_folder");
    }

    public static String aha() {
        return AppRuntime.getAppContext().getFilesDir() + File.separator + "aiapps_folder";
    }

    public static File ahb() {
        return new File(AppRuntime.getAppContext().getFilesDir(), "swan_plugin_workspace");
    }

    public static File lh(String str) {
        if (TextUtils.isEmpty(str)) {
            if (DEBUG) {
                throw new IllegalArgumentException("plugin name can't be empty");
            }
            return null;
        }
        return new File(ahb(), str);
    }

    public static File bn(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            if (DEBUG) {
                throw new IllegalArgumentException("plugin name or version can't be empty");
            }
            return null;
        }
        return new File(lh(str), str2);
    }

    public static boolean a(File file, File file2, com.baidu.swan.apps.u.c.b bVar) {
        return a(file, file2, bVar, null);
    }

    public static synchronized String u(@NonNull File file) {
        String str;
        synchronized (d.class) {
            if (file == null) {
                str = "";
            } else {
                String path = file.getPath();
                if (DEBUG) {
                    Log.d("SwanAppBundleHelper", "getConfigContent path: " + path);
                }
                str = (String) com.baidu.swan.apps.core.turbo.c.adt().o(path, "");
                if (TextUtils.isEmpty(str)) {
                    if (DEBUG) {
                        Log.d("SwanAppBundleHelper", "getConfigContent read start: " + path);
                    }
                    str = com.baidu.swan.d.d.readFileData(file);
                    com.baidu.swan.apps.core.turbo.c.adt().p(path, str);
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
            b.a arz = eVar.arz();
            file = a(eVar.getAppId(), arz.getVersion(), arz.ajA(), arz.ajB(), null);
            if (DEBUG) {
                Log.d("SwanAppBundleHelper", "sendLaunchEvent folderFile: " + file.getPath());
                Log.d("SwanAppBundleHelper", "sendLaunchEvent file exists: " + file.exists());
            }
        }
        return file;
    }

    public static synchronized boolean d(@NonNull com.baidu.swan.apps.runtime.e eVar) {
        boolean z = true;
        synchronized (d.class) {
            File c2 = c(eVar);
            if (c2 == null || !c2.exists()) {
                z = false;
            } else {
                SwanAppConfigData z2 = com.baidu.swan.apps.u.a.a.z(c2);
                if (z2 != null) {
                    eVar.f(z2);
                }
                com.baidu.swan.apps.ad.b.a.a(z2, true);
                com.baidu.swan.apps.ad.g.b.e(z2);
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean a(File file, File file2, com.baidu.swan.apps.u.c.b bVar, com.baidu.swan.apps.aq.a.b bVar2) {
        boolean unzipFile;
        int i = 0;
        if (file == null || file2 == null) {
            return false;
        }
        if (!file.exists() || file.length() == 0) {
            com.baidu.swan.apps.an.a qm = new com.baidu.swan.apps.an.a().bJ(5L).bK(4L).qm("小程序bundle文件不存在或者空文件! ");
            if (bVar2 != null) {
                bVar2.cSE = qm;
                return false;
            }
            return false;
        }
        i.anX().f(new UbcFlowEvent("package_start_unzip"));
        long currentTimeMillis = System.currentTimeMillis();
        a.b x = com.baidu.swan.apps.r.a.a.x(file);
        if (x.type != -1) {
            unzipFile = com.baidu.swan.apps.r.a.a.a(x.cnw, file2, x.type).isSuccess;
            i = x.type;
        } else {
            unzipFile = com.baidu.swan.d.d.unzipFile(file.getPath(), file2.getPath());
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        if (DEBUG) {
            com.baidu.swan.apps.r.a.a.fT((int) (currentTimeMillis2 - currentTimeMillis));
        }
        if (!unzipFile) {
            com.baidu.swan.apps.an.a qm2 = new com.baidu.swan.apps.an.a().bJ(5L).bK(7L).qm("小程序bundle解压失败! PkgType=" + i);
            if (bVar2 != null) {
                bVar2.cSE = qm2;
            }
        }
        i.anX().f(new UbcFlowEvent("package_end_unzip")).bH("app_package_version", String.valueOf(i));
        return unzipFile;
    }

    private static File li(String str) {
        return new File(agZ(), str);
    }

    private static File bo(String str, String str2) {
        return new File(li(str), str2);
    }

    public static File a(String str, String str2, boolean z, String str3, @Nullable JSONObject jSONObject) {
        File d = C0380d.d(str, str2, jSONObject);
        return (!z || TextUtils.isEmpty(str3)) ? d : new File(d, str3);
    }

    public static File D(String str, String str2, String str3) {
        return new File(bo(str, str2), aj.qH(str3));
    }

    public static boolean E(String str, String str2, String str3) {
        return v(D(str, str2, str3));
    }

    public static boolean bp(String str, String str2) {
        return new File(bo(str, str2), "app.json").exists();
    }

    public static boolean v(File file) {
        if (file == null || !file.exists()) {
            return false;
        }
        return new File(file, "app.json").exists();
    }

    /* renamed from: com.baidu.swan.apps.r.d$d  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0380d {
        public static f a(com.baidu.swan.apps.u.c.b bVar, com.baidu.swan.apps.aq.a.b bVar2, @Nullable JSONObject jSONObject) {
            if (bVar == null) {
                return null;
            }
            File a = d.a(bVar.getAppId(), bVar.getVersion(), bVar.ajA(), bVar.ajB(), jSONObject);
            if (!a.exists()) {
                File a2 = a(bVar.getAppId(), true, bVar2);
                if (a2 != null) {
                    if (!d.a(a2, w(a), bVar, bVar2)) {
                        com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "小程序bundle解压失败!").showToast();
                        com.baidu.swan.apps.an.a qm = new com.baidu.swan.apps.an.a().bJ(5L).bK(7L).qm("小程序bundle解压失败! for release");
                        com.baidu.swan.apps.an.e.avX().g(qm);
                        if (bVar2 == null || bVar2.cSE != null) {
                            return null;
                        }
                        bVar2.cSE = qm;
                        return null;
                    }
                } else {
                    com.baidu.swan.apps.process.messaging.client.a.apG().a(8, new SwanAppDeleteInfo(bVar.getAppId(), 1).fv(5));
                    h.b(new com.baidu.swan.apps.statistic.a.d().pu(h.ho(bVar.getAppFrameType())).f(new com.baidu.swan.apps.an.a().bJ(5L).bK(31L).qm("小程序zip和bundle不存在，兜底重置")).a(bVar));
                    if (d.DEBUG) {
                        Log.w("SwanAppBundleHelper", "20050004：reset aiapps");
                        return null;
                    }
                    return null;
                }
            }
            br(bVar.getAppId(), bVar.getVersion());
            f fVar = new f();
            File file = new File(a, "app.json");
            SwanAppConfigData m = SwanAppConfigData.m(d.u(file), a);
            if (m != null) {
                fVar.cnk = bq(bVar.getAppId(), bVar.getVersion()).getPath() + File.separator;
                fVar.cnl = m;
                com.baidu.swan.apps.ad.b.a.a(m, true);
                com.baidu.swan.apps.ad.g.b.e(m);
                if (d.DEBUG) {
                    Log.d("SwanAppBundleHelper", "configFile path: " + file.getPath());
                    Log.d("SwanAppBundleHelper", "configFile exist: " + file.exists());
                    Log.d("SwanAppBundleHelper", "info.mAppBundlePath path: " + fVar.cnk);
                    Log.d("SwanAppBundleHelper", "launchInfo.swanCoreVersion.swanCorePath: " + bVar.adQ().swanCorePath);
                }
                return fVar;
            }
            return null;
        }

        public static File w(File file) {
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }

        public static File bq(String str, String str2) {
            return d(str, str2, null);
        }

        public static File d(String str, String str2, @Nullable JSONObject jSONObject) {
            if (j.pr(str2)) {
                j.h(str, str2, jSONObject);
            }
            return new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "aiapps_folder" + File.separator + str, str2);
        }

        public static void lj(String str) {
            if (!TextUtils.isEmpty(str)) {
                File N = N(str, false);
                if (N != null) {
                    com.baidu.swan.d.d.deleteFile(N);
                }
                com.baidu.swan.d.d.deleteFile(new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "aiapps_folder" + File.separator + str));
            }
        }

        public static void br(String str, String str2) {
            File[] listFiles;
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && (listFiles = new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "aiapps_folder", str).listFiles(new FileFilter() { // from class: com.baidu.swan.apps.r.d.d.1
                @Override // java.io.FileFilter
                public boolean accept(File file) {
                    return file.isDirectory() && TextUtils.isDigitsOnly(file.getName());
                }
            })) != null && listFiles.length > 0) {
                for (File file : listFiles) {
                    if (bs(str2, file.getName())) {
                        if (d.DEBUG) {
                            Log.i("SwanAppBundleHelper", "删除低版本文件夹：" + file.getAbsolutePath());
                        }
                        com.baidu.swan.pms.database.a.aKS().cO(str, file.getName());
                        com.baidu.swan.d.d.deleteFile(file);
                    }
                }
            }
        }

        @Nullable
        public static File N(String str, boolean z) {
            return a(str, z, (com.baidu.swan.apps.aq.a.b) null);
        }

        @Nullable
        public static File a(@Nullable String str, boolean z, @Nullable com.baidu.swan.apps.aq.a.b bVar) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            File ahd = ahd();
            File file = new File(ahd, str + ".aiapps");
            if (file.exists() && file.isFile()) {
                return file;
            }
            if (d.DEBUG && z) {
                com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), ahd.getPath() + " 没有小程序包!").showToast();
            }
            if (bVar != null) {
                com.baidu.swan.apps.an.a qm = new com.baidu.swan.apps.an.a().bJ(5L).bK(4L).qm("没有小程序包! for release, no such bundle file");
                com.baidu.swan.apps.an.e.avX().g(qm);
                bVar.cSE = qm;
                return null;
            }
            return null;
        }

        public static File ahd() {
            File file = new File(AppRuntime.getAppContext().getFilesDir(), "swan_zip");
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }

        private static boolean bs(String str, String str2) {
            if (d.DEBUG) {
                Log.i("SwanAppBundleHelper", "curVersion:" + str + ",targetVersion:" + str2);
            }
            try {
                return bt(str, str2) > 0;
            } catch (IllegalArgumentException e) {
                if (d.DEBUG) {
                    Log.e("SwanAppBundleHelper", "比较版本号Exception：" + e.getMessage());
                    return false;
                }
                return false;
            }
        }

        private static long bt(String str, String str2) throws IllegalArgumentException {
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
        new com.baidu.swan.apps.k.a().a(cVar, a.Yg().getPath() + File.separator + System.currentTimeMillis() + ".aibundle", bVar);
    }

    public static void a(String str, b bVar) {
        c cVar = new c();
        cVar.mDownloadUrl = str;
        com.baidu.swan.apps.swancore.b.a.afi();
        new com.baidu.swan.apps.k.a().a(cVar, com.baidu.swan.apps.swancore.b.a.afj().getPath(), bVar);
    }

    public static void b(String str, b bVar) {
        c cVar = new c();
        cVar.mDownloadUrl = str;
        com.baidu.swan.apps.extcore.c.b.afi();
        new com.baidu.swan.apps.k.a().a(cVar, com.baidu.swan.apps.extcore.c.b.afj().getPath(), bVar);
    }

    /* loaded from: classes7.dex */
    public static class a {
        /* JADX WARN: Removed duplicated region for block: B:19:0x00b2  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static f a(com.baidu.swan.apps.u.c.b bVar, com.baidu.swan.apps.aq.a.b bVar2) {
            f fVar = null;
            File a = a(bVar2);
            if (a != null) {
                com.baidu.swan.apps.runtime.e arv = com.baidu.swan.apps.runtime.e.arv();
                if (arv == null) {
                    if (!d.a(a, XL(), bVar, bVar2)) {
                        com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "小程序bundle解压失败!").showToast();
                        com.baidu.swan.apps.an.a qm = new com.baidu.swan.apps.an.a().bJ(5L).bK(7L).qm("小程序bundle解压失败! for debug");
                        com.baidu.swan.apps.an.e.avX().g(qm);
                        if (bVar2 != null && bVar2.cSE == null) {
                            bVar2.cSE = qm;
                        }
                    }
                    fVar = new f();
                    File ahc = ahc();
                    File file = new File(ahc, "app.json");
                    SwanAppConfigData m = SwanAppConfigData.m(com.baidu.swan.d.d.readFileData(file), ahc);
                    fVar.cnk = ahc.getPath() + File.separator;
                    fVar.cnl = m;
                    com.baidu.swan.apps.ad.b.a.a(m, true);
                    com.baidu.swan.apps.ad.g.b.e(m);
                    if (d.DEBUG) {
                    }
                } else {
                    String string = arv.arH().getString("installed_debug_bundle_md5", "");
                    String md5 = com.baidu.swan.d.e.toMd5(a, false);
                    if (!TextUtils.equals(string, md5)) {
                        if (!d.a(a, XL(), bVar, bVar2)) {
                            com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "小程序bundle解压失败!").showToast();
                            com.baidu.swan.apps.an.a qm2 = new com.baidu.swan.apps.an.a().bJ(5L).bK(7L).qm("小程序bundle解压失败! for debug");
                            com.baidu.swan.apps.an.e.avX().g(qm2);
                            if (bVar2 != null && bVar2.cSE == null) {
                                bVar2.cSE = qm2;
                            }
                        } else {
                            arv.arH().putString("installed_debug_bundle_md5", md5);
                        }
                    }
                    fVar = new f();
                    File ahc2 = ahc();
                    File file2 = new File(ahc2, "app.json");
                    SwanAppConfigData m2 = SwanAppConfigData.m(com.baidu.swan.d.d.readFileData(file2), ahc2);
                    fVar.cnk = ahc2.getPath() + File.separator;
                    fVar.cnl = m2;
                    com.baidu.swan.apps.ad.b.a.a(m2, true);
                    com.baidu.swan.apps.ad.g.b.e(m2);
                    if (d.DEBUG) {
                        Log.d("SwanAppBundleHelper", "configFile path: " + file2.getPath());
                        Log.d("SwanAppBundleHelper", "configFile exist: " + file2.exists());
                        Log.d("SwanAppBundleHelper", "info.mAppBundlePath path: " + fVar.cnk);
                        Log.d("SwanAppBundleHelper", "launchInfo.swanCoreVersion.swanCorePath: " + bVar.adQ().swanCorePath);
                    }
                }
            }
            return fVar;
        }

        public static File ahc() {
            return XL();
        }

        public static File XL() {
            File file = new File(AppRuntime.getAppContext().getFilesDir(), "debug_aiapps_bundle");
            file.mkdirs();
            return file;
        }

        public static File a(com.baidu.swan.apps.aq.a.b bVar) {
            File Yg = Yg();
            File[] listFiles = Yg.listFiles();
            if (listFiles == null || listFiles.length == 0) {
                com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), Yg.getPath() + " 没有测试程序包!").showToast();
                com.baidu.swan.apps.an.a qm = new com.baidu.swan.apps.an.a().bJ(5L).bK(4L).qm("没有小程序包! for debug, bundle files are empty");
                com.baidu.swan.apps.an.e.avX().g(qm);
                if (bVar != null) {
                    bVar.cSE = qm;
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

        public static File Yg() {
            File file = new File(com.baidu.swan.apps.u.a.a.getStorageList().get(0).mPath, "/aiapps_debug/");
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }
    }

    /* loaded from: classes7.dex */
    public static class e {
        public static f d(com.baidu.swan.apps.u.c.b bVar) {
            File XL = XL();
            com.baidu.swan.apps.console.debugger.a.d.XR().ji("unzipstart");
            d.a(Yf(), XL, bVar);
            com.baidu.swan.apps.console.debugger.a.d.XR().ji("unzipend");
            f fVar = new f();
            File file = new File(XL, "app.json");
            SwanAppConfigData m = SwanAppConfigData.m(com.baidu.swan.d.d.readFileData(file), XL);
            fVar.cnk = XL.getPath() + File.separator;
            fVar.cnl = m;
            com.baidu.swan.apps.ad.b.a.a(m, true);
            com.baidu.swan.apps.ad.g.b.e(m);
            if (d.DEBUG) {
                Log.d("SwanAppBundleHelper", "configFile path: " + file.getPath());
                Log.d("SwanAppBundleHelper", "configFile exist: " + file.exists());
                Log.d("SwanAppBundleHelper", "info.mAppBundlePath path: " + fVar.cnk);
            }
            return fVar;
        }

        public static File XL() {
            File file = new File(AppRuntime.getAppContext().getFilesDir(), "aiapps_remote_debug_folder");
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }

        public static File Yf() {
            return new File(Yg(), "remote_debug.aiapps");
        }

        public static File Yg() {
            File file = new File(AppRuntime.getAppContext().getFilesDir(), "aiapps_remote_debug_zip");
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }
    }
}
