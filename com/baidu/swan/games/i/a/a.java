package com.baidu.swan.games.i.a;

import com.baidu.searchbox.v8engine.JsArrayBuffer;
import com.baidu.searchbox.v8engine.V8JavascriptField;
/* loaded from: classes8.dex */
public class a {
    @V8JavascriptField
    public JsArrayBuffer data;
    private int dsQ;
    private int dsR;
    @V8JavascriptField
    public String errMsg;

    public a() {
        this.dsQ = 0;
        int i = this.dsQ;
        this.dsQ = i + 1;
        this.dsR = i;
    }

    public String toString() {
        return "ArrayBufferCallBack" + this.dsR;
    }
}
