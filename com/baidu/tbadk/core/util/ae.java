package com.baidu.tbadk.core.util;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class ae {
    private static ArrayList<a> acb = new ArrayList<>();
    public static AtomicInteger acc = new AtomicInteger(0);

    /* loaded from: classes.dex */
    public static class a {
        public int acd;
        public long ace;
        public int acf;
        public int mMode;
        public long mTime;
    }

    public static int cF(int i) {
        return acc.getAndSet(i);
    }

    public static int cG(int i) {
        return acc.addAndGet(i);
    }

    public static synchronized void a(a aVar) {
        synchronized (ae.class) {
            if (aVar != null) {
                if (acb.size() <= 20) {
                    acb.add(aVar);
                }
            }
        }
    }

    public static synchronized a vL() {
        a remove;
        synchronized (ae.class) {
            int size = acb.size();
            remove = size > 0 ? acb.remove(size - 1) : null;
        }
        return remove;
    }
}
