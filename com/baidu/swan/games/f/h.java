package com.baidu.swan.games.f;
/* loaded from: classes10.dex */
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

    /* loaded from: classes10.dex */
    public static class a {
        private h dTJ = new h();

        public a me(int i) {
            this.dTJ.mType = i;
            return this;
        }

        public a wI(String str) {
            this.dTJ.mID = str;
            return this;
        }

        public h aUX() {
            return this.dTJ;
        }
    }
}
