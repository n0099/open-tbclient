package com.baidu.swan.apps.r;

import android.os.Bundle;
import androidx.annotation.NonNull;
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
/* loaded from: classes9.dex */
public class e extends f.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final com.baidu.swan.pms.a.d dhn;
    private final com.baidu.swan.pms.model.e dhu;

    public e(com.baidu.swan.pms.model.e eVar, com.baidu.swan.pms.a.d dVar) {
        super("extract");
        this.dhu = eVar;
        this.dhn = dVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.r.f.a
    public void aAn() {
        super.aAn();
        if (aAp().getBoolean("result_output_dir_allow_rollback", false)) {
            com.baidu.swan.c.d.zG(aAp().getString("result_output_dir"));
        }
    }

    @Override // com.baidu.swan.apps.r.f.a
    protected boolean a(Pipe.SourceChannel sourceChannel, Bundle bundle) {
        String string = bundle.getString("launch_id");
        com.baidu.swan.apps.u.e.a aVar = null;
        if (DEBUG) {
            aVar = com.baidu.swan.apps.u.e.a.pZ(string);
            aVar.aCX().qc("SwanExtractor").jw(1);
        }
        boolean h = h(Channels.newInputStream(sourceChannel), string);
        if (aVar != null && DEBUG) {
            aVar.cb("SwanExtractor", "done: " + h);
        }
        return h;
    }

    private boolean h(InputStream inputStream, String str) {
        if (inputStream == null) {
            return false;
        }
        com.baidu.swan.apps.al.a a2 = a(new BufferedInputStream(inputStream), str);
        if (a2 == null) {
            return true;
        }
        if (DEBUG) {
            com.baidu.swan.apps.u.e.a.pZ(str).cb("SwanExtractor", "onProcess installe error=" + a2);
        }
        aAp().putLong("result_error_code", a2.aQG());
        return false;
    }

    private com.baidu.swan.apps.al.a a(@NonNull BufferedInputStream bufferedInputStream, String str) {
        File bS;
        boolean i;
        com.baidu.swan.apps.u.e.a pZ = com.baidu.swan.apps.u.e.a.pZ(str);
        if (this.dhu == null) {
            com.baidu.swan.apps.al.a uz = new com.baidu.swan.apps.al.a().cV(11L).cW(2320L).uz("pkg info is empty");
            com.baidu.swan.apps.al.e.aQK().j(uz);
            return uz;
        }
        if (this.dhu.category == 1) {
            bS = a.c.bS(this.dhu.ewI, String.valueOf(this.dhu.versionCode));
        } else if (this.dhu.category == 0) {
            bS = d.C0466d.bS(this.dhu.ewI, String.valueOf(this.dhu.versionCode));
        } else {
            com.baidu.swan.apps.al.a uz2 = new com.baidu.swan.apps.al.a().cV(11L).cW(2320L).uz("pkh category illegal");
            com.baidu.swan.apps.al.e.aQK().j(uz2);
            return uz2;
        }
        if (bS.isFile() && !bS.delete()) {
            if (DEBUG) {
                pZ.cb("SwanExtractor", "解压失败：解压目录被文件占用，且无法删除");
            }
            com.baidu.swan.apps.al.a uz3 = new com.baidu.swan.apps.al.a().cV(11L).cW(2320L).uz("解压失败：解压目录被文件占用，且无法删除");
            com.baidu.swan.apps.al.e.aQK().j(uz3);
            return uz3;
        }
        if (!bS.exists()) {
            aAp().putBoolean("result_output_dir_allow_rollback", true);
            if (!bS.mkdirs()) {
                if (DEBUG) {
                    pZ.cb("SwanExtractor", "解压失败：解压文件夹创建失败");
                }
                com.baidu.swan.apps.al.a uz4 = new com.baidu.swan.apps.al.a().cV(11L).cW(2320L).uz("解压失败：解压文件夹创建失败");
                com.baidu.swan.apps.al.e.aQK().j(uz4);
                return uz4;
            }
        }
        if (DEBUG) {
            pZ.cb("SwanExtractor", "开始执行解压操作, folder:" + bS.getPath());
        }
        aAp().putString("result_output_dir", bS.toString());
        a.C0465a c0465a = null;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            a.b a2 = com.baidu.swan.apps.r.a.a.a(bufferedInputStream);
            boolean z = false;
            int i2 = a2 == null ? -1 : a2.type;
            if (i2 != -1) {
                z = true;
            }
            fQ(z);
            if (z) {
                c0465a = com.baidu.swan.apps.r.a.a.a(bufferedInputStream, bS, i2);
                i = c0465a != null && c0465a.isSuccess;
            } else {
                i = com.baidu.swan.c.f.i(bufferedInputStream, bS.getPath());
                i2 = 0;
            }
            fR(z);
            long currentTimeMillis2 = System.currentTimeMillis();
            if (DEBUG) {
                com.baidu.swan.apps.r.a.a.jo((int) (currentTimeMillis2 - currentTimeMillis));
            }
            if (this.dhn != null) {
                Bundle bundle = new Bundle();
                bundle.putInt("download_package_type_id", i2);
                h.a(this.dhn, bundle, "event_download_package_type");
            }
            if (i) {
                return null;
            }
            com.baidu.swan.apps.al.a cV = new com.baidu.swan.apps.al.a().cV(11L);
            if (z) {
                cV.cW(2330L).uz("decrypt failed:" + c0465a.cYo);
            } else {
                cV.cW(2320L).uz("unzip failed");
            }
            com.baidu.swan.apps.al.e.aQK().j(cV);
            return cV;
        } catch (IOException e) {
            if (DEBUG) {
                pZ.cb("SwanExtractor", "obtainEncryptedBundle Exception: " + e.toString());
                e.printStackTrace();
            }
            com.baidu.swan.apps.al.a uz5 = new com.baidu.swan.apps.al.a().cV(11L).cW(2320L).uz("obtainEncryptedBundle Exception: " + e.toString());
            com.baidu.swan.apps.al.e.aQK().j(uz5);
            return uz5;
        }
    }

    private void fQ(boolean z) {
        if (z) {
            bW("670", "package_start_decrypt");
            bW("770", "na_package_start_decrypt");
            return;
        }
        bW("670", "package_start_unzip");
        bW("770", "na_package_start_unzip");
    }

    private void fR(boolean z) {
        if (z) {
            bW("670", "package_end_decrypt");
            bW("770", "na_package_end_decrypt");
            return;
        }
        bW("670", "package_end_unzip");
        bW("770", "na_package_end_unzip");
    }

    private void bW(String str, String str2) {
        if (this.dhn != null) {
            this.dhn.bw(str, str2);
        }
    }
}
