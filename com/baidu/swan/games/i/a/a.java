package com.baidu.swan.games.i.a;

import com.baidu.searchbox.v8engine.JsArrayBuffer;
import com.baidu.searchbox.v8engine.V8JavascriptField;
/* loaded from: classes11.dex */
public class a {
    private int cYh;
    private int cYi;
    @V8JavascriptField
    public JsArrayBuffer data;
    @V8JavascriptField
    public String errMsg;

    public a() {
        this.cYh = 0;
        int i = this.cYh;
        this.cYh = i + 1;
        this.cYi = i;
    }

    public String toString() {
        return "ArrayBufferCallBack" + this.cYi;
    }
}
