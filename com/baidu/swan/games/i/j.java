package com.baidu.swan.games.i;

import android.webkit.JavascriptInterface;
import com.baidu.searchbox.v8engine.V8JavascriptField;
/* loaded from: classes10.dex */
public class j {
    private boolean dPl;
    private boolean dPm;
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
        return this.dPl;
    }

    @JavascriptInterface
    public boolean isFile() {
        return this.dPm;
    }

    public void hl(boolean z) {
        this.dPl = z;
    }

    public void hm(boolean z) {
        this.dPm = z;
    }
}
