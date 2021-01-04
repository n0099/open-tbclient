package com.baidu.tbadk.core.util;

import com.baidu.tbadk.TbConfig;
import java.io.File;
/* loaded from: classes.dex */
public class as {
    private static as fdq;

    public static synchronized as bwo() {
        as asVar;
        synchronized (as.class) {
            if (fdq == null) {
                fdq = new as();
            }
            asVar = fdq;
        }
        return asVar;
    }

    public String BZ(String str) {
        if (str == null) {
            return null;
        }
        long j = 0;
        for (byte b2 : str.getBytes()) {
            j += b2;
        }
        return "image/" + (j % 20);
    }

    private void T(File file) {
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    T(file2);
                    file2.delete();
                } else if (!file2.delete()) {
                }
            }
        }
    }

    public void bwp() {
        U(new File(n.EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/" + n.getPrefixByType(3)));
    }

    private void U(File file) {
        long currentTimeMillis = System.currentTimeMillis();
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    T(file2);
                    file2.delete();
                } else if (currentTimeMillis - file2.lastModified() >= -1702967296 && file2.delete()) {
                }
            }
        }
    }
}
