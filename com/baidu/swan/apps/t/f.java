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
/* loaded from: classes9.dex */
public class f extends g.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final com.baidu.swan.pms.model.e bsC;
    private final com.baidu.swan.pms.a.d bsv;

    public f(com.baidu.swan.pms.model.e eVar, com.baidu.swan.pms.a.d dVar) {
        super("extract");
        this.bsC = eVar;
        this.bsv = dVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.t.g.a
    public void Rf() {
        super.Rf();
        if (Rh().getBoolean("result_output_dir_allow_rollback", false)) {
            com.baidu.swan.d.c.qO(Rh().getString("result_output_dir"));
        }
    }

    @Override // com.baidu.swan.apps.t.g.a
    protected boolean a(Pipe.SourceChannel sourceChannel, Bundle bundle) {
        String string = bundle.getString("launch_id");
        com.baidu.swan.apps.x.c.a iu = com.baidu.swan.apps.x.c.a.iu(string);
        iu.Tw().ix("SwanExtractor").eV(1);
        boolean e = e(Channels.newInputStream(sourceChannel), string);
        iu.aI("SwanExtractor", "done: " + e);
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
        com.baidu.swan.apps.x.c.a.iu(str).aI("SwanExtractor", "onProcess installe error=" + a);
        Rh().putLong("result_error_code", a.adB());
        return false;
    }

    private com.baidu.swan.apps.ap.a a(@NonNull BufferedInputStream bufferedInputStream, String str) {
        File aA;
        int i;
        boolean z;
        a.C0289a c0289a;
        com.baidu.swan.apps.x.c.a iu = com.baidu.swan.apps.x.c.a.iu(str);
        if (this.bsC == null) {
            com.baidu.swan.apps.ap.a mh = new com.baidu.swan.apps.ap.a().aB(11L).aC(2320L).mh("pkg info is empty");
            com.baidu.swan.apps.ap.e.adF().f(mh);
            return mh;
        }
        if (this.bsC.category == 1) {
            aA = a.c.aA(this.bsC.cwO, String.valueOf(this.bsC.versionCode));
        } else if (this.bsC.category == 0) {
            aA = e.d.aA(this.bsC.cwO, String.valueOf(this.bsC.versionCode));
        } else {
            com.baidu.swan.apps.ap.a mh2 = new com.baidu.swan.apps.ap.a().aB(11L).aC(2320L).mh("pkh category illegal");
            com.baidu.swan.apps.ap.e.adF().f(mh2);
            return mh2;
        }
        if (aA.isFile() && !aA.delete()) {
            if (DEBUG) {
                iu.aI("SwanExtractor", "解压失败：解压目录被文件占用，且无法删除");
            }
            com.baidu.swan.apps.ap.a mh3 = new com.baidu.swan.apps.ap.a().aB(11L).aC(2320L).mh("解压失败：解压目录被文件占用，且无法删除");
            com.baidu.swan.apps.ap.e.adF().f(mh3);
            return mh3;
        }
        if (!aA.exists()) {
            Rh().putBoolean("result_output_dir_allow_rollback", true);
            if (!aA.mkdirs()) {
                if (DEBUG) {
                    iu.aI("SwanExtractor", "解压失败：解压文件夹创建失败");
                }
                com.baidu.swan.apps.ap.a mh4 = new com.baidu.swan.apps.ap.a().aB(11L).aC(2320L).mh("解压失败：解压文件夹创建失败");
                com.baidu.swan.apps.ap.e.adF().f(mh4);
                return mh4;
            }
        }
        if (DEBUG) {
            iu.aI("SwanExtractor", "开始执行解压操作, folder:" + aA.getPath());
        }
        Rh().putString("result_output_dir", aA.toString());
        long currentTimeMillis = System.currentTimeMillis();
        try {
            a.b a = com.baidu.swan.apps.t.a.a.a(bufferedInputStream);
            boolean z2 = false;
            int i2 = a == null ? -1 : a.type;
            if (i2 != -1) {
                z2 = true;
            }
            cv(z2);
            if (z2) {
                a.C0289a a2 = com.baidu.swan.apps.t.a.a.a(bufferedInputStream, aA, i2);
                int i3 = i2;
                c0289a = a2;
                z = a2 != null && a2.isSuccess;
                i = i3;
            } else {
                boolean f = com.baidu.swan.d.f.f(bufferedInputStream, aA.getPath());
                i = 0;
                z = f;
                c0289a = null;
            }
            cw(z2);
            long currentTimeMillis2 = System.currentTimeMillis();
            if (DEBUG) {
                com.baidu.swan.apps.t.a.a.eN((int) (currentTimeMillis2 - currentTimeMillis));
            }
            if (this.bsv != null) {
                Bundle bundle = new Bundle();
                bundle.putInt("download_package_type_id", i);
                h.a(this.bsv, bundle, "event_download_package_type");
            }
            if (z) {
                return null;
            }
            com.baidu.swan.apps.ap.a aB = new com.baidu.swan.apps.ap.a().aB(11L);
            if (z2) {
                aB.aC(2330L).mh("decrypt failed:" + c0289a.blG);
            } else {
                aB.aC(2320L).mh("unzip failed");
            }
            com.baidu.swan.apps.ap.e.adF().f(aB);
            return aB;
        } catch (IOException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            iu.aI("SwanExtractor", "obtainEncryptedBundle Exception: " + e.toString());
            com.baidu.swan.apps.ap.a mh5 = new com.baidu.swan.apps.ap.a().aB(11L).aC(2320L).mh("obtainEncryptedBundle Exception: " + e.toString());
            com.baidu.swan.apps.ap.e.adF().f(mh5);
            return mh5;
        }
    }

    private void cv(boolean z) {
        if (z) {
            aE("670", "package_start_decrypt");
            aE("770", "na_package_start_decrypt");
            return;
        }
        aE("670", "package_start_unzip");
        aE("770", "na_package_start_unzip");
    }

    private void cw(boolean z) {
        if (z) {
            aE("670", "package_end_decrypt");
            aE("770", "na_package_end_decrypt");
            return;
        }
        aE("670", "package_end_unzip");
        aE("770", "na_package_end_unzip");
    }

    private void aE(String str, String str2) {
        if (this.bsv != null) {
            this.bsv.al(str, str2);
        }
    }
}
