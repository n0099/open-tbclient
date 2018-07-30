package com.baidu.crabsdk.b;

import android.os.Environment;
import android.os.StatFs;
/* loaded from: classes2.dex */
public final class q {
    public static String pg() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        long blockCount = statFs.getBlockCount() * statFs.getBlockSize();
        StatFs statFs2 = new StatFs(Environment.getDataDirectory().getPath());
        long availableBlocks = statFs2.getAvailableBlocks() * statFs2.getBlockSize();
        return "Total: " + com.baidu.crabsdk.c.c.p(blockCount) + " Used: " + com.baidu.crabsdk.c.c.p(blockCount - availableBlocks) + " Free: " + com.baidu.crabsdk.c.c.p(availableBlocks);
    }
}
