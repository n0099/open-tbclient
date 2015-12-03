package com.baidu.tbadk.core.util;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class af {
    private static ArrayList<a> abb = new ArrayList<>();
    public static AtomicInteger abc = new AtomicInteger(0);

    /* loaded from: classes.dex */
    public static class a {
        public int abd;
        public int abe;
        public int mMode;
        public int mSize;
        public long mTime;
    }

    public static int cv(int i) {
        return abc.getAndSet(i);
    }

    public static int cw(int i) {
        return abc.addAndGet(i);
    }

    public static synchronized void a(a aVar) {
        synchronized (af.class) {
            if (aVar != null) {
                if (abb.size() <= 20) {
                    abb.add(aVar);
                }
            }
        }
    }

    public static synchronized a uW() {
        a remove;
        synchronized (af.class) {
            int size = abb.size();
            remove = size > 0 ? abb.remove(size - 1) : null;
        }
        return remove;
    }
}
