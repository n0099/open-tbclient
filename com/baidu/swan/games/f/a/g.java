package com.baidu.swan.games.f.a;

import android.webkit.JavascriptInterface;
import com.baidu.searchbox.v8engine.V8JavascriptField;
/* loaded from: classes2.dex */
public class g {
    private int bcK;
    private int mID;
    @V8JavascriptField
    public com.baidu.swan.games.f.f stats;

    public g() {
        this.bcK = 0;
        int i = this.bcK;
        this.bcK = i + 1;
        this.mID = i;
    }

    @JavascriptInterface
    public int jsObjectID() {
        return this.mID;
    }

    public String toString() {
        return "StatCallBack" + this.mID;
    }
}
