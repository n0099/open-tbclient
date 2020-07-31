package com.baidu.swan.games.f;
/* loaded from: classes7.dex */
public final class h {
    public String mID;
    public int mType;

    private h() {
    }

    public int getType() {
        return this.mType;
    }

    public String getID() {
        return this.mID;
    }

    public String toString() {
        return "V8EngineModel{mType=" + this.mType + ", mID='" + this.mID + "'}";
    }

    /* loaded from: classes7.dex */
    public static class a {
        private h dhc = new h();

        public a iS(int i) {
            this.dhc.mType = i;
            return this;
        }

        public a sE(String str) {
            this.dhc.mID = str;
            return this;
        }

        public h aEu() {
            return this.dhc;
        }
    }
}
