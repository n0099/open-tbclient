package com.baidu.tbadk.core.util;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class ao {
    private static ArrayList<ap> Jc = new ArrayList<>();
    public static AtomicInteger Jd = new AtomicInteger(0);

    public static int bX(int i) {
        return Jd.getAndSet(i);
    }

    public static int bY(int i) {
        return Jd.addAndGet(i);
    }

    public static synchronized void a(ap apVar) {
        synchronized (ao.class) {
            if (apVar != null) {
                if (Jc.size() <= 20) {
                    Jc.add(apVar);
                }
            }
        }
    }

    public static synchronized ap ps() {
        ap remove;
        synchronized (ao.class) {
            int size = Jc.size();
            remove = size > 0 ? Jc.remove(size - 1) : null;
        }
        return remove;
    }
}
