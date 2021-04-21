package com.baidu.searchbox.dns.util;
/* loaded from: classes2.dex */
public class DnsChecker {
    static {
        try {
            System.loadLibrary("DnsChecker");
        } catch (UnsatisfiedLinkError e2) {
            if (DnsUtil.DEBUG) {
                e2.printStackTrace();
            }
        }
    }

    public static native boolean isIPv4Reachable();

    public static native boolean isIPv6Reachable();
}
