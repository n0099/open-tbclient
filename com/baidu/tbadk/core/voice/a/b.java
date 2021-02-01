package com.baidu.tbadk.core.voice.a;

import com.baidu.adp.lib.util.s;
import com.baidu.tbadk.core.util.o;
import java.io.File;
/* loaded from: classes.dex */
public class b {
    public static a BN(String str) {
        a aVar = new a();
        if (str == null) {
            aVar.error_code = 6;
            aVar.error_msg = a.qk(aVar.error_code);
        } else if (!o.CheckTempDir(o.getCacheDir() + "voice")) {
            aVar.error_code = 7;
            aVar.error_msg = a.qk(aVar.error_code);
        } else {
            String md5 = s.toMd5(o.GetStreamFromTmpFile(str));
            if (md5 == null) {
                aVar.error_code = 5;
                aVar.error_msg = a.qk(aVar.error_code);
            } else {
                String filePath = o.getFilePath(md5, 1, true);
                if (o.renameTo(str, filePath)) {
                    aVar.path = filePath;
                    aVar.md5 = md5;
                } else {
                    aVar.error_code = 1;
                    aVar.error_msg = a.qk(aVar.error_code);
                }
            }
        }
        return aVar;
    }

    public static boolean renameFile(String str, String str2) {
        return o.renameTo(str, o.getFilePath(str2, 1, true));
    }

    public static synchronized void bvF() {
        synchronized (b.class) {
            File file = new File(o.getCacheDir() + "voice");
            if (file.exists() && file.isDirectory()) {
                File[] listFiles = file.listFiles();
                for (File file2 : listFiles) {
                    file2.delete();
                }
            }
        }
    }
}
