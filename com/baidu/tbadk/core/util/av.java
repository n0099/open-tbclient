package com.baidu.tbadk.core.util;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.tbadk.TbConfig;
import java.io.File;
/* loaded from: classes.dex */
public class av {
    private static av agg;

    public static synchronized av vu() {
        av avVar;
        synchronized (av.class) {
            if (agg == null) {
                agg = new av();
            }
            avVar = agg;
        }
        return avVar;
    }

    public String dK(String str) {
        long j = 0;
        for (byte b : str.getBytes()) {
            j += b;
        }
        return "image/" + (j % 20);
    }

    public Bitmap dL(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return n.V(dK(str), str);
    }

    public boolean dM(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return n.U(dK(str), str);
    }

    public int dN(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        return (int) n.T(dK(str), str);
    }

    public boolean aa(String str, String str2) {
        String str3 = n.yu + "/" + TbConfig.getTempDirName() + "/";
        if (!n.dj(str3)) {
            n.dw(str3);
        }
        String str4 = String.valueOf(str3) + dK(str2);
        if (!n.dj(str4)) {
            n.dw(str4);
        }
        String str5 = String.valueOf(str4) + "/" + str2;
        if (str.equals(str5)) {
            return false;
        }
        return n.c(str, str5, true);
    }

    public void h(String str, byte[] bArr) {
        if (!TextUtils.isEmpty(str)) {
            n.d(dK(str), str, bArr);
        }
    }

    private void v(File file) {
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    v(file2);
                    file2.delete();
                } else {
                    file2.delete();
                }
            }
        }
    }

    public void vv() {
        v(new File(n.yu + "/" + TbConfig.getTempDirName() + "/" + TbConfig.TMP_PIC_DIR_NAME));
        v(new File(n.yu + "/" + TbConfig.getTempDirName() + "/" + TbConfig.IMAGE_CACHE_DIR_NAME));
    }

    public void vw() {
        w(new File(n.yu + "/" + TbConfig.getTempDirName() + "/" + n.cB(3)));
    }

    private void w(File file) {
        long currentTimeMillis = System.currentTimeMillis();
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    v(file2);
                    file2.delete();
                } else if (currentTimeMillis - file2.lastModified() >= -1702967296) {
                    file2.delete();
                }
            }
        }
    }
}
