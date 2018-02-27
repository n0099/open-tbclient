package com.baidu.tbadk.core.util;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class aa {
    private static ArrayList<a> aWh = new ArrayList<>();
    public static AtomicInteger aWi = new AtomicInteger(0);

    /* loaded from: classes.dex */
    public static class a {
        public int aWj;
        public long aWk;
        public int aWl;
        public int mMode;
        public long mTime;
    }

    public static int fF(int i) {
        return aWi.getAndSet(i);
    }

    public static int fG(int i) {
        return aWi.addAndGet(i);
    }

    public static synchronized void a(a aVar) {
        synchronized (aa.class) {
            if (aVar != null) {
                if (aWh.size() <= 20) {
                    aWh.add(aVar);
                }
            }
        }
    }

    public static synchronized a CJ() {
        a remove;
        synchronized (aa.class) {
            int size = aWh.size();
            remove = size > 0 ? aWh.remove(size - 1) : null;
        }
        return remove;
    }
}
