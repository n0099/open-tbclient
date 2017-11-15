package com.baidu.tbadk.core.util;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class aa {
    private static ArrayList<a> agh = new ArrayList<>();
    public static AtomicInteger agi = new AtomicInteger(0);

    /* loaded from: classes.dex */
    public static class a {
        public int agj;
        public long agk;
        public int agl;
        public int mMode;
        public long mTime;
    }

    public static int cH(int i) {
        return agi.getAndSet(i);
    }

    public static int cI(int i) {
        return agi.addAndGet(i);
    }

    public static synchronized void a(a aVar) {
        synchronized (aa.class) {
            if (aVar != null) {
                if (agh.size() <= 20) {
                    agh.add(aVar);
                }
            }
        }
    }

    public static synchronized a uY() {
        a remove;
        synchronized (aa.class) {
            int size = agh.size();
            remove = size > 0 ? agh.remove(size - 1) : null;
        }
        return remove;
    }
}
