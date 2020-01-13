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
/* loaded from: classes10.dex */
public final class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    /* renamed from: com.baidu.swan.apps.core.pms.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0241a {
        public int bmu = 0;
        public boolean bmv = false;
        public String bmw = "";
    }

    public static String Nr() {
        return e.d.RA().getPath();
    }

    public static String Ns() {
        return a.c.RA().getPath();
    }

    public static String Nt() {
        return e.d.RA().getPath();
    }

    public static String Nm() {
        return e.d.RA().getPath();
    }

    public static String Nu() {
        return a.c.RA().getPath();
    }

    public static String Nv() {
        return a.c.RA().getPath();
    }

    public static com.baidu.swan.games.s.a.a A(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return com.baidu.swan.games.s.a.a.pg(com.baidu.swan.d.c.readFileData(new File(a.c.aB(str, String.valueOf(i)), "game.json")));
    }

    public static com.baidu.swan.apps.ap.a a(ReadableByteChannel readableByteChannel, String str, d dVar) throws IOException {
        if (readableByteChannel == null) {
            com.baidu.swan.apps.ap.a mk = new com.baidu.swan.apps.ap.a().aE(11L).aF(2300L).mk("empty source");
            com.baidu.swan.apps.ap.e.adY().f(mk);
            if (DEBUG) {
                Log.i("PkgDownloadUtil", "checkPkgZipSign err: " + mk);
                return mk;
            }
            return mk;
        }
        dVar.am("670", "aiapp_aps_check_sign_start_timestamp");
        dVar.am("770", "na_pms_start_check_sign");
        if (ab.a(readableByteChannel, str, new com.baidu.swan.apps.as.a.c())) {
            dVar.am("670", "aiapp_aps_check_sign_end_timestamp");
            dVar.am("770", "na_pms_end_check_sign");
            return null;
        }
        com.baidu.swan.apps.ap.a mk2 = new com.baidu.swan.apps.ap.a().aE(11L).aF(2300L).mk("check zip file sign fail.");
        com.baidu.swan.apps.ap.e.adY().f(mk2);
        if (DEBUG) {
            Log.i("PkgDownloadUtil", "checkPkgZipSign err: " + mk2);
            return mk2;
        }
        return mk2;
    }

    public static com.baidu.swan.apps.ap.a b(com.baidu.swan.pms.model.e eVar) {
        String str;
        if (eVar == null) {
            com.baidu.swan.apps.ap.a mk = new com.baidu.swan.apps.ap.a().aE(11L).aF(2310L).mk("pkg info is empty");
            com.baidu.swan.apps.ap.e.adY().f(mk);
            return mk;
        }
        if (eVar.category == 0) {
            str = Nr() + File.separator + eVar.cwZ + ".aiapps";
        } else if (eVar.category == 1) {
            str = Ns() + File.separator + eVar.cwZ + ".aigames";
        } else {
            com.baidu.swan.apps.ap.a mk2 = new com.baidu.swan.apps.ap.a().aE(11L).aF(2310L).mk("pkh category illegal");
            com.baidu.swan.apps.ap.e.adY().f(mk2);
            return mk2;
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
        com.baidu.swan.apps.ap.a mk3 = new com.baidu.swan.apps.ap.a().aE(11L).aF(2310L).mk("rename zip fail");
        com.baidu.swan.apps.ap.e.adY().f(mk3);
        return mk3;
    }

    public static com.baidu.swan.apps.ap.a a(com.baidu.swan.pms.model.e eVar, d dVar) {
        File file;
        File aB;
        if (eVar == null) {
            com.baidu.swan.apps.ap.a mk = new com.baidu.swan.apps.ap.a().aE(11L).aF(2320L).mk("pkg info is empty");
            com.baidu.swan.apps.ap.e.adY().f(mk);
            return mk;
        }
        if (eVar.category == 1) {
            file = new File(Ns(), eVar.cwZ + ".aigames");
            aB = a.c.aB(eVar.cwZ, String.valueOf(eVar.versionCode));
        } else if (eVar.category == 0) {
            file = new File(Nr(), eVar.cwZ + ".aiapps");
            aB = e.d.aB(eVar.cwZ, String.valueOf(eVar.versionCode));
        } else {
            com.baidu.swan.apps.ap.a mk2 = new com.baidu.swan.apps.ap.a().aE(11L).aF(2320L).mk("pkh category illegal");
            com.baidu.swan.apps.ap.e.adY().f(mk2);
            return mk2;
        }
        if (!file.exists()) {
            com.baidu.swan.apps.ap.a mk3 = new com.baidu.swan.apps.ap.a().aE(11L).aF(2320L).mk("解压失败：包不存在");
            com.baidu.swan.apps.ap.e.adY().f(mk3);
            return mk3;
        } else if (aB.isFile() && !aB.delete()) {
            if (DEBUG) {
                Log.e("PkgDownloadUtil", "解压失败：解压目录被文件占用，且无法删除");
            }
            com.baidu.swan.apps.ap.a mk4 = new com.baidu.swan.apps.ap.a().aE(11L).aF(2320L).mk("解压失败：解压目录被文件占用，且无法删除");
            com.baidu.swan.apps.ap.e.adY().f(mk4);
            return mk4;
        } else if (!aB.exists() && !aB.mkdirs()) {
            if (DEBUG) {
                Log.e("PkgDownloadUtil", "解压失败：解压文件夹创建失败");
            }
            com.baidu.swan.apps.ap.a mk5 = new com.baidu.swan.apps.ap.a().aE(11L).aF(2320L).mk("解压失败：解压文件夹创建失败");
            com.baidu.swan.apps.ap.e.adY().f(mk5);
            return mk5;
        } else {
            if (DEBUG) {
                Log.i("PkgDownloadUtil", "开始执行解压操作, bundle:" + file.getPath() + " , folder:" + aB.getPath());
            }
            if (a(file, aB, dVar).bmv) {
                return null;
            }
            C0241a a = a(file, aB, dVar);
            if (a.bmv) {
                com.baidu.swan.apps.statistic.d.a(dVar, eVar.category, true);
                return null;
            }
            com.baidu.swan.apps.statistic.d.a(dVar, eVar.category, false);
            com.baidu.swan.d.c.safeDeleteFile(aB);
            com.baidu.swan.apps.ap.a aVar = new com.baidu.swan.apps.ap.a();
            switch (a.bmu) {
                case 0:
                    aVar.aE(11L).aF(2320L).mk("unzip failed");
                    break;
                case 1:
                case 2:
                    aVar.aE(11L).aF(2330L).mk("decryt failed:" + a.bmw + ", PkgType=" + a.bmu);
                    break;
                default:
                    aVar.aE(4L).aF(7L).mk("Unkown bundle type");
                    break;
            }
            com.baidu.swan.apps.ap.e.adY().f(aVar);
            return aVar;
        }
    }

    @NonNull
    private static C0241a a(@NonNull File file, @NonNull File file2, @NonNull d dVar) {
        int i;
        C0241a c0241a = new C0241a();
        long currentTimeMillis = System.currentTimeMillis();
        a.b q = com.baidu.swan.apps.t.a.a.q(file);
        if (q.type != -1) {
            dVar.am("670", "package_start_decrypt");
            dVar.am("770", "na_package_start_decrypt");
            a.C0291a a = com.baidu.swan.apps.t.a.a.a(q.btz, file2, q.type);
            dVar.am("670", "package_end_decrypt");
            dVar.am("770", "na_package_end_decrypt");
            c0241a.bmv = a.isSuccess;
            c0241a.bmw = a.bmw;
            c0241a.bmu = q.type;
            i = q.type;
        } else {
            c0241a.bmu = 0;
            dVar.am("670", "package_start_unzip");
            dVar.am("770", "na_package_start_unzip");
            c0241a.bmv = com.baidu.swan.d.c.unzipFile(file.getPath(), file2.getPath());
            dVar.am("670", "package_end_unzip");
            dVar.am("770", "na_package_end_unzip");
            i = 0;
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        if (DEBUG) {
            com.baidu.swan.apps.t.a.a.eO((int) (currentTimeMillis2 - currentTimeMillis));
        }
        Bundle bundle = new Bundle();
        bundle.putInt("download_package_type_id", i);
        h.a(dVar, bundle, "event_download_package_type");
        return c0241a;
    }

    public static void d(PMSAppInfo pMSAppInfo) {
        if (pMSAppInfo != null) {
            if (!TextUtils.isEmpty(pMSAppInfo.webViewDomains)) {
                com.baidu.swan.apps.aj.a.c.a(pMSAppInfo.appId, "", s.mx(pMSAppInfo.webViewDomains));
            }
            if (!TextUtils.isEmpty(pMSAppInfo.webAction)) {
                com.baidu.swan.apps.aj.a.c.a("", s.mx(pMSAppInfo.webAction));
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
            if (fVar.category == 1 && (A = A(fVar.cwZ, fVar.versionCode)) != null) {
                pMSAppInfo.setOrientation(A.cnb);
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
