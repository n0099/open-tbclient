package com.baidu.tbadk.core.util;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.tbadk.TbConfig;
import java.io.File;
/* loaded from: classes.dex */
public class al {
    private static al ahu;

    public static synchronized al vp() {
        al alVar;
        synchronized (al.class) {
            if (ahu == null) {
                ahu = new al();
            }
            alVar = ahu;
        }
        return alVar;
    }

    public String dP(String str) {
        if (str == null) {
            return null;
        }
        long j = 0;
        for (byte b : str.getBytes()) {
            j += b;
        }
        return "image/" + (j % 20);
    }

    public Bitmap dQ(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return k.X(dP(str), str);
    }

    public boolean dR(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return k.W(dP(str), str);
    }

    public int dS(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        return (int) k.V(dP(str), str);
    }

    public boolean Z(String str, String str2) {
        String str3 = k.xT + "/" + TbConfig.getTempDirName() + "/";
        if (!k.dh(str3)) {
            k.dy(str3);
        }
        String str4 = str3 + dP(str2);
        if (!k.dh(str4)) {
            k.dy(str4);
        }
        String str5 = str4 + "/" + str2;
        if (str.equals(str5)) {
            return false;
        }
        return k.c(str, str5, true);
    }

    public void i(String str, byte[] bArr) {
        if (!TextUtils.isEmpty(str)) {
            k.d(dP(str), str, bArr);
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

    public void vq() {
        v(new File(k.xT + "/" + TbConfig.getTempDirName() + "/" + TbConfig.TMP_PIC_DIR_NAME));
        v(new File(k.xT + "/" + TbConfig.getTempDirName() + "/" + TbConfig.IMAGE_CACHE_DIR_NAME));
    }

    public void vr() {
        w(new File(k.xT + "/" + TbConfig.getTempDirName() + "/" + k.cD(3)));
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
