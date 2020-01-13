package com.baidu.swan.apps.t;

import android.os.Bundle;
import android.support.annotation.NonNull;
import com.baidu.swan.apps.t.a.a;
import com.baidu.swan.apps.t.e;
import com.baidu.swan.apps.t.g;
import com.baidu.swan.games.k.a;
import com.baidu.swan.pms.a.h;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.Channels;
import java.nio.channels.Pipe;
/* loaded from: classes10.dex */
public class f extends g.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final com.baidu.swan.pms.a.d btj;
    private final com.baidu.swan.pms.model.e btq;

    public f(com.baidu.swan.pms.model.e eVar, com.baidu.swan.pms.a.d dVar) {
        super("extract");
        this.btq = eVar;
        this.btj = dVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.t.g.a
    public void RB() {
        super.RB();
        if (RD().getBoolean("result_output_dir_allow_rollback", false)) {
            com.baidu.swan.d.c.qR(RD().getString("result_output_dir"));
        }
    }

    @Override // com.baidu.swan.apps.t.g.a
    protected boolean a(Pipe.SourceChannel sourceChannel, Bundle bundle) {
        String string = bundle.getString("launch_id");
        com.baidu.swan.apps.x.c.a ix = com.baidu.swan.apps.x.c.a.ix(string);
        ix.TT().iA("SwanExtractor").eW(1);
        boolean e = e(Channels.newInputStream(sourceChannel), string);
        ix.aJ("SwanExtractor", "done: " + e);
        return e;
    }

    private boolean e(InputStream inputStream, String str) {
        if (inputStream == null) {
            return false;
        }
        com.baidu.swan.apps.ap.a a = a(new BufferedInputStream(inputStream), str);
        if (a == null) {
            return true;
        }
        com.baidu.swan.apps.x.c.a.ix(str).aJ("SwanExtractor", "onProcess installe error=" + a);
        RD().putLong("result_error_code", a.adU());
        return false;
    }

    private com.baidu.swan.apps.ap.a a(@NonNull BufferedInputStream bufferedInputStream, String str) {
        File aB;
        int i;
        boolean z;
        a.C0291a c0291a;
        com.baidu.swan.apps.x.c.a ix = com.baidu.swan.apps.x.c.a.ix(str);
        if (this.btq == null) {
            com.baidu.swan.apps.ap.a mk = new com.baidu.swan.apps.ap.a().aE(11L).aF(2320L).mk("pkg info is empty");
            com.baidu.swan.apps.ap.e.adY().f(mk);
            return mk;
        }
        if (this.btq.category == 1) {
            aB = a.c.aB(this.btq.cwZ, String.valueOf(this.btq.versionCode));
        } else if (this.btq.category == 0) {
            aB = e.d.aB(this.btq.cwZ, String.valueOf(this.btq.versionCode));
        } else {
            com.baidu.swan.apps.ap.a mk2 = new com.baidu.swan.apps.ap.a().aE(11L).aF(2320L).mk("pkh category illegal");
            com.baidu.swan.apps.ap.e.adY().f(mk2);
            return mk2;
        }
        if (aB.isFile() && !aB.delete()) {
            if (DEBUG) {
                ix.aJ("SwanExtractor", "解压失败：解压目录被文件占用，且无法删除");
            }
            com.baidu.swan.apps.ap.a mk3 = new com.baidu.swan.apps.ap.a().aE(11L).aF(2320L).mk("解压失败：解压目录被文件占用，且无法删除");
            com.baidu.swan.apps.ap.e.adY().f(mk3);
            return mk3;
        }
        if (!aB.exists()) {
            RD().putBoolean("result_output_dir_allow_rollback", true);
            if (!aB.mkdirs()) {
                if (DEBUG) {
                    ix.aJ("SwanExtractor", "解压失败：解压文件夹创建失败");
                }
                com.baidu.swan.apps.ap.a mk4 = new com.baidu.swan.apps.ap.a().aE(11L).aF(2320L).mk("解压失败：解压文件夹创建失败");
                com.baidu.swan.apps.ap.e.adY().f(mk4);
                return mk4;
            }
        }
        if (DEBUG) {
            ix.aJ("SwanExtractor", "开始执行解压操作, folder:" + aB.getPath());
        }
        RD().putString("result_output_dir", aB.toString());
        long currentTimeMillis = System.currentTimeMillis();
        try {
            a.b a = com.baidu.swan.apps.t.a.a.a(bufferedInputStream);
            boolean z2 = false;
            int i2 = a == null ? -1 : a.type;
            if (i2 != -1) {
                z2 = true;
            }
            cA(z2);
            if (z2) {
                a.C0291a a2 = com.baidu.swan.apps.t.a.a.a(bufferedInputStream, aB, i2);
                int i3 = i2;
                c0291a = a2;
                z = a2 != null && a2.isSuccess;
                i = i3;
            } else {
                boolean f = com.baidu.swan.d.f.f(bufferedInputStream, aB.getPath());
                i = 0;
                z = f;
                c0291a = null;
            }
            cB(z2);
            long currentTimeMillis2 = System.currentTimeMillis();
            if (DEBUG) {
                com.baidu.swan.apps.t.a.a.eO((int) (currentTimeMillis2 - currentTimeMillis));
            }
            if (this.btj != null) {
                Bundle bundle = new Bundle();
                bundle.putInt("download_package_type_id", i);
                h.a(this.btj, bundle, "event_download_package_type");
            }
            if (z) {
                return null;
            }
            com.baidu.swan.apps.ap.a aE = new com.baidu.swan.apps.ap.a().aE(11L);
            if (z2) {
                aE.aF(2330L).mk("decrypt failed:" + c0291a.bmw);
            } else {
                aE.aF(2320L).mk("unzip failed");
            }
            com.baidu.swan.apps.ap.e.adY().f(aE);
            return aE;
        } catch (IOException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            ix.aJ("SwanExtractor", "obtainEncryptedBundle Exception: " + e.toString());
            com.baidu.swan.apps.ap.a mk5 = new com.baidu.swan.apps.ap.a().aE(11L).aF(2320L).mk("obtainEncryptedBundle Exception: " + e.toString());
            com.baidu.swan.apps.ap.e.adY().f(mk5);
            return mk5;
        }
    }

    private void cA(boolean z) {
        if (z) {
            aF("670", "package_start_decrypt");
            aF("770", "na_package_start_decrypt");
            return;
        }
        aF("670", "package_start_unzip");
        aF("770", "na_package_start_unzip");
    }

    private void cB(boolean z) {
        if (z) {
            aF("670", "package_end_decrypt");
            aF("770", "na_package_end_decrypt");
            return;
        }
        aF("670", "package_end_unzip");
        aF("770", "na_package_end_unzip");
    }

    private void aF(String str, String str2) {
        if (this.btj != null) {
            this.btj.am(str, str2);
        }
    }
}
