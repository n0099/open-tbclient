package com.baidu.swan.games.h.a;

import android.webkit.JavascriptInterface;
import com.baidu.searchbox.v8engine.V8JavascriptField;
/* loaded from: classes11.dex */
public class b {
    private int cNp;
    private int cNq;
    @V8JavascriptField
    public String errMsg;

    public b() {
        this.cNp = 0;
        int i = this.cNp;
        this.cNp = i + 1;
        this.cNq = i;
    }

    @JavascriptInterface
    public int jsObjectID() {
        return this.cNq;
    }

    public String toString() {
        return "FileSystemJsCallBack" + this.cNq;
    }
}
