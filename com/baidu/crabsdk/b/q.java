package com.baidu.crabsdk.b;

import android.os.Environment;
import android.os.StatFs;
/* loaded from: classes3.dex */
public final class q {
    public static String L() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        long blockCount = statFs.getBlockCount() * statFs.getBlockSize();
        StatFs statFs2 = new StatFs(Environment.getDataDirectory().getPath());
        long availableBlocks = statFs2.getAvailableBlocks() * statFs2.getBlockSize();
        return "Total: " + com.baidu.crabsdk.c.c.i(blockCount) + " Used: " + com.baidu.crabsdk.c.c.i(blockCount - availableBlocks) + " Free: " + com.baidu.crabsdk.c.c.i(availableBlocks);
    }
}
