package com.baidu.crabsdk.a;

import java.util.ArrayList;
import java.util.LinkedHashMap;
/* loaded from: classes14.dex */
public final class p extends n {
    private static final LinkedHashMap<Long, String> aoP = new LinkedHashMap<>();
    private int X;
    private Thread aoQ;

    private p(Thread thread, int i, long j) {
        super(j);
        this.X = a.X;
        this.aoQ = thread;
        this.X = i;
    }

    public p(Thread thread, long j) {
        this(thread, a.X, j);
    }

    public static ArrayList<String> f(long j, long j2) {
        ArrayList<String> arrayList = new ArrayList<>();
        synchronized (aoP) {
            for (Long l : aoP.keySet()) {
                if (j < l.longValue() && l.longValue() < j2) {
                    arrayList.add(aoP.get(l));
                }
            }
        }
        com.baidu.crabsdk.c.a.ds("result : " + arrayList.toString());
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.crabsdk.a.n
    public final void o() {
        StringBuilder sb = new StringBuilder();
        for (StackTraceElement stackTraceElement : this.aoQ.getStackTrace()) {
            sb.append(stackTraceElement.toString()).append("\r\n");
        }
        synchronized (aoP) {
            if (aoP.size() == this.X && this.X > 0) {
                aoP.remove(aoP.keySet().iterator().next());
            }
            aoP.put(Long.valueOf(System.currentTimeMillis()), sb.toString());
        }
    }
}
