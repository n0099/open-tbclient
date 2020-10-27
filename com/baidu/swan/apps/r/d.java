package com.baidu.swan.apps.r;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.ap.ai;
import com.baidu.swan.apps.ap.ak;
import com.baidu.swan.apps.env.SwanAppDeleteInfo;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.performance.i;
import com.baidu.swan.apps.r.a.a;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.statistic.h;
import com.baidu.swan.apps.statistic.j;
import com.baidu.swan.apps.u.c.b;
import java.io.File;
import java.io.FileFilter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static ExecutorService cRp = Executors.newSingleThreadExecutor();

    /* loaded from: classes10.dex */
    public interface b {
        void fa(int i);

        void onFailed();

        void onSuccess();
    }

    /* loaded from: classes10.dex */
    public static class c {
        public String mAppId;
        public String mDownloadUrl;
    }

    /* loaded from: classes10.dex */
    public static class f extends com.baidu.swan.apps.r.a {
        public String cRt;
        public SwanAppConfigData cRu;
    }

    public static void a(final com.baidu.swan.apps.u.c.b bVar, final com.baidu.swan.apps.r.b bVar2) {
        String aqd;
        final JSONObject jSONObject = null;
        if (bVar == null || j.sR(bVar.getVersion())) {
            jSONObject = new JSONObject();
            String aKv = ak.aKv();
            if (bVar == null) {
                aqd = "null";
            } else {
                try {
                    aqd = bVar.aqd();
                } catch (JSONException e2) {
                    if (DEBUG) {
                        e2.printStackTrace();
                    }
                }
            }
            jSONObject.put("originLaunchInfo", aqd);
            jSONObject.put("stackTraceBefore", aKv);
        }
        cRp.execute(new Runnable() { // from class: com.baidu.swan.apps.r.d.1
            @Override // java.lang.Runnable
            public void run() {
                f a2;
                com.baidu.swan.apps.ap.a.b bVar3 = new com.baidu.swan.apps.ap.a.b();
                if (com.baidu.swan.apps.ad.a.a.j(com.baidu.swan.apps.u.c.b.this)) {
                    a2 = com.baidu.swan.apps.ad.a.a.a(com.baidu.swan.apps.u.c.b.this, bVar3);
                } else {
                    a2 = C0452d.a(com.baidu.swan.apps.u.c.b.this, bVar3, jSONObject);
                }
                if (a2 == null || a2.cRu == null || a2.cRu.dnD == null) {
                    com.baidu.swan.apps.am.a aVar = bVar3.dyr;
                    if (aVar == null) {
                        aVar = new com.baidu.swan.apps.am.a().bZ(5L).ca(20L).tM("小程序loadbundle出错，loadinfo为空或者页面配置空 ");
                    }
                    h.b(new com.baidu.swan.apps.statistic.a.d().sU(h.ko(com.baidu.swan.apps.u.c.b.this != null ? com.baidu.swan.apps.u.c.b.this.getAppFrameType() : 0)).i(aVar).sX("appjson_config_invalid").a(com.baidu.swan.apps.u.c.b.this));
                }
                bVar2.a(0, a2);
            }
        });
    }

    public static File atQ() {
        return new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "aiapps_folder");
    }

    public static String atR() {
        return AppRuntime.getAppContext().getFilesDir() + File.separator + "aiapps_folder";
    }

    public static File atS() {
        return new File(AppRuntime.getAppContext().getFilesDir(), "swan_plugin_workspace");
    }

    public static File oF(String str) {
        if (TextUtils.isEmpty(str)) {
            if (DEBUG) {
                throw new IllegalArgumentException("plugin name can't be empty");
            }
            return null;
        }
        return new File(atS(), str);
    }

    public static File bK(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            if (DEBUG) {
                throw new IllegalArgumentException("plugin name or version can't be empty");
            }
            return null;
        }
        return new File(oF(str), str2);
    }

    public static boolean a(File file, File file2, com.baidu.swan.apps.u.c.b bVar) {
        return a(file, file2, bVar, null);
    }

    public static synchronized String y(@NonNull File file) {
        String str;
        synchronized (d.class) {
            if (file == null) {
                str = "";
            } else {
                String path = file.getPath();
                if (DEBUG) {
                    Log.d("SwanAppBundleHelper", "getConfigContent path: " + path);
                }
                str = (String) com.baidu.swan.apps.core.turbo.c.apd().o(path, "");
                if (TextUtils.isEmpty(str)) {
                    if (DEBUG) {
                        Log.d("SwanAppBundleHelper", "getConfigContent read start: " + path);
                    }
                    str = com.baidu.swan.c.d.readFileData(file);
                    com.baidu.swan.apps.core.turbo.c.apd().p(path, str);
                    if (DEBUG) {
                        Log.d("SwanAppBundleHelper", "getConfigContent read end: " + path);
                    }
                }
            }
        }
        return str;
    }

    private static File d(@NonNull com.baidu.swan.apps.runtime.e eVar) {
        File file = null;
        if (eVar != null) {
            b.a aEY = eVar.aEY();
            file = a(eVar.getAppId(), aEY.getVersion(), aEY.awx(), aEY.awy(), null);
            if (DEBUG) {
                Log.d("SwanAppBundleHelper", "sendLaunchEvent folderFile: " + file.getPath());
                Log.d("SwanAppBundleHelper", "sendLaunchEvent file exists: " + file.exists());
            }
        }
        return file;
    }

    public static synchronized boolean e(@NonNull com.baidu.swan.apps.runtime.e eVar) {
        boolean z = true;
        synchronized (d.class) {
            File d = d(eVar);
            if (d != null && d.exists()) {
                SwanAppConfigData D = com.baidu.swan.apps.u.a.a.D(d);
                if (D != null) {
                    eVar.g(D);
                }
                if (com.baidu.swan.apps.performance.b.c.aBA()) {
                    com.baidu.swan.apps.ac.b.a.b(D, true);
                    com.baidu.swan.apps.ac.g.b.f(D);
                } else {
                    com.baidu.swan.apps.ac.b.a.a(D, true);
                    com.baidu.swan.apps.ac.g.b.e(D);
                }
            } else {
                z = false;
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean a(File file, File file2, com.baidu.swan.apps.u.c.b bVar, com.baidu.swan.apps.ap.a.b bVar2) {
        boolean unzipFile;
        int i = 0;
        if (file == null || file2 == null) {
            return false;
        }
        if (!file.exists() || file.length() == 0) {
            com.baidu.swan.apps.am.a tM = new com.baidu.swan.apps.am.a().bZ(5L).ca(4L).tM("小程序bundle文件不存在或者空文件! ");
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
            com.baidu.swan.apps.am.a tM2 = new com.baidu.swan.apps.am.a().bZ(5L).ca(7L).tM("小程序bundle解压失败! PkgType=" + i);
            if (bVar2 != null) {
                bVar2.dyr = tM2;
            }
        }
        i.aBg().f(new UbcFlowEvent("package_end_unzip")).ci("app_package_version", String.valueOf(i));
        return unzipFile;
    }

    private static File oG(String str) {
        return new File(atQ(), str);
    }

    private static File bL(String str, String str2) {
        return new File(oG(str), str2);
    }

    public static File a(String str, String str2, boolean z, String str3, @Nullable JSONObject jSONObject) {
        File d = C0452d.d(str, str2, jSONObject);
        return (!z || TextUtils.isEmpty(str3)) ? d : new File(d, str3);
    }

    public static File M(String str, String str2, String str3) {
        return new File(bL(str, str2), ai.uh(str3));
    }

    public static boolean N(String str, String str2, String str3) {
        return z(M(str, str2, str3));
    }

    public static boolean bM(String str, String str2) {
        boolean exists = new File(bL(str, str2), "app.json").exists();
        com.baidu.swan.apps.console.c.bn("SwanAppBundleHelper", "isAppJsonExist = " + exists);
        return exists;
    }

    public static boolean z(File file) {
        if (file == null || !file.exists()) {
            return false;
        }
        boolean exists = new File(file, "app.json").exists();
        com.baidu.swan.apps.console.c.bn("SwanAppBundleHelper", "isAppJsonExist = " + exists);
        return exists;
    }

    /* renamed from: com.baidu.swan.apps.r.d$d  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0452d {
        public static f a(com.baidu.swan.apps.u.c.b bVar, com.baidu.swan.apps.ap.a.b bVar2, @Nullable JSONObject jSONObject) {
            if (bVar == null) {
                return null;
            }
            File a2 = d.a(bVar.getAppId(), bVar.getVersion(), bVar.awx(), bVar.awy(), jSONObject);
            if (!a2.exists()) {
                File a3 = a(bVar.getAppId(), true, bVar2);
                if (a3 != null) {
                    if (!d.a(a3, A(a2), bVar, bVar2)) {
                        com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "小程序bundle解压失败!").showToast();
                        com.baidu.swan.apps.am.a tM = new com.baidu.swan.apps.am.a().bZ(5L).ca(7L).tM("小程序bundle解压失败! for release");
                        com.baidu.swan.apps.am.e.aJt().j(tM);
                        if (bVar2 == null || bVar2.dyr != null) {
                            return null;
                        }
                        bVar2.dyr = tM;
                        return null;
                    }
                } else {
                    com.baidu.swan.apps.process.messaging.client.a.aCO().a(8, new SwanAppDeleteInfo(bVar.getAppId(), 1).ij(5));
                    h.b(new com.baidu.swan.apps.statistic.a.d().sU(h.ko(bVar.getAppFrameType())).i(new com.baidu.swan.apps.am.a().bZ(5L).ca(31L).tM("小程序zip和bundle不存在，兜底重置")).a(bVar));
                    if (d.DEBUG) {
                        Log.w("SwanAppBundleHelper", "20050004：reset aiapps");
                        return null;
                    }
                    return null;
                }
            }
            bO(bVar.getAppId(), bVar.getVersion());
            f fVar = new f();
            File file = new File(a2, "app.json");
            SwanAppConfigData l = SwanAppConfigData.l(d.y(file), a2);
            if (l != null) {
                fVar.cRt = bN(bVar.getAppId(), bVar.getVersion()).getPath() + File.separator;
                fVar.cRu = l;
                if (com.baidu.swan.apps.performance.b.c.aBA()) {
                    com.baidu.swan.apps.ac.b.a.b(l, true);
                    com.baidu.swan.apps.ac.g.b.f(l);
                } else {
                    com.baidu.swan.apps.ac.b.a.a(l, true);
                    com.baidu.swan.apps.ac.g.b.e(l);
                }
                com.baidu.swan.apps.console.c.bn("SwanAppBundleHelper", "configFile path: " + file.getPath() + "configFile exist: " + file.exists() + "info.mAppBundlePath path: " + fVar.cRt);
                return fVar;
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
            return d(str, str2, null);
        }

        public static File d(String str, String str2, @Nullable JSONObject jSONObject) {
            if (j.sR(str2)) {
                j.h(str, str2, jSONObject);
            }
            return new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "aiapps_folder" + File.separator + str, str2);
        }

        public static void oH(String str) {
            if (!TextUtils.isEmpty(str)) {
                File Y = Y(str, false);
                if (Y != null) {
                    com.baidu.swan.c.d.deleteFile(Y);
                }
                com.baidu.swan.c.d.deleteFile(new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "aiapps_folder" + File.separator + str));
            }
        }

        public static void bO(String str, String str2) {
            File[] listFiles;
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && (listFiles = new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "aiapps_folder", str).listFiles(new FileFilter() { // from class: com.baidu.swan.apps.r.d.d.1
                @Override // java.io.FileFilter
                public boolean accept(File file) {
                    return file.isDirectory() && TextUtils.isDigitsOnly(file.getName());
                }
            })) != null && listFiles.length > 0) {
                for (File file : listFiles) {
                    if (bP(str2, file.getName())) {
                        if (d.DEBUG) {
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
            return a(str, z, (com.baidu.swan.apps.ap.a.b) null);
        }

        @Nullable
        public static File a(@Nullable String str, boolean z, @Nullable com.baidu.swan.apps.ap.a.b bVar) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            File atU = atU();
            File file = new File(atU, str + ".aiapps");
            if (file.exists() && file.isFile()) {
                return file;
            }
            if (d.DEBUG && z) {
                com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), atU.getPath() + " 没有小程序包!").showToast();
            }
            if (bVar != null) {
                com.baidu.swan.apps.am.a tM = new com.baidu.swan.apps.am.a().bZ(5L).ca(4L).tM("没有小程序包! for release, no such bundle file");
                com.baidu.swan.apps.am.e.aJt().j(tM);
                bVar.dyr = tM;
                return null;
            }
            return null;
        }

        public static File atU() {
            File file = new File(AppRuntime.getAppContext().getFilesDir(), "swan_zip");
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }

        private static boolean bP(String str, String str2) {
            if (d.DEBUG) {
                Log.i("SwanAppBundleHelper", "curVersion:" + str + ",targetVersion:" + str2);
            }
            try {
                return bQ(str, str2) > 0;
            } catch (IllegalArgumentException e) {
                if (d.DEBUG) {
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

    public static void a(c cVar, b bVar) {
        new com.baidu.swan.apps.l.a().a(cVar, a.ajB().getPath() + File.separator + System.currentTimeMillis() + ".aibundle", bVar);
    }

    public static void a(String str, b bVar) {
        c cVar = new c();
        cVar.mDownloadUrl = str;
        com.baidu.swan.apps.swancore.b.a.arF();
        new com.baidu.swan.apps.l.a().a(cVar, com.baidu.swan.apps.swancore.b.a.arG().getPath(), bVar);
    }

    public static void b(String str, b bVar) {
        c cVar = new c();
        cVar.mDownloadUrl = str;
        com.baidu.swan.apps.extcore.c.b.arF();
        new com.baidu.swan.apps.l.a().a(cVar, com.baidu.swan.apps.extcore.c.b.arG().getPath(), bVar);
    }

    /* loaded from: classes10.dex */
    public static class a {
        public static f a(com.baidu.swan.apps.u.c.b bVar, com.baidu.swan.apps.ap.a.b bVar2) {
            File a2 = a(bVar2);
            if (a2 == null) {
                return null;
            }
            com.baidu.swan.apps.runtime.e aEU = com.baidu.swan.apps.runtime.e.aEU();
            if (aEU == null) {
                if (!d.a(a2, ajg(), bVar, bVar2)) {
                    com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "小程序bundle解压失败!").showToast();
                    com.baidu.swan.apps.am.a tM = new com.baidu.swan.apps.am.a().bZ(5L).ca(7L).tM("小程序bundle解压失败! for debug");
                    com.baidu.swan.apps.am.e.aJt().j(tM);
                    if (bVar2 == null || bVar2.dyr != null) {
                        return null;
                    }
                    bVar2.dyr = tM;
                    return null;
                }
            } else {
                String string = aEU.aFg().getString("installed_debug_bundle_md5", "");
                String md5 = com.baidu.swan.c.e.toMd5(a2, false);
                if (!TextUtils.equals(string, md5)) {
                    if (!d.a(a2, ajg(), bVar, bVar2)) {
                        com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "小程序bundle解压失败!").showToast();
                        com.baidu.swan.apps.am.a tM2 = new com.baidu.swan.apps.am.a().bZ(5L).ca(7L).tM("小程序bundle解压失败! for debug");
                        com.baidu.swan.apps.am.e.aJt().j(tM2);
                        if (bVar2 == null || bVar2.dyr != null) {
                            return null;
                        }
                        bVar2.dyr = tM2;
                        return null;
                    }
                    aEU.aFg().putString("installed_debug_bundle_md5", md5);
                }
            }
            f fVar = new f();
            File atT = atT();
            File file = new File(atT, "app.json");
            SwanAppConfigData l = SwanAppConfigData.l(com.baidu.swan.c.d.readFileData(file), atT);
            fVar.cRt = atT.getPath() + File.separator;
            fVar.cRu = l;
            com.baidu.swan.apps.ac.b.a.a(l, true);
            com.baidu.swan.apps.ac.g.b.e(l);
            com.baidu.swan.apps.console.c.bn("SwanAppBundleHelper", "configFile path: " + file.getPath() + "configFile exist: " + file.exists() + "info.mAppBundlePath path: " + fVar.cRt);
            return fVar;
        }

        public static File atT() {
            return ajg();
        }

        public static File ajg() {
            File file = new File(AppRuntime.getAppContext().getFilesDir(), "debug_aiapps_bundle");
            file.mkdirs();
            return file;
        }

        public static File a(com.baidu.swan.apps.ap.a.b bVar) {
            File ajB = ajB();
            File[] listFiles = ajB.listFiles();
            if (listFiles == null || listFiles.length == 0) {
                com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), ajB.getPath() + " 没有测试程序包!").showToast();
                com.baidu.swan.apps.am.a tM = new com.baidu.swan.apps.am.a().bZ(5L).ca(4L).tM("没有小程序包! for debug, bundle files are empty");
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
            File file = new File(com.baidu.swan.apps.u.a.a.getStorageList().get(0).mPath, "/aiapps_debug/");
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }
    }

    /* loaded from: classes10.dex */
    public static class e {
        public static f d(com.baidu.swan.apps.u.c.b bVar) {
            File ajg = ajg();
            com.baidu.swan.apps.console.debugger.a.d.ajm().mh("unzipstart");
            d.a(ajA(), ajg, bVar);
            com.baidu.swan.apps.console.debugger.a.d.ajm().mh("unzipend");
            f fVar = new f();
            File file = new File(ajg, "app.json");
            SwanAppConfigData l = SwanAppConfigData.l(com.baidu.swan.c.d.readFileData(file), ajg);
            fVar.cRt = ajg.getPath() + File.separator;
            fVar.cRu = l;
            com.baidu.swan.apps.ac.b.a.a(l, true);
            com.baidu.swan.apps.ac.g.b.e(l);
            com.baidu.swan.apps.console.c.bn("SwanAppBundleHelper", "configFile path: " + file.getPath() + "configFile exist: " + file.exists() + "info.mAppBundlePath path: " + fVar.cRt);
            return fVar;
        }

        public static File ajg() {
            File file = new File(AppRuntime.getAppContext().getFilesDir(), "aiapps_remote_debug_folder");
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }

        public static File ajA() {
            return new File(ajB(), "remote_debug.aiapps");
        }

        public static File ajB() {
            File file = new File(AppRuntime.getAppContext().getFilesDir(), "aiapps_remote_debug_zip");
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }
    }
}
