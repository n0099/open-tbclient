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
    private static boolean czP = false;

    /* renamed from: com.baidu.swan.apps.core.pms.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0403a {
        public int czR = 0;
        public boolean czS = false;
        public String czT = "";
    }

    public static String amn() {
        return d.C0438d.arZ().getPath();
    }

    public static String amo() {
        return a.c.arZ().getPath();
    }

    public static String amp() {
        return d.C0438d.arZ().getPath();
    }

    public static String amh() {
        return d.C0438d.arZ().getPath();
    }

    public static String amq() {
        return a.c.arZ().getPath();
    }

    public static String amr() {
        return a.c.arZ().getPath();
    }

    public static com.baidu.swan.games.t.a.a i(String str, long j) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return com.baidu.swan.games.t.a.a.wN(com.baidu.swan.c.d.readFileData(new File(a.c.bG(str, String.valueOf(j)), "game.json")));
    }

    public static com.baidu.swan.apps.am.a a(ReadableByteChannel readableByteChannel, String str, com.baidu.swan.pms.a.d dVar) throws IOException {
        if (readableByteChannel == null) {
            com.baidu.swan.apps.am.a tt = new com.baidu.swan.apps.am.a().bX(11L).bY(2300L).tt("empty source");
            e.aHz().j(tt);
            if (DEBUG) {
                Log.i("PkgDownloadUtil", "checkPkgZipSign err: " + tt);
                return tt;
            }
            return tt;
        }
        dVar.bk("670", "aiapp_aps_check_sign_start_timestamp");
        dVar.bk("770", "na_pms_start_check_sign");
        if (ae.a(readableByteChannel, str, new com.baidu.swan.apps.ap.a.c())) {
            dVar.bk("670", "aiapp_aps_check_sign_end_timestamp");
            dVar.bk("770", "na_pms_end_check_sign");
            return null;
        }
        com.baidu.swan.apps.am.a tt2 = new com.baidu.swan.apps.am.a().bX(11L).bY(2300L).tt("check zip file sign fail.");
        e.aHz().j(tt2);
        if (DEBUG) {
            Log.i("PkgDownloadUtil", "checkPkgZipSign err: " + tt2);
            return tt2;
        }
        return tt2;
    }

    public static com.baidu.swan.apps.am.a a(com.baidu.swan.pms.model.e eVar, com.baidu.swan.pms.a.d dVar) {
        File bG;
        if (eVar == null) {
            com.baidu.swan.apps.am.a tt = new com.baidu.swan.apps.am.a().bX(11L).bY(2320L).tt("pkg info is empty");
            e.aHz().j(tt);
            return tt;
        }
        File file = new File(eVar.filePath);
        if (eVar.category == 1) {
            bG = a.c.bG(eVar.dTs, String.valueOf(eVar.versionCode));
        } else if (eVar.category == 0) {
            bG = d.C0438d.bG(eVar.dTs, String.valueOf(eVar.versionCode));
        } else {
            com.baidu.swan.apps.am.a tt2 = new com.baidu.swan.apps.am.a().bX(11L).bY(2320L).tt("pkh category illegal");
            e.aHz().j(tt2);
            return tt2;
        }
        if (!file.exists()) {
            com.baidu.swan.apps.am.a tt3 = new com.baidu.swan.apps.am.a().bX(11L).bY(2320L).tt("解压失败：包不存在");
            e.aHz().j(tt3);
            return tt3;
        } else if (bG.isFile() && !bG.delete()) {
            if (DEBUG) {
                Log.e("PkgDownloadUtil", "解压失败：解压目录被文件占用，且无法删除");
            }
            com.baidu.swan.apps.am.a tt4 = new com.baidu.swan.apps.am.a().bX(11L).bY(2320L).tt("解压失败：解压目录被文件占用，且无法删除");
            e.aHz().j(tt4);
            return tt4;
        } else if (!bG.exists() && !bG.mkdirs()) {
            if (DEBUG) {
                Log.e("PkgDownloadUtil", "解压失败：解压文件夹创建失败 " + bG.getAbsolutePath());
            }
            com.baidu.swan.apps.am.a tt5 = new com.baidu.swan.apps.am.a().bX(11L).bY(2320L).tt("解压失败：解压文件夹创建失败");
            e.aHz().j(tt5);
            return tt5;
        } else {
            if (DEBUG) {
                Log.i("PkgDownloadUtil", "开始执行解压操作, bundle:" + file.getPath() + " , folder:" + bG.getPath());
            }
            if (a(file, bG, dVar).czS) {
                return null;
            }
            C0403a a2 = a(file, bG, dVar);
            if (a2.czS) {
                f.a(dVar, eVar.category, true);
                return null;
            }
            f.a(dVar, eVar.category, false);
            com.baidu.swan.c.d.safeDeleteFile(bG);
            com.baidu.swan.apps.am.a aVar = new com.baidu.swan.apps.am.a();
            switch (a2.czR) {
                case 0:
                    aVar.bX(11L).bY(2320L).tt("unzip failed");
                    break;
                case 1:
                case 2:
                    aVar.bX(11L).bY(2330L).tt("decryt failed:" + a2.czT + ", PkgType=" + a2.czR);
                    break;
                default:
                    aVar.bX(4L).bY(7L).tt("Unkown bundle type");
                    break;
            }
            e.aHz().j(aVar);
            return aVar;
        }
    }

    @NonNull
    private static C0403a a(@NonNull File file, @NonNull File file2, @NonNull com.baidu.swan.pms.a.d dVar) {
        int i;
        C0403a c0403a = new C0403a();
        long currentTimeMillis = System.currentTimeMillis();
        a.b B = com.baidu.swan.apps.r.a.a.B(file);
        if (B.type != -1) {
            dVar.bk("670", "package_start_decrypt");
            dVar.bk("770", "na_package_start_decrypt");
            a.C0437a a2 = com.baidu.swan.apps.r.a.a.a(B.cJi, file2, B.type);
            dVar.bk("670", "package_end_decrypt");
            dVar.bk("770", "na_package_end_decrypt");
            c0403a.czS = a2.isSuccess;
            c0403a.czT = a2.czT;
            c0403a.czR = B.type;
            i = B.type;
        } else {
            c0403a.czR = 0;
            dVar.bk("670", "package_start_unzip");
            dVar.bk("770", "na_package_start_unzip");
            c0403a.czS = com.baidu.swan.c.d.unzipFile(file.getPath(), file2.getPath());
            dVar.bk("670", "package_end_unzip");
            dVar.bk("770", "na_package_end_unzip");
            i = 0;
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        if (DEBUG) {
            com.baidu.swan.apps.r.a.a.iE((int) (currentTimeMillis2 - currentTimeMillis));
        }
        Bundle bundle = new Bundle();
        bundle.putInt("download_package_type_id", i);
        h.a(dVar, bundle, "event_download_package_type");
        return c0403a;
    }

    public static void g(@Nullable PMSAppInfo pMSAppInfo) {
        if (pMSAppInfo != null) {
            if (!TextUtils.isEmpty(pMSAppInfo.webViewDomains)) {
                com.baidu.swan.apps.ag.a.c.a(pMSAppInfo.appId, "", v.tH(pMSAppInfo.webViewDomains));
            }
            if (!TextUtils.isEmpty(pMSAppInfo.webAction)) {
                com.baidu.swan.apps.ag.a.c.a("", v.tH(pMSAppInfo.webAction));
            }
            if (!TextUtils.isEmpty(pMSAppInfo.domains)) {
                com.baidu.swan.apps.ag.a.c.g(pMSAppInfo.appId, v.parseString(pMSAppInfo.domains));
            }
        }
    }

    public static void a(PMSAppInfo pMSAppInfo, com.baidu.swan.pms.model.f fVar) {
        com.baidu.swan.games.t.a.a i;
        if (pMSAppInfo != null && fVar != null) {
            pMSAppInfo.h(fVar);
            if (fVar.category == 1 && (i = i(fVar.dTs, fVar.versionCode)) != null) {
                pMSAppInfo.setOrientation(i.dJU);
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
    public static void ams() {
        if (!czP) {
            synchronized (a.class) {
                if (!czP) {
                    czP = true;
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
