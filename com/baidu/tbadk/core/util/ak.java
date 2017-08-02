package com.baidu.tbadk.core.util;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.tbadk.TbConfig;
import java.io.File;
/* loaded from: classes.dex */
public class ak {
    private static ak agC;

    public static synchronized ak vA() {
        ak akVar;
        synchronized (ak.class) {
            if (agC == null) {
                agC = new ak();
            }
            akVar = agC;
        }
        return akVar;
    }

    public String dN(String str) {
        long j = 0;
        for (byte b : str.getBytes()) {
            j += b;
        }
        return "image/" + (j % 20);
    }

    public Bitmap dO(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return k.V(dN(str), str);
    }

    public boolean dP(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return k.U(dN(str), str);
    }

    public int dQ(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        return (int) k.T(dN(str), str);
    }

    public boolean X(String str, String str2) {
        String str3 = k.yu + "/" + TbConfig.getTempDirName() + "/";
        if (!k.dm(str3)) {
            k.dz(str3);
        }
        String str4 = str3 + dN(str2);
        if (!k.dm(str4)) {
            k.dz(str4);
        }
        String str5 = str4 + "/" + str2;
        if (str.equals(str5)) {
            return false;
        }
        return k.c(str, str5, true);
    }

    public void h(String str, byte[] bArr) {
        if (!TextUtils.isEmpty(str)) {
            k.d(dN(str), str, bArr);
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

    public void vB() {
        v(new File(k.yu + "/" + TbConfig.getTempDirName() + "/" + TbConfig.TMP_PIC_DIR_NAME));
        v(new File(k.yu + "/" + TbConfig.getTempDirName() + "/" + TbConfig.IMAGE_CACHE_DIR_NAME));
    }

    public void vC() {
        w(new File(k.yu + "/" + TbConfig.getTempDirName() + "/" + k.cD(3)));
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
