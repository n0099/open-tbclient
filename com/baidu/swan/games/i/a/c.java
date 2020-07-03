package com.baidu.swan.games.i.a;

import com.baidu.searchbox.v8engine.V8JavascriptField;
/* loaded from: classes11.dex */
public class c {
    private int dcV;
    private int dcW;
    @V8JavascriptField
    public String digest;
    @V8JavascriptField
    public String errMsg;
    @V8JavascriptField
    public int size;

    public c() {
        this.dcW = 0;
        int i = this.dcW;
        this.dcW = i + 1;
        this.dcV = i;
    }

    public String toString() {
        return "GetFileInfoCallBack" + this.dcV;
    }
}
