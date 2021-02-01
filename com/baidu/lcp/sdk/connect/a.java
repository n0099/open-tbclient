package com.baidu.lcp.sdk.connect;

import android.content.Context;
import com.baidu.searchbox.dns.DnsHelper;
import com.baidu.searchbox.dns.statistics.HttpDNSStat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes3.dex */
public class a {
    private static int aux = 3;
    public static List<String> auy = Collections.synchronizedList(new ArrayList());
    public static int auz = 0;
    private static Context context;

    /* loaded from: classes3.dex */
    public interface b {
        void a(String str, d dVar);

        void q(String str, boolean z);
    }

    /* loaded from: classes3.dex */
    public interface d {
        void c(int i, String str, String str2);
    }

    public static b aB(Context context2) {
        context = context2.getApplicationContext();
        int aI = com.baidu.lcp.sdk.d.b.aI(context2);
        if (aI == 1 || aI == 2) {
            aux = 0;
            return c.vG();
        } else if (com.baidu.lcp.sdk.d.e.getBdDnsEnable(context2) && aux == 2) {
            return C0151a.aC(context2);
        } else {
            if (aux == 3) {
                return e.aD(context2);
            }
            return c.vG();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class c implements b {
        private static c auH;

        private c() {
        }

        public static synchronized b vG() {
            c cVar;
            synchronized (c.class) {
                if (auH == null) {
                    auH = new c();
                }
                cVar = auH;
            }
            return cVar;
        }

        @Override // com.baidu.lcp.sdk.connect.a.b
        public void a(String str, d dVar) {
            com.baidu.lcp.sdk.d.d.i("DNSUrlProvider", "DefaultUrlProvider try to getUrlAsync");
            com.baidu.lcp.sdk.a.d.writeLoginFlag(a.context, "12N", "DefaultUrlProvider begin");
            if (dVar != null) {
                a.vD();
                com.baidu.lcp.sdk.a.d.writeLoginFlag(a.context, "12Y", "DefaultUrlProvider begin");
                dVar.c(0, "ok", str);
            }
        }

        @Override // com.baidu.lcp.sdk.connect.a.b
        public void q(String str, boolean z) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class e implements b {
        private static e auI;

        private e(Context context) {
            Context unused = a.context = context.getApplicationContext();
        }

        public static synchronized e aD(Context context) {
            e eVar;
            synchronized (e.class) {
                if (auI == null) {
                    auI = new e(context);
                }
                eVar = auI;
            }
            return eVar;
        }

        @Override // com.baidu.lcp.sdk.connect.a.b
        public void a(String str, d dVar) {
            com.baidu.lcp.sdk.d.d.d("DNSUrlProvider", "will getLCPHttpDnsAddress......");
            try {
                com.baidu.lcp.sdk.b.d dVar2 = new com.baidu.lcp.sdk.b.d(a.context);
                dVar2.a(dVar);
                com.baidu.lcp.sdk.b.c.a(dVar2, dVar2);
            } catch (Exception e) {
                a.aS(true);
                a.aB(a.context).a(str, dVar);
            }
        }

        @Override // com.baidu.lcp.sdk.connect.a.b
        public void q(String str, boolean z) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.lcp.sdk.connect.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0151a implements b {
        private static C0151a auA;

        public static synchronized C0151a aC(Context context) {
            C0151a c0151a;
            synchronized (C0151a.class) {
                if (auA == null) {
                    auA = new C0151a(context);
                }
                c0151a = auA;
            }
            return c0151a;
        }

        private C0151a(Context context) {
            Context unused = a.context = context.getApplicationContext();
            a.vD();
        }

        @Override // com.baidu.lcp.sdk.connect.a.b
        public void a(final String str, final d dVar) {
            try {
                com.baidu.lcp.sdk.d.d.i("DNSUrlProvider", "BDHttpDNSUrlProvider try to getUrlAsync");
                if (a.auy == null || a.auy.size() <= 0) {
                    com.baidu.lcp.sdk.a.d.writeLoginFlag(a.context, "11N", "BDDNS begin");
                    final Timer timer = new Timer();
                    com.baidu.lcp.sdk.c.a.aF(a.context).submitForNetWork(new Runnable() { // from class: com.baidu.lcp.sdk.connect.a.a.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.baidu.lcp.sdk.d.d.d("DNSUrlProvider", "bddns > getUrlAsync in... host is " + str);
                            final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
                            timer.schedule(new TimerTask() { // from class: com.baidu.lcp.sdk.connect.a.a.1.1
                                @Override // java.util.TimerTask, java.lang.Runnable
                                public void run() {
                                    com.baidu.lcp.sdk.d.d.d("DNSUrlProvider", "bddns > bdDnsIps is null");
                                    com.baidu.lcp.sdk.a.d.writeLoginFlag(a.context, "11N_3", "BDDNS timeout");
                                    if (dVar != null) {
                                        dVar.c(8007, "bddns timeout :", "bddns timeout, bdDnsIps is null");
                                        a.aS(true);
                                        a.aB(a.context).a(str, dVar);
                                    }
                                    atomicBoolean.set(true);
                                }
                            }, 10000L);
                            DnsHelper dnsHelper = new DnsHelper(a.context);
                            dnsHelper.setHttpDnsState(false, (HttpDNSStat) null, false, true);
                            a.s(dnsHelper.getIpList(str));
                            com.baidu.lcp.sdk.a.d.writeLoginFlag(a.context, "11N_1", "BDDNS get ips");
                            if (a.auy != null && a.auy.size() > 0) {
                                com.baidu.lcp.sdk.d.d.d("DNSUrlProvider", "bddns > bdDnsIps = " + a.auy);
                                String str2 = a.auy.get(0);
                                com.baidu.lcp.sdk.a.d.writeLoginFlag(a.context, "11Y", "BDDNS success");
                                if (dVar != null && !atomicBoolean.get()) {
                                    dVar.c(0, "ok", str2);
                                    if (a.auy.size() > 1) {
                                        a.auz++;
                                        a.aS(false);
                                    }
                                }
                                com.baidu.lcp.sdk.d.d.d("DNSUrlProvider", "bddns > return ip = " + str2);
                                timer.cancel();
                            }
                        }
                    });
                } else if (a.auz < a.auy.size()) {
                    com.baidu.lcp.sdk.a.d.writeLoginFlag(a.context, "11Y", "BDDNS retry success");
                    if (dVar != null) {
                        dVar.c(0, "ok", a.auy.get(a.auz));
                        com.baidu.lcp.sdk.d.d.d("DNSUrlProvider", "retry bddns > return ip = " + a.auy.get(a.auz));
                    }
                    a.auz++;
                } else {
                    a.aS(true);
                    a.aB(a.context).a(str, dVar);
                }
            } catch (Throwable th) {
                com.baidu.lcp.sdk.a.d.writeLoginFlag(a.context, "11N_2", "BDDNS exception, HTTPDNS begin");
                com.baidu.lcp.sdk.d.d.d("DNSUrlProvider", "bddns > bdDnsIps get exception ");
                a.aS(true);
                a.aB(a.context).a(str, dVar);
            }
        }

        @Override // com.baidu.lcp.sdk.connect.a.b
        public void q(String str, boolean z) {
        }
    }

    public static void s(List<String> list) {
        auy.clear();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (list != null && !list.isEmpty()) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= list.size()) {
                    break;
                }
                if (isIpv4(list.get(i2))) {
                    arrayList.add(list.get(i2));
                } else {
                    arrayList2.add(list.get(i2));
                }
                i = i2 + 1;
            }
        }
        if (arrayList2.size() + arrayList.size() > 0) {
            int aQ = com.baidu.lcp.sdk.d.e.aQ(context);
            com.baidu.lcp.sdk.d.d.e("DNSUrlProvider", "getIpPriority :" + aQ + ", ipv4 :" + arrayList.toString() + ", ipv6 :" + arrayList2.toString());
            switch (aQ) {
                case 1:
                    auy.addAll(arrayList2);
                    return;
                case 2:
                    auy.addAll(arrayList2);
                    auy.addAll(arrayList);
                    return;
                case 3:
                default:
                    auy.addAll(arrayList);
                    auy.addAll(arrayList2);
                    return;
                case 4:
                    auy.addAll(arrayList);
                    return;
            }
        }
    }

    public static void C(Context context2, String str) {
        e(context2, str, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void vD() {
        try {
            auz = 0;
            auy.clear();
            aux = 3;
        } catch (Exception e2) {
            com.baidu.lcp.sdk.d.d.e("DNSUrlProvider", "resetBdDns exception", e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean vE() {
        return auy != null && auz <= auy.size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void e(Context context2, String str, boolean z) {
        vD();
        c.vG().q(str, true);
    }

    public static int aS(boolean z) {
        if (z) {
            int aI = com.baidu.lcp.sdk.d.b.aI(context);
            if (aI == 1 || aI == 2) {
                aux = 0;
            } else {
                switch (aux) {
                    case 0:
                        aux = 2;
                        break;
                    case 2:
                        aux = 3;
                        break;
                    case 3:
                        aux = 0;
                        break;
                }
            }
        }
        com.baidu.lcp.sdk.d.d.d("DNSUrlProvider", "try to connect ip, now policy =" + aux);
        return aux;
    }

    public static boolean isIpv4(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        return str.matches("^(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|[1-9])\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)$");
    }

    public static int vF() {
        return aux;
    }
}
