package com.baidu.tbadk.core.util;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class ad {
    private static ArrayList<a> afy = new ArrayList<>();
    public static AtomicInteger afz = new AtomicInteger(0);

    /* loaded from: classes.dex */
    public static class a {
        public int afA;
        public long afB;
        public int afC;
        public int mMode;
        public long mTime;
    }

    public static int cF(int i) {
        return afz.getAndSet(i);
    }

    public static int cG(int i) {
        return afz.addAndGet(i);
    }

    public static synchronized void a(a aVar) {
        synchronized (ad.class) {
            if (aVar != null) {
                if (afy.size() <= 20) {
                    afy.add(aVar);
                }
            }
        }
    }

    public static synchronized a vG() {
        a remove;
        synchronized (ad.class) {
            int size = afy.size();
            remove = size > 0 ? afy.remove(size - 1) : null;
        }
        return remove;
    }
}
