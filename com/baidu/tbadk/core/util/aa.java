package com.baidu.tbadk.core.util;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class aa {
    private static ArrayList<a> aWt = new ArrayList<>();
    public static AtomicInteger aWu = new AtomicInteger(0);

    /* loaded from: classes.dex */
    public static class a {
        public int aWv;
        public long aWw;
        public int aWx;
        public int mMode;
        public long mTime;
    }

    public static int fF(int i) {
        return aWu.getAndSet(i);
    }

    public static int fG(int i) {
        return aWu.addAndGet(i);
    }

    public static synchronized void a(a aVar) {
        synchronized (aa.class) {
            if (aVar != null) {
                if (aWt.size() <= 20) {
                    aWt.add(aVar);
                }
            }
        }
    }

    public static synchronized a CK() {
        a remove;
        synchronized (aa.class) {
            int size = aWt.size();
            remove = size > 0 ? aWt.remove(size - 1) : null;
        }
        return remove;
    }
}
