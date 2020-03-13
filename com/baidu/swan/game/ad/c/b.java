package com.baidu.swan.game.ad.c;

import com.baidu.swan.apps.as.af;
/* loaded from: classes11.dex */
public class b {
    private String chF;
    private String chG;
    private String chH;
    private int chI;
    private int chJ;

    private b(a aVar) {
        this.chG = aVar.chG;
        this.chF = aVar.chF;
        this.chI = aVar.chI;
        this.chJ = aVar.chJ;
        this.chH = aVar.chH;
    }

    public int akv() {
        return this.chI;
    }

    public int akw() {
        return this.chJ;
    }

    public String getAppSid() {
        return this.chG;
    }

    public String akx() {
        return this.chF;
    }

    public String aky() {
        return this.chH;
    }

    /* loaded from: classes11.dex */
    public static class a {
        private String chF;
        private String chG;
        private String chH;
        private int chI;
        private int chJ;

        public a nO(String str) {
            this.chG = str;
            return this;
        }

        public a nP(String str) {
            this.chF = str;
            return this;
        }

        public a nQ(String str) {
            this.chH = str;
            return this;
        }

        public a hE(int i) {
            this.chI = af.S(i);
            return this;
        }

        public a hF(int i) {
            this.chJ = af.S(i);
            return this;
        }

        public b akz() {
            return new b(this);
        }
    }
}
