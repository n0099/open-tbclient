package com.baidu.swan.games.f;

import android.webkit.JavascriptInterface;
import com.baidu.searchbox.v8engine.V8JavascriptField;
/* loaded from: classes2.dex */
public class f {
    private boolean bcA;
    private boolean bcB;
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
        return this.bcA;
    }

    @JavascriptInterface
    public boolean isFile() {
        return this.bcB;
    }

    public void cv(boolean z) {
        this.bcA = z;
    }

    public void cw(boolean z) {
        this.bcB = z;
    }
}
