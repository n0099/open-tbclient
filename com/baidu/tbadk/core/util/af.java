package com.baidu.tbadk.core.util;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class af {
    private static ArrayList<a> abF = new ArrayList<>();
    public static AtomicInteger abG = new AtomicInteger(0);

    /* loaded from: classes.dex */
    public static class a {
        public int abH;
        public long abI;
        public int abJ;
        public int mMode;
        public long mTime;
    }

    public static int co(int i) {
        return abG.getAndSet(i);
    }

    public static int cp(int i) {
        return abG.addAndGet(i);
    }

    public static synchronized void a(a aVar) {
        synchronized (af.class) {
            if (aVar != null) {
                if (abF.size() <= 20) {
                    abF.add(aVar);
                }
            }
        }
    }

    public static synchronized a uG() {
        a remove;
        synchronized (af.class) {
            int size = abF.size();
            remove = size > 0 ? abF.remove(size - 1) : null;
        }
        return remove;
    }
}
