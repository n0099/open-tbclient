package com.baidu.live;
/* loaded from: classes4.dex */
public class b {
    private static volatile b azW;
    private boolean azX;

    private b() {
    }

    public static b AY() {
        if (azW == null) {
            synchronized (c.class) {
                if (azW == null) {
                    azW = new b();
                }
            }
        }
        return azW;
    }

    public void aX(boolean z) {
        this.azX = z;
    }
}
