package com.baidu.swan.games.f.a;

import android.webkit.JavascriptInterface;
import com.baidu.searchbox.v8engine.V8JavascriptField;
/* loaded from: classes2.dex */
public class c {
    private int bhA;
    private int bhB;
    @V8JavascriptField
    public String digest;
    @V8JavascriptField
    public String errMsg;
    @V8JavascriptField
    public int size;

    public c() {
        this.bhB = 0;
        int i = this.bhB;
        this.bhB = i + 1;
        this.bhA = i;
    }

    @JavascriptInterface
    public int jsObjectID() {
        return this.bhA;
    }

    public String toString() {
        return "GetFileInfoCallBack" + this.bhA;
    }
}
