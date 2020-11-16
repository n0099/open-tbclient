package com.baidu.live.liveroom.c;
/* loaded from: classes4.dex */
public class d {
    private static volatile d blD;
    private c blE;
    private b blF;

    private d() {
    }

    public static d MP() {
        if (blD == null) {
            synchronized (d.class) {
                if (blD == null) {
                    blD = new d();
                }
            }
        }
        return blD;
    }

    private b MQ() {
        if (this.blE != null) {
            return this.blE.MO();
        }
        return null;
    }

    public boolean MN() {
        if (this.blF == null) {
            this.blF = MQ();
        }
        if (this.blF == null) {
            return false;
        }
        return this.blF.MN();
    }

    public b MR() {
        if (this.blF != null) {
            return this.blF;
        }
        this.blF = MQ();
        return this.blF;
    }
}
