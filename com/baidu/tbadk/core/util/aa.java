package com.baidu.tbadk.core.util;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class aa {
    private static ArrayList<a> afX = new ArrayList<>();
    public static AtomicInteger afY = new AtomicInteger(0);

    /* loaded from: classes.dex */
    public static class a {
        public int afZ;
        public long aga;
        public int agb;
        public int mMode;
        public long mTime;
    }

    public static int cI(int i) {
        return afY.getAndSet(i);
    }

    public static int cJ(int i) {
        return afY.addAndGet(i);
    }

    public static synchronized void a(a aVar) {
        synchronized (aa.class) {
            if (aVar != null) {
                if (afX.size() <= 20) {
                    afX.add(aVar);
                }
            }
        }
    }

    public static synchronized a uY() {
        a remove;
        synchronized (aa.class) {
            int size = afX.size();
            remove = size > 0 ? afX.remove(size - 1) : null;
        }
        return remove;
    }
}
