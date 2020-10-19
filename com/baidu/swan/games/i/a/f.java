package com.baidu.swan.games.i.a;

import com.baidu.searchbox.v8engine.V8JavascriptField;
/* loaded from: classes10.dex */
public class f {
    private int dGU;
    private int dGV;
    @V8JavascriptField
    public String data;
    @V8JavascriptField
    public String errMsg;

    public f() {
        this.dGV = 0;
        int i = this.dGV;
        this.dGV = i + 1;
        this.dGU = i;
    }

    public String toString() {
        return "ReadFileStringCallBack" + this.dGU;
    }
}
