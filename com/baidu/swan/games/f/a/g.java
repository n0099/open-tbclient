package com.baidu.swan.games.f.a;

import android.webkit.JavascriptInterface;
import com.baidu.searchbox.v8engine.V8JavascriptField;
/* loaded from: classes2.dex */
public class g {
    private int bcG;
    private int mID;
    @V8JavascriptField
    public com.baidu.swan.games.f.f stats;

    public g() {
        this.bcG = 0;
        int i = this.bcG;
        this.bcG = i + 1;
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
