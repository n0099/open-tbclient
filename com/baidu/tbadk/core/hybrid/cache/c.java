package com.baidu.tbadk.core.hybrid.cache;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.hybrid.o;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
/* loaded from: classes.dex */
public class c {
    public CacheEntry dl(String str) {
        CacheEntry dj = a.un().dj(str);
        if (dj == null) {
            return null;
        }
        File file = new File(new File(TbadkCoreApplication.getInst().getFilesDir(), "tbhybrid/cache/files"), dj.getName());
        if (!file.isFile() || file.length() <= 0) {
            return null;
        }
        try {
            dj.setInputStream(new FileInputStream(file));
            return dj;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean dm(String str) {
        CacheEntry dk = a.un().dk(str);
        if (dk == null) {
            return false;
        }
        File file = new File(new File(TbadkCoreApplication.getInst().getFilesDir(), "tbhybrid/cache/files"), dk.getName());
        if (!file.isFile() || file.length() <= 0) {
            return false;
        }
        return file.delete();
    }

    public boolean a(CacheEntry cacheEntry, byte[] bArr) {
        if (cacheEntry == null || bArr == null || !a.un().a(cacheEntry)) {
            return false;
        }
        File file = new File(TbadkCoreApplication.getInst().getFilesDir(), "tbhybrid/cache/files");
        File file2 = new File(file, cacheEntry.getName());
        if (file.exists() || file.mkdirs()) {
            return o.a(file2, bArr, false);
        }
        return false;
    }
}
