package com.baidu.tbadk.core.util;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.tbadk.TbConfig;
import java.io.File;
/* loaded from: classes.dex */
public class ap {
    private static ap aaS;

    public static synchronized ap uz() {
        ap apVar;
        synchronized (ap.class) {
            if (aaS == null) {
                aaS = new ap();
            }
            apVar = aaS;
        }
        return apVar;
    }

    public String cX(String str) {
        long j = 0;
        for (byte b : str.getBytes()) {
            j += b;
        }
        return "image/" + (j % 20);
    }

    public Bitmap cY(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return n.ab(cX(str), str);
    }

    public boolean cZ(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return n.aa(cX(str), str);
    }

    public int da(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        return (int) n.Z(cX(str), str);
    }

    public boolean copyFile(String str, String str2) {
        String str3 = n.xV + "/" + TbConfig.getTempDirName() + "/";
        if (!n.cz(str3)) {
            n.cK(str3);
        }
        String str4 = String.valueOf(str3) + cX(str2);
        if (!n.cz(str4)) {
            n.cK(str4);
        }
        String str5 = String.valueOf(str4) + "/" + str2;
        if (str.equals(str5)) {
            return false;
        }
        return n.c(str, str5, true);
    }

    public void h(String str, byte[] bArr) {
        if (!TextUtils.isEmpty(str)) {
            n.f(cX(str), str, bArr);
        }
    }

    private void u(File file) {
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    u(file2);
                    file2.delete();
                } else {
                    file2.delete();
                }
            }
        }
    }

    public void uA() {
        u(new File(n.xV + "/" + TbConfig.getTempDirName() + "/" + TbConfig.TMP_PIC_DIR_NAME));
        u(new File(n.xV + "/" + TbConfig.getTempDirName() + "/" + TbConfig.IMAGE_CACHE_DIR_NAME));
    }

    public void uB() {
        v(new File(n.xV + "/" + TbConfig.getTempDirName() + "/" + n.cd(3)));
    }

    private void v(File file) {
        long currentTimeMillis = System.currentTimeMillis();
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    u(file2);
                    file2.delete();
                } else if (currentTimeMillis - file2.lastModified() >= -1702967296) {
                    file2.delete();
                }
            }
        }
    }
}
