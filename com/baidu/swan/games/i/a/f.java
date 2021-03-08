package com.baidu.swan.games.i.a;

import com.baidu.searchbox.v8engine.V8JavascriptField;
/* loaded from: classes8.dex */
public class f {
    @V8JavascriptField
    public String data;
    private int eis;
    private int eit;
    @V8JavascriptField
    public String errMsg;

    public f() {
        this.eit = 0;
        int i = this.eit;
        this.eit = i + 1;
        this.eis = i;
    }

    public String toString() {
        return "ReadFileStringCallBack" + this.eis;
    }
}
