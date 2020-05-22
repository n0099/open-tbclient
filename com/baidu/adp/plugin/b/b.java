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
    private static final Map<String, b> Rh = new HashMap();
    private static final Object Ri = new Object();
    private static DateFormat Rj = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.CHINESE);
    private LinkedList<a> Rk = new LinkedList<>();
    private long startTime;
    private String type;

    private static b cn(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "Default";
        }
        if (!Rh.containsKey(str)) {
            synchronized (Ri) {
                if (!Rh.containsKey(str)) {
                    b bVar = new b(str);
                    Rh.put(str, bVar);
                    return bVar;
                }
            }
        }
        return Rh.get(str);
    }

    public static b nK() {
        return cn("plugin_load");
    }

    public static void E(String str, String str2) {
        nK().trace(str, str2);
    }

    b(String str) {
        this.type = str;
    }

    public void trace(String str, String str2) {
        nL();
        nM();
        this.Rk.add(new a(str, str2));
    }

    private void nL() {
        if (this.startTime == 0) {
            this.startTime = System.currentTimeMillis();
        }
    }

    private void nM() {
        while (this.Rk.size() >= 70) {
            this.Rk.poll();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("trace_" + this.type + "{begin@" + Rj.format(new Date(this.startTime)) + "->");
        for (int i = 0; i < this.Rk.size(); i++) {
            a aVar = this.Rk.get(i);
            sb.append(String.format("%s(%s)@%s", aVar.method, aVar.Rl, Rj.format(new Date(aVar.time))));
            if (i < this.Rk.size() - 1) {
                sb.append("->");
            }
        }
        sb.append("->end}");
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {
        private String Rl;
        private String method;
        private long time;

        a(String str, String str2, long j) {
            this.method = str;
            this.Rl = str2;
            this.time = j;
        }

        a(String str, String str2) {
            this(str, str2, System.currentTimeMillis());
        }
    }
}
