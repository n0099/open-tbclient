package com.baidu.tbadk.core.util;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.tbadk.TbConfig;
import java.io.File;
/* loaded from: classes.dex */
public class az {
    private static az XX;

    public static synchronized az tY() {
        az azVar;
        synchronized (az.class) {
            if (XX == null) {
                XX = new az();
            }
            azVar = XX;
        }
        return azVar;
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
        return m.X(dv(str), str);
    }

    public boolean dx(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return m.W(dv(str), str);
    }

    public int dy(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        return (int) m.V(dv(str), str);
    }

    public boolean ac(String str, String str2) {
        String str3 = m.oH + "/" + TbConfig.getTempDirName() + "/";
        if (!m.cO(str3)) {
            m.dc(str3);
        }
        String str4 = String.valueOf(str3) + dv(str2);
        if (!m.cO(str4)) {
            m.dc(str4);
        }
        String str5 = String.valueOf(str4) + "/" + str2;
        if (str.equals(str5)) {
            return false;
        }
        return m.b(str, str5, true);
    }

    public void h(String str, byte[] bArr) {
        if (!TextUtils.isEmpty(str)) {
            m.d(dv(str), str, bArr);
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

    public void tZ() {
        s(new File(m.oH + "/" + TbConfig.getTempDirName() + "/" + TbConfig.TMP_PIC_DIR_NAME));
        s(new File(m.oH + "/" + TbConfig.getTempDirName() + "/" + TbConfig.IMAGE_CACHE_DIR_NAME));
    }

    public void ua() {
        t(new File(m.oH + "/" + TbConfig.getTempDirName() + "/" + m.cn(3)));
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
