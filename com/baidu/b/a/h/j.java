package com.baidu.b.a.h;

import android.os.Environment;
import android.os.StatFs;
/* loaded from: classes2.dex */
public final class j {
    public static long getAvailableInternalMemorySize() {
        long blockSize;
        long availableBlocks;
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        if (a.hasJellyBeanMR2()) {
            blockSize = statFs.getBlockSizeLong();
            availableBlocks = statFs.getAvailableBlocksLong();
        } else {
            blockSize = statFs.getBlockSize();
            availableBlocks = statFs.getAvailableBlocks();
        }
        return availableBlocks * blockSize;
    }

    public static long getTotalInternalMemorySize() {
        long blockSize;
        long blockCount;
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        if (a.hasJellyBeanMR2()) {
            blockSize = statFs.getBlockSizeLong();
            blockCount = statFs.getBlockCountLong();
        } else {
            blockSize = statFs.getBlockSize();
            blockCount = statFs.getBlockCount();
        }
        return blockCount * blockSize;
    }
}
