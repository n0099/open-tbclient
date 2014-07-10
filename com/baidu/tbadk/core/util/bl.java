package com.baidu.tbadk.core.util;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.tbadk.TbConfig;
import java.io.File;
/* loaded from: classes.dex */
public class bl {
    private static bl a;

    public static synchronized bl a() {
        bl blVar;
        synchronized (bl.class) {
            if (a == null) {
                a = new bl();
            }
            blVar = a;
        }
        return blVar;
    }

    public String a(String str) {
        long j = 0;
        for (byte b : str.getBytes()) {
            j += b;
        }
        return "image/" + (j % 20);
    }

    public Bitmap b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return z.c(a(str), str);
    }

    public com.baidu.adp.widget.a.a a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return z.d(str, str2);
    }

    public boolean c(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return z.b(a(str), str);
    }

    public int d(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        return (int) z.a(a(str), str);
    }

    public int e(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        return (int) z.a(z.a(3), str);
    }

    public boolean b(String str, String str2) {
        String str3 = z.a + "/" + TbConfig.getTempDirName() + "/";
        if (!z.a(str3)) {
            z.l(str3);
        }
        String str4 = String.valueOf(str3) + a(str2);
        if (!z.a(str4)) {
            z.l(str4);
        }
        String str5 = String.valueOf(str4) + "/" + str2;
        if (str.equals(str5)) {
            return false;
        }
        return z.a(str, str5, true);
    }

    public void a(String str, byte[] bArr) {
        if (!TextUtils.isEmpty(str)) {
            z.a(a(str), str, bArr);
        }
    }

    public void b(String str, byte[] bArr) {
        if (!TextUtils.isEmpty(str)) {
            z.a(z.a(3), str, bArr);
        }
    }

    private void a(File file) {
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    a(file2);
                    file2.delete();
                } else {
                    file2.delete();
                }
            }
        }
    }

    public void b() {
        a(new File(z.a + "/" + TbConfig.getTempDirName() + "/" + TbConfig.TMP_PIC_DIR_NAME));
        a(new File(z.a + "/" + TbConfig.getTempDirName() + "/" + TbConfig.IMAGE_CACHE_DIR_NAME));
    }

    public void c() {
        b(new File(z.a + "/" + TbConfig.getTempDirName() + "/" + z.a(3)));
    }

    private void b(File file) {
        long currentTimeMillis = System.currentTimeMillis();
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    a(file2);
                    file2.delete();
                } else if (currentTimeMillis - file2.lastModified() >= -1702967296) {
                    file2.delete();
                }
            }
        }
    }
}
