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
public class v {
    private static long ZK = 0;
    private static long ZL = 0;
    private static int ZM = 0;
    private static a ZN = new a(null);
    private static u ZO = new u();
    private static u ZP = new u();
    private static String ZQ = null;
    private static Object pt = new Object();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        int ZR;
        boolean ZS;
        u ZT;
        u ZU;
        u ZV;
        u ZW;
        u ZX;
        u ZY;
        u ZZ;
        u aaa;
        u aab;
        u aac;
        u aad;
        u aae;
        u aaf;
        u aag;
        u aah;

        private a() {
            this.ZR = 0;
            this.ZT = new u();
            this.ZU = new u();
            this.ZV = new u();
            this.ZW = new u();
            this.ZX = new u();
            this.ZY = new u();
            this.ZZ = new u();
            this.aaa = new u();
            this.aab = new u();
            this.aac = new u();
            this.aad = new u();
            this.aae = new u();
            this.aaf = new u();
            this.aag = new u();
            this.aah = new u();
        }

        /* synthetic */ a(a aVar) {
            this();
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [74=4] */
        public int uF() {
            return this.ZT.num + this.ZU.num + this.ZV.num + this.ZW.num + this.ZX.num;
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [80=14] */
        public int uG() {
            return this.ZT.num + this.ZU.num + this.ZV.num + this.ZW.num + this.ZX.num + this.ZY.num + this.ZZ.num + this.aaa.num + this.aab.num + this.aac.num + this.aad.num + this.aae.num + this.aaf.num + this.aag.num + this.aah.num;
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [91=4] */
        public int uH() {
            return this.ZY.num + this.ZZ.num + this.aaa.num + this.aab.num + this.aac.num;
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [97=4] */
        public int uI() {
            return this.aad.num + this.aae.num + this.aaf.num + this.aag.num + this.aah.num;
        }

        public void reset() {
            this.ZR = 0;
            this.ZT.reset();
            this.ZU.reset();
            this.ZV.reset();
            this.ZW.reset();
            this.ZX.reset();
            this.ZY.reset();
            this.ZZ.reset();
            this.aaa.reset();
            this.aab.reset();
            this.aac.reset();
            this.aad.reset();
            this.aae.reset();
            this.aaf.reset();
            this.aag.reset();
            this.aah.reset();
        }
    }

    private static u a(boolean z, boolean z2, String str, boolean z3) {
        if (z) {
            if (z2 && !z3) {
                return ZN.ZT;
            }
            if (str.startsWith("http://tb.himg")) {
                return ZN.ZU;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return ZN.ZV;
            }
            if (z2 && z3) {
                return ZN.ZX;
            }
            return ZN.ZW;
        } else if (com.baidu.adp.lib.util.i.gr()) {
            if (z2) {
                return ZN.ZY;
            }
            if (str.startsWith("http://tb.himg")) {
                return ZN.ZZ;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return ZN.aaa;
            }
            return ZN.aab;
        } else if (z2) {
            return ZN.aad;
        } else {
            if (str.startsWith("http://tb.himg")) {
                return ZN.aae;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return ZN.aaf;
            }
            return ZN.aag;
        }
    }

    public static com.baidu.adp.lib.stats.d eB() {
        return com.baidu.adp.lib.stats.a.eI().ao("dbg");
    }

    public static void a(com.baidu.adp.lib.stats.d dVar, String str, boolean z, long j, boolean z2) {
        if (z && z2) {
            synchronized (pt) {
                ZO.num++;
                ZO.time += j;
                if (ZO.num >= 100) {
                    uy();
                }
            }
        }
    }

    public static void uy() {
        if (ZO.num > 10) {
            com.baidu.adp.lib.stats.d eB = eB();
            eB.q("act", "locStat");
            eB.q("costTime", String.valueOf(ZO.time));
            eB.q("num", String.valueOf(ZO.num));
            eB.q("isWifi", "1");
            com.baidu.adp.lib.stats.a.eI().b("img", eB);
            ZO.reset();
        }
    }

    public static void a(com.baidu.adp.lib.stats.d dVar, String str, boolean z, String str2, boolean z2, Boolean bool, com.baidu.adp.lib.network.http.e eVar, String str3, long j, boolean z3, long j2, int i) {
        boolean z4;
        String str4;
        String str5;
        if (com.baidu.adp.lib.util.k.gD() && eVar != null) {
            String str6 = "";
            boolean gs = com.baidu.tbadk.util.h.gs(str2);
            boolean z5 = false;
            if (com.baidu.tbadk.core.util.a.e.getInstance() != null) {
                z5 = true;
                if (!com.baidu.tbadk.core.util.a.e.getInstance().acG) {
                    com.baidu.tbadk.core.util.a.e.getInstance().init();
                }
            }
            boolean gn = com.baidu.adp.lib.util.i.gn();
            if (!z5) {
                z4 = false;
            } else if (gn) {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().Ng);
            } else if (com.baidu.adp.lib.util.i.gr()) {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().Ni);
            } else {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().Nh);
            }
            boolean z6 = false;
            if (gs && z5) {
                z6 = com.baidu.tbadk.core.util.a.e.getInstance().isShouldCDNFallBack();
            }
            if (gs && gn && z6) {
                if (z) {
                    r.getInstance().insertNormalData(j, str);
                } else {
                    str6 = w.uJ().uK();
                    if (!TextUtils.isEmpty(str6)) {
                        r.getInstance().insertErrorData(eVar.ol, str);
                    }
                }
            }
            if (gs) {
                ZQ = str;
            }
            boolean z7 = false;
            if (eVar.oo != null && eVar.oo.length() > 0) {
                z7 = true;
            }
            synchronized (pt) {
                u a2 = a(gn, gs, str2, z7);
                boolean z8 = ZN.ZS;
                if (a2 != null) {
                    a2.num++;
                    if (z) {
                        a2.time += j;
                        a2.od += j2;
                        ZN.ZS = true;
                        if (z4) {
                            a2.ZJ++;
                        }
                        ZM = 0;
                    } else {
                        if (com.baidu.adp.lib.util.i.gm()) {
                            int i2 = ZM + 1;
                            ZM = i2;
                            if (i2 >= com.baidu.adp.lib.stats.switchs.a.fD().getMaxAlertCount("alert_img", 5)) {
                                com.baidu.adp.lib.stats.a.eI().p("alert_img", "imgFailedCnt_" + String.valueOf(ZM) + "_url=" + str2);
                            }
                        }
                        a2.ZI++;
                        ZN.ZS = false;
                    }
                }
                int uG = ZN.uG();
                if (uG > 100 || (uG > 0 && z8 != ZN.ZS)) {
                    uz();
                }
            }
            if (z && z5) {
                if (!gn || j >= com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().Ng) {
                    if (gn || !com.baidu.adp.lib.util.i.gr() || j >= com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().Ni) {
                        if (!gn && j < com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().Nh) {
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
                str6 = w.uJ().uK();
            }
            if (!gs || !TextUtils.isEmpty("")) {
                str4 = "";
            } else {
                str4 = w.uJ().m11do(str);
            }
            if (!TextUtils.isEmpty("")) {
                str5 = "";
            } else {
                str5 = uB();
            }
            dVar.q("url", str);
            dVar.q("act", "dl");
            dVar.q("result", z ? "1" : "0");
            dVar.q("fullurl", str2);
            dVar.q("netlib", String.valueOf(eVar.ou));
            dVar.q("costTime", String.valueOf(j));
            dVar.q("connTime", String.valueOf(eVar.oe));
            dVar.q("rspTime", String.valueOf(eVar.of));
            dVar.q("retry", String.valueOf(eVar.og));
            dVar.q("localIp", e.getIp());
            dVar.q("tiebaIp", str6);
            dVar.q("cdnIp", str4);
            dVar.q("useIp", eVar.oo);
            dVar.q("dnsIp", str5);
            if (eVar.oe > 1500 || eVar.oe < 0) {
                dVar.q("connBaidu", String.valueOf(uC()));
            }
            dVar.q("memory", uD());
            dVar.q("task", uE());
            dVar.q("status", String.valueOf(eVar.om));
            dVar.q("up", String.valueOf(eVar.oc));
            dVar.q("down", String.valueOf(eVar.od));
            dVar.q("isCDN", gs ? "1" : "0");
            dVar.q("isWebp", bool.booleanValue() ? "1" : "0");
            dVar.q("isMobileProxy", z3 ? "1" : "0");
            dVar.q("exception", eVar.oj);
            dVar.q("reason", str3);
            if (i != 0) {
                dVar.d("procType", Integer.valueOf(i));
            }
            if (eVar.or != null) {
                dVar.q("tracecode1", eVar.or);
            }
            if (eVar.ot != null) {
                dVar.q("tracecode2", eVar.ot);
            }
            com.baidu.adp.lib.stats.a.eI().b("img", dVar);
            if (gs && !TextUtils.isEmpty(str6) && TextUtils.isEmpty(str4) && !z) {
                ZN.ZR++;
            }
        }
    }

    public static void uz() {
        if (ZN.uG() > 10) {
            if (ZN.uF() > 0) {
                a(ZN.ZT, ZN.ZU, ZN.ZV, ZN.ZX, ZN.ZW, 10000);
                com.baidu.tbadk.performanceLog.x.b(ZN.ZT, ZN.ZU, ZN.ZV, ZN.ZX, ZN.ZW, 3);
            }
            if (ZN.uI() > 0) {
                a(ZN.aad, ZN.aae, ZN.aaf, ZN.aah, ZN.aag, 100002);
                com.baidu.tbadk.performanceLog.x.b(ZN.aad, ZN.aae, ZN.aaf, ZN.aah, ZN.aag, 2);
            }
            if (ZN.uH() > 0) {
                a(ZN.ZY, ZN.ZZ, ZN.aaa, ZN.aac, ZN.aab, 100001);
                com.baidu.tbadk.performanceLog.x.b(ZN.ZY, ZN.ZZ, ZN.aaa, ZN.aac, ZN.aab, 1);
            }
            ZN.reset();
        }
    }

    public static void a(u uVar, u uVar2, u uVar3, u uVar4, u uVar5, int i) {
        if (uVar != null && uVar2 != null && uVar3 != null && uVar4 != null && uVar5 != null) {
            String str = "";
            String str2 = "";
            String str3 = "";
            if (TextUtils.isEmpty("")) {
                str = w.uJ().uK();
            }
            if (ZQ != null && TextUtils.isEmpty("")) {
                str2 = w.uJ().m11do(ZQ);
            }
            if (TextUtils.isEmpty("")) {
                str3 = uB();
            }
            com.baidu.adp.lib.stats.d eB = eB();
            eB.q("act", "dlStat");
            eB.q("cdnCostTime", String.valueOf(uVar.time));
            eB.q("cdnNum", String.valueOf(uVar.num));
            eB.q("cdnFailnum", String.valueOf(uVar.ZI));
            eB.q("portraitCostTime", String.valueOf(uVar2.time));
            eB.q("portraitNum", String.valueOf(uVar2.num));
            eB.q("portraitFailnum", String.valueOf(uVar2.ZI));
            eB.q("tiebaCostTime", String.valueOf(uVar3.time));
            eB.q("tiebaNum", String.valueOf(uVar3.num));
            eB.q("tiebaFailnum", String.valueOf(uVar3.ZI));
            eB.q("otherCostTime", String.valueOf(uVar5.time));
            eB.q("otherNum", String.valueOf(uVar5.num));
            eB.q("otherFailnum", String.valueOf(uVar5.ZI));
            eB.q("directIpCostTime", String.valueOf(uVar4.time));
            eB.q("directIpNum", String.valueOf(uVar4.num));
            eB.q("directIpFailnum", String.valueOf(uVar4.ZI));
            eB.q("dnsFailNum", String.valueOf(ZN.ZR));
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
            synchronized (pt) {
                ZP.num++;
                if (z) {
                    ZP.time += j;
                } else {
                    ZP.ZI++;
                }
                if (ZP.num >= 100) {
                    uA();
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

    public static void uA() {
        if (ZP.num > 10) {
            com.baidu.adp.lib.stats.d eB = eB();
            eB.q("act", "dcStat");
            eB.q("costTime", String.valueOf(ZP.time));
            eB.q("num", String.valueOf(ZP.num));
            eB.q("failnum", String.valueOf(ZP.ZI));
            com.baidu.adp.lib.stats.a.eI().b("img", eB);
            com.baidu.tbadk.performanceLog.x.a(ZP.num, ZP.ZI, ZP.time);
            ZP.reset();
        }
    }

    public static void dn(String str) {
        com.baidu.adp.lib.stats.d eB = eB();
        eB.q("act", "assistant");
        eB.q(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, str);
        com.baidu.adp.lib.stats.a.eI().b("img", eB);
    }

    private static String uB() {
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
    private static long uC() {
        HttpURLConnection httpURLConnection;
        long j;
        if (ZK >= 3) {
            return ZL;
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
            if (ZK > -1) {
                ZL = ((ZL * ZK) + j) / (ZK + 1);
            } else {
                ZL = j;
            }
            ZK++;
            return j;
        }
        return j;
    }

    private static String uD() {
        return com.baidu.tbadk.imageManager.c.Ek().df();
    }

    private static String uE() {
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
            str6 = w.uJ().m11do(str);
        }
        String uB = uB();
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
        eB.q("dnsIP", uB);
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
