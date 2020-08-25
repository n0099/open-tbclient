package com.baidu.crabsdk.a;

import java.util.ArrayList;
import java.util.LinkedHashMap;
/* loaded from: classes6.dex */
public final class p extends n {
    private static final LinkedHashMap<Long, String> amW = new LinkedHashMap<>();
    private int X;
    private Thread amX;

    private p(Thread thread, int i, long j) {
        super(j);
        this.X = a.X;
        this.amX = thread;
        this.X = i;
    }

    public p(Thread thread, long j) {
        this(thread, a.X, j);
    }

    public static ArrayList<String> c(long j, long j2) {
        ArrayList<String> arrayList = new ArrayList<>();
        synchronized (amW) {
            for (Long l : amW.keySet()) {
                if (j < l.longValue() && l.longValue() < j2) {
                    arrayList.add(amW.get(l));
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
        for (StackTraceElement stackTraceElement : this.amX.getStackTrace()) {
            sb.append(stackTraceElement.toString()).append("\r\n");
        }
        synchronized (amW) {
            if (amW.size() == this.X && this.X > 0) {
                amW.remove(amW.keySet().iterator().next());
            }
            amW.put(Long.valueOf(System.currentTimeMillis()), sb.toString());
        }
    }
}
