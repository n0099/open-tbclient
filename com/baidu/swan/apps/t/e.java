package com.baidu.swan.apps.t;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.as.ac;
import com.baidu.swan.apps.as.ag;
import com.baidu.swan.apps.as.ai;
import com.baidu.swan.apps.env.SwanAppDeleteInfo;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.statistic.h;
import com.baidu.swan.apps.t.a.a;
import java.io.File;
import java.io.FileFilter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class e {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static ExecutorService bVN = Executors.newSingleThreadExecutor();

    /* loaded from: classes11.dex */
    public interface b {
        void dm(int i);

        void onFailed();

        void onSuccess();
    }

    /* loaded from: classes11.dex */
    public static class c {
        public String mAppId;
        public String mDownloadUrl;
    }

    /* loaded from: classes11.dex */
    public static class f extends com.baidu.swan.apps.t.a {
        public String bVR;
        public SwanAppConfigData bVS;
    }

    public static void a(final com.baidu.swan.apps.x.b.b bVar, final com.baidu.swan.apps.t.b bVar2) {
        String YS;
        final JSONObject jSONObject = null;
        if (bVar == null || h.mW(bVar.getVersion())) {
            jSONObject = new JSONObject();
            String apo = ai.apo();
            if (bVar == null) {
                YS = "null";
            } else {
                try {
                    YS = bVar.YS();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            jSONObject.put("originLaunchInfo", YS);
            jSONObject.put("stackTraceBefore", apo);
        }
        bVN.execute(new Runnable() { // from class: com.baidu.swan.apps.t.e.1
            @Override // java.lang.Runnable
            public void run() {
                f a2;
                com.baidu.swan.apps.as.a.b bVar3 = new com.baidu.swan.apps.as.a.b();
                if (com.baidu.swan.apps.ah.a.a.k(com.baidu.swan.apps.x.b.b.this)) {
                    a2 = com.baidu.swan.apps.ah.a.a.a(com.baidu.swan.apps.x.b.b.this, bVar3);
                } else {
                    a2 = d.a(com.baidu.swan.apps.x.b.b.this, bVar3, jSONObject);
                }
                if (a2 == null || a2.bVS == null || a2.bVS.coA == null) {
                    com.baidu.swan.apps.ap.a aVar = bVar3.cxK;
                    if (aVar == null) {
                        aVar = new com.baidu.swan.apps.ap.a().bn(5L).bo(20L).nL("小程序loadbundle出错，loadinfo为空或者页面配置空 ");
                    }
                    com.baidu.swan.apps.statistic.f.b(new com.baidu.swan.apps.statistic.a.d().mZ(com.baidu.swan.apps.statistic.f.gz(com.baidu.swan.apps.x.b.b.this != null ? com.baidu.swan.apps.x.b.b.this.getAppFrameType() : 0)).e(aVar).nc("appjson_config_invalid").a(com.baidu.swan.apps.x.b.b.this));
                }
                bVar2.a(0, a2);
            }
        });
    }

    public static File abF() {
        return new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "aiapps_folder");
    }

    public static File abG() {
        return new File(AppRuntime.getAppContext().getFilesDir(), "swan_plugin_workspace");
    }

    public static File jr(String str) {
        if (TextUtils.isEmpty(str)) {
            if (DEBUG) {
                throw new IllegalArgumentException("plugin name can't be empty");
            }
            return null;
        }
        return new File(abG(), str);
    }

    public static File aQ(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            if (DEBUG) {
                throw new IllegalArgumentException("plugin name or version can't be empty");
            }
            return null;
        }
        return new File(jr(str), str2);
    }

    public static boolean a(File file, File file2, com.baidu.swan.apps.x.b.b bVar) {
        return a(file, file2, bVar, null);
    }

    public static synchronized String p(@NonNull File file) {
        String str;
        synchronized (e.class) {
            if (file == null) {
                str = "";
            } else {
                String path = file.getPath();
                if (DEBUG) {
                    Log.d("SwanAppBundleHelper", "getConfigContent path: " + path);
                }
                str = (String) com.baidu.swan.apps.core.k.c.Yn().m(path, "");
                if (TextUtils.isEmpty(str)) {
                    if (DEBUG) {
                        Log.d("SwanAppBundleHelper", "getConfigContent read start: " + path);
                    }
                    str = com.baidu.swan.d.c.readFileData(file);
                    com.baidu.swan.apps.core.k.c.Yn().n(path, str);
                    if (DEBUG) {
                        Log.d("SwanAppBundleHelper", "getConfigContent read end: " + path);
                    }
                }
            }
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean a(File file, File file2, com.baidu.swan.apps.x.b.b bVar, com.baidu.swan.apps.as.a.b bVar2) {
        boolean unzipFile;
        int i = 0;
        if (file == null || file2 == null) {
            return false;
        }
        if (!file.exists() || file.length() == 0) {
            com.baidu.swan.apps.ap.a nL = new com.baidu.swan.apps.ap.a().bn(5L).bo(4L).nL("小程序bundle文件不存在或者空文件! ");
            if (bVar2 != null) {
                bVar2.cxK = nL;
                return false;
            }
            return false;
        }
        com.baidu.swan.apps.performance.f.aid().f(new UbcFlowEvent("package_start_unzip"));
        long currentTimeMillis = System.currentTimeMillis();
        a.b s = com.baidu.swan.apps.t.a.a.s(file);
        if (s.type != -1) {
            unzipFile = com.baidu.swan.apps.t.a.a.a(s.bWc, file2, s.type).isSuccess;
            i = s.type;
        } else {
            unzipFile = com.baidu.swan.d.c.unzipFile(file.getPath(), file2.getPath());
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        if (DEBUG) {
            com.baidu.swan.apps.t.a.a.fj((int) (currentTimeMillis2 - currentTimeMillis));
        }
        if (!unzipFile) {
            com.baidu.swan.apps.ap.a nL2 = new com.baidu.swan.apps.ap.a().bn(5L).bo(7L).nL("小程序bundle解压失败! PkgType=" + i);
            if (bVar2 != null) {
                bVar2.cxK = nL2;
            }
        }
        com.baidu.swan.apps.performance.f.aid().f(new UbcFlowEvent("package_end_unzip")).bk("app_package_version", String.valueOf(i));
        return unzipFile;
    }

    private static File js(String str) {
        return new File(abF(), str);
    }

    private static File aR(String str, String str2) {
        return new File(js(str), str2);
    }

    public static File a(String str, String str2, boolean z, String str3, @Nullable JSONObject jSONObject) {
        File c2 = d.c(str, str2, jSONObject);
        return (!z || TextUtils.isEmpty(str3)) ? c2 : new File(c2, str3);
    }

    public static File z(String str, String str2, String str3) {
        return new File(aR(str, str2), ag.oe(str3));
    }

    public static boolean A(String str, String str2, String str3) {
        return q(z(str, str2, str3));
    }

    public static boolean aS(String str, String str2) {
        return new File(aR(str, str2), "app.json").exists();
    }

    public static boolean q(File file) {
        if (file == null || !file.exists()) {
            return false;
        }
        return new File(file, "app.json").exists();
    }

    /* loaded from: classes11.dex */
    public static class d {
        public static f a(com.baidu.swan.apps.x.b.b bVar, com.baidu.swan.apps.as.a.b bVar2, @Nullable JSONObject jSONObject) {
            if (bVar == null) {
                return null;
            }
            File a = e.a(bVar.getAppId(), bVar.getVersion(), bVar.adV(), bVar.adW(), jSONObject);
            if (!a.exists()) {
                File a2 = a(bVar.getAppId(), true, bVar2);
                if (a2 != null) {
                    if (!e.a(a2, r(a), bVar, bVar2)) {
                        com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "小程序bundle解压失败!").showToast();
                        com.baidu.swan.apps.ap.a nL = new com.baidu.swan.apps.ap.a().bn(5L).bo(7L).nL("小程序bundle解压失败! for release");
                        com.baidu.swan.apps.ap.e.aow().f(nL);
                        if (bVar2 == null || bVar2.cxK != null) {
                            return null;
                        }
                        bVar2.cxK = nL;
                        return null;
                    }
                } else {
                    com.baidu.swan.apps.process.messaging.client.a.ajd().a(8, new SwanAppDeleteInfo(bVar.getAppId(), 1));
                    com.baidu.swan.apps.statistic.f.b(new com.baidu.swan.apps.statistic.a.d().mZ(com.baidu.swan.apps.statistic.f.gz(bVar.getAppFrameType())).e(new com.baidu.swan.apps.ap.a().bn(5L).bo(31L).nL("小程序zip和bundle不存在，兜底重置")).a(bVar));
                    if (e.DEBUG) {
                        Log.w("SwanAppBundleHelper", "20050004：reset aiapps");
                        return null;
                    }
                    return null;
                }
            }
            aU(bVar.getAppId(), bVar.getVersion());
            f fVar = new f();
            File file = new File(a, "app.json");
            SwanAppConfigData k = SwanAppConfigData.k(e.p(file), a);
            if (k != null) {
                fVar.bVR = aT(bVar.getAppId(), bVar.getVersion()).getPath() + File.separator;
                fVar.bVS = k;
                com.baidu.swan.apps.ag.b.b.a(k, true);
                com.baidu.swan.apps.ag.g.b.b(k);
                if (e.DEBUG) {
                    Log.d("SwanAppBundleHelper", "configFile path: " + file.getPath());
                    Log.d("SwanAppBundleHelper", "configFile exist: " + file.exists());
                    Log.d("SwanAppBundleHelper", "info.mAppBundlePath path: " + fVar.bVR);
                    Log.d("SwanAppBundleHelper", "launchInfo.swanCoreVersion.swanCorePath: " + bVar.YI().swanCorePath);
                }
                return fVar;
            }
            return null;
        }

        public static File r(File file) {
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }

        public static File aT(String str, String str2) {
            return c(str, str2, null);
        }

        public static File c(String str, String str2, @Nullable JSONObject jSONObject) {
            if (h.mW(str2)) {
                h.d(str, str2, jSONObject);
            }
            return new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "aiapps_folder" + File.separator + str, str2);
        }

        public static void jt(String str) {
            if (!TextUtils.isEmpty(str)) {
                File A = A(str, false);
                if (A != null) {
                    com.baidu.swan.d.c.deleteFile(A);
                }
                com.baidu.swan.d.c.deleteFile(new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "aiapps_folder" + File.separator + str));
            }
        }

        public static void aU(String str, String str2) {
            File[] listFiles;
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && (listFiles = new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "aiapps_folder", str).listFiles(new FileFilter() { // from class: com.baidu.swan.apps.t.e.d.1
                @Override // java.io.FileFilter
                public boolean accept(File file) {
                    return file.isDirectory() && TextUtils.isDigitsOnly(file.getName());
                }
            })) != null && listFiles.length > 0) {
                for (File file : listFiles) {
                    if (aV(str2, file.getName())) {
                        if (e.DEBUG) {
                            Log.i("SwanAppBundleHelper", "删除低版本文件夹：" + file.getAbsolutePath());
                        }
                        com.baidu.swan.pms.database.a.aBI().cm(str, file.getName());
                        com.baidu.swan.d.c.deleteFile(file);
                    }
                }
            }
        }

        @Nullable
        public static File A(String str, boolean z) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return a(str, z, (com.baidu.swan.apps.as.a.b) null);
        }

        public static File a(String str, boolean z, com.baidu.swan.apps.as.a.b bVar) {
            File abI;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            File[] listFiles = abI().listFiles();
            if (listFiles == null || listFiles.length == 0) {
                if (e.DEBUG && z) {
                    com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), abI.getPath() + " 没有小程序包!").showToast();
                }
                com.baidu.swan.apps.ap.a nL = new com.baidu.swan.apps.ap.a().bn(5L).bo(4L).nL("没有小程序包! for release, bundle files are empty");
                com.baidu.swan.apps.ap.e.aow().f(nL);
                if (bVar != null) {
                    bVar.cxK = nL;
                }
                return null;
            }
            for (File file : listFiles) {
                if (TextUtils.equals(file.getName(), str + ".aiapps")) {
                    return file;
                }
            }
            if (e.DEBUG && z) {
                com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), abI.getPath() + " 没有小程序包!").showToast();
            }
            com.baidu.swan.apps.ap.a nL2 = new com.baidu.swan.apps.ap.a().bn(5L).bo(4L).nL("没有小程序包! for release, no such bundle file");
            com.baidu.swan.apps.ap.e.aow().f(nL2);
            if (bVar != null) {
                bVar.cxK = nL2;
            }
            return null;
        }

        public static File abI() {
            File file = new File(AppRuntime.getAppContext().getFilesDir(), "aiapps_zip");
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }

        private static boolean aV(String str, String str2) {
            if (e.DEBUG) {
                Log.i("SwanAppBundleHelper", "curVersion:" + str + ",targetVersion:" + str2);
            }
            try {
                return aW(str, str2) > 0;
            } catch (IllegalArgumentException e) {
                if (e.DEBUG) {
                    Log.e("SwanAppBundleHelper", "比较版本号Exception：" + e.getMessage());
                    return false;
                }
                return false;
            }
        }

        private static long aW(String str, String str2) throws IllegalArgumentException {
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
        new com.baidu.swan.apps.l.a().a(cVar, a.TO().getPath() + File.separator + String.valueOf(System.currentTimeMillis()) + ".aibundle", bVar);
    }

    public static void a(String str, b bVar) {
        c cVar = new c();
        cVar.mDownloadUrl = str;
        com.baidu.swan.apps.swancore.c.a.ZM();
        new com.baidu.swan.apps.l.a().a(cVar, com.baidu.swan.apps.swancore.c.a.ZN().getPath(), bVar);
    }

    public static void b(String str, b bVar) {
        c cVar = new c();
        cVar.mDownloadUrl = str;
        com.baidu.swan.apps.extcore.d.b.ZM();
        new com.baidu.swan.apps.l.a().a(cVar, com.baidu.swan.apps.extcore.d.b.ZN().getPath(), bVar);
    }

    /* loaded from: classes11.dex */
    public static class a {
        /* JADX WARN: Removed duplicated region for block: B:19:0x00b2  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static f a(com.baidu.swan.apps.x.b.b bVar, com.baidu.swan.apps.as.a.b bVar2) {
            f fVar = null;
            File a = a(bVar2);
            if (a != null) {
                com.baidu.swan.apps.runtime.e akN = com.baidu.swan.apps.runtime.e.akN();
                if (akN == null) {
                    if (!e.a(a, Tt(), bVar, bVar2)) {
                        com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "小程序bundle解压失败!").showToast();
                        com.baidu.swan.apps.ap.a nL = new com.baidu.swan.apps.ap.a().bn(5L).bo(7L).nL("小程序bundle解压失败! for debug");
                        com.baidu.swan.apps.ap.e.aow().f(nL);
                        if (bVar2 != null && bVar2.cxK == null) {
                            bVar2.cxK = nL;
                        }
                    }
                    fVar = new f();
                    File abH = abH();
                    File file = new File(abH, "app.json");
                    SwanAppConfigData k = SwanAppConfigData.k(com.baidu.swan.d.c.readFileData(file), abH);
                    fVar.bVR = abH.getPath() + File.separator;
                    fVar.bVS = k;
                    com.baidu.swan.apps.ag.b.b.a(k, true);
                    com.baidu.swan.apps.ag.g.b.b(k);
                    if (e.DEBUG) {
                    }
                } else {
                    String string = akN.akX().getString("installed_debug_bundle_md5", "");
                    String md5 = com.baidu.swan.d.d.toMd5(a, false);
                    if (!TextUtils.equals(string, md5)) {
                        if (!e.a(a, Tt(), bVar, bVar2)) {
                            com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "小程序bundle解压失败!").showToast();
                            com.baidu.swan.apps.ap.a nL2 = new com.baidu.swan.apps.ap.a().bn(5L).bo(7L).nL("小程序bundle解压失败! for debug");
                            com.baidu.swan.apps.ap.e.aow().f(nL2);
                            if (bVar2 != null && bVar2.cxK == null) {
                                bVar2.cxK = nL2;
                            }
                        } else {
                            akN.akX().putString("installed_debug_bundle_md5", md5);
                        }
                    }
                    fVar = new f();
                    File abH2 = abH();
                    File file2 = new File(abH2, "app.json");
                    SwanAppConfigData k2 = SwanAppConfigData.k(com.baidu.swan.d.c.readFileData(file2), abH2);
                    fVar.bVR = abH2.getPath() + File.separator;
                    fVar.bVS = k2;
                    com.baidu.swan.apps.ag.b.b.a(k2, true);
                    com.baidu.swan.apps.ag.g.b.b(k2);
                    if (e.DEBUG) {
                        Log.d("SwanAppBundleHelper", "configFile path: " + file2.getPath());
                        Log.d("SwanAppBundleHelper", "configFile exist: " + file2.exists());
                        Log.d("SwanAppBundleHelper", "info.mAppBundlePath path: " + fVar.bVR);
                        Log.d("SwanAppBundleHelper", "launchInfo.swanCoreVersion.swanCorePath: " + bVar.YI().swanCorePath);
                    }
                }
            }
            return fVar;
        }

        public static File abH() {
            return Tt();
        }

        public static File Tt() {
            File file = new File(AppRuntime.getAppContext().getFilesDir(), "debug_aiapps_bundle");
            file.mkdirs();
            return file;
        }

        public static File a(com.baidu.swan.apps.as.a.b bVar) {
            File TO = TO();
            File[] listFiles = TO.listFiles();
            if (listFiles == null || listFiles.length == 0) {
                com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), TO.getPath() + " 没有测试程序包!").showToast();
                com.baidu.swan.apps.ap.a nL = new com.baidu.swan.apps.ap.a().bn(5L).bo(4L).nL("没有小程序包! for debug, bundle files are empty");
                com.baidu.swan.apps.ap.e.aow().f(nL);
                if (bVar != null) {
                    bVar.cxK = nL;
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

        public static File TO() {
            File file = new File(ac.getStorageList().get(0).mPath, "/aiapps_debug/");
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }
    }

    /* renamed from: com.baidu.swan.apps.t.e$e  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0332e {
        public static f d(com.baidu.swan.apps.x.b.b bVar) {
            File Tt = Tt();
            com.baidu.swan.apps.console.debugger.a.d.Tz().hP("unzipstart");
            e.a(TN(), Tt, bVar);
            com.baidu.swan.apps.console.debugger.a.d.Tz().hP("unzipend");
            f fVar = new f();
            File file = new File(Tt, "app.json");
            SwanAppConfigData k = SwanAppConfigData.k(com.baidu.swan.d.c.readFileData(file), Tt);
            fVar.bVR = Tt.getPath() + File.separator;
            fVar.bVS = k;
            com.baidu.swan.apps.ag.b.b.a(k, true);
            com.baidu.swan.apps.ag.g.b.b(k);
            if (e.DEBUG) {
                Log.d("SwanAppBundleHelper", "configFile path: " + file.getPath());
                Log.d("SwanAppBundleHelper", "configFile exist: " + file.exists());
                Log.d("SwanAppBundleHelper", "info.mAppBundlePath path: " + fVar.bVR);
            }
            return fVar;
        }

        public static File Tt() {
            File file = new File(AppRuntime.getAppContext().getFilesDir(), "aiapps_remote_debug_folder");
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }

        public static File TN() {
            return new File(TO(), "remote_debug.aiapps");
        }

        public static File TO() {
            File file = new File(AppRuntime.getAppContext().getFilesDir(), "aiapps_remote_debug_zip");
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }
    }
}
