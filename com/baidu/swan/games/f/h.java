package com.baidu.swan.games.f;
/* loaded from: classes8.dex */
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

    /* loaded from: classes8.dex */
    public static class a {
        private h egS = new h();

        public a le(int i) {
            this.egS.mType = i;
            return this;
        }

        public a wy(String str) {
            this.egS.mID = str;
            return this;
        }

        public h aWk() {
            return this.egS;
        }
    }
}
