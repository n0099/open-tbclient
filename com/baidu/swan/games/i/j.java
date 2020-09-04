package com.baidu.swan.games.i;

import android.webkit.JavascriptInterface;
import com.baidu.searchbox.v8engine.V8JavascriptField;
/* loaded from: classes8.dex */
public class j {
    private boolean dsL;
    private boolean dsM;
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
        return this.dsL;
    }

    @JavascriptInterface
    public boolean isFile() {
        return this.dsM;
    }

    public void gE(boolean z) {
        this.dsL = z;
    }

    public void gF(boolean z) {
        this.dsM = z;
    }
}
