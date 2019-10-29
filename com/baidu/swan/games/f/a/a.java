package com.baidu.swan.games.f.a;

import android.webkit.JavascriptInterface;
import com.baidu.searchbox.v8engine.JsArrayBuffer;
import com.baidu.searchbox.v8engine.V8JavascriptField;
/* loaded from: classes2.dex */
public class a {
    private int bAN;
    private int bAO;
    @V8JavascriptField
    public JsArrayBuffer data;

    public a() {
        this.bAN = 0;
        int i = this.bAN;
        this.bAN = i + 1;
        this.bAO = i;
    }

    @JavascriptInterface
    public int jsObjectID() {
        return this.bAO;
    }

    public String toString() {
        return "ArrayBufferCallBack" + this.bAO;
    }
}
