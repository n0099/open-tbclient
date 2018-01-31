package com.baidu.tbadk.core.util;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.tbadk.TbConfig;
import java.io.File;
/* loaded from: classes.dex */
public class al {
    private static al aVD;

    public static synchronized al CF() {
        al alVar;
        synchronized (al.class) {
            if (aVD == null) {
                aVD = new al();
            }
            alVar = aVD;
        }
        return alVar;
    }

    public String eb(String str) {
        if (str == null) {
            return null;
        }
        long j = 0;
        for (byte b : str.getBytes()) {
            j += b;
        }
        return "image/" + (j % 20);
    }

    public Bitmap dD(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return k.W(eb(str), str);
    }

    public boolean ec(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return k.V(eb(str), str);
    }

    public int ed(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        return (int) k.U(eb(str), str);
    }

    public boolean X(String str, String str2) {
        String str3 = k.amf + "/" + TbConfig.getTempDirName() + "/";
        if (!k.m12do(str3)) {
            k.dK(str3);
        }
        String str4 = str3 + eb(str2);
        if (!k.m12do(str4)) {
            k.dK(str4);
        }
        String str5 = str4 + "/" + str2;
        if (str.equals(str5)) {
            return false;
        }
        return k.c(str, str5, true);
    }

    public void j(String str, byte[] bArr) {
        if (!TextUtils.isEmpty(str)) {
            k.d(eb(str), str, bArr);
        }
    }

    private void v(File file) {
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    v(file2);
                    file2.delete();
                } else if (!file2.delete()) {
                }
            }
        }
    }

    public void CG() {
        v(new File(k.amf + "/" + TbConfig.getTempDirName() + "/" + TbConfig.TMP_PIC_DIR_NAME));
        v(new File(k.amf + "/" + TbConfig.getTempDirName() + "/" + TbConfig.IMAGE_CACHE_DIR_NAME));
    }

    public void CH() {
        w(new File(k.amf + "/" + TbConfig.getTempDirName() + "/" + k.fA(3)));
    }

    private void w(File file) {
        long currentTimeMillis = System.currentTimeMillis();
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    v(file2);
                    file2.delete();
                } else if (currentTimeMillis - file2.lastModified() >= -1702967296 && file2.delete()) {
                }
            }
        }
    }
}
