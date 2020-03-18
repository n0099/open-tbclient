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
/* loaded from: classes11.dex */
public final class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    /* renamed from: com.baidu.swan.apps.core.pms.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0251a {
        public int bqR = 0;
        public boolean bqS = false;
        public String bqT = "";
    }

    public static String PK() {
        return e.d.TT().getPath();
    }

    public static String PL() {
        return a.c.TT().getPath();
    }

    public static String PM() {
        return e.d.TT().getPath();
    }

    public static String PF() {
        return e.d.TT().getPath();
    }

    public static String PN() {
        return a.c.TT().getPath();
    }

    public static String PO() {
        return a.c.TT().getPath();
    }

    public static com.baidu.swan.games.s.a.a y(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return com.baidu.swan.games.s.a.a.pu(com.baidu.swan.d.c.readFileData(new File(a.c.aK(str, String.valueOf(i)), "game.json")));
    }

    public static com.baidu.swan.apps.ap.a a(ReadableByteChannel readableByteChannel, String str, d dVar) throws IOException {
        if (readableByteChannel == null) {
            com.baidu.swan.apps.ap.a my = new com.baidu.swan.apps.ap.a().aI(11L).aJ(2300L).my("empty source");
            com.baidu.swan.apps.ap.e.agr().f(my);
            if (DEBUG) {
                Log.i("PkgDownloadUtil", "checkPkgZipSign err: " + my);
                return my;
            }
            return my;
        }
        dVar.av("670", "aiapp_aps_check_sign_start_timestamp");
        dVar.av("770", "na_pms_start_check_sign");
        if (ab.a(readableByteChannel, str, new com.baidu.swan.apps.as.a.c())) {
            dVar.av("670", "aiapp_aps_check_sign_end_timestamp");
            dVar.av("770", "na_pms_end_check_sign");
            return null;
        }
        com.baidu.swan.apps.ap.a my2 = new com.baidu.swan.apps.ap.a().aI(11L).aJ(2300L).my("check zip file sign fail.");
        com.baidu.swan.apps.ap.e.agr().f(my2);
        if (DEBUG) {
            Log.i("PkgDownloadUtil", "checkPkgZipSign err: " + my2);
            return my2;
        }
        return my2;
    }

    public static com.baidu.swan.apps.ap.a b(com.baidu.swan.pms.model.e eVar) {
        String str;
        if (eVar == null) {
            com.baidu.swan.apps.ap.a my = new com.baidu.swan.apps.ap.a().aI(11L).aJ(2310L).my("pkg info is empty");
            com.baidu.swan.apps.ap.e.agr().f(my);
            return my;
        }
        if (eVar.category == 0) {
            str = PK() + File.separator + eVar.cBk + ".aiapps";
        } else if (eVar.category == 1) {
            str = PL() + File.separator + eVar.cBk + ".aigames";
        } else {
            com.baidu.swan.apps.ap.a my2 = new com.baidu.swan.apps.ap.a().aI(11L).aJ(2310L).my("pkh category illegal");
            com.baidu.swan.apps.ap.e.agr().f(my2);
            return my2;
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
        com.baidu.swan.apps.ap.a my3 = new com.baidu.swan.apps.ap.a().aI(11L).aJ(2310L).my("rename zip fail");
        com.baidu.swan.apps.ap.e.agr().f(my3);
        return my3;
    }

    public static com.baidu.swan.apps.ap.a a(com.baidu.swan.pms.model.e eVar, d dVar) {
        File file;
        File aK;
        if (eVar == null) {
            com.baidu.swan.apps.ap.a my = new com.baidu.swan.apps.ap.a().aI(11L).aJ(2320L).my("pkg info is empty");
            com.baidu.swan.apps.ap.e.agr().f(my);
            return my;
        }
        if (eVar.category == 1) {
            file = new File(PL(), eVar.cBk + ".aigames");
            aK = a.c.aK(eVar.cBk, String.valueOf(eVar.versionCode));
        } else if (eVar.category == 0) {
            file = new File(PK(), eVar.cBk + ".aiapps");
            aK = e.d.aK(eVar.cBk, String.valueOf(eVar.versionCode));
        } else {
            com.baidu.swan.apps.ap.a my2 = new com.baidu.swan.apps.ap.a().aI(11L).aJ(2320L).my("pkh category illegal");
            com.baidu.swan.apps.ap.e.agr().f(my2);
            return my2;
        }
        if (!file.exists()) {
            com.baidu.swan.apps.ap.a my3 = new com.baidu.swan.apps.ap.a().aI(11L).aJ(2320L).my("解压失败：包不存在");
            com.baidu.swan.apps.ap.e.agr().f(my3);
            return my3;
        } else if (aK.isFile() && !aK.delete()) {
            if (DEBUG) {
                Log.e("PkgDownloadUtil", "解压失败：解压目录被文件占用，且无法删除");
            }
            com.baidu.swan.apps.ap.a my4 = new com.baidu.swan.apps.ap.a().aI(11L).aJ(2320L).my("解压失败：解压目录被文件占用，且无法删除");
            com.baidu.swan.apps.ap.e.agr().f(my4);
            return my4;
        } else if (!aK.exists() && !aK.mkdirs()) {
            if (DEBUG) {
                Log.e("PkgDownloadUtil", "解压失败：解压文件夹创建失败");
            }
            com.baidu.swan.apps.ap.a my5 = new com.baidu.swan.apps.ap.a().aI(11L).aJ(2320L).my("解压失败：解压文件夹创建失败");
            com.baidu.swan.apps.ap.e.agr().f(my5);
            return my5;
        } else {
            if (DEBUG) {
                Log.i("PkgDownloadUtil", "开始执行解压操作, bundle:" + file.getPath() + " , folder:" + aK.getPath());
            }
            if (a(file, aK, dVar).bqS) {
                return null;
            }
            C0251a a = a(file, aK, dVar);
            if (a.bqS) {
                com.baidu.swan.apps.statistic.d.a(dVar, eVar.category, true);
                return null;
            }
            com.baidu.swan.apps.statistic.d.a(dVar, eVar.category, false);
            com.baidu.swan.d.c.safeDeleteFile(aK);
            com.baidu.swan.apps.ap.a aVar = new com.baidu.swan.apps.ap.a();
            switch (a.bqR) {
                case 0:
                    aVar.aI(11L).aJ(2320L).my("unzip failed");
                    break;
                case 1:
                case 2:
                    aVar.aI(11L).aJ(2330L).my("decryt failed:" + a.bqT + ", PkgType=" + a.bqR);
                    break;
                default:
                    aVar.aI(4L).aJ(7L).my("Unkown bundle type");
                    break;
            }
            com.baidu.swan.apps.ap.e.agr().f(aVar);
            return aVar;
        }
    }

    @NonNull
    private static C0251a a(@NonNull File file, @NonNull File file2, @NonNull d dVar) {
        int i;
        C0251a c0251a = new C0251a();
        long currentTimeMillis = System.currentTimeMillis();
        a.b r = com.baidu.swan.apps.t.a.a.r(file);
        if (r.type != -1) {
            dVar.av("670", "package_start_decrypt");
            dVar.av("770", "na_package_start_decrypt");
            a.C0301a a = com.baidu.swan.apps.t.a.a.a(r.bxW, file2, r.type);
            dVar.av("670", "package_end_decrypt");
            dVar.av("770", "na_package_end_decrypt");
            c0251a.bqS = a.isSuccess;
            c0251a.bqT = a.bqT;
            c0251a.bqR = r.type;
            i = r.type;
        } else {
            c0251a.bqR = 0;
            dVar.av("670", "package_start_unzip");
            dVar.av("770", "na_package_start_unzip");
            c0251a.bqS = com.baidu.swan.d.c.unzipFile(file.getPath(), file2.getPath());
            dVar.av("670", "package_end_unzip");
            dVar.av("770", "na_package_end_unzip");
            i = 0;
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        if (DEBUG) {
            com.baidu.swan.apps.t.a.a.fe((int) (currentTimeMillis2 - currentTimeMillis));
        }
        Bundle bundle = new Bundle();
        bundle.putInt("download_package_type_id", i);
        h.a(dVar, bundle, "event_download_package_type");
        return c0251a;
    }

    public static void d(PMSAppInfo pMSAppInfo) {
        if (pMSAppInfo != null) {
            if (!TextUtils.isEmpty(pMSAppInfo.webViewDomains)) {
                com.baidu.swan.apps.aj.a.c.a(pMSAppInfo.appId, "", s.mL(pMSAppInfo.webViewDomains));
            }
            if (!TextUtils.isEmpty(pMSAppInfo.webAction)) {
                com.baidu.swan.apps.aj.a.c.a("", s.mL(pMSAppInfo.webAction));
            }
            if (!TextUtils.isEmpty(pMSAppInfo.domains)) {
                com.baidu.swan.apps.aj.a.c.f(pMSAppInfo.appId, s.parseString(pMSAppInfo.domains));
            }
        }
    }

    public static void a(PMSAppInfo pMSAppInfo, f fVar) {
        com.baidu.swan.games.s.a.a y;
        if (pMSAppInfo != null && fVar != null) {
            pMSAppInfo.h(fVar);
            if (fVar.category == 1 && (y = y(fVar.cBk, fVar.versionCode)) != null) {
                pMSAppInfo.setOrientation(y.crr);
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
