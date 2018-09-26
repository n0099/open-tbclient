package com.baidu.tbadk.core.util;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class aa {
    private static ArrayList<a> asj = new ArrayList<>();
    public static AtomicInteger ask = new AtomicInteger(0);

    /* loaded from: classes.dex */
    public static class a {
        public int asl;
        public long asm;
        public int asn;
        public int mMode;
        public long mTime;
    }

    public static int cS(int i) {
        return ask.getAndSet(i);
    }

    public static int cT(int i) {
        return ask.addAndGet(i);
    }

    public static synchronized void a(a aVar) {
        synchronized (aa.class) {
            if (aVar != null) {
                if (asj.size() <= 20) {
                    asj.add(aVar);
                }
            }
        }
    }

    public static synchronized a Ac() {
        a remove;
        synchronized (aa.class) {
            int size = asj.size();
            remove = size > 0 ? asj.remove(size - 1) : null;
        }
        return remove;
    }
}
