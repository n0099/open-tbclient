package com.baidu.live.liveroom.c;
/* loaded from: classes3.dex */
public class d {
    private static volatile d awa;
    private c awb;
    private b awc;

    private d() {
    }

    public static d yw() {
        if (awa == null) {
            synchronized (d.class) {
                if (awa == null) {
                    awa = new d();
                }
            }
        }
        return awa;
    }

    private b yx() {
        if (this.awb != null) {
            return this.awb.yv();
        }
        return null;
    }

    public boolean yu() {
        if (this.awc == null) {
            this.awc = yx();
        }
        if (this.awc == null) {
            return false;
        }
        return this.awc.yu();
    }

    public b yy() {
        if (this.awc != null) {
            return this.awc;
        }
        this.awc = yx();
        return this.awc;
    }
}
