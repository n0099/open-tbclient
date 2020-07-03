package com.baidu.swan.games.f;
/* loaded from: classes11.dex */
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

    /* loaded from: classes11.dex */
    public static class a {
        private h dbt = new h();

        public a iB(int i) {
            this.dbt.mType = i;
            return this;
        }

        public a rF(String str) {
            this.dbt.mID = str;
            return this;
        }

        public h aAP() {
            return this.dbt;
        }
    }
}
