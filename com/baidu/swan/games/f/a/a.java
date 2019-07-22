package com.baidu.swan.games.f.a;

import android.webkit.JavascriptInterface;
import com.baidu.searchbox.v8engine.JsArrayBuffer;
import com.baidu.searchbox.v8engine.V8JavascriptField;
/* loaded from: classes2.dex */
public class a {
    private int bhA;
    private int bhz;
    @V8JavascriptField
    public JsArrayBuffer data;

    public a() {
        this.bhz = 0;
        int i = this.bhz;
        this.bhz = i + 1;
        this.bhA = i;
    }

    @JavascriptInterface
    public int jsObjectID() {
        return this.bhA;
    }

    public String toString() {
        return "ArrayBufferCallBack" + this.bhA;
    }
}
