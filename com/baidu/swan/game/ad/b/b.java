package com.baidu.swan.game.ad.b;

import com.baidu.swan.apps.ap.ah;
/* loaded from: classes19.dex */
public class b {
    private int YI;
    private String dkM;
    private String dkN;
    private String dkO;
    private int dkP;
    private int dkQ;

    private b(a aVar) {
        this.dkN = aVar.dkN;
        this.dkM = aVar.dkM;
        this.dkP = aVar.dkP;
        this.dkQ = aVar.dkQ;
        this.dkO = aVar.dkO;
        this.YI = aVar.YI;
    }

    public int aJd() {
        return this.dkP;
    }

    public int aJe() {
        return this.dkQ;
    }

    public String getAppSid() {
        return this.dkN;
    }

    public String aJf() {
        return this.dkM;
    }

    public String aJg() {
        return this.dkO;
    }

    public int rO() {
        return this.YI;
    }

    /* loaded from: classes19.dex */
    public static class a {
        private int YI;
        private String dkM;
        private String dkN;
        private String dkO;
        private int dkP;
        private int dkQ;

        public a tW(String str) {
            this.dkN = str;
            return this;
        }

        public a tX(String str) {
            this.dkM = str;
            return this;
        }

        public a tY(String str) {
            this.dkO = str;
            return this;
        }

        public a kM(int i) {
            this.dkP = ah.H(i);
            return this;
        }

        public a kN(int i) {
            this.dkQ = ah.H(i);
            return this;
        }

        public a kO(int i) {
            this.YI = i;
            return this;
        }

        public b aJh() {
            return new b(this);
        }
    }
}
