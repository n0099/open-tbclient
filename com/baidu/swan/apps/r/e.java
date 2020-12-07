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
/* loaded from: classes25.dex */
public class e extends f.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final com.baidu.swan.pms.model.e dcB;
    private final com.baidu.swan.pms.a.d dct;

    public e(com.baidu.swan.pms.model.e eVar, com.baidu.swan.pms.a.d dVar) {
        super("extract");
        this.dcB = eVar;
        this.dct = dVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.r.f.a
    public void ayV() {
        super.ayV();
        if (ayX().getBoolean("result_output_dir_allow_rollback", false)) {
            com.baidu.swan.c.d.zH(ayX().getString("result_output_dir"));
        }
    }

    @Override // com.baidu.swan.apps.r.f.a
    protected boolean a(Pipe.SourceChannel sourceChannel, Bundle bundle) {
        String string = bundle.getString("launch_id");
        com.baidu.swan.apps.u.e.a aVar = null;
        if (DEBUG) {
            aVar = com.baidu.swan.apps.u.e.a.qg(string);
            aVar.aBF().qj("SwanExtractor").jB(1);
        }
        boolean e = e(Channels.newInputStream(sourceChannel), string);
        if (aVar != null && DEBUG) {
            aVar.cc("SwanExtractor", "done: " + e);
        }
        return e;
    }

    private boolean e(InputStream inputStream, String str) {
        if (inputStream == null) {
            return false;
        }
        com.baidu.swan.apps.am.a a2 = a(new BufferedInputStream(inputStream), str);
        if (a2 == null) {
            return true;
        }
        if (DEBUG) {
            com.baidu.swan.apps.u.e.a.qg(str).cc("SwanExtractor", "onProcess installe error=" + a2);
        }
        ayX().putLong("result_error_code", a2.aOo());
        return false;
    }

    private com.baidu.swan.apps.am.a a(@NonNull BufferedInputStream bufferedInputStream, String str) {
        File bT;
        int i;
        boolean z;
        a.C0473a c0473a;
        com.baidu.swan.apps.u.e.a qg = com.baidu.swan.apps.u.e.a.qg(str);
        if (this.dcB == null) {
            com.baidu.swan.apps.am.a uC = new com.baidu.swan.apps.am.a().cU(11L).cV(2320L).uC("pkg info is empty");
            com.baidu.swan.apps.am.e.aOs().j(uC);
            return uC;
        }
        if (this.dcB.category == 1) {
            bT = a.c.bT(this.dcB.emZ, String.valueOf(this.dcB.versionCode));
        } else if (this.dcB.category == 0) {
            bT = d.C0474d.bT(this.dcB.emZ, String.valueOf(this.dcB.versionCode));
        } else {
            com.baidu.swan.apps.am.a uC2 = new com.baidu.swan.apps.am.a().cU(11L).cV(2320L).uC("pkh category illegal");
            com.baidu.swan.apps.am.e.aOs().j(uC2);
            return uC2;
        }
        if (bT.isFile() && !bT.delete()) {
            if (DEBUG) {
                qg.cc("SwanExtractor", "解压失败：解压目录被文件占用，且无法删除");
            }
            com.baidu.swan.apps.am.a uC3 = new com.baidu.swan.apps.am.a().cU(11L).cV(2320L).uC("解压失败：解压目录被文件占用，且无法删除");
            com.baidu.swan.apps.am.e.aOs().j(uC3);
            return uC3;
        }
        if (!bT.exists()) {
            ayX().putBoolean("result_output_dir_allow_rollback", true);
            if (!bT.mkdirs()) {
                if (DEBUG) {
                    qg.cc("SwanExtractor", "解压失败：解压文件夹创建失败");
                }
                com.baidu.swan.apps.am.a uC4 = new com.baidu.swan.apps.am.a().cU(11L).cV(2320L).uC("解压失败：解压文件夹创建失败");
                com.baidu.swan.apps.am.e.aOs().j(uC4);
                return uC4;
            }
        }
        if (DEBUG) {
            qg.cc("SwanExtractor", "开始执行解压操作, folder:" + bT.getPath());
        }
        ayX().putString("result_output_dir", bT.toString());
        long currentTimeMillis = System.currentTimeMillis();
        try {
            a.b a2 = com.baidu.swan.apps.r.a.a.a(bufferedInputStream);
            boolean z2 = false;
            int i2 = a2 == null ? -1 : a2.type;
            if (i2 != -1) {
                z2 = true;
            }
            fH(z2);
            if (z2) {
                a.C0473a a3 = com.baidu.swan.apps.r.a.a.a(bufferedInputStream, bT, i2);
                int i3 = i2;
                c0473a = a3;
                z = a3 != null && a3.isSuccess;
                i = i3;
            } else {
                boolean f = com.baidu.swan.c.f.f(bufferedInputStream, bT.getPath());
                i = 0;
                z = f;
                c0473a = null;
            }
            fI(z2);
            long currentTimeMillis2 = System.currentTimeMillis();
            if (DEBUG) {
                com.baidu.swan.apps.r.a.a.jt((int) (currentTimeMillis2 - currentTimeMillis));
            }
            if (this.dct != null) {
                Bundle bundle = new Bundle();
                bundle.putInt("download_package_type_id", i);
                h.a(this.dct, bundle, "event_download_package_type");
            }
            if (z) {
                return null;
            }
            com.baidu.swan.apps.am.a cU = new com.baidu.swan.apps.am.a().cU(11L);
            if (z2) {
                cU.cV(2330L).uC("decrypt failed:" + c0473a.cTr);
            } else {
                cU.cV(2320L).uC("unzip failed");
            }
            com.baidu.swan.apps.am.e.aOs().j(cU);
            return cU;
        } catch (IOException e) {
            if (DEBUG) {
                qg.cc("SwanExtractor", "obtainEncryptedBundle Exception: " + e.toString());
                e.printStackTrace();
            }
            com.baidu.swan.apps.am.a uC5 = new com.baidu.swan.apps.am.a().cU(11L).cV(2320L).uC("obtainEncryptedBundle Exception: " + e.toString());
            com.baidu.swan.apps.am.e.aOs().j(uC5);
            return uC5;
        }
    }

    private void fH(boolean z) {
        if (z) {
            bX("670", "package_start_decrypt");
            bX("770", "na_package_start_decrypt");
            return;
        }
        bX("670", "package_start_unzip");
        bX("770", "na_package_start_unzip");
    }

    private void fI(boolean z) {
        if (z) {
            bX("670", "package_end_decrypt");
            bX("770", "na_package_end_decrypt");
            return;
        }
        bX("670", "package_end_unzip");
        bX("770", "na_package_end_unzip");
    }

    private void bX(String str, String str2) {
        if (this.dct != null) {
            this.dct.bx(str, str2);
        }
    }
}
