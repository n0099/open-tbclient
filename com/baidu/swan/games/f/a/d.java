package com.baidu.swan.games.f.a;

import android.webkit.JavascriptInterface;
import com.baidu.searchbox.v8engine.V8JavascriptField;
/* loaded from: classes2.dex */
public class d {
    private int bzX;
    private int bzY;
    @V8JavascriptField
    public String[] files;

    public d() {
        this.bzY = 0;
        int i = this.bzY;
        this.bzY = i + 1;
        this.bzX = i;
    }

    @JavascriptInterface
    public int jsObjectID() {
        return this.bzX;
    }

    public String toString() {
        return "ReadDirCallBack" + this.bzX;
    }
}
