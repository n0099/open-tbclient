package com.baidu.swan.games.i;

import android.webkit.JavascriptInterface;
import com.baidu.searchbox.v8engine.V8JavascriptField;
/* loaded from: classes9.dex */
public class j {
    private boolean egL;
    private boolean egM;
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
        return this.egL;
    }

    @JavascriptInterface
    public boolean isFile() {
        return this.egM;
    }

    public void ic(boolean z) {
        this.egL = z;
    }

    public void id(boolean z) {
        this.egM = z;
    }
}
