package com.baidu.swan.games.h;

import android.webkit.JavascriptInterface;
import com.baidu.searchbox.v8engine.V8JavascriptField;
/* loaded from: classes11.dex */
public class i {
    private boolean cnS;
    private boolean cnT;
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
        return this.cnS;
    }

    @JavascriptInterface
    public boolean isFile() {
        return this.cnT;
    }

    public void eC(boolean z) {
        this.cnS = z;
    }

    public void eD(boolean z) {
        this.cnT = z;
    }
}
