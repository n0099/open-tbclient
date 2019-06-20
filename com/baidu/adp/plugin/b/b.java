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
    private static final Map<String, b> It = new HashMap();
    private static final Object Iu = new Object();
    private static DateFormat Iv = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.CHINESE);
    private LinkedList<a> Iw = new LinkedList<>();
    private long startTime;
    private String type;

    private static b bA(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "Default";
        }
        if (!It.containsKey(str)) {
            synchronized (Iu) {
                if (!It.containsKey(str)) {
                    b bVar = new b(str);
                    It.put(str, bVar);
                    return bVar;
                }
            }
        }
        return It.get(str);
    }

    public static b lP() {
        return bA("plugin_load");
    }

    public static void C(String str, String str2) {
        lP().trace(str, str2);
    }

    b(String str) {
        this.type = str;
    }

    public void trace(String str, String str2) {
        lQ();
        lR();
        this.Iw.add(new a(str, str2));
    }

    private void lQ() {
        if (this.startTime == 0) {
            this.startTime = System.currentTimeMillis();
        }
    }

    private void lR() {
        while (this.Iw.size() >= 70) {
            this.Iw.poll();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("trace_" + this.type + "{begin@" + Iv.format(new Date(this.startTime)) + "->");
        for (int i = 0; i < this.Iw.size(); i++) {
            a aVar = this.Iw.get(i);
            sb.append(String.format("%s(%s)@%s", aVar.method, aVar.Ix, Iv.format(new Date(aVar.time))));
            if (i < this.Iw.size() - 1) {
                sb.append("->");
            }
        }
        sb.append("->end}");
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {
        private String Ix;
        private String method;
        private long time;

        a(String str, String str2, long j) {
            this.method = str;
            this.Ix = str2;
            this.time = j;
        }

        a(String str, String str2) {
            this(str, str2, System.currentTimeMillis());
        }
    }
}
