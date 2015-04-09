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
    private static long Tq = 0;
    private static long Tr = 0;
    private static u Ts = new u(null);
    private static v Tt = new v(null);
    private static v Tu = new v(null);
    private static String Tv = null;
    private static Object wN = new Object();

    private static v a(boolean z, boolean z2, String str, boolean z3) {
        if (z) {
            if (z2 && !z3) {
                return Ts.Ty;
            }
            if (str.startsWith("http://tb.himg")) {
                return Ts.Tz;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return Ts.TA;
            }
            if (z2 && z3) {
                return Ts.TC;
            }
            return Ts.TB;
        } else if (com.baidu.adp.lib.network.willdelete.h.hx()) {
            if (z2) {
                return Ts.TD;
            }
            if (str.startsWith("http://tb.himg")) {
                return Ts.TE;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return Ts.TF;
            }
            return Ts.TG;
        } else if (z2) {
            return Ts.TI;
        } else {
            if (str.startsWith("http://tb.himg")) {
                return Ts.TJ;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return Ts.TK;
            }
            return Ts.TL;
        }
    }

    public static com.baidu.adp.lib.stats.q hC() {
        return com.baidu.adp.lib.stats.f.hP().ar("dbg");
    }

    public static void a(com.baidu.adp.lib.stats.q qVar, String str, boolean z, long j, boolean z2) {
        if (z && z2) {
            synchronized (wN) {
                Tt.num++;
                Tt.time += j;
                if (Tt.num >= 100) {
                    rS();
                }
            }
        }
    }

    public static void rS() {
        if (Tt.num > 10) {
            com.baidu.adp.lib.stats.q hC = hC();
            hC.r("act", "locStat");
            hC.r("costTime", String.valueOf(Tt.time));
            hC.r("num", String.valueOf(Tt.num));
            hC.r("isWifi", "1");
            com.baidu.adp.lib.stats.f.hP().a("img", hC);
            Tt.reset();
        }
    }

    public static void a(com.baidu.adp.lib.stats.q qVar, String str, boolean z, String str2, boolean z2, Boolean bool, com.baidu.adp.lib.network.http.d dVar, String str3, long j, boolean z3, long j2) {
        boolean z4;
        String str4;
        String str5;
        if (com.baidu.adp.lib.util.n.isNetOk()) {
            String str6 = "";
            boolean eK = com.baidu.tbadk.util.g.eK(str2);
            boolean z5 = false;
            if (com.baidu.tbadk.core.util.httpNet.e.getInstance() != null) {
                z5 = true;
                if (!com.baidu.tbadk.core.util.httpNet.e.getInstance().Wd) {
                    com.baidu.tbadk.core.util.httpNet.e.getInstance().init();
                }
            }
            boolean iI = com.baidu.adp.lib.util.k.iI();
            if (!z5) {
                z4 = false;
            } else if (iI) {
                z4 = j > ((long) com.baidu.tbadk.core.util.httpNet.e.getInstance().getCDNImageTimeData().NE);
            } else if (com.baidu.adp.lib.network.willdelete.h.hx()) {
                z4 = j > ((long) com.baidu.tbadk.core.util.httpNet.e.getInstance().getCDNImageTimeData().NG);
            } else {
                z4 = j > ((long) com.baidu.tbadk.core.util.httpNet.e.getInstance().getCDNImageTimeData().NF);
            }
            boolean z6 = false;
            if (eK && z5) {
                z6 = com.baidu.tbadk.core.util.httpNet.e.getInstance().isShouldCDNFallBack();
            }
            if (eK && iI && z6) {
                if (z) {
                    r.getInstance().insertNormalData(j, str);
                } else {
                    str6 = w.sh().si();
                    if (!TextUtils.isEmpty(str6)) {
                        r.getInstance().insertErrorData(dVar.vM, str);
                    }
                }
            }
            if (eK) {
                Tv = str;
            }
            boolean z7 = false;
            if (dVar.vO != null && dVar.vO.length() > 0) {
                z7 = true;
            }
            synchronized (wN) {
                v a = a(iI, eK, str2, z7);
                boolean z8 = Ts.Tx;
                if (a != null) {
                    a.num++;
                    if (z) {
                        a.time += j;
                        a.TO += j2;
                        Ts.Tx = true;
                        if (z4) {
                            a.TP++;
                        }
                    } else {
                        a.TN++;
                        Ts.Tx = false;
                    }
                }
                int sb = Ts.sb();
                if (sb > 100 || (sb > 0 && z8 != Ts.Tx)) {
                    rT();
                }
            }
            if (z && z5) {
                if (!iI || j >= com.baidu.tbadk.core.util.httpNet.e.getInstance().getCDNImageTimeData().NE) {
                    if (iI || !com.baidu.adp.lib.network.willdelete.h.hx() || j >= com.baidu.tbadk.core.util.httpNet.e.getInstance().getCDNImageTimeData().NG) {
                        if (!iI && j < com.baidu.tbadk.core.util.httpNet.e.getInstance().getCDNImageTimeData().NF) {
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
            if (!eK || !TextUtils.isEmpty("")) {
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
            qVar.r("isCDN", eK ? "1" : GameInfoData.NOT_FROM_DETAIL);
            qVar.r("isWebp", bool.booleanValue() ? "1" : GameInfoData.NOT_FROM_DETAIL);
            qVar.r("isMobileProxy", z3 ? "1" : GameInfoData.NOT_FROM_DETAIL);
            qVar.r("exception", dVar.vL);
            qVar.r("reason", str3);
            com.baidu.adp.lib.stats.f.hP().a("img", qVar);
            if (eK && !TextUtils.isEmpty(str6) && TextUtils.isEmpty(str4) && !z) {
                Ts.Tw++;
            }
        }
    }

    public static void rT() {
        if (Ts.sb() > 10) {
            if (Ts.sa() > 0) {
                a(Ts.Ty, Ts.Tz, Ts.TA, Ts.TC, Ts.TB, 10000);
            }
            if (Ts.sd() > 0) {
                a(Ts.TI, Ts.TJ, Ts.TK, Ts.TM, Ts.TL, SapiErrorCode.ANTIIF_COMMUNICATE_ERROR);
            }
            if (Ts.sc() > 0) {
                a(Ts.TD, Ts.TE, Ts.TF, Ts.TH, Ts.TG, SapiErrorCode.DB_GATE_COMMUNICATION_ERROR);
            }
            Ts.se();
            Ts.sf();
            Ts.sg();
            Ts.reset();
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
            if (Tv != null && TextUtils.isEmpty("")) {
                str2 = w.sh().cB(Tv);
            }
            if (TextUtils.isEmpty("")) {
                str3 = rV();
            }
            com.baidu.adp.lib.stats.q hC = hC();
            hC.r("act", "dlStat");
            hC.r("cdnCostTime", String.valueOf(vVar.time));
            hC.r("cdnNum", String.valueOf(vVar.num));
            hC.r("cdnFailnum", String.valueOf(vVar.TN));
            hC.r("portraitCostTime", String.valueOf(vVar2.time));
            hC.r("portraitNum", String.valueOf(vVar2.num));
            hC.r("portraitFailnum", String.valueOf(vVar2.TN));
            hC.r("tiebaCostTime", String.valueOf(vVar3.time));
            hC.r("tiebaNum", String.valueOf(vVar3.num));
            hC.r("tiebaFailnum", String.valueOf(vVar3.TN));
            hC.r("otherCostTime", String.valueOf(vVar5.time));
            hC.r("otherNum", String.valueOf(vVar5.num));
            hC.r("otherFailnum", String.valueOf(vVar5.TN));
            hC.r("directIpCostTime", String.valueOf(vVar4.time));
            hC.r("directIpNum", String.valueOf(vVar4.num));
            hC.r("directIpFailnum", String.valueOf(vVar4.TN));
            hC.r("dnsFailNum", String.valueOf(Ts.Tw));
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
                Tu.num++;
                if (z) {
                    Tu.time += j;
                } else {
                    Tu.TN++;
                }
                if (Tu.num >= 100) {
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
        if (Tu.num > 10) {
            com.baidu.adp.lib.stats.q hC = hC();
            hC.r("act", "dcStat");
            hC.r("costTime", String.valueOf(Tu.time));
            hC.r("num", String.valueOf(Tu.num));
            hC.r("failnum", String.valueOf(Tu.TN));
            com.baidu.adp.lib.stats.f.hP().a("img", hC);
            com.baidu.tbadk.performanceLog.ae.a(Tu.num, Tu.TN, Tu.time);
            Tu.reset();
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
        if (Tq >= 3) {
            return Tr;
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
            if (Tq > -1) {
                Tr = ((Tr * Tq) + j) / (Tq + 1);
            } else {
                Tr = j;
            }
            Tq++;
            return j;
        }
        return j;
    }

    private static String rX() {
        return com.baidu.tbadk.imageManager.e.zy().fQ();
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
