package com.baidu.tbadk.core.util;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class au {
    private static ArrayList<av> b = new ArrayList<>();
    public static AtomicInteger a = new AtomicInteger(0);

    public static int a(int i) {
        return a.getAndSet(i);
    }

    public static int b(int i) {
        return a.addAndGet(i);
    }

    public static synchronized void a(av avVar) {
        synchronized (au.class) {
            if (avVar != null) {
                if (b.size() <= 20) {
                    b.add(avVar);
                }
            }
        }
    }

    public static synchronized av a() {
        av remove;
        synchronized (au.class) {
            int size = b.size();
            remove = size > 0 ? b.remove(size - 1) : null;
        }
        return remove;
    }
}
