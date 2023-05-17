package com.baidu.searchbox.dns.util;

import com.baidu.android.util.soloader.SoLoader;
import com.baidu.searchbox.common.runtime.AppRuntime;
/* loaded from: classes3.dex */
public class DnsChecker {
    public static native boolean isIPv4Reachable();

    public static native boolean isIPv6Reachable();

    static {
        SoLoader.load(AppRuntime.getAppContext(), "DnsChecker");
    }

    public static boolean isIPv4ReachableNow() {
        try {
            return isIPv4Reachable();
        } catch (UnsatisfiedLinkError e) {
            if (DnsUtil.DEBUG) {
                e.printStackTrace();
                return false;
            }
            return false;
        }
    }

    public static boolean isIPv6ReachableNow() {
        try {
            return isIPv6Reachable();
        } catch (UnsatisfiedLinkError e) {
            if (DnsUtil.DEBUG) {
                e.printStackTrace();
                return false;
            }
            return false;
        }
    }
}
