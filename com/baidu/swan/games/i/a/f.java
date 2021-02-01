package com.baidu.swan.games.i.a;

import com.baidu.searchbox.v8engine.V8JavascriptField;
/* loaded from: classes9.dex */
public class f {
    @V8JavascriptField
    public String data;
    private int egR;
    private int egS;
    @V8JavascriptField
    public String errMsg;

    public f() {
        this.egS = 0;
        int i = this.egS;
        this.egS = i + 1;
        this.egR = i;
    }

    public String toString() {
        return "ReadFileStringCallBack" + this.egR;
    }
}
