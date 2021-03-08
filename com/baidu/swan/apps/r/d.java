package com.baidu.swan.apps.r;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.ao.ai;
import com.baidu.swan.apps.ao.ak;
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
/* loaded from: classes8.dex */
public class d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static ExecutorService dgo = Executors.newSingleThreadExecutor();

    /* loaded from: classes8.dex */
    public interface b {
        void fo(int i);

        void onFailed();

        void onSuccess();
    }

    /* loaded from: classes8.dex */
    public static class c {
        public String mAppId;
        public String mDownloadUrl;
    }

    /* loaded from: classes8.dex */
    public static class f extends com.baidu.swan.apps.r.a {
        public String dgs;
        public SwanAppConfigData dgt;
    }

    public static void a(final com.baidu.swan.apps.u.c.b bVar, final com.baidu.swan.apps.r.b bVar2) {
        String ate;
        final JSONObject jSONObject = null;
        if (bVar == null || j.sT(bVar.getVersion())) {
            jSONObject = new JSONObject();
            String stackTrace = ak.getStackTrace();
            if (bVar == null) {
                ate = "null";
            } else {
                try {
                    ate = bVar.ate();
                } catch (JSONException e2) {
                    if (DEBUG) {
                        e2.printStackTrace();
                    }
                }
            }
            jSONObject.put("originLaunchInfo", ate);
            jSONObject.put("stackTraceBefore", stackTrace);
        }
        dgo.execute(new Runnable() { // from class: com.baidu.swan.apps.r.d.1
            @Override // java.lang.Runnable
            public void run() {
                f a2;
                com.baidu.swan.apps.ao.a.b bVar3 = new com.baidu.swan.apps.ao.a.b();
                if (com.baidu.swan.apps.ad.a.a.j(com.baidu.swan.apps.u.c.b.this)) {
                    a2 = com.baidu.swan.apps.ad.a.a.a(com.baidu.swan.apps.u.c.b.this, bVar3);
                } else {
                    a2 = C0452d.a(com.baidu.swan.apps.u.c.b.this, bVar3, jSONObject);
                }
                if (a2 == null || a2.dgt == null || a2.dgt.dGq == null) {
                    com.baidu.swan.apps.al.a aVar = bVar3.dRe;
                    if (aVar == null) {
                        aVar = new com.baidu.swan.apps.al.a().db(5L).dc(20L).tO("小程序loadbundle出错，loadinfo为空或者页面配置空 ");
                    }
                    h.b(new com.baidu.swan.apps.statistic.a.d().sW(h.jv(com.baidu.swan.apps.u.c.b.this != null ? com.baidu.swan.apps.u.c.b.this.getAppFrameType() : 0)).i(aVar).sZ("appjson_config_invalid").a(com.baidu.swan.apps.u.c.b.this));
                }
                bVar2.a(0, a2);
            }
        });
    }

    public static File awP() {
        return new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "aiapps_folder");
    }

    public static String awQ() {
        return AppRuntime.getAppContext().getFilesDir() + File.separator + "aiapps_folder";
    }

    public static File awR() {
        return new File(AppRuntime.getAppContext().getFilesDir(), "swan_plugin_workspace");
    }

    public static File oB(String str) {
        if (TextUtils.isEmpty(str)) {
            if (DEBUG) {
                throw new IllegalArgumentException("plugin name can't be empty");
            }
            return null;
        }
        return new File(awR(), str);
    }

    public static File bI(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            if (DEBUG) {
                throw new IllegalArgumentException("plugin name or version can't be empty");
            }
            return null;
        }
        return new File(oB(str), str2);
    }

    public static boolean a(File file, File file2, com.baidu.swan.apps.u.c.b bVar) {
        return a(file, file2, bVar, null);
    }

    public static synchronized String v(@NonNull File file) {
        String str;
        synchronized (d.class) {
            if (file == null) {
                str = "";
            } else {
                String path = file.getPath();
                if (DEBUG) {
                    Log.d("SwanAppBundleHelper", "getConfigContent path: " + path);
                }
                str = (String) com.baidu.swan.apps.core.turbo.c.asd().m(path, "");
                if (TextUtils.isEmpty(str)) {
                    if (DEBUG) {
                        Log.d("SwanAppBundleHelper", "getConfigContent read start: " + path);
                    }
                    str = com.baidu.swan.c.d.readFileData(file);
                    com.baidu.swan.apps.core.turbo.c.asd().n(path, str);
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
            b.a aIR = eVar.aIR();
            file = a(eVar.getAppId(), aIR.getVersion(), aIR.azx(), aIR.azy(), null);
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
                SwanAppConfigData A = com.baidu.swan.apps.u.a.a.A(d);
                if (A != null) {
                    eVar.g(A);
                }
                if (com.baidu.swan.apps.performance.b.c.aEy()) {
                    com.baidu.swan.apps.ac.b.a.b(A, true);
                    com.baidu.swan.apps.ac.g.b.f(A);
                } else {
                    com.baidu.swan.apps.ac.b.a.a(A, true);
                    com.baidu.swan.apps.ac.g.b.e(A);
                }
            } else {
                z = false;
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean a(File file, File file2, com.baidu.swan.apps.u.c.b bVar, com.baidu.swan.apps.ao.a.b bVar2) {
        boolean unzipFile;
        int i = 0;
        if (file == null || file2 == null) {
            return false;
        }
        if (!file.exists() || file.length() == 0) {
            com.baidu.swan.apps.al.a tO = new com.baidu.swan.apps.al.a().db(5L).dc(4L).tO("小程序bundle文件不存在或者空文件! ");
            if (bVar2 != null) {
                bVar2.dRe = tO;
                return false;
            }
            return false;
        }
        i.aEe().f(new UbcFlowEvent("package_start_unzip"));
        long currentTimeMillis = System.currentTimeMillis();
        a.b y = com.baidu.swan.apps.r.a.a.y(file);
        if (y.type != -1) {
            unzipFile = com.baidu.swan.apps.r.a.a.a(y.dgD, file2, y.type).isSuccess;
            i = y.type;
        } else {
            unzipFile = com.baidu.swan.c.d.unzipFile(file.getPath(), file2.getPath());
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        if (DEBUG) {
            com.baidu.swan.apps.r.a.a.hM((int) (currentTimeMillis2 - currentTimeMillis));
        }
        if (!unzipFile) {
            com.baidu.swan.apps.al.a tO2 = new com.baidu.swan.apps.al.a().db(5L).dc(7L).tO("小程序bundle解压失败! PkgType=" + i);
            if (bVar2 != null) {
                bVar2.dRe = tO2;
            }
        }
        i.aEe().f(new UbcFlowEvent("package_end_unzip")).cg("app_package_version", String.valueOf(i));
        return unzipFile;
    }

    private static File oC(String str) {
        return new File(awP(), str);
    }

    private static File bJ(String str, String str2) {
        return new File(oC(str), str2);
    }

    public static File a(String str, String str2, boolean z, String str3, @Nullable JSONObject jSONObject) {
        File d = C0452d.d(str, str2, jSONObject);
        return (!z || TextUtils.isEmpty(str3)) ? d : new File(d, str3);
    }

    public static File S(String str, String str2, String str3) {
        return new File(bJ(str, str2), ai.ul(str3));
    }

    public static boolean T(String str, String str2, String str3) {
        return w(S(str, str2, str3));
    }

    public static boolean bK(String str, String str2) {
        boolean exists = new File(bJ(str, str2), "app.json").exists();
        com.baidu.swan.apps.console.c.bl("SwanAppBundleHelper", "isAppJsonExist = " + exists);
        return exists;
    }

    public static boolean w(File file) {
        if (file == null || !file.exists()) {
            return false;
        }
        boolean exists = new File(file, "app.json").exists();
        com.baidu.swan.apps.console.c.bl("SwanAppBundleHelper", "isAppJsonExist = " + exists);
        return exists;
    }

    /* renamed from: com.baidu.swan.apps.r.d$d  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0452d {
        public static f a(com.baidu.swan.apps.u.c.b bVar, com.baidu.swan.apps.ao.a.b bVar2, @Nullable JSONObject jSONObject) {
            if (bVar == null) {
                return null;
            }
            File a2 = d.a(bVar.getAppId(), bVar.getVersion(), bVar.azx(), bVar.azy(), jSONObject);
            if (!a2.exists()) {
                File a3 = a(bVar.getAppId(), true, bVar2);
                if (a3 != null) {
                    if (!d.a(a3, x(a2), bVar, bVar2)) {
                        com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "小程序bundle解压失败!").aIv();
                        com.baidu.swan.apps.al.a tO = new com.baidu.swan.apps.al.a().db(5L).dc(7L).tO("小程序bundle解压失败! for release");
                        com.baidu.swan.apps.al.e.aNm().j(tO);
                        if (bVar2 == null || bVar2.dRe != null) {
                            return null;
                        }
                        bVar2.dRe = tO;
                        return null;
                    }
                } else {
                    com.baidu.swan.apps.process.messaging.client.a.aFM().a(8, new SwanAppDeleteInfo(bVar.getAppId(), 1).hg(5));
                    h.b(new com.baidu.swan.apps.statistic.a.d().sW(h.jv(bVar.getAppFrameType())).i(new com.baidu.swan.apps.al.a().db(5L).dc(31L).tO("小程序zip和bundle不存在，兜底重置")).a(bVar));
                    if (d.DEBUG) {
                        Log.w("SwanAppBundleHelper", "20050004：reset aiapps");
                        return null;
                    }
                    return null;
                }
            }
            bM(bVar.getAppId(), bVar.getVersion());
            f fVar = new f();
            File file = new File(a2, "app.json");
            SwanAppConfigData o = SwanAppConfigData.o(d.v(file), a2);
            if (o != null) {
                fVar.dgs = bL(bVar.getAppId(), bVar.getVersion()).getPath() + File.separator;
                fVar.dgt = o;
                if (com.baidu.swan.apps.performance.b.c.aEy()) {
                    com.baidu.swan.apps.ac.b.a.b(o, true);
                    com.baidu.swan.apps.ac.g.b.f(o);
                } else {
                    com.baidu.swan.apps.ac.b.a.a(o, true);
                    com.baidu.swan.apps.ac.g.b.e(o);
                }
                com.baidu.swan.apps.console.c.bl("SwanAppBundleHelper", "configFile path: " + file.getPath() + "configFile exist: " + file.exists() + "info.mAppBundlePath path: " + fVar.dgs);
                return fVar;
            }
            return null;
        }

        public static File x(File file) {
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }

        public static File bL(String str, String str2) {
            return d(str, str2, null);
        }

        public static File d(String str, String str2, @Nullable JSONObject jSONObject) {
            if (j.sT(str2)) {
                j.h(str, str2, jSONObject);
            }
            return new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "aiapps_folder" + File.separator + str, str2);
        }

        public static void oD(String str) {
            if (!TextUtils.isEmpty(str)) {
                File Y = Y(str, false);
                if (Y != null) {
                    com.baidu.swan.c.d.deleteFile(Y);
                }
                com.baidu.swan.c.d.deleteFile(new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "aiapps_folder" + File.separator + str));
            }
        }

        public static void bM(String str, String str2) {
            File[] listFiles;
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && (listFiles = new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "aiapps_folder", str).listFiles(new FileFilter() { // from class: com.baidu.swan.apps.r.d.d.1
                @Override // java.io.FileFilter
                public boolean accept(File file) {
                    return file.isDirectory() && TextUtils.isDigitsOnly(file.getName());
                }
            })) != null && listFiles.length > 0) {
                for (File file : listFiles) {
                    if (bN(str2, file.getName())) {
                        if (d.DEBUG) {
                            Log.i("SwanAppBundleHelper", "删除低版本文件夹：" + file.getAbsolutePath());
                        }
                        com.baidu.swan.pms.database.a.bcx().mo31do(str, file.getName());
                        com.baidu.swan.c.d.deleteFile(file);
                    }
                }
            }
        }

        @Nullable
        public static File Y(String str, boolean z) {
            return a(str, z, (com.baidu.swan.apps.ao.a.b) null);
        }

        @Nullable
        public static File a(@Nullable String str, boolean z, @Nullable com.baidu.swan.apps.ao.a.b bVar) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            File awT = awT();
            File file = new File(awT, str + ".aiapps");
            if (file.exists() && file.isFile()) {
                return file;
            }
            if (d.DEBUG && z) {
                com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), awT.getPath() + " 没有小程序包!").aIv();
            }
            if (bVar != null) {
                com.baidu.swan.apps.al.a tO = new com.baidu.swan.apps.al.a().db(5L).dc(4L).tO("没有小程序包! for release, no such bundle file");
                com.baidu.swan.apps.al.e.aNm().j(tO);
                bVar.dRe = tO;
                return null;
            }
            return null;
        }

        public static File awT() {
            File file = new File(AppRuntime.getAppContext().getFilesDir(), "swan_zip");
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }

        private static boolean bN(String str, String str2) {
            if (d.DEBUG) {
                Log.i("SwanAppBundleHelper", "curVersion:" + str + ",targetVersion:" + str2);
            }
            try {
                return bO(str, str2) > 0;
            } catch (IllegalArgumentException e) {
                if (d.DEBUG) {
                    Log.e("SwanAppBundleHelper", "比较版本号Exception：" + e.getMessage());
                    return false;
                }
                return false;
            }
        }

        private static long bO(String str, String str2) throws IllegalArgumentException {
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
        new com.baidu.swan.apps.l.a().a(cVar, a.amv().getPath() + File.separator + System.currentTimeMillis() + ".aibundle", bVar);
    }

    public static void a(String str, b bVar) {
        c cVar = new c();
        cVar.mDownloadUrl = str;
        com.baidu.swan.apps.swancore.b.a.auG();
        new com.baidu.swan.apps.l.a().a(cVar, com.baidu.swan.apps.swancore.b.a.auH().getPath(), bVar);
    }

    public static void b(String str, b bVar) {
        c cVar = new c();
        cVar.mDownloadUrl = str;
        com.baidu.swan.apps.extcore.c.b.auG();
        new com.baidu.swan.apps.l.a().a(cVar, com.baidu.swan.apps.extcore.c.b.auH().getPath(), bVar);
    }

    /* loaded from: classes8.dex */
    public static class a {
        public static f a(com.baidu.swan.apps.u.c.b bVar, com.baidu.swan.apps.ao.a.b bVar2) {
            File a2 = a(bVar2);
            if (a2 == null) {
                return null;
            }
            com.baidu.swan.apps.runtime.e aIN = com.baidu.swan.apps.runtime.e.aIN();
            if (aIN == null) {
                if (!d.a(a2, ama(), bVar, bVar2)) {
                    com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "小程序bundle解压失败!").aIv();
                    com.baidu.swan.apps.al.a tO = new com.baidu.swan.apps.al.a().db(5L).dc(7L).tO("小程序bundle解压失败! for debug");
                    com.baidu.swan.apps.al.e.aNm().j(tO);
                    if (bVar2 == null || bVar2.dRe != null) {
                        return null;
                    }
                    bVar2.dRe = tO;
                    return null;
                }
            } else {
                String string = aIN.aIZ().getString("installed_debug_bundle_md5", "");
                String e = com.baidu.swan.c.e.e(a2, false);
                if (!TextUtils.equals(string, e)) {
                    if (!d.a(a2, ama(), bVar, bVar2)) {
                        com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "小程序bundle解压失败!").aIv();
                        com.baidu.swan.apps.al.a tO2 = new com.baidu.swan.apps.al.a().db(5L).dc(7L).tO("小程序bundle解压失败! for debug");
                        com.baidu.swan.apps.al.e.aNm().j(tO2);
                        if (bVar2 == null || bVar2.dRe != null) {
                            return null;
                        }
                        bVar2.dRe = tO2;
                        return null;
                    }
                    aIN.aIZ().putString("installed_debug_bundle_md5", e);
                }
            }
            f fVar = new f();
            File awS = awS();
            File file = new File(awS, "app.json");
            SwanAppConfigData o = SwanAppConfigData.o(com.baidu.swan.c.d.readFileData(file), awS);
            fVar.dgs = awS.getPath() + File.separator;
            fVar.dgt = o;
            com.baidu.swan.apps.ac.b.a.a(o, true);
            com.baidu.swan.apps.ac.g.b.e(o);
            com.baidu.swan.apps.console.c.bl("SwanAppBundleHelper", "configFile path: " + file.getPath() + "configFile exist: " + file.exists() + "info.mAppBundlePath path: " + fVar.dgs);
            return fVar;
        }

        public static File awS() {
            return ama();
        }

        public static File ama() {
            File file = new File(AppRuntime.getAppContext().getFilesDir(), "debug_aiapps_bundle");
            file.mkdirs();
            return file;
        }

        public static File a(com.baidu.swan.apps.ao.a.b bVar) {
            File amv = amv();
            File[] listFiles = amv.listFiles();
            if (listFiles == null || listFiles.length == 0) {
                com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), amv.getPath() + " 没有测试程序包!").aIv();
                com.baidu.swan.apps.al.a tO = new com.baidu.swan.apps.al.a().db(5L).dc(4L).tO("没有小程序包! for debug, bundle files are empty");
                com.baidu.swan.apps.al.e.aNm().j(tO);
                if (bVar != null) {
                    bVar.dRe = tO;
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

        public static File amv() {
            File file = new File(com.baidu.swan.apps.u.a.a.getStorageList().get(0).mPath, "/aiapps_debug/");
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }
    }

    /* loaded from: classes8.dex */
    public static class e {
        public static f d(com.baidu.swan.apps.u.c.b bVar) {
            File ama = ama();
            com.baidu.swan.apps.console.debugger.a.d.amg().me("unzipstart");
            d.a(amu(), ama, bVar);
            com.baidu.swan.apps.console.debugger.a.d.amg().me("unzipend");
            f fVar = new f();
            File file = new File(ama, "app.json");
            SwanAppConfigData o = SwanAppConfigData.o(com.baidu.swan.c.d.readFileData(file), ama);
            fVar.dgs = ama.getPath() + File.separator;
            fVar.dgt = o;
            com.baidu.swan.apps.ac.b.a.a(o, true);
            com.baidu.swan.apps.ac.g.b.e(o);
            com.baidu.swan.apps.console.c.bl("SwanAppBundleHelper", "configFile path: " + file.getPath() + "configFile exist: " + file.exists() + "info.mAppBundlePath path: " + fVar.dgs);
            return fVar;
        }

        public static File ama() {
            File file = new File(AppRuntime.getAppContext().getFilesDir(), "aiapps_remote_debug_folder");
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }

        public static File amu() {
            return new File(amv(), "remote_debug.aiapps");
        }

        public static File amv() {
            File file = new File(AppRuntime.getAppContext().getFilesDir(), "aiapps_remote_debug_zip");
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }
    }
}
