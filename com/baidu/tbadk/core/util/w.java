package com.baidu.tbadk.core.util;

import android.net.DhcpInfo;
import android.net.wifi.WifiManager;
import android.support.v4.view.MotionEventCompat;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.sapi2.shell.SapiErrorCode;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.service.NetworkChangeReceiver;
import com.baidu.tbadk.core.util.httpNet.CDNIPDirectConnect;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class w {
    private static long HE = 0;
    private static long HF = 0;
    private static x HG = new x(null);
    private static y HH = new y(null);
    private static y HI = new y(null);
    private static String HJ = null;
    private static Object lv = new Object();

    private static y a(boolean z, boolean z2, String str, boolean z3) {
        if (z) {
            if (z2 && !z3) {
                return HG.HM;
            }
            if (str.startsWith("http://tb.himg")) {
                return HG.HN;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return HG.HO;
            }
            if (z2 && z3) {
                return HG.HQ;
            }
            return HG.HP;
        } else if (com.baidu.adp.lib.network.willdelete.h.ea()) {
            if (z2) {
                return HG.HR;
            }
            if (str.startsWith("http://tb.himg")) {
                return HG.HS;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return HG.HT;
            }
            return HG.HU;
        } else if (z2) {
            return HG.HW;
        } else {
            if (str.startsWith("http://tb.himg")) {
                return HG.HX;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return HG.HY;
            }
            return HG.HZ;
        }
    }

    public static com.baidu.adp.lib.stats.q ef() {
        return com.baidu.adp.lib.stats.f.es().ak("dbg");
    }

    public static void a(com.baidu.adp.lib.stats.q qVar, String str, boolean z, long j, boolean z2) {
        if (z && z2) {
            synchronized (lv) {
                HH.num++;
                HH.time += j;
                if (HH.num >= 100) {
                    oz();
                }
            }
        }
    }

    public static void oz() {
        if (HH.num > 10) {
            com.baidu.adp.lib.stats.q ef = ef();
            ef.r("act", "locStat");
            ef.r("costTime", String.valueOf(HH.time));
            ef.r("num", String.valueOf(HH.num));
            ef.r("isWifi", "1");
            com.baidu.adp.lib.stats.f.es().a("img", ef);
            HH.reset();
        }
    }

    public static void a(com.baidu.adp.lib.stats.q qVar, String str, boolean z, String str2, boolean z2, Boolean bool, com.baidu.adp.lib.network.http.d dVar, String str3, long j, boolean z3, long j2) {
        boolean z4;
        String str4;
        String str5;
        if (com.baidu.adp.lib.util.l.isNetOk()) {
            String str6 = "";
            boolean eF = com.baidu.tbadk.util.e.eF(str2);
            boolean fh = com.baidu.adp.lib.util.i.fh();
            if (fh) {
                z4 = j > ((long) CDNIPDirectConnect.pM().JX.BC);
            } else if (com.baidu.adp.lib.network.willdelete.h.ea()) {
                z4 = j > ((long) CDNIPDirectConnect.pM().JX.BE);
            } else {
                z4 = j > ((long) CDNIPDirectConnect.pM().JX.BD);
            }
            boolean z5 = false;
            if (eF) {
                z5 = CDNIPDirectConnect.pM().pQ();
            }
            if (eF && fh && z5) {
                if (z) {
                    e.ol().a(j, str);
                } else {
                    str6 = z.oO().oP();
                    if (!TextUtils.isEmpty(str6)) {
                        e.ol().m(dVar.kt, str);
                    }
                }
            }
            if (eF) {
                HJ = str;
            }
            boolean z6 = false;
            if (dVar.kv != null && dVar.kv.length() > 0) {
                z6 = true;
            }
            synchronized (lv) {
                y a = a(fh, eF, str2, z6);
                boolean z7 = HG.HL;
                if (a != null) {
                    a.num++;
                    if (z) {
                        a.time += j;
                        a.Ic += j2;
                        HG.HL = true;
                        if (z4) {
                            a.Id++;
                        }
                    } else {
                        a.Ib++;
                        HG.HL = false;
                    }
                }
                int oI = HG.oI();
                if (oI > 100 || (oI > 0 && z7 != HG.HL)) {
                    oA();
                }
            }
            if (z) {
                if (!fh || j >= CDNIPDirectConnect.pM().JX.BC) {
                    if (fh || !com.baidu.adp.lib.network.willdelete.h.ea() || j >= CDNIPDirectConnect.pM().JX.BE) {
                        if (!fh && j < CDNIPDirectConnect.pM().JX.BD) {
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
                qVar = ef();
            }
            if (TextUtils.isEmpty(str6)) {
                str6 = z.oO().oP();
            }
            if (!eF || !TextUtils.isEmpty("")) {
                str4 = "";
            } else {
                str4 = z.oO().cx(str);
            }
            if (!TextUtils.isEmpty("")) {
                str5 = "";
            } else {
                str5 = oC();
            }
            qVar.r(ImageViewerConfig.URL, str);
            qVar.r("act", "dl");
            qVar.r("result", z ? "0" : "1");
            qVar.r("fullurl", str2);
            qVar.r("costTime", String.valueOf(j));
            qVar.r("connTime", String.valueOf(dVar.ko));
            qVar.r("rspTime", String.valueOf(dVar.kp));
            qVar.r("retry", String.valueOf(dVar.retry));
            qVar.r("localIp", j.getIp());
            qVar.r("tiebaIp", str6);
            qVar.r("cdnIp", str4);
            qVar.r("useIp", dVar.kv);
            qVar.r("dnsIp", str5);
            if (dVar.ko > 1500 || dVar.ko < 0) {
                qVar.r("connBaidu", String.valueOf(oD()));
            }
            qVar.r("memory", oE());
            qVar.r("task", oF());
            qVar.r("isWifi", fh ? "1" : "0");
            qVar.r("status", String.valueOf(dVar.ku));
            qVar.r("up", String.valueOf(dVar.kl));
            qVar.r("down", String.valueOf(dVar.km));
            qVar.r("isCDN", eF ? "1" : "0");
            qVar.r("isWebp", bool.booleanValue() ? "1" : "0");
            qVar.r("isMobileProxy", z3 ? "1" : "0");
            qVar.r("exception", dVar.ks);
            qVar.r("reason", str3);
            com.baidu.adp.lib.stats.f.es().a("img", qVar);
            if (eF && !TextUtils.isEmpty(str6) && TextUtils.isEmpty(str4) && !z) {
                HG.HK++;
            }
        }
    }

    public static void oA() {
        if (HG.oI() > 10) {
            if (HG.oH() > 0) {
                a(HG.HM, HG.HN, HG.HO, HG.HQ, HG.HP, TbConfig.BIG_IMAGE_MIN_CAPACITY);
            }
            if (HG.oK() > 0) {
                a(HG.HW, HG.HX, HG.HY, HG.Ia, HG.HZ, SapiErrorCode.ANTIIF_COMMUNICATE_ERROR);
            }
            if (HG.oJ() > 0) {
                a(HG.HR, HG.HS, HG.HT, HG.HV, HG.HU, SapiErrorCode.DB_GATE_COMMUNICATION_ERROR);
            }
            HG.oL();
            HG.oM();
            HG.oN();
            HG.reset();
        }
    }

    public static void a(y yVar, y yVar2, y yVar3, y yVar4, y yVar5, int i) {
        if (yVar != null && yVar2 != null && yVar3 != null && yVar4 != null && yVar5 != null) {
            String str = "";
            String str2 = "";
            String str3 = "";
            if (TextUtils.isEmpty("")) {
                str = z.oO().oP();
            }
            if (HJ != null && TextUtils.isEmpty("")) {
                str2 = z.oO().cx(HJ);
            }
            if (TextUtils.isEmpty("")) {
                str3 = oC();
            }
            com.baidu.adp.lib.stats.q ef = ef();
            ef.r("act", "dlStat");
            ef.r("cdnCostTime", String.valueOf(yVar.time));
            ef.r("cdnNum", String.valueOf(yVar.num));
            ef.r("cdnFailnum", String.valueOf(yVar.Ib));
            ef.r("portraitCostTime", String.valueOf(yVar2.time));
            ef.r("portraitNum", String.valueOf(yVar2.num));
            ef.r("portraitFailnum", String.valueOf(yVar2.Ib));
            ef.r("tiebaCostTime", String.valueOf(yVar3.time));
            ef.r("tiebaNum", String.valueOf(yVar3.num));
            ef.r("tiebaFailnum", String.valueOf(yVar3.Ib));
            ef.r("otherCostTime", String.valueOf(yVar5.time));
            ef.r("otherNum", String.valueOf(yVar5.num));
            ef.r("otherFailnum", String.valueOf(yVar5.Ib));
            ef.r("directIpCostTime", String.valueOf(yVar4.time));
            ef.r("directIpNum", String.valueOf(yVar4.num));
            ef.r("directIpFailnum", String.valueOf(yVar4.Ib));
            ef.r("dnsFailNum", String.valueOf(HG.HK));
            if (10000 == i) {
                ef.r("isWifi", "1");
                ef.r("netType", NetworkChangeReceiver.WIFI_STRING);
            } else if (100002 == i) {
                ef.r("netType", "3G");
                ef.r("isWifi", "0");
            } else {
                ef.r("netType", "2G");
                ef.r("isWifi", "0");
            }
            ef.r("localIp", j.getIp());
            ef.r("tbIp", str);
            ef.r("cdnIp", str2);
            ef.r("dnsIp", str3);
            com.baidu.adp.lib.stats.f.es().a("img", ef);
        }
    }

    public static void a(com.baidu.adp.lib.stats.q qVar, String str, String str2, boolean z, boolean z2, boolean z3, int i, String str3, long j, String str4) {
        if (com.baidu.adp.lib.util.l.isNetOk()) {
            synchronized (lv) {
                HI.num++;
                if (z) {
                    HI.time += j;
                } else {
                    HI.Ib++;
                }
                if (HI.num >= 100) {
                    oB();
                }
            }
            if (!z) {
                if (qVar == null) {
                    qVar = ef();
                }
                qVar.r("act", "dc");
                qVar.r("costTime", String.valueOf(j));
                qVar.r(ImageViewerConfig.URL, str);
                qVar.r("fullURL", str2);
                qVar.r("isWebp", z3 ? "1" : "0");
                qVar.r("isCDN", z2 ? "1" : "0");
                qVar.r("length", String.valueOf(i));
                qVar.r("reason", str3);
                qVar.r("result", z ? "0" : "1");
                qVar.r("execption", str4);
                com.baidu.adp.lib.stats.f.es().a("img", qVar);
            }
        }
    }

    public static void oB() {
        if (HI.num > 10) {
            com.baidu.adp.lib.stats.q ef = ef();
            ef.r("act", "dcStat");
            ef.r("costTime", String.valueOf(HI.time));
            ef.r("num", String.valueOf(HI.num));
            ef.r("failnum", String.valueOf(HI.Ib));
            com.baidu.adp.lib.stats.f.es().a("img", ef);
            com.baidu.tbadk.performanceLog.aa.a(HI.num, HI.Ib, HI.time);
            HI.reset();
        }
    }

    public static void cw(String str) {
        com.baidu.adp.lib.stats.q ef = ef();
        ef.r("act", "assistant");
        ef.r(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, str);
        com.baidu.adp.lib.stats.f.es().a("img", ef);
    }

    private static String oC() {
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [647=4] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:74:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static long oD() {
        HttpURLConnection httpURLConnection;
        long j;
        if (HE >= 3) {
            return HF;
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
            if (HE > -1) {
                HF = ((HF * HE) + j) / (HE + 1);
            } else {
                HF = j;
            }
            HE++;
            return j;
        }
        return j;
    }

    private static String oE() {
        return com.baidu.tbadk.imageManager.e.vL().cu();
    }

    private static String oF() {
        return com.baidu.adp.lib.asyncTask.f.cw().cu();
    }

    public static void a(boolean z, boolean z2, String str, String str2) {
        com.baidu.adp.lib.stats.q ef = ef();
        ef.r("act", "getCDNList");
        ef.r("errorNum", str);
        ef.r("errorMsg", str2);
        ef.r("isShortNetError", z2 ? "1" : "0");
        ef.r("isSuccess", z ? "1" : "0");
        com.baidu.adp.lib.stats.f.es().a("img", ef);
    }

    public static void a(boolean z, String str, String str2, String str3, String str4, String str5, long j, boolean z2) {
        String str6 = "";
        if (str != null) {
            str6 = z.oO().cx(str);
        }
        String oC = oC();
        String ip = j.getIp();
        com.baidu.adp.lib.stats.q ef = ef();
        ef.r("act", "tachometerCDN");
        ef.r("errorNum", str3);
        ef.r("execption", str4);
        ef.r("size", str5);
        ef.r("isScuess", z ? "1" : "0");
        ef.r(ImageViewerConfig.URL, str);
        ef.r("localIp", ip);
        ef.r("cdnIp", str6);
        ef.r("dnsIP", oC);
        ef.r("usedIp", str2);
        ef.r("isUsedIp", z2 ? "0" : "1");
        ef.r("costTime", String.valueOf(j));
        com.baidu.adp.lib.stats.f.es().a("img", ef);
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
                    com.baidu.adp.lib.stats.q ef = ef();
                    ef.r("act", "mobileTachometerCDN");
                    ef.r("costTime", String.valueOf(j));
                    ef.r("ipList", sb.toString());
                    com.baidu.adp.lib.stats.f.es().a("img", ef);
                    return;
                }
            }
        }
    }

    public static void d(boolean z, String str) {
        com.baidu.adp.lib.stats.q ef = ef();
        ef.r("act", "getCDNList");
        ef.r("isSuccess", z ? "1" : "0");
        ef.r("errorMsg", str);
        com.baidu.adp.lib.stats.f.es().a("img", ef);
    }
}
