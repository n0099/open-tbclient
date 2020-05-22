package com.baidu.swan.games.i;

import android.webkit.JavascriptInterface;
import com.baidu.searchbox.v8engine.V8JavascriptField;
/* loaded from: classes11.dex */
public class j {
    private boolean cYb;
    private boolean cYc;
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
        return this.cYb;
    }

    @JavascriptInterface
    public boolean isFile() {
        return this.cYc;
    }

    public void fL(boolean z) {
        this.cYb = z;
    }

    public void fM(boolean z) {
        this.cYc = z;
    }
}
