package com.baidu.swan.game.ad.b;

import com.baidu.swan.apps.ap.ah;
/* loaded from: classes14.dex */
public class b {
    private int aat;
    private String dSA;
    private int dSB;
    private int dSC;
    private String dSy;
    private String dSz;

    private b(a aVar) {
        this.dSz = aVar.dSz;
        this.dSy = aVar.dSy;
        this.dSB = aVar.dSB;
        this.dSC = aVar.dSC;
        this.dSA = aVar.dSA;
        this.aat = aVar.aat;
    }

    public int aTo() {
        return this.dSB;
    }

    public int aTp() {
        return this.dSC;
    }

    public String getAppSid() {
        return this.dSz;
    }

    public String aTq() {
        return this.dSy;
    }

    public String aTr() {
        return this.dSA;
    }

    public int rV() {
        return this.aat;
    }

    /* loaded from: classes14.dex */
    public static class a {
        private int aat;
        private String dSA;
        private int dSB;
        private int dSC;
        private String dSy;
        private String dSz;

        public a wk(String str) {
            this.dSz = str;
            return this;
        }

        public a wl(String str) {
            this.dSy = str;
            return this;
        }

        public a wm(String str) {
            this.dSA = str;
            return this;
        }

        public a mj(int i) {
            this.dSB = ah.M(i);
            return this;
        }

        public a mk(int i) {
            this.dSC = ah.M(i);
            return this;
        }

        public a ml(int i) {
            this.aat = i;
            return this;
        }

        public b aTs() {
            return new b(this);
        }
    }
}
