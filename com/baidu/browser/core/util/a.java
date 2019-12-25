package com.baidu.browser.core.util;

import android.os.Environment;
import android.os.StatFs;
/* loaded from: classes9.dex */
public final class a {
    private static String[] sFiledsSysMemInfo = {"MemTotal:", "MemFree:", "Buffers:", "Cached:", "Active:", "Inactive:", "Dirty:"};

    public static float mn() {
        Exception e;
        long j;
        StatFs statFs;
        long j2 = 0;
        try {
            statFs = new StatFs(Environment.getDataDirectory().getPath());
            j = statFs.getBlockSize();
        } catch (Exception e2) {
            e = e2;
            j = 0;
        }
        try {
            j2 = statFs.getAvailableBlocks();
        } catch (Exception e3) {
            e = e3;
            e.printStackTrace();
            return ((float) (j2 * j)) / 1024.0f;
        }
        return ((float) (j2 * j)) / 1024.0f;
    }
}
