package com.baidu.swan.games.e;
/* loaded from: classes11.dex */
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

    /* loaded from: classes11.dex */
    public static class a {
        private h cmF = new h();

        public a hQ(int i) {
            this.cmF.mType = i;
            return this;
        }

        public a oJ(String str) {
            this.cmF.mID = str;
            return this;
        }

        public h anC() {
            return this.cmF;
        }
    }
}
