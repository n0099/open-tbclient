package com.baidu.tbadk.core.util;

import android.net.DhcpInfo;
import android.net.wifi.WifiManager;
import android.support.v4.view.MotionEventCompat;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbDomainConfig;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class t {
    private static long YQ = 0;
    private static long YR = 0;
    private static int YS = 0;
    private static a YT = new a(null);
    private static s YU = new s();
    private static s YV = new s();
    private static String YW = null;
    private static Object pl = new Object();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        int YX;
        boolean YY;
        s YZ;
        s Za;
        s Zb;
        s Zc;
        s Zd;
        s Ze;
        s Zf;
        s Zg;
        s Zh;
        s Zi;
        s Zj;
        s Zk;
        s Zl;
        s Zm;
        s Zn;

        private a() {
            this.YX = 0;
            this.YZ = new s();
            this.Za = new s();
            this.Zb = new s();
            this.Zc = new s();
            this.Zd = new s();
            this.Ze = new s();
            this.Zf = new s();
            this.Zg = new s();
            this.Zh = new s();
            this.Zi = new s();
            this.Zj = new s();
            this.Zk = new s();
            this.Zl = new s();
            this.Zm = new s();
            this.Zn = new s();
        }

        /* synthetic */ a(a aVar) {
            this();
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [75=4] */
        public int up() {
            return this.YZ.num + this.Za.num + this.Zb.num + this.Zc.num + this.Zd.num;
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [81=14] */
        public int uq() {
            return this.YZ.num + this.Za.num + this.Zb.num + this.Zc.num + this.Zd.num + this.Ze.num + this.Zf.num + this.Zg.num + this.Zh.num + this.Zi.num + this.Zj.num + this.Zk.num + this.Zl.num + this.Zm.num + this.Zn.num;
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [92=4] */
        public int ur() {
            return this.Ze.num + this.Zf.num + this.Zg.num + this.Zh.num + this.Zi.num;
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [98=4] */
        public int us() {
            return this.Zj.num + this.Zk.num + this.Zl.num + this.Zm.num + this.Zn.num;
        }

        public void reset() {
            this.YX = 0;
            this.YZ.reset();
            this.Za.reset();
            this.Zb.reset();
            this.Zc.reset();
            this.Zd.reset();
            this.Ze.reset();
            this.Zf.reset();
            this.Zg.reset();
            this.Zh.reset();
            this.Zi.reset();
            this.Zj.reset();
            this.Zk.reset();
            this.Zl.reset();
            this.Zm.reset();
            this.Zn.reset();
        }
    }

    private static s a(boolean z, boolean z2, String str, boolean z3) {
        if (z) {
            if (z2 && !z3) {
                return YT.YZ;
            }
            if (str.startsWith("http://tb.himg")) {
                return YT.Za;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return YT.Zb;
            }
            if (z2 && z3) {
                return YT.Zd;
            }
            return YT.Zc;
        } else if (com.baidu.adp.lib.util.i.gp()) {
            if (z2) {
                return YT.Ze;
            }
            if (str.startsWith("http://tb.himg")) {
                return YT.Zf;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return YT.Zg;
            }
            return YT.Zh;
        } else if (z2) {
            return YT.Zj;
        } else {
            if (str.startsWith("http://tb.himg")) {
                return YT.Zk;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return YT.Zl;
            }
            return YT.Zm;
        }
    }

    public static com.baidu.adp.lib.stats.d ez() {
        return com.baidu.adp.lib.stats.a.eG().an("dbg");
    }

    public static void a(com.baidu.adp.lib.stats.d dVar, String str, boolean z, long j, boolean z2) {
        if (z && z2) {
            synchronized (pl) {
                YU.num++;
                YU.time += j;
                if (YU.num >= 100) {
                    uh();
                }
            }
        }
    }

    public static void uh() {
        if (YU.num > 10) {
            com.baidu.adp.lib.stats.d ez = ez();
            ez.q("act", "locStat");
            ez.q("costTime", String.valueOf(YU.time));
            ez.q("num", String.valueOf(YU.num));
            ez.q("isWifi", "1");
            com.baidu.adp.lib.stats.a.eG().b("img", ez);
            YU.reset();
        }
    }

    public static void a(com.baidu.adp.lib.stats.d dVar, String str, boolean z, String str2, boolean z2, Boolean bool, com.baidu.adp.lib.network.http.e eVar, String str3, long j, boolean z3, long j2, int i) {
        boolean z4;
        String str4;
        String str5;
        if (com.baidu.adp.lib.util.k.gB() && eVar != null) {
            String str6 = "";
            boolean gk = com.baidu.tbadk.util.g.gk(str2);
            boolean z5 = false;
            if (com.baidu.tbadk.core.util.a.e.getInstance() != null) {
                z5 = true;
                if (!com.baidu.tbadk.core.util.a.e.getInstance().abJ) {
                    com.baidu.tbadk.core.util.a.e.getInstance().init();
                }
            }
            boolean gl = com.baidu.adp.lib.util.i.gl();
            if (!z5) {
                z4 = false;
            } else if (gl) {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().Ms);
            } else if (com.baidu.adp.lib.util.i.gp()) {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().Mu);
            } else {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().Mt);
            }
            boolean z6 = false;
            if (gk && z5) {
                z6 = com.baidu.tbadk.core.util.a.e.getInstance().isShouldCDNFallBack();
            }
            if (gk && gl && z6) {
                if (z) {
                    q.getInstance().insertNormalData(j, str);
                } else {
                    str6 = u.ut().uu();
                    if (!TextUtils.isEmpty(str6)) {
                        q.getInstance().insertErrorData(eVar.oe, str);
                    }
                }
            }
            if (gk) {
                YW = str;
            }
            boolean z7 = false;
            if (eVar.og != null && eVar.og.length() > 0) {
                z7 = true;
            }
            synchronized (pl) {
                s a2 = a(gl, gk, str2, z7);
                boolean z8 = YT.YY;
                if (a2 != null) {
                    a2.num++;
                    if (z) {
                        a2.time += j;
                        a2.nX += j2;
                        YT.YY = true;
                        if (z4) {
                            a2.YP++;
                        }
                        YS = 0;
                    } else {
                        if (com.baidu.adp.lib.util.i.gk()) {
                            int i2 = YS + 1;
                            YS = i2;
                            if (i2 >= com.baidu.adp.lib.stats.switchs.a.fB().getMaxAlertCount("alert_img", 5)) {
                                com.baidu.adp.lib.stats.a.eG().p("alert_img", "imgFailedCnt_" + String.valueOf(YS) + "_url=" + str2);
                            }
                        }
                        a2.YO++;
                        YT.YY = false;
                    }
                }
                int uq = YT.uq();
                if (uq > 100 || (uq > 0 && z8 != YT.YY)) {
                    uj();
                }
            }
            if (z && z5) {
                if (!gl || j >= com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().Ms) {
                    if (gl || !com.baidu.adp.lib.util.i.gp() || j >= com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().Mu) {
                        if (!gl && j < com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().Mt) {
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
                dVar = ez();
            }
            if (TextUtils.isEmpty(str6)) {
                str6 = u.ut().uu();
            }
            if (!gk || !TextUtils.isEmpty("")) {
                str4 = "";
            } else {
                str4 = u.ut().dp(str);
            }
            if (!TextUtils.isEmpty("")) {
                str5 = "";
            } else {
                str5 = ul();
            }
            dVar.q("url", str);
            dVar.q("act", "dl");
            dVar.q("result", z ? "1" : "0");
            dVar.q("fullurl", str2);
            dVar.q("netlib", String.valueOf(eVar.ol));
            dVar.q("costTime", String.valueOf(j));
            dVar.q("connTime", String.valueOf(eVar.nY));
            dVar.q("rspTime", String.valueOf(eVar.nZ));
            dVar.q("retry", String.valueOf(eVar.oa));
            dVar.q("localIp", d.getIp());
            dVar.q("tiebaIp", str6);
            dVar.q("cdnIp", str4);
            dVar.q("useIp", eVar.og);
            dVar.q("dnsIp", str5);
            if (eVar.nY > 1500 || eVar.nY < 0) {
                dVar.q("connBaidu", String.valueOf(um()));
            }
            dVar.q("memory", un());
            dVar.q("task", uo());
            dVar.q("status", String.valueOf(eVar.of));
            dVar.q("up", String.valueOf(eVar.nW));
            dVar.q("down", String.valueOf(eVar.nX));
            dVar.q("isCDN", gk ? "1" : "0");
            dVar.q("isWebp", bool.booleanValue() ? "1" : "0");
            dVar.q("isMobileProxy", z3 ? "1" : "0");
            dVar.q("exception", eVar.od);
            dVar.q("reason", str3);
            if (i != 0) {
                dVar.d("procType", Integer.valueOf(i));
            }
            if (eVar.oi != null) {
                dVar.q("tracecode1", eVar.oi);
            }
            if (eVar.oj != null) {
                dVar.q("tracecode2", eVar.oj);
            }
            com.baidu.adp.lib.stats.a.eG().b("img", dVar);
            if (gk && !TextUtils.isEmpty(str6) && TextUtils.isEmpty(str4) && !z) {
                YT.YX++;
            }
        }
    }

    public static void uj() {
        if (YT.uq() > 10) {
            if (YT.up() > 0) {
                a(YT.YZ, YT.Za, YT.Zb, YT.Zd, YT.Zc, 10000);
                com.baidu.tbadk.performanceLog.x.b(YT.YZ, YT.Za, YT.Zb, YT.Zd, YT.Zc, 3);
            }
            if (YT.us() > 0) {
                a(YT.Zj, YT.Zk, YT.Zl, YT.Zn, YT.Zm, 100002);
                com.baidu.tbadk.performanceLog.x.b(YT.Zj, YT.Zk, YT.Zl, YT.Zn, YT.Zm, 2);
            }
            if (YT.ur() > 0) {
                a(YT.Ze, YT.Zf, YT.Zg, YT.Zi, YT.Zh, 100001);
                com.baidu.tbadk.performanceLog.x.b(YT.Ze, YT.Zf, YT.Zg, YT.Zi, YT.Zh, 1);
            }
            YT.reset();
        }
    }

    public static void a(s sVar, s sVar2, s sVar3, s sVar4, s sVar5, int i) {
        if (sVar != null && sVar2 != null && sVar3 != null && sVar4 != null && sVar5 != null) {
            String str = "";
            String str2 = "";
            String str3 = "";
            if (TextUtils.isEmpty("")) {
                str = u.ut().uu();
            }
            if (YW != null && TextUtils.isEmpty("")) {
                str2 = u.ut().dp(YW);
            }
            if (TextUtils.isEmpty("")) {
                str3 = ul();
            }
            com.baidu.adp.lib.stats.d ez = ez();
            ez.q("act", "dlStat");
            ez.q("cdnCostTime", String.valueOf(sVar.time));
            ez.q("cdnNum", String.valueOf(sVar.num));
            ez.q("cdnFailnum", String.valueOf(sVar.YO));
            ez.q("portraitCostTime", String.valueOf(sVar2.time));
            ez.q("portraitNum", String.valueOf(sVar2.num));
            ez.q("portraitFailnum", String.valueOf(sVar2.YO));
            ez.q("tiebaCostTime", String.valueOf(sVar3.time));
            ez.q("tiebaNum", String.valueOf(sVar3.num));
            ez.q("tiebaFailnum", String.valueOf(sVar3.YO));
            ez.q("otherCostTime", String.valueOf(sVar5.time));
            ez.q("otherNum", String.valueOf(sVar5.num));
            ez.q("otherFailnum", String.valueOf(sVar5.YO));
            ez.q("directIpCostTime", String.valueOf(sVar4.time));
            ez.q("directIpNum", String.valueOf(sVar4.num));
            ez.q("directIpFailnum", String.valueOf(sVar4.YO));
            ez.q("dnsFailNum", String.valueOf(YT.YX));
            if (10000 == i) {
                ez.q("isWifi", "1");
                ez.q("netType", "WIFI");
            } else if (100002 == i) {
                ez.q("netType", "3G");
                ez.q("isWifi", "0");
            } else {
                ez.q("netType", "2G");
                ez.q("isWifi", "0");
            }
            ez.q("localIp", d.getIp());
            ez.q("tbIp", str);
            ez.q("cdnIp", str2);
            ez.q("dnsIp", str3);
            com.baidu.adp.lib.stats.a.eG().b("img", ez);
        }
    }

    public static void a(com.baidu.adp.lib.stats.d dVar, String str, String str2, boolean z, boolean z2, boolean z3, int i, String str3, long j, String str4) {
        if (com.baidu.adp.lib.util.k.gB()) {
            synchronized (pl) {
                YV.num++;
                if (z) {
                    YV.time += j;
                } else {
                    YV.YO++;
                }
                if (YV.num >= 100) {
                    uk();
                }
            }
            if (!z) {
                if (dVar == null) {
                    dVar = ez();
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
                com.baidu.adp.lib.stats.a.eG().b("img", dVar);
            }
        }
    }

    public static void uk() {
        if (YV.num > 10) {
            com.baidu.adp.lib.stats.d ez = ez();
            ez.q("act", "dcStat");
            ez.q("costTime", String.valueOf(YV.time));
            ez.q("num", String.valueOf(YV.num));
            ez.q("failnum", String.valueOf(YV.YO));
            com.baidu.adp.lib.stats.a.eG().b("img", ez);
            com.baidu.tbadk.performanceLog.x.a(YV.num, YV.YO, YV.time);
            YV.reset();
        }
    }

    /* renamed from: do  reason: not valid java name */
    public static void m11do(String str) {
        com.baidu.adp.lib.stats.d ez = ez();
        ez.q("act", "assistant");
        ez.q(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, str);
        com.baidu.adp.lib.stats.a.eG().b("img", ez);
    }

    private static String ul() {
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
    private static long um() {
        HttpURLConnection httpURLConnection;
        long j;
        if (YQ >= 3) {
            return YR;
        }
        long currentTimeMillis = System.currentTimeMillis();
        HttpURLConnection httpURLConnection2 = null;
        try {
            httpURLConnection = (HttpURLConnection) new URL(TbDomainConfig.DOMAIN_HTTPS_BAIDU).openConnection();
            try {
                httpURLConnection.setConnectTimeout(TbConfig.NOTIFY_YUN_PUSH);
                httpURLConnection.connect();
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.g.a.f(httpURLConnection);
                j = currentTimeMillis2;
            } catch (SocketTimeoutException e) {
                com.baidu.adp.lib.g.a.f(httpURLConnection);
                j = 2500;
                if (j > 0) {
                }
            } catch (Exception e2) {
                httpURLConnection2 = httpURLConnection;
                com.baidu.adp.lib.g.a.f(httpURLConnection2);
                j = -1;
                if (j > 0) {
                }
            } catch (Throwable th) {
                httpURLConnection2 = httpURLConnection;
                th = th;
                com.baidu.adp.lib.g.a.f(httpURLConnection2);
                throw th;
            }
        } catch (SocketTimeoutException e3) {
            httpURLConnection = null;
        } catch (Exception e4) {
        } catch (Throwable th2) {
            th = th2;
        }
        if (j > 0) {
            if (YQ > -1) {
                YR = ((YR * YQ) + j) / (YQ + 1);
            } else {
                YR = j;
            }
            YQ++;
            return j;
        }
        return j;
    }

    private static String un() {
        return com.baidu.tbadk.imageManager.c.DS().dd();
    }

    private static String uo() {
        return com.baidu.adp.lib.asyncTask.c.de().dd();
    }

    public static void a(boolean z, boolean z2, String str, String str2) {
        com.baidu.adp.lib.stats.d ez = ez();
        ez.q("act", "getCDNList");
        ez.q("errorNum", str);
        ez.q("errorMsg", str2);
        ez.q("isShortNetError", z2 ? "1" : "0");
        ez.q("isSuccess", z ? "1" : "0");
        com.baidu.adp.lib.stats.a.eG().b("img", ez);
    }

    public static void a(boolean z, String str, String str2, String str3, String str4, String str5, long j, boolean z2) {
        String str6 = "";
        if (str != null) {
            str6 = u.ut().dp(str);
        }
        String ul = ul();
        String ip = d.getIp();
        com.baidu.adp.lib.stats.d ez = ez();
        ez.q("act", "tachometerCDN");
        ez.q("errorNum", str3);
        ez.q("execption", str4);
        ez.q("size", str5);
        ez.q("isScuess", z ? "1" : "0");
        ez.q("url", str);
        ez.q("localIp", ip);
        ez.q("cdnIp", str6);
        ez.q("dnsIP", ul);
        ez.q("usedIp", str2);
        ez.q("isUsedIp", z2 ? "0" : "1");
        ez.q("costTime", String.valueOf(j));
        com.baidu.adp.lib.stats.a.eG().b("img", ez);
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
                    com.baidu.adp.lib.stats.d ez = ez();
                    ez.q("act", "mobileTachometerCDN");
                    ez.q("costTime", String.valueOf(j));
                    ez.q("ipList", sb.toString());
                    com.baidu.adp.lib.stats.a.eG().b("img", ez);
                    return;
                }
            }
        }
    }

    public static void d(boolean z, String str) {
        com.baidu.adp.lib.stats.d ez = ez();
        ez.q("act", "getCDNList");
        ez.q("isSuccess", z ? "1" : "0");
        ez.q("errorMsg", str);
        com.baidu.adp.lib.stats.a.eG().b("img", ez);
    }

    public static void a(String str, int i, int i2, int i3) {
        if (i == -1) {
            i = 0;
        }
        if (i2 == -1) {
            i2 = 0;
        }
        com.baidu.adp.lib.stats.a.eG().eventStat(null, str, "imgHttpSwitch", 1, "1sterrcode", String.valueOf(i), "2nderrcode", String.valueOf(i2), "2imgFailed", String.valueOf(i3));
    }
}
