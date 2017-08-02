package com.baidu.tbadk.core.util;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class z {
    private static ArrayList<a> afL = new ArrayList<>();
    public static AtomicInteger afM = new AtomicInteger(0);

    /* loaded from: classes.dex */
    public static class a {
        public int afN;
        public long afO;
        public int afP;
        public int mMode;
        public long mTime;
    }

    public static int cH(int i) {
        return afM.getAndSet(i);
    }

    public static int cI(int i) {
        return afM.addAndGet(i);
    }

    public static synchronized void a(a aVar) {
        synchronized (z.class) {
            if (aVar != null) {
                if (afL.size() <= 20) {
                    afL.add(aVar);
                }
            }
        }
    }

    public static synchronized a vm() {
        a remove;
        synchronized (z.class) {
            int size = afL.size();
            remove = size > 0 ? afL.remove(size - 1) : null;
        }
        return remove;
    }
}
