package com.baidu.swan.games.i.a;

import com.baidu.searchbox.v8engine.JsArrayBuffer;
import com.baidu.searchbox.v8engine.V8JavascriptField;
/* loaded from: classes10.dex */
public class a {
    private int dVi;
    private int dVj;
    @V8JavascriptField
    public JsArrayBuffer data;
    @V8JavascriptField
    public String errMsg;

    public a() {
        this.dVi = 0;
        int i = this.dVi;
        this.dVi = i + 1;
        this.dVj = i;
    }

    public String toString() {
        return "ArrayBufferCallBack" + this.dVj;
    }
}
