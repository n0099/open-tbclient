package com.baidu.live;
/* loaded from: classes3.dex */
public class b {
    private static volatile b ast;
    private boolean asu;

    private b() {
    }

    public static b uM() {
        if (ast == null) {
            synchronized (c.class) {
                if (ast == null) {
                    ast = new b();
                }
            }
        }
        return ast;
    }

    public void aL(boolean z) {
        this.asu = z;
    }
}
