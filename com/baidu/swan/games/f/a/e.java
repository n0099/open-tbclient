package com.baidu.swan.games.f.a;

import android.webkit.JavascriptInterface;
import com.baidu.searchbox.v8engine.V8JavascriptField;
/* loaded from: classes2.dex */
public class e {
    private int bcK;
    @V8JavascriptField
    public String data;
    private int mID;

    public e() {
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
        return "ReadFileStringCallBack" + this.mID;
    }
}
