package com.baidu.swan.games.i;

import android.webkit.JavascriptInterface;
import com.baidu.searchbox.v8engine.V8JavascriptField;
/* loaded from: classes8.dex */
public class j {
    private boolean dsH;
    private boolean dsI;
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
        return this.dsH;
    }

    @JavascriptInterface
    public boolean isFile() {
        return this.dsI;
    }

    public void gD(boolean z) {
        this.dsH = z;
    }

    public void gE(boolean z) {
        this.dsI = z;
    }
}
