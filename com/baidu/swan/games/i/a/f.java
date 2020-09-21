package com.baidu.swan.games.i.a;

import com.baidu.searchbox.v8engine.V8JavascriptField;
/* loaded from: classes3.dex */
public class f {
    @V8JavascriptField
    public String data;
    private int duT;
    private int duU;
    @V8JavascriptField
    public String errMsg;

    public f() {
        this.duU = 0;
        int i = this.duU;
        this.duU = i + 1;
        this.duT = i;
    }

    public String toString() {
        return "ReadFileStringCallBack" + this.duT;
    }
}
