package com.baidu.tbadk.core.util;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.tbadk.TbConfig;
import java.io.File;
/* loaded from: classes.dex */
public class an {
    private static an atn;

    public static synchronized an At() {
        an anVar;
        synchronized (an.class) {
            if (atn == null) {
                atn = new an();
            }
            anVar = atn;
        }
        return anVar;
    }

    public String eX(String str) {
        if (str == null) {
            return null;
        }
        long j = 0;
        for (byte b : str.getBytes()) {
            j += b;
        }
        return "image/" + (j % 20);
    }

    public Bitmap eA(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return l.ah(eX(str), str);
    }

    public boolean eY(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return l.ag(eX(str), str);
    }

    public int eZ(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        return (int) l.af(eX(str), str);
    }

    public boolean ai(String str, String str2) {
        String str3 = l.EZ + "/" + TbConfig.getTempDirName() + "/";
        if (!l.ej(str3)) {
            l.eG(str3);
        }
        String str4 = str3 + eX(str2);
        if (!l.ej(str4)) {
            l.eG(str4);
        }
        String str5 = str4 + "/" + str2;
        if (str.equals(str5)) {
            return false;
        }
        return l.c(str, str5, true);
    }

    public void i(String str, byte[] bArr) {
        if (!TextUtils.isEmpty(str)) {
            l.d(eX(str), str, bArr);
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

    public void Au() {
        A(new File(l.EZ + "/" + TbConfig.getTempDirName() + "/" + TbConfig.TMP_PIC_DIR_NAME));
        A(new File(l.EZ + "/" + TbConfig.getTempDirName() + "/" + TbConfig.IMAGE_CACHE_DIR_NAME));
    }

    public void Av() {
        B(new File(l.EZ + "/" + TbConfig.getTempDirName() + "/" + l.cO(3)));
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
