package com.baidu.tbadk.core.util;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class ao {
    private static ArrayList<ap> IZ = new ArrayList<>();
    public static AtomicInteger Ja = new AtomicInteger(0);

    public static int bX(int i) {
        return Ja.getAndSet(i);
    }

    public static int bY(int i) {
        return Ja.addAndGet(i);
    }

    public static synchronized void a(ap apVar) {
        synchronized (ao.class) {
            if (apVar != null) {
                if (IZ.size() <= 20) {
                    IZ.add(apVar);
                }
            }
        }
    }

    public static synchronized ap pl() {
        ap remove;
        synchronized (ao.class) {
            int size = IZ.size();
            remove = size > 0 ? IZ.remove(size - 1) : null;
        }
        return remove;
    }
}
