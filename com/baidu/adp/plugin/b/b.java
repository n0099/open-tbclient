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
    private static final Map<String, b> SX = new HashMap();
    private static final Object SY = new Object();
    private static DateFormat SZ = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.CHINESE);
    private LinkedList<a> Ta = new LinkedList<>();
    private long startTime;
    private String type;

    private static b cu(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "Default";
        }
        if (!SX.containsKey(str)) {
            synchronized (SY) {
                if (!SX.containsKey(str)) {
                    b bVar = new b(str);
                    SX.put(str, bVar);
                    return bVar;
                }
            }
        }
        return SX.get(str);
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
        this.Ta.add(new a(str, str2));
    }

    private void pH() {
        if (this.startTime == 0) {
            this.startTime = System.currentTimeMillis();
        }
    }

    private void pI() {
        while (this.Ta.size() >= 70) {
            this.Ta.poll();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("trace_" + this.type + "{begin@" + SZ.format(new Date(this.startTime)) + "->");
        for (int i = 0; i < this.Ta.size(); i++) {
            a aVar = this.Ta.get(i);
            sb.append(String.format("%s(%s)@%s", aVar.method, aVar.Tb, SZ.format(new Date(aVar.time))));
            if (i < this.Ta.size() - 1) {
                sb.append("->");
            }
        }
        sb.append("->end}");
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {
        private String Tb;
        private String method;
        private long time;

        a(String str, String str2, long j) {
            this.method = str;
            this.Tb = str2;
            this.time = j;
        }

        a(String str, String str2) {
            this(str, str2, System.currentTimeMillis());
        }
    }
}
