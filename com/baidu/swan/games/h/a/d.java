package com.baidu.swan.games.h.a;

import android.webkit.JavascriptInterface;
import com.baidu.searchbox.v8engine.V8JavascriptField;
/* loaded from: classes11.dex */
public class d {
    private int cNk;
    private int cNl;
    @V8JavascriptField
    public String[] files;

    public d() {
        this.cNl = 0;
        int i = this.cNl;
        this.cNl = i + 1;
        this.cNk = i;
    }

    @JavascriptInterface
    public int jsObjectID() {
        return this.cNk;
    }

    public String toString() {
        return "ReadDirCallBack" + this.cNk;
    }
}
