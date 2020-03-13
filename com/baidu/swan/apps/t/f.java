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
    private final com.baidu.swan.pms.model.e bxC;
    private final com.baidu.swan.pms.a.d bxv;

    public f(com.baidu.swan.pms.model.e eVar, com.baidu.swan.pms.a.d dVar) {
        super("extract");
        this.bxC = eVar;
        this.bxv = dVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.t.g.a
    public void TR() {
        super.TR();
        if (TT().getBoolean("result_output_dir_allow_rollback", false)) {
            com.baidu.swan.d.c.rg(TT().getString("result_output_dir"));
        }
    }

    @Override // com.baidu.swan.apps.t.g.a
    protected boolean a(Pipe.SourceChannel sourceChannel, Bundle bundle) {
        String string = bundle.getString("launch_id");
        com.baidu.swan.apps.x.c.a iM = com.baidu.swan.apps.x.c.a.iM(string);
        iM.Wj().iP("SwanExtractor").fm(1);
        boolean e = e(Channels.newInputStream(sourceChannel), string);
        iM.aT("SwanExtractor", "done: " + e);
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
        com.baidu.swan.apps.x.c.a.iM(str).aT("SwanExtractor", "onProcess installe error=" + a);
        TT().putLong("result_error_code", a.agk());
        return false;
    }

    private com.baidu.swan.apps.ap.a a(@NonNull BufferedInputStream bufferedInputStream, String str) {
        File aL;
        int i;
        boolean z;
        a.C0301a c0301a;
        com.baidu.swan.apps.x.c.a iM = com.baidu.swan.apps.x.c.a.iM(str);
        if (this.bxC == null) {
            com.baidu.swan.apps.ap.a mz = new com.baidu.swan.apps.ap.a().aI(11L).aJ(2320L).mz("pkg info is empty");
            com.baidu.swan.apps.ap.e.ago().f(mz);
            return mz;
        }
        if (this.bxC.category == 1) {
            aL = a.c.aL(this.bxC.cAZ, String.valueOf(this.bxC.versionCode));
        } else if (this.bxC.category == 0) {
            aL = e.d.aL(this.bxC.cAZ, String.valueOf(this.bxC.versionCode));
        } else {
            com.baidu.swan.apps.ap.a mz2 = new com.baidu.swan.apps.ap.a().aI(11L).aJ(2320L).mz("pkh category illegal");
            com.baidu.swan.apps.ap.e.ago().f(mz2);
            return mz2;
        }
        if (aL.isFile() && !aL.delete()) {
            if (DEBUG) {
                iM.aT("SwanExtractor", "解压失败：解压目录被文件占用，且无法删除");
            }
            com.baidu.swan.apps.ap.a mz3 = new com.baidu.swan.apps.ap.a().aI(11L).aJ(2320L).mz("解压失败：解压目录被文件占用，且无法删除");
            com.baidu.swan.apps.ap.e.ago().f(mz3);
            return mz3;
        }
        if (!aL.exists()) {
            TT().putBoolean("result_output_dir_allow_rollback", true);
            if (!aL.mkdirs()) {
                if (DEBUG) {
                    iM.aT("SwanExtractor", "解压失败：解压文件夹创建失败");
                }
                com.baidu.swan.apps.ap.a mz4 = new com.baidu.swan.apps.ap.a().aI(11L).aJ(2320L).mz("解压失败：解压文件夹创建失败");
                com.baidu.swan.apps.ap.e.ago().f(mz4);
                return mz4;
            }
        }
        if (DEBUG) {
            iM.aT("SwanExtractor", "开始执行解压操作, folder:" + aL.getPath());
        }
        TT().putString("result_output_dir", aL.toString());
        long currentTimeMillis = System.currentTimeMillis();
        try {
            a.b a = com.baidu.swan.apps.t.a.a.a(bufferedInputStream);
            boolean z2 = false;
            int i2 = a == null ? -1 : a.type;
            if (i2 != -1) {
                z2 = true;
            }
            cH(z2);
            if (z2) {
                a.C0301a a2 = com.baidu.swan.apps.t.a.a.a(bufferedInputStream, aL, i2);
                int i3 = i2;
                c0301a = a2;
                z = a2 != null && a2.isSuccess;
                i = i3;
            } else {
                boolean f = com.baidu.swan.d.f.f(bufferedInputStream, aL.getPath());
                i = 0;
                z = f;
                c0301a = null;
            }
            cI(z2);
            long currentTimeMillis2 = System.currentTimeMillis();
            if (DEBUG) {
                com.baidu.swan.apps.t.a.a.fe((int) (currentTimeMillis2 - currentTimeMillis));
            }
            if (this.bxv != null) {
                Bundle bundle = new Bundle();
                bundle.putInt("download_package_type_id", i);
                h.a(this.bxv, bundle, "event_download_package_type");
            }
            if (z) {
                return null;
            }
            com.baidu.swan.apps.ap.a aI = new com.baidu.swan.apps.ap.a().aI(11L);
            if (z2) {
                aI.aJ(2330L).mz("decrypt failed:" + c0301a.bqH);
            } else {
                aI.aJ(2320L).mz("unzip failed");
            }
            com.baidu.swan.apps.ap.e.ago().f(aI);
            return aI;
        } catch (IOException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            iM.aT("SwanExtractor", "obtainEncryptedBundle Exception: " + e.toString());
            com.baidu.swan.apps.ap.a mz5 = new com.baidu.swan.apps.ap.a().aI(11L).aJ(2320L).mz("obtainEncryptedBundle Exception: " + e.toString());
            com.baidu.swan.apps.ap.e.ago().f(mz5);
            return mz5;
        }
    }

    private void cH(boolean z) {
        if (z) {
            aP("670", "package_start_decrypt");
            aP("770", "na_package_start_decrypt");
            return;
        }
        aP("670", "package_start_unzip");
        aP("770", "na_package_start_unzip");
    }

    private void cI(boolean z) {
        if (z) {
            aP("670", "package_end_decrypt");
            aP("770", "na_package_end_decrypt");
            return;
        }
        aP("670", "package_end_unzip");
        aP("770", "na_package_end_unzip");
    }

    private void aP(String str, String str2) {
        if (this.bxv != null) {
            this.bxv.aw(str, str2);
        }
    }
}
