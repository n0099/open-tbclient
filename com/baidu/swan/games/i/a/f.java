package com.baidu.swan.games.i.a;

import com.baidu.searchbox.v8engine.V8JavascriptField;
/* loaded from: classes7.dex */
public class f {
    private int dTB;
    private int dTC;
    @V8JavascriptField
    public String data;
    @V8JavascriptField
    public String errMsg;

    public f() {
        this.dTC = 0;
        int i = this.dTC;
        this.dTC = i + 1;
        this.dTB = i;
    }

    public String toString() {
        return "ReadFileStringCallBack" + this.dTB;
    }
}
