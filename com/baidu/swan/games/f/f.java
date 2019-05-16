package com.baidu.swan.games.f;

import android.webkit.JavascriptInterface;
import com.baidu.searchbox.v8engine.V8JavascriptField;
/* loaded from: classes2.dex */
public class f {
    private boolean bgH;
    private boolean bgI;
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
        return this.bgH;
    }

    @JavascriptInterface
    public boolean isFile() {
        return this.bgI;
    }

    public void cM(boolean z) {
        this.bgH = z;
    }

    public void cN(boolean z) {
        this.bgI = z;
    }
}
