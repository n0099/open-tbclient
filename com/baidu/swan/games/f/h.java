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
        private h dNR = new h();

        public a lU(int i) {
            this.dNR.mType = i;
            return this;
        }

        public a wu(String str) {
            this.dNR.mID = str;
            return this;
        }

        public h aSx() {
            return this.dNR;
        }
    }
}
