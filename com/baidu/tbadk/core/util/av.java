package com.baidu.tbadk.core.util;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.tbadk.TbConfig;
import java.io.File;
/* loaded from: classes.dex */
public class av {
    private static av acT;

    public static synchronized av vZ() {
        av avVar;
        synchronized (av.class) {
            if (acT == null) {
                acT = new av();
            }
            avVar = acT;
        }
        return avVar;
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
        return m.W(ds(str), str);
    }

    public boolean du(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return m.V(ds(str), str);
    }

    public int dv(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        return (int) m.U(ds(str), str);
    }

    public boolean copyFile(String str, String str2) {
        String str3 = m.yk + "/" + TbConfig.getTempDirName() + "/";
        if (!m.cO(str3)) {
            m.db(str3);
        }
        String str4 = String.valueOf(str3) + ds(str2);
        if (!m.cO(str4)) {
            m.db(str4);
        }
        String str5 = String.valueOf(str4) + "/" + str2;
        if (str.equals(str5)) {
            return false;
        }
        return m.c(str, str5, true);
    }

    public void h(String str, byte[] bArr) {
        if (!TextUtils.isEmpty(str)) {
            m.f(ds(str), str, bArr);
        }
    }

    private void u(File file) {
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    u(file2);
                    file2.delete();
                } else {
                    file2.delete();
                }
            }
        }
    }

    public void wa() {
        u(new File(m.yk + "/" + TbConfig.getTempDirName() + "/" + TbConfig.TMP_PIC_DIR_NAME));
        u(new File(m.yk + "/" + TbConfig.getTempDirName() + "/" + TbConfig.IMAGE_CACHE_DIR_NAME));
    }

    public void wb() {
        v(new File(m.yk + "/" + TbConfig.getTempDirName() + "/" + m.cB(3)));
    }

    private void v(File file) {
        long currentTimeMillis = System.currentTimeMillis();
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    u(file2);
                    file2.delete();
                } else if (currentTimeMillis - file2.lastModified() >= -1702967296) {
                    file2.delete();
                }
            }
        }
    }
}
