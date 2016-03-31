package com.baidu.tbadk.core.util;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.tbadk.TbConfig;
import java.io.File;
/* loaded from: classes.dex */
public class ax {
    private static ax acg;

    public static synchronized ax ws() {
        ax axVar;
        synchronized (ax.class) {
            if (acg == null) {
                acg = new ax();
            }
            axVar = acg;
        }
        return axVar;
    }

    public String dv(String str) {
        long j = 0;
        for (byte b : str.getBytes()) {
            j += b;
        }
        return "image/" + (j % 20);
    }

    public Bitmap dw(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return m.Y(dv(str), str);
    }

    public boolean dx(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return m.X(dv(str), str);
    }

    public int dy(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        return (int) m.W(dv(str), str);
    }

    public boolean ad(String str, String str2) {
        String str3 = m.yB + "/" + TbConfig.getTempDirName() + "/";
        if (!m.cR(str3)) {
            m.df(str3);
        }
        String str4 = String.valueOf(str3) + dv(str2);
        if (!m.cR(str4)) {
            m.df(str4);
        }
        String str5 = String.valueOf(str4) + "/" + str2;
        if (str.equals(str5)) {
            return false;
        }
        return m.c(str, str5, true);
    }

    public void g(String str, byte[] bArr) {
        if (!TextUtils.isEmpty(str)) {
            m.e(dv(str), str, bArr);
        }
    }

    private void s(File file) {
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    s(file2);
                    file2.delete();
                } else {
                    file2.delete();
                }
            }
        }
    }

    public void wt() {
        s(new File(m.yB + "/" + TbConfig.getTempDirName() + "/" + TbConfig.TMP_PIC_DIR_NAME));
        s(new File(m.yB + "/" + TbConfig.getTempDirName() + "/" + TbConfig.IMAGE_CACHE_DIR_NAME));
    }

    public void wu() {
        t(new File(m.yB + "/" + TbConfig.getTempDirName() + "/" + m.cE(3)));
    }

    private void t(File file) {
        long currentTimeMillis = System.currentTimeMillis();
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    s(file2);
                    file2.delete();
                } else if (currentTimeMillis - file2.lastModified() >= -1702967296) {
                    file2.delete();
                }
            }
        }
    }
}
