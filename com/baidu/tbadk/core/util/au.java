package com.baidu.tbadk.core.util;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.tbadk.TbConfig;
import java.io.File;
/* loaded from: classes.dex */
public class au {
    private static au aby;

    public static synchronized au vg() {
        au auVar;
        synchronized (au.class) {
            if (aby == null) {
                aby = new au();
            }
            auVar = aby;
        }
        return auVar;
    }

    public String dy(String str) {
        long j = 0;
        for (byte b : str.getBytes()) {
            j += b;
        }
        return "image/" + (j % 20);
    }

    public Bitmap dz(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return m.X(dy(str), str);
    }

    public boolean dA(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return m.W(dy(str), str);
    }

    public int dB(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        return (int) m.V(dy(str), str);
    }

    public boolean ac(String str, String str2) {
        String str3 = m.rC + "/" + TbConfig.getTempDirName() + "/";
        if (!m.cW(str3)) {
            m.dj(str3);
        }
        String str4 = String.valueOf(str3) + dy(str2);
        if (!m.cW(str4)) {
            m.dj(str4);
        }
        String str5 = String.valueOf(str4) + "/" + str2;
        if (str.equals(str5)) {
            return false;
        }
        return m.b(str, str5, true);
    }

    public void h(String str, byte[] bArr) {
        if (!TextUtils.isEmpty(str)) {
            m.d(dy(str), str, bArr);
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

    public void vh() {
        s(new File(m.rC + "/" + TbConfig.getTempDirName() + "/" + TbConfig.TMP_PIC_DIR_NAME));
        s(new File(m.rC + "/" + TbConfig.getTempDirName() + "/" + TbConfig.IMAGE_CACHE_DIR_NAME));
    }

    public void vi() {
        t(new File(m.rC + "/" + TbConfig.getTempDirName() + "/" + m.cD(3)));
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
