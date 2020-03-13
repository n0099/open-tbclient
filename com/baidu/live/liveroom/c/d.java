package com.baidu.live.liveroom.c;
/* loaded from: classes3.dex */
public class d {
    private static volatile d avQ;
    private c avR;
    private b avS;

    private d() {
    }

    public static d yr() {
        if (avQ == null) {
            synchronized (d.class) {
                if (avQ == null) {
                    avQ = new d();
                }
            }
        }
        return avQ;
    }

    private b ys() {
        if (this.avR != null) {
            return this.avR.yq();
        }
        return null;
    }

    public boolean yp() {
        if (this.avS == null) {
            this.avS = ys();
        }
        if (this.avS == null) {
            return false;
        }
        return this.avS.yp();
    }

    public b yt() {
        if (this.avS != null) {
            return this.avS;
        }
        this.avS = ys();
        return this.avS;
    }
}
