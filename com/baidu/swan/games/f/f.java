package com.baidu.swan.games.f;

import android.webkit.JavascriptInterface;
import com.baidu.searchbox.v8engine.V8JavascriptField;
/* loaded from: classes2.dex */
public class f {
    private boolean bAH;
    private boolean bAI;
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
        return this.bAH;
    }

    @JavascriptInterface
    public boolean isFile() {
        return this.bAI;
    }

    public void dg(boolean z) {
        this.bAH = z;
    }

    public void dh(boolean z) {
        this.bAI = z;
    }
}
