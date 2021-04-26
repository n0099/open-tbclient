package com.baidu.searchbox.dns.b;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.dns.util.DnsChecker;
import com.baidu.searchbox.dns.util.DnsUtil;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public class b {
    public static Map<String, List<String>> s = Collections.synchronizedMap(new HashMap(2));
    public static int t = 0;
    public static int u = 0;
    public static boolean v = false;

    static {
        ArrayList arrayList = new ArrayList(9);
        arrayList.add("180.149.145.177");
        arrayList.add("112.34.111.104");
        arrayList.add("111.206.37.66");
        arrayList.add("180.97.104.214");
        arrayList.add("117.185.17.20");
        arrayList.add("112.80.248.204");
        arrayList.add("14.215.177.166");
        arrayList.add("183.232.231.184");
        arrayList.add("163.177.151.106");
        ArrayList arrayList2 = new ArrayList(8);
        arrayList2.add("111.13.101.232");
        arrayList2.add("220.181.7.233");
        arrayList2.add("61.135.186.217");
        arrayList2.add("112.80.255.162");
        arrayList2.add("115.239.217.67");
        arrayList2.add("14.215.178.36");
        arrayList2.add("163.177.151.98");
        arrayList2.add("183.232.231.30");
        s.put("mbd.baidu.com", arrayList);
        s.put("m.baidu.com", arrayList2);
    }

    public static List<String> a(Map<String, List<String>> map) {
        if (map != null) {
            if (map.containsKey("local")) {
                return map.get("local");
            }
            if (map.containsKey(UnitedSchemeConstants.UNITED_SCHEME_BACKUP)) {
                return map.get(UnitedSchemeConstants.UNITED_SCHEME_BACKUP);
            }
            return null;
        }
        return null;
    }

    public static boolean b(Map<String, List<String>> map) {
        return map != null && map.containsKey(UnitedSchemeConstants.UNITED_SCHEME_BACKUP);
    }

    public static Map<String, List<String>> h(String str) {
        HashMap hashMap = new HashMap();
        try {
            List<String> parseRawAddressList = DnsUtil.parseRawAddressList(Arrays.asList(InetAddress.getAllByName(str)));
            if (parseRawAddressList != null) {
                hashMap.put("local", parseRawAddressList);
            }
            return hashMap;
        } catch (UnknownHostException e2) {
            if (v) {
                if (DnsChecker.isIPv4Reachable()) {
                    String i2 = i(str.trim());
                    if (i2 != null && !TextUtils.isEmpty(i2)) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(i2);
                        if (DnsUtil.DEBUG) {
                            Log.d(DnsUtil.TAG, " backup ip " + arrayList + " for \"" + str.trim() + "\"");
                        }
                        hashMap.put(UnitedSchemeConstants.UNITED_SCHEME_BACKUP, arrayList);
                        return hashMap;
                    }
                } else {
                    throw e2;
                }
            }
            throw e2;
        }
    }

    public static String i(String str) {
        com.baidu.searchbox.dns.d.a.a d2 = com.baidu.searchbox.dns.a.a.e().d(str);
        List<String> ipList = d2 != null ? d2.getIpList() : null;
        if (ipList == null || ipList.size() == 0) {
            ipList = s.get(str);
        }
        if (ipList == null || ipList.size() <= 0) {
            return null;
        }
        int i2 = 0;
        if ("m.baidu.com".equals(str)) {
            i2 = a(ipList.size());
        } else if ("mbd.baidu.com".equals(str)) {
            i2 = b(ipList.size());
        }
        return ipList.get(i2);
    }

    public static synchronized int b(int i2) {
        int i3;
        synchronized (b.class) {
            if (t >= i2 || t < 0) {
                t = 0;
            }
            i3 = t;
            t = i3 + 1;
        }
        return i3;
    }

    public static synchronized int a(int i2) {
        int i3;
        synchronized (b.class) {
            if (u >= i2 || u < 0) {
                u = 0;
            }
            i3 = u;
            u = i3 + 1;
        }
        return i3;
    }
}
