package com.baidu.swan.games.h.a;

import android.webkit.JavascriptInterface;
import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.swan.games.h.i;
/* loaded from: classes11.dex */
public class g {
    private int cNq;
    private int cNr;
    @V8JavascriptField
    public i stats;

    public g() {
        this.cNr = 0;
        int i = this.cNr;
        this.cNr = i + 1;
        this.cNq = i;
    }

    @JavascriptInterface
    public int jsObjectID() {
        return this.cNq;
    }

    public String toString() {
        return "StatCallBack" + this.cNq;
    }
}
