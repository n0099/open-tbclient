package com.baidu.searchbox.dns;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.dns.c.a;
import com.baidu.searchbox.dns.util.DnsUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes12.dex */
public class b {
    static List<String> i;
    public static boolean j = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static DnsParseResult a(String str, boolean z) {
        int i2;
        List<String> list;
        int i3;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        com.baidu.searchbox.dns.c.a k = new a.C0170a(System.currentTimeMillis(), com.baidu.searchbox.dns.d.b.o().a(str, false, 2), com.baidu.searchbox.dns.a.a.e().c(str)).k();
        com.baidu.searchbox.dns.d.a i4 = k.i();
        com.baidu.searchbox.dns.d.a.a h = k.h();
        int j2 = k.j();
        if (h != null) {
            List<String> a = a(h, DnsUtil.stackType);
            if (a == null || a.isEmpty()) {
                list = a;
                i3 = 0;
                i2 = 1006;
            } else {
                if (j2 == 1001) {
                    z = true;
                }
                if (DnsUtil.DEBUG) {
                    Log.d(DnsUtil.TAG, "DnsEngine getIplist -> cache response hit: " + str + " ip: " + a(a));
                }
                i3 = 2000;
                i2 = j2;
                list = a;
            }
        } else {
            i2 = j2;
            list = null;
            i3 = 0;
        }
        if (i4 != null && z) {
            if (i3 != 2000) {
                i3 = 1000;
            }
            i4.start();
            if (DnsUtil.DEBUG) {
                Log.d(DnsUtil.TAG, " DnsEngine getIplist -> trasmitTask start: " + str);
            }
        } else if (i4 == null) {
            if (DnsUtil.DEBUG) {
                Log.d(DnsUtil.TAG, " DnsEngine getIplist -> no need start transmitTask: " + str);
            }
            if (i3 == 0) {
                i2 = 4;
            }
        }
        return new DnsParseResult(list, i3, i2, DnsUtil.stackType);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static DnsParseResult getParseResult(String str) {
        return b(str, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static DnsParseResult b(String str, boolean z) {
        List<String> list;
        int i2 = 0;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        DnsParseResult a = a(str, !z);
        if (a != null) {
            List<String> ipList = a.getIpList();
            int type = a.getType();
            int subType = a.getSubType();
            int stackType = a.getStackType();
            if (ipList == null || ipList.isEmpty()) {
                if (z) {
                    subType = 2002;
                    List<String> g = com.baidu.searchbox.dns.b.a.g(str);
                    if (g != null && !g.isEmpty()) {
                        i2 = 2000;
                    } else {
                        subType = 3;
                    }
                    if (DnsUtil.DEBUG) {
                        Log.d(DnsUtil.TAG, "DnsEngine getIplist -> wait http dns request: " + str + " ip: " + a(g));
                    }
                    list = g;
                } else {
                    i2 = type;
                    list = ipList;
                }
                if (list == null || list.isEmpty()) {
                    Map<String, List<String>> h = com.baidu.searchbox.dns.b.b.h(str);
                    list = com.baidu.searchbox.dns.b.b.a(h);
                    if (com.baidu.searchbox.dns.b.b.b(h)) {
                        subType = 5;
                    }
                    if (DnsUtil.DEBUG) {
                        Log.d(DnsUtil.TAG, "DnsEngine getIplist -> use local dns:" + str + " ip: " + a(list));
                    }
                }
            } else {
                i2 = type;
                list = ipList;
            }
            if (DnsUtil.DEBUG) {
                Log.d(DnsUtil.TAG, "Dns parse result type: " + i2 + " subtype: " + subType);
            }
            return new DnsParseResult(list, i2, subType, stackType);
        }
        return a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void forceUpdateDomain(String str) {
        a(str);
        b(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void d() {
        synchronized (b.class) {
            if (i != null && i.size() > 0) {
                for (String str : i) {
                    b(str);
                }
            }
        }
    }

    private static synchronized void a(String str) {
        synchronized (b.class) {
            if (i == null) {
                i = new ArrayList(4);
            }
            if (!i.contains(str)) {
                i.add(str);
            }
        }
    }

    private static void b(String str) {
        DnsUtil.initNetworkStackType();
        com.baidu.searchbox.dns.d.a a = com.baidu.searchbox.dns.d.b.o().a(str, true, 1);
        if (a != null) {
            if (DnsUtil.DEBUG) {
                Log.d(DnsUtil.TAG, " start update domain task: " + str);
            }
            a.start();
        }
    }

    private static String a(List<String> list) {
        if (!DnsUtil.DEBUG || list == null || list.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (String str : list) {
            sb.append(str).append(" | ");
        }
        return sb.toString();
    }

    private static List<String> a(com.baidu.searchbox.dns.d.a.a aVar, int i2) {
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

    private static List<String> a(com.baidu.searchbox.dns.d.a.a aVar, boolean z) {
        return aVar.getIpList();
    }
}
