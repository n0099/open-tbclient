package com.baidu.tbadk.core.util;

import android.net.DhcpInfo;
import android.net.wifi.WifiManager;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.sapi2.callback.AccountCenterCallback;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbDomainConfig;
import com.tencent.open.SocialConstants;
import com.xiaomi.mipush.sdk.Constants;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class s {
    private static long aVg = 0;
    private static long aVh = 0;
    private static int aVi = 0;
    private static a aVj = new a();
    private static r aVk = new r();
    private static r aVl = new r();
    private static String aVm = null;
    private static Object syncLock = new Object();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        r aVA;
        r aVB;
        r aVC;
        r aVD;
        int aVn;
        boolean aVo;
        r aVp;
        r aVq;
        r aVr;
        r aVs;
        r aVt;
        r aVu;
        r aVv;
        r aVw;
        r aVx;
        r aVy;
        r aVz;

        private a() {
            this.aVn = 0;
            this.aVp = new r();
            this.aVq = new r();
            this.aVr = new r();
            this.aVs = new r();
            this.aVt = new r();
            this.aVu = new r();
            this.aVv = new r();
            this.aVw = new r();
            this.aVx = new r();
            this.aVy = new r();
            this.aVz = new r();
            this.aVA = new r();
            this.aVB = new r();
            this.aVC = new r();
            this.aVD = new r();
        }

        public int Cm() {
            return this.aVp.num + this.aVq.num + this.aVr.num + this.aVs.num + this.aVt.num;
        }

        public int Cn() {
            return this.aVp.num + this.aVq.num + this.aVr.num + this.aVs.num + this.aVt.num + this.aVu.num + this.aVv.num + this.aVw.num + this.aVx.num + this.aVy.num + this.aVz.num + this.aVA.num + this.aVB.num + this.aVC.num + this.aVD.num;
        }

        public int Co() {
            return this.aVu.num + this.aVv.num + this.aVw.num + this.aVx.num + this.aVy.num;
        }

        public int Cp() {
            return this.aVz.num + this.aVA.num + this.aVB.num + this.aVC.num + this.aVD.num;
        }

        public void reset() {
            this.aVn = 0;
            this.aVp.reset();
            this.aVq.reset();
            this.aVr.reset();
            this.aVs.reset();
            this.aVt.reset();
            this.aVu.reset();
            this.aVv.reset();
            this.aVw.reset();
            this.aVx.reset();
            this.aVy.reset();
            this.aVz.reset();
            this.aVA.reset();
            this.aVB.reset();
            this.aVC.reset();
            this.aVD.reset();
        }
    }

    private static r a(boolean z, boolean z2, String str, boolean z3) {
        if (z) {
            if (z2 && !z3) {
                return aVj.aVp;
            }
            if (str.startsWith("http://tb.himg")) {
                return aVj.aVq;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return aVj.aVr;
            }
            if (z2 && z3) {
                return aVj.aVt;
            }
            return aVj.aVs;
        } else if (com.baidu.adp.lib.util.j.oO()) {
            if (z2) {
                return aVj.aVu;
            }
            if (str.startsWith("http://tb.himg")) {
                return aVj.aVv;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return aVj.aVw;
            }
            return aVj.aVx;
        } else if (z2) {
            return aVj.aVz;
        } else {
            if (str.startsWith("http://tb.himg")) {
                return aVj.aVA;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return aVj.aVB;
            }
            return aVj.aVC;
        }
    }

    public static com.baidu.adp.lib.stats.a nn() {
        return BdStatisticsManager.getInstance().getStatsItem("dbg");
    }

    public static void a(com.baidu.adp.lib.stats.a aVar, String str, boolean z, long j, boolean z2) {
        if (z && z2) {
            synchronized (syncLock) {
                aVk.num++;
                aVk.time += j;
                if (aVk.num >= 100) {
                    Cf();
                }
            }
        }
    }

    public static void Cf() {
        if (aVk.num > 10) {
            com.baidu.adp.lib.stats.a nn = nn();
            nn.append(SocialConstants.PARAM_ACT, "locStat");
            nn.append("costTime", String.valueOf(aVk.time));
            nn.append("num", String.valueOf(aVk.num));
            nn.append("isWifi", "1");
            BdStatisticsManager.getInstance().debug("img", nn);
            aVk.reset();
        }
    }

    public static void a(com.baidu.adp.lib.stats.a aVar, String str, boolean z, String str2, boolean z2, Boolean bool, com.baidu.adp.lib.network.http.d dVar, String str3, long j, boolean z3, long j2, int i) {
        boolean z4;
        String str4;
        String str5;
        if (com.baidu.adp.lib.util.l.pa() && dVar != null) {
            String str6 = "";
            boolean hi = com.baidu.tbadk.util.i.hi(str2);
            boolean z5 = false;
            if (com.baidu.tbadk.core.util.a.e.getInstance() != null) {
                z5 = true;
                if (!com.baidu.tbadk.core.util.a.e.getInstance().aYg) {
                    com.baidu.tbadk.core.util.a.e.getInstance().init();
                }
            }
            boolean oK = com.baidu.adp.lib.util.j.oK();
            if (!z5) {
                z4 = false;
            } else if (oK) {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().aIq);
            } else if (com.baidu.adp.lib.util.j.oO()) {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().aIs);
            } else {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().aIr);
            }
            boolean z6 = false;
            if (hi && z5) {
                z6 = com.baidu.tbadk.core.util.a.e.getInstance().isShouldCDNFallBack();
            }
            if (hi && oK && z6) {
                if (z) {
                    p.getInstance().insertNormalData(j, str);
                } else {
                    str6 = t.Cq().Cr();
                    if (!TextUtils.isEmpty(str6)) {
                        p.getInstance().insertErrorData(dVar.ajg, str);
                    }
                }
            }
            if (hi) {
                aVm = str;
            }
            boolean z7 = false;
            if (dVar.aji != null && dVar.aji.length() > 0) {
                z7 = true;
            }
            synchronized (syncLock) {
                r a2 = a(oK, hi, str2, z7);
                boolean z8 = aVj.aVo;
                if (a2 != null) {
                    a2.num++;
                    if (z) {
                        a2.time += j;
                        a2.aja += j2;
                        aVj.aVo = true;
                        if (z4) {
                            a2.aVf++;
                        }
                        aVi = 0;
                    } else {
                        if (com.baidu.adp.lib.util.j.oJ()) {
                            int i2 = aVi + 1;
                            aVi = i2;
                            if (i2 >= com.baidu.adp.lib.stats.switchs.a.ob().getMaxAlertCount("alert_img", 5)) {
                                BdStatisticsManager.getInstance().alert("alert_img", "imgFailedCnt_" + String.valueOf(aVi) + "_url=" + str2);
                            }
                        }
                        a2.aVe++;
                        aVj.aVo = false;
                    }
                }
                int Cn = aVj.Cn();
                if (Cn > 100 || (Cn > 0 && z8 != aVj.aVo)) {
                    Cg();
                }
            }
            if (z && z5) {
                if (!oK || j >= com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().aIq) {
                    if (oK || !com.baidu.adp.lib.util.j.oO() || j >= com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().aIs) {
                        if (!oK && j < com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().aIr) {
                            return;
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
            if (aVar == null) {
                aVar = nn();
            }
            if (TextUtils.isEmpty(str6)) {
                str6 = t.Cq().Cr();
            }
            if (!hi || !TextUtils.isEmpty("")) {
                str4 = "";
            } else {
                str4 = t.Cq().ee(str);
            }
            if (!TextUtils.isEmpty("")) {
                str5 = "";
            } else {
                str5 = Ci();
            }
            aVar.append("url", str);
            aVar.append(SocialConstants.PARAM_ACT, "dl");
            aVar.append("result", z ? "1" : "0");
            aVar.append("fullurl", str2);
            aVar.append("netlib", String.valueOf(dVar.ajm));
            aVar.append("costTime", String.valueOf(j));
            aVar.append("connTime", String.valueOf(dVar.connectTime));
            aVar.append("rspTime", String.valueOf(dVar.ajb));
            aVar.append("retry", String.valueOf(dVar.ajc));
            aVar.append("localIp", d.getIp());
            aVar.append("tiebaIp", str6);
            aVar.append("cdnIp", str4);
            aVar.append("useIp", dVar.aji);
            aVar.append("dnsIp", str5);
            if (dVar.connectTime > 1500 || dVar.connectTime < 0) {
                aVar.append("connBaidu", String.valueOf(Cj()));
            }
            aVar.append("memory", Ck());
            aVar.append("task", Cl());
            aVar.append(NotificationCompat.CATEGORY_STATUS, String.valueOf(dVar.ajh));
            aVar.append("up", String.valueOf(dVar.aiZ));
            aVar.append("down", String.valueOf(dVar.aja));
            aVar.append("isCDN", hi ? "1" : "0");
            aVar.append("isWebp", bool.booleanValue() ? "1" : "0");
            aVar.append("isMobileProxy", z3 ? "1" : "0");
            aVar.append(com.baidu.fsg.base.statistics.b.k, dVar.ajf);
            aVar.append("reason", str3);
            if (i != 0) {
                aVar.h("procType", Integer.valueOf(i));
            }
            if (dVar.ajk != null) {
                aVar.append("tracecode1", dVar.ajk);
            }
            if (dVar.ajl != null) {
                aVar.append("tracecode2", dVar.ajl);
            }
            BdStatisticsManager.getInstance().debug("img", aVar);
            if (hi && !TextUtils.isEmpty(str6) && TextUtils.isEmpty(str4) && !z) {
                aVj.aVn++;
            }
        }
    }

    public static void Cg() {
        if (aVj.Cn() > 10) {
            if (aVj.Cm() > 0) {
                a(aVj.aVp, aVj.aVq, aVj.aVr, aVj.aVt, aVj.aVs, 10000);
                com.baidu.tbadk.k.n.b(aVj.aVp, aVj.aVq, aVj.aVr, aVj.aVt, aVj.aVs, 3);
            }
            if (aVj.Cp() > 0) {
                a(aVj.aVz, aVj.aVA, aVj.aVB, aVj.aVD, aVj.aVC, 100002);
                com.baidu.tbadk.k.n.b(aVj.aVz, aVj.aVA, aVj.aVB, aVj.aVD, aVj.aVC, 2);
            }
            if (aVj.Co() > 0) {
                a(aVj.aVu, aVj.aVv, aVj.aVw, aVj.aVy, aVj.aVx, AccountCenterCallback.REQUEST_CODE_LOGIN);
                com.baidu.tbadk.k.n.b(aVj.aVu, aVj.aVv, aVj.aVw, aVj.aVy, aVj.aVx, 1);
            }
            aVj.reset();
        }
    }

    public static void a(r rVar, r rVar2, r rVar3, r rVar4, r rVar5, int i) {
        if (rVar != null && rVar2 != null && rVar3 != null && rVar4 != null && rVar5 != null) {
            String str = "";
            String str2 = "";
            String str3 = "";
            if (TextUtils.isEmpty("")) {
                str = t.Cq().Cr();
            }
            if (aVm != null && TextUtils.isEmpty("")) {
                str2 = t.Cq().ee(aVm);
            }
            if (TextUtils.isEmpty("")) {
                str3 = Ci();
            }
            com.baidu.adp.lib.stats.a nn = nn();
            nn.append(SocialConstants.PARAM_ACT, "dlStat");
            nn.append("cdnCostTime", String.valueOf(rVar.time));
            nn.append("cdnNum", String.valueOf(rVar.num));
            nn.append("cdnFailnum", String.valueOf(rVar.aVe));
            nn.append("portraitCostTime", String.valueOf(rVar2.time));
            nn.append("portraitNum", String.valueOf(rVar2.num));
            nn.append("portraitFailnum", String.valueOf(rVar2.aVe));
            nn.append("tiebaCostTime", String.valueOf(rVar3.time));
            nn.append("tiebaNum", String.valueOf(rVar3.num));
            nn.append("tiebaFailnum", String.valueOf(rVar3.aVe));
            nn.append("otherCostTime", String.valueOf(rVar5.time));
            nn.append("otherNum", String.valueOf(rVar5.num));
            nn.append("otherFailnum", String.valueOf(rVar5.aVe));
            nn.append("directIpCostTime", String.valueOf(rVar4.time));
            nn.append("directIpNum", String.valueOf(rVar4.num));
            nn.append("directIpFailnum", String.valueOf(rVar4.aVe));
            nn.append("dnsFailNum", String.valueOf(aVj.aVn));
            if (10000 == i) {
                nn.append("isWifi", "1");
                nn.append("netType", "WIFI");
            } else if (100002 == i) {
                nn.append("netType", "3G");
                nn.append("isWifi", "0");
            } else {
                nn.append("netType", "2G");
                nn.append("isWifi", "0");
            }
            nn.append("localIp", d.getIp());
            nn.append("tbIp", str);
            nn.append("cdnIp", str2);
            nn.append("dnsIp", str3);
            BdStatisticsManager.getInstance().debug("img", nn);
        }
    }

    public static void a(com.baidu.adp.lib.stats.a aVar, String str, String str2, boolean z, boolean z2, boolean z3, int i, String str3, long j, String str4) {
        if (com.baidu.adp.lib.util.l.pa()) {
            synchronized (syncLock) {
                aVl.num++;
                if (z) {
                    aVl.time += j;
                } else {
                    aVl.aVe++;
                }
                if (aVl.num >= 100) {
                    Ch();
                }
            }
            if (!z) {
                if (aVar == null) {
                    aVar = nn();
                }
                aVar.append(SocialConstants.PARAM_ACT, "dc");
                aVar.append("costTime", String.valueOf(j));
                aVar.append("url", str);
                aVar.append("fullURL", str2);
                aVar.append("isWebp", z3 ? "1" : "0");
                aVar.append("isCDN", z2 ? "1" : "0");
                aVar.append("length", String.valueOf(i));
                aVar.append("reason", str3);
                aVar.append("result", z ? "0" : "1");
                aVar.append("execption", str4);
                BdStatisticsManager.getInstance().debug("img", aVar);
            }
        }
    }

    public static void Ch() {
        if (aVl.num > 10) {
            com.baidu.adp.lib.stats.a nn = nn();
            nn.append(SocialConstants.PARAM_ACT, "dcStat");
            nn.append("costTime", String.valueOf(aVl.time));
            nn.append("num", String.valueOf(aVl.num));
            nn.append("failnum", String.valueOf(aVl.aVe));
            BdStatisticsManager.getInstance().debug("img", nn);
            com.baidu.tbadk.k.n.a(aVl.num, aVl.aVe, aVl.time);
            aVl.reset();
        }
    }

    public static void ed(String str) {
        com.baidu.adp.lib.stats.a nn = nn();
        nn.append(SocialConstants.PARAM_ACT, "assistant");
        nn.append("content", str);
        BdStatisticsManager.getInstance().debug("img", nn);
    }

    private static String Ci() {
        try {
            DhcpInfo dhcpInfo = ((WifiManager) BdBaseApplication.getInst().getApp().getSystemService("wifi")).getDhcpInfo();
            return intToIp(dhcpInfo.dns1) + Constants.ACCEPT_TIME_SEPARATOR_SP + intToIp(dhcpInfo.dns2);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    private static String intToIp(int i) {
        return (i & 255) + com.baidu.ar.util.Constants.DOT + ((i >> 8) & 255) + com.baidu.ar.util.Constants.DOT + ((i >> 16) & 255) + com.baidu.ar.util.Constants.DOT + ((i >> 24) & 255);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [599=5] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static long Cj() {
        HttpURLConnection httpURLConnection;
        long j;
        if (aVg >= 3) {
            return aVh;
        }
        long currentTimeMillis = System.currentTimeMillis();
        HttpURLConnection httpURLConnection2 = null;
        try {
            httpURLConnection = (HttpURLConnection) new URL(TbDomainConfig.DOMAIN_HTTPS_BAIDU).openConnection();
        } catch (SocketTimeoutException e) {
            httpURLConnection = null;
        } catch (Exception e2) {
        } catch (Throwable th) {
            th = th;
        }
        try {
            httpURLConnection.setConnectTimeout(TbConfig.NOTIFY_YUN_PUSH);
            httpURLConnection.connect();
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            com.baidu.adp.lib.g.a.f(httpURLConnection);
            j = currentTimeMillis2;
        } catch (SocketTimeoutException e3) {
            com.baidu.adp.lib.g.a.f(httpURLConnection);
            j = 2500;
            if (j > 0) {
            }
        } catch (Exception e4) {
            httpURLConnection2 = httpURLConnection;
            com.baidu.adp.lib.g.a.f(httpURLConnection2);
            j = -1;
            if (j > 0) {
            }
        } catch (Throwable th2) {
            httpURLConnection2 = httpURLConnection;
            th = th2;
            com.baidu.adp.lib.g.a.f(httpURLConnection2);
            throw th;
        }
        if (j > 0) {
            if (aVg > -1) {
                aVh = ((aVh * aVg) + j) / (aVg + 1);
            } else {
                aVh = j;
            }
            aVg++;
            return j;
        }
        return j;
    }

    private static String Ck() {
        return com.baidu.tbadk.imageManager.c.Mx().lN();
    }

    private static String Cl() {
        return com.baidu.adp.lib.asyncTask.a.lO().lN();
    }

    public static void a(boolean z, boolean z2, String str, String str2) {
        com.baidu.adp.lib.stats.a nn = nn();
        nn.append(SocialConstants.PARAM_ACT, "getCDNList");
        nn.append("errorNum", str);
        nn.append("errorMsg", str2);
        nn.append("isShortNetError", z2 ? "1" : "0");
        nn.append("isSuccess", z ? "1" : "0");
        BdStatisticsManager.getInstance().debug("img", nn);
    }

    public static void a(boolean z, String str, String str2, String str3, String str4, String str5, long j, boolean z2) {
        String str6 = "";
        if (str != null) {
            str6 = t.Cq().ee(str);
        }
        String Ci = Ci();
        String ip = d.getIp();
        com.baidu.adp.lib.stats.a nn = nn();
        nn.append(SocialConstants.PARAM_ACT, "tachometerCDN");
        nn.append("errorNum", str3);
        nn.append("execption", str4);
        nn.append("size", str5);
        nn.append("isScuess", z ? "1" : "0");
        nn.append("url", str);
        nn.append("localIp", ip);
        nn.append("cdnIp", str6);
        nn.append("dnsIP", Ci);
        nn.append("usedIp", str2);
        nn.append("isUsedIp", z2 ? "0" : "1");
        nn.append("costTime", String.valueOf(j));
        BdStatisticsManager.getInstance().debug("img", nn);
    }

    public static void a(ArrayList<String> arrayList, long j) {
        if (arrayList != null) {
            StringBuilder sb = new StringBuilder();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < arrayList.size()) {
                    if (i2 != 0) {
                        sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    }
                    sb.append(arrayList.get(i2));
                    i = i2 + 1;
                } else {
                    com.baidu.adp.lib.stats.a nn = nn();
                    nn.append(SocialConstants.PARAM_ACT, "mobileTachometerCDN");
                    nn.append("costTime", String.valueOf(j));
                    nn.append("ipList", sb.toString());
                    BdStatisticsManager.getInstance().debug("img", nn);
                    return;
                }
            }
        }
    }

    public static void d(boolean z, String str) {
        com.baidu.adp.lib.stats.a nn = nn();
        nn.append(SocialConstants.PARAM_ACT, "getCDNList");
        nn.append("isSuccess", z ? "1" : "0");
        nn.append("errorMsg", str);
        BdStatisticsManager.getInstance().debug("img", nn);
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
