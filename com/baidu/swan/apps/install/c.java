package com.baidu.swan.apps.install;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.an.aa;
import com.baidu.swan.apps.an.v;
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
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.c.DEBUG;
    private static ExecutorService awT = Executors.newSingleThreadExecutor();

    /* loaded from: classes2.dex */
    public interface b {
        void cv(int i);

        void onFailed();

        void onSuccess();
    }

    /* renamed from: com.baidu.swan.apps.install.c$c  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0115c {
        public String mAppId;
        public String mDownloadUrl;
    }

    /* loaded from: classes2.dex */
    public static class g extends com.baidu.swan.apps.install.a {
        public String awX;
        public com.baidu.swan.apps.ae.a.c awY;
    }

    public static void a(final com.baidu.swan.apps.v.b.b bVar, final com.baidu.swan.apps.install.b bVar2) {
        final JSONObject jSONObject = null;
        if (bVar == null || TextUtils.isEmpty(bVar.mVersion)) {
            jSONObject = new JSONObject();
            try {
                jSONObject.put("stackTraceBefore", aa.Mn());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        awT.execute(new Runnable() { // from class: com.baidu.swan.apps.install.c.1
            @Override // java.lang.Runnable
            public void run() {
                g a2;
                com.baidu.swan.apps.an.a.b bVar3 = new com.baidu.swan.apps.an.a.b();
                if (com.baidu.swan.apps.ac.a.a.l(com.baidu.swan.apps.v.b.b.this)) {
                    a2 = com.baidu.swan.apps.ac.a.a.a(com.baidu.swan.apps.v.b.b.this, bVar3);
                } else {
                    a2 = d.a(com.baidu.swan.apps.v.b.b.this, bVar3, jSONObject);
                }
                if (a2 == null || a2.awY == null || a2.awY.aOf == null) {
                    com.baidu.swan.apps.ak.a aVar = bVar3.aWy;
                    if (aVar == null) {
                        aVar = new com.baidu.swan.apps.ak.a().L(5L).M(20L).hw("小程序loadbundle出错，loadinfo为空或者页面配置空 ");
                    }
                    com.baidu.swan.apps.statistic.c.a(new com.baidu.swan.apps.statistic.a.d().gR(com.baidu.swan.apps.statistic.c.dC(com.baidu.swan.apps.v.b.b.this != null ? com.baidu.swan.apps.v.b.b.this.axW : 0)).a(aVar).gU("appjson_config_invalid").r(com.baidu.swan.apps.v.b.b.this));
                    com.baidu.swan.apps.statistic.b.c.c(new com.baidu.swan.apps.statistic.b.a("error", String.valueOf(System.currentTimeMillis()), String.valueOf(aVar.LC())));
                } else {
                    com.baidu.swan.apps.statistic.b.c.c(new com.baidu.swan.apps.statistic.b.a("narun"));
                }
                bVar2.a(0, a2);
            }
        });
    }

    public static File Cq() {
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
                com.baidu.swan.apps.ak.a hw = new com.baidu.swan.apps.ak.a().L(5L).M(4L).hw("小程序bundle文件不存在或者空文件! ");
                if (bVar2 != null) {
                    bVar2.aWy = hw;
                }
            } else {
                com.baidu.swan.apps.performance.f.FS().f(new UbcFlowEvent("package_start_unzip"));
                long currentTimeMillis = System.currentTimeMillis();
                BufferedInputStream x = com.baidu.swan.apps.install.a.a.x(file);
                if (x != null) {
                    z = com.baidu.swan.apps.install.a.a.a(file, file2, x).isSuccess;
                } else {
                    z = com.baidu.swan.c.b.bl(file.getPath(), file2.getPath());
                }
                long currentTimeMillis2 = System.currentTimeMillis();
                if (DEBUG) {
                    com.baidu.swan.apps.install.a.a.cA((int) (currentTimeMillis2 - currentTimeMillis));
                }
                if (!z) {
                    com.baidu.swan.apps.ak.a hw2 = new com.baidu.swan.apps.ak.a().L(5L).M(7L).hw("小程序bundle解压失败! ");
                    if (bVar2 != null) {
                        bVar2.aWy = hw2;
                    }
                }
                com.baidu.swan.apps.performance.f.FS().f(new UbcFlowEvent("package_end_unzip"));
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
            File c = c(bVar.mAppId, bVar.mVersion, jSONObject);
            if (!c.exists()) {
                File a = a(bVar.mAppId, true, bVar2);
                if (a != null) {
                    if (!c.a(a, w(c), bVar, bVar2)) {
                        com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "小程序bundle解压失败!").IK();
                        com.baidu.swan.apps.ak.a hw = new com.baidu.swan.apps.ak.a().L(5L).M(7L).hw("小程序bundle解压失败! for release");
                        com.baidu.swan.apps.ak.e.LG().b(hw);
                        if (bVar2 == null || bVar2.aWy != null) {
                            return null;
                        }
                        bVar2.aWy = hw;
                        return null;
                    }
                } else {
                    com.baidu.swan.apps.process.messaging.client.a.Gq().a(8, new SwanAppDeleteInfo(bVar.mAppId, 1));
                    com.baidu.swan.apps.statistic.c.a(new com.baidu.swan.apps.statistic.a.d().gR(com.baidu.swan.apps.statistic.c.dC(bVar.axW)).a(new com.baidu.swan.apps.ak.a().L(5L).M(31L).hw("小程序zip和bundle不存在，兜底重置")).r(bVar));
                    if (c.DEBUG) {
                        Log.w("SwanAppBundleHelper", "20050004：reset aiapps");
                        return null;
                    }
                    return null;
                }
            }
            ai(bVar.mAppId, bVar.mVersion);
            g gVar = new g();
            File file = new File(c, "app.json");
            com.baidu.swan.apps.ae.a.c gk = com.baidu.swan.apps.ae.a.c.gk(com.baidu.swan.c.b.B(file));
            if (gk != null) {
                gVar.awX = c.getPath() + File.separator;
                gVar.awY = gk;
                if (c.DEBUG) {
                    Log.d("SwanAppBundleHelper", "configFile path: " + file.getPath());
                    Log.d("SwanAppBundleHelper", "configFile exist: " + file.exists());
                    Log.d("SwanAppBundleHelper", "info.mAppBundlePath path: " + gVar.awX);
                    Log.d("SwanAppBundleHelper", "launchInfo.mSwanCoreVersion.swanCorePath: " + bVar.atp.aTf);
                }
                return gVar;
            }
            return null;
        }

        public static File w(File file) {
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }

        public static File ah(String str, String str2) {
            return c(str, str2, null);
        }

        public static File c(String str, String str2, @Nullable JSONObject jSONObject) {
            if (TextUtils.isEmpty(str2)) {
                com.baidu.swan.apps.statistic.d.i(str2, jSONObject);
            }
            return new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "aiapps_folder" + File.separator + str, str2);
        }

        public static void eK(String str) {
            if (!TextUtils.isEmpty(str)) {
                File q = q(str, false);
                if (q != null) {
                    com.baidu.swan.c.b.deleteFile(q);
                }
                com.baidu.swan.c.b.deleteFile(new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "aiapps_folder" + File.separator + str));
            }
        }

        public static void ai(String str, String str2) {
            File[] listFiles;
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && (listFiles = new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "aiapps_folder", str).listFiles(new FileFilter() { // from class: com.baidu.swan.apps.install.c.d.1
                @Override // java.io.FileFilter
                public boolean accept(File file) {
                    return file.isDirectory() && TextUtils.isDigitsOnly(file.getName());
                }
            })) != null && listFiles.length > 0) {
                for (File file : listFiles) {
                    if (aj(str2, file.getName())) {
                        if (c.DEBUG) {
                            Log.i("SwanAppBundleHelper", "删除低版本文件夹：" + file.getAbsolutePath());
                        }
                        com.baidu.swan.apps.database.subpackage.a.AV().ag(str, file.getName());
                        com.baidu.swan.c.b.deleteFile(file);
                    }
                }
            }
        }

        @Nullable
        public static File q(String str, boolean z) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return a(str, z, (com.baidu.swan.apps.an.a.b) null);
        }

        public static File a(String str, boolean z, com.baidu.swan.apps.an.a.b bVar) {
            File Cu;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            File[] listFiles = Cu().listFiles();
            if (listFiles == null || listFiles.length == 0) {
                if (c.DEBUG && z) {
                    com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), Cu.getPath() + " 没有小程序包!").IK();
                }
                com.baidu.swan.apps.ak.a hw = new com.baidu.swan.apps.ak.a().L(5L).M(4L).hw("没有小程序包! for release, bundle files are empty");
                com.baidu.swan.apps.ak.e.LG().b(hw);
                if (bVar != null) {
                    bVar.aWy = hw;
                }
                return null;
            }
            for (File file : listFiles) {
                if (TextUtils.equals(file.getName(), str + ".aiapps")) {
                    return file;
                }
            }
            if (c.DEBUG && z) {
                com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), Cu.getPath() + " 没有小程序包!").IK();
            }
            com.baidu.swan.apps.ak.a hw2 = new com.baidu.swan.apps.ak.a().L(5L).M(4L).hw("没有小程序包! for release, no such bundle file");
            com.baidu.swan.apps.ak.e.LG().b(hw2);
            if (bVar != null) {
                bVar.aWy = hw2;
            }
            return null;
        }

        public static File Cu() {
            File file = new File(AppRuntime.getAppContext().getFilesDir(), "aiapps_zip");
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }

        private static boolean aj(String str, String str2) {
            if (c.DEBUG) {
                Log.i("SwanAppBundleHelper", "curVersion:" + str + ",targetVersion:" + str2);
            }
            try {
                return ak(str, str2) > 0;
            } catch (IllegalArgumentException e) {
                if (c.DEBUG) {
                    Log.e("SwanAppBundleHelper", "比较版本号Exception：" + e.getMessage());
                    return false;
                }
                return false;
            }
        }

        private static long ak(String str, String str2) throws IllegalArgumentException {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                throw new IllegalArgumentException("version null");
            }
            if (!TextUtils.isDigitsOnly(str) || !TextUtils.isDigitsOnly(str2)) {
                throw new IllegalArgumentException("version is not digits only");
            }
            return Long.parseLong(str) - Long.parseLong(str2);
        }
    }

    public static void a(C0115c c0115c, b bVar) {
        new com.baidu.swan.apps.k.a().a(c0115c, a.Ct().getPath() + File.separator + String.valueOf(System.currentTimeMillis()) + ".aibundle", bVar);
    }

    public static void a(String str, b bVar) {
        C0115c c0115c = new C0115c();
        c0115c.mDownloadUrl = str;
        com.baidu.swan.apps.swancore.c.a.Br();
        new com.baidu.swan.apps.k.a().a(c0115c, com.baidu.swan.apps.swancore.c.a.Bs().getPath(), bVar);
    }

    public static void b(String str, b bVar) {
        C0115c c0115c = new C0115c();
        c0115c.mDownloadUrl = str;
        com.baidu.swan.apps.extcore.d.b.Br();
        new com.baidu.swan.apps.k.a().a(c0115c, com.baidu.swan.apps.extcore.d.b.Bs().getPath(), bVar);
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
                com.baidu.swan.apps.ae.b IX = com.baidu.swan.apps.ae.b.IX();
                if (IX == null) {
                    if (!c.a(a, Cs(), bVar, bVar2)) {
                        com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "小程序bundle解压失败!").IK();
                        com.baidu.swan.apps.ak.a hw = new com.baidu.swan.apps.ak.a().L(5L).M(7L).hw("小程序bundle解压失败! for debug");
                        com.baidu.swan.apps.ak.e.LG().b(hw);
                        if (bVar2 != null && bVar2.aWy == null) {
                            bVar2.aWy = hw;
                        }
                    }
                    gVar = new g();
                    File file = new File(Cr(), "app.json");
                    com.baidu.swan.apps.ae.a.c gk = com.baidu.swan.apps.ae.a.c.gk(com.baidu.swan.c.b.B(file));
                    gVar.awX = Cr().getPath() + File.separator;
                    gVar.awY = gk;
                    if (c.DEBUG) {
                    }
                } else {
                    String string = IX.Jb().getString("installed_debug_bundle_md5", "");
                    String c = com.baidu.swan.c.c.c(a, false);
                    if (!TextUtils.equals(string, c)) {
                        if (!c.a(a, Cs(), bVar, bVar2)) {
                            com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "小程序bundle解压失败!").IK();
                            com.baidu.swan.apps.ak.a hw2 = new com.baidu.swan.apps.ak.a().L(5L).M(7L).hw("小程序bundle解压失败! for debug");
                            com.baidu.swan.apps.ak.e.LG().b(hw2);
                            if (bVar2 != null && bVar2.aWy == null) {
                                bVar2.aWy = hw2;
                            }
                        } else {
                            IX.Jb().putString("installed_debug_bundle_md5", c);
                        }
                    }
                    gVar = new g();
                    File file2 = new File(Cr(), "app.json");
                    com.baidu.swan.apps.ae.a.c gk2 = com.baidu.swan.apps.ae.a.c.gk(com.baidu.swan.c.b.B(file2));
                    gVar.awX = Cr().getPath() + File.separator;
                    gVar.awY = gk2;
                    if (c.DEBUG) {
                        Log.d("SwanAppBundleHelper", "configFile path: " + file2.getPath());
                        Log.d("SwanAppBundleHelper", "configFile exist: " + file2.exists());
                        Log.d("SwanAppBundleHelper", "info.mAppBundlePath path: " + gVar.awX);
                        Log.d("SwanAppBundleHelper", "launchInfo.mSwanCoreVersion.swanCorePath: " + bVar.atp.aTf);
                    }
                }
            }
            return gVar;
        }

        public static File Cr() {
            return Cs();
        }

        public static File Cs() {
            File file = new File(AppRuntime.getAppContext().getFilesDir(), "debug_aiapps_bundle");
            file.mkdirs();
            return file;
        }

        public static File a(com.baidu.swan.apps.an.a.b bVar) {
            File Ct = Ct();
            File[] listFiles = Ct.listFiles();
            if (listFiles == null || listFiles.length == 0) {
                com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), Ct.getPath() + " 没有测试程序包!").IK();
                com.baidu.swan.apps.ak.a hw = new com.baidu.swan.apps.ak.a().L(5L).M(4L).hw("没有小程序包! for debug, bundle files are empty");
                com.baidu.swan.apps.ak.e.LG().b(hw);
                if (bVar != null) {
                    bVar.aWy = hw;
                }
                return null;
            }
            return d(listFiles);
        }

        private static File d(File[] fileArr) {
            File file = null;
            for (File file2 : fileArr) {
                if (file == null || file2.lastModified() > file.lastModified()) {
                    file = file2;
                }
            }
            return file;
        }

        public static File Ct() {
            File file = new File(v.Me().get(0).mPath, "baidu/aiapps_debug/");
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }
    }

    /* loaded from: classes2.dex */
    public static class e {
        public static g j(com.baidu.swan.apps.v.b.b bVar) {
            c.a(Cv(), Cs(), bVar);
            g gVar = new g();
            File file = new File(Cs(), "app.json");
            com.baidu.swan.apps.ae.a.c gk = com.baidu.swan.apps.ae.a.c.gk(com.baidu.swan.c.b.B(file));
            gVar.awX = Cs().getPath() + File.separator;
            gVar.awY = gk;
            if (c.DEBUG) {
                Log.d("SwanAppBundleHelper", "configFile path: " + file.getPath());
                Log.d("SwanAppBundleHelper", "configFile exist: " + file.exists());
                Log.d("SwanAppBundleHelper", "info.mAppBundlePath path: " + gVar.awX);
            }
            return gVar;
        }

        public static File Cs() {
            File file = new File(AppRuntime.getAppContext().getFilesDir(), "aiapps_remote_debug_folder");
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }

        public static File Cv() {
            return new File(Ct(), "remote_debug.aiapps");
        }

        public static File Ct() {
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
            boolean bl;
            if (subPackageAPSInfo == null) {
                return false;
            }
            File file = new File(subPackageAPSInfo.axo);
            if (!file.exists()) {
                if (c.DEBUG) {
                    Log.e("SwanAppBundleHelper", "解压分包时，ZIP包不存在");
                    return false;
                }
                return false;
            }
            File h = h(subPackageAPSInfo);
            if (h != null) {
                if (!h.exists() && !h.mkdirs()) {
                    if (c.DEBUG) {
                        Log.e("SwanAppBundleHelper", "创建分包解压文件夹失败");
                        return false;
                    }
                    return false;
                }
                BufferedInputStream x = com.baidu.swan.apps.install.a.a.x(file);
                if (x != null) {
                    bl = com.baidu.swan.apps.install.a.a.a(file, h, x).isSuccess;
                } else {
                    bl = com.baidu.swan.c.b.bl(file.getAbsolutePath(), h.getAbsolutePath());
                }
                if (bl) {
                    if (c.DEBUG) {
                        Log.e("SwanAppBundleHelper", "分包解压成功");
                    }
                    return true;
                } else if (c.DEBUG) {
                    Log.e("SwanAppBundleHelper", "分包解压文件失败, file:" + file.getAbsolutePath() + " folder:" + h.getAbsolutePath());
                    return false;
                } else {
                    return false;
                }
            }
            return false;
        }

        private static File h(SubPackageAPSInfo subPackageAPSInfo) {
            if (subPackageAPSInfo == null || TextUtils.isEmpty(subPackageAPSInfo.axm) || TextUtils.isEmpty(subPackageAPSInfo.axn)) {
                if (c.DEBUG) {
                    Log.e("SwanAppBundleHelper", "获取分包解压文件夹失败");
                }
                return null;
            }
            return new File(subPackageAPSInfo.axm, subPackageAPSInfo.axn);
        }
    }
}
