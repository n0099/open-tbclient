package com.baidu.tbadk.core.util;

import com.baidu.tbadk.TbConfig;
import java.io.File;
/* loaded from: classes.dex */
public class at {
    private static at fcw;

    public static synchronized at bsS() {
        at atVar;
        synchronized (at.class) {
            if (fcw == null) {
                fcw = new at();
            }
            atVar = fcw;
        }
        return atVar;
    }

    public String Bl(String str) {
        if (str == null) {
            return null;
        }
        long j = 0;
        for (byte b : str.getBytes()) {
            j += b;
        }
        return "image/" + (j % 20);
    }

    private void P(File file) {
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    P(file2);
                    file2.delete();
                } else if (!file2.delete()) {
                }
            }
        }
    }

    public void bsT() {
        Q(new File(o.EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/" + o.getPrefixByType(3)));
    }

    private void Q(File file) {
        long currentTimeMillis = System.currentTimeMillis();
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    P(file2);
                    file2.delete();
                } else if (currentTimeMillis - file2.lastModified() >= -1702967296 && file2.delete()) {
                }
            }
        }
    }
}
