package com.baidu.tbadk.core.util;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class aa {
    private static ArrayList<a> aWj = new ArrayList<>();
    public static AtomicInteger aWk = new AtomicInteger(0);

    /* loaded from: classes.dex */
    public static class a {
        public int aWl;
        public long aWm;
        public int aWn;
        public int mMode;
        public long mTime;
    }

    public static int fF(int i) {
        return aWk.getAndSet(i);
    }

    public static int fG(int i) {
        return aWk.addAndGet(i);
    }

    public static synchronized void a(a aVar) {
        synchronized (aa.class) {
            if (aVar != null) {
                if (aWj.size() <= 20) {
                    aWj.add(aVar);
                }
            }
        }
    }

    public static synchronized a CK() {
        a remove;
        synchronized (aa.class) {
            int size = aWj.size();
            remove = size > 0 ? aWj.remove(size - 1) : null;
        }
        return remove;
    }
}
