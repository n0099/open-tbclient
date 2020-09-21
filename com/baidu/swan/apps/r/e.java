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
/* loaded from: classes3.dex */
public class e extends f.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final com.baidu.swan.pms.a.d cwN;
    private final com.baidu.swan.pms.model.e cwU;

    public e(com.baidu.swan.pms.model.e eVar, com.baidu.swan.pms.a.d dVar) {
        super("extract");
        this.cwU = eVar;
        this.cwN = dVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.r.f.a
    public void app() {
        super.app();
        if (apr().getBoolean("result_output_dir_allow_rollback", false)) {
            com.baidu.swan.c.d.xM(apr().getString("result_output_dir"));
        }
    }

    @Override // com.baidu.swan.apps.r.f.a
    protected boolean a(Pipe.SourceChannel sourceChannel, Bundle bundle) {
        String string = bundle.getString("launch_id");
        com.baidu.swan.apps.u.e.a aVar = null;
        if (DEBUG) {
            aVar = com.baidu.swan.apps.u.e.a.ol(string);
            aVar.arY().op("SwanExtractor").ip(1);
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
            com.baidu.swan.apps.u.e.a.ol(str).bK("SwanExtractor", "onProcess installe error=" + a);
        }
        apr().putLong("result_error_code", a.aEM());
        return false;
    }

    private com.baidu.swan.apps.am.a a(@NonNull BufferedInputStream bufferedInputStream, String str) {
        File bB;
        int i;
        boolean z;
        a.C0420a c0420a;
        com.baidu.swan.apps.u.e.a ol = com.baidu.swan.apps.u.e.a.ol(str);
        if (this.cwU == null) {
            com.baidu.swan.apps.am.a sH = new com.baidu.swan.apps.am.a().bP(11L).bQ(2320L).sH("pkg info is empty");
            com.baidu.swan.apps.am.e.aEQ().j(sH);
            return sH;
        }
        if (this.cwU.category == 1) {
            bB = a.c.bB(this.cwU.dHr, String.valueOf(this.cwU.versionCode));
        } else if (this.cwU.category == 0) {
            bB = d.C0421d.bB(this.cwU.dHr, String.valueOf(this.cwU.versionCode));
        } else {
            com.baidu.swan.apps.am.a sH2 = new com.baidu.swan.apps.am.a().bP(11L).bQ(2320L).sH("pkh category illegal");
            com.baidu.swan.apps.am.e.aEQ().j(sH2);
            return sH2;
        }
        if (bB.isFile() && !bB.delete()) {
            if (DEBUG) {
                ol.bK("SwanExtractor", "解压失败：解压目录被文件占用，且无法删除");
            }
            com.baidu.swan.apps.am.a sH3 = new com.baidu.swan.apps.am.a().bP(11L).bQ(2320L).sH("解压失败：解压目录被文件占用，且无法删除");
            com.baidu.swan.apps.am.e.aEQ().j(sH3);
            return sH3;
        }
        if (!bB.exists()) {
            apr().putBoolean("result_output_dir_allow_rollback", true);
            if (!bB.mkdirs()) {
                if (DEBUG) {
                    ol.bK("SwanExtractor", "解压失败：解压文件夹创建失败");
                }
                com.baidu.swan.apps.am.a sH4 = new com.baidu.swan.apps.am.a().bP(11L).bQ(2320L).sH("解压失败：解压文件夹创建失败");
                com.baidu.swan.apps.am.e.aEQ().j(sH4);
                return sH4;
            }
        }
        if (DEBUG) {
            ol.bK("SwanExtractor", "开始执行解压操作, folder:" + bB.getPath());
        }
        apr().putString("result_output_dir", bB.toString());
        long currentTimeMillis = System.currentTimeMillis();
        try {
            a.b a = com.baidu.swan.apps.r.a.a.a(bufferedInputStream);
            boolean z2 = false;
            int i2 = a == null ? -1 : a.type;
            if (i2 != -1) {
                z2 = true;
            }
            ex(z2);
            if (z2) {
                a.C0420a a2 = com.baidu.swan.apps.r.a.a.a(bufferedInputStream, bB, i2);
                int i3 = i2;
                c0420a = a2;
                z = a2 != null && a2.isSuccess;
                i = i3;
            } else {
                boolean f = com.baidu.swan.c.f.f(bufferedInputStream, bB.getPath());
                i = 0;
                z = f;
                c0420a = null;
            }
            ey(z2);
            long currentTimeMillis2 = System.currentTimeMillis();
            if (DEBUG) {
                com.baidu.swan.apps.r.a.a.ih((int) (currentTimeMillis2 - currentTimeMillis));
            }
            if (this.cwN != null) {
                Bundle bundle = new Bundle();
                bundle.putInt("download_package_type_id", i);
                h.a(this.cwN, bundle, "event_download_package_type");
            }
            if (z) {
                return null;
            }
            com.baidu.swan.apps.am.a bP = new com.baidu.swan.apps.am.a().bP(11L);
            if (z2) {
                bP.bQ(2330L).sH("decrypt failed:" + c0420a.cnD);
            } else {
                bP.bQ(2320L).sH("unzip failed");
            }
            com.baidu.swan.apps.am.e.aEQ().j(bP);
            return bP;
        } catch (IOException e) {
            if (DEBUG) {
                ol.bK("SwanExtractor", "obtainEncryptedBundle Exception: " + e.toString());
                e.printStackTrace();
            }
            com.baidu.swan.apps.am.a sH5 = new com.baidu.swan.apps.am.a().bP(11L).bQ(2320L).sH("obtainEncryptedBundle Exception: " + e.toString());
            com.baidu.swan.apps.am.e.aEQ().j(sH5);
            return sH5;
        }
    }

    private void ex(boolean z) {
        if (z) {
            bF("670", "package_start_decrypt");
            bF("770", "na_package_start_decrypt");
            return;
        }
        bF("670", "package_start_unzip");
        bF("770", "na_package_start_unzip");
    }

    private void ey(boolean z) {
        if (z) {
            bF("670", "package_end_decrypt");
            bF("770", "na_package_end_decrypt");
            return;
        }
        bF("670", "package_end_unzip");
        bF("770", "na_package_end_unzip");
    }

    private void bF(String str, String str2) {
        if (this.cwN != null) {
            this.cwN.bf(str, str2);
        }
    }
}
