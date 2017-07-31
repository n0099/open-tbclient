package com.baidu.tbadk.core.util;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.tbadk.TbConfig;
import java.io.File;
/* loaded from: classes.dex */
public class ak {
    private static ak ahV;

    public static synchronized ak vK() {
        ak akVar;
        synchronized (ak.class) {
            if (ahV == null) {
                ahV = new ak();
            }
            akVar = ahV;
        }
        return akVar;
    }

    public String dT(String str) {
        long j = 0;
        for (byte b : str.getBytes()) {
            j += b;
        }
        return "image/" + (j % 20);
    }

    public Bitmap dU(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return k.V(dT(str), str);
    }

    public boolean dV(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return k.U(dT(str), str);
    }

    public int dW(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        return (int) k.T(dT(str), str);
    }

    public boolean X(String str, String str2) {
        String str3 = k.zU + "/" + TbConfig.getTempDirName() + "/";
        if (!k.ds(str3)) {
            k.dF(str3);
        }
        String str4 = str3 + dT(str2);
        if (!k.ds(str4)) {
            k.dF(str4);
        }
        String str5 = str4 + "/" + str2;
        if (str.equals(str5)) {
            return false;
        }
        return k.c(str, str5, true);
    }

    public void h(String str, byte[] bArr) {
        if (!TextUtils.isEmpty(str)) {
            k.d(dT(str), str, bArr);
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

    public void vL() {
        v(new File(k.zU + "/" + TbConfig.getTempDirName() + "/" + TbConfig.TMP_PIC_DIR_NAME));
        v(new File(k.zU + "/" + TbConfig.getTempDirName() + "/" + TbConfig.IMAGE_CACHE_DIR_NAME));
    }

    public void vM() {
        w(new File(k.zU + "/" + TbConfig.getTempDirName() + "/" + k.cF(3)));
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
