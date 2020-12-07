package com.baidu.swan.apps.core.g.a;

import android.util.Log;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes25.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static AtomicInteger cRB = new AtomicInteger(0);

    public static String next() {
        if (!com.baidu.swan.apps.core.prefetch.a.a.isOn()) {
            return "master";
        }
        int andIncrement = cRB.getAndIncrement();
        String str = "master";
        if (andIncrement >= 1) {
            str = "master" + andIncrement;
        }
        if (DEBUG) {
            Log.i("MasterIdGenerator", "next master id - " + str);
            return str;
        }
        return str;
    }

    public static int asv() {
        int andSet = cRB.getAndSet(0);
        if (DEBUG) {
            Log.i("MasterIdGenerator", "last master id - " + andSet);
        }
        return andSet;
    }

    public static boolean nJ(String str) {
        return str != null && str.startsWith("master");
    }
}
