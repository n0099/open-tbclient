package com.baidu.swan.game.ad.c;

import com.baidu.swan.apps.aq.ag;
/* loaded from: classes11.dex */
public class b {
    private String cRc;
    private String cRd;
    private String cRe;
    private int cRf;
    private int cRg;

    private b(a aVar) {
        this.cRd = aVar.cRd;
        this.cRc = aVar.cRc;
        this.cRf = aVar.cRf;
        this.cRg = aVar.cRg;
        this.cRe = aVar.cRe;
    }

    public int awq() {
        return this.cRf;
    }

    public int awr() {
        return this.cRg;
    }

    public String getAppSid() {
        return this.cRd;
    }

    public String aws() {
        return this.cRc;
    }

    public String awt() {
        return this.cRe;
    }

    /* loaded from: classes11.dex */
    public static class a {
        private String cRc;
        private String cRd;
        private String cRe;
        private int cRf;
        private int cRg;

        public a qA(String str) {
            this.cRd = str;
            return this;
        }

        public a qB(String str) {
            this.cRc = str;
            return this;
        }

        public a qC(String str) {
            this.cRe = str;
            return this;
        }

        public a ie(int i) {
            this.cRf = ag.B(i);
            return this;
        }

        /* renamed from: if  reason: not valid java name */
        public a m27if(int i) {
            this.cRg = ag.B(i);
            return this;
        }

        public b awu() {
            return new b(this);
        }
    }
}
