package com.baidu.swan.games.i.a;

import com.baidu.searchbox.v8engine.V8JavascriptField;
/* loaded from: classes10.dex */
public class e {
    private int dVj;
    private int dVk;
    @V8JavascriptField
    public String errMsg;
    @V8JavascriptField
    public String[] files;

    public e() {
        this.dVk = 0;
        int i = this.dVk;
        this.dVk = i + 1;
        this.dVj = i;
    }

    public String toString() {
        return "ReadDirCallBack" + this.dVj;
    }
}
