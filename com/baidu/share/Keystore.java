package com.baidu.share;
/* loaded from: classes.dex */
public class Keystore {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a() {
        return nativeGetIntentAction();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String b() {
        return nativeGetPermission();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String c() {
        return nativeGetAction();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String d() {
        return nativeGetFrom();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String e() {
        return nativeGetData();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String f() {
        return nativeGetTimestamp();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String g() {
        return nativeGetReceiver();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String h() {
        return nativeGetSplit();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String i() {
        return nativeGetFileName();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int j() {
        return nativeGetCacheSize();
    }

    private static native String nativeGetAction();

    private static native int nativeGetCacheSize();

    private static native String nativeGetData();

    private static native String nativeGetFileName();

    private static native String nativeGetFrom();

    private static native String nativeGetIntentAction();

    private static native String nativeGetPermission();

    private static native String nativeGetReceiver();

    private static native String nativeGetSplit();

    private static native String nativeGetTimestamp();
}
