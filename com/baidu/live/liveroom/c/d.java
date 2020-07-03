package com.baidu.live.liveroom.c;
/* loaded from: classes3.dex */
public class d {
    private static volatile d aYB;
    private c aYC;
    private b aYD;

    private d() {
    }

    public static d Fw() {
        if (aYB == null) {
            synchronized (d.class) {
                if (aYB == null) {
                    aYB = new d();
                }
            }
        }
        return aYB;
    }

    private b Fx() {
        if (this.aYC != null) {
            return this.aYC.Fv();
        }
        return null;
    }

    public boolean Fu() {
        if (this.aYD == null) {
            this.aYD = Fx();
        }
        if (this.aYD == null) {
            return false;
        }
        return this.aYD.Fu();
    }

    public b Fy() {
        if (this.aYD != null) {
            return this.aYD;
        }
        this.aYD = Fx();
        return this.aYD;
    }
}
