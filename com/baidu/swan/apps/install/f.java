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
    final com.baidu.swan.pms.a.b ayI;
    final com.baidu.swan.pms.model.e ayP;

    public f(com.baidu.swan.pms.model.e eVar, com.baidu.swan.pms.a.b bVar) {
        super("extract");
        this.ayP = eVar;
        this.ayI = bVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.install.g.a
    public void Ej() {
        super.Ej();
        if (El().getBoolean("result_output_dir_allow_rollback", false)) {
            com.baidu.swan.c.a.safeDeleteFile(El().getString("result_output_dir"));
        }
    }

    @Override // com.baidu.swan.apps.install.g.a
    protected boolean a(Pipe.SourceChannel sourceChannel, Bundle bundle) {
        String string = bundle.getString("launch_id");
        com.baidu.swan.apps.v.c.a eY = com.baidu.swan.apps.v.c.a.eY(string);
        eY.Gc().fb("SwanExtractor").cI(1);
        boolean b = b(Channels.newInputStream(sourceChannel), string);
        eY.ak("SwanExtractor", "done: " + b);
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
        com.baidu.swan.apps.v.c.a.eY(str).ak("SwanExtractor", "onProcess installe error=" + a);
        El().putLong("result_error_code", a.OZ());
        return false;
    }

    private com.baidu.swan.apps.ak.a a(@NonNull BufferedInputStream bufferedInputStream, String str) {
        File ae;
        boolean d;
        a.C0159a c0159a;
        com.baidu.swan.apps.v.c.a eY = com.baidu.swan.apps.v.c.a.eY(str);
        if (this.ayP == null) {
            com.baidu.swan.apps.ak.a ii = new com.baidu.swan.apps.ak.a().Z(11L).aa(2320L).ii("pkg info is empty");
            com.baidu.swan.apps.ak.e.Pd().b(ii);
            return ii;
        }
        if (this.ayP.avC == 1) {
            ae = a.d.ae(this.ayP.btp, String.valueOf(this.ayP.versionCode));
        } else if (this.ayP.avC == 0) {
            ae = e.d.ae(this.ayP.btp, String.valueOf(this.ayP.versionCode));
        } else {
            com.baidu.swan.apps.ak.a ii2 = new com.baidu.swan.apps.ak.a().Z(11L).aa(2320L).ii("pkh category illegal");
            com.baidu.swan.apps.ak.e.Pd().b(ii2);
            return ii2;
        }
        if (ae.isFile() && !ae.delete()) {
            if (DEBUG) {
                eY.ak("SwanExtractor", "解压失败：解压目录被文件占用，且无法删除");
            }
            com.baidu.swan.apps.ak.a ii3 = new com.baidu.swan.apps.ak.a().Z(11L).aa(2320L).ii("解压失败：解压目录被文件占用，且无法删除");
            com.baidu.swan.apps.ak.e.Pd().b(ii3);
            return ii3;
        }
        if (!ae.exists()) {
            El().putBoolean("result_output_dir_allow_rollback", true);
            if (!ae.mkdirs()) {
                if (DEBUG) {
                    eY.ak("SwanExtractor", "解压失败：解压文件夹创建失败");
                }
                com.baidu.swan.apps.ak.a ii4 = new com.baidu.swan.apps.ak.a().Z(11L).aa(2320L).ii("解压失败：解压文件夹创建失败");
                com.baidu.swan.apps.ak.e.Pd().b(ii4);
                return ii4;
            }
        }
        if (DEBUG) {
            eY.ak("SwanExtractor", "开始执行解压操作, folder:" + ae.getPath());
        }
        El().putString("result_output_dir", ae.toString());
        long currentTimeMillis = System.currentTimeMillis();
        try {
            boolean a = com.baidu.swan.apps.install.a.a.a(bufferedInputStream);
            bm(a);
            if (a) {
                c0159a = com.baidu.swan.apps.install.a.a.a(bufferedInputStream, ae);
                d = c0159a.isSuccess;
            } else {
                d = com.baidu.swan.c.e.d(bufferedInputStream, ae.getPath());
                c0159a = null;
            }
            bn(a);
            long currentTimeMillis2 = System.currentTimeMillis();
            if (DEBUG) {
                com.baidu.swan.apps.install.a.a.cB((int) (currentTimeMillis2 - currentTimeMillis));
            }
            if (d) {
                return null;
            }
            com.baidu.swan.apps.ak.a Z = new com.baidu.swan.apps.ak.a().Z(11L);
            if (a) {
                Z.aa(2330L).ii("decrypt failed:" + c0159a.atR);
            } else {
                Z.aa(2320L).ii("unzip failed");
            }
            com.baidu.swan.apps.ak.e.Pd().b(Z);
            return Z;
        } catch (IOException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            eY.ak("SwanExtractor", "obtainEncryptedBundle Exception: " + e.toString());
            com.baidu.swan.apps.ak.a ii5 = new com.baidu.swan.apps.ak.a().Z(11L).aa(2320L).ii("obtainEncryptedBundle Exception: " + e.toString());
            com.baidu.swan.apps.ak.e.Pd().b(ii5);
            return ii5;
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
        if (this.ayI != null) {
            this.ayI.X(str, str2);
        }
    }
}
