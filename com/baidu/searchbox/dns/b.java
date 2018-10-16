package com.baidu.searchbox.dns;

import android.text.TextUtils;
import com.baidu.searchbox.dns.c.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class b {
    static List<String> i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static DnsParseResult a(String str, boolean z) {
        List<String> list;
        int i2;
        int i3;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        com.baidu.searchbox.dns.c.a i4 = new a.C0103a(System.currentTimeMillis(), com.baidu.searchbox.dns.d.b.m().c(str, false), com.baidu.searchbox.dns.a.a.e().c(str)).i();
        com.baidu.searchbox.dns.d.a g = i4.g();
        com.baidu.searchbox.dns.d.a.a f = i4.f();
        int h = i4.h();
        if (f != null) {
            list = f.getIpList();
            if (list == null || list.isEmpty()) {
                i3 = 1006;
                i2 = 0;
            } else {
                i2 = 2000;
                if (h == 1001) {
                    z = true;
                    i3 = h;
                } else {
                    i3 = h;
                }
            }
        } else {
            list = null;
            i2 = 0;
            i3 = h;
        }
        if (g != null && z) {
            i2 = 1000;
            g.start();
        } else if (g == null && i2 == 0) {
            i3 = 4;
        }
        return new DnsParseResult(list, i2, i3);
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
            if (ipList == null || ipList.isEmpty()) {
                if (z) {
                    type = 2000;
                    subType = 2002;
                    ipList = com.baidu.searchbox.dns.b.a.d(str);
                    if (ipList == null || ipList.isEmpty()) {
                        subType = 3;
                        list = ipList;
                        if (list != null || list.isEmpty()) {
                            list = com.baidu.searchbox.dns.b.b.d(str);
                        }
                    }
                }
                i2 = type;
                list = ipList;
                if (list != null) {
                }
                list = com.baidu.searchbox.dns.b.b.d(str);
            } else {
                i2 = type;
                list = ipList;
            }
            return new DnsParseResult(list, i2, subType);
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
        com.baidu.searchbox.dns.d.a c = com.baidu.searchbox.dns.d.b.m().c(str, true);
        if (c != null) {
            c.start();
        }
    }
}
