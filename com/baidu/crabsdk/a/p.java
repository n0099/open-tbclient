package com.baidu.crabsdk.a;

import java.util.ArrayList;
import java.util.LinkedHashMap;
/* loaded from: classes3.dex */
public final class p extends n {
    private static final LinkedHashMap<Long, String> Zo = new LinkedHashMap<>();
    private int V;
    private Thread Zp;

    private p(Thread thread, int i, long j) {
        super(j);
        this.V = a.V;
        this.Zp = thread;
        this.V = i;
    }

    public p(Thread thread, long j) {
        this(thread, a.V, j);
    }

    public static ArrayList<String> c(long j, long j2) {
        ArrayList<String> arrayList = new ArrayList<>();
        synchronized (Zo) {
            for (Long l : Zo.keySet()) {
                if (j < l.longValue() && l.longValue() < j2) {
                    arrayList.add(Zo.get(l));
                }
            }
        }
        com.baidu.crabsdk.c.a.cf("result : " + arrayList.toString());
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.crabsdk.a.n
    public final void n() {
        StringBuilder sb = new StringBuilder();
        for (StackTraceElement stackTraceElement : this.Zp.getStackTrace()) {
            sb.append(stackTraceElement.toString()).append("\r\n");
        }
        synchronized (Zo) {
            if (Zo.size() == this.V && this.V > 0) {
                Zo.remove(Zo.keySet().iterator().next());
            }
            Zo.put(Long.valueOf(System.currentTimeMillis()), sb.toString());
        }
    }
}
