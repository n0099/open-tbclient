package com.baidu.tbadk.core.util;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class af {
    private static ArrayList<a> afp = new ArrayList<>();
    public static AtomicInteger afq = new AtomicInteger(0);

    /* loaded from: classes.dex */
    public static class a {
        public int afr;
        public long afs;
        public int aft;
        public int mMode;
        public long mTime;
    }

    public static int cF(int i) {
        return afq.getAndSet(i);
    }

    public static int cG(int i) {
        return afq.addAndGet(i);
    }

    public static synchronized void a(a aVar) {
        synchronized (af.class) {
            if (aVar != null) {
                if (afp.size() <= 20) {
                    afp.add(aVar);
                }
            }
        }
    }

    public static synchronized a vg() {
        a remove;
        synchronized (af.class) {
            int size = afp.size();
            remove = size > 0 ? afp.remove(size - 1) : null;
        }
        return remove;
    }
}
