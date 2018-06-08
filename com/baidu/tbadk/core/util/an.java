package com.baidu.tbadk.core.util;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.tbadk.TbConfig;
import java.io.File;
/* loaded from: classes.dex */
public class an {
    private static an aqK;

    public static synchronized an zk() {
        an anVar;
        synchronized (an.class) {
            if (aqK == null) {
                aqK = new an();
            }
            anVar = aqK;
        }
        return anVar;
    }

    public String eE(String str) {
        if (str == null) {
            return null;
        }
        long j = 0;
        for (byte b : str.getBytes()) {
            j += b;
        }
        return "image/" + (j % 20);
    }

    public Bitmap eh(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return l.ab(eE(str), str);
    }

    public boolean eF(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return l.aa(eE(str), str);
    }

    public int eG(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        return (int) l.Z(eE(str), str);
    }

    public boolean ac(String str, String str2) {
        String str3 = l.CF + "/" + TbConfig.getTempDirName() + "/";
        if (!l.dR(str3)) {
            l.en(str3);
        }
        String str4 = str3 + eE(str2);
        if (!l.dR(str4)) {
            l.en(str4);
        }
        String str5 = str4 + "/" + str2;
        if (str.equals(str5)) {
            return false;
        }
        return l.d(str, str5, true);
    }

    public void i(String str, byte[] bArr) {
        if (!TextUtils.isEmpty(str)) {
            l.d(eE(str), str, bArr);
        }
    }

    private void u(File file) {
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    u(file2);
                    file2.delete();
                } else if (!file2.delete()) {
                }
            }
        }
    }

    public void zl() {
        u(new File(l.CF + "/" + TbConfig.getTempDirName() + "/image"));
        u(new File(l.CF + "/" + TbConfig.getTempDirName() + "/" + TbConfig.IMAGE_CACHE_DIR_NAME));
    }

    public void zm() {
        v(new File(l.CF + "/" + TbConfig.getTempDirName() + "/" + l.cB(3)));
    }

    private void v(File file) {
        long currentTimeMillis = System.currentTimeMillis();
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    u(file2);
                    file2.delete();
                } else if (currentTimeMillis - file2.lastModified() >= -1702967296 && file2.delete()) {
                }
            }
        }
    }
}
