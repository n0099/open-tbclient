package com.baidu.swan.games.e;
/* loaded from: classes2.dex */
public final class g {
    public String mID;
    public int mType;

    private g() {
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

    /* loaded from: classes2.dex */
    public static class a {
        private g bgu = new g();

        public a eW(int i) {
            this.bgu.mType = i;
            return this;
        }

        public a jc(String str) {
            this.bgu.mID = str;
            return this;
        }

        public g RP() {
            return this.bgu;
        }
    }
}
