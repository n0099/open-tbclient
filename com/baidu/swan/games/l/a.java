package com.baidu.swan.games.l;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.env.SwanAppDeleteInfo;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.performance.i;
import com.baidu.swan.apps.r.a.a;
import com.baidu.swan.apps.r.d;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.games.r.f;
import java.io.File;
import java.io.FileFilter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes25.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static ExecutorService dcv = Executors.newSingleThreadExecutor();

    /* loaded from: classes25.dex */
    public static class b extends com.baidu.swan.apps.r.a {
        public String appBundlePath;
        public String ebO;
        public com.baidu.swan.games.t.a.a ebP;
    }

    public static void c(final com.baidu.swan.apps.u.c.b bVar, final com.baidu.swan.apps.r.b bVar2) {
        dcv.execute(new Runnable() { // from class: com.baidu.swan.games.l.a.1
            @Override // java.lang.Runnable
            public void run() {
                b c2;
                com.baidu.swan.apps.ap.a.b bVar3 = new com.baidu.swan.apps.ap.a.b();
                if (com.baidu.swan.apps.u.c.b.this.isDebug() && (com.baidu.swan.apps.ad.a.a.aHn() || a.DEBUG)) {
                    c2 = C0545a.b(com.baidu.swan.apps.u.c.b.this, bVar3);
                } else {
                    c2 = c.c(com.baidu.swan.apps.u.c.b.this, bVar3);
                }
                bVar2.a(0, c2);
            }
        });
    }

    public static File ayQ() {
        return new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "aigames_folder");
    }

    public static File xI(String str) {
        File file = new File(AppRuntime.getAppContext().getExternalFilesDir(null), "swangame/debug");
        return TextUtils.isEmpty(str) ? file : new File(file, str);
    }

    public static void c(String str, d.b bVar) {
        d.c cVar = new d.c();
        cVar.mDownloadUrl = str;
        com.baidu.swan.games.k.a.b.awG();
        new com.baidu.swan.apps.l.a().a(cVar, com.baidu.swan.games.k.a.b.awH().getPath(), bVar);
    }

    public static void b(String str, d.b bVar) {
        d.c cVar = new d.c();
        cVar.mDownloadUrl = str;
        com.baidu.swan.games.h.a.b.awG();
        new com.baidu.swan.apps.l.a().a(cVar, com.baidu.swan.games.h.a.b.awH().getPath(), bVar);
    }

    /* renamed from: com.baidu.swan.games.l.a$a  reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    public static class C0545a {
        public static b b(com.baidu.swan.apps.u.c.b bVar, com.baidu.swan.apps.ap.a.b bVar2) {
            File a2 = a(bVar2);
            if (a2 == null) {
                return null;
            }
            e aJU = e.aJU();
            String md5 = com.baidu.swan.c.e.toMd5(a2, false);
            File xJ = xJ(md5);
            if (aJU == null) {
                if (!a.c(a2, xJ, bVar, bVar2)) {
                    com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "小游戏bundle解压失败!").showToast();
                    com.baidu.swan.apps.am.a uC = new com.baidu.swan.apps.am.a().cU(5L).cV(7L).uC("小游戏bundle解压失败! for debug");
                    com.baidu.swan.apps.am.e.aOs().j(uC);
                    if (bVar2 == null || bVar2.dJA != null) {
                        return null;
                    }
                    bVar2.dJA = uC;
                    return null;
                }
            } else if (!TextUtils.equals(aJU.aKg().getString("installed_debug_game_bundle_md5", ""), md5)) {
                if (!a.c(a2, xJ, bVar, bVar2)) {
                    com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "小游戏bundle解压失败!").showToast();
                    com.baidu.swan.apps.am.a uC2 = new com.baidu.swan.apps.am.a().cU(5L).cV(7L).uC("小游戏bundle解压失败! for debug");
                    com.baidu.swan.apps.am.e.aOs().j(uC2);
                    if (bVar2 == null || bVar2.dJA != null) {
                        return null;
                    }
                    bVar2.dJA = uC2;
                    return null;
                }
                aJU.aKg().putString("installed_debug_game_bundle_md5", md5);
            }
            b bVar3 = new b();
            File file = new File(xJ, "game.json");
            com.baidu.swan.games.t.a.a xW = com.baidu.swan.games.t.a.a.xW(com.baidu.swan.c.d.readFileData(file));
            if (xW != null) {
                bVar3.appBundlePath = xJ.getPath() + File.separator;
                bVar3.ebP = xW;
                if (!TextUtils.isEmpty(xW.edH)) {
                    bVar3.ebO = bVar3.appBundlePath + xW.edH + File.separator;
                    f.aYX().hP(true);
                    f.aYX().xU(bVar3.ebO);
                    f.aYX().xV(xW.edH);
                } else {
                    f.aYX().hP(false);
                }
                if (a.DEBUG) {
                    Log.d("SwanAppBundleHelper", "configFile path: " + file.getPath());
                    Log.d("SwanAppBundleHelper", "configFile exist: " + file.exists());
                    Log.d("SwanAppBundleHelper", "info.appBundlePath path: " + bVar3.appBundlePath);
                    Log.d("SwanAppBundleHelper", "info.mAppOpenDataBundle path: " + bVar3.ebO);
                }
                return bVar3;
            }
            return null;
        }

        public static File xJ(String str) {
            File file = new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "debug_aigames_bundle", str);
            file.mkdirs();
            return file;
        }

        public static File a(com.baidu.swan.apps.ap.a.b bVar) {
            File aoB = aoB();
            File[] listFiles = aoB.listFiles();
            if (listFiles == null || listFiles.length == 0) {
                com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), aoB.getPath() + " 没有测试程序包!").showToast();
                com.baidu.swan.apps.am.a uC = new com.baidu.swan.apps.am.a().cU(5L).cV(4L).uC("没有小游戏包! for debug, bundle files are empty");
                com.baidu.swan.apps.am.e.aOs().j(uC);
                if (bVar != null) {
                    bVar.dJA = uC;
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

        public static File aoB() {
            File xI = a.xI("aigames_debug");
            if (!xI.exists()) {
                xI.mkdirs();
            }
            return xI;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean c(File file, File file2, com.baidu.swan.apps.u.c.b bVar, com.baidu.swan.apps.ap.a.b bVar2) {
        boolean unzipFile;
        int i = 0;
        if (file == null || file2 == null) {
            return false;
        }
        if (!file.exists() || file.length() == 0) {
            com.baidu.swan.apps.am.a uC = new com.baidu.swan.apps.am.a().cU(5L).cV(4L).uC("小游戏bundle文件不存在或者空文件! ");
            if (bVar2 != null) {
                bVar2.dJA = uC;
                return false;
            }
            return false;
        }
        i.aGg().f(new UbcFlowEvent("package_start_unzip"));
        long currentTimeMillis = System.currentTimeMillis();
        a.b A = com.baidu.swan.apps.r.a.a.A(file);
        if (A.type != -1) {
            unzipFile = com.baidu.swan.apps.r.a.a.a(A.dcK, file2, A.type).isSuccess;
            i = A.type;
        } else {
            unzipFile = com.baidu.swan.c.d.unzipFile(file.getPath(), file2.getPath());
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        if (DEBUG) {
            com.baidu.swan.apps.r.a.a.jt((int) (currentTimeMillis2 - currentTimeMillis));
        }
        if (!unzipFile) {
            com.baidu.swan.apps.am.a uC2 = new com.baidu.swan.apps.am.a().cU(5L).cV(7L).uC("小游戏bundle解压失败! PkgType=" + i);
            if (bVar2 != null) {
                bVar2.dJA = uC2;
            }
        }
        i.aGg().f(new UbcFlowEvent("package_end_unzip")).co("app_package_version", String.valueOf(i));
        return unzipFile;
    }

    public static void a(d.c cVar, d.b bVar) {
        new com.baidu.swan.apps.l.a().a(cVar, C0545a.aoB().getPath() + File.separator + System.currentTimeMillis() + ".aibundle", bVar);
    }

    /* loaded from: classes25.dex */
    public static class c {
        public static b c(com.baidu.swan.apps.u.c.b bVar, com.baidu.swan.apps.ap.a.b bVar2) {
            if (bVar == null) {
                return null;
            }
            File bT = bT(bVar.getAppId(), bVar.getVersion());
            if (!bT.exists()) {
                File a2 = a(bVar.getAppId(), true, bVar2);
                if (a2 != null) {
                    if (!a.c(a2, z(bT), bVar, bVar2)) {
                        com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "小游戏bundle解压失败!").showToast();
                        com.baidu.swan.apps.am.a uC = new com.baidu.swan.apps.am.a().cU(5L).cV(7L).uC("小游戏bundle解压失败! for release");
                        com.baidu.swan.apps.am.e.aOs().j(uC);
                        if (bVar2 == null || bVar2.dJA != null) {
                            return null;
                        }
                        bVar2.dJA = uC;
                        return null;
                    }
                } else {
                    com.baidu.swan.apps.process.messaging.client.a.aHO().a(8, new SwanAppDeleteInfo(bVar.getAppId(), 1).iN(5));
                    return null;
                }
            }
            bU(bVar.getAppId(), bVar.getVersion());
            b bVar3 = new b();
            File file = new File(bT, "game.json");
            com.baidu.swan.games.t.a.a xW = com.baidu.swan.games.t.a.a.xW(com.baidu.swan.c.d.readFileData(file));
            if (xW != null) {
                bVar3.appBundlePath = bT.getPath() + File.separator;
                bVar3.ebP = xW;
                if (!TextUtils.isEmpty(xW.edH)) {
                    bVar3.ebO = bVar3.appBundlePath + File.separator + xW.edH + File.separator;
                    f.aYX().hP(true);
                    f.aYX().xU(bVar3.ebO);
                    f.aYX().xV(xW.edH);
                } else {
                    f.aYX().hP(false);
                }
                if (a.DEBUG) {
                    Log.d("SwanAppBundleHelper", "configFile path: " + file.getPath());
                    Log.d("SwanAppBundleHelper", "configFile exist: " + file.exists());
                    Log.d("SwanAppBundleHelper", "info.appBundlePath path: " + bVar3.appBundlePath);
                    Log.d("SwanAppBundleHelper", "info.mAppOpenDataBundle path: " + bVar3.ebO);
                }
                return bVar3;
            }
            return null;
        }

        public static File z(File file) {
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }

        public static File bT(String str, String str2) {
            return new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "aigames_folder" + File.separator + str, str2);
        }

        public static void pw(String str) {
            if (!TextUtils.isEmpty(str)) {
                File Z = Z(str, false);
                if (Z != null) {
                    com.baidu.swan.c.d.deleteFile(Z);
                }
                com.baidu.swan.c.d.deleteFile(new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "aigames_folder" + File.separator + str));
            }
        }

        private static void bU(String str, String str2) {
            File[] listFiles;
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && (listFiles = new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "aigames_folder", str).listFiles(new FileFilter() { // from class: com.baidu.swan.games.l.a.c.1
                @Override // java.io.FileFilter
                public boolean accept(File file) {
                    return file.isDirectory() && TextUtils.isDigitsOnly(file.getName());
                }
            })) != null && listFiles.length > 0) {
                for (File file : listFiles) {
                    if (bV(str2, file.getName())) {
                        if (a.DEBUG) {
                            Log.i("SwanAppBundleHelper", "删除低版本文件夹：" + file.getAbsolutePath());
                        }
                        com.baidu.swan.pms.database.a.bdF().dw(str, file.getName());
                        com.baidu.swan.c.d.deleteFile(file);
                    }
                }
            }
        }

        @Nullable
        public static File Z(String str, boolean z) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return a(str, z, null);
        }

        public static File a(String str, boolean z, com.baidu.swan.apps.ap.a.b bVar) {
            File ayU;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            File[] listFiles = ayU().listFiles();
            if (listFiles == null || listFiles.length == 0) {
                if (a.DEBUG && z) {
                    com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), ayU.getPath() + " 没有小游戏包!").showToast();
                }
                com.baidu.swan.apps.am.a uC = new com.baidu.swan.apps.am.a().cU(5L).cV(4L).uC("没有小游戏包! for release, bundle files are empty");
                com.baidu.swan.apps.am.e.aOs().j(uC);
                if (bVar != null) {
                    bVar.dJA = uC;
                }
                return null;
            }
            for (File file : listFiles) {
                if (TextUtils.equals(file.getName(), str + ".aigames")) {
                    return file;
                }
            }
            if (a.DEBUG && z) {
                com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), ayU.getPath() + " 没有小游戏包!").showToast();
            }
            com.baidu.swan.apps.am.a uC2 = new com.baidu.swan.apps.am.a().cU(5L).cV(4L).uC("没有小游戏包! for release, no such bundle file");
            com.baidu.swan.apps.am.e.aOs().j(uC2);
            if (bVar != null) {
                bVar.dJA = uC2;
            }
            return null;
        }

        public static File ayU() {
            File file = new File(AppRuntime.getAppContext().getFilesDir(), "aigames_zip");
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }

        private static boolean bV(String str, String str2) {
            if (a.DEBUG) {
                Log.i("SwanAppBundleHelper", "curVersion:" + str + ",targetVersion:" + str2);
            }
            try {
                return bW(str, str2) > 0;
            } catch (IllegalArgumentException e) {
                if (a.DEBUG) {
                    Log.e("SwanAppBundleHelper", "比较版本号Exception：" + e.getMessage());
                    return false;
                }
                return false;
            }
        }

        private static long bW(String str, String str2) throws IllegalArgumentException {
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
