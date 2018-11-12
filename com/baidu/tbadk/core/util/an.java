package com.baidu.tbadk.core.util;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.tbadk.TbConfig;
import java.io.File;
/* loaded from: classes.dex */
public class an {
    private static an ayL;

    public static synchronized an CH() {
        an anVar;
        synchronized (an.class) {
            if (ayL == null) {
                ayL = new an();
            }
            anVar = ayL;
        }
        return anVar;
    }

    public String fl(String str) {
        if (str == null) {
            return null;
        }
        long j = 0;
        for (byte b : str.getBytes()) {
            j += b;
        }
        return "image/" + (j % 20);
    }

    public Bitmap eQ(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return l.au(fl(str), str);
    }

    public boolean fm(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return l.at(fl(str), str);
    }

    public int fn(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        return (int) l.as(fl(str), str);
    }

    public boolean copyFile(String str, String str2) {
        String str3 = l.FL + "/" + TbConfig.getTempDirName() + "/";
        if (!l.ez(str3)) {
            l.eW(str3);
        }
        String str4 = str3 + fl(str2);
        if (!l.ez(str4)) {
            l.eW(str4);
        }
        String str5 = str4 + "/" + str2;
        if (str.equals(str5)) {
            return false;
        }
        return l.d(str, str5, true);
    }

    public void i(String str, byte[] bArr) {
        if (!TextUtils.isEmpty(str)) {
            l.d(fl(str), str, bArr);
        }
    }

    private void A(File file) {
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    A(file2);
                    file2.delete();
                } else if (!file2.delete()) {
                }
            }
        }
    }

    public void CI() {
        A(new File(l.FL + "/" + TbConfig.getTempDirName() + "/image"));
        A(new File(l.FL + "/" + TbConfig.getTempDirName() + "/" + TbConfig.IMAGE_CACHE_DIR_NAME));
    }

    public void CJ() {
        B(new File(l.FL + "/" + TbConfig.getTempDirName() + "/" + l.dm(3)));
    }

    private void B(File file) {
        long currentTimeMillis = System.currentTimeMillis();
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    A(file2);
                    file2.delete();
                } else if (currentTimeMillis - file2.lastModified() >= -1702967296 && file2.delete()) {
                }
            }
        }
    }
}
