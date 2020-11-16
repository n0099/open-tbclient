package com.baidu.searchbox.dns.b;

import com.baidu.searchbox.dns.d.c;
import java.util.List;
import java.util.Map;
/* loaded from: classes8.dex */
public class a {
    public static List<String> g(String str) {
        Map<String, com.baidu.searchbox.dns.d.a.a> B;
        com.baidu.searchbox.dns.d.a.a aVar;
        com.baidu.searchbox.dns.d.a.b x = new c(false, str, 2).x();
        if (x == null || x.B() == null || (B = x.B()) == null || B.isEmpty() || (aVar = B.get(str)) == null) {
            return null;
        }
        com.baidu.searchbox.dns.a.a.e().a(str, aVar);
        return aVar.getIpList();
    }
}
