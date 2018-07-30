package com.baidu.crabsdk.a;

import com.baidu.ar.util.SystemInfoUtil;
import java.util.ArrayList;
import java.util.LinkedHashMap;
/* loaded from: classes2.dex */
public final class p extends n {
    private static final LinkedHashMap<Long, String> Sr = new LinkedHashMap<>();
    private Thread Ss;
    private int U;

    private p(Thread thread, int i, long j) {
        super(j);
        this.U = a.U;
        this.Ss = thread;
        this.U = i;
    }

    public p(Thread thread, long j) {
        this(thread, a.U, j);
    }

    public static ArrayList<String> b(long j, long j2) {
        ArrayList<String> arrayList = new ArrayList<>();
        synchronized (Sr) {
            for (Long l : Sr.keySet()) {
                if (j < l.longValue() && l.longValue() < j2) {
                    arrayList.add(Sr.get(l));
                }
            }
        }
        com.baidu.crabsdk.c.a.ce("result : " + arrayList.toString());
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.crabsdk.a.n
    public final void n() {
        StringBuilder sb = new StringBuilder();
        for (StackTraceElement stackTraceElement : this.Ss.getStackTrace()) {
            sb.append(stackTraceElement.toString()).append(SystemInfoUtil.LINE_END);
        }
        synchronized (Sr) {
            if (Sr.size() == this.U && this.U > 0) {
                Sr.remove(Sr.keySet().iterator().next());
            }
            Sr.put(Long.valueOf(System.currentTimeMillis()), sb.toString());
        }
    }
}
