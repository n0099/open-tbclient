package com.baidu.swan.games.i;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.an.aa;
import com.baidu.swan.apps.an.v;
import com.baidu.swan.apps.b;
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
    private static final boolean DEBUG = com.baidu.swan.apps.c.DEBUG;
    private static ExecutorService awT = Executors.newSingleThreadExecutor();

    /* loaded from: classes2.dex */
    public static class b extends com.baidu.swan.apps.install.a {
        public String bdB;
        public String bdC;
        public com.baidu.swan.games.o.a.a bdD;
    }

    public static void c(final com.baidu.swan.apps.v.b.b bVar, final com.baidu.swan.apps.install.b bVar2) {
        awT.execute(new Runnable() { // from class: com.baidu.swan.games.i.a.1
            @Override // java.lang.Runnable
            public void run() {
                b c2;
                com.baidu.swan.apps.an.a.b bVar3 = new com.baidu.swan.apps.an.a.b();
                if (com.baidu.swan.apps.v.b.b.this.axR && a.DEBUG) {
                    c2 = C0163a.b(com.baidu.swan.apps.v.b.b.this, bVar3);
                } else {
                    c2 = c.c(com.baidu.swan.apps.v.b.b.this, bVar3);
                }
                bVar2.a(0, c2);
            }
        });
    }

    public static File Cq() {
        return new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "aigames_folder");
    }

    public static void c(String str, c.b bVar) {
        c.C0115c c0115c = new c.C0115c();
        c0115c.mDownloadUrl = str;
        com.baidu.swan.games.h.a.b.Br();
        new com.baidu.swan.apps.k.a().a(c0115c, com.baidu.swan.games.h.a.b.Bs().getPath(), bVar);
    }

    public static String ba(String str, String str2) {
        if (DEBUG) {
            if (com.baidu.swan.games.h.a.c.iI("package")) {
                if (!new File(str, str2).exists()) {
                    aa.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.i.a.2
                        @Override // java.lang.Runnable
                        public void run() {
                            Toast.makeText(AppRuntime.getAppContext(), b.h.debug_game_core_package_error, 1).show();
                        }
                    });
                    return iJ(str);
                }
                return str;
            } else if (com.baidu.swan.games.h.a.c.iI("normal")) {
                return com.baidu.swan.games.h.a.b.Op();
            }
        }
        return iJ(str);
    }

    private static String iJ(String str) {
        SwanCoreVersion DH = e.Ec().DH();
        return (DH == null || TextUtils.isEmpty(DH.aTf)) ? str : DH.aTf;
    }

    /* renamed from: com.baidu.swan.games.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0163a {
        public static b b(com.baidu.swan.apps.v.b.b bVar, com.baidu.swan.apps.an.a.b bVar2) {
            File a = a(bVar2);
            if (a == null) {
                return null;
            }
            com.baidu.swan.apps.ae.b IX = com.baidu.swan.apps.ae.b.IX();
            String c = com.baidu.swan.c.c.c(a, false);
            File iK = iK(c);
            if (IX == null) {
                if (!a.c(a, iK, bVar, bVar2)) {
                    d.a(AppRuntime.getAppContext(), "小游戏bundle解压失败!").IK();
                    com.baidu.swan.apps.ak.a hw = new com.baidu.swan.apps.ak.a().L(5L).M(7L).hw("小游戏bundle解压失败! for debug");
                    com.baidu.swan.apps.ak.e.LG().b(hw);
                    if (bVar2 == null || bVar2.aWy != null) {
                        return null;
                    }
                    bVar2.aWy = hw;
                    return null;
                }
            } else if (!TextUtils.equals(IX.Jb().getString("installed_debug_game_bundle_md5", ""), c)) {
                if (!a.c(a, iK, bVar, bVar2)) {
                    d.a(AppRuntime.getAppContext(), "小游戏bundle解压失败!").IK();
                    com.baidu.swan.apps.ak.a hw2 = new com.baidu.swan.apps.ak.a().L(5L).M(7L).hw("小游戏bundle解压失败! for debug");
                    com.baidu.swan.apps.ak.e.LG().b(hw2);
                    if (bVar2 == null || bVar2.aWy != null) {
                        return null;
                    }
                    bVar2.aWy = hw2;
                    return null;
                }
                IX.Jb().putString("installed_debug_game_bundle_md5", c);
            }
            b bVar3 = new b();
            File file = new File(iK, "game.json");
            com.baidu.swan.games.o.a.a iU = com.baidu.swan.games.o.a.a.iU(com.baidu.swan.c.b.B(file));
            if (iU != null) {
                bVar3.bdB = iK.getPath() + File.separator;
                bVar3.bdD = iU;
                if (!TextUtils.isEmpty(iU.beV)) {
                    bVar3.bdC = bVar3.bdB + iU.beV + File.separator;
                    f.OM().cy(true);
                    f.OM().iT(bVar3.bdC);
                } else {
                    f.OM().cy(false);
                }
                if (a.DEBUG) {
                    Log.d("SwanAppBundleHelper", "configFile path: " + file.getPath());
                    Log.d("SwanAppBundleHelper", "configFile exist: " + file.exists());
                    Log.d("SwanAppBundleHelper", "info.appBundlePath path: " + bVar3.bdB);
                    Log.d("SwanAppBundleHelper", "info.mAppOpenDataBundle path: " + bVar3.bdC);
                }
                return bVar3;
            }
            return null;
        }

        public static File iK(String str) {
            File file = new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "debug_aigames_bundle", str);
            file.mkdirs();
            return file;
        }

        public static File a(com.baidu.swan.apps.an.a.b bVar) {
            File Ct = Ct();
            File[] listFiles = Ct.listFiles();
            if (listFiles == null || listFiles.length == 0) {
                d.a(AppRuntime.getAppContext(), Ct.getPath() + " 没有测试程序包!").IK();
                com.baidu.swan.apps.ak.a hw = new com.baidu.swan.apps.ak.a().L(5L).M(4L).hw("没有小游戏包! for debug, bundle files are empty");
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
            File file = new File(v.Me().get(0).mPath, "baidu/aigames_debug/");
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
                com.baidu.swan.apps.ak.a hw = new com.baidu.swan.apps.ak.a().L(5L).M(4L).hw("小游戏bundle文件不存在或者空文件! ");
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
                    com.baidu.swan.apps.ak.a hw2 = new com.baidu.swan.apps.ak.a().L(5L).M(7L).hw("小游戏bundle解压失败! ");
                    if (bVar2 != null) {
                        bVar2.aWy = hw2;
                    }
                }
                com.baidu.swan.apps.performance.f.FS().f(new UbcFlowEvent("package_end_unzip"));
            }
        }
        return z;
    }

    public static void a(c.C0115c c0115c, c.b bVar) {
        new com.baidu.swan.apps.k.a().a(c0115c, C0163a.Ct().getPath() + File.separator + String.valueOf(System.currentTimeMillis()) + ".aibundle", bVar);
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
                d.a(AppRuntime.getAppContext(), "小游戏bundle解压失败!").IK();
                com.baidu.swan.apps.ak.a hw = new com.baidu.swan.apps.ak.a().L(5L).M(7L).hw("小游戏bundle解压失败! for release");
                com.baidu.swan.apps.ak.e.LG().b(hw);
                if (bVar2 == null || bVar2.aWy != null) {
                    return null;
                }
                bVar2.aWy = hw;
                return null;
            }
            ai(bVar.mAppId, bVar.mVersion);
            b bVar3 = new b();
            File file = new File(ah, "game.json");
            com.baidu.swan.games.o.a.a iU = com.baidu.swan.games.o.a.a.iU(com.baidu.swan.c.b.B(file));
            if (iU != null) {
                bVar3.bdB = ah.getPath() + File.separator;
                bVar3.bdD = iU;
                if (!TextUtils.isEmpty(iU.beV)) {
                    bVar3.bdC = bVar3.bdB + File.separator + iU.beV + File.separator;
                    f.OM().cy(true);
                    f.OM().iT(bVar3.bdC);
                } else {
                    f.OM().cy(false);
                }
                if (a.DEBUG) {
                    Log.d("SwanAppBundleHelper", "configFile path: " + file.getPath());
                    Log.d("SwanAppBundleHelper", "configFile exist: " + file.exists());
                    Log.d("SwanAppBundleHelper", "info.appBundlePath path: " + bVar3.bdB);
                    Log.d("SwanAppBundleHelper", "info.mAppOpenDataBundle path: " + bVar3.bdC);
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

        public static void eK(String str) {
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
            return a(str, z, null);
        }

        public static File a(String str, boolean z, com.baidu.swan.apps.an.a.b bVar) {
            File Cu;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            File[] listFiles = Cu().listFiles();
            if (listFiles == null || listFiles.length == 0) {
                if (a.DEBUG && z) {
                    d.a(AppRuntime.getAppContext(), Cu.getPath() + " 没有小游戏包!").IK();
                }
                com.baidu.swan.apps.ak.a hw = new com.baidu.swan.apps.ak.a().L(5L).M(4L).hw("没有小游戏包! for release, bundle files are empty");
                com.baidu.swan.apps.ak.e.LG().b(hw);
                if (bVar != null) {
                    bVar.aWy = hw;
                }
                return null;
            }
            for (File file : listFiles) {
                if (TextUtils.equals(file.getName(), str + ".aigames")) {
                    return file;
                }
            }
            if (a.DEBUG && z) {
                d.a(AppRuntime.getAppContext(), Cu.getPath() + " 没有小游戏包!").IK();
            }
            com.baidu.swan.apps.ak.a hw2 = new com.baidu.swan.apps.ak.a().L(5L).M(4L).hw("没有小游戏包! for release, no such bundle file");
            com.baidu.swan.apps.ak.e.LG().b(hw2);
            if (bVar != null) {
                bVar.aWy = hw2;
            }
            return null;
        }

        public static File Cu() {
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
