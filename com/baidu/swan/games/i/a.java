package com.baidu.swan.games.i;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.an.ac;
import com.baidu.swan.apps.an.x;
import com.baidu.swan.apps.install.e;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.swan.games.o.f;
import com.baidu.swan.games.subpackage.aps.SwanGameSubPackageAPSInfo;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileFilter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes2.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static ExecutorService ayJ = Executors.newSingleThreadExecutor();

    /* loaded from: classes2.dex */
    public static class c extends com.baidu.swan.apps.install.a {
        public String bjh;
        public String bji;
        public com.baidu.swan.games.p.a.a bjj;
    }

    public static void c(final com.baidu.swan.apps.v.b.b bVar, final com.baidu.swan.apps.install.b bVar2) {
        ayJ.execute(new Runnable() { // from class: com.baidu.swan.games.i.a.1
            @Override // java.lang.Runnable
            public void run() {
                c c2;
                com.baidu.swan.apps.an.a.b bVar3 = new com.baidu.swan.apps.an.a.b();
                if (com.baidu.swan.apps.v.b.b.this.isDebug() && a.DEBUG) {
                    c2 = b.b(com.baidu.swan.apps.v.b.b.this, bVar3);
                } else {
                    c2 = d.c(com.baidu.swan.apps.v.b.b.this, bVar3);
                }
                bVar2.a(0, c2);
            }
        });
    }

    public static File Ed() {
        return new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "aigames_folder");
    }

    public static void c(String str, e.b bVar) {
        e.c cVar = new e.c();
        cVar.mDownloadUrl = str;
        com.baidu.swan.games.h.a.b.Df();
        new com.baidu.swan.apps.k.a().a(cVar, com.baidu.swan.games.h.a.b.Dg().getPath(), bVar);
    }

    public static String bd(String str, String str2) {
        if (DEBUG) {
            if (com.baidu.swan.games.h.a.c.jD("package")) {
                if (!new File(str, str2).exists()) {
                    ac.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.i.a.2
                        @Override // java.lang.Runnable
                        public void run() {
                            Toast.makeText(AppRuntime.getAppContext(), a.h.debug_game_core_package_error, 1).show();
                        }
                    });
                    return jF(str);
                }
                return str;
            } else if (com.baidu.swan.games.h.a.c.jD("normal")) {
                return com.baidu.swan.games.h.a.b.Si();
            }
        }
        return jF(str);
    }

    private static String jF(String str) {
        SwanCoreVersion Go = com.baidu.swan.apps.w.e.GJ().Go();
        return (Go == null || TextUtils.isEmpty(Go.aXh)) ? str : Go.aXh;
    }

    /* loaded from: classes2.dex */
    public static class b {
        public static c b(com.baidu.swan.apps.v.b.b bVar, com.baidu.swan.apps.an.a.b bVar2) {
            File a = a(bVar2);
            if (a == null) {
                return null;
            }
            com.baidu.swan.apps.ae.b Mh = com.baidu.swan.apps.ae.b.Mh();
            String b = com.baidu.swan.c.b.b(a, false);
            File jG = jG(b);
            if (Mh == null) {
                if (!a.c(a, jG, bVar, bVar2)) {
                    com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "小游戏bundle解压失败!").LU();
                    com.baidu.swan.apps.ak.a ii = new com.baidu.swan.apps.ak.a().Z(5L).aa(7L).ii("小游戏bundle解压失败! for debug");
                    com.baidu.swan.apps.ak.e.Pd().b(ii);
                    if (bVar2 == null || bVar2.baP != null) {
                        return null;
                    }
                    bVar2.baP = ii;
                    return null;
                }
            } else if (!TextUtils.equals(Mh.Ml().getString("installed_debug_game_bundle_md5", ""), b)) {
                if (!a.c(a, jG, bVar, bVar2)) {
                    com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "小游戏bundle解压失败!").LU();
                    com.baidu.swan.apps.ak.a ii2 = new com.baidu.swan.apps.ak.a().Z(5L).aa(7L).ii("小游戏bundle解压失败! for debug");
                    com.baidu.swan.apps.ak.e.Pd().b(ii2);
                    if (bVar2 == null || bVar2.baP != null) {
                        return null;
                    }
                    bVar2.baP = ii2;
                    return null;
                }
                Mh.Ml().putString("installed_debug_game_bundle_md5", b);
            }
            c cVar = new c();
            File file = new File(jG, "game.json");
            com.baidu.swan.games.p.a.a jS = com.baidu.swan.games.p.a.a.jS(com.baidu.swan.c.a.v(file));
            if (jS != null) {
                cVar.bjh = jG.getPath() + File.separator;
                cVar.bjj = jS;
                if (!TextUtils.isEmpty(jS.bkC)) {
                    cVar.bji = cVar.bjh + jS.bkC + File.separator;
                    f.SM().cS(true);
                    f.SM().jQ(cVar.bji);
                    f.SM().jR(jS.bkC);
                } else {
                    f.SM().cS(false);
                }
                if (a.DEBUG) {
                    Log.d("SwanAppBundleHelper", "configFile path: " + file.getPath());
                    Log.d("SwanAppBundleHelper", "configFile exist: " + file.exists());
                    Log.d("SwanAppBundleHelper", "info.appBundlePath path: " + cVar.bjh);
                    Log.d("SwanAppBundleHelper", "info.mAppOpenDataBundle path: " + cVar.bji);
                }
                return cVar;
            }
            return null;
        }

        public static File jG(String str) {
            File file = new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "debug_aigames_bundle", str);
            file.mkdirs();
            return file;
        }

        public static File a(com.baidu.swan.apps.an.a.b bVar) {
            File Eg = Eg();
            File[] listFiles = Eg.listFiles();
            if (listFiles == null || listFiles.length == 0) {
                com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), Eg.getPath() + " 没有测试程序包!").LU();
                com.baidu.swan.apps.ak.a ii = new com.baidu.swan.apps.ak.a().Z(5L).aa(4L).ii("没有小游戏包! for debug, bundle files are empty");
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
            File file = new File(x.PD().get(0).wX, "baidu/aigames_debug/");
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean c(File file, File file2, com.baidu.swan.apps.v.b.b bVar, com.baidu.swan.apps.an.a.b bVar2) {
        boolean z = false;
        if (file != null && file2 != null) {
            if (!file.exists() || file.length() == 0) {
                com.baidu.swan.apps.ak.a ii = new com.baidu.swan.apps.ak.a().Z(5L).aa(4L).ii("小游戏bundle文件不存在或者空文件! ");
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
                    com.baidu.swan.apps.ak.a ii2 = new com.baidu.swan.apps.ak.a().Z(5L).aa(7L).ii("小游戏bundle解压失败! ");
                    if (bVar2 != null) {
                        bVar2.baP = ii2;
                    }
                }
                com.baidu.swan.apps.performance.f.IP().f(new UbcFlowEvent("package_end_unzip"));
            }
        }
        return z;
    }

    public static void a(e.c cVar, e.b bVar) {
        new com.baidu.swan.apps.k.a().a(cVar, b.Eg().getPath() + File.separator + String.valueOf(System.currentTimeMillis()) + ".aibundle", bVar);
    }

    /* loaded from: classes2.dex */
    public static class d {
        public static c c(com.baidu.swan.apps.v.b.b bVar, com.baidu.swan.apps.an.a.b bVar2) {
            File a;
            if (bVar == null || (a = a(bVar.getAppId(), true, bVar2)) == null) {
                return null;
            }
            File ae = ae(bVar.getAppId(), bVar.getVersion());
            if (!ae.exists() && !a.c(a, q(ae), bVar, bVar2)) {
                com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "小游戏bundle解压失败!").LU();
                com.baidu.swan.apps.ak.a ii = new com.baidu.swan.apps.ak.a().Z(5L).aa(7L).ii("小游戏bundle解压失败! for release");
                com.baidu.swan.apps.ak.e.Pd().b(ii);
                if (bVar2 == null || bVar2.baP != null) {
                    return null;
                }
                bVar2.baP = ii;
                return null;
            }
            af(bVar.getAppId(), bVar.getVersion());
            c cVar = new c();
            File file = new File(ae, "game.json");
            com.baidu.swan.games.p.a.a jS = com.baidu.swan.games.p.a.a.jS(com.baidu.swan.c.a.v(file));
            if (jS != null) {
                cVar.bjh = ae.getPath() + File.separator;
                cVar.bjj = jS;
                if (!TextUtils.isEmpty(jS.bkC)) {
                    cVar.bji = cVar.bjh + File.separator + jS.bkC + File.separator;
                    f.SM().cS(true);
                    f.SM().jQ(cVar.bji);
                    f.SM().jR(jS.bkC);
                } else {
                    f.SM().cS(false);
                }
                if (a.DEBUG) {
                    Log.d("SwanAppBundleHelper", "configFile path: " + file.getPath());
                    Log.d("SwanAppBundleHelper", "configFile exist: " + file.exists());
                    Log.d("SwanAppBundleHelper", "info.appBundlePath path: " + cVar.bjh);
                    Log.d("SwanAppBundleHelper", "info.mAppOpenDataBundle path: " + cVar.bji);
                }
                return cVar;
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
            return new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "aigames_folder" + File.separator + str, str2);
        }

        public static void eG(String str) {
            if (!TextUtils.isEmpty(str)) {
                File q = q(str, false);
                if (q != null) {
                    com.baidu.swan.c.a.deleteFile(q);
                }
                com.baidu.swan.c.a.deleteFile(new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "aigames_folder" + File.separator + str));
            }
        }

        private static void af(String str, String str2) {
            File[] listFiles;
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && (listFiles = new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "aigames_folder", str).listFiles(new FileFilter() { // from class: com.baidu.swan.games.i.a.d.1
                @Override // java.io.FileFilter
                public boolean accept(File file) {
                    return file.isDirectory() && TextUtils.isDigitsOnly(file.getName());
                }
            })) != null && listFiles.length > 0) {
                for (File file : listFiles) {
                    if (ag(str2, file.getName())) {
                        if (a.DEBUG) {
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
            return a(str, z, null);
        }

        public static File a(String str, boolean z, com.baidu.swan.apps.an.a.b bVar) {
            File Eh;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            File[] listFiles = Eh().listFiles();
            if (listFiles == null || listFiles.length == 0) {
                if (a.DEBUG && z) {
                    com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), Eh.getPath() + " 没有小游戏包!").LU();
                }
                com.baidu.swan.apps.ak.a ii = new com.baidu.swan.apps.ak.a().Z(5L).aa(4L).ii("没有小游戏包! for release, bundle files are empty");
                com.baidu.swan.apps.ak.e.Pd().b(ii);
                if (bVar != null) {
                    bVar.baP = ii;
                }
                return null;
            }
            for (File file : listFiles) {
                if (TextUtils.equals(file.getName(), str + ".aigames")) {
                    return file;
                }
            }
            if (a.DEBUG && z) {
                com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), Eh.getPath() + " 没有小游戏包!").LU();
            }
            com.baidu.swan.apps.ak.a ii2 = new com.baidu.swan.apps.ak.a().Z(5L).aa(4L).ii("没有小游戏包! for release, no such bundle file");
            com.baidu.swan.apps.ak.e.Pd().b(ii2);
            if (bVar != null) {
                bVar.baP = ii2;
            }
            return null;
        }

        public static File Eh() {
            File file = new File(AppRuntime.getAppContext().getFilesDir(), "aigames_zip");
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }

        private static boolean ag(String str, String str2) {
            if (a.DEBUG) {
                Log.i("SwanAppBundleHelper", "curVersion:" + str + ",targetVersion:" + str2);
            }
            try {
                return ah(str, str2) > 0;
            } catch (IllegalArgumentException e) {
                if (a.DEBUG) {
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

    /* renamed from: com.baidu.swan.games.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0213a {
        public static boolean a(SwanGameSubPackageAPSInfo swanGameSubPackageAPSInfo) {
            boolean bs;
            if (swanGameSubPackageAPSInfo == null) {
                return false;
            }
            File file = new File(swanGameSubPackageAPSInfo.blV);
            if (!file.exists()) {
                if (a.DEBUG) {
                    Log.e("SwanAppBundleHelper", "解压分包时，ZIP包不存在");
                    return false;
                }
                return false;
            }
            File b = b(swanGameSubPackageAPSInfo);
            if (b != null) {
                if (!b.exists() && !b.mkdirs()) {
                    if (a.DEBUG) {
                        Log.e("SwanAppBundleHelper", "创建分包解压文件夹失败");
                        return false;
                    }
                    return false;
                }
                BufferedInputStream r = com.baidu.swan.apps.install.a.a.r(file);
                if (r != null) {
                    bs = com.baidu.swan.apps.install.a.a.a(r, b).isSuccess;
                } else {
                    bs = com.baidu.swan.c.a.bs(file.getAbsolutePath(), b.getAbsolutePath());
                }
                if (bs) {
                    if (a.DEBUG) {
                        Log.e("SwanAppBundleHelper", "分包解压成功");
                    }
                    return true;
                } else if (a.DEBUG) {
                    Log.e("SwanAppBundleHelper", "分包解压文件失败, file:" + file.getAbsolutePath() + " folder:" + b.getAbsolutePath());
                    return false;
                } else {
                    return false;
                }
            }
            return false;
        }

        private static File b(SwanGameSubPackageAPSInfo swanGameSubPackageAPSInfo) {
            if (swanGameSubPackageAPSInfo == null || TextUtils.isEmpty(swanGameSubPackageAPSInfo.blT) || swanGameSubPackageAPSInfo.blX == null) {
                if (a.DEBUG) {
                    Log.e("SwanAppBundleHelper", "获取分包解压文件夹失败");
                }
                return null;
            }
            return new File(swanGameSubPackageAPSInfo.blT, swanGameSubPackageAPSInfo.blX);
        }
    }
}
