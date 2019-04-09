package com.baidu.swan.games.i;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.an.aa;
import com.baidu.swan.apps.an.v;
import com.baidu.swan.apps.install.c;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.res.widget.b.d;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.swan.apps.w.e;
import com.baidu.swan.games.n.f;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileFilter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes2.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static ExecutorService awY = Executors.newSingleThreadExecutor();

    /* loaded from: classes2.dex */
    public static class b extends com.baidu.swan.apps.install.a {
        public String bdG;
        public String bdH;
        public com.baidu.swan.games.o.a.a bdI;
    }

    public static void c(final com.baidu.swan.apps.v.b.b bVar, final com.baidu.swan.apps.install.b bVar2) {
        awY.execute(new Runnable() { // from class: com.baidu.swan.games.i.a.1
            @Override // java.lang.Runnable
            public void run() {
                b c2;
                com.baidu.swan.apps.an.a.b bVar3 = new com.baidu.swan.apps.an.a.b();
                if (com.baidu.swan.apps.v.b.b.this.axW && a.DEBUG) {
                    c2 = C0192a.b(com.baidu.swan.apps.v.b.b.this, bVar3);
                } else {
                    c2 = c.c(com.baidu.swan.apps.v.b.b.this, bVar3);
                }
                bVar2.a(0, c2);
            }
        });
    }

    public static File Co() {
        return new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "aigames_folder");
    }

    public static void c(String str, c.b bVar) {
        c.C0144c c0144c = new c.C0144c();
        c0144c.mDownloadUrl = str;
        com.baidu.swan.games.h.a.b.Bp();
        new com.baidu.swan.apps.k.a().a(c0144c, com.baidu.swan.games.h.a.b.Bq().getPath(), bVar);
    }

    public static String ba(String str, String str2) {
        if (DEBUG) {
            if (com.baidu.swan.games.h.a.c.iJ("package")) {
                if (!new File(str, str2).exists()) {
                    aa.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.i.a.2
                        @Override // java.lang.Runnable
                        public void run() {
                            Toast.makeText(AppRuntime.getAppContext(), a.h.debug_game_core_package_error, 1).show();
                        }
                    });
                    return iK(str);
                }
                return str;
            } else if (com.baidu.swan.games.h.a.c.iJ("normal")) {
                return com.baidu.swan.games.h.a.b.On();
            }
        }
        return iK(str);
    }

    private static String iK(String str) {
        SwanCoreVersion DF = e.Ea().DF();
        return (DF == null || TextUtils.isEmpty(DF.aTk)) ? str : DF.aTk;
    }

    /* renamed from: com.baidu.swan.games.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0192a {
        public static b b(com.baidu.swan.apps.v.b.b bVar, com.baidu.swan.apps.an.a.b bVar2) {
            File a = a(bVar2);
            if (a == null) {
                return null;
            }
            com.baidu.swan.apps.ae.b IV = com.baidu.swan.apps.ae.b.IV();
            String c = com.baidu.swan.c.c.c(a, false);
            File iL = iL(c);
            if (IV == null) {
                if (!a.c(a, iL, bVar, bVar2)) {
                    d.a(AppRuntime.getAppContext(), "小游戏bundle解压失败!").II();
                    com.baidu.swan.apps.ak.a hx = new com.baidu.swan.apps.ak.a().L(5L).M(7L).hx("小游戏bundle解压失败! for debug");
                    com.baidu.swan.apps.ak.e.LE().b(hx);
                    if (bVar2 == null || bVar2.aWD != null) {
                        return null;
                    }
                    bVar2.aWD = hx;
                    return null;
                }
            } else if (!TextUtils.equals(IV.IZ().getString("installed_debug_game_bundle_md5", ""), c)) {
                if (!a.c(a, iL, bVar, bVar2)) {
                    d.a(AppRuntime.getAppContext(), "小游戏bundle解压失败!").II();
                    com.baidu.swan.apps.ak.a hx2 = new com.baidu.swan.apps.ak.a().L(5L).M(7L).hx("小游戏bundle解压失败! for debug");
                    com.baidu.swan.apps.ak.e.LE().b(hx2);
                    if (bVar2 == null || bVar2.aWD != null) {
                        return null;
                    }
                    bVar2.aWD = hx2;
                    return null;
                }
                IV.IZ().putString("installed_debug_game_bundle_md5", c);
            }
            b bVar3 = new b();
            File file = new File(iL, "game.json");
            com.baidu.swan.games.o.a.a iV = com.baidu.swan.games.o.a.a.iV(com.baidu.swan.c.b.B(file));
            if (iV != null) {
                bVar3.bdG = iL.getPath() + File.separator;
                bVar3.bdI = iV;
                if (!TextUtils.isEmpty(iV.bfa)) {
                    bVar3.bdH = bVar3.bdG + iV.bfa + File.separator;
                    f.OK().cy(true);
                    f.OK().iU(bVar3.bdH);
                } else {
                    f.OK().cy(false);
                }
                if (a.DEBUG) {
                    Log.d("SwanAppBundleHelper", "configFile path: " + file.getPath());
                    Log.d("SwanAppBundleHelper", "configFile exist: " + file.exists());
                    Log.d("SwanAppBundleHelper", "info.appBundlePath path: " + bVar3.bdG);
                    Log.d("SwanAppBundleHelper", "info.mAppOpenDataBundle path: " + bVar3.bdH);
                }
                return bVar3;
            }
            return null;
        }

        public static File iL(String str) {
            File file = new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "debug_aigames_bundle", str);
            file.mkdirs();
            return file;
        }

        public static File a(com.baidu.swan.apps.an.a.b bVar) {
            File Cr = Cr();
            File[] listFiles = Cr.listFiles();
            if (listFiles == null || listFiles.length == 0) {
                d.a(AppRuntime.getAppContext(), Cr.getPath() + " 没有测试程序包!").II();
                com.baidu.swan.apps.ak.a hx = new com.baidu.swan.apps.ak.a().L(5L).M(4L).hx("没有小游戏包! for debug, bundle files are empty");
                com.baidu.swan.apps.ak.e.LE().b(hx);
                if (bVar != null) {
                    bVar.aWD = hx;
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

        public static File Cr() {
            File file = new File(v.Mc().get(0).mPath, "baidu/aigames_debug/");
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
                com.baidu.swan.apps.ak.a hx = new com.baidu.swan.apps.ak.a().L(5L).M(4L).hx("小游戏bundle文件不存在或者空文件! ");
                if (bVar2 != null) {
                    bVar2.aWD = hx;
                }
            } else {
                com.baidu.swan.apps.performance.f.FQ().f(new UbcFlowEvent("package_start_unzip"));
                long currentTimeMillis = System.currentTimeMillis();
                BufferedInputStream x = com.baidu.swan.apps.install.a.a.x(file);
                if (x != null) {
                    z = com.baidu.swan.apps.install.a.a.a(file, file2, x).isSuccess;
                } else {
                    z = com.baidu.swan.c.b.bl(file.getPath(), file2.getPath());
                }
                long currentTimeMillis2 = System.currentTimeMillis();
                if (DEBUG) {
                    com.baidu.swan.apps.install.a.a.cz((int) (currentTimeMillis2 - currentTimeMillis));
                }
                if (!z) {
                    com.baidu.swan.apps.ak.a hx2 = new com.baidu.swan.apps.ak.a().L(5L).M(7L).hx("小游戏bundle解压失败! ");
                    if (bVar2 != null) {
                        bVar2.aWD = hx2;
                    }
                }
                com.baidu.swan.apps.performance.f.FQ().f(new UbcFlowEvent("package_end_unzip"));
            }
        }
        return z;
    }

    public static void a(c.C0144c c0144c, c.b bVar) {
        new com.baidu.swan.apps.k.a().a(c0144c, C0192a.Cr().getPath() + File.separator + String.valueOf(System.currentTimeMillis()) + ".aibundle", bVar);
    }

    /* loaded from: classes2.dex */
    public static class c {
        public static b c(com.baidu.swan.apps.v.b.b bVar, com.baidu.swan.apps.an.a.b bVar2) {
            File a;
            if (bVar == null || (a = a(bVar.mAppId, true, bVar2)) == null) {
                return null;
            }
            File ah = ah(bVar.mAppId, bVar.mVersion);
            if (!ah.exists() && !a.c(a, w(ah), bVar, bVar2)) {
                d.a(AppRuntime.getAppContext(), "小游戏bundle解压失败!").II();
                com.baidu.swan.apps.ak.a hx = new com.baidu.swan.apps.ak.a().L(5L).M(7L).hx("小游戏bundle解压失败! for release");
                com.baidu.swan.apps.ak.e.LE().b(hx);
                if (bVar2 == null || bVar2.aWD != null) {
                    return null;
                }
                bVar2.aWD = hx;
                return null;
            }
            ai(bVar.mAppId, bVar.mVersion);
            b bVar3 = new b();
            File file = new File(ah, "game.json");
            com.baidu.swan.games.o.a.a iV = com.baidu.swan.games.o.a.a.iV(com.baidu.swan.c.b.B(file));
            if (iV != null) {
                bVar3.bdG = ah.getPath() + File.separator;
                bVar3.bdI = iV;
                if (!TextUtils.isEmpty(iV.bfa)) {
                    bVar3.bdH = bVar3.bdG + File.separator + iV.bfa + File.separator;
                    f.OK().cy(true);
                    f.OK().iU(bVar3.bdH);
                } else {
                    f.OK().cy(false);
                }
                if (a.DEBUG) {
                    Log.d("SwanAppBundleHelper", "configFile path: " + file.getPath());
                    Log.d("SwanAppBundleHelper", "configFile exist: " + file.exists());
                    Log.d("SwanAppBundleHelper", "info.appBundlePath path: " + bVar3.bdG);
                    Log.d("SwanAppBundleHelper", "info.mAppOpenDataBundle path: " + bVar3.bdH);
                }
                return bVar3;
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
            return new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "aigames_folder" + File.separator + str, str2);
        }

        public static void eL(String str) {
            if (!TextUtils.isEmpty(str)) {
                File q = q(str, false);
                if (q != null) {
                    com.baidu.swan.c.b.deleteFile(q);
                }
                com.baidu.swan.c.b.deleteFile(new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "aigames_folder" + File.separator + str));
            }
        }

        private static void ai(String str, String str2) {
            File[] listFiles;
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && (listFiles = new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "aigames_folder", str).listFiles(new FileFilter() { // from class: com.baidu.swan.games.i.a.c.1
                @Override // java.io.FileFilter
                public boolean accept(File file) {
                    return file.isDirectory() && TextUtils.isDigitsOnly(file.getName());
                }
            })) != null && listFiles.length > 0) {
                for (File file : listFiles) {
                    if (aj(str2, file.getName())) {
                        if (a.DEBUG) {
                            Log.i("SwanAppBundleHelper", "删除低版本文件夹：" + file.getAbsolutePath());
                        }
                        com.baidu.swan.apps.database.subpackage.a.AT().ag(str, file.getName());
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
            return a(str, z, null);
        }

        public static File a(String str, boolean z, com.baidu.swan.apps.an.a.b bVar) {
            File Cs;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            File[] listFiles = Cs().listFiles();
            if (listFiles == null || listFiles.length == 0) {
                if (a.DEBUG && z) {
                    d.a(AppRuntime.getAppContext(), Cs.getPath() + " 没有小游戏包!").II();
                }
                com.baidu.swan.apps.ak.a hx = new com.baidu.swan.apps.ak.a().L(5L).M(4L).hx("没有小游戏包! for release, bundle files are empty");
                com.baidu.swan.apps.ak.e.LE().b(hx);
                if (bVar != null) {
                    bVar.aWD = hx;
                }
                return null;
            }
            for (File file : listFiles) {
                if (TextUtils.equals(file.getName(), str + ".aigames")) {
                    return file;
                }
            }
            if (a.DEBUG && z) {
                d.a(AppRuntime.getAppContext(), Cs.getPath() + " 没有小游戏包!").II();
            }
            com.baidu.swan.apps.ak.a hx2 = new com.baidu.swan.apps.ak.a().L(5L).M(4L).hx("没有小游戏包! for release, no such bundle file");
            com.baidu.swan.apps.ak.e.LE().b(hx2);
            if (bVar != null) {
                bVar.aWD = hx2;
            }
            return null;
        }

        public static File Cs() {
            File file = new File(AppRuntime.getAppContext().getFilesDir(), "aigames_zip");
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }

        private static boolean aj(String str, String str2) {
            if (a.DEBUG) {
                Log.i("SwanAppBundleHelper", "curVersion:" + str + ",targetVersion:" + str2);
            }
            try {
                return ak(str, str2) > 0;
            } catch (IllegalArgumentException e) {
                if (a.DEBUG) {
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
}
