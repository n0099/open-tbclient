package com.baidu.swan.games.h;

import android.webkit.JavascriptInterface;
import com.baidu.searchbox.v8engine.V8JavascriptField;
/* loaded from: classes11.dex */
public class i {
    private boolean cNh;
    private boolean cNi;
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
        return this.cNh;
    }

    @JavascriptInterface
    public boolean isFile() {
        return this.cNi;
    }

    public void fA(boolean z) {
        this.cNh = z;
    }

    public void fB(boolean z) {
        this.cNi = z;
    }
}
