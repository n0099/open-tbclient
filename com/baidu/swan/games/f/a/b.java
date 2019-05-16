package com.baidu.swan.games.f.a;

import android.webkit.JavascriptInterface;
import com.baidu.searchbox.v8engine.V8JavascriptField;
/* loaded from: classes2.dex */
public class b {
    private int bgN;
    @V8JavascriptField
    public String errMsg;
    private int mID;

    public b() {
        this.bgN = 0;
        int i = this.bgN;
        this.bgN = i + 1;
        this.mID = i;
    }

    @JavascriptInterface
    public int jsObjectID() {
        return this.mID;
    }

    public String toString() {
        return "FileSystemJsCallBack" + this.mID;
    }
}
