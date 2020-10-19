package com.baidu.swan.apps.r;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.ap.ai;
import com.baidu.swan.apps.ap.ak;
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
/* loaded from: classes10.dex */
public class d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static ExecutorService cIT = Executors.newSingleThreadExecutor();

    /* loaded from: classes10.dex */
    public interface b {
        void eX(int i);

        void onFailed();

        void onSuccess();
    }

    /* loaded from: classes10.dex */
    public static class c {
        public String mAppId;
        public String mDownloadUrl;
    }

    /* loaded from: classes10.dex */
    public static class f extends com.baidu.swan.apps.r.a {
        public String cIX;
        public SwanAppConfigData cIY;
    }

    public static void a(final com.baidu.swan.apps.u.c.b bVar, final com.baidu.swan.apps.r.b bVar2) {
        String aoi;
        final JSONObject jSONObject = null;
        if (bVar == null || j.sy(bVar.getVersion())) {
            jSONObject = new JSONObject();
            String aIB = ak.aIB();
            if (bVar == null) {
                aoi = "null";
            } else {
                try {
                    aoi = bVar.aoi();
                } catch (JSONException e2) {
                    if (DEBUG) {
                        e2.printStackTrace();
                    }
                }
            }
            jSONObject.put("originLaunchInfo", aoi);
            jSONObject.put("stackTraceBefore", aIB);
        }
        cIT.execute(new Runnable() { // from class: com.baidu.swan.apps.r.d.1
            @Override // java.lang.Runnable
            public void run() {
                f a2;
                com.baidu.swan.apps.ap.a.b bVar3 = new com.baidu.swan.apps.ap.a.b();
                if (com.baidu.swan.apps.ad.a.a.j(com.baidu.swan.apps.u.c.b.this)) {
                    a2 = com.baidu.swan.apps.ad.a.a.a(com.baidu.swan.apps.u.c.b.this, bVar3);
                } else {
                    a2 = C0438d.a(com.baidu.swan.apps.u.c.b.this, bVar3, jSONObject);
                }
                if (a2 == null || a2.cIY == null || a2.cIY.dfd == null) {
                    com.baidu.swan.apps.am.a aVar = bVar3.dpR;
                    if (aVar == null) {
                        aVar = new com.baidu.swan.apps.am.a().bX(5L).bY(20L).tt("小程序loadbundle出错，loadinfo为空或者页面配置空 ");
                    }
                    h.b(new com.baidu.swan.apps.statistic.a.d().sB(h.kd(com.baidu.swan.apps.u.c.b.this != null ? com.baidu.swan.apps.u.c.b.this.getAppFrameType() : 0)).i(aVar).sE("appjson_config_invalid").a(com.baidu.swan.apps.u.c.b.this));
                }
                bVar2.a(0, a2);
            }
        });
    }

    public static File arV() {
        return new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "aiapps_folder");
    }

    public static String arW() {
        return AppRuntime.getAppContext().getFilesDir() + File.separator + "aiapps_folder";
    }

    public static File arX() {
        return new File(AppRuntime.getAppContext().getFilesDir(), "swan_plugin_workspace");
    }

    public static File ol(String str) {
        if (TextUtils.isEmpty(str)) {
            if (DEBUG) {
                throw new IllegalArgumentException("plugin name can't be empty");
            }
            return null;
        }
        return new File(arX(), str);
    }

    public static File bD(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            if (DEBUG) {
                throw new IllegalArgumentException("plugin name or version can't be empty");
            }
            return null;
        }
        return new File(ol(str), str2);
    }

    public static boolean a(File file, File file2, com.baidu.swan.apps.u.c.b bVar) {
        return a(file, file2, bVar, null);
    }

    public static synchronized String y(@NonNull File file) {
        String str;
        synchronized (d.class) {
            if (file == null) {
                str = "";
            } else {
                String path = file.getPath();
                if (DEBUG) {
                    Log.d("SwanAppBundleHelper", "getConfigContent path: " + path);
                }
                str = (String) com.baidu.swan.apps.core.turbo.c.anj().o(path, "");
                if (TextUtils.isEmpty(str)) {
                    if (DEBUG) {
                        Log.d("SwanAppBundleHelper", "getConfigContent read start: " + path);
                    }
                    str = com.baidu.swan.c.d.readFileData(file);
                    com.baidu.swan.apps.core.turbo.c.anj().p(path, str);
                    if (DEBUG) {
                        Log.d("SwanAppBundleHelper", "getConfigContent read end: " + path);
                    }
                }
            }
        }
        return str;
    }

    private static File d(@NonNull com.baidu.swan.apps.runtime.e eVar) {
        File file = null;
        if (eVar != null) {
            b.a aDe = eVar.aDe();
            file = a(eVar.getAppId(), aDe.getVersion(), aDe.auD(), aDe.auE(), null);
            if (DEBUG) {
                Log.d("SwanAppBundleHelper", "sendLaunchEvent folderFile: " + file.getPath());
                Log.d("SwanAppBundleHelper", "sendLaunchEvent file exists: " + file.exists());
            }
        }
        return file;
    }

    public static synchronized boolean e(@NonNull com.baidu.swan.apps.runtime.e eVar) {
        boolean z = true;
        synchronized (d.class) {
            File d = d(eVar);
            if (d != null && d.exists()) {
                SwanAppConfigData D = com.baidu.swan.apps.u.a.a.D(d);
                if (D != null) {
                    eVar.g(D);
                }
                if (com.baidu.swan.apps.performance.b.c.azG()) {
                    com.baidu.swan.apps.ac.b.a.b(D, true);
                    com.baidu.swan.apps.ac.g.b.f(D);
                } else {
                    com.baidu.swan.apps.ac.b.a.a(D, true);
                    com.baidu.swan.apps.ac.g.b.e(D);
                }
            } else {
                z = false;
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean a(File file, File file2, com.baidu.swan.apps.u.c.b bVar, com.baidu.swan.apps.ap.a.b bVar2) {
        boolean unzipFile;
        int i = 0;
        if (file == null || file2 == null) {
            return false;
        }
        if (!file.exists() || file.length() == 0) {
            com.baidu.swan.apps.am.a tt = new com.baidu.swan.apps.am.a().bX(5L).bY(4L).tt("小程序bundle文件不存在或者空文件! ");
            if (bVar2 != null) {
                bVar2.dpR = tt;
                return false;
            }
            return false;
        }
        i.azm().f(new UbcFlowEvent("package_start_unzip"));
        long currentTimeMillis = System.currentTimeMillis();
        a.b B = com.baidu.swan.apps.r.a.a.B(file);
        if (B.type != -1) {
            unzipFile = com.baidu.swan.apps.r.a.a.a(B.cJi, file2, B.type).isSuccess;
            i = B.type;
        } else {
            unzipFile = com.baidu.swan.c.d.unzipFile(file.getPath(), file2.getPath());
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        if (DEBUG) {
            com.baidu.swan.apps.r.a.a.iE((int) (currentTimeMillis2 - currentTimeMillis));
        }
        if (!unzipFile) {
            com.baidu.swan.apps.am.a tt2 = new com.baidu.swan.apps.am.a().bX(5L).bY(7L).tt("小程序bundle解压失败! PkgType=" + i);
            if (bVar2 != null) {
                bVar2.dpR = tt2;
            }
        }
        i.azm().f(new UbcFlowEvent("package_end_unzip")).cb("app_package_version", String.valueOf(i));
        return unzipFile;
    }

    private static File om(String str) {
        return new File(arV(), str);
    }

    private static File bE(String str, String str2) {
        return new File(om(str), str2);
    }

    public static File a(String str, String str2, boolean z, String str3, @Nullable JSONObject jSONObject) {
        File d = C0438d.d(str, str2, jSONObject);
        return (!z || TextUtils.isEmpty(str3)) ? d : new File(d, str3);
    }

    public static File F(String str, String str2, String str3) {
        return new File(bE(str, str2), ai.tO(str3));
    }

    public static boolean G(String str, String str2, String str3) {
        return z(F(str, str2, str3));
    }

    public static boolean bF(String str, String str2) {
        boolean exists = new File(bE(str, str2), "app.json").exists();
        com.baidu.swan.apps.console.c.bg("SwanAppBundleHelper", "isAppJsonExist = " + exists);
        return exists;
    }

    public static boolean z(File file) {
        if (file == null || !file.exists()) {
            return false;
        }
        boolean exists = new File(file, "app.json").exists();
        com.baidu.swan.apps.console.c.bg("SwanAppBundleHelper", "isAppJsonExist = " + exists);
        return exists;
    }

    /* renamed from: com.baidu.swan.apps.r.d$d  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0438d {
        public static f a(com.baidu.swan.apps.u.c.b bVar, com.baidu.swan.apps.ap.a.b bVar2, @Nullable JSONObject jSONObject) {
            if (bVar == null) {
                return null;
            }
            File a2 = d.a(bVar.getAppId(), bVar.getVersion(), bVar.auD(), bVar.auE(), jSONObject);
            if (!a2.exists()) {
                File a3 = a(bVar.getAppId(), true, bVar2);
                if (a3 != null) {
                    if (!d.a(a3, A(a2), bVar, bVar2)) {
                        com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "小程序bundle解压失败!").showToast();
                        com.baidu.swan.apps.am.a tt = new com.baidu.swan.apps.am.a().bX(5L).bY(7L).tt("小程序bundle解压失败! for release");
                        com.baidu.swan.apps.am.e.aHz().j(tt);
                        if (bVar2 == null || bVar2.dpR != null) {
                            return null;
                        }
                        bVar2.dpR = tt;
                        return null;
                    }
                } else {
                    com.baidu.swan.apps.process.messaging.client.a.aAU().a(8, new SwanAppDeleteInfo(bVar.getAppId(), 1).hY(5));
                    h.b(new com.baidu.swan.apps.statistic.a.d().sB(h.kd(bVar.getAppFrameType())).i(new com.baidu.swan.apps.am.a().bX(5L).bY(31L).tt("小程序zip和bundle不存在，兜底重置")).a(bVar));
                    if (d.DEBUG) {
                        Log.w("SwanAppBundleHelper", "20050004：reset aiapps");
                        return null;
                    }
                    return null;
                }
            }
            bH(bVar.getAppId(), bVar.getVersion());
            f fVar = new f();
            File file = new File(a2, "app.json");
            SwanAppConfigData l = SwanAppConfigData.l(d.y(file), a2);
            if (l != null) {
                fVar.cIX = bG(bVar.getAppId(), bVar.getVersion()).getPath() + File.separator;
                fVar.cIY = l;
                if (com.baidu.swan.apps.performance.b.c.azG()) {
                    com.baidu.swan.apps.ac.b.a.b(l, true);
                    com.baidu.swan.apps.ac.g.b.f(l);
                } else {
                    com.baidu.swan.apps.ac.b.a.a(l, true);
                    com.baidu.swan.apps.ac.g.b.e(l);
                }
                com.baidu.swan.apps.console.c.bg("SwanAppBundleHelper", "configFile path: " + file.getPath() + "configFile exist: " + file.exists() + "info.mAppBundlePath path: " + fVar.cIX);
                return fVar;
            }
            return null;
        }

        public static File A(File file) {
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }

        public static File bG(String str, String str2) {
            return d(str, str2, null);
        }

        public static File d(String str, String str2, @Nullable JSONObject jSONObject) {
            if (j.sy(str2)) {
                j.h(str, str2, jSONObject);
            }
            return new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "aiapps_folder" + File.separator + str, str2);
        }

        public static void oo(String str) {
            if (!TextUtils.isEmpty(str)) {
                File W = W(str, false);
                if (W != null) {
                    com.baidu.swan.c.d.deleteFile(W);
                }
                com.baidu.swan.c.d.deleteFile(new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "aiapps_folder" + File.separator + str));
            }
        }

        public static void bH(String str, String str2) {
            File[] listFiles;
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && (listFiles = new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "aiapps_folder", str).listFiles(new FileFilter() { // from class: com.baidu.swan.apps.r.d.d.1
                @Override // java.io.FileFilter
                public boolean accept(File file) {
                    return file.isDirectory() && TextUtils.isDigitsOnly(file.getName());
                }
            })) != null && listFiles.length > 0) {
                for (File file : listFiles) {
                    if (bI(str2, file.getName())) {
                        if (d.DEBUG) {
                            Log.i("SwanAppBundleHelper", "删除低版本文件夹：" + file.getAbsolutePath());
                        }
                        com.baidu.swan.pms.database.a.aWO().dj(str, file.getName());
                        com.baidu.swan.c.d.deleteFile(file);
                    }
                }
            }
        }

        @Nullable
        public static File W(String str, boolean z) {
            return a(str, z, (com.baidu.swan.apps.ap.a.b) null);
        }

        @Nullable
        public static File a(@Nullable String str, boolean z, @Nullable com.baidu.swan.apps.ap.a.b bVar) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            File arZ = arZ();
            File file = new File(arZ, str + ".aiapps");
            if (file.exists() && file.isFile()) {
                return file;
            }
            if (d.DEBUG && z) {
                com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), arZ.getPath() + " 没有小程序包!").showToast();
            }
            if (bVar != null) {
                com.baidu.swan.apps.am.a tt = new com.baidu.swan.apps.am.a().bX(5L).bY(4L).tt("没有小程序包! for release, no such bundle file");
                com.baidu.swan.apps.am.e.aHz().j(tt);
                bVar.dpR = tt;
                return null;
            }
            return null;
        }

        public static File arZ() {
            File file = new File(AppRuntime.getAppContext().getFilesDir(), "swan_zip");
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }

        private static boolean bI(String str, String str2) {
            if (d.DEBUG) {
                Log.i("SwanAppBundleHelper", "curVersion:" + str + ",targetVersion:" + str2);
            }
            try {
                return bJ(str, str2) > 0;
            } catch (IllegalArgumentException e) {
                if (d.DEBUG) {
                    Log.e("SwanAppBundleHelper", "比较版本号Exception：" + e.getMessage());
                    return false;
                }
                return false;
            }
        }

        private static long bJ(String str, String str2) throws IllegalArgumentException {
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
        new com.baidu.swan.apps.l.a().a(cVar, a.ahH().getPath() + File.separator + System.currentTimeMillis() + ".aibundle", bVar);
    }

    public static void a(String str, b bVar) {
        c cVar = new c();
        cVar.mDownloadUrl = str;
        com.baidu.swan.apps.swancore.b.a.apL();
        new com.baidu.swan.apps.l.a().a(cVar, com.baidu.swan.apps.swancore.b.a.apM().getPath(), bVar);
    }

    public static void b(String str, b bVar) {
        c cVar = new c();
        cVar.mDownloadUrl = str;
        com.baidu.swan.apps.extcore.c.b.apL();
        new com.baidu.swan.apps.l.a().a(cVar, com.baidu.swan.apps.extcore.c.b.apM().getPath(), bVar);
    }

    /* loaded from: classes10.dex */
    public static class a {
        public static f a(com.baidu.swan.apps.u.c.b bVar, com.baidu.swan.apps.ap.a.b bVar2) {
            File a2 = a(bVar2);
            if (a2 == null) {
                return null;
            }
            com.baidu.swan.apps.runtime.e aDa = com.baidu.swan.apps.runtime.e.aDa();
            if (aDa == null) {
                if (!d.a(a2, ahm(), bVar, bVar2)) {
                    com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "小程序bundle解压失败!").showToast();
                    com.baidu.swan.apps.am.a tt = new com.baidu.swan.apps.am.a().bX(5L).bY(7L).tt("小程序bundle解压失败! for debug");
                    com.baidu.swan.apps.am.e.aHz().j(tt);
                    if (bVar2 == null || bVar2.dpR != null) {
                        return null;
                    }
                    bVar2.dpR = tt;
                    return null;
                }
            } else {
                String string = aDa.aDm().getString("installed_debug_bundle_md5", "");
                String md5 = com.baidu.swan.c.e.toMd5(a2, false);
                if (!TextUtils.equals(string, md5)) {
                    if (!d.a(a2, ahm(), bVar, bVar2)) {
                        com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "小程序bundle解压失败!").showToast();
                        com.baidu.swan.apps.am.a tt2 = new com.baidu.swan.apps.am.a().bX(5L).bY(7L).tt("小程序bundle解压失败! for debug");
                        com.baidu.swan.apps.am.e.aHz().j(tt2);
                        if (bVar2 == null || bVar2.dpR != null) {
                            return null;
                        }
                        bVar2.dpR = tt2;
                        return null;
                    }
                    aDa.aDm().putString("installed_debug_bundle_md5", md5);
                }
            }
            f fVar = new f();
            File arY = arY();
            File file = new File(arY, "app.json");
            SwanAppConfigData l = SwanAppConfigData.l(com.baidu.swan.c.d.readFileData(file), arY);
            fVar.cIX = arY.getPath() + File.separator;
            fVar.cIY = l;
            com.baidu.swan.apps.ac.b.a.a(l, true);
            com.baidu.swan.apps.ac.g.b.e(l);
            com.baidu.swan.apps.console.c.bg("SwanAppBundleHelper", "configFile path: " + file.getPath() + "configFile exist: " + file.exists() + "info.mAppBundlePath path: " + fVar.cIX);
            return fVar;
        }

        public static File arY() {
            return ahm();
        }

        public static File ahm() {
            File file = new File(AppRuntime.getAppContext().getFilesDir(), "debug_aiapps_bundle");
            file.mkdirs();
            return file;
        }

        public static File a(com.baidu.swan.apps.ap.a.b bVar) {
            File ahH = ahH();
            File[] listFiles = ahH.listFiles();
            if (listFiles == null || listFiles.length == 0) {
                com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), ahH.getPath() + " 没有测试程序包!").showToast();
                com.baidu.swan.apps.am.a tt = new com.baidu.swan.apps.am.a().bX(5L).bY(4L).tt("没有小程序包! for debug, bundle files are empty");
                com.baidu.swan.apps.am.e.aHz().j(tt);
                if (bVar != null) {
                    bVar.dpR = tt;
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

        public static File ahH() {
            File file = new File(com.baidu.swan.apps.u.a.a.getStorageList().get(0).mPath, "/aiapps_debug/");
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }
    }

    /* loaded from: classes10.dex */
    public static class e {
        public static f d(com.baidu.swan.apps.u.c.b bVar) {
            File ahm = ahm();
            com.baidu.swan.apps.console.debugger.a.d.ahs().lO("unzipstart");
            d.a(ahG(), ahm, bVar);
            com.baidu.swan.apps.console.debugger.a.d.ahs().lO("unzipend");
            f fVar = new f();
            File file = new File(ahm, "app.json");
            SwanAppConfigData l = SwanAppConfigData.l(com.baidu.swan.c.d.readFileData(file), ahm);
            fVar.cIX = ahm.getPath() + File.separator;
            fVar.cIY = l;
            com.baidu.swan.apps.ac.b.a.a(l, true);
            com.baidu.swan.apps.ac.g.b.e(l);
            com.baidu.swan.apps.console.c.bg("SwanAppBundleHelper", "configFile path: " + file.getPath() + "configFile exist: " + file.exists() + "info.mAppBundlePath path: " + fVar.cIX);
            return fVar;
        }

        public static File ahm() {
            File file = new File(AppRuntime.getAppContext().getFilesDir(), "aiapps_remote_debug_folder");
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }

        public static File ahG() {
            return new File(ahH(), "remote_debug.aiapps");
        }

        public static File ahH() {
            File file = new File(AppRuntime.getAppContext().getFilesDir(), "aiapps_remote_debug_zip");
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }
    }
}
