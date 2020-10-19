package com.baidu.tbadk.core.util;

import android.net.DhcpInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.mobads.interfaces.utils.IXAdCommonUtils;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.switchs.UseHttpdnsSdkSwitch;
import com.xiaomi.mipush.sdk.Constants;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class u {
    private static long exI = 0;
    private static long exJ = 0;
    private static int exK = 0;
    private static a exL = new a();
    private static t exM = new t();
    private static t exN = new t();
    private static String exO = null;
    private static Object Nl = new Object();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        int exP;
        boolean exQ;
        t exR;
        t exS;
        t exT;
        t exU;
        t exV;
        t exW;
        t exX;
        t exY;
        t exZ;
        t eya;
        t eyb;
        t eyc;
        t eyd;
        t eyf;
        t eyg;

        private a() {
            this.exP = 0;
            this.exR = new t();
            this.exS = new t();
            this.exT = new t();
            this.exU = new t();
            this.exV = new t();
            this.exW = new t();
            this.exX = new t();
            this.exY = new t();
            this.exZ = new t();
            this.eya = new t();
            this.eyb = new t();
            this.eyc = new t();
            this.eyd = new t();
            this.eyf = new t();
            this.eyg = new t();
        }

        public int bml() {
            return this.exR.num + this.exS.num + this.exT.num + this.exU.num + this.exV.num;
        }

        public int bmm() {
            return this.exR.num + this.exS.num + this.exT.num + this.exU.num + this.exV.num + this.exW.num + this.exX.num + this.exY.num + this.exZ.num + this.eya.num + this.eyb.num + this.eyc.num + this.eyd.num + this.eyf.num + this.eyg.num;
        }

        public int bmn() {
            return this.exW.num + this.exX.num + this.exY.num + this.exZ.num + this.eya.num;
        }

        public int bmo() {
            return this.eyb.num + this.eyc.num + this.eyd.num + this.eyf.num + this.eyg.num;
        }

        public void reset() {
            this.exP = 0;
            this.exR.reset();
            this.exS.reset();
            this.exT.reset();
            this.exU.reset();
            this.exV.reset();
            this.exW.reset();
            this.exX.reset();
            this.exY.reset();
            this.exZ.reset();
            this.eya.reset();
            this.eyb.reset();
            this.eyc.reset();
            this.eyd.reset();
            this.eyf.reset();
            this.eyg.reset();
        }
    }

    private static t a(boolean z, boolean z2, String str, boolean z3) {
        if (z) {
            if (z2 && !z3) {
                return exL.exR;
            }
            if (str.startsWith("http://tb.himg")) {
                return exL.exS;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return exL.exT;
            }
            if (z2 && z3) {
                return exL.exV;
            }
            return exL.exU;
        } else if (com.baidu.adp.lib.util.j.is2GNet()) {
            if (z2) {
                return exL.exW;
            }
            if (str.startsWith("http://tb.himg")) {
                return exL.exX;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return exL.exY;
            }
            return exL.exZ;
        } else if (z2) {
            return exL.eyb;
        } else {
            if (str.startsWith("http://tb.himg")) {
                return exL.eyc;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return exL.eyd;
            }
            return exL.eyf;
        }
    }

    public static com.baidu.adp.lib.stats.a mT() {
        return BdStatisticsManager.getInstance().getStatsItem("dbg");
    }

    public static void a(com.baidu.adp.lib.stats.a aVar, String str, boolean z, long j, boolean z2) {
        if (z && z2) {
            synchronized (Nl) {
                exM.num++;
                exM.time += j;
                if (exM.num >= 100) {
                    bme();
                }
            }
        }
    }

    public static void bme() {
        if (exM.num > 10) {
            com.baidu.adp.lib.stats.a mT = mT();
            mT.append("act", "locStat");
            mT.append(TiebaInitialize.LogFields.COST_TIME, String.valueOf(exM.time));
            mT.append("num", String.valueOf(exM.num));
            mT.append("isWifi", "1");
            BdStatisticsManager.getInstance().debug("img", mT);
            exM.reset();
        }
    }

    public static void a(com.baidu.adp.lib.stats.a aVar, String str, boolean z, String str2, boolean z2, Boolean bool, com.baidu.adp.lib.network.http.d dVar, String str3, long j, boolean z3, long j2, int i) {
        boolean z4;
        String str4;
        String str5;
        if (com.baidu.adp.lib.util.l.isNetOk() && dVar != null) {
            String str6 = "";
            boolean isCdn = com.baidu.tbadk.util.n.isCdn(str2);
            boolean z5 = false;
            if (com.baidu.tbadk.core.util.a.e.getInstance() != null) {
                z5 = true;
                if (!com.baidu.tbadk.core.util.a.e.getInstance().eAg) {
                    com.baidu.tbadk.core.util.a.e.getInstance().init();
                }
            }
            boolean isWifiNet = com.baidu.adp.lib.util.j.isWifiNet();
            if (!z5) {
                z4 = false;
            } else if (isWifiNet) {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().eiA);
            } else if (com.baidu.adp.lib.util.j.is2GNet()) {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().eiC);
            } else {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().eiB);
            }
            boolean z6 = false;
            if (isCdn && z5) {
                z6 = com.baidu.tbadk.core.util.a.e.getInstance().isShouldCDNFallBack();
            }
            if (isCdn && isWifiNet && z6) {
                if (z) {
                    r.getInstance().insertNormalData(j, str);
                } else {
                    str6 = v.bmp().bmq();
                    if (!TextUtils.isEmpty(str6)) {
                        r.getInstance().insertErrorData(dVar.LK, str);
                    }
                }
            }
            if (isCdn) {
                exO = str;
            }
            boolean z7 = false;
            if (dVar.LN != null && dVar.LN.length() > 0) {
                z7 = true;
            }
            synchronized (Nl) {
                t a2 = a(isWifiNet, isCdn, str2, z7);
                boolean z8 = exL.exQ;
                if (a2 != null) {
                    a2.num++;
                    if (z) {
                        a2.time += j;
                        a2.downloadSize += j2;
                        exL.exQ = true;
                        if (z4) {
                            a2.slownum++;
                        }
                        exK = 0;
                    } else {
                        if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                            int i2 = exK + 1;
                            exK = i2;
                            if (i2 >= com.baidu.adp.lib.stats.switchs.a.nS().getMaxAlertCount(BdStatsConstant.AlertTypeKey.ALERT_IMG, 5)) {
                                BdStatisticsManager.getInstance().alert(BdStatsConstant.AlertTypeKey.ALERT_IMG, "imgFailedCnt_" + String.valueOf(exK) + "_url=" + str2);
                            }
                        }
                        a2.failnum++;
                        exL.exQ = false;
                    }
                }
                int bmm = exL.bmm();
                if (bmm > 100 || (bmm > 0 && z8 != exL.exQ)) {
                    bmf();
                }
            }
            if (z && z5) {
                if (!isWifiNet || j >= com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().eiA) {
                    if (isWifiNet || !com.baidu.adp.lib.util.j.is2GNet() || j >= com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().eiC) {
                        if (!isWifiNet && j < com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().eiB) {
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
                aVar = mT();
            }
            if (TextUtils.isEmpty(str6)) {
                str6 = v.bmp().bmq();
            }
            if (!isCdn || !TextUtils.isEmpty("")) {
                str4 = "";
            } else {
                str4 = v.bmp().Bh(str);
            }
            if (!TextUtils.isEmpty("")) {
                str5 = "";
            } else {
                str5 = bmh();
            }
            aVar.append("url", str);
            aVar.append("act", IXAdCommonUtils.PKGS_PREF_DOWNLOAD_STATUS);
            aVar.append("result", z ? "1" : "0");
            aVar.append("requrl", str2);
            aVar.append("netlib", dVar.LX == 0 ? "Apache" : "HttpManager");
            aVar.append(TiebaInitialize.LogFields.COST_TIME, String.valueOf(j));
            aVar.append("connTime", String.valueOf(dVar.connectTime));
            aVar.append("rspTime", String.valueOf(dVar.LI));
            aVar.append("retry", String.valueOf(dVar.retry));
            aVar.append("clientIp", d.getIp());
            aVar.append("tiebaIp", str6);
            String Bg = v.bmp().Bg(str);
            if (!TextUtils.isEmpty(Bg)) {
                aVar.append("domainIp", Bg);
            }
            aVar.append("wifiDnsIp", str5);
            if (dVar.connectTime > 1500 || dVar.connectTime < 0) {
                aVar.append("connBaidu", String.valueOf(bmi()));
            }
            aVar.append("memory", bmj());
            aVar.append("task", bmk());
            aVar.append("status", String.valueOf(dVar.LM));
            aVar.append(MapBundleKey.OfflineMapKey.OFFLINE_UPDATE, String.valueOf(dVar.LH));
            aVar.append("down", String.valueOf(dVar.downloadSize));
            aVar.append("isCDN", isCdn ? "1" : "0");
            aVar.append("isWebp", bool.booleanValue() ? "1" : "0");
            aVar.append("isMobileProxy", z3 ? "1" : "0");
            aVar.append("exception", dVar.exception);
            aVar.append(TiebaInitialize.LogFields.REASON, str3);
            if (i != 0) {
                aVar.append("procType", Integer.valueOf(i));
            }
            if (dVar.LV != null) {
                aVar.append("tracecode1", dVar.LV);
            }
            if (dVar.LW != null) {
                aVar.append("tracecode2", dVar.LW);
            }
            if (!at.isEmpty(dVar.LN)) {
                aVar.append("httpDnsIp", dVar.LN);
            } else {
                aVar.append("httpDnsIp", dVar.LO);
            }
            aVar.append("ipIndex", Integer.valueOf(dVar.LU));
            aVar.append("dnsSwitch1", Boolean.valueOf(com.baidu.adp.lib.network.http.c.Lv));
            aVar.append("dnsSwitch2", Boolean.valueOf(UseHttpdnsSdkSwitch.isOn()));
            aVar.append("httpDnsIpList", dVar.LS);
            aVar.append("dnsResolveType", dVar.LQ);
            aVar.append("dnsResolveStatus", dVar.LR);
            aVar.append("isUseIpDirectConnect", Boolean.valueOf(dVar.Lt));
            aVar.append("redirectUrl", dVar.redirectUrl);
            BdStatisticsManager.getInstance().debug("img", aVar);
            if (isCdn && !TextUtils.isEmpty(str6) && TextUtils.isEmpty(str4) && !z) {
                exL.exP++;
            }
        }
    }

    public static void bmf() {
        if (exL.bmm() > 10) {
            if (exL.bml() > 0) {
                a(exL.exR, exL.exS, exL.exT, exL.exV, exL.exU, 10000);
                com.baidu.tbadk.n.k.b(exL.exR, exL.exS, exL.exT, exL.exV, exL.exU, 3);
            }
            if (exL.bmo() > 0) {
                a(exL.eyb, exL.eyc, exL.eyd, exL.eyg, exL.eyf, 100002);
                com.baidu.tbadk.n.k.b(exL.eyb, exL.eyc, exL.eyd, exL.eyg, exL.eyf, 2);
            }
            if (exL.bmn() > 0) {
                a(exL.exW, exL.exX, exL.exY, exL.eya, exL.exZ, 100001);
                com.baidu.tbadk.n.k.b(exL.exW, exL.exX, exL.exY, exL.eya, exL.exZ, 1);
            }
            exL.reset();
        }
    }

    public static void a(t tVar, t tVar2, t tVar3, t tVar4, t tVar5, int i) {
        if (tVar != null && tVar2 != null && tVar3 != null && tVar4 != null && tVar5 != null) {
            String str = "";
            String str2 = "";
            String str3 = "";
            if (TextUtils.isEmpty("")) {
                str = v.bmp().bmq();
            }
            if (exO != null && TextUtils.isEmpty("")) {
                str2 = v.bmp().Bh(exO);
            }
            if (TextUtils.isEmpty("")) {
                str3 = bmh();
            }
            com.baidu.adp.lib.stats.a mT = mT();
            mT.append("act", "dlStat");
            mT.append("cdnCostTime", String.valueOf(tVar.time));
            mT.append("cdnNum", String.valueOf(tVar.num));
            mT.append("cdnFailnum", String.valueOf(tVar.failnum));
            mT.append("portraitCostTime", String.valueOf(tVar2.time));
            mT.append("portraitNum", String.valueOf(tVar2.num));
            mT.append("portraitFailnum", String.valueOf(tVar2.failnum));
            mT.append("tiebaCostTime", String.valueOf(tVar3.time));
            mT.append("tiebaNum", String.valueOf(tVar3.num));
            mT.append("tiebaFailnum", String.valueOf(tVar3.failnum));
            mT.append("otherCostTime", String.valueOf(tVar5.time));
            mT.append("otherNum", String.valueOf(tVar5.num));
            mT.append("otherFailnum", String.valueOf(tVar5.failnum));
            mT.append("directIpCostTime", String.valueOf(tVar4.time));
            mT.append("directIpNum", String.valueOf(tVar4.num));
            mT.append("directIpFailnum", String.valueOf(tVar4.failnum));
            mT.append("dnsFailNum", String.valueOf(exL.exP));
            if (10000 == i) {
                mT.append("isWifi", "1");
                mT.append("netType", "WIFI");
            } else if (100002 == i) {
                mT.append("netType", "3G");
                mT.append("isWifi", "0");
            } else {
                mT.append("netType", "2G");
                mT.append("isWifi", "0");
            }
            mT.append("localIp", d.getIp());
            mT.append("tbIp", str);
            mT.append("cdnIp", str2);
            mT.append("dnsIp", str3);
            BdStatisticsManager.getInstance().debug("img", mT);
        }
    }

    public static void a(com.baidu.adp.lib.stats.a aVar, String str, String str2, boolean z, boolean z2, boolean z3, int i, String str3, long j, String str4, com.baidu.adp.lib.network.http.d dVar) {
        if (com.baidu.adp.lib.util.l.isNetOk()) {
            synchronized (Nl) {
                exN.num++;
                if (z) {
                    exN.time += j;
                } else {
                    exN.failnum++;
                }
                if (exN.num >= 100) {
                    bmg();
                }
            }
            if (!z) {
                if (aVar == null) {
                    aVar = mT();
                }
                aVar.append("act", "dc");
                aVar.append(TiebaInitialize.LogFields.COST_TIME, String.valueOf(j));
                aVar.append("url", str);
                aVar.append("fullURL", str2);
                aVar.append("isWebp", z3 ? "1" : "0");
                aVar.append("isCDN", z2 ? "1" : "0");
                aVar.append("length", String.valueOf(i));
                aVar.append(TiebaInitialize.LogFields.REASON, str3);
                aVar.append("result", z ? "0" : "1");
                aVar.append("execption", str4);
                if (dVar != null) {
                    aVar.append("httpDnsIp", dVar.LO);
                    aVar.append("ipIndex", Integer.valueOf(dVar.LU));
                    aVar.append("httpDnsIpList", dVar.LS);
                    aVar.append("dnsResolveType", dVar.LQ);
                    aVar.append("dnsSwitch1", Boolean.valueOf(com.baidu.adp.lib.network.http.c.Lv));
                    aVar.append("dnsSwitch2", Boolean.valueOf(UseHttpdnsSdkSwitch.isOn()));
                    aVar.append("dnsResolveStatus", dVar.LR);
                    aVar.append("isUseIpDirectConnect", Boolean.valueOf(dVar.Lt));
                }
                BdStatisticsManager.getInstance().debug("img", aVar);
            }
        }
    }

    public static void u(String str, String str2, String str3, String str4) {
        com.baidu.adp.lib.stats.a mT = mT();
        mT.append("act", "ml");
        mT.append("fullURL", str2);
        mT.append("type", str);
        mT.append(TiebaInitialize.LogFields.REASON, str3);
        mT.append("extra", str4);
        BdStatisticsManager.getInstance().debug("img", mT);
    }

    public static void bmg() {
        if (exN.num > 10) {
            com.baidu.adp.lib.stats.a mT = mT();
            mT.append("act", "dcStat");
            mT.append(TiebaInitialize.LogFields.COST_TIME, String.valueOf(exN.time));
            mT.append("num", String.valueOf(exN.num));
            mT.append("failnum", String.valueOf(exN.failnum));
            BdStatisticsManager.getInstance().debug("img", mT);
            com.baidu.tbadk.n.k.b(exN.num, exN.failnum, exN.time);
            exN.reset();
        }
    }

    public static void Bf(String str) {
        com.baidu.adp.lib.stats.a mT = mT();
        mT.append("act", "assistant");
        mT.append("content", str);
        BdStatisticsManager.getInstance().debug("img", mT);
    }

    private static String bmh() {
        try {
            if (ae.bmC()) {
                DhcpInfo dhcpInfo = ((WifiManager) BdBaseApplication.getInst().getApplicationContext().getSystemService("wifi")).getDhcpInfo();
                return intToIp(dhcpInfo.dns1) + Constants.ACCEPT_TIME_SEPARATOR_SP + intToIp(dhcpInfo.dns2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    private static String intToIp(int i) {
        return (i & 255) + "." + ((i >> 8) & 255) + "." + ((i >> 16) & 255) + "." + ((i >> 24) & 255);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [638=5] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static long bmi() {
        HttpURLConnection httpURLConnection;
        long j;
        if (exI >= 3) {
            return exJ;
        }
        long currentTimeMillis = System.currentTimeMillis();
        HttpURLConnection httpURLConnection2 = null;
        try {
            httpURLConnection = (HttpURLConnection) new URL("http://www.baidu.com/").openConnection();
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
            com.baidu.adp.lib.f.a.close(httpURLConnection);
            j = currentTimeMillis2;
        } catch (SocketTimeoutException e3) {
            com.baidu.adp.lib.f.a.close(httpURLConnection);
            j = 2500;
            if (j > 0) {
            }
        } catch (Exception e4) {
            httpURLConnection2 = httpURLConnection;
            com.baidu.adp.lib.f.a.close(httpURLConnection2);
            j = -1;
            if (j > 0) {
            }
        } catch (Throwable th2) {
            httpURLConnection2 = httpURLConnection;
            th = th2;
            com.baidu.adp.lib.f.a.close(httpURLConnection2);
            throw th;
        }
        if (j > 0) {
            if (exI > -1) {
                exJ = ((exJ * exI) + j) / (exI + 1);
            } else {
                exJ = j;
            }
            exI++;
            return j;
        }
        return j;
    }

    private static String bmj() {
        return com.baidu.tbadk.imageManager.c.bwL().toLogString();
    }

    private static String bmk() {
        return com.baidu.adp.lib.asyncTask.a.lR().toLogString();
    }

    public static void a(boolean z, boolean z2, String str, String str2) {
        com.baidu.adp.lib.stats.a mT = mT();
        mT.append("act", "getCDNList");
        mT.append("errorNum", str);
        mT.append(TiebaInitialize.LogFields.ERROR_MESSAGE, str2);
        mT.append("isShortNetError", z2 ? "1" : "0");
        mT.append("isSuccess", z ? "1" : "0");
        BdStatisticsManager.getInstance().debug("img", mT);
    }

    public static void a(boolean z, String str, String str2, String str3, String str4, String str5, long j, boolean z2) {
        String str6 = "";
        if (str != null) {
            str6 = v.bmp().Bh(str);
        }
        String bmh = bmh();
        String ip = d.getIp();
        com.baidu.adp.lib.stats.a mT = mT();
        mT.append("act", "tachometerCDN");
        mT.append("errorNum", str3);
        mT.append("execption", str4);
        mT.append("size", str5);
        mT.append("isScuess", z ? "1" : "0");
        mT.append("url", str);
        mT.append("localIp", ip);
        mT.append("cdnIp", str6);
        mT.append("dnsIP", bmh);
        mT.append("usedIp", str2);
        mT.append("isUsedIp", z2 ? "0" : "1");
        mT.append(TiebaInitialize.LogFields.COST_TIME, String.valueOf(j));
        BdStatisticsManager.getInstance().debug("img", mT);
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
                    com.baidu.adp.lib.stats.a mT = mT();
                    mT.append("act", "mobileTachometerCDN");
                    mT.append(TiebaInitialize.LogFields.COST_TIME, String.valueOf(j));
                    mT.append("ipList", sb.toString());
                    BdStatisticsManager.getInstance().debug("img", mT);
                    return;
                }
            }
        }
    }

    public static void m(boolean z, String str) {
        com.baidu.adp.lib.stats.a mT = mT();
        mT.append("act", "getCDNList");
        mT.append("isSuccess", z ? "1" : "0");
        mT.append(TiebaInitialize.LogFields.ERROR_MESSAGE, str);
        BdStatisticsManager.getInstance().debug("img", mT);
    }

    public static void e(com.baidu.adp.lib.stats.a aVar) {
        aVar.append("act", "tiebaPic");
        BdStatisticsManager.getInstance().debug("img", aVar);
    }

    public static void b(String str, int i, int i2, int i3) {
        if (i == -1) {
            i = 0;
        }
        if (i2 == -1) {
            i2 = 0;
        }
        BdStatisticsManager.getInstance().eventStat(null, str, "imgHttpSwitch", 1, "1sterrcode", String.valueOf(i), "2nderrcode", String.valueOf(i2), "2imgFailed", String.valueOf(i3));
    }
}
