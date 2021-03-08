package com.baidu.live.ae;
/* loaded from: classes10.dex */
public class b {
    private static b bCy;
    private boolean bCz = true;

    public static b Qy() {
        if (bCy == null) {
            synchronized (b.class) {
                if (bCy == null) {
                    bCy = new b();
                }
            }
        }
        return bCy;
    }

    public boolean Qz() {
        return this.bCz;
    }

    public void cU(boolean z) {
        this.bCz = z;
    }
}
