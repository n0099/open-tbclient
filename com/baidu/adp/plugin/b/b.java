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
    private static final Map<String, b> xx = new HashMap();
    private static final Object xy = new Object();
    private static DateFormat xz = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.CHINESE);
    private long startTime;
    private String type;
    private LinkedList<a> xA = new LinkedList<>();

    private static b aV(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "Default";
        }
        if (!xx.containsKey(str)) {
            synchronized (xy) {
                if (!xx.containsKey(str)) {
                    b bVar = new b(str);
                    xx.put(str, bVar);
                    return bVar;
                }
            }
        }
        return xx.get(str);
    }

    public static b iQ() {
        return aV("plugin_load");
    }

    public static void x(String str, String str2) {
        iQ().trace(str, str2);
    }

    b(String str) {
        this.type = str;
    }

    public void trace(String str, String str2) {
        iR();
        iS();
        this.xA.add(new a(str, str2));
    }

    private void iR() {
        if (this.startTime == 0) {
            this.startTime = System.currentTimeMillis();
        }
    }

    private void iS() {
        while (this.xA.size() >= 70) {
            this.xA.poll();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("trace_" + this.type + "{begin@" + xz.format(new Date(this.startTime)) + "->");
        for (int i = 0; i < this.xA.size(); i++) {
            a aVar = this.xA.get(i);
            sb.append(String.format("%s(%s)@%s", aVar.method, aVar.xB, xz.format(new Date(aVar.time))));
            if (i < this.xA.size() - 1) {
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
        private String xB;

        a(String str, String str2, long j) {
            this.method = str;
            this.xB = str2;
            this.time = j;
        }

        a(String str, String str2) {
            this(str, str2, System.currentTimeMillis());
        }
    }
}
