package com.baidu.crabsdk.a;

import com.baidu.ar.util.SystemInfoUtil;
import java.util.ArrayList;
import java.util.LinkedHashMap;
/* loaded from: classes2.dex */
public final class p extends n {
    private static final LinkedHashMap<Long, String> UX = new LinkedHashMap<>();
    private int U;
    private Thread UY;

    private p(Thread thread, int i, long j) {
        super(j);
        this.U = a.U;
        this.UY = thread;
        this.U = i;
    }

    public p(Thread thread, long j) {
        this(thread, a.U, j);
    }

    public static ArrayList<String> b(long j, long j2) {
        ArrayList<String> arrayList = new ArrayList<>();
        synchronized (UX) {
            for (Long l : UX.keySet()) {
                if (j < l.longValue() && l.longValue() < j2) {
                    arrayList.add(UX.get(l));
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
        for (StackTraceElement stackTraceElement : this.UY.getStackTrace()) {
            sb.append(stackTraceElement.toString()).append(SystemInfoUtil.LINE_END);
        }
        synchronized (UX) {
            if (UX.size() == this.U && this.U > 0) {
                UX.remove(UX.keySet().iterator().next());
            }
            UX.put(Long.valueOf(System.currentTimeMillis()), sb.toString());
        }
    }
}
