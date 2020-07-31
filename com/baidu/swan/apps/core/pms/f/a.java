package com.baidu.swan.apps.core.pms.f;

import android.os.Bundle;
import android.support.annotation.AnyThread;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.an.e;
import com.baidu.swan.apps.aq.ae;
import com.baidu.swan.apps.aq.p;
import com.baidu.swan.apps.aq.v;
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
/* loaded from: classes7.dex */
public final class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static boolean cfa = false;

    /* renamed from: com.baidu.swan.apps.core.pms.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0350a {
        public int cfc = 0;
        public boolean cfd = false;
        public String cfe = "";
    }

    public static String act() {
        return d.C0380d.ahd().getPath();
    }

    public static String acu() {
        return a.c.ahd().getPath();
    }

    public static String acv() {
        return d.C0380d.ahd().getPath();
    }

    public static String acn() {
        return d.C0380d.ahd().getPath();
    }

    public static String acw() {
        return a.c.ahd().getPath();
    }

    public static String acx() {
        return a.c.ahd().getPath();
    }

    public static com.baidu.swan.games.t.a.a K(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return com.baidu.swan.games.t.a.a.tr(com.baidu.swan.d.d.readFileData(new File(a.c.bq(str, String.valueOf(i)), "game.json")));
    }

    public static com.baidu.swan.apps.an.a a(ReadableByteChannel readableByteChannel, String str, com.baidu.swan.pms.a.d dVar) throws IOException {
        if (readableByteChannel == null) {
            com.baidu.swan.apps.an.a qm = new com.baidu.swan.apps.an.a().bJ(11L).bK(2300L).qm("empty source");
            e.avX().g(qm);
            if (DEBUG) {
                Log.i("PkgDownloadUtil", "checkPkgZipSign err: " + qm);
                return qm;
            }
            return qm;
        }
        dVar.aY("670", "aiapp_aps_check_sign_start_timestamp");
        dVar.aY("770", "na_pms_start_check_sign");
        if (ae.a(readableByteChannel, str, new com.baidu.swan.apps.aq.a.c())) {
            dVar.aY("670", "aiapp_aps_check_sign_end_timestamp");
            dVar.aY("770", "na_pms_end_check_sign");
            return null;
        }
        com.baidu.swan.apps.an.a qm2 = new com.baidu.swan.apps.an.a().bJ(11L).bK(2300L).qm("check zip file sign fail.");
        e.avX().g(qm2);
        if (DEBUG) {
            Log.i("PkgDownloadUtil", "checkPkgZipSign err: " + qm2);
            return qm2;
        }
        return qm2;
    }

    public static com.baidu.swan.apps.an.a a(com.baidu.swan.pms.model.e eVar, com.baidu.swan.pms.a.d dVar) {
        File bq;
        if (eVar == null) {
            com.baidu.swan.apps.an.a qm = new com.baidu.swan.apps.an.a().bJ(11L).bK(2320L).qm("pkg info is empty");
            e.avX().g(qm);
            return qm;
        }
        File file = new File(eVar.filePath);
        if (eVar.category == 1) {
            bq = a.c.bq(eVar.dvZ, String.valueOf(eVar.versionCode));
        } else if (eVar.category == 0) {
            bq = d.C0380d.bq(eVar.dvZ, String.valueOf(eVar.versionCode));
        } else {
            com.baidu.swan.apps.an.a qm2 = new com.baidu.swan.apps.an.a().bJ(11L).bK(2320L).qm("pkh category illegal");
            e.avX().g(qm2);
            return qm2;
        }
        if (!file.exists()) {
            com.baidu.swan.apps.an.a qm3 = new com.baidu.swan.apps.an.a().bJ(11L).bK(2320L).qm("解压失败：包不存在");
            e.avX().g(qm3);
            return qm3;
        } else if (bq.isFile() && !bq.delete()) {
            if (DEBUG) {
                Log.e("PkgDownloadUtil", "解压失败：解压目录被文件占用，且无法删除");
            }
            com.baidu.swan.apps.an.a qm4 = new com.baidu.swan.apps.an.a().bJ(11L).bK(2320L).qm("解压失败：解压目录被文件占用，且无法删除");
            e.avX().g(qm4);
            return qm4;
        } else if (!bq.exists() && !bq.mkdirs()) {
            if (DEBUG) {
                Log.e("PkgDownloadUtil", "解压失败：解压文件夹创建失败 " + bq.getAbsolutePath());
            }
            com.baidu.swan.apps.an.a qm5 = new com.baidu.swan.apps.an.a().bJ(11L).bK(2320L).qm("解压失败：解压文件夹创建失败");
            e.avX().g(qm5);
            return qm5;
        } else {
            if (DEBUG) {
                Log.i("PkgDownloadUtil", "开始执行解压操作, bundle:" + file.getPath() + " , folder:" + bq.getPath());
            }
            if (a(file, bq, dVar).cfd) {
                return null;
            }
            C0350a a = a(file, bq, dVar);
            if (a.cfd) {
                f.a(dVar, eVar.category, true);
                return null;
            }
            f.a(dVar, eVar.category, false);
            com.baidu.swan.d.d.safeDeleteFile(bq);
            com.baidu.swan.apps.an.a aVar = new com.baidu.swan.apps.an.a();
            switch (a.cfc) {
                case 0:
                    aVar.bJ(11L).bK(2320L).qm("unzip failed");
                    break;
                case 1:
                case 2:
                    aVar.bJ(11L).bK(2330L).qm("decryt failed:" + a.cfe + ", PkgType=" + a.cfc);
                    break;
                default:
                    aVar.bJ(4L).bK(7L).qm("Unkown bundle type");
                    break;
            }
            e.avX().g(aVar);
            return aVar;
        }
    }

    @NonNull
    private static C0350a a(@NonNull File file, @NonNull File file2, @NonNull com.baidu.swan.pms.a.d dVar) {
        int i;
        C0350a c0350a = new C0350a();
        long currentTimeMillis = System.currentTimeMillis();
        a.b x = com.baidu.swan.apps.r.a.a.x(file);
        if (x.type != -1) {
            dVar.aY("670", "package_start_decrypt");
            dVar.aY("770", "na_package_start_decrypt");
            a.C0379a a = com.baidu.swan.apps.r.a.a.a(x.cnw, file2, x.type);
            dVar.aY("670", "package_end_decrypt");
            dVar.aY("770", "na_package_end_decrypt");
            c0350a.cfd = a.isSuccess;
            c0350a.cfe = a.cfe;
            c0350a.cfc = x.type;
            i = x.type;
        } else {
            c0350a.cfc = 0;
            dVar.aY("670", "package_start_unzip");
            dVar.aY("770", "na_package_start_unzip");
            c0350a.cfd = com.baidu.swan.d.d.unzipFile(file.getPath(), file2.getPath());
            dVar.aY("670", "package_end_unzip");
            dVar.aY("770", "na_package_end_unzip");
            i = 0;
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        if (DEBUG) {
            com.baidu.swan.apps.r.a.a.fT((int) (currentTimeMillis2 - currentTimeMillis));
        }
        Bundle bundle = new Bundle();
        bundle.putInt("download_package_type_id", i);
        h.a(dVar, bundle, "event_download_package_type");
        return c0350a;
    }

    public static void g(@Nullable PMSAppInfo pMSAppInfo) {
        if (pMSAppInfo != null) {
            if (!TextUtils.isEmpty(pMSAppInfo.webViewDomains)) {
                com.baidu.swan.apps.ah.a.c.a(pMSAppInfo.appId, "", v.qA(pMSAppInfo.webViewDomains));
            }
            if (!TextUtils.isEmpty(pMSAppInfo.webAction)) {
                com.baidu.swan.apps.ah.a.c.a("", v.qA(pMSAppInfo.webAction));
            }
            if (!TextUtils.isEmpty(pMSAppInfo.domains)) {
                com.baidu.swan.apps.ah.a.c.g(pMSAppInfo.appId, v.parseString(pMSAppInfo.domains));
            }
        }
    }

    public static void a(PMSAppInfo pMSAppInfo, com.baidu.swan.pms.model.f fVar) {
        com.baidu.swan.games.t.a.a K;
        if (pMSAppInfo != null && fVar != null) {
            pMSAppInfo.h(fVar);
            if (fVar.category == 1 && (K = K(fVar.dvZ, fVar.versionCode)) != null) {
                pMSAppInfo.setOrientation(K.dlJ);
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
    public static void acy() {
        if (!cfa) {
            synchronized (a.class) {
                if (!cfa) {
                    cfa = true;
                    final File file = new File(AppRuntime.getAppContext().getFilesDir(), "aiapps_zip");
                    if (file.exists()) {
                        p.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.core.pms.f.a.1
                            @Override // java.lang.Runnable
                            public void run() {
                                com.baidu.swan.d.d.safeDeleteFile(file);
                            }
                        }, "deleteHistoryZipFile");
                    }
                }
            }
        }
    }
}
