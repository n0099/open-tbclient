package com.baidu.live.liveroom.b;
/* loaded from: classes6.dex */
public class d {
    private static volatile d ajj;
    private c ajk;
    private b ajl;

    private d() {
    }

    public static d ue() {
        if (ajj == null) {
            synchronized (d.class) {
                if (ajj == null) {
                    ajj = new d();
                }
            }
        }
        return ajj;
    }

    private b uf() {
        if (this.ajk != null) {
            return this.ajk.ud();
        }
        return null;
    }

    public boolean uc() {
        if (this.ajl == null) {
            this.ajl = uf();
        }
        if (this.ajl == null) {
            return false;
        }
        return this.ajl.uc();
    }

    public b ug() {
        if (this.ajl != null) {
            return this.ajl;
        }
        this.ajl = uf();
        return this.ajl;
    }
}
