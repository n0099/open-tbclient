package com.baidu.tbadk.core.util;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class z {
    private static ArrayList<a> ahi = new ArrayList<>();
    public static AtomicInteger ahj = new AtomicInteger(0);

    /* loaded from: classes.dex */
    public static class a {
        public long ahk;
        public int ahl;
        public int mMethod;
        public int mMode;
        public long mTime;
    }

    public static int cJ(int i) {
        return ahj.getAndSet(i);
    }

    public static int cK(int i) {
        return ahj.addAndGet(i);
    }

    public static synchronized void a(a aVar) {
        synchronized (z.class) {
            if (aVar != null) {
                if (ahi.size() <= 20) {
                    ahi.add(aVar);
                }
            }
        }
    }

    public static synchronized a vw() {
        a remove;
        synchronized (z.class) {
            int size = ahi.size();
            remove = size > 0 ? ahi.remove(size - 1) : null;
        }
        return remove;
    }
}
