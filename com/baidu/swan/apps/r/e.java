package com.baidu.swan.apps.r;

import android.os.Bundle;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.r.a.a;
import com.baidu.swan.apps.r.d;
import com.baidu.swan.apps.r.f;
import com.baidu.swan.games.l.a;
import com.baidu.swan.pms.a.h;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.Channels;
import java.nio.channels.Pipe;
/* loaded from: classes8.dex */
public class e extends f.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final com.baidu.swan.pms.a.d dgn;
    private final com.baidu.swan.pms.model.e dgu;

    public e(com.baidu.swan.pms.model.e eVar, com.baidu.swan.pms.a.d dVar) {
        super("extract");
        this.dgu = eVar;
        this.dgn = dVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.r.f.a
    public void awU() {
        super.awU();
        if (awW().getBoolean("result_output_dir_allow_rollback", false)) {
            com.baidu.swan.c.d.yV(awW().getString("result_output_dir"));
        }
    }

    @Override // com.baidu.swan.apps.r.f.a
    protected boolean a(Pipe.SourceChannel sourceChannel, Bundle bundle) {
        String string = bundle.getString("launch_id");
        com.baidu.swan.apps.u.e.a aVar = null;
        if (DEBUG) {
            aVar = com.baidu.swan.apps.u.e.a.pn(string);
            aVar.azE().pq("SwanExtractor").hU(1);
        }
        boolean h = h(Channels.newInputStream(sourceChannel), string);
        if (aVar != null && DEBUG) {
            aVar.bU("SwanExtractor", "done: " + h);
        }
        return h;
    }

    private boolean h(InputStream inputStream, String str) {
        if (inputStream == null) {
            return false;
        }
        com.baidu.swan.apps.al.a a2 = a(new BufferedInputStream(inputStream), str);
        if (a2 == null) {
            return true;
        }
        if (DEBUG) {
            com.baidu.swan.apps.u.e.a.pn(str).bU("SwanExtractor", "onProcess installe error=" + a2);
        }
        awW().putLong("result_error_code", a2.aNi());
        return false;
    }

    private com.baidu.swan.apps.al.a a(@NonNull BufferedInputStream bufferedInputStream, String str) {
        File bL;
        boolean i;
        com.baidu.swan.apps.u.e.a pn = com.baidu.swan.apps.u.e.a.pn(str);
        if (this.dgu == null) {
            com.baidu.swan.apps.al.a tO = new com.baidu.swan.apps.al.a().db(11L).dc(2320L).tO("pkg info is empty");
            com.baidu.swan.apps.al.e.aNm().j(tO);
            return tO;
        }
        if (this.dgu.category == 1) {
            bL = a.c.bL(this.dgu.evD, String.valueOf(this.dgu.versionCode));
        } else if (this.dgu.category == 0) {
            bL = d.C0452d.bL(this.dgu.evD, String.valueOf(this.dgu.versionCode));
        } else {
            com.baidu.swan.apps.al.a tO2 = new com.baidu.swan.apps.al.a().db(11L).dc(2320L).tO("pkh category illegal");
            com.baidu.swan.apps.al.e.aNm().j(tO2);
            return tO2;
        }
        if (bL.isFile() && !bL.delete()) {
            if (DEBUG) {
                pn.bU("SwanExtractor", "解压失败：解压目录被文件占用，且无法删除");
            }
            com.baidu.swan.apps.al.a tO3 = new com.baidu.swan.apps.al.a().db(11L).dc(2320L).tO("解压失败：解压目录被文件占用，且无法删除");
            com.baidu.swan.apps.al.e.aNm().j(tO3);
            return tO3;
        }
        if (!bL.exists()) {
            awW().putBoolean("result_output_dir_allow_rollback", true);
            if (!bL.mkdirs()) {
                if (DEBUG) {
                    pn.bU("SwanExtractor", "解压失败：解压文件夹创建失败");
                }
                com.baidu.swan.apps.al.a tO4 = new com.baidu.swan.apps.al.a().db(11L).dc(2320L).tO("解压失败：解压文件夹创建失败");
                com.baidu.swan.apps.al.e.aNm().j(tO4);
                return tO4;
            }
        }
        if (DEBUG) {
            pn.bU("SwanExtractor", "开始执行解压操作, folder:" + bL.getPath());
        }
        awW().putString("result_output_dir", bL.toString());
        a.C0451a c0451a = null;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            a.b a2 = com.baidu.swan.apps.r.a.a.a(bufferedInputStream);
            boolean z = false;
            int i2 = a2 == null ? -1 : a2.type;
            if (i2 != -1) {
                z = true;
            }
            fO(z);
            if (z) {
                c0451a = com.baidu.swan.apps.r.a.a.a(bufferedInputStream, bL, i2);
                i = c0451a != null && c0451a.isSuccess;
            } else {
                i = com.baidu.swan.c.f.i(bufferedInputStream, bL.getPath());
                i2 = 0;
            }
            fP(z);
            long currentTimeMillis2 = System.currentTimeMillis();
            if (DEBUG) {
                com.baidu.swan.apps.r.a.a.hM((int) (currentTimeMillis2 - currentTimeMillis));
            }
            if (this.dgn != null) {
                Bundle bundle = new Bundle();
                bundle.putInt("download_package_type_id", i2);
                h.a(this.dgn, bundle, "event_download_package_type");
            }
            if (i) {
                return null;
            }
            com.baidu.swan.apps.al.a db = new com.baidu.swan.apps.al.a().db(11L);
            if (z) {
                db.dc(2330L).tO("decrypt failed:" + c0451a.cXp);
            } else {
                db.dc(2320L).tO("unzip failed");
            }
            com.baidu.swan.apps.al.e.aNm().j(db);
            return db;
        } catch (IOException e) {
            if (DEBUG) {
                pn.bU("SwanExtractor", "obtainEncryptedBundle Exception: " + e.toString());
                e.printStackTrace();
            }
            com.baidu.swan.apps.al.a tO5 = new com.baidu.swan.apps.al.a().db(11L).dc(2320L).tO("obtainEncryptedBundle Exception: " + e.toString());
            com.baidu.swan.apps.al.e.aNm().j(tO5);
            return tO5;
        }
    }

    private void fO(boolean z) {
        if (z) {
            bP("670", "package_start_decrypt");
            bP("770", "na_package_start_decrypt");
            return;
        }
        bP("670", "package_start_unzip");
        bP("770", "na_package_start_unzip");
    }

    private void fP(boolean z) {
        if (z) {
            bP("670", "package_end_decrypt");
            bP("770", "na_package_end_decrypt");
            return;
        }
        bP("670", "package_end_unzip");
        bP("770", "na_package_end_unzip");
    }

    private void bP(String str, String str2) {
        if (this.dgn != null) {
            this.dgn.bp(str, str2);
        }
    }
}
