package com.baidu.swan.apps.r;

import android.os.Bundle;
import android.support.annotation.NonNull;
import com.baidu.swan.apps.r.a.a;
import com.baidu.swan.apps.r.e;
import com.baidu.swan.apps.r.g;
import com.baidu.swan.games.l.a;
import com.baidu.swan.pms.a.h;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.Channels;
import java.nio.channels.Pipe;
/* loaded from: classes11.dex */
public class f extends g.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final com.baidu.swan.pms.a.d clb;
    private final com.baidu.swan.pms.model.e cli;

    public f(com.baidu.swan.pms.model.e eVar, com.baidu.swan.pms.a.d dVar) {
        super("extract");
        this.cli = eVar;
        this.clb = dVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.r.g.a
    public void afS() {
        super.afS();
        if (afU().getBoolean("result_output_dir_allow_rollback", false)) {
            com.baidu.swan.e.d.ue(afU().getString("result_output_dir"));
        }
    }

    @Override // com.baidu.swan.apps.r.g.a
    protected boolean a(Pipe.SourceChannel sourceChannel, Bundle bundle) {
        String string = bundle.getString("launch_id");
        com.baidu.swan.apps.v.c.a ls = com.baidu.swan.apps.v.c.a.ls(string);
        ls.aiq().lv("SwanExtractor").fR(1);
        boolean e = e(Channels.newInputStream(sourceChannel), string);
        ls.bv("SwanExtractor", "done: " + e);
        return e;
    }

    private boolean e(InputStream inputStream, String str) {
        if (inputStream == null) {
            return false;
        }
        com.baidu.swan.apps.an.a a = a(new BufferedInputStream(inputStream), str);
        if (a == null) {
            return true;
        }
        com.baidu.swan.apps.v.c.a.ls(str).bv("SwanExtractor", "onProcess installe error=" + a);
        afU().putLong("result_error_code", a.atS());
        return false;
    }

    private com.baidu.swan.apps.an.a a(@NonNull BufferedInputStream bufferedInputStream, String str) {
        File bm;
        int i;
        boolean z;
        a.C0376a c0376a;
        com.baidu.swan.apps.v.c.a ls = com.baidu.swan.apps.v.c.a.ls(str);
        if (this.cli == null) {
            com.baidu.swan.apps.an.a pB = new com.baidu.swan.apps.an.a().bw(11L).bx(2320L).pB("pkg info is empty");
            com.baidu.swan.apps.an.e.atW().g(pB);
            return pB;
        }
        if (this.cli.category == 1) {
            bm = a.c.bm(this.cli.dqi, String.valueOf(this.cli.versionCode));
        } else if (this.cli.category == 0) {
            bm = e.d.bm(this.cli.dqi, String.valueOf(this.cli.versionCode));
        } else {
            com.baidu.swan.apps.an.a pB2 = new com.baidu.swan.apps.an.a().bw(11L).bx(2320L).pB("pkh category illegal");
            com.baidu.swan.apps.an.e.atW().g(pB2);
            return pB2;
        }
        if (bm.isFile() && !bm.delete()) {
            if (DEBUG) {
                ls.bv("SwanExtractor", "解压失败：解压目录被文件占用，且无法删除");
            }
            com.baidu.swan.apps.an.a pB3 = new com.baidu.swan.apps.an.a().bw(11L).bx(2320L).pB("解压失败：解压目录被文件占用，且无法删除");
            com.baidu.swan.apps.an.e.atW().g(pB3);
            return pB3;
        }
        if (!bm.exists()) {
            afU().putBoolean("result_output_dir_allow_rollback", true);
            if (!bm.mkdirs()) {
                if (DEBUG) {
                    ls.bv("SwanExtractor", "解压失败：解压文件夹创建失败");
                }
                com.baidu.swan.apps.an.a pB4 = new com.baidu.swan.apps.an.a().bw(11L).bx(2320L).pB("解压失败：解压文件夹创建失败");
                com.baidu.swan.apps.an.e.atW().g(pB4);
                return pB4;
            }
        }
        if (DEBUG) {
            ls.bv("SwanExtractor", "开始执行解压操作, folder:" + bm.getPath());
        }
        afU().putString("result_output_dir", bm.toString());
        long currentTimeMillis = System.currentTimeMillis();
        try {
            a.b a = com.baidu.swan.apps.r.a.a.a(bufferedInputStream);
            boolean z2 = false;
            int i2 = a == null ? -1 : a.type;
            if (i2 != -1) {
                z2 = true;
            }
            dZ(z2);
            if (z2) {
                a.C0376a a2 = com.baidu.swan.apps.r.a.a.a(bufferedInputStream, bm, i2);
                int i3 = i2;
                c0376a = a2;
                z = a2 != null && a2.isSuccess;
                i = i3;
            } else {
                boolean f = com.baidu.swan.e.g.f(bufferedInputStream, bm.getPath());
                i = 0;
                z = f;
                c0376a = null;
            }
            ea(z2);
            long currentTimeMillis2 = System.currentTimeMillis();
            if (DEBUG) {
                com.baidu.swan.apps.r.a.a.fJ((int) (currentTimeMillis2 - currentTimeMillis));
            }
            if (this.clb != null) {
                Bundle bundle = new Bundle();
                bundle.putInt("download_package_type_id", i);
                h.a(this.clb, bundle, "event_download_package_type");
            }
            if (z) {
                return null;
            }
            com.baidu.swan.apps.an.a bw = new com.baidu.swan.apps.an.a().bw(11L);
            if (z2) {
                bw.bx(2330L).pB("decrypt failed:" + c0376a.cdx);
            } else {
                bw.bx(2320L).pB("unzip failed");
            }
            com.baidu.swan.apps.an.e.atW().g(bw);
            return bw;
        } catch (IOException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            ls.bv("SwanExtractor", "obtainEncryptedBundle Exception: " + e.toString());
            com.baidu.swan.apps.an.a pB5 = new com.baidu.swan.apps.an.a().bw(11L).bx(2320L).pB("obtainEncryptedBundle Exception: " + e.toString());
            com.baidu.swan.apps.an.e.atW().g(pB5);
            return pB5;
        }
    }

    private void dZ(boolean z) {
        if (z) {
            bq("670", "package_start_decrypt");
            bq("770", "na_package_start_decrypt");
            return;
        }
        bq("670", "package_start_unzip");
        bq("770", "na_package_start_unzip");
    }

    private void ea(boolean z) {
        if (z) {
            bq("670", "package_end_decrypt");
            bq("770", "na_package_end_decrypt");
            return;
        }
        bq("670", "package_end_unzip");
        bq("770", "na_package_end_unzip");
    }

    private void bq(String str, String str2) {
        if (this.clb != null) {
            this.clb.aW(str, str2);
        }
    }
}
