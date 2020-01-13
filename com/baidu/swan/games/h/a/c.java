package com.baidu.swan.games.h.a;

import android.webkit.JavascriptInterface;
import com.baidu.searchbox.v8engine.V8JavascriptField;
/* loaded from: classes10.dex */
public class c {
    private int cjX;
    @V8JavascriptField
    public String digest;
    @V8JavascriptField
    public String errMsg;
    private int mID;
    @V8JavascriptField
    public int size;

    public c() {
        this.cjX = 0;
        int i = this.cjX;
        this.cjX = i + 1;
        this.mID = i;
    }

    @JavascriptInterface
    public int jsObjectID() {
        return this.mID;
    }

    public String toString() {
        return "GetFileInfoCallBack" + this.mID;
    }
}
