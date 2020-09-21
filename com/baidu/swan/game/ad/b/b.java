package com.baidu.swan.game.ad.b;

import com.baidu.swan.apps.ap.ah;
/* loaded from: classes10.dex */
public class b {
    private int Za;
    private String dmO;
    private String dmP;
    private String dmQ;
    private int dmR;
    private int dmS;

    private b(a aVar) {
        this.dmP = aVar.dmP;
        this.dmO = aVar.dmO;
        this.dmR = aVar.dmR;
        this.dmS = aVar.dmS;
        this.dmQ = aVar.dmQ;
        this.Za = aVar.Za;
    }

    public int aJO() {
        return this.dmR;
    }

    public int aJP() {
        return this.dmS;
    }

    public String getAppSid() {
        return this.dmP;
    }

    public String aJQ() {
        return this.dmO;
    }

    public String aJR() {
        return this.dmQ;
    }

    public int rT() {
        return this.Za;
    }

    /* loaded from: classes10.dex */
    public static class a {
        private int Za;
        private String dmO;
        private String dmP;
        private String dmQ;
        private int dmR;
        private int dmS;

        public a up(String str) {
            this.dmP = str;
            return this;
        }

        public a uq(String str) {
            this.dmO = str;
            return this;
        }

        public a ur(String str) {
            this.dmQ = str;
            return this;
        }

        public a kX(int i) {
            this.dmR = ah.H(i);
            return this;
        }

        public a kY(int i) {
            this.dmS = ah.H(i);
            return this;
        }

        public a kZ(int i) {
            this.Za = i;
            return this;
        }

        public b aJS() {
            return new b(this);
        }
    }
}
