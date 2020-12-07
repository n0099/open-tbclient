package com.baidu.swan.games.i.a;

import com.baidu.searchbox.v8engine.V8JavascriptField;
/* loaded from: classes25.dex */
public class c {
    @V8JavascriptField
    public String digest;
    private int eaA;
    private int eaz;
    @V8JavascriptField
    public String errMsg;
    @V8JavascriptField
    public int size;

    public c() {
        this.eaA = 0;
        int i = this.eaA;
        this.eaA = i + 1;
        this.eaz = i;
    }

    public String toString() {
        return "GetFileInfoCallBack" + this.eaz;
    }
}
