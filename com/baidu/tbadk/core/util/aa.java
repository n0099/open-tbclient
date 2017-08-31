package com.baidu.tbadk.core.util;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class aa {
    private static ArrayList<a> agB = new ArrayList<>();
    public static AtomicInteger agC = new AtomicInteger(0);

    /* loaded from: classes.dex */
    public static class a {
        public int agD;
        public long agE;
        public int agF;
        public int mMode;
        public long mTime;
    }

    public static int cK(int i) {
        return agC.getAndSet(i);
    }

    public static int cL(int i) {
        return agC.addAndGet(i);
    }

    public static synchronized void a(a aVar) {
        synchronized (aa.class) {
            if (aVar != null) {
                if (agB.size() <= 20) {
                    agB.add(aVar);
                }
            }
        }
    }

    public static synchronized a vu() {
        a remove;
        synchronized (aa.class) {
            int size = agB.size();
            remove = size > 0 ? agB.remove(size - 1) : null;
        }
        return remove;
    }
}
