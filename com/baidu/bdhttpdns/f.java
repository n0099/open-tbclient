package com.baidu.bdhttpdns;

import com.baidu.bdhttpdns.BDHttpDnsResult;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
final class f {
    private static volatile f afK;

    /* loaded from: classes6.dex */
    interface a {
        void a(int i, ArrayList<String> arrayList, ArrayList<String> arrayList2, long j, String str);
    }

    /* loaded from: classes6.dex */
    private class b implements Runnable {
        private a afL;

        /* renamed from: b  reason: collision with root package name */
        private String f1628b;

        public b(String str, a aVar) {
            this.f1628b = str;
            this.afL = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            ArrayList<String> arrayList;
            ArrayList<String> arrayList2;
            Map b2 = f.this.b(this.f1628b);
            if (b2 != null) {
                arrayList = (ArrayList) b2.get("ipv6");
                arrayList2 = (ArrayList) b2.get("ipv4");
            } else {
                arrayList = null;
                arrayList2 = null;
            }
            this.afL.a(((arrayList2 == null || arrayList2.isEmpty()) && (arrayList == null || arrayList.isEmpty())) ? -1 : 0, arrayList2, arrayList, 60L, this.f1628b);
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
    public static f sD() {
        if (afK == null) {
            synchronized (f.class) {
                if (afK == null) {
                    afK = new f();
                }
            }
        }
        return afK;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, a aVar) {
        if (str == null || str.isEmpty()) {
            return;
        }
        m.sG().b().execute(new b(str, aVar));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BDHttpDnsResult de(String str) {
        ArrayList arrayList;
        ArrayList arrayList2;
        Map<String, ArrayList> b2 = b(str);
        if (b2 != null) {
            arrayList = b2.get("ipv6");
            arrayList2 = b2.get("ipv4");
        } else {
            arrayList = null;
            arrayList2 = null;
        }
        return ((arrayList2 == null || arrayList2.isEmpty()) && (arrayList == null || arrayList.isEmpty())) ? new BDHttpDnsResult(BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveErrorDnsResolve) : new BDHttpDnsResult(BDHttpDnsResult.ResolveType.RESOLVE_FROM_DNS, BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveOK, arrayList2, arrayList);
    }
}
