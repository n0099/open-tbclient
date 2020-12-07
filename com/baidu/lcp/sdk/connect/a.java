package com.baidu.lcp.sdk.connect;

import android.content.Context;
import com.baidu.searchbox.dns.DnsHelper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes14.dex */
public class a {
    private static int azf = 3;
    public static List<String> azg = Collections.synchronizedList(new ArrayList());
    public static int azh = 0;
    private static Context context;

    /* loaded from: classes14.dex */
    public interface b {
        void a(String str, d dVar);

        void q(String str, boolean z);
    }

    /* loaded from: classes14.dex */
    public interface d {
        void c(int i, String str, String str2);
    }

    public static b aD(Context context2) {
        context = context2.getApplicationContext();
        int aK = com.baidu.lcp.sdk.d.b.aK(context2);
        if (aK == 1 || aK == 2) {
            azf = 0;
            return c.Aq();
        } else if (com.baidu.lcp.sdk.d.e.getBdDnsEnable(context2) && azf == 2) {
            return C0168a.aE(context2);
        } else {
            if (azf == 3) {
                return e.aF(context2);
            }
            return c.Aq();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes14.dex */
    public static class c implements b {
        private static c azp;

        private c() {
        }

        public static synchronized b Aq() {
            c cVar;
            synchronized (c.class) {
                if (azp == null) {
                    azp = new c();
                }
                cVar = azp;
            }
            return cVar;
        }

        @Override // com.baidu.lcp.sdk.connect.a.b
        public void a(String str, d dVar) {
            com.baidu.lcp.sdk.d.d.i("DNSUrlProvider", "DefaultUrlProvider try to getUrlAsync");
            com.baidu.lcp.sdk.a.d.writeLoginFlag(a.context, "12N", "DefaultUrlProvider begin");
            if (dVar != null) {
                a.An();
                com.baidu.lcp.sdk.a.d.writeLoginFlag(a.context, "12Y", "DefaultUrlProvider begin");
                dVar.c(0, "ok", str);
            }
        }

        @Override // com.baidu.lcp.sdk.connect.a.b
        public void q(String str, boolean z) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes14.dex */
    public static class e implements b {
        private static e azq;

        private e(Context context) {
            Context unused = a.context = context.getApplicationContext();
        }

        public static synchronized e aF(Context context) {
            e eVar;
            synchronized (e.class) {
                if (azq == null) {
                    azq = new e(context);
                }
                eVar = azq;
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
                a.aZ(true);
                a.aD(a.context).a(str, dVar);
            }
        }

        @Override // com.baidu.lcp.sdk.connect.a.b
        public void q(String str, boolean z) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.lcp.sdk.connect.a$a  reason: collision with other inner class name */
    /* loaded from: classes14.dex */
    public static class C0168a implements b {
        private static C0168a azi;

        public static synchronized C0168a aE(Context context) {
            C0168a c0168a;
            synchronized (C0168a.class) {
                if (azi == null) {
                    azi = new C0168a(context);
                }
                c0168a = azi;
            }
            return c0168a;
        }

        private C0168a(Context context) {
            Context unused = a.context = context.getApplicationContext();
            a.An();
        }

        @Override // com.baidu.lcp.sdk.connect.a.b
        public void a(final String str, final d dVar) {
            try {
                com.baidu.lcp.sdk.d.d.i("DNSUrlProvider", "BDHttpDNSUrlProvider try to getUrlAsync");
                if (a.azg == null || a.azg.size() <= 0) {
                    com.baidu.lcp.sdk.a.d.writeLoginFlag(a.context, "11N", "BDDNS begin");
                    final Timer timer = new Timer();
                    com.baidu.lcp.sdk.c.a.aH(a.context).submitForNetWork(new Runnable() { // from class: com.baidu.lcp.sdk.connect.a.a.1
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
                                        a.aZ(true);
                                        a.aD(a.context).a(str, dVar);
                                    }
                                    atomicBoolean.set(true);
                                }
                            }, 10000L);
                            DnsHelper dnsHelper = new DnsHelper(a.context);
                            dnsHelper.setHttpDnsState(false, null, false, true);
                            a.s(dnsHelper.getIpList(str));
                            com.baidu.lcp.sdk.a.d.writeLoginFlag(a.context, "11N_1", "BDDNS get ips");
                            if (a.azg != null && a.azg.size() > 0) {
                                com.baidu.lcp.sdk.d.d.d("DNSUrlProvider", "bddns > bdDnsIps = " + a.azg);
                                String str2 = a.azg.get(0);
                                com.baidu.lcp.sdk.a.d.writeLoginFlag(a.context, "11Y", "BDDNS success");
                                if (dVar != null && !atomicBoolean.get()) {
                                    dVar.c(0, "ok", str2);
                                    if (a.azg.size() > 1) {
                                        a.azh++;
                                        a.aZ(false);
                                    }
                                }
                                com.baidu.lcp.sdk.d.d.d("DNSUrlProvider", "bddns > return ip = " + str2);
                                timer.cancel();
                            }
                        }
                    });
                } else if (a.azh < a.azg.size()) {
                    com.baidu.lcp.sdk.a.d.writeLoginFlag(a.context, "11Y", "BDDNS retry success");
                    if (dVar != null) {
                        dVar.c(0, "ok", a.azg.get(a.azh));
                        com.baidu.lcp.sdk.d.d.d("DNSUrlProvider", "retry bddns > return ip = " + a.azg.get(a.azh));
                    }
                    a.azh++;
                } else {
                    a.aZ(true);
                    a.aD(a.context).a(str, dVar);
                }
            } catch (Throwable th) {
                com.baidu.lcp.sdk.a.d.writeLoginFlag(a.context, "11N_2", "BDDNS exception, HTTPDNS begin");
                com.baidu.lcp.sdk.d.d.d("DNSUrlProvider", "bddns > bdDnsIps get exception ");
                a.aZ(true);
                a.aD(a.context).a(str, dVar);
            }
        }

        @Override // com.baidu.lcp.sdk.connect.a.b
        public void q(String str, boolean z) {
        }
    }

    public static void s(List<String> list) {
        azg.clear();
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
            int aS = com.baidu.lcp.sdk.d.e.aS(context);
            com.baidu.lcp.sdk.d.d.e("DNSUrlProvider", "getIpPriority :" + aS + ", ipv4 :" + arrayList.toString() + ", ipv6 :" + arrayList2.toString());
            switch (aS) {
                case 1:
                    azg.addAll(arrayList2);
                    return;
                case 2:
                    azg.addAll(arrayList2);
                    azg.addAll(arrayList);
                    return;
                case 3:
                default:
                    azg.addAll(arrayList);
                    azg.addAll(arrayList2);
                    return;
                case 4:
                    azg.addAll(arrayList);
                    return;
            }
        }
    }

    public static void C(Context context2, String str) {
        e(context2, str, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void An() {
        try {
            azh = 0;
            azg.clear();
            azf = 3;
        } catch (Exception e2) {
            com.baidu.lcp.sdk.d.d.e("DNSUrlProvider", "resetBdDns exception", e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean Ao() {
        return azg != null && azh <= azg.size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void e(Context context2, String str, boolean z) {
        An();
        c.Aq().q(str, true);
    }

    public static int aZ(boolean z) {
        if (z) {
            int aK = com.baidu.lcp.sdk.d.b.aK(context);
            if (aK == 1 || aK == 2) {
                azf = 0;
            } else {
                switch (azf) {
                    case 0:
                        azf = 2;
                        break;
                    case 2:
                        azf = 3;
                        break;
                    case 3:
                        azf = 0;
                        break;
                }
            }
        }
        com.baidu.lcp.sdk.d.d.d("DNSUrlProvider", "try to connect ip, now policy =" + azf);
        return azf;
    }

    public static boolean isIpv4(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        return str.matches("^(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|[1-9])\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)$");
    }

    public static int Ap() {
        return azf;
    }
}
