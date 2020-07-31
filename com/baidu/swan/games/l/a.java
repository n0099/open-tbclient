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
/* loaded from: classes7.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static ExecutorService cng = Executors.newSingleThreadExecutor();

    /* loaded from: classes7.dex */
    public static class b extends com.baidu.swan.apps.r.a {
        public String appBundlePath;
        public String djV;
        public com.baidu.swan.games.t.a.a djW;
    }

    public static void c(final com.baidu.swan.apps.u.c.b bVar, final com.baidu.swan.apps.r.b bVar2) {
        cng.execute(new Runnable() { // from class: com.baidu.swan.games.l.a.1
            @Override // java.lang.Runnable
            public void run() {
                b c2;
                com.baidu.swan.apps.aq.a.b bVar3 = new com.baidu.swan.apps.aq.a.b();
                if (com.baidu.swan.apps.u.c.b.this.isDebug() && (com.baidu.swan.apps.ae.a.a.apc() || a.DEBUG)) {
                    c2 = C0449a.b(com.baidu.swan.apps.u.c.b.this, bVar3);
                } else {
                    c2 = c.c(com.baidu.swan.apps.u.c.b.this, bVar3);
                }
                bVar2.a(0, c2);
            }
        });
    }

    public static File agZ() {
        return new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "aigames_folder");
    }

    public static File td(String str) {
        File file = new File(AppRuntime.getAppContext().getExternalFilesDir(null), "swangame/debug");
        return TextUtils.isEmpty(str) ? file : new File(file, str);
    }

    public static void c(String str, d.b bVar) {
        d.c cVar = new d.c();
        cVar.mDownloadUrl = str;
        com.baidu.swan.games.k.a.b.afi();
        new com.baidu.swan.apps.k.a().a(cVar, com.baidu.swan.games.k.a.b.afj().getPath(), bVar);
    }

    public static void b(String str, d.b bVar) {
        d.c cVar = new d.c();
        cVar.mDownloadUrl = str;
        com.baidu.swan.games.h.a.b.afi();
        new com.baidu.swan.apps.k.a().a(cVar, com.baidu.swan.games.h.a.b.afj().getPath(), bVar);
    }

    /* renamed from: com.baidu.swan.games.l.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0449a {
        public static b b(com.baidu.swan.apps.u.c.b bVar, com.baidu.swan.apps.aq.a.b bVar2) {
            File a = a(bVar2);
            if (a == null) {
                return null;
            }
            e arv = e.arv();
            String md5 = com.baidu.swan.d.e.toMd5(a, false);
            File te = te(md5);
            if (arv == null) {
                if (!a.c(a, te, bVar, bVar2)) {
                    com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "小游戏bundle解压失败!").showToast();
                    com.baidu.swan.apps.an.a qm = new com.baidu.swan.apps.an.a().bJ(5L).bK(7L).qm("小游戏bundle解压失败! for debug");
                    com.baidu.swan.apps.an.e.avX().g(qm);
                    if (bVar2 == null || bVar2.cSE != null) {
                        return null;
                    }
                    bVar2.cSE = qm;
                    return null;
                }
            } else if (!TextUtils.equals(arv.arH().getString("installed_debug_game_bundle_md5", ""), md5)) {
                if (!a.c(a, te, bVar, bVar2)) {
                    com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "小游戏bundle解压失败!").showToast();
                    com.baidu.swan.apps.an.a qm2 = new com.baidu.swan.apps.an.a().bJ(5L).bK(7L).qm("小游戏bundle解压失败! for debug");
                    com.baidu.swan.apps.an.e.avX().g(qm2);
                    if (bVar2 == null || bVar2.cSE != null) {
                        return null;
                    }
                    bVar2.cSE = qm2;
                    return null;
                }
                arv.arH().putString("installed_debug_game_bundle_md5", md5);
            }
            b bVar3 = new b();
            File file = new File(te, "game.json");
            com.baidu.swan.games.t.a.a tr = com.baidu.swan.games.t.a.a.tr(com.baidu.swan.d.d.readFileData(file));
            if (tr != null) {
                bVar3.appBundlePath = te.getPath() + File.separator;
                bVar3.djW = tr;
                if (!TextUtils.isEmpty(tr.dlQ)) {
                    bVar3.djV = bVar3.appBundlePath + tr.dlQ + File.separator;
                    f.aFV().gk(true);
                    f.aFV().tp(bVar3.djV);
                    f.aFV().tq(tr.dlQ);
                } else {
                    f.aFV().gk(false);
                }
                if (a.DEBUG) {
                    Log.d("SwanAppBundleHelper", "configFile path: " + file.getPath());
                    Log.d("SwanAppBundleHelper", "configFile exist: " + file.exists());
                    Log.d("SwanAppBundleHelper", "info.appBundlePath path: " + bVar3.appBundlePath);
                    Log.d("SwanAppBundleHelper", "info.mAppOpenDataBundle path: " + bVar3.djV);
                }
                return bVar3;
            }
            return null;
        }

        public static File te(String str) {
            File file = new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "debug_aigames_bundle", str);
            file.mkdirs();
            return file;
        }

        public static File a(com.baidu.swan.apps.aq.a.b bVar) {
            File Yg = Yg();
            File[] listFiles = Yg.listFiles();
            if (listFiles == null || listFiles.length == 0) {
                com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), Yg.getPath() + " 没有测试程序包!").showToast();
                com.baidu.swan.apps.an.a qm = new com.baidu.swan.apps.an.a().bJ(5L).bK(4L).qm("没有小游戏包! for debug, bundle files are empty");
                com.baidu.swan.apps.an.e.avX().g(qm);
                if (bVar != null) {
                    bVar.cSE = qm;
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

        public static File Yg() {
            File td = a.td("aigames_debug");
            if (!td.exists()) {
                td.mkdirs();
            }
            return td;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean c(File file, File file2, com.baidu.swan.apps.u.c.b bVar, com.baidu.swan.apps.aq.a.b bVar2) {
        boolean unzipFile;
        int i = 0;
        if (file == null || file2 == null) {
            return false;
        }
        if (!file.exists() || file.length() == 0) {
            com.baidu.swan.apps.an.a qm = new com.baidu.swan.apps.an.a().bJ(5L).bK(4L).qm("小游戏bundle文件不存在或者空文件! ");
            if (bVar2 != null) {
                bVar2.cSE = qm;
                return false;
            }
            return false;
        }
        i.anX().f(new UbcFlowEvent("package_start_unzip"));
        long currentTimeMillis = System.currentTimeMillis();
        a.b x = com.baidu.swan.apps.r.a.a.x(file);
        if (x.type != -1) {
            unzipFile = com.baidu.swan.apps.r.a.a.a(x.cnw, file2, x.type).isSuccess;
            i = x.type;
        } else {
            unzipFile = com.baidu.swan.d.d.unzipFile(file.getPath(), file2.getPath());
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        if (DEBUG) {
            com.baidu.swan.apps.r.a.a.fT((int) (currentTimeMillis2 - currentTimeMillis));
        }
        if (!unzipFile) {
            com.baidu.swan.apps.an.a qm2 = new com.baidu.swan.apps.an.a().bJ(5L).bK(7L).qm("小游戏bundle解压失败! PkgType=" + i);
            if (bVar2 != null) {
                bVar2.cSE = qm2;
            }
        }
        i.anX().f(new UbcFlowEvent("package_end_unzip")).bH("app_package_version", String.valueOf(i));
        return unzipFile;
    }

    public static void a(d.c cVar, d.b bVar) {
        new com.baidu.swan.apps.k.a().a(cVar, C0449a.Yg().getPath() + File.separator + System.currentTimeMillis() + ".aibundle", bVar);
    }

    /* loaded from: classes7.dex */
    public static class c {
        public static b c(com.baidu.swan.apps.u.c.b bVar, com.baidu.swan.apps.aq.a.b bVar2) {
            if (bVar == null) {
                return null;
            }
            File bq = bq(bVar.getAppId(), bVar.getVersion());
            if (!bq.exists()) {
                File a = a(bVar.getAppId(), true, bVar2);
                if (a != null) {
                    if (!a.c(a, w(bq), bVar, bVar2)) {
                        com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "小游戏bundle解压失败!").showToast();
                        com.baidu.swan.apps.an.a qm = new com.baidu.swan.apps.an.a().bJ(5L).bK(7L).qm("小游戏bundle解压失败! for release");
                        com.baidu.swan.apps.an.e.avX().g(qm);
                        if (bVar2 == null || bVar2.cSE != null) {
                            return null;
                        }
                        bVar2.cSE = qm;
                        return null;
                    }
                } else {
                    com.baidu.swan.apps.process.messaging.client.a.apG().a(8, new SwanAppDeleteInfo(bVar.getAppId(), 1).fv(5));
                    return null;
                }
            }
            br(bVar.getAppId(), bVar.getVersion());
            b bVar3 = new b();
            File file = new File(bq, "game.json");
            com.baidu.swan.games.t.a.a tr = com.baidu.swan.games.t.a.a.tr(com.baidu.swan.d.d.readFileData(file));
            if (tr != null) {
                bVar3.appBundlePath = bq.getPath() + File.separator;
                bVar3.djW = tr;
                if (!TextUtils.isEmpty(tr.dlQ)) {
                    bVar3.djV = bVar3.appBundlePath + File.separator + tr.dlQ + File.separator;
                    f.aFV().gk(true);
                    f.aFV().tp(bVar3.djV);
                    f.aFV().tq(tr.dlQ);
                } else {
                    f.aFV().gk(false);
                }
                if (a.DEBUG) {
                    Log.d("SwanAppBundleHelper", "configFile path: " + file.getPath());
                    Log.d("SwanAppBundleHelper", "configFile exist: " + file.exists());
                    Log.d("SwanAppBundleHelper", "info.appBundlePath path: " + bVar3.appBundlePath);
                    Log.d("SwanAppBundleHelper", "info.mAppOpenDataBundle path: " + bVar3.djV);
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

        public static File bq(String str, String str2) {
            return new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "aigames_folder" + File.separator + str, str2);
        }

        public static void lj(String str) {
            if (!TextUtils.isEmpty(str)) {
                File N = N(str, false);
                if (N != null) {
                    com.baidu.swan.d.d.deleteFile(N);
                }
                com.baidu.swan.d.d.deleteFile(new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "aigames_folder" + File.separator + str));
            }
        }

        private static void br(String str, String str2) {
            File[] listFiles;
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && (listFiles = new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "aigames_folder", str).listFiles(new FileFilter() { // from class: com.baidu.swan.games.l.a.c.1
                @Override // java.io.FileFilter
                public boolean accept(File file) {
                    return file.isDirectory() && TextUtils.isDigitsOnly(file.getName());
                }
            })) != null && listFiles.length > 0) {
                for (File file : listFiles) {
                    if (bs(str2, file.getName())) {
                        if (a.DEBUG) {
                            Log.i("SwanAppBundleHelper", "删除低版本文件夹：" + file.getAbsolutePath());
                        }
                        com.baidu.swan.pms.database.a.aKS().cO(str, file.getName());
                        com.baidu.swan.d.d.deleteFile(file);
                    }
                }
            }
        }

        @Nullable
        public static File N(String str, boolean z) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return a(str, z, null);
        }

        public static File a(String str, boolean z, com.baidu.swan.apps.aq.a.b bVar) {
            File ahd;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            File[] listFiles = ahd().listFiles();
            if (listFiles == null || listFiles.length == 0) {
                if (a.DEBUG && z) {
                    com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), ahd.getPath() + " 没有小游戏包!").showToast();
                }
                com.baidu.swan.apps.an.a qm = new com.baidu.swan.apps.an.a().bJ(5L).bK(4L).qm("没有小游戏包! for release, bundle files are empty");
                com.baidu.swan.apps.an.e.avX().g(qm);
                if (bVar != null) {
                    bVar.cSE = qm;
                }
                return null;
            }
            for (File file : listFiles) {
                if (TextUtils.equals(file.getName(), str + ".aigames")) {
                    return file;
                }
            }
            if (a.DEBUG && z) {
                com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), ahd.getPath() + " 没有小游戏包!").showToast();
            }
            com.baidu.swan.apps.an.a qm2 = new com.baidu.swan.apps.an.a().bJ(5L).bK(4L).qm("没有小游戏包! for release, no such bundle file");
            com.baidu.swan.apps.an.e.avX().g(qm2);
            if (bVar != null) {
                bVar.cSE = qm2;
            }
            return null;
        }

        public static File ahd() {
            File file = new File(AppRuntime.getAppContext().getFilesDir(), "aigames_zip");
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }

        private static boolean bs(String str, String str2) {
            if (a.DEBUG) {
                Log.i("SwanAppBundleHelper", "curVersion:" + str + ",targetVersion:" + str2);
            }
            try {
                return bt(str, str2) > 0;
            } catch (IllegalArgumentException e) {
                if (a.DEBUG) {
                    Log.e("SwanAppBundleHelper", "比较版本号Exception：" + e.getMessage());
                    return false;
                }
                return false;
            }
        }

        private static long bt(String str, String str2) throws IllegalArgumentException {
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
