package com.baidu.tbadk.core.util;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.tbadk.TbConfig;
import java.io.File;
/* loaded from: classes.dex */
public class ax {
    private static ax XF;

    public static synchronized ax tZ() {
        ax axVar;
        synchronized (ax.class) {
            if (XF == null) {
                XF = new ax();
            }
            axVar = XF;
        }
        return axVar;
    }

    public String ds(String str) {
        long j = 0;
        for (byte b : str.getBytes()) {
            j += b;
        }
        return "image/" + (j % 20);
    }

    public Bitmap dt(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return m.Y(ds(str), str);
    }

    public boolean du(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return m.X(ds(str), str);
    }

    public int dv(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        return (int) m.W(ds(str), str);
    }

    public boolean ad(String str, String str2) {
        String str3 = m.oH + "/" + TbConfig.getTempDirName() + "/";
        if (!m.cP(str3)) {
            m.dd(str3);
        }
        String str4 = String.valueOf(str3) + ds(str2);
        if (!m.cP(str4)) {
            m.dd(str4);
        }
        String str5 = String.valueOf(str4) + "/" + str2;
        if (str.equals(str5)) {
            return false;
        }
        return m.b(str, str5, true);
    }

    public void g(String str, byte[] bArr) {
        if (!TextUtils.isEmpty(str)) {
            m.d(ds(str), str, bArr);
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

    public void ua() {
        s(new File(m.oH + "/" + TbConfig.getTempDirName() + "/" + TbConfig.TMP_PIC_DIR_NAME));
        s(new File(m.oH + "/" + TbConfig.getTempDirName() + "/" + TbConfig.IMAGE_CACHE_DIR_NAME));
    }

    public void ub() {
        t(new File(m.oH + "/" + TbConfig.getTempDirName() + "/" + m.cm(3)));
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
