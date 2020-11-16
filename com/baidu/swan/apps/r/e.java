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
/* loaded from: classes7.dex */
public class e extends f.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final com.baidu.swan.pms.model.e cVE;
    private final com.baidu.swan.pms.a.d cVx;

    public e(com.baidu.swan.pms.model.e eVar, com.baidu.swan.pms.a.d dVar) {
        super("extract");
        this.cVE = eVar;
        this.cVx = dVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.r.f.a
    public void avN() {
        super.avN();
        if (avP().getBoolean("result_output_dir_allow_rollback", false)) {
            com.baidu.swan.c.d.za(avP().getString("result_output_dir"));
        }
    }

    @Override // com.baidu.swan.apps.r.f.a
    protected boolean a(Pipe.SourceChannel sourceChannel, Bundle bundle) {
        String string = bundle.getString("launch_id");
        com.baidu.swan.apps.u.e.a aVar = null;
        if (DEBUG) {
            aVar = com.baidu.swan.apps.u.e.a.pz(string);
            aVar.ayw().pC("SwanExtractor").jd(1);
        }
        boolean f = f(Channels.newInputStream(sourceChannel), string);
        if (aVar != null && DEBUG) {
            aVar.bV("SwanExtractor", "done: " + f);
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
            com.baidu.swan.apps.u.e.a.pz(str).bV("SwanExtractor", "onProcess installe error=" + a2);
        }
        avP().putLong("result_error_code", a2.aLh());
        return false;
    }

    private com.baidu.swan.apps.am.a a(@NonNull BufferedInputStream bufferedInputStream, String str) {
        File bM;
        int i;
        boolean z;
        a.C0461a c0461a;
        com.baidu.swan.apps.u.e.a pz = com.baidu.swan.apps.u.e.a.pz(str);
        if (this.cVE == null) {
            com.baidu.swan.apps.am.a tV = new com.baidu.swan.apps.am.a().cv(11L).cw(2320L).tV("pkg info is empty");
            com.baidu.swan.apps.am.e.aLl().j(tV);
            return tV;
        }
        if (this.cVE.category == 1) {
            bM = a.c.bM(this.cVE.efY, String.valueOf(this.cVE.versionCode));
        } else if (this.cVE.category == 0) {
            bM = d.C0462d.bM(this.cVE.efY, String.valueOf(this.cVE.versionCode));
        } else {
            com.baidu.swan.apps.am.a tV2 = new com.baidu.swan.apps.am.a().cv(11L).cw(2320L).tV("pkh category illegal");
            com.baidu.swan.apps.am.e.aLl().j(tV2);
            return tV2;
        }
        if (bM.isFile() && !bM.delete()) {
            if (DEBUG) {
                pz.bV("SwanExtractor", "解压失败：解压目录被文件占用，且无法删除");
            }
            com.baidu.swan.apps.am.a tV3 = new com.baidu.swan.apps.am.a().cv(11L).cw(2320L).tV("解压失败：解压目录被文件占用，且无法删除");
            com.baidu.swan.apps.am.e.aLl().j(tV3);
            return tV3;
        }
        if (!bM.exists()) {
            avP().putBoolean("result_output_dir_allow_rollback", true);
            if (!bM.mkdirs()) {
                if (DEBUG) {
                    pz.bV("SwanExtractor", "解压失败：解压文件夹创建失败");
                }
                com.baidu.swan.apps.am.a tV4 = new com.baidu.swan.apps.am.a().cv(11L).cw(2320L).tV("解压失败：解压文件夹创建失败");
                com.baidu.swan.apps.am.e.aLl().j(tV4);
                return tV4;
            }
        }
        if (DEBUG) {
            pz.bV("SwanExtractor", "开始执行解压操作, folder:" + bM.getPath());
        }
        avP().putString("result_output_dir", bM.toString());
        long currentTimeMillis = System.currentTimeMillis();
        try {
            a.b a2 = com.baidu.swan.apps.r.a.a.a(bufferedInputStream);
            boolean z2 = false;
            int i2 = a2 == null ? -1 : a2.type;
            if (i2 != -1) {
                z2 = true;
            }
            fs(z2);
            if (z2) {
                a.C0461a a3 = com.baidu.swan.apps.r.a.a.a(bufferedInputStream, bM, i2);
                int i3 = i2;
                c0461a = a3;
                z = a3 != null && a3.isSuccess;
                i = i3;
            } else {
                boolean g = com.baidu.swan.c.f.g(bufferedInputStream, bM.getPath());
                i = 0;
                z = g;
                c0461a = null;
            }
            ft(z2);
            long currentTimeMillis2 = System.currentTimeMillis();
            if (DEBUG) {
                com.baidu.swan.apps.r.a.a.iV((int) (currentTimeMillis2 - currentTimeMillis));
            }
            if (this.cVx != null) {
                Bundle bundle = new Bundle();
                bundle.putInt("download_package_type_id", i);
                h.a(this.cVx, bundle, "event_download_package_type");
            }
            if (z) {
                return null;
            }
            com.baidu.swan.apps.am.a cv = new com.baidu.swan.apps.am.a().cv(11L);
            if (z2) {
                cv.cw(2330L).tV("decrypt failed:" + c0461a.cMy);
            } else {
                cv.cw(2320L).tV("unzip failed");
            }
            com.baidu.swan.apps.am.e.aLl().j(cv);
            return cv;
        } catch (IOException e) {
            if (DEBUG) {
                pz.bV("SwanExtractor", "obtainEncryptedBundle Exception: " + e.toString());
                e.printStackTrace();
            }
            com.baidu.swan.apps.am.a tV5 = new com.baidu.swan.apps.am.a().cv(11L).cw(2320L).tV("obtainEncryptedBundle Exception: " + e.toString());
            com.baidu.swan.apps.am.e.aLl().j(tV5);
            return tV5;
        }
    }

    private void fs(boolean z) {
        if (z) {
            bQ("670", "package_start_decrypt");
            bQ("770", "na_package_start_decrypt");
            return;
        }
        bQ("670", "package_start_unzip");
        bQ("770", "na_package_start_unzip");
    }

    private void ft(boolean z) {
        if (z) {
            bQ("670", "package_end_decrypt");
            bQ("770", "na_package_end_decrypt");
            return;
        }
        bQ("670", "package_end_unzip");
        bQ("770", "na_package_end_unzip");
    }

    private void bQ(String str, String str2) {
        if (this.cVx != null) {
            this.cVx.bq(str, str2);
        }
    }
}
