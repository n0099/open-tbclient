package com.baidu.swan.games.i.a;

import com.baidu.searchbox.v8engine.V8JavascriptField;
/* loaded from: classes9.dex */
public class c {
    @V8JavascriptField
    public String digest;
    private int ejw;
    private int ejx;
    @V8JavascriptField
    public String errMsg;
    @V8JavascriptField
    public int size;

    public c() {
        this.ejx = 0;
        int i = this.ejx;
        this.ejx = i + 1;
        this.ejw = i;
    }

    public String toString() {
        return "GetFileInfoCallBack" + this.ejw;
    }
}
