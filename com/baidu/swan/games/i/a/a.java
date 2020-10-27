package com.baidu.swan.games.i.a;

import com.baidu.searchbox.v8engine.JsArrayBuffer;
import com.baidu.searchbox.v8engine.V8JavascriptField;
/* loaded from: classes10.dex */
public class a {
    private int dPq;
    private int dPr;
    @V8JavascriptField
    public JsArrayBuffer data;
    @V8JavascriptField
    public String errMsg;

    public a() {
        this.dPq = 0;
        int i = this.dPq;
        this.dPq = i + 1;
        this.dPr = i;
    }

    public String toString() {
        return "ArrayBufferCallBack" + this.dPr;
    }
}
