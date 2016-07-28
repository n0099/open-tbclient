package com.baidu.tbadk.core.util;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class af {
    private static ArrayList<a> XM = new ArrayList<>();
    public static AtomicInteger XN = new AtomicInteger(0);

    /* loaded from: classes.dex */
    public static class a {
        public int XO;
        public long XP;
        public int XQ;
        public int mMode;
        public long mTime;
    }

    public static int cr(int i) {
        return XN.getAndSet(i);
    }

    public static int cs(int i) {
        return XN.addAndGet(i);
    }

    public static synchronized void a(a aVar) {
        synchronized (af.class) {
            if (aVar != null) {
                if (XM.size() <= 20) {
                    XM.add(aVar);
                }
            }
        }
    }

    public static synchronized a tH() {
        a remove;
        synchronized (af.class) {
            int size = XM.size();
            remove = size > 0 ? XM.remove(size - 1) : null;
        }
        return remove;
    }
}
