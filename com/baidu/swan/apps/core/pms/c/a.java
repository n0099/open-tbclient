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
    public static class C0151a {
        public int atP = 0;
        public boolean atQ = false;
        public String atR = "";
    }

    public static File ze() {
        return e.d.Eh();
    }

    public static File BE() {
        return a.d.Eh();
    }

    public static String BF() {
        return e.d.Eh().getPath();
    }

    public static String BD() {
        return e.d.Eh().getPath();
    }

    public static String BG() {
        return a.d.Eh().getPath();
    }

    public static String BH() {
        return null;
    }

    public static com.baidu.swan.games.p.a.a u(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return com.baidu.swan.games.p.a.a.jS(com.baidu.swan.c.a.v(new File(a.d.ae(str, String.valueOf(i)), "game.json")));
    }

    public static com.baidu.swan.apps.ak.a a(com.baidu.swan.pms.model.e eVar, com.baidu.swan.pms.a.b bVar) {
        if (eVar == null || TextUtils.isEmpty(eVar.filePath)) {
            com.baidu.swan.apps.ak.a ii = new com.baidu.swan.apps.ak.a().Z(11L).aa(2300L).ii("pkg info is empty");
            com.baidu.swan.apps.ak.e.Pd().b(ii);
            return ii;
        }
        ReadableByteChannel readableByteChannel = null;
        try {
            readableByteChannel = Channels.newChannel(new FileInputStream(new File(eVar.filePath)));
            return a(readableByteChannel, eVar.sign, bVar);
        } catch (IOException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            com.baidu.swan.apps.ak.a ii2 = new com.baidu.swan.apps.ak.a().Z(11L).aa(2300L).ii("cannot found filePath: " + eVar.filePath);
            com.baidu.swan.apps.ak.e.Pd().b(ii2);
            return ii2;
        } finally {
            com.baidu.swan.c.a.c(readableByteChannel);
        }
    }

    public static com.baidu.swan.apps.ak.a a(ReadableByteChannel readableByteChannel, String str, com.baidu.swan.pms.a.b bVar) throws IOException {
        if (readableByteChannel == null) {
            com.baidu.swan.apps.ak.a ii = new com.baidu.swan.apps.ak.a().Z(11L).aa(2300L).ii("empty source");
            com.baidu.swan.apps.ak.e.Pd().b(ii);
            if (DEBUG) {
                Log.i("PkgDownloadUtil", "checkPkgZipSign err: " + ii);
                return ii;
            }
            return ii;
        }
        bVar.X("670", "aiapp_aps_check_sign_start_timestamp");
        bVar.X("770", "na_pms_start_check_sign");
        if (w.a(readableByteChannel, str, new com.baidu.swan.apps.an.a.c())) {
            bVar.X("670", "aiapp_aps_check_sign_end_timestamp");
            bVar.X("770", "na_pms_end_check_sign");
            return null;
        }
        com.baidu.swan.apps.ak.a ii2 = new com.baidu.swan.apps.ak.a().Z(11L).aa(2300L).ii("check zip file sign fail.");
        com.baidu.swan.apps.ak.e.Pd().b(ii2);
        if (DEBUG) {
            Log.i("PkgDownloadUtil", "checkPkgZipSign err: " + ii2);
            return ii2;
        }
        return ii2;
    }

    public static com.baidu.swan.apps.ak.a b(com.baidu.swan.pms.model.e eVar) {
        String str;
        if (eVar == null) {
            com.baidu.swan.apps.ak.a ii = new com.baidu.swan.apps.ak.a().Z(11L).aa(2310L).ii("pkg info is empty");
            com.baidu.swan.apps.ak.e.Pd().b(ii);
            return ii;
        }
        if (eVar.avC == 0) {
            str = ze() + File.separator + eVar.btp + ".aiapps";
        } else if (eVar.avC == 1) {
            str = BE() + File.separator + eVar.btp + ".aigames";
        } else {
            com.baidu.swan.apps.ak.a ii2 = new com.baidu.swan.apps.ak.a().Z(11L).aa(2310L).ii("pkh category illegal");
            com.baidu.swan.apps.ak.e.Pd().b(ii2);
            return ii2;
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
        com.baidu.swan.apps.ak.a ii3 = new com.baidu.swan.apps.ak.a().Z(11L).aa(2310L).ii("rename zip fail");
        com.baidu.swan.apps.ak.e.Pd().b(ii3);
        return ii3;
    }

    public static com.baidu.swan.apps.ak.a b(com.baidu.swan.pms.model.e eVar, com.baidu.swan.pms.a.b bVar) {
        File file;
        File ae;
        if (eVar == null) {
            com.baidu.swan.apps.ak.a ii = new com.baidu.swan.apps.ak.a().Z(11L).aa(2320L).ii("pkg info is empty");
            com.baidu.swan.apps.ak.e.Pd().b(ii);
            return ii;
        }
        if (eVar.avC == 1) {
            file = new File(BE(), eVar.btp + ".aigames");
            ae = a.d.ae(eVar.btp, String.valueOf(eVar.versionCode));
        } else if (eVar.avC == 0) {
            file = new File(ze(), eVar.btp + ".aiapps");
            ae = e.d.ae(eVar.btp, String.valueOf(eVar.versionCode));
        } else {
            com.baidu.swan.apps.ak.a ii2 = new com.baidu.swan.apps.ak.a().Z(11L).aa(2320L).ii("pkh category illegal");
            com.baidu.swan.apps.ak.e.Pd().b(ii2);
            return ii2;
        }
        if (!file.exists()) {
            com.baidu.swan.apps.ak.a ii3 = new com.baidu.swan.apps.ak.a().Z(11L).aa(2320L).ii("解压失败：包不存在");
            com.baidu.swan.apps.ak.e.Pd().b(ii3);
            return ii3;
        } else if (ae.isFile() && !ae.delete()) {
            if (DEBUG) {
                Log.e("PkgDownloadUtil", "解压失败：解压目录被文件占用，且无法删除");
            }
            com.baidu.swan.apps.ak.a ii4 = new com.baidu.swan.apps.ak.a().Z(11L).aa(2320L).ii("解压失败：解压目录被文件占用，且无法删除");
            com.baidu.swan.apps.ak.e.Pd().b(ii4);
            return ii4;
        } else if (!ae.exists() && !ae.mkdirs()) {
            if (DEBUG) {
                Log.e("PkgDownloadUtil", "解压失败：解压文件夹创建失败");
            }
            com.baidu.swan.apps.ak.a ii5 = new com.baidu.swan.apps.ak.a().Z(11L).aa(2320L).ii("解压失败：解压文件夹创建失败");
            com.baidu.swan.apps.ak.e.Pd().b(ii5);
            return ii5;
        } else {
            if (DEBUG) {
                Log.i("PkgDownloadUtil", "开始执行解压操作, bundle:" + file.getPath() + " , folder:" + ae.getPath());
            }
            if (a(file, ae, bVar).atQ) {
                return null;
            }
            C0151a a = a(file, ae, bVar);
            if (a.atQ) {
                com.baidu.swan.apps.statistic.c.a(bVar, eVar.avC, true);
                return null;
            }
            com.baidu.swan.apps.statistic.c.a(bVar, eVar.avC, false);
            com.baidu.swan.c.a.safeDeleteFile(ae);
            com.baidu.swan.pms.database.a.Wi().d(eVar);
            com.baidu.swan.apps.ak.a aVar = new com.baidu.swan.apps.ak.a();
            switch (a.atP) {
                case 0:
                    aVar.Z(11L).aa(2320L).ii("unzip failed");
                    break;
                case 1:
                    aVar.Z(11L).aa(2330L).ii("decryt failed:" + a.atR);
                    break;
                default:
                    aVar.Z(4L).aa(7L).ii("Unkown bundle type");
                    break;
            }
            com.baidu.swan.apps.ak.e.Pd().b(aVar);
            return aVar;
        }
    }

    @NonNull
    private static C0151a a(@NonNull File file, @NonNull File file2, @NonNull com.baidu.swan.pms.a.b bVar) {
        C0151a c0151a = new C0151a();
        long currentTimeMillis = System.currentTimeMillis();
        BufferedInputStream r = com.baidu.swan.apps.install.a.a.r(file);
        if (r != null) {
            c0151a.atP = 1;
            bVar.X("670", "aiapp_aps_decrypt_start_timestamp");
            bVar.X("770", "na_package_start_decrypt");
            a.C0159a a = com.baidu.swan.apps.install.a.a.a(r, file2);
            bVar.X("670", "aiapp_aps_decrypt_end_timestamp");
            bVar.X("770", "na_package_end_decrypt");
            c0151a.atQ = a.isSuccess;
            c0151a.atR = a.atR;
        } else {
            c0151a.atP = 0;
            bVar.X("670", "aiapp_aps_unzip_start_timestamp");
            bVar.X("770", "na_package_start_unzip");
            c0151a.atQ = com.baidu.swan.c.a.bs(file.getPath(), file2.getPath());
            bVar.X("670", "aiapp_aps_unzip_end_timestamp");
            bVar.X("770", "na_package_end_unzip");
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        if (DEBUG) {
            com.baidu.swan.apps.install.a.a.cB((int) (currentTimeMillis2 - currentTimeMillis));
        }
        return c0151a;
    }
}
