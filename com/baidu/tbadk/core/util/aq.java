package com.baidu.tbadk.core.util;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.tbadk.TbConfig;
import java.io.File;
/* loaded from: classes.dex */
public class aq {
    private static aq aaY;

    public static synchronized aq uC() {
        aq aqVar;
        synchronized (aq.class) {
            if (aaY == null) {
                aaY = new aq();
            }
            aqVar = aaY;
        }
        return aqVar;
    }

    public String dh(String str) {
        long j = 0;
        for (byte b : str.getBytes()) {
            j += b;
        }
        return "image/" + (j % 20);
    }

    public Bitmap di(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return n.aa(dh(str), str);
    }

    public boolean dj(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return n.Z(dh(str), str);
    }

    public int dk(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        return (int) n.Y(dh(str), str);
    }

    public boolean copyFile(String str, String str2) {
        String str3 = n.xU + "/" + TbConfig.getTempDirName() + "/";
        if (!n.cF(str3)) {
            n.cS(str3);
        }
        String str4 = String.valueOf(str3) + dh(str2);
        if (!n.cF(str4)) {
            n.cS(str4);
        }
        String str5 = String.valueOf(str4) + "/" + str2;
        if (str.equals(str5)) {
            return false;
        }
        return n.c(str, str5, true);
    }

    public void h(String str, byte[] bArr) {
        if (!TextUtils.isEmpty(str)) {
            n.f(dh(str), str, bArr);
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

    public void uD() {
        t(new File(n.xU + "/" + TbConfig.getTempDirName() + "/" + TbConfig.TMP_PIC_DIR_NAME));
        t(new File(n.xU + "/" + TbConfig.getTempDirName() + "/" + TbConfig.IMAGE_CACHE_DIR_NAME));
    }

    public void uE() {
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
