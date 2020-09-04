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
        private h drp = new h();

        public a lb(int i) {
            this.drp.mType = i;
            return this;
        }

        public a uW(String str) {
            this.drp.mID = str;
            return this;
        }

        public h aNj() {
            return this.drp;
        }
    }
}
