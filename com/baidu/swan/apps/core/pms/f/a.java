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
/* loaded from: classes8.dex */
public final class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static boolean clw = false;

    /* renamed from: com.baidu.swan.apps.core.pms.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0391a {
        public int cly = 0;
        public boolean clz = false;
        public String clA = "";
    }

    public static String aiS() {
        return d.C0426d.aoD().getPath();
    }

    public static String aiT() {
        return a.c.aoD().getPath();
    }

    public static String aiU() {
        return d.C0426d.aoD().getPath();
    }

    public static String aiM() {
        return d.C0426d.aoD().getPath();
    }

    public static String aiV() {
        return a.c.aoD().getPath();
    }

    public static String aiW() {
        return a.c.aoD().getPath();
    }

    public static com.baidu.swan.games.t.a.a i(String str, long j) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return com.baidu.swan.games.t.a.a.vI(com.baidu.swan.c.d.readFileData(new File(a.c.bB(str, String.valueOf(j)), "game.json")));
    }

    public static com.baidu.swan.apps.am.a a(ReadableByteChannel readableByteChannel, String str, com.baidu.swan.pms.a.d dVar) throws IOException {
        if (readableByteChannel == null) {
            com.baidu.swan.apps.am.a sn = new com.baidu.swan.apps.am.a().bO(11L).bP(2300L).sn("empty source");
            e.aEg().j(sn);
            if (DEBUG) {
                Log.i("PkgDownloadUtil", "checkPkgZipSign err: " + sn);
                return sn;
            }
            return sn;
        }
        dVar.bf("670", "aiapp_aps_check_sign_start_timestamp");
        dVar.bf("770", "na_pms_start_check_sign");
        if (ae.a(readableByteChannel, str, new com.baidu.swan.apps.ap.a.c())) {
            dVar.bf("670", "aiapp_aps_check_sign_end_timestamp");
            dVar.bf("770", "na_pms_end_check_sign");
            return null;
        }
        com.baidu.swan.apps.am.a sn2 = new com.baidu.swan.apps.am.a().bO(11L).bP(2300L).sn("check zip file sign fail.");
        e.aEg().j(sn2);
        if (DEBUG) {
            Log.i("PkgDownloadUtil", "checkPkgZipSign err: " + sn2);
            return sn2;
        }
        return sn2;
    }

    public static com.baidu.swan.apps.am.a a(com.baidu.swan.pms.model.e eVar, com.baidu.swan.pms.a.d dVar) {
        File bB;
        if (eVar == null) {
            com.baidu.swan.apps.am.a sn = new com.baidu.swan.apps.am.a().bO(11L).bP(2320L).sn("pkg info is empty");
            e.aEg().j(sn);
            return sn;
        }
        File file = new File(eVar.filePath);
        if (eVar.category == 1) {
            bB = a.c.bB(eVar.dFn, String.valueOf(eVar.versionCode));
        } else if (eVar.category == 0) {
            bB = d.C0426d.bB(eVar.dFn, String.valueOf(eVar.versionCode));
        } else {
            com.baidu.swan.apps.am.a sn2 = new com.baidu.swan.apps.am.a().bO(11L).bP(2320L).sn("pkh category illegal");
            e.aEg().j(sn2);
            return sn2;
        }
        if (!file.exists()) {
            com.baidu.swan.apps.am.a sn3 = new com.baidu.swan.apps.am.a().bO(11L).bP(2320L).sn("解压失败：包不存在");
            e.aEg().j(sn3);
            return sn3;
        } else if (bB.isFile() && !bB.delete()) {
            if (DEBUG) {
                Log.e("PkgDownloadUtil", "解压失败：解压目录被文件占用，且无法删除");
            }
            com.baidu.swan.apps.am.a sn4 = new com.baidu.swan.apps.am.a().bO(11L).bP(2320L).sn("解压失败：解压目录被文件占用，且无法删除");
            e.aEg().j(sn4);
            return sn4;
        } else if (!bB.exists() && !bB.mkdirs()) {
            if (DEBUG) {
                Log.e("PkgDownloadUtil", "解压失败：解压文件夹创建失败 " + bB.getAbsolutePath());
            }
            com.baidu.swan.apps.am.a sn5 = new com.baidu.swan.apps.am.a().bO(11L).bP(2320L).sn("解压失败：解压文件夹创建失败");
            e.aEg().j(sn5);
            return sn5;
        } else {
            if (DEBUG) {
                Log.i("PkgDownloadUtil", "开始执行解压操作, bundle:" + file.getPath() + " , folder:" + bB.getPath());
            }
            if (a(file, bB, dVar).clz) {
                return null;
            }
            C0391a a = a(file, bB, dVar);
            if (a.clz) {
                f.a(dVar, eVar.category, true);
                return null;
            }
            f.a(dVar, eVar.category, false);
            com.baidu.swan.c.d.safeDeleteFile(bB);
            com.baidu.swan.apps.am.a aVar = new com.baidu.swan.apps.am.a();
            switch (a.cly) {
                case 0:
                    aVar.bO(11L).bP(2320L).sn("unzip failed");
                    break;
                case 1:
                case 2:
                    aVar.bO(11L).bP(2330L).sn("decryt failed:" + a.clA + ", PkgType=" + a.cly);
                    break;
                default:
                    aVar.bO(4L).bP(7L).sn("Unkown bundle type");
                    break;
            }
            e.aEg().j(aVar);
            return aVar;
        }
    }

    @NonNull
    private static C0391a a(@NonNull File file, @NonNull File file2, @NonNull com.baidu.swan.pms.a.d dVar) {
        int i;
        C0391a c0391a = new C0391a();
        long currentTimeMillis = System.currentTimeMillis();
        a.b y = com.baidu.swan.apps.r.a.a.y(file);
        if (y.type != -1) {
            dVar.bf("670", "package_start_decrypt");
            dVar.bf("770", "na_package_start_decrypt");
            a.C0425a a = com.baidu.swan.apps.r.a.a.a(y.cvc, file2, y.type);
            dVar.bf("670", "package_end_decrypt");
            dVar.bf("770", "na_package_end_decrypt");
            c0391a.clz = a.isSuccess;
            c0391a.clA = a.clA;
            c0391a.cly = y.type;
            i = y.type;
        } else {
            c0391a.cly = 0;
            dVar.bf("670", "package_start_unzip");
            dVar.bf("770", "na_package_start_unzip");
            c0391a.clz = com.baidu.swan.c.d.unzipFile(file.getPath(), file2.getPath());
            dVar.bf("670", "package_end_unzip");
            dVar.bf("770", "na_package_end_unzip");
            i = 0;
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        if (DEBUG) {
            com.baidu.swan.apps.r.a.a.hX((int) (currentTimeMillis2 - currentTimeMillis));
        }
        Bundle bundle = new Bundle();
        bundle.putInt("download_package_type_id", i);
        h.a(dVar, bundle, "event_download_package_type");
        return c0391a;
    }

    public static void g(@Nullable PMSAppInfo pMSAppInfo) {
        if (pMSAppInfo != null) {
            if (!TextUtils.isEmpty(pMSAppInfo.webViewDomains)) {
                com.baidu.swan.apps.ag.a.c.a(pMSAppInfo.appId, "", v.sC(pMSAppInfo.webViewDomains));
            }
            if (!TextUtils.isEmpty(pMSAppInfo.webAction)) {
                com.baidu.swan.apps.ag.a.c.a("", v.sC(pMSAppInfo.webAction));
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
            if (fVar.category == 1 && (i = i(fVar.dFn, fVar.versionCode)) != null) {
                pMSAppInfo.setOrientation(i.dvS);
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
    public static void aiX() {
        if (!clw) {
            synchronized (a.class) {
                if (!clw) {
                    clw = true;
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
