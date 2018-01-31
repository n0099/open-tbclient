package com.baidu.tbadk.core.util;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class aa {
    private static ArrayList<a> aUN = new ArrayList<>();
    public static AtomicInteger aUO = new AtomicInteger(0);

    /* loaded from: classes.dex */
    public static class a {
        public int aUP;
        public long aUQ;
        public int aUR;
        public int mMode;
        public long mTime;
    }

    public static int fF(int i) {
        return aUO.getAndSet(i);
    }

    public static int fG(int i) {
        return aUO.addAndGet(i);
    }

    public static synchronized void a(a aVar) {
        synchronized (aa.class) {
            if (aVar != null) {
                if (aUN.size() <= 20) {
                    aUN.add(aVar);
                }
            }
        }
    }

    public static synchronized a Cr() {
        a remove;
        synchronized (aa.class) {
            int size = aUN.size();
            remove = size > 0 ? aUN.remove(size - 1) : null;
        }
        return remove;
    }
}
