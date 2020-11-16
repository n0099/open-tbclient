package com.baidu.swan.games.i.a;

import com.baidu.searchbox.v8engine.JsArrayBuffer;
import com.baidu.searchbox.v8engine.V8JavascriptField;
/* loaded from: classes7.dex */
public class a {
    private int dTA;
    private int dTB;
    @V8JavascriptField
    public JsArrayBuffer data;
    @V8JavascriptField
    public String errMsg;

    public a() {
        this.dTA = 0;
        int i = this.dTA;
        this.dTA = i + 1;
        this.dTB = i;
    }

    public String toString() {
        return "ArrayBufferCallBack" + this.dTB;
    }
}
