package com.baidu.swan.games.i.a;

import com.baidu.searchbox.v8engine.V8JavascriptField;
/* loaded from: classes8.dex */
public class f {
    @V8JavascriptField
    public String data;
    private int eeJ;
    private int eeK;
    @V8JavascriptField
    public String errMsg;

    public f() {
        this.eeK = 0;
        int i = this.eeK;
        this.eeK = i + 1;
        this.eeJ = i;
    }

    public String toString() {
        return "ReadFileStringCallBack" + this.eeJ;
    }
}
