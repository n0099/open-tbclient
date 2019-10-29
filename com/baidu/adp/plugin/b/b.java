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
    private static final Map<String, b> vr = new HashMap();
    private static final Object vs = new Object();
    private static DateFormat vt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.CHINESE);
    private long startTime;
    private String type;
    private LinkedList<a> vu = new LinkedList<>();

    private static b aJ(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "Default";
        }
        if (!vr.containsKey(str)) {
            synchronized (vs) {
                if (!vr.containsKey(str)) {
                    b bVar = new b(str);
                    vr.put(str, bVar);
                    return bVar;
                }
            }
        }
        return vr.get(str);
    }

    public static b iy() {
        return aJ("plugin_load");
    }

    public static void r(String str, String str2) {
        iy().trace(str, str2);
    }

    b(String str) {
        this.type = str;
    }

    public void trace(String str, String str2) {
        iz();
        iA();
        this.vu.add(new a(str, str2));
    }

    private void iz() {
        if (this.startTime == 0) {
            this.startTime = System.currentTimeMillis();
        }
    }

    private void iA() {
        while (this.vu.size() >= 70) {
            this.vu.poll();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("trace_" + this.type + "{begin@" + vt.format(new Date(this.startTime)) + "->");
        for (int i = 0; i < this.vu.size(); i++) {
            a aVar = this.vu.get(i);
            sb.append(String.format("%s(%s)@%s", aVar.method, aVar.vv, vt.format(new Date(aVar.time))));
            if (i < this.vu.size() - 1) {
                sb.append("->");
            }
        }
        sb.append("->end}");
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {
        private String method;
        private long time;
        private String vv;

        a(String str, String str2, long j) {
            this.method = str;
            this.vv = str2;
            this.time = j;
        }

        a(String str, String str2) {
            this(str, str2, System.currentTimeMillis());
        }
    }
}
