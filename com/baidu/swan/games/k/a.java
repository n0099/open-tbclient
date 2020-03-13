package com.baidu.swan.games.k;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.env.SwanAppDeleteInfo;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.t.a.a;
import com.baidu.swan.apps.t.e;
import com.baidu.swan.d.d;
import com.baidu.swan.games.q.f;
import java.io.File;
import java.io.FileFilter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes11.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static ExecutorService bxw = Executors.newSingleThreadExecutor();

    /* loaded from: classes11.dex */
    public static class b extends com.baidu.swan.apps.t.a {
        public String appBundlePath;
        public String cps;
        public com.baidu.swan.games.s.a.a cpt;
    }

    public static void c(final com.baidu.swan.apps.x.b.b bVar, final com.baidu.swan.apps.t.b bVar2) {
        bxw.execute(new Runnable() { // from class: com.baidu.swan.games.k.a.1
            @Override // java.lang.Runnable
            public void run() {
                b c2;
                com.baidu.swan.apps.as.a.b bVar3 = new com.baidu.swan.apps.as.a.b();
                if (com.baidu.swan.apps.x.b.b.this.isDebug() && (com.baidu.swan.apps.ah.a.a.aaz() || a.DEBUG)) {
                    c2 = C0338a.b(com.baidu.swan.apps.x.b.b.this, bVar3);
                } else {
                    c2 = c.c(com.baidu.swan.apps.x.b.b.this, bVar3);
                }
                bVar2.a(0, c2);
            }
        });
    }

    public static File TN() {
        return new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "aigames_folder");
    }

    public static File ph(String str) {
        File file = new File(AppRuntime.getAppContext().getExternalFilesDir(null), "swangame/debug");
        return TextUtils.isEmpty(str) ? file : new File(file, str);
    }

    public static void c(String str, e.b bVar) {
        e.c cVar = new e.c();
        cVar.mDownloadUrl = str;
        com.baidu.swan.games.j.a.b.RU();
        new com.baidu.swan.apps.l.a().a(cVar, com.baidu.swan.games.j.a.b.RV().getPath(), bVar);
    }

    public static void b(String str, e.b bVar) {
        e.c cVar = new e.c();
        cVar.mDownloadUrl = str;
        com.baidu.swan.games.g.a.b.RU();
        new com.baidu.swan.apps.l.a().a(cVar, com.baidu.swan.games.g.a.b.RV().getPath(), bVar);
    }

    /* renamed from: com.baidu.swan.games.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0338a {
        public static b b(com.baidu.swan.apps.x.b.b bVar, com.baidu.swan.apps.as.a.b bVar2) {
            File a = a(bVar2);
            if (a == null) {
                return null;
            }
            com.baidu.swan.apps.runtime.e acF = com.baidu.swan.apps.runtime.e.acF();
            String md5 = d.toMd5(a, false);
            File pi = pi(md5);
            if (acF == null) {
                if (!a.c(a, pi, bVar, bVar2)) {
                    com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "小游戏bundle解压失败!").showToast();
                    com.baidu.swan.apps.ap.a mz = new com.baidu.swan.apps.ap.a().aI(5L).aJ(7L).mz("小游戏bundle解压失败! for debug");
                    com.baidu.swan.apps.ap.e.ago().f(mz);
                    if (bVar2 == null || bVar2.bYF != null) {
                        return null;
                    }
                    bVar2.bYF = mz;
                    return null;
                }
            } else if (!TextUtils.equals(acF.acP().getString("installed_debug_game_bundle_md5", ""), md5)) {
                if (!a.c(a, pi, bVar, bVar2)) {
                    com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "小游戏bundle解压失败!").showToast();
                    com.baidu.swan.apps.ap.a mz2 = new com.baidu.swan.apps.ap.a().aI(5L).aJ(7L).mz("小游戏bundle解压失败! for debug");
                    com.baidu.swan.apps.ap.e.ago().f(mz2);
                    if (bVar2 == null || bVar2.bYF != null) {
                        return null;
                    }
                    bVar2.bYF = mz2;
                    return null;
                }
                acF.acP().putString("installed_debug_game_bundle_md5", md5);
            }
            b bVar3 = new b();
            File file = new File(pi, "game.json");
            com.baidu.swan.games.s.a.a pv = com.baidu.swan.games.s.a.a.pv(com.baidu.swan.d.c.readFileData(file));
            if (pv != null) {
                bVar3.appBundlePath = pi.getPath() + File.separator;
                bVar3.cpt = pv;
                if (!TextUtils.isEmpty(pv.crn)) {
                    bVar3.cps = bVar3.appBundlePath + pv.crn + File.separator;
                    f.apb().eF(true);
                    f.apb().pt(bVar3.cps);
                    f.apb().pu(pv.crn);
                } else {
                    f.apb().eF(false);
                }
                if (a.DEBUG) {
                    Log.d("SwanAppBundleHelper", "configFile path: " + file.getPath());
                    Log.d("SwanAppBundleHelper", "configFile exist: " + file.exists());
                    Log.d("SwanAppBundleHelper", "info.appBundlePath path: " + bVar3.appBundlePath);
                    Log.d("SwanAppBundleHelper", "info.mAppOpenDataBundle path: " + bVar3.cps);
                }
                return bVar3;
            }
            return null;
        }

        public static File pi(String str) {
            File file = new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "debug_aigames_bundle", str);
            file.mkdirs();
            return file;
        }

        public static File a(com.baidu.swan.apps.as.a.b bVar) {
            File LX = LX();
            File[] listFiles = LX.listFiles();
            if (listFiles == null || listFiles.length == 0) {
                com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), LX.getPath() + " 没有测试程序包!").showToast();
                com.baidu.swan.apps.ap.a mz = new com.baidu.swan.apps.ap.a().aI(5L).aJ(4L).mz("没有小游戏包! for debug, bundle files are empty");
                com.baidu.swan.apps.ap.e.ago().f(mz);
                if (bVar != null) {
                    bVar.bYF = mz;
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

        public static File LX() {
            File ph = a.ph("aigames_debug");
            if (!ph.exists()) {
                ph.mkdirs();
            }
            return ph;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean c(File file, File file2, com.baidu.swan.apps.x.b.b bVar, com.baidu.swan.apps.as.a.b bVar2) {
        boolean unzipFile;
        int i = 0;
        if (file == null || file2 == null) {
            return false;
        }
        if (!file.exists() || file.length() == 0) {
            com.baidu.swan.apps.ap.a mz = new com.baidu.swan.apps.ap.a().aI(5L).aJ(4L).mz("小游戏bundle文件不存在或者空文件! ");
            if (bVar2 != null) {
                bVar2.bYF = mz;
                return false;
            }
            return false;
        }
        com.baidu.swan.apps.performance.f.ZV().f(new UbcFlowEvent("package_start_unzip"));
        long currentTimeMillis = System.currentTimeMillis();
        a.b r = com.baidu.swan.apps.t.a.a.r(file);
        if (r.type != -1) {
            unzipFile = com.baidu.swan.apps.t.a.a.a(r.bxL, file2, r.type).isSuccess;
            i = r.type;
        } else {
            unzipFile = com.baidu.swan.d.c.unzipFile(file.getPath(), file2.getPath());
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        if (DEBUG) {
            com.baidu.swan.apps.t.a.a.fe((int) (currentTimeMillis2 - currentTimeMillis));
        }
        if (!unzipFile) {
            com.baidu.swan.apps.ap.a mz2 = new com.baidu.swan.apps.ap.a().aI(5L).aJ(7L).mz("小游戏bundle解压失败! PkgType=" + i);
            if (bVar2 != null) {
                bVar2.bYF = mz2;
            }
        }
        com.baidu.swan.apps.performance.f.ZV().f(new UbcFlowEvent("package_end_unzip")).bb("app_package_version", String.valueOf(i));
        return unzipFile;
    }

    public static void a(e.c cVar, e.b bVar) {
        new com.baidu.swan.apps.l.a().a(cVar, C0338a.LX().getPath() + File.separator + String.valueOf(System.currentTimeMillis()) + ".aibundle", bVar);
    }

    /* loaded from: classes11.dex */
    public static class c {
        public static b c(com.baidu.swan.apps.x.b.b bVar, com.baidu.swan.apps.as.a.b bVar2) {
            if (bVar == null) {
                return null;
            }
            File aL = aL(bVar.getAppId(), bVar.getVersion());
            if (!aL.exists()) {
                File a = a(bVar.getAppId(), true, bVar2);
                if (a != null) {
                    if (!a.c(a, q(aL), bVar, bVar2)) {
                        com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "小游戏bundle解压失败!").showToast();
                        com.baidu.swan.apps.ap.a mz = new com.baidu.swan.apps.ap.a().aI(5L).aJ(7L).mz("小游戏bundle解压失败! for release");
                        com.baidu.swan.apps.ap.e.ago().f(mz);
                        if (bVar2 == null || bVar2.bYF != null) {
                            return null;
                        }
                        bVar2.bYF = mz;
                        return null;
                    }
                } else {
                    com.baidu.swan.apps.process.messaging.client.a.aaV().a(8, new SwanAppDeleteInfo(bVar.getAppId(), 1));
                    return null;
                }
            }
            aM(bVar.getAppId(), bVar.getVersion());
            b bVar3 = new b();
            File file = new File(aL, "game.json");
            com.baidu.swan.games.s.a.a pv = com.baidu.swan.games.s.a.a.pv(com.baidu.swan.d.c.readFileData(file));
            if (pv != null) {
                bVar3.appBundlePath = aL.getPath() + File.separator;
                bVar3.cpt = pv;
                if (!TextUtils.isEmpty(pv.crn)) {
                    bVar3.cps = bVar3.appBundlePath + File.separator + pv.crn + File.separator;
                    f.apb().eF(true);
                    f.apb().pt(bVar3.cps);
                    f.apb().pu(pv.crn);
                } else {
                    f.apb().eF(false);
                }
                if (a.DEBUG) {
                    Log.d("SwanAppBundleHelper", "configFile path: " + file.getPath());
                    Log.d("SwanAppBundleHelper", "configFile exist: " + file.exists());
                    Log.d("SwanAppBundleHelper", "info.appBundlePath path: " + bVar3.appBundlePath);
                    Log.d("SwanAppBundleHelper", "info.mAppOpenDataBundle path: " + bVar3.cps);
                }
                return bVar3;
            }
            return null;
        }

        public static File q(File file) {
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }

        public static File aL(String str, String str2) {
            return new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "aigames_folder" + File.separator + str, str2);
        }

        public static void ih(String str) {
            if (!TextUtils.isEmpty(str)) {
                File v = v(str, false);
                if (v != null) {
                    com.baidu.swan.d.c.deleteFile(v);
                }
                com.baidu.swan.d.c.deleteFile(new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "aigames_folder" + File.separator + str));
            }
        }

        private static void aM(String str, String str2) {
            File[] listFiles;
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && (listFiles = new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "aigames_folder", str).listFiles(new FileFilter() { // from class: com.baidu.swan.games.k.a.c.1
                @Override // java.io.FileFilter
                public boolean accept(File file) {
                    return file.isDirectory() && TextUtils.isDigitsOnly(file.getName());
                }
            })) != null && listFiles.length > 0) {
                for (File file : listFiles) {
                    if (aN(str2, file.getName())) {
                        if (a.DEBUG) {
                            Log.i("SwanAppBundleHelper", "删除低版本文件夹：" + file.getAbsolutePath());
                        }
                        com.baidu.swan.pms.database.a.atv().cc(str, file.getName());
                        com.baidu.swan.d.c.deleteFile(file);
                    }
                }
            }
        }

        @Nullable
        public static File v(String str, boolean z) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return a(str, z, null);
        }

        public static File a(String str, boolean z, com.baidu.swan.apps.as.a.b bVar) {
            File TQ;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            File[] listFiles = TQ().listFiles();
            if (listFiles == null || listFiles.length == 0) {
                if (a.DEBUG && z) {
                    com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), TQ.getPath() + " 没有小游戏包!").showToast();
                }
                com.baidu.swan.apps.ap.a mz = new com.baidu.swan.apps.ap.a().aI(5L).aJ(4L).mz("没有小游戏包! for release, bundle files are empty");
                com.baidu.swan.apps.ap.e.ago().f(mz);
                if (bVar != null) {
                    bVar.bYF = mz;
                }
                return null;
            }
            for (File file : listFiles) {
                if (TextUtils.equals(file.getName(), str + ".aigames")) {
                    return file;
                }
            }
            if (a.DEBUG && z) {
                com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), TQ.getPath() + " 没有小游戏包!").showToast();
            }
            com.baidu.swan.apps.ap.a mz2 = new com.baidu.swan.apps.ap.a().aI(5L).aJ(4L).mz("没有小游戏包! for release, no such bundle file");
            com.baidu.swan.apps.ap.e.ago().f(mz2);
            if (bVar != null) {
                bVar.bYF = mz2;
            }
            return null;
        }

        public static File TQ() {
            File file = new File(AppRuntime.getAppContext().getFilesDir(), "aigames_zip");
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }

        private static boolean aN(String str, String str2) {
            if (a.DEBUG) {
                Log.i("SwanAppBundleHelper", "curVersion:" + str + ",targetVersion:" + str2);
            }
            try {
                return aO(str, str2) > 0;
            } catch (IllegalArgumentException e) {
                if (a.DEBUG) {
                    Log.e("SwanAppBundleHelper", "比较版本号Exception：" + e.getMessage());
                    return false;
                }
                return false;
            }
        }

        private static long aO(String str, String str2) throws IllegalArgumentException {
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
