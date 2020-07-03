package com.baidu.swan.game.ad.c;

import com.baidu.swan.apps.aq.ag;
/* loaded from: classes11.dex */
public class b {
    private String cVM;
    private String cVN;
    private String cVO;
    private int cVP;
    private int cVQ;

    private b(a aVar) {
        this.cVN = aVar.cVN;
        this.cVM = aVar.cVM;
        this.cVP = aVar.cVP;
        this.cVQ = aVar.cVQ;
        this.cVO = aVar.cVO;
    }

    public int axw() {
        return this.cVP;
    }

    public int axx() {
        return this.cVQ;
    }

    public String getAppSid() {
        return this.cVN;
    }

    public String axy() {
        return this.cVM;
    }

    public String axz() {
        return this.cVO;
    }

    /* loaded from: classes11.dex */
    public static class a {
        private String cVM;
        private String cVN;
        private String cVO;
        private int cVP;
        private int cVQ;

        public a qI(String str) {
            this.cVN = str;
            return this;
        }

        public a qJ(String str) {
            this.cVM = str;
            return this;
        }

        public a qK(String str) {
            this.cVO = str;
            return this;
        }

        public a ip(int i) {
            this.cVP = ag.D(i);
            return this;
        }

        public a iq(int i) {
            this.cVQ = ag.D(i);
            return this;
        }

        public b axA() {
            return new b(this);
        }
    }
}
