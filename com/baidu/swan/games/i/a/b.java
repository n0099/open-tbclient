package com.baidu.swan.games.i.a;

import com.baidu.searchbox.v8engine.V8JavascriptField;
/* loaded from: classes10.dex */
public class b {
    private int dGT;
    private int dGU;
    @V8JavascriptField
    public String errMsg;

    public b() {
        this.dGT = 0;
        int i = this.dGT;
        this.dGT = i + 1;
        this.dGU = i;
    }

    public String toString() {
        return "FileSystemJsCallBack" + this.dGU;
    }
}
