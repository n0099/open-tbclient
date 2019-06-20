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
    final com.baidu.swan.pms.a.b axD;
    final com.baidu.swan.pms.model.e axK;

    public f(com.baidu.swan.pms.model.e eVar, com.baidu.swan.pms.a.b bVar) {
        super("extract");
        this.axK = eVar;
        this.axD = bVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.install.g.a
    public void Dw() {
        super.Dw();
        if (Dy().getBoolean("result_output_dir_allow_rollback", false)) {
            com.baidu.swan.c.a.safeDeleteFile(Dy().getString("result_output_dir"));
        }
    }

    @Override // com.baidu.swan.apps.install.g.a
    protected boolean a(Pipe.SourceChannel sourceChannel, Bundle bundle) {
        String string = bundle.getString("launch_id");
        com.baidu.swan.apps.v.c.a eR = com.baidu.swan.apps.v.c.a.eR(string);
        eR.Fo().eU("SwanExtractor").cG(1);
        boolean b = b(Channels.newInputStream(sourceChannel), string);
        eR.ak("SwanExtractor", "done: " + b);
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
        com.baidu.swan.apps.v.c.a.eR(str).ak("SwanExtractor", "onProcess installe error=" + a);
        Dy().putLong("result_error_code", a.Og());
        return false;
    }

    private com.baidu.swan.apps.ak.a a(@NonNull BufferedInputStream bufferedInputStream, String str) {
        File ae;
        boolean d;
        a.C0148a c0148a;
        com.baidu.swan.apps.v.c.a eR = com.baidu.swan.apps.v.c.a.eR(str);
        if (this.axK == null) {
            com.baidu.swan.apps.ak.a hY = new com.baidu.swan.apps.ak.a().Y(11L).Z(2320L).hY("pkg info is empty");
            com.baidu.swan.apps.ak.e.Ok().b(hY);
            return hY;
        }
        if (this.axK.category == 1) {
            ae = a.d.ae(this.axK.bsc, String.valueOf(this.axK.versionCode));
        } else if (this.axK.category == 0) {
            ae = e.d.ae(this.axK.bsc, String.valueOf(this.axK.versionCode));
        } else {
            com.baidu.swan.apps.ak.a hY2 = new com.baidu.swan.apps.ak.a().Y(11L).Z(2320L).hY("pkh category illegal");
            com.baidu.swan.apps.ak.e.Ok().b(hY2);
            return hY2;
        }
        if (ae.isFile() && !ae.delete()) {
            if (DEBUG) {
                eR.ak("SwanExtractor", "解压失败：解压目录被文件占用，且无法删除");
            }
            com.baidu.swan.apps.ak.a hY3 = new com.baidu.swan.apps.ak.a().Y(11L).Z(2320L).hY("解压失败：解压目录被文件占用，且无法删除");
            com.baidu.swan.apps.ak.e.Ok().b(hY3);
            return hY3;
        }
        if (!ae.exists()) {
            Dy().putBoolean("result_output_dir_allow_rollback", true);
            if (!ae.mkdirs()) {
                if (DEBUG) {
                    eR.ak("SwanExtractor", "解压失败：解压文件夹创建失败");
                }
                com.baidu.swan.apps.ak.a hY4 = new com.baidu.swan.apps.ak.a().Y(11L).Z(2320L).hY("解压失败：解压文件夹创建失败");
                com.baidu.swan.apps.ak.e.Ok().b(hY4);
                return hY4;
            }
        }
        if (DEBUG) {
            eR.ak("SwanExtractor", "开始执行解压操作, folder:" + ae.getPath());
        }
        Dy().putString("result_output_dir", ae.toString());
        long currentTimeMillis = System.currentTimeMillis();
        try {
            boolean a = com.baidu.swan.apps.install.a.a.a(bufferedInputStream);
            bj(a);
            if (a) {
                c0148a = com.baidu.swan.apps.install.a.a.a(bufferedInputStream, ae);
                d = c0148a.isSuccess;
            } else {
                d = com.baidu.swan.c.e.d(bufferedInputStream, ae.getPath());
                c0148a = null;
            }
            bk(a);
            long currentTimeMillis2 = System.currentTimeMillis();
            if (DEBUG) {
                com.baidu.swan.apps.install.a.a.cA((int) (currentTimeMillis2 - currentTimeMillis));
            }
            if (d) {
                return null;
            }
            com.baidu.swan.apps.ak.a Y = new com.baidu.swan.apps.ak.a().Y(11L);
            if (a) {
                Y.Z(2330L).hY("decrypt failed:" + c0148a.asQ);
            } else {
                Y.Z(2320L).hY("unzip failed");
            }
            com.baidu.swan.apps.ak.e.Ok().b(Y);
            return Y;
        } catch (IOException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            eR.ak("SwanExtractor", "obtainEncryptedBundle Exception: " + e.toString());
            com.baidu.swan.apps.ak.a hY5 = new com.baidu.swan.apps.ak.a().Y(11L).Z(2320L).hY("obtainEncryptedBundle Exception: " + e.toString());
            com.baidu.swan.apps.ak.e.Ok().b(hY5);
            return hY5;
        }
    }

    private void bj(boolean z) {
        if (z) {
            ai("670", "aiapp_aps_decrypt_start_timestamp");
            ai("770", "na_package_start_decrypt");
            return;
        }
        ai("670", "aiapp_aps_unzip_start_timestamp");
        ai("770", "na_package_start_unzip");
    }

    private void bk(boolean z) {
        if (z) {
            ai("670", "aiapp_aps_decrypt_end_timestamp");
            ai("770", "na_package_end_decrypt");
            return;
        }
        ai("670", "aiapp_aps_unzip_end_timestamp");
        ai("770", "na_package_end_unzip");
    }

    private void ai(String str, String str2) {
        if (this.axD != null) {
            this.axD.X(str, str2);
        }
    }
}
