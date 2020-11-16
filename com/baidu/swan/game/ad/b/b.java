package com.baidu.swan.game.ad.b;

import com.baidu.swan.apps.ap.ah;
/* loaded from: classes12.dex */
public class b {
    private int Zx;
    private String dLB;
    private String dLC;
    private String dLD;
    private int dLE;
    private int dLF;

    private b(a aVar) {
        this.dLC = aVar.dLC;
        this.dLB = aVar.dLB;
        this.dLE = aVar.dLE;
        this.dLF = aVar.dLF;
        this.dLD = aVar.dLD;
        this.Zx = aVar.Zx;
    }

    public int aQj() {
        return this.dLE;
    }

    public int aQk() {
        return this.dLF;
    }

    public String getAppSid() {
        return this.dLC;
    }

    public String aQl() {
        return this.dLB;
    }

    public String aQm() {
        return this.dLD;
    }

    public int rT() {
        return this.Zx;
    }

    /* loaded from: classes12.dex */
    public static class a {
        private int Zx;
        private String dLB;
        private String dLC;
        private String dLD;
        private int dLE;
        private int dLF;

        public a vD(String str) {
            this.dLC = str;
            return this;
        }

        public a vE(String str) {
            this.dLB = str;
            return this;
        }

        public a vF(String str) {
            this.dLD = str;
            return this;
        }

        public a lL(int i) {
            this.dLE = ah.M(i);
            return this;
        }

        public a lM(int i) {
            this.dLF = ah.M(i);
            return this;
        }

        public a lN(int i) {
            this.Zx = i;
            return this;
        }

        public b aQn() {
            return new b(this);
        }
    }
}
