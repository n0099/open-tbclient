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
    private static ExecutorService ayJ = Executors.newSingleThreadExecutor();

    /* loaded from: classes2.dex */
    public interface b {
        void cw(int i);

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
        public String ayN;
        public com.baidu.swan.apps.ae.a.c ayO;
    }

    public static void a(final com.baidu.swan.apps.v.b.b bVar, final com.baidu.swan.apps.install.b bVar2) {
        String Cy;
        final JSONObject jSONObject = null;
        if (bVar == null || com.baidu.swan.apps.statistic.f.hw(bVar.getVersion())) {
            jSONObject = new JSONObject();
            String PN = ac.PN();
            if (bVar == null) {
                Cy = "null";
            } else {
                try {
                    Cy = bVar.Cy();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            jSONObject.put("originLaunchInfo", Cy);
            jSONObject.put("stackTraceBefore", PN);
        }
        ayJ.execute(new Runnable() { // from class: com.baidu.swan.apps.install.e.1
            @Override // java.lang.Runnable
            public void run() {
                g a2;
                com.baidu.swan.apps.an.a.b bVar3 = new com.baidu.swan.apps.an.a.b();
                if (com.baidu.swan.apps.ac.a.a.l(com.baidu.swan.apps.v.b.b.this)) {
                    a2 = com.baidu.swan.apps.ac.a.a.a(com.baidu.swan.apps.v.b.b.this, bVar3);
                } else {
                    a2 = d.a(com.baidu.swan.apps.v.b.b.this, bVar3, jSONObject);
                }
                if (a2 == null || a2.ayO == null || a2.ayO.aRv == null) {
                    com.baidu.swan.apps.ak.a aVar = bVar3.baP;
                    if (aVar == null) {
                        aVar = new com.baidu.swan.apps.ak.a().Z(5L).aa(20L).ii("小程序loadbundle出错，loadinfo为空或者页面配置空 ");
                    }
                    com.baidu.swan.apps.statistic.e.b(new com.baidu.swan.apps.statistic.a.d().hx(com.baidu.swan.apps.statistic.e.dQ(com.baidu.swan.apps.v.b.b.this != null ? com.baidu.swan.apps.v.b.b.this.FU() : 0)).a(aVar).hA("appjson_config_invalid").s(com.baidu.swan.apps.v.b.b.this));
                    com.baidu.swan.apps.statistic.b.c.c(new com.baidu.swan.apps.statistic.b.a("error", String.valueOf(System.currentTimeMillis()), String.valueOf(aVar.OZ())));
                } else {
                    com.baidu.swan.apps.statistic.b.c.c(new com.baidu.swan.apps.statistic.b.a("narun"));
                }
                bVar2.a(0, a2);
            }
        });
    }

    public static File Ed() {
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
                com.baidu.swan.apps.ak.a ii = new com.baidu.swan.apps.ak.a().Z(5L).aa(4L).ii("小程序bundle文件不存在或者空文件! ");
                if (bVar2 != null) {
                    bVar2.baP = ii;
                }
            } else {
                com.baidu.swan.apps.performance.f.IP().f(new UbcFlowEvent("package_start_unzip"));
                long currentTimeMillis = System.currentTimeMillis();
                BufferedInputStream r = com.baidu.swan.apps.install.a.a.r(file);
                if (r != null) {
                    z = com.baidu.swan.apps.install.a.a.a(r, file2).isSuccess;
                } else {
                    z = com.baidu.swan.c.a.bs(file.getPath(), file2.getPath());
                }
                long currentTimeMillis2 = System.currentTimeMillis();
                if (DEBUG) {
                    com.baidu.swan.apps.install.a.a.cB((int) (currentTimeMillis2 - currentTimeMillis));
                }
                if (!z) {
                    com.baidu.swan.apps.ak.a ii2 = new com.baidu.swan.apps.ak.a().Z(5L).aa(7L).ii("小程序bundle解压失败! ");
                    if (bVar2 != null) {
                        bVar2.baP = ii2;
                    }
                }
                com.baidu.swan.apps.performance.f.IP().f(new UbcFlowEvent("package_end_unzip"));
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
                        com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "小程序bundle解压失败!").LU();
                        com.baidu.swan.apps.ak.a ii = new com.baidu.swan.apps.ak.a().Z(5L).aa(7L).ii("小程序bundle解压失败! for release");
                        com.baidu.swan.apps.ak.e.Pd().b(ii);
                        if (bVar2 == null || bVar2.baP != null) {
                            return null;
                        }
                        bVar2.baP = ii;
                        return null;
                    }
                } else {
                    com.baidu.swan.apps.process.messaging.client.a.Jv().a(8, new SwanAppDeleteInfo(bVar.getAppId(), 1));
                    com.baidu.swan.apps.statistic.e.b(new com.baidu.swan.apps.statistic.a.d().hx(com.baidu.swan.apps.statistic.e.dQ(bVar.FU())).a(new com.baidu.swan.apps.ak.a().Z(5L).aa(31L).ii("小程序zip和bundle不存在，兜底重置")).s(bVar));
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
            com.baidu.swan.apps.ae.a.c gO = com.baidu.swan.apps.ae.a.c.gO(com.baidu.swan.c.a.v(file));
            if (gO != null) {
                gVar.ayN = b.getPath() + File.separator;
                gVar.ayO = gO;
                if (e.DEBUG) {
                    Log.d("SwanAppBundleHelper", "configFile path: " + file.getPath());
                    Log.d("SwanAppBundleHelper", "configFile exist: " + file.exists());
                    Log.d("SwanAppBundleHelper", "info.mAppBundlePath path: " + gVar.ayN);
                    Log.d("SwanAppBundleHelper", "launchInfo.swanCoreVersion.swanCorePath: " + bVar.Cm().aXh);
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
            if (com.baidu.swan.apps.statistic.f.hw(str2)) {
                com.baidu.swan.apps.statistic.f.c(str, str2, jSONObject);
            }
            return new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "aiapps_folder" + File.separator + str, str2);
        }

        public static void eG(String str) {
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
                        com.baidu.swan.apps.database.subpackage.a.CO().ac(str, file.getName());
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
            File Eh;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            File[] listFiles = Eh().listFiles();
            if (listFiles == null || listFiles.length == 0) {
                if (e.DEBUG && z) {
                    com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), Eh.getPath() + " 没有小程序包!").LU();
                }
                com.baidu.swan.apps.ak.a ii = new com.baidu.swan.apps.ak.a().Z(5L).aa(4L).ii("没有小程序包! for release, bundle files are empty");
                com.baidu.swan.apps.ak.e.Pd().b(ii);
                if (bVar != null) {
                    bVar.baP = ii;
                }
                return null;
            }
            for (File file : listFiles) {
                if (TextUtils.equals(file.getName(), str + ".aiapps")) {
                    return file;
                }
            }
            if (e.DEBUG && z) {
                com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), Eh.getPath() + " 没有小程序包!").LU();
            }
            com.baidu.swan.apps.ak.a ii2 = new com.baidu.swan.apps.ak.a().Z(5L).aa(4L).ii("没有小程序包! for release, no such bundle file");
            com.baidu.swan.apps.ak.e.Pd().b(ii2);
            if (bVar != null) {
                bVar.baP = ii2;
            }
            return null;
        }

        public static File Eh() {
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
        new com.baidu.swan.apps.k.a().a(cVar, a.Eg().getPath() + File.separator + String.valueOf(System.currentTimeMillis()) + ".aibundle", bVar);
    }

    public static void a(String str, b bVar) {
        c cVar = new c();
        cVar.mDownloadUrl = str;
        com.baidu.swan.apps.swancore.c.a.Df();
        new com.baidu.swan.apps.k.a().a(cVar, com.baidu.swan.apps.swancore.c.a.Dg().getPath(), bVar);
    }

    public static void b(String str, b bVar) {
        c cVar = new c();
        cVar.mDownloadUrl = str;
        com.baidu.swan.apps.extcore.debug.b.Df();
        new com.baidu.swan.apps.k.a().a(cVar, com.baidu.swan.apps.extcore.debug.b.Dg().getPath(), bVar);
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
                com.baidu.swan.apps.ae.b Mh = com.baidu.swan.apps.ae.b.Mh();
                if (Mh == null) {
                    if (!e.a(a, Ef(), bVar, bVar2)) {
                        com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "小程序bundle解压失败!").LU();
                        com.baidu.swan.apps.ak.a ii = new com.baidu.swan.apps.ak.a().Z(5L).aa(7L).ii("小程序bundle解压失败! for debug");
                        com.baidu.swan.apps.ak.e.Pd().b(ii);
                        if (bVar2 != null && bVar2.baP == null) {
                            bVar2.baP = ii;
                        }
                    }
                    gVar = new g();
                    File file = new File(Ee(), "app.json");
                    com.baidu.swan.apps.ae.a.c gO = com.baidu.swan.apps.ae.a.c.gO(com.baidu.swan.c.a.v(file));
                    gVar.ayN = Ee().getPath() + File.separator;
                    gVar.ayO = gO;
                    if (e.DEBUG) {
                    }
                } else {
                    String string = Mh.Ml().getString("installed_debug_bundle_md5", "");
                    String b = com.baidu.swan.c.b.b(a, false);
                    if (!TextUtils.equals(string, b)) {
                        if (!e.a(a, Ef(), bVar, bVar2)) {
                            com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "小程序bundle解压失败!").LU();
                            com.baidu.swan.apps.ak.a ii2 = new com.baidu.swan.apps.ak.a().Z(5L).aa(7L).ii("小程序bundle解压失败! for debug");
                            com.baidu.swan.apps.ak.e.Pd().b(ii2);
                            if (bVar2 != null && bVar2.baP == null) {
                                bVar2.baP = ii2;
                            }
                        } else {
                            Mh.Ml().putString("installed_debug_bundle_md5", b);
                        }
                    }
                    gVar = new g();
                    File file2 = new File(Ee(), "app.json");
                    com.baidu.swan.apps.ae.a.c gO2 = com.baidu.swan.apps.ae.a.c.gO(com.baidu.swan.c.a.v(file2));
                    gVar.ayN = Ee().getPath() + File.separator;
                    gVar.ayO = gO2;
                    if (e.DEBUG) {
                        Log.d("SwanAppBundleHelper", "configFile path: " + file2.getPath());
                        Log.d("SwanAppBundleHelper", "configFile exist: " + file2.exists());
                        Log.d("SwanAppBundleHelper", "info.mAppBundlePath path: " + gVar.ayN);
                        Log.d("SwanAppBundleHelper", "launchInfo.swanCoreVersion.swanCorePath: " + bVar.Cm().aXh);
                    }
                }
            }
            return gVar;
        }

        public static File Ee() {
            return Ef();
        }

        public static File Ef() {
            File file = new File(AppRuntime.getAppContext().getFilesDir(), "debug_aiapps_bundle");
            file.mkdirs();
            return file;
        }

        public static File a(com.baidu.swan.apps.an.a.b bVar) {
            File Eg = Eg();
            File[] listFiles = Eg.listFiles();
            if (listFiles == null || listFiles.length == 0) {
                com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), Eg.getPath() + " 没有测试程序包!").LU();
                com.baidu.swan.apps.ak.a ii = new com.baidu.swan.apps.ak.a().Z(5L).aa(4L).ii("没有小程序包! for debug, bundle files are empty");
                com.baidu.swan.apps.ak.e.Pd().b(ii);
                if (bVar != null) {
                    bVar.baP = ii;
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

        public static File Eg() {
            File file = new File(x.PD().get(0).wX, "baidu/aiapps_debug/");
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }
    }

    /* renamed from: com.baidu.swan.apps.install.e$e  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0160e {
        public static g j(com.baidu.swan.apps.v.b.b bVar) {
            e.a(Ei(), Ef(), bVar);
            g gVar = new g();
            File file = new File(Ef(), "app.json");
            com.baidu.swan.apps.ae.a.c gO = com.baidu.swan.apps.ae.a.c.gO(com.baidu.swan.c.a.v(file));
            gVar.ayN = Ef().getPath() + File.separator;
            gVar.ayO = gO;
            if (e.DEBUG) {
                Log.d("SwanAppBundleHelper", "configFile path: " + file.getPath());
                Log.d("SwanAppBundleHelper", "configFile exist: " + file.exists());
                Log.d("SwanAppBundleHelper", "info.mAppBundlePath path: " + gVar.ayN);
            }
            return gVar;
        }

        public static File Ef() {
            File file = new File(AppRuntime.getAppContext().getFilesDir(), "aiapps_remote_debug_folder");
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }

        public static File Ei() {
            return new File(Eg(), "remote_debug.aiapps");
        }

        public static File Eg() {
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
            File file = new File(subPackageAPSInfo.azl);
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
            if (subPackageAPSInfo == null || TextUtils.isEmpty(subPackageAPSInfo.azj) || TextUtils.isEmpty(subPackageAPSInfo.azk)) {
                if (e.DEBUG) {
                    Log.e("SwanAppBundleHelper", "获取分包解压文件夹失败");
                }
                return null;
            }
            return new File(subPackageAPSInfo.azj, subPackageAPSInfo.azk);
        }
    }
}
