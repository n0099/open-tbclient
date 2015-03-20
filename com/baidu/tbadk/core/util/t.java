package com.baidu.tbadk.core.util;

import android.net.DhcpInfo;
import android.net.wifi.WifiManager;
import android.support.v4.view.MotionEventCompat;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.sapi2.shell.SapiErrorCode;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.service.NetworkChangeReceiver;
import com.baidu.tbadk.game.GameInfoData;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class t {
    private static long To = 0;
    private static long Tp = 0;
    private static u Tq = new u(null);
    private static v Tr = new v(null);
    private static v Ts = new v(null);
    private static String Tt = null;
    private static Object wN = new Object();

    private static v a(boolean z, boolean z2, String str, boolean z3) {
        if (z) {
            if (z2 && !z3) {
                return Tq.Tw;
            }
            if (str.startsWith("http://tb.himg")) {
                return Tq.Tx;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return Tq.Ty;
            }
            if (z2 && z3) {
                return Tq.TA;
            }
            return Tq.Tz;
        } else if (com.baidu.adp.lib.network.willdelete.h.hx()) {
            if (z2) {
                return Tq.TB;
            }
            if (str.startsWith("http://tb.himg")) {
                return Tq.TC;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return Tq.TD;
            }
            return Tq.TE;
        } else if (z2) {
            return Tq.TG;
        } else {
            if (str.startsWith("http://tb.himg")) {
                return Tq.TH;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return Tq.TI;
            }
            return Tq.TJ;
        }
    }

    public static com.baidu.adp.lib.stats.q hC() {
        return com.baidu.adp.lib.stats.f.hP().ar("dbg");
    }

    public static void a(com.baidu.adp.lib.stats.q qVar, String str, boolean z, long j, boolean z2) {
        if (z && z2) {
            synchronized (wN) {
                Tr.num++;
                Tr.time += j;
                if (Tr.num >= 100) {
                    rS();
                }
            }
        }
    }

    public static void rS() {
        if (Tr.num > 10) {
            com.baidu.adp.lib.stats.q hC = hC();
            hC.r("act", "locStat");
            hC.r("costTime", String.valueOf(Tr.time));
            hC.r("num", String.valueOf(Tr.num));
            hC.r("isWifi", "1");
            com.baidu.adp.lib.stats.f.hP().a("img", hC);
            Tr.reset();
        }
    }

    public static void a(com.baidu.adp.lib.stats.q qVar, String str, boolean z, String str2, boolean z2, Boolean bool, com.baidu.adp.lib.network.http.d dVar, String str3, long j, boolean z3, long j2) {
        boolean z4;
        String str4;
        String str5;
        if (com.baidu.adp.lib.util.n.isNetOk()) {
            String str6 = "";
            boolean eH = com.baidu.tbadk.util.g.eH(str2);
            boolean z5 = false;
            if (com.baidu.tbadk.core.util.httpNet.e.getInstance() != null) {
                z5 = true;
                if (!com.baidu.tbadk.core.util.httpNet.e.getInstance().Wb) {
                    com.baidu.tbadk.core.util.httpNet.e.getInstance().init();
                }
            }
            boolean iI = com.baidu.adp.lib.util.k.iI();
            if (!z5) {
                z4 = false;
            } else if (iI) {
                z4 = j > ((long) com.baidu.tbadk.core.util.httpNet.e.getInstance().getCDNImageTimeData().NC);
            } else if (com.baidu.adp.lib.network.willdelete.h.hx()) {
                z4 = j > ((long) com.baidu.tbadk.core.util.httpNet.e.getInstance().getCDNImageTimeData().NE);
            } else {
                z4 = j > ((long) com.baidu.tbadk.core.util.httpNet.e.getInstance().getCDNImageTimeData().ND);
            }
            boolean z6 = false;
            if (eH && z5) {
                z6 = com.baidu.tbadk.core.util.httpNet.e.getInstance().isShouldCDNFallBack();
            }
            if (eH && iI && z6) {
                if (z) {
                    r.getInstance().insertNormalData(j, str);
                } else {
                    str6 = w.sh().si();
                    if (!TextUtils.isEmpty(str6)) {
                        r.getInstance().insertErrorData(dVar.vM, str);
                    }
                }
            }
            if (eH) {
                Tt = str;
            }
            boolean z7 = false;
            if (dVar.vO != null && dVar.vO.length() > 0) {
                z7 = true;
            }
            synchronized (wN) {
                v a = a(iI, eH, str2, z7);
                boolean z8 = Tq.Tv;
                if (a != null) {
                    a.num++;
                    if (z) {
                        a.time += j;
                        a.TM += j2;
                        Tq.Tv = true;
                        if (z4) {
                            a.TN++;
                        }
                    } else {
                        a.TL++;
                        Tq.Tv = false;
                    }
                }
                int sb = Tq.sb();
                if (sb > 100 || (sb > 0 && z8 != Tq.Tv)) {
                    rT();
                }
            }
            if (z && z5) {
                if (!iI || j >= com.baidu.tbadk.core.util.httpNet.e.getInstance().getCDNImageTimeData().NC) {
                    if (iI || !com.baidu.adp.lib.network.willdelete.h.hx() || j >= com.baidu.tbadk.core.util.httpNet.e.getInstance().getCDNImageTimeData().NE) {
                        if (!iI && j < com.baidu.tbadk.core.util.httpNet.e.getInstance().getCDNImageTimeData().ND) {
                            return;
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
            if (qVar == null) {
                qVar = hC();
            }
            if (TextUtils.isEmpty(str6)) {
                str6 = w.sh().si();
            }
            if (!eH || !TextUtils.isEmpty("")) {
                str4 = "";
            } else {
                str4 = w.sh().cB(str);
            }
            if (!TextUtils.isEmpty("")) {
                str5 = "";
            } else {
                str5 = rV();
            }
            qVar.r(ImageViewerConfig.URL, str);
            qVar.r("act", "dl");
            qVar.r("result", z ? GameInfoData.NOT_FROM_DETAIL : "1");
            qVar.r("fullurl", str2);
            qVar.r("costTime", String.valueOf(j));
            qVar.r("connTime", String.valueOf(dVar.vG));
            qVar.r("rspTime", String.valueOf(dVar.vH));
            qVar.r("retry", String.valueOf(dVar.vI));
            qVar.r("localIp", f.getIp());
            qVar.r("tiebaIp", str6);
            qVar.r("cdnIp", str4);
            qVar.r("useIp", dVar.vO);
            qVar.r("dnsIp", str5);
            if (dVar.vG > 1500 || dVar.vG < 0) {
                qVar.r("connBaidu", String.valueOf(rW()));
            }
            qVar.r("memory", rX());
            qVar.r("task", rY());
            qVar.r("isWifi", iI ? "1" : GameInfoData.NOT_FROM_DETAIL);
            qVar.r("status", String.valueOf(dVar.vN));
            qVar.r("up", String.valueOf(dVar.vE));
            qVar.r("down", String.valueOf(dVar.vF));
            qVar.r("isCDN", eH ? "1" : GameInfoData.NOT_FROM_DETAIL);
            qVar.r("isWebp", bool.booleanValue() ? "1" : GameInfoData.NOT_FROM_DETAIL);
            qVar.r("isMobileProxy", z3 ? "1" : GameInfoData.NOT_FROM_DETAIL);
            qVar.r("exception", dVar.vL);
            qVar.r("reason", str3);
            com.baidu.adp.lib.stats.f.hP().a("img", qVar);
            if (eH && !TextUtils.isEmpty(str6) && TextUtils.isEmpty(str4) && !z) {
                Tq.Tu++;
            }
        }
    }

    public static void rT() {
        if (Tq.sb() > 10) {
            if (Tq.sa() > 0) {
                a(Tq.Tw, Tq.Tx, Tq.Ty, Tq.TA, Tq.Tz, 10000);
            }
            if (Tq.sd() > 0) {
                a(Tq.TG, Tq.TH, Tq.TI, Tq.TK, Tq.TJ, SapiErrorCode.ANTIIF_COMMUNICATE_ERROR);
            }
            if (Tq.sc() > 0) {
                a(Tq.TB, Tq.TC, Tq.TD, Tq.TF, Tq.TE, SapiErrorCode.DB_GATE_COMMUNICATION_ERROR);
            }
            Tq.se();
            Tq.sf();
            Tq.sg();
            Tq.reset();
        }
    }

    public static void a(v vVar, v vVar2, v vVar3, v vVar4, v vVar5, int i) {
        if (vVar != null && vVar2 != null && vVar3 != null && vVar4 != null && vVar5 != null) {
            String str = "";
            String str2 = "";
            String str3 = "";
            if (TextUtils.isEmpty("")) {
                str = w.sh().si();
            }
            if (Tt != null && TextUtils.isEmpty("")) {
                str2 = w.sh().cB(Tt);
            }
            if (TextUtils.isEmpty("")) {
                str3 = rV();
            }
            com.baidu.adp.lib.stats.q hC = hC();
            hC.r("act", "dlStat");
            hC.r("cdnCostTime", String.valueOf(vVar.time));
            hC.r("cdnNum", String.valueOf(vVar.num));
            hC.r("cdnFailnum", String.valueOf(vVar.TL));
            hC.r("portraitCostTime", String.valueOf(vVar2.time));
            hC.r("portraitNum", String.valueOf(vVar2.num));
            hC.r("portraitFailnum", String.valueOf(vVar2.TL));
            hC.r("tiebaCostTime", String.valueOf(vVar3.time));
            hC.r("tiebaNum", String.valueOf(vVar3.num));
            hC.r("tiebaFailnum", String.valueOf(vVar3.TL));
            hC.r("otherCostTime", String.valueOf(vVar5.time));
            hC.r("otherNum", String.valueOf(vVar5.num));
            hC.r("otherFailnum", String.valueOf(vVar5.TL));
            hC.r("directIpCostTime", String.valueOf(vVar4.time));
            hC.r("directIpNum", String.valueOf(vVar4.num));
            hC.r("directIpFailnum", String.valueOf(vVar4.TL));
            hC.r("dnsFailNum", String.valueOf(Tq.Tu));
            if (10000 == i) {
                hC.r("isWifi", "1");
                hC.r("netType", NetworkChangeReceiver.WIFI_STRING);
            } else if (100002 == i) {
                hC.r("netType", "3G");
                hC.r("isWifi", GameInfoData.NOT_FROM_DETAIL);
            } else {
                hC.r("netType", "2G");
                hC.r("isWifi", GameInfoData.NOT_FROM_DETAIL);
            }
            hC.r("localIp", f.getIp());
            hC.r("tbIp", str);
            hC.r("cdnIp", str2);
            hC.r("dnsIp", str3);
            com.baidu.adp.lib.stats.f.hP().a("img", hC);
        }
    }

    public static void a(com.baidu.adp.lib.stats.q qVar, String str, String str2, boolean z, boolean z2, boolean z3, int i, String str3, long j, String str4) {
        if (com.baidu.adp.lib.util.n.isNetOk()) {
            synchronized (wN) {
                Ts.num++;
                if (z) {
                    Ts.time += j;
                } else {
                    Ts.TL++;
                }
                if (Ts.num >= 100) {
                    rU();
                }
            }
            if (!z) {
                if (qVar == null) {
                    qVar = hC();
                }
                qVar.r("act", "dc");
                qVar.r("costTime", String.valueOf(j));
                qVar.r(ImageViewerConfig.URL, str);
                qVar.r("fullURL", str2);
                qVar.r("isWebp", z3 ? "1" : GameInfoData.NOT_FROM_DETAIL);
                qVar.r("isCDN", z2 ? "1" : GameInfoData.NOT_FROM_DETAIL);
                qVar.r("length", String.valueOf(i));
                qVar.r("reason", str3);
                qVar.r("result", z ? GameInfoData.NOT_FROM_DETAIL : "1");
                qVar.r("execption", str4);
                com.baidu.adp.lib.stats.f.hP().a("img", qVar);
            }
        }
    }

    public static void rU() {
        if (Ts.num > 10) {
            com.baidu.adp.lib.stats.q hC = hC();
            hC.r("act", "dcStat");
            hC.r("costTime", String.valueOf(Ts.time));
            hC.r("num", String.valueOf(Ts.num));
            hC.r("failnum", String.valueOf(Ts.TL));
            com.baidu.adp.lib.stats.f.hP().a("img", hC);
            com.baidu.tbadk.performanceLog.ae.a(Ts.num, Ts.TL, Ts.time);
            Ts.reset();
        }
    }

    public static void cA(String str) {
        com.baidu.adp.lib.stats.q hC = hC();
        hC.r("act", "assistant");
        hC.r(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, str);
        com.baidu.adp.lib.stats.f.hP().a("img", hC);
    }

    private static String rV() {
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [679=4] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:74:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static long rW() {
        HttpURLConnection httpURLConnection;
        long j;
        if (To >= 3) {
            return Tp;
        }
        long currentTimeMillis = System.currentTimeMillis();
        HttpURLConnection httpURLConnection2 = null;
        try {
            httpURLConnection = (HttpURLConnection) new URL("http://www.baidu.com/").openConnection();
            try {
                httpURLConnection.setConnectTimeout(2500);
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
            if (To > -1) {
                Tp = ((Tp * To) + j) / (To + 1);
            } else {
                Tp = j;
            }
            To++;
            return j;
        }
        return j;
    }

    private static String rX() {
        return com.baidu.tbadk.imageManager.e.zs().fQ();
    }

    private static String rY() {
        return com.baidu.adp.lib.asyncTask.f.fS().fQ();
    }

    public static void a(boolean z, boolean z2, String str, String str2) {
        com.baidu.adp.lib.stats.q hC = hC();
        hC.r("act", "getCDNList");
        hC.r("errorNum", str);
        hC.r("errorMsg", str2);
        hC.r("isShortNetError", z2 ? "1" : GameInfoData.NOT_FROM_DETAIL);
        hC.r("isSuccess", z ? "1" : GameInfoData.NOT_FROM_DETAIL);
        com.baidu.adp.lib.stats.f.hP().a("img", hC);
    }

    public static void a(boolean z, String str, String str2, String str3, String str4, String str5, long j, boolean z2) {
        String str6 = "";
        if (str != null) {
            str6 = w.sh().cB(str);
        }
        String rV = rV();
        String ip = f.getIp();
        com.baidu.adp.lib.stats.q hC = hC();
        hC.r("act", "tachometerCDN");
        hC.r("errorNum", str3);
        hC.r("execption", str4);
        hC.r("size", str5);
        hC.r("isScuess", z ? "1" : GameInfoData.NOT_FROM_DETAIL);
        hC.r(ImageViewerConfig.URL, str);
        hC.r("localIp", ip);
        hC.r("cdnIp", str6);
        hC.r("dnsIP", rV);
        hC.r("usedIp", str2);
        hC.r("isUsedIp", z2 ? GameInfoData.NOT_FROM_DETAIL : "1");
        hC.r("costTime", String.valueOf(j));
        com.baidu.adp.lib.stats.f.hP().a("img", hC);
    }

    public static void b(ArrayList<String> arrayList, long j) {
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
                    com.baidu.adp.lib.stats.q hC = hC();
                    hC.r("act", "mobileTachometerCDN");
                    hC.r("costTime", String.valueOf(j));
                    hC.r("ipList", sb.toString());
                    com.baidu.adp.lib.stats.f.hP().a("img", hC);
                    return;
                }
            }
        }
    }

    public static void d(boolean z, String str) {
        com.baidu.adp.lib.stats.q hC = hC();
        hC.r("act", "getCDNList");
        hC.r("isSuccess", z ? "1" : GameInfoData.NOT_FROM_DETAIL);
        hC.r("errorMsg", str);
        com.baidu.adp.lib.stats.f.hP().a("img", hC);
    }
}
