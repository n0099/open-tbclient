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
        private g byT = new g();

        public a fR(int i) {
            this.byT.mType = i;
            return this;
        }

        public a jH(String str) {
            this.byT.mID = str;
            return this;
        }

        public g WI() {
            return this.byT;
        }
    }
}
