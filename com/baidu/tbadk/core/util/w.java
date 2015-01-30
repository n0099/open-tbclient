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
    private static long HN = 0;
    private static long HO = 0;
    private static x HP = new x(null);
    private static y HQ = new y(null);
    private static y HR = new y(null);
    private static String HS = null;
    private static Object ly = new Object();

    private static y a(boolean z, boolean z2, String str, boolean z3) {
        if (z) {
            if (z2 && !z3) {
                return HP.HV;
            }
            if (str.startsWith("http://tb.himg")) {
                return HP.HW;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return HP.HX;
            }
            if (z2 && z3) {
                return HP.HZ;
            }
            return HP.HY;
        } else if (com.baidu.adp.lib.network.willdelete.h.dY()) {
            if (z2) {
                return HP.Ia;
            }
            if (str.startsWith("http://tb.himg")) {
                return HP.Ib;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return HP.Ic;
            }
            return HP.Id;
        } else if (z2) {
            return HP.If;
        } else {
            if (str.startsWith("http://tb.himg")) {
                return HP.Ig;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return HP.Ih;
            }
            return HP.Ii;
        }
    }

    public static com.baidu.adp.lib.stats.q ed() {
        return com.baidu.adp.lib.stats.f.eq().ak("dbg");
    }

    public static void a(com.baidu.adp.lib.stats.q qVar, String str, boolean z, long j, boolean z2) {
        if (z && z2) {
            synchronized (ly) {
                HQ.num++;
                HQ.time += j;
                if (HQ.num >= 100) {
                    oC();
                }
            }
        }
    }

    public static void oC() {
        if (HQ.num > 10) {
            com.baidu.adp.lib.stats.q ed = ed();
            ed.r("act", "locStat");
            ed.r("costTime", String.valueOf(HQ.time));
            ed.r("num", String.valueOf(HQ.num));
            ed.r("isWifi", "1");
            com.baidu.adp.lib.stats.f.eq().a("img", ed);
            HQ.reset();
        }
    }

    public static void a(com.baidu.adp.lib.stats.q qVar, String str, boolean z, String str2, boolean z2, Boolean bool, com.baidu.adp.lib.network.http.d dVar, String str3, long j, boolean z3, long j2) {
        boolean z4;
        String str4;
        String str5;
        if (com.baidu.adp.lib.util.l.isNetOk()) {
            String str6 = "";
            boolean eF = com.baidu.tbadk.util.h.eF(str2);
            boolean fg = com.baidu.adp.lib.util.i.fg();
            if (fg) {
                z4 = j > ((long) CDNIPDirectConnect.pX().Kq.BC);
            } else if (com.baidu.adp.lib.network.willdelete.h.dY()) {
                z4 = j > ((long) CDNIPDirectConnect.pX().Kq.BE);
            } else {
                z4 = j > ((long) CDNIPDirectConnect.pX().Kq.BD);
            }
            boolean z5 = false;
            if (eF) {
                z5 = CDNIPDirectConnect.pX().qb();
            }
            if (eF && fg && z5) {
                if (z) {
                    e.oo().a(j, str);
                } else {
                    str6 = z.oR().oS();
                    if (!TextUtils.isEmpty(str6)) {
                        e.oo().m(dVar.kx, str);
                    }
                }
            }
            if (eF) {
                HS = str;
            }
            boolean z6 = false;
            if (dVar.kA != null && dVar.kA.length() > 0) {
                z6 = true;
            }
            synchronized (ly) {
                y a = a(fg, eF, str2, z6);
                boolean z7 = HP.HU;
                if (a != null) {
                    a.num++;
                    if (z) {
                        a.time += j;
                        a.Il += j2;
                        HP.HU = true;
                        if (z4) {
                            a.Im++;
                        }
                    } else {
                        a.Ik++;
                        HP.HU = false;
                    }
                }
                int oL = HP.oL();
                if (oL > 100 || (oL > 0 && z7 != HP.HU)) {
                    oD();
                }
            }
            if (z) {
                if (!fg || j >= CDNIPDirectConnect.pX().Kq.BC) {
                    if (fg || !com.baidu.adp.lib.network.willdelete.h.dY() || j >= CDNIPDirectConnect.pX().Kq.BE) {
                        if (!fg && j < CDNIPDirectConnect.pX().Kq.BD) {
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
                qVar = ed();
            }
            if (TextUtils.isEmpty(str6)) {
                str6 = z.oR().oS();
            }
            if (!eF || !TextUtils.isEmpty("")) {
                str4 = "";
            } else {
                str4 = z.oR().cv(str);
            }
            if (!TextUtils.isEmpty("")) {
                str5 = "";
            } else {
                str5 = oF();
            }
            qVar.r(ImageViewerConfig.URL, str);
            qVar.r("act", "dl");
            qVar.r("result", z ? "0" : "1");
            qVar.r("fullurl", str2);
            qVar.r("costTime", String.valueOf(j));
            qVar.r("connTime", String.valueOf(dVar.kr));
            qVar.r("rspTime", String.valueOf(dVar.ks));
            qVar.r("retry", String.valueOf(dVar.retry));
            qVar.r("localIp", j.getIp());
            qVar.r("tiebaIp", str6);
            qVar.r("cdnIp", str4);
            qVar.r("useIp", dVar.kA);
            qVar.r("dnsIp", str5);
            if (dVar.kr > 1500 || dVar.kr < 0) {
                qVar.r("connBaidu", String.valueOf(oG()));
            }
            qVar.r("memory", oH());
            qVar.r("task", oI());
            qVar.r("isWifi", fg ? "1" : "0");
            qVar.r("status", String.valueOf(dVar.ky));
            qVar.r("up", String.valueOf(dVar.kp));
            qVar.r("down", String.valueOf(dVar.kq));
            qVar.r("isCDN", eF ? "1" : "0");
            qVar.r("isWebp", bool.booleanValue() ? "1" : "0");
            qVar.r("isMobileProxy", z3 ? "1" : "0");
            qVar.r("exception", dVar.kv);
            qVar.r("reason", str3);
            com.baidu.adp.lib.stats.f.eq().a("img", qVar);
            if (eF && !TextUtils.isEmpty(str6) && TextUtils.isEmpty(str4) && !z) {
                HP.HT++;
            }
        }
    }

    public static void oD() {
        if (HP.oL() > 10) {
            if (HP.oK() > 0) {
                a(HP.HV, HP.HW, HP.HX, HP.HZ, HP.HY, TbConfig.BIG_IMAGE_MIN_CAPACITY);
            }
            if (HP.oN() > 0) {
                a(HP.If, HP.Ig, HP.Ih, HP.Ij, HP.Ii, SapiErrorCode.ANTIIF_COMMUNICATE_ERROR);
            }
            if (HP.oM() > 0) {
                a(HP.Ia, HP.Ib, HP.Ic, HP.Ie, HP.Id, SapiErrorCode.DB_GATE_COMMUNICATION_ERROR);
            }
            HP.oO();
            HP.oP();
            HP.oQ();
            HP.reset();
        }
    }

    public static void a(y yVar, y yVar2, y yVar3, y yVar4, y yVar5, int i) {
        if (yVar != null && yVar2 != null && yVar3 != null && yVar4 != null && yVar5 != null) {
            String str = "";
            String str2 = "";
            String str3 = "";
            if (TextUtils.isEmpty("")) {
                str = z.oR().oS();
            }
            if (HS != null && TextUtils.isEmpty("")) {
                str2 = z.oR().cv(HS);
            }
            if (TextUtils.isEmpty("")) {
                str3 = oF();
            }
            com.baidu.adp.lib.stats.q ed = ed();
            ed.r("act", "dlStat");
            ed.r("cdnCostTime", String.valueOf(yVar.time));
            ed.r("cdnNum", String.valueOf(yVar.num));
            ed.r("cdnFailnum", String.valueOf(yVar.Ik));
            ed.r("portraitCostTime", String.valueOf(yVar2.time));
            ed.r("portraitNum", String.valueOf(yVar2.num));
            ed.r("portraitFailnum", String.valueOf(yVar2.Ik));
            ed.r("tiebaCostTime", String.valueOf(yVar3.time));
            ed.r("tiebaNum", String.valueOf(yVar3.num));
            ed.r("tiebaFailnum", String.valueOf(yVar3.Ik));
            ed.r("otherCostTime", String.valueOf(yVar5.time));
            ed.r("otherNum", String.valueOf(yVar5.num));
            ed.r("otherFailnum", String.valueOf(yVar5.Ik));
            ed.r("directIpCostTime", String.valueOf(yVar4.time));
            ed.r("directIpNum", String.valueOf(yVar4.num));
            ed.r("directIpFailnum", String.valueOf(yVar4.Ik));
            ed.r("dnsFailNum", String.valueOf(HP.HT));
            if (10000 == i) {
                ed.r("isWifi", "1");
                ed.r("netType", NetworkChangeReceiver.WIFI_STRING);
            } else if (100002 == i) {
                ed.r("netType", "3G");
                ed.r("isWifi", "0");
            } else {
                ed.r("netType", "2G");
                ed.r("isWifi", "0");
            }
            ed.r("localIp", j.getIp());
            ed.r("tbIp", str);
            ed.r("cdnIp", str2);
            ed.r("dnsIp", str3);
            com.baidu.adp.lib.stats.f.eq().a("img", ed);
        }
    }

    public static void a(com.baidu.adp.lib.stats.q qVar, String str, String str2, boolean z, boolean z2, boolean z3, int i, String str3, long j, String str4) {
        if (com.baidu.adp.lib.util.l.isNetOk()) {
            synchronized (ly) {
                HR.num++;
                if (z) {
                    HR.time += j;
                } else {
                    HR.Ik++;
                }
                if (HR.num >= 100) {
                    oE();
                }
            }
            if (!z) {
                if (qVar == null) {
                    qVar = ed();
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
                com.baidu.adp.lib.stats.f.eq().a("img", qVar);
            }
        }
    }

    public static void oE() {
        if (HR.num > 10) {
            com.baidu.adp.lib.stats.q ed = ed();
            ed.r("act", "dcStat");
            ed.r("costTime", String.valueOf(HR.time));
            ed.r("num", String.valueOf(HR.num));
            ed.r("failnum", String.valueOf(HR.Ik));
            com.baidu.adp.lib.stats.f.eq().a("img", ed);
            com.baidu.tbadk.performanceLog.aa.a(HR.num, HR.Ik, HR.time);
            HR.reset();
        }
    }

    public static void cu(String str) {
        com.baidu.adp.lib.stats.q ed = ed();
        ed.r("act", "assistant");
        ed.r(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, str);
        com.baidu.adp.lib.stats.f.eq().a("img", ed);
    }

    private static String oF() {
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
    private static long oG() {
        HttpURLConnection httpURLConnection;
        long j;
        if (HN >= 3) {
            return HO;
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
            if (HN > -1) {
                HO = ((HO * HN) + j) / (HN + 1);
            } else {
                HO = j;
            }
            HN++;
            return j;
        }
        return j;
    }

    private static String oH() {
        return com.baidu.tbadk.imageManager.e.we().cs();
    }

    private static String oI() {
        return com.baidu.adp.lib.asyncTask.f.cu().cs();
    }

    public static void a(boolean z, boolean z2, String str, String str2) {
        com.baidu.adp.lib.stats.q ed = ed();
        ed.r("act", "getCDNList");
        ed.r("errorNum", str);
        ed.r("errorMsg", str2);
        ed.r("isShortNetError", z2 ? "1" : "0");
        ed.r("isSuccess", z ? "1" : "0");
        com.baidu.adp.lib.stats.f.eq().a("img", ed);
    }

    public static void a(boolean z, String str, String str2, String str3, String str4, String str5, long j, boolean z2) {
        String str6 = "";
        if (str != null) {
            str6 = z.oR().cv(str);
        }
        String oF = oF();
        String ip = j.getIp();
        com.baidu.adp.lib.stats.q ed = ed();
        ed.r("act", "tachometerCDN");
        ed.r("errorNum", str3);
        ed.r("execption", str4);
        ed.r("size", str5);
        ed.r("isScuess", z ? "1" : "0");
        ed.r(ImageViewerConfig.URL, str);
        ed.r("localIp", ip);
        ed.r("cdnIp", str6);
        ed.r("dnsIP", oF);
        ed.r("usedIp", str2);
        ed.r("isUsedIp", z2 ? "0" : "1");
        ed.r("costTime", String.valueOf(j));
        com.baidu.adp.lib.stats.f.eq().a("img", ed);
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
                    com.baidu.adp.lib.stats.q ed = ed();
                    ed.r("act", "mobileTachometerCDN");
                    ed.r("costTime", String.valueOf(j));
                    ed.r("ipList", sb.toString());
                    com.baidu.adp.lib.stats.f.eq().a("img", ed);
                    return;
                }
            }
        }
    }

    public static void d(boolean z, String str) {
        com.baidu.adp.lib.stats.q ed = ed();
        ed.r("act", "getCDNList");
        ed.r("isSuccess", z ? "1" : "0");
        ed.r("errorMsg", str);
        com.baidu.adp.lib.stats.f.eq().a("img", ed);
    }
}
