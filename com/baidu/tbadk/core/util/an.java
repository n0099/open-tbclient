package com.baidu.tbadk.core.util;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class an {
    private static ArrayList<ao> EH = new ArrayList<>();
    public static AtomicInteger EI = new AtomicInteger(0);

    public static int bv(int i) {
        return EI.getAndSet(i);
    }

    public static int bw(int i) {
        return EI.addAndGet(i);
    }

    public static synchronized void a(ao aoVar) {
        synchronized (an.class) {
            if (aoVar != null) {
                if (EH.size() <= 20) {
                    EH.add(aoVar);
                }
            }
        }
    }

    public static synchronized ao mv() {
        ao remove;
        synchronized (an.class) {
            int size = EH.size();
            remove = size > 0 ? EH.remove(size - 1) : null;
        }
        return remove;
    }
}
