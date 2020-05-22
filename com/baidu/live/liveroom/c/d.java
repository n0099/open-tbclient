package com.baidu.live.liveroom.c;
/* loaded from: classes3.dex */
public class d {
    private static volatile d aVS;
    private c aVT;
    private b aVU;

    private d() {
    }

    public static d EN() {
        if (aVS == null) {
            synchronized (d.class) {
                if (aVS == null) {
                    aVS = new d();
                }
            }
        }
        return aVS;
    }

    private b EO() {
        if (this.aVT != null) {
            return this.aVT.EM();
        }
        return null;
    }

    public boolean EL() {
        if (this.aVU == null) {
            this.aVU = EO();
        }
        if (this.aVU == null) {
            return false;
        }
        return this.aVU.EL();
    }

    public b EP() {
        if (this.aVU != null) {
            return this.aVU;
        }
        this.aVU = EO();
        return this.aVU;
    }
}
