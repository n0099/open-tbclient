package com.baidu.swan.games.i;

import android.webkit.JavascriptInterface;
import com.baidu.searchbox.v8engine.V8JavascriptField;
/* loaded from: classes7.dex */
public class j {
    private boolean diA;
    private boolean diz;
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
        return this.diz;
    }

    @JavascriptInterface
    public boolean isFile() {
        return this.diA;
    }

    public void gh(boolean z) {
        this.diz = z;
    }

    public void gi(boolean z) {
        this.diA = z;
    }
}
