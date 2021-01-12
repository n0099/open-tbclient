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
    private static boolean cTy = false;

    /* renamed from: com.baidu.swan.apps.core.pms.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0414a {
        public int cTA = 0;
        public boolean cTB = false;
        public String cTC = "";
    }

    public static String aqF() {
        return d.C0449d.aws().getPath();
    }

    public static String aqG() {
        return a.c.aws().getPath();
    }

    public static String aqH() {
        return d.C0449d.aws().getPath();
    }

    public static String aqz() {
        return d.C0449d.aws().getPath();
    }

    public static String aqI() {
        return a.c.aws().getPath();
    }

    public static String aqJ() {
        return a.c.aws().getPath();
    }

    public static com.baidu.swan.games.t.a.a k(String str, long j) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return com.baidu.swan.games.t.a.a.wK(com.baidu.swan.c.d.readFileData(new File(a.c.bR(str, String.valueOf(j)), "game.json")));
    }

    public static com.baidu.swan.apps.al.a a(ReadableByteChannel readableByteChannel, String str, com.baidu.swan.pms.a.d dVar) throws IOException {
        if (readableByteChannel == null) {
            com.baidu.swan.apps.al.a aVar = new com.baidu.swan.apps.al.a().cV(11L).cW(2300L).to("empty source");
            e.aMQ().j(aVar);
            if (DEBUG) {
                Log.i("PkgDownloadUtil", "checkPkgZipSign err: " + aVar);
                return aVar;
            }
            return aVar;
        }
        dVar.bv("670", "aiapp_aps_check_sign_start_timestamp");
        dVar.bv("770", "na_pms_start_check_sign");
        if (ae.a(readableByteChannel, str, new com.baidu.swan.apps.ao.a.c())) {
            dVar.bv("670", "aiapp_aps_check_sign_end_timestamp");
            dVar.bv("770", "na_pms_end_check_sign");
            return null;
        }
        com.baidu.swan.apps.al.a aVar2 = new com.baidu.swan.apps.al.a().cV(11L).cW(2300L).to("check zip file sign fail.");
        e.aMQ().j(aVar2);
        if (DEBUG) {
            Log.i("PkgDownloadUtil", "checkPkgZipSign err: " + aVar2);
            return aVar2;
        }
        return aVar2;
    }

    public static com.baidu.swan.apps.al.a a(com.baidu.swan.pms.model.e eVar, com.baidu.swan.pms.a.d dVar) {
        File bR;
        if (eVar == null) {
            com.baidu.swan.apps.al.a aVar = new com.baidu.swan.apps.al.a().cV(11L).cW(2320L).to("pkg info is empty");
            e.aMQ().j(aVar);
            return aVar;
        }
        File file = new File(eVar.filePath);
        if (eVar.category == 1) {
            bR = a.c.bR(eVar.erV, String.valueOf(eVar.versionCode));
        } else if (eVar.category == 0) {
            bR = d.C0449d.bR(eVar.erV, String.valueOf(eVar.versionCode));
        } else {
            com.baidu.swan.apps.al.a aVar2 = new com.baidu.swan.apps.al.a().cV(11L).cW(2320L).to("pkh category illegal");
            e.aMQ().j(aVar2);
            return aVar2;
        }
        if (!file.exists()) {
            com.baidu.swan.apps.al.a aVar3 = new com.baidu.swan.apps.al.a().cV(11L).cW(2320L).to("解压失败：包不存在");
            e.aMQ().j(aVar3);
            return aVar3;
        } else if (bR.isFile() && !bR.delete()) {
            if (DEBUG) {
                Log.e("PkgDownloadUtil", "解压失败：解压目录被文件占用，且无法删除");
            }
            com.baidu.swan.apps.al.a aVar4 = new com.baidu.swan.apps.al.a().cV(11L).cW(2320L).to("解压失败：解压目录被文件占用，且无法删除");
            e.aMQ().j(aVar4);
            return aVar4;
        } else if (!bR.exists() && !bR.mkdirs()) {
            if (DEBUG) {
                Log.e("PkgDownloadUtil", "解压失败：解压文件夹创建失败 " + bR.getAbsolutePath());
            }
            com.baidu.swan.apps.al.a aVar5 = new com.baidu.swan.apps.al.a().cV(11L).cW(2320L).to("解压失败：解压文件夹创建失败");
            e.aMQ().j(aVar5);
            return aVar5;
        } else {
            if (DEBUG) {
                Log.i("PkgDownloadUtil", "开始执行解压操作, bundle:" + file.getPath() + " , folder:" + bR.getPath());
            }
            if (a(file, bR, dVar).cTB) {
                return null;
            }
            C0414a a2 = a(file, bR, dVar);
            if (a2.cTB) {
                f.a(dVar, eVar.category, true);
                return null;
            }
            f.a(dVar, eVar.category, false);
            com.baidu.swan.c.d.safeDeleteFile(bR);
            com.baidu.swan.apps.al.a aVar6 = new com.baidu.swan.apps.al.a();
            switch (a2.cTA) {
                case 0:
                    aVar6.cV(11L).cW(2320L).to("unzip failed");
                    break;
                case 1:
                case 2:
                    aVar6.cV(11L).cW(2330L).to("decryt failed:" + a2.cTC + ", PkgType=" + a2.cTA);
                    break;
                default:
                    aVar6.cV(4L).cW(7L).to("Unkown bundle type");
                    break;
            }
            e.aMQ().j(aVar6);
            return aVar6;
        }
    }

    @NonNull
    private static C0414a a(@NonNull File file, @NonNull File file2, @NonNull com.baidu.swan.pms.a.d dVar) {
        int i;
        C0414a c0414a = new C0414a();
        long currentTimeMillis = System.currentTimeMillis();
        a.b C = com.baidu.swan.apps.r.a.a.C(file);
        if (C.type != -1) {
            dVar.bv("670", "package_start_decrypt");
            dVar.bv("770", "na_package_start_decrypt");
            a.C0448a a2 = com.baidu.swan.apps.r.a.a.a(C.dcP, file2, C.type);
            dVar.bv("670", "package_end_decrypt");
            dVar.bv("770", "na_package_end_decrypt");
            c0414a.cTB = a2.isSuccess;
            c0414a.cTC = a2.cTC;
            c0414a.cTA = C.type;
            i = C.type;
        } else {
            c0414a.cTA = 0;
            dVar.bv("670", "package_start_unzip");
            dVar.bv("770", "na_package_start_unzip");
            c0414a.cTB = com.baidu.swan.c.d.unzipFile(file.getPath(), file2.getPath());
            dVar.bv("670", "package_end_unzip");
            dVar.bv("770", "na_package_end_unzip");
            i = 0;
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        if (DEBUG) {
            com.baidu.swan.apps.r.a.a.hI((int) (currentTimeMillis2 - currentTimeMillis));
        }
        Bundle bundle = new Bundle();
        bundle.putInt("download_package_type_id", i);
        h.a(dVar, bundle, "event_download_package_type");
        return c0414a;
    }

    public static void g(@Nullable PMSAppInfo pMSAppInfo) {
        if (pMSAppInfo != null) {
            if (!TextUtils.isEmpty(pMSAppInfo.webViewDomains)) {
                com.baidu.swan.apps.af.a.c.a(pMSAppInfo.appId, "", v.tE(pMSAppInfo.webViewDomains));
            }
            if (!TextUtils.isEmpty(pMSAppInfo.webAction)) {
                com.baidu.swan.apps.af.a.c.b("", v.tE(pMSAppInfo.webAction));
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
            if (fVar.category == 1 && (k = k(fVar.erV, fVar.versionCode)) != null) {
                pMSAppInfo.setOrientation(k.ehL);
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
    public static void aqK() {
        if (!cTy) {
            synchronized (a.class) {
                if (!cTy) {
                    cTy = true;
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
