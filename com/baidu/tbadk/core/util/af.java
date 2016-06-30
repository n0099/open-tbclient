package com.baidu.tbadk.core.util;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class af {
    private static ArrayList<a> Xd = new ArrayList<>();
    public static AtomicInteger Xe = new AtomicInteger(0);

    /* loaded from: classes.dex */
    public static class a {
        public int Xf;
        public long Xg;
        public int Xh;
        public int mMode;
        public long mTime;
    }

    public static int cr(int i) {
        return Xe.getAndSet(i);
    }

    public static int cs(int i) {
        return Xe.addAndGet(i);
    }

    public static synchronized void a(a aVar) {
        synchronized (af.class) {
            if (aVar != null) {
                if (Xd.size() <= 20) {
                    Xd.add(aVar);
                }
            }
        }
    }

    public static synchronized a tI() {
        a remove;
        synchronized (af.class) {
            int size = Xd.size();
            remove = size > 0 ? Xd.remove(size - 1) : null;
        }
        return remove;
    }
}
