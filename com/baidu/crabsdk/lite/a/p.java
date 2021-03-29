package com.baidu.crabsdk.lite.a;

import android.os.Environment;
import android.os.StatFs;
/* loaded from: classes.dex */
public final class p {
    public static String a() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        long blockCount = statFs.getBlockCount() * statFs.getBlockSize();
        StatFs statFs2 = new StatFs(Environment.getDataDirectory().getPath());
        long availableBlocks = statFs2.getAvailableBlocks() * statFs2.getBlockSize();
        return "Total: " + com.baidu.crabsdk.lite.b.c.a(blockCount) + " Used: " + com.baidu.crabsdk.lite.b.c.a(blockCount - availableBlocks) + " Free: " + com.baidu.crabsdk.lite.b.c.a(availableBlocks);
    }
}
