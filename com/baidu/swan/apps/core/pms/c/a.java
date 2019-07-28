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
    public static class C0142a {
        public int atr = 0;
        public boolean ats = false;
        public String att = "";
    }

    public static File za() {
        return e.d.Ed();
    }

    public static File BA() {
        return a.d.Ed();
    }

    public static String BB() {
        return e.d.Ed().getPath();
    }

    public static String Bz() {
        return e.d.Ed().getPath();
    }

    public static String BC() {
        return a.d.Ed().getPath();
    }

    public static String BD() {
        return null;
    }

    public static com.baidu.swan.games.p.a.a u(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return com.baidu.swan.games.p.a.a.jQ(com.baidu.swan.c.a.v(new File(a.d.ae(str, String.valueOf(i)), "game.json")));
    }

    public static com.baidu.swan.apps.ak.a a(com.baidu.swan.pms.model.e eVar, com.baidu.swan.pms.a.b bVar) {
        if (eVar == null || TextUtils.isEmpty(eVar.filePath)) {
            com.baidu.swan.apps.ak.a ig = new com.baidu.swan.apps.ak.a().Z(11L).aa(2300L).ig("pkg info is empty");
            com.baidu.swan.apps.ak.e.OZ().b(ig);
            return ig;
        }
        ReadableByteChannel readableByteChannel = null;
        try {
            readableByteChannel = Channels.newChannel(new FileInputStream(new File(eVar.filePath)));
            return a(readableByteChannel, eVar.sign, bVar);
        } catch (IOException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            com.baidu.swan.apps.ak.a ig2 = new com.baidu.swan.apps.ak.a().Z(11L).aa(2300L).ig("cannot found filePath: " + eVar.filePath);
            com.baidu.swan.apps.ak.e.OZ().b(ig2);
            return ig2;
        } finally {
            com.baidu.swan.c.a.c(readableByteChannel);
        }
    }

    public static com.baidu.swan.apps.ak.a a(ReadableByteChannel readableByteChannel, String str, com.baidu.swan.pms.a.b bVar) throws IOException {
        if (readableByteChannel == null) {
            com.baidu.swan.apps.ak.a ig = new com.baidu.swan.apps.ak.a().Z(11L).aa(2300L).ig("empty source");
            com.baidu.swan.apps.ak.e.OZ().b(ig);
            if (DEBUG) {
                Log.i("PkgDownloadUtil", "checkPkgZipSign err: " + ig);
                return ig;
            }
            return ig;
        }
        bVar.X("670", "aiapp_aps_check_sign_start_timestamp");
        bVar.X("770", "na_pms_start_check_sign");
        if (w.a(readableByteChannel, str, new com.baidu.swan.apps.an.a.c())) {
            bVar.X("670", "aiapp_aps_check_sign_end_timestamp");
            bVar.X("770", "na_pms_end_check_sign");
            return null;
        }
        com.baidu.swan.apps.ak.a ig2 = new com.baidu.swan.apps.ak.a().Z(11L).aa(2300L).ig("check zip file sign fail.");
        com.baidu.swan.apps.ak.e.OZ().b(ig2);
        if (DEBUG) {
            Log.i("PkgDownloadUtil", "checkPkgZipSign err: " + ig2);
            return ig2;
        }
        return ig2;
    }

    public static com.baidu.swan.apps.ak.a b(com.baidu.swan.pms.model.e eVar) {
        String str;
        if (eVar == null) {
            com.baidu.swan.apps.ak.a ig = new com.baidu.swan.apps.ak.a().Z(11L).aa(2310L).ig("pkg info is empty");
            com.baidu.swan.apps.ak.e.OZ().b(ig);
            return ig;
        }
        if (eVar.ave == 0) {
            str = za() + File.separator + eVar.bsR + ".aiapps";
        } else if (eVar.ave == 1) {
            str = BA() + File.separator + eVar.bsR + ".aigames";
        } else {
            com.baidu.swan.apps.ak.a ig2 = new com.baidu.swan.apps.ak.a().Z(11L).aa(2310L).ig("pkh category illegal");
            com.baidu.swan.apps.ak.e.OZ().b(ig2);
            return ig2;
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
        com.baidu.swan.apps.ak.a ig3 = new com.baidu.swan.apps.ak.a().Z(11L).aa(2310L).ig("rename zip fail");
        com.baidu.swan.apps.ak.e.OZ().b(ig3);
        return ig3;
    }

    public static com.baidu.swan.apps.ak.a b(com.baidu.swan.pms.model.e eVar, com.baidu.swan.pms.a.b bVar) {
        File file;
        File ae;
        if (eVar == null) {
            com.baidu.swan.apps.ak.a ig = new com.baidu.swan.apps.ak.a().Z(11L).aa(2320L).ig("pkg info is empty");
            com.baidu.swan.apps.ak.e.OZ().b(ig);
            return ig;
        }
        if (eVar.ave == 1) {
            file = new File(BA(), eVar.bsR + ".aigames");
            ae = a.d.ae(eVar.bsR, String.valueOf(eVar.versionCode));
        } else if (eVar.ave == 0) {
            file = new File(za(), eVar.bsR + ".aiapps");
            ae = e.d.ae(eVar.bsR, String.valueOf(eVar.versionCode));
        } else {
            com.baidu.swan.apps.ak.a ig2 = new com.baidu.swan.apps.ak.a().Z(11L).aa(2320L).ig("pkh category illegal");
            com.baidu.swan.apps.ak.e.OZ().b(ig2);
            return ig2;
        }
        if (!file.exists()) {
            com.baidu.swan.apps.ak.a ig3 = new com.baidu.swan.apps.ak.a().Z(11L).aa(2320L).ig("解压失败：包不存在");
            com.baidu.swan.apps.ak.e.OZ().b(ig3);
            return ig3;
        } else if (ae.isFile() && !ae.delete()) {
            if (DEBUG) {
                Log.e("PkgDownloadUtil", "解压失败：解压目录被文件占用，且无法删除");
            }
            com.baidu.swan.apps.ak.a ig4 = new com.baidu.swan.apps.ak.a().Z(11L).aa(2320L).ig("解压失败：解压目录被文件占用，且无法删除");
            com.baidu.swan.apps.ak.e.OZ().b(ig4);
            return ig4;
        } else if (!ae.exists() && !ae.mkdirs()) {
            if (DEBUG) {
                Log.e("PkgDownloadUtil", "解压失败：解压文件夹创建失败");
            }
            com.baidu.swan.apps.ak.a ig5 = new com.baidu.swan.apps.ak.a().Z(11L).aa(2320L).ig("解压失败：解压文件夹创建失败");
            com.baidu.swan.apps.ak.e.OZ().b(ig5);
            return ig5;
        } else {
            if (DEBUG) {
                Log.i("PkgDownloadUtil", "开始执行解压操作, bundle:" + file.getPath() + " , folder:" + ae.getPath());
            }
            if (a(file, ae, bVar).ats) {
                return null;
            }
            C0142a a = a(file, ae, bVar);
            if (a.ats) {
                com.baidu.swan.apps.statistic.c.a(bVar, eVar.ave, true);
                return null;
            }
            com.baidu.swan.apps.statistic.c.a(bVar, eVar.ave, false);
            com.baidu.swan.c.a.safeDeleteFile(ae);
            com.baidu.swan.pms.database.a.We().d(eVar);
            com.baidu.swan.apps.ak.a aVar = new com.baidu.swan.apps.ak.a();
            switch (a.atr) {
                case 0:
                    aVar.Z(11L).aa(2320L).ig("unzip failed");
                    break;
                case 1:
                    aVar.Z(11L).aa(2330L).ig("decryt failed:" + a.att);
                    break;
                default:
                    aVar.Z(4L).aa(7L).ig("Unkown bundle type");
                    break;
            }
            com.baidu.swan.apps.ak.e.OZ().b(aVar);
            return aVar;
        }
    }

    @NonNull
    private static C0142a a(@NonNull File file, @NonNull File file2, @NonNull com.baidu.swan.pms.a.b bVar) {
        C0142a c0142a = new C0142a();
        long currentTimeMillis = System.currentTimeMillis();
        BufferedInputStream r = com.baidu.swan.apps.install.a.a.r(file);
        if (r != null) {
            c0142a.atr = 1;
            bVar.X("670", "aiapp_aps_decrypt_start_timestamp");
            bVar.X("770", "na_package_start_decrypt");
            a.C0150a a = com.baidu.swan.apps.install.a.a.a(r, file2);
            bVar.X("670", "aiapp_aps_decrypt_end_timestamp");
            bVar.X("770", "na_package_end_decrypt");
            c0142a.ats = a.isSuccess;
            c0142a.att = a.att;
        } else {
            c0142a.atr = 0;
            bVar.X("670", "aiapp_aps_unzip_start_timestamp");
            bVar.X("770", "na_package_start_unzip");
            c0142a.ats = com.baidu.swan.c.a.bs(file.getPath(), file2.getPath());
            bVar.X("670", "aiapp_aps_unzip_end_timestamp");
            bVar.X("770", "na_package_end_unzip");
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        if (DEBUG) {
            com.baidu.swan.apps.install.a.a.cA((int) (currentTimeMillis2 - currentTimeMillis));
        }
        return c0142a;
    }
}
