package com.baidu.ar.vo.a;
/* loaded from: classes11.dex */
public class b {
    private String id;
    private int xo;
    private String xp;
    private int xr;
    private String xs;
    private int xq = 1000;
    private boolean xt = true;

    public void O(int i) {
        this.xo = i;
    }

    public void P(int i) {
        this.xq = i;
    }

    public void Q(int i) {
        this.xr = i;
    }

    public void X(boolean z) {
        this.xt = z;
    }

    public void aQ(String str) {
        this.xp = str;
    }

    public void aR(String str) {
        this.xs = str;
    }

    public int fO() {
        return this.xo;
    }

    public String fP() {
        return this.xp;
    }

    public int fQ() {
        return this.xq;
    }

    public int fR() {
        return this.xr;
    }

    public boolean fS() {
        return this.xt;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String str) {
        this.id = str;
    }

    public String toString() {
        return "SlamModel{id='" + this.id + "', placeType=" + this.xo + ", position='" + this.xp + "', distance=" + this.xq + ", pitchAngle=" + this.xr + ", rotation='" + this.xs + "', mImmediatelyPlaceModel=" + this.xt + '}';
    }
}
