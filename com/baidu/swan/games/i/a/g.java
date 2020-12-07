package com.baidu.swan.games.i.a;

import com.baidu.searchbox.v8engine.V8JavascriptField;
/* loaded from: classes25.dex */
public class g {
    private int eaA;
    private int eaz;
    @V8JavascriptField
    public String errMsg;
    @V8JavascriptField
    public String savedFilePath;

    public g() {
        this.eaA = 0;
        int i = this.eaA;
        this.eaA = i + 1;
        this.eaz = i;
    }

    public String toString() {
        return "SaveFileCallBack" + this.eaz;
    }
}
