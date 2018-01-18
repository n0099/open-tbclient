package com.baidu.tbadk.core.util;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class aa {
    private static ArrayList<a> aUK = new ArrayList<>();
    public static AtomicInteger aUL = new AtomicInteger(0);

    /* loaded from: classes.dex */
    public static class a {
        public int aUM;
        public long aUN;
        public int aUO;
        public int mMode;
        public long mTime;
    }

    public static int fF(int i) {
        return aUL.getAndSet(i);
    }

    public static int fG(int i) {
        return aUL.addAndGet(i);
    }

    public static synchronized void a(a aVar) {
        synchronized (aa.class) {
            if (aVar != null) {
                if (aUK.size() <= 20) {
                    aUK.add(aVar);
                }
            }
        }
    }

    public static synchronized a Cq() {
        a remove;
        synchronized (aa.class) {
            int size = aUK.size();
            remove = size > 0 ? aUK.remove(size - 1) : null;
        }
        return remove;
    }
}
