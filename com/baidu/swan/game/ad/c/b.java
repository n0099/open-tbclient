package com.baidu.swan.game.ad.c;

import com.baidu.swan.apps.as.af;
/* loaded from: classes11.dex */
public class b {
    private String chD;
    private String chE;
    private String chF;
    private int chG;
    private int chH;

    private b(a aVar) {
        this.chE = aVar.chE;
        this.chD = aVar.chD;
        this.chG = aVar.chG;
        this.chH = aVar.chH;
        this.chF = aVar.chF;
    }

    public int akt() {
        return this.chG;
    }

    public int aku() {
        return this.chH;
    }

    public String getAppSid() {
        return this.chE;
    }

    public String akv() {
        return this.chD;
    }

    public String akw() {
        return this.chF;
    }

    /* loaded from: classes11.dex */
    public static class a {
        private String chD;
        private String chE;
        private String chF;
        private int chG;
        private int chH;

        public a nO(String str) {
            this.chE = str;
            return this;
        }

        public a nP(String str) {
            this.chD = str;
            return this;
        }

        public a nQ(String str) {
            this.chF = str;
            return this;
        }

        public a hE(int i) {
            this.chG = af.S(i);
            return this;
        }

        public a hF(int i) {
            this.chH = af.S(i);
            return this;
        }

        public b akx() {
            return new b(this);
        }
    }
}
