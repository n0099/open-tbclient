package com.baidu.tbadk.core.util;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.tbadk.TbConfig;
import java.io.File;
/* loaded from: classes.dex */
public class ap {
    private static ap dNX;

    public static synchronized ap aUT() {
        ap apVar;
        synchronized (ap.class) {
            if (dNX == null) {
                dNX = new ap();
            }
            apVar = dNX;
        }
        return apVar;
    }

    public String ws(String str) {
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
        return m.getImage(ws(str), str);
    }

    public boolean isGif(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return m.isGif(ws(str), str);
    }

    public int wt(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        return (int) m.checkImageFileSize(ws(str), str);
    }

    public boolean copyFile(String str, String str2) {
        String str3 = m.EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/";
        if (!m.CheckTempDir(str3)) {
            m.makeRootDirectory(str3);
        }
        String str4 = str3 + ws(str2);
        if (!m.CheckTempDir(str4)) {
            m.makeRootDirectory(str4);
        }
        String str5 = str4 + "/" + str2;
        if (str.equals(str5)) {
            return false;
        }
        return m.v(str, str5, true);
    }

    public void j(String str, byte[] bArr) {
        if (!TextUtils.isEmpty(str)) {
            m.c(ws(str), str, bArr);
        }
    }

    private void J(File file) {
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    J(file2);
                    file2.delete();
                } else if (!file2.delete()) {
                }
            }
        }
    }

    public void aUU() {
        K(new File(m.EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/" + m.getPrefixByType(3)));
    }

    private void K(File file) {
        long currentTimeMillis = System.currentTimeMillis();
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    J(file2);
                    file2.delete();
                } else if (currentTimeMillis - file2.lastModified() >= -1702967296 && file2.delete()) {
                }
            }
        }
    }
}
