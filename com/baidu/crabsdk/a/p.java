package com.baidu.crabsdk.a;

import java.util.ArrayList;
import java.util.LinkedHashMap;
/* loaded from: classes8.dex */
public final class p extends n {
    private static final LinkedHashMap<Long, String> akC = new LinkedHashMap<>();
    private int X;
    private Thread akD;

    private p(Thread thread, int i, long j) {
        super(j);
        this.X = a.X;
        this.akD = thread;
        this.X = i;
    }

    public p(Thread thread, long j) {
        this(thread, a.X, j);
    }

    public static ArrayList<String> c(long j, long j2) {
        ArrayList<String> arrayList = new ArrayList<>();
        synchronized (akC) {
            for (Long l : akC.keySet()) {
                if (j < l.longValue() && l.longValue() < j2) {
                    arrayList.add(akC.get(l));
                }
            }
        }
        com.baidu.crabsdk.c.a.dg("result : " + arrayList.toString());
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.crabsdk.a.n
    public final void o() {
        StringBuilder sb = new StringBuilder();
        for (StackTraceElement stackTraceElement : this.akD.getStackTrace()) {
            sb.append(stackTraceElement.toString()).append("\r\n");
        }
        synchronized (akC) {
            if (akC.size() == this.X && this.X > 0) {
                akC.remove(akC.keySet().iterator().next());
            }
            akC.put(Long.valueOf(System.currentTimeMillis()), sb.toString());
        }
    }
}
