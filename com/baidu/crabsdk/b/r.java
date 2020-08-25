package com.baidu.crabsdk.b;

import android.os.Environment;
import android.os.StatFs;
/* loaded from: classes6.dex */
public final class r {
    public static String O() {
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            long blockCount = statFs.getBlockCount() * statFs.getBlockSize();
            StatFs statFs2 = new StatFs(Environment.getDataDirectory().getPath());
            long availableBlocks = statFs2.getAvailableBlocks() * statFs2.getBlockSize();
            return "Total: " + com.baidu.crabsdk.c.c.R(blockCount) + " Used: " + com.baidu.crabsdk.c.c.R(blockCount - availableBlocks) + " Free: " + com.baidu.crabsdk.c.c.R(availableBlocks);
        } catch (Exception e) {
            com.baidu.crabsdk.c.a.a("getInternalStorageInfo error!", e);
            return "N/A";
        }
    }

    public static String P() {
        try {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            long blockCount = statFs.getBlockCount() * statFs.getBlockSize();
            StatFs statFs2 = new StatFs(Environment.getExternalStorageDirectory().getPath());
            long availableBlocks = statFs2.getAvailableBlocks() * statFs2.getBlockSize();
            return "Total: " + com.baidu.crabsdk.c.c.R(blockCount) + " Used: " + com.baidu.crabsdk.c.c.R(blockCount - availableBlocks) + " Free: " + com.baidu.crabsdk.c.c.R(availableBlocks);
        } catch (Exception e) {
            return "N/A";
        }
    }
}
