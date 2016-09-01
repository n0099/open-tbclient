package com.baidu.tbadk.core.util;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class af {
    private static ArrayList<a> aaA = new ArrayList<>();
    public static AtomicInteger aaB = new AtomicInteger(0);

    /* loaded from: classes.dex */
    public static class a {
        public int aaC;
        public long aaD;
        public int aaE;
        public int mMode;
        public long mTime;
    }

    public static int cE(int i) {
        return aaB.getAndSet(i);
    }

    public static int cF(int i) {
        return aaB.addAndGet(i);
    }

    public static synchronized void a(a aVar) {
        synchronized (af.class) {
            if (aVar != null) {
                if (aaA.size() <= 20) {
                    aaA.add(aVar);
                }
            }
        }
    }

    public static synchronized a uN() {
        a remove;
        synchronized (af.class) {
            int size = aaA.size();
            remove = size > 0 ? aaA.remove(size - 1) : null;
        }
        return remove;
    }
}
