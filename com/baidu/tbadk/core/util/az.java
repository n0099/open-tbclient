package com.baidu.tbadk.core.util;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.tbadk.TbConfig;
import java.io.File;
/* loaded from: classes.dex */
public class az {
    private static az a;

    public static synchronized az a() {
        az azVar;
        synchronized (az.class) {
            if (a == null) {
                a = new az();
            }
            azVar = a;
        }
        return azVar;
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
        return s.c(a(str), str);
    }

    public boolean c(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return s.b(a(str), str);
    }

    public int d(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        return (int) s.a(a(str), str);
    }

    public boolean a(String str, String str2) {
        String str3 = s.a + "/" + TbConfig.getTempDirName() + "/";
        if (!s.a(str3)) {
            s.l(str3);
        }
        String str4 = String.valueOf(str3) + a(str2);
        if (!s.a(str4)) {
            s.l(str4);
        }
        String str5 = String.valueOf(str4) + "/" + str2;
        if (str.equals(str5)) {
            return false;
        }
        return s.a(str, str5, true);
    }

    public void a(String str, byte[] bArr) {
        if (!TextUtils.isEmpty(str)) {
            s.a(a(str), str, bArr);
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
        a(new File(s.a + "/" + TbConfig.getTempDirName() + "/" + TbConfig.TMP_PIC_DIR_NAME));
        a(new File(s.a + "/" + TbConfig.getTempDirName() + "/" + TbConfig.IMAGE_CACHE_DIR_NAME));
    }

    public void c() {
        b(new File(s.a + "/" + TbConfig.getTempDirName() + "/" + s.a(3)));
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
