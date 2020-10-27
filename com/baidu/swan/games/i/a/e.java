package com.baidu.swan.games.i.a;

import com.baidu.searchbox.v8engine.V8JavascriptField;
/* loaded from: classes10.dex */
public class e {
    private int dPr;
    private int dPs;
    @V8JavascriptField
    public String errMsg;
    @V8JavascriptField
    public String[] files;

    public e() {
        this.dPs = 0;
        int i = this.dPs;
        this.dPs = i + 1;
        this.dPr = i;
    }

    public String toString() {
        return "ReadDirCallBack" + this.dPr;
    }
}
