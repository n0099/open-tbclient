package com.baidu.searchbox.dns.util;

import android.util.Log;
import com.baidu.searchbox.dns.a.a;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class DnsUtil {
    public static final String TAG = "SMART_HTTP_DNS";
    public static String httpDnsDebugAddress;
    public static String httpDnsDebugExtraQueryParams;
    public static boolean DEBUG = false;
    public static int stackType = 0;
    public static boolean iPv6TestEnable = false;
    public static boolean iPv6Perfer = false;

    public static List<String> parseRawAddressList(List<InetAddress> list) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (InetAddress inetAddress : list) {
            arrayList.add(inetAddress.getHostAddress());
        }
        return arrayList;
    }

    public static List<InetAddress> parseInetAddressList(List<String> list) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (String str : list) {
            arrayList.add(InetAddress.getByName(str));
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x000d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void initNetworkStackType() {
        Throwable th;
        boolean z;
        boolean z2;
        boolean z3;
        try {
            z2 = DnsChecker.isIPv4Reachable();
        } catch (Throwable th2) {
            th = th2;
            z = false;
        }
        try {
            z3 = DnsChecker.isIPv6Reachable();
        } catch (Throwable th3) {
            z = z2;
            th = th3;
            if (DEBUG) {
                th.printStackTrace();
            }
            z2 = z;
            z3 = false;
            if (DEBUG) {
            }
            if (!z2) {
            }
            if (!z2) {
            }
        }
        if (DEBUG) {
            Log.i(TAG, " IPv4Reachable: " + z2 + ", isIPv6Reachable: " + z3);
        }
        if (!z2 && z3) {
            stackType = 3;
        } else if (!z2) {
            stackType = 1;
        } else if (z3) {
            stackType = 2;
        } else {
            stackType = 0;
        }
    }

    public static boolean isIPv6TestArea() {
        return a.e().isIPv6TestArea();
    }
}
