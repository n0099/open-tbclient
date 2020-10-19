package com.baidu.live.liveroom.c;
/* loaded from: classes4.dex */
public class d {
    private static volatile d bkz;
    private c bkA;
    private b bkB;

    private d() {
    }

    public static d ME() {
        if (bkz == null) {
            synchronized (d.class) {
                if (bkz == null) {
                    bkz = new d();
                }
            }
        }
        return bkz;
    }

    private b MF() {
        if (this.bkA != null) {
            return this.bkA.MD();
        }
        return null;
    }

    public boolean MC() {
        if (this.bkB == null) {
            this.bkB = MF();
        }
        if (this.bkB == null) {
            return false;
        }
        return this.bkB.MC();
    }

    public b MG() {
        if (this.bkB != null) {
            return this.bkB;
        }
        this.bkB = MF();
        return this.bkB;
    }
}
