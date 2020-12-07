package com.baidu.live.ae;
/* loaded from: classes4.dex */
public class b {
    private static b bxw;
    private boolean bxx = true;

    public static b RL() {
        if (bxw == null) {
            synchronized (b.class) {
                if (bxw == null) {
                    bxw = new b();
                }
            }
        }
        return bxw;
    }

    public boolean RM() {
        return this.bxx;
    }

    public void cM(boolean z) {
        this.bxx = z;
    }
}
