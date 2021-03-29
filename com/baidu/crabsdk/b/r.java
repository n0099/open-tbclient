package com.baidu.crabsdk.b;

import android.os.Environment;
import android.os.StatFs;
/* loaded from: classes.dex */
public final class r {
    public static String a() {
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            long blockCount = statFs.getBlockCount() * statFs.getBlockSize();
            StatFs statFs2 = new StatFs(Environment.getDataDirectory().getPath());
            long availableBlocks = statFs2.getAvailableBlocks() * statFs2.getBlockSize();
            return "Total: " + com.baidu.crabsdk.c.c.f(blockCount) + " Used: " + com.baidu.crabsdk.c.c.f(blockCount - availableBlocks) + " Free: " + com.baidu.crabsdk.c.c.f(availableBlocks);
        } catch (Exception e2) {
            com.baidu.crabsdk.c.a.a("getInternalStorageInfo error!", e2);
            return "N/A";
        }
    }

    public static String b() {
        try {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            long blockCount = statFs.getBlockCount() * statFs.getBlockSize();
            StatFs statFs2 = new StatFs(Environment.getExternalStorageDirectory().getPath());
            long availableBlocks = statFs2.getAvailableBlocks() * statFs2.getBlockSize();
            return "Total: " + com.baidu.crabsdk.c.c.f(blockCount) + " Used: " + com.baidu.crabsdk.c.c.f(blockCount - availableBlocks) + " Free: " + com.baidu.crabsdk.c.c.f(availableBlocks);
        } catch (Exception unused) {
            return "N/A";
        }
    }
}
