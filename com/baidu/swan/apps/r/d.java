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
    private static ExecutorService dcA = Executors.newSingleThreadExecutor();

    /* loaded from: classes8.dex */
    public interface b {
        void dO(int i);

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
        public String dcE;
        public SwanAppConfigData dcF;
    }

    public static void a(final com.baidu.swan.apps.u.c.b bVar, final com.baidu.swan.apps.r.b bVar2) {
        String asD;
        final JSONObject jSONObject = null;
        if (bVar == null || j.st(bVar.getVersion())) {
            jSONObject = new JSONObject();
            String stackTrace = ak.getStackTrace();
            if (bVar == null) {
                asD = "null";
            } else {
                try {
                    asD = bVar.asD();
                } catch (JSONException e2) {
                    if (DEBUG) {
                        e2.printStackTrace();
                    }
                }
            }
            jSONObject.put("originLaunchInfo", asD);
            jSONObject.put("stackTraceBefore", stackTrace);
        }
        dcA.execute(new Runnable() { // from class: com.baidu.swan.apps.r.d.1
            @Override // java.lang.Runnable
            public void run() {
                f a2;
                com.baidu.swan.apps.ao.a.b bVar3 = new com.baidu.swan.apps.ao.a.b();
                if (com.baidu.swan.apps.ad.a.a.j(com.baidu.swan.apps.u.c.b.this)) {
                    a2 = com.baidu.swan.apps.ad.a.a.a(com.baidu.swan.apps.u.c.b.this, bVar3);
                } else {
                    a2 = C0449d.a(com.baidu.swan.apps.u.c.b.this, bVar3, jSONObject);
                }
                if (a2 == null || a2.dcF == null || a2.dcF.dCL == null) {
                    com.baidu.swan.apps.al.a aVar = bVar3.dNx;
                    if (aVar == null) {
                        aVar = new com.baidu.swan.apps.al.a().cV(5L).cW(20L).to("小程序loadbundle出错，loadinfo为空或者页面配置空 ");
                    }
                    h.b(new com.baidu.swan.apps.statistic.a.d().sw(h.jr(com.baidu.swan.apps.u.c.b.this != null ? com.baidu.swan.apps.u.c.b.this.getAppFrameType() : 0)).i(aVar).sz("appjson_config_invalid").a(com.baidu.swan.apps.u.c.b.this));
                }
                bVar2.a(0, a2);
            }
        });
    }

    public static File awo() {
        return new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "aiapps_folder");
    }

    public static String awp() {
        return AppRuntime.getAppContext().getFilesDir() + File.separator + "aiapps_folder";
    }

    public static File awq() {
        return new File(AppRuntime.getAppContext().getFilesDir(), "swan_plugin_workspace");
    }

    public static File oa(String str) {
        if (TextUtils.isEmpty(str)) {
            if (DEBUG) {
                throw new IllegalArgumentException("plugin name can't be empty");
            }
            return null;
        }
        return new File(awq(), str);
    }

    public static File bO(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            if (DEBUG) {
                throw new IllegalArgumentException("plugin name or version can't be empty");
            }
            return null;
        }
        return new File(oa(str), str2);
    }

    public static boolean a(File file, File file2, com.baidu.swan.apps.u.c.b bVar) {
        return a(file, file2, bVar, null);
    }

    public static synchronized String z(@NonNull File file) {
        String str;
        synchronized (d.class) {
            if (file == null) {
                str = "";
            } else {
                String path = file.getPath();
                if (DEBUG) {
                    Log.d("SwanAppBundleHelper", "getConfigContent path: " + path);
                }
                str = (String) com.baidu.swan.apps.core.turbo.c.arC().n(path, "");
                if (TextUtils.isEmpty(str)) {
                    if (DEBUG) {
                        Log.d("SwanAppBundleHelper", "getConfigContent read start: " + path);
                    }
                    str = com.baidu.swan.c.d.readFileData(file);
                    com.baidu.swan.apps.core.turbo.c.arC().o(path, str);
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
            b.a aIv = eVar.aIv();
            file = a(eVar.getAppId(), aIv.getVersion(), aIv.ayW(), aIv.ayX(), null);
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
                SwanAppConfigData E = com.baidu.swan.apps.u.a.a.E(d);
                if (E != null) {
                    eVar.g(E);
                }
                if (com.baidu.swan.apps.performance.b.c.aEa()) {
                    com.baidu.swan.apps.ac.b.a.b(E, true);
                    com.baidu.swan.apps.ac.g.b.f(E);
                } else {
                    com.baidu.swan.apps.ac.b.a.a(E, true);
                    com.baidu.swan.apps.ac.g.b.e(E);
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
            com.baidu.swan.apps.al.a aVar = new com.baidu.swan.apps.al.a().cV(5L).cW(4L).to("小程序bundle文件不存在或者空文件! ");
            if (bVar2 != null) {
                bVar2.dNx = aVar;
                return false;
            }
            return false;
        }
        i.aDG().f(new UbcFlowEvent("package_start_unzip"));
        long currentTimeMillis = System.currentTimeMillis();
        a.b C = com.baidu.swan.apps.r.a.a.C(file);
        if (C.type != -1) {
            unzipFile = com.baidu.swan.apps.r.a.a.a(C.dcP, file2, C.type).isSuccess;
            i = C.type;
        } else {
            unzipFile = com.baidu.swan.c.d.unzipFile(file.getPath(), file2.getPath());
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        if (DEBUG) {
            com.baidu.swan.apps.r.a.a.hI((int) (currentTimeMillis2 - currentTimeMillis));
        }
        if (!unzipFile) {
            com.baidu.swan.apps.al.a aVar2 = new com.baidu.swan.apps.al.a().cV(5L).cW(7L).to("小程序bundle解压失败! PkgType=" + i);
            if (bVar2 != null) {
                bVar2.dNx = aVar2;
            }
        }
        i.aDG().f(new UbcFlowEvent("package_end_unzip")).cm("app_package_version", String.valueOf(i));
        return unzipFile;
    }

    private static File ob(String str) {
        return new File(awo(), str);
    }

    private static File bP(String str, String str2) {
        return new File(ob(str), str2);
    }

    public static File a(String str, String str2, boolean z, String str3, @Nullable JSONObject jSONObject) {
        File d = C0449d.d(str, str2, jSONObject);
        return (!z || TextUtils.isEmpty(str3)) ? d : new File(d, str3);
    }

    public static File R(String str, String str2, String str3) {
        return new File(bP(str, str2), ai.tL(str3));
    }

    public static boolean S(String str, String str2, String str3) {
        return A(R(str, str2, str3));
    }

    public static boolean bQ(String str, String str2) {
        boolean exists = new File(bP(str, str2), "app.json").exists();
        com.baidu.swan.apps.console.c.br("SwanAppBundleHelper", "isAppJsonExist = " + exists);
        return exists;
    }

    public static boolean A(File file) {
        if (file == null || !file.exists()) {
            return false;
        }
        boolean exists = new File(file, "app.json").exists();
        com.baidu.swan.apps.console.c.br("SwanAppBundleHelper", "isAppJsonExist = " + exists);
        return exists;
    }

    /* renamed from: com.baidu.swan.apps.r.d$d  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0449d {
        public static f a(com.baidu.swan.apps.u.c.b bVar, com.baidu.swan.apps.ao.a.b bVar2, @Nullable JSONObject jSONObject) {
            if (bVar == null) {
                return null;
            }
            File a2 = d.a(bVar.getAppId(), bVar.getVersion(), bVar.ayW(), bVar.ayX(), jSONObject);
            if (!a2.exists()) {
                File a3 = a(bVar.getAppId(), true, bVar2);
                if (a3 != null) {
                    if (!d.a(a3, B(a2), bVar, bVar2)) {
                        com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "小程序bundle解压失败!").aHZ();
                        com.baidu.swan.apps.al.a aVar = new com.baidu.swan.apps.al.a().cV(5L).cW(7L).to("小程序bundle解压失败! for release");
                        com.baidu.swan.apps.al.e.aMQ().j(aVar);
                        if (bVar2 == null || bVar2.dNx != null) {
                            return null;
                        }
                        bVar2.dNx = aVar;
                        return null;
                    }
                } else {
                    com.baidu.swan.apps.process.messaging.client.a.aFo().a(8, new SwanAppDeleteInfo(bVar.getAppId(), 1).hc(5));
                    h.b(new com.baidu.swan.apps.statistic.a.d().sw(h.jr(bVar.getAppFrameType())).i(new com.baidu.swan.apps.al.a().cV(5L).cW(31L).to("小程序zip和bundle不存在，兜底重置")).a(bVar));
                    if (d.DEBUG) {
                        Log.w("SwanAppBundleHelper", "20050004：reset aiapps");
                        return null;
                    }
                    return null;
                }
            }
            bS(bVar.getAppId(), bVar.getVersion());
            f fVar = new f();
            File file = new File(a2, "app.json");
            SwanAppConfigData o = SwanAppConfigData.o(d.z(file), a2);
            if (o != null) {
                fVar.dcE = bR(bVar.getAppId(), bVar.getVersion()).getPath() + File.separator;
                fVar.dcF = o;
                if (com.baidu.swan.apps.performance.b.c.aEa()) {
                    com.baidu.swan.apps.ac.b.a.b(o, true);
                    com.baidu.swan.apps.ac.g.b.f(o);
                } else {
                    com.baidu.swan.apps.ac.b.a.a(o, true);
                    com.baidu.swan.apps.ac.g.b.e(o);
                }
                com.baidu.swan.apps.console.c.br("SwanAppBundleHelper", "configFile path: " + file.getPath() + "configFile exist: " + file.exists() + "info.mAppBundlePath path: " + fVar.dcE);
                return fVar;
            }
            return null;
        }

        public static File B(File file) {
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }

        public static File bR(String str, String str2) {
            return d(str, str2, null);
        }

        public static File d(String str, String str2, @Nullable JSONObject jSONObject) {
            if (j.st(str2)) {
                j.h(str, str2, jSONObject);
            }
            return new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "aiapps_folder" + File.separator + str, str2);
        }

        public static void oc(String str) {
            if (!TextUtils.isEmpty(str)) {
                File Z = Z(str, false);
                if (Z != null) {
                    com.baidu.swan.c.d.deleteFile(Z);
                }
                com.baidu.swan.c.d.deleteFile(new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "aiapps_folder" + File.separator + str));
            }
        }

        public static void bS(String str, String str2) {
            File[] listFiles;
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && (listFiles = new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "aiapps_folder", str).listFiles(new FileFilter() { // from class: com.baidu.swan.apps.r.d.d.1
                @Override // java.io.FileFilter
                public boolean accept(File file) {
                    return file.isDirectory() && TextUtils.isDigitsOnly(file.getName());
                }
            })) != null && listFiles.length > 0) {
                for (File file : listFiles) {
                    if (bT(str2, file.getName())) {
                        if (d.DEBUG) {
                            Log.i("SwanAppBundleHelper", "删除低版本文件夹：" + file.getAbsolutePath());
                        }
                        com.baidu.swan.pms.database.a.bci().du(str, file.getName());
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
            File aws = aws();
            File file = new File(aws, str + ".aiapps");
            if (file.exists() && file.isFile()) {
                return file;
            }
            if (d.DEBUG && z) {
                com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), aws.getPath() + " 没有小程序包!").aHZ();
            }
            if (bVar != null) {
                com.baidu.swan.apps.al.a aVar = new com.baidu.swan.apps.al.a().cV(5L).cW(4L).to("没有小程序包! for release, no such bundle file");
                com.baidu.swan.apps.al.e.aMQ().j(aVar);
                bVar.dNx = aVar;
                return null;
            }
            return null;
        }

        public static File aws() {
            File file = new File(AppRuntime.getAppContext().getFilesDir(), "swan_zip");
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }

        private static boolean bT(String str, String str2) {
            if (d.DEBUG) {
                Log.i("SwanAppBundleHelper", "curVersion:" + str + ",targetVersion:" + str2);
            }
            try {
                return bU(str, str2) > 0;
            } catch (IllegalArgumentException e) {
                if (d.DEBUG) {
                    Log.e("SwanAppBundleHelper", "比较版本号Exception：" + e.getMessage());
                    return false;
                }
                return false;
            }
        }

        private static long bU(String str, String str2) throws IllegalArgumentException {
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
        new com.baidu.swan.apps.l.a().a(cVar, a.alU().getPath() + File.separator + System.currentTimeMillis() + ".aibundle", bVar);
    }

    public static void a(String str, b bVar) {
        c cVar = new c();
        cVar.mDownloadUrl = str;
        com.baidu.swan.apps.swancore.b.a.auf();
        new com.baidu.swan.apps.l.a().a(cVar, com.baidu.swan.apps.swancore.b.a.aug().getPath(), bVar);
    }

    public static void b(String str, b bVar) {
        c cVar = new c();
        cVar.mDownloadUrl = str;
        com.baidu.swan.apps.extcore.c.b.auf();
        new com.baidu.swan.apps.l.a().a(cVar, com.baidu.swan.apps.extcore.c.b.aug().getPath(), bVar);
    }

    /* loaded from: classes8.dex */
    public static class a {
        public static f a(com.baidu.swan.apps.u.c.b bVar, com.baidu.swan.apps.ao.a.b bVar2) {
            File a2 = a(bVar2);
            if (a2 == null) {
                return null;
            }
            com.baidu.swan.apps.runtime.e aIr = com.baidu.swan.apps.runtime.e.aIr();
            if (aIr == null) {
                if (!d.a(a2, alz(), bVar, bVar2)) {
                    com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "小程序bundle解压失败!").aHZ();
                    com.baidu.swan.apps.al.a aVar = new com.baidu.swan.apps.al.a().cV(5L).cW(7L).to("小程序bundle解压失败! for debug");
                    com.baidu.swan.apps.al.e.aMQ().j(aVar);
                    if (bVar2 == null || bVar2.dNx != null) {
                        return null;
                    }
                    bVar2.dNx = aVar;
                    return null;
                }
            } else {
                String string = aIr.aID().getString("installed_debug_bundle_md5", "");
                String e = com.baidu.swan.c.e.e(a2, false);
                if (!TextUtils.equals(string, e)) {
                    if (!d.a(a2, alz(), bVar, bVar2)) {
                        com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "小程序bundle解压失败!").aHZ();
                        com.baidu.swan.apps.al.a aVar2 = new com.baidu.swan.apps.al.a().cV(5L).cW(7L).to("小程序bundle解压失败! for debug");
                        com.baidu.swan.apps.al.e.aMQ().j(aVar2);
                        if (bVar2 == null || bVar2.dNx != null) {
                            return null;
                        }
                        bVar2.dNx = aVar2;
                        return null;
                    }
                    aIr.aID().putString("installed_debug_bundle_md5", e);
                }
            }
            f fVar = new f();
            File awr = awr();
            File file = new File(awr, "app.json");
            SwanAppConfigData o = SwanAppConfigData.o(com.baidu.swan.c.d.readFileData(file), awr);
            fVar.dcE = awr.getPath() + File.separator;
            fVar.dcF = o;
            com.baidu.swan.apps.ac.b.a.a(o, true);
            com.baidu.swan.apps.ac.g.b.e(o);
            com.baidu.swan.apps.console.c.br("SwanAppBundleHelper", "configFile path: " + file.getPath() + "configFile exist: " + file.exists() + "info.mAppBundlePath path: " + fVar.dcE);
            return fVar;
        }

        public static File awr() {
            return alz();
        }

        public static File alz() {
            File file = new File(AppRuntime.getAppContext().getFilesDir(), "debug_aiapps_bundle");
            file.mkdirs();
            return file;
        }

        public static File a(com.baidu.swan.apps.ao.a.b bVar) {
            File alU = alU();
            File[] listFiles = alU.listFiles();
            if (listFiles == null || listFiles.length == 0) {
                com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), alU.getPath() + " 没有测试程序包!").aHZ();
                com.baidu.swan.apps.al.a aVar = new com.baidu.swan.apps.al.a().cV(5L).cW(4L).to("没有小程序包! for debug, bundle files are empty");
                com.baidu.swan.apps.al.e.aMQ().j(aVar);
                if (bVar != null) {
                    bVar.dNx = aVar;
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

        public static File alU() {
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
            File alz = alz();
            com.baidu.swan.apps.console.debugger.a.d.alF().lF("unzipstart");
            d.a(alT(), alz, bVar);
            com.baidu.swan.apps.console.debugger.a.d.alF().lF("unzipend");
            f fVar = new f();
            File file = new File(alz, "app.json");
            SwanAppConfigData o = SwanAppConfigData.o(com.baidu.swan.c.d.readFileData(file), alz);
            fVar.dcE = alz.getPath() + File.separator;
            fVar.dcF = o;
            com.baidu.swan.apps.ac.b.a.a(o, true);
            com.baidu.swan.apps.ac.g.b.e(o);
            com.baidu.swan.apps.console.c.br("SwanAppBundleHelper", "configFile path: " + file.getPath() + "configFile exist: " + file.exists() + "info.mAppBundlePath path: " + fVar.dcE);
            return fVar;
        }

        public static File alz() {
            File file = new File(AppRuntime.getAppContext().getFilesDir(), "aiapps_remote_debug_folder");
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }

        public static File alT() {
            return new File(alU(), "remote_debug.aiapps");
        }

        public static File alU() {
            File file = new File(AppRuntime.getAppContext().getFilesDir(), "aiapps_remote_debug_zip");
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }
    }
}
