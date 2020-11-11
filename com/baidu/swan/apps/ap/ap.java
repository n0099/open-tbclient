package com.baidu.swan.apps.ap;
/* loaded from: classes10.dex */
public class ap {
    private int dEf;

    private ap() {
        this.dEf = 0;
    }

    public void lr(int i) {
        this.dEf = i;
    }

    public void reset() {
        this.dEf = 0;
    }

    public boolean aNi() {
        return this.dEf != 0;
    }

    public int aNj() {
        return aNi() ? 1 : 0;
    }

    public static ap aNk() {
        return a.dEg;
    }

    /* loaded from: classes10.dex */
    private static class a {
        private static final ap dEg = new ap();
    }
}
