package com.baidu.swan.games.i.a;

import com.baidu.searchbox.v8engine.V8JavascriptField;
/* loaded from: classes9.dex */
public class d {
    private int ejw;
    private int ejx;
    @V8JavascriptField
    public String errMsg;
    @V8JavascriptField
    public com.baidu.swan.games.i.d[] fileList;

    public d() {
        this.ejx = 0;
        int i = this.ejx;
        this.ejx = i + 1;
        this.ejw = i;
    }

    public String toString() {
        return "GetSavedFileListCallBack" + this.ejw;
    }
}
