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
    private static final Map<String, b> xt = new HashMap();
    private static final Object xu = new Object();
    private static DateFormat xv = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.CHINESE);
    private long startTime;
    private String type;
    private LinkedList<a> xw = new LinkedList<>();

    private static b aV(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "Default";
        }
        if (!xt.containsKey(str)) {
            synchronized (xu) {
                if (!xt.containsKey(str)) {
                    b bVar = new b(str);
                    xt.put(str, bVar);
                    return bVar;
                }
            }
        }
        return xt.get(str);
    }

    public static b iR() {
        return aV("plugin_load");
    }

    public static void y(String str, String str2) {
        iR().trace(str, str2);
    }

    b(String str) {
        this.type = str;
    }

    public void trace(String str, String str2) {
        iS();
        iT();
        this.xw.add(new a(str, str2));
    }

    private void iS() {
        if (this.startTime == 0) {
            this.startTime = System.currentTimeMillis();
        }
    }

    private void iT() {
        while (this.xw.size() >= 70) {
            this.xw.poll();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("trace_" + this.type + "{begin@" + xv.format(new Date(this.startTime)) + "->");
        for (int i = 0; i < this.xw.size(); i++) {
            a aVar = this.xw.get(i);
            sb.append(String.format("%s(%s)@%s", aVar.method, aVar.xx, xv.format(new Date(aVar.time))));
            if (i < this.xw.size() - 1) {
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
        private String xx;

        a(String str, String str2, long j) {
            this.method = str;
            this.xx = str2;
            this.time = j;
        }

        a(String str, String str2) {
            this(str, str2, System.currentTimeMillis());
        }
    }
}
