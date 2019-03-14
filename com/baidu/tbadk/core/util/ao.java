package com.baidu.tbadk.core.util;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.tbadk.TbConfig;
import com.sina.weibo.sdk.utils.FileUtils;
import java.io.File;
/* loaded from: classes.dex */
public class ao {
    private static ao bKJ;

    public static synchronized ao adk() {
        ao aoVar;
        synchronized (ao.class) {
            if (bKJ == null) {
                bKJ = new ao();
            }
            aoVar = bKJ;
        }
        return aoVar;
    }

    public String mB(String str) {
        if (str == null) {
            return null;
        }
        long j = 0;
        for (byte b : str.getBytes()) {
            j += b;
        }
        return FileUtils.IMAGE_FILE_START + (j % 20);
    }

    public Bitmap mf(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return m.bF(mB(str), str);
    }

    public boolean mC(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return m.bE(mB(str), str);
    }

    public int mD(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        return (int) m.bD(mB(str), str);
    }

    public boolean bG(String str, String str2) {
        String str3 = m.FK + "/" + TbConfig.getTempDirName() + "/";
        if (!m.lN(str3)) {
            m.mk(str3);
        }
        String str4 = str3 + mB(str2);
        if (!m.lN(str4)) {
            m.mk(str4);
        }
        String str5 = str4 + "/" + str2;
        if (str.equals(str5)) {
            return false;
        }
        return m.o(str, str5, true);
    }

    public void h(String str, byte[] bArr) {
        if (!TextUtils.isEmpty(str)) {
            m.c(mB(str), str, bArr);
        }
    }

    private void K(File file) {
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    K(file2);
                    file2.delete();
                } else if (!file2.delete()) {
                }
            }
        }
    }

    public void adl() {
        L(new File(m.FK + "/" + TbConfig.getTempDirName() + "/" + m.hc(3)));
    }

    private void L(File file) {
        long currentTimeMillis = System.currentTimeMillis();
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    K(file2);
                    file2.delete();
                } else if (currentTimeMillis - file2.lastModified() >= -1702967296 && file2.delete()) {
                }
            }
        }
    }
}
