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
    private static long aeu = 0;
    private static long aev = 0;
    private static int aew = 0;
    private static a aex = new a(null);
    private static t aey = new t();
    private static t aez = new t();
    private static String aeA = null;
    private static Object ww = new Object();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        int aeB;
        boolean aeC;
        t aeD;
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

        private a() {
            this.aeB = 0;
            this.aeD = new t();
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
        }

        /* synthetic */ a(a aVar) {
            this();
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [75=4] */
        public int vj() {
            return this.aeD.num + this.aeE.num + this.aeF.num + this.aeG.num + this.aeH.num;
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [81=14] */
        public int vk() {
            return this.aeD.num + this.aeE.num + this.aeF.num + this.aeG.num + this.aeH.num + this.aeI.num + this.aeJ.num + this.aeK.num + this.aeL.num + this.aeM.num + this.aeN.num + this.aeO.num + this.aeP.num + this.aeQ.num + this.aeR.num;
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [92=4] */
        public int vl() {
            return this.aeI.num + this.aeJ.num + this.aeK.num + this.aeL.num + this.aeM.num;
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [98=4] */
        public int vm() {
            return this.aeN.num + this.aeO.num + this.aeP.num + this.aeQ.num + this.aeR.num;
        }

        public void reset() {
            this.aeB = 0;
            this.aeD.reset();
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
        }
    }

    private static t a(boolean z, boolean z2, String str, boolean z3) {
        if (z) {
            if (z2 && !z3) {
                return aex.aeD;
            }
            if (str.startsWith("http://tb.himg")) {
                return aex.aeE;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return aex.aeF;
            }
            if (z2 && z3) {
                return aex.aeH;
            }
            return aex.aeG;
        } else if (com.baidu.adp.lib.util.i.ho()) {
            if (z2) {
                return aex.aeI;
            }
            if (str.startsWith("http://tb.himg")) {
                return aex.aeJ;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return aex.aeK;
            }
            return aex.aeL;
        } else if (z2) {
            return aex.aeN;
        } else {
            if (str.startsWith("http://tb.himg")) {
                return aex.aeO;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return aex.aeP;
            }
            return aex.aeQ;
        }
    }

    public static com.baidu.adp.lib.stats.c fM() {
        return BdStatisticsManager.getInstance().getStatsItem("dbg");
    }

    public static void a(com.baidu.adp.lib.stats.c cVar, String str, boolean z, long j, boolean z2) {
        if (z && z2) {
            synchronized (ww) {
                aey.num++;
                aey.time += j;
                if (aey.num >= 100) {
                    vc();
                }
            }
        }
    }

    public static void vc() {
        if (aey.num > 10) {
            com.baidu.adp.lib.stats.c fM = fM();
            fM.p("act", "locStat");
            fM.p("costTime", String.valueOf(aey.time));
            fM.p("num", String.valueOf(aey.num));
            fM.p("isWifi", "1");
            BdStatisticsManager.getInstance().debug("img", fM);
            aey.reset();
        }
    }

    public static void a(com.baidu.adp.lib.stats.c cVar, String str, boolean z, String str2, boolean z2, Boolean bool, com.baidu.adp.lib.network.http.e eVar, String str3, long j, boolean z3, long j2, int i) {
        boolean z4;
        String str4;
        String str5;
        if (com.baidu.adp.lib.util.k.hA() && eVar != null) {
            String str6 = "";
            boolean gf = com.baidu.tbadk.util.g.gf(str2);
            boolean z5 = false;
            if (com.baidu.tbadk.core.util.a.e.getInstance() != null) {
                z5 = true;
                if (!com.baidu.tbadk.core.util.a.e.getInstance().ahn) {
                    com.baidu.tbadk.core.util.a.e.getInstance().init();
                }
            }
            boolean hk = com.baidu.adp.lib.util.i.hk();
            if (!z5) {
                z4 = false;
            } else if (hk) {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().RO);
            } else if (com.baidu.adp.lib.util.i.ho()) {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().RQ);
            } else {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().RP);
            }
            boolean z6 = false;
            if (gf && z5) {
                z6 = com.baidu.tbadk.core.util.a.e.getInstance().isShouldCDNFallBack();
            }
            if (gf && hk && z6) {
                if (z) {
                    r.getInstance().insertNormalData(j, str);
                } else {
                    str6 = v.vn().vo();
                    if (!TextUtils.isEmpty(str6)) {
                        r.getInstance().insertErrorData(eVar.vw, str);
                    }
                }
            }
            if (gf) {
                aeA = str;
            }
            boolean z7 = false;
            if (eVar.vy != null && eVar.vy.length() > 0) {
                z7 = true;
            }
            synchronized (ww) {
                t a2 = a(hk, gf, str2, z7);
                boolean z8 = aex.aeC;
                if (a2 != null) {
                    a2.num++;
                    if (z) {
                        a2.time += j;
                        a2.vp += j2;
                        aex.aeC = true;
                        if (z4) {
                            a2.aet++;
                        }
                        aew = 0;
                    } else {
                        if (com.baidu.adp.lib.util.i.hj()) {
                            int i2 = aew + 1;
                            aew = i2;
                            if (i2 >= com.baidu.adp.lib.stats.switchs.a.gB().getMaxAlertCount("alert_img", 5)) {
                                BdStatisticsManager.getInstance().alert("alert_img", "imgFailedCnt_" + String.valueOf(aew) + "_url=" + str2);
                            }
                        }
                        a2.aes++;
                        aex.aeC = false;
                    }
                }
                int vk = aex.vk();
                if (vk > 100 || (vk > 0 && z8 != aex.aeC)) {
                    vd();
                }
            }
            if (z && z5) {
                if (!hk || j >= com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().RO) {
                    if (hk || !com.baidu.adp.lib.util.i.ho() || j >= com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().RQ) {
                        if (!hk && j < com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().RP) {
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
                cVar = fM();
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
            cVar.p("netlib", String.valueOf(eVar.vC));
            cVar.p("costTime", String.valueOf(j));
            cVar.p("connTime", String.valueOf(eVar.vq));
            cVar.p("rspTime", String.valueOf(eVar.vr));
            cVar.p("retry", String.valueOf(eVar.vs));
            cVar.p("localIp", d.getIp());
            cVar.p("tiebaIp", str6);
            cVar.p("cdnIp", str4);
            cVar.p("useIp", eVar.vy);
            cVar.p("dnsIp", str5);
            if (eVar.vq > 1500 || eVar.vq < 0) {
                cVar.p("connBaidu", String.valueOf(vg()));
            }
            cVar.p("memory", vh());
            cVar.p("task", vi());
            cVar.p("status", String.valueOf(eVar.vx));
            cVar.p("up", String.valueOf(eVar.vo));
            cVar.p("down", String.valueOf(eVar.vp));
            cVar.p("isCDN", gf ? "1" : "0");
            cVar.p("isWebp", bool.booleanValue() ? "1" : "0");
            cVar.p("isMobileProxy", z3 ? "1" : "0");
            cVar.p("exception", eVar.vv);
            cVar.p("reason", str3);
            if (i != 0) {
                cVar.d("procType", Integer.valueOf(i));
            }
            if (eVar.vA != null) {
                cVar.p("tracecode1", eVar.vA);
            }
            if (eVar.vB != null) {
                cVar.p("tracecode2", eVar.vB);
            }
            BdStatisticsManager.getInstance().debug("img", cVar);
            if (gf && !TextUtils.isEmpty(str6) && TextUtils.isEmpty(str4) && !z) {
                aex.aeB++;
            }
        }
    }

    public static void vd() {
        if (aex.vk() > 10) {
            if (aex.vj() > 0) {
                a(aex.aeD, aex.aeE, aex.aeF, aex.aeH, aex.aeG, 10000);
                com.baidu.tbadk.j.x.b(aex.aeD, aex.aeE, aex.aeF, aex.aeH, aex.aeG, 3);
            }
            if (aex.vm() > 0) {
                a(aex.aeN, aex.aeO, aex.aeP, aex.aeR, aex.aeQ, 100002);
                com.baidu.tbadk.j.x.b(aex.aeN, aex.aeO, aex.aeP, aex.aeR, aex.aeQ, 2);
            }
            if (aex.vl() > 0) {
                a(aex.aeI, aex.aeJ, aex.aeK, aex.aeM, aex.aeL, 100001);
                com.baidu.tbadk.j.x.b(aex.aeI, aex.aeJ, aex.aeK, aex.aeM, aex.aeL, 1);
            }
            aex.reset();
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
            if (aeA != null && TextUtils.isEmpty("")) {
                str2 = v.vn().dp(aeA);
            }
            if (TextUtils.isEmpty("")) {
                str3 = vf();
            }
            com.baidu.adp.lib.stats.c fM = fM();
            fM.p("act", "dlStat");
            fM.p("cdnCostTime", String.valueOf(tVar.time));
            fM.p("cdnNum", String.valueOf(tVar.num));
            fM.p("cdnFailnum", String.valueOf(tVar.aes));
            fM.p("portraitCostTime", String.valueOf(tVar2.time));
            fM.p("portraitNum", String.valueOf(tVar2.num));
            fM.p("portraitFailnum", String.valueOf(tVar2.aes));
            fM.p("tiebaCostTime", String.valueOf(tVar3.time));
            fM.p("tiebaNum", String.valueOf(tVar3.num));
            fM.p("tiebaFailnum", String.valueOf(tVar3.aes));
            fM.p("otherCostTime", String.valueOf(tVar5.time));
            fM.p("otherNum", String.valueOf(tVar5.num));
            fM.p("otherFailnum", String.valueOf(tVar5.aes));
            fM.p("directIpCostTime", String.valueOf(tVar4.time));
            fM.p("directIpNum", String.valueOf(tVar4.num));
            fM.p("directIpFailnum", String.valueOf(tVar4.aes));
            fM.p("dnsFailNum", String.valueOf(aex.aeB));
            if (10000 == i) {
                fM.p("isWifi", "1");
                fM.p("netType", "WIFI");
            } else if (100002 == i) {
                fM.p("netType", "3G");
                fM.p("isWifi", "0");
            } else {
                fM.p("netType", "2G");
                fM.p("isWifi", "0");
            }
            fM.p("localIp", d.getIp());
            fM.p("tbIp", str);
            fM.p("cdnIp", str2);
            fM.p("dnsIp", str3);
            BdStatisticsManager.getInstance().debug("img", fM);
        }
    }

    public static void a(com.baidu.adp.lib.stats.c cVar, String str, String str2, boolean z, boolean z2, boolean z3, int i, String str3, long j, String str4) {
        if (com.baidu.adp.lib.util.k.hA()) {
            synchronized (ww) {
                aez.num++;
                if (z) {
                    aez.time += j;
                } else {
                    aez.aes++;
                }
                if (aez.num >= 100) {
                    ve();
                }
            }
            if (!z) {
                if (cVar == null) {
                    cVar = fM();
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
        if (aez.num > 10) {
            com.baidu.adp.lib.stats.c fM = fM();
            fM.p("act", "dcStat");
            fM.p("costTime", String.valueOf(aez.time));
            fM.p("num", String.valueOf(aez.num));
            fM.p("failnum", String.valueOf(aez.aes));
            BdStatisticsManager.getInstance().debug("img", fM);
            com.baidu.tbadk.j.x.a(aez.num, aez.aes, aez.time);
            aez.reset();
        }
    }

    /* renamed from: do  reason: not valid java name */
    public static void m11do(String str) {
        com.baidu.adp.lib.stats.c fM = fM();
        fM.p("act", "assistant");
        fM.p(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, str);
        BdStatisticsManager.getInstance().debug("img", fM);
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
        if (aeu >= 3) {
            return aev;
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
            if (aeu > -1) {
                aev = ((aev * aeu) + j) / (aeu + 1);
            } else {
                aev = j;
            }
            aeu++;
            return j;
        }
        return j;
    }

    private static String vh() {
        return com.baidu.tbadk.imageManager.c.EJ().el();
    }

    private static String vi() {
        return com.baidu.adp.lib.asyncTask.c.em().el();
    }

    public static void a(boolean z, boolean z2, String str, String str2) {
        com.baidu.adp.lib.stats.c fM = fM();
        fM.p("act", "getCDNList");
        fM.p("errorNum", str);
        fM.p("errorMsg", str2);
        fM.p("isShortNetError", z2 ? "1" : "0");
        fM.p("isSuccess", z ? "1" : "0");
        BdStatisticsManager.getInstance().debug("img", fM);
    }

    public static void a(boolean z, String str, String str2, String str3, String str4, String str5, long j, boolean z2) {
        String str6 = "";
        if (str != null) {
            str6 = v.vn().dp(str);
        }
        String vf = vf();
        String ip = d.getIp();
        com.baidu.adp.lib.stats.c fM = fM();
        fM.p("act", "tachometerCDN");
        fM.p("errorNum", str3);
        fM.p("execption", str4);
        fM.p("size", str5);
        fM.p("isScuess", z ? "1" : "0");
        fM.p("url", str);
        fM.p("localIp", ip);
        fM.p("cdnIp", str6);
        fM.p("dnsIP", vf);
        fM.p("usedIp", str2);
        fM.p("isUsedIp", z2 ? "0" : "1");
        fM.p("costTime", String.valueOf(j));
        BdStatisticsManager.getInstance().debug("img", fM);
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
                    com.baidu.adp.lib.stats.c fM = fM();
                    fM.p("act", "mobileTachometerCDN");
                    fM.p("costTime", String.valueOf(j));
                    fM.p("ipList", sb.toString());
                    BdStatisticsManager.getInstance().debug("img", fM);
                    return;
                }
            }
        }
    }

    public static void c(boolean z, String str) {
        com.baidu.adp.lib.stats.c fM = fM();
        fM.p("act", "getCDNList");
        fM.p("isSuccess", z ? "1" : "0");
        fM.p("errorMsg", str);
        BdStatisticsManager.getInstance().debug("img", fM);
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
