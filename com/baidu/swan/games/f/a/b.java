package com.baidu.swan.games.f.a;

import android.webkit.JavascriptInterface;
import com.baidu.searchbox.v8engine.V8JavascriptField;
/* loaded from: classes2.dex */
public class b {
    private int bzW;
    private int bzX;
    @V8JavascriptField
    public String errMsg;

    public b() {
        this.bzW = 0;
        int i = this.bzW;
        this.bzW = i + 1;
        this.bzX = i;
    }

    @JavascriptInterface
    public int jsObjectID() {
        return this.bzX;
    }

    public String toString() {
        return "FileSystemJsCallBack" + this.bzX;
    }
}
