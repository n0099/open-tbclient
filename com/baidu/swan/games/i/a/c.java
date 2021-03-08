package com.baidu.swan.games.i.a;

import com.baidu.searchbox.v8engine.V8JavascriptField;
/* loaded from: classes8.dex */
public class c {
    @V8JavascriptField
    public String digest;
    private int eis;
    private int eit;
    @V8JavascriptField
    public String errMsg;
    @V8JavascriptField
    public int size;

    public c() {
        this.eit = 0;
        int i = this.eit;
        this.eit = i + 1;
        this.eis = i;
    }

    public String toString() {
        return "GetFileInfoCallBack" + this.eis;
    }
}
