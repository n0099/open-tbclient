package com.baidu.swan.games.i;

import android.webkit.JavascriptInterface;
import com.baidu.searchbox.v8engine.V8JavascriptField;
/* loaded from: classes25.dex */
public class j {
    private boolean eat;
    private boolean eau;
    @V8JavascriptField
    public long lastAccessedTime;
    @V8JavascriptField
    public long lastModifiedTime;
    @V8JavascriptField
    public long mode;
    @V8JavascriptField
    public long size;

    @JavascriptInterface
    public boolean isDirectory() {
        return this.eat;
    }

    @JavascriptInterface
    public boolean isFile() {
        return this.eau;
    }

    public void hM(boolean z) {
        this.eat = z;
    }

    public void hN(boolean z) {
        this.eau = z;
    }
}
