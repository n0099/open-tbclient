package com.baidu.tbadk.core.util;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.tbadk.TbConfig;
import java.io.File;
/* loaded from: classes.dex */
public class ax {
    private static ax EY;

    public static synchronized ax my() {
        ax axVar;
        synchronized (ax.class) {
            if (EY == null) {
                EY = new ax();
            }
            axVar = EY;
        }
        return axVar;
    }

    public String bM(String str) {
        long j = 0;
        for (byte b : str.getBytes()) {
            j += b;
        }
        return "image/" + (j % 20);
    }

    public Bitmap bN(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return s.K(bM(str), str);
    }

    public boolean bO(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return s.J(bM(str), str);
    }

    public int bP(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        return (int) s.I(bM(str), str);
    }

    public boolean copyFile(String str, String str2) {
        String str3 = s.mI + "/" + TbConfig.getTempDirName() + "/";
        if (!s.bo(str3)) {
            s.av(str3);
        }
        String str4 = String.valueOf(str3) + bM(str2);
        if (!s.bo(str4)) {
            s.av(str4);
        }
        String str5 = String.valueOf(str4) + "/" + str2;
        if (str.equals(str5)) {
            return false;
        }
        return s.a(str, str5, true);
    }

    public void f(String str, byte[] bArr) {
        if (!TextUtils.isEmpty(str)) {
            s.b(bM(str), str, bArr);
        }
    }

    private void o(File file) {
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    o(file2);
                    file2.delete();
                } else {
                    file2.delete();
                }
            }
        }
    }

    public void mz() {
        o(new File(s.mI + "/" + TbConfig.getTempDirName() + "/" + TbConfig.TMP_PIC_DIR_NAME));
        o(new File(s.mI + "/" + TbConfig.getTempDirName() + "/" + TbConfig.IMAGE_CACHE_DIR_NAME));
    }

    public void mA() {
        p(new File(s.mI + "/" + TbConfig.getTempDirName() + "/" + s.bp(3)));
    }

    private void p(File file) {
        long currentTimeMillis = System.currentTimeMillis();
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    o(file2);
                    file2.delete();
                } else if (currentTimeMillis - file2.lastModified() >= -1702967296) {
                    file2.delete();
                }
            }
        }
    }
}
