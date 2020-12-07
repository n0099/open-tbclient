package com.baidu.swan.games.i.a;

import com.baidu.searchbox.v8engine.V8JavascriptField;
/* loaded from: classes25.dex */
public class f {
    @V8JavascriptField
    public String data;
    private int eaA;
    private int eaz;
    @V8JavascriptField
    public String errMsg;

    public f() {
        this.eaA = 0;
        int i = this.eaA;
        this.eaA = i + 1;
        this.eaz = i;
    }

    public String toString() {
        return "ReadFileStringCallBack" + this.eaz;
    }
}
