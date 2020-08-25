package com.baidu.swan.game.ad.b;

import com.baidu.swan.apps.ap.ah;
/* loaded from: classes19.dex */
public class b {
    private int YG;
    private String dkI;
    private String dkJ;
    private String dkK;
    private int dkL;
    private int dkM;

    private b(a aVar) {
        this.dkJ = aVar.dkJ;
        this.dkI = aVar.dkI;
        this.dkL = aVar.dkL;
        this.dkM = aVar.dkM;
        this.dkK = aVar.dkK;
        this.YG = aVar.YG;
    }

    public int aJd() {
        return this.dkL;
    }

    public int aJe() {
        return this.dkM;
    }

    public String getAppSid() {
        return this.dkJ;
    }

    public String aJf() {
        return this.dkI;
    }

    public String aJg() {
        return this.dkK;
    }

    public int rO() {
        return this.YG;
    }

    /* loaded from: classes19.dex */
    public static class a {
        private int YG;
        private String dkI;
        private String dkJ;
        private String dkK;
        private int dkL;
        private int dkM;

        public a tV(String str) {
            this.dkJ = str;
            return this;
        }

        public a tW(String str) {
            this.dkI = str;
            return this;
        }

        public a tX(String str) {
            this.dkK = str;
            return this;
        }

        public a kM(int i) {
            this.dkL = ah.H(i);
            return this;
        }

        public a kN(int i) {
            this.dkM = ah.H(i);
            return this;
        }

        public a kO(int i) {
            this.YG = i;
            return this;
        }

        public b aJh() {
            return new b(this);
        }
    }
}
