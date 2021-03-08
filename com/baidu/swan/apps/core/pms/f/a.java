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
/* loaded from: classes8.dex */
public final class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static boolean cXl = false;

    /* renamed from: com.baidu.swan.apps.core.pms.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0417a {
        public int cXn = 0;
        public boolean cXo = false;
        public String cXp = "";
    }

    public static String arg() {
        return d.C0452d.awT().getPath();
    }

    public static String arh() {
        return a.c.awT().getPath();
    }

    public static String ari() {
        return d.C0452d.awT().getPath();
    }

    public static String ara() {
        return d.C0452d.awT().getPath();
    }

    public static String arj() {
        return a.c.awT().getPath();
    }

    public static String ark() {
        return a.c.awT().getPath();
    }

    public static com.baidu.swan.games.t.a.a j(String str, long j) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return com.baidu.swan.games.t.a.a.xk(com.baidu.swan.c.d.readFileData(new File(a.c.bL(str, String.valueOf(j)), "game.json")));
    }

    public static com.baidu.swan.apps.al.a a(ReadableByteChannel readableByteChannel, String str, com.baidu.swan.pms.a.d dVar) throws IOException {
        if (readableByteChannel == null) {
            com.baidu.swan.apps.al.a tO = new com.baidu.swan.apps.al.a().db(11L).dc(2300L).tO("empty source");
            e.aNm().j(tO);
            if (DEBUG) {
                Log.i("PkgDownloadUtil", "checkPkgZipSign err: " + tO);
                return tO;
            }
            return tO;
        }
        dVar.bp("670", "aiapp_aps_check_sign_start_timestamp");
        dVar.bp("770", "na_pms_start_check_sign");
        if (ae.a(readableByteChannel, str, new com.baidu.swan.apps.ao.a.c())) {
            dVar.bp("670", "aiapp_aps_check_sign_end_timestamp");
            dVar.bp("770", "na_pms_end_check_sign");
            return null;
        }
        com.baidu.swan.apps.al.a tO2 = new com.baidu.swan.apps.al.a().db(11L).dc(2300L).tO("check zip file sign fail.");
        e.aNm().j(tO2);
        if (DEBUG) {
            Log.i("PkgDownloadUtil", "checkPkgZipSign err: " + tO2);
            return tO2;
        }
        return tO2;
    }

    public static com.baidu.swan.apps.al.a a(com.baidu.swan.pms.model.e eVar, com.baidu.swan.pms.a.d dVar) {
        File bL;
        if (eVar == null) {
            com.baidu.swan.apps.al.a tO = new com.baidu.swan.apps.al.a().db(11L).dc(2320L).tO("pkg info is empty");
            e.aNm().j(tO);
            return tO;
        }
        File file = new File(eVar.filePath);
        if (eVar.category == 1) {
            bL = a.c.bL(eVar.evD, String.valueOf(eVar.versionCode));
        } else if (eVar.category == 0) {
            bL = d.C0452d.bL(eVar.evD, String.valueOf(eVar.versionCode));
        } else {
            com.baidu.swan.apps.al.a tO2 = new com.baidu.swan.apps.al.a().db(11L).dc(2320L).tO("pkh category illegal");
            e.aNm().j(tO2);
            return tO2;
        }
        if (!file.exists()) {
            com.baidu.swan.apps.al.a tO3 = new com.baidu.swan.apps.al.a().db(11L).dc(2320L).tO("解压失败：包不存在");
            e.aNm().j(tO3);
            return tO3;
        } else if (bL.isFile() && !bL.delete()) {
            if (DEBUG) {
                Log.e("PkgDownloadUtil", "解压失败：解压目录被文件占用，且无法删除");
            }
            com.baidu.swan.apps.al.a tO4 = new com.baidu.swan.apps.al.a().db(11L).dc(2320L).tO("解压失败：解压目录被文件占用，且无法删除");
            e.aNm().j(tO4);
            return tO4;
        } else if (!bL.exists() && !bL.mkdirs()) {
            if (DEBUG) {
                Log.e("PkgDownloadUtil", "解压失败：解压文件夹创建失败 " + bL.getAbsolutePath());
            }
            com.baidu.swan.apps.al.a tO5 = new com.baidu.swan.apps.al.a().db(11L).dc(2320L).tO("解压失败：解压文件夹创建失败");
            e.aNm().j(tO5);
            return tO5;
        } else {
            if (DEBUG) {
                Log.i("PkgDownloadUtil", "开始执行解压操作, bundle:" + file.getPath() + " , folder:" + bL.getPath());
            }
            if (a(file, bL, dVar).cXo) {
                return null;
            }
            C0417a a2 = a(file, bL, dVar);
            if (a2.cXo) {
                f.a(dVar, eVar.category, true);
                return null;
            }
            f.a(dVar, eVar.category, false);
            com.baidu.swan.c.d.safeDeleteFile(bL);
            com.baidu.swan.apps.al.a aVar = new com.baidu.swan.apps.al.a();
            switch (a2.cXn) {
                case 0:
                    aVar.db(11L).dc(2320L).tO("unzip failed");
                    break;
                case 1:
                case 2:
                    aVar.db(11L).dc(2330L).tO("decryt failed:" + a2.cXp + ", PkgType=" + a2.cXn);
                    break;
                default:
                    aVar.db(4L).dc(7L).tO("Unkown bundle type");
                    break;
            }
            e.aNm().j(aVar);
            return aVar;
        }
    }

    @NonNull
    private static C0417a a(@NonNull File file, @NonNull File file2, @NonNull com.baidu.swan.pms.a.d dVar) {
        int i;
        C0417a c0417a = new C0417a();
        long currentTimeMillis = System.currentTimeMillis();
        a.b y = com.baidu.swan.apps.r.a.a.y(file);
        if (y.type != -1) {
            dVar.bp("670", "package_start_decrypt");
            dVar.bp("770", "na_package_start_decrypt");
            a.C0451a a2 = com.baidu.swan.apps.r.a.a.a(y.dgD, file2, y.type);
            dVar.bp("670", "package_end_decrypt");
            dVar.bp("770", "na_package_end_decrypt");
            c0417a.cXo = a2.isSuccess;
            c0417a.cXp = a2.cXp;
            c0417a.cXn = y.type;
            i = y.type;
        } else {
            c0417a.cXn = 0;
            dVar.bp("670", "package_start_unzip");
            dVar.bp("770", "na_package_start_unzip");
            c0417a.cXo = com.baidu.swan.c.d.unzipFile(file.getPath(), file2.getPath());
            dVar.bp("670", "package_end_unzip");
            dVar.bp("770", "na_package_end_unzip");
            i = 0;
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        if (DEBUG) {
            com.baidu.swan.apps.r.a.a.hM((int) (currentTimeMillis2 - currentTimeMillis));
        }
        Bundle bundle = new Bundle();
        bundle.putInt("download_package_type_id", i);
        h.a(dVar, bundle, "event_download_package_type");
        return c0417a;
    }

    public static void g(@Nullable PMSAppInfo pMSAppInfo) {
        if (pMSAppInfo != null) {
            if (!TextUtils.isEmpty(pMSAppInfo.webViewDomains)) {
                com.baidu.swan.apps.af.a.c.a(pMSAppInfo.appId, "", v.ue(pMSAppInfo.webViewDomains));
            }
            if (!TextUtils.isEmpty(pMSAppInfo.webAction)) {
                com.baidu.swan.apps.af.a.c.b("", v.ue(pMSAppInfo.webAction));
            }
            if (!TextUtils.isEmpty(pMSAppInfo.domains)) {
                com.baidu.swan.apps.af.a.c.k(pMSAppInfo.appId, v.parseString(pMSAppInfo.domains));
            }
        }
    }

    public static void a(PMSAppInfo pMSAppInfo, com.baidu.swan.pms.model.f fVar) {
        com.baidu.swan.games.t.a.a j;
        if (pMSAppInfo != null && fVar != null) {
            pMSAppInfo.h(fVar);
            if (fVar.category == 1 && (j = j(fVar.evD, fVar.versionCode)) != null) {
                pMSAppInfo.setOrientation(j.elt);
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
    public static void arl() {
        if (!cXl) {
            synchronized (a.class) {
                if (!cXl) {
                    cXl = true;
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
