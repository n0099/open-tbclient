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
    private static ExecutorService bVT = Executors.newSingleThreadExecutor();

    /* loaded from: classes11.dex */
    public static class b extends com.baidu.swan.apps.t.a {
        public String appBundlePath;
        public String cOF;
        public com.baidu.swan.games.s.a.a cOG;
    }

    public static void c(final com.baidu.swan.apps.x.b.b bVar, final com.baidu.swan.apps.t.b bVar2) {
        bVT.execute(new Runnable() { // from class: com.baidu.swan.games.k.a.1
            @Override // java.lang.Runnable
            public void run() {
                b c2;
                com.baidu.swan.apps.as.a.b bVar3 = new com.baidu.swan.apps.as.a.b();
                if (com.baidu.swan.apps.x.b.b.this.isDebug() && (com.baidu.swan.apps.ah.a.a.aiG() || a.DEBUG)) {
                    c2 = C0389a.b(com.baidu.swan.apps.x.b.b.this, bVar3);
                } else {
                    c2 = c.c(com.baidu.swan.apps.x.b.b.this, bVar3);
                }
                bVar2.a(0, c2);
            }
        });
    }

    public static File abE() {
        return new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "aigames_folder");
    }

    public static File qt(String str) {
        File file = new File(AppRuntime.getAppContext().getExternalFilesDir(null), "swangame/debug");
        return TextUtils.isEmpty(str) ? file : new File(file, str);
    }

    public static void c(String str, e.b bVar) {
        e.c cVar = new e.c();
        cVar.mDownloadUrl = str;
        com.baidu.swan.games.j.a.b.ZL();
        new com.baidu.swan.apps.l.a().a(cVar, com.baidu.swan.games.j.a.b.ZM().getPath(), bVar);
    }

    public static void b(String str, e.b bVar) {
        e.c cVar = new e.c();
        cVar.mDownloadUrl = str;
        com.baidu.swan.games.g.a.b.ZL();
        new com.baidu.swan.apps.l.a().a(cVar, com.baidu.swan.games.g.a.b.ZM().getPath(), bVar);
    }

    /* renamed from: com.baidu.swan.games.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0389a {
        public static b b(com.baidu.swan.apps.x.b.b bVar, com.baidu.swan.apps.as.a.b bVar2) {
            File a = a(bVar2);
            if (a == null) {
                return null;
            }
            com.baidu.swan.apps.runtime.e akM = com.baidu.swan.apps.runtime.e.akM();
            String md5 = d.toMd5(a, false);
            File qu = qu(md5);
            if (akM == null) {
                if (!a.c(a, qu, bVar, bVar2)) {
                    com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "小游戏bundle解压失败!").showToast();
                    com.baidu.swan.apps.ap.a nL = new com.baidu.swan.apps.ap.a().bn(5L).bo(7L).nL("小游戏bundle解压失败! for debug");
                    com.baidu.swan.apps.ap.e.aov().f(nL);
                    if (bVar2 == null || bVar2.cxQ != null) {
                        return null;
                    }
                    bVar2.cxQ = nL;
                    return null;
                }
            } else if (!TextUtils.equals(akM.akW().getString("installed_debug_game_bundle_md5", ""), md5)) {
                if (!a.c(a, qu, bVar, bVar2)) {
                    com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "小游戏bundle解压失败!").showToast();
                    com.baidu.swan.apps.ap.a nL2 = new com.baidu.swan.apps.ap.a().bn(5L).bo(7L).nL("小游戏bundle解压失败! for debug");
                    com.baidu.swan.apps.ap.e.aov().f(nL2);
                    if (bVar2 == null || bVar2.cxQ != null) {
                        return null;
                    }
                    bVar2.cxQ = nL2;
                    return null;
                }
                akM.akW().putString("installed_debug_game_bundle_md5", md5);
            }
            b bVar3 = new b();
            File file = new File(qu, "game.json");
            com.baidu.swan.games.s.a.a qH = com.baidu.swan.games.s.a.a.qH(com.baidu.swan.d.c.readFileData(file));
            if (qH != null) {
                bVar3.appBundlePath = qu.getPath() + File.separator;
                bVar3.cOG = qH;
                if (!TextUtils.isEmpty(qH.cQy)) {
                    bVar3.cOF = bVar3.appBundlePath + qH.cQy + File.separator;
                    f.axr().fD(true);
                    f.axr().qF(bVar3.cOF);
                    f.axr().qG(qH.cQy);
                } else {
                    f.axr().fD(false);
                }
                if (a.DEBUG) {
                    Log.d("SwanAppBundleHelper", "configFile path: " + file.getPath());
                    Log.d("SwanAppBundleHelper", "configFile exist: " + file.exists());
                    Log.d("SwanAppBundleHelper", "info.appBundlePath path: " + bVar3.appBundlePath);
                    Log.d("SwanAppBundleHelper", "info.mAppOpenDataBundle path: " + bVar3.cOF);
                }
                return bVar3;
            }
            return null;
        }

        public static File qu(String str) {
            File file = new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "debug_aigames_bundle", str);
            file.mkdirs();
            return file;
        }

        public static File a(com.baidu.swan.apps.as.a.b bVar) {
            File TN = TN();
            File[] listFiles = TN.listFiles();
            if (listFiles == null || listFiles.length == 0) {
                com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), TN.getPath() + " 没有测试程序包!").showToast();
                com.baidu.swan.apps.ap.a nL = new com.baidu.swan.apps.ap.a().bn(5L).bo(4L).nL("没有小游戏包! for debug, bundle files are empty");
                com.baidu.swan.apps.ap.e.aov().f(nL);
                if (bVar != null) {
                    bVar.cxQ = nL;
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

        public static File TN() {
            File qt = a.qt("aigames_debug");
            if (!qt.exists()) {
                qt.mkdirs();
            }
            return qt;
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
            com.baidu.swan.apps.ap.a nL = new com.baidu.swan.apps.ap.a().bn(5L).bo(4L).nL("小游戏bundle文件不存在或者空文件! ");
            if (bVar2 != null) {
                bVar2.cxQ = nL;
                return false;
            }
            return false;
        }
        com.baidu.swan.apps.performance.f.aic().f(new UbcFlowEvent("package_start_unzip"));
        long currentTimeMillis = System.currentTimeMillis();
        a.b s = com.baidu.swan.apps.t.a.a.s(file);
        if (s.type != -1) {
            unzipFile = com.baidu.swan.apps.t.a.a.a(s.bWi, file2, s.type).isSuccess;
            i = s.type;
        } else {
            unzipFile = com.baidu.swan.d.c.unzipFile(file.getPath(), file2.getPath());
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        if (DEBUG) {
            com.baidu.swan.apps.t.a.a.fj((int) (currentTimeMillis2 - currentTimeMillis));
        }
        if (!unzipFile) {
            com.baidu.swan.apps.ap.a nL2 = new com.baidu.swan.apps.ap.a().bn(5L).bo(7L).nL("小游戏bundle解压失败! PkgType=" + i);
            if (bVar2 != null) {
                bVar2.cxQ = nL2;
            }
        }
        com.baidu.swan.apps.performance.f.aic().f(new UbcFlowEvent("package_end_unzip")).bk("app_package_version", String.valueOf(i));
        return unzipFile;
    }

    public static void a(e.c cVar, e.b bVar) {
        new com.baidu.swan.apps.l.a().a(cVar, C0389a.TN().getPath() + File.separator + String.valueOf(System.currentTimeMillis()) + ".aibundle", bVar);
    }

    /* loaded from: classes11.dex */
    public static class c {
        public static b c(com.baidu.swan.apps.x.b.b bVar, com.baidu.swan.apps.as.a.b bVar2) {
            if (bVar == null) {
                return null;
            }
            File aT = aT(bVar.getAppId(), bVar.getVersion());
            if (!aT.exists()) {
                File a = a(bVar.getAppId(), true, bVar2);
                if (a != null) {
                    if (!a.c(a, r(aT), bVar, bVar2)) {
                        com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "小游戏bundle解压失败!").showToast();
                        com.baidu.swan.apps.ap.a nL = new com.baidu.swan.apps.ap.a().bn(5L).bo(7L).nL("小游戏bundle解压失败! for release");
                        com.baidu.swan.apps.ap.e.aov().f(nL);
                        if (bVar2 == null || bVar2.cxQ != null) {
                            return null;
                        }
                        bVar2.cxQ = nL;
                        return null;
                    }
                } else {
                    com.baidu.swan.apps.process.messaging.client.a.ajc().a(8, new SwanAppDeleteInfo(bVar.getAppId(), 1));
                    return null;
                }
            }
            aU(bVar.getAppId(), bVar.getVersion());
            b bVar3 = new b();
            File file = new File(aT, "game.json");
            com.baidu.swan.games.s.a.a qH = com.baidu.swan.games.s.a.a.qH(com.baidu.swan.d.c.readFileData(file));
            if (qH != null) {
                bVar3.appBundlePath = aT.getPath() + File.separator;
                bVar3.cOG = qH;
                if (!TextUtils.isEmpty(qH.cQy)) {
                    bVar3.cOF = bVar3.appBundlePath + File.separator + qH.cQy + File.separator;
                    f.axr().fD(true);
                    f.axr().qF(bVar3.cOF);
                    f.axr().qG(qH.cQy);
                } else {
                    f.axr().fD(false);
                }
                if (a.DEBUG) {
                    Log.d("SwanAppBundleHelper", "configFile path: " + file.getPath());
                    Log.d("SwanAppBundleHelper", "configFile exist: " + file.exists());
                    Log.d("SwanAppBundleHelper", "info.appBundlePath path: " + bVar3.appBundlePath);
                    Log.d("SwanAppBundleHelper", "info.mAppOpenDataBundle path: " + bVar3.cOF);
                }
                return bVar3;
            }
            return null;
        }

        public static File r(File file) {
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }

        public static File aT(String str, String str2) {
            return new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "aigames_folder" + File.separator + str, str2);
        }

        public static void jt(String str) {
            if (!TextUtils.isEmpty(str)) {
                File A = A(str, false);
                if (A != null) {
                    com.baidu.swan.d.c.deleteFile(A);
                }
                com.baidu.swan.d.c.deleteFile(new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "aigames_folder" + File.separator + str));
            }
        }

        private static void aU(String str, String str2) {
            File[] listFiles;
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && (listFiles = new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "aigames_folder", str).listFiles(new FileFilter() { // from class: com.baidu.swan.games.k.a.c.1
                @Override // java.io.FileFilter
                public boolean accept(File file) {
                    return file.isDirectory() && TextUtils.isDigitsOnly(file.getName());
                }
            })) != null && listFiles.length > 0) {
                for (File file : listFiles) {
                    if (aV(str2, file.getName())) {
                        if (a.DEBUG) {
                            Log.i("SwanAppBundleHelper", "删除低版本文件夹：" + file.getAbsolutePath());
                        }
                        com.baidu.swan.pms.database.a.aBI().cm(str, file.getName());
                        com.baidu.swan.d.c.deleteFile(file);
                    }
                }
            }
        }

        @Nullable
        public static File A(String str, boolean z) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return a(str, z, null);
        }

        public static File a(String str, boolean z, com.baidu.swan.apps.as.a.b bVar) {
            File abH;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            File[] listFiles = abH().listFiles();
            if (listFiles == null || listFiles.length == 0) {
                if (a.DEBUG && z) {
                    com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), abH.getPath() + " 没有小游戏包!").showToast();
                }
                com.baidu.swan.apps.ap.a nL = new com.baidu.swan.apps.ap.a().bn(5L).bo(4L).nL("没有小游戏包! for release, bundle files are empty");
                com.baidu.swan.apps.ap.e.aov().f(nL);
                if (bVar != null) {
                    bVar.cxQ = nL;
                }
                return null;
            }
            for (File file : listFiles) {
                if (TextUtils.equals(file.getName(), str + ".aigames")) {
                    return file;
                }
            }
            if (a.DEBUG && z) {
                com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), abH.getPath() + " 没有小游戏包!").showToast();
            }
            com.baidu.swan.apps.ap.a nL2 = new com.baidu.swan.apps.ap.a().bn(5L).bo(4L).nL("没有小游戏包! for release, no such bundle file");
            com.baidu.swan.apps.ap.e.aov().f(nL2);
            if (bVar != null) {
                bVar.cxQ = nL2;
            }
            return null;
        }

        public static File abH() {
            File file = new File(AppRuntime.getAppContext().getFilesDir(), "aigames_zip");
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }

        private static boolean aV(String str, String str2) {
            if (a.DEBUG) {
                Log.i("SwanAppBundleHelper", "curVersion:" + str + ",targetVersion:" + str2);
            }
            try {
                return aW(str, str2) > 0;
            } catch (IllegalArgumentException e) {
                if (a.DEBUG) {
                    Log.e("SwanAppBundleHelper", "比较版本号Exception：" + e.getMessage());
                    return false;
                }
                return false;
            }
        }

        private static long aW(String str, String str2) throws IllegalArgumentException {
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
