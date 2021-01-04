package com.baidu.swan.game.ad.b;

import com.baidu.swan.apps.ao.ah;
/* loaded from: classes3.dex */
public class b {
    private int abd;
    private String ebv;
    private String ebw;
    private String ebx;
    private int eby;
    private int ebz;

    private b(a aVar) {
        this.ebw = aVar.ebw;
        this.ebv = aVar.ebv;
        this.eby = aVar.eby;
        this.ebz = aVar.ebz;
        this.ebx = aVar.ebx;
        this.abd = aVar.abd;
    }

    public int aVI() {
        return this.eby;
    }

    public int aVJ() {
        return this.ebz;
    }

    public String getAppSid() {
        return this.ebw;
    }

    public String aVK() {
        return this.ebv;
    }

    public String aVL() {
        return this.ebx;
    }

    public int rw() {
        return this.abd;
    }

    /* loaded from: classes3.dex */
    public static class a {
        private int abd;
        private String ebv;
        private String ebw;
        private String ebx;
        private int eby;
        private int ebz;

        public a wj(String str) {
            this.ebw = str;
            return this;
        }

        public a wk(String str) {
            this.ebv = str;
            return this;
        }

        public a wl(String str) {
            this.ebx = str;
            return this;
        }

        public a mr(int i) {
            this.eby = ah.O(i);
            return this;
        }

        public a ms(int i) {
            this.ebz = ah.O(i);
            return this;
        }

        public a mt(int i) {
            this.abd = i;
            return this;
        }

        public b aVM() {
            return new b(this);
        }
    }
}
