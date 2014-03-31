package com.baidu.tbadk.core.log;

import com.baidu.tbadk.core.util.m;
/* loaded from: classes.dex */
public final class j {
    private static LoggerItem a = new LoggerItem(h.c);

    public static synchronized String a(String str, String str2, String str3, String str4, String str5) {
        String loggerItem;
        synchronized (j.class) {
            if (!g.a(a)) {
                loggerItem = null;
            } else {
                a.clear();
                a.put("client_ip", g.a(m.a()));
                a.put("url", g.a(str));
                a.put("downloadTime", g.a(str2));
                a.put("dataSize", g.a(str3));
                a.put("errMsg", g.a(str4));
                a.put("remark", g.a(str5));
                a.initBaseData();
                loggerItem = a.toString();
            }
        }
        return loggerItem;
    }
}
