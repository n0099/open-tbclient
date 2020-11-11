package com.baidu.swan.game.ad.b;

import com.baidu.swan.apps.ap.ah;
/* loaded from: classes14.dex */
public class b {
    private int Zs;
    private String dNj;
    private String dNk;
    private String dNl;
    private int dNm;
    private int dNn;

    private b(a aVar) {
        this.dNk = aVar.dNk;
        this.dNj = aVar.dNj;
        this.dNm = aVar.dNm;
        this.dNn = aVar.dNn;
        this.dNl = aVar.dNl;
        this.Zs = aVar.Zs;
    }

    public int aQR() {
        return this.dNm;
    }

    public int aQS() {
        return this.dNn;
    }

    public String getAppSid() {
        return this.dNk;
    }

    public String aQT() {
        return this.dNj;
    }

    public String aQU() {
        return this.dNl;
    }

    public int rT() {
        return this.Zs;
    }

    /* loaded from: classes14.dex */
    public static class a {
        private int Zs;
        private String dNj;
        private String dNk;
        private String dNl;
        private int dNm;
        private int dNn;

        public a vI(String str) {
            this.dNk = str;
            return this;
        }

        public a vJ(String str) {
            this.dNj = str;
            return this;
        }

        public a vK(String str) {
            this.dNl = str;
            return this;
        }

        public a lP(int i) {
            this.dNm = ah.N(i);
            return this;
        }

        public a lQ(int i) {
            this.dNn = ah.N(i);
            return this;
        }

        public a lR(int i) {
            this.Zs = i;
            return this;
        }

        public b aQV() {
            return new b(this);
        }
    }
}
