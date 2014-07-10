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
public class ae {
    private static long a = 0;
    private static long b = 0;
    private static af c = new af(null);
    private static ag d = new ag(null);
    private static ag e = new ag(null);
    private static String f = null;
    private static Object g = new Object();

    private static ag a(boolean z, boolean z2, String str) {
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

    public static com.baidu.adp.lib.stats.o a() {
        return com.baidu.adp.lib.stats.d.b().a("dbg");
    }

    public static void a(com.baidu.adp.lib.stats.o oVar, String str, boolean z, long j, boolean z2) {
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
            com.baidu.adp.lib.stats.o a2 = a();
            a2.a("act", "locStat");
            a2.a("costTime", String.valueOf(d.c));
            a2.a("num", String.valueOf(d.a));
            a2.a("isWifi", TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK);
            com.baidu.adp.lib.stats.d.b().a("img", a2);
            d.a();
        }
    }

    public static void a(com.baidu.adp.lib.stats.o oVar, String str, boolean z, String str2, boolean z2, Boolean bool, com.baidu.adp.lib.network.http.d dVar, String str3, long j) {
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
                i.a().a(j, str);
            } else {
                str4 = ah.a().b();
                if (!TextUtils.isEmpty(str4)) {
                    i.a().a(dVar.i, str);
                }
            }
        }
        if (z3) {
            f = str;
        }
        synchronized (g) {
            ag a3 = a(a2, z3, str2);
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
                if (z3 && (j > 3000 || !z)) {
                    com.baidu.tbadk.core.util.httpNet.a.a().a(str2, dVar.k);
                }
                if (oVar == null) {
                    oVar = a();
                }
                String b2 = TextUtils.isEmpty(str4) ? ah.a().b() : str4;
                if (z3 && TextUtils.isEmpty("")) {
                    str5 = ah.a().a(str);
                }
                if (TextUtils.isEmpty("")) {
                    str6 = e();
                }
                oVar.a("url", str);
                oVar.a("act", "dl");
                oVar.a("result", z ? "0" : TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK);
                oVar.a("fullurl", str2);
                oVar.a("costTime", String.valueOf(j));
                oVar.a("connTime", String.valueOf(dVar.c));
                oVar.a("rspTime", String.valueOf(dVar.d));
                oVar.a("retry", String.valueOf(dVar.e));
                oVar.a("localIp", n.a());
                oVar.a("tiebaIp", b2);
                oVar.a("cdnIp", str5);
                oVar.a("useIp", dVar.k);
                oVar.a("dnsIp", str6);
                if (dVar.c > 1500 || dVar.c < 0) {
                    oVar.a("connBaidu", String.valueOf(f()));
                }
                oVar.a("memory", g());
                oVar.a("task", h());
                oVar.a("isWifi", a2 ? TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK : "0");
                oVar.a("status", String.valueOf(dVar.j));
                oVar.a("up", String.valueOf(dVar.a));
                oVar.a("down", String.valueOf(dVar.b));
                oVar.a("isCDN", z3 ? TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK : "0");
                oVar.a("isWebp", bool.booleanValue() ? TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK : "0");
                oVar.a("exception", dVar.h);
                oVar.a("reason", str3);
                com.baidu.adp.lib.stats.d.b().a("img", oVar);
                if (z3 && !TextUtils.isEmpty(b2) && TextUtils.isEmpty(str5) && !z) {
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
                str = ah.a().b();
            }
            if (f != null && TextUtils.isEmpty("")) {
                str2 = ah.a().a(f);
            }
            if (TextUtils.isEmpty("")) {
                str3 = e();
            }
            com.baidu.adp.lib.stats.o a2 = a();
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
            com.baidu.adp.lib.stats.d.b().a("img", a2);
            c.b();
        }
    }

    public static void a(com.baidu.adp.lib.stats.o oVar, String str, String str2, boolean z, boolean z2, boolean z3, int i, String str3, long j, String str4) {
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
            if (oVar == null) {
                oVar = a();
            }
            oVar.a("act", "dc");
            oVar.a("costTime", String.valueOf(j));
            oVar.a("url", str);
            oVar.a("fullURL", str2);
            oVar.a("isWebp", z3 ? TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK : "0");
            oVar.a("isCDN", z2 ? TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK : "0");
            oVar.a("length", String.valueOf(i));
            oVar.a("reason", str3);
            oVar.a("result", z ? "0" : TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK);
            oVar.a("execption", str4);
            com.baidu.adp.lib.stats.d.b().a("img", oVar);
        }
    }

    public static void d() {
        if (e.a > 10) {
            com.baidu.adp.lib.stats.o a2 = a();
            a2.a("act", "dcStat");
            a2.a("costTime", String.valueOf(e.c));
            a2.a("num", String.valueOf(e.a));
            a2.a("failnum", String.valueOf(e.b));
            com.baidu.adp.lib.stats.d.b().a("img", a2);
            e.a();
        }
    }

    public static void a(boolean z, long j) {
        com.baidu.adp.lib.stats.o a2 = a();
        a2.a("act", "ipswitch");
        a2.a("isOpen", z ? TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK : "0");
        a2.a("dnsTime", String.valueOf(j));
        com.baidu.adp.lib.stats.d.b().a("img", a2);
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [384=4] */
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

    private static String g() {
        return com.baidu.tbadk.imageManager.e.a().d();
    }

    private static String h() {
        return com.baidu.adp.lib.asyncTask.f.b().a();
    }
}
