package com.baidu.searchbox.common.security;
/* loaded from: classes3.dex */
public class SecUbcLog {
    public static UbcLogable sUbcImpl;

    /* loaded from: classes3.dex */
    public interface UbcLogable {
        void onEvent(String str, String str2);
    }

    public static void init(UbcLogable ubcLogable) {
        sUbcImpl = ubcLogable;
    }

    public static void onEvent(String str, String str2) {
        UbcLogable ubcLogable = sUbcImpl;
        if (ubcLogable != null) {
            ubcLogable.onEvent(str, str2);
        }
    }
}
