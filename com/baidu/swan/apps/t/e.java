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
/* loaded from: classes9.dex */
public class e {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static ExecutorService bsw = Executors.newSingleThreadExecutor();

    /* loaded from: classes9.dex */
    public interface b {
        void cG(int i);

        void onFailed();

        void onSuccess();
    }

    /* loaded from: classes9.dex */
    public static class c {
        public String mAppId;
        public String mDownloadUrl;
    }

    /* loaded from: classes9.dex */
    public static class f extends com.baidu.swan.apps.t.a {
        public String bsA;
        public SwanAppConfigData bsB;
    }

    public static void a(final com.baidu.swan.apps.x.b.b bVar, final com.baidu.swan.apps.t.b bVar2) {
        String Oo;
        final JSONObject jSONObject = null;
        if (bVar == null || h.ls(bVar.getVersion())) {
            jSONObject = new JSONObject();
            String aeu = ai.aeu();
            if (bVar == null) {
                Oo = "null";
            } else {
                try {
                    Oo = bVar.Oo();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            jSONObject.put("originLaunchInfo", Oo);
            jSONObject.put("stackTraceBefore", aeu);
        }
        bsw.execute(new Runnable() { // from class: com.baidu.swan.apps.t.e.1
            @Override // java.lang.Runnable
            public void run() {
                f a2;
                com.baidu.swan.apps.as.a.b bVar3 = new com.baidu.swan.apps.as.a.b();
                if (com.baidu.swan.apps.ah.a.a.k(com.baidu.swan.apps.x.b.b.this)) {
                    a2 = com.baidu.swan.apps.ah.a.a.a(com.baidu.swan.apps.x.b.b.this, bVar3);
                } else {
                    a2 = d.a(com.baidu.swan.apps.x.b.b.this, bVar3, jSONObject);
                }
                if (a2 == null || a2.bsB == null || a2.bsB.bKM == null) {
                    com.baidu.swan.apps.ap.a aVar = bVar3.bUn;
                    if (aVar == null) {
                        aVar = new com.baidu.swan.apps.ap.a().aB(5L).aC(20L).mh("小程序loadbundle出错，loadinfo为空或者页面配置空 ");
                    }
                    com.baidu.swan.apps.statistic.f.b(new com.baidu.swan.apps.statistic.a.d().lv(com.baidu.swan.apps.statistic.f.ga(com.baidu.swan.apps.x.b.b.this != null ? com.baidu.swan.apps.x.b.b.this.getAppFrameType() : 0)).e(aVar).ly("appjson_config_invalid").a(com.baidu.swan.apps.x.b.b.this));
                }
                bVar2.a(0, a2);
            }
        });
    }

    public static File Rb() {
        return new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "aiapps_folder");
    }

    public static File Rc() {
        return new File(AppRuntime.getAppContext().getFilesDir(), "swan_plugin_workspace");
    }

    public static File hM(String str) {
        if (TextUtils.isEmpty(str)) {
            if (DEBUG) {
                throw new IllegalArgumentException("plugin name can't be empty");
            }
            return null;
        }
        return new File(Rc(), str);
    }

    public static File ax(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            if (DEBUG) {
                throw new IllegalArgumentException("plugin name or version can't be empty");
            }
            return null;
        }
        return new File(hM(str), str2);
    }

    public static boolean a(File file, File file2, com.baidu.swan.apps.x.b.b bVar) {
        return a(file, file2, bVar, null);
    }

    public static synchronized String n(@NonNull File file) {
        String str;
        synchronized (e.class) {
            if (file == null) {
                str = "";
            } else {
                String path = file.getPath();
                if (DEBUG) {
                    Log.d("SwanAppBundleHelper", "getConfigContent path: " + path);
                }
                str = (String) com.baidu.swan.apps.core.k.c.NJ().h(path, "");
                if (TextUtils.isEmpty(str)) {
                    if (DEBUG) {
                        Log.d("SwanAppBundleHelper", "getConfigContent read start: " + path);
                    }
                    str = com.baidu.swan.d.c.readFileData(file);
                    com.baidu.swan.apps.core.k.c.NJ().i(path, str);
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
            com.baidu.swan.apps.ap.a mh = new com.baidu.swan.apps.ap.a().aB(5L).aC(4L).mh("小程序bundle文件不存在或者空文件! ");
            if (bVar2 != null) {
                bVar2.bUn = mh;
                return false;
            }
            return false;
        }
        com.baidu.swan.apps.performance.f.Xi().f(new UbcFlowEvent("package_start_unzip"));
        long currentTimeMillis = System.currentTimeMillis();
        a.b q = com.baidu.swan.apps.t.a.a.q(file);
        if (q.type != -1) {
            unzipFile = com.baidu.swan.apps.t.a.a.a(q.bsL, file2, q.type).isSuccess;
            i = q.type;
        } else {
            unzipFile = com.baidu.swan.d.c.unzipFile(file.getPath(), file2.getPath());
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        if (DEBUG) {
            com.baidu.swan.apps.t.a.a.eN((int) (currentTimeMillis2 - currentTimeMillis));
        }
        if (!unzipFile) {
            com.baidu.swan.apps.ap.a mh2 = new com.baidu.swan.apps.ap.a().aB(5L).aC(7L).mh("小程序bundle解压失败! PkgType=" + i);
            if (bVar2 != null) {
                bVar2.bUn = mh2;
            }
        }
        com.baidu.swan.apps.performance.f.Xi().f(new UbcFlowEvent("package_end_unzip")).aR("app_package_version", String.valueOf(i));
        return unzipFile;
    }

    private static File hN(String str) {
        return new File(Rb(), str);
    }

    private static File ay(String str, String str2) {
        return new File(hN(str), str2);
    }

    public static File a(String str, String str2, boolean z, String str3, @Nullable JSONObject jSONObject) {
        File d2 = d.d(str, str2, jSONObject);
        return (!z || TextUtils.isEmpty(str3)) ? d2 : new File(d2, str3);
    }

    public static File y(String str, String str2, String str3) {
        return new File(ay(str, str2), ag.mA(str3));
    }

    public static boolean z(String str, String str2, String str3) {
        return o(y(str, str2, str3));
    }

    public static boolean az(String str, String str2) {
        return new File(ay(str, str2), "app.json").exists();
    }

    public static boolean o(File file) {
        if (file == null || !file.exists()) {
            return false;
        }
        return new File(file, "app.json").exists();
    }

    /* loaded from: classes9.dex */
    public static class d {
        public static f a(com.baidu.swan.apps.x.b.b bVar, com.baidu.swan.apps.as.a.b bVar2, @Nullable JSONObject jSONObject) {
            if (bVar == null) {
                return null;
            }
            File a = e.a(bVar.getAppId(), bVar.getVersion(), bVar.Tq(), bVar.Tr(), jSONObject);
            if (!a.exists()) {
                File a2 = a(bVar.getAppId(), true, bVar2);
                if (a2 != null) {
                    if (!e.a(a2, p(a), bVar, bVar2)) {
                        com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "小程序bundle解压失败!").showToast();
                        com.baidu.swan.apps.ap.a mh = new com.baidu.swan.apps.ap.a().aB(5L).aC(7L).mh("小程序bundle解压失败! for release");
                        com.baidu.swan.apps.ap.e.adF().f(mh);
                        if (bVar2 == null || bVar2.bUn != null) {
                            return null;
                        }
                        bVar2.bUn = mh;
                        return null;
                    }
                } else {
                    com.baidu.swan.apps.process.messaging.client.a.Yi().a(8, new SwanAppDeleteInfo(bVar.getAppId(), 1));
                    com.baidu.swan.apps.statistic.f.b(new com.baidu.swan.apps.statistic.a.d().lv(com.baidu.swan.apps.statistic.f.ga(bVar.getAppFrameType())).e(new com.baidu.swan.apps.ap.a().aB(5L).aC(31L).mh("小程序zip和bundle不存在，兜底重置")).a(bVar));
                    if (e.DEBUG) {
                        Log.w("SwanAppBundleHelper", "20050004：reset aiapps");
                        return null;
                    }
                    return null;
                }
            }
            aB(bVar.getAppId(), bVar.getVersion());
            f fVar = new f();
            File file = new File(a, "app.json");
            SwanAppConfigData l = SwanAppConfigData.l(e.n(file), a);
            if (l != null) {
                fVar.bsA = aA(bVar.getAppId(), bVar.getVersion()).getPath() + File.separator;
                fVar.bsB = l;
                com.baidu.swan.apps.ag.b.b.a(l, true);
                com.baidu.swan.apps.ag.g.b.b(l);
                if (e.DEBUG) {
                    Log.d("SwanAppBundleHelper", "configFile path: " + file.getPath());
                    Log.d("SwanAppBundleHelper", "configFile exist: " + file.exists());
                    Log.d("SwanAppBundleHelper", "info.mAppBundlePath path: " + fVar.bsA);
                    Log.d("SwanAppBundleHelper", "launchInfo.swanCoreVersion.swanCorePath: " + bVar.Oe().swanCorePath);
                }
                return fVar;
            }
            return null;
        }

        public static File p(File file) {
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }

        public static File aA(String str, String str2) {
            return d(str, str2, null);
        }

        public static File d(String str, String str2, @Nullable JSONObject jSONObject) {
            if (h.ls(str2)) {
                h.e(str, str2, jSONObject);
            }
            return new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "aiapps_folder" + File.separator + str, str2);
        }

        public static void hO(String str) {
            if (!TextUtils.isEmpty(str)) {
                File v = v(str, false);
                if (v != null) {
                    com.baidu.swan.d.c.deleteFile(v);
                }
                com.baidu.swan.d.c.deleteFile(new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "aiapps_folder" + File.separator + str));
            }
        }

        public static void aB(String str, String str2) {
            File[] listFiles;
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && (listFiles = new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "aiapps_folder", str).listFiles(new FileFilter() { // from class: com.baidu.swan.apps.t.e.d.1
                @Override // java.io.FileFilter
                public boolean accept(File file) {
                    return file.isDirectory() && TextUtils.isDigitsOnly(file.getName());
                }
            })) != null && listFiles.length > 0) {
                for (File file : listFiles) {
                    if (aC(str2, file.getName())) {
                        if (e.DEBUG) {
                            Log.i("SwanAppBundleHelper", "删除低版本文件夹：" + file.getAbsolutePath());
                        }
                        com.baidu.swan.pms.database.a.aqM().bS(str, file.getName());
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
            File Re;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            File[] listFiles = Re().listFiles();
            if (listFiles == null || listFiles.length == 0) {
                if (e.DEBUG && z) {
                    com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), Re.getPath() + " 没有小程序包!").showToast();
                }
                com.baidu.swan.apps.ap.a mh = new com.baidu.swan.apps.ap.a().aB(5L).aC(4L).mh("没有小程序包! for release, bundle files are empty");
                com.baidu.swan.apps.ap.e.adF().f(mh);
                if (bVar != null) {
                    bVar.bUn = mh;
                }
                return null;
            }
            for (File file : listFiles) {
                if (TextUtils.equals(file.getName(), str + ".aiapps")) {
                    return file;
                }
            }
            if (e.DEBUG && z) {
                com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), Re.getPath() + " 没有小程序包!").showToast();
            }
            com.baidu.swan.apps.ap.a mh2 = new com.baidu.swan.apps.ap.a().aB(5L).aC(4L).mh("没有小程序包! for release, no such bundle file");
            com.baidu.swan.apps.ap.e.adF().f(mh2);
            if (bVar != null) {
                bVar.bUn = mh2;
            }
            return null;
        }

        public static File Re() {
            File file = new File(AppRuntime.getAppContext().getFilesDir(), "aiapps_zip");
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }

        private static boolean aC(String str, String str2) {
            if (e.DEBUG) {
                Log.i("SwanAppBundleHelper", "curVersion:" + str + ",targetVersion:" + str2);
            }
            try {
                return aD(str, str2) > 0;
            } catch (IllegalArgumentException e) {
                if (e.DEBUG) {
                    Log.e("SwanAppBundleHelper", "比较版本号Exception：" + e.getMessage());
                    return false;
                }
                return false;
            }
        }

        private static long aD(String str, String str2) throws IllegalArgumentException {
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
        new com.baidu.swan.apps.l.a().a(cVar, a.Jk().getPath() + File.separator + String.valueOf(System.currentTimeMillis()) + ".aibundle", bVar);
    }

    public static void a(String str, b bVar) {
        c cVar = new c();
        cVar.mDownloadUrl = str;
        com.baidu.swan.apps.swancore.c.a.Pi();
        new com.baidu.swan.apps.l.a().a(cVar, com.baidu.swan.apps.swancore.c.a.Pj().getPath(), bVar);
    }

    public static void b(String str, b bVar) {
        c cVar = new c();
        cVar.mDownloadUrl = str;
        com.baidu.swan.apps.extcore.d.b.Pi();
        new com.baidu.swan.apps.l.a().a(cVar, com.baidu.swan.apps.extcore.d.b.Pj().getPath(), bVar);
    }

    /* loaded from: classes9.dex */
    public static class a {
        /* JADX WARN: Removed duplicated region for block: B:19:0x00b2  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static f a(com.baidu.swan.apps.x.b.b bVar, com.baidu.swan.apps.as.a.b bVar2) {
            f fVar = null;
            File a = a(bVar2);
            if (a != null) {
                com.baidu.swan.apps.runtime.e ZS = com.baidu.swan.apps.runtime.e.ZS();
                if (ZS == null) {
                    if (!e.a(a, IP(), bVar, bVar2)) {
                        com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "小程序bundle解压失败!").showToast();
                        com.baidu.swan.apps.ap.a mh = new com.baidu.swan.apps.ap.a().aB(5L).aC(7L).mh("小程序bundle解压失败! for debug");
                        com.baidu.swan.apps.ap.e.adF().f(mh);
                        if (bVar2 != null && bVar2.bUn == null) {
                            bVar2.bUn = mh;
                        }
                    }
                    fVar = new f();
                    File Rd = Rd();
                    File file = new File(Rd, "app.json");
                    SwanAppConfigData l = SwanAppConfigData.l(com.baidu.swan.d.c.readFileData(file), Rd);
                    fVar.bsA = Rd.getPath() + File.separator;
                    fVar.bsB = l;
                    com.baidu.swan.apps.ag.b.b.a(l, true);
                    com.baidu.swan.apps.ag.g.b.b(l);
                    if (e.DEBUG) {
                    }
                } else {
                    String string = ZS.aac().getString("installed_debug_bundle_md5", "");
                    String md5 = com.baidu.swan.d.d.toMd5(a, false);
                    if (!TextUtils.equals(string, md5)) {
                        if (!e.a(a, IP(), bVar, bVar2)) {
                            com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "小程序bundle解压失败!").showToast();
                            com.baidu.swan.apps.ap.a mh2 = new com.baidu.swan.apps.ap.a().aB(5L).aC(7L).mh("小程序bundle解压失败! for debug");
                            com.baidu.swan.apps.ap.e.adF().f(mh2);
                            if (bVar2 != null && bVar2.bUn == null) {
                                bVar2.bUn = mh2;
                            }
                        } else {
                            ZS.aac().putString("installed_debug_bundle_md5", md5);
                        }
                    }
                    fVar = new f();
                    File Rd2 = Rd();
                    File file2 = new File(Rd2, "app.json");
                    SwanAppConfigData l2 = SwanAppConfigData.l(com.baidu.swan.d.c.readFileData(file2), Rd2);
                    fVar.bsA = Rd2.getPath() + File.separator;
                    fVar.bsB = l2;
                    com.baidu.swan.apps.ag.b.b.a(l2, true);
                    com.baidu.swan.apps.ag.g.b.b(l2);
                    if (e.DEBUG) {
                        Log.d("SwanAppBundleHelper", "configFile path: " + file2.getPath());
                        Log.d("SwanAppBundleHelper", "configFile exist: " + file2.exists());
                        Log.d("SwanAppBundleHelper", "info.mAppBundlePath path: " + fVar.bsA);
                        Log.d("SwanAppBundleHelper", "launchInfo.swanCoreVersion.swanCorePath: " + bVar.Oe().swanCorePath);
                    }
                }
            }
            return fVar;
        }

        public static File Rd() {
            return IP();
        }

        public static File IP() {
            File file = new File(AppRuntime.getAppContext().getFilesDir(), "debug_aiapps_bundle");
            file.mkdirs();
            return file;
        }

        public static File a(com.baidu.swan.apps.as.a.b bVar) {
            File Jk = Jk();
            File[] listFiles = Jk.listFiles();
            if (listFiles == null || listFiles.length == 0) {
                com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), Jk.getPath() + " 没有测试程序包!").showToast();
                com.baidu.swan.apps.ap.a mh = new com.baidu.swan.apps.ap.a().aB(5L).aC(4L).mh("没有小程序包! for debug, bundle files are empty");
                com.baidu.swan.apps.ap.e.adF().f(mh);
                if (bVar != null) {
                    bVar.bUn = mh;
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

        public static File Jk() {
            File file = new File(ac.getStorageList().get(0).mPath, "/aiapps_debug/");
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }
    }

    /* renamed from: com.baidu.swan.apps.t.e$e  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C0290e {
        public static f d(com.baidu.swan.apps.x.b.b bVar) {
            File IP = IP();
            com.baidu.swan.apps.console.debugger.a.d.IV().gk("unzipstart");
            e.a(Jj(), IP, bVar);
            com.baidu.swan.apps.console.debugger.a.d.IV().gk("unzipend");
            f fVar = new f();
            File file = new File(IP, "app.json");
            SwanAppConfigData l = SwanAppConfigData.l(com.baidu.swan.d.c.readFileData(file), IP);
            fVar.bsA = IP.getPath() + File.separator;
            fVar.bsB = l;
            com.baidu.swan.apps.ag.b.b.a(l, true);
            com.baidu.swan.apps.ag.g.b.b(l);
            if (e.DEBUG) {
                Log.d("SwanAppBundleHelper", "configFile path: " + file.getPath());
                Log.d("SwanAppBundleHelper", "configFile exist: " + file.exists());
                Log.d("SwanAppBundleHelper", "info.mAppBundlePath path: " + fVar.bsA);
            }
            return fVar;
        }

        public static File IP() {
            File file = new File(AppRuntime.getAppContext().getFilesDir(), "aiapps_remote_debug_folder");
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }

        public static File Jj() {
            return new File(Jk(), "remote_debug.aiapps");
        }

        public static File Jk() {
            File file = new File(AppRuntime.getAppContext().getFilesDir(), "aiapps_remote_debug_zip");
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }
    }
}
