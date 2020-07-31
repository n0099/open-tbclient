package com.baidu.ar.imu;
/* loaded from: classes11.dex */
public class i {
    private b rv = b.WORLD;
    private int rw = 0;

    /* renamed from: rx  reason: collision with root package name */
    private boolean f961rx = false;
    private boolean ry = false;
    private boolean rz = false;
    private boolean rA = false;

    public void H(boolean z) {
        this.f961rx = z;
    }

    public void I(boolean z) {
        this.rz = z;
    }

    public void J(int i) {
        this.rw = i;
    }

    public void b(b bVar) {
        this.rv = bVar;
    }

    public b dN() {
        return this.rv;
    }

    public int dO() {
        return this.rw;
    }

    public boolean dP() {
        return this.f961rx;
    }

    public boolean dQ() {
        return this.ry;
    }

    public boolean dR() {
        return this.rz;
    }

    public boolean dS() {
        return this.rA;
    }
}
