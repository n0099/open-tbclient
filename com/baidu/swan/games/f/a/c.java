package com.baidu.swan.games.f.a;

import android.webkit.JavascriptInterface;
import com.baidu.searchbox.v8engine.V8JavascriptField;
/* loaded from: classes2.dex */
public class c {
    private int bzX;
    private int bzY;
    @V8JavascriptField
    public String digest;
    @V8JavascriptField
    public String errMsg;
    @V8JavascriptField
    public int size;

    public c() {
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
        return "GetFileInfoCallBack" + this.bzX;
    }
}
