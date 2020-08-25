package com.baidu.live.liveroom.c;
/* loaded from: classes7.dex */
public class d {
    private static volatile d bdQ;
    private c bdR;
    private b bdS;

    private d() {
    }

    public static d KX() {
        if (bdQ == null) {
            synchronized (d.class) {
                if (bdQ == null) {
                    bdQ = new d();
                }
            }
        }
        return bdQ;
    }

    private b KY() {
        if (this.bdR != null) {
            return this.bdR.KW();
        }
        return null;
    }

    public boolean KV() {
        if (this.bdS == null) {
            this.bdS = KY();
        }
        if (this.bdS == null) {
            return false;
        }
        return this.bdS.KV();
    }

    public b KZ() {
        if (this.bdS != null) {
            return this.bdS;
        }
        this.bdS = KY();
        return this.bdS;
    }
}
