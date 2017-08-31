package com.baidu.tbadk.core.hybrid.cache;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.hybrid.o;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
/* loaded from: classes.dex */
public class c {
    public CacheEntry db(String str) {
        CacheEntry cZ = a.ui().cZ(str);
        if (cZ == null) {
            return null;
        }
        File file = new File(new File(TbadkCoreApplication.getInst().getFilesDir(), "tbhybrid/cache/files"), cZ.getName());
        if (!file.isFile() || file.length() <= 0) {
            return null;
        }
        try {
            cZ.setInputStream(new FileInputStream(file));
            return cZ;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean dc(String str) {
        CacheEntry da = a.ui().da(str);
        if (da == null) {
            return false;
        }
        File file = new File(new File(TbadkCoreApplication.getInst().getFilesDir(), "tbhybrid/cache/files"), da.getName());
        if (!file.isFile() || file.length() <= 0) {
            return false;
        }
        return file.delete();
    }

    public boolean a(CacheEntry cacheEntry, byte[] bArr) {
        if (cacheEntry == null || bArr == null || !a.ui().a(cacheEntry)) {
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
