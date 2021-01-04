package com.baidu.adp.plugin.b;

import android.text.TextUtils;
import com.baidu.searchbox.perfframe.basic.PerfFrameTrackUIUtil;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Map;
/* loaded from: classes.dex */
public class b {
    private static final Map<String, b> TU = new HashMap();
    private static final Object TV = new Object();
    private static DateFormat TW = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.CHINESE);
    private LinkedList<a> TX = new LinkedList<>();
    private long startTime;
    private String type;

    private static b cs(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "Default";
        }
        if (!TU.containsKey(str)) {
            synchronized (TV) {
                if (!TU.containsKey(str)) {
                    b bVar = new b(str);
                    TU.put(str, bVar);
                    return bVar;
                }
            }
        }
        return TU.get(str);
    }

    public static b pk() {
        return cs("plugin_load");
    }

    public static void E(String str, String str2) {
        pk().trace(str, str2);
    }

    b(String str) {
        this.type = str;
    }

    public void trace(String str, String str2) {
        pl();
        pm();
        this.TX.add(new a(str, str2));
    }

    private void pl() {
        if (this.startTime == 0) {
            this.startTime = System.currentTimeMillis();
        }
    }

    private void pm() {
        while (this.TX.size() >= 70) {
            this.TX.poll();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("trace_" + this.type + "{begin@" + TW.format(new Date(this.startTime)) + PerfFrameTrackUIUtil.SEPERATOR_ARROR);
        for (int i = 0; i < this.TX.size(); i++) {
            a aVar = this.TX.get(i);
            sb.append(String.format("%s(%s)@%s", aVar.method, aVar.TY, TW.format(new Date(aVar.time))));
            if (i < this.TX.size() - 1) {
                sb.append(PerfFrameTrackUIUtil.SEPERATOR_ARROR);
            }
        }
        sb.append("->end}");
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {
        private String TY;
        private String method;
        private long time;

        a(String str, String str2, long j) {
            this.method = str;
            this.TY = str2;
            this.time = j;
        }

        a(String str, String str2) {
            this(str, str2, System.currentTimeMillis());
        }
    }
}
