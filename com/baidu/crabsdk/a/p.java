package com.baidu.crabsdk.a;

import java.util.ArrayList;
import java.util.LinkedHashMap;
/* loaded from: classes8.dex */
public final class p extends n {
    private static final LinkedHashMap<Long, String> ajX = new LinkedHashMap<>();
    private int X;
    private Thread ajY;

    private p(Thread thread, int i, long j) {
        super(j);
        this.X = a.X;
        this.ajY = thread;
        this.X = i;
    }

    public p(Thread thread, long j) {
        this(thread, a.X, j);
    }

    public static ArrayList<String> c(long j, long j2) {
        ArrayList<String> arrayList = new ArrayList<>();
        synchronized (ajX) {
            for (Long l : ajX.keySet()) {
                if (j < l.longValue() && l.longValue() < j2) {
                    arrayList.add(ajX.get(l));
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
        for (StackTraceElement stackTraceElement : this.ajY.getStackTrace()) {
            sb.append(stackTraceElement.toString()).append("\r\n");
        }
        synchronized (ajX) {
            if (ajX.size() == this.X && this.X > 0) {
                ajX.remove(ajX.keySet().iterator().next());
            }
            ajX.put(Long.valueOf(System.currentTimeMillis()), sb.toString());
        }
    }
}
