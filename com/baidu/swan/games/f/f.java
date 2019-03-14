package com.baidu.swan.games.f;

import android.webkit.JavascriptInterface;
import com.baidu.searchbox.v8engine.V8JavascriptField;
/* loaded from: classes2.dex */
public class f {
    private boolean bcB;
    private boolean bcC;
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
        return this.bcB;
    }

    @JavascriptInterface
    public boolean isFile() {
        return this.bcC;
    }

    public void cv(boolean z) {
        this.bcB = z;
    }

    public void cw(boolean z) {
        this.bcC = z;
    }
}
