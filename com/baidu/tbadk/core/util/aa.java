package com.baidu.tbadk.core.util;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class aa {
    private static ArrayList<a> bJK = new ArrayList<>();
    public static AtomicInteger bJL = new AtomicInteger(0);

    /* loaded from: classes.dex */
    public static class a {
        public long aSS;
        public int bJM;
        public int bJN;
        public int mMode;
        public long mTime;
    }

    public static int hf(int i) {
        return bJL.getAndSet(i);
    }

    public static int hg(int i) {
        return bJL.addAndGet(i);
    }

    public static synchronized void a(a aVar) {
        synchronized (aa.class) {
            if (aVar != null) {
                if (bJK.size() <= 20) {
                    bJK.add(aVar);
                }
            }
        }
    }

    public static synchronized a acP() {
        a remove;
        synchronized (aa.class) {
            int size = bJK.size();
            remove = size > 0 ? bJK.remove(size - 1) : null;
        }
        return remove;
    }
}
