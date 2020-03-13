package com.baidu.swan.games.h.a;

import android.webkit.JavascriptInterface;
import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.swan.games.h.i;
/* loaded from: classes11.dex */
public class g {
    private int cod;
    private int mID;
    @V8JavascriptField
    public i stats;

    public g() {
        this.cod = 0;
        int i = this.cod;
        this.cod = i + 1;
        this.mID = i;
    }

    @JavascriptInterface
    public int jsObjectID() {
        return this.mID;
    }

    public String toString() {
        return "StatCallBack" + this.mID;
    }
}
