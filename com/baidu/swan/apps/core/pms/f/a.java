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
    private static boolean cVL = false;

    /* renamed from: com.baidu.swan.apps.core.pms.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C0411a {
        public int cVN = 0;
        public boolean cVO = false;
        public String cVP = "";
    }

    public static String ard() {
        return d.C0446d.awQ().getPath();
    }

    public static String are() {
        return a.c.awQ().getPath();
    }

    public static String arf() {
        return d.C0446d.awQ().getPath();
    }

    public static String aqX() {
        return d.C0446d.awQ().getPath();
    }

    public static String arg() {
        return a.c.awQ().getPath();
    }

    public static String arh() {
        return a.c.awQ().getPath();
    }

    public static com.baidu.swan.games.t.a.a j(String str, long j) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return com.baidu.swan.games.t.a.a.xd(com.baidu.swan.c.d.readFileData(new File(a.c.bL(str, String.valueOf(j)), "game.json")));
    }

    public static com.baidu.swan.apps.al.a a(ReadableByteChannel readableByteChannel, String str, com.baidu.swan.pms.a.d dVar) throws IOException {
        if (readableByteChannel == null) {
            com.baidu.swan.apps.al.a tH = new com.baidu.swan.apps.al.a().db(11L).dc(2300L).tH("empty source");
            e.aNj().j(tH);
            if (DEBUG) {
                Log.i("PkgDownloadUtil", "checkPkgZipSign err: " + tH);
                return tH;
            }
            return tH;
        }
        dVar.bp("670", "aiapp_aps_check_sign_start_timestamp");
        dVar.bp("770", "na_pms_start_check_sign");
        if (ae.a(readableByteChannel, str, new com.baidu.swan.apps.ao.a.c())) {
            dVar.bp("670", "aiapp_aps_check_sign_end_timestamp");
            dVar.bp("770", "na_pms_end_check_sign");
            return null;
        }
        com.baidu.swan.apps.al.a tH2 = new com.baidu.swan.apps.al.a().db(11L).dc(2300L).tH("check zip file sign fail.");
        e.aNj().j(tH2);
        if (DEBUG) {
            Log.i("PkgDownloadUtil", "checkPkgZipSign err: " + tH2);
            return tH2;
        }
        return tH2;
    }

    public static com.baidu.swan.apps.al.a a(com.baidu.swan.pms.model.e eVar, com.baidu.swan.pms.a.d dVar) {
        File bL;
        if (eVar == null) {
            com.baidu.swan.apps.al.a tH = new com.baidu.swan.apps.al.a().db(11L).dc(2320L).tH("pkg info is empty");
            e.aNj().j(tH);
            return tH;
        }
        File file = new File(eVar.filePath);
        if (eVar.category == 1) {
            bL = a.c.bL(eVar.euc, String.valueOf(eVar.versionCode));
        } else if (eVar.category == 0) {
            bL = d.C0446d.bL(eVar.euc, String.valueOf(eVar.versionCode));
        } else {
            com.baidu.swan.apps.al.a tH2 = new com.baidu.swan.apps.al.a().db(11L).dc(2320L).tH("pkh category illegal");
            e.aNj().j(tH2);
            return tH2;
        }
        if (!file.exists()) {
            com.baidu.swan.apps.al.a tH3 = new com.baidu.swan.apps.al.a().db(11L).dc(2320L).tH("解压失败：包不存在");
            e.aNj().j(tH3);
            return tH3;
        } else if (bL.isFile() && !bL.delete()) {
            if (DEBUG) {
                Log.e("PkgDownloadUtil", "解压失败：解压目录被文件占用，且无法删除");
            }
            com.baidu.swan.apps.al.a tH4 = new com.baidu.swan.apps.al.a().db(11L).dc(2320L).tH("解压失败：解压目录被文件占用，且无法删除");
            e.aNj().j(tH4);
            return tH4;
        } else if (!bL.exists() && !bL.mkdirs()) {
            if (DEBUG) {
                Log.e("PkgDownloadUtil", "解压失败：解压文件夹创建失败 " + bL.getAbsolutePath());
            }
            com.baidu.swan.apps.al.a tH5 = new com.baidu.swan.apps.al.a().db(11L).dc(2320L).tH("解压失败：解压文件夹创建失败");
            e.aNj().j(tH5);
            return tH5;
        } else {
            if (DEBUG) {
                Log.i("PkgDownloadUtil", "开始执行解压操作, bundle:" + file.getPath() + " , folder:" + bL.getPath());
            }
            if (a(file, bL, dVar).cVO) {
                return null;
            }
            C0411a a2 = a(file, bL, dVar);
            if (a2.cVO) {
                f.a(dVar, eVar.category, true);
                return null;
            }
            f.a(dVar, eVar.category, false);
            com.baidu.swan.c.d.safeDeleteFile(bL);
            com.baidu.swan.apps.al.a aVar = new com.baidu.swan.apps.al.a();
            switch (a2.cVN) {
                case 0:
                    aVar.db(11L).dc(2320L).tH("unzip failed");
                    break;
                case 1:
                case 2:
                    aVar.db(11L).dc(2330L).tH("decryt failed:" + a2.cVP + ", PkgType=" + a2.cVN);
                    break;
                default:
                    aVar.db(4L).dc(7L).tH("Unkown bundle type");
                    break;
            }
            e.aNj().j(aVar);
            return aVar;
        }
    }

    @NonNull
    private static C0411a a(@NonNull File file, @NonNull File file2, @NonNull com.baidu.swan.pms.a.d dVar) {
        int i;
        C0411a c0411a = new C0411a();
        long currentTimeMillis = System.currentTimeMillis();
        a.b y = com.baidu.swan.apps.r.a.a.y(file);
        if (y.type != -1) {
            dVar.bp("670", "package_start_decrypt");
            dVar.bp("770", "na_package_start_decrypt");
            a.C0445a a2 = com.baidu.swan.apps.r.a.a.a(y.dfc, file2, y.type);
            dVar.bp("670", "package_end_decrypt");
            dVar.bp("770", "na_package_end_decrypt");
            c0411a.cVO = a2.isSuccess;
            c0411a.cVP = a2.cVP;
            c0411a.cVN = y.type;
            i = y.type;
        } else {
            c0411a.cVN = 0;
            dVar.bp("670", "package_start_unzip");
            dVar.bp("770", "na_package_start_unzip");
            c0411a.cVO = com.baidu.swan.c.d.unzipFile(file.getPath(), file2.getPath());
            dVar.bp("670", "package_end_unzip");
            dVar.bp("770", "na_package_end_unzip");
            i = 0;
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        if (DEBUG) {
            com.baidu.swan.apps.r.a.a.hL((int) (currentTimeMillis2 - currentTimeMillis));
        }
        Bundle bundle = new Bundle();
        bundle.putInt("download_package_type_id", i);
        h.a(dVar, bundle, "event_download_package_type");
        return c0411a;
    }

    public static void g(@Nullable PMSAppInfo pMSAppInfo) {
        if (pMSAppInfo != null) {
            if (!TextUtils.isEmpty(pMSAppInfo.webViewDomains)) {
                com.baidu.swan.apps.af.a.c.a(pMSAppInfo.appId, "", v.tX(pMSAppInfo.webViewDomains));
            }
            if (!TextUtils.isEmpty(pMSAppInfo.webAction)) {
                com.baidu.swan.apps.af.a.c.b("", v.tX(pMSAppInfo.webAction));
            }
            if (!TextUtils.isEmpty(pMSAppInfo.domains)) {
                com.baidu.swan.apps.af.a.c.j(pMSAppInfo.appId, v.parseString(pMSAppInfo.domains));
            }
        }
    }

    public static void a(PMSAppInfo pMSAppInfo, com.baidu.swan.pms.model.f fVar) {
        com.baidu.swan.games.t.a.a j;
        if (pMSAppInfo != null && fVar != null) {
            pMSAppInfo.h(fVar);
            if (fVar.category == 1 && (j = j(fVar.euc, fVar.versionCode)) != null) {
                pMSAppInfo.setOrientation(j.ejS);
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
    public static void ari() {
        if (!cVL) {
            synchronized (a.class) {
                if (!cVL) {
                    cVL = true;
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
