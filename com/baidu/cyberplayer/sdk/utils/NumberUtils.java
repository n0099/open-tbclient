package com.baidu.cyberplayer.sdk.utils;
/* loaded from: classes3.dex */
public class NumberUtils {
    public static int parseIntSafely(String str, int i) {
        try {
            return Integer.parseInt(str);
        } catch (Exception unused) {
            return i;
        }
    }

    public static long parseLongSafely(String str, long j) {
        try {
            return Long.parseLong(str);
        } catch (Exception unused) {
            return j;
        }
    }
}
