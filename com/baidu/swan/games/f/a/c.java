package com.baidu.swan.games.f.a;

import android.webkit.JavascriptInterface;
import com.baidu.searchbox.v8engine.V8JavascriptField;
/* loaded from: classes2.dex */
public class c {
    private int bAO;
    private int bAP;
    @V8JavascriptField
    public String digest;
    @V8JavascriptField
    public String errMsg;
    @V8JavascriptField
    public int size;

    public c() {
        this.bAP = 0;
        int i = this.bAP;
        this.bAP = i + 1;
        this.bAO = i;
    }

    @JavascriptInterface
    public int jsObjectID() {
        return this.bAO;
    }

    public String toString() {
        return "GetFileInfoCallBack" + this.bAO;
    }
}
