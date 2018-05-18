package com.baidu.tbadk.core.util;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class aa {
    private static ArrayList<a> ahD = new ArrayList<>();
    public static AtomicInteger ahE = new AtomicInteger(0);

    /* loaded from: classes.dex */
    public static class a {
        public int ahF;
        public long ahG;
        public int ahH;
        public int mMode;
        public long mTime;
    }

    public static int cE(int i) {
        return ahE.getAndSet(i);
    }

    public static int cF(int i) {
        return ahE.addAndGet(i);
    }

    public static synchronized void a(a aVar) {
        synchronized (aa.class) {
            if (aVar != null) {
                if (ahD.size() <= 20) {
                    ahD.add(aVar);
                }
            }
        }
    }

    public static synchronized a vt() {
        a remove;
        synchronized (aa.class) {
            int size = ahD.size();
            remove = size > 0 ? ahD.remove(size - 1) : null;
        }
        return remove;
    }
}
