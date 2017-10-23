package com.baidu.tbadk.core.util;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.tbadk.TbConfig;
import java.io.File;
/* loaded from: classes.dex */
public class al {
    private static al agC;

    public static synchronized al vf() {
        al alVar;
        synchronized (al.class) {
            if (agC == null) {
                agC = new al();
            }
            alVar = agC;
        }
        return alVar;
    }

    public String dH(String str) {
        if (str == null) {
            return null;
        }
        long j = 0;
        for (byte b : str.getBytes()) {
            j += b;
        }
        return "image/" + (j % 20);
    }

    public Bitmap dI(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return k.X(dH(str), str);
    }

    public boolean dJ(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return k.W(dH(str), str);
    }

    public int dK(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        return (int) k.V(dH(str), str);
    }

    public boolean Z(String str, String str2) {
        String str3 = k.xT + "/" + TbConfig.getTempDirName() + "/";
        if (!k.da(str3)) {
            k.dr(str3);
        }
        String str4 = str3 + dH(str2);
        if (!k.da(str4)) {
            k.dr(str4);
        }
        String str5 = str4 + "/" + str2;
        if (str.equals(str5)) {
            return false;
        }
        return k.c(str, str5, true);
    }

    public void i(String str, byte[] bArr) {
        if (!TextUtils.isEmpty(str)) {
            k.d(dH(str), str, bArr);
        }
    }

    private void w(File file) {
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    w(file2);
                    file2.delete();
                } else if (!file2.delete()) {
                }
            }
        }
    }

    public void vg() {
        w(new File(k.xT + "/" + TbConfig.getTempDirName() + "/" + TbConfig.TMP_PIC_DIR_NAME));
        w(new File(k.xT + "/" + TbConfig.getTempDirName() + "/" + TbConfig.IMAGE_CACHE_DIR_NAME));
    }

    public void vh() {
        x(new File(k.xT + "/" + TbConfig.getTempDirName() + "/" + k.cC(3)));
    }

    private void x(File file) {
        long currentTimeMillis = System.currentTimeMillis();
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    w(file2);
                    file2.delete();
                } else if (currentTimeMillis - file2.lastModified() >= -1702967296 && file2.delete()) {
                }
            }
        }
    }
}
