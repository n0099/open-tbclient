package com.baidu.tbadk.core.util;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class aa {
    private static ArrayList<a> aBK = new ArrayList<>();
    public static AtomicInteger aBL = new AtomicInteger(0);

    /* loaded from: classes.dex */
    public static class a {
        public int aBM;
        public int aBN;
        public int mMode;
        public long mSize;
        public long mTime;
    }

    public static int dE(int i) {
        return aBL.getAndSet(i);
    }

    public static int dF(int i) {
        return aBL.addAndGet(i);
    }

    public static synchronized void a(a aVar) {
        synchronized (aa.class) {
            if (aVar != null) {
                if (aBK.size() <= 20) {
                    aBK.add(aVar);
                }
            }
        }
    }

    public static synchronized a DH() {
        a remove;
        synchronized (aa.class) {
            int size = aBK.size();
            remove = size > 0 ? aBK.remove(size - 1) : null;
        }
        return remove;
    }
}
