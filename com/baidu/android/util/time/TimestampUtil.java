package com.baidu.android.util.time;
/* loaded from: classes12.dex */
public final class TimestampUtil {
    private static long mDelta = 0;
    private static long SECONDUNIT = 1000;

    public static void setDeltaTime(String str) {
        if (str != null) {
            try {
                mDelta = Long.parseLong(str) - (System.currentTimeMillis() / SECONDUNIT);
            } catch (Exception e) {
                e.printStackTrace();
                mDelta = 0L;
            }
        }
    }

    public static long getDelta() {
        return mDelta;
    }

    public static String getCalibratedTime() {
        return String.valueOf((System.currentTimeMillis() / SECONDUNIT) + mDelta);
    }
}
