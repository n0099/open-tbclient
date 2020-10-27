package com.baidu.swan.game.ad.b;

import com.baidu.swan.apps.ap.ah;
/* loaded from: classes14.dex */
public class b {
    private int Zs;
    private String dHr;
    private String dHs;
    private String dHt;
    private int dHu;
    private int dHv;

    private b(a aVar) {
        this.dHs = aVar.dHs;
        this.dHr = aVar.dHr;
        this.dHu = aVar.dHu;
        this.dHv = aVar.dHv;
        this.dHt = aVar.dHt;
        this.Zs = aVar.Zs;
    }

    public int aOr() {
        return this.dHu;
    }

    public int aOs() {
        return this.dHv;
    }

    public String getAppSid() {
        return this.dHs;
    }

    public String aOt() {
        return this.dHr;
    }

    public String aOu() {
        return this.dHt;
    }

    public int rT() {
        return this.Zs;
    }

    /* loaded from: classes14.dex */
    public static class a {
        private int Zs;
        private String dHr;
        private String dHs;
        private String dHt;
        private int dHu;
        private int dHv;

        public a vu(String str) {
            this.dHs = str;
            return this;
        }

        public a vv(String str) {
            this.dHr = str;
            return this;
        }

        public a vw(String str) {
            this.dHt = str;
            return this;
        }

        public a lF(int i) {
            this.dHu = ah.L(i);
            return this;
        }

        public a lG(int i) {
            this.dHv = ah.L(i);
            return this;
        }

        public a lH(int i) {
            this.Zs = i;
            return this;
        }

        public b aOv() {
            return new b(this);
        }
    }
}
