package com.baidu.cyberplayer.sdk.utils;
/* loaded from: classes3.dex */
public class c {
    public static int a(String str, int i) {
        try {
            return Integer.parseInt(str);
        } catch (Exception unused) {
            return i;
        }
    }

    public static long a(String str, long j) {
        try {
            return Long.parseLong(str);
        } catch (Exception unused) {
            return j;
        }
    }
}
