package com.baidu.tbadk.core.util;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.tbadk.TbConfig;
import java.io.File;
/* loaded from: classes.dex */
public class az {
    private static az YG;

    public static synchronized az tX() {
        az azVar;
        synchronized (az.class) {
            if (YG == null) {
                YG = new az();
            }
            azVar = YG;
        }
        return azVar;
    }

    public String du(String str) {
        long j = 0;
        for (byte b : str.getBytes()) {
            j += b;
        }
        return "image/" + (j % 20);
    }

    public Bitmap dv(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return m.X(du(str), str);
    }

    public boolean dw(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return m.W(du(str), str);
    }

    public int dx(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        return (int) m.V(du(str), str);
    }

    public boolean ac(String str, String str2) {
        String str3 = m.po + "/" + TbConfig.getTempDirName() + "/";
        if (!m.cO(str3)) {
            m.db(str3);
        }
        String str4 = String.valueOf(str3) + du(str2);
        if (!m.cO(str4)) {
            m.db(str4);
        }
        String str5 = String.valueOf(str4) + "/" + str2;
        if (str.equals(str5)) {
            return false;
        }
        return m.b(str, str5, true);
    }

    public void h(String str, byte[] bArr) {
        if (!TextUtils.isEmpty(str)) {
            m.d(du(str), str, bArr);
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

    public void tY() {
        s(new File(m.po + "/" + TbConfig.getTempDirName() + "/" + TbConfig.TMP_PIC_DIR_NAME));
        s(new File(m.po + "/" + TbConfig.getTempDirName() + "/" + TbConfig.IMAGE_CACHE_DIR_NAME));
    }

    public void tZ() {
        t(new File(m.po + "/" + TbConfig.getTempDirName() + "/" + m.cn(3)));
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
