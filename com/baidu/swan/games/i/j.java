package com.baidu.swan.games.i;

import android.webkit.JavascriptInterface;
import com.baidu.searchbox.v8engine.V8JavascriptField;
/* loaded from: classes9.dex */
public class j {
    private boolean ejq;
    private boolean ejr;
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
        return this.ejq;
    }

    @JavascriptInterface
    public boolean isFile() {
        return this.ejr;
    }

    public void ie(boolean z) {
        this.ejq = z;
    }

    /* renamed from: if  reason: not valid java name */
    public void m33if(boolean z) {
        this.ejr = z;
    }
}
