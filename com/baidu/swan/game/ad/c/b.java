package com.baidu.swan.game.ad.c;

import com.baidu.swan.apps.as.af;
/* loaded from: classes11.dex */
public class b {
    private String cGM;
    private String cGN;
    private String cGO;
    private int cGP;
    private int cGQ;

    private b(a aVar) {
        this.cGN = aVar.cGN;
        this.cGM = aVar.cGM;
        this.cGP = aVar.cGP;
        this.cGQ = aVar.cGQ;
        this.cGO = aVar.cGO;
    }

    public int asK() {
        return this.cGP;
    }

    public int asL() {
        return this.cGQ;
    }

    public String getAppSid() {
        return this.cGN;
    }

    public String asM() {
        return this.cGM;
    }

    public String asN() {
        return this.cGO;
    }

    /* loaded from: classes11.dex */
    public static class a {
        private String cGM;
        private String cGN;
        private String cGO;
        private int cGP;
        private int cGQ;

        public a pc(String str) {
            this.cGN = str;
            return this;
        }

        public a pd(String str) {
            this.cGM = str;
            return this;
        }

        public a pe(String str) {
            this.cGO = str;
            return this;
        }

        public a hL(int i) {
            this.cGP = af.C(i);
            return this;
        }

        public a hM(int i) {
            this.cGQ = af.C(i);
            return this;
        }

        public b asO() {
            return new b(this);
        }
    }
}
