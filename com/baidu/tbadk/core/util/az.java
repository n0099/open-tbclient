package com.baidu.tbadk.core.util;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.tbadk.TbConfig;
import java.io.File;
/* loaded from: classes.dex */
public class az {
    private static az Jj;

    public static synchronized az ps() {
        az azVar;
        synchronized (az.class) {
            if (Jj == null) {
                Jj = new az();
            }
            azVar = Jj;
        }
        return azVar;
    }

    public String cF(String str) {
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
        return s.U(cF(str), str);
    }

    public boolean cG(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return s.T(cF(str), str);
    }

    public int cH(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        return (int) s.S(cF(str), str);
    }

    public boolean copyFile(String str, String str2) {
        String str3 = s.mG + "/" + TbConfig.getTempDirName() + "/";
        if (!s.cg(str3)) {
            s.ay(str3);
        }
        String str4 = String.valueOf(str3) + cF(str2);
        if (!s.cg(str4)) {
            s.ay(str4);
        }
        String str5 = String.valueOf(str4) + "/" + str2;
        if (str.equals(str5)) {
            return false;
        }
        return s.c(str, str5, true);
    }

    public void h(String str, byte[] bArr) {
        if (!TextUtils.isEmpty(str)) {
            s.e(cF(str), str, bArr);
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

    public void pt() {
        o(new File(s.mG + "/" + TbConfig.getTempDirName() + "/" + TbConfig.TMP_PIC_DIR_NAME));
        o(new File(s.mG + "/" + TbConfig.getTempDirName() + "/" + TbConfig.IMAGE_CACHE_DIR_NAME));
    }

    public void pu() {
        p(new File(s.mG + "/" + TbConfig.getTempDirName() + "/" + s.bM(3)));
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
