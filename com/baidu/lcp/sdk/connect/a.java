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
    private static int azv = 3;
    public static List<String> azw = Collections.synchronizedList(new ArrayList());
    public static int azx = 0;
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

    public static b aC(Context context2) {
        context = context2.getApplicationContext();
        int aJ = com.baidu.lcp.sdk.d.b.aJ(context2);
        if (aJ == 1 || aJ == 2) {
            azv = 0;
            return c.zE();
        } else if (com.baidu.lcp.sdk.d.e.getBdDnsEnable(context2) && azv == 2) {
            return C0160a.aD(context2);
        } else {
            if (azv == 3) {
                return e.aE(context2);
            }
            return c.zE();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class c implements b {
        private static c azF;

        private c() {
        }

        public static synchronized b zE() {
            c cVar;
            synchronized (c.class) {
                if (azF == null) {
                    azF = new c();
                }
                cVar = azF;
            }
            return cVar;
        }

        @Override // com.baidu.lcp.sdk.connect.a.b
        public void a(String str, d dVar) {
            com.baidu.lcp.sdk.d.d.i("DNSUrlProvider", "DefaultUrlProvider try to getUrlAsync");
            com.baidu.lcp.sdk.a.d.writeLoginFlag(a.context, "12N", "DefaultUrlProvider begin");
            if (dVar != null) {
                a.zB();
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
        private static e azG;

        private e(Context context) {
            Context unused = a.context = context.getApplicationContext();
        }

        public static synchronized e aE(Context context) {
            e eVar;
            synchronized (e.class) {
                if (azG == null) {
                    azG = new e(context);
                }
                eVar = azG;
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
                a.aW(true);
                a.aC(a.context).a(str, dVar);
            }
        }

        @Override // com.baidu.lcp.sdk.connect.a.b
        public void q(String str, boolean z) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.lcp.sdk.connect.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0160a implements b {
        private static C0160a azy;

        public static synchronized C0160a aD(Context context) {
            C0160a c0160a;
            synchronized (C0160a.class) {
                if (azy == null) {
                    azy = new C0160a(context);
                }
                c0160a = azy;
            }
            return c0160a;
        }

        private C0160a(Context context) {
            Context unused = a.context = context.getApplicationContext();
            a.zB();
        }

        @Override // com.baidu.lcp.sdk.connect.a.b
        public void a(final String str, final d dVar) {
            try {
                com.baidu.lcp.sdk.d.d.i("DNSUrlProvider", "BDHttpDNSUrlProvider try to getUrlAsync");
                if (a.azw == null || a.azw.size() <= 0) {
                    com.baidu.lcp.sdk.a.d.writeLoginFlag(a.context, "11N", "BDDNS begin");
                    final Timer timer = new Timer();
                    com.baidu.lcp.sdk.c.a.aG(a.context).submitForNetWork(new Runnable() { // from class: com.baidu.lcp.sdk.connect.a.a.1
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
                                        a.aW(true);
                                        a.aC(a.context).a(str, dVar);
                                    }
                                    atomicBoolean.set(true);
                                }
                            }, 10000L);
                            DnsHelper dnsHelper = new DnsHelper(a.context);
                            dnsHelper.setHttpDnsState(false, (HttpDNSStat) null, false, true);
                            a.s(dnsHelper.getIpList(str));
                            com.baidu.lcp.sdk.a.d.writeLoginFlag(a.context, "11N_1", "BDDNS get ips");
                            if (a.azw != null && a.azw.size() > 0) {
                                com.baidu.lcp.sdk.d.d.d("DNSUrlProvider", "bddns > bdDnsIps = " + a.azw);
                                String str2 = a.azw.get(0);
                                com.baidu.lcp.sdk.a.d.writeLoginFlag(a.context, "11Y", "BDDNS success");
                                if (dVar != null && !atomicBoolean.get()) {
                                    dVar.c(0, "ok", str2);
                                    if (a.azw.size() > 1) {
                                        a.azx++;
                                        a.aW(false);
                                    }
                                }
                                com.baidu.lcp.sdk.d.d.d("DNSUrlProvider", "bddns > return ip = " + str2);
                                timer.cancel();
                            }
                        }
                    });
                } else if (a.azx < a.azw.size()) {
                    com.baidu.lcp.sdk.a.d.writeLoginFlag(a.context, "11Y", "BDDNS retry success");
                    if (dVar != null) {
                        dVar.c(0, "ok", a.azw.get(a.azx));
                        com.baidu.lcp.sdk.d.d.d("DNSUrlProvider", "retry bddns > return ip = " + a.azw.get(a.azx));
                    }
                    a.azx++;
                } else {
                    a.aW(true);
                    a.aC(a.context).a(str, dVar);
                }
            } catch (Throwable th) {
                com.baidu.lcp.sdk.a.d.writeLoginFlag(a.context, "11N_2", "BDDNS exception, HTTPDNS begin");
                com.baidu.lcp.sdk.d.d.d("DNSUrlProvider", "bddns > bdDnsIps get exception ");
                a.aW(true);
                a.aC(a.context).a(str, dVar);
            }
        }

        @Override // com.baidu.lcp.sdk.connect.a.b
        public void q(String str, boolean z) {
        }
    }

    public static void s(List<String> list) {
        azw.clear();
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
            int aR = com.baidu.lcp.sdk.d.e.aR(context);
            com.baidu.lcp.sdk.d.d.e("DNSUrlProvider", "getIpPriority :" + aR + ", ipv4 :" + arrayList.toString() + ", ipv6 :" + arrayList2.toString());
            switch (aR) {
                case 1:
                    azw.addAll(arrayList2);
                    return;
                case 2:
                    azw.addAll(arrayList2);
                    azw.addAll(arrayList);
                    return;
                case 3:
                default:
                    azw.addAll(arrayList);
                    azw.addAll(arrayList2);
                    return;
                case 4:
                    azw.addAll(arrayList);
                    return;
            }
        }
    }

    public static void C(Context context2, String str) {
        e(context2, str, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zB() {
        try {
            azx = 0;
            azw.clear();
            azv = 3;
        } catch (Exception e2) {
            com.baidu.lcp.sdk.d.d.e("DNSUrlProvider", "resetBdDns exception", e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zC() {
        return azw != null && azx <= azw.size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void e(Context context2, String str, boolean z) {
        zB();
        c.zE().q(str, true);
    }

    public static int aW(boolean z) {
        if (z) {
            int aJ = com.baidu.lcp.sdk.d.b.aJ(context);
            if (aJ == 1 || aJ == 2) {
                azv = 0;
            } else {
                switch (azv) {
                    case 0:
                        azv = 2;
                        break;
                    case 2:
                        azv = 3;
                        break;
                    case 3:
                        azv = 0;
                        break;
                }
            }
        }
        com.baidu.lcp.sdk.d.d.d("DNSUrlProvider", "try to connect ip, now policy =" + azv);
        return azv;
    }

    public static boolean isIpv4(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        return str.matches("^(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|[1-9])\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)$");
    }

    public static int zD() {
        return azv;
    }
}
