package com.baidu.swan.games.i.a;

import com.baidu.searchbox.v8engine.V8JavascriptField;
/* loaded from: classes11.dex */
public class g {
    private int cYi;
    private int cYj;
    @V8JavascriptField
    public String errMsg;
    @V8JavascriptField
    public String savedFilePath;

    public g() {
        this.cYj = 0;
        int i = this.cYj;
        this.cYj = i + 1;
        this.cYi = i;
    }

    public String toString() {
        return "SaveFileCallBack" + this.cYi;
    }
}
