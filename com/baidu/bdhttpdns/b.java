package com.baidu.bdhttpdns;

import com.baidu.bdhttpdns.BDHttpDnsResult;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
final class b {
    private static volatile b EB;

    private b() {
    }

    private Map<String, ArrayList> b(String str) {
        try {
            InetAddress[] allByName = InetAddress.getAllByName(str);
            if (allByName == null || allByName.length == 0) {
                f.a("Dns resolve failed, host(%s), get empty resolve result", str);
                return null;
            }
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            HashMap hashMap = new HashMap();
            for (InetAddress inetAddress : allByName) {
                if (inetAddress instanceof Inet4Address) {
                    String hostAddress = inetAddress.getHostAddress();
                    if (a.a(hostAddress)) {
                        arrayList.add(hostAddress);
                    }
                } else if (inetAddress instanceof Inet6Address) {
                    String hostAddress2 = inetAddress.getHostAddress();
                    if (a.b(hostAddress2)) {
                        arrayList2.add(hostAddress2);
                    }
                }
            }
            hashMap.put("ipv4", arrayList);
            hashMap.put("ipv6", arrayList2);
            if (arrayList.isEmpty() && arrayList2.isEmpty()) {
                f.a("Dns resolve failed, host(%s), get no valid resolve result", str);
                return null;
            }
            f.a("Dns resolve successful, host(%s), ipv4List(%s), ipv6List(%s)", str, arrayList.toString(), arrayList2.toString());
            return hashMap;
        } catch (UnknownHostException e) {
            e.printStackTrace();
            f.a("Dns resolve failed, host(%s), caught UnknownHostException", str);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b lC() {
        if (EB == null) {
            synchronized (b.class) {
                if (EB == null) {
                    EB = new b();
                }
            }
        }
        return EB;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BDHttpDnsResult br(String str) {
        ArrayList arrayList;
        ArrayList arrayList2 = null;
        Map<String, ArrayList> b = b(str);
        if (b != null) {
            arrayList2 = b.get("ipv6");
            arrayList = b.get("ipv4");
        } else {
            arrayList = null;
        }
        return ((arrayList == null || arrayList.isEmpty()) && (arrayList2 == null || arrayList2.isEmpty())) ? new BDHttpDnsResult(BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveErrorDnsResolve) : new BDHttpDnsResult(BDHttpDnsResult.ResolveType.RESOLVE_FROM_DNS, BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveOK, arrayList, arrayList2);
    }
}
