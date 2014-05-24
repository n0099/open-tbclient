package com.baidu.tbadk.core.util;

import android.text.TextUtils;
import com.baidu.adp.lib.resourceLoader.BdResourceLoaderNetHelperStatic;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class ac {
    private static int a = 0;
    private static int b = 0;
    private static int c = 0;
    private static int d = 0;
    private static int e = 0;
    private static int f = 0;
    private static int g = 0;
    private static int h = 0;
    private static long i = 0;
    private static long j = 0;
    private static long k = 0;
    private static long l = 0;
    private static int m = 0;
    private static int n = 0;
    private static int o = 0;
    private static int p = 0;
    private static long q = 0;
    private static long r = 0;
    private static int s = 0;
    private static long t = 0;
    private static String u = null;
    private static Object v = new Object();

    public static com.baidu.adp.lib.stats.s a() {
        return com.baidu.adp.lib.stats.h.a().a("dbg");
    }

    public static void a(com.baidu.adp.lib.stats.s sVar, String str, boolean z, long j2) {
        if (z || j2 > 400) {
            synchronized (v) {
                s++;
                t += j2;
                if (s >= 100) {
                    b();
                }
            }
        }
    }

    public static void b() {
        if (s > 0 && t / s > 400) {
            com.baidu.adp.lib.stats.s a2 = a();
            a2.a("act", "locStat");
            a2.a("costTime", String.valueOf(t));
            a2.a("num", String.valueOf(s));
            com.baidu.adp.lib.stats.h.a().a("img", a2);
            s = 0;
            t = 0L;
        }
    }

    public static void a(com.baidu.adp.lib.stats.s sVar, String str, boolean z, String str2, boolean z2, Boolean bool, com.baidu.adp.lib.network.http.d dVar, String str3, long j2) {
        boolean z3;
        int indexOf = str2.indexOf("hiphotos");
        if (indexOf > 0 && indexOf < 20) {
            z3 = true;
        } else {
            z3 = false;
        }
        boolean a2 = BdResourceLoaderNetHelperStatic.a();
        if (z3 && a2) {
            if (z) {
                h.a().a(j2, str);
            } else if (!TextUtils.isEmpty(e())) {
                h.a().a(dVar.i, str);
            }
        }
        if (z3) {
            u = str;
        }
        synchronized (v) {
            if (a2) {
                if (z3) {
                    a++;
                    i += j2;
                    if (!z) {
                        e++;
                    }
                } else {
                    c++;
                    k += j2;
                    if (!z) {
                        g++;
                    }
                }
            } else if (z3) {
                b++;
                j += j2;
                if (!z) {
                    f++;
                }
            } else {
                d++;
                l += j2;
                if (!z) {
                    h++;
                }
            }
            if (a + b + c + d > 100) {
                c();
            }
        }
    }

    public static void c() {
        String str = "";
        String str2 = "";
        if (a > 0 && (e > 0 || i / a > 1500)) {
            if (TextUtils.isEmpty("")) {
                str = e();
            }
            if (u != null && TextUtils.isEmpty("")) {
                str2 = a(u);
            }
            com.baidu.adp.lib.stats.s a2 = a();
            a2.a("act", "dlStat");
            a2.a("costTime", String.valueOf(i));
            a2.a("num", String.valueOf(a));
            a2.a("failnum", String.valueOf(e));
            a2.a("isCDN", TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK);
            a2.a("isWifi", TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK);
            a2.a("localIp", n.a());
            a2.a("tbIp", str);
            a2.a("cdnIp", str2);
            com.baidu.adp.lib.stats.h.a().a("img", a2);
            e = 0;
            a = 0;
            i = 0L;
        }
        if (c > 0 && (g > 0 || k / c > 1500)) {
            com.baidu.adp.lib.stats.s a3 = a();
            a3.a("act", "dlStat");
            a3.a("costTime", String.valueOf(k));
            a3.a("num", String.valueOf(c));
            a3.a("failnum", String.valueOf(g));
            a3.a("isCDN", "0");
            a3.a("isWifi", TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK);
            com.baidu.adp.lib.stats.h.a().a("img", a3);
            g = 0;
            c = 0;
            k = 0L;
        }
        if (b > 0 && (f > 0 || j / b > 4000)) {
            if (TextUtils.isEmpty(str)) {
                str = e();
            }
            if (u != null && TextUtils.isEmpty(str2)) {
                str2 = a(u);
            }
            com.baidu.adp.lib.stats.s a4 = a();
            a4.a("act", "dlStat");
            a4.a("costTime", String.valueOf(j));
            a4.a("num", String.valueOf(b));
            a4.a("failnum", String.valueOf(f));
            a4.a("isCDN", TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK);
            a4.a("isWifi", "0");
            a4.a("localIp", n.a());
            a4.a("tbIp", str);
            a4.a("cdnIp", str2);
            com.baidu.adp.lib.stats.h.a().a("img", a4);
            f = 0;
            b = 0;
            j = 0L;
        }
        if (d > 0) {
            if (h > 0 || l / d > 4000) {
                com.baidu.adp.lib.stats.s a5 = a();
                a5.a("act", "dlStat");
                a5.a("costTime", String.valueOf(l));
                a5.a("num", String.valueOf(d));
                a5.a("failnum", String.valueOf(h));
                a5.a("isCDN", "0");
                a5.a("isWifi", "0");
                com.baidu.adp.lib.stats.h.a().a("img", a5);
                h = 0;
                d = 0;
                l = 0L;
            }
        }
    }

    public static void a(com.baidu.adp.lib.stats.s sVar, String str, String str2, boolean z, boolean z2, boolean z3, int i2, String str3, long j2) {
        synchronized (v) {
            if (z3) {
                m++;
                q += j2;
                if (!z) {
                    n++;
                }
            } else {
                o++;
                r += j2;
                if (!z) {
                    p++;
                }
            }
            if (m + o >= 100) {
                d();
            }
        }
        if (!z) {
            if (sVar == null) {
                sVar = a();
            }
            sVar.a("act", "dc");
            sVar.a("costTime", String.valueOf(j2));
            sVar.a("url", str);
            sVar.a("fullURL", str2);
            sVar.a("isWebp", z3 ? TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK : "0");
            sVar.a("isCDN", z2 ? TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK : "0");
            sVar.a("length", String.valueOf(i2));
            sVar.a("reason", str3);
            sVar.a("result", z ? "0" : TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK);
            com.baidu.adp.lib.stats.h.a().a("img", sVar);
        }
    }

    public static void d() {
        if (m > 0 && (n > 0 || q / m > 300)) {
            com.baidu.adp.lib.stats.s a2 = a();
            a2.a("act", "dcStat");
            a2.a("costTime", String.valueOf(q));
            a2.a("num", String.valueOf(m));
            a2.a("failnum", String.valueOf(n));
            a2.a("isWebp", TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK);
            com.baidu.adp.lib.stats.h.a().a("img", a2);
            n = 0;
            m = 0;
            q = 0L;
        }
        if (o > 0) {
            if (p > 0 || r / o > 300) {
                com.baidu.adp.lib.stats.s a3 = a();
                a3.a("act", "dcStat");
                a3.a("costTime", String.valueOf(r));
                a3.a("num", String.valueOf(o));
                a3.a("failnum", String.valueOf(p));
                a3.a("isWebp", "0");
                com.baidu.adp.lib.stats.h.a().a("img", a3);
                p = 0;
                o = 0;
                r = 0L;
            }
        }
    }

    private static String e() {
        return UtilHelper.getIpFromDomain("tieba.baidu.com");
    }

    private static String a(String str) {
        int indexOf = str.indexOf("hiphotos.baidu.com");
        return indexOf > 0 ? UtilHelper.getIpFromDomain(String.valueOf(str.substring(0, indexOf).replace("http://", "")) + "hiphotos.baidu.com") : "";
    }
}
