package com.baidu.tbadk.core.util;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class aa {
    private static ArrayList<a> agy = new ArrayList<>();
    public static AtomicInteger agz = new AtomicInteger(0);

    /* loaded from: classes.dex */
    public static class a {
        public int agA;
        public long agB;
        public int agC;
        public int mMode;
        public long mTime;
    }

    public static int cI(int i) {
        return agz.getAndSet(i);
    }

    public static int cJ(int i) {
        return agz.addAndGet(i);
    }

    public static synchronized void a(a aVar) {
        synchronized (aa.class) {
            if (aVar != null) {
                if (agy.size() <= 20) {
                    agy.add(aVar);
                }
            }
        }
    }

    public static synchronized a uY() {
        a remove;
        synchronized (aa.class) {
            int size = agy.size();
            remove = size > 0 ? agy.remove(size - 1) : null;
        }
        return remove;
    }
}
