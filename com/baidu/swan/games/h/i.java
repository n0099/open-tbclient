package com.baidu.swan.games.h;

import android.webkit.JavascriptInterface;
import com.baidu.searchbox.v8engine.V8JavascriptField;
/* loaded from: classes11.dex */
public class i {
    private boolean cof;
    private boolean cog;
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
        return this.cof;
    }

    @JavascriptInterface
    public boolean isFile() {
        return this.cog;
    }

    public void eD(boolean z) {
        this.cof = z;
    }

    public void eE(boolean z) {
        this.cog = z;
    }
}
