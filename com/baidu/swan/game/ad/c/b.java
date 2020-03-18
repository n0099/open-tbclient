package com.baidu.swan.game.ad.c;

import com.baidu.swan.apps.as.af;
/* loaded from: classes11.dex */
public class b {
    private String chQ;
    private String chR;
    private String chS;
    private int chT;
    private int chU;

    private b(a aVar) {
        this.chR = aVar.chR;
        this.chQ = aVar.chQ;
        this.chT = aVar.chT;
        this.chU = aVar.chU;
        this.chS = aVar.chS;
    }

    public int aky() {
        return this.chT;
    }

    public int akz() {
        return this.chU;
    }

    public String getAppSid() {
        return this.chR;
    }

    public String akA() {
        return this.chQ;
    }

    public String akB() {
        return this.chS;
    }

    /* loaded from: classes11.dex */
    public static class a {
        private String chQ;
        private String chR;
        private String chS;
        private int chT;
        private int chU;

        public a nN(String str) {
            this.chR = str;
            return this;
        }

        public a nO(String str) {
            this.chQ = str;
            return this;
        }

        public a nP(String str) {
            this.chS = str;
            return this;
        }

        public a hE(int i) {
            this.chT = af.S(i);
            return this;
        }

        public a hF(int i) {
            this.chU = af.S(i);
            return this;
        }

        public b akC() {
            return new b(this);
        }
    }
}
