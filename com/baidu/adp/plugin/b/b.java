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
    private static final Map<String, b> SZ = new HashMap();
    private static final Object Ta = new Object();
    private static DateFormat Tb = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.CHINESE);
    private LinkedList<a> Tc = new LinkedList<>();
    private long startTime;
    private String type;

    private static b cw(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "Default";
        }
        if (!SZ.containsKey(str)) {
            synchronized (Ta) {
                if (!SZ.containsKey(str)) {
                    b bVar = new b(str);
                    SZ.put(str, bVar);
                    return bVar;
                }
            }
        }
        return SZ.get(str);
    }

    public static b pG() {
        return cw("plugin_load");
    }

    public static void E(String str, String str2) {
        pG().trace(str, str2);
    }

    b(String str) {
        this.type = str;
    }

    public void trace(String str, String str2) {
        pH();
        pI();
        this.Tc.add(new a(str, str2));
    }

    private void pH() {
        if (this.startTime == 0) {
            this.startTime = System.currentTimeMillis();
        }
    }

    private void pI() {
        while (this.Tc.size() >= 70) {
            this.Tc.poll();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("trace_" + this.type + "{begin@" + Tb.format(new Date(this.startTime)) + "->");
        for (int i = 0; i < this.Tc.size(); i++) {
            a aVar = this.Tc.get(i);
            sb.append(String.format("%s(%s)@%s", aVar.method, aVar.Td, Tb.format(new Date(aVar.time))));
            if (i < this.Tc.size() - 1) {
                sb.append("->");
            }
        }
        sb.append("->end}");
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {
        private String Td;
        private String method;
        private long time;

        a(String str, String str2, long j) {
            this.method = str;
            this.Td = str2;
            this.time = j;
        }

        a(String str, String str2) {
            this(str, str2, System.currentTimeMillis());
        }
    }
}
