package com.baidu.tbadk.core.util;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.tbadk.TbConfig;
import java.io.File;
/* loaded from: classes.dex */
public class al {
    private static al aWX;

    public static synchronized al CX() {
        al alVar;
        synchronized (al.class) {
            if (aWX == null) {
                aWX = new al();
            }
            alVar = aWX;
        }
        return alVar;
    }

    public String en(String str) {
        if (str == null) {
            return null;
        }
        long j = 0;
        for (byte b : str.getBytes()) {
            j += b;
        }
        return "image/" + (j % 20);
    }

    public Bitmap dP(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return k.X(en(str), str);
    }

    public boolean eo(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return k.W(en(str), str);
    }

    public int ep(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        return (int) k.V(en(str), str);
    }

    public boolean Y(String str, String str2) {
        String str3 = k.alY + "/" + TbConfig.getTempDirName() + "/";
        if (!k.dz(str3)) {
            k.dW(str3);
        }
        String str4 = str3 + en(str2);
        if (!k.dz(str4)) {
            k.dW(str4);
        }
        String str5 = str4 + "/" + str2;
        if (str.equals(str5)) {
            return false;
        }
        return k.c(str, str5, true);
    }

    public void j(String str, byte[] bArr) {
        if (!TextUtils.isEmpty(str)) {
            k.d(en(str), str, bArr);
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

    public void CY() {
        v(new File(k.alY + "/" + TbConfig.getTempDirName() + "/image"));
        v(new File(k.alY + "/" + TbConfig.getTempDirName() + "/" + TbConfig.IMAGE_CACHE_DIR_NAME));
    }

    public void CZ() {
        w(new File(k.alY + "/" + TbConfig.getTempDirName() + "/" + k.fA(3)));
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
