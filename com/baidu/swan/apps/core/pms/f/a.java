package com.baidu.swan.apps.core.pms.f;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.aq.ac;
import com.baidu.swan.apps.aq.t;
import com.baidu.swan.apps.r.a.a;
import com.baidu.swan.apps.r.e;
import com.baidu.swan.apps.statistic.f;
import com.baidu.swan.e.d;
import com.baidu.swan.games.l.a;
import com.baidu.swan.pms.a.h;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.swan.pms.model.g;
import java.io.File;
import java.io.IOException;
import java.nio.channels.ReadableByteChannel;
/* loaded from: classes11.dex */
public final class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    /* renamed from: com.baidu.swan.apps.core.pms.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0349a {
        public int cdv = 0;
        public boolean cdw = false;
        public String cdx = "";
    }

    public static String abs() {
        return e.d.afR().getPath();
    }

    public static String abt() {
        return a.c.afR().getPath();
    }

    public static String abu() {
        return e.d.afR().getPath();
    }

    public static String abl() {
        return e.d.afR().getPath();
    }

    public static String abv() {
        return a.c.afR().getPath();
    }

    public static String abw() {
        return a.c.afR().getPath();
    }

    public static com.baidu.swan.games.t.a.a K(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return com.baidu.swan.games.t.a.a.st(d.readFileData(new File(a.c.bm(str, String.valueOf(i)), "game.json")));
    }

    public static com.baidu.swan.apps.an.a a(ReadableByteChannel readableByteChannel, String str, com.baidu.swan.pms.a.d dVar) throws IOException {
        if (readableByteChannel == null) {
            com.baidu.swan.apps.an.a pB = new com.baidu.swan.apps.an.a().bw(11L).bx(2300L).pB("empty source");
            com.baidu.swan.apps.an.e.atW().g(pB);
            if (DEBUG) {
                Log.i("PkgDownloadUtil", "checkPkgZipSign err: " + pB);
                return pB;
            }
            return pB;
        }
        dVar.aW("670", "aiapp_aps_check_sign_start_timestamp");
        dVar.aW("770", "na_pms_start_check_sign");
        if (ac.a(readableByteChannel, str, new com.baidu.swan.apps.aq.a.c())) {
            dVar.aW("670", "aiapp_aps_check_sign_end_timestamp");
            dVar.aW("770", "na_pms_end_check_sign");
            return null;
        }
        com.baidu.swan.apps.an.a pB2 = new com.baidu.swan.apps.an.a().bw(11L).bx(2300L).pB("check zip file sign fail.");
        com.baidu.swan.apps.an.e.atW().g(pB2);
        if (DEBUG) {
            Log.i("PkgDownloadUtil", "checkPkgZipSign err: " + pB2);
            return pB2;
        }
        return pB2;
    }

    public static com.baidu.swan.apps.an.a b(com.baidu.swan.pms.model.e eVar) {
        String str;
        if (eVar == null) {
            com.baidu.swan.apps.an.a pB = new com.baidu.swan.apps.an.a().bw(11L).bx(2310L).pB("pkg info is empty");
            com.baidu.swan.apps.an.e.atW().g(pB);
            return pB;
        }
        if (eVar.category == 0) {
            str = abs() + File.separator + eVar.dqi + ".aiapps";
        } else if (eVar.category == 1) {
            str = abt() + File.separator + eVar.dqi + ".aigames";
        } else {
            com.baidu.swan.apps.an.a pB2 = new com.baidu.swan.apps.an.a().bw(11L).bx(2310L).pB("pkh category illegal");
            com.baidu.swan.apps.an.e.atW().g(pB2);
            return pB2;
        }
        d.deleteFile(str);
        File file = new File(str);
        File file2 = new File(eVar.filePath);
        if (file2.renameTo(file)) {
            if (DEBUG) {
                Log.i("PkgDownloadUtil", "重命名成功,from:" + file2.getPath() + " to:" + file.getPath());
            }
            return null;
        }
        d.deleteFile(file2);
        com.baidu.swan.apps.an.a pB3 = new com.baidu.swan.apps.an.a().bw(11L).bx(2310L).pB("rename zip fail");
        com.baidu.swan.apps.an.e.atW().g(pB3);
        return pB3;
    }

    public static com.baidu.swan.apps.an.a a(com.baidu.swan.pms.model.e eVar, com.baidu.swan.pms.a.d dVar) {
        File file;
        File bm;
        if (eVar == null) {
            com.baidu.swan.apps.an.a pB = new com.baidu.swan.apps.an.a().bw(11L).bx(2320L).pB("pkg info is empty");
            com.baidu.swan.apps.an.e.atW().g(pB);
            return pB;
        }
        if (eVar.category == 1) {
            file = new File(abt(), eVar.dqi + ".aigames");
            bm = a.c.bm(eVar.dqi, String.valueOf(eVar.versionCode));
        } else if (eVar.category == 0) {
            file = new File(abs(), eVar.dqi + ".aiapps");
            bm = e.d.bm(eVar.dqi, String.valueOf(eVar.versionCode));
        } else {
            com.baidu.swan.apps.an.a pB2 = new com.baidu.swan.apps.an.a().bw(11L).bx(2320L).pB("pkh category illegal");
            com.baidu.swan.apps.an.e.atW().g(pB2);
            return pB2;
        }
        if (!file.exists()) {
            com.baidu.swan.apps.an.a pB3 = new com.baidu.swan.apps.an.a().bw(11L).bx(2320L).pB("解压失败：包不存在");
            com.baidu.swan.apps.an.e.atW().g(pB3);
            return pB3;
        } else if (bm.isFile() && !bm.delete()) {
            if (DEBUG) {
                Log.e("PkgDownloadUtil", "解压失败：解压目录被文件占用，且无法删除");
            }
            com.baidu.swan.apps.an.a pB4 = new com.baidu.swan.apps.an.a().bw(11L).bx(2320L).pB("解压失败：解压目录被文件占用，且无法删除");
            com.baidu.swan.apps.an.e.atW().g(pB4);
            return pB4;
        } else if (!bm.exists() && !bm.mkdirs()) {
            if (DEBUG) {
                Log.e("PkgDownloadUtil", "解压失败：解压文件夹创建失败");
            }
            com.baidu.swan.apps.an.a pB5 = new com.baidu.swan.apps.an.a().bw(11L).bx(2320L).pB("解压失败：解压文件夹创建失败");
            com.baidu.swan.apps.an.e.atW().g(pB5);
            return pB5;
        } else {
            if (DEBUG) {
                Log.i("PkgDownloadUtil", "开始执行解压操作, bundle:" + file.getPath() + " , folder:" + bm.getPath());
            }
            if (a(file, bm, dVar).cdw) {
                return null;
            }
            C0349a a = a(file, bm, dVar);
            if (a.cdw) {
                f.a(dVar, eVar.category, true);
                return null;
            }
            f.a(dVar, eVar.category, false);
            d.safeDeleteFile(bm);
            com.baidu.swan.apps.an.a aVar = new com.baidu.swan.apps.an.a();
            switch (a.cdv) {
                case 0:
                    aVar.bw(11L).bx(2320L).pB("unzip failed");
                    break;
                case 1:
                case 2:
                    aVar.bw(11L).bx(2330L).pB("decryt failed:" + a.cdx + ", PkgType=" + a.cdv);
                    break;
                default:
                    aVar.bw(4L).bx(7L).pB("Unkown bundle type");
                    break;
            }
            com.baidu.swan.apps.an.e.atW().g(aVar);
            return aVar;
        }
    }

    @NonNull
    private static C0349a a(@NonNull File file, @NonNull File file2, @NonNull com.baidu.swan.pms.a.d dVar) {
        int i;
        C0349a c0349a = new C0349a();
        long currentTimeMillis = System.currentTimeMillis();
        a.b w = com.baidu.swan.apps.r.a.a.w(file);
        if (w.type != -1) {
            dVar.aW("670", "package_start_decrypt");
            dVar.aW("770", "na_package_start_decrypt");
            a.C0376a a = com.baidu.swan.apps.r.a.a.a(w.clr, file2, w.type);
            dVar.aW("670", "package_end_decrypt");
            dVar.aW("770", "na_package_end_decrypt");
            c0349a.cdw = a.isSuccess;
            c0349a.cdx = a.cdx;
            c0349a.cdv = w.type;
            i = w.type;
        } else {
            c0349a.cdv = 0;
            dVar.aW("670", "package_start_unzip");
            dVar.aW("770", "na_package_start_unzip");
            c0349a.cdw = d.unzipFile(file.getPath(), file2.getPath());
            dVar.aW("670", "package_end_unzip");
            dVar.aW("770", "na_package_end_unzip");
            i = 0;
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        if (DEBUG) {
            com.baidu.swan.apps.r.a.a.fJ((int) (currentTimeMillis2 - currentTimeMillis));
        }
        Bundle bundle = new Bundle();
        bundle.putInt("download_package_type_id", i);
        h.a(dVar, bundle, "event_download_package_type");
        return c0349a;
    }

    public static void e(PMSAppInfo pMSAppInfo) {
        if (pMSAppInfo != null) {
            if (!TextUtils.isEmpty(pMSAppInfo.webViewDomains)) {
                com.baidu.swan.apps.ah.a.c.a(pMSAppInfo.appId, "", t.pP(pMSAppInfo.webViewDomains));
            }
            if (!TextUtils.isEmpty(pMSAppInfo.webAction)) {
                com.baidu.swan.apps.ah.a.c.a("", t.pP(pMSAppInfo.webAction));
            }
            if (!TextUtils.isEmpty(pMSAppInfo.domains)) {
                com.baidu.swan.apps.ah.a.c.g(pMSAppInfo.appId, t.parseString(pMSAppInfo.domains));
            }
        }
    }

    public static void a(PMSAppInfo pMSAppInfo, com.baidu.swan.pms.model.f fVar) {
        com.baidu.swan.games.t.a.a K;
        if (pMSAppInfo != null && fVar != null) {
            pMSAppInfo.h(fVar);
            if (fVar.category == 1 && (K = K(fVar.dqi, fVar.versionCode)) != null) {
                pMSAppInfo.setOrientation(K.dga);
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
