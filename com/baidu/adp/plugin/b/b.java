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
    private static final Map<String, b> QT = new HashMap();
    private static final Object QU = new Object();
    private static DateFormat QV = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.CHINESE);
    private LinkedList<a> QW = new LinkedList<>();
    private long startTime;
    private String type;

    private static b cm(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "Default";
        }
        if (!QT.containsKey(str)) {
            synchronized (QU) {
                if (!QT.containsKey(str)) {
                    b bVar = new b(str);
                    QT.put(str, bVar);
                    return bVar;
                }
            }
        }
        return QT.get(str);
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
        this.QW.add(new a(str, str2));
    }

    private void nJ() {
        if (this.startTime == 0) {
            this.startTime = System.currentTimeMillis();
        }
    }

    private void nK() {
        while (this.QW.size() >= 70) {
            this.QW.poll();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("trace_" + this.type + "{begin@" + QV.format(new Date(this.startTime)) + "->");
        for (int i = 0; i < this.QW.size(); i++) {
            a aVar = this.QW.get(i);
            sb.append(String.format("%s(%s)@%s", aVar.method, aVar.QX, QV.format(new Date(aVar.time))));
            if (i < this.QW.size() - 1) {
                sb.append("->");
            }
        }
        sb.append("->end}");
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {
        private String QX;
        private String method;
        private long time;

        a(String str, String str2, long j) {
            this.method = str;
            this.QX = str2;
            this.time = j;
        }

        a(String str, String str2) {
            this(str, str2, System.currentTimeMillis());
        }
    }
}
