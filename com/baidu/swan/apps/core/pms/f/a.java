package com.baidu.swan.apps.core.pms.f;

import android.os.Bundle;
import android.support.annotation.AnyThread;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.am.e;
import com.baidu.swan.apps.ap.ae;
import com.baidu.swan.apps.ap.p;
import com.baidu.swan.apps.ap.v;
import com.baidu.swan.apps.r.a.a;
import com.baidu.swan.apps.r.d;
import com.baidu.swan.apps.statistic.f;
import com.baidu.swan.games.l.a;
import com.baidu.swan.pms.a.h;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.swan.pms.model.g;
import java.io.File;
import java.io.IOException;
import java.nio.channels.ReadableByteChannel;
/* loaded from: classes7.dex */
public final class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static boolean cMu = false;

    /* renamed from: com.baidu.swan.apps.core.pms.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0427a {
        public int cMw = 0;
        public boolean cMx = false;
        public String cMy = "";
    }

    public static String aqa() {
        return d.C0462d.avM().getPath();
    }

    public static String aqb() {
        return a.c.avM().getPath();
    }

    public static String aqc() {
        return d.C0462d.avM().getPath();
    }

    public static String apU() {
        return d.C0462d.avM().getPath();
    }

    public static String aqd() {
        return a.c.avM().getPath();
    }

    public static String aqe() {
        return a.c.avM().getPath();
    }

    public static com.baidu.swan.games.t.a.a k(String str, long j) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return com.baidu.swan.games.t.a.a.xp(com.baidu.swan.c.d.readFileData(new File(a.c.bM(str, String.valueOf(j)), "game.json")));
    }

    public static com.baidu.swan.apps.am.a a(ReadableByteChannel readableByteChannel, String str, com.baidu.swan.pms.a.d dVar) throws IOException {
        if (readableByteChannel == null) {
            com.baidu.swan.apps.am.a tV = new com.baidu.swan.apps.am.a().cv(11L).cw(2300L).tV("empty source");
            e.aLl().j(tV);
            if (DEBUG) {
                Log.i("PkgDownloadUtil", "checkPkgZipSign err: " + tV);
                return tV;
            }
            return tV;
        }
        dVar.bq("670", "aiapp_aps_check_sign_start_timestamp");
        dVar.bq("770", "na_pms_start_check_sign");
        if (ae.a(readableByteChannel, str, new com.baidu.swan.apps.ap.a.c())) {
            dVar.bq("670", "aiapp_aps_check_sign_end_timestamp");
            dVar.bq("770", "na_pms_end_check_sign");
            return null;
        }
        com.baidu.swan.apps.am.a tV2 = new com.baidu.swan.apps.am.a().cv(11L).cw(2300L).tV("check zip file sign fail.");
        e.aLl().j(tV2);
        if (DEBUG) {
            Log.i("PkgDownloadUtil", "checkPkgZipSign err: " + tV2);
            return tV2;
        }
        return tV2;
    }

    public static com.baidu.swan.apps.am.a a(com.baidu.swan.pms.model.e eVar, com.baidu.swan.pms.a.d dVar) {
        File bM;
        if (eVar == null) {
            com.baidu.swan.apps.am.a tV = new com.baidu.swan.apps.am.a().cv(11L).cw(2320L).tV("pkg info is empty");
            e.aLl().j(tV);
            return tV;
        }
        File file = new File(eVar.filePath);
        if (eVar.category == 1) {
            bM = a.c.bM(eVar.efY, String.valueOf(eVar.versionCode));
        } else if (eVar.category == 0) {
            bM = d.C0462d.bM(eVar.efY, String.valueOf(eVar.versionCode));
        } else {
            com.baidu.swan.apps.am.a tV2 = new com.baidu.swan.apps.am.a().cv(11L).cw(2320L).tV("pkh category illegal");
            e.aLl().j(tV2);
            return tV2;
        }
        if (!file.exists()) {
            com.baidu.swan.apps.am.a tV3 = new com.baidu.swan.apps.am.a().cv(11L).cw(2320L).tV("解压失败：包不存在");
            e.aLl().j(tV3);
            return tV3;
        } else if (bM.isFile() && !bM.delete()) {
            if (DEBUG) {
                Log.e("PkgDownloadUtil", "解压失败：解压目录被文件占用，且无法删除");
            }
            com.baidu.swan.apps.am.a tV4 = new com.baidu.swan.apps.am.a().cv(11L).cw(2320L).tV("解压失败：解压目录被文件占用，且无法删除");
            e.aLl().j(tV4);
            return tV4;
        } else if (!bM.exists() && !bM.mkdirs()) {
            if (DEBUG) {
                Log.e("PkgDownloadUtil", "解压失败：解压文件夹创建失败 " + bM.getAbsolutePath());
            }
            com.baidu.swan.apps.am.a tV5 = new com.baidu.swan.apps.am.a().cv(11L).cw(2320L).tV("解压失败：解压文件夹创建失败");
            e.aLl().j(tV5);
            return tV5;
        } else {
            if (DEBUG) {
                Log.i("PkgDownloadUtil", "开始执行解压操作, bundle:" + file.getPath() + " , folder:" + bM.getPath());
            }
            if (a(file, bM, dVar).cMx) {
                return null;
            }
            C0427a a2 = a(file, bM, dVar);
            if (a2.cMx) {
                f.a(dVar, eVar.category, true);
                return null;
            }
            f.a(dVar, eVar.category, false);
            com.baidu.swan.c.d.safeDeleteFile(bM);
            com.baidu.swan.apps.am.a aVar = new com.baidu.swan.apps.am.a();
            switch (a2.cMw) {
                case 0:
                    aVar.cv(11L).cw(2320L).tV("unzip failed");
                    break;
                case 1:
                case 2:
                    aVar.cv(11L).cw(2330L).tV("decryt failed:" + a2.cMy + ", PkgType=" + a2.cMw);
                    break;
                default:
                    aVar.cv(4L).cw(7L).tV("Unkown bundle type");
                    break;
            }
            e.aLl().j(aVar);
            return aVar;
        }
    }

    @NonNull
    private static C0427a a(@NonNull File file, @NonNull File file2, @NonNull com.baidu.swan.pms.a.d dVar) {
        int i;
        C0427a c0427a = new C0427a();
        long currentTimeMillis = System.currentTimeMillis();
        a.b B = com.baidu.swan.apps.r.a.a.B(file);
        if (B.type != -1) {
            dVar.bq("670", "package_start_decrypt");
            dVar.bq("770", "na_package_start_decrypt");
            a.C0461a a2 = com.baidu.swan.apps.r.a.a.a(B.cVN, file2, B.type);
            dVar.bq("670", "package_end_decrypt");
            dVar.bq("770", "na_package_end_decrypt");
            c0427a.cMx = a2.isSuccess;
            c0427a.cMy = a2.cMy;
            c0427a.cMw = B.type;
            i = B.type;
        } else {
            c0427a.cMw = 0;
            dVar.bq("670", "package_start_unzip");
            dVar.bq("770", "na_package_start_unzip");
            c0427a.cMx = com.baidu.swan.c.d.unzipFile(file.getPath(), file2.getPath());
            dVar.bq("670", "package_end_unzip");
            dVar.bq("770", "na_package_end_unzip");
            i = 0;
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        if (DEBUG) {
            com.baidu.swan.apps.r.a.a.iV((int) (currentTimeMillis2 - currentTimeMillis));
        }
        Bundle bundle = new Bundle();
        bundle.putInt("download_package_type_id", i);
        h.a(dVar, bundle, "event_download_package_type");
        return c0427a;
    }

    public static void g(@Nullable PMSAppInfo pMSAppInfo) {
        if (pMSAppInfo != null) {
            if (!TextUtils.isEmpty(pMSAppInfo.webViewDomains)) {
                com.baidu.swan.apps.ag.a.c.a(pMSAppInfo.appId, "", v.uj(pMSAppInfo.webViewDomains));
            }
            if (!TextUtils.isEmpty(pMSAppInfo.webAction)) {
                com.baidu.swan.apps.ag.a.c.a("", v.uj(pMSAppInfo.webAction));
            }
            if (!TextUtils.isEmpty(pMSAppInfo.domains)) {
                com.baidu.swan.apps.ag.a.c.i(pMSAppInfo.appId, v.parseString(pMSAppInfo.domains));
            }
        }
    }

    public static void a(PMSAppInfo pMSAppInfo, com.baidu.swan.pms.model.f fVar) {
        com.baidu.swan.games.t.a.a k;
        if (pMSAppInfo != null && fVar != null) {
            pMSAppInfo.h(fVar);
            if (fVar.category == 1 && (k = k(fVar.efY, fVar.versionCode)) != null) {
                pMSAppInfo.setOrientation(k.dWB);
            } else {
                pMSAppInfo.setOrientation(0);
            }
        }
    }

    public static void a(PMSAppInfo pMSAppInfo, g gVar) {
        if (pMSAppInfo != null && gVar != null) {
            pMSAppInfo.m(gVar);
            if (gVar.category == 0) {
                pMSAppInfo.setOrientation(0);
            }
        }
    }

    public static boolean b(@Nullable com.baidu.swan.pms.model.e eVar) {
        if (eVar == null || TextUtils.isEmpty(eVar.filePath)) {
            return false;
        }
        File file = new File(eVar.filePath);
        return file.exists() && file.isFile() && file.delete();
    }

    @AnyThread
    public static void aqf() {
        if (!cMu) {
            synchronized (a.class) {
                if (!cMu) {
                    cMu = true;
                    final File file = new File(AppRuntime.getAppContext().getFilesDir(), "aiapps_zip");
                    if (file.exists()) {
                        p.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.core.pms.f.a.1
                            @Override // java.lang.Runnable
                            public void run() {
                                com.baidu.swan.c.d.safeDeleteFile(file);
                            }
                        }, "deleteHistoryZipFile");
                    }
                }
            }
        }
    }
}
