package com.baidu.swan.games.i.a;

import com.baidu.searchbox.v8engine.V8JavascriptField;
/* loaded from: classes8.dex */
public class e {
    private int eeJ;
    private int eeK;
    @V8JavascriptField
    public String errMsg;
    @V8JavascriptField
    public String[] files;

    public e() {
        this.eeK = 0;
        int i = this.eeK;
        this.eeK = i + 1;
        this.eeJ = i;
    }

    public String toString() {
        return "ReadDirCallBack" + this.eeJ;
    }
}
