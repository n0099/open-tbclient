package com.baidu.swan.games.i.a;

import com.baidu.searchbox.v8engine.V8JavascriptField;
/* loaded from: classes8.dex */
public class c {
    @V8JavascriptField
    public String digest;
    private int eeJ;
    private int eeK;
    @V8JavascriptField
    public String errMsg;
    @V8JavascriptField
    public int size;

    public c() {
        this.eeK = 0;
        int i = this.eeK;
        this.eeK = i + 1;
        this.eeJ = i;
    }

    public String toString() {
        return "GetFileInfoCallBack" + this.eeJ;
    }
}
