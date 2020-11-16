package com.baidu.swan.games.i;

import android.webkit.JavascriptInterface;
import com.baidu.searchbox.v8engine.V8JavascriptField;
/* loaded from: classes7.dex */
public class j {
    private boolean dTv;
    private boolean dTw;
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
        return this.dTv;
    }

    @JavascriptInterface
    public boolean isFile() {
        return this.dTw;
    }

    public void hx(boolean z) {
        this.dTv = z;
    }

    public void hy(boolean z) {
        this.dTw = z;
    }
}
