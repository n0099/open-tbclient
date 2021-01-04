package com.baidu.swan.games.i.a;

import com.baidu.searchbox.v8engine.V8JavascriptField;
/* loaded from: classes9.dex */
public class g {
    private int ejw;
    private int ejx;
    @V8JavascriptField
    public String errMsg;
    @V8JavascriptField
    public String savedFilePath;

    public g() {
        this.ejx = 0;
        int i = this.ejx;
        this.ejx = i + 1;
        this.ejw = i;
    }

    public String toString() {
        return "SaveFileCallBack" + this.ejw;
    }
}
