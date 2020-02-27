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
        public int bqD = 0;
        public boolean bqE = false;
        public String bqF = "";
    }

    public static String PF() {
        return e.d.TO().getPath();
    }

    public static String PG() {
        return a.c.TO().getPath();
    }

    public static String PH() {
        return e.d.TO().getPath();
    }

    public static String PA() {
        return e.d.TO().getPath();
    }

    public static String PI() {
        return a.c.TO().getPath();
    }

    public static String PJ() {
        return a.c.TO().getPath();
    }

    public static com.baidu.swan.games.s.a.a y(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return com.baidu.swan.games.s.a.a.pv(com.baidu.swan.d.c.readFileData(new File(a.c.aL(str, String.valueOf(i)), "game.json")));
    }

    public static com.baidu.swan.apps.ap.a a(ReadableByteChannel readableByteChannel, String str, d dVar) throws IOException {
        if (readableByteChannel == null) {
            com.baidu.swan.apps.ap.a mz = new com.baidu.swan.apps.ap.a().aI(11L).aJ(2300L).mz("empty source");
            com.baidu.swan.apps.ap.e.agm().f(mz);
            if (DEBUG) {
                Log.i("PkgDownloadUtil", "checkPkgZipSign err: " + mz);
                return mz;
            }
            return mz;
        }
        dVar.aw("670", "aiapp_aps_check_sign_start_timestamp");
        dVar.aw("770", "na_pms_start_check_sign");
        if (ab.a(readableByteChannel, str, new com.baidu.swan.apps.as.a.c())) {
            dVar.aw("670", "aiapp_aps_check_sign_end_timestamp");
            dVar.aw("770", "na_pms_end_check_sign");
            return null;
        }
        com.baidu.swan.apps.ap.a mz2 = new com.baidu.swan.apps.ap.a().aI(11L).aJ(2300L).mz("check zip file sign fail.");
        com.baidu.swan.apps.ap.e.agm().f(mz2);
        if (DEBUG) {
            Log.i("PkgDownloadUtil", "checkPkgZipSign err: " + mz2);
            return mz2;
        }
        return mz2;
    }

    public static com.baidu.swan.apps.ap.a b(com.baidu.swan.pms.model.e eVar) {
        String str;
        if (eVar == null) {
            com.baidu.swan.apps.ap.a mz = new com.baidu.swan.apps.ap.a().aI(11L).aJ(2310L).mz("pkg info is empty");
            com.baidu.swan.apps.ap.e.agm().f(mz);
            return mz;
        }
        if (eVar.category == 0) {
            str = PF() + File.separator + eVar.cAX + ".aiapps";
        } else if (eVar.category == 1) {
            str = PG() + File.separator + eVar.cAX + ".aigames";
        } else {
            com.baidu.swan.apps.ap.a mz2 = new com.baidu.swan.apps.ap.a().aI(11L).aJ(2310L).mz("pkh category illegal");
            com.baidu.swan.apps.ap.e.agm().f(mz2);
            return mz2;
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
        com.baidu.swan.apps.ap.a mz3 = new com.baidu.swan.apps.ap.a().aI(11L).aJ(2310L).mz("rename zip fail");
        com.baidu.swan.apps.ap.e.agm().f(mz3);
        return mz3;
    }

    public static com.baidu.swan.apps.ap.a a(com.baidu.swan.pms.model.e eVar, d dVar) {
        File file;
        File aL;
        if (eVar == null) {
            com.baidu.swan.apps.ap.a mz = new com.baidu.swan.apps.ap.a().aI(11L).aJ(2320L).mz("pkg info is empty");
            com.baidu.swan.apps.ap.e.agm().f(mz);
            return mz;
        }
        if (eVar.category == 1) {
            file = new File(PG(), eVar.cAX + ".aigames");
            aL = a.c.aL(eVar.cAX, String.valueOf(eVar.versionCode));
        } else if (eVar.category == 0) {
            file = new File(PF(), eVar.cAX + ".aiapps");
            aL = e.d.aL(eVar.cAX, String.valueOf(eVar.versionCode));
        } else {
            com.baidu.swan.apps.ap.a mz2 = new com.baidu.swan.apps.ap.a().aI(11L).aJ(2320L).mz("pkh category illegal");
            com.baidu.swan.apps.ap.e.agm().f(mz2);
            return mz2;
        }
        if (!file.exists()) {
            com.baidu.swan.apps.ap.a mz3 = new com.baidu.swan.apps.ap.a().aI(11L).aJ(2320L).mz("解压失败：包不存在");
            com.baidu.swan.apps.ap.e.agm().f(mz3);
            return mz3;
        } else if (aL.isFile() && !aL.delete()) {
            if (DEBUG) {
                Log.e("PkgDownloadUtil", "解压失败：解压目录被文件占用，且无法删除");
            }
            com.baidu.swan.apps.ap.a mz4 = new com.baidu.swan.apps.ap.a().aI(11L).aJ(2320L).mz("解压失败：解压目录被文件占用，且无法删除");
            com.baidu.swan.apps.ap.e.agm().f(mz4);
            return mz4;
        } else if (!aL.exists() && !aL.mkdirs()) {
            if (DEBUG) {
                Log.e("PkgDownloadUtil", "解压失败：解压文件夹创建失败");
            }
            com.baidu.swan.apps.ap.a mz5 = new com.baidu.swan.apps.ap.a().aI(11L).aJ(2320L).mz("解压失败：解压文件夹创建失败");
            com.baidu.swan.apps.ap.e.agm().f(mz5);
            return mz5;
        } else {
            if (DEBUG) {
                Log.i("PkgDownloadUtil", "开始执行解压操作, bundle:" + file.getPath() + " , folder:" + aL.getPath());
            }
            if (a(file, aL, dVar).bqE) {
                return null;
            }
            C0251a a = a(file, aL, dVar);
            if (a.bqE) {
                com.baidu.swan.apps.statistic.d.a(dVar, eVar.category, true);
                return null;
            }
            com.baidu.swan.apps.statistic.d.a(dVar, eVar.category, false);
            com.baidu.swan.d.c.safeDeleteFile(aL);
            com.baidu.swan.apps.ap.a aVar = new com.baidu.swan.apps.ap.a();
            switch (a.bqD) {
                case 0:
                    aVar.aI(11L).aJ(2320L).mz("unzip failed");
                    break;
                case 1:
                case 2:
                    aVar.aI(11L).aJ(2330L).mz("decryt failed:" + a.bqF + ", PkgType=" + a.bqD);
                    break;
                default:
                    aVar.aI(4L).aJ(7L).mz("Unkown bundle type");
                    break;
            }
            com.baidu.swan.apps.ap.e.agm().f(aVar);
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
            dVar.aw("670", "package_start_decrypt");
            dVar.aw("770", "na_package_start_decrypt");
            a.C0301a a = com.baidu.swan.apps.t.a.a.a(r.bxJ, file2, r.type);
            dVar.aw("670", "package_end_decrypt");
            dVar.aw("770", "na_package_end_decrypt");
            c0251a.bqE = a.isSuccess;
            c0251a.bqF = a.bqF;
            c0251a.bqD = r.type;
            i = r.type;
        } else {
            c0251a.bqD = 0;
            dVar.aw("670", "package_start_unzip");
            dVar.aw("770", "na_package_start_unzip");
            c0251a.bqE = com.baidu.swan.d.c.unzipFile(file.getPath(), file2.getPath());
            dVar.aw("670", "package_end_unzip");
            dVar.aw("770", "na_package_end_unzip");
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
                com.baidu.swan.apps.aj.a.c.a(pMSAppInfo.appId, "", s.mM(pMSAppInfo.webViewDomains));
            }
            if (!TextUtils.isEmpty(pMSAppInfo.webAction)) {
                com.baidu.swan.apps.aj.a.c.a("", s.mM(pMSAppInfo.webAction));
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
            if (fVar.category == 1 && (y = y(fVar.cAX, fVar.versionCode)) != null) {
                pMSAppInfo.setOrientation(y.cre);
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
