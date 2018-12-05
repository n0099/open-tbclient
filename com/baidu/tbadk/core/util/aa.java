package com.baidu.tbadk.core.util;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class aa {
    private static ArrayList<a> aBi = new ArrayList<>();
    public static AtomicInteger aBj = new AtomicInteger(0);

    /* loaded from: classes.dex */
    public static class a {
        public int aBk;
        public int aBl;
        public int mMode;
        public long mSize;
        public long mTime;
    }

    public static int dE(int i) {
        return aBj.getAndSet(i);
    }

    public static int dF(int i) {
        return aBj.addAndGet(i);
    }

    public static synchronized void a(a aVar) {
        synchronized (aa.class) {
            if (aVar != null) {
                if (aBi.size() <= 20) {
                    aBi.add(aVar);
                }
            }
        }
    }

    public static synchronized a Du() {
        a remove;
        synchronized (aa.class) {
            int size = aBi.size();
            remove = size > 0 ? aBi.remove(size - 1) : null;
        }
        return remove;
    }
}
