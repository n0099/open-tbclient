package com.baidu.tbadk.core.util;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.tbadk.TbConfig;
import java.io.File;
/* loaded from: classes.dex */
public class bc {
    private static bc Vn;

    public static synchronized bc sT() {
        bc bcVar;
        synchronized (bc.class) {
            if (Vn == null) {
                Vn = new bc();
            }
            bcVar = Vn;
        }
        return bcVar;
    }

    public String cK(String str) {
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
        return o.Y(cK(str), str);
    }

    public boolean cL(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return o.X(cK(str), str);
    }

    public int cM(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        return (int) o.W(cK(str), str);
    }

    public boolean copyFile(String str, String str2) {
        String str3 = o.yl + "/" + TbConfig.getTempDirName() + "/";
        if (!o.cj(str3)) {
            o.aG(str3);
        }
        String str4 = String.valueOf(str3) + cK(str2);
        if (!o.cj(str4)) {
            o.aG(str4);
        }
        String str5 = String.valueOf(str4) + "/" + str2;
        if (str.equals(str5)) {
            return false;
        }
        return o.c(str, str5, true);
    }

    public void h(String str, byte[] bArr) {
        if (!TextUtils.isEmpty(str)) {
            o.f(cK(str), str, bArr);
        }
    }

    private void q(File file) {
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    q(file2);
                    file2.delete();
                } else {
                    file2.delete();
                }
            }
        }
    }

    public void sU() {
        q(new File(o.yl + "/" + TbConfig.getTempDirName() + "/" + TbConfig.TMP_PIC_DIR_NAME));
        q(new File(o.yl + "/" + TbConfig.getTempDirName() + "/" + TbConfig.IMAGE_CACHE_DIR_NAME));
    }

    public void sV() {
        r(new File(o.yl + "/" + TbConfig.getTempDirName() + "/" + o.bS(3)));
    }

    private void r(File file) {
        long currentTimeMillis = System.currentTimeMillis();
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    q(file2);
                    file2.delete();
                } else if (currentTimeMillis - file2.lastModified() >= -1702967296) {
                    file2.delete();
                }
            }
        }
    }
}
