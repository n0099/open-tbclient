package com.baidu.swan.games.i.a;

import com.baidu.searchbox.v8engine.V8JavascriptField;
/* loaded from: classes11.dex */
public class f {
    private int cYi;
    private int cYj;
    @V8JavascriptField
    public String data;
    @V8JavascriptField
    public String errMsg;

    public f() {
        this.cYj = 0;
        int i = this.cYj;
        this.cYj = i + 1;
        this.cYi = i;
    }

    public String toString() {
        return "ReadFileStringCallBack" + this.cYi;
    }
}
