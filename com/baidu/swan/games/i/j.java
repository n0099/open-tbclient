package com.baidu.swan.games.i;

import android.webkit.JavascriptInterface;
import com.baidu.searchbox.v8engine.V8JavascriptField;
/* loaded from: classes8.dex */
public class j {
    private boolean eeD;
    private boolean eeE;
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
        return this.eeD;
    }

    @JavascriptInterface
    public boolean isFile() {
        return this.eeE;
    }

    public void ia(boolean z) {
        this.eeD = z;
    }

    public void ib(boolean z) {
        this.eeE = z;
    }
}
