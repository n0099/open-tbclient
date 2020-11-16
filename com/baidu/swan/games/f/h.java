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
        private h dSb = new h();

        public a ma(int i) {
            this.dSb.mType = i;
            return this;
        }

        public a wD(String str) {
            this.dSb.mID = str;
            return this;
        }

        public h aUp() {
            return this.dSb;
        }
    }
}
