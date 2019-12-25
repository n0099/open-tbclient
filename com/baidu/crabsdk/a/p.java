package com.baidu.crabsdk.a;

import java.util.ArrayList;
import java.util.LinkedHashMap;
/* loaded from: classes5.dex */
public final class p extends n {
    private static final LinkedHashMap<Long, String> PI = new LinkedHashMap<>();
    private Thread PJ;
    private int V;

    private p(Thread thread, int i, long j) {
        super(j);
        this.V = a.V;
        this.PJ = thread;
        this.V = i;
    }

    public p(Thread thread, long j) {
        this(thread, a.V, j);
    }

    public static ArrayList<String> c(long j, long j2) {
        ArrayList<String> arrayList = new ArrayList<>();
        synchronized (PI) {
            for (Long l : PI.keySet()) {
                if (j < l.longValue() && l.longValue() < j2) {
                    arrayList.add(PI.get(l));
                }
            }
        }
        com.baidu.crabsdk.c.a.cb("result : " + arrayList.toString());
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.crabsdk.a.n
    public final void n() {
        StringBuilder sb = new StringBuilder();
        for (StackTraceElement stackTraceElement : this.PJ.getStackTrace()) {
            sb.append(stackTraceElement.toString()).append("\r\n");
        }
        synchronized (PI) {
            if (PI.size() == this.V && this.V > 0) {
                PI.remove(PI.keySet().iterator().next());
            }
            PI.put(Long.valueOf(System.currentTimeMillis()), sb.toString());
        }
    }
}
