package com.baidu.tbadk.core.util;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.tbadk.TbConfig;
import java.io.File;
/* loaded from: classes.dex */
public class an {
    private static an aCl;

    public static synchronized an DL() {
        an anVar;
        synchronized (an.class) {
            if (aCl == null) {
                aCl = new an();
            }
            anVar = aCl;
        }
        return anVar;
    }

    public String fD(String str) {
        if (str == null) {
            return null;
        }
        long j = 0;
        for (byte b : str.getBytes()) {
            j += b;
        }
        return "image/" + (j % 20);
    }

    public Bitmap fi(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return l.ax(fD(str), str);
    }

    public boolean fE(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return l.aw(fD(str), str);
    }

    public int fF(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        return (int) l.av(fD(str), str);
    }

    public boolean copyFile(String str, String str2) {
        String str3 = l.FL + "/" + TbConfig.getTempDirName() + "/";
        if (!l.eR(str3)) {
            l.fo(str3);
        }
        String str4 = str3 + fD(str2);
        if (!l.eR(str4)) {
            l.fo(str4);
        }
        String str5 = str4 + "/" + str2;
        if (str.equals(str5)) {
            return false;
        }
        return l.d(str, str5, true);
    }

    public void i(String str, byte[] bArr) {
        if (!TextUtils.isEmpty(str)) {
            l.d(fD(str), str, bArr);
        }
    }

    private void B(File file) {
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    B(file2);
                    file2.delete();
                } else if (!file2.delete()) {
                }
            }
        }
    }

    public void DM() {
        B(new File(l.FL + "/" + TbConfig.getTempDirName() + "/image"));
        B(new File(l.FL + "/" + TbConfig.getTempDirName() + "/" + TbConfig.IMAGE_CACHE_DIR_NAME));
    }

    public void DN() {
        C(new File(l.FL + "/" + TbConfig.getTempDirName() + "/" + l.dA(3)));
    }

    private void C(File file) {
        long currentTimeMillis = System.currentTimeMillis();
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    B(file2);
                    file2.delete();
                } else if (currentTimeMillis - file2.lastModified() >= -1702967296 && file2.delete()) {
                }
            }
        }
    }
}
