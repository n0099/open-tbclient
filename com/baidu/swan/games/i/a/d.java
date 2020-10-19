package com.baidu.swan.games.i.a;

import com.baidu.searchbox.v8engine.V8JavascriptField;
/* loaded from: classes10.dex */
public class d {
    private int dGU;
    private int dGV;
    @V8JavascriptField
    public String errMsg;
    @V8JavascriptField
    public com.baidu.swan.games.i.d[] fileList;

    public d() {
        this.dGV = 0;
        int i = this.dGV;
        this.dGV = i + 1;
        this.dGU = i;
    }

    public String toString() {
        return "GetSavedFileListCallBack" + this.dGU;
    }
}
