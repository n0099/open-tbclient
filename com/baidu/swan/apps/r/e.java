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
/* loaded from: classes10.dex */
public class e extends f.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final com.baidu.swan.pms.a.d cXh;
    private final com.baidu.swan.pms.model.e cXo;

    public e(com.baidu.swan.pms.model.e eVar, com.baidu.swan.pms.a.d dVar) {
        super("extract");
        this.cXo = eVar;
        this.cXh = dVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.r.f.a
    public void awv() {
        super.awv();
        if (awx().getBoolean("result_output_dir_allow_rollback", false)) {
            com.baidu.swan.c.d.zf(awx().getString("result_output_dir"));
        }
    }

    @Override // com.baidu.swan.apps.r.f.a
    protected boolean a(Pipe.SourceChannel sourceChannel, Bundle bundle) {
        String string = bundle.getString("launch_id");
        com.baidu.swan.apps.u.e.a aVar = null;
        if (DEBUG) {
            aVar = com.baidu.swan.apps.u.e.a.pF(string);
            aVar.aze().pI("SwanExtractor").jh(1);
        }
        boolean f = f(Channels.newInputStream(sourceChannel), string);
        if (aVar != null && DEBUG) {
            aVar.bW("SwanExtractor", "done: " + f);
        }
        return f;
    }

    private boolean f(InputStream inputStream, String str) {
        if (inputStream == null) {
            return false;
        }
        com.baidu.swan.apps.am.a a2 = a(new BufferedInputStream(inputStream), str);
        if (a2 == null) {
            return true;
        }
        if (DEBUG) {
            com.baidu.swan.apps.u.e.a.pF(str).bW("SwanExtractor", "onProcess installe error=" + a2);
        }
        awx().putLong("result_error_code", a2.aLP());
        return false;
    }

    private com.baidu.swan.apps.am.a a(@NonNull BufferedInputStream bufferedInputStream, String str) {
        File bN;
        int i;
        boolean z;
        a.C0463a c0463a;
        com.baidu.swan.apps.u.e.a pF = com.baidu.swan.apps.u.e.a.pF(str);
        if (this.cXo == null) {
            com.baidu.swan.apps.am.a ua = new com.baidu.swan.apps.am.a().cv(11L).cw(2320L).ua("pkg info is empty");
            com.baidu.swan.apps.am.e.aLT().j(ua);
            return ua;
        }
        if (this.cXo.category == 1) {
            bN = a.c.bN(this.cXo.ehG, String.valueOf(this.cXo.versionCode));
        } else if (this.cXo.category == 0) {
            bN = d.C0464d.bN(this.cXo.ehG, String.valueOf(this.cXo.versionCode));
        } else {
            com.baidu.swan.apps.am.a ua2 = new com.baidu.swan.apps.am.a().cv(11L).cw(2320L).ua("pkh category illegal");
            com.baidu.swan.apps.am.e.aLT().j(ua2);
            return ua2;
        }
        if (bN.isFile() && !bN.delete()) {
            if (DEBUG) {
                pF.bW("SwanExtractor", "解压失败：解压目录被文件占用，且无法删除");
            }
            com.baidu.swan.apps.am.a ua3 = new com.baidu.swan.apps.am.a().cv(11L).cw(2320L).ua("解压失败：解压目录被文件占用，且无法删除");
            com.baidu.swan.apps.am.e.aLT().j(ua3);
            return ua3;
        }
        if (!bN.exists()) {
            awx().putBoolean("result_output_dir_allow_rollback", true);
            if (!bN.mkdirs()) {
                if (DEBUG) {
                    pF.bW("SwanExtractor", "解压失败：解压文件夹创建失败");
                }
                com.baidu.swan.apps.am.a ua4 = new com.baidu.swan.apps.am.a().cv(11L).cw(2320L).ua("解压失败：解压文件夹创建失败");
                com.baidu.swan.apps.am.e.aLT().j(ua4);
                return ua4;
            }
        }
        if (DEBUG) {
            pF.bW("SwanExtractor", "开始执行解压操作, folder:" + bN.getPath());
        }
        awx().putString("result_output_dir", bN.toString());
        long currentTimeMillis = System.currentTimeMillis();
        try {
            a.b a2 = com.baidu.swan.apps.r.a.a.a(bufferedInputStream);
            boolean z2 = false;
            int i2 = a2 == null ? -1 : a2.type;
            if (i2 != -1) {
                z2 = true;
            }
            fp(z2);
            if (z2) {
                a.C0463a a3 = com.baidu.swan.apps.r.a.a.a(bufferedInputStream, bN, i2);
                int i3 = i2;
                c0463a = a3;
                z = a3 != null && a3.isSuccess;
                i = i3;
            } else {
                boolean g = com.baidu.swan.c.f.g(bufferedInputStream, bN.getPath());
                i = 0;
                z = g;
                c0463a = null;
            }
            fq(z2);
            long currentTimeMillis2 = System.currentTimeMillis();
            if (DEBUG) {
                com.baidu.swan.apps.r.a.a.iZ((int) (currentTimeMillis2 - currentTimeMillis));
            }
            if (this.cXh != null) {
                Bundle bundle = new Bundle();
                bundle.putInt("download_package_type_id", i);
                h.a(this.cXh, bundle, "event_download_package_type");
            }
            if (z) {
                return null;
            }
            com.baidu.swan.apps.am.a cv = new com.baidu.swan.apps.am.a().cv(11L);
            if (z2) {
                cv.cw(2330L).ua("decrypt failed:" + c0463a.cOi);
            } else {
                cv.cw(2320L).ua("unzip failed");
            }
            com.baidu.swan.apps.am.e.aLT().j(cv);
            return cv;
        } catch (IOException e) {
            if (DEBUG) {
                pF.bW("SwanExtractor", "obtainEncryptedBundle Exception: " + e.toString());
                e.printStackTrace();
            }
            com.baidu.swan.apps.am.a ua5 = new com.baidu.swan.apps.am.a().cv(11L).cw(2320L).ua("obtainEncryptedBundle Exception: " + e.toString());
            com.baidu.swan.apps.am.e.aLT().j(ua5);
            return ua5;
        }
    }

    private void fp(boolean z) {
        if (z) {
            bR("670", "package_start_decrypt");
            bR("770", "na_package_start_decrypt");
            return;
        }
        bR("670", "package_start_unzip");
        bR("770", "na_package_start_unzip");
    }

    private void fq(boolean z) {
        if (z) {
            bR("670", "package_end_decrypt");
            bR("770", "na_package_end_decrypt");
            return;
        }
        bR("670", "package_end_unzip");
        bR("770", "na_package_end_unzip");
    }

    private void bR(String str, String str2) {
        if (this.cXh != null) {
            this.cXh.br(str, str2);
        }
    }
}
