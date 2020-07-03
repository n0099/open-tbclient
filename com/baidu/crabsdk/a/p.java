package com.baidu.crabsdk.a;

import java.util.ArrayList;
import java.util.LinkedHashMap;
/* loaded from: classes8.dex */
public final class p extends n {
    private static final LinkedHashMap<Long, String> alY = new LinkedHashMap<>();
    private int X;
    private Thread alZ;

    private p(Thread thread, int i, long j) {
        super(j);
        this.X = a.X;
        this.alZ = thread;
        this.X = i;
    }

    public p(Thread thread, long j) {
        this(thread, a.X, j);
    }

    public static ArrayList<String> c(long j, long j2) {
        ArrayList<String> arrayList = new ArrayList<>();
        synchronized (alY) {
            for (Long l : alY.keySet()) {
                if (j < l.longValue() && l.longValue() < j2) {
                    arrayList.add(alY.get(l));
                }
            }
        }
        com.baidu.crabsdk.c.a.di("result : " + arrayList.toString());
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.crabsdk.a.n
    public final void o() {
        StringBuilder sb = new StringBuilder();
        for (StackTraceElement stackTraceElement : this.alZ.getStackTrace()) {
            sb.append(stackTraceElement.toString()).append("\r\n");
        }
        synchronized (alY) {
            if (alY.size() == this.X && this.X > 0) {
                alY.remove(alY.keySet().iterator().next());
            }
            alY.put(Long.valueOf(System.currentTimeMillis()), sb.toString());
        }
    }
}
