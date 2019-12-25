package com.baidu.swan.games.h;

import android.webkit.JavascriptInterface;
import com.baidu.searchbox.v8engine.V8JavascriptField;
/* loaded from: classes9.dex */
public class i {
    private boolean cjB;
    private boolean cjC;
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
        return this.cjB;
    }

    @JavascriptInterface
    public boolean isFile() {
        return this.cjC;
    }

    public void eq(boolean z) {
        this.cjB = z;
    }

    public void er(boolean z) {
        this.cjC = z;
    }
}
