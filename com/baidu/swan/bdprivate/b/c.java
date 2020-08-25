package com.baidu.swan.bdprivate.b;
/* loaded from: classes14.dex */
public class c {
    private static volatile b dfs;

    public static synchronized b aGu() {
        b bVar;
        synchronized (c.class) {
            if (dfs == null) {
                dfs = new b();
            }
            bVar = dfs;
        }
        return bVar;
    }
}
