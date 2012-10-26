package com.baidu.loginshare;
/* loaded from: classes.dex */
public class Keystore {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a() {
        return nativeGetSyncAction();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String b() {
        return nativeGetSyncReplyAction();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String c() {
        return nativeGetLoginAction();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String d() {
        return nativeGetLogoutAction();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String e() {
        return nativeGetFileName();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String f() {
        return nativeGetUsername();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String g() {
        return nativeGetEmail();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String h() {
        return nativeGetPhoneNumber();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String i() {
        return nativeGetBduss();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String j() {
        return nativeGetPtoken();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String k() {
        return nativeGetIsValid();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String l() {
        return nativeGetIsEnable();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String m() {
        return nativeGetExtra();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String n() {
        return nativeGetUrl();
    }

    private static native String nativeGetBduss();

    private static native String nativeGetCheckTime();

    private static native String nativeGetEmail();

    private static native String nativeGetExtra();

    private static native String nativeGetFileName();

    private static native String nativeGetIsEnable();

    private static native String nativeGetIsFirstBoot();

    private static native String nativeGetIsValid();

    private static native String nativeGetLoginAction();

    private static native String nativeGetLogoutAction();

    private static native String nativeGetPhoneNumber();

    private static native String nativeGetPtoken();

    private static native String nativeGetStatisticsUrl();

    private static native String nativeGetSyncAction();

    private static native String nativeGetSyncReplyAction();

    private static native String nativeGetUrl();

    private static native String nativeGetUsername();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String o() {
        return nativeGetCheckTime();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String p() {
        return nativeGetStatisticsUrl();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String q() {
        return nativeGetStatisticsUrl();
    }

    private static String r() {
        return nativeGetIsValid();
    }
}
