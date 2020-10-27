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
    private static final Map<String, b> SY = new HashMap();
    private static final Object SZ = new Object();
    private static DateFormat Ta = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.CHINESE);
    private LinkedList<a> Tb = new LinkedList<>();
    private long startTime;
    private String type;

    private static b cu(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "Default";
        }
        if (!SY.containsKey(str)) {
            synchronized (SZ) {
                if (!SY.containsKey(str)) {
                    b bVar = new b(str);
                    SY.put(str, bVar);
                    return bVar;
                }
            }
        }
        return SY.get(str);
    }

    public static b pG() {
        return cu("plugin_load");
    }

    public static void F(String str, String str2) {
        pG().trace(str, str2);
    }

    b(String str) {
        this.type = str;
    }

    public void trace(String str, String str2) {
        pH();
        pI();
        this.Tb.add(new a(str, str2));
    }

    private void pH() {
        if (this.startTime == 0) {
            this.startTime = System.currentTimeMillis();
        }
    }

    private void pI() {
        while (this.Tb.size() >= 70) {
            this.Tb.poll();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("trace_" + this.type + "{begin@" + Ta.format(new Date(this.startTime)) + "->");
        for (int i = 0; i < this.Tb.size(); i++) {
            a aVar = this.Tb.get(i);
            sb.append(String.format("%s(%s)@%s", aVar.method, aVar.Tc, Ta.format(new Date(aVar.time))));
            if (i < this.Tb.size() - 1) {
                sb.append("->");
            }
        }
        sb.append("->end}");
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {
        private String Tc;
        private String method;
        private long time;

        a(String str, String str2, long j) {
            this.method = str;
            this.Tc = str2;
            this.time = j;
        }

        a(String str, String str2) {
            this(str, str2, System.currentTimeMillis());
        }
    }
}
