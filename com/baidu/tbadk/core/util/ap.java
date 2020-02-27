package com.baidu.tbadk.core.util;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.tbadk.TbConfig;
import java.io.File;
/* loaded from: classes.dex */
public class ap {
    private static ap dan;

    public static synchronized ap aGy() {
        ap apVar;
        synchronized (ap.class) {
            if (dan == null) {
                dan = new ap();
            }
            apVar = dan;
        }
        return apVar;
    }

    public String tw(String str) {
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
        return m.getImage(tw(str), str);
    }

    public boolean isGif(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return m.isGif(tw(str), str);
    }

    public int tx(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        return (int) m.checkImageFileSize(tw(str), str);
    }

    public boolean copyFile(String str, String str2) {
        String str3 = m.EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/";
        if (!m.CheckTempDir(str3)) {
            m.makeRootDirectory(str3);
        }
        String str4 = str3 + tw(str2);
        if (!m.CheckTempDir(str4)) {
            m.makeRootDirectory(str4);
        }
        String str5 = str4 + "/" + str2;
        if (str.equals(str5)) {
            return false;
        }
        return m.u(str, str5, true);
    }

    public void j(String str, byte[] bArr) {
        if (!TextUtils.isEmpty(str)) {
            m.c(tw(str), str, bArr);
        }
    }

    private void F(File file) {
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    F(file2);
                    file2.delete();
                } else if (!file2.delete()) {
                }
            }
        }
    }

    public void aGz() {
        G(new File(m.EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/" + m.getPrefixByType(3)));
    }

    private void G(File file) {
        long currentTimeMillis = System.currentTimeMillis();
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    F(file2);
                    file2.delete();
                } else if (currentTimeMillis - file2.lastModified() >= -1702967296 && file2.delete()) {
                }
            }
        }
    }
}
