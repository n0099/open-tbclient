package com.baidu.swan.apps.core.pms.f;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.al.e;
import com.baidu.swan.apps.ao.ae;
import com.baidu.swan.apps.ao.p;
import com.baidu.swan.apps.ao.v;
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
/* loaded from: classes9.dex */
public final class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static boolean cYk = false;

    /* renamed from: com.baidu.swan.apps.core.pms.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C0431a {
        public int cYm = 0;
        public boolean cYn = false;
        public String cYo = "";
    }

    public static String auz() {
        return d.C0466d.aAl().getPath();
    }

    public static String auA() {
        return a.c.aAl().getPath();
    }

    public static String auB() {
        return d.C0466d.aAl().getPath();
    }

    public static String aut() {
        return d.C0466d.aAl().getPath();
    }

    public static String auC() {
        return a.c.aAl().getPath();
    }

    public static String auD() {
        return a.c.aAl().getPath();
    }

    public static com.baidu.swan.games.t.a.a k(String str, long j) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return com.baidu.swan.games.t.a.a.xV(com.baidu.swan.c.d.readFileData(new File(a.c.bS(str, String.valueOf(j)), "game.json")));
    }

    public static com.baidu.swan.apps.al.a a(ReadableByteChannel readableByteChannel, String str, com.baidu.swan.pms.a.d dVar) throws IOException {
        if (readableByteChannel == null) {
            com.baidu.swan.apps.al.a uz = new com.baidu.swan.apps.al.a().cV(11L).cW(2300L).uz("empty source");
            e.aQJ().j(uz);
            if (DEBUG) {
                Log.i("PkgDownloadUtil", "checkPkgZipSign err: " + uz);
                return uz;
            }
            return uz;
        }
        dVar.bw("670", "aiapp_aps_check_sign_start_timestamp");
        dVar.bw("770", "na_pms_start_check_sign");
        if (ae.a(readableByteChannel, str, new com.baidu.swan.apps.ao.a.c())) {
            dVar.bw("670", "aiapp_aps_check_sign_end_timestamp");
            dVar.bw("770", "na_pms_end_check_sign");
            return null;
        }
        com.baidu.swan.apps.al.a uz2 = new com.baidu.swan.apps.al.a().cV(11L).cW(2300L).uz("check zip file sign fail.");
        e.aQJ().j(uz2);
        if (DEBUG) {
            Log.i("PkgDownloadUtil", "checkPkgZipSign err: " + uz2);
            return uz2;
        }
        return uz2;
    }

    public static com.baidu.swan.apps.al.a a(com.baidu.swan.pms.model.e eVar, com.baidu.swan.pms.a.d dVar) {
        File bS;
        if (eVar == null) {
            com.baidu.swan.apps.al.a uz = new com.baidu.swan.apps.al.a().cV(11L).cW(2320L).uz("pkg info is empty");
            e.aQJ().j(uz);
            return uz;
        }
        File file = new File(eVar.filePath);
        if (eVar.category == 1) {
            bS = a.c.bS(eVar.ewI, String.valueOf(eVar.versionCode));
        } else if (eVar.category == 0) {
            bS = d.C0466d.bS(eVar.ewI, String.valueOf(eVar.versionCode));
        } else {
            com.baidu.swan.apps.al.a uz2 = new com.baidu.swan.apps.al.a().cV(11L).cW(2320L).uz("pkh category illegal");
            e.aQJ().j(uz2);
            return uz2;
        }
        if (!file.exists()) {
            com.baidu.swan.apps.al.a uz3 = new com.baidu.swan.apps.al.a().cV(11L).cW(2320L).uz("解压失败：包不存在");
            e.aQJ().j(uz3);
            return uz3;
        } else if (bS.isFile() && !bS.delete()) {
            if (DEBUG) {
                Log.e("PkgDownloadUtil", "解压失败：解压目录被文件占用，且无法删除");
            }
            com.baidu.swan.apps.al.a uz4 = new com.baidu.swan.apps.al.a().cV(11L).cW(2320L).uz("解压失败：解压目录被文件占用，且无法删除");
            e.aQJ().j(uz4);
            return uz4;
        } else if (!bS.exists() && !bS.mkdirs()) {
            if (DEBUG) {
                Log.e("PkgDownloadUtil", "解压失败：解压文件夹创建失败 " + bS.getAbsolutePath());
            }
            com.baidu.swan.apps.al.a uz5 = new com.baidu.swan.apps.al.a().cV(11L).cW(2320L).uz("解压失败：解压文件夹创建失败");
            e.aQJ().j(uz5);
            return uz5;
        } else {
            if (DEBUG) {
                Log.i("PkgDownloadUtil", "开始执行解压操作, bundle:" + file.getPath() + " , folder:" + bS.getPath());
            }
            if (a(file, bS, dVar).cYn) {
                return null;
            }
            C0431a a2 = a(file, bS, dVar);
            if (a2.cYn) {
                f.a(dVar, eVar.category, true);
                return null;
            }
            f.a(dVar, eVar.category, false);
            com.baidu.swan.c.d.safeDeleteFile(bS);
            com.baidu.swan.apps.al.a aVar = new com.baidu.swan.apps.al.a();
            switch (a2.cYm) {
                case 0:
                    aVar.cV(11L).cW(2320L).uz("unzip failed");
                    break;
                case 1:
                case 2:
                    aVar.cV(11L).cW(2330L).uz("decryt failed:" + a2.cYo + ", PkgType=" + a2.cYm);
                    break;
                default:
                    aVar.cV(4L).cW(7L).uz("Unkown bundle type");
                    break;
            }
            e.aQJ().j(aVar);
            return aVar;
        }
    }

    @NonNull
    private static C0431a a(@NonNull File file, @NonNull File file2, @NonNull com.baidu.swan.pms.a.d dVar) {
        int i;
        C0431a c0431a = new C0431a();
        long currentTimeMillis = System.currentTimeMillis();
        a.b D = com.baidu.swan.apps.r.a.a.D(file);
        if (D.type != -1) {
            dVar.bw("670", "package_start_decrypt");
            dVar.bw("770", "na_package_start_decrypt");
            a.C0465a a2 = com.baidu.swan.apps.r.a.a.a(D.dhD, file2, D.type);
            dVar.bw("670", "package_end_decrypt");
            dVar.bw("770", "na_package_end_decrypt");
            c0431a.cYn = a2.isSuccess;
            c0431a.cYo = a2.cYo;
            c0431a.cYm = D.type;
            i = D.type;
        } else {
            c0431a.cYm = 0;
            dVar.bw("670", "package_start_unzip");
            dVar.bw("770", "na_package_start_unzip");
            c0431a.cYn = com.baidu.swan.c.d.unzipFile(file.getPath(), file2.getPath());
            dVar.bw("670", "package_end_unzip");
            dVar.bw("770", "na_package_end_unzip");
            i = 0;
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        if (DEBUG) {
            com.baidu.swan.apps.r.a.a.jo((int) (currentTimeMillis2 - currentTimeMillis));
        }
        Bundle bundle = new Bundle();
        bundle.putInt("download_package_type_id", i);
        h.a(dVar, bundle, "event_download_package_type");
        return c0431a;
    }

    public static void g(@Nullable PMSAppInfo pMSAppInfo) {
        if (pMSAppInfo != null) {
            if (!TextUtils.isEmpty(pMSAppInfo.webViewDomains)) {
                com.baidu.swan.apps.af.a.c.a(pMSAppInfo.appId, "", v.uP(pMSAppInfo.webViewDomains));
            }
            if (!TextUtils.isEmpty(pMSAppInfo.webAction)) {
                com.baidu.swan.apps.af.a.c.b("", v.uP(pMSAppInfo.webAction));
            }
            if (!TextUtils.isEmpty(pMSAppInfo.domains)) {
                com.baidu.swan.apps.af.a.c.j(pMSAppInfo.appId, v.parseString(pMSAppInfo.domains));
            }
        }
    }

    public static void a(PMSAppInfo pMSAppInfo, com.baidu.swan.pms.model.f fVar) {
        com.baidu.swan.games.t.a.a k;
        if (pMSAppInfo != null && fVar != null) {
            pMSAppInfo.h(fVar);
            if (fVar.category == 1 && (k = k(fVar.ewI, fVar.versionCode)) != null) {
                pMSAppInfo.setOrientation(k.emx);
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
    public static void auE() {
        if (!cYk) {
            synchronized (a.class) {
                if (!cYk) {
                    cYk = true;
                    final File file = new File(AppRuntime.getAppContext().getFilesDir(), "aiapps_zip");
                    if (file.exists()) {
                        p.a(new Runnable() { // from class: com.baidu.swan.apps.core.pms.f.a.1
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
