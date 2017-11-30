package com.baidu.tbadk.core.util;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class aa {
    private static ArrayList<a> agE = new ArrayList<>();
    public static AtomicInteger agF = new AtomicInteger(0);

    /* loaded from: classes.dex */
    public static class a {
        public int agG;
        public long agH;
        public int agI;
        public int mMode;
        public long mTime;
    }

    public static int cI(int i) {
        return agF.getAndSet(i);
    }

    public static int cJ(int i) {
        return agF.addAndGet(i);
    }

    public static synchronized void a(a aVar) {
        synchronized (aa.class) {
            if (aVar != null) {
                if (agE.size() <= 20) {
                    agE.add(aVar);
                }
            }
        }
    }

    public static synchronized a vb() {
        a remove;
        synchronized (aa.class) {
            int size = agE.size();
            remove = size > 0 ? agE.remove(size - 1) : null;
        }
        return remove;
    }
}
