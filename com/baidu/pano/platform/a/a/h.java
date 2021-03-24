package com.baidu.pano.platform.a.a;

import com.baidu.pano.platform.a.b;
import java.util.Map;
import org.apache.http.impl.cookie.DateParseException;
import org.apache.http.impl.cookie.DateUtils;
/* loaded from: classes2.dex */
public class h {
    public static b.a a(com.baidu.pano.platform.a.l lVar) {
        boolean z;
        long j;
        long j2;
        long j3;
        long j4;
        long j5;
        long currentTimeMillis = System.currentTimeMillis();
        Map<String, String> map = lVar.f9380c;
        String str = map.get("Date");
        long a2 = str != null ? a(str) : 0L;
        String str2 = map.get("Cache-Control");
        int i = 0;
        if (str2 != null) {
            String[] split = str2.split(",");
            int i2 = 0;
            j = 0;
            j2 = 0;
            while (i < split.length) {
                String trim = split[i].trim();
                if (trim.equals("no-cache") || trim.equals("no-store")) {
                    return null;
                }
                if (trim.startsWith("max-age=")) {
                    try {
                        j = Long.parseLong(trim.substring(8));
                    } catch (Exception unused) {
                    }
                } else if (trim.startsWith("stale-while-revalidate=")) {
                    j2 = Long.parseLong(trim.substring(23));
                } else if (trim.equals("must-revalidate") || trim.equals("proxy-revalidate")) {
                    i2 = 1;
                }
                i++;
            }
            i = i2;
            z = true;
        } else {
            z = false;
            j = 0;
            j2 = 0;
        }
        String str3 = map.get("Expires");
        long a3 = str3 != null ? a(str3) : 0L;
        String str4 = map.get("Last-Modified");
        long a4 = str4 != null ? a(str4) : 0L;
        String str5 = map.get("ETag");
        if (z) {
            j4 = currentTimeMillis + (j * 1000);
            if (i != 0) {
                j5 = j4;
            } else {
                Long.signum(j2);
                j5 = (j2 * 1000) + j4;
            }
            j3 = j5;
        } else {
            j3 = 0;
            if (a2 <= 0 || a3 < a2) {
                j4 = 0;
            } else {
                j4 = currentTimeMillis + (a3 - a2);
                j3 = j4;
            }
        }
        b.a aVar = new b.a();
        aVar.f9346a = lVar.f9379b;
        aVar.f9347b = str5;
        aVar.f9351f = j4;
        aVar.f9350e = j3;
        aVar.f9348c = a2;
        aVar.f9349d = a4;
        aVar.f9352g = map;
        return aVar;
    }

    public static long a(String str) {
        try {
            return DateUtils.parseDate(str).getTime();
        } catch (DateParseException unused) {
            return 0L;
        }
    }

    public static String a(Map<String, String> map, String str) {
        String str2 = map.get("Content-Type");
        if (str2 != null) {
            String[] split = str2.split(";");
            for (int i = 1; i < split.length; i++) {
                String[] split2 = split[i].trim().split("=");
                if (split2.length == 2 && split2[0].equals("charset")) {
                    return split2[1];
                }
            }
        }
        return str;
    }

    public static String a(Map<String, String> map) {
        return a(map, "ISO-8859-1");
    }
}
