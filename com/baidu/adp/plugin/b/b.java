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
    private static final Map<String, b> TS = new HashMap();
    private static final Object TT = new Object();
    private static DateFormat TU = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.CHINESE);
    private LinkedList<a> TV = new LinkedList<>();
    private long startTime;
    private String type;

    private static b cz(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "Default";
        }
        if (!TS.containsKey(str)) {
            synchronized (TT) {
                if (!TS.containsKey(str)) {
                    b bVar = new b(str);
                    TS.put(str, bVar);
                    return bVar;
                }
            }
        }
        return TS.get(str);
    }

    public static b pI() {
        return cz("plugin_load");
    }

    public static void E(String str, String str2) {
        pI().trace(str, str2);
    }

    b(String str) {
        this.type = str;
    }

    public void trace(String str, String str2) {
        pJ();
        pK();
        this.TV.add(new a(str, str2));
    }

    private void pJ() {
        if (this.startTime == 0) {
            this.startTime = System.currentTimeMillis();
        }
    }

    private void pK() {
        while (this.TV.size() >= 70) {
            this.TV.poll();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("trace_" + this.type + "{begin@" + TU.format(new Date(this.startTime)) + PerfFrameTrackUIUtil.SEPERATOR_ARROR);
        for (int i = 0; i < this.TV.size(); i++) {
            a aVar = this.TV.get(i);
            sb.append(String.format("%s(%s)@%s", aVar.method, aVar.TW, TU.format(new Date(aVar.time))));
            if (i < this.TV.size() - 1) {
                sb.append(PerfFrameTrackUIUtil.SEPERATOR_ARROR);
            }
        }
        sb.append("->end}");
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {
        private String TW;
        private String method;
        private long time;

        a(String str, String str2, long j) {
            this.method = str;
            this.TW = str2;
            this.time = j;
        }

        a(String str, String str2) {
            this(str, str2, System.currentTimeMillis());
        }
    }
}
