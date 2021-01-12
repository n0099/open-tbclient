package com.baidu.live.liveroom.c;
/* loaded from: classes10.dex */
public class d {
    private static volatile d bnS;
    private c bnT;
    private b bnU;

    private d() {
    }

    public static d La() {
        if (bnS == null) {
            synchronized (d.class) {
                if (bnS == null) {
                    bnS = new d();
                }
            }
        }
        return bnS;
    }

    private b Lb() {
        if (this.bnT != null) {
            return this.bnT.KZ();
        }
        return null;
    }

    public boolean KY() {
        if (this.bnU == null) {
            this.bnU = Lb();
        }
        if (this.bnU == null) {
            return false;
        }
        return this.bnU.KY();
    }

    public b Lc() {
        if (this.bnU != null) {
            return this.bnU;
        }
        this.bnU = Lb();
        return this.bnU;
    }
}
