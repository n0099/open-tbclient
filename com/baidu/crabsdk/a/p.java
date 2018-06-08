package com.baidu.crabsdk.a;

import com.baidu.ar.util.SystemInfoUtil;
import java.util.ArrayList;
import java.util.LinkedHashMap;
/* loaded from: classes2.dex */
public final class p extends n {
    private static final LinkedHashMap<Long, String> Ss = new LinkedHashMap<>();
    private Thread St;
    private int U;

    private p(Thread thread, int i, long j) {
        super(j);
        this.U = a.U;
        this.St = thread;
        this.U = i;
    }

    public p(Thread thread, long j) {
        this(thread, a.U, j);
    }

    public static ArrayList<String> b(long j, long j2) {
        ArrayList<String> arrayList = new ArrayList<>();
        synchronized (Ss) {
            for (Long l : Ss.keySet()) {
                if (j < l.longValue() && l.longValue() < j2) {
                    arrayList.add(Ss.get(l));
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
        for (StackTraceElement stackTraceElement : this.St.getStackTrace()) {
            sb.append(stackTraceElement.toString()).append(SystemInfoUtil.LINE_END);
        }
        synchronized (Ss) {
            if (Ss.size() == this.U && this.U > 0) {
                Ss.remove(Ss.keySet().iterator().next());
            }
            Ss.put(Long.valueOf(System.currentTimeMillis()), sb.toString());
        }
    }
}
