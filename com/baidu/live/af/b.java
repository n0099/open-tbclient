package com.baidu.live.af;
/* loaded from: classes10.dex */
public class b {
    private static b bxv;
    private boolean bxw = true;

    public static b OU() {
        if (bxv == null) {
            synchronized (b.class) {
                if (bxv == null) {
                    bxv = new b();
                }
            }
        }
        return bxv;
    }

    public boolean OV() {
        return this.bxw;
    }

    public void cL(boolean z) {
        this.bxw = z;
    }
}
