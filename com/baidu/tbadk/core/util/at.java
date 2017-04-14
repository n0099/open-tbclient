package com.baidu.tbadk.core.util;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.tbadk.TbConfig;
import java.io.File;
/* loaded from: classes.dex */
public class at {
    private static at ago;

    public static synchronized at vU() {
        at atVar;
        synchronized (at.class) {
            if (ago == null) {
                ago = new at();
            }
            atVar = ago;
        }
        return atVar;
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
        return l.W(dv(str), str);
    }

    public boolean dx(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return l.V(dv(str), str);
    }

    public int dy(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        return (int) l.U(dv(str), str);
    }

    public boolean ab(String str, String str2) {
        String str3 = l.yq + "/" + TbConfig.getTempDirName() + "/";
        if (!l.cU(str3)) {
            l.dh(str3);
        }
        String str4 = String.valueOf(str3) + dv(str2);
        if (!l.cU(str4)) {
            l.dh(str4);
        }
        String str5 = String.valueOf(str4) + "/" + str2;
        if (str.equals(str5)) {
            return false;
        }
        return l.c(str, str5, true);
    }

    public void h(String str, byte[] bArr) {
        if (!TextUtils.isEmpty(str)) {
            l.d(dv(str), str, bArr);
        }
    }

    private void t(File file) {
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    t(file2);
                    file2.delete();
                } else {
                    file2.delete();
                }
            }
        }
    }

    public void vV() {
        t(new File(l.yq + "/" + TbConfig.getTempDirName() + "/" + TbConfig.TMP_PIC_DIR_NAME));
        t(new File(l.yq + "/" + TbConfig.getTempDirName() + "/" + TbConfig.IMAGE_CACHE_DIR_NAME));
    }

    public void vW() {
        u(new File(l.yq + "/" + TbConfig.getTempDirName() + "/" + l.cB(3)));
    }

    private void u(File file) {
        long currentTimeMillis = System.currentTimeMillis();
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    t(file2);
                    file2.delete();
                } else if (currentTimeMillis - file2.lastModified() >= -1702967296) {
                    file2.delete();
                }
            }
        }
    }
}
