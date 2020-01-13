package com.baidu.crabsdk.a;

import java.util.ArrayList;
import java.util.LinkedHashMap;
/* loaded from: classes6.dex */
public final class p extends n {
    private static final LinkedHashMap<Long, String> PN = new LinkedHashMap<>();
    private Thread PO;
    private int V;

    private p(Thread thread, int i, long j) {
        super(j);
        this.V = a.V;
        this.PO = thread;
        this.V = i;
    }

    public p(Thread thread, long j) {
        this(thread, a.V, j);
    }

    public static ArrayList<String> c(long j, long j2) {
        ArrayList<String> arrayList = new ArrayList<>();
        synchronized (PN) {
            for (Long l : PN.keySet()) {
                if (j < l.longValue() && l.longValue() < j2) {
                    arrayList.add(PN.get(l));
                }
            }
        }
        com.baidu.crabsdk.c.a.cb("result : " + arrayList.toString());
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.crabsdk.a.n
    public final void n() {
        StringBuilder sb = new StringBuilder();
        for (StackTraceElement stackTraceElement : this.PO.getStackTrace()) {
            sb.append(stackTraceElement.toString()).append("\r\n");
        }
        synchronized (PN) {
            if (PN.size() == this.V && this.V > 0) {
                PN.remove(PN.keySet().iterator().next());
            }
            PN.put(Long.valueOf(System.currentTimeMillis()), sb.toString());
        }
    }
}
