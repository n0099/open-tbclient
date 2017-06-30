package com.baidu.tbadk.core.hybrid.cache;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.hybrid.r;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
/* loaded from: classes.dex */
public class d {
    public CacheEntry cZ(String str) {
        CacheEntry cX = a.tV().cX(str);
        if (cX == null) {
            return null;
        }
        File file = new File(new File(TbadkCoreApplication.m9getInst().getFilesDir(), "tbhybrid/cache/files"), cX.getName());
        if (!file.isFile() || file.length() <= 0) {
            return null;
        }
        try {
            cX.setInputStream(new FileInputStream(file));
            return cX;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean da(String str) {
        CacheEntry cY = a.tV().cY(str);
        if (cY == null) {
            return false;
        }
        File file = new File(new File(TbadkCoreApplication.m9getInst().getFilesDir(), "tbhybrid/cache/files"), cY.getName());
        if (!file.isFile() || file.length() <= 0) {
            return false;
        }
        return file.delete();
    }

    public boolean a(CacheEntry cacheEntry, byte[] bArr) {
        if (cacheEntry == null || bArr == null || !a.tV().a(cacheEntry)) {
            return false;
        }
        File file = new File(TbadkCoreApplication.m9getInst().getFilesDir(), "tbhybrid/cache/files");
        File file2 = new File(file, cacheEntry.getName());
        if (file.exists() || file.mkdirs()) {
            return r.a(file2, bArr, false);
        }
        return false;
    }
}
