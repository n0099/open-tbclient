package com.baidu.swan.games.f;

import android.webkit.JavascriptInterface;
import com.baidu.searchbox.v8engine.V8JavascriptField;
/* loaded from: classes2.dex */
public class f {
    private boolean bht;
    private boolean bhu;
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
        return this.bht;
    }

    @JavascriptInterface
    public boolean isFile() {
        return this.bhu;
    }

    public void cP(boolean z) {
        this.bht = z;
    }

    public void cQ(boolean z) {
        this.bhu = z;
    }
}
