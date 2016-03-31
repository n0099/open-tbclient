package com.baidu.tbadk.core.util;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class af {
    private static ArrayList<a> abn = new ArrayList<>();
    public static AtomicInteger abo = new AtomicInteger(0);

    /* loaded from: classes.dex */
    public static class a {
        public int abp;
        public long abq;
        public int abr;
        public int mMode;
        public long mTime;
    }

    public static int cI(int i) {
        return abo.getAndSet(i);
    }

    public static int cJ(int i) {
        return abo.addAndGet(i);
    }

    public static synchronized void a(a aVar) {
        synchronized (af.class) {
            if (aVar != null) {
                if (abn.size() <= 20) {
                    abn.add(aVar);
                }
            }
        }
    }

    public static synchronized a we() {
        a remove;
        synchronized (af.class) {
            int size = abn.size();
            remove = size > 0 ? abn.remove(size - 1) : null;
        }
        return remove;
    }
}
