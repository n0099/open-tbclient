package com.baidu.swan.games.i.a;

import com.baidu.searchbox.v8engine.JsArrayBuffer;
import com.baidu.searchbox.v8engine.V8JavascriptField;
/* loaded from: classes7.dex */
public class a {
    @V8JavascriptField
    public JsArrayBuffer data;
    private int diF;
    private int diG;
    @V8JavascriptField
    public String errMsg;

    public a() {
        this.diF = 0;
        int i = this.diF;
        this.diF = i + 1;
        this.diG = i;
    }

    public String toString() {
        return "ArrayBufferCallBack" + this.diG;
    }
}
