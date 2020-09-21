package com.baidu.live.liveroom.c;
/* loaded from: classes4.dex */
public class d {
    private static volatile d bgJ;
    private c bgK;
    private b bgL;

    private d() {
    }

    public static d LA() {
        if (bgJ == null) {
            synchronized (d.class) {
                if (bgJ == null) {
                    bgJ = new d();
                }
            }
        }
        return bgJ;
    }

    private b LB() {
        if (this.bgK != null) {
            return this.bgK.Lz();
        }
        return null;
    }

    public boolean Ly() {
        if (this.bgL == null) {
            this.bgL = LB();
        }
        if (this.bgL == null) {
            return false;
        }
        return this.bgL.Ly();
    }

    public b LC() {
        if (this.bgL != null) {
            return this.bgL;
        }
        this.bgL = LB();
        return this.bgL;
    }
}
