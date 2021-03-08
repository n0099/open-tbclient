package com.baidu.swan.games.l;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
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
/* loaded from: classes8.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static ExecutorService dgo = Executors.newSingleThreadExecutor();

    /* loaded from: classes8.dex */
    public static class b extends com.baidu.swan.apps.r.a {
        public String appBundlePath;
        public String ejH;
        public com.baidu.swan.games.t.a.a ejI;
    }

    public static void c(final com.baidu.swan.apps.u.c.b bVar, final com.baidu.swan.apps.r.b bVar2) {
        dgo.execute(new Runnable() { // from class: com.baidu.swan.games.l.a.1
            @Override // java.lang.Runnable
            public void run() {
                b c2;
                com.baidu.swan.apps.ao.a.b bVar3 = new com.baidu.swan.apps.ao.a.b();
                if (com.baidu.swan.apps.u.c.b.this.isDebug() && (com.baidu.swan.apps.ad.a.a.aFl() || a.DEBUG)) {
                    c2 = C0524a.b(com.baidu.swan.apps.u.c.b.this, bVar3);
                } else {
                    c2 = c.c(com.baidu.swan.apps.u.c.b.this, bVar3);
                }
                bVar2.a(0, c2);
            }
        });
    }

    public static File awP() {
        return new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "aigames_folder");
    }

    public static File wW(String str) {
        File file = new File(AppRuntime.getAppContext().getExternalFilesDir(null), "swangame/debug");
        return TextUtils.isEmpty(str) ? file : new File(file, str);
    }

    public static void c(String str, d.b bVar) {
        d.c cVar = new d.c();
        cVar.mDownloadUrl = str;
        com.baidu.swan.games.k.a.b.auG();
        new com.baidu.swan.apps.l.a().a(cVar, com.baidu.swan.games.k.a.b.auH().getPath(), bVar);
    }

    public static void b(String str, d.b bVar) {
        d.c cVar = new d.c();
        cVar.mDownloadUrl = str;
        com.baidu.swan.games.h.a.b.auG();
        new com.baidu.swan.apps.l.a().a(cVar, com.baidu.swan.games.h.a.b.auH().getPath(), bVar);
    }

    /* renamed from: com.baidu.swan.games.l.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0524a {
        public static b b(com.baidu.swan.apps.u.c.b bVar, com.baidu.swan.apps.ao.a.b bVar2) {
            File a2 = a(bVar2);
            if (a2 == null) {
                return null;
            }
            e aIN = e.aIN();
            String e = com.baidu.swan.c.e.e(a2, false);
            File wX = wX(e);
            if (aIN == null) {
                if (!a.c(a2, wX, bVar, bVar2)) {
                    com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "小游戏bundle解压失败!").aIv();
                    com.baidu.swan.apps.al.a tO = new com.baidu.swan.apps.al.a().db(5L).dc(7L).tO("小游戏bundle解压失败! for debug");
                    com.baidu.swan.apps.al.e.aNm().j(tO);
                    if (bVar2 == null || bVar2.dRe != null) {
                        return null;
                    }
                    bVar2.dRe = tO;
                    return null;
                }
            } else if (!TextUtils.equals(aIN.aIZ().getString("installed_debug_game_bundle_md5", ""), e)) {
                if (!a.c(a2, wX, bVar, bVar2)) {
                    com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "小游戏bundle解压失败!").aIv();
                    com.baidu.swan.apps.al.a tO2 = new com.baidu.swan.apps.al.a().db(5L).dc(7L).tO("小游戏bundle解压失败! for debug");
                    com.baidu.swan.apps.al.e.aNm().j(tO2);
                    if (bVar2 == null || bVar2.dRe != null) {
                        return null;
                    }
                    bVar2.dRe = tO2;
                    return null;
                }
                aIN.aIZ().putString("installed_debug_game_bundle_md5", e);
            }
            b bVar3 = new b();
            File file = new File(wX, "game.json");
            com.baidu.swan.games.t.a.a xk = com.baidu.swan.games.t.a.a.xk(com.baidu.swan.c.d.readFileData(file));
            if (xk != null) {
                bVar3.appBundlePath = wX.getPath() + File.separator;
                bVar3.ejI = xk;
                if (!TextUtils.isEmpty(xk.elA)) {
                    bVar3.ejH = bVar3.appBundlePath + xk.elA + File.separator;
                    f.aXN().m29if(true);
                    f.aXN().xi(bVar3.ejH);
                    f.aXN().xj(xk.elA);
                } else {
                    f.aXN().m29if(false);
                }
                if (a.DEBUG) {
                    Log.d("SwanAppBundleHelper", "configFile path: " + file.getPath());
                    Log.d("SwanAppBundleHelper", "configFile exist: " + file.exists());
                    Log.d("SwanAppBundleHelper", "info.appBundlePath path: " + bVar3.appBundlePath);
                    Log.d("SwanAppBundleHelper", "info.mAppOpenDataBundle path: " + bVar3.ejH);
                }
                return bVar3;
            }
            return null;
        }

        public static File wX(String str) {
            File file = new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "debug_aigames_bundle", str);
            file.mkdirs();
            return file;
        }

        public static File a(com.baidu.swan.apps.ao.a.b bVar) {
            File amv = amv();
            File[] listFiles = amv.listFiles();
            if (listFiles == null || listFiles.length == 0) {
                com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), amv.getPath() + " 没有测试程序包!").aIv();
                com.baidu.swan.apps.al.a tO = new com.baidu.swan.apps.al.a().db(5L).dc(4L).tO("没有小游戏包! for debug, bundle files are empty");
                com.baidu.swan.apps.al.e.aNm().j(tO);
                if (bVar != null) {
                    bVar.dRe = tO;
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

        public static File amv() {
            File wW = a.wW("aigames_debug");
            if (!wW.exists()) {
                wW.mkdirs();
            }
            return wW;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean c(File file, File file2, com.baidu.swan.apps.u.c.b bVar, com.baidu.swan.apps.ao.a.b bVar2) {
        boolean unzipFile;
        int i = 0;
        if (file == null || file2 == null) {
            return false;
        }
        if (!file.exists() || file.length() == 0) {
            com.baidu.swan.apps.al.a tO = new com.baidu.swan.apps.al.a().db(5L).dc(4L).tO("小游戏bundle文件不存在或者空文件! ");
            if (bVar2 != null) {
                bVar2.dRe = tO;
                return false;
            }
            return false;
        }
        i.aEe().f(new UbcFlowEvent("package_start_unzip"));
        long currentTimeMillis = System.currentTimeMillis();
        a.b y = com.baidu.swan.apps.r.a.a.y(file);
        if (y.type != -1) {
            unzipFile = com.baidu.swan.apps.r.a.a.a(y.dgD, file2, y.type).isSuccess;
            i = y.type;
        } else {
            unzipFile = com.baidu.swan.c.d.unzipFile(file.getPath(), file2.getPath());
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        if (DEBUG) {
            com.baidu.swan.apps.r.a.a.hM((int) (currentTimeMillis2 - currentTimeMillis));
        }
        if (!unzipFile) {
            com.baidu.swan.apps.al.a tO2 = new com.baidu.swan.apps.al.a().db(5L).dc(7L).tO("小游戏bundle解压失败! PkgType=" + i);
            if (bVar2 != null) {
                bVar2.dRe = tO2;
            }
        }
        i.aEe().f(new UbcFlowEvent("package_end_unzip")).cg("app_package_version", String.valueOf(i));
        return unzipFile;
    }

    public static void a(d.c cVar, d.b bVar) {
        new com.baidu.swan.apps.l.a().a(cVar, C0524a.amv().getPath() + File.separator + System.currentTimeMillis() + ".aibundle", bVar);
    }

    /* loaded from: classes8.dex */
    public static class c {
        public static b c(com.baidu.swan.apps.u.c.b bVar, com.baidu.swan.apps.ao.a.b bVar2) {
            if (bVar == null) {
                return null;
            }
            File bL = bL(bVar.getAppId(), bVar.getVersion());
            if (!bL.exists()) {
                File a2 = a(bVar.getAppId(), true, bVar2);
                if (a2 != null) {
                    if (!a.c(a2, x(bL), bVar, bVar2)) {
                        com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "小游戏bundle解压失败!").aIv();
                        com.baidu.swan.apps.al.a tO = new com.baidu.swan.apps.al.a().db(5L).dc(7L).tO("小游戏bundle解压失败! for release");
                        com.baidu.swan.apps.al.e.aNm().j(tO);
                        if (bVar2 == null || bVar2.dRe != null) {
                            return null;
                        }
                        bVar2.dRe = tO;
                        return null;
                    }
                } else {
                    com.baidu.swan.apps.process.messaging.client.a.aFM().a(8, new SwanAppDeleteInfo(bVar.getAppId(), 1).hg(5));
                    return null;
                }
            }
            bM(bVar.getAppId(), bVar.getVersion());
            b bVar3 = new b();
            File file = new File(bL, "game.json");
            com.baidu.swan.games.t.a.a xk = com.baidu.swan.games.t.a.a.xk(com.baidu.swan.c.d.readFileData(file));
            if (xk != null) {
                bVar3.appBundlePath = bL.getPath() + File.separator;
                bVar3.ejI = xk;
                if (!TextUtils.isEmpty(xk.elA)) {
                    bVar3.ejH = bVar3.appBundlePath + File.separator + xk.elA + File.separator;
                    f.aXN().m29if(true);
                    f.aXN().xi(bVar3.ejH);
                    f.aXN().xj(xk.elA);
                } else {
                    f.aXN().m29if(false);
                }
                if (a.DEBUG) {
                    Log.d("SwanAppBundleHelper", "configFile path: " + file.getPath());
                    Log.d("SwanAppBundleHelper", "configFile exist: " + file.exists());
                    Log.d("SwanAppBundleHelper", "info.appBundlePath path: " + bVar3.appBundlePath);
                    Log.d("SwanAppBundleHelper", "info.mAppOpenDataBundle path: " + bVar3.ejH);
                }
                return bVar3;
            }
            return null;
        }

        public static File x(File file) {
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }

        public static File bL(String str, String str2) {
            return new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "aigames_folder" + File.separator + str, str2);
        }

        public static void oD(String str) {
            if (!TextUtils.isEmpty(str)) {
                File Y = Y(str, false);
                if (Y != null) {
                    com.baidu.swan.c.d.deleteFile(Y);
                }
                com.baidu.swan.c.d.deleteFile(new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "aigames_folder" + File.separator + str));
            }
        }

        private static void bM(String str, String str2) {
            File[] listFiles;
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && (listFiles = new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "aigames_folder", str).listFiles(new FileFilter() { // from class: com.baidu.swan.games.l.a.c.1
                @Override // java.io.FileFilter
                public boolean accept(File file) {
                    return file.isDirectory() && TextUtils.isDigitsOnly(file.getName());
                }
            })) != null && listFiles.length > 0) {
                for (File file : listFiles) {
                    if (bN(str2, file.getName())) {
                        if (a.DEBUG) {
                            Log.i("SwanAppBundleHelper", "删除低版本文件夹：" + file.getAbsolutePath());
                        }
                        com.baidu.swan.pms.database.a.bcx().mo31do(str, file.getName());
                        com.baidu.swan.c.d.deleteFile(file);
                    }
                }
            }
        }

        @Nullable
        public static File Y(String str, boolean z) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return a(str, z, null);
        }

        public static File a(String str, boolean z, com.baidu.swan.apps.ao.a.b bVar) {
            File awT;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            File[] listFiles = awT().listFiles();
            if (listFiles == null || listFiles.length == 0) {
                if (a.DEBUG && z) {
                    com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), awT.getPath() + " 没有小游戏包!").aIv();
                }
                com.baidu.swan.apps.al.a tO = new com.baidu.swan.apps.al.a().db(5L).dc(4L).tO("没有小游戏包! for release, bundle files are empty");
                com.baidu.swan.apps.al.e.aNm().j(tO);
                if (bVar != null) {
                    bVar.dRe = tO;
                }
                return null;
            }
            for (File file : listFiles) {
                if (TextUtils.equals(file.getName(), str + ".aigames")) {
                    return file;
                }
            }
            if (a.DEBUG && z) {
                com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), awT.getPath() + " 没有小游戏包!").aIv();
            }
            com.baidu.swan.apps.al.a tO2 = new com.baidu.swan.apps.al.a().db(5L).dc(4L).tO("没有小游戏包! for release, no such bundle file");
            com.baidu.swan.apps.al.e.aNm().j(tO2);
            if (bVar != null) {
                bVar.dRe = tO2;
            }
            return null;
        }

        public static File awT() {
            File file = new File(AppRuntime.getAppContext().getFilesDir(), "aigames_zip");
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }

        private static boolean bN(String str, String str2) {
            if (a.DEBUG) {
                Log.i("SwanAppBundleHelper", "curVersion:" + str + ",targetVersion:" + str2);
            }
            try {
                return bO(str, str2) > 0;
            } catch (IllegalArgumentException e) {
                if (a.DEBUG) {
                    Log.e("SwanAppBundleHelper", "比较版本号Exception：" + e.getMessage());
                    return false;
                }
                return false;
            }
        }

        private static long bO(String str, String str2) throws IllegalArgumentException {
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
