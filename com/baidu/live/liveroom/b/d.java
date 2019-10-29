package com.baidu.live.liveroom.b;
/* loaded from: classes6.dex */
public class d {
    private static volatile d ajB;
    private c ajC;
    private b ajD;

    private d() {
    }

    public static d ud() {
        if (ajB == null) {
            synchronized (d.class) {
                if (ajB == null) {
                    ajB = new d();
                }
            }
        }
        return ajB;
    }

    private b ue() {
        if (this.ajC != null) {
            return this.ajC.uc();
        }
        return null;
    }

    public boolean ub() {
        if (this.ajD == null) {
            this.ajD = ue();
        }
        if (this.ajD == null) {
            return false;
        }
        return this.ajD.ub();
    }

    public b uf() {
        if (this.ajD != null) {
            return this.ajD;
        }
        this.ajD = ue();
        return this.ajD;
    }
}
