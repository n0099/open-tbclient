package com.baidu.tbadk.core.util;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class ao {
    private static ArrayList<ap> IS = new ArrayList<>();
    public static AtomicInteger IT = new AtomicInteger(0);

    public static int bS(int i) {
        return IT.getAndSet(i);
    }

    public static int bT(int i) {
        return IT.addAndGet(i);
    }

    public static synchronized void a(ap apVar) {
        synchronized (ao.class) {
            if (apVar != null) {
                if (IS.size() <= 20) {
                    IS.add(apVar);
                }
            }
        }
    }

    public static synchronized ap pp() {
        ap remove;
        synchronized (ao.class) {
            int size = IS.size();
            remove = size > 0 ? IS.remove(size - 1) : null;
        }
        return remove;
    }
}
