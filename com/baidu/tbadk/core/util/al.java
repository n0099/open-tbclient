package com.baidu.tbadk.core.util;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.tbadk.TbConfig;
import java.io.File;
/* loaded from: classes.dex */
public class al {
    private static al aVB;

    public static synchronized al CM() {
        al alVar;
        synchronized (al.class) {
            if (aVB == null) {
                aVB = new al();
            }
            alVar = aVB;
        }
        return alVar;
    }

    public String dW(String str) {
        if (str == null) {
            return null;
        }
        long j = 0;
        for (byte b : str.getBytes()) {
            j += b;
        }
        return "image/" + (j % 20);
    }

    public Bitmap dX(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return k.W(dW(str), str);
    }

    public boolean dY(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return k.V(dW(str), str);
    }

    public int dZ(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        return (int) k.U(dW(str), str);
    }

    public boolean Y(String str, String str2) {
        String str3 = k.amc + "/" + TbConfig.getTempDirName() + "/";
        if (!k.m12do(str3)) {
            k.dF(str3);
        }
        String str4 = str3 + dW(str2);
        if (!k.m12do(str4)) {
            k.dF(str4);
        }
        String str5 = str4 + "/" + str2;
        if (str.equals(str5)) {
            return false;
        }
        return k.c(str, str5, true);
    }

    public void i(String str, byte[] bArr) {
        if (!TextUtils.isEmpty(str)) {
            k.d(dW(str), str, bArr);
        }
    }

    private void v(File file) {
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    v(file2);
                    file2.delete();
                } else if (!file2.delete()) {
                }
            }
        }
    }

    public void CN() {
        v(new File(k.amc + "/" + TbConfig.getTempDirName() + "/" + TbConfig.TMP_PIC_DIR_NAME));
        v(new File(k.amc + "/" + TbConfig.getTempDirName() + "/" + TbConfig.IMAGE_CACHE_DIR_NAME));
    }

    public void CO() {
        w(new File(k.amc + "/" + TbConfig.getTempDirName() + "/" + k.fC(3)));
    }

    private void w(File file) {
        long currentTimeMillis = System.currentTimeMillis();
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    v(file2);
                    file2.delete();
                } else if (currentTimeMillis - file2.lastModified() >= -1702967296 && file2.delete()) {
                }
            }
        }
    }
}
