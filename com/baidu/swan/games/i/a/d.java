package com.baidu.swan.games.i.a;

import com.baidu.searchbox.v8engine.V8JavascriptField;
/* loaded from: classes10.dex */
public class d {
    private int dVj;
    private int dVk;
    @V8JavascriptField
    public String errMsg;
    @V8JavascriptField
    public com.baidu.swan.games.i.d[] fileList;

    public d() {
        this.dVk = 0;
        int i = this.dVk;
        this.dVk = i + 1;
        this.dVj = i;
    }

    public String toString() {
        return "GetSavedFileListCallBack" + this.dVj;
    }
}
