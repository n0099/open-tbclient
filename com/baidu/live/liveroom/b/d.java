package com.baidu.live.liveroom.b;
/* loaded from: classes2.dex */
public class d {
    private static volatile d arg;
    private c arh;
    private b ari;

    private d() {
    }

    public static d vZ() {
        if (arg == null) {
            synchronized (d.class) {
                if (arg == null) {
                    arg = new d();
                }
            }
        }
        return arg;
    }

    private b wa() {
        if (this.arh != null) {
            return this.arh.vY();
        }
        return null;
    }

    public boolean vX() {
        if (this.ari == null) {
            this.ari = wa();
        }
        if (this.ari == null) {
            return false;
        }
        return this.ari.vX();
    }

    public b wb() {
        if (this.ari != null) {
            return this.ari;
        }
        this.ari = wa();
        return this.ari;
    }
}
