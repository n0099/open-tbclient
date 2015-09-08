package com.baidu.tbadk.core.util;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class z {
    private static ArrayList<a> aap = new ArrayList<>();
    public static AtomicInteger aaq = new AtomicInteger(0);

    /* loaded from: classes.dex */
    public static class a {
        public int aar;
        public int aas;
        public int mMode;
        public int mSize;
        public long mTime;
    }

    public static int cl(int i) {
        return aaq.getAndSet(i);
    }

    public static int cm(int i) {
        return aaq.addAndGet(i);
    }

    public static synchronized void a(a aVar) {
        synchronized (z.class) {
            if (aVar != null) {
                if (aap.size() <= 20) {
                    aap.add(aVar);
                }
            }
        }
    }

    public static synchronized a us() {
        a remove;
        synchronized (z.class) {
            int size = aap.size();
            remove = size > 0 ? aap.remove(size - 1) : null;
        }
        return remove;
    }
}
