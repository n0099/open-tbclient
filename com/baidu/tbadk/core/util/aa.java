package com.baidu.tbadk.core.util;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class aa {
    private static ArrayList<a> aBL = new ArrayList<>();
    public static AtomicInteger aBM = new AtomicInteger(0);

    /* loaded from: classes.dex */
    public static class a {
        public int aBN;
        public int aBO;
        public int mMode;
        public long mSize;
        public long mTime;
    }

    public static int dE(int i) {
        return aBM.getAndSet(i);
    }

    public static int dF(int i) {
        return aBM.addAndGet(i);
    }

    public static synchronized void a(a aVar) {
        synchronized (aa.class) {
            if (aVar != null) {
                if (aBL.size() <= 20) {
                    aBL.add(aVar);
                }
            }
        }
    }

    public static synchronized a DH() {
        a remove;
        synchronized (aa.class) {
            int size = aBL.size();
            remove = size > 0 ? aBL.remove(size - 1) : null;
        }
        return remove;
    }
}
