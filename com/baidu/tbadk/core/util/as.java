package com.baidu.tbadk.core.util;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.tbadk.TbConfig;
import java.io.File;
/* loaded from: classes.dex */
public class as {
    private static as aaJ;

    public static synchronized as va() {
        as asVar;
        synchronized (as.class) {
            if (aaJ == null) {
                aaJ = new as();
            }
            asVar = aaJ;
        }
        return asVar;
    }

    public String dw(String str) {
        long j = 0;
        for (byte b : str.getBytes()) {
            j += b;
        }
        return "image/" + (j % 20);
    }

    public Bitmap dx(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return l.X(dw(str), str);
    }

    public boolean dy(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return l.W(dw(str), str);
    }

    public int dz(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        return (int) l.V(dw(str), str);
    }

    public boolean ac(String str, String str2) {
        String str3 = l.ru + "/" + TbConfig.getTempDirName() + "/";
        if (!l.cU(str3)) {
            l.dh(str3);
        }
        String str4 = String.valueOf(str3) + dw(str2);
        if (!l.cU(str4)) {
            l.dh(str4);
        }
        String str5 = String.valueOf(str4) + "/" + str2;
        if (str.equals(str5)) {
            return false;
        }
        return l.b(str, str5, true);
    }

    public void h(String str, byte[] bArr) {
        if (!TextUtils.isEmpty(str)) {
            l.d(dw(str), str, bArr);
        }
    }

    private void s(File file) {
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    s(file2);
                    file2.delete();
                } else {
                    file2.delete();
                }
            }
        }
    }

    public void vb() {
        s(new File(l.ru + "/" + TbConfig.getTempDirName() + "/" + TbConfig.TMP_PIC_DIR_NAME));
        s(new File(l.ru + "/" + TbConfig.getTempDirName() + "/" + TbConfig.IMAGE_CACHE_DIR_NAME));
    }

    public void vc() {
        t(new File(l.ru + "/" + TbConfig.getTempDirName() + "/" + l.cC(3)));
    }

    private void t(File file) {
        long currentTimeMillis = System.currentTimeMillis();
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    s(file2);
                    file2.delete();
                } else if (currentTimeMillis - file2.lastModified() >= -1702967296) {
                    file2.delete();
                }
            }
        }
    }
}
