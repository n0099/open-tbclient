package com.baidu.tbadk.core.util;

import android.net.DhcpInfo;
import android.net.wifi.WifiManager;
import android.support.v4.view.MotionEventCompat;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class v {
    private static long ZX = 0;
    private static long ZY = 0;
    private static a ZZ = new a(null);
    private static b aaa = new b(null);
    private static b aab = new b(null);
    private static String aac = null;
    private static Object vS = new Object();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        int aau;
        long aav;
        int aaw;
        int num;
        long time;

        private b() {
            this.num = 0;
            this.aau = 0;
            this.time = 0L;
            this.aav = 0L;
            this.aaw = 0;
        }

        /* synthetic */ b(b bVar) {
            this();
        }

        public void reset() {
            this.num = 0;
            this.aau = 0;
            this.time = 0L;
            this.aav = 0L;
            this.aaw = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        int aad;
        boolean aae;
        b aaf;
        b aag;
        b aah;
        b aai;
        b aaj;
        b aak;
        b aal;
        b aam;
        b aan;
        b aao;
        b aap;
        b aaq;
        b aar;
        b aas;
        b aat;

        private a() {
            this.aad = 0;
            this.aaf = new b(null);
            this.aag = new b(null);
            this.aah = new b(null);
            this.aai = new b(null);
            this.aaj = new b(null);
            this.aak = new b(null);
            this.aal = new b(null);
            this.aam = new b(null);
            this.aan = new b(null);
            this.aao = new b(null);
            this.aap = new b(null);
            this.aaq = new b(null);
            this.aar = new b(null);
            this.aas = new b(null);
            this.aat = new b(null);
        }

        /* synthetic */ a(a aVar) {
            this();
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [88=4] */
        public int ux() {
            return this.aaf.num + this.aag.num + this.aah.num + this.aai.num + this.aaj.num;
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [94=14] */
        public int uy() {
            return this.aaf.num + this.aag.num + this.aah.num + this.aai.num + this.aaj.num + this.aak.num + this.aal.num + this.aam.num + this.aan.num + this.aao.num + this.aap.num + this.aaq.num + this.aar.num + this.aas.num + this.aat.num;
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [105=4] */
        public int uz() {
            return this.aak.num + this.aal.num + this.aam.num + this.aan.num + this.aao.num;
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [111=4] */
        public int uA() {
            return this.aap.num + this.aaq.num + this.aar.num + this.aas.num + this.aat.num;
        }

        public void reset() {
            this.aad = 0;
            this.aaf.reset();
            this.aag.reset();
            this.aah.reset();
            this.aai.reset();
            this.aaj.reset();
            this.aak.reset();
            this.aal.reset();
            this.aam.reset();
            this.aan.reset();
            this.aao.reset();
            this.aap.reset();
            this.aaq.reset();
            this.aar.reset();
            this.aas.reset();
            this.aat.reset();
        }

        public void uB() {
            if (v.ZZ.ux() > 0) {
                com.baidu.tbadk.performanceLog.v.a(v.ZZ.aaf.num, v.ZZ.aaf.aau, v.ZZ.aaf.aaw, v.ZZ.aaf.aav, v.ZZ.aaf.time, v.ZZ.aag.num, v.ZZ.aag.aau, v.ZZ.aag.aaw, v.ZZ.aag.time, v.ZZ.aag.aav, v.ZZ.aah.num, v.ZZ.aah.aau, v.ZZ.aah.aaw, v.ZZ.aah.time, v.ZZ.aah.aav, v.ZZ.aaj.num, v.ZZ.aaj.aau, v.ZZ.aaj.aaw, v.ZZ.aaj.time, v.ZZ.aaj.aav, v.ZZ.aai.num, v.ZZ.aai.aau, v.ZZ.aai.aaw, v.ZZ.aai.time, v.ZZ.aai.aav, 3);
            }
        }

        public void uC() {
            if (v.ZZ.uz() > 0) {
                com.baidu.tbadk.performanceLog.v.a(v.ZZ.aak.num, v.ZZ.aak.aau, v.ZZ.aak.aaw, v.ZZ.aak.time, v.ZZ.aak.aav, v.ZZ.aal.num, v.ZZ.aal.aau, v.ZZ.aal.aaw, v.ZZ.aal.time, v.ZZ.aal.aav, v.ZZ.aam.num, v.ZZ.aam.aau, v.ZZ.aam.aaw, v.ZZ.aam.time, v.ZZ.aam.aav, v.ZZ.aao.num, v.ZZ.aao.aau, v.ZZ.aao.aaw, v.ZZ.aao.time, v.ZZ.aao.aav, v.ZZ.aan.num, v.ZZ.aan.aau, v.ZZ.aan.aaw, v.ZZ.aan.time, v.ZZ.aan.aav, 1);
            }
        }

        public void uD() {
            if (v.ZZ.uA() > 0) {
                com.baidu.tbadk.performanceLog.v.a(v.ZZ.aap.num, v.ZZ.aap.aau, v.ZZ.aap.aaw, v.ZZ.aap.time, v.ZZ.aap.aav, v.ZZ.aaq.num, v.ZZ.aaq.aau, v.ZZ.aaq.aaw, v.ZZ.aaq.time, v.ZZ.aaq.aav, v.ZZ.aar.num, v.ZZ.aar.aau, v.ZZ.aar.aaw, v.ZZ.aar.time, v.ZZ.aar.aav, v.ZZ.aat.num, v.ZZ.aat.aau, v.ZZ.aat.aaw, v.ZZ.aat.time, v.ZZ.aat.aav, v.ZZ.aas.num, v.ZZ.aas.aau, v.ZZ.aas.aaw, v.ZZ.aas.time, v.ZZ.aas.aav, 2);
            }
        }
    }

    private static b a(boolean z, boolean z2, String str, boolean z3) {
        if (z) {
            if (z2 && !z3) {
                return ZZ.aaf;
            }
            if (str.startsWith("http://tb.himg")) {
                return ZZ.aag;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return ZZ.aah;
            }
            if (z2 && z3) {
                return ZZ.aaj;
            }
            return ZZ.aai;
        } else if (com.baidu.adp.lib.util.i.iU()) {
            if (z2) {
                return ZZ.aak;
            }
            if (str.startsWith("http://tb.himg")) {
                return ZZ.aal;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return ZZ.aam;
            }
            return ZZ.aan;
        } else if (z2) {
            return ZZ.aap;
        } else {
            if (str.startsWith("http://tb.himg")) {
                return ZZ.aaq;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return ZZ.aar;
            }
            return ZZ.aas;
        }
    }

    public static com.baidu.adp.lib.stats.d he() {
        return com.baidu.adp.lib.stats.a.hl().ar("dbg");
    }

    public static void a(com.baidu.adp.lib.stats.d dVar, String str, boolean z, long j, boolean z2) {
        if (z && z2) {
            synchronized (vS) {
                aaa.num++;
                aaa.time += j;
                if (aaa.num >= 100) {
                    up();
                }
            }
        }
    }

    public static void up() {
        if (aaa.num > 10) {
            com.baidu.adp.lib.stats.d he = he();
            he.q("act", "locStat");
            he.q("costTime", String.valueOf(aaa.time));
            he.q("num", String.valueOf(aaa.num));
            he.q("isWifi", "1");
            com.baidu.adp.lib.stats.a.hl().b("img", he);
            aaa.reset();
        }
    }

    public static void a(com.baidu.adp.lib.stats.d dVar, String str, boolean z, String str2, boolean z2, Boolean bool, com.baidu.adp.lib.network.http.d dVar2, String str3, long j, boolean z3, long j2) {
        boolean z4;
        String str4;
        String str5;
        if (com.baidu.adp.lib.util.k.jg()) {
            String str6 = "";
            boolean ga = com.baidu.tbadk.util.e.ga(str2);
            boolean z5 = false;
            if (com.baidu.tbadk.core.util.a.e.getInstance() != null) {
                z5 = true;
                if (!com.baidu.tbadk.core.util.a.e.getInstance().acS) {
                    com.baidu.tbadk.core.util.a.e.getInstance().init();
                }
            }
            boolean iQ = com.baidu.adp.lib.util.i.iQ();
            if (!z5) {
                z4 = false;
            } else if (iQ) {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().SJ);
            } else if (com.baidu.adp.lib.util.i.iU()) {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().SL);
            } else {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().SK);
            }
            boolean z6 = false;
            if (ga && z5) {
                z6 = com.baidu.tbadk.core.util.a.e.getInstance().isShouldCDNFallBack();
            }
            if (ga && iQ && z6) {
                if (z) {
                    s.getInstance().insertNormalData(j, str);
                } else {
                    str6 = w.uE().uF();
                    if (!TextUtils.isEmpty(str6)) {
                        s.getInstance().insertErrorData(dVar2.uY, str);
                    }
                }
            }
            if (ga) {
                aac = str;
            }
            boolean z7 = false;
            if (dVar2.va != null && dVar2.va.length() > 0) {
                z7 = true;
            }
            synchronized (vS) {
                b a2 = a(iQ, ga, str2, z7);
                boolean z8 = ZZ.aae;
                if (a2 != null) {
                    a2.num++;
                    if (z) {
                        a2.time += j;
                        a2.aav += j2;
                        ZZ.aae = true;
                        if (z4) {
                            a2.aaw++;
                        }
                    } else {
                        a2.aau++;
                        ZZ.aae = false;
                    }
                }
                int uy = ZZ.uy();
                if (uy > 100 || (uy > 0 && z8 != ZZ.aae)) {
                    uq();
                }
            }
            if (z && z5) {
                if (!iQ || j >= com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().SJ) {
                    if (iQ || !com.baidu.adp.lib.util.i.iU() || j >= com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().SL) {
                        if (!iQ && j < com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().SK) {
                            return;
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
            if (dVar == null) {
                dVar = he();
            }
            if (TextUtils.isEmpty(str6)) {
                str6 = w.uE().uF();
            }
            if (!ga || !TextUtils.isEmpty("")) {
                str4 = "";
            } else {
                str4 = w.uE().dl(str);
            }
            if (!TextUtils.isEmpty("")) {
                str5 = "";
            } else {
                str5 = us();
            }
            dVar.q("url", str);
            dVar.q("act", "dl");
            dVar.q("result", z ? "0" : "1");
            dVar.q("fullurl", str2);
            dVar.q("costTime", String.valueOf(j));
            dVar.q("connTime", String.valueOf(dVar2.uS));
            dVar.q("rspTime", String.valueOf(dVar2.uT));
            dVar.q("retry", String.valueOf(dVar2.uU));
            dVar.q("localIp", f.getIp());
            dVar.q("tiebaIp", str6);
            dVar.q("cdnIp", str4);
            dVar.q("useIp", dVar2.va);
            dVar.q("dnsIp", str5);
            if (dVar2.uS > 1500 || dVar2.uS < 0) {
                dVar.q("connBaidu", String.valueOf(ut()));
            }
            dVar.q("memory", uu());
            dVar.q("task", uv());
            dVar.q("isWifi", iQ ? "1" : "0");
            dVar.q("status", String.valueOf(dVar2.uZ));
            dVar.q("up", String.valueOf(dVar2.uQ));
            dVar.q("down", String.valueOf(dVar2.uR));
            dVar.q("isCDN", ga ? "1" : "0");
            dVar.q("isWebp", bool.booleanValue() ? "1" : "0");
            dVar.q("isMobileProxy", z3 ? "1" : "0");
            dVar.q("exception", dVar2.uX);
            dVar.q("reason", str3);
            com.baidu.adp.lib.stats.a.hl().b("img", dVar);
            if (ga && !TextUtils.isEmpty(str6) && TextUtils.isEmpty(str4) && !z) {
                ZZ.aad++;
            }
        }
    }

    public static void uq() {
        if (ZZ.uy() > 10) {
            if (ZZ.ux() > 0) {
                a(ZZ.aaf, ZZ.aag, ZZ.aah, ZZ.aaj, ZZ.aai, 10000);
            }
            if (ZZ.uA() > 0) {
                a(ZZ.aap, ZZ.aaq, ZZ.aar, ZZ.aat, ZZ.aas, 100002);
            }
            if (ZZ.uz() > 0) {
                a(ZZ.aak, ZZ.aal, ZZ.aam, ZZ.aao, ZZ.aan, 100001);
            }
            ZZ.uB();
            ZZ.uC();
            ZZ.uD();
            ZZ.reset();
        }
    }

    public static void a(b bVar, b bVar2, b bVar3, b bVar4, b bVar5, int i) {
        if (bVar != null && bVar2 != null && bVar3 != null && bVar4 != null && bVar5 != null) {
            String str = "";
            String str2 = "";
            String str3 = "";
            if (TextUtils.isEmpty("")) {
                str = w.uE().uF();
            }
            if (aac != null && TextUtils.isEmpty("")) {
                str2 = w.uE().dl(aac);
            }
            if (TextUtils.isEmpty("")) {
                str3 = us();
            }
            com.baidu.adp.lib.stats.d he = he();
            he.q("act", "dlStat");
            he.q("cdnCostTime", String.valueOf(bVar.time));
            he.q("cdnNum", String.valueOf(bVar.num));
            he.q("cdnFailnum", String.valueOf(bVar.aau));
            he.q("portraitCostTime", String.valueOf(bVar2.time));
            he.q("portraitNum", String.valueOf(bVar2.num));
            he.q("portraitFailnum", String.valueOf(bVar2.aau));
            he.q("tiebaCostTime", String.valueOf(bVar3.time));
            he.q("tiebaNum", String.valueOf(bVar3.num));
            he.q("tiebaFailnum", String.valueOf(bVar3.aau));
            he.q("otherCostTime", String.valueOf(bVar5.time));
            he.q("otherNum", String.valueOf(bVar5.num));
            he.q("otherFailnum", String.valueOf(bVar5.aau));
            he.q("directIpCostTime", String.valueOf(bVar4.time));
            he.q("directIpNum", String.valueOf(bVar4.num));
            he.q("directIpFailnum", String.valueOf(bVar4.aau));
            he.q("dnsFailNum", String.valueOf(ZZ.aad));
            if (10000 == i) {
                he.q("isWifi", "1");
                he.q("netType", "WIFI");
            } else if (100002 == i) {
                he.q("netType", "3G");
                he.q("isWifi", "0");
            } else {
                he.q("netType", "2G");
                he.q("isWifi", "0");
            }
            he.q("localIp", f.getIp());
            he.q("tbIp", str);
            he.q("cdnIp", str2);
            he.q("dnsIp", str3);
            com.baidu.adp.lib.stats.a.hl().b("img", he);
        }
    }

    public static void a(com.baidu.adp.lib.stats.d dVar, String str, String str2, boolean z, boolean z2, boolean z3, int i, String str3, long j, String str4) {
        if (com.baidu.adp.lib.util.k.jg()) {
            synchronized (vS) {
                aab.num++;
                if (z) {
                    aab.time += j;
                } else {
                    aab.aau++;
                }
                if (aab.num >= 100) {
                    ur();
                }
            }
            if (!z) {
                if (dVar == null) {
                    dVar = he();
                }
                dVar.q("act", "dc");
                dVar.q("costTime", String.valueOf(j));
                dVar.q("url", str);
                dVar.q("fullURL", str2);
                dVar.q("isWebp", z3 ? "1" : "0");
                dVar.q("isCDN", z2 ? "1" : "0");
                dVar.q("length", String.valueOf(i));
                dVar.q("reason", str3);
                dVar.q("result", z ? "0" : "1");
                dVar.q("execption", str4);
                com.baidu.adp.lib.stats.a.hl().b("img", dVar);
            }
        }
    }

    public static void ur() {
        if (aab.num > 10) {
            com.baidu.adp.lib.stats.d he = he();
            he.q("act", "dcStat");
            he.q("costTime", String.valueOf(aab.time));
            he.q("num", String.valueOf(aab.num));
            he.q("failnum", String.valueOf(aab.aau));
            com.baidu.adp.lib.stats.a.hl().b("img", he);
            com.baidu.tbadk.performanceLog.v.a(aab.num, aab.aau, aab.time);
            aab.reset();
        }
    }

    public static void dk(String str) {
        com.baidu.adp.lib.stats.d he = he();
        he.q("act", "assistant");
        he.q(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, str);
        com.baidu.adp.lib.stats.a.hl().b("img", he);
    }

    private static String us() {
        try {
            DhcpInfo dhcpInfo = ((WifiManager) BdBaseApplication.getInst().getApp().getSystemService("wifi")).getDhcpInfo();
            return String.valueOf(intToIp(dhcpInfo.dns1)) + "," + intToIp(dhcpInfo.dns2);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    private static String intToIp(int i) {
        return String.valueOf(i & MotionEventCompat.ACTION_MASK) + "." + ((i >> 8) & MotionEventCompat.ACTION_MASK) + "." + ((i >> 16) & MotionEventCompat.ACTION_MASK) + "." + ((i >> 24) & MotionEventCompat.ACTION_MASK);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [678=4] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static long ut() {
        HttpURLConnection httpURLConnection;
        long j;
        if (ZX >= 3) {
            return ZY;
        }
        long currentTimeMillis = System.currentTimeMillis();
        HttpURLConnection httpURLConnection2 = null;
        try {
            httpURLConnection = (HttpURLConnection) new URL("http://www.baidu.com/").openConnection();
            try {
                httpURLConnection.setConnectTimeout(2500);
                httpURLConnection.connect();
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.h.a.e(httpURLConnection);
                j = currentTimeMillis2;
            } catch (SocketTimeoutException e) {
                com.baidu.adp.lib.h.a.e(httpURLConnection);
                j = 2500;
                if (j > 0) {
                }
            } catch (Exception e2) {
                httpURLConnection2 = httpURLConnection;
                com.baidu.adp.lib.h.a.e(httpURLConnection2);
                j = -1;
                if (j > 0) {
                }
            } catch (Throwable th) {
                httpURLConnection2 = httpURLConnection;
                th = th;
                com.baidu.adp.lib.h.a.e(httpURLConnection2);
                throw th;
            }
        } catch (SocketTimeoutException e3) {
            httpURLConnection = null;
        } catch (Exception e4) {
        } catch (Throwable th2) {
            th = th2;
        }
        if (j > 0) {
            if (ZX > -1) {
                ZY = ((ZY * ZX) + j) / (ZX + 1);
            } else {
                ZY = j;
            }
            ZX++;
            return j;
        }
        return j;
    }

    private static String uu() {
        return com.baidu.tbadk.imageManager.c.CX().fN();
    }

    private static String uv() {
        return com.baidu.adp.lib.asyncTask.c.fO().fN();
    }

    public static void a(boolean z, boolean z2, String str, String str2) {
        com.baidu.adp.lib.stats.d he = he();
        he.q("act", "getCDNList");
        he.q("errorNum", str);
        he.q("errorMsg", str2);
        he.q("isShortNetError", z2 ? "1" : "0");
        he.q("isSuccess", z ? "1" : "0");
        com.baidu.adp.lib.stats.a.hl().b("img", he);
    }

    public static void a(boolean z, String str, String str2, String str3, String str4, String str5, long j, boolean z2) {
        String str6 = "";
        if (str != null) {
            str6 = w.uE().dl(str);
        }
        String us = us();
        String ip = f.getIp();
        com.baidu.adp.lib.stats.d he = he();
        he.q("act", "tachometerCDN");
        he.q("errorNum", str3);
        he.q("execption", str4);
        he.q("size", str5);
        he.q("isScuess", z ? "1" : "0");
        he.q("url", str);
        he.q("localIp", ip);
        he.q("cdnIp", str6);
        he.q("dnsIP", us);
        he.q("usedIp", str2);
        he.q("isUsedIp", z2 ? "0" : "1");
        he.q("costTime", String.valueOf(j));
        com.baidu.adp.lib.stats.a.hl().b("img", he);
    }

    public static void a(ArrayList<String> arrayList, long j) {
        if (arrayList != null) {
            StringBuilder sb = new StringBuilder();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < arrayList.size()) {
                    if (i2 != 0) {
                        sb.append(",");
                    }
                    sb.append(arrayList.get(i2));
                    i = i2 + 1;
                } else {
                    com.baidu.adp.lib.stats.d he = he();
                    he.q("act", "mobileTachometerCDN");
                    he.q("costTime", String.valueOf(j));
                    he.q("ipList", sb.toString());
                    com.baidu.adp.lib.stats.a.hl().b("img", he);
                    return;
                }
            }
        }
    }

    public static void c(boolean z, String str) {
        com.baidu.adp.lib.stats.d he = he();
        he.q("act", "getCDNList");
        he.q("isSuccess", z ? "1" : "0");
        he.q("errorMsg", str);
        com.baidu.adp.lib.stats.a.hl().b("img", he);
    }
}
