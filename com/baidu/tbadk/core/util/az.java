package com.baidu.tbadk.core.util;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.tbadk.TbConfig;
import java.io.File;
/* loaded from: classes.dex */
public class az {
    private static az abv;

    public static synchronized az vd() {
        az azVar;
        synchronized (az.class) {
            if (abv == null) {
                abv = new az();
            }
            azVar = abv;
        }
        return azVar;
    }

    public String dx(String str) {
        long j = 0;
        for (byte b : str.getBytes()) {
            j += b;
        }
        return "image/" + (j % 20);
    }

    public Bitmap dy(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return m.X(dx(str), str);
    }

    public boolean dz(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return m.W(dx(str), str);
    }

    public int dA(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        return (int) m.V(dx(str), str);
    }

    public boolean ac(String str, String str2) {
        String str3 = m.rB + "/" + TbConfig.getTempDirName() + "/";
        if (!m.cR(str3)) {
            m.de(str3);
        }
        String str4 = String.valueOf(str3) + dx(str2);
        if (!m.cR(str4)) {
            m.de(str4);
        }
        String str5 = String.valueOf(str4) + "/" + str2;
        if (str.equals(str5)) {
            return false;
        }
        return m.b(str, str5, true);
    }

    public void h(String str, byte[] bArr) {
        if (!TextUtils.isEmpty(str)) {
            m.d(dx(str), str, bArr);
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

    public void ve() {
        s(new File(m.rB + "/" + TbConfig.getTempDirName() + "/" + TbConfig.TMP_PIC_DIR_NAME));
        s(new File(m.rB + "/" + TbConfig.getTempDirName() + "/" + TbConfig.IMAGE_CACHE_DIR_NAME));
    }

    public void vf() {
        t(new File(m.rB + "/" + TbConfig.getTempDirName() + "/" + m.cA(3)));
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
