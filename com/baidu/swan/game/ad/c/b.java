package com.baidu.swan.game.ad.c;

import com.baidu.swan.apps.as.af;
/* loaded from: classes11.dex */
public class b {
    private String chE;
    private String chF;
    private String chG;
    private int chH;
    private int chI;

    private b(a aVar) {
        this.chF = aVar.chF;
        this.chE = aVar.chE;
        this.chH = aVar.chH;
        this.chI = aVar.chI;
        this.chG = aVar.chG;
    }

    public int akv() {
        return this.chH;
    }

    public int akw() {
        return this.chI;
    }

    public String getAppSid() {
        return this.chF;
    }

    public String akx() {
        return this.chE;
    }

    public String aky() {
        return this.chG;
    }

    /* loaded from: classes11.dex */
    public static class a {
        private String chE;
        private String chF;
        private String chG;
        private int chH;
        private int chI;

        public a nO(String str) {
            this.chF = str;
            return this;
        }

        public a nP(String str) {
            this.chE = str;
            return this;
        }

        public a nQ(String str) {
            this.chG = str;
            return this;
        }

        public a hE(int i) {
            this.chH = af.S(i);
            return this;
        }

        public a hF(int i) {
            this.chI = af.S(i);
            return this;
        }

        public b akz() {
            return new b(this);
        }
    }
}
