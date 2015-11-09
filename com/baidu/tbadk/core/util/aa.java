package com.baidu.tbadk.core.util;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class aa {
    private static ArrayList<a> aap = new ArrayList<>();
    public static AtomicInteger aaq = new AtomicInteger(0);

    /* loaded from: classes.dex */
    public static class a {
        public int aar;
        public int aas;
        public int mMode;
        public int mSize;
        public long mTime;
    }

    public static int cn(int i) {
        return aaq.getAndSet(i);
    }

    public static int co(int i) {
        return aaq.addAndGet(i);
    }

    public static synchronized void a(a aVar) {
        synchronized (aa.class) {
            if (aVar != null) {
                if (aap.size() <= 20) {
                    aap.add(aVar);
                }
            }
        }
    }

    public static synchronized a uq() {
        a remove;
        synchronized (aa.class) {
            int size = aap.size();
            remove = size > 0 ? aap.remove(size - 1) : null;
        }
        return remove;
    }
}
