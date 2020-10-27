package com.baidu.swan.games.i.a;

import com.baidu.searchbox.v8engine.V8JavascriptField;
/* loaded from: classes10.dex */
public class c {
    private int dPr;
    private int dPs;
    @V8JavascriptField
    public String digest;
    @V8JavascriptField
    public String errMsg;
    @V8JavascriptField
    public int size;

    public c() {
        this.dPs = 0;
        int i = this.dPs;
        this.dPs = i + 1;
        this.dPr = i;
    }

    public String toString() {
        return "GetFileInfoCallBack" + this.dPr;
    }
}
