package com.baidu.crabsdk.a;

import java.util.ArrayList;
import java.util.LinkedHashMap;
/* loaded from: classes8.dex */
public final class p extends n {
    private static final LinkedHashMap<Long, String> Rv = new LinkedHashMap<>();
    private Thread Rw;
    private int X;

    private p(Thread thread, int i, long j) {
        super(j);
        this.X = a.X;
        this.Rw = thread;
        this.X = i;
    }

    public p(Thread thread, long j) {
        this(thread, a.X, j);
    }

    public static ArrayList<String> c(long j, long j2) {
        ArrayList<String> arrayList = new ArrayList<>();
        synchronized (Rv) {
            for (Long l : Rv.keySet()) {
                if (j < l.longValue() && l.longValue() < j2) {
                    arrayList.add(Rv.get(l));
                }
            }
        }
        com.baidu.crabsdk.c.a.cj("result : " + arrayList.toString());
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.crabsdk.a.n
    public final void o() {
        StringBuilder sb = new StringBuilder();
        for (StackTraceElement stackTraceElement : this.Rw.getStackTrace()) {
            sb.append(stackTraceElement.toString()).append("\r\n");
        }
        synchronized (Rv) {
            if (Rv.size() == this.X && this.X > 0) {
                Rv.remove(Rv.keySet().iterator().next());
            }
            Rv.put(Long.valueOf(System.currentTimeMillis()), sb.toString());
        }
    }
}
