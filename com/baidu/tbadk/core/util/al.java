package com.baidu.tbadk.core.util;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class al {
    private static ArrayList<am> UF = new ArrayList<>();
    public static AtomicInteger UG = new AtomicInteger(0);

    public static int bY(int i) {
        return UG.getAndSet(i);
    }

    public static int bZ(int i) {
        return UG.addAndGet(i);
    }

    public static synchronized void a(am amVar) {
        synchronized (al.class) {
            if (amVar != null) {
                if (UF.size() <= 20) {
                    UF.add(amVar);
                }
            }
        }
    }

    public static synchronized am sI() {
        am remove;
        synchronized (al.class) {
            int size = UF.size();
            remove = size > 0 ? UF.remove(size - 1) : null;
        }
        return remove;
    }
}
