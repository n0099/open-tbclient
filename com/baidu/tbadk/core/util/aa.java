package com.baidu.tbadk.core.util;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class aa {
    private static ArrayList<a> bSv = new ArrayList<>();
    public static AtomicInteger bSw = new AtomicInteger(0);

    /* loaded from: classes.dex */
    public static class a {
        public long aWr;
        public int bSx;
        public int bSy;
        public int mMode;
        public long mTime;
    }

    public static int hZ(int i) {
        return bSw.getAndSet(i);
    }

    public static int ia(int i) {
        return bSw.addAndGet(i);
    }

    public static synchronized void a(a aVar) {
        synchronized (aa.class) {
            if (aVar != null) {
                if (bSv.size() <= 20) {
                    bSv.add(aVar);
                }
            }
        }
    }

    public static synchronized a aiP() {
        a remove;
        synchronized (aa.class) {
            int size = bSv.size();
            remove = size > 0 ? bSv.remove(size - 1) : null;
        }
        return remove;
    }
}
