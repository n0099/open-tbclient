package com.baidu.tbadk.core.util;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.tbadk.TbConfig;
import java.io.File;
/* loaded from: classes.dex */
public class aw {
    private static aw acg;

    public static synchronized aw vw() {
        aw awVar;
        synchronized (aw.class) {
            if (acg == null) {
                acg = new aw();
            }
            awVar = acg;
        }
        return awVar;
    }

    public String dB(String str) {
        long j = 0;
        for (byte b : str.getBytes()) {
            j += b;
        }
        return "image/" + (j % 20);
    }

    public Bitmap dC(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return m.X(dB(str), str);
    }

    public boolean dD(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return m.W(dB(str), str);
    }

    public int dE(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        return (int) m.V(dB(str), str);
    }

    public boolean ac(String str, String str2) {
        String str3 = m.rC + "/" + TbConfig.getTempDirName() + "/";
        if (!m.cV(str3)) {
            m.di(str3);
        }
        String str4 = String.valueOf(str3) + dB(str2);
        if (!m.cV(str4)) {
            m.di(str4);
        }
        String str5 = String.valueOf(str4) + "/" + str2;
        if (str.equals(str5)) {
            return false;
        }
        return m.b(str, str5, true);
    }

    public void h(String str, byte[] bArr) {
        if (!TextUtils.isEmpty(str)) {
            m.d(dB(str), str, bArr);
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

    public void vx() {
        s(new File(m.rC + "/" + TbConfig.getTempDirName() + "/" + TbConfig.TMP_PIC_DIR_NAME));
        s(new File(m.rC + "/" + TbConfig.getTempDirName() + "/" + TbConfig.IMAGE_CACHE_DIR_NAME));
    }

    public void vy() {
        t(new File(m.rC + "/" + TbConfig.getTempDirName() + "/" + m.cB(3)));
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
