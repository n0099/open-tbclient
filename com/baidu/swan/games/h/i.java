package com.baidu.swan.games.h;

import android.webkit.JavascriptInterface;
import com.baidu.searchbox.v8engine.V8JavascriptField;
/* loaded from: classes11.dex */
public class i {
    private boolean cnU;
    private boolean cnV;
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
        return this.cnU;
    }

    @JavascriptInterface
    public boolean isFile() {
        return this.cnV;
    }

    public void eC(boolean z) {
        this.cnU = z;
    }

    public void eD(boolean z) {
        this.cnV = z;
    }
}
