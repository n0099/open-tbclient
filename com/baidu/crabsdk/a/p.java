package com.baidu.crabsdk.a;

import java.util.ArrayList;
import java.util.LinkedHashMap;
/* loaded from: classes7.dex */
public final class p extends n {
    private static final LinkedHashMap<Long, String> aoq = new LinkedHashMap<>();
    private int X;
    private Thread aor;

    private p(Thread thread, int i, long j) {
        super(j);
        this.X = a.X;
        this.aor = thread;
        this.X = i;
    }

    public p(Thread thread, long j) {
        this(thread, a.X, j);
    }

    public static ArrayList<String> c(long j, long j2) {
        ArrayList<String> arrayList = new ArrayList<>();
        synchronized (aoq) {
            for (Long l : aoq.keySet()) {
                if (j < l.longValue() && l.longValue() < j2) {
                    arrayList.add(aoq.get(l));
                }
            }
        }
        com.baidu.crabsdk.c.a.dC("result : " + arrayList.toString());
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.crabsdk.a.n
    public final void o() {
        StringBuilder sb = new StringBuilder();
        for (StackTraceElement stackTraceElement : this.aor.getStackTrace()) {
            sb.append(stackTraceElement.toString()).append("\r\n");
        }
        synchronized (aoq) {
            if (aoq.size() == this.X && this.X > 0) {
                aoq.remove(aoq.keySet().iterator().next());
            }
            aoq.put(Long.valueOf(System.currentTimeMillis()), sb.toString());
        }
    }
}
