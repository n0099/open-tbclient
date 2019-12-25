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
/* loaded from: classes9.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static ExecutorService bsw = Executors.newSingleThreadExecutor();

    /* loaded from: classes9.dex */
    public static class b extends com.baidu.swan.apps.t.a {
        public String ckZ;
        public String cla;
        public com.baidu.swan.games.s.a.a clb;
    }

    public static void c(final com.baidu.swan.apps.x.b.b bVar, final com.baidu.swan.apps.t.b bVar2) {
        bsw.execute(new Runnable() { // from class: com.baidu.swan.games.k.a.1
            @Override // java.lang.Runnable
            public void run() {
                b c2;
                com.baidu.swan.apps.as.a.b bVar3 = new com.baidu.swan.apps.as.a.b();
                if (com.baidu.swan.apps.x.b.b.this.isDebug() && (com.baidu.swan.apps.ah.a.a.XM() || a.DEBUG)) {
                    c2 = C0326a.b(com.baidu.swan.apps.x.b.b.this, bVar3);
                } else {
                    c2 = c.c(com.baidu.swan.apps.x.b.b.this, bVar3);
                }
                bVar2.a(0, c2);
            }
        });
    }

    public static File Rb() {
        return new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "aigames_folder");
    }

    public static File oP(String str) {
        File file = new File(AppRuntime.getAppContext().getExternalFilesDir(null), "swangame/debug");
        return TextUtils.isEmpty(str) ? file : new File(file, str);
    }

    public static void c(String str, e.b bVar) {
        e.c cVar = new e.c();
        cVar.mDownloadUrl = str;
        com.baidu.swan.games.j.a.b.Pi();
        new com.baidu.swan.apps.l.a().a(cVar, com.baidu.swan.games.j.a.b.Pj().getPath(), bVar);
    }

    public static void b(String str, e.b bVar) {
        e.c cVar = new e.c();
        cVar.mDownloadUrl = str;
        com.baidu.swan.games.g.a.b.Pi();
        new com.baidu.swan.apps.l.a().a(cVar, com.baidu.swan.games.g.a.b.Pj().getPath(), bVar);
    }

    /* renamed from: com.baidu.swan.games.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C0326a {
        public static b b(com.baidu.swan.apps.x.b.b bVar, com.baidu.swan.apps.as.a.b bVar2) {
            File a = a(bVar2);
            if (a == null) {
                return null;
            }
            com.baidu.swan.apps.runtime.e ZS = com.baidu.swan.apps.runtime.e.ZS();
            String md5 = d.toMd5(a, false);
            File oQ = oQ(md5);
            if (ZS == null) {
                if (!a.c(a, oQ, bVar, bVar2)) {
                    com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "小游戏bundle解压失败!").showToast();
                    com.baidu.swan.apps.ap.a mh = new com.baidu.swan.apps.ap.a().aB(5L).aC(7L).mh("小游戏bundle解压失败! for debug");
                    com.baidu.swan.apps.ap.e.adF().f(mh);
                    if (bVar2 == null || bVar2.bUn != null) {
                        return null;
                    }
                    bVar2.bUn = mh;
                    return null;
                }
            } else if (!TextUtils.equals(ZS.aac().getString("installed_debug_game_bundle_md5", ""), md5)) {
                if (!a.c(a, oQ, bVar, bVar2)) {
                    com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "小游戏bundle解压失败!").showToast();
                    com.baidu.swan.apps.ap.a mh2 = new com.baidu.swan.apps.ap.a().aB(5L).aC(7L).mh("小游戏bundle解压失败! for debug");
                    com.baidu.swan.apps.ap.e.adF().f(mh2);
                    if (bVar2 == null || bVar2.bUn != null) {
                        return null;
                    }
                    bVar2.bUn = mh2;
                    return null;
                }
                ZS.aac().putString("installed_debug_game_bundle_md5", md5);
            }
            b bVar3 = new b();
            File file = new File(oQ, "game.json");
            com.baidu.swan.games.s.a.a pd = com.baidu.swan.games.s.a.a.pd(com.baidu.swan.d.c.readFileData(file));
            if (pd != null) {
                bVar3.ckZ = oQ.getPath() + File.separator;
                bVar3.clb = pd;
                if (!TextUtils.isEmpty(pd.cmV)) {
                    bVar3.cla = bVar3.ckZ + pd.cmV + File.separator;
                    f.amt().et(true);
                    f.amt().pb(bVar3.cla);
                    f.amt().pc(pd.cmV);
                } else {
                    f.amt().et(false);
                }
                if (a.DEBUG) {
                    Log.d("SwanAppBundleHelper", "configFile path: " + file.getPath());
                    Log.d("SwanAppBundleHelper", "configFile exist: " + file.exists());
                    Log.d("SwanAppBundleHelper", "info.appBundlePath path: " + bVar3.ckZ);
                    Log.d("SwanAppBundleHelper", "info.mAppOpenDataBundle path: " + bVar3.cla);
                }
                return bVar3;
            }
            return null;
        }

        public static File oQ(String str) {
            File file = new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "debug_aigames_bundle", str);
            file.mkdirs();
            return file;
        }

        public static File a(com.baidu.swan.apps.as.a.b bVar) {
            File Jk = Jk();
            File[] listFiles = Jk.listFiles();
            if (listFiles == null || listFiles.length == 0) {
                com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), Jk.getPath() + " 没有测试程序包!").showToast();
                com.baidu.swan.apps.ap.a mh = new com.baidu.swan.apps.ap.a().aB(5L).aC(4L).mh("没有小游戏包! for debug, bundle files are empty");
                com.baidu.swan.apps.ap.e.adF().f(mh);
                if (bVar != null) {
                    bVar.bUn = mh;
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

        public static File Jk() {
            File oP = a.oP("aigames_debug");
            if (!oP.exists()) {
                oP.mkdirs();
            }
            return oP;
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
            com.baidu.swan.apps.ap.a mh = new com.baidu.swan.apps.ap.a().aB(5L).aC(4L).mh("小游戏bundle文件不存在或者空文件! ");
            if (bVar2 != null) {
                bVar2.bUn = mh;
                return false;
            }
            return false;
        }
        com.baidu.swan.apps.performance.f.Xi().f(new UbcFlowEvent("package_start_unzip"));
        long currentTimeMillis = System.currentTimeMillis();
        a.b q = com.baidu.swan.apps.t.a.a.q(file);
        if (q.type != -1) {
            unzipFile = com.baidu.swan.apps.t.a.a.a(q.bsL, file2, q.type).isSuccess;
            i = q.type;
        } else {
            unzipFile = com.baidu.swan.d.c.unzipFile(file.getPath(), file2.getPath());
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        if (DEBUG) {
            com.baidu.swan.apps.t.a.a.eN((int) (currentTimeMillis2 - currentTimeMillis));
        }
        if (!unzipFile) {
            com.baidu.swan.apps.ap.a mh2 = new com.baidu.swan.apps.ap.a().aB(5L).aC(7L).mh("小游戏bundle解压失败! PkgType=" + i);
            if (bVar2 != null) {
                bVar2.bUn = mh2;
            }
        }
        com.baidu.swan.apps.performance.f.Xi().f(new UbcFlowEvent("package_end_unzip")).aR("app_package_version", String.valueOf(i));
        return unzipFile;
    }

    public static void a(e.c cVar, e.b bVar) {
        new com.baidu.swan.apps.l.a().a(cVar, C0326a.Jk().getPath() + File.separator + String.valueOf(System.currentTimeMillis()) + ".aibundle", bVar);
    }

    /* loaded from: classes9.dex */
    public static class c {
        public static b c(com.baidu.swan.apps.x.b.b bVar, com.baidu.swan.apps.as.a.b bVar2) {
            if (bVar == null) {
                return null;
            }
            File aA = aA(bVar.getAppId(), bVar.getVersion());
            if (!aA.exists()) {
                File a = a(bVar.getAppId(), true, bVar2);
                if (a != null) {
                    if (!a.c(a, p(aA), bVar, bVar2)) {
                        com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "小游戏bundle解压失败!").showToast();
                        com.baidu.swan.apps.ap.a mh = new com.baidu.swan.apps.ap.a().aB(5L).aC(7L).mh("小游戏bundle解压失败! for release");
                        com.baidu.swan.apps.ap.e.adF().f(mh);
                        if (bVar2 == null || bVar2.bUn != null) {
                            return null;
                        }
                        bVar2.bUn = mh;
                        return null;
                    }
                } else {
                    com.baidu.swan.apps.process.messaging.client.a.Yi().a(8, new SwanAppDeleteInfo(bVar.getAppId(), 1));
                    return null;
                }
            }
            aB(bVar.getAppId(), bVar.getVersion());
            b bVar3 = new b();
            File file = new File(aA, "game.json");
            com.baidu.swan.games.s.a.a pd = com.baidu.swan.games.s.a.a.pd(com.baidu.swan.d.c.readFileData(file));
            if (pd != null) {
                bVar3.ckZ = aA.getPath() + File.separator;
                bVar3.clb = pd;
                if (!TextUtils.isEmpty(pd.cmV)) {
                    bVar3.cla = bVar3.ckZ + File.separator + pd.cmV + File.separator;
                    f.amt().et(true);
                    f.amt().pb(bVar3.cla);
                    f.amt().pc(pd.cmV);
                } else {
                    f.amt().et(false);
                }
                if (a.DEBUG) {
                    Log.d("SwanAppBundleHelper", "configFile path: " + file.getPath());
                    Log.d("SwanAppBundleHelper", "configFile exist: " + file.exists());
                    Log.d("SwanAppBundleHelper", "info.appBundlePath path: " + bVar3.ckZ);
                    Log.d("SwanAppBundleHelper", "info.mAppOpenDataBundle path: " + bVar3.cla);
                }
                return bVar3;
            }
            return null;
        }

        public static File p(File file) {
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }

        public static File aA(String str, String str2) {
            return new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "aigames_folder" + File.separator + str, str2);
        }

        public static void hO(String str) {
            if (!TextUtils.isEmpty(str)) {
                File v = v(str, false);
                if (v != null) {
                    com.baidu.swan.d.c.deleteFile(v);
                }
                com.baidu.swan.d.c.deleteFile(new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "aigames_folder" + File.separator + str));
            }
        }

        private static void aB(String str, String str2) {
            File[] listFiles;
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && (listFiles = new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "aigames_folder", str).listFiles(new FileFilter() { // from class: com.baidu.swan.games.k.a.c.1
                @Override // java.io.FileFilter
                public boolean accept(File file) {
                    return file.isDirectory() && TextUtils.isDigitsOnly(file.getName());
                }
            })) != null && listFiles.length > 0) {
                for (File file : listFiles) {
                    if (aC(str2, file.getName())) {
                        if (a.DEBUG) {
                            Log.i("SwanAppBundleHelper", "删除低版本文件夹：" + file.getAbsolutePath());
                        }
                        com.baidu.swan.pms.database.a.aqM().bS(str, file.getName());
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
            File Re;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            File[] listFiles = Re().listFiles();
            if (listFiles == null || listFiles.length == 0) {
                if (a.DEBUG && z) {
                    com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), Re.getPath() + " 没有小游戏包!").showToast();
                }
                com.baidu.swan.apps.ap.a mh = new com.baidu.swan.apps.ap.a().aB(5L).aC(4L).mh("没有小游戏包! for release, bundle files are empty");
                com.baidu.swan.apps.ap.e.adF().f(mh);
                if (bVar != null) {
                    bVar.bUn = mh;
                }
                return null;
            }
            for (File file : listFiles) {
                if (TextUtils.equals(file.getName(), str + ".aigames")) {
                    return file;
                }
            }
            if (a.DEBUG && z) {
                com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), Re.getPath() + " 没有小游戏包!").showToast();
            }
            com.baidu.swan.apps.ap.a mh2 = new com.baidu.swan.apps.ap.a().aB(5L).aC(4L).mh("没有小游戏包! for release, no such bundle file");
            com.baidu.swan.apps.ap.e.adF().f(mh2);
            if (bVar != null) {
                bVar.bUn = mh2;
            }
            return null;
        }

        public static File Re() {
            File file = new File(AppRuntime.getAppContext().getFilesDir(), "aigames_zip");
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }

        private static boolean aC(String str, String str2) {
            if (a.DEBUG) {
                Log.i("SwanAppBundleHelper", "curVersion:" + str + ",targetVersion:" + str2);
            }
            try {
                return aD(str, str2) > 0;
            } catch (IllegalArgumentException e) {
                if (a.DEBUG) {
                    Log.e("SwanAppBundleHelper", "比较版本号Exception：" + e.getMessage());
                    return false;
                }
                return false;
            }
        }

        private static long aD(String str, String str2) throws IllegalArgumentException {
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
