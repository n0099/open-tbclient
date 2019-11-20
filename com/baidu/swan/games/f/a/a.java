package com.baidu.swan.games.f.a;

import android.webkit.JavascriptInterface;
import com.baidu.searchbox.v8engine.JsArrayBuffer;
import com.baidu.searchbox.v8engine.V8JavascriptField;
/* loaded from: classes2.dex */
public class a {
    private int bzW;
    private int bzX;
    @V8JavascriptField
    public JsArrayBuffer data;

    public a() {
        this.bzW = 0;
        int i = this.bzW;
        this.bzW = i + 1;
        this.bzX = i;
    }

    @JavascriptInterface
    public int jsObjectID() {
        return this.bzX;
    }

    public String toString() {
        return "ArrayBufferCallBack" + this.bzX;
    }
}
