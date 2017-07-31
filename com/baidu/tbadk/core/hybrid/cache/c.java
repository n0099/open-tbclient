package com.baidu.tbadk.core.hybrid.cache;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.hybrid.o;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
/* loaded from: classes.dex */
public class c {
    public CacheEntry di(String str) {
        CacheEntry dg = a.um().dg(str);
        if (dg == null) {
            return null;
        }
        File file = new File(new File(TbadkCoreApplication.getInst().getFilesDir(), "tbhybrid/cache/files"), dg.getName());
        if (!file.isFile() || file.length() <= 0) {
            return null;
        }
        try {
            dg.setInputStream(new FileInputStream(file));
            return dg;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean dj(String str) {
        CacheEntry dh = a.um().dh(str);
        if (dh == null) {
            return false;
        }
        File file = new File(new File(TbadkCoreApplication.getInst().getFilesDir(), "tbhybrid/cache/files"), dh.getName());
        if (!file.isFile() || file.length() <= 0) {
            return false;
        }
        return file.delete();
    }

    public boolean a(CacheEntry cacheEntry, byte[] bArr) {
        if (cacheEntry == null || bArr == null || !a.um().a(cacheEntry)) {
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
