package com.baidu.crabsdk.a;

import java.util.ArrayList;
import java.util.LinkedHashMap;
/* loaded from: classes5.dex */
public final class p extends n {
    private static final LinkedHashMap<Long, String> aqf = new LinkedHashMap<>();
    private int X;
    private Thread aqg;

    private p(Thread thread, int i, long j) {
        super(j);
        this.X = a.X;
        this.aqg = thread;
        this.X = i;
    }

    public p(Thread thread, long j) {
        this(thread, a.X, j);
    }

    public static ArrayList<String> f(long j, long j2) {
        ArrayList<String> arrayList = new ArrayList<>();
        synchronized (aqf) {
            for (Long l : aqf.keySet()) {
                if (j < l.longValue() && l.longValue() < j2) {
                    arrayList.add(aqf.get(l));
                }
            }
        }
        com.baidu.crabsdk.c.a.dw("result : " + arrayList.toString());
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.crabsdk.a.n
    public final void o() {
        StringBuilder sb = new StringBuilder();
        for (StackTraceElement stackTraceElement : this.aqg.getStackTrace()) {
            sb.append(stackTraceElement.toString()).append("\r\n");
        }
        synchronized (aqf) {
            if (aqf.size() == this.X && this.X > 0) {
                aqf.remove(aqf.keySet().iterator().next());
            }
            aqf.put(Long.valueOf(System.currentTimeMillis()), sb.toString());
        }
    }
}
