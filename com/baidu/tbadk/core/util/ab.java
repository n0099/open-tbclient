package com.baidu.tbadk.core.util;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class ab {
    private static ArrayList<a> apL = new ArrayList<>();
    public static AtomicInteger apM = new AtomicInteger(0);

    /* loaded from: classes.dex */
    public static class a {
        public int apN;
        public long apO;
        public int apP;
        public int mMode;
        public long mTime;
    }

    public static int cJ(int i) {
        return apM.getAndSet(i);
    }

    public static int cK(int i) {
        return apM.addAndGet(i);
    }

    public static synchronized void a(a aVar) {
        synchronized (ab.class) {
            if (aVar != null) {
                if (apL.size() <= 20) {
                    apL.add(aVar);
                }
            }
        }
    }

    public static synchronized a yX() {
        a remove;
        synchronized (ab.class) {
            int size = apL.size();
            remove = size > 0 ? apL.remove(size - 1) : null;
        }
        return remove;
    }
}
