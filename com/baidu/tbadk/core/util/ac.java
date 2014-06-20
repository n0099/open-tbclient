package com.baidu.tbadk.core.util;

import android.net.DhcpInfo;
import android.net.wifi.WifiManager;
import android.support.v4.view.MotionEventCompat;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.resourceLoader.BdResourceLoaderNetHelperStatic;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
/* loaded from: classes.dex */
public class ac {
    private static long a = 0;
    private static long b = 0;
    private static ad c = new ad(null);
    private static ae d = new ae(null);
    private static ae e = new ae(null);
    private static String f = null;
    private static Object g = new Object();

    private static ae a(boolean z, boolean z2, String str) {
        if (z) {
            if (z2) {
                return c.b;
            }
            if (str.startsWith("http://tb.himg")) {
                return c.c;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return c.d;
            }
            return c.e;
        }
        return null;
    }

    public static com.baidu.adp.lib.stats.s a() {
        return com.baidu.adp.lib.stats.h.a().a("dbg");
    }

    public static void a(com.baidu.adp.lib.stats.s sVar, String str, boolean z, long j, boolean z2) {
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
            com.baidu.adp.lib.stats.s a2 = a();
            a2.a("act", "locStat");
            a2.a("costTime", String.valueOf(d.c));
            a2.a("num", String.valueOf(d.a));
            a2.a("isWifi", TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK);
            com.baidu.adp.lib.stats.h.a().a("img", a2);
            d.a();
        }
    }

    public static void a(com.baidu.adp.lib.stats.s sVar, String str, boolean z, String str2, boolean z2, Boolean bool, com.baidu.adp.lib.network.http.d dVar, String str3, long j) {
        boolean z3;
        String str4 = "";
        String str5 = "";
        String str6 = "";
        int indexOf = str2.indexOf("hiphotos");
        if (indexOf > 0 && indexOf < 20) {
            z3 = true;
        } else {
            z3 = false;
        }
        boolean a2 = BdResourceLoaderNetHelperStatic.a();
        if (z3 && a2) {
            if (z) {
                h.a().a(j, str);
            } else {
                str4 = e();
                if (!TextUtils.isEmpty(str4)) {
                    h.a().a(dVar.i, str);
                }
            }
        }
        if (z3) {
            f = str;
        }
        synchronized (g) {
            ae a3 = a(a2, z3, str2);
            if (a3 != null) {
                a3.a++;
                if (z) {
                    a3.c += j;
                } else {
                    a3.b++;
                }
            }
            if (c.a() > 100) {
                c();
            }
        }
        if (a2) {
            if (!z || !a2 || j >= 1500) {
                if (sVar == null) {
                    sVar = a();
                }
                String e2 = TextUtils.isEmpty(str4) ? e() : str4;
                if (z3 && TextUtils.isEmpty("")) {
                    str5 = a(str);
                }
                if (TextUtils.isEmpty("")) {
                    str6 = f();
                }
                sVar.a("url", str);
                sVar.a("act", "dl");
                sVar.a("result", z ? "0" : TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK);
                sVar.a("fullurl", str2);
                sVar.a("costTime", String.valueOf(j));
                sVar.a("dnsTime", String.valueOf(dVar.g));
                sVar.a("connTime", String.valueOf(dVar.c));
                sVar.a("rspTime", String.valueOf(dVar.d));
                sVar.a("allTime", String.valueOf(dVar.f));
                sVar.a("retry", String.valueOf(dVar.e));
                sVar.a("localIp", n.a());
                sVar.a("tiebaIp", e2);
                sVar.a("cdnIp", str5);
                sVar.a("dnsIp", str6);
                if (dVar.c > 1500 || dVar.c < 0) {
                    sVar.a("connBaidu", String.valueOf(g()));
                }
                sVar.a("memory", h());
                sVar.a("task", i());
                sVar.a("isWifi", a2 ? TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK : "0");
                sVar.a("status", String.valueOf(dVar.j));
                sVar.a("up", String.valueOf(dVar.a));
                sVar.a("down", String.valueOf(dVar.b));
                sVar.a("isCDN", z3 ? TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK : "0");
                sVar.a("isWebp", bool.booleanValue() ? TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK : "0");
                sVar.a("exception", dVar.h);
                sVar.a("reason", str3);
                com.baidu.adp.lib.stats.h.a().a("img", sVar);
                if (z3 && !TextUtils.isEmpty(e2) && TextUtils.isEmpty(str5) && !z) {
                    c.a++;
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
                str = e();
            }
            if (f != null && TextUtils.isEmpty("")) {
                str2 = a(f);
            }
            if (TextUtils.isEmpty("")) {
                str3 = f();
            }
            com.baidu.adp.lib.stats.s a2 = a();
            a2.a("act", "dlStat");
            a2.a("cdnCostTime", String.valueOf(c.b.c));
            a2.a("cdnNum", String.valueOf(c.b.a));
            a2.a("cdnFailnum", String.valueOf(c.b.b));
            a2.a("portraitCostTime", String.valueOf(c.c.c));
            a2.a("portraitNum", String.valueOf(c.c.a));
            a2.a("portraitFailnum", String.valueOf(c.c.b));
            a2.a("tiebaCostTime", String.valueOf(c.d.c));
            a2.a("tiebaNum", String.valueOf(c.d.a));
            a2.a("tiebaFailnum", String.valueOf(c.d.b));
            a2.a("otherCostTime", String.valueOf(c.e.c));
            a2.a("otherNum", String.valueOf(c.e.a));
            a2.a("otherFailnum", String.valueOf(c.e.b));
            a2.a("dnsFailNum", String.valueOf(c.a));
            a2.a("isWifi", TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK);
            a2.a("localIp", n.a());
            a2.a("tbIp", str);
            a2.a("cdnIp", str2);
            a2.a("dnsIp", str3);
            com.baidu.adp.lib.stats.h.a().a("img", a2);
            c.b();
        }
    }

    public static void a(com.baidu.adp.lib.stats.s sVar, String str, String str2, boolean z, boolean z2, boolean z3, int i, String str3, long j) {
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
            if (sVar == null) {
                sVar = a();
            }
            sVar.a("act", "dc");
            sVar.a("costTime", String.valueOf(j));
            sVar.a("url", str);
            sVar.a("fullURL", str2);
            sVar.a("isWebp", z3 ? TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK : "0");
            sVar.a("isCDN", z2 ? TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK : "0");
            sVar.a("length", String.valueOf(i));
            sVar.a("reason", str3);
            sVar.a("result", z ? "0" : TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK);
            com.baidu.adp.lib.stats.h.a().a("img", sVar);
        }
    }

    public static void d() {
        if (e.a > 10) {
            com.baidu.adp.lib.stats.s a2 = a();
            a2.a("act", "dcStat");
            a2.a("costTime", String.valueOf(e.c));
            a2.a("num", String.valueOf(e.a));
            a2.a("failnum", String.valueOf(e.b));
            com.baidu.adp.lib.stats.h.a().a("img", a2);
            e.a();
        }
    }

    private static String e() {
        return UtilHelper.getIpFromDomain("tieba.baidu.com");
    }

    private static String a(String str) {
        int indexOf = str.indexOf("hiphotos.baidu.com");
        return indexOf > 0 ? UtilHelper.getIpFromDomain(String.valueOf(str.substring(0, indexOf).replace("http://", "")) + "hiphotos.baidu.com") : "";
    }

    private static String f() {
        try {
            DhcpInfo dhcpInfo = ((WifiManager) BdBaseApplication.getInst().getApp().getSystemService("wifi")).getDhcpInfo();
            return String.valueOf(a(dhcpInfo.dns1)) + "," + a(dhcpInfo.dns2);
        } catch (Exception e2) {
            BdLog.e("Cannot get DNSIP");
            return "";
        }
    }

    private static String a(int i) {
        return String.valueOf(i & MotionEventCompat.ACTION_MASK) + "." + ((i >> 8) & MotionEventCompat.ACTION_MASK) + "." + ((i >> 16) & MotionEventCompat.ACTION_MASK) + "." + ((i >> 24) & MotionEventCompat.ACTION_MASK);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [381=4] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static long g() {
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
            com.baidu.adp.lib.f.a.a(httpURLConnection);
            j = currentTimeMillis2;
        } catch (SocketTimeoutException e4) {
            com.baidu.adp.lib.f.a.a(httpURLConnection);
            j = 2500;
            if (j > 0) {
            }
        } catch (Exception e5) {
            httpURLConnection2 = httpURLConnection;
            com.baidu.adp.lib.f.a.a(httpURLConnection2);
            j = -1;
            if (j > 0) {
            }
        } catch (Throwable th2) {
            httpURLConnection2 = httpURLConnection;
            th = th2;
            com.baidu.adp.lib.f.a.a(httpURLConnection2);
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

    private static String h() {
        return com.baidu.tbadk.imageManager.e.a().d();
    }

    private static String i() {
        return com.baidu.adp.lib.asyncTask.f.b().a();
    }
}
