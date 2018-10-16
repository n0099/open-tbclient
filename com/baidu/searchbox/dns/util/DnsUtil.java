package com.baidu.searchbox.dns.util;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class DnsUtil {
    public static final boolean DEBUG = false;
    public static final String TAG = "HTTP_DNS";

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
}
