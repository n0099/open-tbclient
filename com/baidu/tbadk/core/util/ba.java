package com.baidu.tbadk.core.util;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.tbadk.TbConfig;
import java.io.File;
/* loaded from: classes.dex */
public class ba {
    private static ba VU;

    public static synchronized ba tw() {
        ba baVar;
        synchronized (ba.class) {
            if (VU == null) {
                VU = new ba();
            }
            baVar = VU;
        }
        return baVar;
    }

    public String cY(String str) {
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
        return o.ac(cY(str), str);
    }

    public boolean cZ(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return o.ab(cY(str), str);
    }

    public int da(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        return (int) o.aa(cY(str), str);
    }

    public boolean copyFile(String str, String str2) {
        String str3 = o.ya + "/" + TbConfig.getTempDirName() + "/";
        if (!o.cy(str3)) {
            o.aP(str3);
        }
        String str4 = String.valueOf(str3) + cY(str2);
        if (!o.cy(str4)) {
            o.aP(str4);
        }
        String str5 = String.valueOf(str4) + "/" + str2;
        if (str.equals(str5)) {
            return false;
        }
        return o.c(str, str5, true);
    }

    public void h(String str, byte[] bArr) {
        if (!TextUtils.isEmpty(str)) {
            o.f(cY(str), str, bArr);
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

    public void tx() {
        s(new File(o.ya + "/" + TbConfig.getTempDirName() + "/" + TbConfig.TMP_PIC_DIR_NAME));
        s(new File(o.ya + "/" + TbConfig.getTempDirName() + "/" + TbConfig.IMAGE_CACHE_DIR_NAME));
    }

    public void ty() {
        t(new File(o.ya + "/" + TbConfig.getTempDirName() + "/" + o.bV(3)));
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
