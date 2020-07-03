package com.baidu.swan.games.i.a;

import com.baidu.searchbox.v8engine.V8JavascriptField;
/* loaded from: classes11.dex */
public class f {
    @V8JavascriptField
    public String data;
    private int dcV;
    private int dcW;
    @V8JavascriptField
    public String errMsg;

    public f() {
        this.dcW = 0;
        int i = this.dcW;
        this.dcW = i + 1;
        this.dcV = i;
    }

    public String toString() {
        return "ReadFileStringCallBack" + this.dcV;
    }
}
