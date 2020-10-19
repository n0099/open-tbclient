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
    private final com.baidu.swan.pms.a.d cIS;
    private final com.baidu.swan.pms.model.e cIZ;

    public e(com.baidu.swan.pms.model.e eVar, com.baidu.swan.pms.a.d dVar) {
        super("extract");
        this.cIZ = eVar;
        this.cIS = dVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.r.f.a
    public void asa() {
        super.asa();
        if (asc().getBoolean("result_output_dir_allow_rollback", false)) {
            com.baidu.swan.c.d.yy(asc().getString("result_output_dir"));
        }
    }

    @Override // com.baidu.swan.apps.r.f.a
    protected boolean a(Pipe.SourceChannel sourceChannel, Bundle bundle) {
        String string = bundle.getString("launch_id");
        com.baidu.swan.apps.u.e.a aVar = null;
        if (DEBUG) {
            aVar = com.baidu.swan.apps.u.e.a.oY(string);
            aVar.auK().pb("SwanExtractor").iM(1);
        }
        boolean f = f(Channels.newInputStream(sourceChannel), string);
        if (aVar != null && DEBUG) {
            aVar.bP("SwanExtractor", "done: " + f);
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
            com.baidu.swan.apps.u.e.a.oY(str).bP("SwanExtractor", "onProcess installe error=" + a2);
        }
        asc().putLong("result_error_code", a2.aHv());
        return false;
    }

    private com.baidu.swan.apps.am.a a(@NonNull BufferedInputStream bufferedInputStream, String str) {
        File bG;
        int i;
        boolean z;
        a.C0437a c0437a;
        com.baidu.swan.apps.u.e.a oY = com.baidu.swan.apps.u.e.a.oY(str);
        if (this.cIZ == null) {
            com.baidu.swan.apps.am.a tt = new com.baidu.swan.apps.am.a().bX(11L).bY(2320L).tt("pkg info is empty");
            com.baidu.swan.apps.am.e.aHz().j(tt);
            return tt;
        }
        if (this.cIZ.category == 1) {
            bG = a.c.bG(this.cIZ.dTs, String.valueOf(this.cIZ.versionCode));
        } else if (this.cIZ.category == 0) {
            bG = d.C0438d.bG(this.cIZ.dTs, String.valueOf(this.cIZ.versionCode));
        } else {
            com.baidu.swan.apps.am.a tt2 = new com.baidu.swan.apps.am.a().bX(11L).bY(2320L).tt("pkh category illegal");
            com.baidu.swan.apps.am.e.aHz().j(tt2);
            return tt2;
        }
        if (bG.isFile() && !bG.delete()) {
            if (DEBUG) {
                oY.bP("SwanExtractor", "解压失败：解压目录被文件占用，且无法删除");
            }
            com.baidu.swan.apps.am.a tt3 = new com.baidu.swan.apps.am.a().bX(11L).bY(2320L).tt("解压失败：解压目录被文件占用，且无法删除");
            com.baidu.swan.apps.am.e.aHz().j(tt3);
            return tt3;
        }
        if (!bG.exists()) {
            asc().putBoolean("result_output_dir_allow_rollback", true);
            if (!bG.mkdirs()) {
                if (DEBUG) {
                    oY.bP("SwanExtractor", "解压失败：解压文件夹创建失败");
                }
                com.baidu.swan.apps.am.a tt4 = new com.baidu.swan.apps.am.a().bX(11L).bY(2320L).tt("解压失败：解压文件夹创建失败");
                com.baidu.swan.apps.am.e.aHz().j(tt4);
                return tt4;
            }
        }
        if (DEBUG) {
            oY.bP("SwanExtractor", "开始执行解压操作, folder:" + bG.getPath());
        }
        asc().putString("result_output_dir", bG.toString());
        long currentTimeMillis = System.currentTimeMillis();
        try {
            a.b a2 = com.baidu.swan.apps.r.a.a.a(bufferedInputStream);
            boolean z2 = false;
            int i2 = a2 == null ? -1 : a2.type;
            if (i2 != -1) {
                z2 = true;
            }
            eT(z2);
            if (z2) {
                a.C0437a a3 = com.baidu.swan.apps.r.a.a.a(bufferedInputStream, bG, i2);
                int i3 = i2;
                c0437a = a3;
                z = a3 != null && a3.isSuccess;
                i = i3;
            } else {
                boolean g = com.baidu.swan.c.f.g(bufferedInputStream, bG.getPath());
                i = 0;
                z = g;
                c0437a = null;
            }
            eU(z2);
            long currentTimeMillis2 = System.currentTimeMillis();
            if (DEBUG) {
                com.baidu.swan.apps.r.a.a.iE((int) (currentTimeMillis2 - currentTimeMillis));
            }
            if (this.cIS != null) {
                Bundle bundle = new Bundle();
                bundle.putInt("download_package_type_id", i);
                h.a(this.cIS, bundle, "event_download_package_type");
            }
            if (z) {
                return null;
            }
            com.baidu.swan.apps.am.a bX = new com.baidu.swan.apps.am.a().bX(11L);
            if (z2) {
                bX.bY(2330L).tt("decrypt failed:" + c0437a.czT);
            } else {
                bX.bY(2320L).tt("unzip failed");
            }
            com.baidu.swan.apps.am.e.aHz().j(bX);
            return bX;
        } catch (IOException e) {
            if (DEBUG) {
                oY.bP("SwanExtractor", "obtainEncryptedBundle Exception: " + e.toString());
                e.printStackTrace();
            }
            com.baidu.swan.apps.am.a tt5 = new com.baidu.swan.apps.am.a().bX(11L).bY(2320L).tt("obtainEncryptedBundle Exception: " + e.toString());
            com.baidu.swan.apps.am.e.aHz().j(tt5);
            return tt5;
        }
    }

    private void eT(boolean z) {
        if (z) {
            bK("670", "package_start_decrypt");
            bK("770", "na_package_start_decrypt");
            return;
        }
        bK("670", "package_start_unzip");
        bK("770", "na_package_start_unzip");
    }

    private void eU(boolean z) {
        if (z) {
            bK("670", "package_end_decrypt");
            bK("770", "na_package_end_decrypt");
            return;
        }
        bK("670", "package_end_unzip");
        bK("770", "na_package_end_unzip");
    }

    private void bK(String str, String str2) {
        if (this.cIS != null) {
            this.cIS.bk(str, str2);
        }
    }
}
