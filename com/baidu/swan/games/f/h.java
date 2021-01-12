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
        private h edj = new h();

        public a la(int i) {
            this.edj.mType = i;
            return this;
        }

        public a vY(String str) {
            this.edj.mID = str;
            return this;
        }

        public h aVV() {
            return this.edj;
        }
    }
}
