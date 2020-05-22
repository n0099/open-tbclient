package com.baidu.swan.games.i.a;

import com.baidu.searchbox.v8engine.V8JavascriptField;
/* loaded from: classes11.dex */
public class c {
    private int cYi;
    private int cYj;
    @V8JavascriptField
    public String digest;
    @V8JavascriptField
    public String errMsg;
    @V8JavascriptField
    public int size;

    public c() {
        this.cYj = 0;
        int i = this.cYj;
        this.cYj = i + 1;
        this.cYi = i;
    }

    public String toString() {
        return "GetFileInfoCallBack" + this.cYi;
    }
}
