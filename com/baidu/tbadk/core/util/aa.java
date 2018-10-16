package com.baidu.tbadk.core.util;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class aa {
    private static ArrayList<a> awV = new ArrayList<>();
    public static AtomicInteger awW = new AtomicInteger(0);

    /* loaded from: classes.dex */
    public static class a {
        public int awX;
        public int awY;
        public int mMode;
        public long mSize;
        public long mTime;
    }

    public static int dc(int i) {
        return awW.getAndSet(i);
    }

    public static int dd(int i) {
        return awW.addAndGet(i);
    }

    public static synchronized void a(a aVar) {
        synchronized (aa.class) {
            if (aVar != null) {
                if (awV.size() <= 20) {
                    awV.add(aVar);
                }
            }
        }
    }

    public static synchronized a Cj() {
        a remove;
        synchronized (aa.class) {
            int size = awV.size();
            remove = size > 0 ? awV.remove(size - 1) : null;
        }
        return remove;
    }
}
