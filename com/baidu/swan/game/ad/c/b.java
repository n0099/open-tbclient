package com.baidu.swan.game.ad.c;

import com.baidu.swan.apps.as.af;
/* loaded from: classes9.dex */
public class b {
    private String cdn;
    private String cdo;
    private String cdp;
    private int cdq;
    private int cdr;

    private b(a aVar) {
        this.cdo = aVar.cdo;
        this.cdn = aVar.cdn;
        this.cdq = aVar.cdq;
        this.cdr = aVar.cdr;
        this.cdp = aVar.cdp;
    }

    public int ahM() {
        return this.cdq;
    }

    public int ahN() {
        return this.cdr;
    }

    public String getAppSid() {
        return this.cdo;
    }

    public String ahO() {
        return this.cdn;
    }

    public String ahP() {
        return this.cdp;
    }

    /* loaded from: classes9.dex */
    public static class a {
        private String cdn;
        private String cdo;
        private String cdp;
        private int cdq;
        private int cdr;

        public a nw(String str) {
            this.cdo = str;
            return this;
        }

        public a nx(String str) {
            this.cdn = str;
            return this;
        }

        public a ny(String str) {
            this.cdp = str;
            return this;
        }

        public a hn(int i) {
            this.cdq = af.T(i);
            return this;
        }

        public a ho(int i) {
            this.cdr = af.T(i);
            return this;
        }

        public b ahQ() {
            return new b(this);
        }
    }
}
