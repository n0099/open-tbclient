package com.baidu.tbadk.core.util;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class al {
    private static ArrayList<am> UH = new ArrayList<>();
    public static AtomicInteger UI = new AtomicInteger(0);

    public static int bY(int i) {
        return UI.getAndSet(i);
    }

    public static int bZ(int i) {
        return UI.addAndGet(i);
    }

    public static synchronized void a(am amVar) {
        synchronized (al.class) {
            if (amVar != null) {
                if (UH.size() <= 20) {
                    UH.add(amVar);
                }
            }
        }
    }

    public static synchronized am sI() {
        am remove;
        synchronized (al.class) {
            int size = UH.size();
            remove = size > 0 ? UH.remove(size - 1) : null;
        }
        return remove;
    }
}
