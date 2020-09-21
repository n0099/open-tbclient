package com.baidu.swan.games.i.a;

import com.baidu.searchbox.v8engine.V8JavascriptField;
/* loaded from: classes3.dex */
public class b {
    private int duS;
    private int duT;
    @V8JavascriptField
    public String errMsg;

    public b() {
        this.duS = 0;
        int i = this.duS;
        this.duS = i + 1;
        this.duT = i;
    }

    public String toString() {
        return "FileSystemJsCallBack" + this.duT;
    }
}
