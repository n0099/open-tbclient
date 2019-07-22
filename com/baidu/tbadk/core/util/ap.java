package com.baidu.tbadk.core.util;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.tbadk.TbConfig;
import com.sina.weibo.sdk.utils.FileUtils;
import java.io.File;
/* loaded from: classes.dex */
public class ap {
    private static ap bTy;

    public static synchronized ap ajj() {
        ap apVar;
        synchronized (ap.class) {
            if (bTy == null) {
                bTy = new ap();
            }
            apVar = bTy;
        }
        return apVar;
    }

    public String nW(String str) {
        if (str == null) {
            return null;
        }
        long j = 0;
        for (byte b : str.getBytes()) {
            j += b;
        }
        return FileUtils.IMAGE_FILE_START + (j % 20);
    }

    public Bitmap nz(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return m.bP(nW(str), str);
    }

    public boolean nX(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return m.bO(nW(str), str);
    }

    public int nY(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        return (int) m.bN(nW(str), str);
    }

    public boolean bQ(String str, String str2) {
        String str3 = m.Dz + "/" + TbConfig.getTempDirName() + "/";
        if (!m.nh(str3)) {
            m.nE(str3);
        }
        String str4 = str3 + nW(str2);
        if (!m.nh(str4)) {
            m.nE(str4);
        }
        String str5 = str4 + "/" + str2;
        if (str.equals(str5)) {
            return false;
        }
        return m.p(str, str5, true);
    }

    public void h(String str, byte[] bArr) {
        if (!TextUtils.isEmpty(str)) {
            m.c(nW(str), str, bArr);
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

    public void ajk() {
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
