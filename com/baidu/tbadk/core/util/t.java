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
    private static long TZ = 0;
    private static long Ua = 0;
    private static u Ub = new u(null);
    private static v Uc = new v(null);
    private static v Ud = new v(null);
    private static String Ue = null;
    private static Object vR = new Object();

    private static v a(boolean z, boolean z2, String str, boolean z3) {
        if (z) {
            if (z2 && !z3) {
                return Ub.Uh;
            }
            if (str.startsWith("http://tb.himg")) {
                return Ub.Ui;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return Ub.Uj;
            }
            if (z2 && z3) {
                return Ub.Ul;
            }
            return Ub.Uk;
        } else if (com.baidu.adp.lib.network.a.b.hi()) {
            if (z2) {
                return Ub.Um;
            }
            if (str.startsWith("http://tb.himg")) {
                return Ub.Un;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return Ub.Uo;
            }
            return Ub.Up;
        } else if (z2) {
            return Ub.Ur;
        } else {
            if (str.startsWith("http://tb.himg")) {
                return Ub.Us;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return Ub.Ut;
            }
            return Ub.Uu;
        }
    }

    public static com.baidu.adp.lib.stats.q hm() {
        return com.baidu.adp.lib.stats.f.hz().as("dbg");
    }

    public static void a(com.baidu.adp.lib.stats.q qVar, String str, boolean z, long j, boolean z2) {
        if (z && z2) {
            synchronized (vR) {
                Uc.num++;
                Uc.time += j;
                if (Uc.num >= 100) {
                    sA();
                }
            }
        }
    }

    public static void sA() {
        if (Uc.num > 10) {
            com.baidu.adp.lib.stats.q hm = hm();
            hm.r("act", "locStat");
            hm.r("costTime", String.valueOf(Uc.time));
            hm.r("num", String.valueOf(Uc.num));
            hm.r("isWifi", "1");
            com.baidu.adp.lib.stats.f.hz().a("img", hm);
            Uc.reset();
        }
    }

    public static void a(com.baidu.adp.lib.stats.q qVar, String str, boolean z, String str2, boolean z2, Boolean bool, com.baidu.adp.lib.network.http.d dVar, String str3, long j, boolean z3, long j2) {
        boolean z4;
        String str4;
        String str5;
        if (com.baidu.adp.lib.util.n.isNetOk()) {
            String str6 = "";
            boolean ff = com.baidu.tbadk.util.g.ff(str2);
            boolean z5 = false;
            if (com.baidu.tbadk.core.util.httpNet.e.getInstance() != null) {
                z5 = true;
                if (!com.baidu.tbadk.core.util.httpNet.e.getInstance().WL) {
                    com.baidu.tbadk.core.util.httpNet.e.getInstance().init();
                }
            }
            boolean iY = com.baidu.adp.lib.util.k.iY();
            if (!z5) {
                z4 = false;
            } else if (iY) {
                z4 = j > ((long) com.baidu.tbadk.core.util.httpNet.e.getInstance().getCDNImageTimeData().NW);
            } else if (com.baidu.adp.lib.network.a.b.hi()) {
                z4 = j > ((long) com.baidu.tbadk.core.util.httpNet.e.getInstance().getCDNImageTimeData().NY);
            } else {
                z4 = j > ((long) com.baidu.tbadk.core.util.httpNet.e.getInstance().getCDNImageTimeData().NX);
            }
            boolean z6 = false;
            if (ff && z5) {
                z6 = com.baidu.tbadk.core.util.httpNet.e.getInstance().isShouldCDNFallBack();
            }
            if (ff && iY && z6) {
                if (z) {
                    r.getInstance().insertNormalData(j, str);
                } else {
                    str6 = w.sP().sQ();
                    if (!TextUtils.isEmpty(str6)) {
                        r.getInstance().insertErrorData(dVar.uY, str);
                    }
                }
            }
            if (ff) {
                Ue = str;
            }
            boolean z7 = false;
            if (dVar.va != null && dVar.va.length() > 0) {
                z7 = true;
            }
            synchronized (vR) {
                v a = a(iY, ff, str2, z7);
                boolean z8 = Ub.Ug;
                if (a != null) {
                    a.num++;
                    if (z) {
                        a.time += j;
                        a.Ux += j2;
                        Ub.Ug = true;
                        if (z4) {
                            a.Uy++;
                        }
                    } else {
                        a.Uw++;
                        Ub.Ug = false;
                    }
                }
                int sJ = Ub.sJ();
                if (sJ > 100 || (sJ > 0 && z8 != Ub.Ug)) {
                    sB();
                }
            }
            if (z && z5) {
                if (!iY || j >= com.baidu.tbadk.core.util.httpNet.e.getInstance().getCDNImageTimeData().NW) {
                    if (iY || !com.baidu.adp.lib.network.a.b.hi() || j >= com.baidu.tbadk.core.util.httpNet.e.getInstance().getCDNImageTimeData().NY) {
                        if (!iY && j < com.baidu.tbadk.core.util.httpNet.e.getInstance().getCDNImageTimeData().NX) {
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
                qVar = hm();
            }
            if (TextUtils.isEmpty(str6)) {
                str6 = w.sP().sQ();
            }
            if (!ff || !TextUtils.isEmpty("")) {
                str4 = "";
            } else {
                str4 = w.sP().cQ(str);
            }
            if (!TextUtils.isEmpty("")) {
                str5 = "";
            } else {
                str5 = sD();
            }
            qVar.r(ImageViewerConfig.URL, str);
            qVar.r("act", "dl");
            qVar.r("result", z ? GameInfoData.NOT_FROM_DETAIL : "1");
            qVar.r("fullurl", str2);
            qVar.r("costTime", String.valueOf(j));
            qVar.r("connTime", String.valueOf(dVar.uS));
            qVar.r("rspTime", String.valueOf(dVar.uT));
            qVar.r("retry", String.valueOf(dVar.uU));
            qVar.r("localIp", f.getIp());
            qVar.r("tiebaIp", str6);
            qVar.r("cdnIp", str4);
            qVar.r("useIp", dVar.va);
            qVar.r("dnsIp", str5);
            if (dVar.uS > 1500 || dVar.uS < 0) {
                qVar.r("connBaidu", String.valueOf(sE()));
            }
            qVar.r("memory", sF());
            qVar.r("task", sG());
            qVar.r("isWifi", iY ? "1" : GameInfoData.NOT_FROM_DETAIL);
            qVar.r("status", String.valueOf(dVar.uZ));
            qVar.r("up", String.valueOf(dVar.uQ));
            qVar.r("down", String.valueOf(dVar.uR));
            qVar.r("isCDN", ff ? "1" : GameInfoData.NOT_FROM_DETAIL);
            qVar.r("isWebp", bool.booleanValue() ? "1" : GameInfoData.NOT_FROM_DETAIL);
            qVar.r("isMobileProxy", z3 ? "1" : GameInfoData.NOT_FROM_DETAIL);
            qVar.r("exception", dVar.uX);
            qVar.r("reason", str3);
            com.baidu.adp.lib.stats.f.hz().a("img", qVar);
            if (ff && !TextUtils.isEmpty(str6) && TextUtils.isEmpty(str4) && !z) {
                Ub.Uf++;
            }
        }
    }

    public static void sB() {
        if (Ub.sJ() > 10) {
            if (Ub.sI() > 0) {
                a(Ub.Uh, Ub.Ui, Ub.Uj, Ub.Ul, Ub.Uk, 10000);
            }
            if (Ub.sL() > 0) {
                a(Ub.Ur, Ub.Us, Ub.Ut, Ub.Uv, Ub.Uu, SapiErrorCode.ANTIIF_COMMUNICATE_ERROR);
            }
            if (Ub.sK() > 0) {
                a(Ub.Um, Ub.Un, Ub.Uo, Ub.Uq, Ub.Up, SapiErrorCode.DB_GATE_COMMUNICATION_ERROR);
            }
            Ub.sM();
            Ub.sN();
            Ub.sO();
            Ub.reset();
        }
    }

    public static void a(v vVar, v vVar2, v vVar3, v vVar4, v vVar5, int i) {
        if (vVar != null && vVar2 != null && vVar3 != null && vVar4 != null && vVar5 != null) {
            String str = "";
            String str2 = "";
            String str3 = "";
            if (TextUtils.isEmpty("")) {
                str = w.sP().sQ();
            }
            if (Ue != null && TextUtils.isEmpty("")) {
                str2 = w.sP().cQ(Ue);
            }
            if (TextUtils.isEmpty("")) {
                str3 = sD();
            }
            com.baidu.adp.lib.stats.q hm = hm();
            hm.r("act", "dlStat");
            hm.r("cdnCostTime", String.valueOf(vVar.time));
            hm.r("cdnNum", String.valueOf(vVar.num));
            hm.r("cdnFailnum", String.valueOf(vVar.Uw));
            hm.r("portraitCostTime", String.valueOf(vVar2.time));
            hm.r("portraitNum", String.valueOf(vVar2.num));
            hm.r("portraitFailnum", String.valueOf(vVar2.Uw));
            hm.r("tiebaCostTime", String.valueOf(vVar3.time));
            hm.r("tiebaNum", String.valueOf(vVar3.num));
            hm.r("tiebaFailnum", String.valueOf(vVar3.Uw));
            hm.r("otherCostTime", String.valueOf(vVar5.time));
            hm.r("otherNum", String.valueOf(vVar5.num));
            hm.r("otherFailnum", String.valueOf(vVar5.Uw));
            hm.r("directIpCostTime", String.valueOf(vVar4.time));
            hm.r("directIpNum", String.valueOf(vVar4.num));
            hm.r("directIpFailnum", String.valueOf(vVar4.Uw));
            hm.r("dnsFailNum", String.valueOf(Ub.Uf));
            if (10000 == i) {
                hm.r("isWifi", "1");
                hm.r("netType", NetworkChangeReceiver.WIFI_STRING);
            } else if (100002 == i) {
                hm.r("netType", "3G");
                hm.r("isWifi", GameInfoData.NOT_FROM_DETAIL);
            } else {
                hm.r("netType", "2G");
                hm.r("isWifi", GameInfoData.NOT_FROM_DETAIL);
            }
            hm.r("localIp", f.getIp());
            hm.r("tbIp", str);
            hm.r("cdnIp", str2);
            hm.r("dnsIp", str3);
            com.baidu.adp.lib.stats.f.hz().a("img", hm);
        }
    }

    public static void a(com.baidu.adp.lib.stats.q qVar, String str, String str2, boolean z, boolean z2, boolean z3, int i, String str3, long j, String str4) {
        if (com.baidu.adp.lib.util.n.isNetOk()) {
            synchronized (vR) {
                Ud.num++;
                if (z) {
                    Ud.time += j;
                } else {
                    Ud.Uw++;
                }
                if (Ud.num >= 100) {
                    sC();
                }
            }
            if (!z) {
                if (qVar == null) {
                    qVar = hm();
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
                com.baidu.adp.lib.stats.f.hz().a("img", qVar);
            }
        }
    }

    public static void sC() {
        if (Ud.num > 10) {
            com.baidu.adp.lib.stats.q hm = hm();
            hm.r("act", "dcStat");
            hm.r("costTime", String.valueOf(Ud.time));
            hm.r("num", String.valueOf(Ud.num));
            hm.r("failnum", String.valueOf(Ud.Uw));
            com.baidu.adp.lib.stats.f.hz().a("img", hm);
            com.baidu.tbadk.performanceLog.ae.a(Ud.num, Ud.Uw, Ud.time);
            Ud.reset();
        }
    }

    public static void cP(String str) {
        com.baidu.adp.lib.stats.q hm = hm();
        hm.r("act", "assistant");
        hm.r(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, str);
        com.baidu.adp.lib.stats.f.hz().a("img", hm);
    }

    private static String sD() {
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
    private static long sE() {
        HttpURLConnection httpURLConnection;
        long j;
        if (TZ >= 3) {
            return Ua;
        }
        long currentTimeMillis = System.currentTimeMillis();
        HttpURLConnection httpURLConnection2 = null;
        try {
            httpURLConnection = (HttpURLConnection) new URL("http://www.baidu.com/").openConnection();
            try {
                httpURLConnection.setConnectTimeout(2500);
                httpURLConnection.connect();
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.g.a.e(httpURLConnection);
                j = currentTimeMillis2;
            } catch (SocketTimeoutException e) {
                com.baidu.adp.lib.g.a.e(httpURLConnection);
                j = 2500;
                if (j > 0) {
                }
            } catch (Exception e2) {
                httpURLConnection2 = httpURLConnection;
                com.baidu.adp.lib.g.a.e(httpURLConnection2);
                j = -1;
                if (j > 0) {
                }
            } catch (Throwable th) {
                httpURLConnection2 = httpURLConnection;
                th = th;
                com.baidu.adp.lib.g.a.e(httpURLConnection2);
                throw th;
            }
        } catch (SocketTimeoutException e3) {
            httpURLConnection = null;
        } catch (Exception e4) {
        } catch (Throwable th2) {
            th = th2;
        }
        if (j > 0) {
            if (TZ > -1) {
                Ua = ((Ua * TZ) + j) / (TZ + 1);
            } else {
                Ua = j;
            }
            TZ++;
            return j;
        }
        return j;
    }

    private static String sF() {
        return com.baidu.tbadk.imageManager.e.Am().fV();
    }

    private static String sG() {
        return com.baidu.adp.lib.asyncTask.f.fW().fV();
    }

    public static void a(boolean z, boolean z2, String str, String str2) {
        com.baidu.adp.lib.stats.q hm = hm();
        hm.r("act", "getCDNList");
        hm.r("errorNum", str);
        hm.r("errorMsg", str2);
        hm.r("isShortNetError", z2 ? "1" : GameInfoData.NOT_FROM_DETAIL);
        hm.r("isSuccess", z ? "1" : GameInfoData.NOT_FROM_DETAIL);
        com.baidu.adp.lib.stats.f.hz().a("img", hm);
    }

    public static void a(boolean z, String str, String str2, String str3, String str4, String str5, long j, boolean z2) {
        String str6 = "";
        if (str != null) {
            str6 = w.sP().cQ(str);
        }
        String sD = sD();
        String ip = f.getIp();
        com.baidu.adp.lib.stats.q hm = hm();
        hm.r("act", "tachometerCDN");
        hm.r("errorNum", str3);
        hm.r("execption", str4);
        hm.r("size", str5);
        hm.r("isScuess", z ? "1" : GameInfoData.NOT_FROM_DETAIL);
        hm.r(ImageViewerConfig.URL, str);
        hm.r("localIp", ip);
        hm.r("cdnIp", str6);
        hm.r("dnsIP", sD);
        hm.r("usedIp", str2);
        hm.r("isUsedIp", z2 ? GameInfoData.NOT_FROM_DETAIL : "1");
        hm.r("costTime", String.valueOf(j));
        com.baidu.adp.lib.stats.f.hz().a("img", hm);
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
                    com.baidu.adp.lib.stats.q hm = hm();
                    hm.r("act", "mobileTachometerCDN");
                    hm.r("costTime", String.valueOf(j));
                    hm.r("ipList", sb.toString());
                    com.baidu.adp.lib.stats.f.hz().a("img", hm);
                    return;
                }
            }
        }
    }

    public static void d(boolean z, String str) {
        com.baidu.adp.lib.stats.q hm = hm();
        hm.r("act", "getCDNList");
        hm.r("isSuccess", z ? "1" : GameInfoData.NOT_FROM_DETAIL);
        hm.r("errorMsg", str);
        com.baidu.adp.lib.stats.f.hz().a("img", hm);
    }
}
