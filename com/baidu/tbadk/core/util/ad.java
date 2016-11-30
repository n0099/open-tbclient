package com.baidu.tbadk.core.util;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class ad {
    private static ArrayList<a> abl = new ArrayList<>();
    public static AtomicInteger abm = new AtomicInteger(0);

    /* loaded from: classes.dex */
    public static class a {
        public int abn;
        public long abo;
        public int abp;
        public int mMode;
        public long mTime;
    }

    public static int cF(int i) {
        return abm.getAndSet(i);
    }

    public static int cG(int i) {
        return abm.addAndGet(i);
    }

    public static synchronized void a(a aVar) {
        synchronized (ad.class) {
            if (aVar != null) {
                if (abl.size() <= 20) {
                    abl.add(aVar);
                }
            }
        }
    }

    public static synchronized a vg() {
        a remove;
        synchronized (ad.class) {
            int size = abl.size();
            remove = size > 0 ? abl.remove(size - 1) : null;
        }
        return remove;
    }
}
