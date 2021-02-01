package com.baidu.swan.game.ad.b;

import com.baidu.swan.apps.ao.ah;
/* loaded from: classes5.dex */
public class b {
    private int aaW;
    private String dYQ;
    private String dYR;
    private int dYS;
    private int dYT;
    private String mAdPlaceId;

    private b(a aVar) {
        this.dYQ = aVar.dYQ;
        this.mAdPlaceId = aVar.mAdPlaceId;
        this.dYS = aVar.dYS;
        this.dYT = aVar.dYT;
        this.dYR = aVar.dYR;
        this.aaW = aVar.aaW;
    }

    public int getAdWidth() {
        return this.dYS;
    }

    public int getAdHeight() {
        return this.dYT;
    }

    public String getAppSid() {
        return this.dYQ;
    }

    public String getAdPlaceId() {
        return this.mAdPlaceId;
    }

    public String aSe() {
        return this.dYR;
    }

    public int ru() {
        return this.aaW;
    }

    /* loaded from: classes5.dex */
    public static class a {
        private int aaW;
        private String dYQ;
        private String dYR;
        private int dYS;
        private int dYT;
        private String mAdPlaceId;

        public a vr(String str) {
            this.dYQ = str;
            return this;
        }

        public a vs(String str) {
            this.mAdPlaceId = str;
            return this;
        }

        public a vt(String str) {
            this.dYR = str;
            return this;
        }

        public a kO(int i) {
            this.dYS = ah.P(i);
            return this;
        }

        public a kP(int i) {
            this.dYT = ah.P(i);
            return this;
        }

        public a kQ(int i) {
            this.aaW = i;
            return this;
        }

        public b aSf() {
            return new b(this);
        }
    }
}
