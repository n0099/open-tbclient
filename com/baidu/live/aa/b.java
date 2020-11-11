package com.baidu.live.aa;
/* loaded from: classes4.dex */
public class b {
    private static b btZ;
    private boolean bua = true;

    public static b Qa() {
        if (btZ == null) {
            synchronized (b.class) {
                if (btZ == null) {
                    btZ = new b();
                }
            }
        }
        return btZ;
    }

    public boolean Qb() {
        return this.bua;
    }

    public void cw(boolean z) {
        this.bua = z;
    }
}
