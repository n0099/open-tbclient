package com.baidu.swan.games.f;

import android.webkit.JavascriptInterface;
import com.baidu.searchbox.v8engine.V8JavascriptField;
/* loaded from: classes2.dex */
public class f {
    private boolean bhR;
    private boolean bhS;
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
        return this.bhR;
    }

    @JavascriptInterface
    public boolean isFile() {
        return this.bhS;
    }

    public void cP(boolean z) {
        this.bhR = z;
    }

    public void cQ(boolean z) {
        this.bhS = z;
    }
}
