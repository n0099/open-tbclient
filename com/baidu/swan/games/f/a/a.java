package com.baidu.swan.games.f.a;

import android.webkit.JavascriptInterface;
import com.baidu.searchbox.v8engine.JsArrayBuffer;
import com.baidu.searchbox.v8engine.V8JavascriptField;
/* loaded from: classes2.dex */
public class a {
    private int bcF;
    @V8JavascriptField
    public JsArrayBuffer data;
    private int mID;

    public a() {
        this.bcF = 0;
        int i = this.bcF;
        this.bcF = i + 1;
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
