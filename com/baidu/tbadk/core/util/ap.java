package com.baidu.tbadk.core.util;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.tbadk.TbConfig;
import java.io.File;
/* loaded from: classes.dex */
public class ap {
    private static ap bUh;

    public static synchronized ap ajr() {
        ap apVar;
        synchronized (ap.class) {
            if (bUh == null) {
                bUh = new ap();
            }
            apVar = bUh;
        }
        return apVar;
    }

    public String nY(String str) {
        if (str == null) {
            return null;
        }
        long j = 0;
        for (byte b : str.getBytes()) {
            j += b;
        }
        return "image/" + (j % 20);
    }

    public Bitmap nB(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return m.bP(nY(str), str);
    }

    public boolean nZ(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return m.bO(nY(str), str);
    }

    public int oa(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        return (int) m.bN(nY(str), str);
    }

    public boolean bQ(String str, String str2) {
        String str3 = m.Dz + "/" + TbConfig.getTempDirName() + "/";
        if (!m.nj(str3)) {
            m.nG(str3);
        }
        String str4 = str3 + nY(str2);
        if (!m.nj(str4)) {
            m.nG(str4);
        }
        String str5 = str4 + "/" + str2;
        if (str.equals(str5)) {
            return false;
        }
        return m.p(str, str5, true);
    }

    public void h(String str, byte[] bArr) {
        if (!TextUtils.isEmpty(str)) {
            m.c(nY(str), str, bArr);
        }
    }

    private void E(File file) {
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    E(file2);
                    file2.delete();
                } else if (!file2.delete()) {
                }
            }
        }
    }

    public void ajs() {
        F(new File(m.Dz + "/" + TbConfig.getTempDirName() + "/" + m.hV(3)));
    }

    private void F(File file) {
        long currentTimeMillis = System.currentTimeMillis();
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    E(file2);
                    file2.delete();
                } else if (currentTimeMillis - file2.lastModified() >= -1702967296 && file2.delete()) {
                }
            }
        }
    }
}
