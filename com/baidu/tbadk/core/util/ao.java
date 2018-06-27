package com.baidu.tbadk.core.util;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.tbadk.TbConfig;
import java.io.File;
/* loaded from: classes.dex */
public class ao {
    private static ao arn;

    public static synchronized ao zz() {
        ao aoVar;
        synchronized (ao.class) {
            if (arn == null) {
                arn = new ao();
            }
            aoVar = arn;
        }
        return aoVar;
    }

    public String eH(String str) {
        if (str == null) {
            return null;
        }
        long j = 0;
        for (byte b : str.getBytes()) {
            j += b;
        }
        return "image/" + (j % 20);
    }

    public Bitmap ek(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return l.ab(eH(str), str);
    }

    public boolean eI(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return l.aa(eH(str), str);
    }

    public int eJ(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        return (int) l.Z(eH(str), str);
    }

    public boolean ac(String str, String str2) {
        String str3 = l.CH + "/" + TbConfig.getTempDirName() + "/";
        if (!l.dU(str3)) {
            l.eq(str3);
        }
        String str4 = str3 + eH(str2);
        if (!l.dU(str4)) {
            l.eq(str4);
        }
        String str5 = str4 + "/" + str2;
        if (str.equals(str5)) {
            return false;
        }
        return l.d(str, str5, true);
    }

    public void i(String str, byte[] bArr) {
        if (!TextUtils.isEmpty(str)) {
            l.d(eH(str), str, bArr);
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

    public void zA() {
        u(new File(l.CH + "/" + TbConfig.getTempDirName() + "/" + TbConfig.TMP_PIC_DIR_NAME));
        u(new File(l.CH + "/" + TbConfig.getTempDirName() + "/" + TbConfig.IMAGE_CACHE_DIR_NAME));
    }

    public void zB() {
        v(new File(l.CH + "/" + TbConfig.getTempDirName() + "/" + l.cC(3)));
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
