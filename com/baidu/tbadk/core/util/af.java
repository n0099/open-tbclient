package com.baidu.tbadk.core.util;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class af {
    private static ArrayList<a> WN = new ArrayList<>();
    public static AtomicInteger WO = new AtomicInteger(0);

    /* loaded from: classes.dex */
    public static class a {
        public int WP;
        public long WQ;
        public int WR;
        public int mMode;
        public long mTime;
    }

    public static int cr(int i) {
        return WO.getAndSet(i);
    }

    public static int cs(int i) {
        return WO.addAndGet(i);
    }

    public static synchronized void a(a aVar) {
        synchronized (af.class) {
            if (aVar != null) {
                if (WN.size() <= 20) {
                    WN.add(aVar);
                }
            }
        }
    }

    public static synchronized a tK() {
        a remove;
        synchronized (af.class) {
            int size = WN.size();
            remove = size > 0 ? WN.remove(size - 1) : null;
        }
        return remove;
    }
}
