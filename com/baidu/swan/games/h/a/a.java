package com.baidu.swan.games.h.a;

import android.webkit.JavascriptInterface;
import com.baidu.searchbox.v8engine.JsArrayBuffer;
import com.baidu.searchbox.v8engine.V8JavascriptField;
/* loaded from: classes11.dex */
public class a {
    private int cNp;
    private int cNq;
    @V8JavascriptField
    public JsArrayBuffer data;

    public a() {
        this.cNp = 0;
        int i = this.cNp;
        this.cNp = i + 1;
        this.cNq = i;
    }

    @JavascriptInterface
    public int jsObjectID() {
        return this.cNq;
    }

    public String toString() {
        return "ArrayBufferCallBack" + this.cNq;
    }
}
