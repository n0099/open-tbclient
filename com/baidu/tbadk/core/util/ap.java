package com.baidu.tbadk.core.util;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.tbadk.TbConfig;
import java.io.File;
/* loaded from: classes.dex */
public class ap {
    private static ap cWb;

    public static synchronized ap aDU() {
        ap apVar;
        synchronized (ap.class) {
            if (cWb == null) {
                cWb = new ap();
            }
            apVar = cWb;
        }
        return apVar;
    }

    public String tc(String str) {
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
        return m.getImage(tc(str), str);
    }

    public boolean isGif(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return m.isGif(tc(str), str);
    }

    public int td(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        return (int) m.checkImageFileSize(tc(str), str);
    }

    public boolean copyFile(String str, String str2) {
        String str3 = m.EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/";
        if (!m.CheckTempDir(str3)) {
            m.makeRootDirectory(str3);
        }
        String str4 = str3 + tc(str2);
        if (!m.CheckTempDir(str4)) {
            m.makeRootDirectory(str4);
        }
        String str5 = str4 + "/" + str2;
        if (str.equals(str5)) {
            return false;
        }
        return m.t(str, str5, true);
    }

    public void j(String str, byte[] bArr) {
        if (!TextUtils.isEmpty(str)) {
            m.c(tc(str), str, bArr);
        }
    }

    private void D(File file) {
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    D(file2);
                    file2.delete();
                } else if (!file2.delete()) {
                }
            }
        }
    }

    public void aDV() {
        E(new File(m.EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/" + m.getPrefixByType(3)));
    }

    private void E(File file) {
        long currentTimeMillis = System.currentTimeMillis();
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    D(file2);
                    file2.delete();
                } else if (currentTimeMillis - file2.lastModified() >= -1702967296 && file2.delete()) {
                }
            }
        }
    }
}
