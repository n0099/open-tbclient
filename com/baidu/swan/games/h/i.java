package com.baidu.swan.games.h;

import android.webkit.JavascriptInterface;
import com.baidu.searchbox.v8engine.V8JavascriptField;
/* loaded from: classes10.dex */
public class i {
    private boolean cjO;
    private boolean cjP;
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
        return this.cjO;
    }

    @JavascriptInterface
    public boolean isFile() {
        return this.cjP;
    }

    public void ev(boolean z) {
        this.cjO = z;
    }

    public void ew(boolean z) {
        this.cjP = z;
    }
}
