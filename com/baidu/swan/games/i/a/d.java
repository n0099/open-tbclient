package com.baidu.swan.games.i.a;

import com.baidu.searchbox.v8engine.V8JavascriptField;
/* loaded from: classes25.dex */
public class d {
    private int eaA;
    private int eaz;
    @V8JavascriptField
    public String errMsg;
    @V8JavascriptField
    public com.baidu.swan.games.i.d[] fileList;

    public d() {
        this.eaA = 0;
        int i = this.eaA;
        this.eaA = i + 1;
        this.eaz = i;
    }

    public String toString() {
        return "GetSavedFileListCallBack" + this.eaz;
    }
}
