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
    private static final Map<String, b> SD = new HashMap();
    private static final Object SF = new Object();
    private static DateFormat SG = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.CHINESE);
    private LinkedList<a> SH = new LinkedList<>();
    private long startTime;
    private String type;

    private static b cu(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "Default";
        }
        if (!SD.containsKey(str)) {
            synchronized (SF) {
                if (!SD.containsKey(str)) {
                    b bVar = new b(str);
                    SD.put(str, bVar);
                    return bVar;
                }
            }
        }
        return SD.get(str);
    }

    public static b pG() {
        return cu("plugin_load");
    }

    public static void F(String str, String str2) {
        pG().trace(str, str2);
    }

    b(String str) {
        this.type = str;
    }

    public void trace(String str, String str2) {
        pH();
        pI();
        this.SH.add(new a(str, str2));
    }

    private void pH() {
        if (this.startTime == 0) {
            this.startTime = System.currentTimeMillis();
        }
    }

    private void pI() {
        while (this.SH.size() >= 70) {
            this.SH.poll();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("trace_" + this.type + "{begin@" + SG.format(new Date(this.startTime)) + "->");
        for (int i = 0; i < this.SH.size(); i++) {
            a aVar = this.SH.get(i);
            sb.append(String.format("%s(%s)@%s", aVar.method, aVar.SJ, SG.format(new Date(aVar.time))));
            if (i < this.SH.size() - 1) {
                sb.append("->");
            }
        }
        sb.append("->end}");
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {
        private String SJ;
        private String method;
        private long time;

        a(String str, String str2, long j) {
            this.method = str;
            this.SJ = str2;
            this.time = j;
        }

        a(String str, String str2) {
            this(str, str2, System.currentTimeMillis());
        }
    }
}
