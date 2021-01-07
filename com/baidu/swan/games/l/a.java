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
/* loaded from: classes9.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static ExecutorService dho = Executors.newSingleThreadExecutor();

    /* loaded from: classes9.dex */
    public static class b extends com.baidu.swan.apps.r.a {
        public String appBundlePath;
        public String ekL;
        public com.baidu.swan.games.t.a.a ekM;
    }

    public static void c(final com.baidu.swan.apps.u.c.b bVar, final com.baidu.swan.apps.r.b bVar2) {
        dho.execute(new Runnable() { // from class: com.baidu.swan.games.l.a.1
            @Override // java.lang.Runnable
            public void run() {
                b c2;
                com.baidu.swan.apps.ao.a.b bVar3 = new com.baidu.swan.apps.ao.a.b();
                if (com.baidu.swan.apps.u.c.b.this.isDebug() && (com.baidu.swan.apps.ad.a.a.aIH() || a.DEBUG)) {
                    c2 = C0538a.b(com.baidu.swan.apps.u.c.b.this, bVar3);
                } else {
                    c2 = c.c(com.baidu.swan.apps.u.c.b.this, bVar3);
                }
                bVar2.a(0, c2);
            }
        });
    }

    public static File aAi() {
        return new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "aigames_folder");
    }

    public static File xH(String str) {
        File file = new File(AppRuntime.getAppContext().getExternalFilesDir(null), "swangame/debug");
        return TextUtils.isEmpty(str) ? file : new File(file, str);
    }

    public static void c(String str, d.b bVar) {
        d.c cVar = new d.c();
        cVar.mDownloadUrl = str;
        com.baidu.swan.games.k.a.b.axZ();
        new com.baidu.swan.apps.l.a().a(cVar, com.baidu.swan.games.k.a.b.aya().getPath(), bVar);
    }

    public static void b(String str, d.b bVar) {
        d.c cVar = new d.c();
        cVar.mDownloadUrl = str;
        com.baidu.swan.games.h.a.b.axZ();
        new com.baidu.swan.apps.l.a().a(cVar, com.baidu.swan.games.h.a.b.aya().getPath(), bVar);
    }

    /* renamed from: com.baidu.swan.games.l.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C0538a {
        public static b b(com.baidu.swan.apps.u.c.b bVar, com.baidu.swan.apps.ao.a.b bVar2) {
            File a2 = a(bVar2);
            if (a2 == null) {
                return null;
            }
            e aMl = e.aMl();
            String e = com.baidu.swan.c.e.e(a2, false);
            File xI = xI(e);
            if (aMl == null) {
                if (!a.c(a2, xI, bVar, bVar2)) {
                    com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "小游戏bundle解压失败!").aLT();
                    com.baidu.swan.apps.al.a uz = new com.baidu.swan.apps.al.a().cV(5L).cW(7L).uz("小游戏bundle解压失败! for debug");
                    com.baidu.swan.apps.al.e.aQK().j(uz);
                    if (bVar2 == null || bVar2.dSj != null) {
                        return null;
                    }
                    bVar2.dSj = uz;
                    return null;
                }
            } else if (!TextUtils.equals(aMl.aMx().getString("installed_debug_game_bundle_md5", ""), e)) {
                if (!a.c(a2, xI, bVar, bVar2)) {
                    com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "小游戏bundle解压失败!").aLT();
                    com.baidu.swan.apps.al.a uz2 = new com.baidu.swan.apps.al.a().cV(5L).cW(7L).uz("小游戏bundle解压失败! for debug");
                    com.baidu.swan.apps.al.e.aQK().j(uz2);
                    if (bVar2 == null || bVar2.dSj != null) {
                        return null;
                    }
                    bVar2.dSj = uz2;
                    return null;
                }
                aMl.aMx().putString("installed_debug_game_bundle_md5", e);
            }
            b bVar3 = new b();
            File file = new File(xI, "game.json");
            com.baidu.swan.games.t.a.a xV = com.baidu.swan.games.t.a.a.xV(com.baidu.swan.c.d.readFileData(file));
            if (xV != null) {
                bVar3.appBundlePath = xI.getPath() + File.separator;
                bVar3.ekM = xV;
                if (!TextUtils.isEmpty(xV.emE)) {
                    bVar3.ekL = bVar3.appBundlePath + xV.emE + File.separator;
                    f.bbs().ih(true);
                    f.bbs().xT(bVar3.ekL);
                    f.bbs().xU(xV.emE);
                } else {
                    f.bbs().ih(false);
                }
                if (a.DEBUG) {
                    Log.d("SwanAppBundleHelper", "configFile path: " + file.getPath());
                    Log.d("SwanAppBundleHelper", "configFile exist: " + file.exists());
                    Log.d("SwanAppBundleHelper", "info.appBundlePath path: " + bVar3.appBundlePath);
                    Log.d("SwanAppBundleHelper", "info.mAppOpenDataBundle path: " + bVar3.ekL);
                }
                return bVar3;
            }
            return null;
        }

        public static File xI(String str) {
            File file = new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "debug_aigames_bundle", str);
            file.mkdirs();
            return file;
        }

        public static File a(com.baidu.swan.apps.ao.a.b bVar) {
            File apP = apP();
            File[] listFiles = apP.listFiles();
            if (listFiles == null || listFiles.length == 0) {
                com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), apP.getPath() + " 没有测试程序包!").aLT();
                com.baidu.swan.apps.al.a uz = new com.baidu.swan.apps.al.a().cV(5L).cW(4L).uz("没有小游戏包! for debug, bundle files are empty");
                com.baidu.swan.apps.al.e.aQK().j(uz);
                if (bVar != null) {
                    bVar.dSj = uz;
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

        public static File apP() {
            File xH = a.xH("aigames_debug");
            if (!xH.exists()) {
                xH.mkdirs();
            }
            return xH;
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
            com.baidu.swan.apps.al.a uz = new com.baidu.swan.apps.al.a().cV(5L).cW(4L).uz("小游戏bundle文件不存在或者空文件! ");
            if (bVar2 != null) {
                bVar2.dSj = uz;
                return false;
            }
            return false;
        }
        i.aHA().f(new UbcFlowEvent("package_start_unzip"));
        long currentTimeMillis = System.currentTimeMillis();
        a.b D = com.baidu.swan.apps.r.a.a.D(file);
        if (D.type != -1) {
            unzipFile = com.baidu.swan.apps.r.a.a.a(D.dhD, file2, D.type).isSuccess;
            i = D.type;
        } else {
            unzipFile = com.baidu.swan.c.d.unzipFile(file.getPath(), file2.getPath());
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        if (DEBUG) {
            com.baidu.swan.apps.r.a.a.jo((int) (currentTimeMillis2 - currentTimeMillis));
        }
        if (!unzipFile) {
            com.baidu.swan.apps.al.a uz2 = new com.baidu.swan.apps.al.a().cV(5L).cW(7L).uz("小游戏bundle解压失败! PkgType=" + i);
            if (bVar2 != null) {
                bVar2.dSj = uz2;
            }
        }
        i.aHA().f(new UbcFlowEvent("package_end_unzip")).cn("app_package_version", String.valueOf(i));
        return unzipFile;
    }

    public static void a(d.c cVar, d.b bVar) {
        new com.baidu.swan.apps.l.a().a(cVar, C0538a.apP().getPath() + File.separator + System.currentTimeMillis() + ".aibundle", bVar);
    }

    /* loaded from: classes9.dex */
    public static class c {
        public static b c(com.baidu.swan.apps.u.c.b bVar, com.baidu.swan.apps.ao.a.b bVar2) {
            if (bVar == null) {
                return null;
            }
            File bS = bS(bVar.getAppId(), bVar.getVersion());
            if (!bS.exists()) {
                File a2 = a(bVar.getAppId(), true, bVar2);
                if (a2 != null) {
                    if (!a.c(a2, C(bS), bVar, bVar2)) {
                        com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "小游戏bundle解压失败!").aLT();
                        com.baidu.swan.apps.al.a uz = new com.baidu.swan.apps.al.a().cV(5L).cW(7L).uz("小游戏bundle解压失败! for release");
                        com.baidu.swan.apps.al.e.aQK().j(uz);
                        if (bVar2 == null || bVar2.dSj != null) {
                            return null;
                        }
                        bVar2.dSj = uz;
                        return null;
                    }
                } else {
                    com.baidu.swan.apps.process.messaging.client.a.aJi().a(8, new SwanAppDeleteInfo(bVar.getAppId(), 1).iI(5));
                    return null;
                }
            }
            bT(bVar.getAppId(), bVar.getVersion());
            b bVar3 = new b();
            File file = new File(bS, "game.json");
            com.baidu.swan.games.t.a.a xV = com.baidu.swan.games.t.a.a.xV(com.baidu.swan.c.d.readFileData(file));
            if (xV != null) {
                bVar3.appBundlePath = bS.getPath() + File.separator;
                bVar3.ekM = xV;
                if (!TextUtils.isEmpty(xV.emE)) {
                    bVar3.ekL = bVar3.appBundlePath + File.separator + xV.emE + File.separator;
                    f.bbs().ih(true);
                    f.bbs().xT(bVar3.ekL);
                    f.bbs().xU(xV.emE);
                } else {
                    f.bbs().ih(false);
                }
                if (a.DEBUG) {
                    Log.d("SwanAppBundleHelper", "configFile path: " + file.getPath());
                    Log.d("SwanAppBundleHelper", "configFile exist: " + file.exists());
                    Log.d("SwanAppBundleHelper", "info.appBundlePath path: " + bVar3.appBundlePath);
                    Log.d("SwanAppBundleHelper", "info.mAppOpenDataBundle path: " + bVar3.ekL);
                }
                return bVar3;
            }
            return null;
        }

        public static File C(File file) {
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }

        public static File bS(String str, String str2) {
            return new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "aigames_folder" + File.separator + str, str2);
        }

        public static void pp(String str) {
            if (!TextUtils.isEmpty(str)) {
                File Z = Z(str, false);
                if (Z != null) {
                    com.baidu.swan.c.d.deleteFile(Z);
                }
                com.baidu.swan.c.d.deleteFile(new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "aigames_folder" + File.separator + str));
            }
        }

        private static void bT(String str, String str2) {
            File[] listFiles;
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && (listFiles = new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "aigames_folder", str).listFiles(new FileFilter() { // from class: com.baidu.swan.games.l.a.c.1
                @Override // java.io.FileFilter
                public boolean accept(File file) {
                    return file.isDirectory() && TextUtils.isDigitsOnly(file.getName());
                }
            })) != null && listFiles.length > 0) {
                for (File file : listFiles) {
                    if (bU(str2, file.getName())) {
                        if (a.DEBUG) {
                            Log.i("SwanAppBundleHelper", "删除低版本文件夹：" + file.getAbsolutePath());
                        }
                        com.baidu.swan.pms.database.a.bgc().dv(str, file.getName());
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

        public static File a(String str, boolean z, com.baidu.swan.apps.ao.a.b bVar) {
            File aAm;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            File[] listFiles = aAm().listFiles();
            if (listFiles == null || listFiles.length == 0) {
                if (a.DEBUG && z) {
                    com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), aAm.getPath() + " 没有小游戏包!").aLT();
                }
                com.baidu.swan.apps.al.a uz = new com.baidu.swan.apps.al.a().cV(5L).cW(4L).uz("没有小游戏包! for release, bundle files are empty");
                com.baidu.swan.apps.al.e.aQK().j(uz);
                if (bVar != null) {
                    bVar.dSj = uz;
                }
                return null;
            }
            for (File file : listFiles) {
                if (TextUtils.equals(file.getName(), str + ".aigames")) {
                    return file;
                }
            }
            if (a.DEBUG && z) {
                com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), aAm.getPath() + " 没有小游戏包!").aLT();
            }
            com.baidu.swan.apps.al.a uz2 = new com.baidu.swan.apps.al.a().cV(5L).cW(4L).uz("没有小游戏包! for release, no such bundle file");
            com.baidu.swan.apps.al.e.aQK().j(uz2);
            if (bVar != null) {
                bVar.dSj = uz2;
            }
            return null;
        }

        public static File aAm() {
            File file = new File(AppRuntime.getAppContext().getFilesDir(), "aigames_zip");
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }

        private static boolean bU(String str, String str2) {
            if (a.DEBUG) {
                Log.i("SwanAppBundleHelper", "curVersion:" + str + ",targetVersion:" + str2);
            }
            try {
                return bV(str, str2) > 0;
            } catch (IllegalArgumentException e) {
                if (a.DEBUG) {
                    Log.e("SwanAppBundleHelper", "比较版本号Exception：" + e.getMessage());
                    return false;
                }
                return false;
            }
        }

        private static long bV(String str, String str2) throws IllegalArgumentException {
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
