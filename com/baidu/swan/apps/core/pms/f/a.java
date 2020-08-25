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
    private static boolean cls = false;

    /* renamed from: com.baidu.swan.apps.core.pms.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0391a {
        public int clu = 0;
        public boolean clv = false;
        public String clw = "";
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
        return com.baidu.swan.games.t.a.a.vH(com.baidu.swan.c.d.readFileData(new File(a.c.bB(str, String.valueOf(j)), "game.json")));
    }

    public static com.baidu.swan.apps.am.a a(ReadableByteChannel readableByteChannel, String str, com.baidu.swan.pms.a.d dVar) throws IOException {
        if (readableByteChannel == null) {
            com.baidu.swan.apps.am.a sm = new com.baidu.swan.apps.am.a().bO(11L).bP(2300L).sm("empty source");
            e.aEg().j(sm);
            if (DEBUG) {
                Log.i("PkgDownloadUtil", "checkPkgZipSign err: " + sm);
                return sm;
            }
            return sm;
        }
        dVar.bf("670", "aiapp_aps_check_sign_start_timestamp");
        dVar.bf("770", "na_pms_start_check_sign");
        if (ae.a(readableByteChannel, str, new com.baidu.swan.apps.ap.a.c())) {
            dVar.bf("670", "aiapp_aps_check_sign_end_timestamp");
            dVar.bf("770", "na_pms_end_check_sign");
            return null;
        }
        com.baidu.swan.apps.am.a sm2 = new com.baidu.swan.apps.am.a().bO(11L).bP(2300L).sm("check zip file sign fail.");
        e.aEg().j(sm2);
        if (DEBUG) {
            Log.i("PkgDownloadUtil", "checkPkgZipSign err: " + sm2);
            return sm2;
        }
        return sm2;
    }

    public static com.baidu.swan.apps.am.a a(com.baidu.swan.pms.model.e eVar, com.baidu.swan.pms.a.d dVar) {
        File bB;
        if (eVar == null) {
            com.baidu.swan.apps.am.a sm = new com.baidu.swan.apps.am.a().bO(11L).bP(2320L).sm("pkg info is empty");
            e.aEg().j(sm);
            return sm;
        }
        File file = new File(eVar.filePath);
        if (eVar.category == 1) {
            bB = a.c.bB(eVar.dFj, String.valueOf(eVar.versionCode));
        } else if (eVar.category == 0) {
            bB = d.C0426d.bB(eVar.dFj, String.valueOf(eVar.versionCode));
        } else {
            com.baidu.swan.apps.am.a sm2 = new com.baidu.swan.apps.am.a().bO(11L).bP(2320L).sm("pkh category illegal");
            e.aEg().j(sm2);
            return sm2;
        }
        if (!file.exists()) {
            com.baidu.swan.apps.am.a sm3 = new com.baidu.swan.apps.am.a().bO(11L).bP(2320L).sm("解压失败：包不存在");
            e.aEg().j(sm3);
            return sm3;
        } else if (bB.isFile() && !bB.delete()) {
            if (DEBUG) {
                Log.e("PkgDownloadUtil", "解压失败：解压目录被文件占用，且无法删除");
            }
            com.baidu.swan.apps.am.a sm4 = new com.baidu.swan.apps.am.a().bO(11L).bP(2320L).sm("解压失败：解压目录被文件占用，且无法删除");
            e.aEg().j(sm4);
            return sm4;
        } else if (!bB.exists() && !bB.mkdirs()) {
            if (DEBUG) {
                Log.e("PkgDownloadUtil", "解压失败：解压文件夹创建失败 " + bB.getAbsolutePath());
            }
            com.baidu.swan.apps.am.a sm5 = new com.baidu.swan.apps.am.a().bO(11L).bP(2320L).sm("解压失败：解压文件夹创建失败");
            e.aEg().j(sm5);
            return sm5;
        } else {
            if (DEBUG) {
                Log.i("PkgDownloadUtil", "开始执行解压操作, bundle:" + file.getPath() + " , folder:" + bB.getPath());
            }
            if (a(file, bB, dVar).clv) {
                return null;
            }
            C0391a a = a(file, bB, dVar);
            if (a.clv) {
                f.a(dVar, eVar.category, true);
                return null;
            }
            f.a(dVar, eVar.category, false);
            com.baidu.swan.c.d.safeDeleteFile(bB);
            com.baidu.swan.apps.am.a aVar = new com.baidu.swan.apps.am.a();
            switch (a.clu) {
                case 0:
                    aVar.bO(11L).bP(2320L).sm("unzip failed");
                    break;
                case 1:
                case 2:
                    aVar.bO(11L).bP(2330L).sm("decryt failed:" + a.clw + ", PkgType=" + a.clu);
                    break;
                default:
                    aVar.bO(4L).bP(7L).sm("Unkown bundle type");
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
            a.C0425a a = com.baidu.swan.apps.r.a.a.a(y.cuY, file2, y.type);
            dVar.bf("670", "package_end_decrypt");
            dVar.bf("770", "na_package_end_decrypt");
            c0391a.clv = a.isSuccess;
            c0391a.clw = a.clw;
            c0391a.clu = y.type;
            i = y.type;
        } else {
            c0391a.clu = 0;
            dVar.bf("670", "package_start_unzip");
            dVar.bf("770", "na_package_start_unzip");
            c0391a.clv = com.baidu.swan.c.d.unzipFile(file.getPath(), file2.getPath());
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
                com.baidu.swan.apps.ag.a.c.a(pMSAppInfo.appId, "", v.sB(pMSAppInfo.webViewDomains));
            }
            if (!TextUtils.isEmpty(pMSAppInfo.webAction)) {
                com.baidu.swan.apps.ag.a.c.a("", v.sB(pMSAppInfo.webAction));
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
            if (fVar.category == 1 && (i = i(fVar.dFj, fVar.versionCode)) != null) {
                pMSAppInfo.setOrientation(i.dvO);
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
        if (!cls) {
            synchronized (a.class) {
                if (!cls) {
                    cls = true;
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
