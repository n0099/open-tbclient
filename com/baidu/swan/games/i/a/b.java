package com.baidu.swan.games.i.a;

import com.baidu.searchbox.v8engine.V8JavascriptField;
/* loaded from: classes8.dex */
public class b {
    private int dsQ;
    private int dsR;
    @V8JavascriptField
    public String errMsg;

    public b() {
        this.dsQ = 0;
        int i = this.dsQ;
        this.dsQ = i + 1;
        this.dsR = i;
    }

    public String toString() {
        return "FileSystemJsCallBack" + this.dsR;
    }
}
