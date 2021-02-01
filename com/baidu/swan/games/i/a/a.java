package com.baidu.swan.games.i.a;

import com.baidu.searchbox.v8engine.JsArrayBuffer;
import com.baidu.searchbox.v8engine.V8JavascriptField;
/* loaded from: classes9.dex */
public class a {
    @V8JavascriptField
    public JsArrayBuffer data;
    private int egQ;
    private int egR;
    @V8JavascriptField
    public String errMsg;

    public a() {
        this.egQ = 0;
        int i = this.egQ;
        this.egQ = i + 1;
        this.egR = i;
    }

    public String toString() {
        return "ArrayBufferCallBack" + this.egR;
    }
}
