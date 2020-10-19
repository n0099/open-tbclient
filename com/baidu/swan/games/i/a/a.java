package com.baidu.swan.games.i.a;

import com.baidu.searchbox.v8engine.JsArrayBuffer;
import com.baidu.searchbox.v8engine.V8JavascriptField;
/* loaded from: classes10.dex */
public class a {
    private int dGT;
    private int dGU;
    @V8JavascriptField
    public JsArrayBuffer data;
    @V8JavascriptField
    public String errMsg;

    public a() {
        this.dGT = 0;
        int i = this.dGT;
        this.dGT = i + 1;
        this.dGU = i;
    }

    public String toString() {
        return "ArrayBufferCallBack" + this.dGU;
    }
}
