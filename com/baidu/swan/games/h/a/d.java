package com.baidu.swan.games.h.a;

import android.webkit.JavascriptInterface;
import com.baidu.searchbox.v8engine.V8JavascriptField;
/* loaded from: classes11.dex */
public class d {
    private int coo;
    @V8JavascriptField
    public String[] files;
    private int mID;

    public d() {
        this.coo = 0;
        int i = this.coo;
        this.coo = i + 1;
        this.mID = i;
    }

    @JavascriptInterface
    public int jsObjectID() {
        return this.mID;
    }

    public String toString() {
        return "ReadDirCallBack" + this.mID;
    }
}
