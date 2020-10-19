package com.baidu.swan.games.i;

import android.webkit.JavascriptInterface;
import com.baidu.searchbox.v8engine.V8JavascriptField;
/* loaded from: classes10.dex */
public class j {
    private boolean dGO;
    private boolean dGP;
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
        return this.dGO;
    }

    @JavascriptInterface
    public boolean isFile() {
        return this.dGP;
    }

    public void gY(boolean z) {
        this.dGO = z;
    }

    public void gZ(boolean z) {
        this.dGP = z;
    }
}
