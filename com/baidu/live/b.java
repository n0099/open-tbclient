package com.baidu.live;
/* loaded from: classes3.dex */
public class b {
    private static volatile b ant;
    private boolean anu;

    private b() {
    }

    public static b tG() {
        if (ant == null) {
            synchronized (c.class) {
                if (ant == null) {
                    ant = new b();
                }
            }
        }
        return ant;
    }

    public void aJ(boolean z) {
        this.anu = z;
    }
}
