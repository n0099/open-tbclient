package com.baidu.tbadk.core.util;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class ai {
    private static ArrayList<aj> Vj = new ArrayList<>();
    public static AtomicInteger Vk = new AtomicInteger(0);

    public static int cb(int i) {
        return Vk.getAndSet(i);
    }

    public static int cc(int i) {
        return Vk.addAndGet(i);
    }

    public static synchronized void a(aj ajVar) {
        synchronized (ai.class) {
            if (ajVar != null) {
                if (Vj.size() <= 20) {
                    Vj.add(ajVar);
                }
            }
        }
    }

    public static synchronized aj tl() {
        aj remove;
        synchronized (ai.class) {
            int size = Vj.size();
            remove = size > 0 ? Vj.remove(size - 1) : null;
        }
        return remove;
    }
}
