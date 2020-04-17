package com.baidu.swan.games.h.a;

import android.webkit.JavascriptInterface;
import com.baidu.searchbox.v8engine.V8JavascriptField;
/* loaded from: classes11.dex */
public class b {
    private int cNj;
    private int cNk;
    @V8JavascriptField
    public String errMsg;

    public b() {
        this.cNj = 0;
        int i = this.cNj;
        this.cNj = i + 1;
        this.cNk = i;
    }

    @JavascriptInterface
    public int jsObjectID() {
        return this.cNk;
    }

    public String toString() {
        return "FileSystemJsCallBack" + this.cNk;
    }
}
