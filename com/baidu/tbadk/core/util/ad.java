package com.baidu.tbadk.core.util;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class ad {
    private static ArrayList<a> aeQ = new ArrayList<>();
    public static AtomicInteger aeR = new AtomicInteger(0);

    /* loaded from: classes.dex */
    public static class a {
        public int aeS;
        public long aeT;
        public int aeU;
        public int mMode;
        public long mTime;
    }

    public static int cC(int i) {
        return aeR.getAndSet(i);
    }

    public static int cD(int i) {
        return aeR.addAndGet(i);
    }

    public static synchronized void a(a aVar) {
        synchronized (ad.class) {
            if (aVar != null) {
                if (aeQ.size() <= 20) {
                    aeQ.add(aVar);
                }
            }
        }
    }

    public static synchronized a uT() {
        a remove;
        synchronized (ad.class) {
            int size = aeQ.size();
            remove = size > 0 ? aeQ.remove(size - 1) : null;
        }
        return remove;
    }
}
