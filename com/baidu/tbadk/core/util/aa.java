package com.baidu.tbadk.core.util;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class aa {
    private static ArrayList<a> bRu = new ArrayList<>();
    public static AtomicInteger bRv = new AtomicInteger(0);

    /* loaded from: classes.dex */
    public static class a {
        public long aVH;
        public int bRw;
        public int bRx;
        public int mMode;
        public long mTime;
    }

    public static int hT(int i) {
        return bRv.getAndSet(i);
    }

    public static int hU(int i) {
        return bRv.addAndGet(i);
    }

    public static synchronized void a(a aVar) {
        synchronized (aa.class) {
            if (aVar != null) {
                if (bRu.size() <= 20) {
                    bRu.add(aVar);
                }
            }
        }
    }

    public static synchronized a ahN() {
        a remove;
        synchronized (aa.class) {
            int size = bRu.size();
            remove = size > 0 ? bRu.remove(size - 1) : null;
        }
        return remove;
    }
}
