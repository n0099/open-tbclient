package com.baidu.swan.games.i;

import android.webkit.JavascriptInterface;
import com.baidu.searchbox.v8engine.V8JavascriptField;
/* loaded from: classes3.dex */
public class j {
    private boolean duN;
    private boolean duO;
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
        return this.duN;
    }

    @JavascriptInterface
    public boolean isFile() {
        return this.duO;
    }

    public void gC(boolean z) {
        this.duN = z;
    }

    public void gD(boolean z) {
        this.duO = z;
    }
}
