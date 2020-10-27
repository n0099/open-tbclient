package com.baidu.live.liveroom.c;
/* loaded from: classes4.dex */
public class d {
    private static volatile d blU;
    private c blV;
    private b blW;

    private d() {
    }

    public static d MY() {
        if (blU == null) {
            synchronized (d.class) {
                if (blU == null) {
                    blU = new d();
                }
            }
        }
        return blU;
    }

    private b MZ() {
        if (this.blV != null) {
            return this.blV.MX();
        }
        return null;
    }

    public boolean MW() {
        if (this.blW == null) {
            this.blW = MZ();
        }
        if (this.blW == null) {
            return false;
        }
        return this.blW.MW();
    }

    public b Na() {
        if (this.blW != null) {
            return this.blW;
        }
        this.blW = MZ();
        return this.blW;
    }
}
