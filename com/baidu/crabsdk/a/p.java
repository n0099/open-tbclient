package com.baidu.crabsdk.a;

import com.baidu.ar.util.SystemInfoUtil;
import java.util.ArrayList;
import java.util.LinkedHashMap;
/* loaded from: classes6.dex */
public final class p extends n {
    private static final LinkedHashMap<Long, String> XK = new LinkedHashMap<>();
    private int V;
    private Thread XL;

    private p(Thread thread, int i, long j) {
        super(j);
        this.V = a.V;
        this.XL = thread;
        this.V = i;
    }

    public p(Thread thread, long j) {
        this(thread, a.V, j);
    }

    public static ArrayList<String> b(long j, long j2) {
        ArrayList<String> arrayList = new ArrayList<>();
        synchronized (XK) {
            for (Long l : XK.keySet()) {
                if (j < l.longValue() && l.longValue() < j2) {
                    arrayList.add(XK.get(l));
                }
            }
        }
        com.baidu.crabsdk.c.a.cG("result : " + arrayList.toString());
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.crabsdk.a.n
    public final void n() {
        StringBuilder sb = new StringBuilder();
        for (StackTraceElement stackTraceElement : this.XL.getStackTrace()) {
            sb.append(stackTraceElement.toString()).append(SystemInfoUtil.LINE_END);
        }
        synchronized (XK) {
            if (XK.size() == this.V && this.V > 0) {
                XK.remove(XK.keySet().iterator().next());
            }
            XK.put(Long.valueOf(System.currentTimeMillis()), sb.toString());
        }
    }
}
