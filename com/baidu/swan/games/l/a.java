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
/* loaded from: classes10.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static ExecutorService cRp = Executors.newSingleThreadExecutor();

    /* loaded from: classes10.dex */
    public static class b extends com.baidu.swan.apps.r.a {
        public String appBundlePath;
        public String dQG;
        public com.baidu.swan.games.t.a.a dQH;
    }

    public static void c(final com.baidu.swan.apps.u.c.b bVar, final com.baidu.swan.apps.r.b bVar2) {
        cRp.execute(new Runnable() { // from class: com.baidu.swan.games.l.a.1
            @Override // java.lang.Runnable
            public void run() {
                b c2;
                com.baidu.swan.apps.ap.a.b bVar3 = new com.baidu.swan.apps.ap.a.b();
                if (com.baidu.swan.apps.u.c.b.this.isDebug() && (com.baidu.swan.apps.ad.a.a.aCn() || a.DEBUG)) {
                    c2 = C0523a.b(com.baidu.swan.apps.u.c.b.this, bVar3);
                } else {
                    c2 = c.c(com.baidu.swan.apps.u.c.b.this, bVar3);
                }
                bVar2.a(0, c2);
            }
        });
    }

    public static File atQ() {
        return new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "aigames_folder");
    }

    public static File wS(String str) {
        File file = new File(AppRuntime.getAppContext().getExternalFilesDir(null), "swangame/debug");
        return TextUtils.isEmpty(str) ? file : new File(file, str);
    }

    public static void c(String str, d.b bVar) {
        d.c cVar = new d.c();
        cVar.mDownloadUrl = str;
        com.baidu.swan.games.k.a.b.arF();
        new com.baidu.swan.apps.l.a().a(cVar, com.baidu.swan.games.k.a.b.arG().getPath(), bVar);
    }

    public static void b(String str, d.b bVar) {
        d.c cVar = new d.c();
        cVar.mDownloadUrl = str;
        com.baidu.swan.games.h.a.b.arF();
        new com.baidu.swan.apps.l.a().a(cVar, com.baidu.swan.games.h.a.b.arG().getPath(), bVar);
    }

    /* renamed from: com.baidu.swan.games.l.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0523a {
        public static b b(com.baidu.swan.apps.u.c.b bVar, com.baidu.swan.apps.ap.a.b bVar2) {
            File a2 = a(bVar2);
            if (a2 == null) {
                return null;
            }
            e aEU = e.aEU();
            String md5 = com.baidu.swan.c.e.toMd5(a2, false);
            File wT = wT(md5);
            if (aEU == null) {
                if (!a.c(a2, wT, bVar, bVar2)) {
                    com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "小游戏bundle解压失败!").showToast();
                    com.baidu.swan.apps.am.a tM = new com.baidu.swan.apps.am.a().bZ(5L).ca(7L).tM("小游戏bundle解压失败! for debug");
                    com.baidu.swan.apps.am.e.aJt().j(tM);
                    if (bVar2 == null || bVar2.dyr != null) {
                        return null;
                    }
                    bVar2.dyr = tM;
                    return null;
                }
            } else if (!TextUtils.equals(aEU.aFg().getString("installed_debug_game_bundle_md5", ""), md5)) {
                if (!a.c(a2, wT, bVar, bVar2)) {
                    com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "小游戏bundle解压失败!").showToast();
                    com.baidu.swan.apps.am.a tM2 = new com.baidu.swan.apps.am.a().bZ(5L).ca(7L).tM("小游戏bundle解压失败! for debug");
                    com.baidu.swan.apps.am.e.aJt().j(tM2);
                    if (bVar2 == null || bVar2.dyr != null) {
                        return null;
                    }
                    bVar2.dyr = tM2;
                    return null;
                }
                aEU.aFg().putString("installed_debug_game_bundle_md5", md5);
            }
            b bVar3 = new b();
            File file = new File(wT, "game.json");
            com.baidu.swan.games.t.a.a xg = com.baidu.swan.games.t.a.a.xg(com.baidu.swan.c.d.readFileData(file));
            if (xg != null) {
                bVar3.appBundlePath = wT.getPath() + File.separator;
                bVar3.dQH = xg;
                if (!TextUtils.isEmpty(xg.dSy)) {
                    bVar3.dQG = bVar3.appBundlePath + xg.dSy + File.separator;
                    f.aUa().ho(true);
                    f.aUa().xe(bVar3.dQG);
                    f.aUa().xf(xg.dSy);
                } else {
                    f.aUa().ho(false);
                }
                if (a.DEBUG) {
                    Log.d("SwanAppBundleHelper", "configFile path: " + file.getPath());
                    Log.d("SwanAppBundleHelper", "configFile exist: " + file.exists());
                    Log.d("SwanAppBundleHelper", "info.appBundlePath path: " + bVar3.appBundlePath);
                    Log.d("SwanAppBundleHelper", "info.mAppOpenDataBundle path: " + bVar3.dQG);
                }
                return bVar3;
            }
            return null;
        }

        public static File wT(String str) {
            File file = new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "debug_aigames_bundle", str);
            file.mkdirs();
            return file;
        }

        public static File a(com.baidu.swan.apps.ap.a.b bVar) {
            File ajB = ajB();
            File[] listFiles = ajB.listFiles();
            if (listFiles == null || listFiles.length == 0) {
                com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), ajB.getPath() + " 没有测试程序包!").showToast();
                com.baidu.swan.apps.am.a tM = new com.baidu.swan.apps.am.a().bZ(5L).ca(4L).tM("没有小游戏包! for debug, bundle files are empty");
                com.baidu.swan.apps.am.e.aJt().j(tM);
                if (bVar != null) {
                    bVar.dyr = tM;
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

        public static File ajB() {
            File wS = a.wS("aigames_debug");
            if (!wS.exists()) {
                wS.mkdirs();
            }
            return wS;
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
            com.baidu.swan.apps.am.a tM = new com.baidu.swan.apps.am.a().bZ(5L).ca(4L).tM("小游戏bundle文件不存在或者空文件! ");
            if (bVar2 != null) {
                bVar2.dyr = tM;
                return false;
            }
            return false;
        }
        i.aBg().f(new UbcFlowEvent("package_start_unzip"));
        long currentTimeMillis = System.currentTimeMillis();
        a.b B = com.baidu.swan.apps.r.a.a.B(file);
        if (B.type != -1) {
            unzipFile = com.baidu.swan.apps.r.a.a.a(B.cRE, file2, B.type).isSuccess;
            i = B.type;
        } else {
            unzipFile = com.baidu.swan.c.d.unzipFile(file.getPath(), file2.getPath());
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        if (DEBUG) {
            com.baidu.swan.apps.r.a.a.iP((int) (currentTimeMillis2 - currentTimeMillis));
        }
        if (!unzipFile) {
            com.baidu.swan.apps.am.a tM2 = new com.baidu.swan.apps.am.a().bZ(5L).ca(7L).tM("小游戏bundle解压失败! PkgType=" + i);
            if (bVar2 != null) {
                bVar2.dyr = tM2;
            }
        }
        i.aBg().f(new UbcFlowEvent("package_end_unzip")).ci("app_package_version", String.valueOf(i));
        return unzipFile;
    }

    public static void a(d.c cVar, d.b bVar) {
        new com.baidu.swan.apps.l.a().a(cVar, C0523a.ajB().getPath() + File.separator + System.currentTimeMillis() + ".aibundle", bVar);
    }

    /* loaded from: classes10.dex */
    public static class c {
        public static b c(com.baidu.swan.apps.u.c.b bVar, com.baidu.swan.apps.ap.a.b bVar2) {
            if (bVar == null) {
                return null;
            }
            File bN = bN(bVar.getAppId(), bVar.getVersion());
            if (!bN.exists()) {
                File a2 = a(bVar.getAppId(), true, bVar2);
                if (a2 != null) {
                    if (!a.c(a2, A(bN), bVar, bVar2)) {
                        com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "小游戏bundle解压失败!").showToast();
                        com.baidu.swan.apps.am.a tM = new com.baidu.swan.apps.am.a().bZ(5L).ca(7L).tM("小游戏bundle解压失败! for release");
                        com.baidu.swan.apps.am.e.aJt().j(tM);
                        if (bVar2 == null || bVar2.dyr != null) {
                            return null;
                        }
                        bVar2.dyr = tM;
                        return null;
                    }
                } else {
                    com.baidu.swan.apps.process.messaging.client.a.aCO().a(8, new SwanAppDeleteInfo(bVar.getAppId(), 1).ij(5));
                    return null;
                }
            }
            bO(bVar.getAppId(), bVar.getVersion());
            b bVar3 = new b();
            File file = new File(bN, "game.json");
            com.baidu.swan.games.t.a.a xg = com.baidu.swan.games.t.a.a.xg(com.baidu.swan.c.d.readFileData(file));
            if (xg != null) {
                bVar3.appBundlePath = bN.getPath() + File.separator;
                bVar3.dQH = xg;
                if (!TextUtils.isEmpty(xg.dSy)) {
                    bVar3.dQG = bVar3.appBundlePath + File.separator + xg.dSy + File.separator;
                    f.aUa().ho(true);
                    f.aUa().xe(bVar3.dQG);
                    f.aUa().xf(xg.dSy);
                } else {
                    f.aUa().ho(false);
                }
                if (a.DEBUG) {
                    Log.d("SwanAppBundleHelper", "configFile path: " + file.getPath());
                    Log.d("SwanAppBundleHelper", "configFile exist: " + file.exists());
                    Log.d("SwanAppBundleHelper", "info.appBundlePath path: " + bVar3.appBundlePath);
                    Log.d("SwanAppBundleHelper", "info.mAppOpenDataBundle path: " + bVar3.dQG);
                }
                return bVar3;
            }
            return null;
        }

        public static File A(File file) {
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }

        public static File bN(String str, String str2) {
            return new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "aigames_folder" + File.separator + str, str2);
        }

        public static void oH(String str) {
            if (!TextUtils.isEmpty(str)) {
                File Y = Y(str, false);
                if (Y != null) {
                    com.baidu.swan.c.d.deleteFile(Y);
                }
                com.baidu.swan.c.d.deleteFile(new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "aigames_folder" + File.separator + str));
            }
        }

        private static void bO(String str, String str2) {
            File[] listFiles;
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && (listFiles = new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "aigames_folder", str).listFiles(new FileFilter() { // from class: com.baidu.swan.games.l.a.c.1
                @Override // java.io.FileFilter
                public boolean accept(File file) {
                    return file.isDirectory() && TextUtils.isDigitsOnly(file.getName());
                }
            })) != null && listFiles.length > 0) {
                for (File file : listFiles) {
                    if (bP(str2, file.getName())) {
                        if (a.DEBUG) {
                            Log.i("SwanAppBundleHelper", "删除低版本文件夹：" + file.getAbsolutePath());
                        }
                        com.baidu.swan.pms.database.a.aYH().dq(str, file.getName());
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

        public static File a(String str, boolean z, com.baidu.swan.apps.ap.a.b bVar) {
            File atU;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            File[] listFiles = atU().listFiles();
            if (listFiles == null || listFiles.length == 0) {
                if (a.DEBUG && z) {
                    com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), atU.getPath() + " 没有小游戏包!").showToast();
                }
                com.baidu.swan.apps.am.a tM = new com.baidu.swan.apps.am.a().bZ(5L).ca(4L).tM("没有小游戏包! for release, bundle files are empty");
                com.baidu.swan.apps.am.e.aJt().j(tM);
                if (bVar != null) {
                    bVar.dyr = tM;
                }
                return null;
            }
            for (File file : listFiles) {
                if (TextUtils.equals(file.getName(), str + ".aigames")) {
                    return file;
                }
            }
            if (a.DEBUG && z) {
                com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), atU.getPath() + " 没有小游戏包!").showToast();
            }
            com.baidu.swan.apps.am.a tM2 = new com.baidu.swan.apps.am.a().bZ(5L).ca(4L).tM("没有小游戏包! for release, no such bundle file");
            com.baidu.swan.apps.am.e.aJt().j(tM2);
            if (bVar != null) {
                bVar.dyr = tM2;
            }
            return null;
        }

        public static File atU() {
            File file = new File(AppRuntime.getAppContext().getFilesDir(), "aigames_zip");
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }

        private static boolean bP(String str, String str2) {
            if (a.DEBUG) {
                Log.i("SwanAppBundleHelper", "curVersion:" + str + ",targetVersion:" + str2);
            }
            try {
                return bQ(str, str2) > 0;
            } catch (IllegalArgumentException e) {
                if (a.DEBUG) {
                    Log.e("SwanAppBundleHelper", "比较版本号Exception：" + e.getMessage());
                    return false;
                }
                return false;
            }
        }

        private static long bQ(String str, String str2) throws IllegalArgumentException {
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
