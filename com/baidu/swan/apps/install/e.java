package com.baidu.swan.apps.install;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.an.ac;
import com.baidu.swan.apps.an.x;
import com.baidu.swan.apps.env.SwanAppDeleteInfo;
import com.baidu.swan.apps.install.subpackage.SubPackageAPSInfo;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileFilter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class e {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static ExecutorService aRZ = Executors.newSingleThreadExecutor();

    /* loaded from: classes2.dex */
    public interface b {
        void cr(int i);

        void onFailed();

        void onSuccess();
    }

    /* loaded from: classes2.dex */
    public static class c {
        public String mAppId;
        public String mDownloadUrl;
    }

    /* loaded from: classes2.dex */
    public static class g extends com.baidu.swan.apps.install.a {
        public String aSd;
        public com.baidu.swan.apps.ae.a.c aSe;
    }

    public static void a(final com.baidu.swan.apps.v.b.b bVar, final com.baidu.swan.apps.install.b bVar2) {
        String Hs;
        final JSONObject jSONObject = null;
        if (bVar == null || com.baidu.swan.apps.statistic.f.hZ(bVar.getVersion())) {
            jSONObject = new JSONObject();
            String UD = ac.UD();
            if (bVar == null) {
                Hs = "null";
            } else {
                try {
                    Hs = bVar.Hs();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            jSONObject.put("originLaunchInfo", Hs);
            jSONObject.put("stackTraceBefore", UD);
        }
        aRZ.execute(new Runnable() { // from class: com.baidu.swan.apps.install.e.1
            @Override // java.lang.Runnable
            public void run() {
                g a2;
                com.baidu.swan.apps.an.a.b bVar3 = new com.baidu.swan.apps.an.a.b();
                if (com.baidu.swan.apps.ac.a.a.l(com.baidu.swan.apps.v.b.b.this)) {
                    a2 = com.baidu.swan.apps.ac.a.a.a(com.baidu.swan.apps.v.b.b.this, bVar3);
                } else {
                    a2 = d.a(com.baidu.swan.apps.v.b.b.this, bVar3, jSONObject);
                }
                if (a2 == null || a2.aSe == null || a2.aSe.bkz == null) {
                    com.baidu.swan.apps.ak.a aVar = bVar3.btO;
                    if (aVar == null) {
                        aVar = new com.baidu.swan.apps.ak.a().as(5L).at(20L).iL("小程序loadbundle出错，loadinfo为空或者页面配置空 ");
                    }
                    com.baidu.swan.apps.statistic.e.b(new com.baidu.swan.apps.statistic.a.d().ia(com.baidu.swan.apps.statistic.e.eL(com.baidu.swan.apps.v.b.b.this != null ? com.baidu.swan.apps.v.b.b.this.KO() : 0)).a(aVar).ie("appjson_config_invalid").s(com.baidu.swan.apps.v.b.b.this));
                    com.baidu.swan.apps.statistic.b.c.c(new com.baidu.swan.apps.statistic.b.a(BdStatsConstant.StatsType.ERROR, String.valueOf(System.currentTimeMillis()), String.valueOf(aVar.TP())));
                } else {
                    com.baidu.swan.apps.statistic.b.c.c(new com.baidu.swan.apps.statistic.b.a("narun"));
                }
                bVar2.a(0, a2);
            }
        });
    }

    public static File IX() {
        return new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "aiapps_folder");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean a(File file, File file2, com.baidu.swan.apps.v.b.b bVar) {
        return a(file, file2, bVar, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean a(File file, File file2, com.baidu.swan.apps.v.b.b bVar, com.baidu.swan.apps.an.a.b bVar2) {
        boolean z = false;
        if (file != null && file2 != null) {
            if (!file.exists() || file.length() == 0) {
                com.baidu.swan.apps.ak.a iL = new com.baidu.swan.apps.ak.a().as(5L).at(4L).iL("小程序bundle文件不存在或者空文件! ");
                if (bVar2 != null) {
                    bVar2.btO = iL;
                }
            } else {
                com.baidu.swan.apps.performance.f.NJ().f(new UbcFlowEvent("package_start_unzip"));
                long currentTimeMillis = System.currentTimeMillis();
                BufferedInputStream h = com.baidu.swan.apps.install.a.a.h(file);
                if (h != null) {
                    z = com.baidu.swan.apps.install.a.a.a(h, file2).isSuccess;
                } else {
                    z = com.baidu.swan.c.a.bz(file.getPath(), file2.getPath());
                }
                long currentTimeMillis2 = System.currentTimeMillis();
                if (DEBUG) {
                    com.baidu.swan.apps.install.a.a.dw((int) (currentTimeMillis2 - currentTimeMillis));
                }
                if (!z) {
                    com.baidu.swan.apps.ak.a iL2 = new com.baidu.swan.apps.ak.a().as(5L).at(7L).iL("小程序bundle解压失败! ");
                    if (bVar2 != null) {
                        bVar2.btO = iL2;
                    }
                }
                com.baidu.swan.apps.performance.f.NJ().f(new UbcFlowEvent("package_end_unzip"));
            }
        }
        return z;
    }

    /* loaded from: classes2.dex */
    public static class d {
        public static g a(com.baidu.swan.apps.v.b.b bVar, com.baidu.swan.apps.an.a.b bVar2, @Nullable JSONObject jSONObject) {
            if (bVar == null) {
                return null;
            }
            File b = b(bVar.getAppId(), bVar.getVersion(), jSONObject);
            if (!b.exists()) {
                File a = a(bVar.getAppId(), true, bVar2);
                if (a != null) {
                    if (!e.a(a, g(b), bVar, bVar2)) {
                        com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "小程序bundle解压失败!").QN();
                        com.baidu.swan.apps.ak.a iL = new com.baidu.swan.apps.ak.a().as(5L).at(7L).iL("小程序bundle解压失败! for release");
                        com.baidu.swan.apps.ak.e.TT().b(iL);
                        if (bVar2 == null || bVar2.btO != null) {
                            return null;
                        }
                        bVar2.btO = iL;
                        return null;
                    }
                } else {
                    com.baidu.swan.apps.process.messaging.client.a.Op().a(8, new SwanAppDeleteInfo(bVar.getAppId(), 1));
                    com.baidu.swan.apps.statistic.e.b(new com.baidu.swan.apps.statistic.a.d().ia(com.baidu.swan.apps.statistic.e.eL(bVar.KO())).a(new com.baidu.swan.apps.ak.a().as(5L).at(31L).iL("小程序zip和bundle不存在，兜底重置")).s(bVar));
                    if (e.DEBUG) {
                        Log.w("SwanAppBundleHelper", "20050004：reset aiapps");
                        return null;
                    }
                    return null;
                }
            }
            an(bVar.getAppId(), bVar.getVersion());
            g gVar = new g();
            File file = new File(b, "app.json");
            com.baidu.swan.apps.ae.a.c hs = com.baidu.swan.apps.ae.a.c.hs(com.baidu.swan.c.a.l(file));
            if (hs != null) {
                gVar.aSd = b.getPath() + File.separator;
                gVar.aSe = hs;
                if (e.DEBUG) {
                    Log.d("SwanAppBundleHelper", "configFile path: " + file.getPath());
                    Log.d("SwanAppBundleHelper", "configFile exist: " + file.exists());
                    Log.d("SwanAppBundleHelper", "info.mAppBundlePath path: " + gVar.aSd);
                    Log.d("SwanAppBundleHelper", "launchInfo.swanCoreVersion.swanCorePath: " + bVar.Hg().bql);
                }
                return gVar;
            }
            return null;
        }

        public static File g(File file) {
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }

        public static File am(String str, String str2) {
            return b(str, str2, null);
        }

        public static File b(String str, String str2, @Nullable JSONObject jSONObject) {
            if (com.baidu.swan.apps.statistic.f.hZ(str2)) {
                com.baidu.swan.apps.statistic.f.c(str, str2, jSONObject);
            }
            return new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "aiapps_folder" + File.separator + str, str2);
        }

        public static void fn(String str) {
            if (!TextUtils.isEmpty(str)) {
                File t = t(str, false);
                if (t != null) {
                    com.baidu.swan.c.a.deleteFile(t);
                }
                com.baidu.swan.c.a.deleteFile(new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "aiapps_folder" + File.separator + str));
            }
        }

        public static void an(String str, String str2) {
            File[] listFiles;
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && (listFiles = new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "aiapps_folder", str).listFiles(new FileFilter() { // from class: com.baidu.swan.apps.install.e.d.1
                @Override // java.io.FileFilter
                public boolean accept(File file) {
                    return file.isDirectory() && TextUtils.isDigitsOnly(file.getName());
                }
            })) != null && listFiles.length > 0) {
                for (File file : listFiles) {
                    if (ao(str2, file.getName())) {
                        if (e.DEBUG) {
                            Log.i("SwanAppBundleHelper", "删除低版本文件夹：" + file.getAbsolutePath());
                        }
                        com.baidu.swan.apps.database.subpackage.a.HI().ak(str, file.getName());
                        com.baidu.swan.c.a.deleteFile(file);
                    }
                }
            }
        }

        @Nullable
        public static File t(String str, boolean z) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return a(str, z, (com.baidu.swan.apps.an.a.b) null);
        }

        public static File a(String str, boolean z, com.baidu.swan.apps.an.a.b bVar) {
            File Jb;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            File[] listFiles = Jb().listFiles();
            if (listFiles == null || listFiles.length == 0) {
                if (e.DEBUG && z) {
                    com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), Jb.getPath() + " 没有小程序包!").QN();
                }
                com.baidu.swan.apps.ak.a iL = new com.baidu.swan.apps.ak.a().as(5L).at(4L).iL("没有小程序包! for release, bundle files are empty");
                com.baidu.swan.apps.ak.e.TT().b(iL);
                if (bVar != null) {
                    bVar.btO = iL;
                }
                return null;
            }
            for (File file : listFiles) {
                if (TextUtils.equals(file.getName(), str + ".aiapps")) {
                    return file;
                }
            }
            if (e.DEBUG && z) {
                com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), Jb.getPath() + " 没有小程序包!").QN();
            }
            com.baidu.swan.apps.ak.a iL2 = new com.baidu.swan.apps.ak.a().as(5L).at(4L).iL("没有小程序包! for release, no such bundle file");
            com.baidu.swan.apps.ak.e.TT().b(iL2);
            if (bVar != null) {
                bVar.btO = iL2;
            }
            return null;
        }

        public static File Jb() {
            File file = new File(AppRuntime.getAppContext().getFilesDir(), "aiapps_zip");
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }

        private static boolean ao(String str, String str2) {
            if (e.DEBUG) {
                Log.i("SwanAppBundleHelper", "curVersion:" + str + ",targetVersion:" + str2);
            }
            try {
                return ap(str, str2) > 0;
            } catch (IllegalArgumentException e) {
                if (e.DEBUG) {
                    Log.e("SwanAppBundleHelper", "比较版本号Exception：" + e.getMessage());
                    return false;
                }
                return false;
            }
        }

        private static long ap(String str, String str2) throws IllegalArgumentException {
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
        new com.baidu.swan.apps.k.a().a(cVar, a.Ja().getPath() + File.separator + String.valueOf(System.currentTimeMillis()) + ".aibundle", bVar);
    }

    public static void a(String str, b bVar) {
        c cVar = new c();
        cVar.mDownloadUrl = str;
        com.baidu.swan.apps.swancore.c.a.HZ();
        new com.baidu.swan.apps.k.a().a(cVar, com.baidu.swan.apps.swancore.c.a.Ia().getPath(), bVar);
    }

    public static void b(String str, b bVar) {
        c cVar = new c();
        cVar.mDownloadUrl = str;
        com.baidu.swan.apps.extcore.debug.b.HZ();
        new com.baidu.swan.apps.k.a().a(cVar, com.baidu.swan.apps.extcore.debug.b.Ia().getPath(), bVar);
    }

    /* loaded from: classes2.dex */
    public static class a {
        /* JADX WARN: Removed duplicated region for block: B:19:0x00af  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static g a(com.baidu.swan.apps.v.b.b bVar, com.baidu.swan.apps.an.a.b bVar2) {
            g gVar = null;
            File a = a(bVar2);
            if (a != null) {
                com.baidu.swan.apps.ae.b QZ = com.baidu.swan.apps.ae.b.QZ();
                if (QZ == null) {
                    if (!e.a(a, IZ(), bVar, bVar2)) {
                        com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "小程序bundle解压失败!").QN();
                        com.baidu.swan.apps.ak.a iL = new com.baidu.swan.apps.ak.a().as(5L).at(7L).iL("小程序bundle解压失败! for debug");
                        com.baidu.swan.apps.ak.e.TT().b(iL);
                        if (bVar2 != null && bVar2.btO == null) {
                            bVar2.btO = iL;
                        }
                    }
                    gVar = new g();
                    File file = new File(IY(), "app.json");
                    com.baidu.swan.apps.ae.a.c hs = com.baidu.swan.apps.ae.a.c.hs(com.baidu.swan.c.a.l(file));
                    gVar.aSd = IY().getPath() + File.separator;
                    gVar.aSe = hs;
                    if (e.DEBUG) {
                    }
                } else {
                    String string = QZ.Rd().getString("installed_debug_bundle_md5", "");
                    String b = com.baidu.swan.c.b.b(a, false);
                    if (!TextUtils.equals(string, b)) {
                        if (!e.a(a, IZ(), bVar, bVar2)) {
                            com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "小程序bundle解压失败!").QN();
                            com.baidu.swan.apps.ak.a iL2 = new com.baidu.swan.apps.ak.a().as(5L).at(7L).iL("小程序bundle解压失败! for debug");
                            com.baidu.swan.apps.ak.e.TT().b(iL2);
                            if (bVar2 != null && bVar2.btO == null) {
                                bVar2.btO = iL2;
                            }
                        } else {
                            QZ.Rd().putString("installed_debug_bundle_md5", b);
                        }
                    }
                    gVar = new g();
                    File file2 = new File(IY(), "app.json");
                    com.baidu.swan.apps.ae.a.c hs2 = com.baidu.swan.apps.ae.a.c.hs(com.baidu.swan.c.a.l(file2));
                    gVar.aSd = IY().getPath() + File.separator;
                    gVar.aSe = hs2;
                    if (e.DEBUG) {
                        Log.d("SwanAppBundleHelper", "configFile path: " + file2.getPath());
                        Log.d("SwanAppBundleHelper", "configFile exist: " + file2.exists());
                        Log.d("SwanAppBundleHelper", "info.mAppBundlePath path: " + gVar.aSd);
                        Log.d("SwanAppBundleHelper", "launchInfo.swanCoreVersion.swanCorePath: " + bVar.Hg().bql);
                    }
                }
            }
            return gVar;
        }

        public static File IY() {
            return IZ();
        }

        public static File IZ() {
            File file = new File(AppRuntime.getAppContext().getFilesDir(), "debug_aiapps_bundle");
            file.mkdirs();
            return file;
        }

        public static File a(com.baidu.swan.apps.an.a.b bVar) {
            File Ja = Ja();
            File[] listFiles = Ja.listFiles();
            if (listFiles == null || listFiles.length == 0) {
                com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), Ja.getPath() + " 没有测试程序包!").QN();
                com.baidu.swan.apps.ak.a iL = new com.baidu.swan.apps.ak.a().as(5L).at(4L).iL("没有小程序包! for debug, bundle files are empty");
                com.baidu.swan.apps.ak.e.TT().b(iL);
                if (bVar != null) {
                    bVar.btO = iL;
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

        public static File Ja() {
            File file = new File(x.Ut().get(0).mPath, "baidu/aiapps_debug/");
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }
    }

    /* renamed from: com.baidu.swan.apps.install.e$e  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0192e {
        public static g j(com.baidu.swan.apps.v.b.b bVar) {
            e.a(Jc(), IZ(), bVar);
            g gVar = new g();
            File file = new File(IZ(), "app.json");
            com.baidu.swan.apps.ae.a.c hs = com.baidu.swan.apps.ae.a.c.hs(com.baidu.swan.c.a.l(file));
            gVar.aSd = IZ().getPath() + File.separator;
            gVar.aSe = hs;
            if (e.DEBUG) {
                Log.d("SwanAppBundleHelper", "configFile path: " + file.getPath());
                Log.d("SwanAppBundleHelper", "configFile exist: " + file.exists());
                Log.d("SwanAppBundleHelper", "info.mAppBundlePath path: " + gVar.aSd);
            }
            return gVar;
        }

        public static File IZ() {
            File file = new File(AppRuntime.getAppContext().getFilesDir(), "aiapps_remote_debug_folder");
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }

        public static File Jc() {
            return new File(Ja(), "remote_debug.aiapps");
        }

        public static File Ja() {
            File file = new File(AppRuntime.getAppContext().getFilesDir(), "aiapps_remote_debug_zip");
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }
    }

    /* loaded from: classes2.dex */
    public static class f {
        public static boolean f(SubPackageAPSInfo subPackageAPSInfo) {
            boolean bz;
            if (subPackageAPSInfo == null) {
                return false;
            }
            File file = new File(subPackageAPSInfo.aSB);
            if (!file.exists()) {
                if (e.DEBUG) {
                    Log.e("SwanAppBundleHelper", "解压分包时，ZIP包不存在");
                    return false;
                }
                return false;
            }
            File h = h(subPackageAPSInfo);
            if (h != null) {
                if (!h.exists() && !h.mkdirs()) {
                    if (e.DEBUG) {
                        Log.e("SwanAppBundleHelper", "创建分包解压文件夹失败");
                        return false;
                    }
                    return false;
                }
                BufferedInputStream h2 = com.baidu.swan.apps.install.a.a.h(file);
                if (h2 != null) {
                    bz = com.baidu.swan.apps.install.a.a.a(h2, h).isSuccess;
                } else {
                    bz = com.baidu.swan.c.a.bz(file.getAbsolutePath(), h.getAbsolutePath());
                }
                if (bz) {
                    if (e.DEBUG) {
                        Log.e("SwanAppBundleHelper", "分包解压成功");
                    }
                    return true;
                } else if (e.DEBUG) {
                    Log.e("SwanAppBundleHelper", "分包解压文件失败, file:" + file.getAbsolutePath() + " folder:" + h.getAbsolutePath());
                    return false;
                } else {
                    return false;
                }
            }
            return false;
        }

        private static File h(SubPackageAPSInfo subPackageAPSInfo) {
            if (subPackageAPSInfo == null || TextUtils.isEmpty(subPackageAPSInfo.aSz) || TextUtils.isEmpty(subPackageAPSInfo.aSA)) {
                if (e.DEBUG) {
                    Log.e("SwanAppBundleHelper", "获取分包解压文件夹失败");
                }
                return null;
            }
            return new File(subPackageAPSInfo.aSz, subPackageAPSInfo.aSA);
        }
    }
}
