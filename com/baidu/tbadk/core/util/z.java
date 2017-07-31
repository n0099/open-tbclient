package com.baidu.tbadk.core.util;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class z {
    private static ArrayList<a> ahg = new ArrayList<>();
    public static AtomicInteger ahh = new AtomicInteger(0);

    /* loaded from: classes.dex */
    public static class a {
        public long ahi;
        public int ahj;
        public int mMethod;
        public int mMode;
        public long mTime;
    }

    public static int cJ(int i) {
        return ahh.getAndSet(i);
    }

    public static int cK(int i) {
        return ahh.addAndGet(i);
    }

    public static synchronized void a(a aVar) {
        synchronized (z.class) {
            if (aVar != null) {
                if (ahg.size() <= 20) {
                    ahg.add(aVar);
                }
            }
        }
    }

    public static synchronized a vw() {
        a remove;
        synchronized (z.class) {
            int size = ahg.size();
            remove = size > 0 ? ahg.remove(size - 1) : null;
        }
        return remove;
    }
}
