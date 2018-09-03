package com.baidu.tbadk.core.util;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.tbadk.TbConfig;
import java.io.File;
/* loaded from: classes.dex */
public class ao {
    private static ao aqP;

    public static synchronized ao zo() {
        ao aoVar;
        synchronized (ao.class) {
            if (aqP == null) {
                aqP = new ao();
            }
            aoVar = aqP;
        }
        return aoVar;
    }

    public String eF(String str) {
        if (str == null) {
            return null;
        }
        long j = 0;
        for (byte b : str.getBytes()) {
            j += b;
        }
        return "image/" + (j % 20);
    }

    public Bitmap ei(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return l.aa(eF(str), str);
    }

    public boolean eG(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return l.Z(eF(str), str);
    }

    public int eH(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        return (int) l.Y(eF(str), str);
    }

    public boolean ab(String str, String str2) {
        String str3 = l.CD + "/" + TbConfig.getTempDirName() + "/";
        if (!l.dR(str3)) {
            l.eo(str3);
        }
        String str4 = str3 + eF(str2);
        if (!l.dR(str4)) {
            l.eo(str4);
        }
        String str5 = str4 + "/" + str2;
        if (str.equals(str5)) {
            return false;
        }
        return l.c(str, str5, true);
    }

    public void i(String str, byte[] bArr) {
        if (!TextUtils.isEmpty(str)) {
            l.d(eF(str), str, bArr);
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

    public void zp() {
        u(new File(l.CD + "/" + TbConfig.getTempDirName() + "/" + TbConfig.TMP_PIC_DIR_NAME));
        u(new File(l.CD + "/" + TbConfig.getTempDirName() + "/" + TbConfig.IMAGE_CACHE_DIR_NAME));
    }

    public void zq() {
        v(new File(l.CD + "/" + TbConfig.getTempDirName() + "/" + l.cE(3)));
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
