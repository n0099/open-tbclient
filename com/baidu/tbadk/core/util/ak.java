package com.baidu.tbadk.core.util;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.tbadk.TbConfig;
import java.io.File;
/* loaded from: classes.dex */
public class ak {
    private static ak ahX;

    public static synchronized ak vL() {
        ak akVar;
        synchronized (ak.class) {
            if (ahX == null) {
                ahX = new ak();
            }
            akVar = ahX;
        }
        return akVar;
    }

    public String dX(String str) {
        long j = 0;
        for (byte b : str.getBytes()) {
            j += b;
        }
        return "image/" + (j % 20);
    }

    public Bitmap dY(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return k.V(dX(str), str);
    }

    public boolean dZ(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return k.U(dX(str), str);
    }

    public int ea(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        return (int) k.T(dX(str), str);
    }

    public boolean X(String str, String str2) {
        String str3 = k.zW + "/" + TbConfig.getTempDirName() + "/";
        if (!k.dv(str3)) {
            k.dI(str3);
        }
        String str4 = str3 + dX(str2);
        if (!k.dv(str4)) {
            k.dI(str4);
        }
        String str5 = str4 + "/" + str2;
        if (str.equals(str5)) {
            return false;
        }
        return k.c(str, str5, true);
    }

    public void h(String str, byte[] bArr) {
        if (!TextUtils.isEmpty(str)) {
            k.d(dX(str), str, bArr);
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

    public void vM() {
        v(new File(k.zW + "/" + TbConfig.getTempDirName() + "/" + TbConfig.TMP_PIC_DIR_NAME));
        v(new File(k.zW + "/" + TbConfig.getTempDirName() + "/" + TbConfig.IMAGE_CACHE_DIR_NAME));
    }

    public void vN() {
        w(new File(k.zW + "/" + TbConfig.getTempDirName() + "/" + k.cF(3)));
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
