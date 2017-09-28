package com.baidu.tbadk.core.util;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.tbadk.TbConfig;
import java.io.File;
/* loaded from: classes.dex */
public class al {
    private static al agO;

    public static synchronized al vm() {
        al alVar;
        synchronized (al.class) {
            if (agO == null) {
                agO = new al();
            }
            alVar = agO;
        }
        return alVar;
    }

    public String dI(String str) {
        if (str == null) {
            return null;
        }
        long j = 0;
        for (byte b : str.getBytes()) {
            j += b;
        }
        return "image/" + (j % 20);
    }

    public Bitmap dJ(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return k.Y(dI(str), str);
    }

    public boolean dK(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return k.X(dI(str), str);
    }

    public int dL(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        return (int) k.W(dI(str), str);
    }

    public boolean aa(String str, String str2) {
        String str3 = k.xS + "/" + TbConfig.getTempDirName() + "/";
        if (!k.db(str3)) {
            k.ds(str3);
        }
        String str4 = str3 + dI(str2);
        if (!k.db(str4)) {
            k.ds(str4);
        }
        String str5 = str4 + "/" + str2;
        if (str.equals(str5)) {
            return false;
        }
        return k.c(str, str5, true);
    }

    public void i(String str, byte[] bArr) {
        if (!TextUtils.isEmpty(str)) {
            k.d(dI(str), str, bArr);
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

    public void vn() {
        w(new File(k.xS + "/" + TbConfig.getTempDirName() + "/" + TbConfig.TMP_PIC_DIR_NAME));
        w(new File(k.xS + "/" + TbConfig.getTempDirName() + "/" + TbConfig.IMAGE_CACHE_DIR_NAME));
    }

    public void vo() {
        x(new File(k.xS + "/" + TbConfig.getTempDirName() + "/" + k.cD(3)));
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
