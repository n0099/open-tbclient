package com.baidu.live.af;
/* loaded from: classes11.dex */
public class b {
    private static b bCh;
    private boolean bCi = true;

    public static b SP() {
        if (bCh == null) {
            synchronized (b.class) {
                if (bCh == null) {
                    bCh = new b();
                }
            }
        }
        return bCh;
    }

    public boolean SQ() {
        return this.bCi;
    }

    public void cP(boolean z) {
        this.bCi = z;
    }
}
