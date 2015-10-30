package com.baidu.tbadk.core.util;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class aa {
    private static ArrayList<a> aal = new ArrayList<>();
    public static AtomicInteger aam = new AtomicInteger(0);

    /* loaded from: classes.dex */
    public static class a {
        public int aan;
        public int aao;
        public int mMode;
        public int mSize;
        public long mTime;
    }

    public static int cn(int i) {
        return aam.getAndSet(i);
    }

    public static int co(int i) {
        return aam.addAndGet(i);
    }

    public static synchronized void a(a aVar) {
        synchronized (aa.class) {
            if (aVar != null) {
                if (aal.size() <= 20) {
                    aal.add(aVar);
                }
            }
        }
    }

    public static synchronized a un() {
        a remove;
        synchronized (aa.class) {
            int size = aal.size();
            remove = size > 0 ? aal.remove(size - 1) : null;
        }
        return remove;
    }
}
