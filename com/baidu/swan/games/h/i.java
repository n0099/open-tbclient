package com.baidu.swan.games.h;

import android.webkit.JavascriptInterface;
import com.baidu.searchbox.v8engine.V8JavascriptField;
/* loaded from: classes11.dex */
public class i {
    private boolean cNb;
    private boolean cNc;
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
        return this.cNb;
    }

    @JavascriptInterface
    public boolean isFile() {
        return this.cNc;
    }

    public void fA(boolean z) {
        this.cNb = z;
    }

    public void fB(boolean z) {
        this.cNc = z;
    }
}
