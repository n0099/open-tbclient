package com.baidu.swan.game.ad.b;

import com.baidu.swan.apps.ap.ah;
/* loaded from: classes14.dex */
public class b {
    private int Zr;
    private String dyU;
    private String dyV;
    private String dyW;
    private int dyX;
    private int dyY;

    private b(a aVar) {
        this.dyV = aVar.dyV;
        this.dyU = aVar.dyU;
        this.dyX = aVar.dyX;
        this.dyY = aVar.dyY;
        this.dyW = aVar.dyW;
        this.Zr = aVar.Zr;
    }

    public int aMx() {
        return this.dyX;
    }

    public int aMy() {
        return this.dyY;
    }

    public String getAppSid() {
        return this.dyV;
    }

    public String aMz() {
        return this.dyU;
    }

    public String aMA() {
        return this.dyW;
    }

    public int rT() {
        return this.Zr;
    }

    /* loaded from: classes14.dex */
    public static class a {
        private int Zr;
        private String dyU;
        private String dyV;
        private String dyW;
        private int dyX;
        private int dyY;

        public a vb(String str) {
            this.dyV = str;
            return this;
        }

        public a vc(String str) {
            this.dyU = str;
            return this;
        }

        public a vd(String str) {
            this.dyW = str;
            return this;
        }

        public a lu(int i) {
            this.dyX = ah.J(i);
            return this;
        }

        public a lv(int i) {
            this.dyY = ah.J(i);
            return this;
        }

        public a lw(int i) {
            this.Zr = i;
            return this;
        }

        public b aMB() {
            return new b(this);
        }
    }
}
