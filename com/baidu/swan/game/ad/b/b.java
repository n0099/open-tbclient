package com.baidu.swan.game.ad.b;

import com.baidu.swan.apps.ao.ah;
/* loaded from: classes5.dex */
public class b {
    private int acs;
    private String eas;
    private String eat;
    private int eau;
    private int eav;
    private String mAdPlaceId;

    private b(a aVar) {
        this.eas = aVar.eas;
        this.mAdPlaceId = aVar.mAdPlaceId;
        this.eau = aVar.eau;
        this.eav = aVar.eav;
        this.eat = aVar.eat;
        this.acs = aVar.acs;
    }

    public int getAdWidth() {
        return this.eau;
    }

    public int getAdHeight() {
        return this.eav;
    }

    public String getAppSid() {
        return this.eas;
    }

    public String getAdPlaceId() {
        return this.mAdPlaceId;
    }

    public String aSh() {
        return this.eat;
    }

    public int ru() {
        return this.acs;
    }

    /* loaded from: classes5.dex */
    public static class a {
        private int acs;
        private String eas;
        private String eat;
        private int eau;
        private int eav;
        private String mAdPlaceId;

        public a vy(String str) {
            this.eas = str;
            return this;
        }

        public a vz(String str) {
            this.mAdPlaceId = str;
            return this;
        }

        public a vA(String str) {
            this.eat = str;
            return this;
        }

        public a kP(int i) {
            this.eau = ah.T(i);
            return this;
        }

        public a kQ(int i) {
            this.eav = ah.T(i);
            return this;
        }

        public a kR(int i) {
            this.acs = i;
            return this;
        }

        public b aSi() {
            return new b(this);
        }
    }
}
