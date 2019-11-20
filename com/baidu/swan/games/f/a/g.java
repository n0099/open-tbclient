package com.baidu.swan.games.f.a;

import android.webkit.JavascriptInterface;
import com.baidu.searchbox.v8engine.V8JavascriptField;
/* loaded from: classes2.dex */
public class g {
    private int bzX;
    private int bzY;
    @V8JavascriptField
    public com.baidu.swan.games.f.f stats;

    public g() {
        this.bzY = 0;
        int i = this.bzY;
        this.bzY = i + 1;
        this.bzX = i;
    }

    @JavascriptInterface
    public int jsObjectID() {
        return this.bzX;
    }

    public String toString() {
        return "StatCallBack" + this.bzX;
    }
}
