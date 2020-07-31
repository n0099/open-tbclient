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
    private static final Map<String, b> RF = new HashMap();
    private static final Object RG = new Object();
    private static DateFormat RH = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.CHINESE);
    private LinkedList<a> RI = new LinkedList<>();
    private long startTime;
    private String type;

    private static b cm(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "Default";
        }
        if (!RF.containsKey(str)) {
            synchronized (RG) {
                if (!RF.containsKey(str)) {
                    b bVar = new b(str);
                    RF.put(str, bVar);
                    return bVar;
                }
            }
        }
        return RF.get(str);
    }

    public static b ob() {
        return cm("plugin_load");
    }

    public static void D(String str, String str2) {
        ob().trace(str, str2);
    }

    b(String str) {
        this.type = str;
    }

    public void trace(String str, String str2) {
        oc();
        od();
        this.RI.add(new a(str, str2));
    }

    private void oc() {
        if (this.startTime == 0) {
            this.startTime = System.currentTimeMillis();
        }
    }

    private void od() {
        while (this.RI.size() >= 70) {
            this.RI.poll();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("trace_" + this.type + "{begin@" + RH.format(new Date(this.startTime)) + "->");
        for (int i = 0; i < this.RI.size(); i++) {
            a aVar = this.RI.get(i);
            sb.append(String.format("%s(%s)@%s", aVar.method, aVar.RJ, RH.format(new Date(aVar.time))));
            if (i < this.RI.size() - 1) {
                sb.append("->");
            }
        }
        sb.append("->end}");
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {
        private String RJ;
        private String method;
        private long time;

        a(String str, String str2, long j) {
            this.method = str;
            this.RJ = str2;
            this.time = j;
        }

        a(String str, String str2) {
            this(str, str2, System.currentTimeMillis());
        }
    }
}
