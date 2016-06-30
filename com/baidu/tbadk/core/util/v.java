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
    private static long Wa = 0;
    private static long Wb = 0;
    private static int Wc = 0;
    private static a Wd = new a(null);
    private static u We = new u();
    private static u Wf = new u();
    private static String Wg = null;
    private static Object mp = new Object();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        int Wh;
        boolean Wi;
        u Wj;
        u Wk;
        u Wl;
        u Wm;
        u Wn;
        u Wo;
        u Wp;
        u Wq;
        u Wr;
        u Ws;
        u Wt;
        u Wu;
        u Wv;
        u Ww;
        u Wx;

        private a() {
            this.Wh = 0;
            this.Wj = new u();
            this.Wk = new u();
            this.Wl = new u();
            this.Wm = new u();
            this.Wn = new u();
            this.Wo = new u();
            this.Wp = new u();
            this.Wq = new u();
            this.Wr = new u();
            this.Ws = new u();
            this.Wt = new u();
            this.Wu = new u();
            this.Wv = new u();
            this.Ww = new u();
            this.Wx = new u();
        }

        /* synthetic */ a(a aVar) {
            this();
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [74=4] */
        public int tl() {
            return this.Wj.num + this.Wk.num + this.Wl.num + this.Wm.num + this.Wn.num;
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [80=14] */
        public int tm() {
            return this.Wj.num + this.Wk.num + this.Wl.num + this.Wm.num + this.Wn.num + this.Wo.num + this.Wp.num + this.Wq.num + this.Wr.num + this.Ws.num + this.Wt.num + this.Wu.num + this.Wv.num + this.Ww.num + this.Wx.num;
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [91=4] */
        public int tn() {
            return this.Wo.num + this.Wp.num + this.Wq.num + this.Wr.num + this.Ws.num;
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [97=4] */
        public int to() {
            return this.Wt.num + this.Wu.num + this.Wv.num + this.Ww.num + this.Wx.num;
        }

        public void reset() {
            this.Wh = 0;
            this.Wj.reset();
            this.Wk.reset();
            this.Wl.reset();
            this.Wm.reset();
            this.Wn.reset();
            this.Wo.reset();
            this.Wp.reset();
            this.Wq.reset();
            this.Wr.reset();
            this.Ws.reset();
            this.Wt.reset();
            this.Wu.reset();
            this.Wv.reset();
            this.Ww.reset();
            this.Wx.reset();
        }
    }

    private static u a(boolean z, boolean z2, String str, boolean z3) {
        if (z) {
            if (z2 && !z3) {
                return Wd.Wj;
            }
            if (str.startsWith("http://tb.himg")) {
                return Wd.Wk;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return Wd.Wl;
            }
            if (z2 && z3) {
                return Wd.Wn;
            }
            return Wd.Wm;
        } else if (com.baidu.adp.lib.util.i.fw()) {
            if (z2) {
                return Wd.Wo;
            }
            if (str.startsWith("http://tb.himg")) {
                return Wd.Wp;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return Wd.Wq;
            }
            return Wd.Wr;
        } else if (z2) {
            return Wd.Wt;
        } else {
            if (str.startsWith("http://tb.himg")) {
                return Wd.Wu;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return Wd.Wv;
            }
            return Wd.Ww;
        }
    }

    public static com.baidu.adp.lib.stats.d dH() {
        return com.baidu.adp.lib.stats.a.dO().al("dbg");
    }

    public static void a(com.baidu.adp.lib.stats.d dVar, String str, boolean z, long j, boolean z2) {
        if (z && z2) {
            synchronized (mp) {
                We.num++;
                We.time += j;
                if (We.num >= 100) {
                    te();
                }
            }
        }
    }

    public static void te() {
        if (We.num > 10) {
            com.baidu.adp.lib.stats.d dH = dH();
            dH.q("act", "locStat");
            dH.q("costTime", String.valueOf(We.time));
            dH.q("num", String.valueOf(We.num));
            dH.q("isWifi", "1");
            com.baidu.adp.lib.stats.a.dO().b("img", dH);
            We.reset();
        }
    }

    public static void a(com.baidu.adp.lib.stats.d dVar, String str, boolean z, String str2, boolean z2, Boolean bool, com.baidu.adp.lib.network.http.e eVar, String str3, long j, boolean z3, long j2, int i) {
        boolean z4;
        String str4;
        String str5;
        if (com.baidu.adp.lib.util.k.fI() && eVar != null) {
            String str6 = "";
            boolean gn = com.baidu.tbadk.util.h.gn(str2);
            boolean z5 = false;
            if (com.baidu.tbadk.core.util.a.e.getInstance() != null) {
                z5 = true;
                if (!com.baidu.tbadk.core.util.a.e.getInstance().YX) {
                    com.baidu.tbadk.core.util.a.e.getInstance().init();
                }
            }
            boolean fs = com.baidu.adp.lib.util.i.fs();
            if (!z5) {
                z4 = false;
            } else if (fs) {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().KT);
            } else if (com.baidu.adp.lib.util.i.fw()) {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().KV);
            } else {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().KU);
            }
            boolean z6 = false;
            if (gn && z5) {
                z6 = com.baidu.tbadk.core.util.a.e.getInstance().isShouldCDNFallBack();
            }
            if (gn && fs && z6) {
                if (z) {
                    r.getInstance().insertNormalData(j, str);
                } else {
                    str6 = w.tp().tq();
                    if (!TextUtils.isEmpty(str6)) {
                        r.getInstance().insertErrorData(eVar.lm, str);
                    }
                }
            }
            if (gn) {
                Wg = str;
            }
            boolean z7 = false;
            if (eVar.lo != null && eVar.lo.length() > 0) {
                z7 = true;
            }
            synchronized (mp) {
                u a2 = a(fs, gn, str2, z7);
                boolean z8 = Wd.Wi;
                if (a2 != null) {
                    a2.num++;
                    if (z) {
                        a2.time += j;
                        a2.lf += j2;
                        Wd.Wi = true;
                        if (z4) {
                            a2.VZ++;
                        }
                        Wc = 0;
                    } else {
                        if (com.baidu.adp.lib.util.i.fr()) {
                            int i2 = Wc + 1;
                            Wc = i2;
                            if (i2 >= com.baidu.adp.lib.stats.switchs.a.eJ().getMaxAlertCount("alert_img", 5)) {
                                com.baidu.adp.lib.stats.a.dO().p("alert_img", "imgFailedCnt_" + String.valueOf(Wc) + "_url=" + str2);
                            }
                        }
                        a2.VY++;
                        Wd.Wi = false;
                    }
                }
                int tm = Wd.tm();
                if (tm > 100 || (tm > 0 && z8 != Wd.Wi)) {
                    tf();
                }
            }
            if (z && z5) {
                if (!fs || j >= com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().KT) {
                    if (fs || !com.baidu.adp.lib.util.i.fw() || j >= com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().KV) {
                        if (!fs && j < com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().KU) {
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
                dVar = dH();
            }
            if (TextUtils.isEmpty(str6)) {
                str6 = w.tp().tq();
            }
            if (!gn || !TextUtils.isEmpty("")) {
                str4 = "";
            } else {
                str4 = w.tp().dk(str);
            }
            if (!TextUtils.isEmpty("")) {
                str5 = "";
            } else {
                str5 = th();
            }
            dVar.q("url", str);
            dVar.q("act", "dl");
            dVar.q("result", z ? "1" : "0");
            dVar.q("fullurl", str2);
            dVar.q("netlib", String.valueOf(eVar.ls));
            dVar.q("costTime", String.valueOf(j));
            dVar.q("connTime", String.valueOf(eVar.lg));
            dVar.q("rspTime", String.valueOf(eVar.lh));
            dVar.q("retry", String.valueOf(eVar.li));
            dVar.q("localIp", e.getIp());
            dVar.q("tiebaIp", str6);
            dVar.q("cdnIp", str4);
            dVar.q("useIp", eVar.lo);
            dVar.q("dnsIp", str5);
            if (eVar.lg > 1500 || eVar.lg < 0) {
                dVar.q("connBaidu", String.valueOf(ti()));
            }
            dVar.q("memory", tj());
            dVar.q("task", tk());
            dVar.q("status", String.valueOf(eVar.ln));
            dVar.q("up", String.valueOf(eVar.le));
            dVar.q("down", String.valueOf(eVar.lf));
            dVar.q("isCDN", gn ? "1" : "0");
            dVar.q("isWebp", bool.booleanValue() ? "1" : "0");
            dVar.q("isMobileProxy", z3 ? "1" : "0");
            dVar.q("exception", eVar.ll);
            dVar.q("reason", str3);
            if (i != 0) {
                dVar.b("procType", Integer.valueOf(i));
            }
            if (eVar.lq != null) {
                dVar.q("tracecode1", eVar.lq);
            }
            if (eVar.lr != null) {
                dVar.q("tracecode2", eVar.lr);
            }
            com.baidu.adp.lib.stats.a.dO().b("img", dVar);
            if (gn && !TextUtils.isEmpty(str6) && TextUtils.isEmpty(str4) && !z) {
                Wd.Wh++;
            }
        }
    }

    public static void tf() {
        if (Wd.tm() > 10) {
            if (Wd.tl() > 0) {
                a(Wd.Wj, Wd.Wk, Wd.Wl, Wd.Wn, Wd.Wm, 10000);
                com.baidu.tbadk.performanceLog.x.b(Wd.Wj, Wd.Wk, Wd.Wl, Wd.Wn, Wd.Wm, 3);
            }
            if (Wd.to() > 0) {
                a(Wd.Wt, Wd.Wu, Wd.Wv, Wd.Wx, Wd.Ww, 100002);
                com.baidu.tbadk.performanceLog.x.b(Wd.Wt, Wd.Wu, Wd.Wv, Wd.Wx, Wd.Ww, 2);
            }
            if (Wd.tn() > 0) {
                a(Wd.Wo, Wd.Wp, Wd.Wq, Wd.Ws, Wd.Wr, 100001);
                com.baidu.tbadk.performanceLog.x.b(Wd.Wo, Wd.Wp, Wd.Wq, Wd.Ws, Wd.Wr, 1);
            }
            Wd.reset();
        }
    }

    public static void a(u uVar, u uVar2, u uVar3, u uVar4, u uVar5, int i) {
        if (uVar != null && uVar2 != null && uVar3 != null && uVar4 != null && uVar5 != null) {
            String str = "";
            String str2 = "";
            String str3 = "";
            if (TextUtils.isEmpty("")) {
                str = w.tp().tq();
            }
            if (Wg != null && TextUtils.isEmpty("")) {
                str2 = w.tp().dk(Wg);
            }
            if (TextUtils.isEmpty("")) {
                str3 = th();
            }
            com.baidu.adp.lib.stats.d dH = dH();
            dH.q("act", "dlStat");
            dH.q("cdnCostTime", String.valueOf(uVar.time));
            dH.q("cdnNum", String.valueOf(uVar.num));
            dH.q("cdnFailnum", String.valueOf(uVar.VY));
            dH.q("portraitCostTime", String.valueOf(uVar2.time));
            dH.q("portraitNum", String.valueOf(uVar2.num));
            dH.q("portraitFailnum", String.valueOf(uVar2.VY));
            dH.q("tiebaCostTime", String.valueOf(uVar3.time));
            dH.q("tiebaNum", String.valueOf(uVar3.num));
            dH.q("tiebaFailnum", String.valueOf(uVar3.VY));
            dH.q("otherCostTime", String.valueOf(uVar5.time));
            dH.q("otherNum", String.valueOf(uVar5.num));
            dH.q("otherFailnum", String.valueOf(uVar5.VY));
            dH.q("directIpCostTime", String.valueOf(uVar4.time));
            dH.q("directIpNum", String.valueOf(uVar4.num));
            dH.q("directIpFailnum", String.valueOf(uVar4.VY));
            dH.q("dnsFailNum", String.valueOf(Wd.Wh));
            if (10000 == i) {
                dH.q("isWifi", "1");
                dH.q("netType", "WIFI");
            } else if (100002 == i) {
                dH.q("netType", "3G");
                dH.q("isWifi", "0");
            } else {
                dH.q("netType", "2G");
                dH.q("isWifi", "0");
            }
            dH.q("localIp", e.getIp());
            dH.q("tbIp", str);
            dH.q("cdnIp", str2);
            dH.q("dnsIp", str3);
            com.baidu.adp.lib.stats.a.dO().b("img", dH);
        }
    }

    public static void a(com.baidu.adp.lib.stats.d dVar, String str, String str2, boolean z, boolean z2, boolean z3, int i, String str3, long j, String str4) {
        if (com.baidu.adp.lib.util.k.fI()) {
            synchronized (mp) {
                Wf.num++;
                if (z) {
                    Wf.time += j;
                } else {
                    Wf.VY++;
                }
                if (Wf.num >= 100) {
                    tg();
                }
            }
            if (!z) {
                if (dVar == null) {
                    dVar = dH();
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
                com.baidu.adp.lib.stats.a.dO().b("img", dVar);
            }
        }
    }

    public static void tg() {
        if (Wf.num > 10) {
            com.baidu.adp.lib.stats.d dH = dH();
            dH.q("act", "dcStat");
            dH.q("costTime", String.valueOf(Wf.time));
            dH.q("num", String.valueOf(Wf.num));
            dH.q("failnum", String.valueOf(Wf.VY));
            com.baidu.adp.lib.stats.a.dO().b("img", dH);
            com.baidu.tbadk.performanceLog.x.a(Wf.num, Wf.VY, Wf.time);
            Wf.reset();
        }
    }

    public static void dj(String str) {
        com.baidu.adp.lib.stats.d dH = dH();
        dH.q("act", "assistant");
        dH.q(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, str);
        com.baidu.adp.lib.stats.a.dO().b("img", dH);
    }

    private static String th() {
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
    private static long ti() {
        HttpURLConnection httpURLConnection;
        long j;
        if (Wa >= 3) {
            return Wb;
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
            if (Wa > -1) {
                Wb = ((Wb * Wa) + j) / (Wa + 1);
            } else {
                Wb = j;
            }
            Wa++;
            return j;
        }
        return j;
    }

    private static String tj() {
        return com.baidu.tbadk.imageManager.c.CQ().cl();
    }

    private static String tk() {
        return com.baidu.adp.lib.asyncTask.c.cm().cl();
    }

    public static void a(boolean z, boolean z2, String str, String str2) {
        com.baidu.adp.lib.stats.d dH = dH();
        dH.q("act", "getCDNList");
        dH.q("errorNum", str);
        dH.q(EcommSellerErrorActivityConfig.ERROR_MSG, str2);
        dH.q("isShortNetError", z2 ? "1" : "0");
        dH.q("isSuccess", z ? "1" : "0");
        com.baidu.adp.lib.stats.a.dO().b("img", dH);
    }

    public static void a(boolean z, String str, String str2, String str3, String str4, String str5, long j, boolean z2) {
        String str6 = "";
        if (str != null) {
            str6 = w.tp().dk(str);
        }
        String th = th();
        String ip = e.getIp();
        com.baidu.adp.lib.stats.d dH = dH();
        dH.q("act", "tachometerCDN");
        dH.q("errorNum", str3);
        dH.q("execption", str4);
        dH.q("size", str5);
        dH.q("isScuess", z ? "1" : "0");
        dH.q("url", str);
        dH.q("localIp", ip);
        dH.q("cdnIp", str6);
        dH.q("dnsIP", th);
        dH.q("usedIp", str2);
        dH.q("isUsedIp", z2 ? "0" : "1");
        dH.q("costTime", String.valueOf(j));
        com.baidu.adp.lib.stats.a.dO().b("img", dH);
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
                    com.baidu.adp.lib.stats.d dH = dH();
                    dH.q("act", "mobileTachometerCDN");
                    dH.q("costTime", String.valueOf(j));
                    dH.q("ipList", sb.toString());
                    com.baidu.adp.lib.stats.a.dO().b("img", dH);
                    return;
                }
            }
        }
    }

    public static void d(boolean z, String str) {
        com.baidu.adp.lib.stats.d dH = dH();
        dH.q("act", "getCDNList");
        dH.q("isSuccess", z ? "1" : "0");
        dH.q(EcommSellerErrorActivityConfig.ERROR_MSG, str);
        com.baidu.adp.lib.stats.a.dO().b("img", dH);
    }

    public static void a(String str, int i, int i2, int i3) {
        if (i == -1) {
            i = 0;
        }
        if (i2 == -1) {
            i2 = 0;
        }
        com.baidu.adp.lib.stats.a.dO().eventStat(null, str, "imgHttpSwitch", 1, "1sterrcode", String.valueOf(i), "2nderrcode", String.valueOf(i2), "2imgFailed", String.valueOf(i3));
    }
}
