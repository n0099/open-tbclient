package com.baidu.searchbox.dns.util;

import android.util.Log;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class DnsUtil {
    public static boolean DEBUG = false;
    public static final String TAG = "SMART_HTTP_DNS";
    public static int stackType;

    /* JADX WARN: Removed duplicated region for block: B:16:0x001a  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0046  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void initNetworkStackType() {
        boolean z;
        boolean z2;
        try {
            z = DnsChecker.isIPv4Reachable();
            try {
                z2 = DnsChecker.isIPv6Reachable();
            } catch (Throwable th) {
                th = th;
                if (DEBUG) {
                    th.printStackTrace();
                }
                z2 = false;
                if (DEBUG) {
                }
                if (!z) {
                }
                if (!z) {
                }
            }
        } catch (Throwable th2) {
            th = th2;
            z = false;
        }
        if (DEBUG) {
            Log.i(TAG, " IPv4Reachable: " + z + ", isIPv6Reachable: " + z2);
        }
        if (!z && z2) {
            stackType = 3;
        } else if (!z) {
            stackType = 1;
        } else if (z2) {
            stackType = 2;
        } else {
            stackType = 0;
        }
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
}
