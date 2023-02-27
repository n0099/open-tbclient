package com.baidu.searchbox.dns.policy;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.dns.cache.DnsCacheHelper;
import com.baidu.searchbox.dns.transmit.model.DnsModel;
import com.baidu.searchbox.dns.util.DnsChecker;
import com.baidu.searchbox.dns.util.DnsUtil;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public class LocalDnsPolicy {
    public static final String KEY_BACKUPIPLIST = "backup";
    public static final String KEY_LOCALDNSIPLIST = "local";
    public static final String MBAIDU_DOMAIN = "m.baidu.com";
    public static final String MBD_DOMAIN = "mbd.baidu.com";
    public static boolean backUpIPEnable = true;
    public static Map<String, List<String>> sBackUpIps = Collections.synchronizedMap(new HashMap(2));
    public static int sMbaiduIPIndex;
    public static int sMbdIPIndex;

    static {
        ArrayList arrayList = new ArrayList(9);
        arrayList.add("124.237.176.128");
        arrayList.add("112.34.111.104");
        arrayList.add("111.206.209.138");
        arrayList.add("180.101.49.185");
        arrayList.add("183.194.218.175");
        arrayList.add("153.3.236.119");
        arrayList.add("14.215.178.113");
        arrayList.add("183.232.231.184");
        arrayList.add("157.255.77.135");
        ArrayList arrayList2 = new ArrayList(8);
        arrayList2.add("39.156.66.95");
        arrayList2.add("220.181.38.129");
        arrayList2.add("110.242.68.9");
        arrayList2.add("112.80.255.162");
        arrayList2.add("180.101.49.19");
        arrayList2.add("36.152.44.90");
        arrayList2.add("14.215.178.36");
        arrayList2.add("163.177.151.98");
        arrayList2.add("183.232.231.30");
        sBackUpIps.put(MBD_DOMAIN, arrayList);
        sBackUpIps.put(MBAIDU_DOMAIN, arrayList2);
    }

    public static String getBackUpIp(String str) {
        List<String> list;
        DnsModel backup = DnsCacheHelper.getCacheHelper().getBackup(str);
        if (backup != null) {
            list = backup.getIpList();
        } else {
            list = null;
        }
        if (list == null || list.size() == 0) {
            list = sBackUpIps.get(str);
        }
        if (list == null || list.size() <= 0) {
            return null;
        }
        int i = 0;
        if (MBAIDU_DOMAIN.equals(str)) {
            i = getsMbaiduIPIndex(list.size());
        } else if (MBD_DOMAIN.equals(str)) {
            i = getsMbdIPIndex(list.size());
        }
        return list.get(i);
    }

    public static Map<String, List<String>> getIpListByHost(String str) throws UnknownHostException {
        HashMap hashMap = new HashMap();
        try {
            List<String> parseRawAddressList = DnsUtil.parseRawAddressList(Arrays.asList(InetAddress.getAllByName(str)));
            if (parseRawAddressList != null) {
                hashMap.put("local", parseRawAddressList);
            }
            return hashMap;
        } catch (UnknownHostException e) {
            if (backUpIPEnable) {
                if (DnsChecker.isIPv4ReachableNow()) {
                    String backUpIp = getBackUpIp(str.trim());
                    if (backUpIp != null && !TextUtils.isEmpty(backUpIp)) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(backUpIp);
                        if (DnsUtil.DEBUG) {
                            Log.d(DnsUtil.TAG, " backup ip " + arrayList + " for \"" + str.trim() + "\"");
                        }
                        hashMap.put("backup", arrayList);
                        return hashMap;
                    }
                } else {
                    throw e;
                }
            }
            throw e;
        }
    }

    public static List<String> getIpListFromMapResult(Map<String, List<String>> map) {
        if (map != null) {
            if (map.containsKey("local")) {
                return map.get("local");
            }
            if (map.containsKey("backup")) {
                return map.get("backup");
            }
            return null;
        }
        return null;
    }

    public static synchronized int getsMbaiduIPIndex(int i) {
        int i2;
        synchronized (LocalDnsPolicy.class) {
            if (sMbaiduIPIndex >= i || sMbaiduIPIndex < 0) {
                sMbaiduIPIndex = 0;
            }
            i2 = sMbaiduIPIndex;
            sMbaiduIPIndex = i2 + 1;
        }
        return i2;
    }

    public static synchronized int getsMbdIPIndex(int i) {
        int i2;
        synchronized (LocalDnsPolicy.class) {
            if (sMbdIPIndex >= i || sMbdIPIndex < 0) {
                sMbdIPIndex = 0;
            }
            i2 = sMbdIPIndex;
            sMbdIPIndex = i2 + 1;
        }
        return i2;
    }

    public static boolean isBackUpIpFromMapResult(Map<String, List<String>> map) {
        if (map != null && map.containsKey("backup")) {
            return true;
        }
        return false;
    }
}
