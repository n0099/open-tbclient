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
    private static ExecutorService bxu = Executors.newSingleThreadExecutor();

    /* loaded from: classes11.dex */
    public interface b {
        void cX(int i);

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
        public String bxy;
        public SwanAppConfigData bxz;
    }

    public static void a(final com.baidu.swan.apps.x.b.b bVar, final com.baidu.swan.apps.t.b bVar2) {
        String QY;
        final JSONObject jSONObject = null;
        if (bVar == null || h.lK(bVar.getVersion())) {
            jSONObject = new JSONObject();
            String ahb = ai.ahb();
            if (bVar == null) {
                QY = "null";
            } else {
                try {
                    QY = bVar.QY();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            jSONObject.put("originLaunchInfo", QY);
            jSONObject.put("stackTraceBefore", ahb);
        }
        bxu.execute(new Runnable() { // from class: com.baidu.swan.apps.t.e.1
            @Override // java.lang.Runnable
            public void run() {
                f a2;
                com.baidu.swan.apps.as.a.b bVar3 = new com.baidu.swan.apps.as.a.b();
                if (com.baidu.swan.apps.ah.a.a.k(com.baidu.swan.apps.x.b.b.this)) {
                    a2 = com.baidu.swan.apps.ah.a.a.a(com.baidu.swan.apps.x.b.b.this, bVar3);
                } else {
                    a2 = d.a(com.baidu.swan.apps.x.b.b.this, bVar3, jSONObject);
                }
                if (a2 == null || a2.bxz == null || a2.bxz.bPB == null) {
                    com.baidu.swan.apps.ap.a aVar = bVar3.bYD;
                    if (aVar == null) {
                        aVar = new com.baidu.swan.apps.ap.a().aI(5L).aJ(20L).mz("小程序loadbundle出错，loadinfo为空或者页面配置空 ");
                    }
                    com.baidu.swan.apps.statistic.f.b(new com.baidu.swan.apps.statistic.a.d().lN(com.baidu.swan.apps.statistic.f.gs(com.baidu.swan.apps.x.b.b.this != null ? com.baidu.swan.apps.x.b.b.this.getAppFrameType() : 0)).e(aVar).lQ("appjson_config_invalid").a(com.baidu.swan.apps.x.b.b.this));
                }
                bVar2.a(0, a2);
            }
        });
    }

    public static File TL() {
        return new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "aiapps_folder");
    }

    public static File TM() {
        return new File(AppRuntime.getAppContext().getFilesDir(), "swan_plugin_workspace");
    }

    /* renamed from: if  reason: not valid java name */
    public static File m26if(String str) {
        if (TextUtils.isEmpty(str)) {
            if (DEBUG) {
                throw new IllegalArgumentException("plugin name can't be empty");
            }
            return null;
        }
        return new File(TM(), str);
    }

    public static File aI(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            if (DEBUG) {
                throw new IllegalArgumentException("plugin name or version can't be empty");
            }
            return null;
        }
        return new File(m26if(str), str2);
    }

    public static boolean a(File file, File file2, com.baidu.swan.apps.x.b.b bVar) {
        return a(file, file2, bVar, null);
    }

    public static synchronized String o(@NonNull File file) {
        String str;
        synchronized (e.class) {
            if (file == null) {
                str = "";
            } else {
                String path = file.getPath();
                if (DEBUG) {
                    Log.d("SwanAppBundleHelper", "getConfigContent path: " + path);
                }
                str = (String) com.baidu.swan.apps.core.k.c.Qt().h(path, "");
                if (TextUtils.isEmpty(str)) {
                    if (DEBUG) {
                        Log.d("SwanAppBundleHelper", "getConfigContent read start: " + path);
                    }
                    str = com.baidu.swan.d.c.readFileData(file);
                    com.baidu.swan.apps.core.k.c.Qt().i(path, str);
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
            com.baidu.swan.apps.ap.a mz = new com.baidu.swan.apps.ap.a().aI(5L).aJ(4L).mz("小程序bundle文件不存在或者空文件! ");
            if (bVar2 != null) {
                bVar2.bYD = mz;
                return false;
            }
            return false;
        }
        com.baidu.swan.apps.performance.f.ZT().f(new UbcFlowEvent("package_start_unzip"));
        long currentTimeMillis = System.currentTimeMillis();
        a.b r = com.baidu.swan.apps.t.a.a.r(file);
        if (r.type != -1) {
            unzipFile = com.baidu.swan.apps.t.a.a.a(r.bxJ, file2, r.type).isSuccess;
            i = r.type;
        } else {
            unzipFile = com.baidu.swan.d.c.unzipFile(file.getPath(), file2.getPath());
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        if (DEBUG) {
            com.baidu.swan.apps.t.a.a.fe((int) (currentTimeMillis2 - currentTimeMillis));
        }
        if (!unzipFile) {
            com.baidu.swan.apps.ap.a mz2 = new com.baidu.swan.apps.ap.a().aI(5L).aJ(7L).mz("小程序bundle解压失败! PkgType=" + i);
            if (bVar2 != null) {
                bVar2.bYD = mz2;
            }
        }
        com.baidu.swan.apps.performance.f.ZT().f(new UbcFlowEvent("package_end_unzip")).bb("app_package_version", String.valueOf(i));
        return unzipFile;
    }

    private static File ig(String str) {
        return new File(TL(), str);
    }

    private static File aJ(String str, String str2) {
        return new File(ig(str), str2);
    }

    public static File a(String str, String str2, boolean z, String str3, @Nullable JSONObject jSONObject) {
        File d2 = d.d(str, str2, jSONObject);
        return (!z || TextUtils.isEmpty(str3)) ? d2 : new File(d2, str3);
    }

    public static File z(String str, String str2, String str3) {
        return new File(aJ(str, str2), ag.mS(str3));
    }

    public static boolean A(String str, String str2, String str3) {
        return p(z(str, str2, str3));
    }

    public static boolean aK(String str, String str2) {
        return new File(aJ(str, str2), "app.json").exists();
    }

    public static boolean p(File file) {
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
            File a = e.a(bVar.getAppId(), bVar.getVersion(), bVar.Wb(), bVar.Wc(), jSONObject);
            if (!a.exists()) {
                File a2 = a(bVar.getAppId(), true, bVar2);
                if (a2 != null) {
                    if (!e.a(a2, q(a), bVar, bVar2)) {
                        com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "小程序bundle解压失败!").showToast();
                        com.baidu.swan.apps.ap.a mz = new com.baidu.swan.apps.ap.a().aI(5L).aJ(7L).mz("小程序bundle解压失败! for release");
                        com.baidu.swan.apps.ap.e.agm().f(mz);
                        if (bVar2 == null || bVar2.bYD != null) {
                            return null;
                        }
                        bVar2.bYD = mz;
                        return null;
                    }
                } else {
                    com.baidu.swan.apps.process.messaging.client.a.aaT().a(8, new SwanAppDeleteInfo(bVar.getAppId(), 1));
                    com.baidu.swan.apps.statistic.f.b(new com.baidu.swan.apps.statistic.a.d().lN(com.baidu.swan.apps.statistic.f.gs(bVar.getAppFrameType())).e(new com.baidu.swan.apps.ap.a().aI(5L).aJ(31L).mz("小程序zip和bundle不存在，兜底重置")).a(bVar));
                    if (e.DEBUG) {
                        Log.w("SwanAppBundleHelper", "20050004：reset aiapps");
                        return null;
                    }
                    return null;
                }
            }
            aM(bVar.getAppId(), bVar.getVersion());
            f fVar = new f();
            File file = new File(a, "app.json");
            SwanAppConfigData l = SwanAppConfigData.l(e.o(file), a);
            if (l != null) {
                fVar.bxy = aL(bVar.getAppId(), bVar.getVersion()).getPath() + File.separator;
                fVar.bxz = l;
                com.baidu.swan.apps.ag.b.b.a(l, true);
                com.baidu.swan.apps.ag.g.b.b(l);
                if (e.DEBUG) {
                    Log.d("SwanAppBundleHelper", "configFile path: " + file.getPath());
                    Log.d("SwanAppBundleHelper", "configFile exist: " + file.exists());
                    Log.d("SwanAppBundleHelper", "info.mAppBundlePath path: " + fVar.bxy);
                    Log.d("SwanAppBundleHelper", "launchInfo.swanCoreVersion.swanCorePath: " + bVar.QO().swanCorePath);
                }
                return fVar;
            }
            return null;
        }

        public static File q(File file) {
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }

        public static File aL(String str, String str2) {
            return d(str, str2, null);
        }

        public static File d(String str, String str2, @Nullable JSONObject jSONObject) {
            if (h.lK(str2)) {
                h.e(str, str2, jSONObject);
            }
            return new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "aiapps_folder" + File.separator + str, str2);
        }

        public static void ih(String str) {
            if (!TextUtils.isEmpty(str)) {
                File v = v(str, false);
                if (v != null) {
                    com.baidu.swan.d.c.deleteFile(v);
                }
                com.baidu.swan.d.c.deleteFile(new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "aiapps_folder" + File.separator + str));
            }
        }

        public static void aM(String str, String str2) {
            File[] listFiles;
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && (listFiles = new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "aiapps_folder", str).listFiles(new FileFilter() { // from class: com.baidu.swan.apps.t.e.d.1
                @Override // java.io.FileFilter
                public boolean accept(File file) {
                    return file.isDirectory() && TextUtils.isDigitsOnly(file.getName());
                }
            })) != null && listFiles.length > 0) {
                for (File file : listFiles) {
                    if (aN(str2, file.getName())) {
                        if (e.DEBUG) {
                            Log.i("SwanAppBundleHelper", "删除低版本文件夹：" + file.getAbsolutePath());
                        }
                        com.baidu.swan.pms.database.a.att().cc(str, file.getName());
                        com.baidu.swan.d.c.deleteFile(file);
                    }
                }
            }
        }

        @Nullable
        public static File v(String str, boolean z) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return a(str, z, (com.baidu.swan.apps.as.a.b) null);
        }

        public static File a(String str, boolean z, com.baidu.swan.apps.as.a.b bVar) {
            File TO;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            File[] listFiles = TO().listFiles();
            if (listFiles == null || listFiles.length == 0) {
                if (e.DEBUG && z) {
                    com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), TO.getPath() + " 没有小程序包!").showToast();
                }
                com.baidu.swan.apps.ap.a mz = new com.baidu.swan.apps.ap.a().aI(5L).aJ(4L).mz("没有小程序包! for release, bundle files are empty");
                com.baidu.swan.apps.ap.e.agm().f(mz);
                if (bVar != null) {
                    bVar.bYD = mz;
                }
                return null;
            }
            for (File file : listFiles) {
                if (TextUtils.equals(file.getName(), str + ".aiapps")) {
                    return file;
                }
            }
            if (e.DEBUG && z) {
                com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), TO.getPath() + " 没有小程序包!").showToast();
            }
            com.baidu.swan.apps.ap.a mz2 = new com.baidu.swan.apps.ap.a().aI(5L).aJ(4L).mz("没有小程序包! for release, no such bundle file");
            com.baidu.swan.apps.ap.e.agm().f(mz2);
            if (bVar != null) {
                bVar.bYD = mz2;
            }
            return null;
        }

        public static File TO() {
            File file = new File(AppRuntime.getAppContext().getFilesDir(), "aiapps_zip");
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }

        private static boolean aN(String str, String str2) {
            if (e.DEBUG) {
                Log.i("SwanAppBundleHelper", "curVersion:" + str + ",targetVersion:" + str2);
            }
            try {
                return aO(str, str2) > 0;
            } catch (IllegalArgumentException e) {
                if (e.DEBUG) {
                    Log.e("SwanAppBundleHelper", "比较版本号Exception：" + e.getMessage());
                    return false;
                }
                return false;
            }
        }

        private static long aO(String str, String str2) throws IllegalArgumentException {
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
        new com.baidu.swan.apps.l.a().a(cVar, a.LV().getPath() + File.separator + String.valueOf(System.currentTimeMillis()) + ".aibundle", bVar);
    }

    public static void a(String str, b bVar) {
        c cVar = new c();
        cVar.mDownloadUrl = str;
        com.baidu.swan.apps.swancore.c.a.RS();
        new com.baidu.swan.apps.l.a().a(cVar, com.baidu.swan.apps.swancore.c.a.RT().getPath(), bVar);
    }

    public static void b(String str, b bVar) {
        c cVar = new c();
        cVar.mDownloadUrl = str;
        com.baidu.swan.apps.extcore.d.b.RS();
        new com.baidu.swan.apps.l.a().a(cVar, com.baidu.swan.apps.extcore.d.b.RT().getPath(), bVar);
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
                com.baidu.swan.apps.runtime.e acD = com.baidu.swan.apps.runtime.e.acD();
                if (acD == null) {
                    if (!e.a(a, LA(), bVar, bVar2)) {
                        com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "小程序bundle解压失败!").showToast();
                        com.baidu.swan.apps.ap.a mz = new com.baidu.swan.apps.ap.a().aI(5L).aJ(7L).mz("小程序bundle解压失败! for debug");
                        com.baidu.swan.apps.ap.e.agm().f(mz);
                        if (bVar2 != null && bVar2.bYD == null) {
                            bVar2.bYD = mz;
                        }
                    }
                    fVar = new f();
                    File TN = TN();
                    File file = new File(TN, "app.json");
                    SwanAppConfigData l = SwanAppConfigData.l(com.baidu.swan.d.c.readFileData(file), TN);
                    fVar.bxy = TN.getPath() + File.separator;
                    fVar.bxz = l;
                    com.baidu.swan.apps.ag.b.b.a(l, true);
                    com.baidu.swan.apps.ag.g.b.b(l);
                    if (e.DEBUG) {
                    }
                } else {
                    String string = acD.acN().getString("installed_debug_bundle_md5", "");
                    String md5 = com.baidu.swan.d.d.toMd5(a, false);
                    if (!TextUtils.equals(string, md5)) {
                        if (!e.a(a, LA(), bVar, bVar2)) {
                            com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "小程序bundle解压失败!").showToast();
                            com.baidu.swan.apps.ap.a mz2 = new com.baidu.swan.apps.ap.a().aI(5L).aJ(7L).mz("小程序bundle解压失败! for debug");
                            com.baidu.swan.apps.ap.e.agm().f(mz2);
                            if (bVar2 != null && bVar2.bYD == null) {
                                bVar2.bYD = mz2;
                            }
                        } else {
                            acD.acN().putString("installed_debug_bundle_md5", md5);
                        }
                    }
                    fVar = new f();
                    File TN2 = TN();
                    File file2 = new File(TN2, "app.json");
                    SwanAppConfigData l2 = SwanAppConfigData.l(com.baidu.swan.d.c.readFileData(file2), TN2);
                    fVar.bxy = TN2.getPath() + File.separator;
                    fVar.bxz = l2;
                    com.baidu.swan.apps.ag.b.b.a(l2, true);
                    com.baidu.swan.apps.ag.g.b.b(l2);
                    if (e.DEBUG) {
                        Log.d("SwanAppBundleHelper", "configFile path: " + file2.getPath());
                        Log.d("SwanAppBundleHelper", "configFile exist: " + file2.exists());
                        Log.d("SwanAppBundleHelper", "info.mAppBundlePath path: " + fVar.bxy);
                        Log.d("SwanAppBundleHelper", "launchInfo.swanCoreVersion.swanCorePath: " + bVar.QO().swanCorePath);
                    }
                }
            }
            return fVar;
        }

        public static File TN() {
            return LA();
        }

        public static File LA() {
            File file = new File(AppRuntime.getAppContext().getFilesDir(), "debug_aiapps_bundle");
            file.mkdirs();
            return file;
        }

        public static File a(com.baidu.swan.apps.as.a.b bVar) {
            File LV = LV();
            File[] listFiles = LV.listFiles();
            if (listFiles == null || listFiles.length == 0) {
                com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), LV.getPath() + " 没有测试程序包!").showToast();
                com.baidu.swan.apps.ap.a mz = new com.baidu.swan.apps.ap.a().aI(5L).aJ(4L).mz("没有小程序包! for debug, bundle files are empty");
                com.baidu.swan.apps.ap.e.agm().f(mz);
                if (bVar != null) {
                    bVar.bYD = mz;
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

        public static File LV() {
            File file = new File(ac.getStorageList().get(0).mPath, "/aiapps_debug/");
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }
    }

    /* renamed from: com.baidu.swan.apps.t.e$e  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0302e {
        public static f d(com.baidu.swan.apps.x.b.b bVar) {
            File LA = LA();
            com.baidu.swan.apps.console.debugger.a.d.LG().gD("unzipstart");
            e.a(LU(), LA, bVar);
            com.baidu.swan.apps.console.debugger.a.d.LG().gD("unzipend");
            f fVar = new f();
            File file = new File(LA, "app.json");
            SwanAppConfigData l = SwanAppConfigData.l(com.baidu.swan.d.c.readFileData(file), LA);
            fVar.bxy = LA.getPath() + File.separator;
            fVar.bxz = l;
            com.baidu.swan.apps.ag.b.b.a(l, true);
            com.baidu.swan.apps.ag.g.b.b(l);
            if (e.DEBUG) {
                Log.d("SwanAppBundleHelper", "configFile path: " + file.getPath());
                Log.d("SwanAppBundleHelper", "configFile exist: " + file.exists());
                Log.d("SwanAppBundleHelper", "info.mAppBundlePath path: " + fVar.bxy);
            }
            return fVar;
        }

        public static File LA() {
            File file = new File(AppRuntime.getAppContext().getFilesDir(), "aiapps_remote_debug_folder");
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }

        public static File LU() {
            return new File(LV(), "remote_debug.aiapps");
        }

        public static File LV() {
            File file = new File(AppRuntime.getAppContext().getFilesDir(), "aiapps_remote_debug_zip");
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }
    }
}
