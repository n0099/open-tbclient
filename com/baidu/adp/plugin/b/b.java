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
    private static final Map<String, b> KC = new HashMap();
    private static final Object KD = new Object();
    private static DateFormat KE = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.CHINESE);
    private LinkedList<a> KF = new LinkedList<>();
    private long startTime;
    private String type;

    private static b bQ(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "Default";
        }
        if (!KC.containsKey(str)) {
            synchronized (KD) {
                if (!KC.containsKey(str)) {
                    b bVar = new b(str);
                    KC.put(str, bVar);
                    return bVar;
                }
            }
        }
        return KC.get(str);
    }

    public static b mQ() {
        return bQ("plugin_load");
    }

    public static void J(String str, String str2) {
        mQ().trace(str, str2);
    }

    b(String str) {
        this.type = str;
    }

    public void trace(String str, String str2) {
        mR();
        mS();
        this.KF.add(new a(str, str2));
    }

    private void mR() {
        if (this.startTime == 0) {
            this.startTime = System.currentTimeMillis();
        }
    }

    private void mS() {
        while (this.KF.size() >= 70) {
            this.KF.poll();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("trace_" + this.type + "{begin@" + KE.format(new Date(this.startTime)) + "->");
        for (int i = 0; i < this.KF.size(); i++) {
            a aVar = this.KF.get(i);
            sb.append(String.format("%s(%s)@%s", aVar.method, aVar.KG, KE.format(new Date(aVar.time))));
            if (i < this.KF.size() - 1) {
                sb.append("->");
            }
        }
        sb.append("->end}");
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {
        private String KG;
        private String method;
        private long time;

        a(String str, String str2, long j) {
            this.method = str;
            this.KG = str2;
            this.time = j;
        }

        a(String str, String str2) {
            this(str, str2, System.currentTimeMillis());
        }
    }
}
