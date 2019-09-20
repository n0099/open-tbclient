package com.baidu.tbadk.core.util;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class aa {
    private static ArrayList<a> bTc = new ArrayList<>();
    public static AtomicInteger bTd = new AtomicInteger(0);

    /* loaded from: classes.dex */
    public static class a {
        public long aWP;
        public int bTe;
        public int bTf;
        public int mMode;
        public long mTime;
    }

    public static int hZ(int i) {
        return bTd.getAndSet(i);
    }

    public static int ia(int i) {
        return bTd.addAndGet(i);
    }

    public static synchronized void a(a aVar) {
        synchronized (aa.class) {
            if (aVar != null) {
                if (bTc.size() <= 20) {
                    bTc.add(aVar);
                }
            }
        }
    }

    public static synchronized a aiV() {
        a remove;
        synchronized (aa.class) {
            int size = bTc.size();
            remove = size > 0 ? bTc.remove(size - 1) : null;
        }
        return remove;
    }
}
