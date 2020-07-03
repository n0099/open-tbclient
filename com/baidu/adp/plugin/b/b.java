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
    private static final Map<String, b> RI = new HashMap();
    private static final Object RJ = new Object();
    private static DateFormat RK = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.CHINESE);
    private LinkedList<a> RL = new LinkedList<>();
    private long startTime;
    private String type;

    private static b co(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "Default";
        }
        if (!RI.containsKey(str)) {
            synchronized (RJ) {
                if (!RI.containsKey(str)) {
                    b bVar = new b(str);
                    RI.put(str, bVar);
                    return bVar;
                }
            }
        }
        return RI.get(str);
    }

    public static b oa() {
        return co("plugin_load");
    }

    public static void E(String str, String str2) {
        oa().trace(str, str2);
    }

    b(String str) {
        this.type = str;
    }

    public void trace(String str, String str2) {
        ob();
        oc();
        this.RL.add(new a(str, str2));
    }

    private void ob() {
        if (this.startTime == 0) {
            this.startTime = System.currentTimeMillis();
        }
    }

    private void oc() {
        while (this.RL.size() >= 70) {
            this.RL.poll();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("trace_" + this.type + "{begin@" + RK.format(new Date(this.startTime)) + "->");
        for (int i = 0; i < this.RL.size(); i++) {
            a aVar = this.RL.get(i);
            sb.append(String.format("%s(%s)@%s", aVar.method, aVar.RO, RK.format(new Date(aVar.time))));
            if (i < this.RL.size() - 1) {
                sb.append("->");
            }
        }
        sb.append("->end}");
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {
        private String RO;
        private String method;
        private long time;

        a(String str, String str2, long j) {
            this.method = str;
            this.RO = str2;
            this.time = j;
        }

        a(String str, String str2) {
            this(str, str2, System.currentTimeMillis());
        }
    }
}
