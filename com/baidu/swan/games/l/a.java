package com.baidu.swan.games.l;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.env.SwanAppDeleteInfo;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.performance.g;
import com.baidu.swan.apps.r.a.a;
import com.baidu.swan.apps.r.e;
import com.baidu.swan.apps.res.widget.b.d;
import com.baidu.swan.games.r.f;
import java.io.File;
import java.io.FileFilter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes11.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static ExecutorService clc = Executors.newSingleThreadExecutor();

    /* loaded from: classes11.dex */
    public static class b extends com.baidu.swan.apps.r.a {
        public String appBundlePath;
        public String del;
        public com.baidu.swan.games.t.a.a dem;
    }

    public static void c(final com.baidu.swan.apps.v.b.b bVar, final com.baidu.swan.apps.r.b bVar2) {
        clc.execute(new Runnable() { // from class: com.baidu.swan.games.l.a.1
            @Override // java.lang.Runnable
            public void run() {
                b c2;
                com.baidu.swan.apps.aq.a.b bVar3 = new com.baidu.swan.apps.aq.a.b();
                if (com.baidu.swan.apps.v.b.b.this.isDebug() && (com.baidu.swan.apps.af.a.a.ant() || a.DEBUG)) {
                    c2 = C0436a.b(com.baidu.swan.apps.v.b.b.this, bVar3);
                } else {
                    c2 = c.c(com.baidu.swan.apps.v.b.b.this, bVar3);
                }
                bVar2.a(0, c2);
            }
        });
    }

    public static File afO() {
        return new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "aigames_folder");
    }

    public static File se(String str) {
        File file = new File(AppRuntime.getAppContext().getExternalFilesDir(null), "swangame/debug");
        return TextUtils.isEmpty(str) ? file : new File(file, str);
    }

    public static void c(String str, e.b bVar) {
        e.c cVar = new e.c();
        cVar.mDownloadUrl = str;
        com.baidu.swan.games.k.a.b.adR();
        new com.baidu.swan.apps.k.a().a(cVar, com.baidu.swan.games.k.a.b.adS().getPath(), bVar);
    }

    public static void b(String str, e.b bVar) {
        e.c cVar = new e.c();
        cVar.mDownloadUrl = str;
        com.baidu.swan.games.h.a.b.adR();
        new com.baidu.swan.apps.k.a().a(cVar, com.baidu.swan.games.h.a.b.adS().getPath(), bVar);
    }

    /* renamed from: com.baidu.swan.games.l.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0436a {
        public static b b(com.baidu.swan.apps.v.b.b bVar, com.baidu.swan.apps.aq.a.b bVar2) {
            File a = a(bVar2);
            if (a == null) {
                return null;
            }
            com.baidu.swan.apps.runtime.e apM = com.baidu.swan.apps.runtime.e.apM();
            String md5 = com.baidu.swan.e.e.toMd5(a, false);
            File sf = sf(md5);
            if (apM == null) {
                if (!a.c(a, sf, bVar, bVar2)) {
                    d.a(AppRuntime.getAppContext(), "小游戏bundle解压失败!").showToast();
                    com.baidu.swan.apps.an.a pB = new com.baidu.swan.apps.an.a().bw(5L).bx(7L).pB("小游戏bundle解压失败! for debug");
                    com.baidu.swan.apps.an.e.atW().g(pB);
                    if (bVar2 == null || bVar2.cPd != null) {
                        return null;
                    }
                    bVar2.cPd = pB;
                    return null;
                }
            } else if (!TextUtils.equals(apM.apY().getString("installed_debug_game_bundle_md5", ""), md5)) {
                if (!a.c(a, sf, bVar, bVar2)) {
                    d.a(AppRuntime.getAppContext(), "小游戏bundle解压失败!").showToast();
                    com.baidu.swan.apps.an.a pB2 = new com.baidu.swan.apps.an.a().bw(5L).bx(7L).pB("小游戏bundle解压失败! for debug");
                    com.baidu.swan.apps.an.e.atW().g(pB2);
                    if (bVar2 == null || bVar2.cPd != null) {
                        return null;
                    }
                    bVar2.cPd = pB2;
                    return null;
                }
                apM.apY().putString("installed_debug_game_bundle_md5", md5);
            }
            b bVar3 = new b();
            File file = new File(sf, "game.json");
            com.baidu.swan.games.t.a.a st = com.baidu.swan.games.t.a.a.st(com.baidu.swan.e.d.readFileData(file));
            if (st != null) {
                bVar3.appBundlePath = sf.getPath() + File.separator;
                bVar3.dem = st;
                if (!TextUtils.isEmpty(st.dgh)) {
                    bVar3.del = bVar3.appBundlePath + st.dgh + File.separator;
                    f.aCo().fT(true);
                    f.aCo().sq(bVar3.del);
                    f.aCo().ss(st.dgh);
                } else {
                    f.aCo().fT(false);
                }
                if (a.DEBUG) {
                    Log.d("SwanAppBundleHelper", "configFile path: " + file.getPath());
                    Log.d("SwanAppBundleHelper", "configFile exist: " + file.exists());
                    Log.d("SwanAppBundleHelper", "info.appBundlePath path: " + bVar3.appBundlePath);
                    Log.d("SwanAppBundleHelper", "info.mAppOpenDataBundle path: " + bVar3.del);
                }
                return bVar3;
            }
            return null;
        }

        public static File sf(String str) {
            File file = new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "debug_aigames_bundle", str);
            file.mkdirs();
            return file;
        }

        public static File a(com.baidu.swan.apps.aq.a.b bVar) {
            File XA = XA();
            File[] listFiles = XA.listFiles();
            if (listFiles == null || listFiles.length == 0) {
                d.a(AppRuntime.getAppContext(), XA.getPath() + " 没有测试程序包!").showToast();
                com.baidu.swan.apps.an.a pB = new com.baidu.swan.apps.an.a().bw(5L).bx(4L).pB("没有小游戏包! for debug, bundle files are empty");
                com.baidu.swan.apps.an.e.atW().g(pB);
                if (bVar != null) {
                    bVar.cPd = pB;
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

        public static File XA() {
            File se = a.se("aigames_debug");
            if (!se.exists()) {
                se.mkdirs();
            }
            return se;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean c(File file, File file2, com.baidu.swan.apps.v.b.b bVar, com.baidu.swan.apps.aq.a.b bVar2) {
        boolean unzipFile;
        int i = 0;
        if (file == null || file2 == null) {
            return false;
        }
        if (!file.exists() || file.length() == 0) {
            com.baidu.swan.apps.an.a pB = new com.baidu.swan.apps.an.a().bw(5L).bx(4L).pB("小游戏bundle文件不存在或者空文件! ");
            if (bVar2 != null) {
                bVar2.cPd = pB;
                return false;
            }
            return false;
        }
        g.amD().f(new UbcFlowEvent("package_start_unzip"));
        long currentTimeMillis = System.currentTimeMillis();
        a.b w = com.baidu.swan.apps.r.a.a.w(file);
        if (w.type != -1) {
            unzipFile = com.baidu.swan.apps.r.a.a.a(w.clr, file2, w.type).isSuccess;
            i = w.type;
        } else {
            unzipFile = com.baidu.swan.e.d.unzipFile(file.getPath(), file2.getPath());
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        if (DEBUG) {
            com.baidu.swan.apps.r.a.a.fJ((int) (currentTimeMillis2 - currentTimeMillis));
        }
        if (!unzipFile) {
            com.baidu.swan.apps.an.a pB2 = new com.baidu.swan.apps.an.a().bw(5L).bx(7L).pB("小游戏bundle解压失败! PkgType=" + i);
            if (bVar2 != null) {
                bVar2.cPd = pB2;
            }
        }
        g.amD().f(new UbcFlowEvent("package_end_unzip")).bF("app_package_version", String.valueOf(i));
        return unzipFile;
    }

    public static void a(e.c cVar, e.b bVar) {
        new com.baidu.swan.apps.k.a().a(cVar, C0436a.XA().getPath() + File.separator + String.valueOf(System.currentTimeMillis()) + ".aibundle", bVar);
    }

    /* loaded from: classes11.dex */
    public static class c {
        public static b c(com.baidu.swan.apps.v.b.b bVar, com.baidu.swan.apps.aq.a.b bVar2) {
            if (bVar == null) {
                return null;
            }
            File bm = bm(bVar.getAppId(), bVar.getVersion());
            if (!bm.exists()) {
                File a = a(bVar.getAppId(), true, bVar2);
                if (a != null) {
                    if (!a.c(a, v(bm), bVar, bVar2)) {
                        d.a(AppRuntime.getAppContext(), "小游戏bundle解压失败!").showToast();
                        com.baidu.swan.apps.an.a pB = new com.baidu.swan.apps.an.a().bw(5L).bx(7L).pB("小游戏bundle解压失败! for release");
                        com.baidu.swan.apps.an.e.atW().g(pB);
                        if (bVar2 == null || bVar2.cPd != null) {
                            return null;
                        }
                        bVar2.cPd = pB;
                        return null;
                    }
                } else {
                    com.baidu.swan.apps.process.messaging.client.a.anW().a(8, new SwanAppDeleteInfo(bVar.getAppId(), 1));
                    return null;
                }
            }
            bn(bVar.getAppId(), bVar.getVersion());
            b bVar3 = new b();
            File file = new File(bm, "game.json");
            com.baidu.swan.games.t.a.a st = com.baidu.swan.games.t.a.a.st(com.baidu.swan.e.d.readFileData(file));
            if (st != null) {
                bVar3.appBundlePath = bm.getPath() + File.separator;
                bVar3.dem = st;
                if (!TextUtils.isEmpty(st.dgh)) {
                    bVar3.del = bVar3.appBundlePath + File.separator + st.dgh + File.separator;
                    f.aCo().fT(true);
                    f.aCo().sq(bVar3.del);
                    f.aCo().ss(st.dgh);
                } else {
                    f.aCo().fT(false);
                }
                if (a.DEBUG) {
                    Log.d("SwanAppBundleHelper", "configFile path: " + file.getPath());
                    Log.d("SwanAppBundleHelper", "configFile exist: " + file.exists());
                    Log.d("SwanAppBundleHelper", "info.appBundlePath path: " + bVar3.appBundlePath);
                    Log.d("SwanAppBundleHelper", "info.mAppOpenDataBundle path: " + bVar3.del);
                }
                return bVar3;
            }
            return null;
        }

        public static File v(File file) {
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }

        public static File bm(String str, String str2) {
            return new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "aigames_folder" + File.separator + str, str2);
        }

        public static void kM(String str) {
            if (!TextUtils.isEmpty(str)) {
                File O = O(str, false);
                if (O != null) {
                    com.baidu.swan.e.d.deleteFile(O);
                }
                com.baidu.swan.e.d.deleteFile(new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "aigames_folder" + File.separator + str));
            }
        }

        private static void bn(String str, String str2) {
            File[] listFiles;
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && (listFiles = new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "aigames_folder", str).listFiles(new FileFilter() { // from class: com.baidu.swan.games.l.a.c.1
                @Override // java.io.FileFilter
                public boolean accept(File file) {
                    return file.isDirectory() && TextUtils.isDigitsOnly(file.getName());
                }
            })) != null && listFiles.length > 0) {
                for (File file : listFiles) {
                    if (bo(str2, file.getName())) {
                        if (a.DEBUG) {
                            Log.i("SwanAppBundleHelper", "删除低版本文件夹：" + file.getAbsolutePath());
                        }
                        com.baidu.swan.pms.database.a.aHb().cL(str, file.getName());
                        com.baidu.swan.e.d.deleteFile(file);
                    }
                }
            }
        }

        @Nullable
        public static File O(String str, boolean z) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return a(str, z, null);
        }

        public static File a(String str, boolean z, com.baidu.swan.apps.aq.a.b bVar) {
            File afR;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            File[] listFiles = afR().listFiles();
            if (listFiles == null || listFiles.length == 0) {
                if (a.DEBUG && z) {
                    d.a(AppRuntime.getAppContext(), afR.getPath() + " 没有小游戏包!").showToast();
                }
                com.baidu.swan.apps.an.a pB = new com.baidu.swan.apps.an.a().bw(5L).bx(4L).pB("没有小游戏包! for release, bundle files are empty");
                com.baidu.swan.apps.an.e.atW().g(pB);
                if (bVar != null) {
                    bVar.cPd = pB;
                }
                return null;
            }
            for (File file : listFiles) {
                if (TextUtils.equals(file.getName(), str + ".aigames")) {
                    return file;
                }
            }
            if (a.DEBUG && z) {
                d.a(AppRuntime.getAppContext(), afR.getPath() + " 没有小游戏包!").showToast();
            }
            com.baidu.swan.apps.an.a pB2 = new com.baidu.swan.apps.an.a().bw(5L).bx(4L).pB("没有小游戏包! for release, no such bundle file");
            com.baidu.swan.apps.an.e.atW().g(pB2);
            if (bVar != null) {
                bVar.cPd = pB2;
            }
            return null;
        }

        public static File afR() {
            File file = new File(AppRuntime.getAppContext().getFilesDir(), "aigames_zip");
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }

        private static boolean bo(String str, String str2) {
            if (a.DEBUG) {
                Log.i("SwanAppBundleHelper", "curVersion:" + str + ",targetVersion:" + str2);
            }
            try {
                return bp(str, str2) > 0;
            } catch (IllegalArgumentException e) {
                if (a.DEBUG) {
                    Log.e("SwanAppBundleHelper", "比较版本号Exception：" + e.getMessage());
                    return false;
                }
                return false;
            }
        }

        private static long bp(String str, String str2) throws IllegalArgumentException {
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
