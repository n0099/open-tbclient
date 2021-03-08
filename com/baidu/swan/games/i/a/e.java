package com.baidu.swan.games.i.a;

import com.baidu.searchbox.v8engine.V8JavascriptField;
/* loaded from: classes8.dex */
public class e {
    private int eis;
    private int eit;
    @V8JavascriptField
    public String errMsg;
    @V8JavascriptField
    public String[] files;

    public e() {
        this.eit = 0;
        int i = this.eit;
        this.eit = i + 1;
        this.eis = i;
    }

    public String toString() {
        return "ReadDirCallBack" + this.eis;
    }
}
