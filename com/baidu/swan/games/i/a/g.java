package com.baidu.swan.games.i.a;

import com.baidu.searchbox.v8engine.V8JavascriptField;
/* loaded from: classes7.dex */
public class g {
    private int diG;
    private int diH;
    @V8JavascriptField
    public String errMsg;
    @V8JavascriptField
    public String savedFilePath;

    public g() {
        this.diH = 0;
        int i = this.diH;
        this.diH = i + 1;
        this.diG = i;
    }

    public String toString() {
        return "SaveFileCallBack" + this.diG;
    }
}
