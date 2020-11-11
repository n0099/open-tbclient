package com.baidu.pano.platform.a.a;

import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.baidu.pano.platform.a.b;
import com.baidu.webkit.internal.ETAG;
import com.baidubce.http.Headers;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Map;
import org.apache.http.impl.cookie.DateParseException;
import org.apache.http.impl.cookie.DateUtils;
/* loaded from: classes7.dex */
public class h {
    public static b.a a(com.baidu.pano.platform.a.l lVar) {
        boolean z;
        boolean z2;
        long j;
        long j2;
        long j3;
        long j4;
        long currentTimeMillis = System.currentTimeMillis();
        Map<String, String> map = lVar.c;
        long j5 = 0;
        long j6 = 0;
        long j7 = 0;
        String str = map.get("Date");
        if (str != null) {
            j5 = a(str);
        }
        String str2 = map.get(Headers.CACHE_CONTROL);
        if (str2 == null) {
            z = false;
            z2 = false;
        } else {
            String[] split = str2.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
            z = false;
            long j8 = 0;
            long j9 = 0;
            for (String str3 : split) {
                String trim = str3.trim();
                if (trim.equals("no-cache") || trim.equals("no-store")) {
                    return null;
                }
                if (trim.startsWith("max-age=")) {
                    try {
                        j9 = Long.parseLong(trim.substring(8));
                    } catch (Exception e) {
                    }
                } else if (trim.startsWith("stale-while-revalidate=")) {
                    try {
                        j8 = Long.parseLong(trim.substring(23));
                    } catch (Exception e2) {
                    }
                } else if (trim.equals("must-revalidate") || trim.equals("proxy-revalidate")) {
                    z = true;
                }
            }
            j6 = j9;
            j7 = j8;
            z2 = true;
        }
        String str4 = map.get(Headers.EXPIRES);
        if (str4 == null) {
            j = 0;
        } else {
            j = a(str4);
        }
        String str5 = map.get(Headers.LAST_MODIFIED);
        if (str5 == null) {
            j2 = 0;
        } else {
            j2 = a(str5);
        }
        String str6 = map.get(Headers.ETAG);
        if (z2) {
            j4 = currentTimeMillis + (1000 * j6);
            j3 = z ? j4 : (1000 * j7) + j4;
        } else if (j5 <= 0 || j < j5) {
            j3 = 0;
            j4 = 0;
        } else {
            j3 = (j - j5) + currentTimeMillis;
            j4 = j3;
        }
        b.a aVar = new b.a();
        aVar.f2648a = lVar.b;
        aVar.b = str6;
        aVar.f = j4;
        aVar.e = j3;
        aVar.c = j5;
        aVar.d = j2;
        aVar.g = map;
        return aVar;
    }

    public static long a(String str) {
        try {
            return DateUtils.parseDate(str).getTime();
        } catch (DateParseException e) {
            return 0L;
        }
    }

    public static String a(Map<String, String> map, String str) {
        String str2 = map.get("Content-Type");
        if (str2 != null) {
            String[] split = str2.split(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
            for (int i = 1; i < split.length; i++) {
                String[] split2 = split[i].trim().split(ETAG.EQUAL);
                if (split2.length == 2 && split2[0].equals("charset")) {
                    return split2[1];
                }
            }
            return str;
        }
        return str;
    }

    public static String a(Map<String, String> map) {
        return a(map, "ISO-8859-1");
    }
}
