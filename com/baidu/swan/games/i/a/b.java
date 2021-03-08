package com.baidu.swan.games.i.a;

import com.baidu.searchbox.v8engine.V8JavascriptField;
/* loaded from: classes8.dex */
public class b {
    private int eir;
    private int eis;
    @V8JavascriptField
    public String errMsg;

    public b() {
        this.eir = 0;
        int i = this.eir;
        this.eir = i + 1;
        this.eis = i;
    }

    public String toString() {
        return "FileSystemJsCallBack" + this.eis;
    }
}
