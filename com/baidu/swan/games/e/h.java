package com.baidu.swan.games.e;
/* loaded from: classes9.dex */
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

    /* loaded from: classes9.dex */
    public static class a {
        private h cio = new h();

        public a hz(int i) {
            this.cio.mType = i;
            return this;
        }

        public a or(String str) {
            this.cio.mID = str;
            return this;
        }

        public h akW() {
            return this.cio;
        }
    }
}
