package com.baidu.tbadk.core.util;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class ab {
    private static ArrayList<a> aqj = new ArrayList<>();
    public static AtomicInteger aqk = new AtomicInteger(0);

    /* loaded from: classes.dex */
    public static class a {
        public int aql;
        public long aqm;
        public int aqn;
        public int mMode;
        public long mTime;
    }

    public static int cH(int i) {
        return aqk.getAndSet(i);
    }

    public static int cI(int i) {
        return aqk.addAndGet(i);
    }

    public static synchronized void a(a aVar) {
        synchronized (ab.class) {
            if (aVar != null) {
                if (aqj.size() <= 20) {
                    aqj.add(aVar);
                }
            }
        }
    }

    public static synchronized a zi() {
        a remove;
        synchronized (ab.class) {
            int size = aqj.size();
            remove = size > 0 ? aqj.remove(size - 1) : null;
        }
        return remove;
    }
}
