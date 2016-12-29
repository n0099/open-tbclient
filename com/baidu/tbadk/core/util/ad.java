package com.baidu.tbadk.core.util;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class ad {
    private static ArrayList<a> aaF = new ArrayList<>();
    public static AtomicInteger aaG = new AtomicInteger(0);

    /* loaded from: classes.dex */
    public static class a {
        public int aaH;
        public long aaI;
        public int aaJ;
        public int mMode;
        public long mTime;
    }

    public static int cH(int i) {
        return aaG.getAndSet(i);
    }

    public static int cI(int i) {
        return aaG.addAndGet(i);
    }

    public static synchronized void a(a aVar) {
        synchronized (ad.class) {
            if (aVar != null) {
                if (aaF.size() <= 20) {
                    aaF.add(aVar);
                }
            }
        }
    }

    public static synchronized a uS() {
        a remove;
        synchronized (ad.class) {
            int size = aaF.size();
            remove = size > 0 ? aaF.remove(size - 1) : null;
        }
        return remove;
    }
}
