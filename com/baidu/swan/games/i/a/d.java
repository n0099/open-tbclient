package com.baidu.swan.games.i.a;

import com.baidu.searchbox.v8engine.V8JavascriptField;
/* loaded from: classes10.dex */
public class d {
    private int dPr;
    private int dPs;
    @V8JavascriptField
    public String errMsg;
    @V8JavascriptField
    public com.baidu.swan.games.i.d[] fileList;

    public d() {
        this.dPs = 0;
        int i = this.dPs;
        this.dPs = i + 1;
        this.dPr = i;
    }

    public String toString() {
        return "GetSavedFileListCallBack" + this.dPr;
    }
}
