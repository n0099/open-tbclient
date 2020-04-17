package com.baidu.live.liveroom.c;
/* loaded from: classes3.dex */
public class d {
    private static volatile d aPD;
    private c aPE;
    private b aPF;

    private d() {
    }

    public static d Dq() {
        if (aPD == null) {
            synchronized (d.class) {
                if (aPD == null) {
                    aPD = new d();
                }
            }
        }
        return aPD;
    }

    private b Dr() {
        if (this.aPE != null) {
            return this.aPE.Dp();
        }
        return null;
    }

    public boolean Do() {
        if (this.aPF == null) {
            this.aPF = Dr();
        }
        if (this.aPF == null) {
            return false;
        }
        return this.aPF.Do();
    }

    public b Ds() {
        if (this.aPF != null) {
            return this.aPF;
        }
        this.aPF = Dr();
        return this.aPF;
    }
}
