package com.baidu.swan.games.i.a;

import com.baidu.searchbox.v8engine.V8JavascriptField;
/* loaded from: classes3.dex */
public class g {
    private int duT;
    private int duU;
    @V8JavascriptField
    public String errMsg;
    @V8JavascriptField
    public String savedFilePath;

    public g() {
        this.duU = 0;
        int i = this.duU;
        this.duU = i + 1;
        this.duT = i;
    }

    public String toString() {
        return "SaveFileCallBack" + this.duT;
    }
}
