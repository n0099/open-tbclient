package com.baidu.tbadk.core.util;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class ac {
    private static ArrayList<a> ZT = new ArrayList<>();
    public static AtomicInteger ZU = new AtomicInteger(0);

    /* loaded from: classes.dex */
    public static class a {
        public int ZV;
        public long ZW;
        public int ZX;
        public int mMode;
        public long mTime;
    }

    public static int cG(int i) {
        return ZU.getAndSet(i);
    }

    public static int cH(int i) {
        return ZU.addAndGet(i);
    }

    public static synchronized void a(a aVar) {
        synchronized (ac.class) {
            if (aVar != null) {
                if (ZT.size() <= 20) {
                    ZT.add(aVar);
                }
            }
        }
    }

    public static synchronized a uM() {
        a remove;
        synchronized (ac.class) {
            int size = ZT.size();
            remove = size > 0 ? ZT.remove(size - 1) : null;
        }
        return remove;
    }
}
