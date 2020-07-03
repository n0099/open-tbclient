package com.baidu.swan.games.i.a;

import com.baidu.searchbox.v8engine.JsArrayBuffer;
import com.baidu.searchbox.v8engine.V8JavascriptField;
/* loaded from: classes11.dex */
public class a {
    @V8JavascriptField
    public JsArrayBuffer data;
    private int dcU;
    private int dcV;
    @V8JavascriptField
    public String errMsg;

    public a() {
        this.dcU = 0;
        int i = this.dcU;
        this.dcU = i + 1;
        this.dcV = i;
    }

    public String toString() {
        return "ArrayBufferCallBack" + this.dcV;
    }
}
