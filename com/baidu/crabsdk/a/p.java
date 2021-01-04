package com.baidu.crabsdk.a;

import java.util.ArrayList;
import java.util.LinkedHashMap;
/* loaded from: classes3.dex */
public final class p extends n {
    private static final LinkedHashMap<Long, String> apE = new LinkedHashMap<>();
    private int X;
    private Thread apF;

    private p(Thread thread, int i, long j) {
        super(j);
        this.X = a.X;
        this.apF = thread;
        this.X = i;
    }

    public p(Thread thread, long j) {
        this(thread, a.X, j);
    }

    public static ArrayList<String> f(long j, long j2) {
        ArrayList<String> arrayList = new ArrayList<>();
        synchronized (apE) {
            for (Long l : apE.keySet()) {
                if (j < l.longValue() && l.longValue() < j2) {
                    arrayList.add(apE.get(l));
                }
            }
        }
        com.baidu.crabsdk.c.a.dx("result : " + arrayList.toString());
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.crabsdk.a.n
    public final void o() {
        StringBuilder sb = new StringBuilder();
        for (StackTraceElement stackTraceElement : this.apF.getStackTrace()) {
            sb.append(stackTraceElement.toString()).append("\r\n");
        }
        synchronized (apE) {
            if (apE.size() == this.X && this.X > 0) {
                apE.remove(apE.keySet().iterator().next());
            }
            apE.put(Long.valueOf(System.currentTimeMillis()), sb.toString());
        }
    }
}
