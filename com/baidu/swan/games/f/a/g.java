package com.baidu.swan.games.f.a;

import android.webkit.JavascriptInterface;
import com.baidu.searchbox.v8engine.V8JavascriptField;
/* loaded from: classes2.dex */
public class g {
    private int bAO;
    private int bAP;
    @V8JavascriptField
    public com.baidu.swan.games.f.f stats;

    public g() {
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
        return "StatCallBack" + this.bAO;
    }
}
