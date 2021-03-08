package com.baidu.swan.games.i;

import android.webkit.JavascriptInterface;
import com.baidu.searchbox.v8engine.V8JavascriptField;
/* loaded from: classes8.dex */
public class j {
    private boolean eim;
    private boolean ein;
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
        return this.eim;
    }

    @JavascriptInterface
    public boolean isFile() {
        return this.ein;
    }

    public void ic(boolean z) {
        this.eim = z;
    }

    public void id(boolean z) {
        this.ein = z;
    }
}
