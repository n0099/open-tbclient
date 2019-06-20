package com.baidu.tbadk.core.util;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.tbadk.TbConfig;
import com.sina.weibo.sdk.utils.FileUtils;
import java.io.File;
/* loaded from: classes.dex */
public class ao {
    private static ao bSx;

    public static synchronized ao aig() {
        ao aoVar;
        synchronized (ao.class) {
            if (bSx == null) {
                bSx = new ao();
            }
            aoVar = bSx;
        }
        return aoVar;
    }

    public String nJ(String str) {
        if (str == null) {
            return null;
        }
        long j = 0;
        for (byte b : str.getBytes()) {
            j += b;
        }
        return FileUtils.IMAGE_FILE_START + (j % 20);
    }

    public Bitmap nn(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return m.bP(nJ(str), str);
    }

    public boolean nK(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return m.bO(nJ(str), str);
    }

    public int nL(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        return (int) m.bN(nJ(str), str);
    }

    public boolean bQ(String str, String str2) {
        String str3 = m.Dt + "/" + TbConfig.getTempDirName() + "/";
        if (!m.mV(str3)) {
            m.ns(str3);
        }
        String str4 = str3 + nJ(str2);
        if (!m.mV(str4)) {
            m.ns(str4);
        }
        String str5 = str4 + "/" + str2;
        if (str.equals(str5)) {
            return false;
        }
        return m.p(str, str5, true);
    }

    public void h(String str, byte[] bArr) {
        if (!TextUtils.isEmpty(str)) {
            m.c(nJ(str), str, bArr);
        }
    }

    private void E(File file) {
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    E(file2);
                    file2.delete();
                } else if (!file2.delete()) {
                }
            }
        }
    }

    public void aih() {
        F(new File(m.Dt + "/" + TbConfig.getTempDirName() + "/" + m.hP(3)));
    }

    private void F(File file) {
        long currentTimeMillis = System.currentTimeMillis();
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    E(file2);
                    file2.delete();
                } else if (currentTimeMillis - file2.lastModified() >= -1702967296 && file2.delete()) {
                }
            }
        }
    }
}
