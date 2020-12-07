package com.baidu.crabsdk.a;

import java.util.ArrayList;
import java.util.LinkedHashMap;
/* loaded from: classes8.dex */
public final class p extends n {
    private static final LinkedHashMap<Long, String> ape = new LinkedHashMap<>();
    private int X;
    private Thread apf;

    private p(Thread thread, int i, long j) {
        super(j);
        this.X = a.X;
        this.apf = thread;
        this.X = i;
    }

    public p(Thread thread, long j) {
        this(thread, a.X, j);
    }

    public static ArrayList<String> c(long j, long j2) {
        ArrayList<String> arrayList = new ArrayList<>();
        synchronized (ape) {
            for (Long l : ape.keySet()) {
                if (j < l.longValue() && l.longValue() < j2) {
                    arrayList.add(ape.get(l));
                }
            }
        }
        com.baidu.crabsdk.c.a.dE("result : " + arrayList.toString());
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.crabsdk.a.n
    public final void o() {
        StringBuilder sb = new StringBuilder();
        for (StackTraceElement stackTraceElement : this.apf.getStackTrace()) {
            sb.append(stackTraceElement.toString()).append("\r\n");
        }
        synchronized (ape) {
            if (ape.size() == this.X && this.X > 0) {
                ape.remove(ape.keySet().iterator().next());
            }
            ape.put(Long.valueOf(System.currentTimeMillis()), sb.toString());
        }
    }
}
