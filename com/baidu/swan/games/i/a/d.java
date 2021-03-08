package com.baidu.swan.games.i.a;

import com.baidu.searchbox.v8engine.V8JavascriptField;
/* loaded from: classes8.dex */
public class d {
    private int eis;
    private int eit;
    @V8JavascriptField
    public String errMsg;
    @V8JavascriptField
    public com.baidu.swan.games.i.d[] fileList;

    public d() {
        this.eit = 0;
        int i = this.eit;
        this.eit = i + 1;
        this.eis = i;
    }

    public String toString() {
        return "GetSavedFileListCallBack" + this.eis;
    }
}
