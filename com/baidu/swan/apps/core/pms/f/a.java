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
/* loaded from: classes25.dex */
public final class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static boolean cTn = false;

    /* renamed from: com.baidu.swan.apps.core.pms.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    public static class C0439a {
        public int cTp = 0;
        public boolean cTq = false;
        public String cTr = "";
    }

    public static String ati() {
        return d.C0474d.ayU().getPath();
    }

    public static String atj() {
        return a.c.ayU().getPath();
    }

    public static String atk() {
        return d.C0474d.ayU().getPath();
    }

    public static String atc() {
        return d.C0474d.ayU().getPath();
    }

    public static String atl() {
        return a.c.ayU().getPath();
    }

    public static String atm() {
        return a.c.ayU().getPath();
    }

    public static com.baidu.swan.games.t.a.a k(String str, long j) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return com.baidu.swan.games.t.a.a.xW(com.baidu.swan.c.d.readFileData(new File(a.c.bT(str, String.valueOf(j)), "game.json")));
    }

    public static com.baidu.swan.apps.am.a a(ReadableByteChannel readableByteChannel, String str, com.baidu.swan.pms.a.d dVar) throws IOException {
        if (readableByteChannel == null) {
            com.baidu.swan.apps.am.a uC = new com.baidu.swan.apps.am.a().cU(11L).cV(2300L).uC("empty source");
            e.aOs().j(uC);
            if (DEBUG) {
                Log.i("PkgDownloadUtil", "checkPkgZipSign err: " + uC);
                return uC;
            }
            return uC;
        }
        dVar.bx("670", "aiapp_aps_check_sign_start_timestamp");
        dVar.bx("770", "na_pms_start_check_sign");
        if (ae.a(readableByteChannel, str, new com.baidu.swan.apps.ap.a.c())) {
            dVar.bx("670", "aiapp_aps_check_sign_end_timestamp");
            dVar.bx("770", "na_pms_end_check_sign");
            return null;
        }
        com.baidu.swan.apps.am.a uC2 = new com.baidu.swan.apps.am.a().cU(11L).cV(2300L).uC("check zip file sign fail.");
        e.aOs().j(uC2);
        if (DEBUG) {
            Log.i("PkgDownloadUtil", "checkPkgZipSign err: " + uC2);
            return uC2;
        }
        return uC2;
    }

    public static com.baidu.swan.apps.am.a a(com.baidu.swan.pms.model.e eVar, com.baidu.swan.pms.a.d dVar) {
        File bT;
        if (eVar == null) {
            com.baidu.swan.apps.am.a uC = new com.baidu.swan.apps.am.a().cU(11L).cV(2320L).uC("pkg info is empty");
            e.aOs().j(uC);
            return uC;
        }
        File file = new File(eVar.filePath);
        if (eVar.category == 1) {
            bT = a.c.bT(eVar.emZ, String.valueOf(eVar.versionCode));
        } else if (eVar.category == 0) {
            bT = d.C0474d.bT(eVar.emZ, String.valueOf(eVar.versionCode));
        } else {
            com.baidu.swan.apps.am.a uC2 = new com.baidu.swan.apps.am.a().cU(11L).cV(2320L).uC("pkh category illegal");
            e.aOs().j(uC2);
            return uC2;
        }
        if (!file.exists()) {
            com.baidu.swan.apps.am.a uC3 = new com.baidu.swan.apps.am.a().cU(11L).cV(2320L).uC("解压失败：包不存在");
            e.aOs().j(uC3);
            return uC3;
        } else if (bT.isFile() && !bT.delete()) {
            if (DEBUG) {
                Log.e("PkgDownloadUtil", "解压失败：解压目录被文件占用，且无法删除");
            }
            com.baidu.swan.apps.am.a uC4 = new com.baidu.swan.apps.am.a().cU(11L).cV(2320L).uC("解压失败：解压目录被文件占用，且无法删除");
            e.aOs().j(uC4);
            return uC4;
        } else if (!bT.exists() && !bT.mkdirs()) {
            if (DEBUG) {
                Log.e("PkgDownloadUtil", "解压失败：解压文件夹创建失败 " + bT.getAbsolutePath());
            }
            com.baidu.swan.apps.am.a uC5 = new com.baidu.swan.apps.am.a().cU(11L).cV(2320L).uC("解压失败：解压文件夹创建失败");
            e.aOs().j(uC5);
            return uC5;
        } else {
            if (DEBUG) {
                Log.i("PkgDownloadUtil", "开始执行解压操作, bundle:" + file.getPath() + " , folder:" + bT.getPath());
            }
            if (a(file, bT, dVar).cTq) {
                return null;
            }
            C0439a a2 = a(file, bT, dVar);
            if (a2.cTq) {
                f.a(dVar, eVar.category, true);
                return null;
            }
            f.a(dVar, eVar.category, false);
            com.baidu.swan.c.d.safeDeleteFile(bT);
            com.baidu.swan.apps.am.a aVar = new com.baidu.swan.apps.am.a();
            switch (a2.cTp) {
                case 0:
                    aVar.cU(11L).cV(2320L).uC("unzip failed");
                    break;
                case 1:
                case 2:
                    aVar.cU(11L).cV(2330L).uC("decryt failed:" + a2.cTr + ", PkgType=" + a2.cTp);
                    break;
                default:
                    aVar.cU(4L).cV(7L).uC("Unkown bundle type");
                    break;
            }
            e.aOs().j(aVar);
            return aVar;
        }
    }

    @NonNull
    private static C0439a a(@NonNull File file, @NonNull File file2, @NonNull com.baidu.swan.pms.a.d dVar) {
        int i;
        C0439a c0439a = new C0439a();
        long currentTimeMillis = System.currentTimeMillis();
        a.b A = com.baidu.swan.apps.r.a.a.A(file);
        if (A.type != -1) {
            dVar.bx("670", "package_start_decrypt");
            dVar.bx("770", "na_package_start_decrypt");
            a.C0473a a2 = com.baidu.swan.apps.r.a.a.a(A.dcK, file2, A.type);
            dVar.bx("670", "package_end_decrypt");
            dVar.bx("770", "na_package_end_decrypt");
            c0439a.cTq = a2.isSuccess;
            c0439a.cTr = a2.cTr;
            c0439a.cTp = A.type;
            i = A.type;
        } else {
            c0439a.cTp = 0;
            dVar.bx("670", "package_start_unzip");
            dVar.bx("770", "na_package_start_unzip");
            c0439a.cTq = com.baidu.swan.c.d.unzipFile(file.getPath(), file2.getPath());
            dVar.bx("670", "package_end_unzip");
            dVar.bx("770", "na_package_end_unzip");
            i = 0;
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        if (DEBUG) {
            com.baidu.swan.apps.r.a.a.jt((int) (currentTimeMillis2 - currentTimeMillis));
        }
        Bundle bundle = new Bundle();
        bundle.putInt("download_package_type_id", i);
        h.a(dVar, bundle, "event_download_package_type");
        return c0439a;
    }

    public static void g(@Nullable PMSAppInfo pMSAppInfo) {
        if (pMSAppInfo != null) {
            if (!TextUtils.isEmpty(pMSAppInfo.webViewDomains)) {
                com.baidu.swan.apps.ag.a.c.a(pMSAppInfo.appId, "", v.uQ(pMSAppInfo.webViewDomains));
            }
            if (!TextUtils.isEmpty(pMSAppInfo.webAction)) {
                com.baidu.swan.apps.ag.a.c.a("", v.uQ(pMSAppInfo.webAction));
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
            if (fVar.category == 1 && (k = k(fVar.emZ, fVar.versionCode)) != null) {
                pMSAppInfo.setOrientation(k.edA);
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
    public static void atn() {
        if (!cTn) {
            synchronized (a.class) {
                if (!cTn) {
                    cTn = true;
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
