package com.baidu.tbadk.core.util;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class aa {
    private static ArrayList<a> aaj = new ArrayList<>();
    public static AtomicInteger aak = new AtomicInteger(0);

    /* loaded from: classes.dex */
    public static class a {
        public int aal;
        public int aam;
        public int mMode;
        public int mSize;
        public long mTime;
    }

    public static int cn(int i) {
        return aak.getAndSet(i);
    }

    public static int co(int i) {
        return aak.addAndGet(i);
    }

    public static synchronized void a(a aVar) {
        synchronized (aa.class) {
            if (aVar != null) {
                if (aaj.size() <= 20) {
                    aaj.add(aVar);
                }
            }
        }
    }

    public static synchronized a uq() {
        a remove;
        synchronized (aa.class) {
            int size = aaj.size();
            remove = size > 0 ? aaj.remove(size - 1) : null;
        }
        return remove;
    }
}
