package com.baidu.tbadk.core.util;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class aa {
    private static ArrayList<a> bJG = new ArrayList<>();
    public static AtomicInteger bJH = new AtomicInteger(0);

    /* loaded from: classes.dex */
    public static class a {
        public long aSN;
        public int bJI;
        public int bJJ;
        public int mMode;
        public long mTime;
    }

    public static int hg(int i) {
        return bJH.getAndSet(i);
    }

    public static int hh(int i) {
        return bJH.addAndGet(i);
    }

    public static synchronized void a(a aVar) {
        synchronized (aa.class) {
            if (aVar != null) {
                if (bJG.size() <= 20) {
                    bJG.add(aVar);
                }
            }
        }
    }

    public static synchronized a acS() {
        a remove;
        synchronized (aa.class) {
            int size = bJG.size();
            remove = size > 0 ? bJG.remove(size - 1) : null;
        }
        return remove;
    }
}
