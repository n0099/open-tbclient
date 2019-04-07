package com.baidu.crabsdk.a;

import java.util.ArrayList;
import java.util.LinkedHashMap;
/* loaded from: classes3.dex */
public final class p extends n {
    private static final LinkedHashMap<Long, String> abx = new LinkedHashMap<>();
    private int V;
    private Thread aby;

    private p(Thread thread, int i, long j) {
        super(j);
        this.V = a.V;
        this.aby = thread;
        this.V = i;
    }

    public p(Thread thread, long j) {
        this(thread, a.V, j);
    }

    public static ArrayList<String> c(long j, long j2) {
        ArrayList<String> arrayList = new ArrayList<>();
        synchronized (abx) {
            for (Long l : abx.keySet()) {
                if (j < l.longValue() && l.longValue() < j2) {
                    arrayList.add(abx.get(l));
                }
            }
        }
        com.baidu.crabsdk.c.a.cv("result : " + arrayList.toString());
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.crabsdk.a.n
    public final void n() {
        StringBuilder sb = new StringBuilder();
        for (StackTraceElement stackTraceElement : this.aby.getStackTrace()) {
            sb.append(stackTraceElement.toString()).append("\r\n");
        }
        synchronized (abx) {
            if (abx.size() == this.V && this.V > 0) {
                abx.remove(abx.keySet().iterator().next());
            }
            abx.put(Long.valueOf(System.currentTimeMillis()), sb.toString());
        }
    }
}
