package com.baidu.crabsdk.a;

import java.util.ArrayList;
import java.util.LinkedHashMap;
/* loaded from: classes5.dex */
public final class p extends n {
    private static final LinkedHashMap<Long, String> aoF = new LinkedHashMap<>();
    private int X;
    private Thread aoG;

    private p(Thread thread, int i, long j) {
        super(j);
        this.X = a.X;
        this.aoG = thread;
        this.X = i;
    }

    public p(Thread thread, long j) {
        this(thread, a.X, j);
    }

    public static ArrayList<String> f(long j, long j2) {
        ArrayList<String> arrayList = new ArrayList<>();
        synchronized (aoF) {
            for (Long l : aoF.keySet()) {
                if (j < l.longValue() && l.longValue() < j2) {
                    arrayList.add(aoF.get(l));
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
        for (StackTraceElement stackTraceElement : this.aoG.getStackTrace()) {
            sb.append(stackTraceElement.toString()).append("\r\n");
        }
        synchronized (aoF) {
            if (aoF.size() == this.X && this.X > 0) {
                aoF.remove(aoF.keySet().iterator().next());
            }
            aoF.put(Long.valueOf(System.currentTimeMillis()), sb.toString());
        }
    }
}
