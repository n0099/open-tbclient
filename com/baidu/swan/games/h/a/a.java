package com.baidu.swan.games.h.a;

import android.webkit.JavascriptInterface;
import com.baidu.searchbox.v8engine.JsArrayBuffer;
import com.baidu.searchbox.v8engine.V8JavascriptField;
/* loaded from: classes10.dex */
public class a {
    private int cjW;
    @V8JavascriptField
    public JsArrayBuffer data;
    private int mID;

    public a() {
        this.cjW = 0;
        int i = this.cjW;
        this.cjW = i + 1;
        this.mID = i;
    }

    @JavascriptInterface
    public int jsObjectID() {
        return this.mID;
    }

    public String toString() {
        return "ArrayBufferCallBack" + this.mID;
    }
}
