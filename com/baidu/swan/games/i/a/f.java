package com.baidu.swan.games.i.a;

import com.baidu.searchbox.v8engine.V8JavascriptField;
/* loaded from: classes9.dex */
public class f {
    @V8JavascriptField
    public String data;
    private int ejw;
    private int ejx;
    @V8JavascriptField
    public String errMsg;

    public f() {
        this.ejx = 0;
        int i = this.ejx;
        this.ejx = i + 1;
        this.ejw = i;
    }

    public String toString() {
        return "ReadFileStringCallBack" + this.ejw;
    }
}
