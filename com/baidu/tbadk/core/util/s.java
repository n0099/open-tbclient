package com.baidu.tbadk.core.util;

import android.net.DhcpInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.mobads.interfaces.utils.IXAdCommonUtils;
import com.baidu.mobads.interfaces.utils.IXAdSystemUtils;
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
    private static long bSb = 0;
    private static long bSc = 0;
    private static int bSd = 0;
    private static a bSe = new a();
    private static r bSf = new r();
    private static r bSg = new r();
    private static String bSh = null;
    private static Object syncLock = new Object();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        int bSi;
        boolean bSj;
        r bSk;
        r bSl;
        r bSm;
        r bSn;
        r bSo;
        r bSp;
        r bSq;
        r bSr;
        r bSs;
        r bSt;
        r bSu;
        r bSv;
        r bSw;
        r bSx;
        r bSy;

        private a() {
            this.bSi = 0;
            this.bSk = new r();
            this.bSl = new r();
            this.bSm = new r();
            this.bSn = new r();
            this.bSo = new r();
            this.bSp = new r();
            this.bSq = new r();
            this.bSr = new r();
            this.bSs = new r();
            this.bSt = new r();
            this.bSu = new r();
            this.bSv = new r();
            this.bSw = new r();
            this.bSx = new r();
            this.bSy = new r();
        }

        public int aix() {
            return this.bSk.num + this.bSl.num + this.bSm.num + this.bSn.num + this.bSo.num;
        }

        public int aiy() {
            return this.bSk.num + this.bSl.num + this.bSm.num + this.bSn.num + this.bSo.num + this.bSp.num + this.bSq.num + this.bSr.num + this.bSs.num + this.bSt.num + this.bSu.num + this.bSv.num + this.bSw.num + this.bSx.num + this.bSy.num;
        }

        public int aiz() {
            return this.bSp.num + this.bSq.num + this.bSr.num + this.bSs.num + this.bSt.num;
        }

        public int aiA() {
            return this.bSu.num + this.bSv.num + this.bSw.num + this.bSx.num + this.bSy.num;
        }

        public void reset() {
            this.bSi = 0;
            this.bSk.reset();
            this.bSl.reset();
            this.bSm.reset();
            this.bSn.reset();
            this.bSo.reset();
            this.bSp.reset();
            this.bSq.reset();
            this.bSr.reset();
            this.bSs.reset();
            this.bSt.reset();
            this.bSu.reset();
            this.bSv.reset();
            this.bSw.reset();
            this.bSx.reset();
            this.bSy.reset();
        }
    }

    private static r a(boolean z, boolean z2, String str, boolean z3) {
        if (z) {
            if (z2 && !z3) {
                return bSe.bSk;
            }
            if (str.startsWith("http://tb.himg")) {
                return bSe.bSl;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return bSe.bSm;
            }
            if (z2 && z3) {
                return bSe.bSo;
            }
            return bSe.bSn;
        } else if (com.baidu.adp.lib.util.j.kh()) {
            if (z2) {
                return bSe.bSp;
            }
            if (str.startsWith("http://tb.himg")) {
                return bSe.bSq;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return bSe.bSr;
            }
            return bSe.bSs;
        } else if (z2) {
            return bSe.bSu;
        } else {
            if (str.startsWith("http://tb.himg")) {
                return bSe.bSv;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return bSe.bSw;
            }
            return bSe.bSx;
        }
    }

    public static com.baidu.adp.lib.stats.a iF() {
        return BdStatisticsManager.getInstance().getStatsItem("dbg");
    }

    public static void a(com.baidu.adp.lib.stats.a aVar, String str, boolean z, long j, boolean z2) {
        if (z && z2) {
            synchronized (syncLock) {
                bSf.num++;
                bSf.time += j;
                if (bSf.num >= 100) {
                    aiq();
                }
            }
        }
    }

    public static void aiq() {
        if (bSf.num > 10) {
            com.baidu.adp.lib.stats.a iF = iF();
            iF.append(SocialConstants.PARAM_ACT, "locStat");
            iF.append("costTime", String.valueOf(bSf.time));
            iF.append("num", String.valueOf(bSf.num));
            iF.append("isWifi", "1");
            BdStatisticsManager.getInstance().debug(SocialConstants.PARAM_IMG_URL, iF);
            bSf.reset();
        }
    }

    public static void a(com.baidu.adp.lib.stats.a aVar, String str, boolean z, String str2, boolean z2, Boolean bool, com.baidu.adp.lib.network.http.d dVar, String str3, long j, boolean z3, long j2, int i) {
        boolean z4;
        String str4;
        String str5;
        if (com.baidu.adp.lib.util.l.kt() && dVar != null) {
            String str6 = "";
            boolean rp = com.baidu.tbadk.util.k.rp(str2);
            boolean z5 = false;
            if (com.baidu.tbadk.core.util.a.e.getInstance() != null) {
                z5 = true;
                if (!com.baidu.tbadk.core.util.a.e.getInstance().bVu) {
                    com.baidu.tbadk.core.util.a.e.getInstance().init();
                }
            }
            boolean kd = com.baidu.adp.lib.util.j.kd();
            if (!z5) {
                z4 = false;
            } else if (kd) {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().bDc);
            } else if (com.baidu.adp.lib.util.j.kh()) {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().bDe);
            } else {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().bDd);
            }
            boolean z6 = false;
            if (rp && z5) {
                z6 = com.baidu.tbadk.core.util.a.e.getInstance().isShouldCDNFallBack();
            }
            if (rp && kd && z6) {
                if (z) {
                    p.getInstance().insertNormalData(j, str);
                } else {
                    str6 = t.aiB().aiC();
                    if (!TextUtils.isEmpty(str6)) {
                        p.getInstance().insertErrorData(dVar.AA, str);
                    }
                }
            }
            if (rp) {
                bSh = str;
            }
            boolean z7 = false;
            if (dVar.AC != null && dVar.AC.length() > 0) {
                z7 = true;
            }
            synchronized (syncLock) {
                r a2 = a(kd, rp, str2, z7);
                boolean z8 = bSe.bSj;
                if (a2 != null) {
                    a2.num++;
                    if (z) {
                        a2.time += j;
                        a2.Au += j2;
                        bSe.bSj = true;
                        if (z4) {
                            a2.bSa++;
                        }
                        bSd = 0;
                    } else {
                        if (com.baidu.adp.lib.util.j.kc()) {
                            int i2 = bSd + 1;
                            bSd = i2;
                            if (i2 >= com.baidu.adp.lib.stats.switchs.a.jt().getMaxAlertCount("alert_img", 5)) {
                                BdStatisticsManager.getInstance().alert("alert_img", "imgFailedCnt_" + String.valueOf(bSd) + "_url=" + str2);
                            }
                        }
                        a2.bRZ++;
                        bSe.bSj = false;
                    }
                }
                int aiy = bSe.aiy();
                if (aiy > 100 || (aiy > 0 && z8 != bSe.bSj)) {
                    air();
                }
            }
            if (z && z5) {
                if (!kd || j >= com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().bDc) {
                    if (kd || !com.baidu.adp.lib.util.j.kh() || j >= com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().bDe) {
                        if (!kd && j < com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().bDd) {
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
                aVar = iF();
            }
            if (TextUtils.isEmpty(str6)) {
                str6 = t.aiB().aiC();
            }
            if (!rp || !TextUtils.isEmpty("")) {
                str4 = "";
            } else {
                str4 = t.aiB().nQ(str);
            }
            if (!TextUtils.isEmpty("")) {
                str5 = "";
            } else {
                str5 = ait();
            }
            aVar.append("url", str);
            aVar.append(SocialConstants.PARAM_ACT, IXAdCommonUtils.PKGS_PREF_DOWNLOAD_STATUS);
            aVar.append("result", z ? "1" : "0");
            aVar.append("fullurl", str2);
            aVar.append("netlib", String.valueOf(dVar.AG));
            aVar.append("costTime", String.valueOf(j));
            aVar.append("connTime", String.valueOf(dVar.connectTime));
            aVar.append("rspTime", String.valueOf(dVar.Av));
            aVar.append("retry", String.valueOf(dVar.Aw));
            aVar.append("localIp", d.getIp());
            aVar.append("tiebaIp", str6);
            aVar.append("cdnIp", str4);
            aVar.append("useIp", dVar.AC);
            aVar.append("dnsIp", str5);
            if (dVar.connectTime > 1500 || dVar.connectTime < 0) {
                aVar.append("connBaidu", String.valueOf(aiu()));
            }
            aVar.append("memory", aiv());
            aVar.append("task", aiw());
            aVar.append("status", String.valueOf(dVar.AB));
            aVar.append("up", String.valueOf(dVar.At));
            aVar.append("down", String.valueOf(dVar.Au));
            aVar.append("isCDN", rp ? "1" : "0");
            aVar.append("isWebp", bool.booleanValue() ? "1" : "0");
            aVar.append("isMobileProxy", z3 ? "1" : "0");
            aVar.append("exception", dVar.Az);
            aVar.append("reason", str3);
            if (i != 0) {
                aVar.c("procType", Integer.valueOf(i));
            }
            if (dVar.AE != null) {
                aVar.append("tracecode1", dVar.AE);
            }
            if (dVar.AF != null) {
                aVar.append("tracecode2", dVar.AF);
            }
            BdStatisticsManager.getInstance().debug(SocialConstants.PARAM_IMG_URL, aVar);
            if (rp && !TextUtils.isEmpty(str6) && TextUtils.isEmpty(str4) && !z) {
                bSe.bSi++;
            }
        }
    }

    public static void air() {
        if (bSe.aiy() > 10) {
            if (bSe.aix() > 0) {
                a(bSe.bSk, bSe.bSl, bSe.bSm, bSe.bSo, bSe.bSn, 10000);
                com.baidu.tbadk.p.k.b(bSe.bSk, bSe.bSl, bSe.bSm, bSe.bSo, bSe.bSn, 3);
            }
            if (bSe.aiA() > 0) {
                a(bSe.bSu, bSe.bSv, bSe.bSw, bSe.bSy, bSe.bSx, 100002);
                com.baidu.tbadk.p.k.b(bSe.bSu, bSe.bSv, bSe.bSw, bSe.bSy, bSe.bSx, 2);
            }
            if (bSe.aiz() > 0) {
                a(bSe.bSp, bSe.bSq, bSe.bSr, bSe.bSt, bSe.bSs, 100001);
                com.baidu.tbadk.p.k.b(bSe.bSp, bSe.bSq, bSe.bSr, bSe.bSt, bSe.bSs, 1);
            }
            bSe.reset();
        }
    }

    public static void a(r rVar, r rVar2, r rVar3, r rVar4, r rVar5, int i) {
        if (rVar != null && rVar2 != null && rVar3 != null && rVar4 != null && rVar5 != null) {
            String str = "";
            String str2 = "";
            String str3 = "";
            if (TextUtils.isEmpty("")) {
                str = t.aiB().aiC();
            }
            if (bSh != null && TextUtils.isEmpty("")) {
                str2 = t.aiB().nQ(bSh);
            }
            if (TextUtils.isEmpty("")) {
                str3 = ait();
            }
            com.baidu.adp.lib.stats.a iF = iF();
            iF.append(SocialConstants.PARAM_ACT, "dlStat");
            iF.append("cdnCostTime", String.valueOf(rVar.time));
            iF.append("cdnNum", String.valueOf(rVar.num));
            iF.append("cdnFailnum", String.valueOf(rVar.bRZ));
            iF.append("portraitCostTime", String.valueOf(rVar2.time));
            iF.append("portraitNum", String.valueOf(rVar2.num));
            iF.append("portraitFailnum", String.valueOf(rVar2.bRZ));
            iF.append("tiebaCostTime", String.valueOf(rVar3.time));
            iF.append("tiebaNum", String.valueOf(rVar3.num));
            iF.append("tiebaFailnum", String.valueOf(rVar3.bRZ));
            iF.append("otherCostTime", String.valueOf(rVar5.time));
            iF.append("otherNum", String.valueOf(rVar5.num));
            iF.append("otherFailnum", String.valueOf(rVar5.bRZ));
            iF.append("directIpCostTime", String.valueOf(rVar4.time));
            iF.append("directIpNum", String.valueOf(rVar4.num));
            iF.append("directIpFailnum", String.valueOf(rVar4.bRZ));
            iF.append("dnsFailNum", String.valueOf(bSe.bSi));
            if (10000 == i) {
                iF.append("isWifi", "1");
                iF.append("netType", "WIFI");
            } else if (100002 == i) {
                iF.append("netType", "3G");
                iF.append("isWifi", "0");
            } else {
                iF.append("netType", "2G");
                iF.append("isWifi", "0");
            }
            iF.append("localIp", d.getIp());
            iF.append("tbIp", str);
            iF.append("cdnIp", str2);
            iF.append("dnsIp", str3);
            BdStatisticsManager.getInstance().debug(SocialConstants.PARAM_IMG_URL, iF);
        }
    }

    public static void a(com.baidu.adp.lib.stats.a aVar, String str, String str2, boolean z, boolean z2, boolean z3, int i, String str3, long j, String str4) {
        if (com.baidu.adp.lib.util.l.kt()) {
            synchronized (syncLock) {
                bSg.num++;
                if (z) {
                    bSg.time += j;
                } else {
                    bSg.bRZ++;
                }
                if (bSg.num >= 100) {
                    ais();
                }
            }
            if (!z) {
                if (aVar == null) {
                    aVar = iF();
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
                BdStatisticsManager.getInstance().debug(SocialConstants.PARAM_IMG_URL, aVar);
            }
        }
    }

    public static void n(String str, String str2, String str3, String str4) {
        com.baidu.adp.lib.stats.a iF = iF();
        iF.append(SocialConstants.PARAM_ACT, "ml");
        iF.append("fullURL", str2);
        iF.append("type", str);
        iF.append("reason", str3);
        iF.append("extra", str4);
        BdStatisticsManager.getInstance().debug(SocialConstants.PARAM_IMG_URL, iF);
    }

    public static void ais() {
        if (bSg.num > 10) {
            com.baidu.adp.lib.stats.a iF = iF();
            iF.append(SocialConstants.PARAM_ACT, "dcStat");
            iF.append("costTime", String.valueOf(bSg.time));
            iF.append("num", String.valueOf(bSg.num));
            iF.append("failnum", String.valueOf(bSg.bRZ));
            BdStatisticsManager.getInstance().debug(SocialConstants.PARAM_IMG_URL, iF);
            com.baidu.tbadk.p.k.b(bSg.num, bSg.bRZ, bSg.time);
            bSg.reset();
        }
    }

    public static void nP(String str) {
        com.baidu.adp.lib.stats.a iF = iF();
        iF.append(SocialConstants.PARAM_ACT, "assistant");
        iF.append("content", str);
        BdStatisticsManager.getInstance().debug(SocialConstants.PARAM_IMG_URL, iF);
    }

    private static String ait() {
        try {
            DhcpInfo dhcpInfo = ((WifiManager) BdBaseApplication.getInst().getApp().getSystemService(IXAdSystemUtils.NT_WIFI)).getDhcpInfo();
            return intToIp(dhcpInfo.dns1) + Constants.ACCEPT_TIME_SEPARATOR_SP + intToIp(dhcpInfo.dns2);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    private static String intToIp(int i) {
        return (i & 255) + "." + ((i >> 8) & 255) + "." + ((i >> 16) & 255) + "." + ((i >> 24) & 255);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [609=5] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static long aiu() {
        HttpURLConnection httpURLConnection;
        long j;
        if (bSb >= 3) {
            return bSc;
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
            if (bSb > -1) {
                bSc = ((bSc * bSb) + j) / (bSb + 1);
            } else {
                bSc = j;
            }
            bSb++;
            return j;
        }
        return j;
    }

    private static String aiv() {
        return com.baidu.tbadk.imageManager.c.atK().hd();
    }

    private static String aiw() {
        return com.baidu.adp.lib.asyncTask.a.he().hd();
    }

    public static void a(boolean z, boolean z2, String str, String str2) {
        com.baidu.adp.lib.stats.a iF = iF();
        iF.append(SocialConstants.PARAM_ACT, "getCDNList");
        iF.append("errorNum", str);
        iF.append("errorMsg", str2);
        iF.append("isShortNetError", z2 ? "1" : "0");
        iF.append("isSuccess", z ? "1" : "0");
        BdStatisticsManager.getInstance().debug(SocialConstants.PARAM_IMG_URL, iF);
    }

    public static void a(boolean z, String str, String str2, String str3, String str4, String str5, long j, boolean z2) {
        String str6 = "";
        if (str != null) {
            str6 = t.aiB().nQ(str);
        }
        String ait = ait();
        String ip = d.getIp();
        com.baidu.adp.lib.stats.a iF = iF();
        iF.append(SocialConstants.PARAM_ACT, "tachometerCDN");
        iF.append("errorNum", str3);
        iF.append("execption", str4);
        iF.append("size", str5);
        iF.append("isScuess", z ? "1" : "0");
        iF.append("url", str);
        iF.append("localIp", ip);
        iF.append("cdnIp", str6);
        iF.append("dnsIP", ait);
        iF.append("usedIp", str2);
        iF.append("isUsedIp", z2 ? "0" : "1");
        iF.append("costTime", String.valueOf(j));
        BdStatisticsManager.getInstance().debug(SocialConstants.PARAM_IMG_URL, iF);
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
                    com.baidu.adp.lib.stats.a iF = iF();
                    iF.append(SocialConstants.PARAM_ACT, "mobileTachometerCDN");
                    iF.append("costTime", String.valueOf(j));
                    iF.append("ipList", sb.toString());
                    BdStatisticsManager.getInstance().debug(SocialConstants.PARAM_IMG_URL, iF);
                    return;
                }
            }
        }
    }

    public static void g(boolean z, String str) {
        com.baidu.adp.lib.stats.a iF = iF();
        iF.append(SocialConstants.PARAM_ACT, "getCDNList");
        iF.append("isSuccess", z ? "1" : "0");
        iF.append("errorMsg", str);
        BdStatisticsManager.getInstance().debug(SocialConstants.PARAM_IMG_URL, iF);
    }

    public static void d(com.baidu.adp.lib.stats.a aVar) {
        aVar.append(SocialConstants.PARAM_ACT, "tiebaPic");
        BdStatisticsManager.getInstance().debug(SocialConstants.PARAM_IMG_URL, aVar);
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
