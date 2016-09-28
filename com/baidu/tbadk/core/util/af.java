package com.baidu.tbadk.core.util;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class af {
    private static ArrayList<a> aaN = new ArrayList<>();
    public static AtomicInteger aaO = new AtomicInteger(0);

    /* loaded from: classes.dex */
    public static class a {
        public int aaP;
        public long aaQ;
        public int aaR;
        public int mMode;
        public long mTime;
    }

    public static int cE(int i) {
        return aaO.getAndSet(i);
    }

    public static int cF(int i) {
        return aaO.addAndGet(i);
    }

    public static synchronized void a(a aVar) {
        synchronized (af.class) {
            if (aVar != null) {
                if (aaN.size() <= 20) {
                    aaN.add(aVar);
                }
            }
        }
    }

    public static synchronized a vc() {
        a remove;
        synchronized (af.class) {
            int size = aaN.size();
            remove = size > 0 ? aaN.remove(size - 1) : null;
        }
        return remove;
    }
}
