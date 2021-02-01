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
/* loaded from: classes9.dex */
public class e extends f.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final com.baidu.swan.pms.a.d deM;
    private final com.baidu.swan.pms.model.e deT;

    public e(com.baidu.swan.pms.model.e eVar, com.baidu.swan.pms.a.d dVar) {
        super("extract");
        this.deT = eVar;
        this.deM = dVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.r.f.a
    public void awR() {
        super.awR();
        if (awT().getBoolean("result_output_dir_allow_rollback", false)) {
            com.baidu.swan.c.d.yO(awT().getString("result_output_dir"));
        }
    }

    @Override // com.baidu.swan.apps.r.f.a
    protected boolean a(Pipe.SourceChannel sourceChannel, Bundle bundle) {
        String string = bundle.getString("launch_id");
        com.baidu.swan.apps.u.e.a aVar = null;
        if (DEBUG) {
            aVar = com.baidu.swan.apps.u.e.a.pg(string);
            aVar.azB().pj("SwanExtractor").hT(1);
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
            com.baidu.swan.apps.u.e.a.pg(str).bU("SwanExtractor", "onProcess installe error=" + a2);
        }
        awT().putLong("result_error_code", a2.aNf());
        return false;
    }

    private com.baidu.swan.apps.al.a a(@NonNull BufferedInputStream bufferedInputStream, String str) {
        File bL;
        boolean i;
        com.baidu.swan.apps.u.e.a pg = com.baidu.swan.apps.u.e.a.pg(str);
        if (this.deT == null) {
            com.baidu.swan.apps.al.a tH = new com.baidu.swan.apps.al.a().db(11L).dc(2320L).tH("pkg info is empty");
            com.baidu.swan.apps.al.e.aNj().j(tH);
            return tH;
        }
        if (this.deT.category == 1) {
            bL = a.c.bL(this.deT.euc, String.valueOf(this.deT.versionCode));
        } else if (this.deT.category == 0) {
            bL = d.C0446d.bL(this.deT.euc, String.valueOf(this.deT.versionCode));
        } else {
            com.baidu.swan.apps.al.a tH2 = new com.baidu.swan.apps.al.a().db(11L).dc(2320L).tH("pkh category illegal");
            com.baidu.swan.apps.al.e.aNj().j(tH2);
            return tH2;
        }
        if (bL.isFile() && !bL.delete()) {
            if (DEBUG) {
                pg.bU("SwanExtractor", "解压失败：解压目录被文件占用，且无法删除");
            }
            com.baidu.swan.apps.al.a tH3 = new com.baidu.swan.apps.al.a().db(11L).dc(2320L).tH("解压失败：解压目录被文件占用，且无法删除");
            com.baidu.swan.apps.al.e.aNj().j(tH3);
            return tH3;
        }
        if (!bL.exists()) {
            awT().putBoolean("result_output_dir_allow_rollback", true);
            if (!bL.mkdirs()) {
                if (DEBUG) {
                    pg.bU("SwanExtractor", "解压失败：解压文件夹创建失败");
                }
                com.baidu.swan.apps.al.a tH4 = new com.baidu.swan.apps.al.a().db(11L).dc(2320L).tH("解压失败：解压文件夹创建失败");
                com.baidu.swan.apps.al.e.aNj().j(tH4);
                return tH4;
            }
        }
        if (DEBUG) {
            pg.bU("SwanExtractor", "开始执行解压操作, folder:" + bL.getPath());
        }
        awT().putString("result_output_dir", bL.toString());
        a.C0445a c0445a = null;
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
                c0445a = com.baidu.swan.apps.r.a.a.a(bufferedInputStream, bL, i2);
                i = c0445a != null && c0445a.isSuccess;
            } else {
                i = com.baidu.swan.c.f.i(bufferedInputStream, bL.getPath());
                i2 = 0;
            }
            fP(z);
            long currentTimeMillis2 = System.currentTimeMillis();
            if (DEBUG) {
                com.baidu.swan.apps.r.a.a.hL((int) (currentTimeMillis2 - currentTimeMillis));
            }
            if (this.deM != null) {
                Bundle bundle = new Bundle();
                bundle.putInt("download_package_type_id", i2);
                h.a(this.deM, bundle, "event_download_package_type");
            }
            if (i) {
                return null;
            }
            com.baidu.swan.apps.al.a db = new com.baidu.swan.apps.al.a().db(11L);
            if (z) {
                db.dc(2330L).tH("decrypt failed:" + c0445a.cVP);
            } else {
                db.dc(2320L).tH("unzip failed");
            }
            com.baidu.swan.apps.al.e.aNj().j(db);
            return db;
        } catch (IOException e) {
            if (DEBUG) {
                pg.bU("SwanExtractor", "obtainEncryptedBundle Exception: " + e.toString());
                e.printStackTrace();
            }
            com.baidu.swan.apps.al.a tH5 = new com.baidu.swan.apps.al.a().db(11L).dc(2320L).tH("obtainEncryptedBundle Exception: " + e.toString());
            com.baidu.swan.apps.al.e.aNj().j(tH5);
            return tH5;
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
        if (this.deM != null) {
            this.deM.bp(str, str2);
        }
    }
}
