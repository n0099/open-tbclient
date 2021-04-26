package com.baidu.android.util.time;
@Deprecated
/* loaded from: classes.dex */
public final class TimestampUtil {
    public static long SECONDUNIT = 1000;
    public static long mDelta;

    public static String getCalibratedTime() {
        return String.valueOf((System.currentTimeMillis() / SECONDUNIT) + mDelta);
    }

    public static long getDelta() {
        return mDelta;
    }

    public static void setDeltaTime(String str) {
        if (str == null) {
            return;
        }
        try {
            mDelta = Long.parseLong(str) - (System.currentTimeMillis() / SECONDUNIT);
        } catch (Exception e2) {
            e2.printStackTrace();
            mDelta = 0L;
        }
    }
}
