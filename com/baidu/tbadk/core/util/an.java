package com.baidu.tbadk.core.util;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.tbadk.TbConfig;
import com.sina.weibo.sdk.utils.FileUtils;
import java.io.File;
/* loaded from: classes.dex */
public class an {
    private static an aCN;

    public static synchronized an DZ() {
        an anVar;
        synchronized (an.class) {
            if (aCN == null) {
                aCN = new an();
            }
            anVar = aCN;
        }
        return anVar;
    }

    public String fQ(String str) {
        if (str == null) {
            return null;
        }
        long j = 0;
        for (byte b : str.getBytes()) {
            j += b;
        }
        return FileUtils.IMAGE_FILE_START + (j % 20);
    }

    public Bitmap fs(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return l.ay(fQ(str), str);
    }

    public boolean fR(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return l.ax(fQ(str), str);
    }

    public int fS(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        return (int) l.aw(fQ(str), str);
    }

    public boolean copyFile(String str, String str2) {
        String str3 = l.FL + "/" + TbConfig.getTempDirName() + "/";
        if (!l.fa(str3)) {
            l.fy(str3);
        }
        String str4 = str3 + fQ(str2);
        if (!l.fa(str4)) {
            l.fy(str4);
        }
        String str5 = str4 + "/" + str2;
        if (str.equals(str5)) {
            return false;
        }
        return l.d(str, str5, true);
    }

    public void i(String str, byte[] bArr) {
        if (!TextUtils.isEmpty(str)) {
            l.d(fQ(str), str, bArr);
        }
    }

    private void C(File file) {
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    C(file2);
                    file2.delete();
                } else if (!file2.delete()) {
                }
            }
        }
    }

    public void Ea() {
        D(new File(l.FL + "/" + TbConfig.getTempDirName() + "/" + l.dA(3)));
    }

    private void D(File file) {
        long currentTimeMillis = System.currentTimeMillis();
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    C(file2);
                    file2.delete();
                } else if (currentTimeMillis - file2.lastModified() >= -1702967296 && file2.delete()) {
                }
            }
        }
    }
}
