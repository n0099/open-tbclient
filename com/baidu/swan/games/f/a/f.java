package com.baidu.swan.games.f.a;

import android.webkit.JavascriptInterface;
import com.baidu.searchbox.v8engine.V8JavascriptField;
/* loaded from: classes2.dex */
public class f {
    private int bhY;
    private int bhZ;
    @V8JavascriptField
    public String savedFilePath;

    public f() {
        this.bhZ = 0;
        int i = this.bhZ;
        this.bhZ = i + 1;
        this.bhY = i;
    }

    @JavascriptInterface
    public int jsObjectID() {
        return this.bhY;
    }

    public String toString() {
        return "SaveFileCallBack" + this.bhY;
    }
}
