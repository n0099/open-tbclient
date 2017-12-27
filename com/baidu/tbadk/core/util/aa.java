package com.baidu.tbadk.core.util;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class aa {
    private static ArrayList<a> aUL = new ArrayList<>();
    public static AtomicInteger aUM = new AtomicInteger(0);

    /* loaded from: classes.dex */
    public static class a {
        public int aUN;
        public long aUO;
        public int aUP;
        public int mMode;
        public long mTime;
    }

    public static int fH(int i) {
        return aUM.getAndSet(i);
    }

    public static int fI(int i) {
        return aUM.addAndGet(i);
    }

    public static synchronized void a(a aVar) {
        synchronized (aa.class) {
            if (aVar != null) {
                if (aUL.size() <= 20) {
                    aUL.add(aVar);
                }
            }
        }
    }

    public static synchronized a Cy() {
        a remove;
        synchronized (aa.class) {
            int size = aUL.size();
            remove = size > 0 ? aUL.remove(size - 1) : null;
        }
        return remove;
    }
}
