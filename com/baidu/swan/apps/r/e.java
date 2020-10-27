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
    private final com.baidu.swan.pms.a.d cRo;
    private final com.baidu.swan.pms.model.e cRv;

    public e(com.baidu.swan.pms.model.e eVar, com.baidu.swan.pms.a.d dVar) {
        super("extract");
        this.cRv = eVar;
        this.cRo = dVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.r.f.a
    public void atV() {
        super.atV();
        if (atX().getBoolean("result_output_dir_allow_rollback", false)) {
            com.baidu.swan.c.d.yR(atX().getString("result_output_dir"));
        }
    }

    @Override // com.baidu.swan.apps.r.f.a
    protected boolean a(Pipe.SourceChannel sourceChannel, Bundle bundle) {
        String string = bundle.getString("launch_id");
        com.baidu.swan.apps.u.e.a aVar = null;
        if (DEBUG) {
            aVar = com.baidu.swan.apps.u.e.a.pr(string);
            aVar.awE().pu("SwanExtractor").iX(1);
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
            com.baidu.swan.apps.u.e.a.pr(str).bW("SwanExtractor", "onProcess installe error=" + a2);
        }
        atX().putLong("result_error_code", a2.aJp());
        return false;
    }

    private com.baidu.swan.apps.am.a a(@NonNull BufferedInputStream bufferedInputStream, String str) {
        File bN;
        int i;
        boolean z;
        a.C0451a c0451a;
        com.baidu.swan.apps.u.e.a pr = com.baidu.swan.apps.u.e.a.pr(str);
        if (this.cRv == null) {
            com.baidu.swan.apps.am.a tM = new com.baidu.swan.apps.am.a().bZ(11L).ca(2320L).tM("pkg info is empty");
            com.baidu.swan.apps.am.e.aJt().j(tM);
            return tM;
        }
        if (this.cRv.category == 1) {
            bN = a.c.bN(this.cRv.ebO, String.valueOf(this.cRv.versionCode));
        } else if (this.cRv.category == 0) {
            bN = d.C0452d.bN(this.cRv.ebO, String.valueOf(this.cRv.versionCode));
        } else {
            com.baidu.swan.apps.am.a tM2 = new com.baidu.swan.apps.am.a().bZ(11L).ca(2320L).tM("pkh category illegal");
            com.baidu.swan.apps.am.e.aJt().j(tM2);
            return tM2;
        }
        if (bN.isFile() && !bN.delete()) {
            if (DEBUG) {
                pr.bW("SwanExtractor", "解压失败：解压目录被文件占用，且无法删除");
            }
            com.baidu.swan.apps.am.a tM3 = new com.baidu.swan.apps.am.a().bZ(11L).ca(2320L).tM("解压失败：解压目录被文件占用，且无法删除");
            com.baidu.swan.apps.am.e.aJt().j(tM3);
            return tM3;
        }
        if (!bN.exists()) {
            atX().putBoolean("result_output_dir_allow_rollback", true);
            if (!bN.mkdirs()) {
                if (DEBUG) {
                    pr.bW("SwanExtractor", "解压失败：解压文件夹创建失败");
                }
                com.baidu.swan.apps.am.a tM4 = new com.baidu.swan.apps.am.a().bZ(11L).ca(2320L).tM("解压失败：解压文件夹创建失败");
                com.baidu.swan.apps.am.e.aJt().j(tM4);
                return tM4;
            }
        }
        if (DEBUG) {
            pr.bW("SwanExtractor", "开始执行解压操作, folder:" + bN.getPath());
        }
        atX().putString("result_output_dir", bN.toString());
        long currentTimeMillis = System.currentTimeMillis();
        try {
            a.b a2 = com.baidu.swan.apps.r.a.a.a(bufferedInputStream);
            boolean z2 = false;
            int i2 = a2 == null ? -1 : a2.type;
            if (i2 != -1) {
                z2 = true;
            }
            fg(z2);
            if (z2) {
                a.C0451a a3 = com.baidu.swan.apps.r.a.a.a(bufferedInputStream, bN, i2);
                int i3 = i2;
                c0451a = a3;
                z = a3 != null && a3.isSuccess;
                i = i3;
            } else {
                boolean g = com.baidu.swan.c.f.g(bufferedInputStream, bN.getPath());
                i = 0;
                z = g;
                c0451a = null;
            }
            fh(z2);
            long currentTimeMillis2 = System.currentTimeMillis();
            if (DEBUG) {
                com.baidu.swan.apps.r.a.a.iP((int) (currentTimeMillis2 - currentTimeMillis));
            }
            if (this.cRo != null) {
                Bundle bundle = new Bundle();
                bundle.putInt("download_package_type_id", i);
                h.a(this.cRo, bundle, "event_download_package_type");
            }
            if (z) {
                return null;
            }
            com.baidu.swan.apps.am.a bZ = new com.baidu.swan.apps.am.a().bZ(11L);
            if (z2) {
                bZ.ca(2330L).tM("decrypt failed:" + c0451a.cIp);
            } else {
                bZ.ca(2320L).tM("unzip failed");
            }
            com.baidu.swan.apps.am.e.aJt().j(bZ);
            return bZ;
        } catch (IOException e) {
            if (DEBUG) {
                pr.bW("SwanExtractor", "obtainEncryptedBundle Exception: " + e.toString());
                e.printStackTrace();
            }
            com.baidu.swan.apps.am.a tM5 = new com.baidu.swan.apps.am.a().bZ(11L).ca(2320L).tM("obtainEncryptedBundle Exception: " + e.toString());
            com.baidu.swan.apps.am.e.aJt().j(tM5);
            return tM5;
        }
    }

    private void fg(boolean z) {
        if (z) {
            bR("670", "package_start_decrypt");
            bR("770", "na_package_start_decrypt");
            return;
        }
        bR("670", "package_start_unzip");
        bR("770", "na_package_start_unzip");
    }

    private void fh(boolean z) {
        if (z) {
            bR("670", "package_end_decrypt");
            bR("770", "na_package_end_decrypt");
            return;
        }
        bR("670", "package_end_unzip");
        bR("770", "na_package_end_unzip");
    }

    private void bR(String str, String str2) {
        if (this.cRo != null) {
            this.cRo.br(str, str2);
        }
    }
}
