package com.baidu.swan.games.i.a;

import com.baidu.searchbox.v8engine.JsArrayBuffer;
import com.baidu.searchbox.v8engine.V8JavascriptField;
/* loaded from: classes8.dex */
public class a {
    @V8JavascriptField
    public JsArrayBuffer data;
    private int dsM;
    private int dsN;
    @V8JavascriptField
    public String errMsg;

    public a() {
        this.dsM = 0;
        int i = this.dsM;
        this.dsM = i + 1;
        this.dsN = i;
    }

    public String toString() {
        return "ArrayBufferCallBack" + this.dsN;
    }
}
