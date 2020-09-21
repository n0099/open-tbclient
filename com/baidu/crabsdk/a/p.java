package com.baidu.crabsdk.a;

import java.util.ArrayList;
import java.util.LinkedHashMap;
/* loaded from: classes8.dex */
public final class p extends n {
    private static final LinkedHashMap<Long, String> anA = new LinkedHashMap<>();
    private int X;
    private Thread anB;

    private p(Thread thread, int i, long j) {
        super(j);
        this.X = a.X;
        this.anB = thread;
        this.X = i;
    }

    public p(Thread thread, long j) {
        this(thread, a.X, j);
    }

    public static ArrayList<String> c(long j, long j2) {
        ArrayList<String> arrayList = new ArrayList<>();
        synchronized (anA) {
            for (Long l : anA.keySet()) {
                if (j < l.longValue() && l.longValue() < j2) {
                    arrayList.add(anA.get(l));
                }
            }
        }
        com.baidu.crabsdk.c.a.dv("result : " + arrayList.toString());
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.crabsdk.a.n
    public final void o() {
        StringBuilder sb = new StringBuilder();
        for (StackTraceElement stackTraceElement : this.anB.getStackTrace()) {
            sb.append(stackTraceElement.toString()).append("\r\n");
        }
        synchronized (anA) {
            if (anA.size() == this.X && this.X > 0) {
                anA.remove(anA.keySet().iterator().next());
            }
            anA.put(Long.valueOf(System.currentTimeMillis()), sb.toString());
        }
    }
}
