package com.baidu.swan.apps.core.pms.d;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.as.ab;
import com.baidu.swan.apps.as.s;
import com.baidu.swan.apps.t.a.a;
import com.baidu.swan.apps.t.e;
import com.baidu.swan.games.k.a;
import com.baidu.swan.pms.a.d;
import com.baidu.swan.pms.a.h;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.swan.pms.model.f;
import com.baidu.swan.pms.model.g;
import java.io.File;
import java.io.IOException;
import java.nio.channels.ReadableByteChannel;
/* loaded from: classes9.dex */
public final class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    /* renamed from: com.baidu.swan.apps.core.pms.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C0239a {
        public int blE = 0;
        public boolean blF = false;
        public String blG = "";
    }

    public static String MV() {
        return e.d.Re().getPath();
    }

    public static String MW() {
        return a.c.Re().getPath();
    }

    public static String MX() {
        return e.d.Re().getPath();
    }

    public static String MQ() {
        return e.d.Re().getPath();
    }

    public static String MY() {
        return a.c.Re().getPath();
    }

    public static String MZ() {
        return a.c.Re().getPath();
    }

    public static com.baidu.swan.games.s.a.a A(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return com.baidu.swan.games.s.a.a.pd(com.baidu.swan.d.c.readFileData(new File(a.c.aA(str, String.valueOf(i)), "game.json")));
    }

    public static com.baidu.swan.apps.ap.a a(ReadableByteChannel readableByteChannel, String str, d dVar) throws IOException {
        if (readableByteChannel == null) {
            com.baidu.swan.apps.ap.a mh = new com.baidu.swan.apps.ap.a().aB(11L).aC(2300L).mh("empty source");
            com.baidu.swan.apps.ap.e.adF().f(mh);
            if (DEBUG) {
                Log.i("PkgDownloadUtil", "checkPkgZipSign err: " + mh);
                return mh;
            }
            return mh;
        }
        dVar.al("670", "aiapp_aps_check_sign_start_timestamp");
        dVar.al("770", "na_pms_start_check_sign");
        if (ab.a(readableByteChannel, str, new com.baidu.swan.apps.as.a.c())) {
            dVar.al("670", "aiapp_aps_check_sign_end_timestamp");
            dVar.al("770", "na_pms_end_check_sign");
            return null;
        }
        com.baidu.swan.apps.ap.a mh2 = new com.baidu.swan.apps.ap.a().aB(11L).aC(2300L).mh("check zip file sign fail.");
        com.baidu.swan.apps.ap.e.adF().f(mh2);
        if (DEBUG) {
            Log.i("PkgDownloadUtil", "checkPkgZipSign err: " + mh2);
            return mh2;
        }
        return mh2;
    }

    public static com.baidu.swan.apps.ap.a b(com.baidu.swan.pms.model.e eVar) {
        String str;
        if (eVar == null) {
            com.baidu.swan.apps.ap.a mh = new com.baidu.swan.apps.ap.a().aB(11L).aC(2310L).mh("pkg info is empty");
            com.baidu.swan.apps.ap.e.adF().f(mh);
            return mh;
        }
        if (eVar.category == 0) {
            str = MV() + File.separator + eVar.cwO + ".aiapps";
        } else if (eVar.category == 1) {
            str = MW() + File.separator + eVar.cwO + ".aigames";
        } else {
            com.baidu.swan.apps.ap.a mh2 = new com.baidu.swan.apps.ap.a().aB(11L).aC(2310L).mh("pkh category illegal");
            com.baidu.swan.apps.ap.e.adF().f(mh2);
            return mh2;
        }
        com.baidu.swan.d.c.deleteFile(str);
        File file = new File(str);
        File file2 = new File(eVar.filePath);
        if (file2.renameTo(file)) {
            if (DEBUG) {
                Log.i("PkgDownloadUtil", "重命名成功,from:" + file2.getPath() + " to:" + file.getPath());
            }
            return null;
        }
        com.baidu.swan.d.c.deleteFile(file2);
        com.baidu.swan.apps.ap.a mh3 = new com.baidu.swan.apps.ap.a().aB(11L).aC(2310L).mh("rename zip fail");
        com.baidu.swan.apps.ap.e.adF().f(mh3);
        return mh3;
    }

    public static com.baidu.swan.apps.ap.a a(com.baidu.swan.pms.model.e eVar, d dVar) {
        File file;
        File aA;
        if (eVar == null) {
            com.baidu.swan.apps.ap.a mh = new com.baidu.swan.apps.ap.a().aB(11L).aC(2320L).mh("pkg info is empty");
            com.baidu.swan.apps.ap.e.adF().f(mh);
            return mh;
        }
        if (eVar.category == 1) {
            file = new File(MW(), eVar.cwO + ".aigames");
            aA = a.c.aA(eVar.cwO, String.valueOf(eVar.versionCode));
        } else if (eVar.category == 0) {
            file = new File(MV(), eVar.cwO + ".aiapps");
            aA = e.d.aA(eVar.cwO, String.valueOf(eVar.versionCode));
        } else {
            com.baidu.swan.apps.ap.a mh2 = new com.baidu.swan.apps.ap.a().aB(11L).aC(2320L).mh("pkh category illegal");
            com.baidu.swan.apps.ap.e.adF().f(mh2);
            return mh2;
        }
        if (!file.exists()) {
            com.baidu.swan.apps.ap.a mh3 = new com.baidu.swan.apps.ap.a().aB(11L).aC(2320L).mh("解压失败：包不存在");
            com.baidu.swan.apps.ap.e.adF().f(mh3);
            return mh3;
        } else if (aA.isFile() && !aA.delete()) {
            if (DEBUG) {
                Log.e("PkgDownloadUtil", "解压失败：解压目录被文件占用，且无法删除");
            }
            com.baidu.swan.apps.ap.a mh4 = new com.baidu.swan.apps.ap.a().aB(11L).aC(2320L).mh("解压失败：解压目录被文件占用，且无法删除");
            com.baidu.swan.apps.ap.e.adF().f(mh4);
            return mh4;
        } else if (!aA.exists() && !aA.mkdirs()) {
            if (DEBUG) {
                Log.e("PkgDownloadUtil", "解压失败：解压文件夹创建失败");
            }
            com.baidu.swan.apps.ap.a mh5 = new com.baidu.swan.apps.ap.a().aB(11L).aC(2320L).mh("解压失败：解压文件夹创建失败");
            com.baidu.swan.apps.ap.e.adF().f(mh5);
            return mh5;
        } else {
            if (DEBUG) {
                Log.i("PkgDownloadUtil", "开始执行解压操作, bundle:" + file.getPath() + " , folder:" + aA.getPath());
            }
            if (a(file, aA, dVar).blF) {
                return null;
            }
            C0239a a = a(file, aA, dVar);
            if (a.blF) {
                com.baidu.swan.apps.statistic.d.a(dVar, eVar.category, true);
                return null;
            }
            com.baidu.swan.apps.statistic.d.a(dVar, eVar.category, false);
            com.baidu.swan.d.c.safeDeleteFile(aA);
            com.baidu.swan.apps.ap.a aVar = new com.baidu.swan.apps.ap.a();
            switch (a.blE) {
                case 0:
                    aVar.aB(11L).aC(2320L).mh("unzip failed");
                    break;
                case 1:
                case 2:
                    aVar.aB(11L).aC(2330L).mh("decryt failed:" + a.blG + ", PkgType=" + a.blE);
                    break;
                default:
                    aVar.aB(4L).aC(7L).mh("Unkown bundle type");
                    break;
            }
            com.baidu.swan.apps.ap.e.adF().f(aVar);
            return aVar;
        }
    }

    @NonNull
    private static C0239a a(@NonNull File file, @NonNull File file2, @NonNull d dVar) {
        int i;
        C0239a c0239a = new C0239a();
        long currentTimeMillis = System.currentTimeMillis();
        a.b q = com.baidu.swan.apps.t.a.a.q(file);
        if (q.type != -1) {
            dVar.al("670", "package_start_decrypt");
            dVar.al("770", "na_package_start_decrypt");
            a.C0289a a = com.baidu.swan.apps.t.a.a.a(q.bsL, file2, q.type);
            dVar.al("670", "package_end_decrypt");
            dVar.al("770", "na_package_end_decrypt");
            c0239a.blF = a.isSuccess;
            c0239a.blG = a.blG;
            c0239a.blE = q.type;
            i = q.type;
        } else {
            c0239a.blE = 0;
            dVar.al("670", "package_start_unzip");
            dVar.al("770", "na_package_start_unzip");
            c0239a.blF = com.baidu.swan.d.c.unzipFile(file.getPath(), file2.getPath());
            dVar.al("670", "package_end_unzip");
            dVar.al("770", "na_package_end_unzip");
            i = 0;
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        if (DEBUG) {
            com.baidu.swan.apps.t.a.a.eN((int) (currentTimeMillis2 - currentTimeMillis));
        }
        Bundle bundle = new Bundle();
        bundle.putInt("download_package_type_id", i);
        h.a(dVar, bundle, "event_download_package_type");
        return c0239a;
    }

    public static void d(PMSAppInfo pMSAppInfo) {
        if (pMSAppInfo != null) {
            if (!TextUtils.isEmpty(pMSAppInfo.webViewDomains)) {
                com.baidu.swan.apps.aj.a.c.a(pMSAppInfo.appId, "", s.mu(pMSAppInfo.webViewDomains));
            }
            if (!TextUtils.isEmpty(pMSAppInfo.webAction)) {
                com.baidu.swan.apps.aj.a.c.a("", s.mu(pMSAppInfo.webAction));
            }
            if (!TextUtils.isEmpty(pMSAppInfo.domains)) {
                com.baidu.swan.apps.aj.a.c.f(pMSAppInfo.appId, s.parseString(pMSAppInfo.domains));
            }
        }
    }

    public static void a(PMSAppInfo pMSAppInfo, f fVar) {
        com.baidu.swan.games.s.a.a A;
        if (pMSAppInfo != null && fVar != null) {
            pMSAppInfo.h(fVar);
            if (fVar.category == 1 && (A = A(fVar.cwO, fVar.versionCode)) != null) {
                pMSAppInfo.setOrientation(A.cmO);
            } else {
                pMSAppInfo.setOrientation(0);
            }
        }
    }

    public static void a(PMSAppInfo pMSAppInfo, g gVar) {
        if (pMSAppInfo != null && gVar != null) {
            pMSAppInfo.l(gVar);
            if (gVar.category == 0) {
                pMSAppInfo.setOrientation(0);
            }
        }
    }
}
