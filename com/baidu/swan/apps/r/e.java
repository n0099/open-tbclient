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
/* loaded from: classes8.dex */
public class e extends f.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final com.baidu.swan.pms.a.d cuM;
    private final com.baidu.swan.pms.model.e cuT;

    public e(com.baidu.swan.pms.model.e eVar, com.baidu.swan.pms.a.d dVar) {
        super("extract");
        this.cuT = eVar;
        this.cuM = dVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.r.f.a
    public void aoE() {
        super.aoE();
        if (aoG().getBoolean("result_output_dir_allow_rollback", false)) {
            com.baidu.swan.c.d.xt(aoG().getString("result_output_dir"));
        }
    }

    @Override // com.baidu.swan.apps.r.f.a
    protected boolean a(Pipe.SourceChannel sourceChannel, Bundle bundle) {
        String string = bundle.getString("launch_id");
        com.baidu.swan.apps.u.e.a aVar = null;
        if (DEBUG) {
            aVar = com.baidu.swan.apps.u.e.a.nR(string);
            aVar.aro().nU("SwanExtractor").m34if(1);
        }
        boolean e = e(Channels.newInputStream(sourceChannel), string);
        if (aVar != null && DEBUG) {
            aVar.bK("SwanExtractor", "done: " + e);
        }
        return e;
    }

    private boolean e(InputStream inputStream, String str) {
        if (inputStream == null) {
            return false;
        }
        com.baidu.swan.apps.am.a a = a(new BufferedInputStream(inputStream), str);
        if (a == null) {
            return true;
        }
        if (DEBUG) {
            com.baidu.swan.apps.u.e.a.nR(str).bK("SwanExtractor", "onProcess installe error=" + a);
        }
        aoG().putLong("result_error_code", a.aEc());
        return false;
    }

    private com.baidu.swan.apps.am.a a(@NonNull BufferedInputStream bufferedInputStream, String str) {
        File bB;
        int i;
        boolean z;
        a.C0425a c0425a;
        com.baidu.swan.apps.u.e.a nR = com.baidu.swan.apps.u.e.a.nR(str);
        if (this.cuT == null) {
            com.baidu.swan.apps.am.a sn = new com.baidu.swan.apps.am.a().bO(11L).bP(2320L).sn("pkg info is empty");
            com.baidu.swan.apps.am.e.aEg().j(sn);
            return sn;
        }
        if (this.cuT.category == 1) {
            bB = a.c.bB(this.cuT.dFn, String.valueOf(this.cuT.versionCode));
        } else if (this.cuT.category == 0) {
            bB = d.C0426d.bB(this.cuT.dFn, String.valueOf(this.cuT.versionCode));
        } else {
            com.baidu.swan.apps.am.a sn2 = new com.baidu.swan.apps.am.a().bO(11L).bP(2320L).sn("pkh category illegal");
            com.baidu.swan.apps.am.e.aEg().j(sn2);
            return sn2;
        }
        if (bB.isFile() && !bB.delete()) {
            if (DEBUG) {
                nR.bK("SwanExtractor", "解压失败：解压目录被文件占用，且无法删除");
            }
            com.baidu.swan.apps.am.a sn3 = new com.baidu.swan.apps.am.a().bO(11L).bP(2320L).sn("解压失败：解压目录被文件占用，且无法删除");
            com.baidu.swan.apps.am.e.aEg().j(sn3);
            return sn3;
        }
        if (!bB.exists()) {
            aoG().putBoolean("result_output_dir_allow_rollback", true);
            if (!bB.mkdirs()) {
                if (DEBUG) {
                    nR.bK("SwanExtractor", "解压失败：解压文件夹创建失败");
                }
                com.baidu.swan.apps.am.a sn4 = new com.baidu.swan.apps.am.a().bO(11L).bP(2320L).sn("解压失败：解压文件夹创建失败");
                com.baidu.swan.apps.am.e.aEg().j(sn4);
                return sn4;
            }
        }
        if (DEBUG) {
            nR.bK("SwanExtractor", "开始执行解压操作, folder:" + bB.getPath());
        }
        aoG().putString("result_output_dir", bB.toString());
        long currentTimeMillis = System.currentTimeMillis();
        try {
            a.b a = com.baidu.swan.apps.r.a.a.a(bufferedInputStream);
            boolean z2 = false;
            int i2 = a == null ? -1 : a.type;
            if (i2 != -1) {
                z2 = true;
            }
            ez(z2);
            if (z2) {
                a.C0425a a2 = com.baidu.swan.apps.r.a.a.a(bufferedInputStream, bB, i2);
                int i3 = i2;
                c0425a = a2;
                z = a2 != null && a2.isSuccess;
                i = i3;
            } else {
                boolean f = com.baidu.swan.c.f.f(bufferedInputStream, bB.getPath());
                i = 0;
                z = f;
                c0425a = null;
            }
            eA(z2);
            long currentTimeMillis2 = System.currentTimeMillis();
            if (DEBUG) {
                com.baidu.swan.apps.r.a.a.hX((int) (currentTimeMillis2 - currentTimeMillis));
            }
            if (this.cuM != null) {
                Bundle bundle = new Bundle();
                bundle.putInt("download_package_type_id", i);
                h.a(this.cuM, bundle, "event_download_package_type");
            }
            if (z) {
                return null;
            }
            com.baidu.swan.apps.am.a bO = new com.baidu.swan.apps.am.a().bO(11L);
            if (z2) {
                bO.bP(2330L).sn("decrypt failed:" + c0425a.clA);
            } else {
                bO.bP(2320L).sn("unzip failed");
            }
            com.baidu.swan.apps.am.e.aEg().j(bO);
            return bO;
        } catch (IOException e) {
            if (DEBUG) {
                nR.bK("SwanExtractor", "obtainEncryptedBundle Exception: " + e.toString());
                e.printStackTrace();
            }
            com.baidu.swan.apps.am.a sn5 = new com.baidu.swan.apps.am.a().bO(11L).bP(2320L).sn("obtainEncryptedBundle Exception: " + e.toString());
            com.baidu.swan.apps.am.e.aEg().j(sn5);
            return sn5;
        }
    }

    private void ez(boolean z) {
        if (z) {
            bF("670", "package_start_decrypt");
            bF("770", "na_package_start_decrypt");
            return;
        }
        bF("670", "package_start_unzip");
        bF("770", "na_package_start_unzip");
    }

    private void eA(boolean z) {
        if (z) {
            bF("670", "package_end_decrypt");
            bF("770", "na_package_end_decrypt");
            return;
        }
        bF("670", "package_end_unzip");
        bF("770", "na_package_end_unzip");
    }

    private void bF(String str, String str2) {
        if (this.cuM != null) {
            this.cuM.bf(str, str2);
        }
    }
}
