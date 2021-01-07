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
/* loaded from: classes9.dex */
public class d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static ExecutorService dho = Executors.newSingleThreadExecutor();

    /* loaded from: classes9.dex */
    public interface b {
        void fu(int i);

        void onFailed();

        void onSuccess();
    }

    /* loaded from: classes9.dex */
    public static class c {
        public String mAppId;
        public String mDownloadUrl;
    }

    /* loaded from: classes9.dex */
    public static class f extends com.baidu.swan.apps.r.a {
        public String dhs;
        public SwanAppConfigData dht;
    }

    public static void a(final com.baidu.swan.apps.u.c.b bVar, final com.baidu.swan.apps.r.b bVar2) {
        String awx;
        final JSONObject jSONObject = null;
        if (bVar == null || j.tE(bVar.getVersion())) {
            jSONObject = new JSONObject();
            String stackTrace = ak.getStackTrace();
            if (bVar == null) {
                awx = "null";
            } else {
                try {
                    awx = bVar.awx();
                } catch (JSONException e2) {
                    if (DEBUG) {
                        e2.printStackTrace();
                    }
                }
            }
            jSONObject.put("originLaunchInfo", awx);
            jSONObject.put("stackTraceBefore", stackTrace);
        }
        dho.execute(new Runnable() { // from class: com.baidu.swan.apps.r.d.1
            @Override // java.lang.Runnable
            public void run() {
                f a2;
                com.baidu.swan.apps.ao.a.b bVar3 = new com.baidu.swan.apps.ao.a.b();
                if (com.baidu.swan.apps.ad.a.a.j(com.baidu.swan.apps.u.c.b.this)) {
                    a2 = com.baidu.swan.apps.ad.a.a.a(com.baidu.swan.apps.u.c.b.this, bVar3);
                } else {
                    a2 = C0466d.a(com.baidu.swan.apps.u.c.b.this, bVar3, jSONObject);
                }
                if (a2 == null || a2.dht == null || a2.dht.dHx == null) {
                    com.baidu.swan.apps.al.a aVar = bVar3.dSj;
                    if (aVar == null) {
                        aVar = new com.baidu.swan.apps.al.a().cV(5L).cW(20L).uz("小程序loadbundle出错，loadinfo为空或者页面配置空 ");
                    }
                    h.b(new com.baidu.swan.apps.statistic.a.d().tH(h.kX(com.baidu.swan.apps.u.c.b.this != null ? com.baidu.swan.apps.u.c.b.this.getAppFrameType() : 0)).i(aVar).tK("appjson_config_invalid").a(com.baidu.swan.apps.u.c.b.this));
                }
                bVar2.a(0, a2);
            }
        });
    }

    public static File aAi() {
        return new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "aiapps_folder");
    }

    public static String aAj() {
        return AppRuntime.getAppContext().getFilesDir() + File.separator + "aiapps_folder";
    }

    public static File aAk() {
        return new File(AppRuntime.getAppContext().getFilesDir(), "swan_plugin_workspace");
    }

    public static File pn(String str) {
        if (TextUtils.isEmpty(str)) {
            if (DEBUG) {
                throw new IllegalArgumentException("plugin name can't be empty");
            }
            return null;
        }
        return new File(aAk(), str);
    }

    public static File bP(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            if (DEBUG) {
                throw new IllegalArgumentException("plugin name or version can't be empty");
            }
            return null;
        }
        return new File(pn(str), str2);
    }

    public static boolean a(File file, File file2, com.baidu.swan.apps.u.c.b bVar) {
        return a(file, file2, bVar, null);
    }

    public static synchronized String A(@NonNull File file) {
        String str;
        synchronized (d.class) {
            if (file == null) {
                str = "";
            } else {
                String path = file.getPath();
                if (DEBUG) {
                    Log.d("SwanAppBundleHelper", "getConfigContent path: " + path);
                }
                str = (String) com.baidu.swan.apps.core.turbo.c.avx().n(path, "");
                if (TextUtils.isEmpty(str)) {
                    if (DEBUG) {
                        Log.d("SwanAppBundleHelper", "getConfigContent read start: " + path);
                    }
                    str = com.baidu.swan.c.d.readFileData(file);
                    com.baidu.swan.apps.core.turbo.c.avx().o(path, str);
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
            b.a aMp = eVar.aMp();
            file = a(eVar.getAppId(), aMp.getVersion(), aMp.aCQ(), aMp.aCR(), null);
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
                SwanAppConfigData F = com.baidu.swan.apps.u.a.a.F(d);
                if (F != null) {
                    eVar.g(F);
                }
                if (com.baidu.swan.apps.performance.b.c.aHU()) {
                    com.baidu.swan.apps.ac.b.a.b(F, true);
                    com.baidu.swan.apps.ac.g.b.f(F);
                } else {
                    com.baidu.swan.apps.ac.b.a.a(F, true);
                    com.baidu.swan.apps.ac.g.b.e(F);
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
            com.baidu.swan.apps.al.a uz = new com.baidu.swan.apps.al.a().cV(5L).cW(4L).uz("小程序bundle文件不存在或者空文件! ");
            if (bVar2 != null) {
                bVar2.dSj = uz;
                return false;
            }
            return false;
        }
        i.aHA().f(new UbcFlowEvent("package_start_unzip"));
        long currentTimeMillis = System.currentTimeMillis();
        a.b D = com.baidu.swan.apps.r.a.a.D(file);
        if (D.type != -1) {
            unzipFile = com.baidu.swan.apps.r.a.a.a(D.dhD, file2, D.type).isSuccess;
            i = D.type;
        } else {
            unzipFile = com.baidu.swan.c.d.unzipFile(file.getPath(), file2.getPath());
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        if (DEBUG) {
            com.baidu.swan.apps.r.a.a.jo((int) (currentTimeMillis2 - currentTimeMillis));
        }
        if (!unzipFile) {
            com.baidu.swan.apps.al.a uz2 = new com.baidu.swan.apps.al.a().cV(5L).cW(7L).uz("小程序bundle解压失败! PkgType=" + i);
            if (bVar2 != null) {
                bVar2.dSj = uz2;
            }
        }
        i.aHA().f(new UbcFlowEvent("package_end_unzip")).cn("app_package_version", String.valueOf(i));
        return unzipFile;
    }

    private static File po(String str) {
        return new File(aAi(), str);
    }

    private static File bQ(String str, String str2) {
        return new File(po(str), str2);
    }

    public static File a(String str, String str2, boolean z, String str3, @Nullable JSONObject jSONObject) {
        File d = C0466d.d(str, str2, jSONObject);
        return (!z || TextUtils.isEmpty(str3)) ? d : new File(d, str3);
    }

    public static File S(String str, String str2, String str3) {
        return new File(bQ(str, str2), ai.uW(str3));
    }

    public static boolean T(String str, String str2, String str3) {
        return B(S(str, str2, str3));
    }

    public static boolean bR(String str, String str2) {
        boolean exists = new File(bQ(str, str2), "app.json").exists();
        com.baidu.swan.apps.console.c.bs("SwanAppBundleHelper", "isAppJsonExist = " + exists);
        return exists;
    }

    public static boolean B(File file) {
        if (file == null || !file.exists()) {
            return false;
        }
        boolean exists = new File(file, "app.json").exists();
        com.baidu.swan.apps.console.c.bs("SwanAppBundleHelper", "isAppJsonExist = " + exists);
        return exists;
    }

    /* renamed from: com.baidu.swan.apps.r.d$d  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C0466d {
        public static f a(com.baidu.swan.apps.u.c.b bVar, com.baidu.swan.apps.ao.a.b bVar2, @Nullable JSONObject jSONObject) {
            if (bVar == null) {
                return null;
            }
            File a2 = d.a(bVar.getAppId(), bVar.getVersion(), bVar.aCQ(), bVar.aCR(), jSONObject);
            if (!a2.exists()) {
                File a3 = a(bVar.getAppId(), true, bVar2);
                if (a3 != null) {
                    if (!d.a(a3, C(a2), bVar, bVar2)) {
                        com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "小程序bundle解压失败!").aLT();
                        com.baidu.swan.apps.al.a uz = new com.baidu.swan.apps.al.a().cV(5L).cW(7L).uz("小程序bundle解压失败! for release");
                        com.baidu.swan.apps.al.e.aQK().j(uz);
                        if (bVar2 == null || bVar2.dSj != null) {
                            return null;
                        }
                        bVar2.dSj = uz;
                        return null;
                    }
                } else {
                    com.baidu.swan.apps.process.messaging.client.a.aJi().a(8, new SwanAppDeleteInfo(bVar.getAppId(), 1).iI(5));
                    h.b(new com.baidu.swan.apps.statistic.a.d().tH(h.kX(bVar.getAppFrameType())).i(new com.baidu.swan.apps.al.a().cV(5L).cW(31L).uz("小程序zip和bundle不存在，兜底重置")).a(bVar));
                    if (d.DEBUG) {
                        Log.w("SwanAppBundleHelper", "20050004：reset aiapps");
                        return null;
                    }
                    return null;
                }
            }
            bT(bVar.getAppId(), bVar.getVersion());
            f fVar = new f();
            File file = new File(a2, "app.json");
            SwanAppConfigData o = SwanAppConfigData.o(d.A(file), a2);
            if (o != null) {
                fVar.dhs = bS(bVar.getAppId(), bVar.getVersion()).getPath() + File.separator;
                fVar.dht = o;
                if (com.baidu.swan.apps.performance.b.c.aHU()) {
                    com.baidu.swan.apps.ac.b.a.b(o, true);
                    com.baidu.swan.apps.ac.g.b.f(o);
                } else {
                    com.baidu.swan.apps.ac.b.a.a(o, true);
                    com.baidu.swan.apps.ac.g.b.e(o);
                }
                com.baidu.swan.apps.console.c.bs("SwanAppBundleHelper", "configFile path: " + file.getPath() + "configFile exist: " + file.exists() + "info.mAppBundlePath path: " + fVar.dhs);
                return fVar;
            }
            return null;
        }

        public static File C(File file) {
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }

        public static File bS(String str, String str2) {
            return d(str, str2, null);
        }

        public static File d(String str, String str2, @Nullable JSONObject jSONObject) {
            if (j.tE(str2)) {
                j.h(str, str2, jSONObject);
            }
            return new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "aiapps_folder" + File.separator + str, str2);
        }

        public static void pp(String str) {
            if (!TextUtils.isEmpty(str)) {
                File Z = Z(str, false);
                if (Z != null) {
                    com.baidu.swan.c.d.deleteFile(Z);
                }
                com.baidu.swan.c.d.deleteFile(new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "aiapps_folder" + File.separator + str));
            }
        }

        public static void bT(String str, String str2) {
            File[] listFiles;
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && (listFiles = new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "aiapps_folder", str).listFiles(new FileFilter() { // from class: com.baidu.swan.apps.r.d.d.1
                @Override // java.io.FileFilter
                public boolean accept(File file) {
                    return file.isDirectory() && TextUtils.isDigitsOnly(file.getName());
                }
            })) != null && listFiles.length > 0) {
                for (File file : listFiles) {
                    if (bU(str2, file.getName())) {
                        if (d.DEBUG) {
                            Log.i("SwanAppBundleHelper", "删除低版本文件夹：" + file.getAbsolutePath());
                        }
                        com.baidu.swan.pms.database.a.bgc().dv(str, file.getName());
                        com.baidu.swan.c.d.deleteFile(file);
                    }
                }
            }
        }

        @Nullable
        public static File Z(String str, boolean z) {
            return a(str, z, (com.baidu.swan.apps.ao.a.b) null);
        }

        @Nullable
        public static File a(@Nullable String str, boolean z, @Nullable com.baidu.swan.apps.ao.a.b bVar) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            File aAm = aAm();
            File file = new File(aAm, str + ".aiapps");
            if (file.exists() && file.isFile()) {
                return file;
            }
            if (d.DEBUG && z) {
                com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), aAm.getPath() + " 没有小程序包!").aLT();
            }
            if (bVar != null) {
                com.baidu.swan.apps.al.a uz = new com.baidu.swan.apps.al.a().cV(5L).cW(4L).uz("没有小程序包! for release, no such bundle file");
                com.baidu.swan.apps.al.e.aQK().j(uz);
                bVar.dSj = uz;
                return null;
            }
            return null;
        }

        public static File aAm() {
            File file = new File(AppRuntime.getAppContext().getFilesDir(), "swan_zip");
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }

        private static boolean bU(String str, String str2) {
            if (d.DEBUG) {
                Log.i("SwanAppBundleHelper", "curVersion:" + str + ",targetVersion:" + str2);
            }
            try {
                return bV(str, str2) > 0;
            } catch (IllegalArgumentException e) {
                if (d.DEBUG) {
                    Log.e("SwanAppBundleHelper", "比较版本号Exception：" + e.getMessage());
                    return false;
                }
                return false;
            }
        }

        private static long bV(String str, String str2) throws IllegalArgumentException {
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
        new com.baidu.swan.apps.l.a().a(cVar, a.apP().getPath() + File.separator + System.currentTimeMillis() + ".aibundle", bVar);
    }

    public static void a(String str, b bVar) {
        c cVar = new c();
        cVar.mDownloadUrl = str;
        com.baidu.swan.apps.swancore.b.a.axZ();
        new com.baidu.swan.apps.l.a().a(cVar, com.baidu.swan.apps.swancore.b.a.aya().getPath(), bVar);
    }

    public static void b(String str, b bVar) {
        c cVar = new c();
        cVar.mDownloadUrl = str;
        com.baidu.swan.apps.extcore.c.b.axZ();
        new com.baidu.swan.apps.l.a().a(cVar, com.baidu.swan.apps.extcore.c.b.aya().getPath(), bVar);
    }

    /* loaded from: classes9.dex */
    public static class a {
        public static f a(com.baidu.swan.apps.u.c.b bVar, com.baidu.swan.apps.ao.a.b bVar2) {
            File a2 = a(bVar2);
            if (a2 == null) {
                return null;
            }
            com.baidu.swan.apps.runtime.e aMl = com.baidu.swan.apps.runtime.e.aMl();
            if (aMl == null) {
                if (!d.a(a2, apu(), bVar, bVar2)) {
                    com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "小程序bundle解压失败!").aLT();
                    com.baidu.swan.apps.al.a uz = new com.baidu.swan.apps.al.a().cV(5L).cW(7L).uz("小程序bundle解压失败! for debug");
                    com.baidu.swan.apps.al.e.aQK().j(uz);
                    if (bVar2 == null || bVar2.dSj != null) {
                        return null;
                    }
                    bVar2.dSj = uz;
                    return null;
                }
            } else {
                String string = aMl.aMx().getString("installed_debug_bundle_md5", "");
                String e = com.baidu.swan.c.e.e(a2, false);
                if (!TextUtils.equals(string, e)) {
                    if (!d.a(a2, apu(), bVar, bVar2)) {
                        com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "小程序bundle解压失败!").aLT();
                        com.baidu.swan.apps.al.a uz2 = new com.baidu.swan.apps.al.a().cV(5L).cW(7L).uz("小程序bundle解压失败! for debug");
                        com.baidu.swan.apps.al.e.aQK().j(uz2);
                        if (bVar2 == null || bVar2.dSj != null) {
                            return null;
                        }
                        bVar2.dSj = uz2;
                        return null;
                    }
                    aMl.aMx().putString("installed_debug_bundle_md5", e);
                }
            }
            f fVar = new f();
            File aAl = aAl();
            File file = new File(aAl, "app.json");
            SwanAppConfigData o = SwanAppConfigData.o(com.baidu.swan.c.d.readFileData(file), aAl);
            fVar.dhs = aAl.getPath() + File.separator;
            fVar.dht = o;
            com.baidu.swan.apps.ac.b.a.a(o, true);
            com.baidu.swan.apps.ac.g.b.e(o);
            com.baidu.swan.apps.console.c.bs("SwanAppBundleHelper", "configFile path: " + file.getPath() + "configFile exist: " + file.exists() + "info.mAppBundlePath path: " + fVar.dhs);
            return fVar;
        }

        public static File aAl() {
            return apu();
        }

        public static File apu() {
            File file = new File(AppRuntime.getAppContext().getFilesDir(), "debug_aiapps_bundle");
            file.mkdirs();
            return file;
        }

        public static File a(com.baidu.swan.apps.ao.a.b bVar) {
            File apP = apP();
            File[] listFiles = apP.listFiles();
            if (listFiles == null || listFiles.length == 0) {
                com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), apP.getPath() + " 没有测试程序包!").aLT();
                com.baidu.swan.apps.al.a uz = new com.baidu.swan.apps.al.a().cV(5L).cW(4L).uz("没有小程序包! for debug, bundle files are empty");
                com.baidu.swan.apps.al.e.aQK().j(uz);
                if (bVar != null) {
                    bVar.dSj = uz;
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

        public static File apP() {
            File file = new File(com.baidu.swan.apps.u.a.a.getStorageList().get(0).mPath, "/aiapps_debug/");
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }
    }

    /* loaded from: classes9.dex */
    public static class e {
        public static f d(com.baidu.swan.apps.u.c.b bVar) {
            File apu = apu();
            com.baidu.swan.apps.console.debugger.a.d.apA().mQ("unzipstart");
            d.a(apO(), apu, bVar);
            com.baidu.swan.apps.console.debugger.a.d.apA().mQ("unzipend");
            f fVar = new f();
            File file = new File(apu, "app.json");
            SwanAppConfigData o = SwanAppConfigData.o(com.baidu.swan.c.d.readFileData(file), apu);
            fVar.dhs = apu.getPath() + File.separator;
            fVar.dht = o;
            com.baidu.swan.apps.ac.b.a.a(o, true);
            com.baidu.swan.apps.ac.g.b.e(o);
            com.baidu.swan.apps.console.c.bs("SwanAppBundleHelper", "configFile path: " + file.getPath() + "configFile exist: " + file.exists() + "info.mAppBundlePath path: " + fVar.dhs);
            return fVar;
        }

        public static File apu() {
            File file = new File(AppRuntime.getAppContext().getFilesDir(), "aiapps_remote_debug_folder");
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }

        public static File apO() {
            return new File(apP(), "remote_debug.aiapps");
        }

        public static File apP() {
            File file = new File(AppRuntime.getAppContext().getFilesDir(), "aiapps_remote_debug_zip");
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }
    }
}
