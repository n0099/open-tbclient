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
    final com.baidu.swan.pms.a.b ayk;
    final com.baidu.swan.pms.model.e ayr;

    public f(com.baidu.swan.pms.model.e eVar, com.baidu.swan.pms.a.b bVar) {
        super("extract");
        this.ayr = eVar;
        this.ayk = bVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.install.g.a
    public void Ef() {
        super.Ef();
        if (Eh().getBoolean("result_output_dir_allow_rollback", false)) {
            com.baidu.swan.c.a.safeDeleteFile(Eh().getString("result_output_dir"));
        }
    }

    @Override // com.baidu.swan.apps.install.g.a
    protected boolean a(Pipe.SourceChannel sourceChannel, Bundle bundle) {
        String string = bundle.getString("launch_id");
        com.baidu.swan.apps.v.c.a eW = com.baidu.swan.apps.v.c.a.eW(string);
        eW.FY().eZ("SwanExtractor").cH(1);
        boolean b = b(Channels.newInputStream(sourceChannel), string);
        eW.ak("SwanExtractor", "done: " + b);
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
        com.baidu.swan.apps.v.c.a.eW(str).ak("SwanExtractor", "onProcess installe error=" + a);
        Eh().putLong("result_error_code", a.OV());
        return false;
    }

    private com.baidu.swan.apps.ak.a a(@NonNull BufferedInputStream bufferedInputStream, String str) {
        File ae;
        boolean d;
        a.C0145a c0145a;
        com.baidu.swan.apps.v.c.a eW = com.baidu.swan.apps.v.c.a.eW(str);
        if (this.ayr == null) {
            com.baidu.swan.apps.ak.a ig = new com.baidu.swan.apps.ak.a().Z(11L).aa(2320L).ig("pkg info is empty");
            com.baidu.swan.apps.ak.e.OZ().b(ig);
            return ig;
        }
        if (this.ayr.ave == 1) {
            ae = a.d.ae(this.ayr.bsR, String.valueOf(this.ayr.versionCode));
        } else if (this.ayr.ave == 0) {
            ae = e.d.ae(this.ayr.bsR, String.valueOf(this.ayr.versionCode));
        } else {
            com.baidu.swan.apps.ak.a ig2 = new com.baidu.swan.apps.ak.a().Z(11L).aa(2320L).ig("pkh category illegal");
            com.baidu.swan.apps.ak.e.OZ().b(ig2);
            return ig2;
        }
        if (ae.isFile() && !ae.delete()) {
            if (DEBUG) {
                eW.ak("SwanExtractor", "解压失败：解压目录被文件占用，且无法删除");
            }
            com.baidu.swan.apps.ak.a ig3 = new com.baidu.swan.apps.ak.a().Z(11L).aa(2320L).ig("解压失败：解压目录被文件占用，且无法删除");
            com.baidu.swan.apps.ak.e.OZ().b(ig3);
            return ig3;
        }
        if (!ae.exists()) {
            Eh().putBoolean("result_output_dir_allow_rollback", true);
            if (!ae.mkdirs()) {
                if (DEBUG) {
                    eW.ak("SwanExtractor", "解压失败：解压文件夹创建失败");
                }
                com.baidu.swan.apps.ak.a ig4 = new com.baidu.swan.apps.ak.a().Z(11L).aa(2320L).ig("解压失败：解压文件夹创建失败");
                com.baidu.swan.apps.ak.e.OZ().b(ig4);
                return ig4;
            }
        }
        if (DEBUG) {
            eW.ak("SwanExtractor", "开始执行解压操作, folder:" + ae.getPath());
        }
        Eh().putString("result_output_dir", ae.toString());
        long currentTimeMillis = System.currentTimeMillis();
        try {
            boolean a = com.baidu.swan.apps.install.a.a.a(bufferedInputStream);
            bm(a);
            if (a) {
                c0145a = com.baidu.swan.apps.install.a.a.a(bufferedInputStream, ae);
                d = c0145a.isSuccess;
            } else {
                d = com.baidu.swan.c.e.d(bufferedInputStream, ae.getPath());
                c0145a = null;
            }
            bn(a);
            long currentTimeMillis2 = System.currentTimeMillis();
            if (DEBUG) {
                com.baidu.swan.apps.install.a.a.cA((int) (currentTimeMillis2 - currentTimeMillis));
            }
            if (d) {
                return null;
            }
            com.baidu.swan.apps.ak.a Z = new com.baidu.swan.apps.ak.a().Z(11L);
            if (a) {
                Z.aa(2330L).ig("decrypt failed:" + c0145a.att);
            } else {
                Z.aa(2320L).ig("unzip failed");
            }
            com.baidu.swan.apps.ak.e.OZ().b(Z);
            return Z;
        } catch (IOException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            eW.ak("SwanExtractor", "obtainEncryptedBundle Exception: " + e.toString());
            com.baidu.swan.apps.ak.a ig5 = new com.baidu.swan.apps.ak.a().Z(11L).aa(2320L).ig("obtainEncryptedBundle Exception: " + e.toString());
            com.baidu.swan.apps.ak.e.OZ().b(ig5);
            return ig5;
        }
    }

    private void bm(boolean z) {
        if (z) {
            ai("670", "aiapp_aps_decrypt_start_timestamp");
            ai("770", "na_package_start_decrypt");
            return;
        }
        ai("670", "aiapp_aps_unzip_start_timestamp");
        ai("770", "na_package_start_unzip");
    }

    private void bn(boolean z) {
        if (z) {
            ai("670", "aiapp_aps_decrypt_end_timestamp");
            ai("770", "na_package_end_decrypt");
            return;
        }
        ai("670", "aiapp_aps_unzip_end_timestamp");
        ai("770", "na_package_end_unzip");
    }

    private void ai(String str, String str2) {
        if (this.ayk != null) {
            this.ayk.X(str, str2);
        }
    }
}
