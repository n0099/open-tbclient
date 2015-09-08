package com.baidu.tbadk.core.util;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.tbadk.TbConfig;
import java.io.File;
/* loaded from: classes.dex */
public class ap {
    private static ap abb;

    public static synchronized ap uE() {
        ap apVar;
        synchronized (ap.class) {
            if (abb == null) {
                abb = new ap();
            }
            apVar = abb;
        }
        return apVar;
    }

    public String dd(String str) {
        long j = 0;
        for (byte b : str.getBytes()) {
            j += b;
        }
        return "image/" + (j % 20);
    }

    public Bitmap de(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return n.ab(dd(str), str);
    }

    public boolean df(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return n.aa(dd(str), str);
    }

    public int dg(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        return (int) n.Z(dd(str), str);
    }

    public boolean copyFile(String str, String str2) {
        String str3 = n.xT + "/" + TbConfig.getTempDirName() + "/";
        if (!n.cF(str3)) {
            n.cQ(str3);
        }
        String str4 = String.valueOf(str3) + dd(str2);
        if (!n.cF(str4)) {
            n.cQ(str4);
        }
        String str5 = String.valueOf(str4) + "/" + str2;
        if (str.equals(str5)) {
            return false;
        }
        return n.c(str, str5, true);
    }

    public void h(String str, byte[] bArr) {
        if (!TextUtils.isEmpty(str)) {
            n.f(dd(str), str, bArr);
        }
    }

    private void u(File file) {
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    u(file2);
                    file2.delete();
                } else {
                    file2.delete();
                }
            }
        }
    }

    public void uF() {
        u(new File(n.xT + "/" + TbConfig.getTempDirName() + "/" + TbConfig.TMP_PIC_DIR_NAME));
        u(new File(n.xT + "/" + TbConfig.getTempDirName() + "/" + TbConfig.IMAGE_CACHE_DIR_NAME));
    }

    public void uG() {
        v(new File(n.xT + "/" + TbConfig.getTempDirName() + "/" + n.ch(3)));
    }

    private void v(File file) {
        long currentTimeMillis = System.currentTimeMillis();
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    u(file2);
                    file2.delete();
                } else if (currentTimeMillis - file2.lastModified() >= -1702967296) {
                    file2.delete();
                }
            }
        }
    }
}
