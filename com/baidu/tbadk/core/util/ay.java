package com.baidu.tbadk.core.util;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.tbadk.TbConfig;
import java.io.File;
/* loaded from: classes.dex */
public class ay {
    private static ay abI;

    public static synchronized ay vs() {
        ay ayVar;
        synchronized (ay.class) {
            if (abI == null) {
                abI = new ay();
            }
            ayVar = abI;
        }
        return ayVar;
    }

    public String dz(String str) {
        long j = 0;
        for (byte b : str.getBytes()) {
            j += b;
        }
        return "image/" + (j % 20);
    }

    public Bitmap dA(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return m.X(dz(str), str);
    }

    public boolean dB(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return m.W(dz(str), str);
    }

    public int dC(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        return (int) m.V(dz(str), str);
    }

    public boolean ac(String str, String str2) {
        String str3 = m.rB + "/" + TbConfig.getTempDirName() + "/";
        if (!m.cT(str3)) {
            m.dg(str3);
        }
        String str4 = String.valueOf(str3) + dz(str2);
        if (!m.cT(str4)) {
            m.dg(str4);
        }
        String str5 = String.valueOf(str4) + "/" + str2;
        if (str.equals(str5)) {
            return false;
        }
        return m.b(str, str5, true);
    }

    public void h(String str, byte[] bArr) {
        if (!TextUtils.isEmpty(str)) {
            m.d(dz(str), str, bArr);
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

    public void vt() {
        s(new File(m.rB + "/" + TbConfig.getTempDirName() + "/" + TbConfig.TMP_PIC_DIR_NAME));
        s(new File(m.rB + "/" + TbConfig.getTempDirName() + "/" + TbConfig.IMAGE_CACHE_DIR_NAME));
    }

    public void vu() {
        t(new File(m.rB + "/" + TbConfig.getTempDirName() + "/" + m.cA(3)));
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
