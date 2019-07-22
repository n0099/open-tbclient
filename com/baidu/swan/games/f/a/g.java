package com.baidu.swan.games.f.a;

import android.webkit.JavascriptInterface;
import com.baidu.searchbox.v8engine.V8JavascriptField;
/* loaded from: classes2.dex */
public class g {
    private int bhA;
    private int bhB;
    @V8JavascriptField
    public com.baidu.swan.games.f.f stats;

    public g() {
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
        return "StatCallBack" + this.bhA;
    }
}
