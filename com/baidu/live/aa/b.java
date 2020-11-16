package com.baidu.live.aa;
/* loaded from: classes4.dex */
public class b {
    private static b bsn;
    private boolean bso = true;

    public static b Pr() {
        if (bsn == null) {
            synchronized (b.class) {
                if (bsn == null) {
                    bsn = new b();
                }
            }
        }
        return bsn;
    }

    public boolean Ps() {
        return this.bso;
    }

    public void cy(boolean z) {
        this.bso = z;
    }
}
