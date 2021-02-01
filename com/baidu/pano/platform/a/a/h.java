package com.baidu.pano.platform.a.a;

import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.baidu.pano.platform.a.b;
import com.baidubce.http.Headers;
import java.util.Map;
import org.apache.http.impl.cookie.DateParseException;
import org.apache.http.impl.cookie.DateUtils;
/* loaded from: classes4.dex */
public class h {
    public static b.a a(com.baidu.pano.platform.a.l lVar) {
        boolean z;
        long j;
        long j2;
        long j3;
        long j4;
        long currentTimeMillis = System.currentTimeMillis();
        Map<String, String> map = lVar.c;
        long j5 = 0;
        long j6 = 0;
        long j7 = 0;
        boolean z2 = false;
        String str = map.get("Date");
        if (str != null) {
            j5 = a(str);
        }
        String str2 = map.get(Headers.CACHE_CONTROL);
        if (str2 == null) {
            z = false;
        } else {
            String[] split = str2.split(",");
            int i = 0;
            z = false;
            while (i < split.length) {
                String trim = split[i].trim();
                if (trim.equals("no-cache") || trim.equals("no-store")) {
                    return null;
                }
                if (trim.startsWith("max-age=")) {
                    try {
                        j6 = Long.parseLong(trim.substring(8));
                    } catch (Exception e) {
                    }
                } else if (trim.startsWith("stale-while-revalidate=")) {
                    try {
                        j7 = Long.parseLong(trim.substring(23));
                    } catch (Exception e2) {
                    }
                } else if (trim.equals("must-revalidate") || trim.equals("proxy-revalidate")) {
                    z = true;
                }
                i++;
                j7 = j7;
            }
            z2 = true;
        }
        String str3 = map.get(Headers.EXPIRES);
        if (str3 == null) {
            j = 0;
        } else {
            j = a(str3);
        }
        String str4 = map.get(Headers.LAST_MODIFIED);
        if (str4 == null) {
            j2 = 0;
        } else {
            j2 = a(str4);
        }
        String str5 = map.get(Headers.ETAG);
        if (z2) {
            j4 = currentTimeMillis + (1000 * j6);
            j3 = z ? j4 : (1000 * j7) + j4;
        } else if (j5 <= 0 || j < j5) {
            j3 = 0;
            j4 = 0;
        } else {
            long j8 = currentTimeMillis + (j - j5);
            j3 = j8;
            j4 = j8;
        }
        b.a aVar = new b.a();
        aVar.f3867a = lVar.f3884b;
        aVar.f3868b = str5;
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
                String[] split2 = split[i].trim().split("=");
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
