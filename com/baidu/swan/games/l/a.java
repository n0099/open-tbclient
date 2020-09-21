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
/* loaded from: classes3.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static ExecutorService cwO = Executors.newSingleThreadExecutor();

    /* loaded from: classes3.dex */
    public static class b extends com.baidu.swan.apps.r.a {
        public String appBundlePath;
        public String dwi;
        public com.baidu.swan.games.t.a.a dwj;
    }

    public static void c(final com.baidu.swan.apps.u.c.b bVar, final com.baidu.swan.apps.r.b bVar2) {
        cwO.execute(new Runnable() { // from class: com.baidu.swan.games.l.a.1
            @Override // java.lang.Runnable
            public void run() {
                b c2;
                com.baidu.swan.apps.ap.a.b bVar3 = new com.baidu.swan.apps.ap.a.b();
                if (com.baidu.swan.apps.u.c.b.this.isDebug() && (com.baidu.swan.apps.ad.a.a.axI() || a.DEBUG)) {
                    c2 = C0492a.b(com.baidu.swan.apps.u.c.b.this, bVar3);
                } else {
                    c2 = c.c(com.baidu.swan.apps.u.c.b.this, bVar3);
                }
                bVar2.a(0, c2);
            }
        });
    }

    public static File apk() {
        return new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "aigames_folder");
    }

    public static File vN(String str) {
        File file = new File(AppRuntime.getAppContext().getExternalFilesDir(null), "swangame/debug");
        return TextUtils.isEmpty(str) ? file : new File(file, str);
    }

    public static void c(String str, d.b bVar) {
        d.c cVar = new d.c();
        cVar.mDownloadUrl = str;
        com.baidu.swan.games.k.a.b.amZ();
        new com.baidu.swan.apps.l.a().a(cVar, com.baidu.swan.games.k.a.b.ana().getPath(), bVar);
    }

    public static void b(String str, d.b bVar) {
        d.c cVar = new d.c();
        cVar.mDownloadUrl = str;
        com.baidu.swan.games.h.a.b.amZ();
        new com.baidu.swan.apps.l.a().a(cVar, com.baidu.swan.games.h.a.b.ana().getPath(), bVar);
    }

    /* renamed from: com.baidu.swan.games.l.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0492a {
        public static b b(com.baidu.swan.apps.u.c.b bVar, com.baidu.swan.apps.ap.a.b bVar2) {
            File a = a(bVar2);
            if (a == null) {
                return null;
            }
            e aAr = e.aAr();
            String md5 = com.baidu.swan.c.e.toMd5(a, false);
            File vO = vO(md5);
            if (aAr == null) {
                if (!a.c(a, vO, bVar, bVar2)) {
                    com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "小游戏bundle解压失败!").showToast();
                    com.baidu.swan.apps.am.a sH = new com.baidu.swan.apps.am.a().bP(5L).bQ(7L).sH("小游戏bundle解压失败! for debug");
                    com.baidu.swan.apps.am.e.aEQ().j(sH);
                    if (bVar2 == null || bVar2.ddJ != null) {
                        return null;
                    }
                    bVar2.ddJ = sH;
                    return null;
                }
            } else if (!TextUtils.equals(aAr.aAD().getString("installed_debug_game_bundle_md5", ""), md5)) {
                if (!a.c(a, vO, bVar, bVar2)) {
                    com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "小游戏bundle解压失败!").showToast();
                    com.baidu.swan.apps.am.a sH2 = new com.baidu.swan.apps.am.a().bP(5L).bQ(7L).sH("小游戏bundle解压失败! for debug");
                    com.baidu.swan.apps.am.e.aEQ().j(sH2);
                    if (bVar2 == null || bVar2.ddJ != null) {
                        return null;
                    }
                    bVar2.ddJ = sH2;
                    return null;
                }
                aAr.aAD().putString("installed_debug_game_bundle_md5", md5);
            }
            b bVar3 = new b();
            File file = new File(vO, "game.json");
            com.baidu.swan.games.t.a.a wb = com.baidu.swan.games.t.a.a.wb(com.baidu.swan.c.d.readFileData(file));
            if (wb != null) {
                bVar3.appBundlePath = vO.getPath() + File.separator;
                bVar3.dwj = wb;
                if (!TextUtils.isEmpty(wb.dya)) {
                    bVar3.dwi = bVar3.appBundlePath + wb.dya + File.separator;
                    f.aPx().gF(true);
                    f.aPx().vZ(bVar3.dwi);
                    f.aPx().wa(wb.dya);
                } else {
                    f.aPx().gF(false);
                }
                if (a.DEBUG) {
                    Log.d("SwanAppBundleHelper", "configFile path: " + file.getPath());
                    Log.d("SwanAppBundleHelper", "configFile exist: " + file.exists());
                    Log.d("SwanAppBundleHelper", "info.appBundlePath path: " + bVar3.appBundlePath);
                    Log.d("SwanAppBundleHelper", "info.mAppOpenDataBundle path: " + bVar3.dwi);
                }
                return bVar3;
            }
            return null;
        }

        public static File vO(String str) {
            File file = new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "debug_aigames_bundle", str);
            file.mkdirs();
            return file;
        }

        public static File a(com.baidu.swan.apps.ap.a.b bVar) {
            File aeW = aeW();
            File[] listFiles = aeW.listFiles();
            if (listFiles == null || listFiles.length == 0) {
                com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), aeW.getPath() + " 没有测试程序包!").showToast();
                com.baidu.swan.apps.am.a sH = new com.baidu.swan.apps.am.a().bP(5L).bQ(4L).sH("没有小游戏包! for debug, bundle files are empty");
                com.baidu.swan.apps.am.e.aEQ().j(sH);
                if (bVar != null) {
                    bVar.ddJ = sH;
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

        public static File aeW() {
            File vN = a.vN("aigames_debug");
            if (!vN.exists()) {
                vN.mkdirs();
            }
            return vN;
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
            com.baidu.swan.apps.am.a sH = new com.baidu.swan.apps.am.a().bP(5L).bQ(4L).sH("小游戏bundle文件不存在或者空文件! ");
            if (bVar2 != null) {
                bVar2.ddJ = sH;
                return false;
            }
            return false;
        }
        i.awB().f(new UbcFlowEvent("package_start_unzip"));
        long currentTimeMillis = System.currentTimeMillis();
        a.b y = com.baidu.swan.apps.r.a.a.y(file);
        if (y.type != -1) {
            unzipFile = com.baidu.swan.apps.r.a.a.a(y.cxd, file2, y.type).isSuccess;
            i = y.type;
        } else {
            unzipFile = com.baidu.swan.c.d.unzipFile(file.getPath(), file2.getPath());
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        if (DEBUG) {
            com.baidu.swan.apps.r.a.a.ih((int) (currentTimeMillis2 - currentTimeMillis));
        }
        if (!unzipFile) {
            com.baidu.swan.apps.am.a sH2 = new com.baidu.swan.apps.am.a().bP(5L).bQ(7L).sH("小游戏bundle解压失败! PkgType=" + i);
            if (bVar2 != null) {
                bVar2.ddJ = sH2;
            }
        }
        i.awB().f(new UbcFlowEvent("package_end_unzip")).bW("app_package_version", String.valueOf(i));
        return unzipFile;
    }

    public static void a(d.c cVar, d.b bVar) {
        new com.baidu.swan.apps.l.a().a(cVar, C0492a.aeW().getPath() + File.separator + System.currentTimeMillis() + ".aibundle", bVar);
    }

    /* loaded from: classes3.dex */
    public static class c {
        public static b c(com.baidu.swan.apps.u.c.b bVar, com.baidu.swan.apps.ap.a.b bVar2) {
            if (bVar == null) {
                return null;
            }
            File bB = bB(bVar.getAppId(), bVar.getVersion());
            if (!bB.exists()) {
                File a = a(bVar.getAppId(), true, bVar2);
                if (a != null) {
                    if (!a.c(a, x(bB), bVar, bVar2)) {
                        com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "小游戏bundle解压失败!").showToast();
                        com.baidu.swan.apps.am.a sH = new com.baidu.swan.apps.am.a().bP(5L).bQ(7L).sH("小游戏bundle解压失败! for release");
                        com.baidu.swan.apps.am.e.aEQ().j(sH);
                        if (bVar2 == null || bVar2.ddJ != null) {
                            return null;
                        }
                        bVar2.ddJ = sH;
                        return null;
                    }
                } else {
                    com.baidu.swan.apps.process.messaging.client.a.ayl().a(8, new SwanAppDeleteInfo(bVar.getAppId(), 1).hB(5));
                    return null;
                }
            }
            bC(bVar.getAppId(), bVar.getVersion());
            b bVar3 = new b();
            File file = new File(bB, "game.json");
            com.baidu.swan.games.t.a.a wb = com.baidu.swan.games.t.a.a.wb(com.baidu.swan.c.d.readFileData(file));
            if (wb != null) {
                bVar3.appBundlePath = bB.getPath() + File.separator;
                bVar3.dwj = wb;
                if (!TextUtils.isEmpty(wb.dya)) {
                    bVar3.dwi = bVar3.appBundlePath + File.separator + wb.dya + File.separator;
                    f.aPx().gF(true);
                    f.aPx().vZ(bVar3.dwi);
                    f.aPx().wa(wb.dya);
                } else {
                    f.aPx().gF(false);
                }
                if (a.DEBUG) {
                    Log.d("SwanAppBundleHelper", "configFile path: " + file.getPath());
                    Log.d("SwanAppBundleHelper", "configFile exist: " + file.exists());
                    Log.d("SwanAppBundleHelper", "info.appBundlePath path: " + bVar3.appBundlePath);
                    Log.d("SwanAppBundleHelper", "info.mAppOpenDataBundle path: " + bVar3.dwi);
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

        public static File bB(String str, String str2) {
            return new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "aigames_folder" + File.separator + str, str2);
        }

        public static void nA(String str) {
            if (!TextUtils.isEmpty(str)) {
                File S = S(str, false);
                if (S != null) {
                    com.baidu.swan.c.d.deleteFile(S);
                }
                com.baidu.swan.c.d.deleteFile(new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "aigames_folder" + File.separator + str));
            }
        }

        private static void bC(String str, String str2) {
            File[] listFiles;
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && (listFiles = new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "aigames_folder", str).listFiles(new FileFilter() { // from class: com.baidu.swan.games.l.a.c.1
                @Override // java.io.FileFilter
                public boolean accept(File file) {
                    return file.isDirectory() && TextUtils.isDigitsOnly(file.getName());
                }
            })) != null && listFiles.length > 0) {
                for (File file : listFiles) {
                    if (bD(str2, file.getName())) {
                        if (a.DEBUG) {
                            Log.i("SwanAppBundleHelper", "删除低版本文件夹：" + file.getAbsolutePath());
                        }
                        com.baidu.swan.pms.database.a.aUf().de(str, file.getName());
                        com.baidu.swan.c.d.deleteFile(file);
                    }
                }
            }
        }

        @Nullable
        public static File S(String str, boolean z) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return a(str, z, null);
        }

        public static File a(String str, boolean z, com.baidu.swan.apps.ap.a.b bVar) {
            File apo;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            File[] listFiles = apo().listFiles();
            if (listFiles == null || listFiles.length == 0) {
                if (a.DEBUG && z) {
                    com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), apo.getPath() + " 没有小游戏包!").showToast();
                }
                com.baidu.swan.apps.am.a sH = new com.baidu.swan.apps.am.a().bP(5L).bQ(4L).sH("没有小游戏包! for release, bundle files are empty");
                com.baidu.swan.apps.am.e.aEQ().j(sH);
                if (bVar != null) {
                    bVar.ddJ = sH;
                }
                return null;
            }
            for (File file : listFiles) {
                if (TextUtils.equals(file.getName(), str + ".aigames")) {
                    return file;
                }
            }
            if (a.DEBUG && z) {
                com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), apo.getPath() + " 没有小游戏包!").showToast();
            }
            com.baidu.swan.apps.am.a sH2 = new com.baidu.swan.apps.am.a().bP(5L).bQ(4L).sH("没有小游戏包! for release, no such bundle file");
            com.baidu.swan.apps.am.e.aEQ().j(sH2);
            if (bVar != null) {
                bVar.ddJ = sH2;
            }
            return null;
        }

        public static File apo() {
            File file = new File(AppRuntime.getAppContext().getFilesDir(), "aigames_zip");
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }

        private static boolean bD(String str, String str2) {
            if (a.DEBUG) {
                Log.i("SwanAppBundleHelper", "curVersion:" + str + ",targetVersion:" + str2);
            }
            try {
                return bE(str, str2) > 0;
            } catch (IllegalArgumentException e) {
                if (a.DEBUG) {
                    Log.e("SwanAppBundleHelper", "比较版本号Exception：" + e.getMessage());
                    return false;
                }
                return false;
            }
        }

        private static long bE(String str, String str2) throws IllegalArgumentException {
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
