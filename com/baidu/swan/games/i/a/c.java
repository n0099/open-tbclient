package com.baidu.swan.games.i.a;

import com.baidu.searchbox.v8engine.V8JavascriptField;
/* loaded from: classes3.dex */
public class c {
    @V8JavascriptField
    public String digest;
    private int duT;
    private int duU;
    @V8JavascriptField
    public String errMsg;
    @V8JavascriptField
    public int size;

    public c() {
        this.duU = 0;
        int i = this.duU;
        this.duU = i + 1;
        this.duT = i;
    }

    public String toString() {
        return "GetFileInfoCallBack" + this.duT;
    }
}
