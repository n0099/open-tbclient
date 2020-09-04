package com.baidu.swan.games.i.a;

import com.baidu.searchbox.v8engine.V8JavascriptField;
/* loaded from: classes8.dex */
public class c {
    @V8JavascriptField
    public String digest;
    private int dsR;
    private int dsS;
    @V8JavascriptField
    public String errMsg;
    @V8JavascriptField
    public int size;

    public c() {
        this.dsS = 0;
        int i = this.dsS;
        this.dsS = i + 1;
        this.dsR = i;
    }

    public String toString() {
        return "GetFileInfoCallBack" + this.dsR;
    }
}
