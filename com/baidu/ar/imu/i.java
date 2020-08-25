package com.baidu.ar.imu;
/* loaded from: classes11.dex */
public class i {
    private b rZ = b.WORLD;
    private int sa = 0;
    private boolean sb = false;
    private boolean sc = false;
    private boolean sd = false;
    private boolean se = false;

    public void I(boolean z) {
        this.sb = z;
    }

    public void J(boolean z) {
        this.sd = z;
    }

    public void L(int i) {
        this.sa = i;
    }

    public void b(b bVar) {
        this.rZ = bVar;
    }

    public b eX() {
        return this.rZ;
    }

    public int eY() {
        return this.sa;
    }

    public boolean eZ() {
        return this.sb;
    }

    public boolean fa() {
        return this.sc;
    }

    public boolean fb() {
        return this.sd;
    }

    public boolean fc() {
        return this.se;
    }
}
