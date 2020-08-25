package com.baidu.swan.games.i.a;

import com.baidu.searchbox.v8engine.V8JavascriptField;
/* loaded from: classes8.dex */
public class f {
    @V8JavascriptField
    public String data;
    private int dsN;
    private int dsO;
    @V8JavascriptField
    public String errMsg;

    public f() {
        this.dsO = 0;
        int i = this.dsO;
        this.dsO = i + 1;
        this.dsN = i;
    }

    public String toString() {
        return "ReadFileStringCallBack" + this.dsN;
    }
}
