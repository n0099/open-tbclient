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
    private static final Map<String, b> Sl = new HashMap();
    private static final Object Sm = new Object();
    private static DateFormat Sn = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.CHINESE);
    private LinkedList<a> So = new LinkedList<>();
    private long startTime;
    private String type;

    private static b cs(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "Default";
        }
        if (!Sl.containsKey(str)) {
            synchronized (Sm) {
                if (!Sl.containsKey(str)) {
                    b bVar = new b(str);
                    Sl.put(str, bVar);
                    return bVar;
                }
            }
        }
        return Sl.get(str);
    }

    public static b pB() {
        return cs("plugin_load");
    }

    public static void F(String str, String str2) {
        pB().trace(str, str2);
    }

    b(String str) {
        this.type = str;
    }

    public void trace(String str, String str2) {
        pC();
        pD();
        this.So.add(new a(str, str2));
    }

    private void pC() {
        if (this.startTime == 0) {
            this.startTime = System.currentTimeMillis();
        }
    }

    private void pD() {
        while (this.So.size() >= 70) {
            this.So.poll();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("trace_" + this.type + "{begin@" + Sn.format(new Date(this.startTime)) + "->");
        for (int i = 0; i < this.So.size(); i++) {
            a aVar = this.So.get(i);
            sb.append(String.format("%s(%s)@%s", aVar.method, aVar.Sp, Sn.format(new Date(aVar.time))));
            if (i < this.So.size() - 1) {
                sb.append("->");
            }
        }
        sb.append("->end}");
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {
        private String Sp;
        private String method;
        private long time;

        a(String str, String str2, long j) {
            this.method = str;
            this.Sp = str2;
            this.time = j;
        }

        a(String str, String str2) {
            this(str, str2, System.currentTimeMillis());
        }
    }
}
