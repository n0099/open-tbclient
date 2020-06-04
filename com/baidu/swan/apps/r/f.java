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
    private final com.baidu.swan.pms.a.d cgn;
    private final com.baidu.swan.pms.model.e cgu;

    public f(com.baidu.swan.pms.model.e eVar, com.baidu.swan.pms.a.d dVar) {
        super("extract");
        this.cgu = eVar;
        this.cgn = dVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.r.g.a
    public void aeM() {
        super.aeM();
        if (aeO().getBoolean("result_output_dir_allow_rollback", false)) {
            com.baidu.swan.e.d.tW(aeO().getString("result_output_dir"));
        }
    }

    @Override // com.baidu.swan.apps.r.g.a
    protected boolean a(Pipe.SourceChannel sourceChannel, Bundle bundle) {
        String string = bundle.getString("launch_id");
        com.baidu.swan.apps.v.c.a lk = com.baidu.swan.apps.v.c.a.lk(string);
        lk.ahk().ln("SwanExtractor").fG(1);
        boolean e = e(Channels.newInputStream(sourceChannel), string);
        lk.bt("SwanExtractor", "done: " + e);
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
        com.baidu.swan.apps.v.c.a.lk(str).bt("SwanExtractor", "onProcess installe error=" + a);
        aeO().putLong("result_error_code", a.asM());
        return false;
    }

    private com.baidu.swan.apps.an.a a(@NonNull BufferedInputStream bufferedInputStream, String str) {
        File bk;
        int i;
        boolean z;
        a.C0370a c0370a;
        com.baidu.swan.apps.v.c.a lk = com.baidu.swan.apps.v.c.a.lk(str);
        if (this.cgu == null) {
            com.baidu.swan.apps.an.a pt = new com.baidu.swan.apps.an.a().bw(11L).bx(2320L).pt("pkg info is empty");
            com.baidu.swan.apps.an.e.asQ().g(pt);
            return pt;
        }
        if (this.cgu.category == 1) {
            bk = a.c.bk(this.cgu.dlx, String.valueOf(this.cgu.versionCode));
        } else if (this.cgu.category == 0) {
            bk = e.d.bk(this.cgu.dlx, String.valueOf(this.cgu.versionCode));
        } else {
            com.baidu.swan.apps.an.a pt2 = new com.baidu.swan.apps.an.a().bw(11L).bx(2320L).pt("pkh category illegal");
            com.baidu.swan.apps.an.e.asQ().g(pt2);
            return pt2;
        }
        if (bk.isFile() && !bk.delete()) {
            if (DEBUG) {
                lk.bt("SwanExtractor", "解压失败：解压目录被文件占用，且无法删除");
            }
            com.baidu.swan.apps.an.a pt3 = new com.baidu.swan.apps.an.a().bw(11L).bx(2320L).pt("解压失败：解压目录被文件占用，且无法删除");
            com.baidu.swan.apps.an.e.asQ().g(pt3);
            return pt3;
        }
        if (!bk.exists()) {
            aeO().putBoolean("result_output_dir_allow_rollback", true);
            if (!bk.mkdirs()) {
                if (DEBUG) {
                    lk.bt("SwanExtractor", "解压失败：解压文件夹创建失败");
                }
                com.baidu.swan.apps.an.a pt4 = new com.baidu.swan.apps.an.a().bw(11L).bx(2320L).pt("解压失败：解压文件夹创建失败");
                com.baidu.swan.apps.an.e.asQ().g(pt4);
                return pt4;
            }
        }
        if (DEBUG) {
            lk.bt("SwanExtractor", "开始执行解压操作, folder:" + bk.getPath());
        }
        aeO().putString("result_output_dir", bk.toString());
        long currentTimeMillis = System.currentTimeMillis();
        try {
            a.b a = com.baidu.swan.apps.r.a.a.a(bufferedInputStream);
            boolean z2 = false;
            int i2 = a == null ? -1 : a.type;
            if (i2 != -1) {
                z2 = true;
            }
            dU(z2);
            if (z2) {
                a.C0370a a2 = com.baidu.swan.apps.r.a.a.a(bufferedInputStream, bk, i2);
                int i3 = i2;
                c0370a = a2;
                z = a2 != null && a2.isSuccess;
                i = i3;
            } else {
                boolean f = com.baidu.swan.e.g.f(bufferedInputStream, bk.getPath());
                i = 0;
                z = f;
                c0370a = null;
            }
            dV(z2);
            long currentTimeMillis2 = System.currentTimeMillis();
            if (DEBUG) {
                com.baidu.swan.apps.r.a.a.fy((int) (currentTimeMillis2 - currentTimeMillis));
            }
            if (this.cgn != null) {
                Bundle bundle = new Bundle();
                bundle.putInt("download_package_type_id", i);
                h.a(this.cgn, bundle, "event_download_package_type");
            }
            if (z) {
                return null;
            }
            com.baidu.swan.apps.an.a bw = new com.baidu.swan.apps.an.a().bw(11L);
            if (z2) {
                bw.bx(2330L).pt("decrypt failed:" + c0370a.bYH);
            } else {
                bw.bx(2320L).pt("unzip failed");
            }
            com.baidu.swan.apps.an.e.asQ().g(bw);
            return bw;
        } catch (IOException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            lk.bt("SwanExtractor", "obtainEncryptedBundle Exception: " + e.toString());
            com.baidu.swan.apps.an.a pt5 = new com.baidu.swan.apps.an.a().bw(11L).bx(2320L).pt("obtainEncryptedBundle Exception: " + e.toString());
            com.baidu.swan.apps.an.e.asQ().g(pt5);
            return pt5;
        }
    }

    private void dU(boolean z) {
        if (z) {
            bo("670", "package_start_decrypt");
            bo("770", "na_package_start_decrypt");
            return;
        }
        bo("670", "package_start_unzip");
        bo("770", "na_package_start_unzip");
    }

    private void dV(boolean z) {
        if (z) {
            bo("670", "package_end_decrypt");
            bo("770", "na_package_end_decrypt");
            return;
        }
        bo("670", "package_end_unzip");
        bo("770", "na_package_end_unzip");
    }

    private void bo(String str, String str2) {
        if (this.cgn != null) {
            this.cgn.aU(str, str2);
        }
    }
}
