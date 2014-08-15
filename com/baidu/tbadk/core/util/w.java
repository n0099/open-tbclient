package com.baidu.tbadk.core.util;

import android.net.DhcpInfo;
import android.net.wifi.WifiManager;
import android.support.v4.view.MotionEventCompat;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.resourceLoader.BdResourceLoaderNetHelperStatic;
import com.baidu.tbadk.TbConfig;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
/* loaded from: classes.dex */
public class w {
    private static long a = 0;
    private static long b = 0;
    private static x c = new x(null);
    private static y d = new y(null);
    private static y e = new y(null);
    private static String f = null;
    private static Object g = new Object();

    private static y a(boolean z, boolean z2, String str, boolean z3) {
        if (z) {
            if (z2 && !z3) {
                return c.c;
            }
            if (str.startsWith("http://tb.himg")) {
                return c.d;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return c.e;
            }
            if (z3) {
                return c.g;
            }
            return c.f;
        }
        return null;
    }

    public static com.baidu.adp.lib.stats.q a() {
        return com.baidu.adp.lib.stats.f.c().a("dbg");
    }

    public static void a(com.baidu.adp.lib.stats.q qVar, String str, boolean z, long j, boolean z2) {
        if (z && z2) {
            synchronized (g) {
                d.a++;
                d.c += j;
                if (d.a >= 100) {
                    b();
                }
            }
        }
    }

    public static void b() {
        if (d.a > 10) {
            com.baidu.adp.lib.stats.q a2 = a();
            a2.a("act", "locStat");
            a2.a("costTime", String.valueOf(d.c));
            a2.a("num", String.valueOf(d.a));
            a2.a("isWifi", TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK);
            com.baidu.adp.lib.stats.f.c().a("img", a2);
            d.a();
        }
    }

    public static void a(com.baidu.adp.lib.stats.q qVar, String str, boolean z, String str2, boolean z2, Boolean bool, com.baidu.adp.lib.network.http.d dVar, String str3, long j) {
        boolean z3;
        String str4;
        String str5;
        if (com.baidu.adp.lib.util.j.c()) {
            String str6 = "";
            int indexOf = str2.indexOf("hiphotos");
            if (indexOf > 0 && indexOf < 20) {
                z3 = true;
            } else {
                z3 = false;
            }
            boolean a2 = BdResourceLoaderNetHelperStatic.a();
            boolean z4 = false;
            if (z3) {
                z4 = com.baidu.tbadk.core.util.httpNet.a.a().a(str2, dVar.k, z, j > 3000);
            }
            if (z3 && a2 && z4) {
                if (z) {
                    e.a().a(j, str);
                } else {
                    str6 = z.a().b();
                    if (!TextUtils.isEmpty(str6)) {
                        e.a().a(dVar.i, str);
                    }
                }
            }
            if (z3) {
                f = str;
            }
            boolean z5 = false;
            if (dVar.k != null && dVar.k.length() > 0) {
                z5 = true;
            }
            synchronized (g) {
                y a3 = a(a2, z3, str2, z5);
                boolean z6 = c.b;
                if (a3 != null) {
                    a3.a++;
                    if (z) {
                        a3.c += j;
                        c.b = true;
                    } else {
                        a3.b++;
                        c.b = false;
                    }
                }
                int a4 = c.a();
                if (a4 > 100 || (a4 > 0 && z6 != c.b)) {
                    c();
                }
            }
            if (a2) {
                if (!z || !a2 || j >= 1500) {
                    if (qVar == null) {
                        qVar = a();
                    }
                    if (TextUtils.isEmpty(str6)) {
                        str6 = z.a().b();
                    }
                    if (!z3 || !TextUtils.isEmpty("")) {
                        str4 = "";
                    } else {
                        str4 = z.a().a(str);
                    }
                    if (!TextUtils.isEmpty("")) {
                        str5 = "";
                    } else {
                        str5 = e();
                    }
                    qVar.a("url", str);
                    qVar.a("act", "dl");
                    qVar.a("result", z ? "0" : TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK);
                    qVar.a("fullurl", str2);
                    qVar.a("costTime", String.valueOf(j));
                    qVar.a("connTime", String.valueOf(dVar.c));
                    qVar.a("rspTime", String.valueOf(dVar.d));
                    qVar.a("retry", String.valueOf(dVar.e));
                    qVar.a("localIp", j.a());
                    qVar.a("tiebaIp", str6);
                    qVar.a("cdnIp", str4);
                    qVar.a("useIp", dVar.k);
                    qVar.a("dnsIp", str5);
                    if (dVar.c > 1500 || dVar.c < 0) {
                        qVar.a("connBaidu", String.valueOf(f()));
                    }
                    qVar.a("memory", g());
                    qVar.a("task", h());
                    qVar.a("isWifi", a2 ? TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK : "0");
                    qVar.a("status", String.valueOf(dVar.j));
                    qVar.a("up", String.valueOf(dVar.a));
                    qVar.a("down", String.valueOf(dVar.b));
                    qVar.a("isCDN", z3 ? TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK : "0");
                    qVar.a("isWebp", bool.booleanValue() ? TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK : "0");
                    qVar.a("exception", dVar.h);
                    qVar.a("reason", str3);
                    com.baidu.adp.lib.stats.f.c().a("img", qVar);
                    if (z3 && !TextUtils.isEmpty(str6) && TextUtils.isEmpty(str4) && !z) {
                        c.a++;
                    }
                }
            }
        }
    }

    public static void c() {
        String str = "";
        String str2 = "";
        String str3 = "";
        if (c.a() > 10) {
            if (TextUtils.isEmpty("")) {
                str = z.a().b();
            }
            if (f != null && TextUtils.isEmpty("")) {
                str2 = z.a().a(f);
            }
            if (TextUtils.isEmpty("")) {
                str3 = e();
            }
            com.baidu.adp.lib.stats.q a2 = a();
            a2.a("act", "dlStat");
            a2.a("cdnCostTime", String.valueOf(c.c.c));
            a2.a("cdnNum", String.valueOf(c.c.a));
            a2.a("cdnFailnum", String.valueOf(c.c.b));
            a2.a("portraitCostTime", String.valueOf(c.d.c));
            a2.a("portraitNum", String.valueOf(c.d.a));
            a2.a("portraitFailnum", String.valueOf(c.d.b));
            a2.a("tiebaCostTime", String.valueOf(c.e.c));
            a2.a("tiebaNum", String.valueOf(c.e.a));
            a2.a("tiebaFailnum", String.valueOf(c.e.b));
            a2.a("otherCostTime", String.valueOf(c.f.c));
            a2.a("otherNum", String.valueOf(c.f.a));
            a2.a("otherFailnum", String.valueOf(c.f.b));
            a2.a("directIpCostTime", String.valueOf(c.g.c));
            a2.a("directIpNum", String.valueOf(c.g.a));
            a2.a("directIpFailnum", String.valueOf(c.g.b));
            a2.a("dnsFailNum", String.valueOf(c.a));
            a2.a("isWifi", TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK);
            a2.a("localIp", j.a());
            a2.a("tbIp", str);
            a2.a("cdnIp", str2);
            a2.a("dnsIp", str3);
            com.baidu.adp.lib.stats.f.c().a("img", a2);
            c.b();
        }
    }

    public static void a(com.baidu.adp.lib.stats.q qVar, String str, String str2, boolean z, boolean z2, boolean z3, int i, String str3, long j, String str4) {
        if (com.baidu.adp.lib.util.j.c()) {
            synchronized (g) {
                e.a++;
                if (z) {
                    e.c += j;
                } else {
                    e.b++;
                }
                if (e.a >= 100) {
                    d();
                }
            }
            if (!z) {
                if (qVar == null) {
                    qVar = a();
                }
                qVar.a("act", "dc");
                qVar.a("costTime", String.valueOf(j));
                qVar.a("url", str);
                qVar.a("fullURL", str2);
                qVar.a("isWebp", z3 ? TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK : "0");
                qVar.a("isCDN", z2 ? TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK : "0");
                qVar.a("length", String.valueOf(i));
                qVar.a("reason", str3);
                qVar.a("result", z ? "0" : TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK);
                qVar.a("execption", str4);
                com.baidu.adp.lib.stats.f.c().a("img", qVar);
            }
        }
    }

    public static void d() {
        if (e.a > 10) {
            com.baidu.adp.lib.stats.q a2 = a();
            a2.a("act", "dcStat");
            a2.a("costTime", String.valueOf(e.c));
            a2.a("num", String.valueOf(e.a));
            a2.a("failnum", String.valueOf(e.b));
            com.baidu.adp.lib.stats.f.c().a("img", a2);
            e.a();
        }
    }

    public static void a(String str) {
        com.baidu.adp.lib.stats.q a2 = a();
        a2.a("act", "assistant");
        a2.a("content", str);
        com.baidu.adp.lib.stats.f.c().a("img", a2);
    }

    private static String e() {
        try {
            DhcpInfo dhcpInfo = ((WifiManager) BdBaseApplication.getInst().getApp().getSystemService("wifi")).getDhcpInfo();
            return String.valueOf(a(dhcpInfo.dns1)) + "," + a(dhcpInfo.dns2);
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    private static String a(int i) {
        return String.valueOf(i & MotionEventCompat.ACTION_MASK) + "." + ((i >> 8) & MotionEventCompat.ACTION_MASK) + "." + ((i >> 16) & MotionEventCompat.ACTION_MASK) + "." + ((i >> 24) & MotionEventCompat.ACTION_MASK);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [417=4] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static long f() {
        HttpURLConnection httpURLConnection;
        long j;
        if (a >= 3) {
            return b;
        }
        long currentTimeMillis = System.currentTimeMillis();
        HttpURLConnection httpURLConnection2 = null;
        try {
            httpURLConnection = (HttpURLConnection) new URL("http://www.baidu.com/").openConnection();
        } catch (SocketTimeoutException e2) {
            httpURLConnection = null;
        } catch (Exception e3) {
        } catch (Throwable th) {
            th = th;
        }
        try {
            httpURLConnection.setConnectTimeout(2500);
            httpURLConnection.connect();
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            com.baidu.adp.lib.e.a.a(httpURLConnection);
            j = currentTimeMillis2;
        } catch (SocketTimeoutException e4) {
            com.baidu.adp.lib.e.a.a(httpURLConnection);
            j = 2500;
            if (j > 0) {
            }
        } catch (Exception e5) {
            httpURLConnection2 = httpURLConnection;
            com.baidu.adp.lib.e.a.a(httpURLConnection2);
            j = -1;
            if (j > 0) {
            }
        } catch (Throwable th2) {
            httpURLConnection2 = httpURLConnection;
            th = th2;
            com.baidu.adp.lib.e.a.a(httpURLConnection2);
            throw th;
        }
        if (j > 0) {
            if (a > -1) {
                b = ((b * a) + j) / (a + 1);
            } else {
                b = j;
            }
            a++;
            return j;
        }
        return j;
    }

    private static String g() {
        return com.baidu.tbadk.imageManager.e.a().d();
    }

    private static String h() {
        return com.baidu.adp.lib.asyncTask.f.b().a();
    }

    public static void a(boolean z, String str, String str2) {
        com.baidu.adp.lib.stats.q a2 = a();
        a2.a("act", "getCDNList");
        a2.a("errorNum", str);
        a2.a("errorMsg", str2);
        a2.a("isShortNetError", z ? TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK : "0");
        com.baidu.adp.lib.stats.f.c().a("img", a2);
    }

    public static void a(boolean z, String str, String str2, String str3, String str4, String str5, long j, boolean z2) {
        String str6 = "";
        if (str != null) {
            str6 = z.a().a(str);
        }
        String e2 = e();
        String a2 = j.a();
        com.baidu.adp.lib.stats.q a3 = a();
        a3.a("act", "tachometerCDN");
        a3.a("errorNum", str3);
        a3.a("execption", str4);
        a3.a("size", str5);
        a3.a("isScuess", z ? TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK : "0");
        a3.a("url", str);
        a3.a("localIp", a2);
        a3.a("cdnIp", str6);
        a3.a("dnsIP", e2);
        a3.a("usedIp", str2);
        a3.a("isUsedIp", z2 ? TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK : "0");
        a3.a("costTime", String.valueOf(j));
        com.baidu.adp.lib.stats.f.c().a("img", a3);
    }
}
