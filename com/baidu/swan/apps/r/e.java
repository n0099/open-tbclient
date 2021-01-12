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
    private final com.baidu.swan.pms.model.e dcG;
    private final com.baidu.swan.pms.a.d dcz;

    public e(com.baidu.swan.pms.model.e eVar, com.baidu.swan.pms.a.d dVar) {
        super("extract");
        this.dcG = eVar;
        this.dcz = dVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.r.f.a
    public void awt() {
        super.awt();
        if (awv().getBoolean("result_output_dir_allow_rollback", false)) {
            com.baidu.swan.c.d.yv(awv().getString("result_output_dir"));
        }
    }

    @Override // com.baidu.swan.apps.r.f.a
    protected boolean a(Pipe.SourceChannel sourceChannel, Bundle bundle) {
        String string = bundle.getString("launch_id");
        com.baidu.swan.apps.u.e.a aVar = null;
        if (DEBUG) {
            aVar = com.baidu.swan.apps.u.e.a.oO(string);
            aVar.azd().oR("SwanExtractor").hQ(1);
        }
        boolean h = h(Channels.newInputStream(sourceChannel), string);
        if (aVar != null && DEBUG) {
            aVar.ca("SwanExtractor", "done: " + h);
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
            com.baidu.swan.apps.u.e.a.oO(str).ca("SwanExtractor", "onProcess installe error=" + a2);
        }
        awv().putLong("result_error_code", a2.aMM());
        return false;
    }

    private com.baidu.swan.apps.al.a a(@NonNull BufferedInputStream bufferedInputStream, String str) {
        File bR;
        boolean i;
        com.baidu.swan.apps.u.e.a oO = com.baidu.swan.apps.u.e.a.oO(str);
        if (this.dcG == null) {
            com.baidu.swan.apps.al.a aVar = new com.baidu.swan.apps.al.a().cV(11L).cW(2320L).to("pkg info is empty");
            com.baidu.swan.apps.al.e.aMQ().j(aVar);
            return aVar;
        }
        if (this.dcG.category == 1) {
            bR = a.c.bR(this.dcG.erV, String.valueOf(this.dcG.versionCode));
        } else if (this.dcG.category == 0) {
            bR = d.C0449d.bR(this.dcG.erV, String.valueOf(this.dcG.versionCode));
        } else {
            com.baidu.swan.apps.al.a aVar2 = new com.baidu.swan.apps.al.a().cV(11L).cW(2320L).to("pkh category illegal");
            com.baidu.swan.apps.al.e.aMQ().j(aVar2);
            return aVar2;
        }
        if (bR.isFile() && !bR.delete()) {
            if (DEBUG) {
                oO.ca("SwanExtractor", "解压失败：解压目录被文件占用，且无法删除");
            }
            com.baidu.swan.apps.al.a aVar3 = new com.baidu.swan.apps.al.a().cV(11L).cW(2320L).to("解压失败：解压目录被文件占用，且无法删除");
            com.baidu.swan.apps.al.e.aMQ().j(aVar3);
            return aVar3;
        }
        if (!bR.exists()) {
            awv().putBoolean("result_output_dir_allow_rollback", true);
            if (!bR.mkdirs()) {
                if (DEBUG) {
                    oO.ca("SwanExtractor", "解压失败：解压文件夹创建失败");
                }
                com.baidu.swan.apps.al.a aVar4 = new com.baidu.swan.apps.al.a().cV(11L).cW(2320L).to("解压失败：解压文件夹创建失败");
                com.baidu.swan.apps.al.e.aMQ().j(aVar4);
                return aVar4;
            }
        }
        if (DEBUG) {
            oO.ca("SwanExtractor", "开始执行解压操作, folder:" + bR.getPath());
        }
        awv().putString("result_output_dir", bR.toString());
        a.C0448a c0448a = null;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            a.b a2 = com.baidu.swan.apps.r.a.a.a(bufferedInputStream);
            boolean z = false;
            int i2 = a2 == null ? -1 : a2.type;
            if (i2 != -1) {
                z = true;
            }
            fM(z);
            if (z) {
                c0448a = com.baidu.swan.apps.r.a.a.a(bufferedInputStream, bR, i2);
                i = c0448a != null && c0448a.isSuccess;
            } else {
                i = com.baidu.swan.c.f.i(bufferedInputStream, bR.getPath());
                i2 = 0;
            }
            fN(z);
            long currentTimeMillis2 = System.currentTimeMillis();
            if (DEBUG) {
                com.baidu.swan.apps.r.a.a.hI((int) (currentTimeMillis2 - currentTimeMillis));
            }
            if (this.dcz != null) {
                Bundle bundle = new Bundle();
                bundle.putInt("download_package_type_id", i2);
                h.a(this.dcz, bundle, "event_download_package_type");
            }
            if (i) {
                return null;
            }
            com.baidu.swan.apps.al.a cV = new com.baidu.swan.apps.al.a().cV(11L);
            if (z) {
                cV.cW(2330L).to("decrypt failed:" + c0448a.cTC);
            } else {
                cV.cW(2320L).to("unzip failed");
            }
            com.baidu.swan.apps.al.e.aMQ().j(cV);
            return cV;
        } catch (IOException e) {
            if (DEBUG) {
                oO.ca("SwanExtractor", "obtainEncryptedBundle Exception: " + e.toString());
                e.printStackTrace();
            }
            com.baidu.swan.apps.al.a aVar5 = new com.baidu.swan.apps.al.a().cV(11L).cW(2320L).to("obtainEncryptedBundle Exception: " + e.toString());
            com.baidu.swan.apps.al.e.aMQ().j(aVar5);
            return aVar5;
        }
    }

    private void fM(boolean z) {
        if (z) {
            bV("670", "package_start_decrypt");
            bV("770", "na_package_start_decrypt");
            return;
        }
        bV("670", "package_start_unzip");
        bV("770", "na_package_start_unzip");
    }

    private void fN(boolean z) {
        if (z) {
            bV("670", "package_end_decrypt");
            bV("770", "na_package_end_decrypt");
            return;
        }
        bV("670", "package_end_unzip");
        bV("770", "na_package_end_unzip");
    }

    private void bV(String str, String str2) {
        if (this.dcz != null) {
            this.dcz.bv(str, str2);
        }
    }
}
