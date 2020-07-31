package com.baidu.searchbox.dns.util;
/* loaded from: classes6.dex */
public class DnsChecker {
    public static native boolean isIPv4Reachable();

    public static native boolean isIPv6Reachable();

    static {
        try {
            System.loadLibrary("DnsChecker");
        } catch (UnsatisfiedLinkError e) {
            if (DnsUtil.DEBUG) {
                e.printStackTrace();
            }
        }
    }
}
