package com.baidu.swan.games.h.a;

import android.webkit.JavascriptInterface;
import com.baidu.searchbox.v8engine.V8JavascriptField;
/* loaded from: classes11.dex */
public class b {
    private int coa;
    @V8JavascriptField
    public String errMsg;
    private int mID;

    public b() {
        this.coa = 0;
        int i = this.coa;
        this.coa = i + 1;
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
