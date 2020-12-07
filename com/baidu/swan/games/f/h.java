package com.baidu.swan.games.f;
/* loaded from: classes25.dex */
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

    /* loaded from: classes25.dex */
    public static class a {
        private h dYZ = new h();

        public a my(int i) {
            this.dYZ.mType = i;
            return this;
        }

        public a xk(String str) {
            this.dYZ.mID = str;
            return this;
        }

        public h aXu() {
            return this.dYZ;
        }
    }
}
