package com.baidu.tbadk.core.util;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.tbadk.TbConfig;
import java.io.File;
/* loaded from: classes.dex */
public class aw {
    private static aw abT;

    public static synchronized aw vk() {
        aw awVar;
        synchronized (aw.class) {
            if (abT == null) {
                abT = new aw();
            }
            awVar = abT;
        }
        return awVar;
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
        return n.X(ds(str), str);
    }

    public boolean du(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return n.W(ds(str), str);
    }

    public int dv(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        return (int) n.V(ds(str), str);
    }

    public boolean copyFile(String str, String str2) {
        String str3 = n.ya + "/" + TbConfig.getTempDirName() + "/";
        if (!n.cO(str3)) {
            n.db(str3);
        }
        String str4 = String.valueOf(str3) + ds(str2);
        if (!n.cO(str4)) {
            n.db(str4);
        }
        String str5 = String.valueOf(str4) + "/" + str2;
        if (str.equals(str5)) {
            return false;
        }
        return n.c(str, str5, true);
    }

    public void h(String str, byte[] bArr) {
        if (!TextUtils.isEmpty(str)) {
            n.f(ds(str), str, bArr);
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

    public void vl() {
        u(new File(n.ya + "/" + TbConfig.getTempDirName() + "/" + TbConfig.TMP_PIC_DIR_NAME));
        u(new File(n.ya + "/" + TbConfig.getTempDirName() + "/" + TbConfig.IMAGE_CACHE_DIR_NAME));
    }

    public void vm() {
        v(new File(n.ya + "/" + TbConfig.getTempDirName() + "/" + n.cr(3)));
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
