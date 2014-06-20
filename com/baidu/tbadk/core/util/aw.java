package com.baidu.tbadk.core.util;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class aw {
    private static ArrayList<ax> b = new ArrayList<>();
    public static AtomicInteger a = new AtomicInteger(0);

    public static int a(int i) {
        return a.getAndSet(i);
    }

    public static int b(int i) {
        return a.addAndGet(i);
    }

    public static synchronized void a(ax axVar) {
        synchronized (aw.class) {
            if (axVar != null) {
                if (b.size() <= 20) {
                    b.add(axVar);
                }
            }
        }
    }

    public static synchronized ax a() {
        ax remove;
        synchronized (aw.class) {
            int size = b.size();
            remove = size > 0 ? b.remove(size - 1) : null;
        }
        return remove;
    }
}
