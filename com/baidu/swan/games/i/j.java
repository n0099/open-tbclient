package com.baidu.swan.games.i;

import android.webkit.JavascriptInterface;
import com.baidu.searchbox.v8engine.V8JavascriptField;
/* loaded from: classes10.dex */
public class j {
    private boolean dVd;
    private boolean dVe;
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
        return this.dVd;
    }

    @JavascriptInterface
    public boolean isFile() {
        return this.dVe;
    }

    public void hu(boolean z) {
        this.dVd = z;
    }

    public void hv(boolean z) {
        this.dVe = z;
    }
}
