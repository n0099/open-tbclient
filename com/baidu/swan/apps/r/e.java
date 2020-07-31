package com.baidu.swan.apps.r;

import android.os.Bundle;
import android.support.annotation.NonNull;
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
/* loaded from: classes7.dex */
public class e extends f.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final com.baidu.swan.pms.a.d cnf;
    private final com.baidu.swan.pms.model.e cnm;

    public e(com.baidu.swan.pms.model.e eVar, com.baidu.swan.pms.a.d dVar) {
        super("extract");
        this.cnm = eVar;
        this.cnf = dVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.r.f.a
    public void ahe() {
        super.ahe();
        if (ahg().getBoolean("result_output_dir_allow_rollback", false)) {
            com.baidu.swan.d.d.vh(ahg().getString("result_output_dir"));
        }
    }

    @Override // com.baidu.swan.apps.r.f.a
    protected boolean a(Pipe.SourceChannel sourceChannel, Bundle bundle) {
        String string = bundle.getString("launch_id");
        com.baidu.swan.apps.u.d.a aVar = null;
        if (com.baidu.swan.apps.performance.b.b.aoo()) {
            if (DEBUG) {
                aVar = com.baidu.swan.apps.u.d.a.lT(string);
                aVar.ajH().lW("SwanExtractor").gb(1);
            }
        } else {
            aVar = com.baidu.swan.apps.u.d.a.lT(string);
            aVar.ajH().lW("SwanExtractor").gb(1);
        }
        boolean e = e(Channels.newInputStream(sourceChannel), string);
        if (aVar != null && DEBUG) {
            aVar.bx("SwanExtractor", "done: " + e);
        }
        return e;
    }

    private boolean e(InputStream inputStream, String str) {
        if (inputStream == null) {
            return false;
        }
        com.baidu.swan.apps.an.a a = a(new BufferedInputStream(inputStream), str);
        if (a == null) {
            return true;
        }
        if (com.baidu.swan.apps.performance.b.b.aoo()) {
            if (DEBUG) {
                com.baidu.swan.apps.u.d.a.lT(str).bx("SwanExtractor", "onProcess installe error=" + a);
            }
        } else {
            com.baidu.swan.apps.u.d.a.lT(str).bx("SwanExtractor", "onProcess installe error=" + a);
        }
        ahg().putLong("result_error_code", a.avT());
        return false;
    }

    private com.baidu.swan.apps.an.a a(@NonNull BufferedInputStream bufferedInputStream, String str) {
        File bq;
        int i;
        boolean z;
        a.C0379a c0379a;
        com.baidu.swan.apps.u.d.a lT = com.baidu.swan.apps.u.d.a.lT(str);
        if (this.cnm == null) {
            com.baidu.swan.apps.an.a qm = new com.baidu.swan.apps.an.a().bJ(11L).bK(2320L).qm("pkg info is empty");
            com.baidu.swan.apps.an.e.avX().g(qm);
            return qm;
        }
        if (this.cnm.category == 1) {
            bq = a.c.bq(this.cnm.dvZ, String.valueOf(this.cnm.versionCode));
        } else if (this.cnm.category == 0) {
            bq = d.C0380d.bq(this.cnm.dvZ, String.valueOf(this.cnm.versionCode));
        } else {
            com.baidu.swan.apps.an.a qm2 = new com.baidu.swan.apps.an.a().bJ(11L).bK(2320L).qm("pkh category illegal");
            com.baidu.swan.apps.an.e.avX().g(qm2);
            return qm2;
        }
        if (bq.isFile() && !bq.delete()) {
            if (DEBUG) {
                lT.bx("SwanExtractor", "解压失败：解压目录被文件占用，且无法删除");
            }
            com.baidu.swan.apps.an.a qm3 = new com.baidu.swan.apps.an.a().bJ(11L).bK(2320L).qm("解压失败：解压目录被文件占用，且无法删除");
            com.baidu.swan.apps.an.e.avX().g(qm3);
            return qm3;
        }
        if (!bq.exists()) {
            ahg().putBoolean("result_output_dir_allow_rollback", true);
            if (!bq.mkdirs()) {
                if (DEBUG) {
                    lT.bx("SwanExtractor", "解压失败：解压文件夹创建失败");
                }
                com.baidu.swan.apps.an.a qm4 = new com.baidu.swan.apps.an.a().bJ(11L).bK(2320L).qm("解压失败：解压文件夹创建失败");
                com.baidu.swan.apps.an.e.avX().g(qm4);
                return qm4;
            }
        }
        if (DEBUG) {
            lT.bx("SwanExtractor", "开始执行解压操作, folder:" + bq.getPath());
        }
        ahg().putString("result_output_dir", bq.toString());
        long currentTimeMillis = System.currentTimeMillis();
        try {
            a.b a = com.baidu.swan.apps.r.a.a.a(bufferedInputStream);
            boolean z2 = false;
            int i2 = a == null ? -1 : a.type;
            if (i2 != -1) {
                z2 = true;
            }
            ef(z2);
            if (z2) {
                a.C0379a a2 = com.baidu.swan.apps.r.a.a.a(bufferedInputStream, bq, i2);
                int i3 = i2;
                c0379a = a2;
                z = a2 != null && a2.isSuccess;
                i = i3;
            } else {
                boolean f = com.baidu.swan.d.f.f(bufferedInputStream, bq.getPath());
                i = 0;
                z = f;
                c0379a = null;
            }
            eg(z2);
            long currentTimeMillis2 = System.currentTimeMillis();
            if (DEBUG) {
                com.baidu.swan.apps.r.a.a.fT((int) (currentTimeMillis2 - currentTimeMillis));
            }
            if (this.cnf != null) {
                Bundle bundle = new Bundle();
                bundle.putInt("download_package_type_id", i);
                h.a(this.cnf, bundle, "event_download_package_type");
            }
            if (z) {
                return null;
            }
            com.baidu.swan.apps.an.a bJ = new com.baidu.swan.apps.an.a().bJ(11L);
            if (z2) {
                bJ.bK(2330L).qm("decrypt failed:" + c0379a.cfe);
            } else {
                bJ.bK(2320L).qm("unzip failed");
            }
            com.baidu.swan.apps.an.e.avX().g(bJ);
            return bJ;
        } catch (IOException e) {
            if (DEBUG) {
                lT.bx("SwanExtractor", "obtainEncryptedBundle Exception: " + e.toString());
                e.printStackTrace();
            }
            com.baidu.swan.apps.an.a qm5 = new com.baidu.swan.apps.an.a().bJ(11L).bK(2320L).qm("obtainEncryptedBundle Exception: " + e.toString());
            com.baidu.swan.apps.an.e.avX().g(qm5);
            return qm5;
        }
    }

    private void ef(boolean z) {
        if (z) {
            bu("670", "package_start_decrypt");
            bu("770", "na_package_start_decrypt");
            return;
        }
        bu("670", "package_start_unzip");
        bu("770", "na_package_start_unzip");
    }

    private void eg(boolean z) {
        if (z) {
            bu("670", "package_end_decrypt");
            bu("770", "na_package_end_decrypt");
            return;
        }
        bu("670", "package_end_unzip");
        bu("770", "na_package_end_unzip");
    }

    private void bu(String str, String str2) {
        if (this.cnf != null) {
            this.cnf.aY(str, str2);
        }
    }
}
