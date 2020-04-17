package com.baidu.swan.games.h.a;

import android.webkit.JavascriptInterface;
import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.swan.games.h.i;
/* loaded from: classes11.dex */
public class g {
    private int cNk;
    private int cNl;
    @V8JavascriptField
    public i stats;

    public g() {
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
        return "StatCallBack" + this.cNk;
    }
}
