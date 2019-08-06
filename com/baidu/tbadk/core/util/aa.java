package com.baidu.tbadk.core.util;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class aa {
    private static ArrayList<a> bSB = new ArrayList<>();
    public static AtomicInteger bSC = new AtomicInteger(0);

    /* loaded from: classes.dex */
    public static class a {
        public long aWr;
        public int bSD;
        public int bSE;
        public int mMode;
        public long mTime;
    }

    public static int hZ(int i) {
        return bSC.getAndSet(i);
    }

    public static int ia(int i) {
        return bSC.addAndGet(i);
    }

    public static synchronized void a(a aVar) {
        synchronized (aa.class) {
            if (aVar != null) {
                if (bSB.size() <= 20) {
                    bSB.add(aVar);
                }
            }
        }
    }

    public static synchronized a aiR() {
        a remove;
        synchronized (aa.class) {
            int size = bSB.size();
            remove = size > 0 ? bSB.remove(size - 1) : null;
        }
        return remove;
    }
}
