package com.baidu.tbadk.core.util;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.tbadk.TbConfig;
import java.io.File;
/* loaded from: classes.dex */
public class am {
    private static am aiD;

    public static synchronized am vK() {
        am amVar;
        synchronized (am.class) {
            if (aiD == null) {
                aiD = new am();
            }
            amVar = aiD;
        }
        return amVar;
    }

    public String ef(String str) {
        if (str == null) {
            return null;
        }
        long j = 0;
        for (byte b : str.getBytes()) {
            j += b;
        }
        return "image/" + (j % 20);
    }

    public Bitmap dH(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return k.Y(ef(str), str);
    }

    public boolean eg(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return k.X(ef(str), str);
    }

    public int eh(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        return (int) k.W(ef(str), str);
    }

    public boolean Z(String str, String str2) {
        String str3 = k.wB + "/" + TbConfig.getTempDirName() + "/";
        if (!k.dr(str3)) {
            k.dN(str3);
        }
        String str4 = str3 + ef(str2);
        if (!k.dr(str4)) {
            k.dN(str4);
        }
        String str5 = str4 + "/" + str2;
        if (str.equals(str5)) {
            return false;
        }
        return k.d(str, str5, true);
    }

    public void i(String str, byte[] bArr) {
        if (!TextUtils.isEmpty(str)) {
            k.d(ef(str), str, bArr);
        }
    }

    private void u(File file) {
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    u(file2);
                    file2.delete();
                } else if (!file2.delete()) {
                }
            }
        }
    }

    public void vL() {
        u(new File(k.wB + "/" + TbConfig.getTempDirName() + "/image"));
        u(new File(k.wB + "/" + TbConfig.getTempDirName() + "/" + TbConfig.IMAGE_CACHE_DIR_NAME));
    }

    public void vM() {
        v(new File(k.wB + "/" + TbConfig.getTempDirName() + "/" + k.cz(3)));
    }

    private void v(File file) {
        long currentTimeMillis = System.currentTimeMillis();
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    u(file2);
                    file2.delete();
                } else if (currentTimeMillis - file2.lastModified() >= -1702967296 && file2.delete()) {
                }
            }
        }
    }
}
