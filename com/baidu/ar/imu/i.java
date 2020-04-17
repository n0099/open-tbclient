package com.baidu.ar.imu;
/* loaded from: classes3.dex */
public class i {
    private b qW = b.WORLD;
    private int qX = 0;
    private boolean qY = false;
    private boolean qZ = false;
    private boolean ra = false;
    private boolean rb = false;

    public void D(int i) {
        this.qX = i;
    }

    public void H(boolean z) {
        this.qY = z;
    }

    public void I(boolean z) {
        this.ra = z;
    }

    public void b(b bVar) {
        this.qW = bVar;
    }

    public boolean dA() {
        return this.qZ;
    }

    public boolean dB() {
        return this.ra;
    }

    public boolean dC() {
        return this.rb;
    }

    public b dx() {
        return this.qW;
    }

    public int dy() {
        return this.qX;
    }

    public boolean dz() {
        return this.qY;
    }
}
