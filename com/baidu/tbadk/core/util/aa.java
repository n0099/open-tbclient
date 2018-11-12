package com.baidu.tbadk.core.util;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class aa {
    private static ArrayList<a> axI = new ArrayList<>();
    public static AtomicInteger axJ = new AtomicInteger(0);

    /* loaded from: classes.dex */
    public static class a {
        public int axK;
        public int axL;
        public int mMode;
        public long mSize;
        public long mTime;
    }

    public static int dq(int i) {
        return axJ.getAndSet(i);
    }

    public static int dr(int i) {
        return axJ.addAndGet(i);
    }

    public static synchronized void a(a aVar) {
        synchronized (aa.class) {
            if (aVar != null) {
                if (axI.size() <= 20) {
                    axI.add(aVar);
                }
            }
        }
    }

    public static synchronized a Cq() {
        a remove;
        synchronized (aa.class) {
            int size = axI.size();
            remove = size > 0 ? axI.remove(size - 1) : null;
        }
        return remove;
    }
}
