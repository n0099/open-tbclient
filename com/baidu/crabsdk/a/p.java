package com.baidu.crabsdk.a;

import java.util.ArrayList;
import java.util.LinkedHashMap;
/* loaded from: classes8.dex */
public final class p extends n {
    private static final LinkedHashMap<Long, String> ajR = new LinkedHashMap<>();
    private int X;
    private Thread ajS;

    private p(Thread thread, int i, long j) {
        super(j);
        this.X = a.X;
        this.ajS = thread;
        this.X = i;
    }

    public p(Thread thread, long j) {
        this(thread, a.X, j);
    }

    public static ArrayList<String> c(long j, long j2) {
        ArrayList<String> arrayList = new ArrayList<>();
        synchronized (ajR) {
            for (Long l : ajR.keySet()) {
                if (j < l.longValue() && l.longValue() < j2) {
                    arrayList.add(ajR.get(l));
                }
            }
        }
        com.baidu.crabsdk.c.a.de("result : " + arrayList.toString());
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.crabsdk.a.n
    public final void o() {
        StringBuilder sb = new StringBuilder();
        for (StackTraceElement stackTraceElement : this.ajS.getStackTrace()) {
            sb.append(stackTraceElement.toString()).append("\r\n");
        }
        synchronized (ajR) {
            if (ajR.size() == this.X && this.X > 0) {
                ajR.remove(ajR.keySet().iterator().next());
            }
            ajR.put(Long.valueOf(System.currentTimeMillis()), sb.toString());
        }
    }
}
