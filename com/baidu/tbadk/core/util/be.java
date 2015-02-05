package com.baidu.tbadk.core.util;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.tbadk.TbConfig;
import java.io.File;
/* loaded from: classes.dex */
public class be {
    private static be Jz;

    public static synchronized be pw() {
        be beVar;
        synchronized (be.class) {
            if (Jz == null) {
                Jz = new be();
            }
            beVar = Jz;
        }
        return beVar;
    }

    public String cB(String str) {
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
        return s.X(cB(str), str);
    }

    public boolean cC(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return s.W(cB(str), str);
    }

    public int cD(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        return (int) s.V(cB(str), str);
    }

    public boolean copyFile(String str, String str2) {
        String str3 = s.mJ + "/" + TbConfig.getTempDirName() + "/";
        if (!s.cb(str3)) {
            s.ay(str3);
        }
        String str4 = String.valueOf(str3) + cB(str2);
        if (!s.cb(str4)) {
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
            s.e(cB(str), str, bArr);
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

    public void px() {
        q(new File(s.mJ + "/" + TbConfig.getTempDirName() + "/" + TbConfig.TMP_PIC_DIR_NAME));
        q(new File(s.mJ + "/" + TbConfig.getTempDirName() + "/" + TbConfig.IMAGE_CACHE_DIR_NAME));
    }

    public void py() {
        r(new File(s.mJ + "/" + TbConfig.getTempDirName() + "/" + s.bR(3)));
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
