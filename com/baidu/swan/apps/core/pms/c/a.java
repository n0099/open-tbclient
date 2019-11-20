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
    public static class C0183a {
        public int aMO = 0;
        public boolean aMP = false;
        public String aMQ = "";
    }

    public static File Ea() {
        return e.d.Jc();
    }

    public static File Gz() {
        return a.d.Jc();
    }

    public static String GA() {
        return e.d.Jc().getPath();
    }

    public static String Gy() {
        return e.d.Jc().getPath();
    }

    public static String GB() {
        return a.d.Jc().getPath();
    }

    public static String GC() {
        return null;
    }

    public static com.baidu.swan.games.p.a.a u(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return com.baidu.swan.games.p.a.a.ku(com.baidu.swan.c.a.l(new File(a.d.am(str, String.valueOf(i)), "game.json")));
    }

    public static com.baidu.swan.apps.ak.a a(com.baidu.swan.pms.model.e eVar, com.baidu.swan.pms.a.b bVar) {
        if (eVar == null || TextUtils.isEmpty(eVar.filePath)) {
            com.baidu.swan.apps.ak.a iL = new com.baidu.swan.apps.ak.a().ar(11L).as(2300L).iL("pkg info is empty");
            com.baidu.swan.apps.ak.e.TR().b(iL);
            return iL;
        }
        ReadableByteChannel readableByteChannel = null;
        try {
            readableByteChannel = Channels.newChannel(new FileInputStream(new File(eVar.filePath)));
            return a(readableByteChannel, eVar.sign, bVar);
        } catch (IOException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            com.baidu.swan.apps.ak.a iL2 = new com.baidu.swan.apps.ak.a().ar(11L).as(2300L).iL("cannot found filePath: " + eVar.filePath);
            com.baidu.swan.apps.ak.e.TR().b(iL2);
            return iL2;
        } finally {
            com.baidu.swan.c.a.b(readableByteChannel);
        }
    }

    public static com.baidu.swan.apps.ak.a a(ReadableByteChannel readableByteChannel, String str, com.baidu.swan.pms.a.b bVar) throws IOException {
        if (readableByteChannel == null) {
            com.baidu.swan.apps.ak.a iL = new com.baidu.swan.apps.ak.a().ar(11L).as(2300L).iL("empty source");
            com.baidu.swan.apps.ak.e.TR().b(iL);
            if (DEBUG) {
                Log.i("PkgDownloadUtil", "checkPkgZipSign err: " + iL);
                return iL;
            }
            return iL;
        }
        bVar.af("670", "aiapp_aps_check_sign_start_timestamp");
        bVar.af("770", "na_pms_start_check_sign");
        if (w.a(readableByteChannel, str, new com.baidu.swan.apps.an.a.c())) {
            bVar.af("670", "aiapp_aps_check_sign_end_timestamp");
            bVar.af("770", "na_pms_end_check_sign");
            return null;
        }
        com.baidu.swan.apps.ak.a iL2 = new com.baidu.swan.apps.ak.a().ar(11L).as(2300L).iL("check zip file sign fail.");
        com.baidu.swan.apps.ak.e.TR().b(iL2);
        if (DEBUG) {
            Log.i("PkgDownloadUtil", "checkPkgZipSign err: " + iL2);
            return iL2;
        }
        return iL2;
    }

    public static com.baidu.swan.apps.ak.a b(com.baidu.swan.pms.model.e eVar) {
        String str;
        if (eVar == null) {
            com.baidu.swan.apps.ak.a iL = new com.baidu.swan.apps.ak.a().ar(11L).as(2310L).iL("pkg info is empty");
            com.baidu.swan.apps.ak.e.TR().b(iL);
            return iL;
        }
        if (eVar.category == 0) {
            str = Ea() + File.separator + eVar.bLj + ".aiapps";
        } else if (eVar.category == 1) {
            str = Gz() + File.separator + eVar.bLj + ".aigames";
        } else {
            com.baidu.swan.apps.ak.a iL2 = new com.baidu.swan.apps.ak.a().ar(11L).as(2310L).iL("pkh category illegal");
            com.baidu.swan.apps.ak.e.TR().b(iL2);
            return iL2;
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
        com.baidu.swan.apps.ak.a iL3 = new com.baidu.swan.apps.ak.a().ar(11L).as(2310L).iL("rename zip fail");
        com.baidu.swan.apps.ak.e.TR().b(iL3);
        return iL3;
    }

    public static com.baidu.swan.apps.ak.a b(com.baidu.swan.pms.model.e eVar, com.baidu.swan.pms.a.b bVar) {
        File file;
        File am;
        if (eVar == null) {
            com.baidu.swan.apps.ak.a iL = new com.baidu.swan.apps.ak.a().ar(11L).as(2320L).iL("pkg info is empty");
            com.baidu.swan.apps.ak.e.TR().b(iL);
            return iL;
        }
        if (eVar.category == 1) {
            file = new File(Gz(), eVar.bLj + ".aigames");
            am = a.d.am(eVar.bLj, String.valueOf(eVar.versionCode));
        } else if (eVar.category == 0) {
            file = new File(Ea(), eVar.bLj + ".aiapps");
            am = e.d.am(eVar.bLj, String.valueOf(eVar.versionCode));
        } else {
            com.baidu.swan.apps.ak.a iL2 = new com.baidu.swan.apps.ak.a().ar(11L).as(2320L).iL("pkh category illegal");
            com.baidu.swan.apps.ak.e.TR().b(iL2);
            return iL2;
        }
        if (!file.exists()) {
            com.baidu.swan.apps.ak.a iL3 = new com.baidu.swan.apps.ak.a().ar(11L).as(2320L).iL("解压失败：包不存在");
            com.baidu.swan.apps.ak.e.TR().b(iL3);
            return iL3;
        } else if (am.isFile() && !am.delete()) {
            if (DEBUG) {
                Log.e("PkgDownloadUtil", "解压失败：解压目录被文件占用，且无法删除");
            }
            com.baidu.swan.apps.ak.a iL4 = new com.baidu.swan.apps.ak.a().ar(11L).as(2320L).iL("解压失败：解压目录被文件占用，且无法删除");
            com.baidu.swan.apps.ak.e.TR().b(iL4);
            return iL4;
        } else if (!am.exists() && !am.mkdirs()) {
            if (DEBUG) {
                Log.e("PkgDownloadUtil", "解压失败：解压文件夹创建失败");
            }
            com.baidu.swan.apps.ak.a iL5 = new com.baidu.swan.apps.ak.a().ar(11L).as(2320L).iL("解压失败：解压文件夹创建失败");
            com.baidu.swan.apps.ak.e.TR().b(iL5);
            return iL5;
        } else {
            if (DEBUG) {
                Log.i("PkgDownloadUtil", "开始执行解压操作, bundle:" + file.getPath() + " , folder:" + am.getPath());
            }
            if (a(file, am, bVar).aMP) {
                return null;
            }
            C0183a a = a(file, am, bVar);
            if (a.aMP) {
                com.baidu.swan.apps.statistic.c.a(bVar, eVar.category, true);
                return null;
            }
            com.baidu.swan.apps.statistic.c.a(bVar, eVar.category, false);
            com.baidu.swan.c.a.m(am);
            com.baidu.swan.pms.database.a.aaV().d(eVar);
            com.baidu.swan.apps.ak.a aVar = new com.baidu.swan.apps.ak.a();
            switch (a.aMO) {
                case 0:
                    aVar.ar(11L).as(2320L).iL("unzip failed");
                    break;
                case 1:
                    aVar.ar(11L).as(2330L).iL("decryt failed:" + a.aMQ);
                    break;
                default:
                    aVar.ar(4L).as(7L).iL("Unkown bundle type");
                    break;
            }
            com.baidu.swan.apps.ak.e.TR().b(aVar);
            return aVar;
        }
    }

    @NonNull
    private static C0183a a(@NonNull File file, @NonNull File file2, @NonNull com.baidu.swan.pms.a.b bVar) {
        C0183a c0183a = new C0183a();
        long currentTimeMillis = System.currentTimeMillis();
        BufferedInputStream h = com.baidu.swan.apps.install.a.a.h(file);
        if (h != null) {
            c0183a.aMO = 1;
            bVar.af("670", "aiapp_aps_decrypt_start_timestamp");
            bVar.af("770", "na_package_start_decrypt");
            a.C0191a a = com.baidu.swan.apps.install.a.a.a(h, file2);
            bVar.af("670", "aiapp_aps_decrypt_end_timestamp");
            bVar.af("770", "na_package_end_decrypt");
            c0183a.aMP = a.isSuccess;
            c0183a.aMQ = a.aMQ;
        } else {
            c0183a.aMO = 0;
            bVar.af("670", "aiapp_aps_unzip_start_timestamp");
            bVar.af("770", "na_package_start_unzip");
            c0183a.aMP = com.baidu.swan.c.a.bz(file.getPath(), file2.getPath());
            bVar.af("670", "aiapp_aps_unzip_end_timestamp");
            bVar.af("770", "na_package_end_unzip");
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        if (DEBUG) {
            com.baidu.swan.apps.install.a.a.dw((int) (currentTimeMillis2 - currentTimeMillis));
        }
        return c0183a;
    }
}
