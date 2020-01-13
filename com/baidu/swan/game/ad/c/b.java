package com.baidu.swan.game.ad.c;

import com.baidu.swan.apps.as.af;
/* loaded from: classes10.dex */
public class b {
    private String cdA;
    private String cdB;
    private String cdC;
    private int cdD;
    private int cdE;

    private b(a aVar) {
        this.cdB = aVar.cdB;
        this.cdA = aVar.cdA;
        this.cdD = aVar.cdD;
        this.cdE = aVar.cdE;
        this.cdC = aVar.cdC;
    }

    public int aif() {
        return this.cdD;
    }

    public int aig() {
        return this.cdE;
    }

    public String getAppSid() {
        return this.cdB;
    }

    public String aih() {
        return this.cdA;
    }

    public String aii() {
        return this.cdC;
    }

    /* loaded from: classes10.dex */
    public static class a {
        private String cdA;
        private String cdB;
        private String cdC;
        private int cdD;
        private int cdE;

        public a nz(String str) {
            this.cdB = str;
            return this;
        }

        public a nA(String str) {
            this.cdA = str;
            return this;
        }

        public a nB(String str) {
            this.cdC = str;
            return this;
        }

        public a hn(int i) {
            this.cdD = af.S(i);
            return this;
        }

        public a ho(int i) {
            this.cdE = af.S(i);
            return this;
        }

        public b aij() {
            return new b(this);
        }
    }
}
