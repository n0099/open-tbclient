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
    private static final Map<String, b> KJ = new HashMap();
    private static final Object KK = new Object();
    private static DateFormat KL = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.CHINESE);
    private LinkedList<a> KM = new LinkedList<>();
    private long startTime;
    private String type;

    private static b bQ(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "Default";
        }
        if (!KJ.containsKey(str)) {
            synchronized (KK) {
                if (!KJ.containsKey(str)) {
                    b bVar = new b(str);
                    KJ.put(str, bVar);
                    return bVar;
                }
            }
        }
        return KJ.get(str);
    }

    public static b mV() {
        return bQ("plugin_load");
    }

    public static void I(String str, String str2) {
        mV().trace(str, str2);
    }

    b(String str) {
        this.type = str;
    }

    public void trace(String str, String str2) {
        mW();
        mX();
        this.KM.add(new a(str, str2));
    }

    private void mW() {
        if (this.startTime == 0) {
            this.startTime = System.currentTimeMillis();
        }
    }

    private void mX() {
        while (this.KM.size() >= 70) {
            this.KM.poll();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("trace_" + this.type + "{begin@" + KL.format(new Date(this.startTime)) + "->");
        for (int i = 0; i < this.KM.size(); i++) {
            a aVar = this.KM.get(i);
            sb.append(String.format("%s(%s)@%s", aVar.method, aVar.KN, KL.format(new Date(aVar.time))));
            if (i < this.KM.size() - 1) {
                sb.append("->");
            }
        }
        sb.append("->end}");
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {
        private String KN;
        private String method;
        private long time;

        a(String str, String str2, long j) {
            this.method = str;
            this.KN = str2;
            this.time = j;
        }

        a(String str, String str2) {
            this(str, str2, System.currentTimeMillis());
        }
    }
}
