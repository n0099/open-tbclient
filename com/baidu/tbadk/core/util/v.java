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
    private static long VK = 0;
    private static long VL = 0;
    private static int VM = 0;
    private static a VN = new a(null);
    private static u VO = new u();
    private static u VP = new u();
    private static String VQ = null;
    private static Object mp = new Object();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        int VR;
        boolean VS;
        u VT;
        u VU;
        u VV;
        u VW;
        u VX;
        u VY;
        u VZ;
        u Wa;
        u Wb;
        u Wc;
        u Wd;
        u We;
        u Wf;
        u Wg;
        u Wh;

        private a() {
            this.VR = 0;
            this.VT = new u();
            this.VU = new u();
            this.VV = new u();
            this.VW = new u();
            this.VX = new u();
            this.VY = new u();
            this.VZ = new u();
            this.Wa = new u();
            this.Wb = new u();
            this.Wc = new u();
            this.Wd = new u();
            this.We = new u();
            this.Wf = new u();
            this.Wg = new u();
            this.Wh = new u();
        }

        /* synthetic */ a(a aVar) {
            this();
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [74=4] */
        public int to() {
            return this.VT.num + this.VU.num + this.VV.num + this.VW.num + this.VX.num;
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [80=14] */
        public int tp() {
            return this.VT.num + this.VU.num + this.VV.num + this.VW.num + this.VX.num + this.VY.num + this.VZ.num + this.Wa.num + this.Wb.num + this.Wc.num + this.Wd.num + this.We.num + this.Wf.num + this.Wg.num + this.Wh.num;
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [91=4] */
        public int tq() {
            return this.VY.num + this.VZ.num + this.Wa.num + this.Wb.num + this.Wc.num;
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [97=4] */
        public int tr() {
            return this.Wd.num + this.We.num + this.Wf.num + this.Wg.num + this.Wh.num;
        }

        public void reset() {
            this.VR = 0;
            this.VT.reset();
            this.VU.reset();
            this.VV.reset();
            this.VW.reset();
            this.VX.reset();
            this.VY.reset();
            this.VZ.reset();
            this.Wa.reset();
            this.Wb.reset();
            this.Wc.reset();
            this.Wd.reset();
            this.We.reset();
            this.Wf.reset();
            this.Wg.reset();
            this.Wh.reset();
        }
    }

    private static u a(boolean z, boolean z2, String str, boolean z3) {
        if (z) {
            if (z2 && !z3) {
                return VN.VT;
            }
            if (str.startsWith("http://tb.himg")) {
                return VN.VU;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return VN.VV;
            }
            if (z2 && z3) {
                return VN.VX;
            }
            return VN.VW;
        } else if (com.baidu.adp.lib.util.i.fv()) {
            if (z2) {
                return VN.VY;
            }
            if (str.startsWith("http://tb.himg")) {
                return VN.VZ;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return VN.Wa;
            }
            return VN.Wb;
        } else if (z2) {
            return VN.Wd;
        } else {
            if (str.startsWith("http://tb.himg")) {
                return VN.We;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return VN.Wf;
            }
            return VN.Wg;
        }
    }

    public static com.baidu.adp.lib.stats.d dG() {
        return com.baidu.adp.lib.stats.a.dN().al("dbg");
    }

    public static void a(com.baidu.adp.lib.stats.d dVar, String str, boolean z, long j, boolean z2) {
        if (z && z2) {
            synchronized (mp) {
                VO.num++;
                VO.time += j;
                if (VO.num >= 100) {
                    th();
                }
            }
        }
    }

    public static void th() {
        if (VO.num > 10) {
            com.baidu.adp.lib.stats.d dG = dG();
            dG.q("act", "locStat");
            dG.q("costTime", String.valueOf(VO.time));
            dG.q("num", String.valueOf(VO.num));
            dG.q("isWifi", "1");
            com.baidu.adp.lib.stats.a.dN().b("img", dG);
            VO.reset();
        }
    }

    public static void a(com.baidu.adp.lib.stats.d dVar, String str, boolean z, String str2, boolean z2, Boolean bool, com.baidu.adp.lib.network.http.e eVar, String str3, long j, boolean z3, long j2, int i) {
        boolean z4;
        String str4;
        String str5;
        if (com.baidu.adp.lib.util.k.fH() && eVar != null) {
            String str6 = "";
            boolean gh = com.baidu.tbadk.util.h.gh(str2);
            boolean z5 = false;
            if (com.baidu.tbadk.core.util.a.e.getInstance() != null) {
                z5 = true;
                if (!com.baidu.tbadk.core.util.a.e.getInstance().YG) {
                    com.baidu.tbadk.core.util.a.e.getInstance().init();
                }
            }
            boolean fr = com.baidu.adp.lib.util.i.fr();
            if (!z5) {
                z4 = false;
            } else if (fr) {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().KT);
            } else if (com.baidu.adp.lib.util.i.fv()) {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().KV);
            } else {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().KU);
            }
            boolean z6 = false;
            if (gh && z5) {
                z6 = com.baidu.tbadk.core.util.a.e.getInstance().isShouldCDNFallBack();
            }
            if (gh && fr && z6) {
                if (z) {
                    r.getInstance().insertNormalData(j, str);
                } else {
                    str6 = w.ts().tt();
                    if (!TextUtils.isEmpty(str6)) {
                        r.getInstance().insertErrorData(eVar.lo, str);
                    }
                }
            }
            if (gh) {
                VQ = str;
            }
            boolean z7 = false;
            if (eVar.lq != null && eVar.lq.length() > 0) {
                z7 = true;
            }
            synchronized (mp) {
                u a2 = a(fr, gh, str2, z7);
                boolean z8 = VN.VS;
                if (a2 != null) {
                    a2.num++;
                    if (z) {
                        a2.time += j;
                        a2.lh += j2;
                        VN.VS = true;
                        if (z4) {
                            a2.VJ++;
                        }
                        VM = 0;
                    } else {
                        if (com.baidu.adp.lib.util.i.fq()) {
                            int i2 = VM + 1;
                            VM = i2;
                            if (i2 >= com.baidu.adp.lib.stats.switchs.a.eI().getMaxAlertCount("alert_img", 5)) {
                                com.baidu.adp.lib.stats.a.dN().p("alert_img", "imgFailedCnt_" + String.valueOf(VM) + "_url=" + str2);
                            }
                        }
                        a2.VI++;
                        VN.VS = false;
                    }
                }
                int tp = VN.tp();
                if (tp > 100 || (tp > 0 && z8 != VN.VS)) {
                    ti();
                }
            }
            if (z && z5) {
                if (!fr || j >= com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().KT) {
                    if (fr || !com.baidu.adp.lib.util.i.fv() || j >= com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().KV) {
                        if (!fr && j < com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().KU) {
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
                dVar = dG();
            }
            if (TextUtils.isEmpty(str6)) {
                str6 = w.ts().tt();
            }
            if (!gh || !TextUtils.isEmpty("")) {
                str4 = "";
            } else {
                str4 = w.ts().dm(str);
            }
            if (!TextUtils.isEmpty("")) {
                str5 = "";
            } else {
                str5 = tk();
            }
            dVar.q("url", str);
            dVar.q("act", "dl");
            dVar.q("result", z ? "1" : "0");
            dVar.q("fullurl", str2);
            dVar.q("netlib", String.valueOf(eVar.ls));
            dVar.q("costTime", String.valueOf(j));
            dVar.q("connTime", String.valueOf(eVar.li));
            dVar.q("rspTime", String.valueOf(eVar.lj));
            dVar.q("retry", String.valueOf(eVar.lk));
            dVar.q("localIp", e.getIp());
            dVar.q("tiebaIp", str6);
            dVar.q("cdnIp", str4);
            dVar.q("useIp", eVar.lq);
            dVar.q("dnsIp", str5);
            if (eVar.li > 1500 || eVar.li < 0) {
                dVar.q("connBaidu", String.valueOf(tl()));
            }
            dVar.q("memory", tm());
            dVar.q("task", tn());
            dVar.q("isWifi", fr ? "1" : "0");
            dVar.q("status", String.valueOf(eVar.lp));
            dVar.q("up", String.valueOf(eVar.lg));
            dVar.q("down", String.valueOf(eVar.lh));
            dVar.q("isCDN", gh ? "1" : "0");
            dVar.q("isWebp", bool.booleanValue() ? "1" : "0");
            dVar.q("isMobileProxy", z3 ? "1" : "0");
            dVar.q("exception", eVar.ln);
            dVar.q("reason", str3);
            if (i != 0) {
                dVar.b("procType", Integer.valueOf(i));
            }
            com.baidu.adp.lib.stats.a.dN().b("img", dVar);
            if (gh && !TextUtils.isEmpty(str6) && TextUtils.isEmpty(str4) && !z) {
                VN.VR++;
            }
        }
    }

    public static void ti() {
        if (VN.tp() > 10) {
            if (VN.to() > 0) {
                a(VN.VT, VN.VU, VN.VV, VN.VX, VN.VW, 10000);
                com.baidu.tbadk.performanceLog.x.b(VN.VT, VN.VU, VN.VV, VN.VX, VN.VW, 3);
            }
            if (VN.tr() > 0) {
                a(VN.Wd, VN.We, VN.Wf, VN.Wh, VN.Wg, 100002);
                com.baidu.tbadk.performanceLog.x.b(VN.Wd, VN.We, VN.Wf, VN.Wh, VN.Wg, 2);
            }
            if (VN.tq() > 0) {
                a(VN.VY, VN.VZ, VN.Wa, VN.Wc, VN.Wb, 100001);
                com.baidu.tbadk.performanceLog.x.b(VN.VY, VN.VZ, VN.Wa, VN.Wc, VN.Wb, 1);
            }
            VN.reset();
        }
    }

    public static void a(u uVar, u uVar2, u uVar3, u uVar4, u uVar5, int i) {
        if (uVar != null && uVar2 != null && uVar3 != null && uVar4 != null && uVar5 != null) {
            String str = "";
            String str2 = "";
            String str3 = "";
            if (TextUtils.isEmpty("")) {
                str = w.ts().tt();
            }
            if (VQ != null && TextUtils.isEmpty("")) {
                str2 = w.ts().dm(VQ);
            }
            if (TextUtils.isEmpty("")) {
                str3 = tk();
            }
            com.baidu.adp.lib.stats.d dG = dG();
            dG.q("act", "dlStat");
            dG.q("cdnCostTime", String.valueOf(uVar.time));
            dG.q("cdnNum", String.valueOf(uVar.num));
            dG.q("cdnFailnum", String.valueOf(uVar.VI));
            dG.q("portraitCostTime", String.valueOf(uVar2.time));
            dG.q("portraitNum", String.valueOf(uVar2.num));
            dG.q("portraitFailnum", String.valueOf(uVar2.VI));
            dG.q("tiebaCostTime", String.valueOf(uVar3.time));
            dG.q("tiebaNum", String.valueOf(uVar3.num));
            dG.q("tiebaFailnum", String.valueOf(uVar3.VI));
            dG.q("otherCostTime", String.valueOf(uVar5.time));
            dG.q("otherNum", String.valueOf(uVar5.num));
            dG.q("otherFailnum", String.valueOf(uVar5.VI));
            dG.q("directIpCostTime", String.valueOf(uVar4.time));
            dG.q("directIpNum", String.valueOf(uVar4.num));
            dG.q("directIpFailnum", String.valueOf(uVar4.VI));
            dG.q("dnsFailNum", String.valueOf(VN.VR));
            if (10000 == i) {
                dG.q("isWifi", "1");
                dG.q("netType", "WIFI");
            } else if (100002 == i) {
                dG.q("netType", "3G");
                dG.q("isWifi", "0");
            } else {
                dG.q("netType", "2G");
                dG.q("isWifi", "0");
            }
            dG.q("localIp", e.getIp());
            dG.q("tbIp", str);
            dG.q("cdnIp", str2);
            dG.q("dnsIp", str3);
            com.baidu.adp.lib.stats.a.dN().b("img", dG);
        }
    }

    public static void a(com.baidu.adp.lib.stats.d dVar, String str, String str2, boolean z, boolean z2, boolean z3, int i, String str3, long j, String str4) {
        if (com.baidu.adp.lib.util.k.fH()) {
            synchronized (mp) {
                VP.num++;
                if (z) {
                    VP.time += j;
                } else {
                    VP.VI++;
                }
                if (VP.num >= 100) {
                    tj();
                }
            }
            if (!z) {
                if (dVar == null) {
                    dVar = dG();
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
                com.baidu.adp.lib.stats.a.dN().b("img", dVar);
            }
        }
    }

    public static void tj() {
        if (VP.num > 10) {
            com.baidu.adp.lib.stats.d dG = dG();
            dG.q("act", "dcStat");
            dG.q("costTime", String.valueOf(VP.time));
            dG.q("num", String.valueOf(VP.num));
            dG.q("failnum", String.valueOf(VP.VI));
            com.baidu.adp.lib.stats.a.dN().b("img", dG);
            com.baidu.tbadk.performanceLog.x.a(VP.num, VP.VI, VP.time);
            VP.reset();
        }
    }

    public static void dl(String str) {
        com.baidu.adp.lib.stats.d dG = dG();
        dG.q("act", "assistant");
        dG.q(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, str);
        com.baidu.adp.lib.stats.a.dN().b("img", dG);
    }

    private static String tk() {
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [593=4] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static long tl() {
        HttpURLConnection httpURLConnection;
        long j;
        if (VK >= 3) {
            return VL;
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
            if (VK > -1) {
                VL = ((VL * VK) + j) / (VK + 1);
            } else {
                VL = j;
            }
            VK++;
            return j;
        }
        return j;
    }

    private static String tm() {
        return com.baidu.tbadk.imageManager.c.CI().ck();
    }

    private static String tn() {
        return com.baidu.adp.lib.asyncTask.c.cl().ck();
    }

    public static void a(boolean z, boolean z2, String str, String str2) {
        com.baidu.adp.lib.stats.d dG = dG();
        dG.q("act", "getCDNList");
        dG.q("errorNum", str);
        dG.q("errorMsg", str2);
        dG.q("isShortNetError", z2 ? "1" : "0");
        dG.q("isSuccess", z ? "1" : "0");
        com.baidu.adp.lib.stats.a.dN().b("img", dG);
    }

    public static void a(boolean z, String str, String str2, String str3, String str4, String str5, long j, boolean z2) {
        String str6 = "";
        if (str != null) {
            str6 = w.ts().dm(str);
        }
        String tk = tk();
        String ip = e.getIp();
        com.baidu.adp.lib.stats.d dG = dG();
        dG.q("act", "tachometerCDN");
        dG.q("errorNum", str3);
        dG.q("execption", str4);
        dG.q("size", str5);
        dG.q("isScuess", z ? "1" : "0");
        dG.q("url", str);
        dG.q("localIp", ip);
        dG.q("cdnIp", str6);
        dG.q("dnsIP", tk);
        dG.q("usedIp", str2);
        dG.q("isUsedIp", z2 ? "0" : "1");
        dG.q("costTime", String.valueOf(j));
        com.baidu.adp.lib.stats.a.dN().b("img", dG);
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
                    com.baidu.adp.lib.stats.d dG = dG();
                    dG.q("act", "mobileTachometerCDN");
                    dG.q("costTime", String.valueOf(j));
                    dG.q("ipList", sb.toString());
                    com.baidu.adp.lib.stats.a.dN().b("img", dG);
                    return;
                }
            }
        }
    }

    public static void d(boolean z, String str) {
        com.baidu.adp.lib.stats.d dG = dG();
        dG.q("act", "getCDNList");
        dG.q("isSuccess", z ? "1" : "0");
        dG.q("errorMsg", str);
        com.baidu.adp.lib.stats.a.dN().b("img", dG);
    }

    public static void a(String str, int i, int i2, int i3) {
        if (i == -1) {
            i = 0;
        }
        if (i2 == -1) {
            i2 = 0;
        }
        com.baidu.adp.lib.stats.a.dN().eventStat(null, str, "imgHttpSwitch", 1, "1sterrcode", String.valueOf(i), "2nderrcode", String.valueOf(i2), "2imgFailed", String.valueOf(i3));
    }
}
