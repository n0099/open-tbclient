package com.baidu.searchbox.dns.b;

import com.baidu.searchbox.dns.d.c;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public class a {
    public static List<String> d(String str) {
        Map<String, com.baidu.searchbox.dns.d.a.a> t;
        com.baidu.searchbox.dns.d.a.a aVar;
        com.baidu.searchbox.dns.d.a.b F = new c(false, str).F();
        if (F == null || F.t() == null || (t = F.t()) == null || t.isEmpty() || (aVar = t.get(str)) == null) {
            return null;
        }
        com.baidu.searchbox.dns.a.a.e().a(str, aVar);
        return aVar.getIpList();
    }
}
