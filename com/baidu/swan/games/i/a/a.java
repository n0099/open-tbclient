package com.baidu.swan.games.i.a;

import com.baidu.searchbox.v8engine.JsArrayBuffer;
import com.baidu.searchbox.v8engine.V8JavascriptField;
/* loaded from: classes25.dex */
public class a {
    @V8JavascriptField
    public JsArrayBuffer data;
    private int eay;
    private int eaz;
    @V8JavascriptField
    public String errMsg;

    public a() {
        this.eay = 0;
        int i = this.eay;
        this.eay = i + 1;
        this.eaz = i;
    }

    public String toString() {
        return "ArrayBufferCallBack" + this.eaz;
    }
}
