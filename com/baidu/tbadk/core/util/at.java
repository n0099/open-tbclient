package com.baidu.tbadk.core.util;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.tbadk.TbConfig;
import java.io.File;
/* loaded from: classes.dex */
public class at {
    private static at afx;

    public static synchronized at vf() {
        at atVar;
        synchronized (at.class) {
            if (afx == null) {
                afx = new at();
            }
            atVar = afx;
        }
        return atVar;
    }

    public String dq(String str) {
        long j = 0;
        for (byte b : str.getBytes()) {
            j += b;
        }
        return "image/" + (j % 20);
    }

    public Bitmap dr(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return l.V(dq(str), str);
    }

    public boolean ds(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return l.U(dq(str), str);
    }

    public int dt(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        return (int) l.T(dq(str), str);
    }

    public boolean aa(String str, String str2) {
        String str3 = l.yu + "/" + TbConfig.getTempDirName() + "/";
        if (!l.cP(str3)) {
            l.dc(str3);
        }
        String str4 = String.valueOf(str3) + dq(str2);
        if (!l.cP(str4)) {
            l.dc(str4);
        }
        String str5 = String.valueOf(str4) + "/" + str2;
        if (str.equals(str5)) {
            return false;
        }
        return l.c(str, str5, true);
    }

    public void h(String str, byte[] bArr) {
        if (!TextUtils.isEmpty(str)) {
            l.d(dq(str), str, bArr);
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

    public void vg() {
        t(new File(l.yu + "/" + TbConfig.getTempDirName() + "/" + TbConfig.TMP_PIC_DIR_NAME));
        t(new File(l.yu + "/" + TbConfig.getTempDirName() + "/" + TbConfig.IMAGE_CACHE_DIR_NAME));
    }

    public void vh() {
        u(new File(l.yu + "/" + TbConfig.getTempDirName() + "/" + l.cz(3)));
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
