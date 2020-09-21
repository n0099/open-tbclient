package com.baidu.swan.games.i.a;

import com.baidu.searchbox.v8engine.V8JavascriptField;
/* loaded from: classes3.dex */
public class e {
    private int duT;
    private int duU;
    @V8JavascriptField
    public String errMsg;
    @V8JavascriptField
    public String[] files;

    public e() {
        this.duU = 0;
        int i = this.duU;
        this.duU = i + 1;
        this.duT = i;
    }

    public String toString() {
        return "ReadDirCallBack" + this.duT;
    }
}
