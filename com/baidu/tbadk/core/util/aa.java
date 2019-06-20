package com.baidu.tbadk.core.util;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class aa {
    private static ArrayList<a> bRv = new ArrayList<>();
    public static AtomicInteger bRw = new AtomicInteger(0);

    /* loaded from: classes.dex */
    public static class a {
        public long aVH;
        public int bRx;
        public int bRy;
        public int mMode;
        public long mTime;
    }

    public static int hT(int i) {
        return bRw.getAndSet(i);
    }

    public static int hU(int i) {
        return bRw.addAndGet(i);
    }

    public static synchronized void a(a aVar) {
        synchronized (aa.class) {
            if (aVar != null) {
                if (bRv.size() <= 20) {
                    bRv.add(aVar);
                }
            }
        }
    }

    public static synchronized a ahN() {
        a remove;
        synchronized (aa.class) {
            int size = bRv.size();
            remove = size > 0 ? bRv.remove(size - 1) : null;
        }
        return remove;
    }
}
