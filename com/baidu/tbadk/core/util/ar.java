package com.baidu.tbadk.core.util;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.tbadk.TbConfig;
import java.io.File;
/* loaded from: classes.dex */
public class ar {
    private static ar abb;

    public static synchronized ar uD() {
        ar arVar;
        synchronized (ar.class) {
            if (abb == null) {
                abb = new ar();
            }
            arVar = abb;
        }
        return arVar;
    }

    public String di(String str) {
        long j = 0;
        for (byte b : str.getBytes()) {
            j += b;
        }
        return "image/" + (j % 20);
    }

    public Bitmap dj(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return n.aa(di(str), str);
    }

    public boolean dk(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return n.Z(di(str), str);
    }

    public int dl(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        return (int) n.Y(di(str), str);
    }

    public boolean copyFile(String str, String str2) {
        String str3 = n.xU + "/" + TbConfig.getTempDirName() + "/";
        if (!n.cG(str3)) {
            n.cT(str3);
        }
        String str4 = String.valueOf(str3) + di(str2);
        if (!n.cG(str4)) {
            n.cT(str4);
        }
        String str5 = String.valueOf(str4) + "/" + str2;
        if (str.equals(str5)) {
            return false;
        }
        return n.c(str, str5, true);
    }

    public void h(String str, byte[] bArr) {
        if (!TextUtils.isEmpty(str)) {
            n.f(di(str), str, bArr);
        }
    }

    private void t(File file) {
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    t(file2);
                    file2.delete();
                } else {
                    file2.delete();
                }
            }
        }
    }

    public void uE() {
        t(new File(n.xU + "/" + TbConfig.getTempDirName() + "/" + TbConfig.TMP_PIC_DIR_NAME));
        t(new File(n.xU + "/" + TbConfig.getTempDirName() + "/" + TbConfig.IMAGE_CACHE_DIR_NAME));
    }

    public void uF() {
        u(new File(n.xU + "/" + TbConfig.getTempDirName() + "/" + n.cj(3)));
    }

    private void u(File file) {
        long currentTimeMillis = System.currentTimeMillis();
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    t(file2);
                    file2.delete();
                } else if (currentTimeMillis - file2.lastModified() >= -1702967296) {
                    file2.delete();
                }
            }
        }
    }
}
