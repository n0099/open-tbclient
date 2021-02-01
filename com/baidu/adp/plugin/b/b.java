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
    private static final Map<String, b> TQ = new HashMap();
    private static final Object TR = new Object();
    private static DateFormat TS = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.CHINESE);
    private LinkedList<a> TT = new LinkedList<>();
    private long startTime;
    private String type;

    private static b cs(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "Default";
        }
        if (!TQ.containsKey(str)) {
            synchronized (TR) {
                if (!TQ.containsKey(str)) {
                    b bVar = new b(str);
                    TQ.put(str, bVar);
                    return bVar;
                }
            }
        }
        return TQ.get(str);
    }

    public static b pi() {
        return cs("plugin_load");
    }

    public static void C(String str, String str2) {
        pi().trace(str, str2);
    }

    b(String str) {
        this.type = str;
    }

    public void trace(String str, String str2) {
        pj();
        pk();
        this.TT.add(new a(str, str2));
    }

    private void pj() {
        if (this.startTime == 0) {
            this.startTime = System.currentTimeMillis();
        }
    }

    private void pk() {
        while (this.TT.size() >= 70) {
            this.TT.poll();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("trace_" + this.type + "{begin@" + TS.format(new Date(this.startTime)) + PerfFrameTrackUIUtil.SEPERATOR_ARROR);
        for (int i = 0; i < this.TT.size(); i++) {
            a aVar = this.TT.get(i);
            sb.append(String.format("%s(%s)@%s", aVar.method, aVar.TU, TS.format(new Date(aVar.time))));
            if (i < this.TT.size() - 1) {
                sb.append(PerfFrameTrackUIUtil.SEPERATOR_ARROR);
            }
        }
        sb.append("->end}");
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {
        private String TU;
        private String method;
        private long time;

        a(String str, String str2, long j) {
            this.method = str;
            this.TU = str2;
            this.time = j;
        }

        a(String str, String str2) {
            this(str, str2, System.currentTimeMillis());
        }
    }
}
