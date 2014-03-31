package com.baidu.tbadk.core.util;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public final class at {
    private static ArrayList<au> b = new ArrayList<>();
    public static AtomicInteger a = new AtomicInteger(0);

    public static int a(int i) {
        return a.getAndSet(0);
    }

    public static int b(int i) {
        return a.addAndGet(i);
    }

    public static synchronized void a(au auVar) {
        synchronized (at.class) {
            if (auVar != null) {
                if (b.size() <= 20) {
                    b.add(auVar);
                }
            }
        }
    }

    public static synchronized au a() {
        au remove;
        synchronized (at.class) {
            int size = b.size();
            remove = size > 0 ? b.remove(size - 1) : null;
        }
        return remove;
    }
}
