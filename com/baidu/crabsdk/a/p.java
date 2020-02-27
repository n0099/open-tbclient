package com.baidu.crabsdk.a;

import java.util.ArrayList;
import java.util.LinkedHashMap;
/* loaded from: classes8.dex */
public final class p extends n {
    private static final LinkedHashMap<Long, String> Rt = new LinkedHashMap<>();
    private Thread Ru;
    private int V;

    private p(Thread thread, int i, long j) {
        super(j);
        this.V = a.V;
        this.Ru = thread;
        this.V = i;
    }

    public p(Thread thread, long j) {
        this(thread, a.V, j);
    }

    public static ArrayList<String> c(long j, long j2) {
        ArrayList<String> arrayList = new ArrayList<>();
        synchronized (Rt) {
            for (Long l : Rt.keySet()) {
                if (j < l.longValue() && l.longValue() < j2) {
                    arrayList.add(Rt.get(l));
                }
            }
        }
        com.baidu.crabsdk.c.a.cj("result : " + arrayList.toString());
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.crabsdk.a.n
    public final void n() {
        StringBuilder sb = new StringBuilder();
        for (StackTraceElement stackTraceElement : this.Ru.getStackTrace()) {
            sb.append(stackTraceElement.toString()).append("\r\n");
        }
        synchronized (Rt) {
            if (Rt.size() == this.V && this.V > 0) {
                Rt.remove(Rt.keySet().iterator().next());
            }
            Rt.put(Long.valueOf(System.currentTimeMillis()), sb.toString());
        }
    }
}
