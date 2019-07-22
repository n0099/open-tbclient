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
    private static final Map<String, b> IF = new HashMap();
    private static final Object IG = new Object();
    private static DateFormat IH = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.CHINESE);
    private LinkedList<a> II = new LinkedList<>();
    private long startTime;
    private String type;

    private static b bC(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "Default";
        }
        if (!IF.containsKey(str)) {
            synchronized (IG) {
                if (!IF.containsKey(str)) {
                    b bVar = new b(str);
                    IF.put(str, bVar);
                    return bVar;
                }
            }
        }
        return IF.get(str);
    }

    public static b mf() {
        return bC("plugin_load");
    }

    public static void C(String str, String str2) {
        mf().trace(str, str2);
    }

    b(String str) {
        this.type = str;
    }

    public void trace(String str, String str2) {
        mg();
        mh();
        this.II.add(new a(str, str2));
    }

    private void mg() {
        if (this.startTime == 0) {
            this.startTime = System.currentTimeMillis();
        }
    }

    private void mh() {
        while (this.II.size() >= 70) {
            this.II.poll();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("trace_" + this.type + "{begin@" + IH.format(new Date(this.startTime)) + "->");
        for (int i = 0; i < this.II.size(); i++) {
            a aVar = this.II.get(i);
            sb.append(String.format("%s(%s)@%s", aVar.method, aVar.IJ, IH.format(new Date(aVar.time))));
            if (i < this.II.size() - 1) {
                sb.append("->");
            }
        }
        sb.append("->end}");
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {
        private String IJ;
        private String method;
        private long time;

        a(String str, String str2, long j) {
            this.method = str;
            this.IJ = str2;
            this.time = j;
        }

        a(String str, String str2) {
            this(str, str2, System.currentTimeMillis());
        }
    }
}
