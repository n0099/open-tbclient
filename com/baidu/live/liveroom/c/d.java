package com.baidu.live.liveroom.c;
/* loaded from: classes3.dex */
public class d {
    private static volatile d avP;
    private c avQ;
    private b avR;

    private d() {
    }

    public static d yr() {
        if (avP == null) {
            synchronized (d.class) {
                if (avP == null) {
                    avP = new d();
                }
            }
        }
        return avP;
    }

    private b ys() {
        if (this.avQ != null) {
            return this.avQ.yq();
        }
        return null;
    }

    public boolean yp() {
        if (this.avR == null) {
            this.avR = ys();
        }
        if (this.avR == null) {
            return false;
        }
        return this.avR.yp();
    }

    public b yt() {
        if (this.avR != null) {
            return this.avR;
        }
        this.avR = ys();
        return this.avR;
    }
}
