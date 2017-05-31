package com.baidu.tbadk.core.util;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class ad {
    private static ArrayList<a> aeH = new ArrayList<>();
    public static AtomicInteger aeI = new AtomicInteger(0);

    /* loaded from: classes.dex */
    public static class a {
        public int aeJ;
        public long aeK;
        public int aeL;
        public int mMode;
        public long mTime;
    }

    public static int cD(int i) {
        return aeI.getAndSet(i);
    }

    public static int cE(int i) {
        return aeI.addAndGet(i);
    }

    public static synchronized void a(a aVar) {
        synchronized (ad.class) {
            if (aVar != null) {
                if (aeH.size() <= 20) {
                    aeH.add(aVar);
                }
            }
        }
    }

    public static synchronized a uQ() {
        a remove;
        synchronized (ad.class) {
            int size = aeH.size();
            remove = size > 0 ? aeH.remove(size - 1) : null;
        }
        return remove;
    }
}
