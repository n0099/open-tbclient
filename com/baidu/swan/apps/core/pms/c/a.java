package com.baidu.swan.apps.core.pms.c;

import android.util.Log;
import com.baidu.swan.apps.ak.e;
import com.baidu.swan.apps.an.u;
import com.baidu.swan.apps.install.a.a;
import com.baidu.swan.apps.install.c;
import com.baidu.swan.games.i.a;
import com.baidu.swan.pms.model.f;
import java.io.BufferedInputStream;
import java.io.File;
/* loaded from: classes2.dex */
public final class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static File xD() {
        return c.d.Cu();
    }

    public static File zL() {
        return a.c.Cu();
    }

    public static String zM() {
        return c.d.Cu().getPath();
    }

    public static String zN() {
        return c.d.Cu().getPath();
    }

    public static com.baidu.swan.apps.ak.a a(f fVar, com.baidu.swan.pms.a.b bVar) {
        if (fVar == null) {
            com.baidu.swan.apps.ak.a hw = new com.baidu.swan.apps.ak.a().L(11L).M(2300L).hw("pkg info is empty");
            e.LG().b(hw);
            return hw;
        }
        bVar.ac("670", "aiapp_aps_check_sign_start_timestamp");
        bVar.ac("770", "na_pms_start_check_sign");
        if (u.a(new File(fVar.filePath), fVar.sign, new com.baidu.swan.apps.an.a.c())) {
            bVar.ac("670", "aiapp_aps_check_sign_end_timestamp");
            bVar.ac("770", "na_pms_end_check_sign");
            return null;
        }
        com.baidu.swan.apps.ak.a hw2 = new com.baidu.swan.apps.ak.a().L(11L).M(2300L).hw("check zip file sign fail.");
        e.LG().b(hw2);
        return hw2;
    }

    public static com.baidu.swan.apps.ak.a b(f fVar) {
        String str;
        if (fVar == null) {
            com.baidu.swan.apps.ak.a hw = new com.baidu.swan.apps.ak.a().L(11L).M(2310L).hw("pkg info is empty");
            e.LG().b(hw);
            return hw;
        }
        if (fVar.category == 0) {
            str = xD() + File.separator + fVar.blW + ".aiapps";
        } else if (fVar.category == 1) {
            str = zL() + File.separator + fVar.blW + ".aigames";
        } else {
            com.baidu.swan.apps.ak.a hw2 = new com.baidu.swan.apps.ak.a().L(11L).M(2310L).hw("pkh category illegal");
            e.LG().b(hw2);
            return hw2;
        }
        com.baidu.swan.c.b.deleteFile(str);
        File file = new File(str);
        File file2 = new File(fVar.filePath);
        if (file2.renameTo(file)) {
            if (DEBUG) {
                Log.i("PkgDownloadUtil", "重命名成功");
            }
            return null;
        }
        com.baidu.swan.c.b.deleteFile(file2);
        com.baidu.swan.apps.ak.a hw3 = new com.baidu.swan.apps.ak.a().L(11L).M(2310L).hw("rename zip fail");
        e.LG().b(hw3);
        return hw3;
    }

    public static com.baidu.swan.apps.ak.a b(f fVar, com.baidu.swan.pms.a.b bVar) {
        File file;
        File ah;
        boolean z;
        boolean z2;
        a.C0143a c0143a;
        if (fVar == null) {
            com.baidu.swan.apps.ak.a hw = new com.baidu.swan.apps.ak.a().L(11L).M(2320L).hw("pkg info is empty");
            e.LG().b(hw);
            return hw;
        }
        if (fVar.category == 1) {
            file = new File(zL(), fVar.blW + ".aigames");
            ah = a.c.ah(fVar.blW, String.valueOf(fVar.versionCode));
        } else if (fVar.category == 0) {
            file = new File(xD(), fVar.blW + ".aiapps");
            ah = c.d.ah(fVar.blW, String.valueOf(fVar.versionCode));
        } else {
            com.baidu.swan.apps.ak.a hw2 = new com.baidu.swan.apps.ak.a().L(11L).M(2320L).hw("pkh category illegal");
            e.LG().b(hw2);
            return hw2;
        }
        if (!file.exists()) {
            com.baidu.swan.apps.ak.a hw3 = new com.baidu.swan.apps.ak.a().L(11L).M(2320L).hw("解压失败：包不存在");
            e.LG().b(hw3);
            return hw3;
        } else if (ah.exists()) {
            if (DEBUG) {
                Log.e("PkgDownloadUtil", "解压失败：解压文件夹已存在");
            }
            return null;
        } else if (!ah.mkdirs()) {
            if (DEBUG) {
                Log.e("PkgDownloadUtil", "解压失败：解压文件夹创建失败");
            }
            com.baidu.swan.apps.ak.a hw4 = new com.baidu.swan.apps.ak.a().L(11L).M(2320L).hw("解压失败：解压文件夹创建失败");
            e.LG().b(hw4);
            return hw4;
        } else {
            if (DEBUG) {
                Log.i("PkgDownloadUtil", "开始执行解压操作, bundle:" + file.getPath() + " , folder:" + ah.getPath());
            }
            long currentTimeMillis = System.currentTimeMillis();
            BufferedInputStream x = com.baidu.swan.apps.install.a.a.x(file);
            if (x != null) {
                bVar.ac("670", "aiapp_aps_decrypt_start_timestamp");
                bVar.ac("770", "na_package_start_decrypt");
                c0143a = com.baidu.swan.apps.install.a.a.a(file, ah, x);
                bVar.ac("670", "aiapp_aps_decrypt_end_timestamp");
                bVar.ac("770", "na_package_end_decrypt");
                z2 = c0143a.isSuccess;
                z = false;
            } else {
                bVar.ac("670", "aiapp_aps_unzip_start_timestamp");
                bVar.ac("770", "na_package_start_unzip");
                boolean bl = com.baidu.swan.c.b.bl(file.getPath(), ah.getPath());
                bVar.ac("670", "aiapp_aps_unzip_end_timestamp");
                bVar.ac("770", "na_package_end_unzip");
                z = true;
                z2 = bl;
                c0143a = null;
            }
            long currentTimeMillis2 = System.currentTimeMillis();
            if (DEBUG) {
                com.baidu.swan.apps.install.a.a.cA((int) (currentTimeMillis2 - currentTimeMillis));
            }
            if (z2) {
                return null;
            }
            com.baidu.swan.apps.ak.a aVar = new com.baidu.swan.apps.ak.a();
            if (z) {
                aVar.L(11L).M(2320L).hw("unzip failed");
            } else {
                aVar.L(11L).M(2330L).hw("decrypt failed:" + (c0143a == null ? "" : c0143a.axc));
            }
            e.LG().b(aVar);
            return aVar;
        }
    }
}
