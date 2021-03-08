package com.baidu.live.liveroom.c;
/* loaded from: classes10.dex */
public class d {
    private static volatile d bsT;
    private c bsU;
    private b bsV;

    private d() {
    }

    public static d MB() {
        if (bsT == null) {
            synchronized (d.class) {
                if (bsT == null) {
                    bsT = new d();
                }
            }
        }
        return bsT;
    }

    private b MC() {
        if (this.bsU != null) {
            return this.bsU.MA();
        }
        return null;
    }

    public boolean Mz() {
        if (this.bsV == null) {
            this.bsV = MC();
        }
        if (this.bsV == null) {
            return false;
        }
        return this.bsV.Mz();
    }

    public b MD() {
        if (this.bsV != null) {
            return this.bsV;
        }
        this.bsV = MC();
        return this.bsV;
    }
}
