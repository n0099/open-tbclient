package com.baidu.swan.game.ad.b;

import com.baidu.swan.apps.ao.ah;
/* loaded from: classes14.dex */
public class b {
    private int aba;
    private String dWJ;
    private String dWK;
    private String dWL;
    private int dWM;
    private int dWN;

    private b(a aVar) {
        this.dWK = aVar.dWK;
        this.dWJ = aVar.dWJ;
        this.dWM = aVar.dWM;
        this.dWN = aVar.dWN;
        this.dWL = aVar.dWL;
        this.aba = aVar.aba;
    }

    public int aRP() {
        return this.dWM;
    }

    public int aRQ() {
        return this.dWN;
    }

    public String getAppSid() {
        return this.dWK;
    }

    public String aRR() {
        return this.dWJ;
    }

    public String aRS() {
        return this.dWL;
    }

    public int rw() {
        return this.aba;
    }

    /* loaded from: classes14.dex */
    public static class a {
        private int aba;
        private String dWJ;
        private String dWK;
        private String dWL;
        private int dWM;
        private int dWN;

        public a uY(String str) {
            this.dWK = str;
            return this;
        }

        public a uZ(String str) {
            this.dWJ = str;
            return this;
        }

        public a va(String str) {
            this.dWL = str;
            return this;
        }

        public a kL(int i) {
            this.dWM = ah.O(i);
            return this;
        }

        public a kM(int i) {
            this.dWN = ah.O(i);
            return this;
        }

        public a kN(int i) {
            this.aba = i;
            return this;
        }

        public b aRT() {
            return new b(this);
        }
    }
}
