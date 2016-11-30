package com.baidu.tbadk.core.util;

import android.net.DhcpInfo;
import android.net.wifi.WifiManager;
import android.support.v4.view.MotionEventCompat;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.baidu.tbadk.core.atomData.EcommSellerErrorActivityConfig;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class u {
    private static long aai = 0;
    private static long aaj = 0;
    private static int aak = 0;
    private static a aal = new a(null);
    private static t aam = new t();
    private static t aan = new t();
    private static String aao = null;
    private static Object pu = new Object();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        t aaA;
        t aaB;
        t aaC;
        t aaD;
        t aaE;
        t aaF;
        int aap;
        boolean aaq;
        t aar;
        t aas;
        t aat;
        t aau;
        t aav;
        t aaw;
        t aax;
        t aay;
        t aaz;

        private a() {
            this.aap = 0;
            this.aar = new t();
            this.aas = new t();
            this.aat = new t();
            this.aau = new t();
            this.aav = new t();
            this.aaw = new t();
            this.aax = new t();
            this.aay = new t();
            this.aaz = new t();
            this.aaA = new t();
            this.aaB = new t();
            this.aaC = new t();
            this.aaD = new t();
            this.aaE = new t();
            this.aaF = new t();
        }

        /* synthetic */ a(a aVar) {
            this();
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [74=4] */
        public int uJ() {
            return this.aar.num + this.aas.num + this.aat.num + this.aau.num + this.aav.num;
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [80=14] */
        public int uK() {
            return this.aar.num + this.aas.num + this.aat.num + this.aau.num + this.aav.num + this.aaw.num + this.aax.num + this.aay.num + this.aaz.num + this.aaA.num + this.aaB.num + this.aaC.num + this.aaD.num + this.aaE.num + this.aaF.num;
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [91=4] */
        public int uL() {
            return this.aaw.num + this.aax.num + this.aay.num + this.aaz.num + this.aaA.num;
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [97=4] */
        public int uM() {
            return this.aaB.num + this.aaC.num + this.aaD.num + this.aaE.num + this.aaF.num;
        }

        public void reset() {
            this.aap = 0;
            this.aar.reset();
            this.aas.reset();
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
        }
    }

    private static t a(boolean z, boolean z2, String str, boolean z3) {
        if (z) {
            if (z2 && !z3) {
                return aal.aar;
            }
            if (str.startsWith("http://tb.himg")) {
                return aal.aas;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return aal.aat;
            }
            if (z2 && z3) {
                return aal.aav;
            }
            return aal.aau;
        } else if (com.baidu.adp.lib.util.i.gr()) {
            if (z2) {
                return aal.aaw;
            }
            if (str.startsWith("http://tb.himg")) {
                return aal.aax;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return aal.aay;
            }
            return aal.aaz;
        } else if (z2) {
            return aal.aaB;
        } else {
            if (str.startsWith("http://tb.himg")) {
                return aal.aaC;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return aal.aaD;
            }
            return aal.aaE;
        }
    }

    public static com.baidu.adp.lib.stats.d eB() {
        return com.baidu.adp.lib.stats.a.eI().ao("dbg");
    }

    public static void a(com.baidu.adp.lib.stats.d dVar, String str, boolean z, long j, boolean z2) {
        if (z && z2) {
            synchronized (pu) {
                aam.num++;
                aam.time += j;
                if (aam.num >= 100) {
                    uC();
                }
            }
        }
    }

    public static void uC() {
        if (aam.num > 10) {
            com.baidu.adp.lib.stats.d eB = eB();
            eB.q("act", "locStat");
            eB.q("costTime", String.valueOf(aam.time));
            eB.q("num", String.valueOf(aam.num));
            eB.q("isWifi", "1");
            com.baidu.adp.lib.stats.a.eI().b("img", eB);
            aam.reset();
        }
    }

    public static void a(com.baidu.adp.lib.stats.d dVar, String str, boolean z, String str2, boolean z2, Boolean bool, com.baidu.adp.lib.network.http.e eVar, String str3, long j, boolean z3, long j2, int i) {
        boolean z4;
        String str4;
        String str5;
        if (com.baidu.adp.lib.util.k.gD() && eVar != null) {
            String str6 = "";
            boolean gs = com.baidu.tbadk.util.g.gs(str2);
            boolean z5 = false;
            if (com.baidu.tbadk.core.util.a.e.getInstance() != null) {
                z5 = true;
                if (!com.baidu.tbadk.core.util.a.e.getInstance().adf) {
                    com.baidu.tbadk.core.util.a.e.getInstance().init();
                }
            }
            boolean gn = com.baidu.adp.lib.util.i.gn();
            if (!z5) {
                z4 = false;
            } else if (gn) {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().Ni);
            } else if (com.baidu.adp.lib.util.i.gr()) {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().Nk);
            } else {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().Nj);
            }
            boolean z6 = false;
            if (gs && z5) {
                z6 = com.baidu.tbadk.core.util.a.e.getInstance().isShouldCDNFallBack();
            }
            if (gs && gn && z6) {
                if (z) {
                    r.getInstance().insertNormalData(j, str);
                } else {
                    str6 = v.uN().uO();
                    if (!TextUtils.isEmpty(str6)) {
                        r.getInstance().insertErrorData(eVar.om, str);
                    }
                }
            }
            if (gs) {
                aao = str;
            }
            boolean z7 = false;
            if (eVar.oq != null && eVar.oq.length() > 0) {
                z7 = true;
            }
            synchronized (pu) {
                t a2 = a(gn, gs, str2, z7);
                boolean z8 = aal.aaq;
                if (a2 != null) {
                    a2.num++;
                    if (z) {
                        a2.time += j;
                        a2.oe += j2;
                        aal.aaq = true;
                        if (z4) {
                            a2.aah++;
                        }
                        aak = 0;
                    } else {
                        if (com.baidu.adp.lib.util.i.gm()) {
                            int i2 = aak + 1;
                            aak = i2;
                            if (i2 >= com.baidu.adp.lib.stats.switchs.a.fD().getMaxAlertCount("alert_img", 5)) {
                                com.baidu.adp.lib.stats.a.eI().p("alert_img", "imgFailedCnt_" + String.valueOf(aak) + "_url=" + str2);
                            }
                        }
                        a2.aag++;
                        aal.aaq = false;
                    }
                }
                int uK = aal.uK();
                if (uK > 100 || (uK > 0 && z8 != aal.aaq)) {
                    uD();
                }
            }
            if (z && z5) {
                if (!gn || j >= com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().Ni) {
                    if (gn || !com.baidu.adp.lib.util.i.gr() || j >= com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().Nk) {
                        if (!gn && j < com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().Nj) {
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
                dVar = eB();
            }
            if (TextUtils.isEmpty(str6)) {
                str6 = v.uN().uO();
            }
            if (!gs || !TextUtils.isEmpty("")) {
                str4 = "";
            } else {
                str4 = v.uN().dq(str);
            }
            if (!TextUtils.isEmpty("")) {
                str5 = "";
            } else {
                str5 = uF();
            }
            dVar.q("url", str);
            dVar.q("act", "dl");
            dVar.q("result", z ? "1" : "0");
            dVar.q("fullurl", str2);
            dVar.q("netlib", String.valueOf(eVar.ov));
            dVar.q("costTime", String.valueOf(j));
            dVar.q("connTime", String.valueOf(eVar.of));
            dVar.q("rspTime", String.valueOf(eVar.og));
            dVar.q("retry", String.valueOf(eVar.oh));
            dVar.q("localIp", e.getIp());
            dVar.q("tiebaIp", str6);
            dVar.q("cdnIp", str4);
            dVar.q("useIp", eVar.oq);
            dVar.q("dnsIp", str5);
            if (eVar.of > 1500 || eVar.of < 0) {
                dVar.q("connBaidu", String.valueOf(uG()));
            }
            dVar.q("memory", uH());
            dVar.q("task", uI());
            dVar.q("status", String.valueOf(eVar.oo));
            dVar.q("up", String.valueOf(eVar.od));
            dVar.q("down", String.valueOf(eVar.oe));
            dVar.q("isCDN", gs ? "1" : "0");
            dVar.q("isWebp", bool.booleanValue() ? "1" : "0");
            dVar.q("isMobileProxy", z3 ? "1" : "0");
            dVar.q("exception", eVar.ol);
            dVar.q("reason", str3);
            if (i != 0) {
                dVar.d("procType", Integer.valueOf(i));
            }
            if (eVar.ot != null) {
                dVar.q("tracecode1", eVar.ot);
            }
            if (eVar.ou != null) {
                dVar.q("tracecode2", eVar.ou);
            }
            com.baidu.adp.lib.stats.a.eI().b("img", dVar);
            if (gs && !TextUtils.isEmpty(str6) && TextUtils.isEmpty(str4) && !z) {
                aal.aap++;
            }
        }
    }

    public static void uD() {
        if (aal.uK() > 10) {
            if (aal.uJ() > 0) {
                a(aal.aar, aal.aas, aal.aat, aal.aav, aal.aau, 10000);
                com.baidu.tbadk.performanceLog.x.b(aal.aar, aal.aas, aal.aat, aal.aav, aal.aau, 3);
            }
            if (aal.uM() > 0) {
                a(aal.aaB, aal.aaC, aal.aaD, aal.aaF, aal.aaE, 100002);
                com.baidu.tbadk.performanceLog.x.b(aal.aaB, aal.aaC, aal.aaD, aal.aaF, aal.aaE, 2);
            }
            if (aal.uL() > 0) {
                a(aal.aaw, aal.aax, aal.aay, aal.aaA, aal.aaz, 100001);
                com.baidu.tbadk.performanceLog.x.b(aal.aaw, aal.aax, aal.aay, aal.aaA, aal.aaz, 1);
            }
            aal.reset();
        }
    }

    public static void a(t tVar, t tVar2, t tVar3, t tVar4, t tVar5, int i) {
        if (tVar != null && tVar2 != null && tVar3 != null && tVar4 != null && tVar5 != null) {
            String str = "";
            String str2 = "";
            String str3 = "";
            if (TextUtils.isEmpty("")) {
                str = v.uN().uO();
            }
            if (aao != null && TextUtils.isEmpty("")) {
                str2 = v.uN().dq(aao);
            }
            if (TextUtils.isEmpty("")) {
                str3 = uF();
            }
            com.baidu.adp.lib.stats.d eB = eB();
            eB.q("act", "dlStat");
            eB.q("cdnCostTime", String.valueOf(tVar.time));
            eB.q("cdnNum", String.valueOf(tVar.num));
            eB.q("cdnFailnum", String.valueOf(tVar.aag));
            eB.q("portraitCostTime", String.valueOf(tVar2.time));
            eB.q("portraitNum", String.valueOf(tVar2.num));
            eB.q("portraitFailnum", String.valueOf(tVar2.aag));
            eB.q("tiebaCostTime", String.valueOf(tVar3.time));
            eB.q("tiebaNum", String.valueOf(tVar3.num));
            eB.q("tiebaFailnum", String.valueOf(tVar3.aag));
            eB.q("otherCostTime", String.valueOf(tVar5.time));
            eB.q("otherNum", String.valueOf(tVar5.num));
            eB.q("otherFailnum", String.valueOf(tVar5.aag));
            eB.q("directIpCostTime", String.valueOf(tVar4.time));
            eB.q("directIpNum", String.valueOf(tVar4.num));
            eB.q("directIpFailnum", String.valueOf(tVar4.aag));
            eB.q("dnsFailNum", String.valueOf(aal.aap));
            if (10000 == i) {
                eB.q("isWifi", "1");
                eB.q("netType", "WIFI");
            } else if (100002 == i) {
                eB.q("netType", "3G");
                eB.q("isWifi", "0");
            } else {
                eB.q("netType", "2G");
                eB.q("isWifi", "0");
            }
            eB.q("localIp", e.getIp());
            eB.q("tbIp", str);
            eB.q("cdnIp", str2);
            eB.q("dnsIp", str3);
            com.baidu.adp.lib.stats.a.eI().b("img", eB);
        }
    }

    public static void a(com.baidu.adp.lib.stats.d dVar, String str, String str2, boolean z, boolean z2, boolean z3, int i, String str3, long j, String str4) {
        if (com.baidu.adp.lib.util.k.gD()) {
            synchronized (pu) {
                aan.num++;
                if (z) {
                    aan.time += j;
                } else {
                    aan.aag++;
                }
                if (aan.num >= 100) {
                    uE();
                }
            }
            if (!z) {
                if (dVar == null) {
                    dVar = eB();
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
                com.baidu.adp.lib.stats.a.eI().b("img", dVar);
            }
        }
    }

    public static void uE() {
        if (aan.num > 10) {
            com.baidu.adp.lib.stats.d eB = eB();
            eB.q("act", "dcStat");
            eB.q("costTime", String.valueOf(aan.time));
            eB.q("num", String.valueOf(aan.num));
            eB.q("failnum", String.valueOf(aan.aag));
            com.baidu.adp.lib.stats.a.eI().b("img", eB);
            com.baidu.tbadk.performanceLog.x.a(aan.num, aan.aag, aan.time);
            aan.reset();
        }
    }

    public static void dp(String str) {
        com.baidu.adp.lib.stats.d eB = eB();
        eB.q("act", "assistant");
        eB.q(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, str);
        com.baidu.adp.lib.stats.a.eI().b("img", eB);
    }

    private static String uF() {
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [598=4] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static long uG() {
        HttpURLConnection httpURLConnection;
        long j;
        if (aai >= 3) {
            return aaj;
        }
        long currentTimeMillis = System.currentTimeMillis();
        HttpURLConnection httpURLConnection2 = null;
        try {
            httpURLConnection = (HttpURLConnection) new URL("http://www.baidu.com/").openConnection();
            try {
                httpURLConnection.setConnectTimeout(2500);
                httpURLConnection.connect();
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.h.a.f(httpURLConnection);
                j = currentTimeMillis2;
            } catch (SocketTimeoutException e) {
                com.baidu.adp.lib.h.a.f(httpURLConnection);
                j = 2500;
                if (j > 0) {
                }
            } catch (Exception e2) {
                httpURLConnection2 = httpURLConnection;
                com.baidu.adp.lib.h.a.f(httpURLConnection2);
                j = -1;
                if (j > 0) {
                }
            } catch (Throwable th) {
                httpURLConnection2 = httpURLConnection;
                th = th;
                com.baidu.adp.lib.h.a.f(httpURLConnection2);
                throw th;
            }
        } catch (SocketTimeoutException e3) {
            httpURLConnection = null;
        } catch (Exception e4) {
        } catch (Throwable th2) {
            th = th2;
        }
        if (j > 0) {
            if (aai > -1) {
                aaj = ((aaj * aai) + j) / (aai + 1);
            } else {
                aaj = j;
            }
            aai++;
            return j;
        }
        return j;
    }

    private static String uH() {
        return com.baidu.tbadk.imageManager.c.Ep().df();
    }

    private static String uI() {
        return com.baidu.adp.lib.asyncTask.c.dg().df();
    }

    public static void a(boolean z, boolean z2, String str, String str2) {
        com.baidu.adp.lib.stats.d eB = eB();
        eB.q("act", "getCDNList");
        eB.q("errorNum", str);
        eB.q(EcommSellerErrorActivityConfig.ERROR_MSG, str2);
        eB.q("isShortNetError", z2 ? "1" : "0");
        eB.q("isSuccess", z ? "1" : "0");
        com.baidu.adp.lib.stats.a.eI().b("img", eB);
    }

    public static void a(boolean z, String str, String str2, String str3, String str4, String str5, long j, boolean z2) {
        String str6 = "";
        if (str != null) {
            str6 = v.uN().dq(str);
        }
        String uF = uF();
        String ip = e.getIp();
        com.baidu.adp.lib.stats.d eB = eB();
        eB.q("act", "tachometerCDN");
        eB.q("errorNum", str3);
        eB.q("execption", str4);
        eB.q("size", str5);
        eB.q("isScuess", z ? "1" : "0");
        eB.q("url", str);
        eB.q("localIp", ip);
        eB.q("cdnIp", str6);
        eB.q("dnsIP", uF);
        eB.q("usedIp", str2);
        eB.q("isUsedIp", z2 ? "0" : "1");
        eB.q("costTime", String.valueOf(j));
        com.baidu.adp.lib.stats.a.eI().b("img", eB);
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
                    com.baidu.adp.lib.stats.d eB = eB();
                    eB.q("act", "mobileTachometerCDN");
                    eB.q("costTime", String.valueOf(j));
                    eB.q("ipList", sb.toString());
                    com.baidu.adp.lib.stats.a.eI().b("img", eB);
                    return;
                }
            }
        }
    }

    public static void d(boolean z, String str) {
        com.baidu.adp.lib.stats.d eB = eB();
        eB.q("act", "getCDNList");
        eB.q("isSuccess", z ? "1" : "0");
        eB.q(EcommSellerErrorActivityConfig.ERROR_MSG, str);
        com.baidu.adp.lib.stats.a.eI().b("img", eB);
    }

    public static void a(String str, int i, int i2, int i3) {
        if (i == -1) {
            i = 0;
        }
        if (i2 == -1) {
            i2 = 0;
        }
        com.baidu.adp.lib.stats.a.eI().eventStat(null, str, "imgHttpSwitch", 1, "1sterrcode", String.valueOf(i), "2nderrcode", String.valueOf(i2), "2imgFailed", String.valueOf(i3));
    }
}
