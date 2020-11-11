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
/* loaded from: classes10.dex */
public final class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static boolean cOe = false;

    /* renamed from: com.baidu.swan.apps.core.pms.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0429a {
        public int cOg = 0;
        public boolean cOh = false;
        public String cOi = "";
    }

    public static String aqI() {
        return d.C0464d.awu().getPath();
    }

    public static String aqJ() {
        return a.c.awu().getPath();
    }

    public static String aqK() {
        return d.C0464d.awu().getPath();
    }

    public static String aqC() {
        return d.C0464d.awu().getPath();
    }

    public static String aqL() {
        return a.c.awu().getPath();
    }

    public static String aqM() {
        return a.c.awu().getPath();
    }

    public static com.baidu.swan.games.t.a.a k(String str, long j) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return com.baidu.swan.games.t.a.a.xu(com.baidu.swan.c.d.readFileData(new File(a.c.bN(str, String.valueOf(j)), "game.json")));
    }

    public static com.baidu.swan.apps.am.a a(ReadableByteChannel readableByteChannel, String str, com.baidu.swan.pms.a.d dVar) throws IOException {
        if (readableByteChannel == null) {
            com.baidu.swan.apps.am.a ua = new com.baidu.swan.apps.am.a().cv(11L).cw(2300L).ua("empty source");
            e.aLT().j(ua);
            if (DEBUG) {
                Log.i("PkgDownloadUtil", "checkPkgZipSign err: " + ua);
                return ua;
            }
            return ua;
        }
        dVar.br("670", "aiapp_aps_check_sign_start_timestamp");
        dVar.br("770", "na_pms_start_check_sign");
        if (ae.a(readableByteChannel, str, new com.baidu.swan.apps.ap.a.c())) {
            dVar.br("670", "aiapp_aps_check_sign_end_timestamp");
            dVar.br("770", "na_pms_end_check_sign");
            return null;
        }
        com.baidu.swan.apps.am.a ua2 = new com.baidu.swan.apps.am.a().cv(11L).cw(2300L).ua("check zip file sign fail.");
        e.aLT().j(ua2);
        if (DEBUG) {
            Log.i("PkgDownloadUtil", "checkPkgZipSign err: " + ua2);
            return ua2;
        }
        return ua2;
    }

    public static com.baidu.swan.apps.am.a a(com.baidu.swan.pms.model.e eVar, com.baidu.swan.pms.a.d dVar) {
        File bN;
        if (eVar == null) {
            com.baidu.swan.apps.am.a ua = new com.baidu.swan.apps.am.a().cv(11L).cw(2320L).ua("pkg info is empty");
            e.aLT().j(ua);
            return ua;
        }
        File file = new File(eVar.filePath);
        if (eVar.category == 1) {
            bN = a.c.bN(eVar.ehG, String.valueOf(eVar.versionCode));
        } else if (eVar.category == 0) {
            bN = d.C0464d.bN(eVar.ehG, String.valueOf(eVar.versionCode));
        } else {
            com.baidu.swan.apps.am.a ua2 = new com.baidu.swan.apps.am.a().cv(11L).cw(2320L).ua("pkh category illegal");
            e.aLT().j(ua2);
            return ua2;
        }
        if (!file.exists()) {
            com.baidu.swan.apps.am.a ua3 = new com.baidu.swan.apps.am.a().cv(11L).cw(2320L).ua("解压失败：包不存在");
            e.aLT().j(ua3);
            return ua3;
        } else if (bN.isFile() && !bN.delete()) {
            if (DEBUG) {
                Log.e("PkgDownloadUtil", "解压失败：解压目录被文件占用，且无法删除");
            }
            com.baidu.swan.apps.am.a ua4 = new com.baidu.swan.apps.am.a().cv(11L).cw(2320L).ua("解压失败：解压目录被文件占用，且无法删除");
            e.aLT().j(ua4);
            return ua4;
        } else if (!bN.exists() && !bN.mkdirs()) {
            if (DEBUG) {
                Log.e("PkgDownloadUtil", "解压失败：解压文件夹创建失败 " + bN.getAbsolutePath());
            }
            com.baidu.swan.apps.am.a ua5 = new com.baidu.swan.apps.am.a().cv(11L).cw(2320L).ua("解压失败：解压文件夹创建失败");
            e.aLT().j(ua5);
            return ua5;
        } else {
            if (DEBUG) {
                Log.i("PkgDownloadUtil", "开始执行解压操作, bundle:" + file.getPath() + " , folder:" + bN.getPath());
            }
            if (a(file, bN, dVar).cOh) {
                return null;
            }
            C0429a a2 = a(file, bN, dVar);
            if (a2.cOh) {
                f.a(dVar, eVar.category, true);
                return null;
            }
            f.a(dVar, eVar.category, false);
            com.baidu.swan.c.d.safeDeleteFile(bN);
            com.baidu.swan.apps.am.a aVar = new com.baidu.swan.apps.am.a();
            switch (a2.cOg) {
                case 0:
                    aVar.cv(11L).cw(2320L).ua("unzip failed");
                    break;
                case 1:
                case 2:
                    aVar.cv(11L).cw(2330L).ua("decryt failed:" + a2.cOi + ", PkgType=" + a2.cOg);
                    break;
                default:
                    aVar.cv(4L).cw(7L).ua("Unkown bundle type");
                    break;
            }
            e.aLT().j(aVar);
            return aVar;
        }
    }

    @NonNull
    private static C0429a a(@NonNull File file, @NonNull File file2, @NonNull com.baidu.swan.pms.a.d dVar) {
        int i;
        C0429a c0429a = new C0429a();
        long currentTimeMillis = System.currentTimeMillis();
        a.b B = com.baidu.swan.apps.r.a.a.B(file);
        if (B.type != -1) {
            dVar.br("670", "package_start_decrypt");
            dVar.br("770", "na_package_start_decrypt");
            a.C0463a a2 = com.baidu.swan.apps.r.a.a.a(B.cXx, file2, B.type);
            dVar.br("670", "package_end_decrypt");
            dVar.br("770", "na_package_end_decrypt");
            c0429a.cOh = a2.isSuccess;
            c0429a.cOi = a2.cOi;
            c0429a.cOg = B.type;
            i = B.type;
        } else {
            c0429a.cOg = 0;
            dVar.br("670", "package_start_unzip");
            dVar.br("770", "na_package_start_unzip");
            c0429a.cOh = com.baidu.swan.c.d.unzipFile(file.getPath(), file2.getPath());
            dVar.br("670", "package_end_unzip");
            dVar.br("770", "na_package_end_unzip");
            i = 0;
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        if (DEBUG) {
            com.baidu.swan.apps.r.a.a.iZ((int) (currentTimeMillis2 - currentTimeMillis));
        }
        Bundle bundle = new Bundle();
        bundle.putInt("download_package_type_id", i);
        h.a(dVar, bundle, "event_download_package_type");
        return c0429a;
    }

    public static void g(@Nullable PMSAppInfo pMSAppInfo) {
        if (pMSAppInfo != null) {
            if (!TextUtils.isEmpty(pMSAppInfo.webViewDomains)) {
                com.baidu.swan.apps.ag.a.c.a(pMSAppInfo.appId, "", v.uo(pMSAppInfo.webViewDomains));
            }
            if (!TextUtils.isEmpty(pMSAppInfo.webAction)) {
                com.baidu.swan.apps.ag.a.c.a("", v.uo(pMSAppInfo.webAction));
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
            if (fVar.category == 1 && (k = k(fVar.ehG, fVar.versionCode)) != null) {
                pMSAppInfo.setOrientation(k.dYj);
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
    public static void aqN() {
        if (!cOe) {
            synchronized (a.class) {
                if (!cOe) {
                    cOe = true;
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
