package com.baidu.swan.apps.core.pms.c;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.an.w;
import com.baidu.swan.apps.install.a.a;
import com.baidu.swan.apps.install.e;
import com.baidu.swan.games.i.a;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
/* loaded from: classes2.dex */
public final class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    /* renamed from: com.baidu.swan.apps.core.pms.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0140a {
        public int asO = 0;
        public boolean asP = false;
        public String asQ = "";
    }

    public static File yu() {
        return e.d.Du();
    }

    public static File AS() {
        return a.d.Du();
    }

    public static String AT() {
        return e.d.Du().getPath();
    }

    public static String AR() {
        return e.d.Du().getPath();
    }

    public static String AU() {
        return a.d.Du().getPath();
    }

    public static String AV() {
        return null;
    }

    public static com.baidu.swan.games.p.a.a u(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return com.baidu.swan.games.p.a.a.jI(com.baidu.swan.c.a.v(new File(a.d.ae(str, String.valueOf(i)), "game.json")));
    }

    public static com.baidu.swan.apps.ak.a a(com.baidu.swan.pms.model.e eVar, com.baidu.swan.pms.a.b bVar) {
        if (eVar == null || TextUtils.isEmpty(eVar.filePath)) {
            com.baidu.swan.apps.ak.a hY = new com.baidu.swan.apps.ak.a().Y(11L).Z(2300L).hY("pkg info is empty");
            com.baidu.swan.apps.ak.e.Ok().b(hY);
            return hY;
        }
        ReadableByteChannel readableByteChannel = null;
        try {
            readableByteChannel = Channels.newChannel(new FileInputStream(new File(eVar.filePath)));
            return a(readableByteChannel, eVar.sign, bVar);
        } catch (IOException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            com.baidu.swan.apps.ak.a hY2 = new com.baidu.swan.apps.ak.a().Y(11L).Z(2300L).hY("cannot found filePath: " + eVar.filePath);
            com.baidu.swan.apps.ak.e.Ok().b(hY2);
            return hY2;
        } finally {
            com.baidu.swan.c.a.c(readableByteChannel);
        }
    }

    public static com.baidu.swan.apps.ak.a a(ReadableByteChannel readableByteChannel, String str, com.baidu.swan.pms.a.b bVar) throws IOException {
        if (readableByteChannel == null) {
            com.baidu.swan.apps.ak.a hY = new com.baidu.swan.apps.ak.a().Y(11L).Z(2300L).hY("empty source");
            com.baidu.swan.apps.ak.e.Ok().b(hY);
            if (DEBUG) {
                Log.i("PkgDownloadUtil", "checkPkgZipSign err: " + hY);
                return hY;
            }
            return hY;
        }
        bVar.X("670", "aiapp_aps_check_sign_start_timestamp");
        bVar.X("770", "na_pms_start_check_sign");
        if (w.a(readableByteChannel, str, new com.baidu.swan.apps.an.a.c())) {
            bVar.X("670", "aiapp_aps_check_sign_end_timestamp");
            bVar.X("770", "na_pms_end_check_sign");
            return null;
        }
        com.baidu.swan.apps.ak.a hY2 = new com.baidu.swan.apps.ak.a().Y(11L).Z(2300L).hY("check zip file sign fail.");
        com.baidu.swan.apps.ak.e.Ok().b(hY2);
        if (DEBUG) {
            Log.i("PkgDownloadUtil", "checkPkgZipSign err: " + hY2);
            return hY2;
        }
        return hY2;
    }

    public static com.baidu.swan.apps.ak.a b(com.baidu.swan.pms.model.e eVar) {
        String str;
        if (eVar == null) {
            com.baidu.swan.apps.ak.a hY = new com.baidu.swan.apps.ak.a().Y(11L).Z(2310L).hY("pkg info is empty");
            com.baidu.swan.apps.ak.e.Ok().b(hY);
            return hY;
        }
        if (eVar.category == 0) {
            str = yu() + File.separator + eVar.bsc + ".aiapps";
        } else if (eVar.category == 1) {
            str = AS() + File.separator + eVar.bsc + ".aigames";
        } else {
            com.baidu.swan.apps.ak.a hY2 = new com.baidu.swan.apps.ak.a().Y(11L).Z(2310L).hY("pkh category illegal");
            com.baidu.swan.apps.ak.e.Ok().b(hY2);
            return hY2;
        }
        com.baidu.swan.c.a.deleteFile(str);
        File file = new File(str);
        File file2 = new File(eVar.filePath);
        if (file2.renameTo(file)) {
            if (DEBUG) {
                Log.i("PkgDownloadUtil", "重命名成功,from:" + file2.getPath() + " to:" + file.getPath());
            }
            return null;
        }
        com.baidu.swan.c.a.deleteFile(file2);
        com.baidu.swan.apps.ak.a hY3 = new com.baidu.swan.apps.ak.a().Y(11L).Z(2310L).hY("rename zip fail");
        com.baidu.swan.apps.ak.e.Ok().b(hY3);
        return hY3;
    }

    public static com.baidu.swan.apps.ak.a b(com.baidu.swan.pms.model.e eVar, com.baidu.swan.pms.a.b bVar) {
        File file;
        File ae;
        if (eVar == null) {
            com.baidu.swan.apps.ak.a hY = new com.baidu.swan.apps.ak.a().Y(11L).Z(2320L).hY("pkg info is empty");
            com.baidu.swan.apps.ak.e.Ok().b(hY);
            return hY;
        }
        if (eVar.category == 1) {
            file = new File(AS(), eVar.bsc + ".aigames");
            ae = a.d.ae(eVar.bsc, String.valueOf(eVar.versionCode));
        } else if (eVar.category == 0) {
            file = new File(yu(), eVar.bsc + ".aiapps");
            ae = e.d.ae(eVar.bsc, String.valueOf(eVar.versionCode));
        } else {
            com.baidu.swan.apps.ak.a hY2 = new com.baidu.swan.apps.ak.a().Y(11L).Z(2320L).hY("pkh category illegal");
            com.baidu.swan.apps.ak.e.Ok().b(hY2);
            return hY2;
        }
        if (!file.exists()) {
            com.baidu.swan.apps.ak.a hY3 = new com.baidu.swan.apps.ak.a().Y(11L).Z(2320L).hY("解压失败：包不存在");
            com.baidu.swan.apps.ak.e.Ok().b(hY3);
            return hY3;
        } else if (ae.isFile() && !ae.delete()) {
            if (DEBUG) {
                Log.e("PkgDownloadUtil", "解压失败：解压目录被文件占用，且无法删除");
            }
            com.baidu.swan.apps.ak.a hY4 = new com.baidu.swan.apps.ak.a().Y(11L).Z(2320L).hY("解压失败：解压目录被文件占用，且无法删除");
            com.baidu.swan.apps.ak.e.Ok().b(hY4);
            return hY4;
        } else if (!ae.exists() && !ae.mkdirs()) {
            if (DEBUG) {
                Log.e("PkgDownloadUtil", "解压失败：解压文件夹创建失败");
            }
            com.baidu.swan.apps.ak.a hY5 = new com.baidu.swan.apps.ak.a().Y(11L).Z(2320L).hY("解压失败：解压文件夹创建失败");
            com.baidu.swan.apps.ak.e.Ok().b(hY5);
            return hY5;
        } else {
            if (DEBUG) {
                Log.i("PkgDownloadUtil", "开始执行解压操作, bundle:" + file.getPath() + " , folder:" + ae.getPath());
            }
            if (a(file, ae, bVar).asP) {
                return null;
            }
            C0140a a = a(file, ae, bVar);
            if (a.asP) {
                com.baidu.swan.apps.statistic.c.a(bVar, eVar.category, true);
                return null;
            }
            com.baidu.swan.apps.statistic.c.a(bVar, eVar.category, false);
            com.baidu.swan.c.a.safeDeleteFile(ae);
            com.baidu.swan.pms.database.a.Vl().d(eVar);
            com.baidu.swan.apps.ak.a aVar = new com.baidu.swan.apps.ak.a();
            switch (a.asO) {
                case 0:
                    aVar.Y(11L).Z(2320L).hY("unzip failed");
                    break;
                case 1:
                    aVar.Y(11L).Z(2330L).hY("decryt failed:" + a.asQ);
                    break;
                default:
                    aVar.Y(4L).Z(7L).hY("Unkown bundle type");
                    break;
            }
            com.baidu.swan.apps.ak.e.Ok().b(aVar);
            return aVar;
        }
    }

    @NonNull
    private static C0140a a(@NonNull File file, @NonNull File file2, @NonNull com.baidu.swan.pms.a.b bVar) {
        C0140a c0140a = new C0140a();
        long currentTimeMillis = System.currentTimeMillis();
        BufferedInputStream r = com.baidu.swan.apps.install.a.a.r(file);
        if (r != null) {
            c0140a.asO = 1;
            bVar.X("670", "aiapp_aps_decrypt_start_timestamp");
            bVar.X("770", "na_package_start_decrypt");
            a.C0148a a = com.baidu.swan.apps.install.a.a.a(r, file2);
            bVar.X("670", "aiapp_aps_decrypt_end_timestamp");
            bVar.X("770", "na_package_end_decrypt");
            c0140a.asP = a.isSuccess;
            c0140a.asQ = a.asQ;
        } else {
            c0140a.asO = 0;
            bVar.X("670", "aiapp_aps_unzip_start_timestamp");
            bVar.X("770", "na_package_start_unzip");
            c0140a.asP = com.baidu.swan.c.a.bs(file.getPath(), file2.getPath());
            bVar.X("670", "aiapp_aps_unzip_end_timestamp");
            bVar.X("770", "na_package_end_unzip");
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        if (DEBUG) {
            com.baidu.swan.apps.install.a.a.cA((int) (currentTimeMillis2 - currentTimeMillis));
        }
        return c0140a;
    }
}
