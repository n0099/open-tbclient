package com.baidu.tbadk.core.util;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.tbadk.TbConfig;
import java.io.File;
/* loaded from: classes.dex */
public class at {
    private static at afG;

    public static synchronized at vi() {
        at atVar;
        synchronized (at.class) {
            if (afG == null) {
                afG = new at();
            }
            atVar = afG;
        }
        return atVar;
    }

    public String dt(String str) {
        long j = 0;
        for (byte b : str.getBytes()) {
            j += b;
        }
        return "image/" + (j % 20);
    }

    public Bitmap du(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return l.W(dt(str), str);
    }

    public boolean dv(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return l.V(dt(str), str);
    }

    public int dw(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        return (int) l.U(dt(str), str);
    }

    public boolean ab(String str, String str2) {
        String str3 = l.yu + "/" + TbConfig.getTempDirName() + "/";
        if (!l.cS(str3)) {
            l.df(str3);
        }
        String str4 = String.valueOf(str3) + dt(str2);
        if (!l.cS(str4)) {
            l.df(str4);
        }
        String str5 = String.valueOf(str4) + "/" + str2;
        if (str.equals(str5)) {
            return false;
        }
        return l.c(str, str5, true);
    }

    public void h(String str, byte[] bArr) {
        if (!TextUtils.isEmpty(str)) {
            l.d(dt(str), str, bArr);
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

    public void vj() {
        t(new File(l.yu + "/" + TbConfig.getTempDirName() + "/" + TbConfig.TMP_PIC_DIR_NAME));
        t(new File(l.yu + "/" + TbConfig.getTempDirName() + "/" + TbConfig.IMAGE_CACHE_DIR_NAME));
    }

    public void vk() {
        u(new File(l.yu + "/" + TbConfig.getTempDirName() + "/" + l.cy(3)));
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
