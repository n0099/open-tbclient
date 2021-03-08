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
    private static int avX = 3;
    public static List<String> avY = Collections.synchronizedList(new ArrayList());
    public static int avZ = 0;
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

    public static b aA(Context context2) {
        context = context2.getApplicationContext();
        int aH = com.baidu.lcp.sdk.d.b.aH(context2);
        if (aH == 1 || aH == 2) {
            avX = 0;
            return c.vJ();
        } else if (com.baidu.lcp.sdk.d.e.getBdDnsEnable(context2) && avX == 2) {
            return C0157a.aB(context2);
        } else {
            if (avX == 3) {
                return e.aC(context2);
            }
            return c.vJ();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class c implements b {
        private static c awh;

        private c() {
        }

        public static synchronized b vJ() {
            c cVar;
            synchronized (c.class) {
                if (awh == null) {
                    awh = new c();
                }
                cVar = awh;
            }
            return cVar;
        }

        @Override // com.baidu.lcp.sdk.connect.a.b
        public void a(String str, d dVar) {
            com.baidu.lcp.sdk.d.d.i("DNSUrlProvider", "DefaultUrlProvider try to getUrlAsync");
            com.baidu.lcp.sdk.a.d.writeLoginFlag(a.context, "12N", "DefaultUrlProvider begin");
            if (dVar != null) {
                a.vG();
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
        private static e awi;

        private e(Context context) {
            Context unused = a.context = context.getApplicationContext();
        }

        public static synchronized e aC(Context context) {
            e eVar;
            synchronized (e.class) {
                if (awi == null) {
                    awi = new e(context);
                }
                eVar = awi;
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
                a.aA(a.context).a(str, dVar);
            }
        }

        @Override // com.baidu.lcp.sdk.connect.a.b
        public void q(String str, boolean z) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.lcp.sdk.connect.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0157a implements b {
        private static C0157a awa;

        public static synchronized C0157a aB(Context context) {
            C0157a c0157a;
            synchronized (C0157a.class) {
                if (awa == null) {
                    awa = new C0157a(context);
                }
                c0157a = awa;
            }
            return c0157a;
        }

        private C0157a(Context context) {
            Context unused = a.context = context.getApplicationContext();
            a.vG();
        }

        @Override // com.baidu.lcp.sdk.connect.a.b
        public void a(final String str, final d dVar) {
            try {
                com.baidu.lcp.sdk.d.d.i("DNSUrlProvider", "BDHttpDNSUrlProvider try to getUrlAsync");
                if (a.avY == null || a.avY.size() <= 0) {
                    com.baidu.lcp.sdk.a.d.writeLoginFlag(a.context, "11N", "BDDNS begin");
                    final Timer timer = new Timer();
                    com.baidu.lcp.sdk.c.a.aE(a.context).submitForNetWork(new Runnable() { // from class: com.baidu.lcp.sdk.connect.a.a.1
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
                                        a.aA(a.context).a(str, dVar);
                                    }
                                    atomicBoolean.set(true);
                                }
                            }, 10000L);
                            DnsHelper dnsHelper = new DnsHelper(a.context);
                            dnsHelper.setHttpDnsState(false, (HttpDNSStat) null, false, true);
                            a.s(dnsHelper.getIpList(str));
                            com.baidu.lcp.sdk.a.d.writeLoginFlag(a.context, "11N_1", "BDDNS get ips");
                            if (a.avY != null && a.avY.size() > 0) {
                                com.baidu.lcp.sdk.d.d.d("DNSUrlProvider", "bddns > bdDnsIps = " + a.avY);
                                String str2 = a.avY.get(0);
                                com.baidu.lcp.sdk.a.d.writeLoginFlag(a.context, "11Y", "BDDNS success");
                                if (dVar != null && !atomicBoolean.get()) {
                                    dVar.c(0, "ok", str2);
                                    if (a.avY.size() > 1) {
                                        a.avZ++;
                                        a.aS(false);
                                    }
                                }
                                com.baidu.lcp.sdk.d.d.d("DNSUrlProvider", "bddns > return ip = " + str2);
                                timer.cancel();
                            }
                        }
                    });
                } else if (a.avZ < a.avY.size()) {
                    com.baidu.lcp.sdk.a.d.writeLoginFlag(a.context, "11Y", "BDDNS retry success");
                    if (dVar != null) {
                        dVar.c(0, "ok", a.avY.get(a.avZ));
                        com.baidu.lcp.sdk.d.d.d("DNSUrlProvider", "retry bddns > return ip = " + a.avY.get(a.avZ));
                    }
                    a.avZ++;
                } else {
                    a.aS(true);
                    a.aA(a.context).a(str, dVar);
                }
            } catch (Throwable th) {
                com.baidu.lcp.sdk.a.d.writeLoginFlag(a.context, "11N_2", "BDDNS exception, HTTPDNS begin");
                com.baidu.lcp.sdk.d.d.d("DNSUrlProvider", "bddns > bdDnsIps get exception ");
                a.aS(true);
                a.aA(a.context).a(str, dVar);
            }
        }

        @Override // com.baidu.lcp.sdk.connect.a.b
        public void q(String str, boolean z) {
        }
    }

    public static void s(List<String> list) {
        avY.clear();
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
            int aP = com.baidu.lcp.sdk.d.e.aP(context);
            com.baidu.lcp.sdk.d.d.e("DNSUrlProvider", "getIpPriority :" + aP + ", ipv4 :" + arrayList.toString() + ", ipv6 :" + arrayList2.toString());
            switch (aP) {
                case 1:
                    avY.addAll(arrayList2);
                    return;
                case 2:
                    avY.addAll(arrayList2);
                    avY.addAll(arrayList);
                    return;
                case 3:
                default:
                    avY.addAll(arrayList);
                    avY.addAll(arrayList2);
                    return;
                case 4:
                    avY.addAll(arrayList);
                    return;
            }
        }
    }

    public static void C(Context context2, String str) {
        e(context2, str, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void vG() {
        try {
            avZ = 0;
            avY.clear();
            avX = 3;
        } catch (Exception e2) {
            com.baidu.lcp.sdk.d.d.e("DNSUrlProvider", "resetBdDns exception", e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean vH() {
        return avY != null && avZ <= avY.size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void e(Context context2, String str, boolean z) {
        vG();
        c.vJ().q(str, true);
    }

    public static int aS(boolean z) {
        if (z) {
            int aH = com.baidu.lcp.sdk.d.b.aH(context);
            if (aH == 1 || aH == 2) {
                avX = 0;
            } else {
                switch (avX) {
                    case 0:
                        avX = 2;
                        break;
                    case 2:
                        avX = 3;
                        break;
                    case 3:
                        avX = 0;
                        break;
                }
            }
        }
        com.baidu.lcp.sdk.d.d.d("DNSUrlProvider", "try to connect ip, now policy =" + avX);
        return avX;
    }

    public static boolean isIpv4(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        return str.matches("^(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|[1-9])\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)$");
    }

    public static int vI() {
        return avX;
    }
}
