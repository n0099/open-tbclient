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
/* loaded from: classes3.dex */
public class d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static ExecutorService cwO = Executors.newSingleThreadExecutor();

    /* loaded from: classes3.dex */
    public interface b {
        void eO(int i);

        void onFailed();

        void onSuccess();
    }

    /* loaded from: classes3.dex */
    public static class c {
        public String mAppId;
        public String mDownloadUrl;
    }

    /* loaded from: classes3.dex */
    public static class f extends com.baidu.swan.apps.r.a {
        public String cwS;
        public SwanAppConfigData cwT;
    }

    public static void a(final com.baidu.swan.apps.u.c.b bVar, final com.baidu.swan.apps.r.b bVar2) {
        String alx;
        final JSONObject jSONObject = null;
        if (bVar == null || j.rL(bVar.getVersion())) {
            jSONObject = new JSONObject();
            String aFS = ak.aFS();
            if (bVar == null) {
                alx = "null";
            } else {
                try {
                    alx = bVar.alx();
                } catch (JSONException e2) {
                    if (DEBUG) {
                        e2.printStackTrace();
                    }
                }
            }
            jSONObject.put("originLaunchInfo", alx);
            jSONObject.put("stackTraceBefore", aFS);
        }
        cwO.execute(new Runnable() { // from class: com.baidu.swan.apps.r.d.1
            @Override // java.lang.Runnable
            public void run() {
                f a2;
                com.baidu.swan.apps.ap.a.b bVar3 = new com.baidu.swan.apps.ap.a.b();
                if (com.baidu.swan.apps.ad.a.a.j(com.baidu.swan.apps.u.c.b.this)) {
                    a2 = com.baidu.swan.apps.ad.a.a.a(com.baidu.swan.apps.u.c.b.this, bVar3);
                } else {
                    a2 = C0421d.a(com.baidu.swan.apps.u.c.b.this, bVar3, jSONObject);
                }
                if (a2 == null || a2.cwT == null || a2.cwT.cSV == null) {
                    com.baidu.swan.apps.am.a aVar = bVar3.ddJ;
                    if (aVar == null) {
                        aVar = new com.baidu.swan.apps.am.a().bP(5L).bQ(20L).sH("小程序loadbundle出错，loadinfo为空或者页面配置空 ");
                    }
                    h.b(new com.baidu.swan.apps.statistic.a.d().rO(h.jG(com.baidu.swan.apps.u.c.b.this != null ? com.baidu.swan.apps.u.c.b.this.getAppFrameType() : 0)).i(aVar).rR("appjson_config_invalid").a(com.baidu.swan.apps.u.c.b.this));
                }
                bVar2.a(0, a2);
            }
        });
    }

    public static File apk() {
        return new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "aiapps_folder");
    }

    public static String apl() {
        return AppRuntime.getAppContext().getFilesDir() + File.separator + "aiapps_folder";
    }

    public static File apm() {
        return new File(AppRuntime.getAppContext().getFilesDir(), "swan_plugin_workspace");
    }

    public static File ny(String str) {
        if (TextUtils.isEmpty(str)) {
            if (DEBUG) {
                throw new IllegalArgumentException("plugin name can't be empty");
            }
            return null;
        }
        return new File(apm(), str);
    }

    public static File by(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            if (DEBUG) {
                throw new IllegalArgumentException("plugin name or version can't be empty");
            }
            return null;
        }
        return new File(ny(str), str2);
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
                str = (String) com.baidu.swan.apps.core.turbo.c.aky().o(path, "");
                if (TextUtils.isEmpty(str)) {
                    if (DEBUG) {
                        Log.d("SwanAppBundleHelper", "getConfigContent read start: " + path);
                    }
                    str = com.baidu.swan.c.d.readFileData(file);
                    com.baidu.swan.apps.core.turbo.c.aky().p(path, str);
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
            b.a aAv = eVar.aAv();
            file = a(eVar.getAppId(), aAv.getVersion(), aAv.arR(), aAv.arS(), null);
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
                if (com.baidu.swan.apps.performance.b.c.awV()) {
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
    public static boolean a(File file, File file2, com.baidu.swan.apps.u.c.b bVar, com.baidu.swan.apps.ap.a.b bVar2) {
        boolean unzipFile;
        int i = 0;
        if (file == null || file2 == null) {
            return false;
        }
        if (!file.exists() || file.length() == 0) {
            com.baidu.swan.apps.am.a sH = new com.baidu.swan.apps.am.a().bP(5L).bQ(4L).sH("小程序bundle文件不存在或者空文件! ");
            if (bVar2 != null) {
                bVar2.ddJ = sH;
                return false;
            }
            return false;
        }
        i.awB().f(new UbcFlowEvent("package_start_unzip"));
        long currentTimeMillis = System.currentTimeMillis();
        a.b y = com.baidu.swan.apps.r.a.a.y(file);
        if (y.type != -1) {
            unzipFile = com.baidu.swan.apps.r.a.a.a(y.cxd, file2, y.type).isSuccess;
            i = y.type;
        } else {
            unzipFile = com.baidu.swan.c.d.unzipFile(file.getPath(), file2.getPath());
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        if (DEBUG) {
            com.baidu.swan.apps.r.a.a.ih((int) (currentTimeMillis2 - currentTimeMillis));
        }
        if (!unzipFile) {
            com.baidu.swan.apps.am.a sH2 = new com.baidu.swan.apps.am.a().bP(5L).bQ(7L).sH("小程序bundle解压失败! PkgType=" + i);
            if (bVar2 != null) {
                bVar2.ddJ = sH2;
            }
        }
        i.awB().f(new UbcFlowEvent("package_end_unzip")).bW("app_package_version", String.valueOf(i));
        return unzipFile;
    }

    private static File nz(String str) {
        return new File(apk(), str);
    }

    private static File bz(String str, String str2) {
        return new File(nz(str), str2);
    }

    public static File a(String str, String str2, boolean z, String str3, @Nullable JSONObject jSONObject) {
        File d = C0421d.d(str, str2, jSONObject);
        return (!z || TextUtils.isEmpty(str3)) ? d : new File(d, str3);
    }

    public static File E(String str, String str2, String str3) {
        return new File(bz(str, str2), ai.tc(str3));
    }

    public static boolean F(String str, String str2, String str3) {
        return w(E(str, str2, str3));
    }

    public static boolean bA(String str, String str2) {
        boolean exists = new File(bz(str, str2), "app.json").exists();
        com.baidu.swan.apps.console.c.bb("SwanAppBundleHelper", "isAppJsonExist = " + exists);
        return exists;
    }

    public static boolean w(File file) {
        if (file == null || !file.exists()) {
            return false;
        }
        boolean exists = new File(file, "app.json").exists();
        com.baidu.swan.apps.console.c.bb("SwanAppBundleHelper", "isAppJsonExist = " + exists);
        return exists;
    }

    /* renamed from: com.baidu.swan.apps.r.d$d  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0421d {
        public static f a(com.baidu.swan.apps.u.c.b bVar, com.baidu.swan.apps.ap.a.b bVar2, @Nullable JSONObject jSONObject) {
            if (bVar == null) {
                return null;
            }
            File a = d.a(bVar.getAppId(), bVar.getVersion(), bVar.arR(), bVar.arS(), jSONObject);
            if (!a.exists()) {
                File a2 = a(bVar.getAppId(), true, bVar2);
                if (a2 != null) {
                    if (!d.a(a2, x(a), bVar, bVar2)) {
                        com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "小程序bundle解压失败!").showToast();
                        com.baidu.swan.apps.am.a sH = new com.baidu.swan.apps.am.a().bP(5L).bQ(7L).sH("小程序bundle解压失败! for release");
                        com.baidu.swan.apps.am.e.aEQ().j(sH);
                        if (bVar2 == null || bVar2.ddJ != null) {
                            return null;
                        }
                        bVar2.ddJ = sH;
                        return null;
                    }
                } else {
                    com.baidu.swan.apps.process.messaging.client.a.ayl().a(8, new SwanAppDeleteInfo(bVar.getAppId(), 1).hB(5));
                    h.b(new com.baidu.swan.apps.statistic.a.d().rO(h.jG(bVar.getAppFrameType())).i(new com.baidu.swan.apps.am.a().bP(5L).bQ(31L).sH("小程序zip和bundle不存在，兜底重置")).a(bVar));
                    if (d.DEBUG) {
                        Log.w("SwanAppBundleHelper", "20050004：reset aiapps");
                        return null;
                    }
                    return null;
                }
            }
            bC(bVar.getAppId(), bVar.getVersion());
            f fVar = new f();
            File file = new File(a, "app.json");
            SwanAppConfigData m = SwanAppConfigData.m(d.v(file), a);
            if (m != null) {
                fVar.cwS = bB(bVar.getAppId(), bVar.getVersion()).getPath() + File.separator;
                fVar.cwT = m;
                if (com.baidu.swan.apps.performance.b.c.awV()) {
                    com.baidu.swan.apps.ac.b.a.b(m, true);
                    com.baidu.swan.apps.ac.g.b.f(m);
                } else {
                    com.baidu.swan.apps.ac.b.a.a(m, true);
                    com.baidu.swan.apps.ac.g.b.e(m);
                }
                com.baidu.swan.apps.console.c.bb("SwanAppBundleHelper", "configFile path: " + file.getPath() + "configFile exist: " + file.exists() + "info.mAppBundlePath path: " + fVar.cwS);
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

        public static File bB(String str, String str2) {
            return d(str, str2, null);
        }

        public static File d(String str, String str2, @Nullable JSONObject jSONObject) {
            if (j.rL(str2)) {
                j.h(str, str2, jSONObject);
            }
            return new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "aiapps_folder" + File.separator + str, str2);
        }

        public static void nA(String str) {
            if (!TextUtils.isEmpty(str)) {
                File S = S(str, false);
                if (S != null) {
                    com.baidu.swan.c.d.deleteFile(S);
                }
                com.baidu.swan.c.d.deleteFile(new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "aiapps_folder" + File.separator + str));
            }
        }

        public static void bC(String str, String str2) {
            File[] listFiles;
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && (listFiles = new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "aiapps_folder", str).listFiles(new FileFilter() { // from class: com.baidu.swan.apps.r.d.d.1
                @Override // java.io.FileFilter
                public boolean accept(File file) {
                    return file.isDirectory() && TextUtils.isDigitsOnly(file.getName());
                }
            })) != null && listFiles.length > 0) {
                for (File file : listFiles) {
                    if (bD(str2, file.getName())) {
                        if (d.DEBUG) {
                            Log.i("SwanAppBundleHelper", "删除低版本文件夹：" + file.getAbsolutePath());
                        }
                        com.baidu.swan.pms.database.a.aUf().de(str, file.getName());
                        com.baidu.swan.c.d.deleteFile(file);
                    }
                }
            }
        }

        @Nullable
        public static File S(String str, boolean z) {
            return a(str, z, (com.baidu.swan.apps.ap.a.b) null);
        }

        @Nullable
        public static File a(@Nullable String str, boolean z, @Nullable com.baidu.swan.apps.ap.a.b bVar) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            File apo = apo();
            File file = new File(apo, str + ".aiapps");
            if (file.exists() && file.isFile()) {
                return file;
            }
            if (d.DEBUG && z) {
                com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), apo.getPath() + " 没有小程序包!").showToast();
            }
            if (bVar != null) {
                com.baidu.swan.apps.am.a sH = new com.baidu.swan.apps.am.a().bP(5L).bQ(4L).sH("没有小程序包! for release, no such bundle file");
                com.baidu.swan.apps.am.e.aEQ().j(sH);
                bVar.ddJ = sH;
                return null;
            }
            return null;
        }

        public static File apo() {
            File file = new File(AppRuntime.getAppContext().getFilesDir(), "swan_zip");
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }

        private static boolean bD(String str, String str2) {
            if (d.DEBUG) {
                Log.i("SwanAppBundleHelper", "curVersion:" + str + ",targetVersion:" + str2);
            }
            try {
                return bE(str, str2) > 0;
            } catch (IllegalArgumentException e) {
                if (d.DEBUG) {
                    Log.e("SwanAppBundleHelper", "比较版本号Exception：" + e.getMessage());
                    return false;
                }
                return false;
            }
        }

        private static long bE(String str, String str2) throws IllegalArgumentException {
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
        new com.baidu.swan.apps.l.a().a(cVar, a.aeW().getPath() + File.separator + System.currentTimeMillis() + ".aibundle", bVar);
    }

    public static void a(String str, b bVar) {
        c cVar = new c();
        cVar.mDownloadUrl = str;
        com.baidu.swan.apps.swancore.b.a.amZ();
        new com.baidu.swan.apps.l.a().a(cVar, com.baidu.swan.apps.swancore.b.a.ana().getPath(), bVar);
    }

    public static void b(String str, b bVar) {
        c cVar = new c();
        cVar.mDownloadUrl = str;
        com.baidu.swan.apps.extcore.c.b.amZ();
        new com.baidu.swan.apps.l.a().a(cVar, com.baidu.swan.apps.extcore.c.b.ana().getPath(), bVar);
    }

    /* loaded from: classes3.dex */
    public static class a {
        public static f a(com.baidu.swan.apps.u.c.b bVar, com.baidu.swan.apps.ap.a.b bVar2) {
            File a = a(bVar2);
            if (a == null) {
                return null;
            }
            com.baidu.swan.apps.runtime.e aAr = com.baidu.swan.apps.runtime.e.aAr();
            if (aAr == null) {
                if (!d.a(a, aeB(), bVar, bVar2)) {
                    com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "小程序bundle解压失败!").showToast();
                    com.baidu.swan.apps.am.a sH = new com.baidu.swan.apps.am.a().bP(5L).bQ(7L).sH("小程序bundle解压失败! for debug");
                    com.baidu.swan.apps.am.e.aEQ().j(sH);
                    if (bVar2 == null || bVar2.ddJ != null) {
                        return null;
                    }
                    bVar2.ddJ = sH;
                    return null;
                }
            } else {
                String string = aAr.aAD().getString("installed_debug_bundle_md5", "");
                String md5 = com.baidu.swan.c.e.toMd5(a, false);
                if (!TextUtils.equals(string, md5)) {
                    if (!d.a(a, aeB(), bVar, bVar2)) {
                        com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "小程序bundle解压失败!").showToast();
                        com.baidu.swan.apps.am.a sH2 = new com.baidu.swan.apps.am.a().bP(5L).bQ(7L).sH("小程序bundle解压失败! for debug");
                        com.baidu.swan.apps.am.e.aEQ().j(sH2);
                        if (bVar2 == null || bVar2.ddJ != null) {
                            return null;
                        }
                        bVar2.ddJ = sH2;
                        return null;
                    }
                    aAr.aAD().putString("installed_debug_bundle_md5", md5);
                }
            }
            f fVar = new f();
            File apn = apn();
            File file = new File(apn, "app.json");
            SwanAppConfigData m = SwanAppConfigData.m(com.baidu.swan.c.d.readFileData(file), apn);
            fVar.cwS = apn.getPath() + File.separator;
            fVar.cwT = m;
            com.baidu.swan.apps.ac.b.a.a(m, true);
            com.baidu.swan.apps.ac.g.b.e(m);
            com.baidu.swan.apps.console.c.bb("SwanAppBundleHelper", "configFile path: " + file.getPath() + "configFile exist: " + file.exists() + "info.mAppBundlePath path: " + fVar.cwS);
            return fVar;
        }

        public static File apn() {
            return aeB();
        }

        public static File aeB() {
            File file = new File(AppRuntime.getAppContext().getFilesDir(), "debug_aiapps_bundle");
            file.mkdirs();
            return file;
        }

        public static File a(com.baidu.swan.apps.ap.a.b bVar) {
            File aeW = aeW();
            File[] listFiles = aeW.listFiles();
            if (listFiles == null || listFiles.length == 0) {
                com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), aeW.getPath() + " 没有测试程序包!").showToast();
                com.baidu.swan.apps.am.a sH = new com.baidu.swan.apps.am.a().bP(5L).bQ(4L).sH("没有小程序包! for debug, bundle files are empty");
                com.baidu.swan.apps.am.e.aEQ().j(sH);
                if (bVar != null) {
                    bVar.ddJ = sH;
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

        public static File aeW() {
            File file = new File(com.baidu.swan.apps.u.a.a.getStorageList().get(0).mPath, "/aiapps_debug/");
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }
    }

    /* loaded from: classes3.dex */
    public static class e {
        public static f d(com.baidu.swan.apps.u.c.b bVar) {
            File aeB = aeB();
            com.baidu.swan.apps.console.debugger.a.d.aeH().lc("unzipstart");
            d.a(aeV(), aeB, bVar);
            com.baidu.swan.apps.console.debugger.a.d.aeH().lc("unzipend");
            f fVar = new f();
            File file = new File(aeB, "app.json");
            SwanAppConfigData m = SwanAppConfigData.m(com.baidu.swan.c.d.readFileData(file), aeB);
            fVar.cwS = aeB.getPath() + File.separator;
            fVar.cwT = m;
            com.baidu.swan.apps.ac.b.a.a(m, true);
            com.baidu.swan.apps.ac.g.b.e(m);
            com.baidu.swan.apps.console.c.bb("SwanAppBundleHelper", "configFile path: " + file.getPath() + "configFile exist: " + file.exists() + "info.mAppBundlePath path: " + fVar.cwS);
            return fVar;
        }

        public static File aeB() {
            File file = new File(AppRuntime.getAppContext().getFilesDir(), "aiapps_remote_debug_folder");
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }

        public static File aeV() {
            return new File(aeW(), "remote_debug.aiapps");
        }

        public static File aeW() {
            File file = new File(AppRuntime.getAppContext().getFilesDir(), "aiapps_remote_debug_zip");
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }
    }
}
