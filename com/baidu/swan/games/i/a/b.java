package com.baidu.swan.games.i.a;

import com.baidu.searchbox.v8engine.V8JavascriptField;
/* loaded from: classes10.dex */
public class b {
    private int dVi;
    private int dVj;
    @V8JavascriptField
    public String errMsg;

    public b() {
        this.dVi = 0;
        int i = this.dVi;
        this.dVi = i + 1;
        this.dVj = i;
    }

    public String toString() {
        return "FileSystemJsCallBack" + this.dVj;
    }
}
