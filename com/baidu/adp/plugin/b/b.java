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
    private static final Map<String, b> QW = new HashMap();
    private static final Object QX = new Object();
    private static DateFormat QY = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.CHINESE);
    private LinkedList<a> QZ = new LinkedList<>();
    private long startTime;
    private String type;

    private static b cm(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "Default";
        }
        if (!QW.containsKey(str)) {
            synchronized (QX) {
                if (!QW.containsKey(str)) {
                    b bVar = new b(str);
                    QW.put(str, bVar);
                    return bVar;
                }
            }
        }
        return QW.get(str);
    }

    public static b nI() {
        return cm("plugin_load");
    }

    public static void E(String str, String str2) {
        nI().trace(str, str2);
    }

    b(String str) {
        this.type = str;
    }

    public void trace(String str, String str2) {
        nJ();
        nK();
        this.QZ.add(new a(str, str2));
    }

    private void nJ() {
        if (this.startTime == 0) {
            this.startTime = System.currentTimeMillis();
        }
    }

    private void nK() {
        while (this.QZ.size() >= 70) {
            this.QZ.poll();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("trace_" + this.type + "{begin@" + QY.format(new Date(this.startTime)) + "->");
        for (int i = 0; i < this.QZ.size(); i++) {
            a aVar = this.QZ.get(i);
            sb.append(String.format("%s(%s)@%s", aVar.method, aVar.Ra, QY.format(new Date(aVar.time))));
            if (i < this.QZ.size() - 1) {
                sb.append("->");
            }
        }
        sb.append("->end}");
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {
        private String Ra;
        private String method;
        private long time;

        a(String str, String str2, long j) {
            this.method = str;
            this.Ra = str2;
            this.time = j;
        }

        a(String str, String str2) {
            this(str, str2, System.currentTimeMillis());
        }
    }
}
