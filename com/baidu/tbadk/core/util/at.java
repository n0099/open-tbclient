package com.baidu.tbadk.core.util;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.tbadk.TbConfig;
import java.io.File;
/* loaded from: classes.dex */
public class at {
    private static at afZ;

    public static synchronized at vx() {
        at atVar;
        synchronized (at.class) {
            if (afZ == null) {
                afZ = new at();
            }
            atVar = afZ;
        }
        return atVar;
    }

    public String dp(String str) {
        long j = 0;
        for (byte b : str.getBytes()) {
            j += b;
        }
        return "image/" + (j % 20);
    }

    public Bitmap dq(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return l.V(dp(str), str);
    }

    public boolean dr(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return l.U(dp(str), str);
    }

    public int ds(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        return (int) l.T(dp(str), str);
    }

    public boolean aa(String str, String str2) {
        String str3 = l.yP + "/" + TbConfig.getTempDirName() + "/";
        if (!l.cN(str3)) {
            l.da(str3);
        }
        String str4 = String.valueOf(str3) + dp(str2);
        if (!l.cN(str4)) {
            l.da(str4);
        }
        String str5 = String.valueOf(str4) + "/" + str2;
        if (str.equals(str5)) {
            return false;
        }
        return l.b(str, str5, true);
    }

    public void h(String str, byte[] bArr) {
        if (!TextUtils.isEmpty(str)) {
            l.d(dp(str), str, bArr);
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

    public void vy() {
        s(new File(l.yP + "/" + TbConfig.getTempDirName() + "/" + TbConfig.TMP_PIC_DIR_NAME));
        s(new File(l.yP + "/" + TbConfig.getTempDirName() + "/" + TbConfig.IMAGE_CACHE_DIR_NAME));
    }

    public void vz() {
        t(new File(l.yP + "/" + TbConfig.getTempDirName() + "/" + l.cy(3)));
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
