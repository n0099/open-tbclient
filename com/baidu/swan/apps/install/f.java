package com.baidu.swan.apps.install;

import android.os.Bundle;
import android.support.annotation.NonNull;
import com.baidu.swan.apps.install.a.a;
import com.baidu.swan.apps.install.e;
import com.baidu.swan.apps.install.g;
import com.baidu.swan.games.i.a;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.Channels;
import java.nio.channels.Pipe;
/* loaded from: classes2.dex */
public class f extends g.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    final com.baidu.swan.pms.a.b aRY;
    final com.baidu.swan.pms.model.e aSf;

    public f(com.baidu.swan.pms.model.e eVar, com.baidu.swan.pms.a.b bVar) {
        super("extract");
        this.aSf = eVar;
        this.aRY = bVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.install.g.a
    public void Jd() {
        super.Jd();
        if (Jf().getBoolean("result_output_dir_allow_rollback", false)) {
            com.baidu.swan.c.a.lK(Jf().getString("result_output_dir"));
        }
    }

    @Override // com.baidu.swan.apps.install.g.a
    protected boolean a(Pipe.SourceChannel sourceChannel, Bundle bundle) {
        String string = bundle.getString("launch_id");
        com.baidu.swan.apps.v.c.a fF = com.baidu.swan.apps.v.c.a.fF(string);
        fF.KW().fI("SwanExtractor").dD(1);
        boolean b = b(Channels.newInputStream(sourceChannel), string);
        fF.as("SwanExtractor", "done: " + b);
        return b;
    }

    private boolean b(InputStream inputStream, String str) {
        if (inputStream == null) {
            return false;
        }
        com.baidu.swan.apps.ak.a a = a(new BufferedInputStream(inputStream), str);
        if (a == null) {
            return true;
        }
        com.baidu.swan.apps.v.c.a.fF(str).as("SwanExtractor", "onProcess installe error=" + a);
        Jf().putLong("result_error_code", a.TP());
        return false;
    }

    private com.baidu.swan.apps.ak.a a(@NonNull BufferedInputStream bufferedInputStream, String str) {
        File am;
        boolean d;
        a.C0191a c0191a;
        com.baidu.swan.apps.v.c.a fF = com.baidu.swan.apps.v.c.a.fF(str);
        if (this.aSf == null) {
            com.baidu.swan.apps.ak.a iL = new com.baidu.swan.apps.ak.a().as(11L).at(2320L).iL("pkg info is empty");
            com.baidu.swan.apps.ak.e.TT().b(iL);
            return iL;
        }
        if (this.aSf.category == 1) {
            am = a.d.am(this.aSf.bMa, String.valueOf(this.aSf.versionCode));
        } else if (this.aSf.category == 0) {
            am = e.d.am(this.aSf.bMa, String.valueOf(this.aSf.versionCode));
        } else {
            com.baidu.swan.apps.ak.a iL2 = new com.baidu.swan.apps.ak.a().as(11L).at(2320L).iL("pkh category illegal");
            com.baidu.swan.apps.ak.e.TT().b(iL2);
            return iL2;
        }
        if (am.isFile() && !am.delete()) {
            if (DEBUG) {
                fF.as("SwanExtractor", "解压失败：解压目录被文件占用，且无法删除");
            }
            com.baidu.swan.apps.ak.a iL3 = new com.baidu.swan.apps.ak.a().as(11L).at(2320L).iL("解压失败：解压目录被文件占用，且无法删除");
            com.baidu.swan.apps.ak.e.TT().b(iL3);
            return iL3;
        }
        if (!am.exists()) {
            Jf().putBoolean("result_output_dir_allow_rollback", true);
            if (!am.mkdirs()) {
                if (DEBUG) {
                    fF.as("SwanExtractor", "解压失败：解压文件夹创建失败");
                }
                com.baidu.swan.apps.ak.a iL4 = new com.baidu.swan.apps.ak.a().as(11L).at(2320L).iL("解压失败：解压文件夹创建失败");
                com.baidu.swan.apps.ak.e.TT().b(iL4);
                return iL4;
            }
        }
        if (DEBUG) {
            fF.as("SwanExtractor", "开始执行解压操作, folder:" + am.getPath());
        }
        Jf().putString("result_output_dir", am.toString());
        long currentTimeMillis = System.currentTimeMillis();
        try {
            boolean a = com.baidu.swan.apps.install.a.a.a(bufferedInputStream);
            bE(a);
            if (a) {
                c0191a = com.baidu.swan.apps.install.a.a.a(bufferedInputStream, am);
                d = c0191a.isSuccess;
            } else {
                d = com.baidu.swan.c.e.d(bufferedInputStream, am.getPath());
                c0191a = null;
            }
            bF(a);
            long currentTimeMillis2 = System.currentTimeMillis();
            if (DEBUG) {
                com.baidu.swan.apps.install.a.a.dw((int) (currentTimeMillis2 - currentTimeMillis));
            }
            if (d) {
                return null;
            }
            com.baidu.swan.apps.ak.a as = new com.baidu.swan.apps.ak.a().as(11L);
            if (a) {
                as.at(2330L).iL("decrypt failed:" + c0191a.aNi);
            } else {
                as.at(2320L).iL("unzip failed");
            }
            com.baidu.swan.apps.ak.e.TT().b(as);
            return as;
        } catch (IOException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            fF.as("SwanExtractor", "obtainEncryptedBundle Exception: " + e.toString());
            com.baidu.swan.apps.ak.a iL5 = new com.baidu.swan.apps.ak.a().as(11L).at(2320L).iL("obtainEncryptedBundle Exception: " + e.toString());
            com.baidu.swan.apps.ak.e.TT().b(iL5);
            return iL5;
        }
    }

    private void bE(boolean z) {
        if (z) {
            aq("670", "aiapp_aps_decrypt_start_timestamp");
            aq("770", "na_package_start_decrypt");
            return;
        }
        aq("670", "aiapp_aps_unzip_start_timestamp");
        aq("770", "na_package_start_unzip");
    }

    private void bF(boolean z) {
        if (z) {
            aq("670", "aiapp_aps_decrypt_end_timestamp");
            aq("770", "na_package_end_decrypt");
            return;
        }
        aq("670", "aiapp_aps_unzip_end_timestamp");
        aq("770", "na_package_end_unzip");
    }

    private void aq(String str, String str2) {
        if (this.aRY != null) {
            this.aRY.af(str, str2);
        }
    }
}
