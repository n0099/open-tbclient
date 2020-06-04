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
    public static class C0343a {
        public int bYF = 0;
        public boolean bYG = false;
        public String bYH = "";
    }

    public static String aam() {
        return e.d.aeL().getPath();
    }

    public static String aan() {
        return a.c.aeL().getPath();
    }

    public static String aao() {
        return e.d.aeL().getPath();
    }

    public static String aaf() {
        return e.d.aeL().getPath();
    }

    public static String aap() {
        return a.c.aeL().getPath();
    }

    public static String aaq() {
        return a.c.aeL().getPath();
    }

    public static com.baidu.swan.games.t.a.a K(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return com.baidu.swan.games.t.a.a.sk(d.readFileData(new File(a.c.bk(str, String.valueOf(i)), "game.json")));
    }

    public static com.baidu.swan.apps.an.a a(ReadableByteChannel readableByteChannel, String str, com.baidu.swan.pms.a.d dVar) throws IOException {
        if (readableByteChannel == null) {
            com.baidu.swan.apps.an.a pt = new com.baidu.swan.apps.an.a().bw(11L).bx(2300L).pt("empty source");
            com.baidu.swan.apps.an.e.asQ().g(pt);
            if (DEBUG) {
                Log.i("PkgDownloadUtil", "checkPkgZipSign err: " + pt);
                return pt;
            }
            return pt;
        }
        dVar.aU("670", "aiapp_aps_check_sign_start_timestamp");
        dVar.aU("770", "na_pms_start_check_sign");
        if (ac.a(readableByteChannel, str, new com.baidu.swan.apps.aq.a.c())) {
            dVar.aU("670", "aiapp_aps_check_sign_end_timestamp");
            dVar.aU("770", "na_pms_end_check_sign");
            return null;
        }
        com.baidu.swan.apps.an.a pt2 = new com.baidu.swan.apps.an.a().bw(11L).bx(2300L).pt("check zip file sign fail.");
        com.baidu.swan.apps.an.e.asQ().g(pt2);
        if (DEBUG) {
            Log.i("PkgDownloadUtil", "checkPkgZipSign err: " + pt2);
            return pt2;
        }
        return pt2;
    }

    public static com.baidu.swan.apps.an.a b(com.baidu.swan.pms.model.e eVar) {
        String str;
        if (eVar == null) {
            com.baidu.swan.apps.an.a pt = new com.baidu.swan.apps.an.a().bw(11L).bx(2310L).pt("pkg info is empty");
            com.baidu.swan.apps.an.e.asQ().g(pt);
            return pt;
        }
        if (eVar.category == 0) {
            str = aam() + File.separator + eVar.dlx + ".aiapps";
        } else if (eVar.category == 1) {
            str = aan() + File.separator + eVar.dlx + ".aigames";
        } else {
            com.baidu.swan.apps.an.a pt2 = new com.baidu.swan.apps.an.a().bw(11L).bx(2310L).pt("pkh category illegal");
            com.baidu.swan.apps.an.e.asQ().g(pt2);
            return pt2;
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
        com.baidu.swan.apps.an.a pt3 = new com.baidu.swan.apps.an.a().bw(11L).bx(2310L).pt("rename zip fail");
        com.baidu.swan.apps.an.e.asQ().g(pt3);
        return pt3;
    }

    public static com.baidu.swan.apps.an.a a(com.baidu.swan.pms.model.e eVar, com.baidu.swan.pms.a.d dVar) {
        File file;
        File bk;
        if (eVar == null) {
            com.baidu.swan.apps.an.a pt = new com.baidu.swan.apps.an.a().bw(11L).bx(2320L).pt("pkg info is empty");
            com.baidu.swan.apps.an.e.asQ().g(pt);
            return pt;
        }
        if (eVar.category == 1) {
            file = new File(aan(), eVar.dlx + ".aigames");
            bk = a.c.bk(eVar.dlx, String.valueOf(eVar.versionCode));
        } else if (eVar.category == 0) {
            file = new File(aam(), eVar.dlx + ".aiapps");
            bk = e.d.bk(eVar.dlx, String.valueOf(eVar.versionCode));
        } else {
            com.baidu.swan.apps.an.a pt2 = new com.baidu.swan.apps.an.a().bw(11L).bx(2320L).pt("pkh category illegal");
            com.baidu.swan.apps.an.e.asQ().g(pt2);
            return pt2;
        }
        if (!file.exists()) {
            com.baidu.swan.apps.an.a pt3 = new com.baidu.swan.apps.an.a().bw(11L).bx(2320L).pt("解压失败：包不存在");
            com.baidu.swan.apps.an.e.asQ().g(pt3);
            return pt3;
        } else if (bk.isFile() && !bk.delete()) {
            if (DEBUG) {
                Log.e("PkgDownloadUtil", "解压失败：解压目录被文件占用，且无法删除");
            }
            com.baidu.swan.apps.an.a pt4 = new com.baidu.swan.apps.an.a().bw(11L).bx(2320L).pt("解压失败：解压目录被文件占用，且无法删除");
            com.baidu.swan.apps.an.e.asQ().g(pt4);
            return pt4;
        } else if (!bk.exists() && !bk.mkdirs()) {
            if (DEBUG) {
                Log.e("PkgDownloadUtil", "解压失败：解压文件夹创建失败");
            }
            com.baidu.swan.apps.an.a pt5 = new com.baidu.swan.apps.an.a().bw(11L).bx(2320L).pt("解压失败：解压文件夹创建失败");
            com.baidu.swan.apps.an.e.asQ().g(pt5);
            return pt5;
        } else {
            if (DEBUG) {
                Log.i("PkgDownloadUtil", "开始执行解压操作, bundle:" + file.getPath() + " , folder:" + bk.getPath());
            }
            if (a(file, bk, dVar).bYG) {
                return null;
            }
            C0343a a = a(file, bk, dVar);
            if (a.bYG) {
                f.a(dVar, eVar.category, true);
                return null;
            }
            f.a(dVar, eVar.category, false);
            d.safeDeleteFile(bk);
            com.baidu.swan.apps.an.a aVar = new com.baidu.swan.apps.an.a();
            switch (a.bYF) {
                case 0:
                    aVar.bw(11L).bx(2320L).pt("unzip failed");
                    break;
                case 1:
                case 2:
                    aVar.bw(11L).bx(2330L).pt("decryt failed:" + a.bYH + ", PkgType=" + a.bYF);
                    break;
                default:
                    aVar.bw(4L).bx(7L).pt("Unkown bundle type");
                    break;
            }
            com.baidu.swan.apps.an.e.asQ().g(aVar);
            return aVar;
        }
    }

    @NonNull
    private static C0343a a(@NonNull File file, @NonNull File file2, @NonNull com.baidu.swan.pms.a.d dVar) {
        int i;
        C0343a c0343a = new C0343a();
        long currentTimeMillis = System.currentTimeMillis();
        a.b w = com.baidu.swan.apps.r.a.a.w(file);
        if (w.type != -1) {
            dVar.aU("670", "package_start_decrypt");
            dVar.aU("770", "na_package_start_decrypt");
            a.C0370a a = com.baidu.swan.apps.r.a.a.a(w.cgD, file2, w.type);
            dVar.aU("670", "package_end_decrypt");
            dVar.aU("770", "na_package_end_decrypt");
            c0343a.bYG = a.isSuccess;
            c0343a.bYH = a.bYH;
            c0343a.bYF = w.type;
            i = w.type;
        } else {
            c0343a.bYF = 0;
            dVar.aU("670", "package_start_unzip");
            dVar.aU("770", "na_package_start_unzip");
            c0343a.bYG = d.unzipFile(file.getPath(), file2.getPath());
            dVar.aU("670", "package_end_unzip");
            dVar.aU("770", "na_package_end_unzip");
            i = 0;
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        if (DEBUG) {
            com.baidu.swan.apps.r.a.a.fy((int) (currentTimeMillis2 - currentTimeMillis));
        }
        Bundle bundle = new Bundle();
        bundle.putInt("download_package_type_id", i);
        h.a(dVar, bundle, "event_download_package_type");
        return c0343a;
    }

    public static void e(PMSAppInfo pMSAppInfo) {
        if (pMSAppInfo != null) {
            if (!TextUtils.isEmpty(pMSAppInfo.webViewDomains)) {
                com.baidu.swan.apps.ah.a.c.a(pMSAppInfo.appId, "", t.pH(pMSAppInfo.webViewDomains));
            }
            if (!TextUtils.isEmpty(pMSAppInfo.webAction)) {
                com.baidu.swan.apps.ah.a.c.a("", t.pH(pMSAppInfo.webAction));
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
            if (fVar.category == 1 && (K = K(fVar.dlx, fVar.versionCode)) != null) {
                pMSAppInfo.setOrientation(K.dbn);
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
