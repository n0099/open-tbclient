package com.baidu.swan.games.h.a;

import android.webkit.JavascriptInterface;
import com.baidu.searchbox.v8engine.V8JavascriptField;
/* loaded from: classes11.dex */
public class f {
    private int coc;
    private int mID;
    @V8JavascriptField
    public String savedFilePath;

    public f() {
        this.coc = 0;
        int i = this.coc;
        this.coc = i + 1;
        this.mID = i;
    }

    @JavascriptInterface
    public int jsObjectID() {
        return this.mID;
    }

    public String toString() {
        return "SaveFileCallBack" + this.mID;
    }
}
