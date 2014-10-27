package com.baidu.tbadk.core.util;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class an {
    private static ArrayList<ao> EG = new ArrayList<>();
    public static AtomicInteger EH = new AtomicInteger(0);

    public static int bv(int i) {
        return EH.getAndSet(i);
    }

    public static int bw(int i) {
        return EH.addAndGet(i);
    }

    public static synchronized void a(ao aoVar) {
        synchronized (an.class) {
            if (aoVar != null) {
                if (EG.size() <= 20) {
                    EG.add(aoVar);
                }
            }
        }
    }

    public static synchronized ao mv() {
        ao remove;
        synchronized (an.class) {
            int size = EG.size();
            remove = size > 0 ? EG.remove(size - 1) : null;
        }
        return remove;
    }
}
