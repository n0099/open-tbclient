package com.baidu.swan.game.ad.b;

import com.baidu.swan.apps.aq.ai;
/* loaded from: classes9.dex */
public class b {
    private int Ya;
    private String daA;
    private int daB;
    private int daC;
    private String dax;
    private String daz;

    private b(a aVar) {
        this.daz = aVar.daz;
        this.dax = aVar.dax;
        this.daB = aVar.daB;
        this.daC = aVar.daC;
        this.daA = aVar.daA;
        this.Ya = aVar.Ya;
    }

    public int aAt() {
        return this.daB;
    }

    public int aAu() {
        return this.daC;
    }

    public String getAppSid() {
        return this.daz;
    }

    public String aAv() {
        return this.dax;
    }

    public String aAw() {
        return this.daA;
    }

    public int qp() {
        return this.Ya;
    }

    /* loaded from: classes9.dex */
    public static class a {
        private int Ya;
        private String daA;
        private int daB;
        private int daC;
        private String dax;
        private String daz;

        public a rC(String str) {
            this.daz = str;
            return this;
        }

        public a rD(String str) {
            this.dax = str;
            return this;
        }

        public a rE(String str) {
            this.daA = str;
            return this;
        }

        public a iD(int i) {
            this.daB = ai.D(i);
            return this;
        }

        public a iE(int i) {
            this.daC = ai.D(i);
            return this;
        }

        public a iF(int i) {
            this.Ya = i;
            return this;
        }

        public b aAx() {
            return new b(this);
        }
    }
}
