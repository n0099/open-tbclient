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
    private static long aal = 0;
    private static long aam = 0;
    private static a aan = new a(null);
    private static u aao = new u();
    private static u aap = new u();
    private static String aaq = null;
    private static Object wv = new Object();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        u aaA;
        u aaB;
        u aaC;
        u aaD;
        u aaE;
        u aaF;
        u aaG;
        u aaH;
        int aar;
        boolean aas;
        u aat;
        u aau;
        u aav;
        u aaw;
        u aax;
        u aay;
        u aaz;

        private a() {
            this.aar = 0;
            this.aat = new u();
            this.aau = new u();
            this.aav = new u();
            this.aaw = new u();
            this.aax = new u();
            this.aay = new u();
            this.aaz = new u();
            this.aaA = new u();
            this.aaB = new u();
            this.aaC = new u();
            this.aaD = new u();
            this.aaE = new u();
            this.aaF = new u();
            this.aaG = new u();
            this.aaH = new u();
        }

        /* synthetic */ a(a aVar) {
            this();
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [72=4] */
        public int vH() {
            return this.aat.num + this.aau.num + this.aav.num + this.aaw.num + this.aax.num;
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [78=14] */
        public int vI() {
            return this.aat.num + this.aau.num + this.aav.num + this.aaw.num + this.aax.num + this.aay.num + this.aaz.num + this.aaA.num + this.aaB.num + this.aaC.num + this.aaD.num + this.aaE.num + this.aaF.num + this.aaG.num + this.aaH.num;
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [89=4] */
        public int vJ() {
            return this.aay.num + this.aaz.num + this.aaA.num + this.aaB.num + this.aaC.num;
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [95=4] */
        public int vK() {
            return this.aaD.num + this.aaE.num + this.aaF.num + this.aaG.num + this.aaH.num;
        }

        public void reset() {
            this.aar = 0;
            this.aat.reset();
            this.aau.reset();
            this.aav.reset();
            this.aaw.reset();
            this.aax.reset();
            this.aay.reset();
            this.aaz.reset();
            this.aaA.reset();
            this.aaB.reset();
            this.aaC.reset();
            this.aaD.reset();
            this.aaE.reset();
            this.aaF.reset();
            this.aaG.reset();
            this.aaH.reset();
        }
    }

    private static u a(boolean z, boolean z2, String str, boolean z3) {
        if (z) {
            if (z2 && !z3) {
                return aan.aat;
            }
            if (str.startsWith("http://tb.himg")) {
                return aan.aau;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return aan.aav;
            }
            if (z2 && z3) {
                return aan.aax;
            }
            return aan.aaw;
        } else if (com.baidu.adp.lib.util.i.jk()) {
            if (z2) {
                return aan.aay;
            }
            if (str.startsWith("http://tb.himg")) {
                return aan.aaz;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return aan.aaA;
            }
            return aan.aaB;
        } else if (z2) {
            return aan.aaD;
        } else {
            if (str.startsWith("http://tb.himg")) {
                return aan.aaE;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return aan.aaF;
            }
            return aan.aaG;
        }
    }

    public static com.baidu.adp.lib.stats.d hs() {
        return com.baidu.adp.lib.stats.a.hz().as("dbg");
    }

    public static void a(com.baidu.adp.lib.stats.d dVar, String str, boolean z, long j, boolean z2) {
        if (z && z2) {
            synchronized (wv) {
                aao.num++;
                aao.time += j;
                if (aao.num >= 100) {
                    vA();
                }
            }
        }
    }

    public static void vA() {
        if (aao.num > 10) {
            com.baidu.adp.lib.stats.d hs = hs();
            hs.r("act", "locStat");
            hs.r("costTime", String.valueOf(aao.time));
            hs.r("num", String.valueOf(aao.num));
            hs.r("isWifi", "1");
            com.baidu.adp.lib.stats.a.hz().b("img", hs);
            aao.reset();
        }
    }

    public static void a(com.baidu.adp.lib.stats.d dVar, String str, boolean z, String str2, boolean z2, Boolean bool, com.baidu.adp.lib.network.http.e eVar, String str3, long j, boolean z3, long j2, int i) {
        boolean z4;
        String str4;
        String str5;
        if (com.baidu.adp.lib.util.k.jw() && eVar != null) {
            String str6 = "";
            boolean gk = com.baidu.tbadk.util.h.gk(str2);
            boolean z5 = false;
            if (com.baidu.tbadk.core.util.a.e.getInstance() != null) {
                z5 = true;
                if (!com.baidu.tbadk.core.util.a.e.getInstance().adi) {
                    com.baidu.tbadk.core.util.a.e.getInstance().init();
                }
            }
            boolean jg = com.baidu.adp.lib.util.i.jg();
            if (!z5) {
                z4 = false;
            } else if (jg) {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().Qc);
            } else if (com.baidu.adp.lib.util.i.jk()) {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().Qe);
            } else {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().Qd);
            }
            boolean z6 = false;
            if (gk && z5) {
                z6 = com.baidu.tbadk.core.util.a.e.getInstance().isShouldCDNFallBack();
            }
            if (gk && jg && z6) {
                if (z) {
                    r.getInstance().insertNormalData(j, str);
                } else {
                    str6 = w.vL().vM();
                    if (!TextUtils.isEmpty(str6)) {
                        r.getInstance().insertErrorData(eVar.vx, str);
                    }
                }
            }
            if (gk) {
                aaq = str;
            }
            boolean z7 = false;
            if (eVar.vz != null && eVar.vz.length() > 0) {
                z7 = true;
            }
            synchronized (wv) {
                u a2 = a(jg, gk, str2, z7);
                boolean z8 = aan.aas;
                if (a2 != null) {
                    a2.num++;
                    if (z) {
                        a2.time += j;
                        a2.vq += j2;
                        aan.aas = true;
                        if (z4) {
                            a2.aak++;
                        }
                    } else {
                        a2.aaj++;
                        aan.aas = false;
                    }
                }
                int vI = aan.vI();
                if (vI > 100 || (vI > 0 && z8 != aan.aas)) {
                    vB();
                }
            }
            if (z && z5) {
                if (!jg || j >= com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().Qc) {
                    if (jg || !com.baidu.adp.lib.util.i.jk() || j >= com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().Qe) {
                        if (!jg && j < com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().Qd) {
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
                dVar = hs();
            }
            if (TextUtils.isEmpty(str6)) {
                str6 = w.vL().vM();
            }
            if (!gk || !TextUtils.isEmpty("")) {
                str4 = "";
            } else {
                str4 = w.vL().dp(str);
            }
            if (!TextUtils.isEmpty("")) {
                str5 = "";
            } else {
                str5 = vD();
            }
            dVar.r("url", str);
            dVar.r("act", "dl");
            dVar.r("result", z ? "1" : "0");
            dVar.r("fullurl", str2);
            dVar.r("netlib", String.valueOf(eVar.vB));
            dVar.r("costTime", String.valueOf(j));
            dVar.r("connTime", String.valueOf(eVar.vr));
            dVar.r("rspTime", String.valueOf(eVar.vs));
            dVar.r("retry", String.valueOf(eVar.vt));
            dVar.r("localIp", e.getIp());
            dVar.r("tiebaIp", str6);
            dVar.r("cdnIp", str4);
            dVar.r("useIp", eVar.vz);
            dVar.r("dnsIp", str5);
            if (eVar.vr > 1500 || eVar.vr < 0) {
                dVar.r("connBaidu", String.valueOf(vE()));
            }
            dVar.r("memory", vF());
            dVar.r("task", vG());
            dVar.r("isWifi", jg ? "1" : "0");
            dVar.r("status", String.valueOf(eVar.vy));
            dVar.r("up", String.valueOf(eVar.vp));
            dVar.r("down", String.valueOf(eVar.vq));
            dVar.r("isCDN", gk ? "1" : "0");
            dVar.r("isWebp", bool.booleanValue() ? "1" : "0");
            dVar.r("isMobileProxy", z3 ? "1" : "0");
            dVar.r("exception", eVar.vw);
            dVar.r("reason", str3);
            if (i != 0) {
                dVar.b("procType", Integer.valueOf(i));
            }
            com.baidu.adp.lib.stats.a.hz().b("img", dVar);
            if (gk && !TextUtils.isEmpty(str6) && TextUtils.isEmpty(str4) && !z) {
                aan.aar++;
            }
        }
    }

    public static void vB() {
        if (aan.vI() > 10) {
            if (aan.vH() > 0) {
                a(aan.aat, aan.aau, aan.aav, aan.aax, aan.aaw, 10000);
                com.baidu.tbadk.performanceLog.x.b(aan.aat, aan.aau, aan.aav, aan.aax, aan.aaw, 3);
            }
            if (aan.vK() > 0) {
                a(aan.aaD, aan.aaE, aan.aaF, aan.aaH, aan.aaG, 100002);
                com.baidu.tbadk.performanceLog.x.b(aan.aaD, aan.aaE, aan.aaF, aan.aaH, aan.aaG, 2);
            }
            if (aan.vJ() > 0) {
                a(aan.aay, aan.aaz, aan.aaA, aan.aaC, aan.aaB, 100001);
                com.baidu.tbadk.performanceLog.x.b(aan.aay, aan.aaz, aan.aaA, aan.aaC, aan.aaB, 1);
            }
            aan.reset();
        }
    }

    public static void a(u uVar, u uVar2, u uVar3, u uVar4, u uVar5, int i) {
        if (uVar != null && uVar2 != null && uVar3 != null && uVar4 != null && uVar5 != null) {
            String str = "";
            String str2 = "";
            String str3 = "";
            if (TextUtils.isEmpty("")) {
                str = w.vL().vM();
            }
            if (aaq != null && TextUtils.isEmpty("")) {
                str2 = w.vL().dp(aaq);
            }
            if (TextUtils.isEmpty("")) {
                str3 = vD();
            }
            com.baidu.adp.lib.stats.d hs = hs();
            hs.r("act", "dlStat");
            hs.r("cdnCostTime", String.valueOf(uVar.time));
            hs.r("cdnNum", String.valueOf(uVar.num));
            hs.r("cdnFailnum", String.valueOf(uVar.aaj));
            hs.r("portraitCostTime", String.valueOf(uVar2.time));
            hs.r("portraitNum", String.valueOf(uVar2.num));
            hs.r("portraitFailnum", String.valueOf(uVar2.aaj));
            hs.r("tiebaCostTime", String.valueOf(uVar3.time));
            hs.r("tiebaNum", String.valueOf(uVar3.num));
            hs.r("tiebaFailnum", String.valueOf(uVar3.aaj));
            hs.r("otherCostTime", String.valueOf(uVar5.time));
            hs.r("otherNum", String.valueOf(uVar5.num));
            hs.r("otherFailnum", String.valueOf(uVar5.aaj));
            hs.r("directIpCostTime", String.valueOf(uVar4.time));
            hs.r("directIpNum", String.valueOf(uVar4.num));
            hs.r("directIpFailnum", String.valueOf(uVar4.aaj));
            hs.r("dnsFailNum", String.valueOf(aan.aar));
            if (10000 == i) {
                hs.r("isWifi", "1");
                hs.r("netType", "WIFI");
            } else if (100002 == i) {
                hs.r("netType", "3G");
                hs.r("isWifi", "0");
            } else {
                hs.r("netType", "2G");
                hs.r("isWifi", "0");
            }
            hs.r("localIp", e.getIp());
            hs.r("tbIp", str);
            hs.r("cdnIp", str2);
            hs.r("dnsIp", str3);
            com.baidu.adp.lib.stats.a.hz().b("img", hs);
        }
    }

    public static void a(com.baidu.adp.lib.stats.d dVar, String str, String str2, boolean z, boolean z2, boolean z3, int i, String str3, long j, String str4) {
        if (com.baidu.adp.lib.util.k.jw()) {
            synchronized (wv) {
                aap.num++;
                if (z) {
                    aap.time += j;
                } else {
                    aap.aaj++;
                }
                if (aap.num >= 100) {
                    vC();
                }
            }
            if (!z) {
                if (dVar == null) {
                    dVar = hs();
                }
                dVar.r("act", "dc");
                dVar.r("costTime", String.valueOf(j));
                dVar.r("url", str);
                dVar.r("fullURL", str2);
                dVar.r("isWebp", z3 ? "1" : "0");
                dVar.r("isCDN", z2 ? "1" : "0");
                dVar.r("length", String.valueOf(i));
                dVar.r("reason", str3);
                dVar.r("result", z ? "0" : "1");
                dVar.r("execption", str4);
                com.baidu.adp.lib.stats.a.hz().b("img", dVar);
            }
        }
    }

    public static void vC() {
        if (aap.num > 10) {
            com.baidu.adp.lib.stats.d hs = hs();
            hs.r("act", "dcStat");
            hs.r("costTime", String.valueOf(aap.time));
            hs.r("num", String.valueOf(aap.num));
            hs.r("failnum", String.valueOf(aap.aaj));
            com.baidu.adp.lib.stats.a.hz().b("img", hs);
            com.baidu.tbadk.performanceLog.x.a(aap.num, aap.aaj, aap.time);
            aap.reset();
        }
    }

    public static void dn(String str) {
        com.baidu.adp.lib.stats.d hs = hs();
        hs.r("act", "assistant");
        hs.r(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, str);
        com.baidu.adp.lib.stats.a.hz().b("img", hs);
    }

    private static String vD() {
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [584=4] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static long vE() {
        HttpURLConnection httpURLConnection;
        long j;
        if (aal >= 3) {
            return aam;
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
            if (aal > -1) {
                aam = ((aam * aal) + j) / (aal + 1);
            } else {
                aam = j;
            }
            aal++;
            return j;
        }
        return j;
    }

    private static String vF() {
        return com.baidu.tbadk.imageManager.c.EO().fV();
    }

    private static String vG() {
        return com.baidu.adp.lib.asyncTask.c.fW().fV();
    }

    public static void a(boolean z, boolean z2, String str, String str2) {
        com.baidu.adp.lib.stats.d hs = hs();
        hs.r("act", "getCDNList");
        hs.r("errorNum", str);
        hs.r("errorMsg", str2);
        hs.r("isShortNetError", z2 ? "1" : "0");
        hs.r("isSuccess", z ? "1" : "0");
        com.baidu.adp.lib.stats.a.hz().b("img", hs);
    }

    public static void a(boolean z, String str, String str2, String str3, String str4, String str5, long j, boolean z2) {
        String str6 = "";
        if (str != null) {
            str6 = w.vL().dp(str);
        }
        String vD = vD();
        String ip = e.getIp();
        com.baidu.adp.lib.stats.d hs = hs();
        hs.r("act", "tachometerCDN");
        hs.r("errorNum", str3);
        hs.r("execption", str4);
        hs.r("size", str5);
        hs.r("isScuess", z ? "1" : "0");
        hs.r("url", str);
        hs.r("localIp", ip);
        hs.r("cdnIp", str6);
        hs.r("dnsIP", vD);
        hs.r("usedIp", str2);
        hs.r("isUsedIp", z2 ? "0" : "1");
        hs.r("costTime", String.valueOf(j));
        com.baidu.adp.lib.stats.a.hz().b("img", hs);
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
                    com.baidu.adp.lib.stats.d hs = hs();
                    hs.r("act", "mobileTachometerCDN");
                    hs.r("costTime", String.valueOf(j));
                    hs.r("ipList", sb.toString());
                    com.baidu.adp.lib.stats.a.hz().b("img", hs);
                    return;
                }
            }
        }
    }

    public static void c(boolean z, String str) {
        com.baidu.adp.lib.stats.d hs = hs();
        hs.r("act", "getCDNList");
        hs.r("isSuccess", z ? "1" : "0");
        hs.r("errorMsg", str);
        com.baidu.adp.lib.stats.a.hz().b("img", hs);
    }

    public static void a(String str, int i, int i2, int i3) {
        if (i == -1) {
            i = 0;
        }
        if (i2 == -1) {
            i2 = 0;
        }
        com.baidu.adp.lib.stats.a.hz().eventStat(null, str, "imgHttpSwitch", 1, "1sterrcode", String.valueOf(i), "2nderrcode", String.valueOf(i2), "2imgFailed", String.valueOf(i3));
    }
}
