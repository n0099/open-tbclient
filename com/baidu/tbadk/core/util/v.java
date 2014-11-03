package com.baidu.tbadk.core.util;

import android.net.DhcpInfo;
import android.net.wifi.WifiManager;
import android.support.v4.view.MotionEventCompat;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.pluginArch.PluginLogger;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
/* loaded from: classes.dex */
public class v {
    private static long Ds = 0;
    private static long Dt = 0;
    private static w Du = new w(null);
    private static x Dv = new x(null);
    private static x Dw = new x(null);
    private static String Dx = null;
    private static Object lu = new Object();

    private static x a(boolean z, boolean z2, String str, boolean z3) {
        if (z) {
            if (z2 && !z3) {
                return Du.DA;
            }
            if (str.startsWith("http://tb.himg")) {
                return Du.DB;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return Du.DC;
            }
            if (z2 && z3) {
                return Du.DE;
            }
            return Du.DD;
        } else if (com.baidu.adp.lib.network.willdelete.h.eb()) {
            if (z2) {
                return Du.DF;
            }
            if (str.startsWith("http://tb.himg")) {
                return Du.DG;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return Du.DH;
            }
            return Du.DI;
        } else if (z2) {
            return Du.DK;
        } else {
            if (str.startsWith("http://tb.himg")) {
                return Du.DL;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return Du.DM;
            }
            return Du.DN;
        }
    }

    public static com.baidu.adp.lib.stats.q getLogItem() {
        return com.baidu.adp.lib.stats.f.er().ag("dbg");
    }

    public static void a(com.baidu.adp.lib.stats.q qVar, String str, boolean z, long j, boolean z2) {
        if (z && z2) {
            synchronized (lu) {
                Dv.num++;
                Dv.time += j;
                if (Dv.num >= 100) {
                    lE();
                }
            }
        }
    }

    public static void lE() {
        if (Dv.num > 10) {
            com.baidu.adp.lib.stats.q logItem = getLogItem();
            logItem.n("act", "locStat");
            logItem.n("costTime", String.valueOf(Dv.time));
            logItem.n("num", String.valueOf(Dv.num));
            logItem.n("isWifi", "1");
            com.baidu.adp.lib.stats.f.er().a("img", logItem);
            Dv.reset();
        }
    }

    public static void a(com.baidu.adp.lib.stats.q qVar, String str, boolean z, String str2, boolean z2, Boolean bool, com.baidu.adp.lib.network.http.d dVar, String str3, long j, boolean z3) {
        boolean z4;
        boolean z5;
        String str4;
        String str5;
        if (com.baidu.adp.lib.util.m.isNetOk()) {
            String str6 = "";
            int indexOf = str2.indexOf("hiphotos");
            if (indexOf > 0 && indexOf < 20) {
                z4 = true;
            } else {
                z4 = false;
            }
            boolean fi = com.baidu.adp.lib.util.j.fi();
            if (fi) {
                z5 = j > 3000;
            } else if (com.baidu.adp.lib.network.willdelete.h.eb()) {
                z5 = j > 10000;
            } else {
                z5 = j > TbConfig.NOTIFY_SOUND_INTERVAL;
            }
            boolean z6 = false;
            if (z4) {
                z6 = com.baidu.tbadk.core.util.httpNet.a.mT().mX();
            }
            if (z4 && fi && z6) {
                if (z) {
                    e.lq().a(j, str);
                } else {
                    str6 = y.lT().lU();
                    if (!TextUtils.isEmpty(str6)) {
                        e.lq().d(dVar.ks, str);
                    }
                }
            }
            if (z4) {
                Dx = str;
            }
            boolean z7 = false;
            if (dVar.ku != null && dVar.ku.length() > 0) {
                z7 = true;
            }
            synchronized (lu) {
                x a = a(fi, z4, str2, z7);
                boolean z8 = Du.Dz;
                if (a != null) {
                    a.num++;
                    if (z) {
                        a.time += j;
                        Du.Dz = true;
                        if (z5) {
                            a.DQ++;
                        }
                    } else {
                        a.DP++;
                        Du.Dz = false;
                    }
                }
                int lN = Du.lN();
                if (lN > 100 || (lN > 0 && z8 != Du.Dz)) {
                    lF();
                }
            }
            if (fi) {
                if (!z || !fi || j >= 1500) {
                    if (qVar == null) {
                        qVar = getLogItem();
                    }
                    if (TextUtils.isEmpty(str6)) {
                        str6 = y.lT().lU();
                    }
                    if (!z4 || !TextUtils.isEmpty("")) {
                        str4 = "";
                    } else {
                        str4 = y.lT().bE(str);
                    }
                    if (!TextUtils.isEmpty("")) {
                        str5 = "";
                    } else {
                        str5 = lH();
                    }
                    qVar.n(ImageViewerConfig.URL, str);
                    qVar.n("act", "dl");
                    qVar.n("result", z ? "0" : "1");
                    qVar.n("fullurl", str2);
                    qVar.n("costTime", String.valueOf(j));
                    qVar.n("connTime", String.valueOf(dVar.km));
                    qVar.n("rspTime", String.valueOf(dVar.ko));
                    qVar.n("retry", String.valueOf(dVar.retry));
                    qVar.n("localIp", j.getIp());
                    qVar.n("tiebaIp", str6);
                    qVar.n("cdnIp", str4);
                    qVar.n("useIp", dVar.ku);
                    qVar.n("dnsIp", str5);
                    if (dVar.km > 1500 || dVar.km < 0) {
                        qVar.n("connBaidu", String.valueOf(lI()));
                    }
                    qVar.n("memory", lJ());
                    qVar.n("task", lK());
                    qVar.n("isWifi", fi ? "1" : "0");
                    qVar.n("status", String.valueOf(dVar.kt));
                    qVar.n("up", String.valueOf(dVar.kk));
                    qVar.n("down", String.valueOf(dVar.kl));
                    qVar.n("isCDN", z4 ? "1" : "0");
                    qVar.n("isWebp", bool.booleanValue() ? "1" : "0");
                    qVar.n("isMobile", z3 ? "1" : "0");
                    qVar.n("exception", dVar.kr);
                    qVar.n(PluginLogger.KEY_REASON, str3);
                    com.baidu.adp.lib.stats.f.er().a("img", qVar);
                    if (z4 && !TextUtils.isEmpty(str6) && TextUtils.isEmpty(str4) && !z) {
                        Du.Dy++;
                    }
                }
            }
        }
    }

    public static void lF() {
        String str = "";
        String str2 = "";
        String str3 = "";
        if (Du.lN() > 10) {
            if (Du.lM() > 0) {
                if (TextUtils.isEmpty("")) {
                    str = y.lT().lU();
                }
                if (Dx != null && TextUtils.isEmpty("")) {
                    str2 = y.lT().bE(Dx);
                }
                if (TextUtils.isEmpty("")) {
                    str3 = lH();
                }
                com.baidu.adp.lib.stats.q logItem = getLogItem();
                logItem.n("act", "dlStat");
                logItem.n("cdnCostTime", String.valueOf(Du.DA.time));
                logItem.n("cdnNum", String.valueOf(Du.DA.num));
                logItem.n("cdnFailnum", String.valueOf(Du.DA.DP));
                logItem.n("portraitCostTime", String.valueOf(Du.DB.time));
                logItem.n("portraitNum", String.valueOf(Du.DB.num));
                logItem.n("portraitFailnum", String.valueOf(Du.DB.DP));
                logItem.n("tiebaCostTime", String.valueOf(Du.DC.time));
                logItem.n("tiebaNum", String.valueOf(Du.DC.num));
                logItem.n("tiebaFailnum", String.valueOf(Du.DC.DP));
                logItem.n("otherCostTime", String.valueOf(Du.DD.time));
                logItem.n("otherNum", String.valueOf(Du.DD.num));
                logItem.n("otherFailnum", String.valueOf(Du.DD.DP));
                logItem.n("directIpCostTime", String.valueOf(Du.DE.time));
                logItem.n("directIpNum", String.valueOf(Du.DE.num));
                logItem.n("directIpFailnum", String.valueOf(Du.DE.DP));
                logItem.n("dnsFailNum", String.valueOf(Du.Dy));
                logItem.n("isWifi", "1");
                logItem.n("localIp", j.getIp());
                logItem.n("tbIp", str);
                logItem.n("cdnIp", str2);
                logItem.n("dnsIp", str3);
                com.baidu.adp.lib.stats.f.er().a("img", logItem);
            }
            Du.lQ();
            Du.lR();
            Du.lS();
            Du.reset();
        }
    }

    public static void a(com.baidu.adp.lib.stats.q qVar, String str, String str2, boolean z, boolean z2, boolean z3, int i, String str3, long j, String str4) {
        if (com.baidu.adp.lib.util.m.isNetOk()) {
            synchronized (lu) {
                Dw.num++;
                if (z) {
                    Dw.time += j;
                } else {
                    Dw.DP++;
                }
                if (Dw.num >= 100) {
                    lG();
                }
            }
            if (!z) {
                if (qVar == null) {
                    qVar = getLogItem();
                }
                qVar.n("act", "dc");
                qVar.n("costTime", String.valueOf(j));
                qVar.n(ImageViewerConfig.URL, str);
                qVar.n("fullURL", str2);
                qVar.n("isWebp", z3 ? "1" : "0");
                qVar.n("isCDN", z2 ? "1" : "0");
                qVar.n("length", String.valueOf(i));
                qVar.n(PluginLogger.KEY_REASON, str3);
                qVar.n("result", z ? "0" : "1");
                qVar.n("execption", str4);
                com.baidu.adp.lib.stats.f.er().a("img", qVar);
            }
        }
    }

    public static void lG() {
        if (Dw.num > 10) {
            com.baidu.adp.lib.stats.q logItem = getLogItem();
            logItem.n("act", "dcStat");
            logItem.n("costTime", String.valueOf(Dw.time));
            logItem.n("num", String.valueOf(Dw.num));
            logItem.n("failnum", String.valueOf(Dw.DP));
            com.baidu.adp.lib.stats.f.er().a("img", logItem);
            com.baidu.tbadk.performanceLog.t.a(Dw.num, Dw.DP, Dw.time);
            Dw.reset();
        }
    }

    public static void bD(String str) {
        com.baidu.adp.lib.stats.q logItem = getLogItem();
        logItem.n("act", "assistant");
        logItem.n("content", str);
        com.baidu.adp.lib.stats.f.er().a("img", logItem);
    }

    private static String lH() {
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [587=4] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:74:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static long lI() {
        HttpURLConnection httpURLConnection;
        long j;
        if (Ds >= 3) {
            return Dt;
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
            if (Ds > -1) {
                Dt = ((Dt * Ds) + j) / (Ds + 1);
            } else {
                Dt = j;
            }
            Ds++;
            return j;
        }
        return j;
    }

    private static String lJ() {
        return com.baidu.tbadk.imageManager.e.si().bU();
    }

    private static String lK() {
        return com.baidu.adp.lib.asyncTask.f.bV().bU();
    }

    public static void a(boolean z, boolean z2, String str, String str2) {
        com.baidu.adp.lib.stats.q logItem = getLogItem();
        logItem.n("act", "getCDNList");
        logItem.n("errorNum", str);
        logItem.n("errorMsg", str2);
        logItem.n("isShortNetError", z2 ? "1" : "0");
        logItem.n("isSuccess", z ? "1" : "0");
        com.baidu.adp.lib.stats.f.er().a("img", logItem);
    }

    public static void a(boolean z, String str, String str2, String str3, String str4, String str5, long j, boolean z2) {
        String str6 = "";
        if (str != null) {
            str6 = y.lT().bE(str);
        }
        String lH = lH();
        String ip = j.getIp();
        com.baidu.adp.lib.stats.q logItem = getLogItem();
        logItem.n("act", "tachometerCDN");
        logItem.n("errorNum", str3);
        logItem.n("execption", str4);
        logItem.n("size", str5);
        logItem.n("isScuess", z ? "1" : "0");
        logItem.n(ImageViewerConfig.URL, str);
        logItem.n("localIp", ip);
        logItem.n("cdnIp", str6);
        logItem.n("dnsIP", lH);
        logItem.n("usedIp", str2);
        logItem.n("isUsedIp", z2 ? "0" : "1");
        logItem.n("costTime", String.valueOf(j));
        com.baidu.adp.lib.stats.f.er().a("img", logItem);
    }
}
