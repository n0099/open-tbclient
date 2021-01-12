package com.baidu.swan.games.i.a;

import com.baidu.searchbox.v8engine.JsArrayBuffer;
import com.baidu.searchbox.v8engine.V8JavascriptField;
/* loaded from: classes8.dex */
public class a {
    @V8JavascriptField
    public JsArrayBuffer data;
    private int eeI;
    private int eeJ;
    @V8JavascriptField
    public String errMsg;

    public a() {
        this.eeI = 0;
        int i = this.eeI;
        this.eeI = i + 1;
        this.eeJ = i;
    }

    public String toString() {
        return "ArrayBufferCallBack" + this.eeJ;
    }
}
