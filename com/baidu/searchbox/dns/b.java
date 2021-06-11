package com.baidu.searchbox.dns;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.dns.c.a;
import com.baidu.searchbox.dns.util.DnsUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: i  reason: collision with root package name */
    public static List<String> f10078i = null;
    public static boolean j = false;

    public static DnsParseResult a(String str, boolean z) {
        List<String> list = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int i2 = 0;
        com.baidu.searchbox.dns.c.a k = new a.C0134a(System.currentTimeMillis(), com.baidu.searchbox.dns.d.b.o().a(str, false, 2), com.baidu.searchbox.dns.a.a.e().c(str)).k();
        com.baidu.searchbox.dns.d.a i3 = k.i();
        com.baidu.searchbox.dns.d.a.a h2 = k.h();
        int j2 = k.j();
        if (h2 != null) {
            list = a(h2, DnsUtil.stackType);
            if (list == null || list.isEmpty()) {
                j2 = 1006;
            } else {
                if (j2 == 1001) {
                    z = true;
                }
                if (DnsUtil.DEBUG) {
                    Log.d(DnsUtil.TAG, "DnsEngine getIplist -> cache response hit: " + str + " ip: " + a(list));
                }
                i2 = 2000;
            }
        }
        if (i3 != null && z) {
            if (i2 != 2000) {
                i2 = 1000;
            }
            i3.start();
            if (DnsUtil.DEBUG) {
                Log.d(DnsUtil.TAG, " DnsEngine getIplist -> trasmitTask start: " + str);
            }
        } else if (i3 == null) {
            if (DnsUtil.DEBUG) {
                Log.d(DnsUtil.TAG, " DnsEngine getIplist -> no need start transmitTask: " + str);
            }
            if (i2 == 0) {
                j2 = 4;
            }
        }
        return new DnsParseResult(list, i2, j2, DnsUtil.stackType);
    }

    public static DnsParseResult b(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        DnsParseResult a2 = a(str, !z);
        if (a2 != null) {
            List<String> ipList = a2.getIpList();
            int type = a2.getType();
            int subType = a2.getSubType();
            int stackType = a2.getStackType();
            if (ipList == null || ipList.isEmpty()) {
                if (z) {
                    int i2 = 2000;
                    int i3 = 2002;
                    List<String> g2 = com.baidu.searchbox.dns.b.a.g(str);
                    if (g2 == null || g2.isEmpty()) {
                        i3 = 3;
                        i2 = 0;
                    }
                    if (DnsUtil.DEBUG) {
                        Log.d(DnsUtil.TAG, "DnsEngine getIplist -> wait http dns request: " + str + " ip: " + a(g2));
                    }
                    subType = i3;
                    ipList = g2;
                    type = i2;
                }
                if (ipList == null || ipList.isEmpty()) {
                    Map<String, List<String>> h2 = com.baidu.searchbox.dns.b.b.h(str);
                    ipList = com.baidu.searchbox.dns.b.b.a(h2);
                    if (com.baidu.searchbox.dns.b.b.b(h2)) {
                        subType = 5;
                    }
                    if (DnsUtil.DEBUG) {
                        Log.d(DnsUtil.TAG, "DnsEngine getIplist -> use local dns:" + str + " ip: " + a(ipList));
                    }
                }
            }
            if (DnsUtil.DEBUG) {
                Log.d(DnsUtil.TAG, "Dns parse result type: " + type + " subtype: " + subType);
            }
            return new DnsParseResult(ipList, type, subType, stackType);
        }
        return a2;
    }

    public static synchronized void d() {
        synchronized (b.class) {
            if (f10078i != null && f10078i.size() > 0) {
                for (String str : f10078i) {
                    b(str);
                }
            }
        }
    }

    public static void forceUpdateDomain(String str) {
        a(str);
        b(str);
    }

    public static DnsParseResult getParseResult(String str) {
        return b(str, false);
    }

    public static synchronized void a(String str) {
        synchronized (b.class) {
            if (f10078i == null) {
                f10078i = new ArrayList(4);
            }
            if (!f10078i.contains(str)) {
                f10078i.add(str);
            }
        }
    }

    public static void b(String str) {
        DnsUtil.initNetworkStackType();
        com.baidu.searchbox.dns.d.a a2 = com.baidu.searchbox.dns.d.b.o().a(str, true, 1);
        if (a2 != null) {
            if (DnsUtil.DEBUG) {
                Log.d(DnsUtil.TAG, " start update domain task: " + str);
            }
            a2.start();
        }
    }

    public static String a(List<String> list) {
        if (!DnsUtil.DEBUG || list == null || list.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (String str : list) {
            sb.append(str);
            sb.append(" | ");
        }
        return sb.toString();
    }

    public static List<String> a(com.baidu.searchbox.dns.d.a.a aVar, int i2) {
        if (i2 == 3) {
            return a(aVar, j);
        }
        if (i2 == 1) {
            return a(aVar, false);
        }
        if (i2 == 2) {
            return a(aVar, true);
        }
        return a(aVar, false);
    }

    public static List<String> a(com.baidu.searchbox.dns.d.a.a aVar, boolean z) {
        return aVar.getIpList();
    }
}
