package com.baidu.swan.games.f.a;

import android.webkit.JavascriptInterface;
import com.baidu.searchbox.v8engine.V8JavascriptField;
/* loaded from: classes2.dex */
public class g {
    private int bhY;
    private int bhZ;
    @V8JavascriptField
    public com.baidu.swan.games.f.f stats;

    public g() {
        this.bhZ = 0;
        int i = this.bhZ;
        this.bhZ = i + 1;
        this.bhY = i;
    }

    @JavascriptInterface
    public int jsObjectID() {
        return this.bhY;
    }

    public String toString() {
        return "StatCallBack" + this.bhY;
    }
}
