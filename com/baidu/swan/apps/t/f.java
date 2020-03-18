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
    private final com.baidu.swan.pms.a.d bxG;
    private final com.baidu.swan.pms.model.e bxN;

    public f(com.baidu.swan.pms.model.e eVar, com.baidu.swan.pms.a.d dVar) {
        super("extract");
        this.bxN = eVar;
        this.bxG = dVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.t.g.a
    public void TU() {
        super.TU();
        if (TW().getBoolean("result_output_dir_allow_rollback", false)) {
            com.baidu.swan.d.c.rf(TW().getString("result_output_dir"));
        }
    }

    @Override // com.baidu.swan.apps.t.g.a
    protected boolean a(Pipe.SourceChannel sourceChannel, Bundle bundle) {
        String string = bundle.getString("launch_id");
        com.baidu.swan.apps.x.c.a iL = com.baidu.swan.apps.x.c.a.iL(string);
        iL.Wm().iO("SwanExtractor").fm(1);
        boolean e = e(Channels.newInputStream(sourceChannel), string);
        iL.aS("SwanExtractor", "done: " + e);
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
        com.baidu.swan.apps.x.c.a.iL(str).aS("SwanExtractor", "onProcess installe error=" + a);
        TW().putLong("result_error_code", a.agn());
        return false;
    }

    private com.baidu.swan.apps.ap.a a(@NonNull BufferedInputStream bufferedInputStream, String str) {
        File aK;
        int i;
        boolean z;
        a.C0301a c0301a;
        com.baidu.swan.apps.x.c.a iL = com.baidu.swan.apps.x.c.a.iL(str);
        if (this.bxN == null) {
            com.baidu.swan.apps.ap.a my = new com.baidu.swan.apps.ap.a().aI(11L).aJ(2320L).my("pkg info is empty");
            com.baidu.swan.apps.ap.e.agr().f(my);
            return my;
        }
        if (this.bxN.category == 1) {
            aK = a.c.aK(this.bxN.cBk, String.valueOf(this.bxN.versionCode));
        } else if (this.bxN.category == 0) {
            aK = e.d.aK(this.bxN.cBk, String.valueOf(this.bxN.versionCode));
        } else {
            com.baidu.swan.apps.ap.a my2 = new com.baidu.swan.apps.ap.a().aI(11L).aJ(2320L).my("pkh category illegal");
            com.baidu.swan.apps.ap.e.agr().f(my2);
            return my2;
        }
        if (aK.isFile() && !aK.delete()) {
            if (DEBUG) {
                iL.aS("SwanExtractor", "解压失败：解压目录被文件占用，且无法删除");
            }
            com.baidu.swan.apps.ap.a my3 = new com.baidu.swan.apps.ap.a().aI(11L).aJ(2320L).my("解压失败：解压目录被文件占用，且无法删除");
            com.baidu.swan.apps.ap.e.agr().f(my3);
            return my3;
        }
        if (!aK.exists()) {
            TW().putBoolean("result_output_dir_allow_rollback", true);
            if (!aK.mkdirs()) {
                if (DEBUG) {
                    iL.aS("SwanExtractor", "解压失败：解压文件夹创建失败");
                }
                com.baidu.swan.apps.ap.a my4 = new com.baidu.swan.apps.ap.a().aI(11L).aJ(2320L).my("解压失败：解压文件夹创建失败");
                com.baidu.swan.apps.ap.e.agr().f(my4);
                return my4;
            }
        }
        if (DEBUG) {
            iL.aS("SwanExtractor", "开始执行解压操作, folder:" + aK.getPath());
        }
        TW().putString("result_output_dir", aK.toString());
        long currentTimeMillis = System.currentTimeMillis();
        try {
            a.b a = com.baidu.swan.apps.t.a.a.a(bufferedInputStream);
            boolean z2 = false;
            int i2 = a == null ? -1 : a.type;
            if (i2 != -1) {
                z2 = true;
            }
            cI(z2);
            if (z2) {
                a.C0301a a2 = com.baidu.swan.apps.t.a.a.a(bufferedInputStream, aK, i2);
                int i3 = i2;
                c0301a = a2;
                z = a2 != null && a2.isSuccess;
                i = i3;
            } else {
                boolean f = com.baidu.swan.d.f.f(bufferedInputStream, aK.getPath());
                i = 0;
                z = f;
                c0301a = null;
            }
            cJ(z2);
            long currentTimeMillis2 = System.currentTimeMillis();
            if (DEBUG) {
                com.baidu.swan.apps.t.a.a.fe((int) (currentTimeMillis2 - currentTimeMillis));
            }
            if (this.bxG != null) {
                Bundle bundle = new Bundle();
                bundle.putInt("download_package_type_id", i);
                h.a(this.bxG, bundle, "event_download_package_type");
            }
            if (z) {
                return null;
            }
            com.baidu.swan.apps.ap.a aI = new com.baidu.swan.apps.ap.a().aI(11L);
            if (z2) {
                aI.aJ(2330L).my("decrypt failed:" + c0301a.bqT);
            } else {
                aI.aJ(2320L).my("unzip failed");
            }
            com.baidu.swan.apps.ap.e.agr().f(aI);
            return aI;
        } catch (IOException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            iL.aS("SwanExtractor", "obtainEncryptedBundle Exception: " + e.toString());
            com.baidu.swan.apps.ap.a my5 = new com.baidu.swan.apps.ap.a().aI(11L).aJ(2320L).my("obtainEncryptedBundle Exception: " + e.toString());
            com.baidu.swan.apps.ap.e.agr().f(my5);
            return my5;
        }
    }

    private void cI(boolean z) {
        if (z) {
            aO("670", "package_start_decrypt");
            aO("770", "na_package_start_decrypt");
            return;
        }
        aO("670", "package_start_unzip");
        aO("770", "na_package_start_unzip");
    }

    private void cJ(boolean z) {
        if (z) {
            aO("670", "package_end_decrypt");
            aO("770", "na_package_end_decrypt");
            return;
        }
        aO("670", "package_end_unzip");
        aO("770", "na_package_end_unzip");
    }

    private void aO(String str, String str2) {
        if (this.bxG != null) {
            this.bxG.av(str, str2);
        }
    }
}
