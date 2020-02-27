package com.baidu.adp.plugin.b;

import android.text.TextUtils;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Map;
/* loaded from: classes.dex */
public class b {
    private static final Map<String, b> xP = new HashMap();
    private static final Object xQ = new Object();
    private static DateFormat xR = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.CHINESE);
    private long startTime;
    private String type;
    private LinkedList<a> xS = new LinkedList<>();

    private static b aX(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "Default";
        }
        if (!xP.containsKey(str)) {
            synchronized (xQ) {
                if (!xP.containsKey(str)) {
                    b bVar = new b(str);
                    xP.put(str, bVar);
                    return bVar;
                }
            }
        }
        return xP.get(str);
    }

    public static b jf() {
        return aX("plugin_load");
    }

    public static void A(String str, String str2) {
        jf().trace(str, str2);
    }

    b(String str) {
        this.type = str;
    }

    public void trace(String str, String str2) {
        jg();
        jh();
        this.xS.add(new a(str, str2));
    }

    private void jg() {
        if (this.startTime == 0) {
            this.startTime = System.currentTimeMillis();
        }
    }

    private void jh() {
        while (this.xS.size() >= 70) {
            this.xS.poll();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("trace_" + this.type + "{begin@" + xR.format(new Date(this.startTime)) + "->");
        for (int i = 0; i < this.xS.size(); i++) {
            a aVar = this.xS.get(i);
            sb.append(String.format("%s(%s)@%s", aVar.method, aVar.xT, xR.format(new Date(aVar.time))));
            if (i < this.xS.size() - 1) {
                sb.append("->");
            }
        }
        sb.append("->end}");
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {
        private String method;
        private long time;
        private String xT;

        a(String str, String str2, long j) {
            this.method = str;
            this.xT = str2;
            this.time = j;
        }

        a(String str, String str2) {
            this(str, str2, System.currentTimeMillis());
        }
    }
}
