package com.baidu.swan.games.f;

import android.webkit.JavascriptInterface;
import com.baidu.searchbox.v8engine.V8JavascriptField;
/* loaded from: classes2.dex */
public class f {
    private boolean bzQ;
    private boolean bzR;
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
        return this.bzQ;
    }

    @JavascriptInterface
    public boolean isFile() {
        return this.bzR;
    }

    public void dg(boolean z) {
        this.bzQ = z;
    }

    public void dh(boolean z) {
        this.bzR = z;
    }
}
