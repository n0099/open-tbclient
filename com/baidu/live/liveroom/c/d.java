package com.baidu.live.liveroom.c;
/* loaded from: classes4.dex */
public class d {
    private static volatile d aYz;
    private c aYA;
    private b aYB;

    private d() {
    }

    public static d Fq() {
        if (aYz == null) {
            synchronized (d.class) {
                if (aYz == null) {
                    aYz = new d();
                }
            }
        }
        return aYz;
    }

    private b Fr() {
        if (this.aYA != null) {
            return this.aYA.Fp();
        }
        return null;
    }

    public boolean Fo() {
        if (this.aYB == null) {
            this.aYB = Fr();
        }
        if (this.aYB == null) {
            return false;
        }
        return this.aYB.Fo();
    }

    public b Fs() {
        if (this.aYB != null) {
            return this.aYB;
        }
        this.aYB = Fr();
        return this.aYB;
    }
}
