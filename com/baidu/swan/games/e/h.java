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
        private h cmS = new h();

        public a hQ(int i) {
            this.cmS.mType = i;
            return this;
        }

        public a oI(String str) {
            this.cmS.mID = str;
            return this;
        }

        public h anH() {
            return this.cmS;
        }
    }
}
