package com.baidu.live.liveroom.c;
/* loaded from: classes7.dex */
public class d {
    private static volatile d bdS;
    private c bdT;
    private b bdU;

    private d() {
    }

    public static d KX() {
        if (bdS == null) {
            synchronized (d.class) {
                if (bdS == null) {
                    bdS = new d();
                }
            }
        }
        return bdS;
    }

    private b KY() {
        if (this.bdT != null) {
            return this.bdT.KW();
        }
        return null;
    }

    public boolean KV() {
        if (this.bdU == null) {
            this.bdU = KY();
        }
        if (this.bdU == null) {
            return false;
        }
        return this.bdU.KV();
    }

    public b KZ() {
        if (this.bdU != null) {
            return this.bdU;
        }
        this.bdU = KY();
        return this.bdU;
    }
}
