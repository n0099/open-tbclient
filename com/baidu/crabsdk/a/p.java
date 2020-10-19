package com.baidu.crabsdk.a;

import java.util.ArrayList;
import java.util.LinkedHashMap;
/* loaded from: classes11.dex */
public final class p extends n {
    private static final LinkedHashMap<Long, String> aoj = new LinkedHashMap<>();
    private int X;
    private Thread aok;

    private p(Thread thread, int i, long j) {
        super(j);
        this.X = a.X;
        this.aok = thread;
        this.X = i;
    }

    public p(Thread thread, long j) {
        this(thread, a.X, j);
    }

    public static ArrayList<String> c(long j, long j2) {
        ArrayList<String> arrayList = new ArrayList<>();
        synchronized (aoj) {
            for (Long l : aoj.keySet()) {
                if (j < l.longValue() && l.longValue() < j2) {
                    arrayList.add(aoj.get(l));
                }
            }
        }
        com.baidu.crabsdk.c.a.dA("result : " + arrayList.toString());
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.crabsdk.a.n
    public final void o() {
        StringBuilder sb = new StringBuilder();
        for (StackTraceElement stackTraceElement : this.aok.getStackTrace()) {
            sb.append(stackTraceElement.toString()).append("\r\n");
        }
        synchronized (aoj) {
            if (aoj.size() == this.X && this.X > 0) {
                aoj.remove(aoj.keySet().iterator().next());
            }
            aoj.put(Long.valueOf(System.currentTimeMillis()), sb.toString());
        }
    }
}
