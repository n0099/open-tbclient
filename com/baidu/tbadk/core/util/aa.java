package com.baidu.tbadk.core.util;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class aa {
    private static ArrayList<a> agA = new ArrayList<>();
    public static AtomicInteger agB = new AtomicInteger(0);

    /* loaded from: classes.dex */
    public static class a {
        public int agC;
        public long agD;
        public int agE;
        public int mMode;
        public long mTime;
    }

    public static int cK(int i) {
        return agB.getAndSet(i);
    }

    public static int cL(int i) {
        return agB.addAndGet(i);
    }

    public static synchronized void a(a aVar) {
        synchronized (aa.class) {
            if (aVar != null) {
                if (agA.size() <= 20) {
                    agA.add(aVar);
                }
            }
        }
    }

    public static synchronized a vu() {
        a remove;
        synchronized (aa.class) {
            int size = agA.size();
            remove = size > 0 ? agA.remove(size - 1) : null;
        }
        return remove;
    }
}
