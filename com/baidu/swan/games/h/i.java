package com.baidu.swan.games.h;

import android.webkit.JavascriptInterface;
import com.baidu.searchbox.v8engine.V8JavascriptField;
/* loaded from: classes11.dex */
public class i {
    private boolean cnT;
    private boolean cnU;
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
        return this.cnT;
    }

    @JavascriptInterface
    public boolean isFile() {
        return this.cnU;
    }

    public void eC(boolean z) {
        this.cnT = z;
    }

    public void eD(boolean z) {
        this.cnU = z;
    }
}
