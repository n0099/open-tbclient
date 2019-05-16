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
    private static final Map<String, b> Iu = new HashMap();
    private static final Object Iv = new Object();
    private static DateFormat Iw = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.CHINESE);
    private LinkedList<a> Ix = new LinkedList<>();
    private long startTime;
    private String type;

    private static b bA(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "Default";
        }
        if (!Iu.containsKey(str)) {
            synchronized (Iv) {
                if (!Iu.containsKey(str)) {
                    b bVar = new b(str);
                    Iu.put(str, bVar);
                    return bVar;
                }
            }
        }
        return Iu.get(str);
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
        this.Ix.add(new a(str, str2));
    }

    private void lQ() {
        if (this.startTime == 0) {
            this.startTime = System.currentTimeMillis();
        }
    }

    private void lR() {
        while (this.Ix.size() >= 70) {
            this.Ix.poll();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("trace_" + this.type + "{begin@" + Iw.format(new Date(this.startTime)) + "->");
        for (int i = 0; i < this.Ix.size(); i++) {
            a aVar = this.Ix.get(i);
            sb.append(String.format("%s(%s)@%s", aVar.method, aVar.Iy, Iw.format(new Date(aVar.time))));
            if (i < this.Ix.size() - 1) {
                sb.append("->");
            }
        }
        sb.append("->end}");
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {
        private String Iy;
        private String method;
        private long time;

        a(String str, String str2, long j) {
            this.method = str;
            this.Iy = str2;
            this.time = j;
        }

        a(String str, String str2) {
            this(str, str2, System.currentTimeMillis());
        }
    }
}
