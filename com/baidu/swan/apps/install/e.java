package com.baidu.swan.apps.install;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
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
    private static ExecutorService axE = Executors.newSingleThreadExecutor();

    /* loaded from: classes2.dex */
    public interface b {
        void cv(int i);

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
        public String axI;
        public com.baidu.swan.apps.ae.a.c axJ;
    }

    public static void a(final com.baidu.swan.apps.v.b.b bVar, final com.baidu.swan.apps.install.b bVar2) {
        String shortString;
        final JSONObject jSONObject = null;
        if (bVar == null || com.baidu.swan.apps.statistic.f.hn(bVar.getVersion())) {
            jSONObject = new JSONObject();
            String OT = ac.OT();
            if (bVar == null) {
                shortString = "null";
            } else {
                try {
                    shortString = bVar.toShortString();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            jSONObject.put("originLaunchInfo", shortString);
            jSONObject.put("stackTraceBefore", OT);
        }
        axE.execute(new Runnable() { // from class: com.baidu.swan.apps.install.e.1
            @Override // java.lang.Runnable
            public void run() {
                g a2;
                com.baidu.swan.apps.an.a.b bVar3 = new com.baidu.swan.apps.an.a.b();
                if (com.baidu.swan.apps.ac.a.a.l(com.baidu.swan.apps.v.b.b.this)) {
                    a2 = com.baidu.swan.apps.ac.a.a.a(com.baidu.swan.apps.v.b.b.this, bVar3);
                } else {
                    a2 = d.a(com.baidu.swan.apps.v.b.b.this, bVar3, jSONObject);
                }
                if (a2 == null || a2.axJ == null || a2.axJ.aQn == null) {
                    com.baidu.swan.apps.ak.a aVar = bVar3.aZH;
                    if (aVar == null) {
                        aVar = new com.baidu.swan.apps.ak.a().Y(5L).Z(20L).hY("小程序loadbundle出错，loadinfo为空或者页面配置空 ");
                    }
                    com.baidu.swan.apps.statistic.e.b(new com.baidu.swan.apps.statistic.a.d().ho(com.baidu.swan.apps.statistic.e.dM(com.baidu.swan.apps.v.b.b.this != null ? com.baidu.swan.apps.v.b.b.this.Fg() : 0)).a(aVar).hr("appjson_config_invalid").s(com.baidu.swan.apps.v.b.b.this));
                    com.baidu.swan.apps.statistic.b.c.c(new com.baidu.swan.apps.statistic.b.a("error", String.valueOf(System.currentTimeMillis()), String.valueOf(aVar.Og())));
                } else {
                    com.baidu.swan.apps.statistic.b.c.c(new com.baidu.swan.apps.statistic.b.a("narun"));
                }
                bVar2.a(0, a2);
            }
        });
    }

    public static File Dq() {
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
                com.baidu.swan.apps.ak.a hY = new com.baidu.swan.apps.ak.a().Y(5L).Z(4L).hY("小程序bundle文件不存在或者空文件! ");
                if (bVar2 != null) {
                    bVar2.aZH = hY;
                }
            } else {
                com.baidu.swan.apps.performance.f.HY().f(new UbcFlowEvent("package_start_unzip"));
                long currentTimeMillis = System.currentTimeMillis();
                BufferedInputStream r = com.baidu.swan.apps.install.a.a.r(file);
                if (r != null) {
                    z = com.baidu.swan.apps.install.a.a.a(r, file2).isSuccess;
                } else {
                    z = com.baidu.swan.c.a.bs(file.getPath(), file2.getPath());
                }
                long currentTimeMillis2 = System.currentTimeMillis();
                if (DEBUG) {
                    com.baidu.swan.apps.install.a.a.cA((int) (currentTimeMillis2 - currentTimeMillis));
                }
                if (!z) {
                    com.baidu.swan.apps.ak.a hY2 = new com.baidu.swan.apps.ak.a().Y(5L).Z(7L).hY("小程序bundle解压失败! ");
                    if (bVar2 != null) {
                        bVar2.aZH = hY2;
                    }
                }
                com.baidu.swan.apps.performance.f.HY().f(new UbcFlowEvent("package_end_unzip"));
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
                    if (!e.a(a, q(b), bVar, bVar2)) {
                        com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "小程序bundle解压失败!").Ld();
                        com.baidu.swan.apps.ak.a hY = new com.baidu.swan.apps.ak.a().Y(5L).Z(7L).hY("小程序bundle解压失败! for release");
                        com.baidu.swan.apps.ak.e.Ok().b(hY);
                        if (bVar2 == null || bVar2.aZH != null) {
                            return null;
                        }
                        bVar2.aZH = hY;
                        return null;
                    }
                } else {
                    com.baidu.swan.apps.process.messaging.client.a.IE().a(8, new SwanAppDeleteInfo(bVar.getAppId(), 1));
                    com.baidu.swan.apps.statistic.e.b(new com.baidu.swan.apps.statistic.a.d().ho(com.baidu.swan.apps.statistic.e.dM(bVar.Fg())).a(new com.baidu.swan.apps.ak.a().Y(5L).Z(31L).hY("小程序zip和bundle不存在，兜底重置")).s(bVar));
                    if (e.DEBUG) {
                        Log.w("SwanAppBundleHelper", "20050004：reset aiapps");
                        return null;
                    }
                    return null;
                }
            }
            af(bVar.getAppId(), bVar.getVersion());
            g gVar = new g();
            File file = new File(b, "app.json");
            com.baidu.swan.apps.ae.a.c gF = com.baidu.swan.apps.ae.a.c.gF(com.baidu.swan.c.a.v(file));
            if (gF != null) {
                gVar.axI = b.getPath() + File.separator;
                gVar.axJ = gF;
                if (e.DEBUG) {
                    Log.d("SwanAppBundleHelper", "configFile path: " + file.getPath());
                    Log.d("SwanAppBundleHelper", "configFile exist: " + file.exists());
                    Log.d("SwanAppBundleHelper", "info.mAppBundlePath path: " + gVar.axI);
                    Log.d("SwanAppBundleHelper", "launchInfo.swanCoreVersion.swanCorePath: " + bVar.BA().aVZ);
                }
                return gVar;
            }
            return null;
        }

        public static File q(File file) {
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }

        public static File ae(String str, String str2) {
            return b(str, str2, null);
        }

        public static File b(String str, String str2, @Nullable JSONObject jSONObject) {
            if (com.baidu.swan.apps.statistic.f.hn(str2)) {
                com.baidu.swan.apps.statistic.f.c(str, str2, jSONObject);
            }
            return new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "aiapps_folder" + File.separator + str, str2);
        }

        public static void ez(String str) {
            if (!TextUtils.isEmpty(str)) {
                File q = q(str, false);
                if (q != null) {
                    com.baidu.swan.c.a.deleteFile(q);
                }
                com.baidu.swan.c.a.deleteFile(new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "aiapps_folder" + File.separator + str));
            }
        }

        public static void af(String str, String str2) {
            File[] listFiles;
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && (listFiles = new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "aiapps_folder", str).listFiles(new FileFilter() { // from class: com.baidu.swan.apps.install.e.d.1
                @Override // java.io.FileFilter
                public boolean accept(File file) {
                    return file.isDirectory() && TextUtils.isDigitsOnly(file.getName());
                }
            })) != null && listFiles.length > 0) {
                for (File file : listFiles) {
                    if (ag(str2, file.getName())) {
                        if (e.DEBUG) {
                            Log.i("SwanAppBundleHelper", "删除低版本文件夹：" + file.getAbsolutePath());
                        }
                        com.baidu.swan.apps.database.subpackage.a.Cb().ac(str, file.getName());
                        com.baidu.swan.c.a.deleteFile(file);
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
            File Du;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            File[] listFiles = Du().listFiles();
            if (listFiles == null || listFiles.length == 0) {
                if (e.DEBUG && z) {
                    com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), Du.getPath() + " 没有小程序包!").Ld();
                }
                com.baidu.swan.apps.ak.a hY = new com.baidu.swan.apps.ak.a().Y(5L).Z(4L).hY("没有小程序包! for release, bundle files are empty");
                com.baidu.swan.apps.ak.e.Ok().b(hY);
                if (bVar != null) {
                    bVar.aZH = hY;
                }
                return null;
            }
            for (File file : listFiles) {
                if (TextUtils.equals(file.getName(), str + ".aiapps")) {
                    return file;
                }
            }
            if (e.DEBUG && z) {
                com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), Du.getPath() + " 没有小程序包!").Ld();
            }
            com.baidu.swan.apps.ak.a hY2 = new com.baidu.swan.apps.ak.a().Y(5L).Z(4L).hY("没有小程序包! for release, no such bundle file");
            com.baidu.swan.apps.ak.e.Ok().b(hY2);
            if (bVar != null) {
                bVar.aZH = hY2;
            }
            return null;
        }

        public static File Du() {
            File file = new File(AppRuntime.getAppContext().getFilesDir(), "aiapps_zip");
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }

        private static boolean ag(String str, String str2) {
            if (e.DEBUG) {
                Log.i("SwanAppBundleHelper", "curVersion:" + str + ",targetVersion:" + str2);
            }
            try {
                return ah(str, str2) > 0;
            } catch (IllegalArgumentException e) {
                if (e.DEBUG) {
                    Log.e("SwanAppBundleHelper", "比较版本号Exception：" + e.getMessage());
                    return false;
                }
                return false;
            }
        }

        private static long ah(String str, String str2) throws IllegalArgumentException {
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
        new com.baidu.swan.apps.k.a().a(cVar, a.Dt().getPath() + File.separator + String.valueOf(System.currentTimeMillis()) + ".aibundle", bVar);
    }

    public static void a(String str, b bVar) {
        c cVar = new c();
        cVar.mDownloadUrl = str;
        com.baidu.swan.apps.swancore.c.a.Cs();
        new com.baidu.swan.apps.k.a().a(cVar, com.baidu.swan.apps.swancore.c.a.Ct().getPath(), bVar);
    }

    public static void b(String str, b bVar) {
        c cVar = new c();
        cVar.mDownloadUrl = str;
        com.baidu.swan.apps.extcore.debug.b.Cs();
        new com.baidu.swan.apps.k.a().a(cVar, com.baidu.swan.apps.extcore.debug.b.Ct().getPath(), bVar);
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
                com.baidu.swan.apps.ae.b Lq = com.baidu.swan.apps.ae.b.Lq();
                if (Lq == null) {
                    if (!e.a(a, Ds(), bVar, bVar2)) {
                        com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "小程序bundle解压失败!").Ld();
                        com.baidu.swan.apps.ak.a hY = new com.baidu.swan.apps.ak.a().Y(5L).Z(7L).hY("小程序bundle解压失败! for debug");
                        com.baidu.swan.apps.ak.e.Ok().b(hY);
                        if (bVar2 != null && bVar2.aZH == null) {
                            bVar2.aZH = hY;
                        }
                    }
                    gVar = new g();
                    File file = new File(Dr(), "app.json");
                    com.baidu.swan.apps.ae.a.c gF = com.baidu.swan.apps.ae.a.c.gF(com.baidu.swan.c.a.v(file));
                    gVar.axI = Dr().getPath() + File.separator;
                    gVar.axJ = gF;
                    if (e.DEBUG) {
                    }
                } else {
                    String string = Lq.Lu().getString("installed_debug_bundle_md5", "");
                    String b = com.baidu.swan.c.b.b(a, false);
                    if (!TextUtils.equals(string, b)) {
                        if (!e.a(a, Ds(), bVar, bVar2)) {
                            com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "小程序bundle解压失败!").Ld();
                            com.baidu.swan.apps.ak.a hY2 = new com.baidu.swan.apps.ak.a().Y(5L).Z(7L).hY("小程序bundle解压失败! for debug");
                            com.baidu.swan.apps.ak.e.Ok().b(hY2);
                            if (bVar2 != null && bVar2.aZH == null) {
                                bVar2.aZH = hY2;
                            }
                        } else {
                            Lq.Lu().putString("installed_debug_bundle_md5", b);
                        }
                    }
                    gVar = new g();
                    File file2 = new File(Dr(), "app.json");
                    com.baidu.swan.apps.ae.a.c gF2 = com.baidu.swan.apps.ae.a.c.gF(com.baidu.swan.c.a.v(file2));
                    gVar.axI = Dr().getPath() + File.separator;
                    gVar.axJ = gF2;
                    if (e.DEBUG) {
                        Log.d("SwanAppBundleHelper", "configFile path: " + file2.getPath());
                        Log.d("SwanAppBundleHelper", "configFile exist: " + file2.exists());
                        Log.d("SwanAppBundleHelper", "info.mAppBundlePath path: " + gVar.axI);
                        Log.d("SwanAppBundleHelper", "launchInfo.swanCoreVersion.swanCorePath: " + bVar.BA().aVZ);
                    }
                }
            }
            return gVar;
        }

        public static File Dr() {
            return Ds();
        }

        public static File Ds() {
            File file = new File(AppRuntime.getAppContext().getFilesDir(), "debug_aiapps_bundle");
            file.mkdirs();
            return file;
        }

        public static File a(com.baidu.swan.apps.an.a.b bVar) {
            File Dt = Dt();
            File[] listFiles = Dt.listFiles();
            if (listFiles == null || listFiles.length == 0) {
                com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), Dt.getPath() + " 没有测试程序包!").Ld();
                com.baidu.swan.apps.ak.a hY = new com.baidu.swan.apps.ak.a().Y(5L).Z(4L).hY("没有小程序包! for debug, bundle files are empty");
                com.baidu.swan.apps.ak.e.Ok().b(hY);
                if (bVar != null) {
                    bVar.aZH = hY;
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

        public static File Dt() {
            File file = new File(x.OJ().get(0).wU, "baidu/aiapps_debug/");
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }
    }

    /* renamed from: com.baidu.swan.apps.install.e$e  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0149e {
        public static g j(com.baidu.swan.apps.v.b.b bVar) {
            e.a(Dv(), Ds(), bVar);
            g gVar = new g();
            File file = new File(Ds(), "app.json");
            com.baidu.swan.apps.ae.a.c gF = com.baidu.swan.apps.ae.a.c.gF(com.baidu.swan.c.a.v(file));
            gVar.axI = Ds().getPath() + File.separator;
            gVar.axJ = gF;
            if (e.DEBUG) {
                Log.d("SwanAppBundleHelper", "configFile path: " + file.getPath());
                Log.d("SwanAppBundleHelper", "configFile exist: " + file.exists());
                Log.d("SwanAppBundleHelper", "info.mAppBundlePath path: " + gVar.axI);
            }
            return gVar;
        }

        public static File Ds() {
            File file = new File(AppRuntime.getAppContext().getFilesDir(), "aiapps_remote_debug_folder");
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }

        public static File Dv() {
            return new File(Dt(), "remote_debug.aiapps");
        }

        public static File Dt() {
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
            boolean bs;
            if (subPackageAPSInfo == null) {
                return false;
            }
            File file = new File(subPackageAPSInfo.ayg);
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
                BufferedInputStream r = com.baidu.swan.apps.install.a.a.r(file);
                if (r != null) {
                    bs = com.baidu.swan.apps.install.a.a.a(r, h).isSuccess;
                } else {
                    bs = com.baidu.swan.c.a.bs(file.getAbsolutePath(), h.getAbsolutePath());
                }
                if (bs) {
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
            if (subPackageAPSInfo == null || TextUtils.isEmpty(subPackageAPSInfo.aye) || TextUtils.isEmpty(subPackageAPSInfo.ayf)) {
                if (e.DEBUG) {
                    Log.e("SwanAppBundleHelper", "获取分包解压文件夹失败");
                }
                return null;
            }
            return new File(subPackageAPSInfo.aye, subPackageAPSInfo.ayf);
        }
    }
}
