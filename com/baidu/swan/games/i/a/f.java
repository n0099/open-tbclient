package com.baidu.swan.games.i.a;

import com.baidu.searchbox.v8engine.V8JavascriptField;
/* loaded from: classes10.dex */
public class f {
    private int dPr;
    private int dPs;
    @V8JavascriptField
    public String data;
    @V8JavascriptField
    public String errMsg;

    public f() {
        this.dPs = 0;
        int i = this.dPs;
        this.dPs = i + 1;
        this.dPr = i;
    }

    public String toString() {
        return "ReadFileStringCallBack" + this.dPr;
    }
}
