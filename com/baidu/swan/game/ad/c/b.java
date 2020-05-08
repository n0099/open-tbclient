package com.baidu.swan.game.ad.c;

import com.baidu.swan.apps.as.af;
/* loaded from: classes11.dex */
public class b {
    private String cGS;
    private String cGT;
    private String cGU;
    private int cGV;
    private int cGW;

    private b(a aVar) {
        this.cGT = aVar.cGT;
        this.cGS = aVar.cGS;
        this.cGV = aVar.cGV;
        this.cGW = aVar.cGW;
        this.cGU = aVar.cGU;
    }

    public int asJ() {
        return this.cGV;
    }

    public int asK() {
        return this.cGW;
    }

    public String getAppSid() {
        return this.cGT;
    }

    public String asL() {
        return this.cGS;
    }

    public String asM() {
        return this.cGU;
    }

    /* loaded from: classes11.dex */
    public static class a {
        private String cGS;
        private String cGT;
        private String cGU;
        private int cGV;
        private int cGW;

        public a pc(String str) {
            this.cGT = str;
            return this;
        }

        public a pd(String str) {
            this.cGS = str;
            return this;
        }

        public a pe(String str) {
            this.cGU = str;
            return this;
        }

        public a hL(int i) {
            this.cGV = af.C(i);
            return this;
        }

        public a hM(int i) {
            this.cGW = af.C(i);
            return this;
        }

        public b asN() {
            return new b(this);
        }
    }
}
