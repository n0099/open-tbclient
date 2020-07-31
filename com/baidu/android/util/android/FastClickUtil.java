package com.baidu.android.util.android;
/* loaded from: classes20.dex */
public class FastClickUtil {
    private static final int SHOW_DIOLOG_GAP_TIME = 1300;
    public static long sLastShowDiologTime = 0;

    public static void clearLastRecordTime() {
        sLastShowDiologTime = 0L;
    }

    public static boolean isFastShowDialogCallback() {
        boolean z;
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - sLastShowDiologTime > 1300) {
            z = false;
        } else {
            z = true;
        }
        sLastShowDiologTime = currentTimeMillis;
        return z;
    }
}
