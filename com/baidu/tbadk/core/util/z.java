package com.baidu.tbadk.core.util;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class z {
    private static ArrayList<a> aag = new ArrayList<>();
    public static AtomicInteger aah = new AtomicInteger(0);

    /* loaded from: classes.dex */
    public static class a {
        public int aai;
        public int aaj;
        public int mMode;
        public int mSize;
        public long mTime;
    }

    public static int ch(int i) {
        return aah.getAndSet(i);
    }

    public static int ci(int i) {
        return aah.addAndGet(i);
    }

    public static synchronized void a(a aVar) {
        synchronized (z.class) {
            if (aVar != null) {
                if (aag.size() <= 20) {
                    aag.add(aVar);
                }
            }
        }
    }

    public static synchronized a un() {
        a remove;
        synchronized (z.class) {
            int size = aag.size();
            remove = size > 0 ? aag.remove(size - 1) : null;
        }
        return remove;
    }
}
