package com.baidu.tbadk.core.util;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class ad {
    private static ArrayList<a> afj = new ArrayList<>();
    public static AtomicInteger afk = new AtomicInteger(0);

    /* loaded from: classes.dex */
    public static class a {
        public int afl;
        public long afm;
        public int afn;
        public int mMode;
        public long mTime;
    }

    public static int cC(int i) {
        return afk.getAndSet(i);
    }

    public static int cD(int i) {
        return afk.addAndGet(i);
    }

    public static synchronized void a(a aVar) {
        synchronized (ad.class) {
            if (aVar != null) {
                if (afj.size() <= 20) {
                    afj.add(aVar);
                }
            }
        }
    }

    public static synchronized a vj() {
        a remove;
        synchronized (ad.class) {
            int size = afj.size();
            remove = size > 0 ? afj.remove(size - 1) : null;
        }
        return remove;
    }
}
