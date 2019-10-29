package com.baidu.crabsdk.a;

import java.util.ArrayList;
import java.util.LinkedHashMap;
/* loaded from: classes3.dex */
public final class p extends n {
    private static final LinkedHashMap<Long, String> JJ = new LinkedHashMap<>();
    private Thread JK;
    private int V;

    private p(Thread thread, int i, long j) {
        super(j);
        this.V = a.V;
        this.JK = thread;
        this.V = i;
    }

    public p(Thread thread, long j) {
        this(thread, a.V, j);
    }

    public static ArrayList<String> c(long j, long j2) {
        ArrayList<String> arrayList = new ArrayList<>();
        synchronized (JJ) {
            for (Long l : JJ.keySet()) {
                if (j < l.longValue() && l.longValue() < j2) {
                    arrayList.add(JJ.get(l));
                }
            }
        }
        com.baidu.crabsdk.c.a.bu("result : " + arrayList.toString());
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.crabsdk.a.n
    public final void n() {
        StringBuilder sb = new StringBuilder();
        for (StackTraceElement stackTraceElement : this.JK.getStackTrace()) {
            sb.append(stackTraceElement.toString()).append("\r\n");
        }
        synchronized (JJ) {
            if (JJ.size() == this.V && this.V > 0) {
                JJ.remove(JJ.keySet().iterator().next());
            }
            JJ.put(Long.valueOf(System.currentTimeMillis()), sb.toString());
        }
    }
}
