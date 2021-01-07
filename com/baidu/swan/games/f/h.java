package com.baidu.swan.games.f;
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
        private h ehW = new h();

        public a mG(int i) {
            this.ehW.mType = i;
            return this;
        }

        public a xj(String str) {
            this.ehW.mID = str;
            return this;
        }

        public h aZP() {
            return this.ehW;
        }
    }
}
