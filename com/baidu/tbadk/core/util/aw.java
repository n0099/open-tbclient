package com.baidu.tbadk.core.util;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.tbadk.TbConfig;
import java.io.File;
/* loaded from: classes.dex */
public class aw {
    private static aw acy;

    public static synchronized aw uU() {
        aw awVar;
        synchronized (aw.class) {
            if (acy == null) {
                acy = new aw();
            }
            awVar = acy;
        }
        return awVar;
    }

    public String dv(String str) {
        long j = 0;
        for (byte b : str.getBytes()) {
            j += b;
        }
        return "image/" + (j % 20);
    }

    public Bitmap dw(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return n.W(dv(str), str);
    }

    public boolean dx(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return n.V(dv(str), str);
    }

    public int dy(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        return (int) n.U(dv(str), str);
    }

    public boolean copyFile(String str, String str2) {
        String str3 = n.yc + "/" + TbConfig.getTempDirName() + "/";
        if (!n.cR(str3)) {
            n.de(str3);
        }
        String str4 = String.valueOf(str3) + dv(str2);
        if (!n.cR(str4)) {
            n.de(str4);
        }
        String str5 = String.valueOf(str4) + "/" + str2;
        if (str.equals(str5)) {
            return false;
        }
        return n.c(str, str5, true);
    }

    public void h(String str, byte[] bArr) {
        if (!TextUtils.isEmpty(str)) {
            n.f(dv(str), str, bArr);
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

    public void uV() {
        u(new File(n.yc + "/" + TbConfig.getTempDirName() + "/" + TbConfig.TMP_PIC_DIR_NAME));
        u(new File(n.yc + "/" + TbConfig.getTempDirName() + "/" + TbConfig.IMAGE_CACHE_DIR_NAME));
    }

    public void uW() {
        v(new File(n.yc + "/" + TbConfig.getTempDirName() + "/" + n.ck(3)));
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
