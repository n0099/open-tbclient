package com.baidu.swan.games.h.a;

import android.webkit.JavascriptInterface;
import com.baidu.searchbox.v8engine.V8JavascriptField;
/* loaded from: classes10.dex */
public class d {
    private int cjX;
    @V8JavascriptField
    public String[] files;
    private int mID;

    public d() {
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
        return "ReadDirCallBack" + this.mID;
    }
}
