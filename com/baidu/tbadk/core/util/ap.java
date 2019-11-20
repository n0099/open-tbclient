package com.baidu.tbadk.core.util;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.tbadk.TbConfig;
import java.io.File;
/* loaded from: classes.dex */
public class ap {
    private static ap cjr;

    public static synchronized ap amJ() {
        ap apVar;
        synchronized (ap.class) {
            if (cjr == null) {
                cjr = new ap();
            }
            apVar = cjr;
        }
        return apVar;
    }

    public String nQ(String str) {
        if (str == null) {
            return null;
        }
        long j = 0;
        for (byte b : str.getBytes()) {
            j += b;
        }
        return "image/" + (j % 20);
    }

    public Bitmap getImage(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return m.getImage(nQ(str), str);
    }

    public boolean isGif(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return m.isGif(nQ(str), str);
    }

    public int nR(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        return (int) m.checkImageFileSize(nQ(str), str);
    }

    public boolean copyFile(String str, String str2) {
        String str3 = m.EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/";
        if (!m.CheckTempDir(str3)) {
            m.makeRootDirectory(str3);
        }
        String str4 = str3 + nQ(str2);
        if (!m.CheckTempDir(str4)) {
            m.makeRootDirectory(str4);
        }
        String str5 = str4 + "/" + str2;
        if (str.equals(str5)) {
            return false;
        }
        return m.s(str, str5, true);
    }

    public void g(String str, byte[] bArr) {
        if (!TextUtils.isEmpty(str)) {
            m.c(nQ(str), str, bArr);
        }
    }

    private void r(File file) {
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    r(file2);
                    file2.delete();
                } else if (!file2.delete()) {
                }
            }
        }
    }

    public void amK() {
        s(new File(m.EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/" + m.getPrefixByType(3)));
    }

    private void s(File file) {
        long currentTimeMillis = System.currentTimeMillis();
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    r(file2);
                    file2.delete();
                } else if (currentTimeMillis - file2.lastModified() >= -1702967296 && file2.delete()) {
                }
            }
        }
    }
}
