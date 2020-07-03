package com.baidu.swan.apps.r;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.aq.ad;
import com.baidu.swan.apps.aq.ah;
import com.baidu.swan.apps.aq.aj;
import com.baidu.swan.apps.env.SwanAppDeleteInfo;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.r.a.a;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.statistic.h;
import com.baidu.swan.apps.statistic.j;
import com.baidu.swan.apps.v.b.b;
import java.io.File;
import java.io.FileFilter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class e {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static ExecutorService clc = Executors.newSingleThreadExecutor();

    /* loaded from: classes11.dex */
    public interface b {
        void dE(int i);

        void onFailed();

        void onSuccess();
    }

    /* loaded from: classes11.dex */
    public static class c {
        public String mAppId;
        public String mDownloadUrl;
    }

    /* loaded from: classes11.dex */
    public static class f extends com.baidu.swan.apps.r.a {
        public String clg;
        public SwanAppConfigData clh;
    }

    public static void a(final com.baidu.swan.apps.v.b.b bVar, final com.baidu.swan.apps.r.b bVar2) {
        String acY;
        final JSONObject jSONObject = null;
        if (bVar == null || j.oH(bVar.getVersion())) {
            jSONObject = new JSONObject();
            String auT = aj.auT();
            if (bVar == null) {
                acY = "null";
            } else {
                try {
                    acY = bVar.acY();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            jSONObject.put("originLaunchInfo", acY);
            jSONObject.put("stackTraceBefore", auT);
        }
        clc.execute(new Runnable() { // from class: com.baidu.swan.apps.r.e.1
            @Override // java.lang.Runnable
            public void run() {
                f a2;
                com.baidu.swan.apps.aq.a.b bVar3 = new com.baidu.swan.apps.aq.a.b();
                if (com.baidu.swan.apps.af.a.a.m(com.baidu.swan.apps.v.b.b.this)) {
                    a2 = com.baidu.swan.apps.af.a.a.a(com.baidu.swan.apps.v.b.b.this, bVar3);
                } else {
                    a2 = d.a(com.baidu.swan.apps.v.b.b.this, bVar3, jSONObject);
                }
                if (a2 == null || a2.clh == null || a2.clh.cFc == null) {
                    com.baidu.swan.apps.an.a aVar = bVar3.cPd;
                    if (aVar == null) {
                        aVar = new com.baidu.swan.apps.an.a().bw(5L).bx(20L).pB("小程序loadbundle出错，loadinfo为空或者页面配置空 ");
                    }
                    h.b(new com.baidu.swan.apps.statistic.a.d().oK(h.hf(com.baidu.swan.apps.v.b.b.this != null ? com.baidu.swan.apps.v.b.b.this.getAppFrameType() : 0)).f(aVar).oN("appjson_config_invalid").a(com.baidu.swan.apps.v.b.b.this));
                }
                bVar2.a(0, a2);
            }
        });
    }

    public static File afO() {
        return new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "aiapps_folder");
    }

    public static File afP() {
        return new File(AppRuntime.getAppContext().getFilesDir(), "swan_plugin_workspace");
    }

    public static File kK(String str) {
        if (TextUtils.isEmpty(str)) {
            if (DEBUG) {
                throw new IllegalArgumentException("plugin name can't be empty");
            }
            return null;
        }
        return new File(afP(), str);
    }

    public static File bj(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            if (DEBUG) {
                throw new IllegalArgumentException("plugin name or version can't be empty");
            }
            return null;
        }
        return new File(kK(str), str2);
    }

    public static boolean a(File file, File file2, com.baidu.swan.apps.v.b.b bVar) {
        return a(file, file2, bVar, null);
    }

    public static synchronized String t(@NonNull File file) {
        String str;
        synchronized (e.class) {
            if (file == null) {
                str = "";
            } else {
                String path = file.getPath();
                if (DEBUG) {
                    Log.d("SwanAppBundleHelper", "getConfigContent path: " + path);
                }
                str = (String) com.baidu.swan.apps.core.turbo.c.aco().o(path, "");
                if (TextUtils.isEmpty(str)) {
                    if (DEBUG) {
                        Log.d("SwanAppBundleHelper", "getConfigContent read start: " + path);
                    }
                    str = com.baidu.swan.e.d.readFileData(file);
                    com.baidu.swan.apps.core.turbo.c.aco().p(path, str);
                    if (DEBUG) {
                        Log.d("SwanAppBundleHelper", "getConfigContent read end: " + path);
                    }
                }
            }
        }
        return str;
    }

    private static File c(@NonNull com.baidu.swan.apps.runtime.e eVar) {
        File file = null;
        if (eVar != null) {
            b.a apQ = eVar.apQ();
            file = a(eVar.getAppId(), apQ.getVersion(), apQ.aik(), apQ.ail(), null);
            if (DEBUG) {
                Log.d("SwanAppBundleHelper", "sendLaunchEvent folderFile: " + file.getPath());
                Log.d("SwanAppBundleHelper", "sendLaunchEvent file exists: " + file.exists());
            }
        }
        return file;
    }

    public static synchronized boolean d(@NonNull com.baidu.swan.apps.runtime.e eVar) {
        boolean z = true;
        synchronized (e.class) {
            File c2 = c(eVar);
            if (c2 == null || !c2.exists()) {
                z = false;
            } else {
                String t = t(new File(c2, "app.json"));
                if (DEBUG && !TextUtils.isEmpty(t)) {
                    Log.i("SwanAppBundleHelper", "pre handle configData : " + t);
                }
                SwanAppConfigData k = SwanAppConfigData.k(t, c2);
                if (k != null) {
                    eVar.f(k);
                }
                com.baidu.swan.apps.ae.b.a.a(k, true);
                com.baidu.swan.apps.ae.g.b.e(k);
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean a(File file, File file2, com.baidu.swan.apps.v.b.b bVar, com.baidu.swan.apps.aq.a.b bVar2) {
        boolean unzipFile;
        int i = 0;
        if (file == null || file2 == null) {
            return false;
        }
        if (!file.exists() || file.length() == 0) {
            com.baidu.swan.apps.an.a pB = new com.baidu.swan.apps.an.a().bw(5L).bx(4L).pB("小程序bundle文件不存在或者空文件! ");
            if (bVar2 != null) {
                bVar2.cPd = pB;
                return false;
            }
            return false;
        }
        com.baidu.swan.apps.performance.g.amD().f(new UbcFlowEvent("package_start_unzip"));
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
            com.baidu.swan.apps.an.a pB2 = new com.baidu.swan.apps.an.a().bw(5L).bx(7L).pB("小程序bundle解压失败! PkgType=" + i);
            if (bVar2 != null) {
                bVar2.cPd = pB2;
            }
        }
        com.baidu.swan.apps.performance.g.amD().f(new UbcFlowEvent("package_end_unzip")).bF("app_package_version", String.valueOf(i));
        return unzipFile;
    }

    private static File kL(String str) {
        return new File(afO(), str);
    }

    private static File bk(String str, String str2) {
        return new File(kL(str), str2);
    }

    public static File a(String str, String str2, boolean z, String str3, @Nullable JSONObject jSONObject) {
        File d2 = d.d(str, str2, jSONObject);
        return (!z || TextUtils.isEmpty(str3)) ? d2 : new File(d2, str3);
    }

    public static File D(String str, String str2, String str3) {
        return new File(bk(str, str2), ah.pV(str3));
    }

    public static boolean E(String str, String str2, String str3) {
        return u(D(str, str2, str3));
    }

    public static boolean bl(String str, String str2) {
        return new File(bk(str, str2), "app.json").exists();
    }

    public static boolean u(File file) {
        if (file == null || !file.exists()) {
            return false;
        }
        return new File(file, "app.json").exists();
    }

    /* loaded from: classes11.dex */
    public static class d {
        public static f a(com.baidu.swan.apps.v.b.b bVar, com.baidu.swan.apps.aq.a.b bVar2, @Nullable JSONObject jSONObject) {
            if (bVar == null) {
                return null;
            }
            File a = e.a(bVar.getAppId(), bVar.getVersion(), bVar.aik(), bVar.ail(), jSONObject);
            if (!a.exists()) {
                File a2 = a(bVar.getAppId(), true, bVar2);
                if (a2 != null) {
                    if (!e.a(a2, v(a), bVar, bVar2)) {
                        com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "小程序bundle解压失败!").showToast();
                        com.baidu.swan.apps.an.a pB = new com.baidu.swan.apps.an.a().bw(5L).bx(7L).pB("小程序bundle解压失败! for release");
                        com.baidu.swan.apps.an.e.atW().g(pB);
                        if (bVar2 == null || bVar2.cPd != null) {
                            return null;
                        }
                        bVar2.cPd = pB;
                        return null;
                    }
                } else {
                    com.baidu.swan.apps.process.messaging.client.a.anW().a(8, new SwanAppDeleteInfo(bVar.getAppId(), 1));
                    h.b(new com.baidu.swan.apps.statistic.a.d().oK(h.hf(bVar.getAppFrameType())).f(new com.baidu.swan.apps.an.a().bw(5L).bx(31L).pB("小程序zip和bundle不存在，兜底重置")).a(bVar));
                    if (e.DEBUG) {
                        Log.w("SwanAppBundleHelper", "20050004：reset aiapps");
                        return null;
                    }
                    return null;
                }
            }
            bn(bVar.getAppId(), bVar.getVersion());
            f fVar = new f();
            File file = new File(a, "app.json");
            SwanAppConfigData k = SwanAppConfigData.k(e.t(file), a);
            if (k != null) {
                fVar.clg = bm(bVar.getAppId(), bVar.getVersion()).getPath() + File.separator;
                fVar.clh = k;
                com.baidu.swan.apps.ae.b.a.a(k, true);
                com.baidu.swan.apps.ae.g.b.e(k);
                if (e.DEBUG) {
                    Log.d("SwanAppBundleHelper", "configFile path: " + file.getPath());
                    Log.d("SwanAppBundleHelper", "configFile exist: " + file.exists());
                    Log.d("SwanAppBundleHelper", "info.mAppBundlePath path: " + fVar.clg);
                    Log.d("SwanAppBundleHelper", "launchInfo.swanCoreVersion.swanCorePath: " + bVar.acM().swanCorePath);
                }
                return fVar;
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
            return d(str, str2, null);
        }

        public static File d(String str, String str2, @Nullable JSONObject jSONObject) {
            if (j.oH(str2)) {
                j.e(str, str2, jSONObject);
            }
            return new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "aiapps_folder" + File.separator + str, str2);
        }

        public static void kM(String str) {
            if (!TextUtils.isEmpty(str)) {
                File O = O(str, false);
                if (O != null) {
                    com.baidu.swan.e.d.deleteFile(O);
                }
                com.baidu.swan.e.d.deleteFile(new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "aiapps_folder" + File.separator + str));
            }
        }

        public static void bn(String str, String str2) {
            File[] listFiles;
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && (listFiles = new File(AppRuntime.getAppContext().getFilesDir() + File.separator + "aiapps_folder", str).listFiles(new FileFilter() { // from class: com.baidu.swan.apps.r.e.d.1
                @Override // java.io.FileFilter
                public boolean accept(File file) {
                    return file.isDirectory() && TextUtils.isDigitsOnly(file.getName());
                }
            })) != null && listFiles.length > 0) {
                for (File file : listFiles) {
                    if (bo(str2, file.getName())) {
                        if (e.DEBUG) {
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
            return a(str, z, (com.baidu.swan.apps.aq.a.b) null);
        }

        public static File a(String str, boolean z, com.baidu.swan.apps.aq.a.b bVar) {
            File afR;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            File[] listFiles = afR().listFiles();
            if (listFiles == null || listFiles.length == 0) {
                if (e.DEBUG && z) {
                    com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), afR.getPath() + " 没有小程序包!").showToast();
                }
                com.baidu.swan.apps.an.a pB = new com.baidu.swan.apps.an.a().bw(5L).bx(4L).pB("没有小程序包! for release, bundle files are empty");
                com.baidu.swan.apps.an.e.atW().g(pB);
                if (bVar != null) {
                    bVar.cPd = pB;
                }
                return null;
            }
            for (File file : listFiles) {
                if (TextUtils.equals(file.getName(), str + ".aiapps")) {
                    return file;
                }
            }
            if (e.DEBUG && z) {
                com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), afR.getPath() + " 没有小程序包!").showToast();
            }
            com.baidu.swan.apps.an.a pB2 = new com.baidu.swan.apps.an.a().bw(5L).bx(4L).pB("没有小程序包! for release, no such bundle file");
            com.baidu.swan.apps.an.e.atW().g(pB2);
            if (bVar != null) {
                bVar.cPd = pB2;
            }
            return null;
        }

        public static File afR() {
            File file = new File(AppRuntime.getAppContext().getFilesDir(), "aiapps_zip");
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }

        private static boolean bo(String str, String str2) {
            if (e.DEBUG) {
                Log.i("SwanAppBundleHelper", "curVersion:" + str + ",targetVersion:" + str2);
            }
            try {
                return bp(str, str2) > 0;
            } catch (IllegalArgumentException e) {
                if (e.DEBUG) {
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

    public static void a(c cVar, b bVar) {
        new com.baidu.swan.apps.k.a().a(cVar, a.XA().getPath() + File.separator + String.valueOf(System.currentTimeMillis()) + ".aibundle", bVar);
    }

    public static void a(String str, b bVar) {
        c cVar = new c();
        cVar.mDownloadUrl = str;
        com.baidu.swan.apps.swancore.b.a.adR();
        new com.baidu.swan.apps.k.a().a(cVar, com.baidu.swan.apps.swancore.b.a.adS().getPath(), bVar);
    }

    public static void b(String str, b bVar) {
        c cVar = new c();
        cVar.mDownloadUrl = str;
        com.baidu.swan.apps.extcore.c.b.adR();
        new com.baidu.swan.apps.k.a().a(cVar, com.baidu.swan.apps.extcore.c.b.adS().getPath(), bVar);
    }

    /* loaded from: classes11.dex */
    public static class a {
        /* JADX WARN: Removed duplicated region for block: B:19:0x00b2  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static f a(com.baidu.swan.apps.v.b.b bVar, com.baidu.swan.apps.aq.a.b bVar2) {
            f fVar = null;
            File a = a(bVar2);
            if (a != null) {
                com.baidu.swan.apps.runtime.e apM = com.baidu.swan.apps.runtime.e.apM();
                if (apM == null) {
                    if (!e.a(a, Xf(), bVar, bVar2)) {
                        com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "小程序bundle解压失败!").showToast();
                        com.baidu.swan.apps.an.a pB = new com.baidu.swan.apps.an.a().bw(5L).bx(7L).pB("小程序bundle解压失败! for debug");
                        com.baidu.swan.apps.an.e.atW().g(pB);
                        if (bVar2 != null && bVar2.cPd == null) {
                            bVar2.cPd = pB;
                        }
                    }
                    fVar = new f();
                    File afQ = afQ();
                    File file = new File(afQ, "app.json");
                    SwanAppConfigData k = SwanAppConfigData.k(com.baidu.swan.e.d.readFileData(file), afQ);
                    fVar.clg = afQ.getPath() + File.separator;
                    fVar.clh = k;
                    com.baidu.swan.apps.ae.b.a.a(k, true);
                    com.baidu.swan.apps.ae.g.b.e(k);
                    if (e.DEBUG) {
                    }
                } else {
                    String string = apM.apY().getString("installed_debug_bundle_md5", "");
                    String md5 = com.baidu.swan.e.e.toMd5(a, false);
                    if (!TextUtils.equals(string, md5)) {
                        if (!e.a(a, Xf(), bVar, bVar2)) {
                            com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "小程序bundle解压失败!").showToast();
                            com.baidu.swan.apps.an.a pB2 = new com.baidu.swan.apps.an.a().bw(5L).bx(7L).pB("小程序bundle解压失败! for debug");
                            com.baidu.swan.apps.an.e.atW().g(pB2);
                            if (bVar2 != null && bVar2.cPd == null) {
                                bVar2.cPd = pB2;
                            }
                        } else {
                            apM.apY().putString("installed_debug_bundle_md5", md5);
                        }
                    }
                    fVar = new f();
                    File afQ2 = afQ();
                    File file2 = new File(afQ2, "app.json");
                    SwanAppConfigData k2 = SwanAppConfigData.k(com.baidu.swan.e.d.readFileData(file2), afQ2);
                    fVar.clg = afQ2.getPath() + File.separator;
                    fVar.clh = k2;
                    com.baidu.swan.apps.ae.b.a.a(k2, true);
                    com.baidu.swan.apps.ae.g.b.e(k2);
                    if (e.DEBUG) {
                        Log.d("SwanAppBundleHelper", "configFile path: " + file2.getPath());
                        Log.d("SwanAppBundleHelper", "configFile exist: " + file2.exists());
                        Log.d("SwanAppBundleHelper", "info.mAppBundlePath path: " + fVar.clg);
                        Log.d("SwanAppBundleHelper", "launchInfo.swanCoreVersion.swanCorePath: " + bVar.acM().swanCorePath);
                    }
                }
            }
            return fVar;
        }

        public static File afQ() {
            return Xf();
        }

        public static File Xf() {
            File file = new File(AppRuntime.getAppContext().getFilesDir(), "debug_aiapps_bundle");
            file.mkdirs();
            return file;
        }

        public static File a(com.baidu.swan.apps.aq.a.b bVar) {
            File XA = XA();
            File[] listFiles = XA.listFiles();
            if (listFiles == null || listFiles.length == 0) {
                com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), XA.getPath() + " 没有测试程序包!").showToast();
                com.baidu.swan.apps.an.a pB = new com.baidu.swan.apps.an.a().bw(5L).bx(4L).pB("没有小程序包! for debug, bundle files are empty");
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
            File file = new File(ad.getStorageList().get(0).mPath, "/aiapps_debug/");
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }
    }

    /* renamed from: com.baidu.swan.apps.r.e$e  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0377e {
        public static f d(com.baidu.swan.apps.v.b.b bVar) {
            File Xf = Xf();
            com.baidu.swan.apps.console.debugger.a.d.Xl().iY("unzipstart");
            e.a(Xz(), Xf, bVar);
            com.baidu.swan.apps.console.debugger.a.d.Xl().iY("unzipend");
            f fVar = new f();
            File file = new File(Xf, "app.json");
            SwanAppConfigData k = SwanAppConfigData.k(com.baidu.swan.e.d.readFileData(file), Xf);
            fVar.clg = Xf.getPath() + File.separator;
            fVar.clh = k;
            com.baidu.swan.apps.ae.b.a.a(k, true);
            com.baidu.swan.apps.ae.g.b.e(k);
            if (e.DEBUG) {
                Log.d("SwanAppBundleHelper", "configFile path: " + file.getPath());
                Log.d("SwanAppBundleHelper", "configFile exist: " + file.exists());
                Log.d("SwanAppBundleHelper", "info.mAppBundlePath path: " + fVar.clg);
            }
            return fVar;
        }

        public static File Xf() {
            File file = new File(AppRuntime.getAppContext().getFilesDir(), "aiapps_remote_debug_folder");
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }

        public static File Xz() {
            return new File(XA(), "remote_debug.aiapps");
        }

        public static File XA() {
            File file = new File(AppRuntime.getAppContext().getFilesDir(), "aiapps_remote_debug_zip");
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }
    }
}
