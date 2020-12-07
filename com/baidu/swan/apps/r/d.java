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
/* loaded from: classes25.dex */
public class d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static ExecutorService dcv = Executors.newSingleThreadExecutor();

    /* loaded from: classes25.dex */
    public interface b {
        void fu(int i);

        void onFailed();

        void onSuccess();
    }

    /* loaded from: classes25.dex */
    public static class c {
        public String mAppId;
        public String mDownloadUrl;
    }

    /* loaded from: classes25.dex */
    public static class f extends com.baidu.swan.apps.r.a {
        public SwanAppConfigData dcA;
        public String dcz;
    }

    public static void a(final com.baidu.swan.apps.u.c.b bVar, final com.baidu.swan.apps.r.b bVar2) {
        String ave;
        final JSONObject jSONObject = null;
        if (bVar == null || j.tH(bVar.getVersion())) {
            jSONObject = new JSONObject();
            String stackTrace = ak.getStackTrace();
            if (bVar == null) {
                ave = "null";
            } else {
                try {
                    ave = bVar.ave();
                } catch (JSONException e2) {
                    if (DEBUG) {
                        e2.printStackTrace();
                    }
                }
            }
            jSONObject.put("originLaunchInfo", ave);
            jSONObject.put("stackTraceBefore", stackTrace);
        }
        dcv.execute(new Runnable() { // from class: com.baidu.swan.apps.r.d.1
            @Override // java.lang.Runnable
            public void run() {
                f a2;
                com.baidu.swan.apps.ap.a.b bVar3 = new com.baidu.swan.apps.ap.a.b();
                if (com.baidu.swan.apps.ad.a.a.j(com.baidu.swan.apps.u.c.b.this)) {
                    a2 = com.baidu.swan.apps.ad.a.a.a(com.baidu.swan.apps.u.c.b.this, bVar3);
                } else {
                    a2 = C0474d.a(com.baidu.swan.apps.u.c.b.this, bVar3, jSONObject);
                }
                if (a2 == null || a2.dcA == null || a2.dcA.dyS == null) {
                    com.baidu.swan.apps.am.a aVar = bVar3.dJA;
                    if (aVar == null) {
                        aVar = new com.baidu.swan.apps.am.a().cU(5L).cV(20L).uC("小程序loadbundle出错，loadinfo为空或者页面配置空 ");
                    }
                    h.b(new com.baidu.swan.apps.statistic.a.d().tK(h.kS(com.baidu.swan.apps.u.c.b.this != null ? com.baidu.swan.apps.u.c.b.this.getAppFrameType() : 0)).i(aVar).tN("appjson_config_invalid").a(com.baidu.swan.apps.u.c.b.this));
                }
                bVar2.a(0, a2);
            }
        });
    }

    public static File ayQ() {
        return new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "aiapps_folder");
    }

    public static String ayR() {
        return AppRuntime.getAppContext().getFilesDir() + File.separator + "aiapps_folder";
    }

    public static File ayS() {
        return new File(AppRuntime.getAppContext().getFilesDir(), "swan_plugin_workspace");
    }

    public static File pu(String str) {
        if (TextUtils.isEmpty(str)) {
            if (DEBUG) {
                throw new IllegalArgumentException("plugin name can't be empty");
            }
            return null;
        }
        return new File(ayS(), str);
    }

    public static File bQ(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            if (DEBUG) {
                throw new IllegalArgumentException("plugin name or version can't be empty");
            }
            return null;
        }
        return new File(pu(str), str2);
    }

    public static boolean a(File file, File file2, com.baidu.swan.apps.u.c.b bVar) {
        return a(file, file2, bVar, null);
    }

    public static synchronized String x(@NonNull File file) {
        String str;
        synchronized (d.class) {
            if (file == null) {
                str = "";
            } else {
                String path = file.getPath();
                if (DEBUG) {
                    Log.d("SwanAppBundleHelper", "getConfigContent path: " + path);
                }
                str = (String) com.baidu.swan.apps.core.turbo.c.aue().n(path, "");
                if (TextUtils.isEmpty(str)) {
                    if (DEBUG) {
                        Log.d("SwanAppBundleHelper", "getConfigContent read start: " + path);
                    }
                    str = com.baidu.swan.c.d.readFileData(file);
                    com.baidu.swan.apps.core.turbo.c.aue().o(path, str);
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
            b.a aJY = eVar.aJY();
            file = a(eVar.getAppId(), aJY.getVersion(), aJY.aBy(), aJY.aBz(), null);
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
                SwanAppConfigData C = com.baidu.swan.apps.u.a.a.C(d);
                if (C != null) {
                    eVar.g(C);
                }
                if (com.baidu.swan.apps.performance.b.c.aGA()) {
                    com.baidu.swan.apps.ac.b.a.b(C, true);
                    com.baidu.swan.apps.ac.g.b.f(C);
                } else {
                    com.baidu.swan.apps.ac.b.a.a(C, true);
                    com.baidu.swan.apps.ac.g.b.e(C);
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
            com.baidu.swan.apps.am.a uC = new com.baidu.swan.apps.am.a().cU(5L).cV(4L).uC("小程序bundle文件不存在或者空文件! ");
            if (bVar2 != null) {
                bVar2.dJA = uC;
                return false;
            }
            return false;
        }
        i.aGg().f(new UbcFlowEvent("package_start_unzip"));
        long currentTimeMillis = System.currentTimeMillis();
        a.b A = com.baidu.swan.apps.r.a.a.A(file);
        if (A.type != -1) {
            unzipFile = com.baidu.swan.apps.r.a.a.a(A.dcK, file2, A.type).isSuccess;
            i = A.type;
        } else {
            unzipFile = com.baidu.swan.c.d.unzipFile(file.getPath(), file2.getPath());
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        if (DEBUG) {
            com.baidu.swan.apps.r.a.a.jt((int) (currentTimeMillis2 - currentTimeMillis));
        }
        if (!unzipFile) {
            com.baidu.swan.apps.am.a uC2 = new com.baidu.swan.apps.am.a().cU(5L).cV(7L).uC("小程序bundle解压失败! PkgType=" + i);
            if (bVar2 != null) {
                bVar2.dJA = uC2;
            }
        }
        i.aGg().f(new UbcFlowEvent("package_end_unzip")).co("app_package_version", String.valueOf(i));
        return unzipFile;
    }

    private static File pv(String str) {
        return new File(ayQ(), str);
    }

    private static File bR(String str, String str2) {
        return new File(pv(str), str2);
    }

    public static File a(String str, String str2, boolean z, String str3, @Nullable JSONObject jSONObject) {
        File d = C0474d.d(str, str2, jSONObject);
        return (!z || TextUtils.isEmpty(str3)) ? d : new File(d, str3);
    }

    public static File P(String str, String str2, String str3) {
        return new File(bR(str, str2), ai.uX(str3));
    }

    public static boolean Q(String str, String str2, String str3) {
        return y(P(str, str2, str3));
    }

    public static boolean bS(String str, String str2) {
        boolean exists = new File(bR(str, str2), "app.json").exists();
        com.baidu.swan.apps.console.c.bt("SwanAppBundleHelper", "isAppJsonExist = " + exists);
        return exists;
    }

    public static boolean y(File file) {
        if (file == null || !file.exists()) {
            return false;
        }
        boolean exists = new File(file, "app.json").exists();
        com.baidu.swan.apps.console.c.bt("SwanAppBundleHelper", "isAppJsonExist = " + exists);
        return exists;
    }

    /* renamed from: com.baidu.swan.apps.r.d$d  reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    public static class C0474d {
        public static f a(com.baidu.swan.apps.u.c.b bVar, com.baidu.swan.apps.ap.a.b bVar2, @Nullable JSONObject jSONObject) {
            if (bVar == null) {
                return null;
            }
            File a2 = d.a(bVar.getAppId(), bVar.getVersion(), bVar.aBy(), bVar.aBz(), jSONObject);
            if (!a2.exists()) {
                File a3 = a(bVar.getAppId(), true, bVar2);
                if (a3 != null) {
                    if (!d.a(a3, z(a2), bVar, bVar2)) {
                        com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "小程序bundle解压失败!").showToast();
                        com.baidu.swan.apps.am.a uC = new com.baidu.swan.apps.am.a().cU(5L).cV(7L).uC("小程序bundle解压失败! for release");
                        com.baidu.swan.apps.am.e.aOs().j(uC);
                        if (bVar2 == null || bVar2.dJA != null) {
                            return null;
                        }
                        bVar2.dJA = uC;
                        return null;
                    }
                } else {
                    com.baidu.swan.apps.process.messaging.client.a.aHO().a(8, new SwanAppDeleteInfo(bVar.getAppId(), 1).iN(5));
                    h.b(new com.baidu.swan.apps.statistic.a.d().tK(h.kS(bVar.getAppFrameType())).i(new com.baidu.swan.apps.am.a().cU(5L).cV(31L).uC("小程序zip和bundle不存在，兜底重置")).a(bVar));
                    if (d.DEBUG) {
                        Log.w("SwanAppBundleHelper", "20050004：reset aiapps");
                        return null;
                    }
                    return null;
                }
            }
            bU(bVar.getAppId(), bVar.getVersion());
            f fVar = new f();
            File file = new File(a2, "app.json");
            SwanAppConfigData l = SwanAppConfigData.l(d.x(file), a2);
            if (l != null) {
                fVar.dcz = bT(bVar.getAppId(), bVar.getVersion()).getPath() + File.separator;
                fVar.dcA = l;
                if (com.baidu.swan.apps.performance.b.c.aGA()) {
                    com.baidu.swan.apps.ac.b.a.b(l, true);
                    com.baidu.swan.apps.ac.g.b.f(l);
                } else {
                    com.baidu.swan.apps.ac.b.a.a(l, true);
                    com.baidu.swan.apps.ac.g.b.e(l);
                }
                com.baidu.swan.apps.console.c.bt("SwanAppBundleHelper", "configFile path: " + file.getPath() + "configFile exist: " + file.exists() + "info.mAppBundlePath path: " + fVar.dcz);
                return fVar;
            }
            return null;
        }

        public static File z(File file) {
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }

        public static File bT(String str, String str2) {
            return d(str, str2, null);
        }

        public static File d(String str, String str2, @Nullable JSONObject jSONObject) {
            if (j.tH(str2)) {
                j.h(str, str2, jSONObject);
            }
            return new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "aiapps_folder" + File.separator + str, str2);
        }

        public static void pw(String str) {
            if (!TextUtils.isEmpty(str)) {
                File Z = Z(str, false);
                if (Z != null) {
                    com.baidu.swan.c.d.deleteFile(Z);
                }
                com.baidu.swan.c.d.deleteFile(new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "aiapps_folder" + File.separator + str));
            }
        }

        public static void bU(String str, String str2) {
            File[] listFiles;
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && (listFiles = new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "aiapps_folder", str).listFiles(new FileFilter() { // from class: com.baidu.swan.apps.r.d.d.1
                @Override // java.io.FileFilter
                public boolean accept(File file) {
                    return file.isDirectory() && TextUtils.isDigitsOnly(file.getName());
                }
            })) != null && listFiles.length > 0) {
                for (File file : listFiles) {
                    if (bV(str2, file.getName())) {
                        if (d.DEBUG) {
                            Log.i("SwanAppBundleHelper", "删除低版本文件夹：" + file.getAbsolutePath());
                        }
                        com.baidu.swan.pms.database.a.bdF().dw(str, file.getName());
                        com.baidu.swan.c.d.deleteFile(file);
                    }
                }
            }
        }

        @Nullable
        public static File Z(String str, boolean z) {
            return a(str, z, (com.baidu.swan.apps.ap.a.b) null);
        }

        @Nullable
        public static File a(@Nullable String str, boolean z, @Nullable com.baidu.swan.apps.ap.a.b bVar) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            File ayU = ayU();
            File file = new File(ayU, str + ".aiapps");
            if (file.exists() && file.isFile()) {
                return file;
            }
            if (d.DEBUG && z) {
                com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), ayU.getPath() + " 没有小程序包!").showToast();
            }
            if (bVar != null) {
                com.baidu.swan.apps.am.a uC = new com.baidu.swan.apps.am.a().cU(5L).cV(4L).uC("没有小程序包! for release, no such bundle file");
                com.baidu.swan.apps.am.e.aOs().j(uC);
                bVar.dJA = uC;
                return null;
            }
            return null;
        }

        public static File ayU() {
            File file = new File(AppRuntime.getAppContext().getFilesDir(), "swan_zip");
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }

        private static boolean bV(String str, String str2) {
            if (d.DEBUG) {
                Log.i("SwanAppBundleHelper", "curVersion:" + str + ",targetVersion:" + str2);
            }
            try {
                return bW(str, str2) > 0;
            } catch (IllegalArgumentException e) {
                if (d.DEBUG) {
                    Log.e("SwanAppBundleHelper", "比较版本号Exception：" + e.getMessage());
                    return false;
                }
                return false;
            }
        }

        private static long bW(String str, String str2) throws IllegalArgumentException {
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
        new com.baidu.swan.apps.l.a().a(cVar, a.aoB().getPath() + File.separator + System.currentTimeMillis() + ".aibundle", bVar);
    }

    public static void a(String str, b bVar) {
        c cVar = new c();
        cVar.mDownloadUrl = str;
        com.baidu.swan.apps.swancore.b.a.awG();
        new com.baidu.swan.apps.l.a().a(cVar, com.baidu.swan.apps.swancore.b.a.awH().getPath(), bVar);
    }

    public static void b(String str, b bVar) {
        c cVar = new c();
        cVar.mDownloadUrl = str;
        com.baidu.swan.apps.extcore.c.b.awG();
        new com.baidu.swan.apps.l.a().a(cVar, com.baidu.swan.apps.extcore.c.b.awH().getPath(), bVar);
    }

    /* loaded from: classes25.dex */
    public static class a {
        public static f a(com.baidu.swan.apps.u.c.b bVar, com.baidu.swan.apps.ap.a.b bVar2) {
            File a2 = a(bVar2);
            if (a2 == null) {
                return null;
            }
            com.baidu.swan.apps.runtime.e aJU = com.baidu.swan.apps.runtime.e.aJU();
            if (aJU == null) {
                if (!d.a(a2, aog(), bVar, bVar2)) {
                    com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "小程序bundle解压失败!").showToast();
                    com.baidu.swan.apps.am.a uC = new com.baidu.swan.apps.am.a().cU(5L).cV(7L).uC("小程序bundle解压失败! for debug");
                    com.baidu.swan.apps.am.e.aOs().j(uC);
                    if (bVar2 == null || bVar2.dJA != null) {
                        return null;
                    }
                    bVar2.dJA = uC;
                    return null;
                }
            } else {
                String string = aJU.aKg().getString("installed_debug_bundle_md5", "");
                String md5 = com.baidu.swan.c.e.toMd5(a2, false);
                if (!TextUtils.equals(string, md5)) {
                    if (!d.a(a2, aog(), bVar, bVar2)) {
                        com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "小程序bundle解压失败!").showToast();
                        com.baidu.swan.apps.am.a uC2 = new com.baidu.swan.apps.am.a().cU(5L).cV(7L).uC("小程序bundle解压失败! for debug");
                        com.baidu.swan.apps.am.e.aOs().j(uC2);
                        if (bVar2 == null || bVar2.dJA != null) {
                            return null;
                        }
                        bVar2.dJA = uC2;
                        return null;
                    }
                    aJU.aKg().putString("installed_debug_bundle_md5", md5);
                }
            }
            f fVar = new f();
            File ayT = ayT();
            File file = new File(ayT, "app.json");
            SwanAppConfigData l = SwanAppConfigData.l(com.baidu.swan.c.d.readFileData(file), ayT);
            fVar.dcz = ayT.getPath() + File.separator;
            fVar.dcA = l;
            com.baidu.swan.apps.ac.b.a.a(l, true);
            com.baidu.swan.apps.ac.g.b.e(l);
            com.baidu.swan.apps.console.c.bt("SwanAppBundleHelper", "configFile path: " + file.getPath() + "configFile exist: " + file.exists() + "info.mAppBundlePath path: " + fVar.dcz);
            return fVar;
        }

        public static File ayT() {
            return aog();
        }

        public static File aog() {
            File file = new File(AppRuntime.getAppContext().getFilesDir(), "debug_aiapps_bundle");
            file.mkdirs();
            return file;
        }

        public static File a(com.baidu.swan.apps.ap.a.b bVar) {
            File aoB = aoB();
            File[] listFiles = aoB.listFiles();
            if (listFiles == null || listFiles.length == 0) {
                com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), aoB.getPath() + " 没有测试程序包!").showToast();
                com.baidu.swan.apps.am.a uC = new com.baidu.swan.apps.am.a().cU(5L).cV(4L).uC("没有小程序包! for debug, bundle files are empty");
                com.baidu.swan.apps.am.e.aOs().j(uC);
                if (bVar != null) {
                    bVar.dJA = uC;
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

        public static File aoB() {
            File file = new File(com.baidu.swan.apps.u.a.a.getStorageList().get(0).mPath, "/aiapps_debug/");
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }
    }

    /* loaded from: classes25.dex */
    public static class e {
        public static f d(com.baidu.swan.apps.u.c.b bVar) {
            File aog = aog();
            com.baidu.swan.apps.console.debugger.a.d.aom().mX("unzipstart");
            d.a(aoA(), aog, bVar);
            com.baidu.swan.apps.console.debugger.a.d.aom().mX("unzipend");
            f fVar = new f();
            File file = new File(aog, "app.json");
            SwanAppConfigData l = SwanAppConfigData.l(com.baidu.swan.c.d.readFileData(file), aog);
            fVar.dcz = aog.getPath() + File.separator;
            fVar.dcA = l;
            com.baidu.swan.apps.ac.b.a.a(l, true);
            com.baidu.swan.apps.ac.g.b.e(l);
            com.baidu.swan.apps.console.c.bt("SwanAppBundleHelper", "configFile path: " + file.getPath() + "configFile exist: " + file.exists() + "info.mAppBundlePath path: " + fVar.dcz);
            return fVar;
        }

        public static File aog() {
            File file = new File(AppRuntime.getAppContext().getFilesDir(), "aiapps_remote_debug_folder");
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }

        public static File aoA() {
            return new File(aoB(), "remote_debug.aiapps");
        }

        public static File aoB() {
            File file = new File(AppRuntime.getAppContext().getFilesDir(), "aiapps_remote_debug_zip");
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }
    }
}
