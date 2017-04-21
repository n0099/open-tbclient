package com.baidu.tbadk.core.util;

import android.net.DhcpInfo;
import android.net.wifi.WifiManager;
import android.support.v4.view.MotionEventCompat;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbDomainConfig;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class u {
    private static long aev = 0;
    private static long aew = 0;
    private static int aex = 0;
    private static a aey = new a(null);
    private static t aez = new t();
    private static t aeA = new t();
    private static String aeB = null;
    private static Object wA = new Object();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        int aeC;
        boolean aeD;
        t aeE;
        t aeF;
        t aeG;
        t aeH;
        t aeI;
        t aeJ;
        t aeK;
        t aeL;
        t aeM;
        t aeN;
        t aeO;
        t aeP;
        t aeQ;
        t aeR;
        t aeS;

        private a() {
            this.aeC = 0;
            this.aeE = new t();
            this.aeF = new t();
            this.aeG = new t();
            this.aeH = new t();
            this.aeI = new t();
            this.aeJ = new t();
            this.aeK = new t();
            this.aeL = new t();
            this.aeM = new t();
            this.aeN = new t();
            this.aeO = new t();
            this.aeP = new t();
            this.aeQ = new t();
            this.aeR = new t();
            this.aeS = new t();
        }

        /* synthetic */ a(a aVar) {
            this();
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [75=4] */
        public int vj() {
            return this.aeE.num + this.aeF.num + this.aeG.num + this.aeH.num + this.aeI.num;
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [81=14] */
        public int vk() {
            return this.aeE.num + this.aeF.num + this.aeG.num + this.aeH.num + this.aeI.num + this.aeJ.num + this.aeK.num + this.aeL.num + this.aeM.num + this.aeN.num + this.aeO.num + this.aeP.num + this.aeQ.num + this.aeR.num + this.aeS.num;
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [92=4] */
        public int vl() {
            return this.aeJ.num + this.aeK.num + this.aeL.num + this.aeM.num + this.aeN.num;
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [98=4] */
        public int vm() {
            return this.aeO.num + this.aeP.num + this.aeQ.num + this.aeR.num + this.aeS.num;
        }

        public void reset() {
            this.aeC = 0;
            this.aeE.reset();
            this.aeF.reset();
            this.aeG.reset();
            this.aeH.reset();
            this.aeI.reset();
            this.aeJ.reset();
            this.aeK.reset();
            this.aeL.reset();
            this.aeM.reset();
            this.aeN.reset();
            this.aeO.reset();
            this.aeP.reset();
            this.aeQ.reset();
            this.aeR.reset();
            this.aeS.reset();
        }
    }

    private static t a(boolean z, boolean z2, String str, boolean z3) {
        if (z) {
            if (z2 && !z3) {
                return aey.aeE;
            }
            if (str.startsWith("http://tb.himg")) {
                return aey.aeF;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return aey.aeG;
            }
            if (z2 && z3) {
                return aey.aeI;
            }
            return aey.aeH;
        } else if (com.baidu.adp.lib.util.i.hp()) {
            if (z2) {
                return aey.aeJ;
            }
            if (str.startsWith("http://tb.himg")) {
                return aey.aeK;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return aey.aeL;
            }
            return aey.aeM;
        } else if (z2) {
            return aey.aeO;
        } else {
            if (str.startsWith("http://tb.himg")) {
                return aey.aeP;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return aey.aeQ;
            }
            return aey.aeR;
        }
    }

    public static com.baidu.adp.lib.stats.c fN() {
        return BdStatisticsManager.getInstance().getStatsItem("dbg");
    }

    public static void a(com.baidu.adp.lib.stats.c cVar, String str, boolean z, long j, boolean z2) {
        if (z && z2) {
            synchronized (wA) {
                aez.num++;
                aez.time += j;
                if (aez.num >= 100) {
                    vc();
                }
            }
        }
    }

    public static void vc() {
        if (aez.num > 10) {
            com.baidu.adp.lib.stats.c fN = fN();
            fN.p("act", "locStat");
            fN.p("costTime", String.valueOf(aez.time));
            fN.p("num", String.valueOf(aez.num));
            fN.p("isWifi", "1");
            BdStatisticsManager.getInstance().debug("img", fN);
            aez.reset();
        }
    }

    public static void a(com.baidu.adp.lib.stats.c cVar, String str, boolean z, String str2, boolean z2, Boolean bool, com.baidu.adp.lib.network.http.e eVar, String str3, long j, boolean z3, long j2, int i) {
        boolean z4;
        String str4;
        String str5;
        if (com.baidu.adp.lib.util.k.hB() && eVar != null) {
            String str6 = "";
            boolean gf = com.baidu.tbadk.util.g.gf(str2);
            boolean z5 = false;
            if (com.baidu.tbadk.core.util.a.e.getInstance() != null) {
                z5 = true;
                if (!com.baidu.tbadk.core.util.a.e.getInstance().aho) {
                    com.baidu.tbadk.core.util.a.e.getInstance().init();
                }
            }
            boolean hl = com.baidu.adp.lib.util.i.hl();
            if (!z5) {
                z4 = false;
            } else if (hl) {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().RQ);
            } else if (com.baidu.adp.lib.util.i.hp()) {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().RS);
            } else {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().RR);
            }
            boolean z6 = false;
            if (gf && z5) {
                z6 = com.baidu.tbadk.core.util.a.e.getInstance().isShouldCDNFallBack();
            }
            if (gf && hl && z6) {
                if (z) {
                    r.getInstance().insertNormalData(j, str);
                } else {
                    str6 = v.vn().vo();
                    if (!TextUtils.isEmpty(str6)) {
                        r.getInstance().insertErrorData(eVar.vA, str);
                    }
                }
            }
            if (gf) {
                aeB = str;
            }
            boolean z7 = false;
            if (eVar.vC != null && eVar.vC.length() > 0) {
                z7 = true;
            }
            synchronized (wA) {
                t a2 = a(hl, gf, str2, z7);
                boolean z8 = aey.aeD;
                if (a2 != null) {
                    a2.num++;
                    if (z) {
                        a2.time += j;
                        a2.vu += j2;
                        aey.aeD = true;
                        if (z4) {
                            a2.aeu++;
                        }
                        aex = 0;
                    } else {
                        if (com.baidu.adp.lib.util.i.hk()) {
                            int i2 = aex + 1;
                            aex = i2;
                            if (i2 >= com.baidu.adp.lib.stats.switchs.a.gC().getMaxAlertCount("alert_img", 5)) {
                                BdStatisticsManager.getInstance().alert("alert_img", "imgFailedCnt_" + String.valueOf(aex) + "_url=" + str2);
                            }
                        }
                        a2.aet++;
                        aey.aeD = false;
                    }
                }
                int vk = aey.vk();
                if (vk > 100 || (vk > 0 && z8 != aey.aeD)) {
                    vd();
                }
            }
            if (z && z5) {
                if (!hl || j >= com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().RQ) {
                    if (hl || !com.baidu.adp.lib.util.i.hp() || j >= com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().RS) {
                        if (!hl && j < com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().RR) {
                            return;
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
            if (cVar == null) {
                cVar = fN();
            }
            if (TextUtils.isEmpty(str6)) {
                str6 = v.vn().vo();
            }
            if (!gf || !TextUtils.isEmpty("")) {
                str4 = "";
            } else {
                str4 = v.vn().dp(str);
            }
            if (!TextUtils.isEmpty("")) {
                str5 = "";
            } else {
                str5 = vf();
            }
            cVar.p("url", str);
            cVar.p("act", "dl");
            cVar.p("result", z ? "1" : "0");
            cVar.p("fullurl", str2);
            cVar.p("netlib", String.valueOf(eVar.vG));
            cVar.p("costTime", String.valueOf(j));
            cVar.p("connTime", String.valueOf(eVar.connectTime));
            cVar.p("rspTime", String.valueOf(eVar.vv));
            cVar.p("retry", String.valueOf(eVar.vw));
            cVar.p("localIp", d.getIp());
            cVar.p("tiebaIp", str6);
            cVar.p("cdnIp", str4);
            cVar.p("useIp", eVar.vC);
            cVar.p("dnsIp", str5);
            if (eVar.connectTime > 1500 || eVar.connectTime < 0) {
                cVar.p("connBaidu", String.valueOf(vg()));
            }
            cVar.p("memory", vh());
            cVar.p("task", vi());
            cVar.p("status", String.valueOf(eVar.vB));
            cVar.p("up", String.valueOf(eVar.vt));
            cVar.p("down", String.valueOf(eVar.vu));
            cVar.p("isCDN", gf ? "1" : "0");
            cVar.p("isWebp", bool.booleanValue() ? "1" : "0");
            cVar.p("isMobileProxy", z3 ? "1" : "0");
            cVar.p("exception", eVar.vz);
            cVar.p("reason", str3);
            if (i != 0) {
                cVar.d("procType", Integer.valueOf(i));
            }
            if (eVar.vE != null) {
                cVar.p("tracecode1", eVar.vE);
            }
            if (eVar.vF != null) {
                cVar.p("tracecode2", eVar.vF);
            }
            BdStatisticsManager.getInstance().debug("img", cVar);
            if (gf && !TextUtils.isEmpty(str6) && TextUtils.isEmpty(str4) && !z) {
                aey.aeC++;
            }
        }
    }

    public static void vd() {
        if (aey.vk() > 10) {
            if (aey.vj() > 0) {
                a(aey.aeE, aey.aeF, aey.aeG, aey.aeI, aey.aeH, 10000);
                com.baidu.tbadk.j.x.b(aey.aeE, aey.aeF, aey.aeG, aey.aeI, aey.aeH, 3);
            }
            if (aey.vm() > 0) {
                a(aey.aeO, aey.aeP, aey.aeQ, aey.aeS, aey.aeR, 100002);
                com.baidu.tbadk.j.x.b(aey.aeO, aey.aeP, aey.aeQ, aey.aeS, aey.aeR, 2);
            }
            if (aey.vl() > 0) {
                a(aey.aeJ, aey.aeK, aey.aeL, aey.aeN, aey.aeM, 100001);
                com.baidu.tbadk.j.x.b(aey.aeJ, aey.aeK, aey.aeL, aey.aeN, aey.aeM, 1);
            }
            aey.reset();
        }
    }

    public static void a(t tVar, t tVar2, t tVar3, t tVar4, t tVar5, int i) {
        if (tVar != null && tVar2 != null && tVar3 != null && tVar4 != null && tVar5 != null) {
            String str = "";
            String str2 = "";
            String str3 = "";
            if (TextUtils.isEmpty("")) {
                str = v.vn().vo();
            }
            if (aeB != null && TextUtils.isEmpty("")) {
                str2 = v.vn().dp(aeB);
            }
            if (TextUtils.isEmpty("")) {
                str3 = vf();
            }
            com.baidu.adp.lib.stats.c fN = fN();
            fN.p("act", "dlStat");
            fN.p("cdnCostTime", String.valueOf(tVar.time));
            fN.p("cdnNum", String.valueOf(tVar.num));
            fN.p("cdnFailnum", String.valueOf(tVar.aet));
            fN.p("portraitCostTime", String.valueOf(tVar2.time));
            fN.p("portraitNum", String.valueOf(tVar2.num));
            fN.p("portraitFailnum", String.valueOf(tVar2.aet));
            fN.p("tiebaCostTime", String.valueOf(tVar3.time));
            fN.p("tiebaNum", String.valueOf(tVar3.num));
            fN.p("tiebaFailnum", String.valueOf(tVar3.aet));
            fN.p("otherCostTime", String.valueOf(tVar5.time));
            fN.p("otherNum", String.valueOf(tVar5.num));
            fN.p("otherFailnum", String.valueOf(tVar5.aet));
            fN.p("directIpCostTime", String.valueOf(tVar4.time));
            fN.p("directIpNum", String.valueOf(tVar4.num));
            fN.p("directIpFailnum", String.valueOf(tVar4.aet));
            fN.p("dnsFailNum", String.valueOf(aey.aeC));
            if (10000 == i) {
                fN.p("isWifi", "1");
                fN.p("netType", "WIFI");
            } else if (100002 == i) {
                fN.p("netType", "3G");
                fN.p("isWifi", "0");
            } else {
                fN.p("netType", "2G");
                fN.p("isWifi", "0");
            }
            fN.p("localIp", d.getIp());
            fN.p("tbIp", str);
            fN.p("cdnIp", str2);
            fN.p("dnsIp", str3);
            BdStatisticsManager.getInstance().debug("img", fN);
        }
    }

    public static void a(com.baidu.adp.lib.stats.c cVar, String str, String str2, boolean z, boolean z2, boolean z3, int i, String str3, long j, String str4) {
        if (com.baidu.adp.lib.util.k.hB()) {
            synchronized (wA) {
                aeA.num++;
                if (z) {
                    aeA.time += j;
                } else {
                    aeA.aet++;
                }
                if (aeA.num >= 100) {
                    ve();
                }
            }
            if (!z) {
                if (cVar == null) {
                    cVar = fN();
                }
                cVar.p("act", "dc");
                cVar.p("costTime", String.valueOf(j));
                cVar.p("url", str);
                cVar.p("fullURL", str2);
                cVar.p("isWebp", z3 ? "1" : "0");
                cVar.p("isCDN", z2 ? "1" : "0");
                cVar.p("length", String.valueOf(i));
                cVar.p("reason", str3);
                cVar.p("result", z ? "0" : "1");
                cVar.p("execption", str4);
                BdStatisticsManager.getInstance().debug("img", cVar);
            }
        }
    }

    public static void ve() {
        if (aeA.num > 10) {
            com.baidu.adp.lib.stats.c fN = fN();
            fN.p("act", "dcStat");
            fN.p("costTime", String.valueOf(aeA.time));
            fN.p("num", String.valueOf(aeA.num));
            fN.p("failnum", String.valueOf(aeA.aet));
            BdStatisticsManager.getInstance().debug("img", fN);
            com.baidu.tbadk.j.x.a(aeA.num, aeA.aet, aeA.time);
            aeA.reset();
        }
    }

    /* renamed from: do  reason: not valid java name */
    public static void m11do(String str) {
        com.baidu.adp.lib.stats.c fN = fN();
        fN.p("act", "assistant");
        fN.p(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, str);
        BdStatisticsManager.getInstance().debug("img", fN);
    }

    private static String vf() {
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [599=4] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static long vg() {
        HttpURLConnection httpURLConnection;
        long j;
        if (aev >= 3) {
            return aew;
        }
        long currentTimeMillis = System.currentTimeMillis();
        HttpURLConnection httpURLConnection2 = null;
        try {
            httpURLConnection = (HttpURLConnection) new URL(TbDomainConfig.DOMAIN_HTTPS_BAIDU).openConnection();
            try {
                httpURLConnection.setConnectTimeout(TbConfig.NOTIFY_YUN_PUSH);
                httpURLConnection.connect();
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.g.a.g(httpURLConnection);
                j = currentTimeMillis2;
            } catch (SocketTimeoutException e) {
                com.baidu.adp.lib.g.a.g(httpURLConnection);
                j = 2500;
                if (j > 0) {
                }
            } catch (Exception e2) {
                httpURLConnection2 = httpURLConnection;
                com.baidu.adp.lib.g.a.g(httpURLConnection2);
                j = -1;
                if (j > 0) {
                }
            } catch (Throwable th) {
                httpURLConnection2 = httpURLConnection;
                th = th;
                com.baidu.adp.lib.g.a.g(httpURLConnection2);
                throw th;
            }
        } catch (SocketTimeoutException e3) {
            httpURLConnection = null;
        } catch (Exception e4) {
        } catch (Throwable th2) {
            th = th2;
        }
        if (j > 0) {
            if (aev > -1) {
                aew = ((aew * aev) + j) / (aev + 1);
            } else {
                aew = j;
            }
            aev++;
            return j;
        }
        return j;
    }

    private static String vh() {
        return com.baidu.tbadk.imageManager.c.EJ().em();
    }

    private static String vi() {
        return com.baidu.adp.lib.asyncTask.c.en().em();
    }

    public static void a(boolean z, boolean z2, String str, String str2) {
        com.baidu.adp.lib.stats.c fN = fN();
        fN.p("act", "getCDNList");
        fN.p("errorNum", str);
        fN.p("errorMsg", str2);
        fN.p("isShortNetError", z2 ? "1" : "0");
        fN.p("isSuccess", z ? "1" : "0");
        BdStatisticsManager.getInstance().debug("img", fN);
    }

    public static void a(boolean z, String str, String str2, String str3, String str4, String str5, long j, boolean z2) {
        String str6 = "";
        if (str != null) {
            str6 = v.vn().dp(str);
        }
        String vf = vf();
        String ip = d.getIp();
        com.baidu.adp.lib.stats.c fN = fN();
        fN.p("act", "tachometerCDN");
        fN.p("errorNum", str3);
        fN.p("execption", str4);
        fN.p("size", str5);
        fN.p("isScuess", z ? "1" : "0");
        fN.p("url", str);
        fN.p("localIp", ip);
        fN.p("cdnIp", str6);
        fN.p("dnsIP", vf);
        fN.p("usedIp", str2);
        fN.p("isUsedIp", z2 ? "0" : "1");
        fN.p("costTime", String.valueOf(j));
        BdStatisticsManager.getInstance().debug("img", fN);
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
                    com.baidu.adp.lib.stats.c fN = fN();
                    fN.p("act", "mobileTachometerCDN");
                    fN.p("costTime", String.valueOf(j));
                    fN.p("ipList", sb.toString());
                    BdStatisticsManager.getInstance().debug("img", fN);
                    return;
                }
            }
        }
    }

    public static void c(boolean z, String str) {
        com.baidu.adp.lib.stats.c fN = fN();
        fN.p("act", "getCDNList");
        fN.p("isSuccess", z ? "1" : "0");
        fN.p("errorMsg", str);
        BdStatisticsManager.getInstance().debug("img", fN);
    }

    public static void a(String str, int i, int i2, int i3) {
        if (i == -1) {
            i = 0;
        }
        if (i2 == -1) {
            i2 = 0;
        }
        BdStatisticsManager.getInstance().eventStat(null, str, "imgHttpSwitch", 1, "1sterrcode", String.valueOf(i), "2nderrcode", String.valueOf(i2), "2imgFailed", String.valueOf(i3));
    }
}
