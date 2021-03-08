package com.baidu.swan.games.i.a;

import com.baidu.searchbox.v8engine.JsArrayBuffer;
import com.baidu.searchbox.v8engine.V8JavascriptField;
/* loaded from: classes8.dex */
public class a {
    @V8JavascriptField
    public JsArrayBuffer data;
    private int eir;
    private int eis;
    @V8JavascriptField
    public String errMsg;

    public a() {
        this.eir = 0;
        int i = this.eir;
        this.eir = i + 1;
        this.eis = i;
    }

    public String toString() {
        return "ArrayBufferCallBack" + this.eis;
    }
}
