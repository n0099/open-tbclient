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

    public static File xC() {
        return c.d.Cs();
    }

    public static File zK() {
        return a.c.Cs();
    }

    public static String zL() {
        return c.d.Cs().getPath();
    }

    public static String zM() {
        return c.d.Cs().getPath();
    }

    public static com.baidu.swan.apps.ak.a a(f fVar, com.baidu.swan.pms.a.b bVar) {
        if (fVar == null) {
            com.baidu.swan.apps.ak.a hx = new com.baidu.swan.apps.ak.a().L(11L).M(2300L).hx("pkg info is empty");
            e.LE().b(hx);
            return hx;
        }
        bVar.ac("670", "aiapp_aps_check_sign_start_timestamp");
        bVar.ac("770", "na_pms_start_check_sign");
        if (u.a(new File(fVar.filePath), fVar.sign, new com.baidu.swan.apps.an.a.c())) {
            bVar.ac("670", "aiapp_aps_check_sign_end_timestamp");
            bVar.ac("770", "na_pms_end_check_sign");
            return null;
        }
        com.baidu.swan.apps.ak.a hx2 = new com.baidu.swan.apps.ak.a().L(11L).M(2300L).hx("check zip file sign fail.");
        e.LE().b(hx2);
        return hx2;
    }

    public static com.baidu.swan.apps.ak.a b(f fVar) {
        String str;
        if (fVar == null) {
            com.baidu.swan.apps.ak.a hx = new com.baidu.swan.apps.ak.a().L(11L).M(2310L).hx("pkg info is empty");
            e.LE().b(hx);
            return hx;
        }
        if (fVar.category == 0) {
            str = xC() + File.separator + fVar.bma + ".aiapps";
        } else if (fVar.category == 1) {
            str = zK() + File.separator + fVar.bma + ".aigames";
        } else {
            com.baidu.swan.apps.ak.a hx2 = new com.baidu.swan.apps.ak.a().L(11L).M(2310L).hx("pkh category illegal");
            e.LE().b(hx2);
            return hx2;
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
        com.baidu.swan.apps.ak.a hx3 = new com.baidu.swan.apps.ak.a().L(11L).M(2310L).hx("rename zip fail");
        e.LE().b(hx3);
        return hx3;
    }

    public static com.baidu.swan.apps.ak.a b(f fVar, com.baidu.swan.pms.a.b bVar) {
        File file;
        File ah;
        boolean z;
        boolean z2;
        a.C0143a c0143a;
        if (fVar == null) {
            com.baidu.swan.apps.ak.a hx = new com.baidu.swan.apps.ak.a().L(11L).M(2320L).hx("pkg info is empty");
            e.LE().b(hx);
            return hx;
        }
        if (fVar.category == 1) {
            file = new File(zK(), fVar.bma + ".aigames");
            ah = a.c.ah(fVar.bma, String.valueOf(fVar.versionCode));
        } else if (fVar.category == 0) {
            file = new File(xC(), fVar.bma + ".aiapps");
            ah = c.d.ah(fVar.bma, String.valueOf(fVar.versionCode));
        } else {
            com.baidu.swan.apps.ak.a hx2 = new com.baidu.swan.apps.ak.a().L(11L).M(2320L).hx("pkh category illegal");
            e.LE().b(hx2);
            return hx2;
        }
        if (!file.exists()) {
            com.baidu.swan.apps.ak.a hx3 = new com.baidu.swan.apps.ak.a().L(11L).M(2320L).hx("解压失败：包不存在");
            e.LE().b(hx3);
            return hx3;
        } else if (ah.exists()) {
            if (DEBUG) {
                Log.e("PkgDownloadUtil", "解压失败：解压文件夹已存在");
            }
            return null;
        } else if (!ah.mkdirs()) {
            if (DEBUG) {
                Log.e("PkgDownloadUtil", "解压失败：解压文件夹创建失败");
            }
            com.baidu.swan.apps.ak.a hx4 = new com.baidu.swan.apps.ak.a().L(11L).M(2320L).hx("解压失败：解压文件夹创建失败");
            e.LE().b(hx4);
            return hx4;
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
                com.baidu.swan.apps.install.a.a.cz((int) (currentTimeMillis2 - currentTimeMillis));
            }
            if (z2) {
                return null;
            }
            com.baidu.swan.apps.ak.a aVar = new com.baidu.swan.apps.ak.a();
            if (z) {
                aVar.L(11L).M(2320L).hx("unzip failed");
            } else {
                aVar.L(11L).M(2330L).hx("decrypt failed:" + (c0143a == null ? "" : c0143a.axg));
            }
            e.LE().b(aVar);
            return aVar;
        }
    }
}
