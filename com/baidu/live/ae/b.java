package com.baidu.live.ae;
/* loaded from: classes11.dex */
public class b {
    private static b bAY;
    private boolean bAZ = true;

    public static b Qv() {
        if (bAY == null) {
            synchronized (b.class) {
                if (bAY == null) {
                    bAY = new b();
                }
            }
        }
        return bAY;
    }

    public boolean Qw() {
        return this.bAZ;
    }

    public void cU(boolean z) {
        this.bAZ = z;
    }
}
