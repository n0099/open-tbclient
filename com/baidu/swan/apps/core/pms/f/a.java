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
    private static boolean cIl = false;

    /* renamed from: com.baidu.swan.apps.core.pms.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0417a {
        public int cIn = 0;
        public boolean cIo = false;
        public String cIp = "";
    }

    public static String aoh() {
        return d.C0452d.atU().getPath();
    }

    public static String aoi() {
        return a.c.atU().getPath();
    }

    public static String aoj() {
        return d.C0452d.atU().getPath();
    }

    public static String aob() {
        return d.C0452d.atU().getPath();
    }

    public static String aok() {
        return a.c.atU().getPath();
    }

    public static String aol() {
        return a.c.atU().getPath();
    }

    public static com.baidu.swan.games.t.a.a k(String str, long j) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return com.baidu.swan.games.t.a.a.xg(com.baidu.swan.c.d.readFileData(new File(a.c.bN(str, String.valueOf(j)), "game.json")));
    }

    public static com.baidu.swan.apps.am.a a(ReadableByteChannel readableByteChannel, String str, com.baidu.swan.pms.a.d dVar) throws IOException {
        if (readableByteChannel == null) {
            com.baidu.swan.apps.am.a tM = new com.baidu.swan.apps.am.a().bZ(11L).ca(2300L).tM("empty source");
            e.aJt().j(tM);
            if (DEBUG) {
                Log.i("PkgDownloadUtil", "checkPkgZipSign err: " + tM);
                return tM;
            }
            return tM;
        }
        dVar.br("670", "aiapp_aps_check_sign_start_timestamp");
        dVar.br("770", "na_pms_start_check_sign");
        if (ae.a(readableByteChannel, str, new com.baidu.swan.apps.ap.a.c())) {
            dVar.br("670", "aiapp_aps_check_sign_end_timestamp");
            dVar.br("770", "na_pms_end_check_sign");
            return null;
        }
        com.baidu.swan.apps.am.a tM2 = new com.baidu.swan.apps.am.a().bZ(11L).ca(2300L).tM("check zip file sign fail.");
        e.aJt().j(tM2);
        if (DEBUG) {
            Log.i("PkgDownloadUtil", "checkPkgZipSign err: " + tM2);
            return tM2;
        }
        return tM2;
    }

    public static com.baidu.swan.apps.am.a a(com.baidu.swan.pms.model.e eVar, com.baidu.swan.pms.a.d dVar) {
        File bN;
        if (eVar == null) {
            com.baidu.swan.apps.am.a tM = new com.baidu.swan.apps.am.a().bZ(11L).ca(2320L).tM("pkg info is empty");
            e.aJt().j(tM);
            return tM;
        }
        File file = new File(eVar.filePath);
        if (eVar.category == 1) {
            bN = a.c.bN(eVar.ebO, String.valueOf(eVar.versionCode));
        } else if (eVar.category == 0) {
            bN = d.C0452d.bN(eVar.ebO, String.valueOf(eVar.versionCode));
        } else {
            com.baidu.swan.apps.am.a tM2 = new com.baidu.swan.apps.am.a().bZ(11L).ca(2320L).tM("pkh category illegal");
            e.aJt().j(tM2);
            return tM2;
        }
        if (!file.exists()) {
            com.baidu.swan.apps.am.a tM3 = new com.baidu.swan.apps.am.a().bZ(11L).ca(2320L).tM("解压失败：包不存在");
            e.aJt().j(tM3);
            return tM3;
        } else if (bN.isFile() && !bN.delete()) {
            if (DEBUG) {
                Log.e("PkgDownloadUtil", "解压失败：解压目录被文件占用，且无法删除");
            }
            com.baidu.swan.apps.am.a tM4 = new com.baidu.swan.apps.am.a().bZ(11L).ca(2320L).tM("解压失败：解压目录被文件占用，且无法删除");
            e.aJt().j(tM4);
            return tM4;
        } else if (!bN.exists() && !bN.mkdirs()) {
            if (DEBUG) {
                Log.e("PkgDownloadUtil", "解压失败：解压文件夹创建失败 " + bN.getAbsolutePath());
            }
            com.baidu.swan.apps.am.a tM5 = new com.baidu.swan.apps.am.a().bZ(11L).ca(2320L).tM("解压失败：解压文件夹创建失败");
            e.aJt().j(tM5);
            return tM5;
        } else {
            if (DEBUG) {
                Log.i("PkgDownloadUtil", "开始执行解压操作, bundle:" + file.getPath() + " , folder:" + bN.getPath());
            }
            if (a(file, bN, dVar).cIo) {
                return null;
            }
            C0417a a2 = a(file, bN, dVar);
            if (a2.cIo) {
                f.a(dVar, eVar.category, true);
                return null;
            }
            f.a(dVar, eVar.category, false);
            com.baidu.swan.c.d.safeDeleteFile(bN);
            com.baidu.swan.apps.am.a aVar = new com.baidu.swan.apps.am.a();
            switch (a2.cIn) {
                case 0:
                    aVar.bZ(11L).ca(2320L).tM("unzip failed");
                    break;
                case 1:
                case 2:
                    aVar.bZ(11L).ca(2330L).tM("decryt failed:" + a2.cIp + ", PkgType=" + a2.cIn);
                    break;
                default:
                    aVar.bZ(4L).ca(7L).tM("Unkown bundle type");
                    break;
            }
            e.aJt().j(aVar);
            return aVar;
        }
    }

    @NonNull
    private static C0417a a(@NonNull File file, @NonNull File file2, @NonNull com.baidu.swan.pms.a.d dVar) {
        int i;
        C0417a c0417a = new C0417a();
        long currentTimeMillis = System.currentTimeMillis();
        a.b B = com.baidu.swan.apps.r.a.a.B(file);
        if (B.type != -1) {
            dVar.br("670", "package_start_decrypt");
            dVar.br("770", "na_package_start_decrypt");
            a.C0451a a2 = com.baidu.swan.apps.r.a.a.a(B.cRE, file2, B.type);
            dVar.br("670", "package_end_decrypt");
            dVar.br("770", "na_package_end_decrypt");
            c0417a.cIo = a2.isSuccess;
            c0417a.cIp = a2.cIp;
            c0417a.cIn = B.type;
            i = B.type;
        } else {
            c0417a.cIn = 0;
            dVar.br("670", "package_start_unzip");
            dVar.br("770", "na_package_start_unzip");
            c0417a.cIo = com.baidu.swan.c.d.unzipFile(file.getPath(), file2.getPath());
            dVar.br("670", "package_end_unzip");
            dVar.br("770", "na_package_end_unzip");
            i = 0;
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        if (DEBUG) {
            com.baidu.swan.apps.r.a.a.iP((int) (currentTimeMillis2 - currentTimeMillis));
        }
        Bundle bundle = new Bundle();
        bundle.putInt("download_package_type_id", i);
        h.a(dVar, bundle, "event_download_package_type");
        return c0417a;
    }

    public static void g(@Nullable PMSAppInfo pMSAppInfo) {
        if (pMSAppInfo != null) {
            if (!TextUtils.isEmpty(pMSAppInfo.webViewDomains)) {
                com.baidu.swan.apps.ag.a.c.a(pMSAppInfo.appId, "", v.ua(pMSAppInfo.webViewDomains));
            }
            if (!TextUtils.isEmpty(pMSAppInfo.webAction)) {
                com.baidu.swan.apps.ag.a.c.a("", v.ua(pMSAppInfo.webAction));
            }
            if (!TextUtils.isEmpty(pMSAppInfo.domains)) {
                com.baidu.swan.apps.ag.a.c.g(pMSAppInfo.appId, v.parseString(pMSAppInfo.domains));
            }
        }
    }

    public static void a(PMSAppInfo pMSAppInfo, com.baidu.swan.pms.model.f fVar) {
        com.baidu.swan.games.t.a.a k;
        if (pMSAppInfo != null && fVar != null) {
            pMSAppInfo.h(fVar);
            if (fVar.category == 1 && (k = k(fVar.ebO, fVar.versionCode)) != null) {
                pMSAppInfo.setOrientation(k.dSr);
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
    public static void aom() {
        if (!cIl) {
            synchronized (a.class) {
                if (!cIl) {
                    cIl = true;
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
