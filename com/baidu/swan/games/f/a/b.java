package com.baidu.swan.games.f.a;

import android.webkit.JavascriptInterface;
import com.baidu.searchbox.v8engine.V8JavascriptField;
/* loaded from: classes2.dex */
public class b {
    private int bhX;
    private int bhY;
    @V8JavascriptField
    public String errMsg;

    public b() {
        this.bhX = 0;
        int i = this.bhX;
        this.bhX = i + 1;
        this.bhY = i;
    }

    @JavascriptInterface
    public int jsObjectID() {
        return this.bhY;
    }

    public String toString() {
        return "FileSystemJsCallBack" + this.bhY;
    }
}
