package com.baidu.swan.games.i;

import android.webkit.JavascriptInterface;
import com.baidu.searchbox.v8engine.V8JavascriptField;
/* loaded from: classes11.dex */
public class j {
    private boolean dcO;
    private boolean dcP;
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
        return this.dcO;
    }

    @JavascriptInterface
    public boolean isFile() {
        return this.dcP;
    }

    public void fQ(boolean z) {
        this.dcO = z;
    }

    public void fR(boolean z) {
        this.dcP = z;
    }
}
