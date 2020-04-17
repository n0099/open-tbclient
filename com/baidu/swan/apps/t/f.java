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
/* loaded from: classes11.dex */
public class f extends g.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final com.baidu.swan.pms.a.d bVM;
    private final com.baidu.swan.pms.model.e bVT;

    public f(com.baidu.swan.pms.model.e eVar, com.baidu.swan.pms.a.d dVar) {
        super("extract");
        this.bVT = eVar;
        this.bVM = dVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.t.g.a
    public void abJ() {
        super.abJ();
        if (abL().getBoolean("result_output_dir_allow_rollback", false)) {
            com.baidu.swan.d.c.st(abL().getString("result_output_dir"));
        }
    }

    @Override // com.baidu.swan.apps.t.g.a
    protected boolean a(Pipe.SourceChannel sourceChannel, Bundle bundle) {
        String string = bundle.getString("launch_id");
        com.baidu.swan.apps.x.c.a jY = com.baidu.swan.apps.x.c.a.jY(string);
        jY.aeb().kb("SwanExtractor").fr(1);
        boolean d = d(Channels.newInputStream(sourceChannel), string);
        jY.bc("SwanExtractor", "done: " + d);
        return d;
    }

    private boolean d(InputStream inputStream, String str) {
        if (inputStream == null) {
            return false;
        }
        com.baidu.swan.apps.ap.a a = a(new BufferedInputStream(inputStream), str);
        if (a == null) {
            return true;
        }
        com.baidu.swan.apps.x.c.a.jY(str).bc("SwanExtractor", "onProcess installe error=" + a);
        abL().putLong("result_error_code", a.aos());
        return false;
    }

    private com.baidu.swan.apps.ap.a a(@NonNull BufferedInputStream bufferedInputStream, String str) {
        File aT;
        int i;
        boolean z;
        a.C0331a c0331a;
        com.baidu.swan.apps.x.c.a jY = com.baidu.swan.apps.x.c.a.jY(str);
        if (this.bVT == null) {
            com.baidu.swan.apps.ap.a nL = new com.baidu.swan.apps.ap.a().bn(11L).bo(2320L).nL("pkg info is empty");
            com.baidu.swan.apps.ap.e.aow().f(nL);
            return nL;
        }
        if (this.bVT.category == 1) {
            aT = a.c.aT(this.bVT.dai, String.valueOf(this.bVT.versionCode));
        } else if (this.bVT.category == 0) {
            aT = e.d.aT(this.bVT.dai, String.valueOf(this.bVT.versionCode));
        } else {
            com.baidu.swan.apps.ap.a nL2 = new com.baidu.swan.apps.ap.a().bn(11L).bo(2320L).nL("pkh category illegal");
            com.baidu.swan.apps.ap.e.aow().f(nL2);
            return nL2;
        }
        if (aT.isFile() && !aT.delete()) {
            if (DEBUG) {
                jY.bc("SwanExtractor", "解压失败：解压目录被文件占用，且无法删除");
            }
            com.baidu.swan.apps.ap.a nL3 = new com.baidu.swan.apps.ap.a().bn(11L).bo(2320L).nL("解压失败：解压目录被文件占用，且无法删除");
            com.baidu.swan.apps.ap.e.aow().f(nL3);
            return nL3;
        }
        if (!aT.exists()) {
            abL().putBoolean("result_output_dir_allow_rollback", true);
            if (!aT.mkdirs()) {
                if (DEBUG) {
                    jY.bc("SwanExtractor", "解压失败：解压文件夹创建失败");
                }
                com.baidu.swan.apps.ap.a nL4 = new com.baidu.swan.apps.ap.a().bn(11L).bo(2320L).nL("解压失败：解压文件夹创建失败");
                com.baidu.swan.apps.ap.e.aow().f(nL4);
                return nL4;
            }
        }
        if (DEBUG) {
            jY.bc("SwanExtractor", "开始执行解压操作, folder:" + aT.getPath());
        }
        abL().putString("result_output_dir", aT.toString());
        long currentTimeMillis = System.currentTimeMillis();
        try {
            a.b a = com.baidu.swan.apps.t.a.a.a(bufferedInputStream);
            boolean z2 = false;
            int i2 = a == null ? -1 : a.type;
            if (i2 != -1) {
                z2 = true;
            }
            dE(z2);
            if (z2) {
                a.C0331a a2 = com.baidu.swan.apps.t.a.a.a(bufferedInputStream, aT, i2);
                int i3 = i2;
                c0331a = a2;
                z = a2 != null && a2.isSuccess;
                i = i3;
            } else {
                boolean e = com.baidu.swan.d.f.e(bufferedInputStream, aT.getPath());
                i = 0;
                z = e;
                c0331a = null;
            }
            dF(z2);
            long currentTimeMillis2 = System.currentTimeMillis();
            if (DEBUG) {
                com.baidu.swan.apps.t.a.a.fj((int) (currentTimeMillis2 - currentTimeMillis));
            }
            if (this.bVM != null) {
                Bundle bundle = new Bundle();
                bundle.putInt("download_package_type_id", i);
                h.a(this.bVM, bundle, "event_download_package_type");
            }
            if (z) {
                return null;
            }
            com.baidu.swan.apps.ap.a bn = new com.baidu.swan.apps.ap.a().bn(11L);
            if (z2) {
                bn.bo(2330L).nL("decrypt failed:" + c0331a.bPa);
            } else {
                bn.bo(2320L).nL("unzip failed");
            }
            com.baidu.swan.apps.ap.e.aow().f(bn);
            return bn;
        } catch (IOException e2) {
            if (DEBUG) {
                e2.printStackTrace();
            }
            jY.bc("SwanExtractor", "obtainEncryptedBundle Exception: " + e2.toString());
            com.baidu.swan.apps.ap.a nL5 = new com.baidu.swan.apps.ap.a().bn(11L).bo(2320L).nL("obtainEncryptedBundle Exception: " + e2.toString());
            com.baidu.swan.apps.ap.e.aow().f(nL5);
            return nL5;
        }
    }

    private void dE(boolean z) {
        if (z) {
            aX("670", "package_start_decrypt");
            aX("770", "na_package_start_decrypt");
            return;
        }
        aX("670", "package_start_unzip");
        aX("770", "na_package_start_unzip");
    }

    private void dF(boolean z) {
        if (z) {
            aX("670", "package_end_decrypt");
            aX("770", "na_package_end_decrypt");
            return;
        }
        aX("670", "package_end_unzip");
        aX("770", "na_package_end_unzip");
    }

    private void aX(String str, String str2) {
        if (this.bVM != null) {
            this.bVM.aE(str, str2);
        }
    }
}
