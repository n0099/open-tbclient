package com.baidu.tbadk.core.util;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class aa {
    private static ArrayList<a> bJH = new ArrayList<>();
    public static AtomicInteger bJI = new AtomicInteger(0);

    /* loaded from: classes.dex */
    public static class a {
        public long aSO;
        public int bJJ;
        public int bJK;
        public int mMode;
        public long mTime;
    }

    public static int hg(int i) {
        return bJI.getAndSet(i);
    }

    public static int hh(int i) {
        return bJI.addAndGet(i);
    }

    public static synchronized void a(a aVar) {
        synchronized (aa.class) {
            if (aVar != null) {
                if (bJH.size() <= 20) {
                    bJH.add(aVar);
                }
            }
        }
    }

    public static synchronized a acS() {
        a remove;
        synchronized (aa.class) {
            int size = bJH.size();
            remove = size > 0 ? bJH.remove(size - 1) : null;
        }
        return remove;
    }
}
