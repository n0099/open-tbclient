package com.baidu.tbadk.core.util;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class ad {
    private static ArrayList<a> afx = new ArrayList<>();
    public static AtomicInteger afy = new AtomicInteger(0);

    /* loaded from: classes.dex */
    public static class a {
        public long afA;
        public int afB;
        public int afz;
        public int mMode;
        public long mTime;
    }

    public static int cF(int i) {
        return afy.getAndSet(i);
    }

    public static int cG(int i) {
        return afy.addAndGet(i);
    }

    public static synchronized void a(a aVar) {
        synchronized (ad.class) {
            if (aVar != null) {
                if (afx.size() <= 20) {
                    afx.add(aVar);
                }
            }
        }
    }

    public static synchronized a vG() {
        a remove;
        synchronized (ad.class) {
            int size = afx.size();
            remove = size > 0 ? afx.remove(size - 1) : null;
        }
        return remove;
    }
}
