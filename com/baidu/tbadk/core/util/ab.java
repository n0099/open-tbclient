package com.baidu.tbadk.core.util;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class ab {
    private static ArrayList<a> apK = new ArrayList<>();
    public static AtomicInteger apL = new AtomicInteger(0);

    /* loaded from: classes.dex */
    public static class a {
        public int apM;
        public long apN;
        public int apO;
        public int mMode;
        public long mTime;
    }

    public static int cJ(int i) {
        return apL.getAndSet(i);
    }

    public static int cK(int i) {
        return apL.addAndGet(i);
    }

    public static synchronized void a(a aVar) {
        synchronized (ab.class) {
            if (aVar != null) {
                if (apK.size() <= 20) {
                    apK.add(aVar);
                }
            }
        }
    }

    public static synchronized a yZ() {
        a remove;
        synchronized (ab.class) {
            int size = apK.size();
            remove = size > 0 ? apK.remove(size - 1) : null;
        }
        return remove;
    }
}
