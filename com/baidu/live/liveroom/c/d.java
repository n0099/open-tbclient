package com.baidu.live.liveroom.c;
/* loaded from: classes4.dex */
public class d {
    private static volatile d bqK;
    private c bqL;
    private b bqM;

    private d() {
    }

    public static d Ph() {
        if (bqK == null) {
            synchronized (d.class) {
                if (bqK == null) {
                    bqK = new d();
                }
            }
        }
        return bqK;
    }

    private b Pi() {
        if (this.bqL != null) {
            return this.bqL.Pg();
        }
        return null;
    }

    public boolean Pf() {
        if (this.bqM == null) {
            this.bqM = Pi();
        }
        if (this.bqM == null) {
            return false;
        }
        return this.bqM.Pf();
    }

    public b Pj() {
        if (this.bqM != null) {
            return this.bqM;
        }
        this.bqM = Pi();
        return this.bqM;
    }
}
