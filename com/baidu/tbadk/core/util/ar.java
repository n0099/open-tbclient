package com.baidu.tbadk.core.util;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.tbadk.TbConfig;
import java.io.File;
/* loaded from: classes.dex */
public class ar {
    private static ar ebg;

    public static synchronized ar baP() {
        ar arVar;
        synchronized (ar.class) {
            if (ebg == null) {
                ebg = new ar();
            }
            arVar = ebg;
        }
        return arVar;
    }

    public String xQ(String str) {
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
        return n.getImage(xQ(str), str);
    }

    public boolean isGif(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return n.isGif(xQ(str), str);
    }

    public int xR(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        return (int) n.checkImageFileSize(xQ(str), str);
    }

    public boolean copyFile(String str, String str2) {
        String str3 = n.EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/";
        if (!n.CheckTempDir(str3)) {
            n.makeRootDirectory(str3);
        }
        String str4 = str3 + xQ(str2);
        if (!n.CheckTempDir(str4)) {
            n.makeRootDirectory(str4);
        }
        String str5 = str4 + "/" + str2;
        if (str.equals(str5)) {
            return false;
        }
        return n.v(str, str5, true);
    }

    public void j(String str, byte[] bArr) {
        if (!TextUtils.isEmpty(str)) {
            n.c(xQ(str), str, bArr);
        }
    }

    private void N(File file) {
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    N(file2);
                    file2.delete();
                } else if (!file2.delete()) {
                }
            }
        }
    }

    public void baQ() {
        O(new File(n.EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/" + n.getPrefixByType(3)));
    }

    private void O(File file) {
        long currentTimeMillis = System.currentTimeMillis();
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    N(file2);
                    file2.delete();
                } else if (currentTimeMillis - file2.lastModified() >= -1702967296 && file2.delete()) {
                }
            }
        }
    }
}
