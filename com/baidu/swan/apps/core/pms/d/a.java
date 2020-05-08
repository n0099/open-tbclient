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
    public static class C0302a {
        public int bPd = 0;
        public boolean bPe = false;
        public String bPf = "";
    }

    public static String Xy() {
        return e.d.abH().getPath();
    }

    public static String Xz() {
        return a.c.abH().getPath();
    }

    public static String XA() {
        return e.d.abH().getPath();
    }

    public static String Xt() {
        return e.d.abH().getPath();
    }

    public static String XB() {
        return a.c.abH().getPath();
    }

    public static String XC() {
        return a.c.abH().getPath();
    }

    public static com.baidu.swan.games.s.a.a G(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return com.baidu.swan.games.s.a.a.qH(com.baidu.swan.d.c.readFileData(new File(a.c.aT(str, String.valueOf(i)), "game.json")));
    }

    public static com.baidu.swan.apps.ap.a a(ReadableByteChannel readableByteChannel, String str, d dVar) throws IOException {
        if (readableByteChannel == null) {
            com.baidu.swan.apps.ap.a nL = new com.baidu.swan.apps.ap.a().bn(11L).bo(2300L).nL("empty source");
            com.baidu.swan.apps.ap.e.aov().f(nL);
            if (DEBUG) {
                Log.i("PkgDownloadUtil", "checkPkgZipSign err: " + nL);
                return nL;
            }
            return nL;
        }
        dVar.aE("670", "aiapp_aps_check_sign_start_timestamp");
        dVar.aE("770", "na_pms_start_check_sign");
        if (ab.a(readableByteChannel, str, new com.baidu.swan.apps.as.a.c())) {
            dVar.aE("670", "aiapp_aps_check_sign_end_timestamp");
            dVar.aE("770", "na_pms_end_check_sign");
            return null;
        }
        com.baidu.swan.apps.ap.a nL2 = new com.baidu.swan.apps.ap.a().bn(11L).bo(2300L).nL("check zip file sign fail.");
        com.baidu.swan.apps.ap.e.aov().f(nL2);
        if (DEBUG) {
            Log.i("PkgDownloadUtil", "checkPkgZipSign err: " + nL2);
            return nL2;
        }
        return nL2;
    }

    public static com.baidu.swan.apps.ap.a b(com.baidu.swan.pms.model.e eVar) {
        String str;
        if (eVar == null) {
            com.baidu.swan.apps.ap.a nL = new com.baidu.swan.apps.ap.a().bn(11L).bo(2310L).nL("pkg info is empty");
            com.baidu.swan.apps.ap.e.aov().f(nL);
            return nL;
        }
        if (eVar.category == 0) {
            str = Xy() + File.separator + eVar.dan + ".aiapps";
        } else if (eVar.category == 1) {
            str = Xz() + File.separator + eVar.dan + ".aigames";
        } else {
            com.baidu.swan.apps.ap.a nL2 = new com.baidu.swan.apps.ap.a().bn(11L).bo(2310L).nL("pkh category illegal");
            com.baidu.swan.apps.ap.e.aov().f(nL2);
            return nL2;
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
        com.baidu.swan.apps.ap.a nL3 = new com.baidu.swan.apps.ap.a().bn(11L).bo(2310L).nL("rename zip fail");
        com.baidu.swan.apps.ap.e.aov().f(nL3);
        return nL3;
    }

    public static com.baidu.swan.apps.ap.a a(com.baidu.swan.pms.model.e eVar, d dVar) {
        File file;
        File aT;
        if (eVar == null) {
            com.baidu.swan.apps.ap.a nL = new com.baidu.swan.apps.ap.a().bn(11L).bo(2320L).nL("pkg info is empty");
            com.baidu.swan.apps.ap.e.aov().f(nL);
            return nL;
        }
        if (eVar.category == 1) {
            file = new File(Xz(), eVar.dan + ".aigames");
            aT = a.c.aT(eVar.dan, String.valueOf(eVar.versionCode));
        } else if (eVar.category == 0) {
            file = new File(Xy(), eVar.dan + ".aiapps");
            aT = e.d.aT(eVar.dan, String.valueOf(eVar.versionCode));
        } else {
            com.baidu.swan.apps.ap.a nL2 = new com.baidu.swan.apps.ap.a().bn(11L).bo(2320L).nL("pkh category illegal");
            com.baidu.swan.apps.ap.e.aov().f(nL2);
            return nL2;
        }
        if (!file.exists()) {
            com.baidu.swan.apps.ap.a nL3 = new com.baidu.swan.apps.ap.a().bn(11L).bo(2320L).nL("解压失败：包不存在");
            com.baidu.swan.apps.ap.e.aov().f(nL3);
            return nL3;
        } else if (aT.isFile() && !aT.delete()) {
            if (DEBUG) {
                Log.e("PkgDownloadUtil", "解压失败：解压目录被文件占用，且无法删除");
            }
            com.baidu.swan.apps.ap.a nL4 = new com.baidu.swan.apps.ap.a().bn(11L).bo(2320L).nL("解压失败：解压目录被文件占用，且无法删除");
            com.baidu.swan.apps.ap.e.aov().f(nL4);
            return nL4;
        } else if (!aT.exists() && !aT.mkdirs()) {
            if (DEBUG) {
                Log.e("PkgDownloadUtil", "解压失败：解压文件夹创建失败");
            }
            com.baidu.swan.apps.ap.a nL5 = new com.baidu.swan.apps.ap.a().bn(11L).bo(2320L).nL("解压失败：解压文件夹创建失败");
            com.baidu.swan.apps.ap.e.aov().f(nL5);
            return nL5;
        } else {
            if (DEBUG) {
                Log.i("PkgDownloadUtil", "开始执行解压操作, bundle:" + file.getPath() + " , folder:" + aT.getPath());
            }
            if (a(file, aT, dVar).bPe) {
                return null;
            }
            C0302a a = a(file, aT, dVar);
            if (a.bPe) {
                com.baidu.swan.apps.statistic.d.a(dVar, eVar.category, true);
                return null;
            }
            com.baidu.swan.apps.statistic.d.a(dVar, eVar.category, false);
            com.baidu.swan.d.c.safeDeleteFile(aT);
            com.baidu.swan.apps.ap.a aVar = new com.baidu.swan.apps.ap.a();
            switch (a.bPd) {
                case 0:
                    aVar.bn(11L).bo(2320L).nL("unzip failed");
                    break;
                case 1:
                case 2:
                    aVar.bn(11L).bo(2330L).nL("decryt failed:" + a.bPf + ", PkgType=" + a.bPd);
                    break;
                default:
                    aVar.bn(4L).bo(7L).nL("Unkown bundle type");
                    break;
            }
            com.baidu.swan.apps.ap.e.aov().f(aVar);
            return aVar;
        }
    }

    @NonNull
    private static C0302a a(@NonNull File file, @NonNull File file2, @NonNull d dVar) {
        int i;
        C0302a c0302a = new C0302a();
        long currentTimeMillis = System.currentTimeMillis();
        a.b s = com.baidu.swan.apps.t.a.a.s(file);
        if (s.type != -1) {
            dVar.aE("670", "package_start_decrypt");
            dVar.aE("770", "na_package_start_decrypt");
            a.C0352a a = com.baidu.swan.apps.t.a.a.a(s.bWi, file2, s.type);
            dVar.aE("670", "package_end_decrypt");
            dVar.aE("770", "na_package_end_decrypt");
            c0302a.bPe = a.isSuccess;
            c0302a.bPf = a.bPf;
            c0302a.bPd = s.type;
            i = s.type;
        } else {
            c0302a.bPd = 0;
            dVar.aE("670", "package_start_unzip");
            dVar.aE("770", "na_package_start_unzip");
            c0302a.bPe = com.baidu.swan.d.c.unzipFile(file.getPath(), file2.getPath());
            dVar.aE("670", "package_end_unzip");
            dVar.aE("770", "na_package_end_unzip");
            i = 0;
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        if (DEBUG) {
            com.baidu.swan.apps.t.a.a.fj((int) (currentTimeMillis2 - currentTimeMillis));
        }
        Bundle bundle = new Bundle();
        bundle.putInt("download_package_type_id", i);
        h.a(dVar, bundle, "event_download_package_type");
        return c0302a;
    }

    public static void d(PMSAppInfo pMSAppInfo) {
        if (pMSAppInfo != null) {
            if (!TextUtils.isEmpty(pMSAppInfo.webViewDomains)) {
                com.baidu.swan.apps.aj.a.c.a(pMSAppInfo.appId, "", s.nY(pMSAppInfo.webViewDomains));
            }
            if (!TextUtils.isEmpty(pMSAppInfo.webAction)) {
                com.baidu.swan.apps.aj.a.c.a("", s.nY(pMSAppInfo.webAction));
            }
            if (!TextUtils.isEmpty(pMSAppInfo.domains)) {
                com.baidu.swan.apps.aj.a.c.g(pMSAppInfo.appId, s.parseString(pMSAppInfo.domains));
            }
        }
    }

    public static void a(PMSAppInfo pMSAppInfo, f fVar) {
        com.baidu.swan.games.s.a.a G;
        if (pMSAppInfo != null && fVar != null) {
            pMSAppInfo.h(fVar);
            if (fVar.category == 1 && (G = G(fVar.dan, fVar.versionCode)) != null) {
                pMSAppInfo.setOrientation(G.cQr);
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
