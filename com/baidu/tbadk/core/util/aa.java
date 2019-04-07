package com.baidu.tbadk.core.util;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class aa {
    private static ArrayList<a> bJJ = new ArrayList<>();
    public static AtomicInteger bJK = new AtomicInteger(0);

    /* loaded from: classes.dex */
    public static class a {
        public long aSR;
        public int bJL;
        public int bJM;
        public int mMode;
        public long mTime;
    }

    public static int hf(int i) {
        return bJK.getAndSet(i);
    }

    public static int hg(int i) {
        return bJK.addAndGet(i);
    }

    public static synchronized void a(a aVar) {
        synchronized (aa.class) {
            if (aVar != null) {
                if (bJJ.size() <= 20) {
                    bJJ.add(aVar);
                }
            }
        }
    }

    public static synchronized a acP() {
        a remove;
        synchronized (aa.class) {
            int size = bJJ.size();
            remove = size > 0 ? bJJ.remove(size - 1) : null;
        }
        return remove;
    }
}
