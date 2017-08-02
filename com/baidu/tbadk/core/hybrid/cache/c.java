package com.baidu.tbadk.core.hybrid.cache;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.hybrid.o;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
/* loaded from: classes.dex */
public class c {
    public CacheEntry dc(String str) {
        CacheEntry da = a.ub().da(str);
        if (da == null) {
            return null;
        }
        File file = new File(new File(TbadkCoreApplication.getInst().getFilesDir(), "tbhybrid/cache/files"), da.getName());
        if (!file.isFile() || file.length() <= 0) {
            return null;
        }
        try {
            da.setInputStream(new FileInputStream(file));
            return da;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean dd(String str) {
        CacheEntry db = a.ub().db(str);
        if (db == null) {
            return false;
        }
        File file = new File(new File(TbadkCoreApplication.getInst().getFilesDir(), "tbhybrid/cache/files"), db.getName());
        if (!file.isFile() || file.length() <= 0) {
            return false;
        }
        return file.delete();
    }

    public boolean a(CacheEntry cacheEntry, byte[] bArr) {
        if (cacheEntry == null || bArr == null || !a.ub().a(cacheEntry)) {
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
