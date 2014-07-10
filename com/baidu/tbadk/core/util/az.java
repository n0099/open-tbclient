package com.baidu.tbadk.core.util;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class az {
    private static ArrayList<ba> b = new ArrayList<>();
    public static AtomicInteger a = new AtomicInteger(0);

    public static int a(int i) {
        return a.getAndSet(i);
    }

    public static int b(int i) {
        return a.addAndGet(i);
    }

    public static synchronized void a(ba baVar) {
        synchronized (az.class) {
            if (baVar != null) {
                if (b.size() <= 20) {
                    b.add(baVar);
                }
            }
        }
    }

    public static synchronized ba a() {
        ba remove;
        synchronized (az.class) {
            int size = b.size();
            remove = size > 0 ? b.remove(size - 1) : null;
        }
        return remove;
    }
}
