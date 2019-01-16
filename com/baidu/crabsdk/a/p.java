package com.baidu.crabsdk.a;

import com.baidu.ar.util.SystemInfoUtil;
import java.util.ArrayList;
import java.util.LinkedHashMap;
/* loaded from: classes6.dex */
public final class p extends n {
    private static final LinkedHashMap<Long, String> XT = new LinkedHashMap<>();
    private int V;
    private Thread XU;

    private p(Thread thread, int i, long j) {
        super(j);
        this.V = a.V;
        this.XU = thread;
        this.V = i;
    }

    public p(Thread thread, long j) {
        this(thread, a.V, j);
    }

    public static ArrayList<String> b(long j, long j2) {
        ArrayList<String> arrayList = new ArrayList<>();
        synchronized (XT) {
            for (Long l : XT.keySet()) {
                if (j < l.longValue() && l.longValue() < j2) {
                    arrayList.add(XT.get(l));
                }
            }
        }
        com.baidu.crabsdk.c.a.cH("result : " + arrayList.toString());
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.crabsdk.a.n
    public final void n() {
        StringBuilder sb = new StringBuilder();
        for (StackTraceElement stackTraceElement : this.XU.getStackTrace()) {
            sb.append(stackTraceElement.toString()).append(SystemInfoUtil.LINE_END);
        }
        synchronized (XT) {
            if (XT.size() == this.V && this.V > 0) {
                XT.remove(XT.keySet().iterator().next());
            }
            XT.put(Long.valueOf(System.currentTimeMillis()), sb.toString());
        }
    }
}
