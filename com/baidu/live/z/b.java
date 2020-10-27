package com.baidu.live.z;
/* loaded from: classes4.dex */
public class b {
    private static b bsE;
    private boolean bsF = true;

    public static b Pz() {
        if (bsE == null) {
            synchronized (b.class) {
                if (bsE == null) {
                    bsE = new b();
                }
            }
        }
        return bsE;
    }

    public boolean PA() {
        return this.bsF;
    }

    public void cv(boolean z) {
        this.bsF = z;
    }
}
