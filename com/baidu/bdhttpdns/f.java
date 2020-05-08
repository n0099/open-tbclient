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
final class f {
    private static volatile f aaU;

    /* loaded from: classes.dex */
    interface a {
        void a(int i, ArrayList<String> arrayList, ArrayList<String> arrayList2, long j, String str);
    }

    /* loaded from: classes.dex */
    private class b implements Runnable {
        private a aaV;
        private String b;

        public b(String str, a aVar) {
            this.b = str;
            this.aaV = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            ArrayList<String> arrayList;
            ArrayList<String> arrayList2 = null;
            Map b = f.this.b(this.b);
            if (b != null) {
                arrayList2 = (ArrayList) b.get("ipv6");
                arrayList = (ArrayList) b.get("ipv4");
            } else {
                arrayList = null;
            }
            this.aaV.a(((arrayList == null || arrayList.isEmpty()) && (arrayList2 == null || arrayList2.isEmpty())) ? -1 : 0, arrayList, arrayList2, 60L, this.b);
        }
    }

    private f() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, ArrayList> b(String str) {
        try {
            InetAddress[] allByName = InetAddress.getAllByName(str);
            if (allByName == null || allByName.length == 0) {
                l.a("Dns resolve failed, host(%s), get empty resolve result", str);
                return null;
            }
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            HashMap hashMap = new HashMap();
            for (InetAddress inetAddress : allByName) {
                if (inetAddress instanceof Inet4Address) {
                    String hostAddress = inetAddress.getHostAddress();
                    if (e.a(hostAddress)) {
                        arrayList.add(hostAddress);
                    }
                } else if (inetAddress instanceof Inet6Address) {
                    String hostAddress2 = inetAddress.getHostAddress();
                    if (e.b(hostAddress2)) {
                        arrayList2.add(hostAddress2);
                    }
                }
            }
            hashMap.put("ipv4", arrayList);
            hashMap.put("ipv6", arrayList2);
            if (arrayList.isEmpty() && arrayList2.isEmpty()) {
                l.a("Dns resolve failed, host(%s), get no valid resolve result", str);
                return null;
            }
            l.a("Dns resolve successful, host(%s), ipv4List(%s), ipv6List(%s)", str, arrayList.toString(), arrayList2.toString());
            return hashMap;
        } catch (UnknownHostException e) {
            e.printStackTrace();
            l.a("Dns resolve failed, host(%s), caught UnknownHostException", str);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static f qK() {
        if (aaU == null) {
            synchronized (f.class) {
                if (aaU == null) {
                    aaU = new f();
                }
            }
        }
        return aaU;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, a aVar) {
        if (str == null || str.isEmpty()) {
            return;
        }
        m.qN().b().execute(new b(str, aVar));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BDHttpDnsResult cS(String str) {
        ArrayList arrayList;
        ArrayList arrayList2 = null;
        Map<String, ArrayList> b2 = b(str);
        if (b2 != null) {
            arrayList2 = b2.get("ipv6");
            arrayList = b2.get("ipv4");
        } else {
            arrayList = null;
        }
        return ((arrayList == null || arrayList.isEmpty()) && (arrayList2 == null || arrayList2.isEmpty())) ? new BDHttpDnsResult(BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveErrorDnsResolve) : new BDHttpDnsResult(BDHttpDnsResult.ResolveType.RESOLVE_FROM_DNS, BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveOK, arrayList, arrayList2);
    }
}
